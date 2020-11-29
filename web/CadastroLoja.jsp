<%-- 
    Document   : CadastroLoja
    Created on : 23/10/2020, 18:12:16
    Author     : braia
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uai Food</title>
        <script type="text/javascript" >
            function limpa_formulário_cep() {
                document.getElementById('rua').value = ("");
                document.getElementById('bairro').value = ("");
                document.getElementById('cidade').value = ("");
                document.getElementById('uf').value = ("");
            }

            function meu_callback(conteudo) {
                if (!("erro" in conteudo)) {
                    //Atualiza os campos com os valores.
                    document.getElementById('rua').value = (conteudo.logradouro);
                    document.getElementById('bairro').value = (conteudo.bairro);
                    document.getElementById('cidade').value = (conteudo.localidade);
                    document.getElementById('uf').value = (conteudo.uf);
                } //end if.
                else {
                    //CEP não Encontrado.
                    limpa_formulário_cep();
                    alert("CEP não encontrado.");
                }
            }

            function pesquisacep(valor) {
                //Nova variável "cep" somente com dígitos.
                var cep = valor.replace(/\D/g, '');
                //Verifica se campo cep possui valor informado.
                if (cep != "") {
                    var validacep = /^[0-9]{8}$/; //expressão para validação do cep

                    //Valida o formato do CEP.
                    if (validacep.test(cep)) {
                        //Preenche os campos com "..." enquanto consulta webservice.
                        document.getElementById('rua').value = "...";
                        document.getElementById('bairro').value = "...";
                        document.getElementById('cidade').value = "...";
                        document.getElementById('uf').value = "...";
                        //Cria um elemento javascript.
                        var script = document.createElement('script');
                        //Sincroniza com o callback.
                        script.src = 'https://viacep.com.br/ws/' + cep + '/json/?callback=meu_callback';
                        //Insere script no documento e carrega o conteúdo.
                        document.body.appendChild(script);
                    } //end if.
                    else {
                        //cep é inválido.
                        limpa_formulário_cep();
                        alert("Formato de CEP inválido.");
                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
                }
            }
        </script>


        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <script src="js/validaCampo.js"></script>
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

        <!-- header-section-ends -->
        <!-- content-section-starts -->
        <div class="content">
            <div class="main">
                <div class="container">
                    <div class="register text-center">

                        <div class="special-offers-section-head text-center dotted-line"> <div class="special-offers-section" > <h1>Cadastrar Loja</h1></br> </div></div>

                        <form action ="FrontController?action=GravarLoja&operacao=cadastrar" method = "post" name="ManterLoja" onsubmit=" return validacaoLoja()">
                            <table style="margin:auto">
                                <tr>

                                    <td><input type="hidden" name="txtIdLoja" value="${loja.id}" ></td>
                                </tr>
                                <tr>
                                    <td>Nome*:</td>
                                    <td><input pattern="^[A-Za-z].{3,45}$" required type="text" name="txtNomeLoja" value="${loja.nome}" ></td>
                                </tr>
                                <tr>
                                    <td>CNPJ*:</td>
                                    <td><input pattern="[0-12].{13}$" title="Utilize Apenas Numeros" required type="text" name="txtCnpjLoja" value="${loja.cnpj}" ></td>
                                </tr>
                                <tr>
                                    <td>Email*:</td>
                                    <td><input pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,45}$" required  type="email" name="txtEmailLoja" value="${loja.email}" ></td>
                                </tr> 
                                <tr>
                                    <td>Senha*:</td>
                                    <td><input title="Minimo 6 digitos"  pattern=".{6,25}$" required type="password" name="txtSenhaLoja" value="${loja.senha}" ></td>
                                </tr>
                                <tr>
                                    <td>Telefone:</td>
                                    <td><input title="Exemplo: DDDXXXXXXXX" pattern=".{10,15}$" type="text" name="txtTelefoneLoja" value="${loja.telefone}" ></td>
                                </tr>
                                <tr>
                                    <td>CEP*:</td>
                                    <td><input pattern="[0-9].{6,10}$" required type="text" name="txtCepLoja" id="cep"  onblur="pesquisacep(this.value);" value="${loja.cep}" ></td>
                                </tr>

                                <tr>
                                    <td>Logradouro*:</td>
                                    <td><input  pattern="[A-Za-z].{4,45}" required type="text" name="txtLogradouroLoja" id="rua" value="${loja.logradouro}" ></td>
                                </tr>
                                <tr>
                                    <td>Bairro*:</td>
                                    <td><input pattern="[A-Za-z].{4,45}" required type="text" name="txtBairroLoja" id="bairro" value="${loja.bairro}" ></td>
                                </tr>
                                <tr>
                                    <td>Numero*:</td>
                                    <td><input pattern="[A-Za-z0-9].{0,10}" required type="text" name="txtNumeroLoja" value="${loja.numero}" ></td>
                                </tr>
                                <tr>
                                    <td>Complemento:</td>
                                    <td><input pattern="[A-Za-z].{2,45}"  type="text" name="txtComplementoLoja" value="${loja.complemento}" ></td>
                                </tr>
                                <tr>
                                    <td>Cidade*:</td>
                                    <td><input pattern="[A-Za-z].{4,25}" required type="text" name="txtCidadeLoja" id="cidade" value="${loja.cidade}" ></td>
                                </tr>
                                <tr>
                                    <td>Estado*:</td>
                                    <td><input  pattern="[A-Za-z]{2}" required  title="Apenas a sigla" type="text" name="txtEstadoLoja" id="uf" value="${loja.estado}" ></td>
                                </tr>

                            </table>
                                <br/><br/><br/>
                            <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>