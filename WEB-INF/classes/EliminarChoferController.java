import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cliente;
import modelos.ListaChoferes;
import conexiones.ConexionFlete;


public class EliminarChoferController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String color="";
		String choferID=request.getParameter("choferID");
		
		int fletesChofer=new ConexionFlete().numeroFletesPorChofer(choferID);
		if(fletesChofer==0){
			new ListaChoferes().eliminarChofer(choferID);
			request.setAttribute("mensaje","Chofer eliminado de manera exitosa");
			color+="10E214";
			request.setAttribute("coloreado",color);
			request.setAttribute("ListaDeChoferes",new ListaChoferes().obtenerChoferes());
	    	request.getRequestDispatcher("VerChoferes.jsp").forward(request,response);
		}else{
			color+="FF0000";
			request.setAttribute("coloreado",color);
			request.setAttribute("mensaje","No se ha eliminado pues el chofer tiene fletes pendientes.");
			request.setAttribute("ListaDeChoferes",new ListaChoferes().obtenerChoferes());
	    	request.getRequestDispatcher("VerChoferes.jsp").forward(request,response);
		}
		


	}


}