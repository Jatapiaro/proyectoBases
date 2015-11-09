import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cargamento;
import conexiones.ConexionCargamento;


public class RegistroCargamentoController extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		ArrayList<String> parameters=new ArrayList<String>();
		String tipoCargamento=request.getParameter("tipoCargamento");
		parameters.add(tipoCargamento);
		String pesoCargamento=request.getParameter("pesoCargamento");
		parameters.add(pesoCargamento);
		String delicadoCargamento=request.getParameter("delicadoCargamento");
		parameters.add(delicadoCargamento);

		if(validarParametros(parameters)){

			Cargamento cargamento=new Cargamento(tipoCargamento,
				Float.parseFloat(pesoCargamento),
				Boolean.parseBoolean(delicadoCargamento));

			new ConexionCargamento().addCargamento(cargamento);

			request.setAttribute("mensaje","Flete agregado de manera exitosa");
			request.setAttribute("direccion","index.html");
			request.getRequestDispatcher("resultados.jsp").forward(request,response);

		}else{
			request.setAttribute("mensaje",
				"No has ingresado todos los datos");
			request.setAttribute("direccion","registroCliente.html");
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