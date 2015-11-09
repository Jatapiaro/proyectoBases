import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cliente;
import modelos.ListaClientes;


public class RegistroClienteController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		ArrayList<String> parameters=new ArrayList<String>();
		String nombreCliente=request.getParameter("nombreCliente");
		parameters.add(nombreCliente);
		String telefonoCliente=request.getParameter("telefonoCliente");
		parameters.add(telefonoCliente);
		String contactoCliente=request.getParameter("contactoCliente");
		parameters.add(contactoCliente);

		if(validarParametros(parameters)){

			Cliente cliente=new Cliente(nombreCliente,telefonoCliente,
				contactoCliente);

			new ListaClientes().agregarCliente(cliente);

			request.setAttribute("mensaje","Cliente agregado de manera exitosa");
			request.setAttribute("direccion","index.html");
			request.getRequestDispatcher("resultados.jsp").forward(request,response);

		}else{
			request.setAttribute("mensaje",
				"No has ingresado todos los datos");
			request.setAttribute("direccion","registrocliente.html");
			request.getRequestDispatcher("FaltanDatos.jsp").forward(request,response);
		}

	}

	
	boolean validarParametros(ArrayList<String> parametros){
		boolean validado=true;
		for (String p : parametros){
			if(p.equals("")){
				validado=false;
				break;
			}
		}
		return validado;
	}


}