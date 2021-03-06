import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;
import conexiones.ConexionCargamento;
import modelos.ListaFletes;
import modelos.ListaCargamentos;


public class EliminarCargamento extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String idCargamento=request.getParameter("cargamentoID");
		int id=Integer.parseInt(idCargamento);
		int fleteID=new ListaCargamentos().getCargamentoFromID(id).getFleteID();
		Timestamp t=Timestamp.valueOf(request.getParameter("fechaHoraRecoleccion"));
		if(timeStamp().compareTo(t)<0){

			new ConexionCargamento().eliminarCargamento(id);
			request.setAttribute("mensaje","Cargamento modificado de manera exitosa");
			String color="10E214";
			request.setAttribute("fleteID",fleteID);
			request.setAttribute("fechaHoraRecoleccion",t);
			request.setAttribute("coloreado",color);
			request.setAttribute("ListaDeCargamentos",new ListaCargamentos(fleteID).getCargamentos());
			request.getRequestDispatcher("VerCargamentos.jsp").forward(request,response);
		}else{
			request.setAttribute("fleteID",fleteID);
			request.setAttribute("mensaje","El flete esta en proceso de entrega, ya no puede ser borrado");
			String color="FF0000";
			request.setAttribute("fechaHoraRecoleccion",t);
			request.setAttribute("coloreado",color);
			request.setAttribute("ListaDeCargamentos",new ListaCargamentos(fleteID).getCargamentos());
			request.getRequestDispatcher("VerCargamentos.jsp").forward(request,response);
		}

	}
	public Timestamp timeStamp(){
		Date d2=new Date();
	    return new Timestamp(d2.getTime());
	}

}