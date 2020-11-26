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
            
                <td>Id Pedido</td>               

            </tr>
            <c:if test="${msg != null}">
                    <div class="container alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Atenção</strong> ${msg}
                      
                    </div>
            </c:if>
            <div><c:out value="${vazio}"/></div>
                <c:forEach items="${pedidos}" var="pedido">
                    <tr> <c:if test="${id == pedido.getIdLoja() && pedido.getStatus().getNome() != 'Finalizado'}">
                    <tr>
                        <td><c:out value="${pedido.getId()}"/> </td>
                        <td><a href="FrontController?action=AtualizaPedido&operacao=abrirPagina&comando=preparar&idPedido=<c:out value="${pedido.getId()}"/>">Preparo</a></td>
                        <td><a href="FrontController?action=AtualizaPedido&operacao=abrirPagina&comando=despachar&idPedido=<c:out value="${pedido.getId()}"/>">Despacho</a></td>
                        <td><a href="FrontController?action=AtualizaPedido&operacao=abrirPagina&comando=entregar&idPedido=<c:out value="${pedido.getId()}"/>">Entregue</a></td>
                        <td><a href="FrontController?action=AtualizaPedido&operacao=abrirPagina&comando=finalizar&idPedido=<c:out value="${pedido.getId()}"/>">Finalizado</a></td>
                        <td><a href="FrontController?action=AtualizaPedido&operacao=abrirPagina&comando=cancelar&idPedido=<c:out value="${pedido.getId()}"/>">Cancelado</a></td>
                    </tr>
                    </c:if>
                </c:forEach>
        </table>
                
    </body>
</html>