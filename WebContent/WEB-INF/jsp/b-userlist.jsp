<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/b-head.jsp"%>
<article>
	<tr>
		<td align="center">
			<ul class="select">
				<form method="post" action="${pageContext.request.contextPath }/user/backUserlist">
					<input name="method" value="query" class="input-text" type="hidden">
					<li class="select-list">
						<dl id="select3">
							<dt>姓名：</dt>
							<dd>
								<input id="name" name="name" class="input-text" type="text"
									value="${name}" />
								<button type="submit">确认</button>
							</dd>
						</dl>
					</li>
					<li class="select-list">
						<dl id="select4">
							<dt>角色：</dt>
							<dd>
								<select name="role_id">
									<c:if test="${roleList != null }">
										<option value="0">--请选择--</option>
										<c:forEach var="role" items="${roleList}">
											<option
												<c:if test="${role.id == role_id }">selected="selected"</c:if>
												value="${role.id}">${role.role_name}</option>
										</c:forEach>
									</c:if>
								</select>
								<button type="submit">确认</button>
							</dd>
						</dl>
					</li> <input type="hidden" name="pageNo" id="pageNo" value="1" />
				</form>

				<li>
					<table id="tbList" border="0" cellpadding="0" border="1"
						cellspacing="0" style="margin-left: -100px; width: 100%;">
						<tr style="background-color: rgba(255, 102, 0, .8); height: 30px;"
							id="header_order">
							<td align="center" style="color: #fff;" class="font_b2"><strong>id</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>账号</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>姓名</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>角色</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>电话</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>操作</strong></td>
						</tr>
						<c:forEach var="user" items="${userList}" varStatus="status">
							<tr>
								<td><span>${user.id }</span></td>

								<td><span>${user.account }</span></td>
								<td><span>${user.name }</span></td>
								<td><span>${user.role_name }</span></td>
								<td><span>${user.phone}</span></td>
								<td><span><a
										href="${pageContext.request.contextPath }/user/usermodify?id=${user.id}"><img
											src="${pageContext.request.contextPath }/statics/img/xiugai.png"
											alt="修改" title="修改" /></a></span> <span><a
										href="${pageContext.request.contextPath }/user/removeUser?id=${user.id}"><img
											src="${pageContext.request.contextPath }/statics/img/schu.png"
											alt="删除" title="删除" onclick="javascript:return del();"/></a></span></td>
							</tr>
						</c:forEach>
					</table>
					<div class="page-bar">
						<ul class="page-num-ul clearfix">
							<li>共${totalSize}条记录&nbsp;&nbsp; ${pageNo }/${totalPage}页</li>
							<c:if test="${pageNo > 1}">
								<a href="javascript:page_nav(document.forms[2],1);">首页</a>
								<a href="javascript:page_nav(document.forms[2],${pageNo-1});">上一页</a>
							</c:if>
							<c:if test="${pageNo < totalPage}">
								<a href="javascript:page_nav(document.forms[2],${pageNo+1});">下一页</a>
								<a href="javascript:page_nav(document.forms[2],${totalPage});">最后一页</a>
							</c:if>
							&nbsp;&nbsp;
						</ul>
						<span class="page-go-form"><label>跳转至</label> <input
							type="text" name="inputPage" id="inputPage" value="${pageNo}"
							class="page-key" />页
							<button type="button" class="page-btn"
								onClick='page_nav(document.forms[2],document.getElementById("inputPage").value)'>GO</button>
						</span>
					</div>
				</li>
			</ul> <script type="text/javascript">
			function page_nav(f,p){
				document.getElementById("pageNo").value = p;
				f.submit();
			}
			function del() {
				var msg = "您真的确定要删除吗？\n\n请确认！";
				if (confirm(msg)==true){
					return true;
				}else{
					return false;
				}
			}
		</script>
</article>

<%@include file="/WEB-INF/jsp/common/f-foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/clublist.js"></script>

