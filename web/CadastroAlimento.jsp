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
        <title>Cadastro Alimento</title>
    </head>
    <body>
             <h1>Cadrasto Alimento</h1>
         <form action ="FrontController?action=GravarAlimento&operacao=cadastrar" method = "post">
            <table>
            <tr>
                <td>NOME*:</td>
                <td><input pattern="^[A-Za-z].{3,45}$" required type="text" name="txtNomeAlimento" value="${alimento.nome}" ></td>
            </tr>
            <tr>
                <td>PREÇO*:</td>
                <td><input pattern='[0-9]+(\\.[0-9][0-9]?)?' title="XX,XX" required type="number" name="txtPrecoAlimento" value="${alimento.preco}" ></td>
            </tr>
             <tr>
                <td>DESCRIÇÃO*:</td>
                <td><input  pattern="[a-zA-Z].{5,45}$" required  type="text" name="txtDescricaoAlimento" value="${alimento.descricao}" ></td>
            </tr> 
            
            </table>
                        <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
              </form>
            
    </body>
</html>