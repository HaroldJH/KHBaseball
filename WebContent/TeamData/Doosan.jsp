<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>KH 야구 프로젝트</title>
<link href="css/basic.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="../assets/css/styles.css" />
<link rel="stylesheet" href="../css/main.css" type="text/css" />
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
 google.load("visualization", "1", {packages:["corechart"]});
 google.setOnLoadCallback(drawChart);
 function drawChart() {
   var data = google.visualization.arrayToDataTable([
     ['Month', 'Sales', 'Expenses'],
     ['3월',  3,      0],
     ['4월',  1,      0],
     ['5월',  3,       0],
     ['6월',  7,      0]
   ]);

   var options = {
     title: 'Company Performance'
   };

   var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
   chart.draw(data, options);
 }
</script>


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
<script type="text/javascript" src="./js/fancyzoom.min.js"></script>
<script type="text/javascript" charset="utf-8">
/*     $(document).ready(function() {
      $('div.photo a').fancyZoom({
         directory : 'images/zoom',
         scaleImg : true,
         closeOnClick : true
      });
   });  */
</script>
<link rel="stylesheet" href="/css/main.css" type="text/css" />

<style type="text/css">
#tblTeam{
		width: 600px;
		margin: 20px auto;
		text-align:left;
		line-height: 1.3em; 
	}

#tblTeam #td1{width:300px;height:200px;}
#tblTeam #td3{width:300px;height:400px;}
#logo{
	width:200px;height:160px;margin-left:50px;
}

img1{
	width:90px; height:120px;
}
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
                  <th id="col1">구단 정보 메뉴</th>
               </tr>
               <tr>
                  <td class="cel1"><span style="color:red;weight:bold;">&nbsp;&nbsp;구단</span></td>
               </tr>
               <tr>
                  <td class="cel1"><a href="/KH/TeamData/LG.jsp">&nbsp;&nbsp;-LG</a></td>
               </tr>
                <tr>
                  <td class="cel1"><a href="/KH/TeamData/SK.jsp">&nbsp;&nbsp;-SK</a></td>
               </tr>
                <tr>
                  <td class="cel1"><a href="/KH/TeamData/Doosan.jsp">&nbsp;&nbsp;-Doosan</a></td>
               </tr>
                <tr>
                  <td class="cel1"><a href="/KH/TeamData/Lotte.jsp">&nbsp;&nbsp;-Lotte</a></td>
               </tr>
                <tr>
                  <td class="cel1"><a href="/KH/Rank/List.do">&nbsp;&nbsp;-KIA</a></td>
               </tr>
                <tr>
                  <td class="cel1"><a href="/KH/Rank/List.do">&nbsp;&nbsp;-Nc</a></td>
               </tr>
                <tr>
                  <td class="cel1"><a href="/KH/Rank/List.do">&nbsp;&nbsp;-Samsung</a></td>
               </tr>
                
              

            </table>

            <div id="mainContent">
            <div id="flow">Home > 구단 정보> LG&nbsp;   </div>
            <p style="font-size:13px; 1px;margin-left: 185px;margin-top: 100px;">구단소개 ><span style="color:red;">LG</span></p>
               
             <table id="tblTeam" >
			<tr>
				<td id="td1"> <img src="../images/logo/LG.jpg" id="logo" /> </td>
				<td id="td2">
				<h4 style="color:red;">LG 트윈스</h4></br>  
				토론장 가기  </br>
				창단 : 1990년 </br>
				홈구장 : 잠실야구장 </br>
				우승 : 2회 우승 (90, 94) </br>
				공식 홈페이지 : http://www.lgtwins.com </br>
				
				</td>
			</tr>
			<tr>
				<td colspan="2" id="td3">
				
				<h3>팀 컬러</h3></br>

				2013시즌 74승 54패의 성적으로 페넌트레이스를 2위로 마치며 11년 만에 가을 야구에 초대 받았다. 
				플레이오프에서 1승 3패로 두산에 패하며 아쉽게 시즌을 마무리했으나, 김기태 감독의 형님 리더십 아래 
				시즌 내내 선수들이 하나된 모습을 보였다는 점은 2014시즌을 기대하게 하기에 충분했다. 2013시즌 팀 
				평균자책점 1위(3.72)를 차지한 투수진은 김선우, 윤지웅, 신승현 등이 가세하며 선수층이 더욱 
				두터워졌지만, 에이스 리즈의 빈자리가 아쉬움으로 남는다. 새로운 외국인 투수들과 류제국이 선발진에서 
				리즈의 공백을 메워줄 수 있을지가 올 시즌 마운드의 관건이다. 타선에서는 이병규(9), 박용택, 이진영,
				 정성훈 등 베테랑 선수들과 이병규(7), 정의윤, 김용의, 문선재 등 젊은 선수들의 신구 조화가 기대되며,
				  외국인 타자 벨과 박경수, 백창수 등 군제대 선수들도 힘을 보탠다. 투타에서 두터운 선수층을 구축한
				   LG 트윈스가 김기태 감독이 추구하는 토털 베이스볼로 2년 연속 포스트시즌에 진출할 수 있을지 지켜볼
				    만하다.
				    
				</br></br>
				<img src= "../images/logo/2.jpg" style="width:90px; height:120px;"/></br>
				감독: 백인천</br>
				코치: 이재환, 유백만</br>
				투수: 하기룡, 정순명, 이길환, 이광권, 유종겸, 차준섭, 박석채, 김시철</br>
				포수: 유승안, 김용운, 최정기</br>
				내야수: 김용윤, 김용달, 김인식, 조호, 박재천, 이광은</br>
				외야수: 이종도, 신언호, 송영운, 배수희, 최정우, 김봉기</br>
				
				</td>
				
			</tr>
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