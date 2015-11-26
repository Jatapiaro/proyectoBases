import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Reparto;
import modelos.ListaRepartos;
import conexiones.ConexionFlete;


public class ModificarRepartoController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		int fleteID=Integer.parseInt(request.getParameter("fleteID"));
		int repartoID=Integer.parseInt(request.getParameter("repartoID"));
		String direccion=request.getParameter("direccion");
		String t=request.getParameter("fechaHoraRecoleccion");
		Reparto r=new Reparto(direccion,repartoID);
		new ListaRepartos(fleteID).modificarReparto(repartoID,r);
		request.setAttribute("mensaje","Reparto modificado de manera exitosa");
		String color="10E214";
		request.setAttribute("fleteID",fleteID);
		request.setAttribute("fechaHoraRecoleccion",t);
		request.setAttribute("coloreado",color);
		request.setAttribute("ListaDeRepartos",new ListaRepartos(fleteID).getRepartos());
	 	request.getRequestDispatcher("VerRepartos.jsp").forward(request,response);
	}


}