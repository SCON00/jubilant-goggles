<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="resources/css/bootstrap.css" rel="stylesheet" />
<script type="text/javascript" src='resources/js/jquery-3.4.1.js'></script>
<script type="text/javascript" src='resources/js/bootstrap.js'></script>
</head>
<body>
<div class='container-fluid'>
	<table class="table table-dark">
		<thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row"><a href='mgt/dashboard.do/stationBoard' class='btn btn-outline-warning'>관리자 모듈</a></th>
    	<td><a href='station/linemap.do' class='btn btn-outline-success'>LINE-MAP</a></td>
    	<td><a href='station/station.do/0332' class='btn btn-outline-secondary'>STATION</a></td>
    	<td><a href='cs/noticeList.do' class='btn btn-outline-primary'>공지사항</a></td>
    </tr>
    <tr>
    	<th scope="row"><a href='member/mypage.do' class='btn btn-outline-warning'>마이페이지</a></th>
    	<td><a href='station/lineinfo.do' class='btn btn-outline-success'>LINE-INFO</a></td>
    	<td><a href='train/traininfo.do' class='btn btn-outline-secondary'>TRAIN-INFO</a></td>
    	<td><a href='cs/favorite.do' class='btn btn-outline-primary'>즐겨찾기</a></td>
    </tr>
  </tbody>
	</table>
</div>
</body>
</html>