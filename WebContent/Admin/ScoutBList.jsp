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
/* 
#subTitle tr th {background-color: #DEDEDE;}
#subTitle tr:nth-child(6) td {
	color:red;
	font-weight: bold;
	} */
#subTitle tr th {background-color: #DEDEDE;height:40pt;font-size: 20pt;}
#subTitle #col{height:40pt;text-align:center;}
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

#demerits {
	padding-top: 5px;
	width: 750px;
	height: 25px;
	margin: 10px auto;
	border: 1px solid gray;	
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


#tblList3 {
	border: 1px solid gray;
	border-collapse: collapse;
	text-align: center;
	width: 700px;
}

#tblList3 tr th{
	background-color: #DEDEDE;
	height: 40px;	
	}


#tblList3 tr td{ padding-top: 5px;}

#tblList4 {
	border: 1px solid gray;
	border-collapse: collapse;
	text-align: center;
	width: 700px;
}

#tblList4 tr th{
	background-color: #DEDEDE;
	height: 40px;	
	}

#tblList4 tr td{padding-top: 5px;}

#tblList5 {
	border: 1px solid gray;
	border-collapse: collapse;
	text-align: center;
	width: 700px;
}

#tblList5 tr th{
	background-color: #DEDEDE;
	height: 40px;	
	}

#tblList5 tr td{padding-top: 5px;}

#scoutBnt{	
	margin-left: 310px;
	margin-top: 3px;
	height: 25px;
	}
#form1 {
	float: left;
}
#form2 {
	float:right;
	margin-right: 45px;
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
	
	
	//팀이름 탭제어
	function fsel(n) {
		sel = n;
		
		var prSalary = document.getElementById("prSalary");
		var val = prSalary.value;
		
		location.href = "/KHBaseball/Admin/ScoutBList.do?teamdemerit=${teamdemerit}&team=" + n + "&prSalary=" + val;
	}
	
	 //영입하기
	 function check() {
		 var prSalary = document.getElementById("prSalary");
		 var teamdemerit = document.getElementById("teamdemerit");
		 	
		 document.getElementById("teamdemerit2").value = teamdemerit.value;	
		 document.getElementById("team2").value = ${team};	
		 document.getElementById("prSalary2").value = prSalary.value;
		 
		 document.getElementById("scoutForm").submit();
			
	} 
	 
	 //투수 타자별 페이지 나누기
	 function send(teamdemerit) {
		 
		 if (teamdemerit.value != 0) {
			 if (teamdemerit.selectedIndex == 1) {
		 		location.href = "/KHBaseball/Admin/ScoutList.do?teamdemerit=" + teamdemerit.value;
			 } else {
				 location.href = "/KHBaseball/Admin/ScoutBList.do?teamdemerit=" + teamdemerit.value;
			 }
		 }
	 }
	 
	//연봉으로 다시 나누기
	 function selPrSalary(prSalary) {
		 if (prSalary.value != "salary1") { 
		     var teamdemerit = document.getElementById("teamdemerit");
			 var val = prSalary.value;
			 location.href = "/KHBaseball/Admin/ScoutBList.do?teamdemerit=" + teamdemerit.value + "&team=${team}&prSalary=" + val;
		 }
	 }
	
</script>
<link rel="stylesheet" href="../css/main.css" type="text/css" />
</head>
<body >
	<div id="bg" >
		<div class="wrap">

			<!-- menu -->
			<%@include file="../Menu.jsp"%>

			<!-- main -->
			<div id="main">
				</br> </br> </br> </br> </br>
				<table id="subTitle" border="1px solid gray">

               <tr>
                  <th>&nbsp;관리자메뉴</th>
               </tr>
               <tr>
                  <td>&nbsp;<a style="color:black;"href="/KHBaseball/Admin/Compare.do?teamId=${teamId}">선수 관리</a></td>
               </tr>
               <tr>
                  <td>&nbsp;&nbsp;<a style="color:black;" href="/KHBaseball/Admin/Compare.do?teamId=${teamId}">- 선수 비교</a></td>
               </tr>
               <tr>
                  <td>&nbsp;&nbsp;<a style="color:black;"href="/KHBaseball/Admin/TeamCompare.do?teamId=${teamId}">- 팀 전력 비교</a></td>
               </tr>
               <tr>
                  <td>&nbsp;<a style="color:black;" href="/KHBaseball/Admin/RecomLineUp.do?teamId=${teamId}">선발 라인업 추천</a></td>
               </tr>
               <tr>
                  <td>&nbsp;<a style="color:red;" href="/KHBaseball/Admin/ScoutList.do?teamId=${teamId}">영입 추천</a></td>
               </tr>
               <tr>
                  <td>&nbsp;<a style="color:black;" href="/KHBaseball/Admin/RemoveList.do?teamId=${teamId}">방출 추천</a></td>
               </tr>

            </table>

				<div id="mainContent">
					<div id="flow"><p margin ="10px">Home > 관리자메뉴 > 영입추천</p></div>
					<div id="demerits">
						<form name="form1" id="form1">
							<a> &nbsp;팀단점 : </a>
							<select name = "teamdemerit" id="teamdemerit" onchange="send(this);">
							<option value="0">==팀단점==</option>
							
							<c:forEach items="${selList}" var="selItem">
							<c:if test="${teamdemerit == selItem}">
								<option value="${selItem}" selected="selected">${selItem}</option>
							</c:if>
							<c:if test="${teamdemerit != selItem}">
								<option value="${selItem}">${selItem}</option>
							</c:if>
							</c:forEach>
							
							</select>							
						</form>
						<form name="form2" id="form2">
							<select name="prSalary" id ="prSalary" onchange="selPrSalary(this);" >
								<option value="salary1" selected="selected">==연봉==</option>
								<option value="1hm">1억 미만</option>
								<option value="13hm">1억~3억</option>
								<option value="3hm">3억 초과</option>
							</select>
						</form>
					</div>
					<div id="tabs">
						<ul>
							<li onclick="fsel(1);" id="tab1"><a href="#tabs-1">L G</a></li>
							<li onclick="fsel(2);" id="tab2"><a href="#tabs-2">롯데</a></li>
							<li onclick="fsel(3);" id="tab3"><a href="#tabs-3">두산</a></li>
							<li onclick="fsel(4);" id="tab4"><a href="#tabs-4">S K</a></li>
							<li onclick="fsel(5);" id="tab5"><a href="#tabs-5">무소속</a></li>
							<li><input type="button" value="  영입하기  "  id= "scoutBnt" onclick="check();" /></li>
						</ul>
						
						<form method="GET" id="scoutForm" name="scoutForm" action="/KHBaseball/Admin/ScoutB.do">
						<input type="hidden" name="teamdemerit2" id="teamdemerit2" />
						<input type="hidden" name="team2" id="team2" />
						<input type="hidden" name="prSalary2" id="prSalary2"/>
						
						<!-- LG 타자 영입 추천 리스트 -->
						<div id="tabs-1">
							<table id="tblList1">
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
						
						<!-- 롯데 타자 영입 추천 리스트 -->
						
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
						
						
						<!-- 두산 타자 영입 추천 리스트 -->
						
						<div id="tabs-3">
							<table id="tblList3">
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
						
						<!-- SK 타자 영입 추천 리스트 -->
						
						<div id="tabs-4">
							<table id="tblList4">
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
						
						<!-- 무소속 영입 추천 리스트 -->
						
						<div id="tabs-5">
							<table id="tblList5">
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
						
						</form>

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
	
			
		$("#tabs").tabs({ active: ${team-1} , disabled : [${hteam-1}]});
	
		<c:if test="${empty teamdemerit}">
			$("#teamdemerit").val("0");
		</c:if>
	
		<c:if test="${!empty teamdemerit}">
			$("#teamdemerit").val("${teamdemerit}");
		</c:if>
		
		
		<c:if test="${empty prSalary}">
		$("#prSalary").val("salary1");
		</c:if>
	
		<c:if test="${!empty prSalary}">
			$("#prSalary").val("${prSalary}");
		</c:if>
		
		
	//-->
	</script>
</body>
</html>