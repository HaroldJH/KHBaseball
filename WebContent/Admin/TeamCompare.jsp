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
 */
#subTitle tr th {background-color: #DEDEDE;height:40px;font-size: 20pt;}
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
#tblForm{
	text-align: center;
	width: 350px; hegiht:500px;
	border: 1px solid gray;
	border-collapse: collapse;
	margin: 10px auto;
}
#tblForm tr {
	height: 27px;
}
#tblForm tr th {
	border: 0px;
	height: 41px;
	padding-top: 2px;
	border: 1px solid #486499;
	background: #3f5787;
	color: #fff;
	font-size: 20px;
	text-align: center;
}

#tblForm tr td {
/* 	border: 1px solid gray; */

	background: #26385c;
	color: #9ec7fd;
	font-size: 16px;
	font-weight: bold;
}
#tblForm tr:nth-child(2){
	border-top: 1px solid #1c2b4a;
	color: #fff;
}
#leftDiv, #rightDiv {
	width:290px;height:200px;
	margin:10px auto; 
	border:1px solid black;
}

#centerDiv{
	width:380px;height:200px;
	margin:10px auto; 
	border:1px solid black;
}

.wingTbl { 
	width: 280px;
	margin: 10px auto;
	border: 1px solid gray;
	border-collapse: collapse;
}
.wingTbl tr td{
	border: 1px solid gray;
	text-align: center;
}
.wingTbl tr:FIRST-CHILD{
	background-color: #1c2b4a;
	color: #fff;
}
.long {
	width: 55px;
	color: #6e6e6e;
	font-size: 9pt;
	font-weight: normal;
	letter-spacing: -1px;
}
.short {
	font-size: 9pt;
	font-weight: bold;
	width:25px;
}
.wingTbl tr {
	height: 30px;
}






#subTitle {
   width: 150px;
   height: 220px;
   border: 1px solid gray;
   border-collapse: collapse;
   float:left;
   margin-top: 100px;
   margin-left: -100px;
}

#subTitle tr th {background-color: #DEDEDE;}

#mainContent {
   width: 970px;
   height: 780px;
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
.tblForm{
	text-align: center;
	width: 350px; hegiht:330px;
	border: 1px solid gray;
	border-collapse: collapse;
	margin: 10px auto;
}
.tblForm tr {
	height: 23px;
}
.tblForm tr th {
	border: 0px;
	height: 41px;
	padding-top: 2px;
	border: 1px solid #486499;
	background: #3f5787;
	color: #fff;
	font-size: 19px;
	text-align: center;
}

.tblForm tr td {
/* 	border: 1px solid gray; */

	background: #26385c;
	color: #9ec7fd;
	font-size: 16px;
	font-weight: bold;
}
.tblForm tr:nth-child(2){
	border-top: 1px solid #1c2b4a;
	color: #fff;
}
#leftDiv, #rightDiv {
	width:290px;height:610px;
	margin:10px auto; 
	border:0px solid black;
}

#centerDiv{
	width:380px;height:650px;
	margin:10px auto; 
	border-right:1px solid gray;
	border-left: 1px solid gray;
}

.wingTbl { 
	width: 280px;
	margin: 20px auto;
	border: 1px solid gray;
	border-collapse: collapse;
} 
.wingTbl tr td{
	border: 1px solid gray;
	text-align: center;
}
.wingTbl tr:FIRST-CHILD{
	background-color: #1c2b4a;
	color: #fff;
}
.long {
	width: 55px;
	color: #6e6e6e;
	font-size: 9pt;
	font-weight: normal;
	letter-spacing: -1px;
}
.short {
	font-size: 9pt;
	font-weight: bold;
	width:25px;
}
.wingTbl tr {
	height: 24px;
}

#subTbl{
	border: 1px solid gray;
	border-collapse: collapse;
	width: 280px; height:150px;
	margin: 10px auto;
}
#subTbl tr td{
	border: 1px solid gray;
	text-align: center;
}
#subTbl tr { height: 25px; }
#subTbl tr:FIRST-CHILD{
	background-color: #1c2b4a;
	color: #fff;
	height: 30px;
}
#subTbl tr:nth-child(2) { background-color: #BDBDBD; }
#LotteName {
	color:#344f94;
	font-weight: bold;
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
<link rel="stylesheet" href="../css/main.css" type="text/css" />

<script type="text/javascript">

	function LineUp(n) {
		
		cw=400;
		 ch=300;
		
		sw=screen.availWidth;
		sh=screen.availHeight;
		
		px=(sw-cw)/1.1;
		py=(sh-ch)/2.3;
		
		window.open("LineUp.do?n="+n, n+" 라인업",
				'left='+px+',top='+py+',resizable=yes, scrollbars=yes, width=400, height=300');
	}
</script>
</head>
<body>
   <div id="bg" >
      <div class="wrap">

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
                  <td class="cel1">&nbsp;<a style="color:red;"href="/KHBaseball/Admin/Compare.do?teamId=${teamId}">선수 관리</a></td>
               </tr>
               <tr>
                  <td class="cel1">&nbsp;&nbsp;<a style="color:black;" href="/KHBaseball/Admin/Compare.do?teamId=${teamId}">- 선수 비교</a></td>
               </tr>
               <tr>
                  <td class="cel1">&nbsp;&nbsp;<a style="color:red;"href="/KHBaseball/Admin/TeamCompare.do?teamId=${teamId}">- 팀 전력 비교</a></td>
               </tr>
               <tr>
                  <td class="cel1">&nbsp;<a style="color:black;" href="/KHBaseball/Admin/RecomLineUp.do?teamId=${teamId}">선발 라인업 추천</a></td>
               </tr>
               <tr>
                  <td class="cel1">&nbsp;<a style="color:black;" href="/KHBaseball/Admin/ScoutList.do?teamId=${teamId}">영입 추천</a></td>
               </tr>
               <tr>
                  <td class="cel1">&nbsp;<a style="color:black;" href="/KHBaseball/Admin/RemoveList.do?teamId=${teamId}">방출 추천</a></td>
               </tr>

            </table>

            <div id="mainContent">
               <div id="flow">Home > 관리자메뉴 > 라인업 추천</div>
               
              <div id="leftDiv" class="wingDiv" style="float:left;">
               		<table id="leftTbl" class="wingTbl" style="margin-bottom:40px;">
               			<tr>
               				<td colspan="5">
               				${team2.teamName} 선발 투수</td>
               				
               			</tr>
               			<tr>
               				<td rowspan="4" style="width:100px;">
               				<img style="width:100px;" src="../images/face/${pitcher2.playerName}.jpg" />
               				</td>
               				<td colspan="4" style="font-size:16pt;color:#344f94;font-weight:bold">
               				${pitcher2.playerName}
               				</td>
               			</tr>
               			<tr>
               				<td class="long">방어율</td>
               				<td class="short">${pitcher2.pBangEo}</td>
               				<td class="long">탈삼진</td>
               				<td class="short">${pitcher2.pSamjin}</td>
               			</tr>
               			<tr>
               				<td class="long">피안타</td>
               				<td class="short">${pitcher2.pAnta}</td>
               				<td class="long">피홈런</td>
               				<td class="short">${pitcher2.pHomerun}</td>
               			</tr>
               			<tr>
               				<td class="long">평균 자책</td>
               				<td class="short">${pitcher2.pJacheck}</td>
               				<td class="long">홀드</td>
               				<td class="short">${pitcher2.pHold}</td>
               			</tr>
               		</table>
               		
               		<hr />
               		<table class="subTbl" id="subTbl">
               		<tr>
               			<th colspan="7">${team2.teamName} 타자 라인업</th>
               		</tr>
               		<tr>
               			<th>타순</th>
               			<th>이름</th>
               			<th>타율</th>
               			<th>홈런</th>
               			<th>장타</th>
               			<th>안타</th>
               			<th>출루율</th>
               		</tr>
               		<%int i = 1; %>
               		<c:forEach items="${lotteLineUp}" var="llu">
               			<tr>
               				<td><%=i %>번타자</td>
               				<td id="LotteName">${llu.playerName}</td>
               				<td>${llu.battingAverage}</td>
               				<td>${llu.homeRun}</td>
               				<td>${llu.slugging}</td>
               				<td>${llu.hits}</td>
               				<td>${llu.onBase }</td>
               			</tr>
               			<% i++; %>
               		</c:forEach>
               		</table>
               </div>
               
             	<div id="centerDiv" style="float:left;">
            	<table id="tblForm" class="tblForm">
            		<tr>
            			<th>${team2.teamName}</th>
            			<th>VS</th>
            			<th>${team1.teamName}</th>
            		</tr>
            		<tr>
            			<td>${team2.win}승 ${team2.draw}무 ${team2.lose}패</td>
            			<td>승패</td>
            			<td>${team1.win}승 ${team1.draw}무 ${team1.lose}패</td>
            		</tr>
            		<tr>
            			<td>${team2.ranking}위</td>
            			<td>순위</td>
            			<td>${team1.ranking}위</td>
            		</tr>
            		<tr>
            			<td>${team2.winrate}</td>
            			<td>팀승률</td>
            			<td>${team1.winrate}</td>
            		</tr>
            		<tr>
            			<td>${team2.battingAverage}</td>
            			<td>팀타율</td>
            			<td>${team1.battingAverage}</td>
            		</tr>
            		<tr>
            			<td>${team2.homerun}</td>
            			<td>홈런</td>
            			<td>${team1.homerun}</td>
            		</tr>
            		<tr>
            			<td>0승0무2패</td>
            			<td>상대전적</td>
            			<td>2승0무0패</td>
            		</tr>
            		
            	</table>
            	
            	<hr />
            	
            	
            	<table id="tblForm" class="tblForm">
            		<tr>
            			<th>${team2.teamName}</th>
            			<th>VS</th>
            			<th>${team3.teamName}</th>
            		</tr>
            		<tr>
            			<td>${team2.win}승 ${team2.draw}무 ${team2.lose}패</td>
            			<td>승패</td>
            			<td>${team3.win}승 ${team3.draw}무 ${team3.lose}패</td>
            		</tr>
            		<tr>
            			<td>${team2.ranking}위</td>
            			<td>순위</td>
            			<td>${team3.ranking}위</td>
            		</tr>
            		<tr>
            			<td>${team2.winrate}</td>
            			<td>팀승률</td>
            			<td>${team3.winrate}</td>
            		</tr>
            		<tr>
            			<td>${team2.battingAverage}</td>
            			<td>팀타율</td>
            			<td>${team3.battingAverage}</td>
            		</tr>
            		<tr>
            			<td>${team2.homerun}</td>
            			<td>홈런</td>
            			<td>${team3.homerun}</td>
            		</tr>
            		<tr>
            			<td>0승0무1패</td>
            			<td>상대전적</td>
            			<td>1승0무0패</td>
            		</tr>
            		
            	</table>
            	
            	<hr />
            	
            	<table id="tblForm" class="tblForm">
            		<tr>
            			<th>${team2.teamName}</th>
            			<th>VS</th>
            			<th>${team4.teamName}</th>
            		</tr>
            		<tr>
            			<td>${team2.win}승 ${team2.draw}무 ${team2.lose}패</td>
            			<td>승패</td>
            			<td>${team4.win}승 ${team4.draw}무 ${team4.lose}패</td>
            		</tr>
            		<tr>
            			<td>${team2.ranking}위</td>
            			<td>순위</td>
            			<td>${team4.ranking}위</td>
            		</tr>
            		<tr>
            			<td>${team2.winrate}</td>
            			<td>팀승률</td>
            			<td>${team4.winrate}</td>
            		</tr>
            		<tr>
            			<td>${team2.battingAverage}</td>
            			<td>팀타율</td>
            			<td>${team4.battingAverage}</td>
            		</tr>
            		<tr>
            			<td>${team2.homerun}</td>
            			<td>홈런</td>
            			<td>${team4.homerun}</td>
            		</tr>
            		<tr>
            			<td>1승0무1패</td>
            			<td>상대전적</td>
            			<td>1승0무1패</td>
            		</tr>
            		
            	</table>
            	</div>
            	
            	
            	<div id="rightDiv" class="wingDiv" style="float:left;">
            	
				<table id="rightTbl" class="wingTbl">
					<tr>
						<td colspan="5">
						${team1.teamName} 선발 투수</td>

					</tr>
					<tr>
						<td rowspan="4"style="width:100px;"><img style="width:100px;"
							src="../images/face/${pitcher.playerName}.jpg" /></td>
						<td colspan="4" style="font-size:16pt;color:#344f94;font-weight:bold">${pitcher.playerName}</td>
					</tr>
					<tr>
						<td class="long">방어율</td>
						<td class="short">${pitcher.pBangEo}</td>
						<td class="long">탈삼진</td>
						<td class="short">${pitcher.pSamjin}</td>
					</tr>
					<tr>
						<td class="long">피안타</td>
						<td class="short">${pitcher.pAnta}</td>
						<td class="long">피홈런</td>
						<td class="short">${pitcher.pHomerun}</td>
					</tr>
					<tr>
						<td class="long">평균 자책</td>
						<td class="short">${pitcher.pJacheck}</td>
						<td class="long">홀드</td>
						<td class="short">${pitcher.pHold}</td>
					</tr>
					<tr>
            			<td colspan="5">
            				<input type="button" value="LG타자 라인업 보기" onclick="LineUp(1);" />
            			</td>
            		</tr>
				</table>
				
				<hr />
				
				<table id="rightTbl" class="wingTbl">
					<tr>
						<td colspan="5">
						${team3.teamName} 선발 투수</td>

					</tr>
					<tr>
						<td rowspan="4"style="width:100px;"><img style="width:100px;"
							src="../images/face/${pitcher3.playerName}.jpg" /></td>
						<td colspan="4" style="font-size:16pt;color:#344f94;font-weight:bold">${pitcher3.playerName}</td>
					</tr>
					<tr>
						<td class="long">방어율</td>
						<td class="short">${pitcher3.pBangEo}</td>
						<td class="long">탈삼진</td>
						<td class="short">${pitcher3.pSamjin}</td>
					</tr>
					<tr>
						<td class="long">피안타</td>
						<td class="short">${pitcher3.pAnta}</td>
						<td class="long">피홈런</td>
						<td class="short">${pitcher3.pHomerun}</td>
					</tr>
					<tr>
						<td class="long">평균 자책</td>
						<td class="short">${pitcher3.pJacheck}</td>
						<td class="long">홀드</td>
						<td class="short">${pitcher3.pHold}</td>
					</tr>
					<tr>
            			<td colspan="5">
            				<input type="button" value="SK 타자 라인업 보기" onclick="LineUp(3);" />
            			</td>
            		</tr>
				</table>
				
				<hr />
				
				<table id="rightTbl" class="wingTbl">
					<tr>
						<td colspan="5">
						${team4.teamName} 선발 투수</td>

					</tr>
					<tr>
						<td rowspan="4"style="width:100px;"><img style="width:100px;"
							src="../images/face/${pitcher4.playerName}.jpg" /></td>
						<td colspan="4" style="font-size:16pt;color:#344f94;font-weight:bold">${pitcher4.playerName}</td>
					</tr>
					<tr>
						<td class="long">방어율</td>
						<td class="short">${pitcher4.pBangEo}</td>
						<td class="long">탈삼진</td>
						<td class="short">${pitcher4.pSamjin}</td>
					</tr>
					<tr>
						<td class="long">피안타</td>
						<td class="short">${pitcher4.pAnta}</td>
						<td class="long">피홈런</td>
						<td class="short">${pitcher4.pHomerun}</td>
					</tr>
					<tr>
						<td class="long">평균 자책</td>
						<td class="short">${pitcher4.pJacheck}</td>
						<td class="long">홀드</td>
						<td class="short">${pitcher4.pHold}</td>
					</tr>
					<tr>
            			<td colspan="5">
            				<input type="button" value="두산 타자 라인업 보기" onclick="LineUp(4);" />
            			</td>
            		</tr>
				</table>
				
				
				
			</div>
           	</div> <!-- MainContent -->
         </div><!-- /main -->

			<div id="side"></div>
         
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

</body>
</html>