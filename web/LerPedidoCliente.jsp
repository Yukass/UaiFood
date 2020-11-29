<%-- 
    Document   : Front
    Created on : 23/10/2020, 18:11:52
    Author     : braia
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Perdido</title>
    </head>
    <body>
             <h1>Meus Pedidos</h1>

            <table border=1  class=" col-lg-12 ">
            <tr>
            
                <td>Total</td>
                <td>Status</td>
               
                

            </tr>
            <div><c:out value="${vazio}"/></div>
                <c:forEach items="${pedidos}" var="pedido">
                    <tr> <c:if test="${id == pedido.cliente.getId()}">
                    <tr>
                        <td><c:out value="${pedido.total}"/></td>
                        <td><c:out value="${pedido.status.nome}"/></td>
                        <c:forEach items="${pedido.getItensPedidos()}" var="item">
                        <tr><td>Nome Alimento: <c:out value="${item.getNomeAlimento()}"/> </td>
                            <td>Quantidade: <c:out value="${item.getQuantidade()}"/></td>
                            <td>Preco Unitario: <c:out value="${item.getPrecoUnitario()}"/></td>
                        
                        </tr>
                        </c:forEach>
                        
                    </tr>
                    </c:if>
                </c:forEach>
        </table>
                
    </body>
</html>