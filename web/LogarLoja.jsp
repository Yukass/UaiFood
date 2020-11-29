<%-- 
    Document   : LogarLoja
    Created on : 08/11/2020, 19:32:22
    Author     : braia
--%>

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

            function confereEmail() {
                var confirmacao = documento.getElementById("log").value();
                        String
                regex = "[a-z._-]+@[a-z.]+"
                        Pattern
                pattern = Pattern.compile(regex);
                Matcher
                matcher = pattern.matcher(confirmacao);
                if (matcher.find() && matcher.group().equals(confirmacao)) {
                } else {
                    alert("Insira um email válido");
                }

            }

            < script >
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
            });
        </script>
    </head>
    <body>
        <div id="header"></div>
        <div class="container text-center">
            <div class="special-offers-section-head text-center dotted-line"> <div class="special-offers-section" > <h1>Logar Loja</h1></br> </div></div>

            <form action ="FrontController?action=LogarLoja&operacao=logar" method = "post">
                <table style="margin:auto">
                    <tr>
                        <td>Email:</td>
                        <td><input pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,25}$" required onBlur="confereEmail()" name= "txtEmailLoja"></td>
                    </tr>
                    <tr>
                        <td>Senha:</td>
                        <td><input pattern=".{6,25}$" required type="password" name="txtSenhaLoja"></td>
                    </tr>
                </table>
                <br/><br/><br/>
                <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
            </form>
        </div>
    </body>
</html>
