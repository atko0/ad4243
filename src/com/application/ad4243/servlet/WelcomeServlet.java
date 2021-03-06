package com.application.ad4243.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.application.ad4243.dao.PMF;
import com.application.ad4243.model.*;

import javax.jdo.*;

/**
 *
 * @author g13943se
 */
//@WebServlet(name = "WelcomeServlet", urlPatterns = {"/WelcomeServlet"})
public class WelcomeServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        
        /////////////////////
        // DATA STORE TEST //
        // --------------- //
        // result: OK      //
        /////////////////////
        
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        
        /* 
        // make data
        try{
        	manager.makePersistent(new User(910, "fushide", "fushide", 500));
        }finally{ manager.close(); }
        */
        
        
        // load data
        /*
        try{
        	User testUser = manager.getObjectById(User.class, 910);
        	System.out.println("LOAD USER:"+testUser.getName()+"(ID:"+testUser.getUserId()+")");
        }catch(JDOObjectNotFoundException e){
        	e.printStackTrace();
        }finally{
        	manager.close();
        }
        */
        /////////////////////
        
        if(userName!=null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
