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
import model.Pedido;

/**
 *
 * @author Yukas
 */
public class LerPedidoClienteAction implements Action {

    public LerPedidoClienteAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
          
        String operacao  = request.getParameter("operacao");
        
        if(operacao.equals("abrirPagina")){
              try {          
        request.setAttribute("pedidos", DAO.getInstance().getAllObjetos(Class.forName("model.Pedido")));
        HttpSession session = request.getSession();
        String idCliente = session.getAttribute("cliente").toString();
        request.setAttribute("id", idCliente);
        
            
        RequestDispatcher view = request.getRequestDispatcher("LerPedidoCliente.jsp");
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