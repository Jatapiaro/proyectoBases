import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import beans.Vehiculo;
import modelos.ListaVehiculos;

public class RegistroVehiculoController extends HttpServlet{


	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		ArrayList<String> parameters=new ArrayList<String>();

		String placasVehiculo=request.getParameter("placasVehiculo");
		placasVehiculo=placasVehiculo.toUpperCase();
		parameters.add(placasVehiculo);
		String costoVehiculo=request.getParameter("costoVehiculo");
		parameters.add(costoVehiculo);
		String capacidadVehiculo=request.getParameter("capacidadVehiculo");
		parameters.add(capacidadVehiculo);
		

			Vehiculo vehiculo=new Vehiculo(placasVehiculo,
				Float.parseFloat(costoVehiculo),
				Float.parseFloat(capacidadVehiculo));

			new ListaVehiculos().agregarVehiculo(vehiculo);

			request.setAttribute("mensaje","Vehiculo agregado de manera exitosa");
			request.setAttribute("direccion","index.html");
			request.getRequestDispatcher("resultados.jsp").forward(request,response);


	}

	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)throws ServletException,IOException{

		request.setAttribute("ListaDeVehiculos",new ListaVehiculos().getVehiculos());
		request.getRequestDispatcher("VistaVehiculo.jsp").forward(request,response);

	}

	
	boolean validarParametros(ArrayList<String> parametros){
		boolean validado=true;
		if(parametros.get(0).length()!=7){
			return false;
		}
		for (String p : parametros){
			if(p.equals("")){
				validado=false;
				break;
			}
		}
		return validado;
	}

}