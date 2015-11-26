<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/estilos2.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	<title>Ver Cargamentos</title>
	<style type="text/css">
	table, td, th{

		font-family: "Roboto";
		border: none;
		border-collapse: separate;
    	border-spacing: 10px;

	}

	td, th{
		padding: 5px;
	

	}
	th{
		background-color: #303F9F;
		color: #fff;
	}
	</style>
</head>
<body>
    <c:choose>
    	<c:when test="${sessionScope.usuario != null && sessionScope.rol == true}">
  	<center>
	<div class="contenedor-formulario">
		<div class="wrap">
			<div class="formulario" name="formulario_registro">
			<h2 style="color:#303F9F">Lista de repartos del flete #${fleteID}</h2>
			<br>
			<br>
			<h3 style="color:#${coloreado}">${mensaje}</h3>
				<div>
					<div class="input-group">
					</div>
					
						<table >
							<thead>
								<th>Direcci&oacuten</th>
								<th>Entregado</th>
								<th>Maniobra</th>
							</thead>

							<c:forEach items="${ListaDeRepartos}" var="reparto">
							<tr>
								<td style= "color:#303F9F">${reparto.direccion}</td>
                        		<td style= "color:#303F9F">
                        		<c:choose>
                        		<c:when test="${reparto.horaSalida==null}">
                        		Reparto no entregado
                        		</c:when>
                        		<c:otherwise>
                        		Reparto entregado a las ${reparto.horaSalida.hours}:${reparto.horaSalida.minutes}
                        		</c:otherwise>
                        		</c:choose>
                        		</td>

								<td style= "color:#303F9F">
								<c:choose>
                        		<c:when test="${reparto.horaSalida==null}">
                        		<form action="ConfirmarRepart.do" method="post">
								<input type="hidden" value="${fechaHoraRecoleccion}" name="fechaHoraRecoleccion">
								<input type="hidden" value="${reparto.repartoID}" name="repartoID">
								<input type="hidden" value="${fleteID}" name="fleteID">
                          		<div class="input-group radio">
                            	<input type="radio" name="maniobraRecoleccion" id= "MR2" value="True"/>
                            	<label for="MR2">S&iacute;</label>
                            	<input type="radio" name="maniobraRecoleccion" id= "MR" value="False"/>
                            	<label for="MR">No</label>
                        		</div>

                        		<td>
								<input type="hidden" value="${reparto.repartoID}" name="repartoID">
								<input type="submit" id="btn-submit" value="Confirmar Reparto" style="width:100%"></td>
								</form>
                        		</td>

                        		</c:when>
                        		<c:otherwise>
                        		<c:choose>
                        		<c:when test="${reparto.maniobra}">
                        		Si
                        		</c:when>
                        		<c:otherwise>
                        		No
                        		</c:otherwise>
                        		</c:choose>
                        		</c:otherwise>
                        		</c:choose>
                        		</td>



                         		<td>
                        		<form action="ObtenerReparto.do"method="post">
								<input type="hidden" value="${reparto.repartoID}" name="repartoID">
								<input type="hidden" value="${fleteID}" name="fleteID">
								<input type="hidden" value="${fechaHoraRecoleccion}" name="fechaHoraRecoleccion">

								<input type="submit" id="btn-submit" value="Editar Reparto" style="width:100%"></td>
								</form>
                        		</td>

                         		<td>
                        		<form action="EliminarReparto.do" method="post">
								<input type="hidden" value="${fechaHoraRecoleccion}" name="fechaHoraRecoleccion">
								<input type="hidden" value="${reparto.repartoID}" name="repartoID">
								<input type="hidden" value="${fleteID}" name="fleteID">
								<input type="submit" id="btn-submit" value="Eliminar" style="width:100%"></td>
								</form>
                        		</td>

							</tr>
							</c:forEach>

							<tr>							
							<form action="RedireccionRep.do" method="post">
							<input type="hidden" value="${fleteID}" name="fleteID">
							<input type="hidden" value="${fechaHoraRecoleccion}" name="fechaHoraRecoleccion">
						    <input type="submit" id="btn-submit2" value="Anadir Reparto" style="width:100%">
							</form>
							</tr>
							</table>
							</center>

				</div>
			</form>
		</div>
	</div>
	<a href="RegistrarFlete.do">Regresar a Fletes</a>

	<script src="js/formulario.js"></script>
	</c:when>
		<c:otherwise>
			<c:redirect url="Login.html"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>