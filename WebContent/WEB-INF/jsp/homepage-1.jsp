<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/f-head.jsp"%>
<%@include file="/WEB-INF/jsp/common/lunbo.jsp"%>
<div class="container-fluid"
	style="height: 600px; width: 1000px; background: #FFFFFF; margin-left: 145px;">
	<div class="container left" style="height: 400px; width: 30%;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<td width="272"><img
				src="${pageContext.request.contextPath }/statics/img/logo/neirong1.gif"
				width="272" height="44" usemap="#Map2" /> <map name="Map2"
					id="Map2">
					<area shape="rect" coords="229,15,270,37" href="/eventvideo"
						onclick="ClickTip(this,event)" onfocus="this.blur() " />
				</map></td>
			<tr>
				<td><a target="_blank" href="/eventVideo/videoplay?newsid=2741">
						<div class="menu"
							style="width: 272px; height: 153px; background: url(upload/news/2015-12-10/2e2ab0c8-fb5e-4b2e-a012-2f1641039b65.png); background-size: 272px 153px; filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='upload/news/2015-12-10/2e2ab0c8-fb5e-4b2e-a012-2f1641039b65.png', sizingmethod='scale');">
							<img
								src="${pageContext.request.contextPath }/statics/img/corporation/timg (7).jpg"
								style="width: 275px; height: 150px" />
							<!--class="imgplay"-->
							<div>厦门工学院学生社团2014-2015学年回顾</div>
						</div>
				</a></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><a target="_blank" href="/eventVideo/videoplay?newsid=132">
						<div class="menu"
							style="width: 272px; height: 153px; background: url(upload/news/2015-12-10/db662267-e9c9-4e91-92c8-97d4718273e8.png); background-size: 272px 153px; filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='upload/news/2015-12-10/db662267-e9c9-4e91-92c8-97d4718273e8.png', sizingmethod='scale');">
							<img
								src="${pageContext.request.contextPath }/statics/img/corporation/lh02.jpg"
								style="width: 275px; height: 150px" />
							<div>厦门工学院学生社团联合会宣传片</div>
						</div>
				</a></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><img
					src="${pageContext.request.contextPath }/statics/img/logo/neirong2.gif"
					width="272" height="47" usemap="#Map5" /> <map name="Map5"
						id="Map5">
						<area shape="rect" coords="228,18,270,43" target="_blank"
							href="/home/linklist" onclick="ClickTip(this,event)"
							onfocus="this.blur() " />
					</map></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td align="left" class="font1"><a
								href="http://www.xit.edu.cn" target="_blank">厦门工学院</a> <br /> <a
								href="http://www.xit.edu.cn/tw/" target="_blank">厦门工学院（团委网站）</a>
								<br /> <a href="http://www.xit.edu.cn/xgc/" target="_blank">学工部</a>
								<br /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div class="container right"
		style="height: 400px; width: 70%; margin-top: -10px;">
		<td>&nbsp;</td>
		<td width="703" height="16" valign="bottom"></td> <img
			src="${pageContext.request.contextPath }/statics/img/logo/neirong3.gif"
			id="imggg" width="703" height="29" usemap="#Map3" />
		<map name="Map3" id="Map3">
			<area shape="rect" id="slxw" coords="96,2,183,29"
				href="javascript:void(0)" onclick="ClickTip(this,event)"
				onfocus="this.blur() " />
			<area shape="rect" id="slgg" coords="2,2,87,29"
				href="javascript:void(0)" onclick="ClickTip(this,event)"
				onfocus="this.blur() " />
			<area shape="rect" id="slsrc" coords="656,4,700,25"
				href="/chronicle/Notice" onclick="ClickTip(this,event)"
				onfocus="this.blur() " />
		</map>
		<table width="100%" border="0" id="tbgg" cellspacing="0"
			cellpadding="0" style="margin-left: 30px;">

			<tr>
				<td colspan="2" align="center" class="font4"><a target="_blank"
					style="color: #F70B19" href="/chronicle/newsDetail?newsid=14314">关于学生社团参加2018年厦门工学院学生志愿者暑期文化科技卫生“三下乡”社会实践活动的通知</a></td>
			</tr>
			<tr>
				<td colspan="2" align="left">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;各学院团委、各学生社团：为深入学习贯彻习近平新时代中国特色社会主义思想，按照共青团中央《关于开展2018年全国大中专学生志愿者暑期文化科技卫生“三下乡”社会实践活动的通知》的有关要求，引领教育广大青年学生勇做担当民族复兴大任的时代新人，以实际行动助力精准扶贫，服务乡村振兴战略，切实在感受改革开放...<a
					target="_blank" style="color: #d0000e"
					href="/chronicle/newsDetail?newsid=14314">详细>></a>
				</td>
			</tr>
			<tr>
				<td colspan="2"
					background="${pageContext.request.contextPath }/statics/img/fgx.gif">&nbsp;</td>
			</tr>
			<form method="post"
				action="${pageContext.request.contextPath }/notice/selectNotice"></form>
			<c:forEach var="notice" items="${noticelist}" varStatus="status">

				<tr>
					<td align="left" class="font2" width="87%"><a target="_blank"
						href="#">${notice.title }</a></td>
					<td align="right" width="13%">${notice.formatDate}</td>
				</tr>
			</c:forEach>


		</table>

		</td>
		</tr>
		<table style="width: 100%">
			<tr>
				<td colspan="3" style="border-bottom: solid 1px #F70B19;"><img
					src="${pageContext.request.contextPath }/statics/img/logo/neirong5.gif"
					width="703" height="44" usemap="#Map" /> <map name="Map" id="Map">
						<area shape="rect" coords="651,15,700,37"
							href="/eventvideo/eventList" onclick="ClickTip(this,event)"
							onfocus="this.blur() " />
					</map></td>
			</tr>
		</table>
		<div class="box">
			<dl id="s-event" class="s-event" style="width: 700px;"></dl>
		</div>
	</div>
	<!--内容部分结束-->
</div>
</article>

<%@include file="/WEB-INF/jsp/common/f-foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/homepage-1.js"></script>

