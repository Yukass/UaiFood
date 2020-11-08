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
        <title>Cadastro Cliente</title>
    </head>
    <body>
             <h1>Cliente</h1>
         <form action ="FrontController?action=GravarCliente&operacao=cadastrar" method = "post" name="ManterCliente" onsubmit=" return validacaoCliente()">
            <table>
            <tr>
              
                <td><input type="hidden" name="txtIdCliente" value="${cliente.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
            </tr>
            <tr>
                <td>Nome*:</td>
                <td><input pattern="^[A-Za-z].{3,45}$" required type="text" name="txtNomeCliente" value="${cliente.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            <tr>
                <td>CPF*:</td>
                <td><input pattern="[0-9].{10}$" title="Utilize Apenas Numeros" required type="text" name="txtCpfCliente" value="${cliente.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>Email*:</td>
                <td><input pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,45}$" required  type="email" name="txtEmailCliente" value="${cliente.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr> 
             <tr>
                <td>Senha*:</td>
                <td><input title="Minimo 6 digitos"  pattern=".{6,25}$" required type="password" name="txtSenhaCliente" value="${cliente.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            <tr>
                <td>Telefone:</td>
                <td><input title="Exemplo: DDDXXXXXXXX" pattern=".{10,15}$" type="text" name="txtTelefoneCliente" value="${cliente.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>CEP*:</td>
                <td><input pattern="[0-9].{7,10}$" required type="text" name="txtCepCliente" id="cep"  onblur="pesquisacep(this.value);" value="${cliente.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            
             <tr>
                <td>Logradouro*:</td>
                <td><input  pattern="[A-Za-z].{4,45}" required type="text" name="txtLogradouroCliente" id="rua" value="${cliente.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
			<tr>
                <td>Bairro*:</td>
                <td><input pattern="[A-Za-z].{4,45}" required type="text" name="txtBairroCliente" id="bairro" value="${cliente.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>Numero*:</td>
                <td><input pattern="[A-Za-z0-9].{0,10}" required type="text" name="txtNumeroCliente" value="${cliente.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>Complemento:</td>
                <td><input pattern="[A-Za-z].{2,45}"  type="text" name="txtComplementoCliente" value="${cliente.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>Cidade*:</td>
                <td><input pattern="[A-Za-z].{4,25}" required type="text" name="txtCidadeCliente" id="cidade" value="${cliente.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>Estado*:</td>
                <td><input  pattern="[A-Za-z]{2}" required  title="Apenas a sigla" type="text" name="txtEstadoCliente" id="uf" value="${cliente.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            
            </table>
                        <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
              </form>
            
    </body>
</html>