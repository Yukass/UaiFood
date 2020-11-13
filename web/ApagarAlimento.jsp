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
             <h1>Apagar Alimento</h1>
<form action ="FrontController?action=ApagarAlimento&operacao=apagar" method = "post">
            <table border=1  class=" col-lg-12 ">
            <tr>
            
                <td>Nome Comida</td>
                <td>Preço Comida</td>
                <td>Descrição Comida</td>

            </tr>
            <div><c:out value="${vazio}"/></div>
                <c:forEach items="${alimentos}" var="alimento">
                    <tr> <c:if test="${id == alimento.idLoja}">
                    <tr>
                        <td><c:out value="${alimento.nome}"/></td>
                        <td><c:out value="${alimento.preco}"/></td>
                        <td><c:out value="${alimento.descricao}"/></td>
                        <td><input type="radio" name="comida" value="${alimento.id}"></td>
                    </tr>
                    </c:if>
                </c:forEach>
        </table>
                <td><input type="submit" name="btnExcluir" value="Excluir"></td>
      </form>
    </body>
</html>