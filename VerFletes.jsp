<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="css/estilosFlete.css">
    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <title>Despliega Fletes</title>
    <style type="text/css">

    table,tr,td{
        font-family: "Roboto";
        border: solid;
        vertical-align: top;
    }
    </style>
</head>
<body>
    <div class="contenedor-formulario">
        <div class="wrap">
            <div class="formulario" name="formulario_registro">

                <c:choose>
                <c:when test="${sessionScope.usuario != null}">
                    <center>
                        <h1 style= "color:#303F9F"><strong>Ver fletes</strong></h1>
                        <h3 style= "color:#303F9F">${mensaje}</h3>
                        <br>
                        <br>
                        <c:forEach items="${ListaDeFletes}" var="flete">
                    <tr>
                    <center>
                    <table border="0.5px">
                                <tr>
                                <p style= "color:#303F9F">Flete Numero ${flete.fleteID}</p>
                                <form action="ObtenerCargamentos.do" method="post">
                                <input type="hidden" value="${flete.fleteID}" name="theID">
                                <input type="hidden" value="${flete.fechaHoraRecoleccion}" name="fechaHoraRecoleccion">
                                <td style= "color:#303F9F"><b>N&ordm Flete: </b><c:out value="${flete.fleteID}"/></td>
                                <td style= "color:#303F9F"><b>Para el cliente: </b><c:out value="${flete.clienteNombre}"/></td>
                                <td style= "color:#303F9F"><b>Zona de destino: </b><c:out value="${flete.zona}"/></td>
                                <td><input type="submit" value="Ver cargamentos"></td>
                                </form>
                                </tr>

                                <tr>
                                <form action="ObtenerRep.do" method="post">
                                <input type="hidden" value="${flete.fleteID}" name="theID">
                                <input type="hidden" value="${flete.fechaHoraRecoleccion}" name="fechaHoraRecoleccion">
                                <td style= "color:#303F9F"><b>Chofer encargado: </b><c:out value="${flete.choferNombre}"/></td>
                                <td style= "color:#303F9F"><b>Vehiculo designado: </b><c:out value="${flete.vehiculoID}"/></td>
                                <td style= "color:#303F9F"><b>Kilometros aproximados: </b><c:out value="${flete.kilometros}"/> km</td>
                                <td><input type="submit" value="Ver Repartos"></td>
                                </form>
                                </tr>



                                <tr>
                                <td style= "color:#303F9F"><b>Fecha y hora de recolecci&oacuten: </b><c:out value="${flete.fechaHoraRecoleccion}"/></td>
                                <td style= "color:#303F9F"><b>Dirección de recolecci&oacuten: </b><c:out value="${flete.direccionRecoleccion}"/></td>

                                <c:choose>
                                <c:when test="${flete.horaSalidaRecoleccion==null}">
                                <form action="ConfirmarRecoleccion.do" method="post">
                                <input type="hidden" value="${flete.fleteID}" name="theID">
                                <input type="hidden" value="${flete.fechaHoraRecoleccion}" name="fechaHoraRecoleccion">
                                <td style= "color:#303F9F"><b>Maniobra al recolectar</b></td>
                                    <td>
                                    <div class="input-group radio">
                                    <input type="radio" name="maniobraRecoleccion" id ="mani" value="True"/>
                                    <label for="mani">S&iacute;</label>
                                    <input type="radio" name="maniobraRecoleccion" id ="manio" value="False"/>
                                    <label for="manio">No</label>
                                    </div>
                                    </td>
                                <td style= "color:#303F9F"><input type="submit" value="Recoleccion Completada"></td>
                                </form>
                                </c:when>
                                <c:otherwise>
                                <td style= "color:#303F9F"><b>Recolecci&oacuten completada a las: </b>
                                <c:out value="${flete.horaSalidaRecoleccion.hours}"/>
                                :
                                <c:out value="${flete.horaSalidaRecoleccion.minutes}"/>hrs
                                </td>
                                <td style= "color:#303F9F"><b>Maniobra: </b>
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


                                <td style= "color:#303F9F"><b>Fecha y hora de entrega: </b><c:out value="${flete.fechaHoraEntrega}"/></td>
                                <td style= "color:#303F9F"><b>Direcci&oacuten de entrega: </b><c:out value="${flete.direccionEntrega}"/></td>

                                <c:choose>


                                <c:when test="${flete.horaSalidaEntrega==null}">

                                <form action="ConfirmarEntrega.do" method="post">

                                <input type="hidden" value="${flete.fleteID}" name="theID">

                                <input type="hidden" value="${flete.fechaHoraEntrega}" name="fechaHoraEntrega">

                                <input type="hidden" value="${flete.horaSalidaRecoleccion}" name="horaSalidaRecoleccion">

                                <td style= "color:#303F9F"><b>Maniobra al entregar</b></td>
                                    <td>
                                        <div class="input-group radio">
                                        <input type="radio" name="maniobraEntrega" id ="m" value="True"/>
                                        <label for="m">S&iacute;</label>
                                        <input type="radio" name="maniobraEntrega" id ="ma" value="False"/>
                                        <label for="ma">No</label>
                                        </div>
                                    </td>



                                <td><input type="submit" value="Entrega Completada"></td>
                                </form>

                                </c:when>

                                <c:otherwise>
                                <td style= "color:#303F9F"><b>Entrega completada a las: </b>
                                <c:out value="${flete.horaSalidaEntrega.hours}"/>
                                :
                                <c:out value="${flete.horaSalidaEntrega.minutes}"/>hrs
                                </td>
                                <td style= "color:#303F9F"><b>Maniobra: </b>
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
                                    <td style= "color:#303F9F">
                                    <b>Precio: </b>${flete.precio}
                                    </td>
                                </tr>

                            <tr>
                            <table>
                            <form action="ObtenerFlete.do" method="post">
                            <input type="hidden" value="${flete.fleteID}" name="theID">

                            <input type="hidden" value="${flete.fechaHoraRecoleccion}" name="fechaHoraRecoleccion">

                            <td><input type="submit" value="Modificar flete"></td>
                            </form>
                            <td><input type="submit" value="Modificar flete"></td>
                             </table>
                            </tr>
                            </table>
                            </tr>
                            </br>
                            </br>
                            </br>
                         </c:forEach>
                    </center>

                </c:when>
                <c:otherwise>
                    <c:redirect url="Login.html"></c:redirect>
                </c:otherwise>
                </c:choose>
                </div>
        </div>
         <a href="Index.jsp">Men&uacute</a>
    </div>
</body>
</html>