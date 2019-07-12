<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>열차 정보</title>
<link href="/resources/css/bootstrap.css" rel="stylesheet" />
<script type="text/javascript" src='/resources/js/jquery-3.4.1.js'></script>
<script type="text/javascript" src='/resources/js/bootstrap.js'></script>
</head>
<body>
<h1 class="display-1">TRAIN-INFO</h1>
<div class='container-fluid'>
	<table class='table table-hover table-responsive'>
		<tbody>
			<tr><th scope='row'>상행</th><c:forEach var='i' begin="1" end="10"><td class='table-success'><button class='btn btn-lg btn-outline-warning btn-block'>${i}호차</button></td></c:forEach></tr>
			<tr><th scope='row'>하행</th><c:forEach var='i' begin="1" end="10"><td class='table-warning'><button class='btn btn-lg btn-outline-warning btn-block'>${11-i}호차</button></td></c:forEach></tr>			
		</tbody>
	</table>
</div>
</body>
</html>