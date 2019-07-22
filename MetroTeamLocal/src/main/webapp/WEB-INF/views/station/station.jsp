<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>역 정보</title>
<link href="/resources/css/bootstrap.css" rel="stylesheet">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<style>
.table td {
	 vertical-align:middle;
}
</style>
<link href="/resources/css/dashboard.css" rel="stylesheet">

<script src="/resources/js/jquery-3.4.1.js"></script>

<script src="/resources/js/bootstrap.bundle.js"></script>
</head>
<body>
	<h1 class="display-1">STATION</h1>
	<input type="hidden" id="station-code" value="${result.stationCode}"/>
	<div class='row'>
		<div class='container col-md-6'>
			<table class='table table-borderless'>
				<tbody>
					<tr> 
						<td><i class="fas fa-minus"></i></td>
						<td>
							<button class="btn btn-outline-primary btn-lg btn-block"><i class="fas fa-subway"></i></button>
						</td>
						<td><i class="fas fa-minus"></i></td>
					</tr>
					
				</tbody>
			</table>
		</div>
		<div class='container col-md-6'>
			<div class="card border-primary" style="width: 30rem;">
				<div id='map' style="width: 100%; height: 300px;"></div>
				<div class="card-header bg-transparent">
						<ul class="nav nav-pills card-header-pills nav-fill">
							<li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-angle-left"></i></a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
								role="button" aria-haspopup="true" aria-expanded="false">1번 출구</a>
								<div class="dropdown-menu" id="exit-list">
									<a class="dropdown-item" href="#">Action</a>
								</div>
							</li>
							<li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-angle-right"></i></a></li>
						</ul>
					</div>
				<div class="card-body bg-primary text-white" id='exit-info'>					
						<h5 class='card-title'>출구 정보</h5>
						<p class="card-text lead">${result.ure}</p>					
				</div>
			</div>
		</div>
	</div>
	
	<div class='container'>
		<div class='row'>
			<div class='col-sm'>
				<div class="card" style="width: 30rem;">
					<div id='map' style="width:100%; height:300px;"></div>
					<div class="card-body">
						<h5 class="card-title">${result.stationName}</h5>
						<p class="card-text lead">${result.ure}</p>
						<a href="#" class="btn btn-primary">Go somewhere</a>
					</div>
				</div>
			</div>
			<div class='col-sm'>
				<div class="card" style="width: 30rem;">
					<img src="http://www.seoulmetro.co.kr/web_upload/cyberstation/in/station_${result.stationCode}.jpg" class="card-img-top" alt="Station">
					<div class="card-body">
						<h5 class="card-title">${result.stationName}</h5>
						
						<p class="card-text">${result.useful}</p>
						<a href="#" class="btn btn-primary">Go somewhere</a>
					</div>
				</div>
			</div>
		</div>
		<div class='row'>
			<figure class="figure col-sm-6">
  				<img src="http://www.seoulmetro.co.kr/web_upload/cyberstation/in/station_${result.stationCode}.jpg" 
  				class="figure-img img-fluid rounded" alt="No Image">
  				<figcaption class="figure-caption">A caption for the above image.</figcaption>
			</figure>
			<figure class="figure col-sm-6">
  				<img src="http://www.seoulmetro.co.kr/web_upload/cyberstation/in/station_${result.stationCode}.jpg" 
  				class="figure-img img-fluid rounded" alt="No Image">
  				<figcaption class="figure-caption">A caption for the above image.</figcaption>
			</figure>
		</div>
	</div>
<script
		src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
	<script src="/resources/js/dashboard.js"></script>
<script type="text/javascript" src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=500615dfd78ac5a177e2c8c513d542b6"></script>
<script type="text/javascript" src='/resources/js/station.js'></script>

<script>
	$(function(){
		var code = $('#station-code').val();
		stationMap(code);
		exitInfo(code, stnExitInfo);
	});
</script>
</body>
</html>