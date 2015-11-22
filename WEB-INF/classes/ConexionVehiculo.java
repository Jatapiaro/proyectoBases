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
				"INSERT INTO Vehiculos (placasVehiculo,costoVehiculo,capacidadVehiculo) VALUES(?,?,?)");

			enunciado.setString(1, vehiculo.getPlacasVehiculo());
			enunciado.setFloat(2, vehiculo.getCostoVehiculo());
			enunciado.setFloat(3, vehiculo.getCapacidadVehiculo());

			enunciado.execute();
			consulta.close();
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
		    	Vehiculo v=new Vehiculo(
					resultado.getString("placasVehiculo"),
					resultado.getFloat("costoVehiculo"), 
					resultado.getFloat("capacidadVehiculo"),
					resultado.getBoolean("activo"));

		    	if(v.getActivo()){
		    		vehiculos.add(v);
		    	}

			}

			consulta.close();
			conexion.close();

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

			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		return v;
	}

	public Vehiculo getVehiculoForWeight(float peso){
		Vehiculo res=null;
		ArrayList<Vehiculo> vehic=getAllVehiculos();
		for (Vehiculo v: vehic) {
			if(v.getActivo() && peso<=v.getCapacidadVehiculo()){
				res=v;
				break;
			}
		}
		return res;
	}

	public void eliminarVehiculo(String id){
		try{
			id="\""+id+"\"";
			enunciado=conexion.prepareStatement( 
				"UPDATE Vehiculos SET activo=? WHERE placasVehiculo="+id+";");
			enunciado.setBoolean(1,false);	
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public void updateVehiculo(String id,Vehiculo v){
		try{
			id="\""+id+"\"";
			enunciado=conexion.prepareStatement( 
				"UPDATE Vehiculos SET costoVehiculo=?,capacidadVehiculo=? WHERE placasVehiculo="+id+";");
			enunciado.setFloat(1,v.getCostoVehiculo());
			enunciado.setFloat(2,v.getCapacidadVehiculo());
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	public float getVehiculoMaxCapacidad(){

		Float peso=null;;

		try{
			resultado=consulta.executeQuery(
				"SELECT MAX(capacidadVehiculo) AS maximo FROM Vehiculos;");

			while(resultado.next()){
				peso=new Float(resultado.getFloat("maximo"));
			}
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(!peso.equals(null)){
			return peso.floatValue();
		}else{
			return 0.0f;
		}
	}


}