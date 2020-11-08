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
        <title>Ler Loja</title>
    </head>
    <body>
             <h1>Loja</h1>
         <form action ="FrontController?action=LerLoja&operacao=lerLoja" method = "post" name="ManterLoja">
            <table>
            <tr>
                <td>ID*:</td>
                <td><input type="text" name="txtIdLoja" value="${loja.id}" ></td>
            </tr>
            <tr>
                <td>Nome*:</td>
                <td><input pattern="^[A-Za-z].{3,45}$"  type="text" name="txtNomeLoja" value="${loja.nome}" ></td>
            </tr>
            <tr>
                <td>CNPJ*:</td>
                <td><input pattern="[0-9].{13}$" title="Utilize Apenas Numeros"  type="text" name="txtCnpjLoja" value="${loja.cnpj}" ></td>
            </tr>
             <tr>
                <td>Email*:</td>
                <td><input pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,45}$"   type="email" name="txtEmailLoja" value="${loja.email}" ></td>
            </tr> 
             <tr>
                <td>Senha*:</td>
                <td><input title="Minimo 6 digitos"  pattern=".{6,25}$"  type="password" name="txtSenhaLoja" value="${loja.senha}" ></td>
            </tr>
            <tr>
                <td>Telefone:</td>
                <td><input title="Exemplo: DDDXXXXXXXX" pattern=".{10,15}$" type="text" name="txtTelefoneLoja" value="${loja.telefone}" ></td>
            </tr>
             <tr>
                <td>CEP*:</td>
                <td><input pattern="[0-9].{7,10}$"  type="text" name="txtCepLoja" id="cep"  onblur="pesquisacep(this.value);" value="${loja.cep}" ></td>
            </tr>
            
             <tr>
                <td>Logradouro*:</td>
                <td><input  pattern="[A-Za-z].{4,45}"  type="text" name="txtLogradouroLoja" id="rua" value="${loja.logradouro}" ></td>
            </tr>
			<tr>
                <td>Bairro*:</td>
                <td><input pattern="[A-Za-z].{4,45}"  type="text" name="txtBairroLoja" id="bairro" value="${loja.bairro}" ></td>
            </tr>
             <tr>
                <td>Numero*:</td>
                <td><input pattern="[A-Za-z0-9].{0,10}"  type="text" name="txtNumeroLoja" value="${loja.numero}" ></td>
            </tr>
             <tr>
                <td>Complemento:</td>
                <td><input pattern="[A-Za-z].{2,45}"  type="text" name="txtComplementoLoja" value="${loja.complemento}" ></td>
            </tr>
             <tr>
                <td>Cidade*:</td>
                <td><input pattern="[A-Za-z].{4,25}"  type="text" name="txtCidadeLoja" id="cidade" value="${loja.cidade}" ></td>
            </tr>
             <tr>
                <td>Estado*:</td>
                <td><input  pattern="[A-Za-z]{2}"   title="Apenas a sigla" type="text" name="txtEstadoLoja" id="uf" value="${loja.estado}" ></td>
            </tr>
            
            </table>
                        <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
              </form>
            
    </body>
</html>