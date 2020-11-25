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
import model.Item_Pedido;
import model.Pedido;

/**
 *
 * @author Yukas
 */
public class ItemPedidoAction implements Action {

    public ItemPedidoAction() {
    }
    
 public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
          
        String operacao  = request.getParameter("operacao");
        
        if(operacao.equals("adicionar")){
              try {  
        request.setAttribute("alimentos", DAO.getInstance().getAllObjetos(Class.forName("model.Alimento")));
       // Long idAlimento = Long.parseLong(request.getParameter("idAlimento"));
        
        //Alimento alimento = (Alimento) DAO.getInstance().getObjeto(idAlimento, Class.forName("model.Alimento"));
        
        
        
        RequestDispatcher view = request.getRequestDispatcher("ClienteLerAlimentos.jsp");
        view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(LerAlimentoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}