ss<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/b-head.jsp"%>
<div class="location">
	<strong>你现在所在的位置是:</strong> <span>社团管理页面 >> 社团修改页面</span>
</div>
<div class="providerAdd">

	<form method="post"
		action="${pageContext.request.contextPath }/user/usermodifysave"
		modelAttribute="user">
		<font color="red">${sessionScope.message}</font> <input name="method"
			value="query" class="input-text" type="hidden"> <input
			type="hidden" id="id" name="id" value="${user.id }" />
		<li class="select-list">
			<dl id="select3">
				<dt>姓名：</dt>
				<dd>
					<input id="name" name="name" class="input-text" type="text"
						value="${user.name }" />
				</dd>
			</dl>
		</li>
		<li class="select-list">
			<dl id="select3">
				<dt>电话：</dt>
				<dd>
					<input id="phone" name="phone" class="input-text" type="text"
						value="${user.phone}" />
				<dd></dd>
				</dd>
			</dl>

			<dl id="select4">
				<dt>角色：</dt>
				<dd>
					<select name="role_id" id="role_id">
						<c:if test="${roleList != null }">
							<option value="0">--请选择--</option>
							<c:forEach var="role" items="${roleList}">
								<option
									<c:if test="${role.id == user.role_id }">selected="selected"</c:if>
									value="${role.id}">${role.id}</option>
							</c:forEach>
						</c:if>
					</select>
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

