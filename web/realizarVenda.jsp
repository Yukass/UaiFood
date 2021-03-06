<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Uai Food</title>

        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script>
            $(document).ready(function () {

            var i = - 1;
                    adicionar = function () {

                    if ($("#quantidade").val() !== 0) {

                    i++;
                            var valorTotal = parseFloat($("#valorTotal").text());
                            var linha = $("<tr>");
                            var colunas = "";
                            var opcao = $("#alimento").find("option:selected");
                            valorTotal = valorTotal + (opcao.data('preco') * $("#quantidade").val());
                            var info = $("#alimento").val() + "," + $("#quantidade").val() + "," + opcao.data('preco') + "," + opcao.data('nome') + "," + valorTotal;
                            var txtValor = "txtIdAlimento" + i.toString();
                            colunas += '<td style="visibility:hidden;"><input type="text" name=' + txtValor + ' value=' + info + '>' + $("#alimento").val() + '</td>';
                            colunas += '<td>' + opcao.data('nome') + '</td>';
                            colunas += '<td data-quantidade=' + $("#quantidade").val() + '>' + $("#quantidade").val() + '</td>';
                            colunas += '<td data-preco=' + opcao.data('preco') + '>' + opcao.data('preco') + '</td>';
                            colunas += '<td><button type="button" class="btn btn-danger btn-xs" onclick="remover(this)">Excluir <span class="glyphicon glyphicon-trash"></span></button></td>';
                            colunas += '</tr>';
                            linha.append(colunas);
                            $("#tabela").append(linha);
                            $("#quantidade").val(null);
                            $("#valorTotal").text(valorTotal.toFixed(2));
                    }
                    };
                    adicionarCombo = function () {

                    var idCombo = $("#combo").val();
                            var listaAlimentos;
                            fetch('FrontController?action=LerAlimentosLoja&operacao=getCombo&idCombo=' + idCombo)
                            .then(response = > response.json())
                            .then((data) = > {
                            listaAlimentos = data.alimento;
                                    debugger;
                                    if (listaAlimentos !== null){

                            listaAlimentos.forEach(function(alimento){
                            i++;
                                    var valorTotal = parseFloat($("#valorTotal").text());
                                    var linha = $("<tr>");
                                    var colunas = "";
                                    valorTotal = valorTotal + (alimento.quantidade * alimento.precoUnitario);
                                    var info = alimento.idAlimento + "," + alimento.quantidade + "," + alimento.precoUnitario + "," + alimento.nomeAlimento + "," + valorTotal;
                                    var txtValor = "txtIdAlimento" + i.toString();
                                    colunas += '<td style="visibility:hidden;"><input type="text" name=' + txtValor + ' value=' + info + '>' + alimento.idAlimento + '</td>';
                                    colunas += '<td>' + alimento.nomeAlimento + '</td>';
                                    colunas += '<td data-quantidade=' + alimento.quantidade + '>' + alimento.quantidade + '</td>';
                                    colunas += '<td data-preco=' + alimento.precoUnitario + '>' + alimento.precoUnitario + '</td>';
                                    colunas += '<td><button type="button" class="btn btn-danger btn-xs" onclick="remover(this)">Excluir <span class="glyphicon glyphicon-trash"></span></button></td>';
                                    colunas += '</tr>';
                                    linha.append(colunas);
                                    $("#tabela").append(linha);
                                    $("#quantidade").val(null);
                                    $("#valorTotal").text(valorTotal.toFixed(2));
                            });
                            }
                            });
                    };
                    remover = function (item) {
                    var valorTotal = parseFloat($("#valorTotal").text());
                            var tr = $(item).closest('tr');
                            var quantidade = tr.find('td[data-quantidade]').data('quantidade');
                            var preco = tr.find('td[data-preco]').data('preco');
                            valorTotal = valorTotal - (quantidade * preco);
                            $("#valorTotal").text(valorTotal.toFixed(2));
                            tr.remove();
                    }

            $("#loja").change(function () {
            $("#tabela tr").remove();
                    var linha = $("<tr>");
                    var colunas = "";
                    colunas += '<td style="visibility:hidden;">Código</td>';
                    colunas += '<td>Alimento</td>';
                    colunas += '<td>Quantidade</td>';
                    colunas += '<td>Preço Unit.</td>';
                    colunas += '<td>Ação</td>';
                    colunas += '</tr>';
                    linha.append(colunas);
                    $("#tabela").append(linha);
                    $("#valorTotal").text(0);
            });
            });</script>
        <script>
                    $(function () {
                    $("#header").load("Header.jsp");
                            $("#UploadImagem").load("UploadImagem.jsp");
                    });        </script>

    </head>

    <body>
        <div id="header"></div>
        <div class="container">
            <form action ="FrontController?action=CadastroPedido&operacao=cadastrar&idLoja=${id}" method = "post">

                <div class="row">
                    <div class="col-sm-12 page-header">
                        <h1>Realizar Compra</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="loja">Loja</label>
                            <select class="form-control" id="loja" name="loja">
                                <c:forEach items="${lojas}" var="umLoja">
                                    <c:if test="${id == umLoja.getId()}">
                                        <option value="${umLoja.getId()}">${umLoja.nome}</option>  
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="alimento">Alimento</label>
                            <select class="form-control" id="alimento" name="alimento">
                                <c:forEach items="${alimentos}" var="umAlimento">
                                    <c:if test="${id == umAlimento.idLoja}">
                                        <option value="${umAlimento.getId()}" 
                                                data-nome="${umAlimento.nome}"
                                                data-preco="${umAlimento.preco}">${umAlimento.nome}</option> 
                                    </c:if>
                                </c:forEach>

                            </select>
                        </div>

                        <div class="form-group">
                            <label for="quantidade">Quantidade</label>
                            <input type="number" id="quantidade" name="quantidade" class="form-control"><br><br>
                        </div>
                        <button onclick="adicionar()" type="button" class="btn btn-primary">Adicionar Item</button>
                        <br><br>


                        <div class="form-group">
                            <label for="combo">Combo</label>
                            <select class="form-control" id="combo" name="combo">
                                <c:forEach items="${combos}" var="umCombo">
                                    <c:if test="${id == umCombo.getIdLoja()}">
                                        <option value="${umCombo.getId()}" 
                                                >${umCombo.nome}</option> 
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>

                        <button onclick="adicionarCombo()" type="button" class="btn btn-primary">Adicionar Combo</button>
                        <br><br>

                    </div>
                    <div class="col-sm-6">
                        <div class="row">
                            <h2 align="right">
                                Valor Total - R$
                                <label id="valorTotal" name="valorTotal">0</label>
                            </h2>
                        </div>
                        <div class="row">
                            <table class="table table-striped table-bordered table-hover table-condensed" id="tabela">
                                <tr>
                                    <td style="visibility:hidden;">Código</td>
                                    <td>Alimento</td>
                                    <td>Quantidade</td>
                                    <td>Preço Unit.</td>
                                    <td>Ação</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <center>
                    <input type="radio" id="dinheiro" name="formaPagamentoTxt" value="Dinheiro" checked>
                    <label for="dinheiro">Dinheiro</label>
                    <input type="radio" id="debito" name="formaPagamentoTxt" value="Debito">
                    <label for="debito">Debito</label>
                    <input type="radio" id="ticket" name="formaPagamentoTxt" value="Ticket">
                    <label for="ticket">Ticket</label>
                    <button type="submit" class="btn btn-success">Finalizar Venda</button>
                </center>
            </form>
        </div>
    </body>

</html>