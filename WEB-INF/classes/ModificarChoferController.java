import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Chofer;
import modelos.ListaChoferes;
import conexiones.ConexionFlete;


public class ModificarChoferController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String nombreChofer=request.getParameter("nombreChofer");
		String telefonoChofer=request.getParameter("telefonoChofer");
		float salarioChofer=Float.parseFloat(request.getParameter("salarioChofer"));
		String choferID=request.getParameter("usernameChofer");

		Chofer c=new Chofer(nombreChofer,telefonoChofer,salarioChofer);
		new ListaChoferes().updateChofer(choferID,c);

		request.setAttribute("mensaje","Chofer modificado de manera exitosa");
		String color="10E214";
		request.setAttribute("coloreado",color);
		request.setAttribute("ListaDeChoferes",new ListaChoferes().obtenerChoferes());
	    request.getRequestDispatcher("VerChoferes.jsp").forward(request,response);
	}


}