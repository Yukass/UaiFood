/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import DAO.DAO;
import controller.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;

/**
 *
 * @author braia
 */
public class LogarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String operacao = request.getParameter("operacao");

        if (operacao.equals("abrirPagina")) {
            try {
                RequestDispatcher view = request.getRequestDispatcher("LogarCliente.jsp");
                view.forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else if (operacao.equals("logar")) {

            try {
                String emailCliente = request.getParameter("txtEmailCliente");
                String senhaCliente = request.getParameter("txtSenhaCliente");
                Cliente cliente = (Cliente) DAO.getInstance().getLogin(emailCliente, Class.forName("model.Cliente"));
                if (cliente.getSenha().equals(senhaCliente)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("cliente", cliente.getId());
                    RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                    view.forward(request, response);
                } else {
                    RequestDispatcher view = request.getRequestDispatcher("/LogarCliente.jsp");
                    view.forward(request, response);
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (operacao.equals("deslogar")) {
            try {
                HttpSession session = request.getSession();
                session.removeAttribute("cliente");
                request.getSession(false);
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(LogarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
