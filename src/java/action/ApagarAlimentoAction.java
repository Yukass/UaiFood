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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Alimento;

/**
 *
 * @author Yukas
 */
public class ApagarAlimentoAction implements Action {

    public ApagarAlimentoAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
          
        String operacao  = request.getParameter("operacao");
        
        if(operacao.equals("abrirPagina")){
              try {          
        request.setAttribute("alimentos", DAO.getInstance().getAllObjetos(Class.forName("model.Alimento")));
        HttpSession session = request.getSession();
        String idLoja = session.getAttribute("loja").toString();
        request.setAttribute("id", idLoja);
        
        RequestDispatcher view = request.getRequestDispatcher("ApagarAlimento.jsp");
        view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(LerAlimentoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(operacao.equals("apagar")){
            try {
                
                Long idComida = Long.parseLong(request.getParameter("comida"));
                DAO.getInstance().excluir(idComida, Class.forName("model.Alimento"));
                
                request.setAttribute("alimentos", DAO.getInstance().getAllObjetos(Class.forName("model.Alimento")));
                HttpSession session = request.getSession();
                String idLoja = session.getAttribute("loja").toString();
                request.setAttribute("id", idLoja);
                RequestDispatcher view = request.getRequestDispatcher("ApagarAlimento.jsp");
                view.forward(request, response);
  
            } catch (ServletException ex) {
                Logger.getLogger(ApagarAlimentoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ApagarAlimentoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}