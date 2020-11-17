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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Alimento;

/**
 *
 * @author Yukas
 */
public class GravarAlimentoAction implements Action {

    public GravarAlimentoAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
          
        String operacao  = request.getParameter("operacao");
        
        if(operacao.equals("abrirPagina")){
              try {
            RequestDispatcher view = request.getRequestDispatcher("CadastroAlimento.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        }
        else if(operacao.equals("cadastrar")){
        
        String nome = request.getParameter("txtNomeAlimento");
        String preco = request.getParameter("txtPrecoAlimento");
        
        preco = preco.replace(",",".");
        Double precoDouble = Double.parseDouble(preco);
        String descricao = request.getParameter("txtDescricaoAlimento");
        
        HttpSession session = request.getSession();
        Long idLoja = Long.parseLong(session.getAttribute("loja").toString());
        Long id = null;

        Alimento alimento = new Alimento(nome, precoDouble, descricao, idLoja);
        try {
            DAO.getInstance().salvar(alimento);
            RequestDispatcher view = request.getRequestDispatcher("CadastroAlimento.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    }
}