import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cargamento;
import modelos.ListaCargamentos;
import conexiones.ConexionCargamento;


public class ObtenerCargamentosController extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{
		String t=request.getParameter("fechaHoraRecoleccion");
		int id=Integer.parseInt(request.getParameter("theID"));
		request.setAttribute("fleteID",id);
		request.setAttribute("fechaHoraRecoleccion",t);
		request.setAttribute("ListaDeCargamentos",new ConexionCargamento().getCargamentos(id));
		request.getRequestDispatcher("VerCargamentos.jsp").forward(request,response);
	}

	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)throws ServletException,IOException{
		
			String t=request.getParameter("fechaHoraRecoleccion");
			int id=Integer.parseInt(request.getParameter("idFromFlete"));
			request.setAttribute("fleteID",id);
			request.setAttribute("fechaHoraRecoleccion",t);
			request.setAttribute("ListaDeCargamentos",new ConexionCargamento().getCargamentos(id));
			request.getRequestDispatcher("VerCargamentos.jsp").forward(request,response);
			
	}

}