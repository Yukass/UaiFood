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
        <title>Ler Cliente</title>
    </head>
    <body>
       
         <h1>Cliente</h1>
         <form action ="FrontController?action=LerCliente&operacao=lerCliente" method = "post" name="ManterCliente">
            <table>
            <tr>
                <td>ID*:</td>
                <td><input type="text" name="txtIdCliente" value="${cliente.id}" ></td>
            </tr>
            <tr>
                <td>Nome*:</td>
                <td><input pattern="^[A-Za-z].{3,45}$"  type="text" name="txtNomeCliente" value="${cliente.nome}" ></td>
            </tr>
            <tr>
                <td>CPF*:</td>
                <td><input pattern="[0-9].{10}$" title="Utilize Apenas Numeros"  type="text" name="txtCpfCliente" value="${cliente.cpf}" ></td>
            </tr>
             <tr>
                <td>Email*:</td>
                <td><input pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,45}$"   type="email" name="txtEmailCliente" value="${cliente.email}" ></td>
            </tr> 
             <tr>
                <td>Senha*:</td>
                <td><input title="Minimo 6 digitos"  pattern=".{6,25}$"  type="password" name="txtSenhaCliente" value="${cliente.senha}" ></td>
            </tr>
            <tr>
                <td>Telefone:</td>
                <td><input title="Exemplo: DDDXXXXXXXX" pattern=".{10,15}$" type="text" name="txtTelefoneCliente" value="${cliente.telefone}" ></td>
            </tr>
             <tr>
                <td>CEP*:</td>
                <td><input pattern="[0-9].{7,10}$"  type="text" name="txtCepCliente" id="cep"  onblur="pesquisacep(this.value);" value="${cliente.cep}" ></td>
            </tr>
            
             <tr>
                <td>Logradouro*:</td>
                <td><input  pattern="[A-Za-z].{4,45}"  type="text" name="txtLogradouroCliente" id="rua" value="${cliente.logradouro}" ></td>
            </tr>
			<tr>
                <td>Bairro*:</td>
                <td><input pattern="[A-Za-z].{4,45}"  type="text" name="txtBairroCliente" id="bairro" value="${cliente.bairro}" ></td>
            </tr>
             <tr>
                <td>Numero*:</td>
                <td><input pattern="[A-Za-z0-9].{0,10}"  type="text" name="txtNumeroCliente" value="${cliente.numero}" ></td>
            </tr>
             <tr>
                <td>Complemento:</td>
                <td><input pattern="[A-Za-z].{2,45}"  type="text" name="txtComplementoCliente" value="${cliente.complemento}" ></td>
            </tr>
             <tr>
                <td>Cidade*:</td>
                <td><input pattern="[A-Za-z].{4,25}"  type="text" name="txtCidadeCliente" id="cidade" value="${cliente.cidade}" ></td>
            </tr>
             <tr>
                <td>Estado*:</td>
                <td><input  pattern="[A-Za-z]{2}"   title="Apenas a sigla" type="text" name="txtEstadoCliente" id="uf" value="${cliente.estado}" ></td>
            </tr>
            
            </table>
                        <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
              </form>
            
    </body>
</html>