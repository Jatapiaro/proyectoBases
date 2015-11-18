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
					<h1><strong>Registrar Flete</strong></h1>
						<form action="RegistrarFlete.do" method="post">
							<table>
								<tr>
									<td>Cliente que solicta el servicio</td>
									<td>
										<select name="elCliente">

										<c:forEach items="${ListaDeClientes}" var="cliente">

	  									<option value="${cliente.clienteID}">${cliente.nombreCliente}</option>
	  									</c:forEach>
									    </select>

									</td>	
								</tr>

								<tr>

									<td>Fecha y hora de recolección</td>
									<td>
										<input type="datetime-local" name="fechaHoraRecoleccion">
									</td>
		
								</tr>


								<tr>

									<td>
										Dirección de recolección
									</td>
									<td>
									<input type="text" name="direccionRecoleccion">
									</td>
		
									</tr>


									<tr>
										<td>
											Fecha y hora de entrega
										</td>
										<td>
											<input type="datetime-local" name="fechaHoraEntrega">
										</td>
									</tr>


									<tr>

										<td>
											Dirección de entrega
										</td>
										<td>
											<input type="text" name="direccionEntrega">
										</td>
							
									</tr>

								<tr>
									<td>Chofer Encargado</td>
									<td>
										<select name="elChofer">

										<c:forEach items="${ListaDeChoferes}" var="chofer">

	  									<option value="${chofer.usernameChofer}">${chofer.nombreChofer}</option>
	  									</c:forEach>
									    </select>

									</td>	
								</tr>	


									<tr>

										<td>
											Zona de Entrega
										</td>

										<td>
											Norte<input type="radio" name="zona" value="Norte"/>
											Sur<input type="radio" name="zona" value="Sur"/>
											Oriente<input type="radio" name="zona" value="Oriente"/>
											Poniente<input type="radio" name="zona" value="Poniente"/>
											Foráneo<input type="radio" name="zona" value="Foraneo"/>
										</td>	
							
									</tr>	

									<tr>

										<td>
											Kilometros
										</td>
											<input type="text" name="kilometros">
										<td>
										</td>	
							
									</tr>		

									<tr>
										<td colspan="2" align="center"><input type="submit" value="RegistrarFlete"></td>
									</tr>

						</table>
					</form>
				</center>
				<a href="Index.jsp"></a>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.html"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>