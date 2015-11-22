import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Vehiculo;
import modelos.ListaVehiculos;
import conexiones.ConexionVehiculo;


public class ObtenerVehiculoController extends HttpServlet{

	//Usar para traer el objeto a editar.
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String vehiculoID=request.getParameter("vehiculoID");
		Vehiculo v=new ConexionVehiculo().getVehiculoFromID(vehiculoID);
		request.setAttribute("vehiculo",v);
		request.getRequestDispatcher("ModificarVehiculo.jsp").forward(request,response);
	}

}