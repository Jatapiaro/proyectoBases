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

		}catch(Exception e){
			e.printStackTrace();
		}

		return vehiculos;
	}
	


}