<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/b-head.jsp"%>
<div class="location">
	<strong>你现在所在的位置是:</strong> <span>公告管理页面 >> 公告添加页面</span>
</div>
<div class="providerAdd">
	<form method="post"
		action="${pageContext.request.contextPath }/notice/addNotice"
		modelAttribute="notice">
		<font color="red">${sessionScope.message}</font> <input name="method"
			value="query" class="input-text" type="hidden">
		<li class="select-list">
			<dl id="select3">
				<dt>标题：</dt>
				<dd>
					<input id="title" name="title" class="input-text" type="text"
						value="" />
				</dd>
			</dl>
		</li>
		<li class="select-list">
			<dl id="select4">
				<dt>内容：</dt>
				<dd>
					<input id="article" name="article" class="input-text" type="text"
						value="" style="height: 200px; width: 350px;" />
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

