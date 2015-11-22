import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cargamento;
import modelos.ListaCargamentos;
import conexiones.ConexionCargamento;


public class ObtenerCargamentosController extends HttpServlet{

	//Usar para traer el objeto a editar.
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		int id=Integer.parseInt(request.getParameter("theID"));
		request.setAttribute("ListaDeCargamentos",new ConexionCargamento().getCargamentos(id));
		request.getRequestDispatcher("VerCargamentos.jsp").forward(request,response);

	}

}