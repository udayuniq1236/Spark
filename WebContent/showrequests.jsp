<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.InputStream.*" %>
<%@ page import="java.io.OutputStream.*" %>
<%@ page import="java.sql.Statement.*" %>
<%@ page import=" java.io.FileInputStream.*" %>
<%@page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Requests</title>
</head>
<% 
     Properties prop=new Properties();
     String filename = "/database.properties";
     ServletContext context = getServletContext();
     InputStream in = context.getResourceAsStream(filename);
     prop.load(in);
     in.close();

     
     String driver=prop.getProperty("drivername");
     String connectionURL = prop.getProperty("url");
     String usernamedb = prop.getProperty("dbusername");
     String passworddb = prop.getProperty("dbpassword");
     Class.forName(driver);
   Connection  con=DriverManager.getConnection(connectionURL,usernamedb,passworddb);
            Statement statement = con.createStatement();
				String location=request.getParameter("location");
				String apartmentname=request.getParameter("apartmentname");
				String goscode=request.getParameter("goscode");
        
            ResultSet resultset =
                statement.executeQuery("select * from collegereg order by time desc"); 

            %>
    <body>
                        <table class="table table-bordered table-hover tile">
                            <thead>
            <tr>
               
               <TH style="color:blue; font-weight:bold; font-size:18px;">College Name</TH>
                 <TH style="color:blue; font-weight:bold; font-size:18px;">College Code</TH>
                 <TH style="color:blue; font-weight:bold; font-size:18px;">College Location</TH>
                 
                <TH style="color:blue; font-weight:bold; font-size:18px;">College Email</TH>
                                  
                                 
                  
                <TH style="color:blue; font-weight:bold; font-size:18px;">College Contact Number</TH>
                 
              <TH style="color:blue; font-weight:bold; font-size:18px;">AddRequest</th>
                  <TH style="color:blue; font-weight:bold; font-size:18px;">DeleteRequest</TH>
            </tr>
            </thead>
                           <% while(resultset.next()){ %>
            <tbody>
            <TR>
              <form action="NewUserRegistration.jsp" method="post">
                <TD> <input hidden="hidden" readonly="readonly" name="collegename" value=<%= resultset.getString(2) %>><%= resultset.getString(2) %></TD>
                <TD> <input hidden="hidden" readonly="readonly" name="collegecode" value=<%= resultset.getString(3) %>><%= resultset.getString(3) %></TD>
                <TD> <input hidden="hidden" readonly="readonly" name="location" value=<%= resultset.getString(4) %>><%= resultset.getString(4) %></TD>
                 <input hidden="hidden" readonly="readonly" name="principalname" value=<%= resultset.getString(5) %>>
                <input hidden="hidden" readonly="readonly" name="adminname" value=<%= resultset.getString(6) %>>
                 <TD><input hidden="hidden" readonly="readonly" name="collegeemailid" value=<%= resultset.getString(10) %>> <%= resultset.getString(10) %></TD>
                  <TD> <input hidden="hidden" readonly="readonly" name="collegecontactno" value=<%= resultset.getString(8) %>><%= resultset.getString(8) %></TD>
                  <input hidden="hidden" readonly="readonly" name="adminemailid" value=<%= resultset.getString(7) %>>
                  <input hidden="hidden" readonly="readonly" name="collegealternativeno" value=<%= resultset.getString(9) %>>
                  <TD> <input hidden="hidden" readonly="readonly" name="id" value=<%= resultset.getString(1) %>><%= resultset.getString(1) %></TD> 
                 <td>
          <input type="submit" value="Add" class="btn btn-warning" style="background-color: yellow"></form>
                 
          <form action="del" method="post"><input  hidden="hidden" name="id" value=<%=resultset.getInt(1) %>><td>
   <input type="submit" value="Delete" class="btn btn-danger" style="background-color: yellow"></form>
               
</td>
                
                
                 
                 
                 
                 </TD>
               
            </TR>
            </tbody>
            <% } %>      
             </TABLE>
</body>
</html>