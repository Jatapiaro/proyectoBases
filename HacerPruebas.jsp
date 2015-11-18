<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Deslpiega contactos</title>
</head>
<body>

	<center>
		
		<table border="1">

			<tr>
				<td>Nombre</td>
				<td>Apellido</td>
				<td>Edad</td>
				<td>Telefono</td>
				<td>Ciudad</td>
			</tr>

		
		<c:forEach items="${ListaDeChoferes}" var="chofer">
				<tr>
					<td><c:out value="${chofer.nombreChofer}"/></td>
					<td><c:out value="${chofer.telefonoChofer}"/></td>
					<td><c:out value="${chofer.salarioChofer}"/></td>
				</tr>
		</c:forEach>

		</table>


	</center>

</body>
</html>