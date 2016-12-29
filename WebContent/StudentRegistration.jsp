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
<title>Insert title here</title>
</head>

<%String e=request.getParameter("college_username");  %>
  <%   
        HttpSession sess=request.getSession();  
        session.setAttribute("college_username",e);   %> 
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
    Statement stm=con.createStatement();
    String sql="select * from collegesapproved where username='"+e+"'";
    ResultSet rs=stm.executeQuery(sql);
    %>

  <%while(rs.next()){ %>



<body>
<form action="StudentRegistrationServlet" method="post" enctype="multipart/form-data">
College ID: <input type="text" name="collegeid" value="<%=rs.getString(6) %>"/> <br />
Spark ID: <input type="text" name="sparkid" value="<%=rs.getString(2) %>"/> <br />
Student ID: <input type="text" name="studentid" placeholder="Student ID"/> <br />
Student Name: <input type="text" name="studentname" placeholder="Student Name"/> <br />
DAteOfBirth: <input type="text" name="dob" placeholder="Please Enter as DDMMYYYY(Ex:01011992)"/> <br />
Password: <input type="password" name="dob" placeholder="Don't Enter" readonly/> <br />
Gender
<input type="radio" name="gender" value="male">male
<input type="radio" name="gender" value="female">female
<input type="radio" name="gender" value="others">others
<br>
<select name="qualification">
<option value="">Select Qualification</option>
<option value="Inter">Inter</option>
<option value="Diplamo">Diplamo</option>
</select>
<br/>
Batch
<input type="text" name="batch" placeholder="YYYY"/> <br/>
Branch :
<select name="branch">
<option value="">Select Branch</option>
  <option value="MECH">MECH</option>
  <option value="CSE">CSE</option>
  <option value="ECE">ECE</option>
  <option value="IT">IT</option>
  <option value="EEE">EEE</option>
  <option value="CIVIL">CIVIL</option>
  <option value ="Others">Others</option>
  </select><br/>
 Section: <input type="text" name="section"  placeholder=""/> <br/>
 Contact No: <input type="text" name="contactno" placeholder=""/> <br/>
 ParentcontactNO:<input type="text" name="Parentcontactno" placeholder=""/> <br/>
  Email id: <input type="text" name="emailid" placeholder="...@gmail.com"/> <br/>
  <input type="file" name="photo" placeholder="Choose Photo" ><br />
   <input type="submit" value="Register Student"> <br/>


</form>
 <%} %>    
</body>
</html>