<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<html>
<head>
	<title>Registro de Clientes</title>
</head>
<body>
 

    <c:choose>
    	<c:when test="${sessionScope.usuario != null}">
			<center>
				<h1><strong>Registro de Cliente</strong></h1>
				<form action="RegistrarCliente.do" method="post">
					<table>


						<tr>
							<td>
								Nombre del Cliente
							</td>
							<td>
								<input type="text" name="nombreCliente">
							</td>	
						</tr>

						<tr>
							<td>
								Teléfono
							</td>
							<td>
								<input type="text" name="telefonoCliente">
							</td>	
						</tr>

						<tr>
							<td>
								Representante/Contacto del cliente
							</td>
							<td>
								<input type="text" name="contactoCliente">
							</td>	
						</tr>


						<tr>
							<td colspan="2" align="center"><input type="submit" value="Registrar"></td>
						</tr>

					</table>
				</form>
				<a href="Index.jsp">Menú Principal</a>
			</center>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.html"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>