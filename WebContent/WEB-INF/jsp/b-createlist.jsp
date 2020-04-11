<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/b-head.jsp"%>
<article>
	<tr>
		<td align="center">
			<ul class="select">
				<form method="post" action="${pageContext.request.contextPath }/create/createlist">
					<input name="method" value="query" class="input-text" type="hidden">
					<input type="hidden" name="pageNo" id="pageNo" value="1" />
				</form>

				<li>
					<table id="tbList" border="0" cellpadding="0" border="1"
						cellspacing="0" style="margin-left: -100px; width: 100%;">
						<tr style="background-color: rgba(255, 102, 0, .8); height: 30px;"
							id="header_order">
							<td align="center" style="color: #fff;" class="font_b2"><strong>ID</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>姓名</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>电话</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>年级</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>专业</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>社团名</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>社团简介</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>操作</strong></td>
						</tr>
						<c:forEach var="create" items="${createclublist }"
							varStatus="status">
							<tr>
								<td><span>${create.userId}</span></td>
								<td><span>${create.user.name}</span></td>
								<td><span>${create.user.phone }</span></td>
								<td><span>${create.user.grade}</span></td>
								<td><span>${create.user.professional}</span></td>
								<td><span>${create.clubName}</span></td>
								<td><span>${create.clubBrief}</span></td>
								<td><span><a
										href="${pageContext.request.contextPath }/create/agreecreate?clubname=${create.clubName}&&clubbrief=${create.clubBrief}&&userid=${create.userId}"><img
											src="${pageContext.request.contextPath }/statics/img/add.jpg"
											alt="添加" title="添加" /></a></span> <span><a
										href="${pageContext.request.contextPath }/create/disagreecreate?createclubId=${create.id}"><img
											src="${pageContext.request.contextPath }/statics/img/schu.png"
											alt="删除" title="删除" /></a></span></td>
							</tr>
						</c:forEach>
					</table>
					<div class="page-bar">
						<ul class="page-num-ul clearfix">
							<li>共${totalSize}条记录&nbsp;&nbsp; ${pageNo }/${totalPage}页</li>
							<c:if test="${pageNo > 1}">
								<a href="javascript:page_nav(document.forms[1],1);">首页</a>
								<a href="javascript:page_nav(document.forms[1],${pageNo-1});">上一页</a>
							</c:if>
							<c:if test="${pageNo < totalPage}">
								<a href="javascript:page_nav(document.forms[1],${pageNo+1});">下一页</a>
								<a href="javascript:page_nav(document.forms[1],${totalPage});">最后一页</a>
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
		</script>
</article>

<%@include file="/WEB-INF/jsp/common/f-foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/clublist.js"></script>

