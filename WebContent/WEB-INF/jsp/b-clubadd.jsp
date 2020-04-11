<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/b-head.jsp"%>
<div class="location">
	<strong>你现在所在的位置是:</strong> <span>社团管理页面 >> 社团添加页面</span>
</div>
<div class="providerAdd">
	<form method="post"
		action="${pageContext.request.contextPath}/club/addClub"
		modelAttribute="club">
		<font color="red">${sessionScope.message}</font> <input name="method"
			value="query" class="input-text" type="hidden">

		<li class="select-list">
			<dl id="select3">
				<dt>社团名称：</dt>
				<dd>
					<input id="clubName" name="clubName" class="input-text" type="text"
						value="" />
				</dd>
			</dl>
		</li>
		<li class="select-list">
		<li class="select-list">
			<dl id="select3">
				<dt>社团简介：</dt>
				<dd>
					<input id="clubBrief" name="clubBrief" class="input-text"
						type="text" value="" />
				</dd>
			</dl>
		</li>
		<li class="select-list">
			<dl id="select4">
				<dt>社长ID：</dt>
				<dd>
					<input id="userId" name="userId" class="input-text" type="number"
						value="" />
				</dd>
			</dl>
			<div id="select4">
				<input type="submit" name="add" id="add" value="保存"> <input
					type="button" id="back" name="back" value="返回">
			</div>
		</li>
	</form>
</div>


<%@include file="/WEB-INF/jsp/common/f-foot.jsp"%>

