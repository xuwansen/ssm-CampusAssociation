<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>系统登录 - 社团管理系统</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/style.css" />
</head>
<body class="login_bg1">
	<section>
		<header class="loginHeader">
			<h1>校园社团管理系统</h1>
		</header>
		<section class="loginCont">
			<form action="${pageContext.request.contextPath }/user/dologin"
				name="actionForm" id="actionForm" method="post">
				<div class="info">${error }</div>
				<div class="inputbox">
					<label for="user">用户名：</label> <input type="text"
						class="input-text" id="account" name="account" placeholder="请输入账号"
						required />
				</div>
				<div class="inputbox">
					<label for="mima">密码：</label> <input type="password" id="password"
						name="password" placeholder="请输入密码" style="margin-left: 15px;"
						required />
				</div>
				<div class="subBtn">
					<input type="submit" value="登录" style="margin-left: 15px;" /> <input
						type="reset" value="重置" style="margin-left: 15px;" />
				</div>
			</form>
		</section>
	</section>
</body>
</html>
