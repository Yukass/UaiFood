package controller;

import DAO.DAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet(name = "FrontController", urlPatterns = "/FrontController")
public class FrontController extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    String action = request.getParameter("action");
    Action actionObject=null;
    if(action==null || action.equals(""))
      response.sendRedirect("index.jsp");
    actionObject=ActionFactory.create(action);
    if(actionObject!=null)
      actionObject.execute(request, response);
    
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    processRequest(request, response);
  }
  

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    processRequest(request, response);
  }
  
  /** Returns a short description of the servlet.
   */
  public String getServletInfo() {
    return "Short description";
  }
  // </editor-fold>
}
