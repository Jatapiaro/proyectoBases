package conexiones;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Reparto;

public class ConexionReparto{

	private Statement consulta;
	private ResultSet resultado;
	private PreparedStatement enunciado;
	private Connection conexion;
	private ArrayList<Reparto> repartos;

	public ConexionReparto(){
		try{

			Class.forName("com.mysql.jdbc.Driver");

			conexion=DriverManager.getConnection(
				"jdbc:mysql://localhost/TransportesRizo","jacobotapia","jacobo");

			consulta=conexion.createStatement();

			repartos=new ArrayList<Reparto>();
			

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void addReparto(Reparto reparto){
		try{

			//INSERT INTO Clientes (nombreCliente,telefonoCliente,contactoCliente,deudaCliente) VALUES ("Insumos","5521505060","Armando",0);  
			String rows="(direccion,fleteID)";
			enunciado=conexion.prepareStatement( 
				"INSERT INTO Repartos "+rows+ 
				" VALUES(?,?);");

			enunciado.setString(1,reparto.getDireccion());
			enunciado.setInt(2,reparto.getFleteID());
			enunciado.execute();
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<Reparto> getRepartos(int idFlete){

		try{
			resultado=consulta.executeQuery(
				"SELECT * FROM Repartos WHERE fleteID="+idFlete+";");

			while(resultado.next()){
				repartos.add(new Reparto(
					resultado.getInt("repartoID"),
					resultado.getInt("fleteID"),
					resultado.getBoolean("maniobra"),
					resultado.getBoolean("entregado"),
					resultado.getString("direccion"),
					resultado.getTimestamp("horaSalida")
					));
			}
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}

		return repartos;

		
	}


	public void eliminarReparto(int idReparto){

		try{
			enunciado=conexion.prepareStatement("DELETE FROM Repartos WHERE repartoID="+idReparto+";");
			enunciado.executeUpdate();
		    consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void modificarReparto(int id, Reparto c){
		try{
			enunciado=conexion.prepareStatement( 
				"UPDATE Repartos SET direccion=? WHERE repartoID="+id+";");
			enunciado.setString(1,c.getDireccion());
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Reparto getRepartoFromID(int id){
		Reparto c=null;
		try{

			resultado=consulta.executeQuery(
				"SELECT * FROM Repartos WHERE repartoID="+id+";");

			while(resultado.next()){
				c=new Reparto(
					resultado.getInt("repartoID"),
					resultado.getString("direccion")
					);
			}
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
	}

	public void entregado(int idReparto,boolean maniobra,Timestamp t){
		try{
			enunciado=conexion.prepareStatement( 
				"UPDATE Repartos SET maniobra=?,entregado=?,horaSalida=? WHERE repartoID="+idReparto+";");
			enunciado.setBoolean(1,maniobra);
			enunciado.setBoolean(2,true);
			enunciado.setTimestamp(3,t);
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	public void eliminarRepartosFlete(int idFlete){

		try{
			enunciado=conexion.prepareStatement("DELETE FROM Repartos WHERE repartoID="+idFlete+";");
			enunciado.executeUpdate();
		    consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
