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

        <script src="jquery-3.2.1.min.js"></script>
        <script>
            $(function () {
                $("#header").load("Header.jsp");
                $("#UploadImagem").load("UploadImagem.jsp");
            });
        </script>
    </head>
    <body>
        <div id="header"></div>
        <div class="content">
            <div class="main">
                <div class="container">
                    <div class="register">

                        <div class="special-offers-section-head text-center dotted-line"> <div class="special-offers-section" > <h1>Meus Pedidos</h1></br> </div></div>

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
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>