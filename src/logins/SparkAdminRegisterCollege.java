package logins;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SparkAdminRegisterCollege
 */
@WebServlet("/logins/SparkAdminRegisterCollege")
public class SparkAdminRegisterCollege extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SparkAdminRegisterCollege() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		
		String collegename=request.getParameter("collegename");
		String collegecode=request.getParameter("collegecode");
		String location=request.getParameter("location");// this is for sending email
		String principalname=request.getParameter("principalname");
		String username=request.getParameter("username");
		String Password=request.getParameter("Password");
		String sparkid=request.getParameter("sparkid");
		String collegenumber=request.getParameter("collegenumber");
		String adminname=request.getParameter("adminname");
		 String adminemailid = request.getParameter("adminemailid");// this is for sending email
	        String collegealternativeno = request.getParameter("collegealternativeno");
	        String collegeemailid = request.getParameter("collegeemailid");// this is for sending email
	        try{
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
	          
	          String s1="delete from collegereg where collegecode ='"+collegecode+"'";
	          int upt = statement.executeUpdate(s1);
				PreparedStatement pstmt=con.prepareStatement("insert into collegesapproved(sparkid, username, password, collegename, collegecode, location, principalname, admin_name, admin_emailid, college_contactno, college_alternativeno, college_emailid) values(?,?,?,?,?,?,?,?,?,?,?,?)");
				 pstmt.setString(1, sparkid);
		          pstmt.setString(3, Password);
		          pstmt.setString(2, username);
				 pstmt.setString(4, collegename);
		          pstmt.setString(5, collegecode);
		          pstmt.setString(6, location);
		          pstmt.setString(7, principalname);
		          pstmt.setString(8, adminname);
		          pstmt.setString(9, adminemailid);
		          pstmt.setString(10, collegenumber);
		          pstmt.setString(11, collegealternativeno);
		          pstmt.setString(12, collegeemailid);

		          
			
		          int rs=pstmt.executeUpdate();
		          if(rs>0 && upt>0){
		        	   
		        	   out.println("Successfully Registered");
		        	 
		        	 /*  
		        	   try{
		        		   EmailUtility.sendEmail(host, port, user, pass, email, subject,
		 	                      password1);
		 	              resultMessage = "The e-mail was sent successfully";
		        	   }
		        	   catch (Exception ex) {
		                   ex.printStackTrace();
		                   //resultMessage = "There were an error: " + ex.getMessage();
		               }*/
		        	   
		        	  /* RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
		        		rd.include(request, response);*/
		           }
		           else{
		        	   out.println("<script type=\"text/javascript\">");  
						out.println("alert('registration failed try again');");  
						out.println("</script>");
		        	   /*RequestDispatcher rd=request.getRequestDispatcher("NewUserRegistration.jsp");
		        	   rd.include(request, response);*/
		           }
			
				}
				catch(Exception e){
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('data already exist');");  
					out.println("</script>");
					/*RequestDispatcher rd=request.getRequestDispatcher("NewUserRegistration.jsp");
		     	   rd.include(request, response);*/
					e.printStackTrace();
				}
				
				
				
				
			}

		}
