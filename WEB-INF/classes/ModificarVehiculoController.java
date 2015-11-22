import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Vehiculo;
import modelos.ListaVehiculos;
import conexiones.ConexionVehiculo;
import conexiones.ConexionFlete;

public class ModificarVehiculoController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String id=request.getParameter("vehiculoID");
		float costoVehiculo=Float.parseFloat(request.getParameter("costoVehiculo"));
		float capacidadVehiculo=Float.parseFloat(request.getParameter("capacidadVehiculo"));
		Vehiculo v=new Vehiculo("AAAAA",costoVehiculo,capacidadVehiculo);
		new ListaVehiculos().modificarVehiculo(id,v);
		request.setAttribute("mensaje","Vehículo modificado de manera exitosa");
		String color="10E214";
		request.setAttribute("coloreado",color);
		request.setAttribute("ListaDeVehiculos",new ListaVehiculos().getVehiculos());
	    request.getRequestDispatcher("VistaVehiculo.jsp").forward(request,response);
	}


}