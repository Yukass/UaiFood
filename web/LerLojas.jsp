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
        <title>Pesquisar Lojas</title>
    </head>
    <body>
             <h1>Pesquisar Lojas</h1>

            <table border=1  class=" col-lg-12 ">
            <tr>
            
                <td>Nome Loja</td>
                <td>Opção</td>

            </tr>
            <div><c:out value="${vazio}"/></div>
                <c:forEach items="${lojas}" var="lojas">
                    <tr>
                    <tr>
                        <td><c:out value="${lojas.nome}"/></td>
                        <td><a href="FrontController?action=LerAlimentosLoja&operacao=abrirPagina&id=<c:out value="${lojas.id}"/>">Entrar</a></td>
                    </tr>
                    
                </c:forEach>
        </table>
                
    </body>
</html>