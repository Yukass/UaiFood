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
import java.lang.reflect.Method;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Loja;
import model.MainFactory;
import model.MementoManager;
import model.Pedido;

/**
 *
 * @author Yukas
 */
public class AtualizaPedidoAction implements Action {

    public AtualizaPedidoAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
          
        String operacao  = request.getParameter("operacao");
        
        if(operacao.equals("abrirPagina")){
        try {
            
        String comando = request.getParameter("comando");
        String idPedidoString = request.getParameter("idPedido");
        Long idPedido = Long.parseLong(idPedidoString);  
        Pedido pedido = null;
        pedido = (Pedido) DAO.getInstance().getObjeto(idPedido, Class.forName("model.Pedido"));
        request.setAttribute("pedidos", DAO.getInstance().getAllObjetos(Class.forName("model.Pedido")));
        HttpSession session = request.getSession();
        String idLoja = session.getAttribute("loja").toString();
        request.setAttribute("id", idLoja);    
        
        MementoManager mm = new MementoManager(pedido.getStatus());
        boolean mudou = MainFactory.invocarMetodoFactory(pedido, comando);
        
         String msg;
        if (mudou) {
            msg = "O pedido mudou para " + pedido.getStatus().getNome();
            mm.adicionarMemento(pedido.getStatus());
            pedido.notificar();
        } else {
            msg = "Estado do pedido " + pedido.getStatus().getNome() + " não pode ser trocado!";
        }
        DAO.getInstance().salvar(pedido);
        request.setAttribute("msg", msg);

        
        
        RequestDispatcher view = request.getRequestDispatcher("LerPedidoLoja.jsp");
        view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(LerLojaAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(LerPedidoClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}