<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KH 야구 프로젝트</title>
<link rel="stylesheet" href="../assets/css/styles.css" />
<link rel="stylesheet" href="../css/main.css" type="text/css" />

<style type="text/css">
#subTitle {
	width: 150px;
	height:130px;
	border: 1px solid gray;
	border-collapse: collapse;
	float:left;
	margin-top: 100px;
	margin-left: -100px;
}
#subTitle tr th {background-color: #DEDEDE; height:20px;font-size: 20pt;}
#subTitle tr td {font-size: 15pt;height:25px;}
#subTitle #col{height:40px;font-size: 20pt;text-align:center;}
 .cel1{font-size: 15pt;background-color:#F0ECE0;}

#mainContent {
	width: 970px;
	float:left;
	margin-left:20px;
	margin-top: 100px;
	border:1px solid gray;
	
}

#mainContent #flow {
	width: 100%;
	background-color: #DEDEDE;
	text-align: right;
	height: 30px;
	font-size: 15px;
	text-align: right;
	
}

#mainContent #bbb {
	margin: 10px;
	border: 1px solid gray;
}


#tabs {
	width: 750px;
	margin: 10px auto;
}

#img1{width:150px;height:150px;}


</style>

<script type="text/javascript" src="../js/jquery-1.4.1.min.js"></script>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/slideshow.js"></script>
<script type="text/javascript" src="../js/cufon-yui.js"></script>
<!-- <script type="text/javascript" src="js/Arial.font.js"></script> -->

<!-- Including the Lobster font from Google's Font Directory -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Lobster" />

<!-- Enabling HTML5 support for Internet Explorer -->
<!--[if lt IE 9]>
     <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
     <![endif]-->

<script type="text/javascript">
	Cufon.replace('h1,h2,h3,h4,h5,#menu,#copy,.blog-date');
</script>
<script type="text/javascript" src="../js/fancyzoom.min.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$('div.photo a').fancyZoom({
			directory : 'images/zoom',
			scaleImg : true,
			closeOnClick : true
		});
	});
</script>
<link rel="stylesheet" href="../css/main.css" type="text/css" />
</head>
<body >
	<div id="bg" >
		<div class="wrap" >

			<!-- menu -->
			<%@include file="../Menu.jsp"%>

			<!-- main -->
			<div id="main">
				</br> </br> </br> </br> </br>
				<table id="subTitle" border="1px solid gray">

					<tr>
                  <th id="col">&nbsp;일정/결과 메뉴</th>
               </tr>
               <tr>
                  <td class="cel1"><a href="/KHBaseball/cast/playSchedule.do">&nbsp;<span style="color:red;weight:bold;">경기 일정</span></a></td>
               </tr>
               <tr>
                  <td class="cel1"><a href="/KHBaseball/cast/cast.do">&nbsp;중계</a></td>
               </tr>

				</table>

				<div id="mainContent">
					<div id="flow">Home > 일정/결과 > 중계</div>
					
					<table>
				<c:forEach items="${schedule}" var="dto">
				<tr>
					<td rowspan="2"></td>
				</tr>
				<tr class="date">
					<td><span style="margin-bottom: 20px;font-size:20pt;weight:bold;">${dto.playDate }<br /></span></td>
					<td><img src = "../images/${dto.awayTeamId }.jpg" id="img1"><span style="font-size:30pt;"><img src="../images/vs.png" style="width:60px;height:60px;margin-top:20px;margin-bottom: 20px;" /></span><img src = "../images/${dto.homeTeamId }.jpg"  id="img1"> <%-- <c:if test="${dto.status == '1'} ">기록</c:if> <c:if test="${dto.status == '0'} "> --%><a href="./Cast.do?hid=${dto.historyId }" style="font-size: 20pt;">중계</a><img src="../images/click2.png" alt="" style="width:90px;height:40px;"/></td>
					
				</tr>
			</c:forEach>
			
			</table>
			
					
					
				</div>


			</div>


			<!-- /main -->

			<!-- side -->
			<div id="side"></div>
			<!-- /side -->
		</div>

		<!-- footer -->
		<div id="footer">
			<div id="footerbg">
				<div class="wrap">

					<!-- footer links -->
					<p id="footer_menu">
						<a href="#">Jobs @ corporattica</a> <a href="#">Press Releases</a>
						<a href="#">Terms and Conditions</a>

						<!-- credit link -->
						<a href="http://www.solucija.com" title="Free CSS Templates">Solucija</a>
					</p>
					<!-- /footer links -->

					<p id="copy">
						corporattica <span>professional approach</span>
					</p>

					<div class="clear"></div>
				</div>
			</div>
		</div>
		<!-- /footer -->

	</div>


	<script type="text/javascript">
	<!--
		$("#tabs").tabs();
	//-->
	</script>
</body>
</html>