import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cliente;
import beans.Chofer;
import modelos.ListaClientes;
import modelos.ListaChoferes;


public class ClientesChoferesController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{
	}



	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)throws ServletException,IOException{

		request.setAttribute("ListaDeClientes",
			new ListaClientes().obtenerClientes());
		request.setAttribute("ListaDeChoferes",
			new ListaChoferes().obtenerChoferes());
		request.getRequestDispatcher("RegistroFlete.jsp").forward(request,response);

	}



}