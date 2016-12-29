package logins;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import javax.servlet.http.*;



/**
 * Servlet implementation class StudentRegistration
 */
@WebServlet("/logins/StudentRegistrationServlet")
@MultipartConfig(maxFileSize = 16177215) 
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationServlet() {
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
		
		 InputStream inputStream = null;
	        Part filePart = request.getPart("photo");
	        String collegeid = request.getParameter("collegeid");
	        String sparkid = request.getParameter("sparkid");
	        String studentid = request.getParameter("studentid");
	        String studentname = request.getParameter("studentname");
	        String dob = request.getParameter("dob");
	        String password = request.getParameter("dob");
	        String gender = request.getParameter("gender");
	        String qualification = request.getParameter("qualification");
	        String batch = request.getParameter("batch");
	        String branch = request.getParameter("branch");
	        String section = request.getParameter("section");
	        String contactno = request.getParameter("contactno");
	        String Parentcontactno = request.getParameter("Parentcontactno");
	        String emailid = request.getParameter("emailid");
	        
	        if(qualification.equals("Inter")){
	        	int batch_add = Integer.parseInt(batch);
	        	int batch_add_new = batch_add+4;
	        	batch = batch+"-"+batch_add_new;
	        	System.out.println(batch);
	        }else{
	        	int batch_add = Integer.parseInt("batch");
	        	int batch_add_new = batch_add+3;
	        	batch = batch+"-"+batch_add_new;
	        	System.out.println(batch);
	        }
	        
	        
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	            
	            
	            try
	    		{
	    			
	    			
	    			
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
	    	

	System.out.println("connected");
	    				
	    				
	    				PreparedStatement pstmt=con.prepareStatement("insert into studentsdetails (collegeid, sparkid, studentid, studentname, password, dob, gender, qualification, batch, branch, section, contactno, Parentcontactno, emailid, photo) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	    				pstmt.setString(1,collegeid);
	    				pstmt.setString(2,sparkid);
	    				pstmt.setString(3,studentid);
	    				pstmt.setString(4,studentname);
	    				pstmt.setString(5,password);
	    				pstmt.setString(6,dob);
	    				pstmt.setString(7,gender);
	    				pstmt.setString(8,qualification);
	    				pstmt.setString(9,batch);
	    				pstmt.setString(10,branch);
	    				pstmt.setString(11,section);
	    				pstmt.setString(12,contactno);
	    				pstmt.setString(13,Parentcontactno);
	    				pstmt.setString(14,emailid);
	    				//pstmt.setString(7,s7);
	    				
	    				if (inputStream != null) {
	    	                // fetches input stream of the upload file for the blob column
	    	                pstmt.setBlob(15, inputStream);
	    	            }

	    				int rs=pstmt.executeUpdate();
	    				PrintWriter pw=response.getWriter();
	    				
	    			    if(rs>0){
	    			    	
	    			    	/*RequestDispatcher rd=request.getRequestDispatcher("localadminregistrationsucess.jsp");
	    					rd.forward(request, response);*/
	    			    	System.out.println("Success");
	    			    	
	    			    }
	    			    else{
	    			    
	    			    	//System.out.println("fail");
	    			    /*	RequestDispatcher rd=request.getRequestDispatcher("localadminregistrationfailure.jsp");
	    					rd.forward(request, response);*/
	    			    	System.out.println("failed");
	    			    	
	    			    }
	    			
	    			
	    	}catch(Exception e){
	    				//out.println("Duplicate Entry Data Already Exists!");
						/*RequestDispatcher rd=request.getRequestDispatcher("localadminregistration.jsp");
						rd.include(request, response);*/
	    				System.out.println("error");
	    				e.printStackTrace();
	    			}
	    			
	        }
		}
	}