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
	<header> <script>
		/*加入收藏功能开始*/
		function AddFavorite(sURL, sTitle) {
            try {
                window.external.addFavorite(sURL, sTitle);
            }
            catch (e) {
                try {
                    window.sidebar.addPanel(sTitle, sURL, "");
                }
                catch (e) {
                    alert("加入收藏失败，请使用Ctrl+D进行添加");
                }
            }
        }
 		/*加入收藏功能结束*/
		</script>
	<div class="container-fluid"
		style="width: 1000px; border-top-left-radius: 5px; border-top-right-radius: 5px;">
		<div class="container">
			<div class="head-top">
				<div class="navbar-left"
					style="margin-left: -10px; margin-top: 5px;">校园社团网，欢迎您！</div>
				<div class="navbar-right"
					style="margin-right: 180px; margin-top: 5px;">
					<c:choose>
						<c:when test="${sessionScope.user==null}">
							<a class="theme-login"
								href="${pageContext.request.contextPath }/f-login">嗨，您还没登录呢</a>&nbsp;丨&nbsp;<a
								href="javascript:void(0)"
								onclick="AddFavorite(window.location,document.title)">加入收藏</a>&nbsp;丨&nbsp;<a
								href="#">联系我们</a>
						</c:when>
						<c:otherwise>
							<a class="theme-login"
								href="${pageContext.request.contextPath }/base/exit">欢迎您，${sessionScope.user.name }!
								注销</a>&nbsp;丨&nbsp;<a
								href="${pageContext.request.contextPath }/f-modifyUser?id=${sessionScope.user.id }">修改个人信息</a>&nbsp;丨&nbsp;<a
								href="javascript:void(0)"
								onclick="AddFavorite(window.location,document.title)">加入收藏</a>&nbsp;丨&nbsp;<a
								href="#">联系我们</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
	<div class="container" style="height: 80px;">
		<div class="navbar-left">
			<a href="#" class="navbar-brand"><img
				src="${pageContext.request.contextPath }/statics/img/logo/logo.jpg"
				width="400px" height="40px" /></a>
		</div>
		<div class="left" style="margin-top: 30px; margin-left: 100px;">
			<form class="form-search">
				<input type="text" class="input-medium search-query"
					style="width: 250px;">
				<button type="submit" class="btn-primary">搜索</button>
			</form>
		</div>
		<div class="navbar-right" style="margin-right: 50px;">
			<img
				src="${pageContext.request.contextPath }/statics/img/logo/ballroom.jpg"
				width="130px" height="130px" />
		</div>
	</div>

	</header>
	<nav>
	<div class="container">
		<div class="navbar-nav">
			<ul class="nav nav-pills">
				<li role="presentation" class="navbar-brand"><a
					href="${pageContext.request.contextPath }/notice/selectNotice">首页</a></li>
				<li class="dropdown navbar-brand"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> 社团快讯 <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">社团新闻</a></li>
						<li><a href="notice.html">社团公告</a></li>
					</ul></li>
				<li role="presentation" class="navbar-brand"><a
					href="${pageContext.request.contextPath }/club/frontClublist">社团检索</a></li>
				<li role="presentation" class="navbar-brand"><a href="#">资料下载</a></li>
				<li role="presentation" class="navbar-brand"><a href="#">规章制度</a></li>
				<c:choose>
					<c:when test="${sessionScope.user.role_id==2}">
						<li role="presentation" class="navbar-brand"><a
							href="${pageContext.request.contextPath }/join/frontJoinlist?clubId=${sessionScope.clubId}">加入社团名单</a></li>
					</c:when>
					<c:otherwise>
						<li role="presentation" class="navbar-brand"><a
							href="${pageContext.request.contextPath }/f-creatclub">创建社团</a></li>
					</c:otherwise>
				</c:choose>

			</ul>

		</div>
	</div>
	<div style="height: 4px; width: 1000px; background: red; margin: auto;"></div>
	</nav>
</body>
</html>