<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Test</title>
	

	<c:if test="${sessionScope.usuario != null}">
    There is a user **attribute** in the session
	</c:if>
	
</head>
<body>

</body>
</html>