import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import conexiones.ConexionCargamento;
import modelos.ListaFletes;


public class EliminarCargamento extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String idCliente=request.getParameter("cID");
		int id=Integer.parseInt(idCliente);
		new ConexionCargamento().eliminarCargamento(id);
		request.setAttribute("ListaDeFletes",new ListaFletes().obtenerProximosFletes());
		request.getRequestDispatcher("VistaFletes.jsp").forward(request,response);

	}


}