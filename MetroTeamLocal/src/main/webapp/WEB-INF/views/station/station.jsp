<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>역 정보</title>
<link href="/resources/css/bootstrap.css" rel="stylesheet">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<link href="/resources/css/dashboard.css" rel="stylesheet">
<link href="/resources/css/station.css" rel="stylesheet">
</head>
<body>
	<h1 class="display-1">STATION</h1>
	<input type="hidden" id="station-code" value="${result.stationCode}"/>
	<input type="hidden" id="line-name" value="${result.line}"/>
	<c:forEach var="m" items="${codes}">
		<input type="hidden" class="station-codes" id="${m.line}" value="${m.stationCode }"/>
	</c:forEach>
	<div class='container-fluid'>
	<div class="alert alert-info alert-dismissible" role="alert" style="display:none">
  <strong>Holy guacamole!</strong> <span>You should check in on some of those fields below.</span>
  <a href="#" class="alert-link">즐겨찾기 목록</a>
  <button type="button" class="close" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
		<div class='row'>
		
			<div class='col-lg'>
				
				<ul class="nav nav-tabs ml-1 mr-1">
					<c:forEach var='m' items="${lines}">
					<li class="nav-item">
						<a class="lines-link nav-link bg-${m.key} text-white" href="#">${m.key}</a>
					</li>
					</c:forEach>
					<li class="nav-item">
						<button id="favorite-btn" class="btn btn-outline-warning"><i class="fas fa-star"></i></button>
					</li>					
				</ul>
				<c:forEach var='line' items='${lines}'>
					<div class="card-group m-2 liveStation" id="liveStation-${line.key}">
						<div class="card border-${line.key} mb-3" >
							<div class="card-header bg-transparent border-${line.key} text-${line.key}">Header</div>
							<div class="card-body text-${line.key}">
								<h5 class="card-title">card title</h5>
								<!-- <p class="card-text">Some quick example text to build on the
									card title and make up the bulk of the card's content.</p> -->
							</div>
							<div class="card-footer bg-transparent border-${line.key} text-${line.key}">Footer</div>
						</div>
						<div class="card bg-${line.key} mb-3" >
							<div class="card-header bg-transparent border-${line.key} text-white text-left">
								<i class='fas fa-angle-left'></i>${line.value[1][fn:length(line.value[1])-2].stationName}
							</div>
							<div class="card-body text-white">
								<h5 class="card-title">${result.stationName}</h5>
								<%-- <p class="card-text">${result.ure}</p> --%>
							</div>
							<div class="card-footer bg-transparent border-${line.key} text-white text-right">
								${line.value[0][1].stationName}<i class="fas fa-angle-right"></i>
							</div>
						</div>
						<div class="card border-${line.key} mb-3" >
							<div class="card-header bg-transparent border-${line.key} text-${line.key}">Header</div>
							<div class="card-body text-${line.key}">
								<h5 class="card-title">card title</h5>
								<!-- <p class="card-text">Some quick example text to build on the
									card title and make up the bulk of the card's content.</p> -->
							</div>
							<div class="card-footer bg-transparent border-${line.key} text-${line.key}">Footer</div>
						</div>
					</div>
				</c:forEach>
				
				<hr/>
				<c:forEach var="line" items="${lines}">
				
				<div class="lines" id="line-${line.key}">
					<!-- 주변 역 노선도 -->
					<c:forEach var="stns" items="${line.value}" varStatus="status">
					<table class="table table-sm table-borderless text-center text-${line.key} table-schedule m-2">
						
						<c:choose>
							<c:when test="${status.index == 0}">
								<caption class="text-right"><i class="fas fa-angle-left"></i>내선(상행)</caption>
							</c:when>
							<c:otherwise>
								<caption>외선(하행)<i class="fas fa-angle-right"></i></caption>
							</c:otherwise>
						</c:choose>
						
						<tbody>
							<tr>
								<c:forEach var='stn' items="${stns}">
								<td>
									<c:if test="${stn.stationName != '' }">
										<i class="fas fa-subway"></i>
									</c:if>
								</td>
								</c:forEach>
								
							</tr>
							<tr>
								<c:forEach var='stn' items="${stns}">
								<td class="bg-${line.key} text-white">
									<c:if test="${stn.stationName != '' }">
										<i class="far fa-circle"></i>
									</c:if>	
								</td>
								</c:forEach>
								
							</tr>
							<tr>
								<c:forEach var='stn' items="${stns}">
									<td><a href='/station/station.do/${stn.stationCode}'>${stn.stationName}</a></td>								
								</c:forEach>
													
							</tr>
						</tbody>
					</table>
					</c:forEach>
					
				</div>
				</c:forEach>	
				<hr/>
				<!-- 혼잡도 -->
				<h5>혼잡도 - 준비중</h5>
				<table class="table">
					<thead>
						<tr>
							<th>상행</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>							
								<ul class="nav nav-pills nav-fill">
								<c:forEach var="i" begin="1" end="10">
									<li class="nav-item">										
										<c:choose>
											<c:when test="${i%3==0}">
												<a class='nav-link btn btn-success text-white'>${i}</a>
											</c:when>
											<c:when test="${i%3==2}">
												<a class='nav-link btn btn-warning text-white'>${i}</a>
											</c:when>
											<c:otherwise>
												<a class='nav-link btn btn-danger text-white'>${i}</a>
											</c:otherwise>
										</c:choose>
									</li>
								</c:forEach>
								</ul>							
							</td>
						</tr>						
					</tbody>
					<thead>
						<tr>
							<th>하행</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>							
								<ul class="nav nav-pills nav-fill">
								<c:forEach var="i" begin="1" end="10">
									<li class="nav-item">										
										<c:choose>
											<c:when test="${(11-i)%3==2}">
												<a class='nav-link btn btn-success text-white'>${11-i}</a>
											</c:when>
											<c:when test="${(11-i)%3==1}">
												<a class='nav-link btn btn-warning text-white'>${11-i}</a>
											</c:when>
											<c:otherwise>
												<a class='nav-link btn btn-danger text-white'>${11-i}</a>
											</c:otherwise>
										</c:choose>
									</li>
								</c:forEach>
								</ul>							
							</td>
						</tr>						
					</tbody>
				</table>
				<hr/>
				<div class="card bg-secondary text-white">
					<div class="card-header">역 이름</div>
					<div class="card-body">
						<h5 class="card-title">${result.stationName}</h5>
						<p class="card-text lead">${result.ure}</p>
					</div>
					<div class="card-footer">${result.sAddress} <i class="fas fa-phone"></i> ${result.sPhone}</div>
				</div>
				<hr/>
			</div>

			<div class='col-lg'>
			
				<!-- 지도 및 출구별 장소 정보 -->						
				<div class="card border-secondary exit-map-card">
					<div id='map' class='card-img-top' style="width: 100%; height: 300px;"></div>
					<div class="card-header bg-secondary text-white">
						<ul class="nav nav-pills card-header-pills nav-fill">
							<li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-angle-left"></i></a></li>
							<li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
								role="button" aria-haspopup="true" aria-expanded="false">1번 출구</a>
								<div class="dropdown-menu" id="exit-list">
									<c:forEach var='sMap' items="${result.sExits}">
										<a class="dropdown-item" href="#">${sMap.key}번 출구</a>
									</c:forEach>								
								</div>
							</li>
							<li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-angle-right"></i></a></li>
						</ul>
					</div>
					<div class="card-body text-secondary" id='exit-info'>					
						<h5 class='card-title'>출구 정보</h5>
						<p class="card-text lead">출구 정보가 없습니다.</p>
						<c:forEach var='sMap' items="${result.sExits}">
							<p class="card-text lead" id="exit-${sMap.key}">${sMap.value}</p>	
						</c:forEach>									
					</div>
				</div>
				<hr/>
				<!-- 내부 지도 및 시설 정보 -->
				<h5>역 정보</h5>								
				<div class="card">
					<img src="http://www.seoulmetro.co.kr/web_upload/cyberstation/in/station_${result.stationCode}.jpg"
					 class="card-img-top" alt="Station">
					<div class="card-body">
						<h5 class="card-title">${result.stationName}</h5>						
						<p class="card-text">${result.useful}</p>
						<p class="card-text">화장실 - ${result.sToilet}</p>
					</div>
				</div>
				<hr/>
			</div>				
		</div>
	</div>
	
<script src="/resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=500615dfd78ac5a177e2c8c513d542b6"></script>
<script src="/resources/js/bootstrap.bundle.js"></script>
<script type="text/javascript" src='/resources/js/station.js'></script>
<script type="text/javascript">
$(function(){	
	
	$('.liveStation').hide();
	$('.lines').hide();
	$('#liveStation-' + $('#line-name').val()).show();
	$('#line-' + $('#line-name').val()).show();
	setExitInfo($('.exit-map-card').find('.dropdown-toggle').text());
	
	$('#exit-list').find('a').on('click',function(){
		setExitInfo($(this).text());
	});
	var code = $('#station-code').val();
	
	/* setInterval(function(){ 
		trainSchedule("03호선",code, 1);
		trainSchedule("03호선",code, 2);
	},5000); */
	
	// 역 코드 저장
	$('.station-codes').each(function(){
		trainSchedule($(this).attr("id"), $(this).val(),1);
		trainSchedule($(this).attr("id"), $(this).val(),2);
	});
	
	setInterval(function(){ 
		$('.station-codes').each(function(){
			trainSchedule($(this).attr("id"), $(this).val(),1);
			trainSchedule($(this).attr("id"), $(this).val(),2);
		});
	},5678);
	
	// 호선 정보 변경
	$('.lines-link').on('click', function(){
		
		$('.liveStation').hide();
		$('.lines').hide();
		$('#liveStation-' + $(this).text()).show();
		$('#line-' + $(this).text()).show();
	});
	
	// 즐겨찾기 버튼 클릭
	$('#favorite-btn').click(function(){
		if($(this).hasClass("btn-outline-secondary")){
			$(this).removeClass("btn-outline-secondary");
			$(this).addClass("btn-outline-warning");
			$(this).find("i").removeClass("far");
			$(this).find("i").addClass("fas");
			favoriteDo($('#station-name').text(),"add");			
			$('.alert > strong').text("추가 성공!");
			$('.alert > span').text("즐겨찾기에 등록 하였습니다.");
			$('.alert').show();
		} else {
			$(this).removeClass("btn-outline-warning");
			$(this).addClass("btn-outline-secondary");
			$(this).find("i").removeClass("fas");
			$(this).find("i").addClass("far");
			favoriteDo($('#station-name').text(),"remove");
			$('.alert > strong').text("제거 완료!");
			$('.alert > span').text("즐겨찾기를 수정 하였습니다.");
			$('.alert').show();
		}
	});
	var addFvList=new Array();	// 이전에 추가해놓은 즐겨찾기 목록
   	var sessionRealMid = '<%=(String) session.getAttribute("realMid")%>';
    if(sessionRealMid != '' || sessionRealMid != 'null'){
    	// ajax로 즐겨찾기 목록 갖고와서 addFvList에 넣어놓기
    	$.ajax({
    		type: "get",
			async : true,
			url : "../member/getfavoritelist.do",
			contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
			success : function(data){
				$.each(JSON.parse(data), function(){
					addFvList.push(this.STATION_NAME);
				});
				if($.inArray($('#station-name').text(),addFvList)){
					$('#favorite-btn').removeClass("btn-outline-secondary");
					$('#favorite-btn').addClass("btn-outline-warning");
					$('#favorite-btn').find("i").removeClass("far");
					$('#favorite-btn').find("i").addClass("fas");
				}
			}
    	});
    }
	// 즐겨찾기 관리 함수
	function favoriteDo(value, key){
		var sessionRealMid = '<%=(String) session.getAttribute("realMid")%>';
        if(sessionRealMid == '' || sessionRealMid == 'null'){
     	   alert('즐겨찾기 추가는 회원만 가능합니다. ');
     	   return false;
        }
 	  
 	   if(key == "add"){ 		   
 		   
 		   $.ajax({
 			   async : true,
        		   url : "../member/addfavoritelist.do",
 			   contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
 			   data : {sname : value},
 			   error : function(){
 				   return false;
 			   }
 		   }); 
 	   } else{ 
 		  
 		   $.ajax({
 			   async : true,
        		   url : "../member/editFavoriteBySname.do",
 			   contentType : 'application/x-www-form-urlencoded;charset=UTF-8',
 			   data : {sname : value},
 			   error : function(){
 				  return false;
 			   }
 		   });
 	   }
 	   
	}
	// 알림창 닫기
	$('.close').click(function(){
		$('.alert').hide();
	});
	
	stationMap(code);	
})
</script>
</body>
</html>