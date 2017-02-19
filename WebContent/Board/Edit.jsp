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
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript">
	function send() {
		//글쓰기
		var form = document.forms[0];
		var memberId = document.getElementById("memberId");
		var title = document.getElementById("title");
		var content = document.getElementById("content");
		
	/* 	//유효성 검사(잘못된 부분 검사)
		if(memberId.value ==""	) {
			alert("이름을 입력하세요.");
			memberId.focus();
			return;
		}
		if(title.value == "") {
			alert("제목을 입력하세요.");
			title.focus();
			return;
		}
		if(content.value == ""	) {
			alert("내용을 입력하세요.");
			content.focus();
			return;
		} */
		
		form.submit();//글쓰기(데이터전송)
	}
</script>
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
                  <th>&nbsp;관리자메뉴</th>
               </tr>
               <tr>
                  <td>&nbsp;선수 관리</td>
               </tr>
               <tr>
                  <td>&nbsp;&nbsp;- 선수 비교</td>
               </tr>
               <tr>
                  <td>&nbsp;&nbsp;- 팀 전력 비교</td>
               </tr>
               <tr>
                  <td>&nbsp;선발 라인업 추천</td>
               </tr>
               <tr>
                  <td>&nbsp;영입추천</td>
               </tr>
               <tr>
                  <td>&nbsp;방출추천</td>
               </tr>

            </table>

            <div id="mainContent">
               <div id="flow">Home > 관리자메뉴 > 공지사항</div>
           <form method="POST" action="/KHBaseball/Board/EditOk.do">
	<table id="tblForm">
		<tr>
			<th class="left">글쓴이</th>
			<td class="right"><input type="text" name="memberid" id="memberid" class="short" value="${dto.memberId}"/></td>
		</tr>
		<tr>
			<th class="left">제목</th>
			<td class="right"><input type="text" name="title" id="title" class="long" value="${dto.title}"/></td>
		</tr>
		<tr>
			<th class="left">글내용</th>
			<td class="right"><textarea name="content" id="content" class="long" >${dto.content}</textarea></td>
		</tr>
             
             </table>
             <input type="hidden" name="memberId" value="${dto.noticeId}" />
             </form>
            </div>
        <input type="button" value="수정완료" onclick="send();"/>
    
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