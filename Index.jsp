<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<style type="text/css">
		*{
			padding: 0px;
			margin: 0px;
		}

		#header{
			margin: auto;
			width: 650px;
			font-family: Arial, Helvetica, sans-serif; 
		}

		ul, cl {
			list-style: none;
		}

		.nav li a{
			background-color: #303f9f;
			color:#fff;
			text-decoration: none;
			padding: 10px 15px;
			display: block;


		}
		.nav li a:hover {
			background-color:#434343;
		}

		.nav > li{
			float: left;
		}

		.nav li ul{
			display: none;
			position: absolute;
			min-width: 140px;
		}

		.nav li:hover > ul{
		display:block;
		}

	</style>
	<title>MenuTransportes</title>
</head>
<body>


	<c:choose>
			<c:when test="${sessionScope.usuario != null &&sessionScope.rol == true}">

	<div id= "header">
		<ul class="nav">
			
			<li><a>Fletes</a>
			<ul>
				<li><a href="TraeClientesChoferes.do">Registrar Flete</a></li>
				<li><a href="RegistrarFlete.do">Consultar Pr&oacute;ximos Fletes</a></li>
				<li><a href="">Consultar Fletes Realizados</a></li>
			</ul>


			<li><a>Clientes</a>
			<ul>
				<li><a href="RegistroClientes.jsp">Registrar</a></li>
				<li><a href="RegistrarCliente.do">Consultar Clientes</a></li>

			</ul>	
			<li><a>Choferes</a>
				<ul>
				<li><a href="RegistroChofer.jsp">Registrar</a></li>
				<li><a href="RegistrarChofer.do">Consultar</a></li>
			</ul>	
		
			<li><a>Vehiculos</a>
				<ul>
				<li><a href="RegistrarVehiculo.jsp">Registrar</a></li>
				<li><a href="RegistrarVehiculo.do">Consultar</a></li>
			</ul>	

			</c:when>
			<c:otherwise>
				<c:redirect url="Login.html"></c:redirect>
			</c:otherwise>
	</c:choose>

</body>
</html>