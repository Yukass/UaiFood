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
import model.Cliente;
import java.io.IOException;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author Yukas
 */
public class GravarClienteAction implements Action {

    public GravarClienteAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String operacao = request.getParameter("operacao");

        if (operacao.equals("abrirPagina")) {
            try {
                RequestDispatcher view = request.getRequestDispatcher("CadastroCliente.jsp");
                view.forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else if (operacao.equals("cadastrar")) {

            String nome = request.getParameter("txtNomeCliente");
            String cpf = request.getParameter("txtCpfCliente");
            String email = request.getParameter("txtEmailCliente");
            String senha = request.getParameter("txtSenhaCliente");
            String telefone = request.getParameter("txtTelefoneCliente");
            String cep = request.getParameter("txtCepCliente");
            String logradouro = request.getParameter("txtLogradouroCliente");
            String bairro = request.getParameter("txtBairroCliente");
            String numero = request.getParameter("txtNumeroCliente");
            String complemento = request.getParameter("txtComplementoCliente");
            String cidade = request.getParameter("txtCidadeCliente");
            String estado = request.getParameter("txtEstadoCliente");
            Long id = null;

            Cliente cliente = new Cliente(cpf);
            cliente.setNome(nome)
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
                DAO.getInstance().salvar(cliente);
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
