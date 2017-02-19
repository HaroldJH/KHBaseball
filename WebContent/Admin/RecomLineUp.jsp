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

.gudan {
	float: left;
	margin-left: 10px;
}
.tblForm {
		border: 1px solid gray;
		border-collapse: collapse;
		width: 700px;
		margin: 10px 20px;
}
	
.tblForm th, .tblForm td  {
		border: 1px solid gray;
		text-align: center;
}
.tblForm tr th {
	border: 0px;
	height: 40px;
	background-color: #2F4F4F;
	color: white;
} 
.tblForm tr td {
	border: 0px;
	border-bottom: 1px solid gray;
	height: 25px;
}

#tblForm tr td:FIRST-CHILD {
	color: #354f99;
	font-weight: bolder;
}

.short { width: 50px; }
.long { width: 70px; }

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
	var f_box = new Array("LG","롯데","두산","SK");
	var s_box = new Array();
	var t = ${teamId};
	if(t == 1){
		s_box[0] = new Array("장원준", "정대현", "김승희");
		s_box[1] = new Array("유희관", "최병욱", "이용찬");
		s_box[2] = new Array("김광현", "박희수", "박정배");
	} else if(t == 2){
		s_box[0] = new Array("우규민", "봉중근", "이동현");
		s_box[1] = new Array("유희관", "최병욱", "이용찬");
		s_box[2] = new Array("김광현", "박희수", "박정배");
	} else if(t == 3){
		s_box[0] = new Array("우규민", "봉중근", "이동현");
		s_box[1] = new Array("장원준", "정대현", "김승희");
		s_box[2] = new Array("김광현", "박희수", "박정배");
	} else if(t == 4){
		s_box[0] = new Array("우규민", "봉중근", "이동현");
		s_box[1] = new Array("장원준", "정대현", "김승희");
		s_box[2] = new Array("유희관", "최병욱", "이용찬");
	}

	$(document).ready(function() {
		$(".gudan").hide();
		init(this.form);
		$("#first").val("${first}");
		sChange($("form")[0]);
		$("#second").val("${second}");
	});

	
	function recom() {
		$("form").attr("action","/KHBaseball/Admin/RecomLineUp.do");
		$("form")[0].submit();
		
		
		/* if(sel == 1){ 
			$("form").attr("action","/KHBaseball/Admin/LgLineUp.do").submit();
		}else if(sel == 2) {
			$("form").attr("action","/KHBaseball/Admin/LotteLineUp.do").submit();
			
		} */
	}
	
	function sChange(f) {
		
		var f_sel = f.first;
		var s_sel = f.second;
		
		sel = f_sel.selectedIndex;
		for(var i=s_sel.length; i>=0; i--) {
			s_sel.options[i] = null;
		}
		
		s_sel.options[0] = new Option("선수 이름", "");
		
		if(sel != 0) {
			for(var i=0; i<s_box[sel-1].length; i++) {
				s_sel.options[i+1] =
					new Option(s_box[sel-1][i], s_box[sel-1][i]);
			}
		}
		

		
	}
		
	function init(f){
		var f_sel = f.first;
		var s_sel = f.second;
		var teamId = ${teamId};
		
		f_sel.options[0] = new Option("선택", "");
		s_sel.options[0] = new Option("선수 이름", "");
		
		
		for(var i=0; i<f_box.length; i++) {
			//alert(${teamId});
		
				f_sel.options[i+1] = new Option(f_box[i], i+1);
			
		}
		$("#first option:eq("+(teamId)+")").remove();


		/* <c:if test="${state == 2}">
			f_sel.options[2].selected = true;
		</c:if> */
		
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
                  <td id="cel1">&nbsp;<a style="color:black;"href="/KHBaseball/Admin/Compare.do?teamId=${teamId}">선수 관리</a></td>
               </tr>
               <tr>
                  <td id="cel1">&nbsp;&nbsp;<a style="color:black;" href="/KHBaseball/Admin/Compare.do?teamId=${teamId}">- 선수 비교</a></td>
               </tr>
               <tr>
                  <td id="cel1">&nbsp;&nbsp;<a style="color:black;"href="/KHBaseball/Admin/TeamCompare.do?teamId=${teamId}">- 팀 전력 비교</a></td>
               </tr>
               <tr>
                  <td id="cel1">&nbsp;<a style="color:red;" href="/KHBaseball/Admin/RecomLineUp.do?teamId=${teamId}">선발 라인업 추천</a></td>
               </tr>
               <tr>
                  <td id="cel1">&nbsp;<a style="color:black;" href="/KHBaseball/Admin/ScoutList.do?teamId=${teamId}">영입 추천</a></td>
               </tr>
               <tr>
                  <td id="cel1">&nbsp;<a style="color:black;" href="/KHBaseball/Admin/RemoveList.do?teamId=${teamId}">방출 추천</a></td>
               </tr>

            </table>

            <div id="mainContent">
               <div id="flow">Home > 관리자메뉴 > 라인업 추천</div>
             
             
             <form name="form">
             <div id="topArea" style="width:800px; height:30px;margin-left:25px;margin-top:15px;">
         		<span style="float: left;font-size:13pt;font-weight:bold;">구단 : &nbsp;</span>
         		
         		<select id="first" name="first" onchange="sChange(this.form);" style="float: left; width:70px;">
         			
         		</select>
         		
         		<div id="secondArea" style="float: left;margin-left:10px;margin-right:10px;">
         		<span style="font-size:13pt;font-weight:bold;">선수 : </span>
         		
         		<select id="second" name="second"  style="width: 100px;">
         			
         		</select>
         		</div>
         		
         		
         		
         		<div id="btnRecom">
         		<input type="button" value="추천 보기" onclick="recom();"/>
         		</div>
         		
         		<div style="clear: both;"></div>
         	 
             </div> <!-- topArea -->
             
             <div id="contentArea">
             	<table id="tblForm" class="tblForm" style="float: left;">
			 		<tr>
			 			<th class="long">포지션</th>
			 			<th>선수명</th>
			 			<th class="short">타수</th>
			 			<th class="short">안타</th>
			 			<th class="short">홈런</th>
			 			<th class="short">도루</th>
			 			<th class="short">삼진</th>
			 			<th class="long">타율</th>
			 			<th class="long">장타율</th>
			 			<th class="long">출루율</th>
			 			<th class="long">OPS</th>
			 		</tr>
			 		<% int i = 1; %>
			 		<c:forEach items="${recomdto }" var="rdto">
			 		<tr>
			 			<%if(i < 10){ %>
			 				
			 			<td>
							<%=i %>번 타자
			 			</td>
			 				
			 			<%}else { %>
			 			<td>벤치</td>
			 			<%} %>
			 			<td>
			 			${rdto.playerName}
			 			</td>
			 			<td>${rdto.atBat }</td>
			 			<td>${rdto.hits }</td>
			 			<td>${rdto.homeRun }</td>
			 			<td>${rdto.still }</td>
			 			<td>${rdto.samjin }</td>
			 			<td>${rdto.battingAverage }</td>
			 			<td>${rdto.onBase }</td>
			 			<td>${rdto.slugging }</td>
			 			<td>${rdto.ops }</td>
			 		</tr>
			 		<% ++i; %>
			 		</c:forEach>
			 		
			 	</table>
             </div> <!-- contentArea -->
             </form>
           </div> <!-- MainContent -->
         </div><!-- /main -->

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

</body>
</html>