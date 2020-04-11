<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/b-head.jsp"%>
<article>
	<tr>
		<td align="center">
			<ul class="select">
				<form method="post"
					action="${pageContext.request.contextPath }/notice/backNoticelist">
					<input name="method" value="query" class="input-text" type="hidden">

					<li class="select-list">
						<dl id="select3">
							<dt>公告号：：</dt>
							<dd>
								<input name="id" class="input-text" type="number" value="${id}" />
								<button type="submit">确认</button>
							</dd>
						</dl>
					</li>
					<li class="select-list">
						<dl id="select4">
							<dt>标题：</dt>
							<dd>
								<input name="title" class="input-text" type="text"
									value="${title}" />
								<button type="submit">确认</button>
							</dd>
							<a href="${pageContext.request.contextPath}/b-noticeadd"><img
								src="${pageContext.request.contextPath }/statics/img/addNotice.jpg"
								alt="添加公告" title="添加公告" /></a>
						</dl>
					</li> <input type="hidden" name="pageNo" id="pageNo" value="1" />


				</form>

				<li>
					<table id="tbList" border="0" cellpadding="0" border="1"
						cellspacing="0" style="margin-left: -100px; width: 100%;">
						<tr style="background-color: rgba(255, 102, 0, .8); height: 30px;"
							id="header_order">
							<td align="center" style="color: #fff;" class="font_b2"><strong>公告号</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>标题</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>发布日期</strong></td>
							<td align="center" style="color: #fff;" class="font_b2"><strong>操作</strong></td>
						</tr>
						<c:forEach var="notice" items="${noticelist }" varStatus="status">
							<tr>
								<td><span>${notice.id }</span></td>
								<td><span>${notice.title }</span></td>
								<td><span>${notice.formatDate }</span></td>
								<td><span><a
										href="${pageContext.request.contextPath }/notice/modifyNotice?id=${notice.id}"><img
											src="${pageContext.request.contextPath }/statics/img/xiugai.png"
											alt="修改" title="修改" /></a></span> <span><a
										href="${pageContext.request.contextPath }/notice/removeNotice?id=${notice.id}"><img
											src="${pageContext.request.contextPath }/statics/img/schu.png"
											alt="删除" title="删除" /></a></span></td>
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
		</script>
</article>

<%@include file="/WEB-INF/jsp/common/f-foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/clublist.js"></script>

