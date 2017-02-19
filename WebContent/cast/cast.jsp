<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	height:500px;
	font-size: 10pt;
	
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
#right{border:3px solid gray;width:400px;height:400px;margin-left:30%;margin-top:20px; }

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
</script>
<script type="text/javascript">
	/* var interval = setInterval(function test() {
		$.ajax({
			type : "GET",
			url : "/KHBaseball/CastAjax.do"
		});
	}, 2000); */

	/* var interval1 = setInterval(function test() {
		var request = new XMLHttpRequest();
		request.open('GET', '/KHBaseball/test.do', false);
		request.send();
		//document.getElementById("right").innerHTML = request.responseText;
		var result = document.getElementById("right");
		//result.innerHTML = "";
		result.innerHTML = "<h3>"+request.responseText. + result.innerHTML;
	}, 10000); */

	/* setInterval(function() {
		$.ajax({
			url : '/KHBaseball/test.do',
			dataType : 'xml',
			success : function(data) {
				//alert(data);
				//alert(1);

				//jquery에서는 특정한 태그의 내용을 가져올 때
				//find("태그")를 이용하면 된다.
				$(data).find('event').each(function() { //각각에 대하여 작업을 하고싶으면 each에 function을 걸면된다.
					var output = "";
					output += "<div><h3>";
					output += $(this).find('name').text();
					output += $(this).find('item').text() + "</h3>"; //text()는 안의 내용을 나타낸다.
					output += "</div>";
					var result = document.getElementById("right");
					result.innerHTML = output + result.innerHTML;
				});
			}
		});
	}, 3000); */
	if ("${isEnd}" === "end") {
		alert("경기가 종료되었습니다.");
	} else {
		setInterval(function() {
			$.ajax({
				url : '/KHBaseball/CastAjax.do?hid=${hid}',
				dataType : 'xml',
				success : function(data) {
					//alert(data);
					//alert(1);

					//jquery에서는 특정한 태그의 내용을 가져올 때
					//find("태그")를 이용하면 된다.
					$(data).find('event').each(function() { //각각에 대하여 작업을 하고싶으면 each에 function을 걸면된다.
						//alert(1);
						var output = "";
						output += "<div><h3>";
						output += $(this).find('player').text() + " : ";
						output += $(this).find('eventName').text() + "</h3>"; //text()는 안의 내용을 나타낸다.
						output += "</div>";
						var result = document.getElementById("right");
						result.innerHTML = output + result.innerHTML;
					});
				}
			});
		}, 3000);
	}
	
	/* function callBack(xml) {
		var list = $(xml).find("item");
		var result = document.getElementById("right");
		
		result.innerHTML = "";
		for (i = 0; i < list.length; i++) {
			result.innerHTML = $(list[i]).text() + "<br>" + result.innerHTML;
		}
	} */
</script>
<link rel="stylesheet" href="../css/main.css" type="text/css" />
</head>
<body >
	<div id="bg" >
		<div class="wrap" >

			<!-- menu -->
			<%@include file="../Menu.jsp"%>

			<!-- main -->
			<div id="main">
				</br> </br> </br> </br> </br>
				<table id="subTitle" border="1px solid gray">

					<tr>
                  <th id="col">&nbsp;일정/결과 메뉴</th>
               </tr>
               <tr>
                  <td class="cel1"><a href="/KHBaseball/cast/playSchedule.do">&nbsp;<span style="color:red;weight:bold;">경기 일정</span></a></td>
               </tr>
               <tr>
                  <td class="cel1"><a href="/KHBaseball/cast/cast.do">&nbsp;중계</a></td>
               </tr>

				</table>

				<div id="mainContent">
					<div id="flow"><p style="font-size: 17pt;">Home > 일정/결과 > 중계</p></div>
					
					<div id="right">중계</div>
					
					
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


	<script type="text/javascript">
	<!--
		$("#tabs").tabs();
	//-->
	</script>
</body>
</html>