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
public class EditarAlimentoAction implements Action {

    public EditarAlimentoAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
          
        String operacao  = request.getParameter("operacao");
        
        if(operacao.equals("abrirPagina")){
              try {          
        Long idComida = Long.parseLong(request.getParameter("id"));
        request.setAttribute("idComida", idComida);
        request.setAttribute("alimento", DAO.getInstance().getObjeto(idComida, Class.forName("model.Alimento")));
        RequestDispatcher view = request.getRequestDispatcher("EditarAlimento.jsp");
        view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(EditarAlimentoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(operacao.equals("editar")){
        String nome = request.getParameter("txtNomeAlimento");
        String preco = request.getParameter("txtPrecoAlimento");
        String descricao = request.getParameter("txtDescricaoAlimento");
        Long id = Long.parseLong(request.getParameter("idComida"));
        preco = preco.replace(",",".");
        Double precoDouble = Double.parseDouble(preco);   
        
        HttpSession session = request.getSession();
        Long idLoja = Long.parseLong(session.getAttribute("usuario").toString());

        Alimento alimento = new Alimento(nome, precoDouble, descricao, idLoja);
        alimento.setId(id);
        
        try {          
            DAO.getInstance().salvar(alimento);
            RequestDispatcher view = request.getRequestDispatcher("FrontController?action=LerAlimento&operacao=abrirPagina");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LerLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

}