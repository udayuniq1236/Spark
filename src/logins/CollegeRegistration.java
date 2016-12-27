package logins;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CollegeRegistration
 */
@WebServlet("/logins/CollegeRegistration")
public class CollegeRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeRegistration() {
        super();
        // TODO Auto-generated constructor stub test
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
		
		
		String collegename = request.getParameter("collegename");
		String collegecode = request.getParameter("collegecode");
		String collegelocation = request.getParameter("collegelocation");
		String collegeprincipalname = request.getParameter("collegeprincipalname");
		String collegeadminname = request.getParameter("collegeadminname");
		String collegeadminemailid = request.getParameter("collegeadminemailid");
		String collegecontactnumber = request.getParameter("collegecontactnumber");
		String collegealternativenumber = request.getParameter("collegealternativenumber");
		String collegeemailid = request.getParameter("collegeemailid");
		
		getDetails( collegename, collegecode, collegelocation, collegeprincipalname, collegeadminname,
				collegeadminemailid, collegecontactnumber, collegealternativenumber, collegeemailid);
		out.close();
	}

	public void getDetails( String collegename, String collegecode, String collegelocation,
			String collegeprincipalname, String collegeadminname, String collegeadminemailid,
			String collegecontactnumber, String collegealternativenumber, String collegeemailid) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost/sparkdb","root","root");
			PreparedStatement preparedStatement = con.prepareStatement("insert into collegereg(collegename, collegecode, location, principalname, admin_name, admin_emailid, college_contactno, college_alternativeno, college_emailid) values(?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1,collegename);
			preparedStatement.setString(2,collegecode);
			preparedStatement.setString(3,collegelocation);
			preparedStatement.setString(4,collegeprincipalname);
			preparedStatement.setString(5,collegeadminname);
			preparedStatement.setString(6,collegeadminemailid);
			preparedStatement.setString(7,collegecontactnumber);
			preparedStatement.setString(8,collegealternativenumber);
			preparedStatement.setString(9,collegeemailid);
			
			
			int i = preparedStatement.executeUpdate();
			if(i>0){
				//out.print("You are Succesfully Registered");
			}else{
				
			}
		}catch(Exception e){
			System.out.println(""+e);
		}
	}

}
