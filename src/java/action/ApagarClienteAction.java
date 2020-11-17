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
 * @author Yukas
 */
public class ApagarClienteAction implements Action{
      public ApagarClienteAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
         String operacao  = request.getParameter("operacao");
        
         if(operacao.equals("abrirPagina")){
              try {             
            RequestDispatcher view = request.getRequestDispatcher("ApagarCliente.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        }else if(operacao.equals("apagar")){
        
        try {
            HttpSession session = request.getSession();
            Long idCliente = Long.parseLong(session.getAttribute("cliente").toString());
            Cliente cliente = (Cliente) DAO.getInstance().getObjeto(idCliente, Class.forName("model.Cliente"));
            DAO.getInstance().excluir(cliente);
            session.removeAttribute("cliente");
            request.getSession(false);
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            view.forward(request, response);     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    }
}