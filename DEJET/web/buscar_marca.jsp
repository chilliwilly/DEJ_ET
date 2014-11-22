<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Marca</title>
    </head>
    <body>
        <%@include file="WEB-INF/menu.jspf" %>
        <form action="<c:url value="/ListarServlet"/>" method="post">
            <table>
                <tr>
                    <td>Seleccione Marca</td>
                    <td>:</td>
                    <td>
                        <select name="cboMarca">
                            <c:forEach items="${lista}" var="lm">
                                <option value="${lm.id_marca}"><c:out value="${lm.descrip_marca}"/></option>
                            </c:forEach>                            
                        </select>
                    </td>
                    <td>
                        <input type="submit" value="Buscar">
                    </td>
                </tr>
            </table>        
            <br><br>
            <!--param.algo == m.valoriteracion ? "SELECTED":""-->
        </form>   
        <c:choose>
            <c:when test="${alista==null}">
                <%-- Salta el seleccione --%>
            </c:when>
            <c:when test="${empty alista}">
                <h3>No hay autos par amostrar</h3>
            </c:when>
            <c:otherwise>
                <c:if test="${alista!=null}">
                    <table border="1px" width="50%">
                        <tr>
                            <td>Patente</td>
                            <td>Marca</td>
                            <td>Año</td>
                            <td>Color</td>
                            <td>Aire</td>
                            <td>Airbag</td>
                            <td>ABS</td>                
                        </tr>
                        <c:forEach items="${alista}" var="la">
                            <tr>
                                <td><c:out value="${la.patente}"/></td>
                                <td><c:out value="${la.marca}"/></td>
                                <td><c:out value="${la.anio}"/></td>
                                <td><c:out value="${la.color}"/></td>
                                <td><c:out value="${la.aire ? 'Si' : 'No'}"/></td>
                                <td><c:out value="${la.airbag ? 'Si' : 'No'}"/></td>
                                <td><c:out value="${la.abs ? 'Si' : 'No'}"/></td>                
                            </tr>   
                        </c:forEach>
                    </table>
                </c:if>
            </c:otherwise>
        </c:choose>
    </body>
</html>