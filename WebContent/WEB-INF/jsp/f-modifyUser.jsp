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
	<h3></h3>
	<form action="${pageContext.request.contextPath }/base/modifyUserSave"
		method="post" modelAttribute="user">
		<div class="register">
			<font color="red">${requestScope.message}</font>
			 <input type="hidden" id=id name="id" value="${user.id }" />
			<div class="inputbox" style="margin-left: 15px;">
				<label for="user">姓名：</label> <input type="text" id="name"
					name="name" value="${user.name }" />
			</div>
			<div class="inputbox" style="margin-left: 15px;">
				<label for="password">密码：</label> <input type="text" id="password"
					name="password" value="${user.password }" />
			</div>
			<div class="inputbox">
				<label for="phone">电话：</label> <input type="number" id="phone"
					name="phone" value="${user.phone }" />
			</div>
			<div class="inputbox">
				<label for="phone">年级：</label> <input type="text" id="grade"
					name="grade" value="${user.grade }" />
			</div>
			<div class="inputbox">
				<label for="phone">专业：</label> <input type="text" id="professional"
					name="professional" value="${user.professional }" />
			</div>
			<div class="subBtn">
				<input type="submit" value="保存" /> <input type="reset" value="返回" />
			</div>
		</div>
	</form>
</body>
<%@include file="/WEB-INF/jsp/common/f-foot.jsp"%>