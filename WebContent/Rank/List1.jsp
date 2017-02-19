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
   height: 130px;
   border: 1px solid gray;
   border-collapse: collapse;
   float:left;
   margin-top: 100px;
   margin-left: -100px;
}
/* 
#subTitle tr th {background-color: #DEDEDE;}
 */
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


</style>

<script type="text/javascript" src="../js/jquery-1.4.1.min.js"></script>
<script type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" src="../js/slideshow.js"></script>
<script type="text/javascript" src="../js/cufon-yui.js"></script>

<link rel="stylesheet"
   href="http://fonts.googleapis.com/css?family=Lobster" />

<script type="text/javascript">
   Cufon.replace('h1,h2,h3,h4,h5,#menu,#copy,.blog-date');
</script>
<script type="text/javascript" src="../js/fancyzoom.min.js"></script>
<script type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="../css/main.css" type="text/css" />

<style type="text/css">
	
	#tblList{height:300px; font-size: 20pt;}
	#tblList, #btnList {
		width: 600px;
		margin: 20px auto;
		text-align:center;
		
	}
	#tblList #col1 { width: 50px; }
	#tblList #col2 { width: 100px; }
	#tblList #col3 { width: 100px; }
	#tblList #col4 { width: 100px; }
	#tblList #col5 { width: 50px; }
	#tblList #col6 { width: 50px; }
	#tblList #col7 { width: 50px; }
	#tblList #col8 { width: 100px; }
	
	#tblList th { background-color: #DEDEDE; }
	.cell1, .cell3, .cell4, .cell5 {  vbbvbv/ 
		text-align: center; 
	}
	
	#searchList { text-align: center; }
	#searchList #word { width: 150px; height: 14px; }
</style>

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
                  <th id="col">&nbsp;순위 메뉴</th>
               </tr>
               <tr>
                  <td class="cel1"><a href="/KHBaseball/Rank/List.do">&nbsp;<span style="color:red;weight:bold;">순위</span></a></td>
               </tr>
               <tr>
                  <td class="cel1"><a href="/KHBaseball/Rank/YearData.do">&nbsp;역대 전적 기록</a></td>
               </tr>
                
              

            </table>

            <div id="mainContent">
               <div id="flow">Home > 순위   </div>
            <p style="font-size: 20pt;margin-left: 185px; margin-top:5px;">년도별 <span style="color:red;">구단 순위</span></p>
               
             <!-- 년도 선택 창 -->  
             <div id="searchList" style="width:600px;margin:10px auto;text-align:left;margin-bottom: 0px;">
				<form method="GET" action="/ball/Rank/List.do">
					<select name="col" id="col">
						<option value="subject">2014</option>
						<option value="content">2013</option>
						<option value="name">2012</option>
						
					</select>
					
				</form>
			</div>
			
			<div style="width:600px;margin:10px auto;text-align:left;margin-bottom: 0px;">
           
         
			</div>
			<!-- 순위 리스트 창 -->
			<table id="tblList">
		<tr>
			<th id="col1">순위</th>
			<th id="col2">팀명</th>
			<th id="col3">경기</th>
			<th id="col4">승</th>
			<th id="col5">무</th>
			<th id="col6">패</th>
			<th id="col7">승차</th>
			 <th id="col8">승률</th> 
		</tr>
		
		
		<c:forEach items="${rankList}" var="dto">
		<tr>
			<td class="cell1">${dto.ranking}</td>
			<td class="cell2">${dto.teamName}</td>
			<td class="cell3">${dto.gameNum}</td>
			<td class="cell4">${dto.win}</td>
			<td class="cell5">${dto.draw}</td>
			<td class="cell6">${dto.lose}</td>
			<td class="cell7">${dto.rankDifference}</td>
			<td class="cell8">${dto.winRate}</td>
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

</body>
</html>