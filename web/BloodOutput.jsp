<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>



<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>e-RaktKosh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  </head>
  <body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
      <a href="http://localhost:9494/Blood/"><img src="Rakt5.png"></a>
     
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
            
          <a class="nav-link active" aria-current="page" href="Looking_for_bloo.html">Looking for Blood</a>
            
        </li>
        <li class="nav-item">
          <a class="nav-link" href="BloodAvailability.html">Blood Availability</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="checkForDonar.html">Check for Donar</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="about_Blood_donation.html">About blood donation</a>
        </li>
        
      </ul>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Login
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="donarLogin.html">Wants to Donate</a></li>
            <li><a class="dropdown-item" href="bookRegistration.html">Book a slot for donation</a></li>
            
          </ul>
        </li>
        
        
    </div>
  </div>
</nav>
      <br>
      
      <div class="container">
          <div class="row">
              <div class="col-1"></div>
              <div class="col-10">
                  <table class="table table-bordered">
                       <tr>
      <th scope="col">Sn No.</th>
      <th scope="col">Blood Bank</th>
      <th scope="col">Location</th>
      <th scope="col">Availability (in ml)</th>
      <th scope="col">Blood group</th>
    </tr>
     <%
        String state=request.getParameter("state");
        String district=request.getParameter("district");
        String BGroup=request.getParameter("BGroup");
        
        
                Connection con = null;

ResultSet resultSet = null;
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodInformation","root","Tomrancho@1");
            PreparedStatement pst=con.prepareStatement("select * from donarInformation where state=? and district=? and bloodgroup=?");
            pst.setString(1, state);
            pst.setString(2, district);
            pst.setString(3, BGroup);
            
            ResultSet rs=pst.executeQuery();
            int i=1;
            while(rs.next()){
            %>
            
           <tr>
                <td><h5><%=i %></h5></td>
                <td><h5><%=rs.getString("hospitalName") %></h5></td>
                <td><p><%=rs.getString("hospitalAddress") %></p></td>            
                <td><p><%=rs.getString("bloodquantity") %> (ml)</p></td>  
                <td><h3><%=rs.getString("bloodgroup") %></h3></td>
            </tr>
            
            <%
                i++;
            }
            }catch(Exception e){
                   e.printStackTrace();
               }
        %>
                  
                    </table>
              </div>
              <div class="col-1"></div>
          </div>
      </div>
    </body>
</html>
