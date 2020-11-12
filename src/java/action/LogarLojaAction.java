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
import model.Loja;

/**
 *
 * @author braia
 */
public class LogarLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String operacao = request.getParameter("operacao");

        if (operacao.equals("abrirPagina")) {
            try {
                RequestDispatcher view = request.getRequestDispatcher("LogarLoja.jsp");
                view.forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else if (operacao.equals("logar")) {

            try {
                String emailLoja = request.getParameter("txtEmailLoja");
                String senhaLoja = request.getParameter("txtSenhaLoja");
                Loja loja = (Loja) DAO.getInstance().getLogin(emailLoja, Class.forName("model.Loja"));
                if (loja.getSenha().equals(senhaLoja)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("usuario", loja.getId());
                    RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                    view.forward(request, response);
                } else {
                    RequestDispatcher view = request.getRequestDispatcher("/LogarLoja.jsp");
                    view.forward(request, response);
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LerLojaAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(LerLojaAction.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (operacao.equals("deslogar")) {
            try {
                HttpSession session = request.getSession();
                session.removeAttribute("usuario");
                request.getSession(false);
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(LogarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
