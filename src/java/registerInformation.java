/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rahul
 */
public class registerInformation extends HttpServlet {

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
            out.println("<title>Servlet registerInformation</title>");            
            out.println("</head>");
            out.println("<body>");
            String state=request.getParameter("state");
            
            String district=request.getParameter("district");
            //out.println(district);
            String name=request.getParameter("name");
            //out.println(name);
            String Mnumber=request.getParameter("Mnumber");
            //out.println(Mnumber);
            String email=request.getParameter("email");
            //out.println(email);
            String address=request.getParameter("address");
            //out.println(address);
            String gender=request.getParameter("gender");
            //out.println(gender);
            String age=request.getParameter("age");
            //out.println(age);
            String weight=request.getParameter("weight");
            //out.println(weight);
            String Bloodgroup=request.getParameter("Bloodgroup");
            //out.println(Bloodgroup);
            String Bquantity=request.getParameter("Bquantity");
            //out.println(Bquantity);
            String HIV=request.getParameter("HIV");
            //out.println(HIV);
            String hepatitis=request.getParameter("hepatitis");
            //out.println(hepatitis);
            String hepatitisC=request.getParameter("hepatitisC");
            //out.println("hepatitisC");
            String HTLV=request.getParameter("HTLV");
            //out.println("HTLV");
            String syphilis=request.getParameter("syphilis");
            //out.println("syphilis");
            if(HIV.equals("No") && hepatitis.equals("No") && hepatitisC.equals("No") && HTLV.equals("No") && syphilis.equals("No")){
                
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodInformation","root","Tomrancho@1");
                 PreparedStatement pst=con.prepareStatement("insert into registerInformationn(state,district,name,MobileNumber,email,Address,gender,age,weight,bloodgroup,bloodquantity,HIV,hepatitis,hepatitisC,HTLV,syphilis)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                 pst.setString(1, state);
                 pst.setString(2, district);
                 pst.setString(3, name);
                 pst.setString(4, Mnumber);
                 pst.setString(5, email);
                 pst.setString(6, address);
                 pst.setString(7, gender);
                 pst.setString(8, age);
                 pst.setString(9, weight);
                 pst.setString(10, Bloodgroup);
                 pst.setString(11, Bquantity);
                 pst.setString(12, HIV);
                 pst.setString(13, hepatitis);
                 pst.setString(14, hepatitisC);
                 pst.setString(15, HTLV);
                 pst.setString(16, syphilis);
                 int rowCount=pst.executeUpdate();
                 out.println(rowCount);
                 if(rowCount>0){
                    
                    response.sendRedirect("index.html");
                }
                else{
                    response.sendRedirect("bookegistration.html");
                    
                }
                 }
            catch(Exception e){
                e.printStackTrace();
            }
            }
            else{
                out.println("You are Not applicable for donating blood");
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
