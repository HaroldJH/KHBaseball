<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
	height: 220px;
	border: 1px solid gray;
	border-collapse: collapse;
	float:left;
	margin-top: 100px;
	margin-left: -100px;
}

/* #subTitle tr th {background-color: #DEDEDE;}
#subTitle tr:nth-child(7) td {
	color:red;
	font-weight: bold;
	} */
#subTitle tr th {background-color: #DEDEDE;height:40px;font-size: 20pt;}
#subTitle tr td {font-size: 15pt;height:25px;}
#subTitle #col{height:40px;font-size: 20pt;text-align:center;}
 .cel1{font-size: 15pt;background-color:#F0ECE0;}

/* #subTitle tr:last-child td {color:red;background-color: yellow;} */

#mainContent {
	width: 970px;
	float:left;
	margin-left:20px;
	margin-top: 100px;
	border:1px solid gray;
	
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

.cell0 {padding-left : 10px;}

#tblList1 {
	border: 1px solid gray;
	border-collapse: collapse;
	text-align: center;
	width: 700px;
}

#tblList1 tr th{
	background-color: #DEDEDE;
	height: 40px;	
	}


#tblList1 tr td{ padding-top: 5px;}

#tblList2 {
	border: 1px solid gray;
	border-collapse: collapse;
	text-align: center;
	width: 700px;
}

#tblList2 tr th{
	background-color: #DEDEDE;
	height: 40px;	
	}

#tblList2 tr td{padding-top: 5px;}

#removeBnt{	
	margin-left: 400px;
	margin-top: 3px;
	height: 25px;
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
		$('div.photo a').fancyZoom({
			directory : 'images/zoom',
			scaleImg : true,
			closeOnClick : true
		});
		
		
		
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
	
	 function check() {
		
		if(confirm("정말 방출하시겠습니까?")){
			var playerId;
			
			var max = 0;
			
			if (sel == 1)
				max = ${plist.size()};
			else
				max = ${hlist.size()};
				
		
			
			for (i=1; i<= max; i++) {
				var temp = "";
				
				
				if (sel == 1)
					temp = "ch";
				else
					temp = "hch";
				
			
				
				var c = document.getElementById(temp + i);
				if (c.checked) {
					playerId = c.value;
				}
			}
			
			location.href = "RemoveListDel.do?playerId=" + playerId + "&sel=" + sel;	
		} 
		 
			
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
                  <th id="col1">&nbsp;관리자메뉴</th>
               </tr>
               <tr>
                  <td class="cel1">&nbsp;<a style="color:black;"href="/KHBaseball/Admin/Compare.do?teamId=${teamId}">선수 관리</a></td>
               </tr>
               <tr>
                  <td class="cel1">&nbsp;&nbsp;<a style="color:black;" href="/KHBaseball/Admin/Compare.do?teamId=${teamId}">- 선수 비교</a></td>
               </tr>
               <tr>
                  <td class="cel1">&nbsp;&nbsp;<a style="color:black;"href="/KHBaseball/Admin/TeamCompare.do?teamId=${teamId}">- 팀 전력 비교</a></td>
               </tr>
               <tr>
                  <td class="cel1">&nbsp;<a style="color:black;" href="/KHBaseball/Admin/RecomLineUp.do?teamId=${teamId}">선발 라인업 추천</a></td>
               </tr>
               <tr>
                  <td class="cel1">&nbsp;<a style="color:black;" href="/KHBaseball/Admin/ScoutList.do?teamId=${teamId}">영입 추천</a></td>
               </tr>
               <tr>
                  <td class="cel1">&nbsp;<a style="color:red;" href="/KHBaseball/Admin/RemoveList.do?teamId=${teamId}">방출 추천</a></td>
               </tr>

            </table>

				<div id="mainContent">
					<div id="flow"><p margin ="10px">Home > 관리자메뉴 > 방출추천</p></div>
					
					<div id="tabs">
						<ul>
							<li onclick="fsel(1);" id="tab1"><a href="#tabs-1">투수 리스트</a></li>
							<li onclick="fsel(2);" id="tab2"><a href="#tabs-2">타자 리스트</a></li>
							<li><input type="button" value="  방출하기  "  id= "removeBnt" onclick="check();" /></li>
						</ul>
						
						
						<!-- 투수 방출 추천 리스트 -->
						<div id="tabs-1">
							<table id="tblList1">
								<tr>
									<th id="col0"></th>
									<th id="col1">&nbsp;&nbsp;순위</th>
									<th id="col2">&nbsp;&nbsp;선수명</th>
									<th id="col3">&nbsp;&nbsp;승</th>
									<th id="col4">&nbsp;&nbsp;패</th>
									<th id="col5">&nbsp;&nbsp;세</th>
									<th id="col6">&nbsp;&nbsp;홀드</th>
									<th id="col7">&nbsp;&nbsp;이닝</th>
									<th id="col8">&nbsp;&nbsp;피안타</th>
									<th id="col9">&nbsp;&nbsp;피홈런</th>
									<th id="col10">&nbsp;&nbsp;볼넷</th>
									<th id="col11">&nbsp;&nbsp;탈삼진</th>
									<th id="col12">&nbsp;&nbsp;방어율</th>
									<th id="col13">&nbsp;&nbsp;WHIP</th>
								</tr>

								<c:set var="n" value="1" />
								<c:forEach items="${plist}" var="dto">

								<tr>
									<td class="cell0"><input type="checkbox" id="ch${n}" name="ch" value="${dto.playerId}" /></td>
									<td class="cell1">${n}</td>
									<td class="cell2">${dto.playerName}</td>
									<td class="cell3">${dto.pWin}</td>
									<td class="cell4">${dto.pLose}</td>
									<td class="cell5">${dto.pSave}</td>
									<td class="cell6">${dto.pHold}</td>
									<td class="cell7">${dto.pInning}</td>
									<td class="cell8">${dto.pAnta}</td>
									<td class="cell9">${dto.pHomerun}</td>
									<td class="cell10">${dto.pBallnet}</td>
									<td class="cell11">${dto.pSamjin}</td>
									<td class="cell12">${dto.pBangEo}</td>
									<td class="cell13">${dto.whip}</td>
									
								</tr> 
								<c:set var="n" value="${n+1}" />
								</c:forEach>
							</table>
						</div>
						
						<!-- 타자 방출 추천 리스트 -->
						
						<div id="tabs-2">
						<table id="tblList2">
								<tr>				
									<th id="col0"></th>
									<th id="col1">&nbsp;&nbsp;순위</th>
									<th id="col2">&nbsp;&nbsp;선수명</th>
									<th id="col3">&nbsp;&nbsp;타수</th>
									<th id="col4">&nbsp;&nbsp;안타</th>
									<th id="col5">&nbsp;&nbsp;홈런</th>
									<th id="col6">&nbsp;&nbsp;도루</th>
									<th id="col7">&nbsp;&nbsp;삼진</th>
									<th id="col8">&nbsp;&nbsp;볼넷</th>
									<th id="col9">&nbsp;&nbsp;타율</th>
									<th id="col10">&nbsp;&nbsp;출루율</th>
									<th id="col11">&nbsp;&nbsp;장타율</th>
									<th id="col12">&nbsp;&nbsp;ops</th>
									<th id="col13">&nbsp;&nbsp;실책</th>
								</tr>

								<c:set var="n" value="1" />
								<c:forEach items="${hlist}" var="dto">

								<tr>					
									<td class="cell0"><input type="checkbox" id="hch${n}" name="hch" value="${dto.playerId}" /></td>									
									<td class="cell1">${n}</td>
									<td class="cell2">${dto.playerName}</td>
									<td class="cell3">${dto.atBat}</td>
									<td class="cell4">${dto.hits}</td>
									<td class="cell5">${dto.homeRun}</td>
									<td class="cell6">${dto.still}</td>
									<td class="cell7">${dto.samJin}</td>
									<td class="cell8">${dto.fourBall}</td>
									<td class="cell9">${dto.battingAverage}</td>
									<td class="cell10">${dto.onBase}</td>
									<td class="cell11">${dto.slugging}</td>
									<td class="cell12">${dto.ops}</td>
									<td class="cell13">${dto.error}</td>
									
								</tr> 
								<c:set var="n" value="${n+1}" />
								</c:forEach>
							</table>
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
		if ("${sel}" != "1") {
			$("#tabs").tabs({ active: 0 });
		} else {
			$("#tabs").tabs({ active: 1 });
		}
	//-->
	</script>
</body>
</html>