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
 * @author Yukas
 */
public class ApagarLojaAction implements Action{
      public ApagarLojaAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
         String operacao  = request.getParameter("operacao");
        
         if(operacao.equals("abrirPagina")){
              try {             
            RequestDispatcher view = request.getRequestDispatcher("ApagarLoja.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        }else if(operacao.equals("apagar")){
        
        try {
            HttpSession session = request.getSession();
            Long idLoja = Long.parseLong(session.getAttribute("usuario").toString());
            Loja loja = (Loja) DAO.getInstance().getObjeto(idLoja, Class.forName("model.Loja"));
            DAO.getInstance().excluir(loja);
            session.removeAttribute("usuario");
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