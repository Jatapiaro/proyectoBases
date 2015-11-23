import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;
import conexiones.ConexionFlete;
import modelos.ListaFletes;
import beans.Flete;


public class ConfirmarRecoleccion extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		int idFlete=Integer.parseInt(request.getParameter("theID"));
		Timestamp entry=Timestamp.valueOf(request.getParameter("fechaHoraRecoleccion"));
		Timestamp myTime=timeStamp();
		boolean man=Boolean.parseBoolean(request.getParameter("maniobraRecoleccion"));
		if(myTime.compareTo(entry)>=0){
			new ConexionFlete().completarRecoleccion(idFlete,man);
			request.setAttribute("ListaDeFletes",new ListaFletes().obtenerProximosFletes());
			request.getRequestDispatcher("VerFletes.jsp").forward(request,response);
		}else{
			request.setAttribute("mensaje","Aun falta tiempo para la hora de entrega");
		    request.setAttribute("ListaDeFletes",new ListaFletes().obtenerProximosFletes());
			request.getRequestDispatcher("VerFletes.jsp").forward(request,response);
		}

	}

	public Timestamp timeStamp(){
		Date d2=new Date();
	    return new Timestamp(d2.getTime());
	}

}