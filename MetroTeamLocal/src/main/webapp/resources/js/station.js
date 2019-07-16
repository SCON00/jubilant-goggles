/**
 * 
 */
$(function(){
	$('.station-map').click(function(){		
		
		stationMap($(this).text());
	});
});

function stationMap(code){
	// 서울시 역코드로 지하철역 위치 조회
	$.getJSON("http://openapi.seoul.go.kr:8088/5651457766776f6f38366244585056/json/SearchLocationOfSTNByIDService/1/1/" + code, 
			function(data){
					var coord = data.SearchLocationOfSTNByIDService.row[0];
					var yCoord = coord.YPOINT_WGS;
					var xCoord = coord.XPOINT_WGS;
					
					console.log("X:" + xCoord + ", Y:" + yCoord);
					getMap(xCoord,yCoord);				
	});
}

function getMap(x,y){
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(x, y), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};

	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
}

function exitInfo(code){
	$.ajax({
		type : "get",
		data : {"stationCode" : code},
		url : "/mgt/exitInfo.do",
		dataType : "json",
		success : function(data){
			var exits = Object.keys(data);
			for(var i=0; i < exits.length; i++){
				console.log(exits[i] + ": " + data[exits[i]]);
			}
		}
	});
}
/*
<div class="card bg-${i} text-white text-center p-3">
<blockquote class="blockquote mb-0">
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
		Integer posuere erat.</p>
	<footer class="blockquote-footer text-white">
		<small> Someone famous in <cite title="Source Title">Source
				Title</cite>
		</small>
	</footer>
</blockquote>
</div>

*/





