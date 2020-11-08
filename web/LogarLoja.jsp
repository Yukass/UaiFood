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
        <title>JSP Page</title>
    </head>
    <body>
        
          <form action ="FrontController?action=LogarLoja&operacao=logar" method = "post">
            <table>
            <tr>
              <td>Email:</td>
              <td><input name= "txtEmailLoja"></td>
            </tr>
            <tr>
              <td>Senha:</td>
              <td><input type="password" name="txtSenhaLoja"></td>
            </tr>
            </table>
              <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
         </form>
    </body>
</html>
