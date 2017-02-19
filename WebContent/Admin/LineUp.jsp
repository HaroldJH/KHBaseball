<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#subTbl{
	border: 1px solid gray;
	border-collapse: collapse;
	width: 320px; height:200px;
	margin: 10px auto;
}
#subTbl tr td{
	border: 1px solid gray;
	text-align: center;
	font-size: 11pt;
}
#subTbl tr { height: 25px; }
#subTbl tr:FIRST-CHILD{
	background-color: #1c2b4a;
	color: #fff;
	height: 30px;
}
#subTbl tr:nth-child(2) { background-color: #BDBDBD; }
.nname {
	color:#344f94;
	font-weight: bold;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

               		<table class="subTbl" id="subTbl">
               		<tr>
               		<%
               		String n = request.getParameter("n");
               		if(n.equals("1")){ %>
               			<th colspan="7">LG 타자 라인업</th>
               		<%} else if(n.equals("3")){ %>
               			<th colspan="7">SK 타자 라인업</th>
               		<%} else if(n.equals("4")){%>
               			<th colspan="7">두산 타자 라인업</th>
               		<%} %>
               		</tr>
               		<tr>
               			<th>타순</th>
               			<th>이름</th>
               			<th>타율</th>
               			<th>홈런</th>
               			<th>장타</th>
               			<th>안타</th>
               			<th>출루율</th>
               		</tr>
               		<%
               		
               		int i = 1;
               		
               		if(n.equals("1")){
               		%>
               		
               		<c:forEach items="${lgLineUp}" var="lg">
               			<tr>
               				<td><%=i %>번타자</td>
               				<td class="nname">${lg.playerName}</td>
               				<td>${lg.battingAverage}</td>
               				<td>${lg.homeRun}</td>
               				<td>${lg.slugging}</td>
               				<td>${lg.hits}</td>
               				<td>${lg.onBase }</td>
               			</tr>
               			<% i++; %>
               		</c:forEach>
               		<%} else if(n.equals("4")){%>
               		
               		<c:forEach items="${doosanLineUp}" var="doosan">
               			<tr>
               				<td><%=i %>번타자</td>
               				<td class="nname">${doosan.playerName}</td>
               				<td>${doosan.battingAverage}</td>
               				<td>${doosan.homeRun}</td>
               				<td>${doosan.slugging}</td>
               				<td>${doosan.hits}</td>
               				<td>${doosan.onBase }</td>
               			</tr>
               			<% i++; %>
               		</c:forEach>
               		
               		<%} else if(n.equals("3")){ %>
               		
               		<c:forEach items="${skLineUp}" var="sk">
               			<tr>
               				<td><%=i %>번타자</td>
               				<td class="nname">${sk.playerName}</td>
               				<td>${sk.battingAverage}</td>
               				<td>${sk.homeRun}</td>
               				<td>${sk.slugging}</td>
               				<td>${sk.hits}</td>
               				<td>${sk.onBase }</td>
               			</tr>
               			<% i++; %>
               		</c:forEach>
               		
               		<%} %>
               		</table>
</body>
</html>