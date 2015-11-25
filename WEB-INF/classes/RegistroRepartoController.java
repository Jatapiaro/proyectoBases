import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Reparto;
import modelos.ListaRepartos;


public class RegistroRepartoController extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		ArrayList<String> parameters=new ArrayList<String>();
		int idFlete=Integer.parseInt(request.getParameter("idFromFlete"));
		String direccion=request.getParameter("direccion");

		new ListaRepartos(idFlete).addReparto(new Reparto(direccion,idFlete));
		request.setAttribute("mensaje","Reparto agregado de manera exitosa");
		request.setAttribute("direccion","index.html");
		request.getRequestDispatcher("resultados.jsp").forward(request,response);
		request.setAttribute("ListaDeRepartos",new ListaRepartos(idFlete).getRepartos());
	 	request.getRequestDispatcher("VerRepartos.jsp").forward(request,response);
	}


	

}