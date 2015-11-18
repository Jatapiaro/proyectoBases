<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<html>
<head>
	<title>Registro de Cargamento</title>
</head>
<body>
 

    <c:choose>
    	<c:when test="${sessionScope.usuario != null}">
			<center>
				<h1><strong>Registro de Cargamentos</strong></h1>
				<form action="RegistrarCargamento.do" method="post">
				<table>

					<input type="hidden" value="${fleteID}" name="idFromFlete">
					<tr>
						<td>
							Descripción del cargamento
						</td>
						<td>
							<input type="text" name="tipoCargamento">
						</td>	
					</tr>

					<tr>
						<td>
							Peso del cargamento
						</td>
						<td>
							<input type="text" name="pesoCargamento">
						</td>	
					</tr>

					<tr>
						<td>
							¿Es Delicado?
						</td>
						<td>
							Si<input type="radio" name="delicadoCargamento" value="True"/>
							No<input type="radio" name="delicadoCargamento" value="False"/>
						</td>	
					</tr>


					<tr>
						<td colspan="2" align="center"><input type="submit" value="Registrar Cargamento"></td>
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