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
                        Flete N&uacutemero ${flete.fleteID}
                        <form action="ObtenerCargamentos.do" method="post">
                        <input type="hidden" value="${flete.fleteID}" name="theID">
                        <input type="hidden" value="${flete.fechaHoraRecoleccion}" name="fechaHoraRecoleccion">
                        <td>N&ordm Flete: <c:out value="${flete.fleteID}"/></td>
                        <td>Para el cliente: <c:out value="${flete.clienteNombre}"/></td>
                        <td>Zona de destino: <c:out value="${flete.zona}"/></td>
                        <td><input type="submit" value="Ver cargamentos"></td>
                        </form>
                        </tr>

                        <tr>
                        <form action="ObtenerRep.do" method="post">
                        <input type="hidden" value="${flete.fleteID}" name="theID">
                        <input type="hidden" value="${flete.fechaHoraRecoleccion}" name="fechaHoraRecoleccion">
                        <td>Chofer encargado: <c:out value="${flete.choferNombre}"/></td>
                        <td>Vehiculo designado: <c:out value="${flete.vehiculoID}"/></td>
                        <td>Kilometros aproximados: <c:out value="${flete.kilometros}"/> km</td> 
                        <td><input type="submit" value="Ver Repartos"></td>
                        </form>
                        </tr>



                        <tr>
                        <td>Fecha y hora de recolecci&oacuten: <c:out value="${flete.fechaHoraRecoleccion}"/></td>
                        <td>Direcci&oacute de recolecci&oacuten: <c:out value="${flete.direccionRecoleccion}"/></td>

                        <c:choose>
                        <c:when test="${flete.horaSalidaRecoleccion==null}">
                        <form action="ConfirmarRecoleccion.do" method="post">
                        <input type="hidden" value="${flete.fleteID}" name="theID">
                        <input type="hidden" value="${flete.fechaHoraRecoleccion}" name="fechaHoraRecoleccion">
                        <td>Maniobra al recolectar
                        Si<input type="radio" name="maniobraRecoleccion" value="True"/>
                        No<input type="radio" name="maniobraRecoleccion" value="False"/>
                        </td>
                        <td><input type="submit" value="Recoleccion Completada"></td>
                        </form>
                        </c:when>
                        <c:otherwise>
                        <td>Recolecci&oacuten completada a las:    
                        <c:out value="${flete.horaSalidaRecoleccion.hours}"/>
                        :
                        <c:out value="${flete.horaSalidaRecoleccion.minutes}"/>hrs
                        </td>
                        <td>Maniobra: 
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


                        <td>Fecha y hora de entrega: <c:out value="${flete.fechaHoraEntrega}"/></td>
                        <td>Direcci&oacuten de entrega: <c:out value="${flete.direccionEntrega}"/></td>

                        <c:choose>


                        <c:when test="${flete.horaSalidaEntrega==null}">

                        <form action="ConfirmarEntrega.do" method="post">

                        <input type="hidden" value="${flete.fleteID}" name="theID">

                        <input type="hidden" value="${flete.fechaHoraEntrega}" name="fechaHoraEntrega">

                        <input type="hidden" value="${flete.horaSalidaRecoleccion}" name="horaSalidaRecoleccion">

                        <td>Maniobra al entregar

                        Si<input type="radio" name="maniobraEntrega" value="True"/>
                        No<input type="radio" name="maniobraEntrega" value="False"/>
                        </td>

                        <td><input type="submit" value="Entrega Completada"></td>
                        </form>

                        </c:when>

                        <c:otherwise>
                        <td>Entrega completada a las:   
                        <c:out value="${flete.horaSalidaEntrega.hours}"/>
                        :
                        <c:out value="${flete.horaSalidaEntrega.minutes}"/>hrs
                        </td>
                        <td>Maniobra:  
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
                            <td>
                            Peso: ${flete.peso}kg
                            </td>
                            <td>
                            Precio: $${flete.precio}
                            </td>
                        </tr>
                    
                    <tr>
                    <table>

                    <form action="ObtenerFlete.do" method="post">
                    <input type="hidden" value="${flete.fleteID}" name="theID">

                    <input type="hidden" value="${flete.fechaHoraRecoleccion}" name="fechaHoraRecoleccion">

                    <td><input type="submit" value="Modificar flete"></td>
                    </form>

                    <form action="EliminarFlete.do" method="post">
                    <input type="hidden" value="${flete.fleteID}" name="idFlete">

                    <input type="hidden" value="${flete.fechaHoraRecoleccion}" name="fechaHoraRecoleccion">
                    <td><input type="submit" value="Eliminar"></td>
                    </form>
                    </table>
                    </tr>
                    </table>
                    </tr>
                </c:forEach>

            </center>
            <a href="Index.jsp">Men&uacute Principal</a>
        </c:when>
        <c:otherwise>
            <c:redirect url="Login.html"></c:redirect>
        </c:otherwise>
    </c:choose>
</body>
</html>