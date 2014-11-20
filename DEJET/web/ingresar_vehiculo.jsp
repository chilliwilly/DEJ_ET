<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Vehiculo</title>
    </head>
    <body>
        <%@include file="WEB-INF/menu.jspf" %>
        <h1>Ingreso Nuevo Vehiculo</h1>
        <form action="<c:url value="/IngresarServlet"/>" method="post">
            <table>
                <tr>
                    <td>Patente</td>
                    <td>:</td>
                    <td>
                        <input type="text" style="text-transform: uppercase;" maxlength="6" required="true" name="txtPatente"
                               placeholder="Ingrese Patente">
                    </td>
                </tr>
                <tr>
                    <td>Marca</td>
                    <td>:</td>
                    <td>
                        <select name="cboMarca">
                            <c:forEach items="${lista}" var="lm">
                                <option value="${lm.id_marca}"><c:out value="${lm.descrip_marca}"/></option>
                            </c:forEach>                            
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Año</td>
                    <td>:</td>
                    <td>
                        <input type="number" maxlength="4" required="true" name="txtAnio"
                               placeholder="Ingrese Año">
                    </td>
                </tr>
                <tr>
                    <td>Color</td>
                    <td>:</td>
                    <td>
                        <input type="text" required="true" name="txtColor"
                               placeholder="Ingrese Color Ej: Rojo">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" name="chkAire">
                    </td>
                    <td colspan="2">Aire Acondicionado</td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" name="chkAB">
                    </td>
                    <td colspan="2">Air Bag</td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" name="chkABS">
                    </td>
                    <td colspan="2">Frenos ABS</td>
                </tr>
            </table>
            <br><br>
            <input type="submit" value="Ingresar"/>
            <br><br>
            <c:out value="${estado}"/>
        </form>
</html>
