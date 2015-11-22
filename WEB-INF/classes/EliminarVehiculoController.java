import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Vehiculo;
import modelos.ListaVehiculos;
import conexiones.ConexionFlete;


public class EliminarVehiculoController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String color="";
		String vehiculoID=request.getParameter("vehiculoID");
		
		int fletesVehiculo=new ConexionFlete().numeroFletesPorVehiculo(vehiculoID);
		if(fletesVehiculo==0){
			new ListaVehiculos().eliminarVehiculo(vehiculoID);
			request.setAttribute("mensaje","Vehículo eliminado de manera exitosa");
			color+="10E214";
			request.setAttribute("coloreado",color);
			request.setAttribute("ListaDeVehiculos",new ListaVehiculos().getVehiculos());
	    	request.getRequestDispatcher("VistaVehiculo.jsp").forward(request,response);
		}else{
			color+="FF0000";
			request.setAttribute("coloreado",color);
			request.setAttribute("mensaje","No se ha eliminado el vehículo pues tiene fletes pendientes.");
			request.setAttribute("ListaDeVehiculos",new ListaVehiculos().getVehiculos());
	    	request.getRequestDispatcher("VistaVehiculo.jsp").forward(request,response);	
		}
		


	}


}