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
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Loja</h1>
        
         <form action ="FrontController?action=GravarLoja&operacao=${operacao}" method = "post" name="ManterLoja" onsubmit=" return validacaoLoja()">
            <table>
            <tr>
              
                <td><input type="hidden" name="txtIdLoja" value="${loja.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
            </tr>
            <tr>
                <td>Nome*:</td>
                <td><input pattern="^[A-Za-z].{3,45}$" required type="text" name="txtNomeLoja" value="${loja.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            <tr>
                <td>CNPJ*:</td>
                <td><input pattern="[0-12].{12}$" title="Utilize Apenas Numeros" required type="text" name="txtCnpjLoja" value="${loja.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>Email*:</td>
                <td><input pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,45}$" required  type="email" name="txtEmailLoja" value="${loja.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr> 
             <tr>
                <td>Senha*:</td>
                <td><input title="Minimo 6 digitos"  pattern=".{6,25}$" required type="password" name="txtSenhaLoja" value="${loja.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            <tr>
                <td>Telefone:</td>
                <td><input title="Exemplo: DDDXXXXXXXX" pattern=".{10,15}$" type="text" name="txtTelefoneLoja" value="${loja.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>CEP*:</td>
                <td><input pattern="[0-9].{6,10}$" required type="text" name="txtCepLoja" id="cep"  onblur="pesquisacep(this.value);" value="${loja.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            
             <tr>
                <td>Logradouro*:</td>
                <td><input  pattern="[A-Za-z].{4,45}" required type="text" name="txtLogradouroLoja" id="rua" value="${loja.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
			<tr>
                <td>Bairro*:</td>
                <td><input pattern="[A-Za-z].{4,45}" required type="text" name="txtBairroLoja" id="bairro" value="${loja.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>Numero*:</td>
                <td><input pattern="[A-Za-z0-9].{0,10}" required type="text" name="txtNumeroLoja" value="${loja.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>Complemento:</td>
                <td><input pattern="[A-Za-z].{2,45}"  type="text" name="txtComplementoLoja" value="${loja.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>Cidade*:</td>
                <td><input pattern="[A-Za-z].{4,25}" required type="text" name="txtCidadeLoja" id="cidade" value="${loja.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
             <tr>
                <td>Estado*:</td>
                <td><input  pattern="[A-Za-z]{2}" required  title="Apenas a sigla" type="text" name="txtEstadoLoja" id="uf" value="${loja.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            
            </table>
                        <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
              </form>
    </body>
</html>
