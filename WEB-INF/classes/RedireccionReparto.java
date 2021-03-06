import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;
import modelos.ListaRepartos;


public class RedireccionReparto extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		Timestamp t=Timestamp.valueOf(request.getParameter("fechaHoraRecoleccion"));
		String fleteID=request.getParameter("fleteID");


		if(timeStamp().compareTo(t)<0){
			request.setAttribute("fechaHoraRecoleccion",t);
			request.setAttribute("fleteID",fleteID);
			request.getRequestDispatcher("RegistroReparto.jsp").forward(request,response);			
		}else{
			request.setAttribute("fleteID",fleteID);
			request.setAttribute("mensaje","El flete esta en proceso de entrega, ya no puedes agregar repartos");
			String color="FF0000";
			request.setAttribute("fechaHoraRecoleccion",t);
			request.setAttribute("coloreado",color);
			request.setAttribute("ListaDeRepartos",new ListaRepartos(Integer.parseInt(fleteID)).getRepartos());
			request.getRequestDispatcher("VerRepartos.jsp").forward(request,response);
		}
	}

	public Timestamp timeStamp(){
		Date d2=new Date();
	    return new Timestamp(d2.getTime());
	}

	
}