<%-- 
    Document   : LogarCliente
    Created on : 08/11/2020, 19:32:33
    Author     : braia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

          <form action ="FrontController?action=LogarCliente&operacao=logar" method = "post">
            <table>
            <tr>
              <td>Email:</td>
              <td><input  name="txtEmailCliente"></td>    
            </tr>
            <tr>
              <td>Senha:</td>
              <td><input type="password" name="txtSenhaCliente"></td>
            </tr>
            <tr>
            </table>
              <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
         </form>
    </body>
</html>
