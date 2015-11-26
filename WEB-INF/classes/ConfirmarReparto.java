import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;
import conexiones.ConexionFlete;
import modelos.ListaFletes;
import beans.Flete;
import modelos.ListaRepartos;


public class ConfirmarReparto extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{
		int idFlete=Integer.parseInt(request.getParameter("fleteID"));
		int repartoID=Integer.parseInt(request.getParameter("repartoID"));
		//javax.swing.JOptionPane.showMessageDialog(null,repartoID);
		Timestamp t=new ListaFletes().isCollected(idFlete);
		Timestamp myTime=timeStamp();
		boolean man=Boolean.parseBoolean(request.getParameter("maniobraRecoleccion"));
		if(t!=null){
			new ListaRepartos(idFlete).setEntregado(repartoID,man,myTime);
			String color="10E214";
			request.setAttribute("mensaje","Reparto completado");
			request.setAttribute("fleteID",idFlete);
			request.setAttribute("fechaHoraRecoleccion",t);
			request.setAttribute("coloreado",color);
			request.setAttribute("ListaDeRepartos",new ListaRepartos(idFlete).getRepartos());
			request.getRequestDispatcher("VerRepartos.jsp").forward(request,response);
		}else{
			String color="FF0000";
			request.setAttribute("mensaje","Aun no has hecho la recolección del flete");
			request.setAttribute("fleteID",idFlete);
			request.setAttribute("fechaHoraRecoleccion",t);
			request.setAttribute("coloreado",color);
			request.setAttribute("ListaDeRepartos",new ListaRepartos(idFlete).getRepartos());
			request.getRequestDispatcher("VerRepartos.jsp").forward(request,response);
		}

	}

	public Timestamp timeStamp(){
		Date d2=new Date();
	    return new Timestamp(d2.getTime());
	}

}