<%-- 
    Document   : newjspindex
    Created on : 01/11/2020, 22:39:33
    Author     : Yukas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <% if (session.getAttribute("loja") == null) { %>
            <% if (session.getAttribute("cliente") == null) { %>
            <li><a href="FrontController?action=LogarLoja&operacao=abrirPagina">Logar Loja</a> </li>
            <li><a href="FrontController?action=GravarLoja&operacao=abrirPagina">Registrar Loja</a> </li>
             <% } %>
        <% } else {%>
        <li><a href="FrontController?action=LerLoja&operacao=abrirPagina">Editar Loja</a> </li>
        <li><a href="FrontController?action=ApagarLoja&operacao=abrirPagina">Apagar Loja</a> </li> 
        <li><a href="FrontController?action=GravarAlimento&operacao=abrirPagina">Cadastrar Alimento</a></li>
        <li><a href="FrontController?action=LerAlimento&operacao=abrirPagina">Pesquisar Alimento</a></li>
        <li><a href="FrontController?action=ApagarAlimento&operacao=abrirPagina">Apagar Alimento</a></li>
        <li><a href="FrontController?action=LogarLoja&operacao=deslogar">Deslogar Loja</a> </li>
        <% } %>
    

        <br/>
        <% if (session.getAttribute("cliente") == null) { %>
            <% if (session.getAttribute("loja") == null) { %>
            <li><a href="FrontController?action=LogarCliente&operacao=abrirPagina">Logar Cliente</a> </li>
            <li><a href="FrontController?action=GravarCliente&operacao=abrirPagina">Registrar Cliente</a> </li>
             <% } %>
        <% } else {%>
        <li><a href="FrontController?action=LerCliente&operacao=abrirPagina">Editar Cliente</a> </li>
        <li><a href="FrontController?action=ApagarCliente&operacao=abrirPagina">Apagar Cliente</a> </li>
        <li><a href="FrontController?action=LerLojas&operacao=abrirPagina">Lojas Comida</a> </li>
        <li><a href="FrontController?action=LerPedidoCliente&operacao=abrirPagina">Meus Pedidos</a> </li>
        <li><a href="FrontController?action=LogarCliente&operacao=deslogar">Deslogar Cliente</a> </li>
        <% } %>    
    

</body>
</html>