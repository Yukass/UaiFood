/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import DAO.DAO;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Action;
import model.Loja;
import java.io.IOException;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author Yukas
 */
public class GravarLojaAction implements Action {

    public GravarLojaAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String operacao = request.getParameter("operacao");

        if (operacao.equals("abrirPagina")) {
            try {
                RequestDispatcher view = request.getRequestDispatcher("CadastroLoja.jsp");
                view.forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else if (operacao.equals("cadastrar")) {

            String nome = request.getParameter("txtNomeLoja");
            String cnpj = request.getParameter("txtCnpjLoja");
            String email = request.getParameter("txtEmailLoja");
            String senha = request.getParameter("txtSenhaLoja");
            String telefone = request.getParameter("txtTelefoneLoja");
            String cep = request.getParameter("txtCepLoja");
            String logradouro = request.getParameter("txtLogradouroLoja");
            String bairro = request.getParameter("txtBairroLoja");
            String numero = request.getParameter("txtNumeroLoja");
            String complemento = request.getParameter("txtComplementoLoja");
            String cidade = request.getParameter("txtCidadeLoja");
            String estado = request.getParameter("txtEstadoLoja");
            Long id = null;

            Loja loja = new Loja(cnpj);
            loja.setNome(nome)
                    .setEmail(email)
                    .setSenha(senha)
                    .setTelefone(telefone)
                    .setCep(cep)
                    .setLogradouro(logradouro)
                    .setBairro(bairro)
                    .setNumero(numero)
                    .setComplemento(complemento)
                    .setCidade(cidade)
                    .setEstado(estado);
            try {
                DAO.getInstance().salvar(loja);
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
}
