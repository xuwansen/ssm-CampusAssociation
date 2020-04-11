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

	<article>
		<div class="container" style="width: 1000px; margin: 5px 160px;">
			<table width="1000" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td valign="top">&nbsp;</td>
					<td valign="top">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr bgcolor="ffffff">
					<td width="200" rowspan="2" align="center" valign="top"
						bgcolor="#f3f3f3">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="50" align="left">
									<table width="92%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="17%">&nbsp;</td>
											<td width="83%" class="font_w1"><p style="front:">申请社团</p></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<p>&nbsp;</p>
					</td>
					<td width="20" rowspan="2" align="center" valign="top">&nbsp;</td>
					<td valign="top"><img
						src="${pageContext.request.contextPath }/statics/img/logo/create.jpg"
						width="780" height="179" /></td>
				</tr>
				<tr bgcolor="ffffff">
					<td width="780" valign="top" bgcolor="#ffffff">


						<table width="98%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2" align="left"><span class="STYLE4">创建社团申请</span></span></td>
							</tr>
							<tr>
								<td height="15" colspan="2" align="left"></td>
							</tr>
							<tr>
								<td colspan="2" align="left" class="font_b2"><img
									src="/images/line1.gif" width="100%" height="1" /></td>
							</tr>
							<tr>
								<td height="15" colspan="2"></td>
							</tr>

							<tr>
								<td colspan="2">
									<form
										action="${pageContext.request.contextPath }/create/Createclub?userId=${sessionScope.user.id}"
										method="post" onsubmit="return check()">

										<table class="formtable" style="text-align: left;">
											<font color="red">${requestScope.message}</font>
											
											<li class="select-list">
												<dl id="select3">
													社团名：
													<input id="clubname" name="clubname" class="input-text"
														type="text" />
												</dl>
											</li>
											<li class="select-list">
												<dl id="select3">
													社团简介：
													<input id="clubbrief" name="clubbrief" class="input-text"
														type="text" />

												</dl>
												<dl id="select3">
													<input id="name" name="name" class="input-text"
														type="hidden" />
													<button type="submit">确认</button>
												</dl>

											</li>
										</table>
									</form>
								</td>
							</tr>
						</table>

					</td>
				</tr>
			</table>

		</div>

	</article>
</body>
<%@include file="/WEB-INF/jsp/common/f-foot.jsp"%>
