import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Chofer;
import modelos.ListaChoferes;

public class RegistroChoferController extends HttpServlet{

	private String msjError;

	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		ArrayList<String> parameters=new ArrayList<String>();
		String nombreChofer=request.getParameter("nombreChofer");
		parameters.add(nombreChofer);
		String usernameChofer=request.getParameter("usernameChofer");
		parameters.add(usernameChofer);
		String passwordChofer=request.getParameter("passwordChofer");
		parameters.add(passwordChofer);
		String telefonoChofer=request.getParameter("telefonoChofer");
		parameters.add(telefonoChofer);
		String salarioChofer=request.getParameter("salarioChofer");
		parameters.add(salarioChofer);
		String esAdmin=request.getParameter("esAdmin");
		parameters.add(esAdmin);

		if(validarParametros(parameters) && verificarUnicidad(usernameChofer)){

			Chofer chofer=new Chofer(nombreChofer,usernameChofer,
				passwordChofer,telefonoChofer,
				Float.parseFloat(salarioChofer),
				Boolean.parseBoolean(esAdmin));

			new ListaChoferes().agregarChofer(chofer);

			request.setAttribute("mensaje","Chofer agregado de manera exitosa");
			request.setAttribute("direccion","Index.jsp");
			request.getRequestDispatcher("resultados.jsp").forward(request,response);


		}else{
			request.setAttribute("mensaje",msjError);
			request.setAttribute("direccion","RegistroChofer.html");
			request.getRequestDispatcher("FaltanDatos.jsp").forward(request,response);
		}

	}


	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)throws ServletException,IOException{

		request.setAttribute("ListaDeChoferes",
			new ListaChoferes().obtenerChoferes());
		
		request.getRequestDispatcher(
			"VerChoferes.jsp").forward(request,response);

	}

	
	boolean validarParametros(ArrayList<String> parametros){
		boolean validado=true;
		for (String p : parametros){
			if(p.equals("")){
				validado=false;
				break;
			}
		}
		msjError="No has ingresado todos los datos";
		return validado;
	}

	boolean verificarUnicidad(String username){
		
		ArrayList<Chofer> listaChoferes=
		new ListaChoferes().obtenerChoferes();

		boolean valido=true;

		for (Chofer c : listaChoferes) {
			if(c.getUsernameChofer().equals(username)){
				valido=false;
				msjError="Este username ya ha sido registrado";
				break;
			}
		}

		return valido;
	}
}