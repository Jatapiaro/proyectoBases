package conexiones;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Vehiculo;

public class ConexionVehiculo{

	private Statement consulta;
	private ResultSet resultado;
	private PreparedStatement enunciado;
	private Connection conexion;
	private ArrayList<Vehiculo> vehiculos;

	public ConexionVehiculo(){
		try {

			Class.forName("com.mysql.jdbc.Driver");

			conexion=DriverManager.getConnection(
				"jdbc:mysql://localhost/TransportesRizo","jacobo","jacobo");

			consulta=conexion.createStatement();

			vehiculos=new ArrayList<Vehiculo>();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void agregarVehiculo(Vehiculo vehiculo){
		try {

			enunciado=conexion.prepareStatement(
				"INSERT INTO Vehiculos VALUES(?,?,?)");

			enunciado.setString(1, vehiculo.getPlacasVehiculo());
			enunciado.setFloat(2, vehiculo.getCostoVehiculo());
			enunciado.setFloat(3, vehiculo.getCapacidadVehiculo());

			enunciado.execute();
			conexion.close();

		} catch (Exception e) {	
			e.printStackTrace();
		}
	}

	public ArrayList<Vehiculo> getAllVehiculos(){
		
		try{

			resultado= consulta.executeQuery(
				"SELECT * FROM Vehiculos");

		    while(resultado.next()){
				vehiculos.add(new Vehiculo(
					resultado.getString("placasVehiculo"),
					resultado.getFloat("costoVehiculo"), 
					resultado.getFloat("capacidadVehiculo")));
			}

			resultado.close();

		}catch(Exception e){
			e.printStackTrace();
		}

		return vehiculos;
	}

	public Vehiculo getVehiculoFromID(String vehiculoID){
		Vehiculo v=null;
	    vehiculoID="\""+vehiculoID+"\"";
		try{

			resultado= consulta.executeQuery(
				"SELECT * FROM Vehiculos WHERE placasVehiculo="+vehiculoID+";");

		    while(resultado.next()){
				v=new Vehiculo(
					resultado.getString("placasVehiculo"),
					resultado.getFloat("costoVehiculo"), 
					resultado.getFloat("capacidadVehiculo"));
			}

			resultado.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		return v;
	}

	public Vehiculo getVehiculoForWeight(float peso){
		Vehiculo res=null;
		ArrayList<Vehiculo> vehic=getAllVehiculos();
		for (Vehiculo v: vehic) {
			if(peso<=v.getCapacidadVehiculo()){
				res=v;
				break;
			}
		}
		return res;
	}


}