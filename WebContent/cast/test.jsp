<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<% 
	//서블릿에게 데이터를 XML로 출력 처리 
	response.setContentType("text/xml");	
%>

<result>
	<c:forEach var="item" items="${event}">
	<event>
		<name>${item.playerName}</name>
		<item>${item.playerEvent }</item>
	</event>
	</c:forEach>
</result>

