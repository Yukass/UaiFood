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
import model.Cliente;

/**
 *
 * @author Yukas
 */
public class LerClienteAction implements Action{
    
    public LerClienteAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Long idCliente = Long.parseLong(request.getParameter("txtIdCliente"));
            Cliente cliente = (Cliente) DAO.getInstance().getObjeto(idCliente, Class.forName("model.Cliente"));
            request.setAttribute("cliente", cliente);
            RequestDispatcher view = request.getRequestDispatcher("/LerCliente.jsp");
            view.forward(request, response);     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
}