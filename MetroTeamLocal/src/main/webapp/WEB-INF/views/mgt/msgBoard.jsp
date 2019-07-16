<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Dashboard</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
			<button id="ajax_test" type="button"
				class="btn btn-sm btn-outline-secondary">Test</button>
			<button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
		</div>
		<button type="button"
			class="btn btn-sm btn-outline-secondary dropdown-toggle">
			<span data-feather="calendar"></span> This week
		</button>
	</div>
</div>

<div class="table-responsive">
	<table class="table table-dark table-hover table-striped table-sm">
		<thead>
			<tr>
				<th>회원번호</th>
				<th>역 코드</th>
				<th>열차코드</th>
				<th>등록일</th>
				<th>내 용</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var='m' items="${list}">
				<tr>
					<td>${m.memberId}</td>
					<td>${m.stationId}</td>
					<td>${m.trainId}</td>
					<td>${m.msgDate}</td>
					<td>${m.msgContent}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
<h2>Section title</h2>
<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>