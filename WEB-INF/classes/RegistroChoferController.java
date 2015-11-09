import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Chofer;
import modelos.ListaChoferes;

public class RegistroChoferController extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		ArrayList<String> parameters=new ArrayList<String>();
		String nombreChofer=request.getParameter("nombreChofer");
		parameters.add(nombreChofer);
		String telefonoChofer=request.getParameter("telefonoChofer");
		parameters.add(telefonoChofer);
		String salarioChofer=request.getParameter("salarioChofer");
		parameters.add(salarioChofer);

		if(validarParametros(parameters)){

			Chofer chofer=new Chofer(nombreChofer,telefonoChofer,
				Float.parseFloat(salarioChofer));

			new ListaChoferes().agregarChofer(chofer);

			request.setAttribute("mensaje","Chofer agregado de manera exitosa");
			request.setAttribute("direccion","index.html");
			request.getRequestDispatcher("resultados.jsp").forward(request,response);


		}else{
			request.setAttribute("mensaje",
				"No has ingresado todos los datos");
			request.setAttribute("direccion","registroCliente.html");
			request.getRequestDispatcher("resultados.jsp").forward(request,response);
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