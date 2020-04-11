<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/b-head.jsp"%>
<article>
	<tr>
		<td align="center">
			<ul class="select">
				<form method="post"
					action="${pageContext.request.contextPath }/club/backClublist">
					<input name="method" value="query" class="input-text" type="hidden">

					<li class="select-list">
						<dl id="select3">
							<dt>社团号：</dt>
							<dd>
								<input name="clubId" class="input-text" type="number" />
								<button type="submit">确认</button>
							</dd>
						</dl>
					</li>
					<li class="select-list">
						<dl id="select4">
							<dt>社团名称：</dt>
							<dd>
								<input name="clubName" class="input-text" type="text" />
								<button type="submit">确认</button>
							</dd>
							<a href="${pageContext.request.contextPath}/b-clubadd"><img
								src="${pageContext.request.contextPath }/statics/img/addClub.jpg"
								alt="添加社团" title="添加社团" /></a>
						</dl>
					</li> <input type="hidden" name="pageNo" id="pageNo" value="1" />


				</form>

				<li>
					<table id="tbList" border="0" cellpadding="0" border="1"
						cellspacing="0" style="margin-left: -100px; width: 100%;">
						<tr style="background-color: rgba(255, 102, 0, .8); height: 30px;"
							id="header_order">
							<td align="center" style="color: #fff;" class="font_b2"><strong>社团号</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>社团名</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>社长名</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>简介</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>操作</strong></td>
						</tr>
						<c:forEach var="club" items="${clubList }" varStatus="status">
							<tr>
								<td><span>${club.clubId }</span></td>
								<td><span>${club.clubName }</span></td>
								<td><span>${club.name}</span></td>
								<td><span>${club.clubBrief}</span></td>
								<td><span><a
										href="${pageContext.request.contextPath }/club/modifyClub?id=${club.clubId}"><img
											src="${pageContext.request.contextPath }/statics/img/xiugai.png"
											alt="修改" title="修改" /></a></span> <span><a
										href="${pageContext.request.contextPath }/club/removeClub?id=${club.clubId}"><img
											src="${pageContext.request.contextPath }/statics/img/schu.png"
											alt="删除" title="删除" onclick="javascript:return del();"/></a></span></td>
							</tr>
						</c:forEach>
					</table>
					<div class="page-bar">
						<ul class="page-num-ul clearfix">
							<li>共${totalSize}条记录&nbsp;&nbsp; ${pageNo}/${totalPage}页</li>
							<c:if test="${pageNo>1}">
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
			</ul> 
		<script type="text/javascript">
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

