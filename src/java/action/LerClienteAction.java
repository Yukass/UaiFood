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
import model.Cliente;

/**
 *
 * @author Yukas
 */
public class LerClienteAction implements Action{

    public LerClienteAction() {
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String operacao  = request.getParameter("operacao");
        
         if(operacao.equals("abrirPagina")){
              try {
            HttpSession session = request.getSession();
            Long idCliente = Long.parseLong(session.getAttribute("cliente").toString());
            Cliente cliente = (Cliente) DAO.getInstance().getObjeto(idCliente, Class.forName("model.Cliente"));
            request.setAttribute("cliente", cliente);
 
            RequestDispatcher view = request.getRequestDispatcher("LerCliente.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(operacao.equals("editar")){     
        String nome = request.getParameter("txtNomeCliente");
        String cpf = request.getParameter("txtCpfCliente");
        String email = request.getParameter("txtEmailCliente");
        String senha = request.getParameter("txtSenhaCliente");
        String telefone = request.getParameter("txtTelefoneCliente");
        String cep = request.getParameter("txtCepCliente");
        String logradouro = request.getParameter("txtLogradouroCliente");
        String bairro = request.getParameter("txtBairroCliente");
        String numero = request.getParameter("txtNumeroCliente");
        String complemento = request.getParameter("txtComplementoCliente");
        String cidade = request.getParameter("txtCidadeCliente");
        String estado = request.getParameter("txtEstadoCliente");
        Long id = null;
        
            Cliente cliente = new Cliente(nome, cpf, email, senha, telefone, cep, logradouro, bairro, numero,
                    complemento, cidade, estado);
            HttpSession session = request.getSession();
            Long idCliente = Long.parseLong(session.getAttribute("cliente").toString());
            id = idCliente;
            cliente.setId(id);
        try {          
            DAO.getInstance().salvar(cliente);
            request.setAttribute("cliente", cliente);
            RequestDispatcher view = request.getRequestDispatcher("LerCliente.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

}