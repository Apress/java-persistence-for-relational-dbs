/*
 * SampleServlet.java
 *
 * Created on November 3, 2002, 9:43 PM
 */

package com.centare.strongbrownbag.cactus;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author  rsperko
 * @version
 */
public class SampleServlet extends HttpServlet {
    
    /** Initializes the servlet.
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
    }
    
    /** Destroys the servlet.
     */
    public void destroy() {
        
    }
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet is Running</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet is Running</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    
    public void saveToSession(HttpServletRequest request)
    {
    	String testparam = request.getParameter("testparam");
    	request.getSession().setAttribute("testAttribute", testparam);
    }
}
