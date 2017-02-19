<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>KH 야구 프로젝트</title>
	<link rel="stylesheet" href="./assets/css/styles.css" />
	<link rel="stylesheet" href="./css/main.css" type="text/css" />
	<link rel="stylesheet"href="http://fonts.googleapis.com/css?family=Lobster" />
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<script type="text/javascript" src="js/jquery-1.4.1.min.js"></script>
	<script type="text/javascript" src="./js/jquery-1.4.1.min.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/slideshow.js"></script>
	<script type="text/javascript" src="js/cufon-yui.js"></script>
	<script type="text/javascript" src="js/Arial.font.js"></script>
	<script type="text/javascript" src="./js/menu.js"></script>
	<script type="text/javascript" src="./js/slideshow.js"></script>
	<script type="text/javascript" src="./js/cufon-yui.js"></script>
	<script type="text/javascript">
		Cufon.replace('h1,h2,h3,h4,h5,#menu,#copy,.blog-date');
	</script>
	<script type="text/javascript" src="js/fancyzoom.min.js"></script>
	<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			$('div.photo a').fancyZoom({directory: 'images/zoom', scaleImg: true, closeOnClick: true});
		});
	</script>

	<script type="text/javascript">
	   Cufon.replace('h1,h2,h3,h4,h5,#menu,#copy,.blog-date');
	</script>
	<script type="text/javascript" src="./js/fancyzoom.min.js"></script>
	<script type="text/javascript" charset="utf-8">
	   $(document).ready(function() {
	      $('div.photo a').fancyZoom({
	         directory : 'images/zoom',
	         scaleImg : true,
	         closeOnClick : true
	      });
	   });
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
	
	#subTitle tr th {background-color: #DEDEDE;}
	
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
	

	 #formLogin{
	 	margin-top:5px;
	 	border:1px solid gray;
	 	width:250px;
	 	height:100px;
	 	margin-left:15px;
	 }
	 #formLogin tr{margin-left: 5px;}
	
	#Lth{font-size:15pt;}
	
	
	#tblLogin{
		margin-top:5px;
		margin-left:7px;
		text-size:3pt;
	}
	
	
	#subLogin{
		width:235px;
		margin-left:10px;
		text-align:center;
	}
	
	#layout	{ background-color:transparent; width:1000px; height:690px; }
	#header { background-color:transparent; height:100px;width:250px;}
	#leftside{ background-color:transparent; float:left; width:250px; height:600px;margin-left:30px;margin-right: 0px; }
	#content{ background-color:transparent; float:right; width:700px; height:600px; margin-left:-820px;}
	#logoImg{ background-color:transparent; clear:both; height:100px; margin-left:5px;margin-bottom: 15px;}
	
	
	
	#formR{
		border:1px solid gray;
	 	width:250px;
	 	height:230px;
	 	margin-left:15px;
	 	margin-top:5px;
	}
	#tblRank{
		
	 	width:230px;
	 	height:190px;
	 	margin-left:3px;
	}
	#tblRank tr th{background-color: #34657C;color: white;text-align:center;}
	#tblRank tr td{text-align:center;}
	
	
	
	#formS{
		border:1px solid gray;
	 	width:250px;
	 	height:150px;
	 	margin-left:15px;
	 	margin-top:5px;
	}
	#tblS{
		width:230px;
	 	height:100px;
	 	margin-top:0px;
	 	margin-left:3px;
	}
	#tblS #td1{background-color: #34657C;color: white;margin-left: 3px;}
	#tblS #td2{color:gray;weight:bold;margin-left: 3px;}
	
	#formN{border:1px solid gray;
	 	width:250px;
	 	height:200px;
	 	margin-left:15px;
	 	margin-top:5px;}
	
	#tblN{
		
	 	width:230px;
	 	height:140px;
	 	margin-top:0px;
	 	margin-left:3px;
	}
	
	#tblN #trN{background-color: #34657C;color: white;margin-left: 3px;}
	#slide{
		border:1px solid gray;
		width:600px;
		height:300px;
	}
	#tblTop1{
		width:280px;
		height:150px;
		border:1px solid gray;
		padding:3px;
		
	}
	
	#tblTop1 #top1{background-color: #34657C; height:40px; color:white;}
	#img{ height: 300px; width:600px;}
	#ulTu{font-size:20pt;text-align:right;}
	</style>
</head>
<body>
	<div id="bg1" style="background-color: white;" >
		<div class="wrap1">
	
         <!-- menu -->
         <%@include file="MenuIndex.jsp"%>
		<!-- menu -->	
		
	<div id="layout">
	
	<div id="leftside">
	<div  id="formLogin">
	<c:if test="${empty mId}">
         <form method="post" action="/KHBaseball/Login.do" >
	<table id="tblLogin" >
		<tr>
			<th id="Lth">아이디</th>
			<td id="Ltd"><input type="text" value="" id="mId" name="mId"/></td>
		</tr>
		<tr>
			<th id="Lth">비밀번호</th>
			<td> <input type="password" value="" id="mPw" name="mPw"/></td>
		</tr>
	</table>
	  <div >
            <input type="submit" value="로그인" id="subLogin"/>
      </div>
      </form> 
      <ul>
			<li class="classlogin" style="display:inline-block;"><a 
		
		href="" onclick="" >&nbsp;&nbsp;회원가입&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
		<li style="display:inline-block;"><a  href="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아이디</a> 
		
		<span class="vr">/</span> <a  href="" onclick="">비밀번호 찾기</a></li>
		</ul>
     </c:if>
         <c:if test="${!empty mId}">
            <form method="post" action="/KHBaseball/Logout.do">
            <table>
            <tr><td>
            <span style="color:red;font-size:12pt">${mId } 님 로그인중.,....</span></br>
			 <span style="color:balck;;font-size:12pt">저희 KH Baseball에 오신것을 환영합니다!!!</span>
			           
            <input type="submit" value="로그아웃"/>
            </td></tr>
            </table>
            </form>
        </c:if>
		
		 
	</div>
	
	<!-- 순위 박스  -->
			<form action="" id="formR" > 
			<div>
			<p  style="font-size:25px; weight:bold; margin-left:3px;margin-bottom: 0px;">&nbsp;&nbsp;구단<span style="color:red; weight:bold; margin-left:3px;margin-bottom: 0px;">Ranking</span></p>
			<table id="tblRank">
		  <tr >
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
	
		<tr>
			<td class="cell1">5</td>
			<td class="cell2">기아</td>
			<td class="cell3">4</td>
			<td class="cell4">2</td>
			<td class="cell5">0</td>
			<td class="cell6">2</td>
			<td class="cell7">4</td>
			<td class="cell8">0.45</td>
		</tr>
		<tr>
			<td class="cell1">6</td>
			<td class="cell2">삼성</td>
			<td class="cell3">4</td>
			<td class="cell4">2</td>
			<td class="cell5">0</td>
			<td class="cell6">2</td>
			<td class="cell7">4</td>
			<td class="cell8">0.35</td>
		</tr>
		<tr>
			<td class="cell1">7</td>
			<td class="cell2">한화</td>
			<td class="cell3">4</td>
			<td class="cell4">2</td>
			<td class="cell5">0</td>
			<td class="cell6">2</td>
			<td class="cell7">4</td>
			<td class="cell8">0.25</td>
		</tr>
		<tr>
			<td class="cell1">8</td>
			<td class="cell2">NC</td>
			<td class="cell3">4</td>
			<td class="cell4">2</td>
			<td class="cell5">0</td>
			<td class="cell6">2</td>
			<td class="cell7">4</td>
			<td class="cell8">0.23</td>
		</tr>
		<tr>
			<td class="cell1">9</td>
			<td class="cell2">기아</td>
			<td class="cell3">4</td>
			<td class="cell4">2</td>
			<td class="cell5">0</td>
			<td class="cell6">2</td>
			<td class="cell7">4</td>
			<td class="cell8">0.12</td>
		</tr>
	

	
		</table>
				</div>
				</form>
				
				
				<!-- 일정 박스  -->
		<form action="" id="formS"> 
		<p  style="font-size:25px; weight:bold;margin-top:2px; margin-left:3px;margin-bottom: 0px;">&nbsp;&nbsp;일정/결과<span style="color:red; weight:bold; margin-left:3px;margin-bottom: 0px;">중계보기</span></p>
		
		<table id="tblS">
			<tr id="td1">
				<td colspan="4">&nbsp;&nbsp;경기 일정</td>
				
			</tr>
			<tr id="td2">
				<td colspan="4" >2014-05-22</td>
				
			</tr>
			<tr>
				<td>LG</td>
				<td>vs</td>
				<td>KIA</td>
				<td>17:00:00</td>
			</tr>
			<tr>
				<td>삼성</td>
				<td>vs</td>
				<td>롯데</td>
				<td>17:00:00</td>
			</tr>
	
			
			
		</table>
		</form>
		
		<!-- 공지사항 박스  -->
		<form action="" id="formN"> 
		<p  style="font-size:25px; weight:bold;margin-top:0px; margin-left:10px;margin-bottom: 0px;">관계자<span style="color:red; weight:bold; margin-left:3px;margin-bottom: 0px;">공지사항</span></p>
		
		<table id="tblN">
		
			<tr id="trN">
				<td colspan="2">&nbsp;&nbsp;공지사항 게시판</td>
			</tr>
			<tr>
				<td>KH야구 공지사항글..</td>
				<td>2014-05-24</td>
			</tr>
			<tr>
				<td>KH야구 이벤트발표..</td>
				<td>2014-05-22</td>
			</tr>
			<tr>
				<td>LG vs SK 분석..</td>
				<td>2014-05-19</td>
			</tr>
			<tr>
				<td>롯데 vs 두산..</td>
				<td>2014-05-19</td>
			</tr>
			
		</table>
		
		</form>
		</div>
		
		
		<!-- 우측 화면   -->	
		<div id="content">
		<!-- 			<div id="slide" >-->			
		<div id="pitch">
		<div id="slideshow">
			
			<!-- 1st frame -->
		<div class="active">
			<img src="images/m1.jpg" alt="" id="img" />
			<div class="overlay transparent">
				<h2>KH Baseball project</h2>
				<p>KH Baseball for manager.야구 관계자들을 위한 선수관리 페이지와 일반 유저들을 위한 야구정보제공 페이지 제작</p>
		</div>
		<p class="arrow"><a href="#"></a></p>
		</div>
		<!-- /1st frame -->
		
		<!-- 2nd frame -->
		<div>
		<img src="images/mainSamsung.jpg" alt="" id="img"/>
		<div class="overlay transparent">
			<h2 style="color:yellow;">SamsungLions TODAY</h2>
			<p>초심과 열정은 거짓이 없고 순수하며 마음을 다잡을 수 있는 큰 힘을 지니고 있습니다 .</p>
		</div>
		<p class="arrow"><a href="#"></a></p>
		</div>
		<!-- /2nd frame -->
		
		<!-- 3rd frame -->
		<div>
			<img src="images/mainLG.png" alt="" id="img"/>
			<div class="overlay transparent">
				<h2>Mesurable Results</h2>
				<p>Aliquam erat volutpat. Doneca sem consequat tortor posuere dignissim sit amet at ipsum.</p>
			</div>
			<p class="arrow"><a href="#"></a></p>
			</div>
							<!-- 3rd frame -->
				
			</div>
		</div>
		
		<!-- </div> -->
			<div id="content" style="margin-bottom:100px;">	
		<table>
		<tr>
			<td>
		<p  style="font-size:25px; weight:bold; margin-left:3px;margin-top:5px;margin-bottom: 0px;">타자<span style="color:red; weight:bold; margin-left:3px;margin-bottom: 0px;">TOP3</span></p>
			
			<table id="tblTop1" >
		<tr id="top1">
			<td colspan="2" >
			<ul id="ulTu">
					
				<li style="display:inline-block;text-align:center;"><a href="">타점</a></li>
				<li style="display:inline-block;text-align:center;"><a href="">타율</a></li>
				<li style="display:inline-block;text-align:center;"><a href="">안타</a></li>
			</ul>
			</td>
		</tr>
		<tr>
			<td >
			 <a href="">
			    <img src="images/2.jpg" />
		    </a>
			</td>
			<td>
			 <ol>
					    
			    <li class="no1" >
				    <a href="">
				    <em></em>10 민병헌 (두산)
				    </a>
			    </li>
			    <li class="no1">
				    <a href="">
				    <em></em>6 이원석 (두산) 
				    </a>
			    </li>
			    <li class="no1">
				    <a href="">
				    <em></em>장원삼 (삼성) 5
				    </a>
			    </li>
			    
		    </ol>
			</td>
		</tr>
	</table>
			</td>
			<td>
			<p  style="font-size:25px; weight:bold; margin-left:3px;margin-top:5px;margin-bottom: 0px;">투수<span style="color:red; weight:bold; margin-left:3px;margin-bottom: 0px;">TOP3</span></p>
			
			<table id="tblTop1" >
		<tr id="top1">
			<td colspan="2">
			<ul id="ulTu">
					
			     <li style="display:inline-block;text-align:center;"><a href="">방어율</a></li>
				 <li style="display:inline-block;text-align:center;"><a href="">세이브</a></li>
	             <li style="display:inline-block;text-align:center;"><a href="">탈삼진</a></li>
             </ul>
			</td>
		</tr>
		<tr>
			<td >
			 <a href="">
			    <img src="images/1.jpg" />
		    </a>
			</td>
			<td>
			 <ol>
					    
			    <li class="no1" >
				    <a href="">
				    <em></em>장원삼 (삼성) 5
				    </a>
			    </li>
			    <li class="no1">
				    <a href="">
				    <em></em>장원삼 (삼성) 5
				    </a>
			    </li>
			    <li class="no1">
				    <a href="">
				    <em></em>장원삼 (삼성) 5
				    </a>
			    </li>
			    
		    </ol>
			</td>
		</tr>
	</table>
			</td>
		</tr>
		</table>	
		<div id="logoImg">
		<p style="margin-bottom:0px;margin-top:80px;font-size:10pt;weight:bold;">구단<span style="color:red;weight:bold;">바로가기</span></p>
		<div style="margin-top:0px;">
		<a href="">
		<img src="images/logo/LG.jpg" alt="" style="width:50px;height:50px;"/>
		</a>
		<a href="">
		<img src="images/logo/Doosan.jpg" alt="" style="width:50px;height:50px;" />
		</a>
		<a href="">
		<img src="images/logo/Lotte.jpg" alt="" style="width:50px;height:50px;" />
		</a>
		<a href="">
		<img src="images/logo/Sk.jpg" alt="" style="width:50px;height:50px;"/>
		</a>
		<img src="images/logo/LG.jpg" alt="" style="width:50px;height:50px;" />
		<img src="images/logo/Doosan.jpg" alt=""  style="width:50px;height:50px;"/>
		<img src="images/logo/Lotte.jpg" alt=""  style="width:50px;height:50px;"/>
		<img src="images/logo/Sk.jpg" alt=""  style="width:50px;height:50px;"/>
		<img src="images/logo/LG.jpg" alt=""  style="width:50px;height:50px;"/>
		</div>
		</div>	
		
		
	</div>
	</div>
	</div>

		
		
	</div>
	<br/>
	<br/><br/><br/><br/><br/><br/><br/><br/>
	<!-- footer -->
      <div id="footer" style="margin-top:100px;">
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