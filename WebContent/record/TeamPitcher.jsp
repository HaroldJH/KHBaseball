<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
	height: 130px;
	border: 1px solid gray;
	border-collapse: collapse;
	float: left;
	margin-top: 100px;
	margin-left: -100px;
}
#subTitle tr th {background-color: #DEDEDE;height:40px;font-size: 20pt;}
#subTitle tr td {font-size: 15pt;height:25px;}
#subTitle #col{height:40px;font-size: 20pt;text-align:center;}
 .cel1{font-size: 15pt;background-color:#F0ECE0;}

#subTitle tr:nth-child(7) td {
	color: red;
	font-weight: bold;
}
/* #subTitle tr:last-child td {color:red;background-color: yellow;} */
#mainContent {
	width: 970px;
	float: left;
	margin-left: 20px;
	margin-top: 100px;
	border: 1px solid gray;
}

#flow {
	width: 100%;
	background-color: #DEDEDE;
	text-align: right;
	height: 30px;
	font-size: 15px;
	font-weight: bold;
	text-align: right;
}

#tabs {
	width: 750px;
	margin: 10px auto;
}

.cell0 {
	padding-left: 10px;
}

#tblList1 {
	border: 1px solid gray;
	border-collapse: collapse;
	text-align: center;
	width: 700px;
}

#tblList1 tr th {
	background-color: #DEDEDE;
	height: 40px;
}

#tblList1 tr td {
	padding-top: 5px;
}

#tblList2 {
	border: 1px solid gray;
	border-collapse: collapse;
	text-align: center;
	width: 700px;
}

#tblList2 tr th {
	background-color: #DEDEDE;
	height: 40px;
}

#tblList2 tr td {
	padding-top: 5px;
}

#removeBnt {
	margin-left: 400px;
	margin-top: 3px;
	height: 25px;
}

#arrow {
	width: 30px;
	height: 20px;
}

#batter {
	width: 80px;
	height: 60px;
}
#a{
	text-align:center;
}
.p{
	text-align:center;
}
#Battertbl{
	margin-left:50px;
}
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

	});
	
	
	<% if (request.getParameter("sel") != null) {
		if (request.getParameter("sel").equals("1")) {%>
	var sel = 1;
	<% } else { %>
	var sel = 2;
	
	<%}} else { %>

	var sel = 1;
	<% } %>
	
	
	function fsel(n) {
		sel = n;
	}
	
	
	
</script>
<link rel="stylesheet" href="../css/main.css" type="text/css" />
</head>
<body >
	<div id="bg">
		<div class="wrap" >

			<!-- menu -->
			<%@include file="../Menu.jsp"%>

			<!-- main -->
			<div id="main">
				</br> </br> </br> </br> </br>
				<table id="subTitle" border="1px solid gray">

					<tr>
                  <th id="col"><a href="/KHBaseball/record/BatterRecord.do">&nbsp;기록</a></th>
               </tr>
               <tr>
                  <td class="cel1"><a href="/KHBaseball/record/BatterRecord.do">&nbsp;-선수 기록</a></td>
               </tr>
               <tr>
                  <td class="cel1"><a href="/KHBaseball/record/Teambatter.do"> &nbsp;&nbsp;-팀 기록</a></td>
               </tr>
				</table>

				<div id="mainContent">
					<div id="flow">
						<p margin="10px">Home > 기록 >팀 투구 순위</p>
					</div>

					<div id="tabs">
						<ul>
							<li onclick="fsel(1);" id="tab1"><a href="#tabs-1" onclick="location.href='/KHBaseball/record/Teambatter.do'">팀 타격 순위</a></li>
							<li onclick="fsel(2);" id="tab2"><a href="#tabs-2" onclick="location.href='/KHBaseball/record/TeamPitcher.do'">팀 투구 순위</a></li>
						</ul>



						<div id="tabs-1">
							<form id="BatterRecord">
								<table id="Battertbl">
									<tr>
									<tr>
										<th>팀 평균 타점</th>
										<td><img src="/KHBaseball/images/arrow.jpg" alt="타율"
											id="arrow" /></td><% int a = 1; %>
										<td><c:forEach items="${teamrbi}" var="teamrbi">
										<th style="width:23px;"><%=a %>등</th>
												<td class="p"><a href="#"><img src="../images/${teamrbi.TeamName }.jpg"
													alt="홈런" id="batter" /></a>
													<br />${teamrbi.teamrbi}<br />${teamrbi.teamName}</td>
											<% ++a; %>
											</c:forEach></td>
									</tr>
									<tr>
										<th>팀 평균 타율</th>
										<td><img src="/KHBaseball/images/arrow.jpg" alt="타율"
											id="arrow" /></td><% int p = 1; %>
										<td>
										 <c:forEach items="${bta}" var="b">
										<th style="width:23px;"><%=p %>등</th>
												<td class="p"><a href="#"><img src="../images/${b.playerName }.jpg"
													alt="홈런" id="batter" /></a><br />
												<br />${b.battingaverage }<br />${b.playerName }<br />${b.teamName}</td>
											<% ++p; %>
											</c:forEach>
									</tr>

									<tr>
										<th>팀 평균 안타</th>
										<td><img src="/KHBaseball/images/arrow.jpg" alt="타율"
											id="arrow" /></td><% int b = 1; %>
										<td><c:forEach items="${hits}" var="hits">
										<th style="width:23px;"><%=b %>등</th>
												<td class="p"><a href="#"><img src="../images/${hits.playerName }.jpg"
													alt="홈런" id="batter" /></a>
												<br />${hits.hits}<br />${hits.playerName }<br />${hits.teamName}</td>
											<% ++b; %>
											</c:forEach>
									</tr>

									<tr>
										<th>팀 평균 득점</th>
										<td><img src="/KHBaseball/images/arrow.jpg" alt="타율"
											id="arrow" /></td><% int c = 1; %>
										<td><c:forEach items="${score }" var="score">
										<th style="width:23px;"><%=c %>등</th>
												<td class="p"><a href="#"><img src="../images/${score.playerName }.jpg"
													alt="홈런" id="batter" /></a>
												<hr />${score.score}<br />${score.playerName }<br />${score.teamName}</td>
											<% ++c; %>
											</c:forEach>
									</tr>



								<tr>
										<th>팀 평균 출루율</th>
										<td><img src="/KHBaseball/images/arrow.jpg" alt="타율"
											id="arrow" /></td><% int d = 1; %>
										<td id="p"><c:forEach items="${teamonbase }" var="teamonbase">
										<th style="width:23px;"><%=d %>등</th>
												<td class="p"><a href="#"><img
													src="../images/${teamonbase.teamName }.jpg" alt="홈런"
													id="batter" /></a>
												<br />${teamonbase.rnum}<br />${teamonbase.onbase}<br />${teamonbase.teamName}</td>
											<% ++d; %>
											</c:forEach>
									</tr>



									<tr>
										<th>팀 평균 장타율</th>
										<td><img src="/KHBaseball/images/arrow.jpg" alt="타율"
											id="arrow" /></td><% int e = 1; %>
										<td><c:forEach items="${slugging }" var="slugging">
										<th style="width:23px;"><%=e %>등</th>
												<td class="p"><a href="#"><img
													src="../images/${slugging.playerName }.jpg" alt="홈런"
													id="batter" /></a>
												<br />${slugging.slugging}<br />${slugging.playerName }<br />${slugging.teamName}</td>
												<% ++e; %>
											</c:forEach>
									</tr>



								</table>
							</form>
						</div>



						<div id="tabs-2">
							<form id="PitcherRecord">
								<table id="Pitchertbl">
									<tr>
									<tr>
										<th>팀 평균 방어율</th>
										<td><img src="/KHBaseball/images/arrow.jpg" alt="타율"
											id="arrow" /></td><% int f = 1; %>
										<td><c:forEach items="${teampbangeo}" var="teampbangeo">
										<th style="width:23px;"><%=f %>등</th>
												<td class="p"><a href="#"><img
													src="../images/${teampbangeo.teamName }.jpg" alt="홈런"id="pitcher" /></a>
													<br />${teampbangeo.teamPBangEo}
													<br />${teampbangeo.teamName}</td>
											<% ++f; %>
											</c:forEach></td>
									</tr>

									<tr>
										<th>팀 평균 세이브</th>
										<td><img src="/KHBaseball/images/arrow.jpg" alt="타율"
											id="arrow" /></td><% int g = 1; %>
										<td><c:forEach items="${teampsave}" var="teampsave">
										<th style="width:23px;"><%=g %>등</th>
												<td class="p"><a href="#"><img src="../images/${teampsave.teamName }.jpg"
													alt="홈런" id="pitcher" /></a> <br />
													${teampsave.teamPsave}<br />${teampsave.teamName}</td>
											<% ++g; %>
											</c:forEach></td>
											</tr>
											
									<tr>
										<th>팀 평균 탈삼진</th>
										<td><img src="/KHBaseball/images/arrow.jpg" alt="타율"
											id="arrow" /></td><% int h = 1; %>

										<td><c:forEach items="${teampsamjin}" var="teamPsamjin">
										<th style="width:23px;"><%=h %>등</th>
												<td class="p"><a href="#"><img
													src="../images/${teamPsamjin.teamName }.jpg" alt="홈런"
													id="pitcher" /></a><br />${teamPsamjin.teamPsamjin}<br />${teamPsamjin.teamName}
												</td>
												<% ++h; %>
											</c:forEach>
									</tr>

								</table>
							</form>


						</div>

					</div>
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


	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.10.4/themes/flick/jquery-ui.css">
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script type="text/javascript">
	<!--
			
			$("#tabs").tabs({ active: 1 });
		
	//-->
	</script>
</body>
</html>