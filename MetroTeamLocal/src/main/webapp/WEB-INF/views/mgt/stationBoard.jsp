<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Stations</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
			<button id="ajax_test" type="button" class="btn btn-sm btn-outline-secondary">Test</button>
			<button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
		</div>
		<button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
			<span data-feather="calendar"></span> This week
		</button>
	</div>
</div>

<div class="table-responsive border-bottom">
	<table class="table table-dark table-hover table-striped table-sm">
		<thead>
			<tr>
				<th colspan='5'>
					<div class="input-group mb-3">
						<div class="input-group-prepend" id="line-list">
							<div class="btn-group" role="group">
								<button class="btn btn-outline-secondary dropdown-toggle"
									type="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Line 1~9</button>
								<div class="dropdown-menu bg-dark">
									<a class="dropdown-item text-light" href="#">01호선</a>
									<a class="dropdown-item text-light" href="#">02호선</a>
									<a class="dropdown-item text-light" href="#">03호선</a>
									<a class="dropdown-item text-light" href="#">04호선</a>
									<div role="separator" class="dropdown-divider"></div>
									<a class="dropdown-item text-light" href="#">05호선</a>
									<a class="dropdown-item text-light" href="#">06호선</a>
									<a class="dropdown-item text-light" href="#">07호선</a>
									<a class="dropdown-item text-light" href="#">08호선</a>
									<div role="separator" class="dropdown-divider"></div>
									<a class="dropdown-item text-light" href="#">09호선</a>								
								</div>
							</div>
							<div class="btn-group" role="group">
								<button class="btn btn-outline-secondary dropdown-toggle"
									type="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Others</button>
								<div class="dropdown-menu bg-dark">
									<a class="dropdown-item text-light" href="#">경강선</a>
									<a class="dropdown-item text-light" href="#">경의선</a>
									<a class="dropdown-item text-light" href="#">경춘선</a>
									<div role="separator" class="dropdown-divider"></div>
									<a class="dropdown-item text-light" href="#">공항철도</a>
									<a class="dropdown-item text-light" href="#">분당선</a>
									<a class="dropdown-item text-light" href="#">서해선</a>
									<a class="dropdown-item text-light" href="#">수인선</a>
									<a class="dropdown-item text-light" href="#">신분당선</a>
									<div role="separator" class="dropdown-divider"></div>
									<a class="dropdown-item text-light" href="#">용인경전철</a>
									<a class="dropdown-item text-light" href="#">우이신설경전철</a>
									<a class="dropdown-item text-light" href="#">의정부경전철</a>
									<div role="separator" class="dropdown-divider"></div>
									<a class="dropdown-item text-light" href="#">인천2호선</a>
									<a class="dropdown-item text-light" href="#">인천선</a>									
								</div>
							</div>
						</div>
						<input type="text" id="search-station"
							class="form-control form-control-dark"
							placeholder="station code or name"
							aria-label="station code or name"
							aria-describedby="search-button">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="button"
								id="search-button">Search</button>
						</div>
					</div>
				</th>
			</tr>
			<tr>
				<th scope="col">역 코드</th>
				<th scope="col">역 이름</th>
				<th scope="col">영문명</th>
				<th scope="col">노선</th>
				<th scope="col">외부코드</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var='m' items="${list}">
				<tr>
					<th scope="row">
						<button type="button" class="station-map btn btn-sm btn-block btn-secondary">${m.stationCode}</button>
					</th>
					<td>${m.stationName}</td>
					<td>${m.stationNameEng}</td>
					<td>${m.lineNumber}</td>
					<td>${m.fCode}</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item">
				<a class="page-link" id="previous-page" href="#" aria-label="Previous"> 
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" id="this-page"	href="#">${page}</a>
			</li>
			<li class="page-item">
				<a class="page-link" id="next-page" href="#" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
		</ul>
	</nav>
</div>

<h2>Exits</h2>

<div class='card-columns card-columns-exits border-bottom'>
	
	<div class="card bg-primary text-white text-center p-3">
		<blockquote class="blockquote mb-0">
			<p>출구정보가 존재하지 않습니다.</p>
			<footer class="blockquote-footer text-white">
				<small> 00 <cite title="Source Title">번 출구</cite>
				</small>
			</footer>
		</blockquote>
	</div>
	
</div>
<h2>Map</h2>
<div id="map" class="container border-bottom" style="width:100%;height:500px"></div>
<h2>Section title</h2>
<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>
<script type="text/javascript" src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=500615dfd78ac5a177e2c8c513d542b6"></script>
<script type="text/javascript" src="/resources/js/station.js"></script>
<script>
	$(function(){
		stationMap("0331");
		exitInfo("0331");		
		
		$('#previous-page').click(function(){
			var pageNum = $('#this-page').text() - 1;
			if(pageNum == 0) pageNum = 1;
			
			listByPage(pageNum);
		});
		
		$('#next-page').click(function(){
			var pageNum = $('#this-page').text() - (-1);
			
			listByPage(pageNum);
		});		
	});
</script>