<%-- 
    Document   : newjspindex
    Created on : 01/11/2020, 22:39:33
    Author     : Yukas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Uai Food</title>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <!-- Custom Theme files -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--webfont-->
        <link href='//fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Lobster+Two:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <!--Animation-->
        <script src="js/wow.min.js"></script>
        <link href="css/animate.css" rel='stylesheet' type='text/css' />
        <script>
            new WOW().init();
        </script>
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
                });
            });
        </script>
        <script src="js/simpleCart.min.js"></script>
    </head>
    <body>
        <div class="header">
            <div class="container">
                <div class="top-header">
                    <div class="logo">
                        <a href="index.jsp"><h1>Uai Food</h1></a>
                    </div>
                    <div class="queries">
                        <p>Duvidas? Ligue para nós, é grátis!<span>0800-0000-7777 </span><label>(11AM à 11PM) </label> </p>  

                    </div>

                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="menu-bar">
                <div class="container">
                    <div class="top-menu">
                        <ul>

                            <li class="active"><a href="index.jsp">Inicio</a></li>|
                                <% if (session.getAttribute("loja") == null) { %>
                                <% if (session.getAttribute("cliente") == null) { %>
                            <li><a href="FrontController?action=LogarLoja&operacao=abrirPagina">Logar Loja</a> </li>
                            <li><a href="FrontController?action=GravarLoja&operacao=abrirPagina">Registrar Loja</a> </li>
                                <% } %>
                                <% } else {%>
                            <li><a href="FrontController?action=LerLoja&operacao=abrirPagina">Editar Loja</a> </li>
                            <li><a href="FrontController?action=ApagarLoja&operacao=abrirPagina">Apagar Loja</a> </li> 
                            <li><a href="FrontController?action=GravarAlimento&operacao=abrirPagina">Cadastrar Alimento</a></li>
                            <li><a href="FrontController?action=CadastroCombo&operacao=abrirPagina">Cadastrar Combo</a></li>
                            <li><a href="FrontController?action=LerAlimento&operacao=abrirPagina">Pesquisar Alimento</a></li>
                            <li><a href="FrontController?action=ApagarAlimento&operacao=abrirPagina">Apagar Alimento</a></li>
                            <li><a href="FrontController?action=LerPedidoLoja&operacao=abrirPagina">Ver Pedidos</a></li>
                            <li><a href="FrontController?action=LogarLoja&operacao=deslogar">Deslogar Loja</a> </li>
                                <% } %>

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
                                <% }%>
                            <div class="clearfix"></div>
                        </ul>
                    </div>
                </div>
            </div>


    </body>
</html>