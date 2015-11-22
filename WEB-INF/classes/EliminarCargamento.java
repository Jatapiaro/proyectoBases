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

		String idCargamento=request.getParameter("cargamentoID");
		int id=Integer.parseInt(idCargamento);
		new ConexionCargamento().eliminarCargamento(id);
		request.setAttribute("ListaDeFletes",new ListaFletes().obtenerProximosFletes());
		request.getRequestDispatcher("VerFletes.jsp").forward(request,response);
	}


}