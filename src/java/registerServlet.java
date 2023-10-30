/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rahul
 */
public class registerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
         String name=request.getParameter("name");
         String gender=request.getParameter("gender");
         String mobile=request.getParameter("mobile");
         String state=request.getParameter("state");
         String address=request.getParameter("address");
         String age=request.getParameter("age");
         String email=request.getParameter("email");
         String Omobile=request.getParameter("Omobile");
         String district=request.getParameter("district");
         String pinCode=request.getParameter("pinCode");
         String Password=request.getParameter("Password");
         
         
            
            RequestDispatcher dispatcher=null;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodInformation","root","Tomrancho@1");
                PreparedStatement pst=con.prepareStatement("insert into LoginDonar(name,Gender,Mobile,state,Address,age,email,district,pinCode,OMobile,password)values(?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, name);
                pst.setString(2, gender);
                pst.setString(3, mobile);
                pst.setString(4, state);
                pst.setString(5, address);
                pst.setString(6, age);
                pst.setString(7, email);
                pst.setString(8, district);
                
                
                pst.setString(9, pinCode);
                pst.setString(10, Omobile);
                pst.setString(11, Password);
                int rowCount=pst.executeUpdate();
                if(rowCount>0){
                   
                    response.sendRedirect("f1information.jsp");
                }
                else{
                    response.sendRedirect("donarLogin.html");
                    
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
