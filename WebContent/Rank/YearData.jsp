<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
 <script type="text/javascript" src= "https://www.google.com/jsapi"></script>
   
    <script type="text/javascript">
      google.load('visualization', '1', {packages: ['corechart']});
    </script>
     <script type="text/javascript">
      function drawVisualization() {
        // Create and populate the data table.
        var data = google.visualization.arrayToDataTable([
         
                                                          
          ['일', 'LG','롯데','두산','SK'],
          ['5/9(금)',   2.5,1.2,2.2,2.5],
          ['5/10(토)',   3.0,1.0,2.5,1.5],
          ['5/11(일)',   2.1,1.8,1.9,2.5],
          ['5/13(화)',   2.8,1.0,1.5,1.5],
          ['5/14(수)',   3.0,1.1,1.8,2.3]
          ]);
      
        // Create and draw the visualization.
        new google.visualization.LineChart(document.getElementById('visualization')).
            draw(data, {curveType: "function",
                        width: 600, height: 300,
                        vAxis: {maxValue: 3}}
                );
      }
      

      google.setOnLoadCallback(drawVisualization);
    </script>

<link rel="stylesheet"
   href="http://fonts.googleapis.com/css?family=Lobster" />

<script type="text/javascript">
   Cufon.replace('h1,h2,h3,h4,h5,#menu,#copy,.blog-date');
</script>
<script type="text/javascript" src="../js/fancyzoom.min.js"></script>
<script type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="../css/main.css" type="text/css" />

<style type="text/css">
	#tblYear, #btnList {
		width: 600px;
		margin: 20px auto;
		text-align:center;
	}
	#tblYear #col1 { width: 150px; }
	#tblYear #col2 { width: 100px; }
	#tblYear #col3 { width: 100px; }
	#tblYear #col4 { width: 50px; }
	#tblYear #col5 { width: 100px; }
	#tblYear #col6 { width: 100px; }
	#tblYear th { background-color: #DEDEDE; }
	.cell1, .cell3, .cell4, .cell5 { 
		text-align: center; 
	}
	
	#trY{height:30px;}
	#tblYear tr{height:30px;}
	
	#divYear{width:600px;height:300px;background-color: yellow;margin: 20px auto;}
	
	#searchList {margin-left:10px; text-align: center; }
	#searchList #word { width: 150px; height: 14px; }
</style>
<script type="text/javascript">
	/* function moveLis(sel) {
		location.href = "/KHBaseball/Rank/yearDate.do?teamName=" + sel.value;
		
	} */
	
	/* $(document).ready(function() {
		alert(${idx});
	}); */
</script>

</head>
<body onload="init();">
  <div id="bg" >
      <div class="wrap">

         <!-- menu -->
         <%@include file="../Menu.jsp"%>

         <!-- main -->
         <div id="main">
           </br> </br> </br> </br> </br>
            <table id="subTitle" border="1px solid gray">

               <tr >
                  <th id="col">&nbsp;순위 메뉴</th>
               </tr>
               <tr>
                  <td class="cel1"><a href="/KHBaseball/Rank/List.do">&nbsp; 순위</a></td>
               </tr>
               <tr>
                  <td class="cel1"><a href="">&nbsp;<span style="color:red; weight:bold;">역대 전적 기록</span></a></td>
               </tr>
            </table>

            <div id="mainContent">
            <div id="flow">Home > 순위   </div>
            <p style="font-size: 20pt;margin-left: 185px; margin-top:5px;">구단별 <span style="color:red;">역대 기록</span></p>
               
             <!-- 년도 선택 창 -->  
            <div style="width:600px;margin:10px auto;text-align:left;margin-bottom: 

0px;">
           
           
            <select id = "yearList" name="yearList" onchange="selYearList();">
				<option value="팀선택">팀선택</option>
				<c:forEach items ="${yearList}" var="dto">
				<option value="${dto.teamName}" >${dto.teamName}

</option>
				</c:forEach>
			</select>
			
			</div>
			
			<!-- 순위 리스트 창 -->
			<table id="tblYear">
			
			<tr id="trY">
			<!-- <th id="col1">상대팀</th> -->
			<th id="col1">상대팀</th>
			<th id="col2">경기</th>
			<th id="col3">승</th>
			<th id="col4">패</th>
			<th id="col5">승률</th>
			
		</tr>
		<%-- 
		<c:if test="${dto.teamName}=">
		
		</c:if> --%>
		<c:if test="">
		<tr>
			<td colspan="5" style="text-align:center;">팀을 

선택해주세요.</td>
		</tr>
		</c:if>
		
		<c:forEach items="${yearList2}" var="dto">
		<tr>
			<td class="cell1">${dto.teamName}</td>
			<td class="cell2">${dto.gameNum}</td>
			<td class="cell3">${dto.win}</td>
			<td class="cell4">${dto.lose}</td>
			<td class="cell5">${dto.winRate}</td>
		</tr>
		</c:forEach>
	
	</table>
          
           <!-- 꺽은선 그래프 -->
         
		  <h4 style="margin-bottom: 1px;margin-left: 185px;margin-top: 30px;">

일별 승률 <span style="color:red;">변동 그래프</span></h4>
           <div id="divYear" >
			  <div id="visualization" style="width: px; height: 

400px;"></div>
			
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
                  <a href="http://www.solucija.com" title="Free CSS 

Templates">Solucija</a>
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
	
		
		    function selYearList() {
		    	var yearList=document.getElementById("yearList"); //선택된 인덱스 값
				
			    var idx = yearList.selectedIndex;//선택값 인덱스 번호
				//var value = yearList.options[idx].value; //값 접근
				
				/* alert(value);*/
				//alert(idx); 
				
				location.href = "/KHBaseball/Rank/YearData.do?idx=" + 

idx;
		    	
		    }
			
			
			
			/* <c:forEach items ="${yearList}" var="dto">
				team[${dto.teamName}];
			</c:forEach> */
			
			
	
   
	
	//alert($("#yearList").val());
  
   </script>

</body>
</html>