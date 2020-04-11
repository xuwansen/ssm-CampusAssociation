<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/f-head.jsp"%>
<meta charset="UTF-8">
<title>系统登录 - 校园社团管理系统</title>
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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/css/style.css" />
<body class="login_bg">
	<section class="loginBox">
		<section class="loginCont">
			<form class="loginForm"
				action="${pageContext.request.contextPath }/base/dologin"  method="post">
				<div class="info">${error }</div>
				<div class="inputbox">
					<label for="user">账号：</label> <input type="text" class="input-text" name="account" placeholder="请输入用户名" required />
				</div>
				<div class="inputbox">
					<label for="mima">密码：</label> <input type="password" name="password" placeholder="请输入密码" required />
				</div>
				<div class="loginfont">
					<a href="${pageContext.request.contextPath }/f-register">还没有账号？请注册</a>
				</div>
				<div class="subBtn">
					<input type="submit" value="登录" /> <input type="reset" value="重置" />
				</div>
			</form>
		</section>
	</section>
</body>
<%@include file="/WEB-INF/jsp/common/f-foot.jsp"%>