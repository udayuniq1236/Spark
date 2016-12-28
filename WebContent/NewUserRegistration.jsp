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
<title>Add College</title>
</head>
<%-- <% 
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

            %> --%>
<body>


<div class="col-md-4">
  
        <h1 align="center" style="color:white;"><b>Register Users</b></h1>              
</div>


      <div class="col-md-4" align="right">
                    <br><br>
                   <a href="index.html"> <input type="submit" value="logout" style="background-color: yellow; border:none; border-radius:6px; color:black; padding:6px;"></a>
                    </div>
                    </div>
                    </div>    
                    
                <h4 class="page-title" style="color:blue; font-weight: bold;text-align: center;">Fill The Below Details</h4><br><br>
                                
                <!-- Text Input -->
                <div class="container">
                <center>
				<form  action="logins/SparkAdminRegisterCollege" method="post">
                <div class="block-area" id="text-input" ng-app="">
                    
                    
                    
                    
                    <input class="form-control input-sm m-b-10" style="width:50%;" type="text" placeholder="College Name" value="<%=request.getParameter("collegename") %>"  name="collegename" readonly="readonly" required>
                    <input type="text" class="form-control m-b-10"  style="width:50%;" placeholder="College Code" value="<%=request.getParameter("collegecode") %>" name="collegecode" readonly="readonly" >
                    <input class="form-control input-sm m-b-10" style="width:50%;"  type="text" placeholder="Location" value="<%=request.getParameter("location") %>" name="location" readonly="readonly"  value="location">
                        
                    <div class="row">
                        <div class="col-lg-12">
                            <input type="text" class="form-control m-b-10"  style="width:50%;" placeholder="Principal Name" value="<%=request.getParameter("principalname") %>" readonly="readonly"   name="principalname" required>
                        </div>
                        
                        <div class="col-lg-12">
                            <input type="text" class="form-control m-b-10" style="width:50%;"  placeholder="User Name" name="username" required ng-model="username">
                        </div>
                        <div class="col-lg-12">
                            <input type="text" class="form-control m-b-10" style="width:50%;"  placeholder="Password" name="Password" required ng-model="password">
                        </div>
                        <div class="col-lg-12">
                            <input type="text" class="form-control m-b-10" style="width:50%;"  placeholder="Spark ID" name="sparkid" value="SPK<%=request.getParameter("id") %>" required>
                        </div>
                        
                        
                        <div class="col-lg-12">
                            <input type="text" class="form-control m-b-10" style="width:50%;"  placeholder="College Number" value="<%=request.getParameter("collegecontactno") %>" name="collegenumber" pattern="[0-9]+" title="only numbers" readonly="readonly"  required>
                        </div>
                        <div class="col-lg-12">
                            <input type="text" class="form-control m-b-10" style="width:50%;"  placeholder="Admin Name" value="<%=request.getParameter("adminname") %>" readonly="readonly"  name="adminname" value="">
                        </div>
						 <div class="col-lg-12">
                            <input type="text" class="form-control m-b-12" style="width:50%;"  placeholder="Admin Email ID" value="<%=request.getParameter("adminemailid") %>" readonly="readonly"  name="adminemailid" value="">
                        </div>
						

                       
                    </div>
                   <input type="hidden" name="collegealternativeno"  value=" <%=request.getParameter("collegealternativeno") %>" readonly="readonly">
                   <input type="hidden" name="collegeemailid"  value=" <%=request.getParameter("collegeemailid") %>"  readonly="readonly">
                    <%-- <input type="hidden" name="subject" value="PASSWORD GENERATED FROM KNIT APP">
                    <input type="hidden" name="password1"  value="Your EmailId : <%=request.getParameter("email") %>  And Password : {{password}}" readonly="readonly">
					 --%>
					 <br>
                   <center> <input type="submit" style="background-color:#00CCE5; border:none; border-radius:6px; color:white; padding:8px;" value="Register"></center>
                    
                </div>
                </div>
                </center>
				</form>
                
               

</body>
</html>