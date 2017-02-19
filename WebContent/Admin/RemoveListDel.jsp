<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KH 야구 프로젝트</title>
</head>
<body>

	<div>
		<script type="text/javascript">
	
		<c:if test="${result == 1}">
			alert("방출완료!!");
			location.href = "/KHBaseball/Admin/RemoveList.do?sel=${sel}";
		</c:if>
						
		<c:if test="${result == 0}">
			alert("방출실패!!");
			history.back();
		</c:if>
					
		</script>

	</div>


</body>
</html>