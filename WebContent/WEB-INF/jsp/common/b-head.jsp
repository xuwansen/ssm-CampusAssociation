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
	<header>
	<div class="theme-popover">
		<div class="theme-poptit">
			<a href="javascript:;" title="关闭" class="close">×</a>
			<h3 style="text-align: left;">登录</h3>
		</div>
		<div class="theme-popbod dform">
			<form class="theme-signin" name="loginform" action="" method="post"
				onsubmit="return check()">
				<ol>
					<li><strong>学号：</strong><input class="ipt" type="text"
						name="username" id="username" size="20" /></li>
					<li><strong>密码：</strong><input class="ipt" type="password"
						name="password" id="password" size="20" /></li>
					<li><input class="btn btn-primary" type="submit" name="submit"
						value=" 登 录 " /></li>
				</ol>
			</form>
		</div>
	</div>
	<script>
		/*弹框登陆功能开始*/
		jQuery(document).ready(function($) {
			$('.theme-login').click(function(){
				$('.theme-popover-mask').fadeIn(100);
				$('.theme-popover').slideDown(200);
			})
			$('.theme-poptit .close').click(function(){
				$('.theme-popover-mask').fadeOut(100);
				$('.theme-popover').slideUp(200);
			})
		})
		/*弹框登陆功能结束*/
		/*弹窗表单验证测试*/
			function check() {
							var username=document.getElementById("username").value;
							if(!/^[0-9]*$/.test(username)||/(^\s*)|(\s*$)/.test("username")){
								alert('请输入正确的学号');
								return false;
							}
							var password=document.getElementById("password").value;
							if(/^[\s\n\t\r]*$/.test(password)){
								alert('密码不能为空')
								return false;
							}
						}
		</script> <script>
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
					style="margin-left: -10px; margin-top: 5px;">校园社团后台管理系统</div>
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
									欢迎您，${sessionScope.user.name }! &nbsp;丨&nbsp;<a
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
					href="${pageContext.request.contextPath }/user/backUserlist">用户管理</a></li>
				<li role="presentation" class="navbar-brand"><a
					href="${pageContext.request.contextPath }/club/backClublist">社团管理</a></li>
				<li role="presentation" class="navbar-brand"><a
					href="${pageContext.request.contextPath }/notice/backNoticelist">公告管理</a></li>
				<li role="presentation" class="navbar-brand"><a
					href="${pageContext.request.contextPath }/create/createlist">创建社团请求管理</a></li>
				<li role="presentation" class="navbar-brand"><a
					href="${pageContext.request.contextPath }/base/exit">退出系统</a></li>
			</ul>
		</div>
	</div>
	<div style="height: 4px; width: 1000px; background: red; margin: auto;"></div>
	</nav>
</body>
</html>