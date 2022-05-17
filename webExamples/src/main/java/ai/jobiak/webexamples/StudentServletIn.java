package ai.jobiak.webexamples;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServletIn
 */
@WebServlet("/sin")
public class StudentServletIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServletIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="jdbc:Mysql://localhost:3306/examples";
		String userName="root";
		String password="admin";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection(url,userName,password);
			Statement st=con.createStatement();
			String sql="select * from students";
			ResultSet rs=st.executeQuery(sql);
			rs.next();
	
		PrintWriter out=response.getWriter();
		
		ServletContext context=getServletContext();
		context.setAttribute("Fname", rs.getString(2));
		context.setAttribute("Lname", rs.getString(3));
		context.setAttribute("roll", rs.getString(1));
		
		
		
		RequestDispatcher dispatcher=context.getRequestDispatcher("/sout");
		dispatcher.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}


}
