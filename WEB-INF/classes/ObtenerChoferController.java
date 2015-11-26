import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Chofer;
import modelos.ListaChoferes;


public class ObtenerChoferController extends HttpServlet{

	//Usar para traer el objeto a editar.
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String id=request.getParameter("choferID");
		Chofer c=new ListaChoferes().getChoferFromID(id);
		request.setAttribute("chofer",c);
		request.getRequestDispatcher("ModificarChofer.jsp").forward(request,response);
	}

}