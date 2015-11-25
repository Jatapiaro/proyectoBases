import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
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
		new ConexionCargamento().eliminarCargamento(id);
		request.setAttribute("mensaje","Cargamento modificado de manera exitosa");
		String color="10E214";
		request.setAttribute("coloreado",color);
		request.setAttribute("ListaDeCargamentos",new ListaCargamentos(fleteID).getCargamentos());
		request.getRequestDispatcher("VerCargamentos.jsp").forward(request,response);

	}

}