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
        <title>Apaga Cliente</title>
    </head>
    <body>
             <h1>Cliente</h1>
         <form action ="FrontController?action=ApagarCliente&operacao=apagar" method = "post" name="ManterCliente" onsubmit=" return validacaoCliente()">
            <table>
            <tr>
              <td>ID*:</td>
              <td><input  name="txtIdCliente" value="${cliente.id}"></td>
            </tr>
            <tr>
            </table>
                        <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
              </form>
            
    </body>
</html>