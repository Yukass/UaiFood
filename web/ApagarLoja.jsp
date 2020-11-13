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
        <title>Apaga Loja</title>
    </head>
    <body>
             <h1>Loja</h1>
         <form action ="FrontController?action=ApagarLoja&operacao=apagar" method = "post" >
            <table>
            <tr>
              <td>Deseja mesmo apagar?</td>
            </tr>
            <tr>
            </table>
                        <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
              </form>
            
    </body>
</html>