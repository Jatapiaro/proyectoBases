import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cliente;
import modelos.ListaClientes;


public class ObtenerClienteController extends HttpServlet{

	//Usar para traer el objeto a editar.
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		int id=Integer.parseInt(request.getParameter("clienteID"));
		Cliente c=new ListaClientes().getClienteFromID(id);
		request.setAttribute("cliente",c);
		request.getRequestDispatcher("ModificarCliente.jsp").forward(request,response);
	}

}