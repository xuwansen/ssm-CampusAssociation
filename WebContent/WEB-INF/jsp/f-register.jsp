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


<body>
	<h3>注册</h3>
	<form action="${pageContext.request.contextPath }/base/register"
		method=post>
		<div class="register">
			<div class="inputbox" style="margin-left: 15px;">
				<label for="user">姓名：</label> <input type="text" class="input-text"
					id="name" name="name" placeholder="请输入姓名" required />
			</div>
			<div class="inputbox" style="margin-left: 15px;">
				<label for="account">账号：</label> <input type="text"
					class="input-text" id="account" name="account" placeholder="请输入账号"
					required />
			</div>
			<div class="inputbox" style="margin-left: 15px;">
				<label for="password">密码：</label> <input type="password" id="pwd1"
					name="password" placeholder="请输入密码" required />
			</div>
			<div class="inputbox">
				<label for="phone">手机号码：</label> <input type="number" id="phone"
					name="phone" placeholder="请输入账号" required />
			</div>
			<div class="inputbox">
				<label for="grade">年级：</label> <input type="text" id="grade"
					name="grade" placeholder="请输入年级，例：大一" required />
			</div>
			<div class="inputbox">
				<label for="professional">专业：</label> <input type="text"
					id="professional" name="professional" placeholder="请输入专业，例：软件工程"
					required />
			</div>
			<div class="subBtn">
				<input type="submit" value="注册" /> <input type="reset" value="重置" />
			</div>
		</div>
	</form>
</body>
<%@include file="/WEB-INF/jsp/common/f-foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/f-register.js"></script>
