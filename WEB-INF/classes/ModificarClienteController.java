import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cliente;
import modelos.ListaClientes;
import conexiones.ConexionFlete;


public class ModificarClienteController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String nombreCliente=request.getParameter("nombreCliente");
		String telefonoCliente=request.getParameter("telefonoCliente");
		String contactoCliente=request.getParameter("contactoCliente");
		float deudaCliente=Float.parseFloat(request.getParameter("deudaCliente"));
		int clienteID=Integer.parseInt(request.getParameter("clienteID"));

		Cliente c=new Cliente(nombreCliente,telefonoCliente,
			contactoCliente,deudaCliente);
		new ListaClientes().modificarCliente(clienteID,c);

		request.setAttribute("mensaje","Cliente modificado de manera exitosa");
		String color="10E214";
		request.setAttribute("coloreado",color);
		request.setAttribute("ListaDeClientes",new ListaClientes().obtenerClientes());
	    request.getRequestDispatcher("VerClientes.jsp").forward(request,response);
	}


}