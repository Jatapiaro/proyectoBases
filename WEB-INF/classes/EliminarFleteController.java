import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;
import conexiones.ConexionFlete;
import modelos.ListaFletes;


public class EliminarFleteController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String idCargamento=request.getParameter("cargamentoID");
		int id=Integer.parseInt(request.getParameter("idFlete"));
		Timestamp t=Timestamp.valueOf(request.getParameter("fechaHoraRecoleccion"));
		if(timeStamp().compareTo(t)<0){

			new ConexionFlete().eliminarFlete(id);
			request.setAttribute("mensaje","Flete eliminado modificado de manera exitosa");
			String color="10E214";
			request.setAttribute("coloreado",color);
			request.setAttribute("ListaDeFletes",new ListaFletes().obtenerProximosFletes());
			request.getRequestDispatcher("VerFletes.jsp").forward(request,response);
		}else{
			request.setAttribute("mensaje","El flete esta en proceso de entrega, ya no puede ser borrado");
			String color="FF0000";
			request.setAttribute("coloreado",color);
			request.setAttribute("ListaDeFletes",new ListaFletes().obtenerProximosFletes());
			request.getRequestDispatcher("VerFletes.jsp").forward(request,response);
		}

	}
	public Timestamp timeStamp(){
		Date d2=new Date();
	    return new Timestamp(d2.getTime());
	}

}