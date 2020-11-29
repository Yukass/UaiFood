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
import model.Combo;
import model.Item_Pedido;

/**
 *
 * @author Yukas
 */
public class CadastroComboAction implements Action {

    public CadastroComboAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
          
        String operacao  = request.getParameter("operacao");
        
        if(operacao.equals("abrirPagina")){
              try {   
        HttpSession session = request.getSession();
        String idLoja = session.getAttribute("loja").toString();
 
        request.setAttribute("alimentos", DAO.getInstance().getAllObjetos(Class.forName("model.Alimento")));
        request.setAttribute("lojas", DAO.getInstance().getAllObjetos(Class.forName("model.Loja")));
        request.setAttribute("id", idLoja);
        
        RequestDispatcher view = request.getRequestDispatcher("CadastroCombo.jsp");
        view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(LerAlimentoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(operacao.equals("cadastrar")){
              try {   
                  
        ArrayList<Item_Pedido> itensPedidos = new ArrayList();
        List<String> alimentos = new ArrayList();          
        
        int incrementoInt;
        String incrementoString;
        for (int i = 0; i < 20; i++) 
        {
            incrementoInt = i;
            incrementoString = Integer.toString(incrementoInt);
            String reconhece = request.getParameter("txtIdAlimento"+incrementoString);
            if(reconhece != null)
            alimentos.add(request.getParameter("txtIdAlimento"+incrementoString));
        }
        
            for (int i = 0; i < alimentos.size(); i++) {
            
            String[] textoSeparado = alimentos.get(i).split(",");
            Long idItemPedido = Long.parseLong(textoSeparado[0]);
            Integer quantidadeItemPedido = Integer.parseInt(textoSeparado[1]);
            Double valorUnitarioItemPedido = Double.parseDouble(textoSeparado[2]);
            String nomeItemPedido = textoSeparado[3];
            Item_Pedido item = new Item_Pedido(idItemPedido, quantidadeItemPedido, valorUnitarioItemPedido,nomeItemPedido);
            itensPedidos.add(item);
        }
        HttpSession session = request.getSession();
        String idLojaString = session.getAttribute("loja").toString();
        Long idLoja = Long.parseLong(idLojaString);
        String nomeCombo = request.getParameter("txtNomeCombo");
        Combo comboCriado = new Combo(nomeCombo, idLoja, itensPedidos);
        DAO.getInstance().salvar(comboCriado);

        request.setAttribute("alimentos", DAO.getInstance().getAllObjetos(Class.forName("model.Alimento")));
        request.setAttribute("lojas", DAO.getInstance().getAllObjetos(Class.forName("model.Loja")));
        request.setAttribute("id", idLoja);
        
         alimentos.clear();
         itensPedidos.clear();
        RequestDispatcher view = request.getRequestDispatcher("CadastroCombo.jsp");
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