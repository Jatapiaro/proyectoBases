import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import conexiones.ConexionFlete;
import modelos.ListaFletes;
import beans.Flete;


public class ConfirmarRecoleccion extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{


		int idFlete=Integer.parseInt(request.getParameter("theID"));
		boolean man=Boolean.parseBoolean(request.getParameter("maniobraRecoleccion"));
		new ConexionFlete().completarRecoleccion(idFlete,man);
		request.setAttribute("ListaDeFletes",new ListaFletes().obtenerFletes());
		ArrayList<Flete> fletesitos=new ListaFletes().obtenerFletes();
		request.getRequestDispatcher("VerFletes.jsp").forward(request,response);
	}


}