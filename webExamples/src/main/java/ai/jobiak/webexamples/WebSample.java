package ai.jobiak.webexamples;

import java.io.IOException;
import java.sql.*;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class WebSample implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/world";
		String userName="root";
		String password="admin";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection(url,userName,password);
			String sql="update signup set ";
		} catch (SQLException e) {
	
			e.printStackTrace();
		}

	}

}
