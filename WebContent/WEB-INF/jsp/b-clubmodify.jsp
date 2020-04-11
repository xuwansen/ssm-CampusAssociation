ss<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/b-head.jsp"%>
<div class="location">
	<strong>你现在所在的位置是:</strong> <span>社团管理页面 >> 社团修改页面</span>
</div>
<div class="providerAdd">

	<form method="post"
		action="${pageContext.request.contextPath }/club/modifyClubSave"
		modelAttribute="club">
		<input name="method" value="query" class="input-text" type="hidden">
		<font color="red">${sessionScope.message}</font> <input type="hidden"
			id="clubId" name="clubId" value="${club.clubId }" />
		<li class="select-list">
			<dl id="select3">
				<dt>社团名称：</dt>
				<dd>
					<input id="clubName" name="clubName" class="input-text" type="text"
						value="${club.clubName }" />
				</dd>
			</dl>
		</li>
		<li class="select-list">
			<dl id="select3">
				<dt>社团简介：</dt>
				<dd>
					<input id="clubBrief" name="clubBrief" class="input-text"
						type="text" value="${club.clubBrief}" />
				</dd>
			</dl>
			<div id="select4">
				<input type="submit" name="save" id="save" value="保存"> <input
					type="button" id="back" name="back" value="返回">
			</div>
		</li>
	</form>
</div>
<%@include file="/WEB-INF/jsp/common/f-foot.jsp"%>

