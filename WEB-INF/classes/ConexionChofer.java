package conexiones;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Chofer;

public class ConexionChofer{

	private Connection conexion;
	private Statement consulta;
	private ResultSet resultado;
	private PreparedStatement enunciado;
	private ArrayList<Chofer> choferes;

	public ConexionChofer(){
		try{

			Class.forName("com.mysql.jdbc.Driver");

			conexion=DriverManager.getConnection(
				"jdbc:mysql://localhost/TransportesRizo","jacobotapia","jacobo");

			consulta=conexion.createStatement();

			choferes=new ArrayList<Chofer>();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void addChofer(Chofer chofer){
		try{

			String rows="(nombreChofer,telefonoChofer,salarioChofer,usernameChofer,passwordChofer,esAdmin)";
			enunciado=conexion.prepareStatement( 
				"INSERT INTO Choferes "+rows+ 
				" VALUES(?,?,?,?,?,?);");

			enunciado.setString(1,chofer.getNombreChofer());
			enunciado.setString(2,chofer.getTelefonoChofer());
			enunciado.setFloat(3,chofer.getSalarioChofer());
			enunciado.setString(4,chofer.getUsernameChofer());
			enunciado.setString(5,chofer.getPasswordChofer());
			enunciado.setBoolean(6,chofer.getEsAdmin());
			enunciado.execute();
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<Chofer> getAllChoferes(){
		try{

			resultado=consulta.executeQuery(
				"SELECT * FROM Choferes;");

			while(resultado.next()){
				Chofer c=new Chofer(
					resultado.getString("nombreChofer"),
					resultado.getString("usernameChofer"),
					resultado.getString("passwordChofer"),
					resultado.getString("telefonoChofer"),
					resultado.getFloat("salarioChofer"),
					resultado.getBoolean("esAdmin"),
					resultado.getBoolean("activo"));
				if(c.getActivo()){
					choferes.add(c);
				}
			}
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		return choferes;
	}

	public String getNombreChoferFromID(String id){
		id="\""+id+"\"";
		String nombreChofer="";
		try{
			resultado=consulta.executeQuery(
				"SELECT * FROM Choferes WHERE usernameChofer="+id+";");
			
			while(resultado.next()){
				nombreChofer=resultado.getString("nombreChofer");
			}
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}

		return nombreChofer;
	}

	public Chofer getChoferFromID(String id){
		id="\""+id+"\"";
		Chofer c=new Chofer();
		try{
			resultado=consulta.executeQuery(
				"SELECT * FROM Choferes WHERE usernameChofer="+id+";");
			
			while(resultado.next()){
				c=new Chofer(
					resultado.getString("nombreChofer"),
					resultado.getString("telefonoChofer"),
					resultado.getString("usernameChofer"),
					resultado.getString("passwordChofer"),
					resultado.getFloat("salarioChofer"),
					resultado.getBoolean("esAdmin"));
			}
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}

		return c;
	}

	public void eliminarChofer(String id){
		try{
			id="\""+id+"\"";
			enunciado=conexion.prepareStatement( 
				"UPDATE Choferes SET activo=? WHERE usernameChofer="+id+";");
			enunciado.setBoolean(1,false);	
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void updateChofer(String id, Chofer c){

		try{
			id="\""+id+"\"";
			enunciado=conexion.prepareStatement( 
				"UPDATE Choferes SET nombreChofer=?,telefonoChofer=?,salarioChofer=? WHERE usernameChofer="+id+";");
			enunciado.setString(1,c.getNombreChofer());	
			enunciado.setString(2,c.getTelefonoChofer());
			enunciado.setFloat(3,c.getSalarioChofer());
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}


}