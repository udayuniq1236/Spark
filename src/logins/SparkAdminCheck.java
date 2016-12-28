package logins;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.Controller.RequestDispatcher;

import javax.servlet.*;

/**
 * Servlet implementation class SparkAdminCheck
 */
@WebServlet("/logins/SparkAdminCheck")
public class SparkAdminCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SparkAdminCheck() {
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
				
				
				String spark_username = request.getParameter("spark_username");
				String spark_password = request.getParameter("spark_password");
				
				
				try{
					
					Properties prop=new Properties();
		            String filename = "/database.properties";
		            javax.servlet.ServletContext context = getServletContext();
		            InputStream in = context.getResourceAsStream(filename);
		            prop.load(in);
		            in.close();

		            String driver=prop.getProperty("drivername");
		            String connectionURL = prop.getProperty("url");
		            String usernamedb = prop.getProperty("dbusername");
		            String passworddb = prop.getProperty("dbpassword");
		            Class.forName(driver);
		          Connection  con=DriverManager.getConnection(connectionURL,usernamedb,passworddb);
			
		PreparedStatement preparedStatement = con.prepareStatement("select spark_username, spark_password from sparkadmins where spark_username=? and spark_password=?");
					
					preparedStatement.setString(1,spark_username);
					preparedStatement.setString(2,spark_password);

					ResultSet rs = preparedStatement.executeQuery();
					if(rs.next()){
						/*String id=rs.getString("email");
						String pass1=rs.getString("password");
						RequestDispatcher rd=request.getRequestDispatcher("newindex.jsp");
						rd.forward(request, response);*/
						out.print("Login Success");
						/*RequestDispatcher rd=request.getRequestDispatcher("showrequests.jsp");
						rd.forward(request, response);*/
						
					}else{
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('please correct your username/password');");  
						out.println("</script>");
		
						//out.println("<b><h3 style=color:red;>Invalid Username/Password</h3></b>");
						/*RequestDispatcher rd=request.getRequestDispatcher("SparkAdminLogin.html");
						rd.include(request, response);*/
					}
					}
				catch(Exception e)
			    {
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('please correct your username/password');");  
					out.println("</script>");
					
					//out.println("<b><h3 style=color:red;>Invalid Username/Password</h3></b>");
					/*RequestDispatcher rd=request.getRequestDispatcher("SparkAdminLogin.html");
					rd.include(request, response);*/
			    }
					
				}
			}
