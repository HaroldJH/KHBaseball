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
<script type="text/javascript">

/* <c:forEach items="${battingAverages}" var="a">
alert(${a.playerName});
</c:forEach> */

</script>
<style type="text/css">
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
	
	#tblList th { background-color: #DEDEDE; font-size: 20pt;}
	.cell1, .cell2, .cell3, .cell5 {  vbbvbv/ 
		text-align: center; font-size: 20pt;
	}
	
	
	#searchList { text-align: center; }
	#searchList #word { width: 150px; height: 14px; }
</style>

</head>
<body>
   <div id="bg" style="background-color: #FFFAFA;">
      <div class="wrap">

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
                  <td class="cel1"><a href="/KHBaseball/record/TeamBatter.do">&nbsp;-팀 기록</a></td>
               </tr>
                
              

            </table>

            <div id="mainContent">
               <div id="flow">Home > 기록   </div>
            <h4 style="margin-bottom: 1px;margin-left: 185px;margin-top: 100px; font-size:20pt;">안타 20명까지 순위</h4>
               
             <!-- 년도 선택 창 -->  
             
			
			<div style="width:600px;margin:10px auto;text-align:left;margin-bottom: 0px;">
           
         
			</div>
			<!-- 순위 리스트 창 -->
			<table id="tblList">
		<tr>
			<th id="col1">순위</th>
			<th id="col2">선수이름</th>
			<th id="col3">안타</th> 
		</tr>
		<!-- 도루 -->
		<c:forEach items="${hitss}" var="dto">
		<tr>
			<td class="cell1">${dto.rnum}</td>
			<td class="cell2">${dto.playerName}(${dto.teamName})</td>
			<td class="cell3">${dto.hitss}</td>
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