import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cliente;
import modelos.ListaClientes;
import conexiones.ConexionFlete;


public class EliminarClienteController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		int clienteID=Integer.parseInt(request.getParameter("clienteID"));
		
		int fletesCliente=new ConexionFlete().numeroFletesPorCliente(clienteID);
		float adeudo=new ListaClientes().getClienteFromID(clienteID).getDeudaCliente();
		if(fletesCliente==0 && adeudo==0){
			new ListaClientes().eliminarCliente(clienteID);
			request.setAttribute("mensaje","Cliente eliminado de manera exitosa");
			request.setAttribute("ListaDeClientes",new ListaClientes().obtenerClientes());
	    	request.getRequestDispatcher("VerClientes.jsp").forward(request,response);
		}else{
			request.setAttribute("mensaje","No se ha eliminado pues el cliente tiene fletes pendientes o tiene un adeudo");
			request.setAttribute("ListaDeClientes",new ListaClientes().obtenerClientes());
	    	request.getRequestDispatcher("VerClientes.jsp").forward(request,response);	
		}
		


	}


}