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
		Timestamp t=Timestamp.valueOf(request.getParameter("fechaHoraRecoleccion"));	
		Flete f=new ListaFletes().getFleteFromID(idFlete);

		if(timeStamp().compareTo(t)<0){
			f.setFleteID(idFlete);
			request.setAttribute("flete",f);
			request.setAttribute("ListaDeClientes",new ListaClientes().obtenerClientes());
			request.setAttribute("ListaDeChoferes",new ListaChoferes().obtenerChoferes());
			request.getRequestDispatcher("ModificarFlete.jsp").forward(request,response);
		}else{
			request.setAttribute("ListaDeFletes",
			new ListaFletes().obtenerProximosFletes());
			request.setAttribute("mensaje","El flete ya esta en proceso, ya no puedes modificarlo");
			request.getRequestDispatcher("VerFletes.jsp").forward(request,response);
		}



	}

	public Timestamp timeStamp(){
		Date d2=new Date();
	    return new Timestamp(d2.getTime());
	}

}