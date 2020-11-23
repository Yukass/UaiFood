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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Alimento;
import model.Item_Pedido;
import model.Pedido;
import model.PedidoEstadoRecebido;

/**
 *
 * @author Yukas
 */
public class CadastroPedidoAction implements Action {

    public CadastroPedidoAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
          
        String operacao  = request.getParameter("operacao");
        
         if(operacao.equals("cadastrar")){
        
        List<String> alimentos = new ArrayList();
        //List<String> idAlimento = new ArrayList();
        //List<String> qntAlimento = new ArrayList();
        //List<String> valorUnitarioAlimento = new ArrayList();
        ArrayList<Item_Pedido> itensPedidos = new ArrayList();
        
        
        int incrementoInt;
        String incrementoString;
        for (int i = 0; i < 4; i++) 
        {
            incrementoInt = i;
            incrementoString = Integer.toString(incrementoInt);
            String reconhece = request.getParameter("txtIdAlimento"+incrementoString);
            if(reconhece != null)
            alimentos.add(request.getParameter("txtIdAlimento"+incrementoString));
        }
        
        //501,3
        
        for (int i = 0; i < alimentos.size(); i++) {
            
            String[] textoSeparado = alimentos.get(i).split(",");
            //idAlimento.add(textoSeparado[0]);
            //qntAlimento.add(textoSeparado[1]);
            //valorUnitarioAlimento.add(textoSeparado[2]);
            Long idItemPedido = Long.parseLong(textoSeparado[0]);
            Integer quantidadeItemPedido = Integer.parseInt(textoSeparado[1]);
            Double valorUnitarioItemPedido = Double.parseDouble(textoSeparado[2]);
            Item_Pedido item = new Item_Pedido(idItemPedido, quantidadeItemPedido, valorUnitarioItemPedido);
            itensPedidos.add(item);
        }
          
        
          String[] valorTotalString = alimentos.get(alimentos.size() - 1).split(",");
          double valorTotal = Double.parseDouble(valorTotalString[3]);
          
          HttpSession session = request.getSession();
          Long idCliente = Long.parseLong(session.getAttribute("cliente").toString());
          
            try {
                Cliente cliente = (Cliente) DAO.getInstance().getObjeto(idCliente, Class.forName("model.Cliente")); 
                
              //alimento, quantidade, valorTotal
         
               Pedido pedido = new Pedido(valorTotal, cliente, "dinheiro", itensPedidos);    
               DAO.getInstance().salvar(pedido);
               alimentos.clear();
               itensPedidos.clear();
                
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastroPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
}