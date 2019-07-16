<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>관리자 모듈</title>

    <link rel="canonical" href="https://korvil.com">

    <!-- Bootstrap core CSS -->
<link href="/resources/css/bootstrap.css" rel="stylesheet">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="/resources/css/dashboard.css" rel="stylesheet">

<script src="/resources/js/jquery-3.4.1.js"></script>
	
	<script src="/resources/js/bootstrap.bundle.js"></script>
	
	<script type="text/javascript">
		$(function(){
			
			$('#ajax_test').click(function(){
				
				$.ajax({
					type: "get",
					url: "getLines.do",
					success : function(data){
						alert("!!!");
					}
				});
			});
			$('input[type="text"]').keypress(function(e){
				if(e.which == 13){
					var apiKey = $(this).val();
					if(apiKey != null){
						$.ajax({
							type: "get",
							url: "addKey.do/" + apiKey,
							success : function(data){
								alert(data);
							}
						});
					}
				}				
			});
		});
	</script>

  </head>
<body>
	<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Company	name</a> 
		<input class="form-control form-control-dark w-100" type="text"	placeholder="Search" aria-label="Search">
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><a class="nav-link" href="#">Sign
					out</a></li>
		</ul>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<nav class="col-md-2 d-none d-md-block bg-light sidebar">
				<div class="sidebar-sticky">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link active" href="#">
								<span data-feather="home"></span> Dashboard <span
								class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="memberBoard"> <span 
								data-feather="file"></span> 회원관리
						</a></li>
						<li class="nav-item"><a class="nav-link" href="stationBoard"> <span
								data-feather="shopping-cart"></span> 역정보 관리
						</a></li>
						<li class="nav-item"><a class="nav-link" href="scheduleBoard"> <span
								data-feather="users"></span> 열차 스케줄 관리
						</a></li>
						<li class="nav-item"><a class="nav-link" href="noticeBoard"> <span
								data-feather="bar-chart-2"></span> 공지사항
						</a></li>
						<li class="nav-item"><a class="nav-link" href="qnaBoard"> <span
								data-feather="layers"></span> 문의사항
						</a></li>
					</ul>

					<h6
						class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
						<span>Saved reports</span> <a
							class="d-flex align-items-center text-muted" href="#"> <span
							data-feather="plus-circle"></span>
						</a>
					</h6>
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Current month
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Last quarter
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Social engagement
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Year-end sale
						</a></li>
					</ul>
				</div>
			</nav>
			
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
			<jsp:include page="${boardName}.jsp"></jsp:include>
			</main>
		</div>
	</div>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
	<script src="/resources/js/dashboard.js"></script>
</body>
</html>
