<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/styles.css" />
<link rel="stylesheet" href="../css/main.css" type="text/css" />

    <!-- Including the Lobster font from Google's Font Directory -->
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster" />

<style type="text/css">
	h3 { text-align: center; }
	.tblForm {
		border: 1px solid gray;
		border-collapse: collapse;
		width: 600px;
		margin: 10px 20px;
	}
	
	.tblForm th, .tblForm td  {
		border: 1px solid gray;
		text-align: center;
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

#clickedTbl {
	border: 1px solid gray;
	width: 900px; height: 120px;
	border-collapse: collapse;
	text-align: center;
}

#clickedTbl tr{
	height: 30px;
}

#clickedTbl tr td {
	border: 1px solid gray;
	width: 110px;
	text-align: center;
}
#clickedTbl tr th {
	width: 50px;
}
#clickedTbl tr td span, .name1, .name2 {
	font-weight: bold;
	font-size: 13pt; 
	color: #354f99;
}




#clickedTbl tr td:nth-child(1) { width: 150px; }
#clickedTbl tr td:nth-child(4) { width: 150px; }

.clicked { 
width: 900px;
margin: 10px auto; }

.graph {
	border: 1px solid black;
	width: 270px;
	height: 335px;
	margin-left: auto;
	margin-top: 10px;
}

.tblClick {
	display: none;
}

.clickImg {
	width: 900px;
	height: 120px;
}

.tblGraph {
	float: left;
	width: 271px; height: 38px;
	border: 1px solid gray;
	margin-top: 12px;
	margin-left: 11px;
	border-collapse: collapse;
}
.tblGraph tr td {
	border: 1px solid gray;
	text-align: center;	
}
.tblGraph tr td:FIRST-CHILD {
	background-color: #1EA4FF;
}
.tblGraph tr td:nth-child(2) {
	background-color: #5FEE9E;
}
</style>

<!-- <script src="/KHBaseball/js/Chart.js"></script> -->
<script type="text/javascript">
	var checkNum = 0;
	var temp = 0, temp2 = 0, temp3 = 0;
	var m1 = 0;
	var m2 = 0;
  	var info = new Array();
  	var info2 = new Array();
	
 	
	function clean() {
		$(".clickImg").show();
		$(".tblClick").hide();
		
		$("."+temp3).css("background-color", "white");
		$("."+temp2).css("background-color", "white");
		$("."+temp).css("background-color", "white");
		checkNum = 0;
	}
	
	function change() {
		
	}
	
	function check(playerId, playerName, btAverage, still, homeRun, onBase, ops, slugging) { //선수 선택시 색 변경
		
		if(checkNum == 0){
			$(".clickImg").hide();
			$(".tblClick").show();
			
			$("."+playerId).css("background-color", "#1EA4FF");
			checkNum++;
			temp3 = playerId;
			$(".name1").html(playerName);
			$("#btAverage1").html(btAverage);
			$("#still1").html(still);
			$("#homeRun1").html(homeRun);
			$("#onBase1").html(onBase);
			$("#ops1").html(ops);
			$("#slugging1").html(slugging);
			$("#tdImg1").html("<img src='../images/face/"+playerName+".jpg' style='width:148px; height:118px;'/>");
			
		}
		else if(checkNum == 1){
				$(".name2").html(playerName);
				$("#btAverage2").html(btAverage);
				$("#still2").html(still);
				$("#homeRun2").html(homeRun);
				$("#onBase2").html(onBase);
				$("#ops2").html(ops);
				$("#slugging2").html(slugging);
				$("#tdImg2").html("<img src='../images/face/"+playerName+".jpg' style='width:148px; height:118px;'/>");
			if(temp3 == playerId){
				$(".clickImg").show();
				$(".tblClick").hide();
				
				$("."+temp3).css("background-color", "white");
				$("."+temp2).css("background-color", "white");
				$("."+temp).css("background-color", "white");
				$(".name2").html("이름");
				$(".name1").html("이름");
				$(".cell").html("0");
				
				temp3 = 0;
				checkNum = 0;
				m1 = 0;
				m2 = 0;
				setChart1(0,0,0,0,0,0,0);
				setChart3(0,0,0,0,0,0,0);
				return;
			}
			
			$("."+temp2).css("background-color", "white");
			$("."+playerId).css("background-color", "#5FEE9E");
			checkNum++;
			temp = playerId;
			
		}else if(checkNum == 2) {
				$(".name2").html(playerName);
				$("#btAverage2").html(btAverage);
				$("#still2").html(still);
				$("#homeRun2").html(homeRun);
				$("#onBase2").html(onBase);
				$("#ops2").html(ops);
				$("#slugging2").html(slugging);
				$("#tdImg2").html("<img src='../images/face/"+playerName+".jpg' style='width:148px; height:118px;'/>");
				
			if(temp3 == playerId){
				$(".clickImg").show();
				$(".tblClick").hide();
				
				$("."+temp3).css("background-color", "white");
				$("."+temp2).css("background-color", "white");
				$("."+temp).css("background-color", "white");
				$(".name2").html("이름");
				$(".name1").html("이름");
				$(".cell").html("0");
				
				checkNum = 0;
				m1 = 0;
				m2 = 0;
				setChart1(0,0,0,0,0,0,0);
				setChart3(0,0,0,0,0,0,0);
				return;
			}
			
			$("."+temp).css("background-color", "white");
			$("."+playerId).css("background-color", "#5FEE9E");
			checkNum = 1;
			temp2 = playerId;
		}		
	}
	
	//투수~~~~투수~~~~투수~~~~투수~~~~투수~~~~투수~~~~투수~~~~투수~~~~투수~~~~투수~~~~투수~~~
	function check2(playerId, playerName, pBangEo, pInning, pWin, pLose, pSave, pSamjin) { //선수 선택시 색 변경
	
		if(checkNum == 0){
			$(".clickImg").hide();
			$(".tblClick").show();
			
			
			$("."+playerId).css("background-color", "#1EA4FF");
			checkNum++;
			temp3 = playerId;
			$(".name3").html(playerName);
			$("#pBangEo1").html(pBangEo);
			$("#pInning1").html(pInning);
			$("#pWin1").html(pWin);
			$("#pLose1").html(pLose);
			$("#pSave1").html(pSave);
			$("#pSamjin1").html(pSamjin);
			$("#tdImg3").html("<img src='../images/face/"+playerName+".jpg' style='width:148px; height:118px;'/>");
			
		}
		else if(checkNum == 1){
			$(".name4").html(playerName);
			$("#pBangEo2").html(pBangEo);
			$("#pInning2").html(pInning);
			$("#pWin2").html(pWin);
			$("#pLose2").html(pLose);
			$("#pSave2").html(pSave);
			$("#pSamjin2").html(pSamjin);
			$("#tdImg4").html("<img src='../images/face/"+playerName+".jpg' style='width:148px; height:118px;'/>");
			if(temp3 == playerId){
				$(".clickImg").show();
				$(".tblClick").hide();
				
				$("."+temp3).css("background-color", "white");
				$("."+temp2).css("background-color", "white");
				$("."+temp).css("background-color", "white");
				$(".name4").html("이름");
				$(".name3").html("이름");
				$(".cell").html("0");
				
				temp3 = 0;
				checkNum = 0;
				m1 = 0;
				m2 = 0;
				setChart1(0,0,0,0,0,0,0);
				setChart3(0,0,0,0,0,0,0);
				return;
			}
			
			$("."+temp2).css("background-color", "white");
			$("."+playerId).css("background-color", "#5FEE9E");
			checkNum++;
			temp = playerId;
			
		}else if(checkNum == 2) {
			$(".name4").html(playerName);
			$("#pBangEo2").html(pBangEo);
			$("#pInning2").html(pInning);
			$("#pWin2").html(pWin);
			$("#pLose2").html(pLose);
			$("#pSave2").html(pSave);
			$("#pSamjin2").html(pSamjin);
			$("#tdImg4").html("<img src='../images/face/"+playerName+".jpg' style='width:148px; height:118px;'/>");
			if(temp3 == playerId){
				$(".clickImg").show();
				$(".tblClick").hide();
				
				$("."+temp3).css("background-color", "white");
				$("."+temp2).css("background-color", "white");
				$("."+temp).css("background-color", "white");
				$(".name4").html("이름");
				$(".name3").html("이름");
				$(".cell").html("0");
				
				checkNum = 0;
				m1 = 0;
				m2 = 0;
				setChart1(0,0,0,0,0,0,0);
				setChart3(0,0,0,0,0,0,0);
				return;
			}
			
			$("."+temp).css("background-color", "white");
			$("."+playerId).css("background-color", "#5FEE9E");
			checkNum = 1;
			temp2 = playerId;
		}
	}
</script>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="/KHBaseball/js/highcharts.js"></script>
<script src="/KHBaseball/js/highcharts-more.js"></script>
<script src="/KHBaseball/js/exporting.js"></script>
		
<script type="text/javascript">

 
  	function sel(pName, btAverage, slugging, onBase, ops, rbi, fourBall) {
  		if(m1 == 0) {
  			m1++;
  			info[0] = pName;
  			info[1] = btAverage;
  			info[2] = slugging;
  			info[3] = onBase;
  			info[4] = ops;
  			info[5] = rbi;
  			info[6] = fourBall;
  			
  			setChart1(pName, btAverage, slugging, onBase, ops, rbi, fourBall);
  			
  		} else {
  			setChart2(info,pName, btAverage, slugging, onBase, ops, rbi, fourBall );
  			/* info[0] = pName;
  			info[1] = btAverage;
  			info[2] = slugging;
  			info[3] = onBase;
  			info[4] = ops;
  			info[5] = rbi;
  			info[6] = fourBall; */
  		} 
  	}
  
  	
  	function sel2(pName, pWin, pSave, pHold, pSamjin, pBangEo, pInning) {
  		if(m2 == 0) {
  			m2++;
  			info2[0] = pName;
  			info2[1] = pWin;
  			info2[2] = pSave;
  			info2[3] = pHold;
  			info2[4] = pSamjin;
  			info2[5] = pBangEo;
  			info2[6] = pInning;
  			
  			setChart3(pName, pWin, pSave, pHold, pSamjin, pBangEo, pInning);
  			
  		} else {
  			setChart4(info2,pName,pWin, pSave, pHold, pSamjin, pBangEo, pInning);
  			/* info2[0] = pName;
  			info2[1] = btAverage;
  			info2[2] = slugging;
  			info2[3] = onBase;
  			info2[4] = ops;
  			info2[5] = rbi;
  			info2[6] = fourBall; */
  		} 
  	}
  	
  	
	function setChart1(pName, btAverage, slugging, onBase, ops, rbi, fourBall) {

		$('#container').highcharts({
		    chart: {
		        polar: true,
		        type: 'line'
		    },
		    
		    title: {
		        text: '타자 그래프 비교',
		        x: 0
		    },
		    
		    pane: {
		    	size: '80%'
		    },
		    
		    xAxis: {
		        categories: ['타율', '장타율', '출루율', 'OPS', 
		                'RBI', '볼넷'],
		        tickmarkPlacement: 'on',
		        lineWidth: 0
		    },
		        
		    yAxis: {
		        gridLineInterpolation: 'polygon',
		        lineWidth: 0,
		        min: 0
		    },
		    
		    legend: {
		        
		        verticalAlign: 'center',
		        y: 370,
		        layout: 'vertical'
		    },
		    
		    series: [{
		        name: pName,
		        data: [btAverage*10, slugging*10, onBase*10, ops*10, rbi*5, fourBall*5],
		        pointPlacement: 'on'
		    	
		    }
		    ]
		});
	}
	
	//-----------------------------------------------------------
	function setChart2(info,pName, btAverage, slugging, onBase, ops, rbi, fourBall) {
		$('#container').highcharts({
	        
		    chart: {
		        polar: true,
		        type: 'line'
		    },
		    
		    title: {
		        text: '타자 그래프 비교',
		        x: 0
		    },
		    
		    pane: {
		    	size: '80%'
		    },
		    
		    xAxis: {
		        categories: ['타율', '장타율', '출루율', 'OPS', 
				                'RBI', '볼넷'],
		        tickmarkPlacement: 'on',
		        lineWidth: 0
		    },
		        
		    yAxis: {
		        gridLineInterpolation: 'polygon',
		        lineWidth: 0,
		        min: 0
		    },
		    
		    legend: {
		        
		        verticalAlign: 'center',
		        y: 370,
		        layout: 'vertical'
		    },
		    
		    series: [{
		        name: 'Allocated Budget',
		        data: [info[1]*10, info[2]*10, info[3]*10, info[4]*10, info[5]*5, info[6]*5],
		        pointPlacement: 'on'
		    }, {
		        name: 'Actual Spending',
		        data: [btAverage*10, slugging*10, onBase*10, ops*10, rbi*5, fourBall*5],
		        pointPlacement: 'on'
		    }]
			
		});
	}
	
	
	function setChart3(pName, pWin, pSave, pHold, pSamjin, pBangEo, pInning) {

		$('#container2').highcharts({
		    chart: {
		        polar: true,
		        type: 'line'
		    },
		    
		    title: {
		        text: '투수 그래프 비교',
		        x: 0
		    },
		    
		    pane: {
		    	size: '80%'
		    },
		    
		    xAxis: {
		        categories: ['승','세이브','홀드','삼진','방어율','이닝'],
		        tickmarkPlacement: 'on',
		        lineWidth: 0
		    },
		        
		    yAxis: {
		        gridLineInterpolation: 'polygon',
		        lineWidth: 0,
		        min: 0
		    },
		    
		    legend: {
		        
		        verticalAlign: 'center',
		        y: 370,
		        layout: 'vertical'
		    },
		    
		    series: [{
		        name: pName,
		        data: [pWin, pSave, pHold,
		               pSamjin, pBangEo, pInning],
		        pointPlacement: 'on'
		    	
		    }
		    ]
		});
	}
	
	function setChart3(pName, pWin, pSave, pHold, pSamjin, pBangEo, pInning) {

		$('#container2').highcharts({
		    chart: {
		        polar: true,
		        type: 'line'
		    },
		    
		    title: {
		        text: '투수 그래프 비교',
		        x: 0
		    },
		    
		    pane: {
		    	size: '80%'
		    },
		    
		    xAxis: {
		        categories: ['승','세이브','홀드','삼진','방어율','이닝'],
		        tickmarkPlacement: 'on',
		        lineWidth: 0
		    },
		        
		    yAxis: {
		        gridLineInterpolation: 'polygon',
		        lineWidth: 0,
		        min: 0
		    },
		    
		    legend: {
		        
		        verticalAlign: 'center',
		        y: 370,
		        layout: 'vertical'
		    },
		    
		    series: [{
		        name: pName,
		        data: [pWin, pSave, pHold,
		               pSamjin, pBangEo, pInning],
		        pointPlacement: 'on'
		    	
		    }
		    ]
		});
	}
	
	function setChart4(info2,pName, pWin, pSave, pHold, pSamjin, pBangEo, pInning) {
		$('#container2').highcharts({
	        
		    chart: {
		        polar: true,
		        type: 'line'
		    },
		    
		    title: {
		        text: '투수 그래프 비교',
		        x: 0
		    },
		    
		    pane: {
		    	size: '80%'
		    },
		    
		    xAxis: {
		        categories: ['승','세이브','홀드','삼진','방어율','이닝'],
		        tickmarkPlacement: 'on',
		        lineWidth: 0
		    },
		        
		    yAxis: {
		        gridLineInterpolation: 'polygon',
		        lineWidth: 0,
		        min: 0
		    },
		    
		    legend: {
		        
		        verticalAlign: 'center',
		        y: 370,
		        layout: 'vertical'
		    },
		    
		    series: [{
		        name: 'Allocated Budget',
		        data: [info2[1], info2[2], info2[3],
		               info2[4], info2[5], info2[6]],
		        pointPlacement: 'on'
		    }, {
		        name: 'Actual Spending',
		        data: [pWin, pSave, pHold,
		               pSamjin, pBangEo, pInning],
		        pointPlacement: 'on'
		    }]
			
		});
	}
	
/* }); */
		</script>
</head>
<body style="background-image: url('./images/base3.jpg'); background-repeat: no-repeat; background-size: 100% 88%;">
	<div id="bg" >
        
		<div class="wrap" >
			
			<%@include file="../Menu.jsp" %>
			
			<!-- main -->
			<div id="main" >
	
	
			</br> </br> </br> </br> </br>
            <table id="subTitle" border="1px solid gray">

               <tr>
                  <th>&nbsp;관리자메뉴</th>
               </tr>
               <tr>
                  <td>&nbsp;<a style="color:red;"href="/KHBaseball/Admin/Compare.do?teamId=${teamId}">선수 관리</a></td>
               </tr>
               <tr>
                  <td>&nbsp;&nbsp;<a style="color:red;" href="/KHBaseball/Admin/Compare.do?teamId=${teamId}">- 선수 비교</a></td>
               </tr>
               <tr>
                  <td>&nbsp;&nbsp;<a style="color:black;"href="/KHBaseball/Admin/TeamCompare.do?teamId=${teamId}">- 팀 전력 비교</a></td>
               </tr>
               <tr>
                  <td>&nbsp;<a style="color:black;" href="/KHBaseball/Admin/RecomLineUp.do?teamId=${teamId}">선발 라인업 추천</a></td>
               </tr>
               <tr>
                  <td>&nbsp;<a style="color:black;" href="/KHBaseball/Admin/ScoutList.do?teamId=${teamId}">영입 추천</a></td>
               </tr>
               <tr>
                  <td>&nbsp;<a style="color:black;" href="/KHBaseball/Admin/RemoveList.do?teamId=${teamId}">방출 추천</a></td>
               </tr>

            </table>

            <div id="mainContent">
               <div id="flow">Home > 관리자메뉴 > 영입추천</div>
              
               <form method="POST" id="form">
			 <div id="tabs">
              <ul>
                <li><a href="#tabs-1" onclick="clean();">타자 리스트</a></li>
                <li><a href="#tabs-2" onclick="clean();">투수 리스트</a></li>
              </ul>
              <div id="tabs-1">
               
			 	<table id="tblForm" class="tblForm" style="float: left;">
			 		<tr>
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
			 		<c:forEach items="${compareList }" var="cdto">
			 		<tr onclick="check(${cdto.playerId}, '${cdto.playerName}',
			 			${cdto.battingAverage }, ${cdto.still}, 
			 			${cdto.homeRun}, ${cdto.onBase}, ${cdto.ops},
			 			${cdto.slugging});  
			 			sel('${cdto.playerName}',${cdto.battingAverage},
			 			${cdto.slugging},${cdto.onBase},${cdto.ops},
			 			${cdto.rbi},${cdto.fourBall});"
			 			 class="${cdto.playerId }" id="${cdto.playerId }">
			 			<td>
			 			${cdto.playerName}
			 			</td>
			 			<td>${cdto.atBat }</td>
			 			<td>${cdto.hits }</td>
			 			<td>${cdto.homeRun }</td>
			 			<td>${cdto.still }</td>
			 			<td>${cdto.samjin }</td>
			 			<td>${cdto.battingAverage }</td>
			 			<td>${cdto.onBase }</td>
			 			<td>${cdto.slugging }</td>
			 			<td>${cdto.ops }</td>
			 		</tr>
			 		</c:forEach>
			 		<tr>
			 			<td colspan="10" style="text-align: right;">
			 			<input type="button" value ="교체하기" onclick="change();"/>
			 			</td>
			 		</tr>
			 	</table>
				
				<table id="tblGraph" class="tblGraph">
					<tr>
						<td class="name1" style="width:136px; color: white;"></td>
						<td class="name2" style="width:136px;color: white;"></td>
					</tr>
				</table>
				<!-- 그래프~~~그래프~~~그래프~~~그래프~~~그래프~~~그래프~~~ --> 
				<!-- 그래프~~~그래프~~~그래프~~~그래프~~~그래프~~~그래프~~~ -->
			 	<div id="graph" class="graph" style="margin-top: 50px;">

				<div id="container" class="container" style=" height: 307px;"></div>

			 	</div>
			 	
			 	
			 	
			 	<hr style="clear: both;"/>
			 	
			 	<div id="clicked" class="clicked"> <!-- 클릭한 선수 -->
			 	<img src="../images/click.png" class="clickImg"/>
				<table id="clickedTbl" class="tblClick">
					<tr>
						<td rowspan="4" id="tdImg1"></td>
						<td colspan="4"><span id="name1" class="name1" style="font-weight: bold;">이름</span></td>
						<td rowspan="4" style="background-color: #999"><span style="font-size:20pt; font-weight:bold">VS</span></td>
						<td rowspan="4" id="tdImg2"></td>
						<td colspan="4"><span id="name2" class="name2">이름</span></td>
					</tr>
					<tr>
						<th>타율</th>
						<td><span id="btAverage1"></span></td>
						<th>도루</th>
						<td><span id="still1"></span></td>
						<th>타율</th>
						<td><span id="btAverage2" class="cell"></span></td>
						<th>도루</th>
						<td><span id="still2" class="cell"></span></td>
					</tr>
					<tr>
						<th>홈런</th>
						<td><span id="homeRun1"></span></td>
						<th>출루</th>
						<td><span id="onBase1"></span></td>
						<th>홈런</th>
						<td><span id="homeRun2" class="cell"></span></td>
						<th>출루</th>
						<td><span id="onBase2" class="cell"></span></td>
					</tr>
					<tr>
						<th>OPS</th>
						<td><span id="ops1"></span></td>
						<th>장타</th>
						<td><span id="slugging1"></span></td>
						<th>OPS</th>
						<td><span id="ops2" class="cell"></span></td>
						<th>장타</th>
						<td><span id="slugging2" class="cell"></span></td>
					</tr>
				</table>
			</div>
			 	
			 </div>
              <div id="tabs-2">
                <table id="tblForm" class="tblForm" style="float:left;">
			 		<tr>
			 			<th>선수명</th>
			 			<th>승</th>
			 			<th>패</th>
			 			<th>세이브</th>
			 			<th>홀드</th>
			 			<th>이닝</th>
			 			<th>안타</th>
			 			<th>홈런</th>
			 			<th>볼넷</th>
			 			<th>삼진</th>
			 			<th>자책</th>
			 			<th>방어율</th>
			 			
			 		</tr>
			 		<c:forEach items="${compareList2 }" var="cdto2">
			 		<tr onclick="check2(${cdto2.playerId}, '${cdto2.playerName }',${cdto2.pBangEo},
			 			${cdto2.pInning}, ${cdto2.pWin}, ${cdto2.pLose},
			 			${cdto2.pSave}, ${cdto2.pSamjin});
			 			sel2('${cdto2.playerName}',${cdto2.pWin},
			 			${cdto2.pSave},${cdto2.pHold},${cdto2.pSamjin},
			 			${cdto2.pBangEo},${cdto2.pInning});" class="${cdto2.playerId }">
			 			<td>${cdto2.playerName}</td>
			 			<td>${cdto2.pWin}</td>
			 			<td>${cdto2.pLose }</td>
			 			<td>${cdto2.pSave }</td>
			 			<td>${cdto2.pHold }</td>
			 			<td>${cdto2.pInning }</td>
			 			<td>${cdto2.pAnta }</td>
			 			<td>${cdto2.pHomerun }</td>
			 			<td>${cdto2.pBallnet }</td>
			 			<td>${cdto2.pSamjin }</td>
			 			<td>${cdto2.pJacheck }</td>
			 			<td>${cdto2.pBangEo }</td>
			 		</tr>
			 		</c:forEach>
			 		<tr>
			 			<td colspan="12" style="text-align: right;">
			 			<input type="button" value ="교체하기" onclick="change();"/>
			 			</td>
			 		</tr>
			 	</table>
			 	
			 	<table id="tblGraph" class="tblGraph" style="float:left;">
					<tr>
						<td class="name3" style="width:136px; color: white;"></td>
						<td class="name4" style="width:136px;color: white;"></td>
					</tr>
				</table>
				<!-- 그래프~~~그래프~~~그래프~~~그래프~~~그래프~~~그래프~~~ --> 
				<!-- 그래프~~~그래프~~~그래프~~~그래프~~~그래프~~~그래프~~~ -->
			 	<div id="graph2" class="graph" style="margin-top: 50px;">

				<div id="container2" class="container" style=" height:307px; width:267px;"></div>

			 	</div>
			 	
			 	<hr style="clear:both;"/>
			 	<!-- 투수~~~~~투수~~~~~투수~~~~~투수~~~~~투수~~~~~ -->
			 	<div id="clicked2" class="clicked"> <!-- 클릭한 선수 -->
			 	<img src="../images/click.png" class="clickImg" />
				<table id="clickedTbl" class="tblClick">
					<tr>
						<td rowspan="4" id="tdImg3"></td>
						<td colspan="4"><span id="name3" class="name3" style="font-weight: bold;">이름</span></td>
						<td rowspan="4" style="background-color: #999"><span style="font-size:20pt; font-weight:bold;">VS</span></td>
						<td rowspan="4" id="tdImg4"></td>
						<td colspan="4"><span id="name4" class="name4">이름</span></td>
					</tr>
					<tr>
						<th>방어</th>
						<td><span id="pBangEo1"></span></td>
						<th>이닝</th>
						<td><span id="pInning1"></span></td>
						<th>방어</th>
						<td><span id="pBangEo2" class="cell"></span></td>
						<th>이닝</th>
						<td><span id="pInning2" class="cell"></span></td>
					</tr>
					<tr>
						<th>승</th>
						<td><span id="pWin1"></span></td>
						<th>패</th>
						<td><span id="pLose1"></span></td>
						<th>승</th>
						<td><span id="pWin2" class="cell"></span></td>
						<th>패</th>
						<td><span id="pLose2" class="cell"></span></td>
					</tr>
					<tr>
						<th>세</th>
						<td><span id="pSave1"></span></td>
						<th>삼진</th>
						<td><span id="pSamjin1"></span></td>
						<th>세</th>
						<td><span id="pSave2" class="cell"></span></td>
						<th>삼진</th>
						<td><span id="pSamjin2" class="cell"></span></td>
					</tr>
				</table>
			</div> <!-- clicked -->
			
		</div> <!-- tab2 -->
			 	
      </div> <!-- tabs -->
            
            
    
			 </form> 
			
              </div> <!--MainContent -->
			</div>
			<!-- /main -->
			
			
			<div id="side">
			</div>
		</div>
		
		
		<%@include file="../footer.jsp" %>
	</div>
	
   <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/flick/jquery-ui.css" >
   
   <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
   <script type="text/javascript">
   <!--

	setChart1(0,0,0,0,0,0,0);
    setChart3(0,0,0,0,0,0,0);
      $( "#tabs" ).tabs();
   
   		
   //-->
   </script>
</body>
</html>





















