<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校园社团网</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/css/lanrenzhijia.css"
	media="all">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/css/main.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/css/f-style.css" />
</head>
<body>
	<session> <!--轮播开始-->
	<div class="XXX" style="margin-top: 5px;">
		<div id="slidershow" class="carousel slide" data-slide="carousel">
			<!--图片轮播顺序-->
			<ol class="carousel-indicators">
				<li class="active" data-target="#slidershow" data-slide-to="0"></li>
				<li class="active" data-target="#slidershow" data-slide-to="1"></li>
				<li class="active" data-target="#slidershow" data-slide-to="2"></li>
				<li class="active" data-target="#slidershow" data-slide-to="3"></li>
			</ol>
			<!--设置轮播图片-->
			<div class="carousel-inner">
				<div class="item active" style="margin: 0 auto;">
					<a href="#"><img
						src="${pageContext.request.contextPath }/statics/img/logo/lunbo1.jpg"
						style="width: 1000px; height: 450px;" style="margin: auto;" /></a>
					<div class="carousel-caption">
						<h3></h3>
					</div>
				</div>
				<div class="item">
					<a href="#"><img
						src="${pageContext.request.contextPath }/statics/img/logo/lunbo2.png"
						style="width: 1000px; height: 450px;" /></a>
					<div class="carousel-caption">
						<h3></h3>
					</div>
				</div>
				<div class="item">
					<a href="#"><img
						src="${pageContext.request.contextPath }/statics/img/logo/lunbo3.jpg"
						style="width: 1000px; height: 450px;" /></a>
					<div class="carousel-caption">
						<h3></h3>
					</div>
				</div>
				<div class="item">
					<a href="#"><img
						src="${pageContext.request.contextPath }/statics/img/logo/lunbo4.png"
						style="width: 1000px; height: 450px;" /></a>
					<div class="carousel-caption">
						<h3></h3>
					</div>
				</div>
				<!--设置轮播图片结束-->
			</div>
			<!--图片轮播控制器开始-->
			<a class="carousel-control left " href="#slidershow" role="button"
				data-slide="next"><span
				class="glyphicon glyphicon-chevron-left">&lsaquo;</span></a> <a
				class="carousel-control right" href="#slidershow" role="button"
				data-slide="next"><span
				class="glyphicon glyphicon-chevron-right">&rsaquo;</span></a>
		</div>
	</div>
	<!--轮播结束--> <!--内容部分开始--> </session>
</body>
</html>