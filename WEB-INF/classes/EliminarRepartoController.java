import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;
import conexiones.ConexionCargamento;
import modelos.ListaFletes;
import modelos.ListaRepartos;


public class EliminarRepartoController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String idReparto=request.getParameter("repartoID");
		int id=Integer.parseInt(idReparto);
		int fleteID=Integer.parseInt(request.getParameter("fleteID"));
//sjavax.swing.JOptionPane.showMessageDialog(null,fleteID);
		Timestamp t=Timestamp.valueOf(request.getParameter("fechaHoraRecoleccion"));
		if(timeStamp().compareTo(t)<0){

			new ListaRepartos(fleteID).eliminarReparto(id);
			request.setAttribute("mensaje","Reparto modificado de manera exitosa");
			String color="10E214";
			request.setAttribute("fleteID",fleteID);
			request.setAttribute("fechaHoraRecoleccion",t);
			request.setAttribute("coloreado",color);
			request.setAttribute("ListaDeRepartos",new ListaRepartos(fleteID).getRepartos());
			request.getRequestDispatcher("VerRepartos.jsp").forward(request,response);
		}else{
			request.setAttribute("fleteID",fleteID);
			request.setAttribute("mensaje","El flete esta en proceso de entrega, el reparto ya no puede ser borrado");
			String color="FF0000";
			request.setAttribute("fechaHoraRecoleccion",t);
			request.setAttribute("coloreado",color);
			request.setAttribute("ListaDeRepartos",new ListaRepartos(fleteID).getRepartos());
			request.getRequestDispatcher("VerRepartos.jsp").forward(request,response);

		}

	}
	public Timestamp timeStamp(){
		Date d2=new Date();
	    return new Timestamp(d2.getTime());
	}

}