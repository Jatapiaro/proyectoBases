import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import modelos.ListaCargamentos;
import java.util.Date;


public class RedireccionCargamento extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{
		
		Timestamp t=Timestamp.valueOf(request.getParameter("fechaHoraRecoleccion"));
		int fleteID=Integer.parseInt(request.getParameter("idFromFlete"));
		
		if(timeStamp().compareTo(t)<0){
			
			request.setAttribute("fechaHoraRecoleccion",t);
			request.setAttribute("fleteID",fleteID);
			request.getRequestDispatcher("RegistroCargamentos.jsp").forward(request,response);
		
		}else{
			request.setAttribute("fleteID",fleteID);
			request.setAttribute("mensaje","El flete esta en proceso de entrega, ya no puedes agregar cargamentos");
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