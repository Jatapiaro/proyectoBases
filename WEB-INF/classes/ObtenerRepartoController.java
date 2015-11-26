import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;
import beans.Cargamento;
import modelos.ListaRepartos;
import conexiones.ConexionFlete;


public class ObtenerRepartoController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{
		int fleteID=Integer.parseInt(request.getParameter("fleteID"));
		//javax.swing.JOptionPane.showMessageDialog(null,fleteID);
		Timestamp t=Timestamp.valueOf(request.getParameter("fechaHoraRecoleccion"));
		int repartoID=Integer.parseInt(request.getParameter("repartoID"));
		if(timeStamp().compareTo(t)<0){
			request.setAttribute("fleteID",fleteID);
			request.setAttribute("fechaHoraRecoleccion",t);
			request.setAttribute("reparto",new ListaRepartos(fleteID).getRepartoFromID(repartoID));
			request.getRequestDispatcher("ModificarReparto.jsp").forward(request,response);
		}else{
			request.setAttribute("fleteID",fleteID);
			request.setAttribute("mensaje","El flete esta en proceso de entrega, el reparto no puede ser modificado");
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