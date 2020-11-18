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
public class LerLojaAction implements Action{

    public LerLojaAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String operacao  = request.getParameter("operacao");
        
         if(operacao.equals("abrirPagina")){
              try {
            HttpSession session = request.getSession();
            Long idLoja = Long.parseLong(session.getAttribute("loja").toString());
            Loja loja = (Loja) DAO.getInstance().getObjeto(idLoja, Class.forName("model.Loja"));
            request.setAttribute("loja", loja);
 
            RequestDispatcher view = request.getRequestDispatcher("LerLoja.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(LerLojaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(operacao.equals("editar")){     
        String nome = request.getParameter("txtNomeLoja");
        String cnpj = request.getParameter("txtCnpjLoja");
        String email = request.getParameter("txtEmailLoja");
        String senha = request.getParameter("txtSenhaLoja");
        String telefone = request.getParameter("txtTelefoneLoja");
        String cep = request.getParameter("txtCepLoja");
        String logradouro = request.getParameter("txtLogradouroLoja");
        String bairro = request.getParameter("txtBairroLoja");
        String numero = request.getParameter("txtNumeroLoja");
        String complemento = request.getParameter("txtComplementoLoja");
        String cidade = request.getParameter("txtCidadeLoja");
        String estado = request.getParameter("txtEstadoLoja");
        Long id = null;
        
            Loja loja = new Loja(nome, cnpj, email, senha, telefone, cep, logradouro, bairro, numero,
                    complemento, cidade, estado);
            HttpSession session = request.getSession();
            Long idLoja = Long.parseLong(session.getAttribute("loja").toString());
            id = idLoja;
            loja.setId(id);
        try {          
            DAO.getInstance().salvar(loja);
            request.setAttribute("loja", loja);
            RequestDispatcher view = request.getRequestDispatcher("LerLoja.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LerLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

}