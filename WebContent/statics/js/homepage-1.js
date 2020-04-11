 function ClickTip(type, event) { }
		    $(function () {
		        $(".menu").hover(
		              function () {
		                  $(this).find(".imgplay").attr("src", "${pageContext.request.contextPath }/statics/images/play1.png");
		              },
		              function () {
		                  $(this).find(".imgplay").attr("src", "${pageContext.request.contextPath }/statics/images/play.png");
		              }
		        );
		        $("#slgg").click(function () {
		            $("#imggg").attr("src", "WEB-INF/statics/img/logo/neirong3.gif");
		            $("#tbgg").show();
		            $("#tbst").hide();
		            $("#slsrc").attr("href", "/chronicle/Notice")
		        });
		
		        $("#slxw").click(function () {
		            $("#imggg").attr("src", "${pageContext.request.contextPath }/statics/img/logo/neirong4.gif");
		            $("#tbgg").hide();
		            $("#tbst").show();
		            $("#slsrc").attr("href", "/club/clubnews")
		        });
		    })