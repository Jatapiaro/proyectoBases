import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class RedireccionCargamento extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String theID=request.getParameter("idFromFlete");
		request.setAttribute("fleteID",theID);
		request.getRequestDispatcher("RegistroCargamentos.jsp").forward(request,response);
		
	}

	
}