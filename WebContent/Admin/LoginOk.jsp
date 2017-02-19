<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<script type="text/javascript">
	 
	 <c:if test="${result != null}">
	 	alert("저희 KH Baseball에 오신것을 환영합니다!!!");
	 	location.href="/KHBaseball/LoginOk.do";
	 </c:if>
	 
	 <c:if test="${result == null}">
	 	alert("아이디 및 비밀번호를 다시확인해주세요!!");
	 	history.back();
	 </c:if>
	 </script>
</body>
</html>