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
	<script>
          function validate() {
              var pwd1 = document.getElementById("password").value;
              var pwd2 = document.getElementById("password2").value;

              if(pwd1 == pwd2) {
                  document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
                  document.getElementById("submit").disabled = false;
              }
              else {
                  document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
                document.getElementById("submit").disabled = true;
              }
          }
      </script>
	<h3></h3>
	<form
		action="${pageContext.request.contextPath }/user/modifyPasswordSave"
		method="post" modelAttribute="user">
		<div class="register">
			<input type="hidden" id="account" name="account"
				value="${sessionScope.user.account }" />
			<div class="inputbox" style="margin-left: 15px;">
				<label for="user">旧密码：</label> <input type="password"
					class="input-text" id="oldpassword" name="oldpassword" />
			</div>
			<div class="inputbox" style="margin-left: 15px;">
				<label for="password">新密码：</label> <input type="password"
					id="password" name="password" placeholder="请输入新密码" required />
			</div>
			<div class="inputbox">
				<label for="password">确定密码：</label> <input type="password"
					id="password2" name="password" placeholder="请输入新密码" required /> <span
					id="tishi"></span>
			</div>
			<div class="subBtn">
				<input type="submit" value="保存" /> <input type="reset" value="返回" />
			</div>
		</div>
	</form>
</body>
<%@include file="/WEB-INF/jsp/common/f-foot.jsp"%>