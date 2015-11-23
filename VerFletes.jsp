<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
    <title>Deslpiega fletes</title>
</head>
<body>
    <c:choose>
        <c:when test="${sessionScope.usuario != null}">
            <center>
                <h1><strong>Ver fletes</strong></h1>
                <h1>${mensaje}</h1>
                <c:forEach items="${ListaDeFletes}" var="flete">
                    <table>
                    <tr>
                    <center>
                    <table border="1.0px">

                        <tr>
                        Flete Numero ${flete.fleteID}
                        <form action="ObtenerCargamentos.do" method="post">
                        <input type="hidden" value="${flete.fleteID}" name="theID">
                        <td>Nº Flete: </td><td><c:out value="${flete.fleteID}"/></td>
                        <td>Para el cliente: </td><td><c:out value="${flete.clienteNombre}"/></td>
                        <td><input type="submit" value="Ver cargamentos"></td>
                        </form>
                        </tr>

                        <tr>
                        <form action="" method="post">
                        <input type="hidden" value="${flete.fleteID}" name="theID">
                        <td>Chofer encargado: </td><td><c:out value="${flete.choferNombre}"/></td>
                        <td>Vehiculo designado: </td><td><c:out value="${flete.vehiculoID}"/></td>
                        <td><input type="submit" value="Ver Repartos"></td>
                        </form>
                        </tr>



                        <tr>
                        <td>Fecha y hora de recoleccion: </td><td><c:out value="${flete.fechaHoraRecoleccion}"/></td>
                        <td>Dirección de recolección: </td><td><c:out value="${flete.direccionRecoleccion}"/></td>

                        <c:choose>
                        <c:when test="${flete.horaSalidaRecoleccion==null}">
                        <form action="ConfirmarRecoleccion.do" method="post">
                        <input type="hidden" value="${flete.fleteID}" name="theID">
                        <input type="hidden" value="${flete.fechaHoraRecoleccion}" name="fechaHoraRecoleccion">
                        <td>Maniobra al recolectar</td>
                        <td>
                        Si<input type="radio" name="maniobraRecoleccion" value="True"/>
                        No<input type="radio" name="maniobraRecoleccion" value="False"/>
                        </td>
                        <td><input type="submit" value="Recoleccion Completada"></td>
                        </form>
                        </c:when>
                        <c:otherwise>
                        <td>Recoleccion completada a las:   
                        <c:out value="${flete.horaSalidaRecoleccion.hours}"/>
                        :
                        <c:out value="${flete.horaSalidaRecoleccion.minutes}"/>hrs
                        </td>
                        <td>Maniobra 
                        <c:choose>
                        <c:when test="${flete.recoleccionManiobra==true}">
                        S&iacute;
                        </c:when>
                        <c:otherwise>
                        No
                        </c:otherwise>
                        </c:choose>
                        </td>
                        </c:otherwise>
                        </c:choose>
                        </tr>

                        <tr>
                        <form action="ConfirmarEntrega.do" method="post">
                        <input type="hidden" value="${flete.fleteID}" name="theID">
                        <td>Fecha y hora de entrega: </td><td><c:out value="${flete.fechaHoraEntrega}"/></td>
                        <td>Dirección de entrega: </td><td><c:out value="${flete.direccionEntrega}"/></td>

                        <c:choose>
                        <c:when test="${flete.horaSalidaRecoleccion==null}"
                        <td>Maniobra al entregar</td>
                        <td>
                        Si<input type="radio" name="maniobraEntrega" value="True"/>
                        No<input type="radio" name="maniobraEntrega" value="False"/>
                        </td>

                        <form action="" method="post">
                        <td><input type="submit" value="Entrega Completada"></td>
                        </form>
                        </c:when>

                        <c:otherwise>
                        <td>Entrega completada a las:   
                        <c:out value="${flete.horaSalidaEntrega.hours}"/>
                        :
                        <c:out value="${flete.horaSalidaEntrega.minutes}"/>hrs
                        </td>
                        <td>Maniobra 
                        <c:choose>
                        <c:when test="${flete.entregaManiobra==true}">
                        S&iacute;
                        </c:when>
                        <c:otherwise>
                        No
                        </c:otherwise>
                        </c:choose>
                        </td>
                        </c:otherwise>
                        </c:choose>
                        </tr>
                    
                    <tr>
                    <table>
                    <td><input type="submit" value="Eliminar Flete"></td>
                    <td><input type="submit" value="Modificar flete"></td>
                    </table>
                    </tr>
                    </table>
                    </tr>
                </c:forEach>

            </center>
            <a href="Index.jsp">Menú Principal</a>
        </c:when>
        <c:otherwise>
            <c:redirect url="Login.html"></c:redirect>
        </c:otherwise>
    </c:choose>
</body>
</html>