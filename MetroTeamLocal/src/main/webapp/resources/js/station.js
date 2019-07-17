/**
 * 
 */
$(function(){
	$('.station-map').click(function(){		
		
		stationMap($(this).text());
		exitInfo($(this).text());
	});
	
	$('#search-button').click(function(){
		stationList($('#search-station').val());
	});
});

function stationMap(code){
	
	// 역코드 해당역에서 가장 빠른 코드 번호 조회
	$.ajax({
		type : "get",
		url : "/mgt/stationCode.do/" + code,
		success : function(data){
			
			// 서울시 역코드로 지하철역 위치 조회
			$.getJSON("http://openapi.seoul.go.kr:8088/5651457766776f6f38366244585056/json/SearchLocationOfSTNByIDService/1/1/" + data, 
					function(data){
							var coord = data.SearchLocationOfSTNByIDService.row[0];
							var yCoord = coord.YPOINT_WGS;
							var xCoord = coord.XPOINT_WGS;
							
							console.log("X:" + xCoord + ", Y:" + yCoord);
							getMap(xCoord,yCoord);				
			});
		}
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
	var colorWheel = new Array("primary","secondary","success", "danger","warning","info","dark");
	$.ajax({
		type : "get",
		data : {"stationCode" : code},
		url : "/mgt/exitInfo.do",
		dataType : "json",
		success : function(data){
			var cols = $('.card-columns-exits');
			cols.empty();
			var exits = Object.keys(data);
			for(var i=0; i < exits.length; i++){
				cols.append("<div class='card bg-" + colorWheel[i%colorWheel.length] + " text-white text-center p-3'></div>");
				var div = cols.find("div:nth-of-type(" + (i+1) + ")");
				div.append("<blockquote class='blockquote mb-0'></blockquote>");
				var bQuote = div.find("blockquote");
				bQuote.append("<p>" + data[exits[i]] + "</p>");
				bQuote.append("<footer class='blockquote-footer text-white'></footer>");
				bQuote.find("footer").append("<small>" + exits[i] +  "<cite title='Source Title'> 번 출구 </cite></small>");
			}
		}
	});
}

function stationList(searchWord){
	
	$.ajax({
		type : "get",
		url : "/mgt/stationInfo.do/" + searchWord,
		dataType : "json",
		success : function(data){
			for(var a in data){
				console.log(data[a]);
			}
		}
	});
}





