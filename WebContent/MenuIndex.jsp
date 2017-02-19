<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- logo -->
<span style="margin-left:60px;"><a href="/KHBaseball/Index.jsp"><img id="logo" src="images/mainlogo.gif"  style="height:50px;" /></a>
</span>
<!-- /logo -->

<!-- menu -->
<ul class="fancyNav" >
	<li id="home" ><a href="/KHBaseball/Index.jsp" class="homeIcon" >Home</a></li>
	<li id="news"><a href="/KHBaseball/Board/List.do" style="font-family: 'Nanum Pen Script', cursive;font-weight:bold;">공지사항</a></li>
	<li id="about"><a href="/KHBaseball/cast/PlaySchedule.do" style="font-family: 'Nanum Pen Script',cursive;font-weight:bold;">일정/결과</a></li>
	<li id="services"><a href="/KHBaseball/record/BatterRecord.do" style="font-family: 'Nanum Pen Script',cursive;font-weight:bold;">기록</a></li>
	<li id="contact"><a href="/KHBaseball/Rank/List1.do" style="font-family: 'Nanum Pen Script', cursive;font-weight:bold;">순위</a></li>
	<li id="contact"><a href="/KHBaseball/TeamData/LG.jsp" style="font-family:'Nanum Pen Script', cursive;font-weight:bold;">구단정보</a></li>
	<c:if test="${!empty teamId }">
	<li id="contact"><a href="/KHBaseball/Admin/Compare.do?teamId=${teamId}" style="font-weight:bold;font-family: 'Nanum Pen Script', cursive;">관리자</a></li>
	</c:if>
</ul>


