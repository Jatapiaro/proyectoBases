import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;
import conexiones.ConexionFlete;
import modelos.ListaFletes;
import modelos.ListaClientes;
import modelos.ListaChoferes;
import beans.Flete;


public class ObtenerFleteController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		int idFlete=Integer.parseInt(request.getParameter("theID"));
		///request.setAttribute("fleteID",idFlete);		
		Flete f=new ListaFletes().getFleteFromID(idFlete);
		f.setFleteID(idFlete);
		request.setAttribute("flete",f);
		request.setAttribute("ListaDeClientes",new ListaClientes().obtenerClientes());
		request.setAttribute("ListaDeChoferes",new ListaChoferes().obtenerChoferes());
		request.getRequestDispatcher("ModificarFlete.jsp").forward(request,response);

	}

	public Timestamp timeStamp(){
		Date d2=new Date();
	    return new Timestamp(d2.getTime());
	}

}