/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import DAO.DAO;
import controller.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MainFactory;
import model.MementoManager;
import model.Pedido;

/**
 *
 * @author mathe
 */
public class MementoEstadoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
              String operacao  = request.getParameter("memento");
              String idPedidoString = request.getParameter("idPedido");
              Long idPedido = Long.parseLong(idPedidoString);
              HttpSession session = request.getSession();
              Pedido pedido;
        try {
            pedido = (Pedido) DAO.getInstance().getObjeto(idPedido, Class.forName("model.Pedido"));
            MementoManager mm = (MementoManager) session.getAttribute("mementoManager" + idPedidoString);
            String msg = "Sem historico para modificar";
              
            if(mm != null){
                MainFactory.invocarMemento(mm, operacao);
                pedido.setStatus(mm.atual());
                DAO.getInstance().salvar(pedido);
                if (operacao.equals("avancar")) {
                    msg = "Pedido avancado!";
                } else if(operacao.equals("retroceder")) {
                    msg = "Pedido retrocedido!";
                }
            }
            request.setAttribute("pedidos", DAO.getInstance().getAllObjetos(Class.forName("model.Pedido")));
            String idLoja = session.getAttribute("loja").toString();
            request.setAttribute("id", idLoja); 
            
            if(mm != null){
            session.setAttribute("mementoManager" + idPedidoString, mm);
            request.setAttribute("msg", msg+ " " + mm.index);
            }
            RequestDispatcher view = request.getRequestDispatcher("LerPedidoLoja.jsp");
            view.forward(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MementoEstadoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(MementoEstadoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
              
          

    }
}
