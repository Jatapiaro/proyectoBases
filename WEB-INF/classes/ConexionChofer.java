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
				"jdbc:mysql://localhost/TransportesRizo","jacobo","jacobo");

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
				choferes.add(new Chofer(
					resultado.getString("nombreChofer"),
					resultado.getString("usernameChofer"),
					resultado.getString("passwordChofer"),
					resultado.getString("telefonoChofer"),
					resultado.getFloat("salarioChofer"),
					resultado.getBoolean("esAdmin")));
			}
			resultado.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		return choferes;
	}

	public Chofer getChoferFromID(String id){
		id="\""+id+"\"";
		Chofer c=null;
		try{
			resultado=consulta.executeQuery(
				"SELECT * FROM Choferes WHERE usernameChofer="+id+";");
			
			while(resultado.next()){
				c=new Chofer(
					resultado.getString("nombreChofer"),
					resultado.getString("usernameChofer"),
					resultado.getString("passwordChofer"),
					resultado.getString("telefonoChofer"),
					resultado.getFloat("salarioChofer"),
					resultado.getBoolean("esAdmin"));
			}
			resultado.close();

		}catch(Exception e){
			e.printStackTrace();
		}

		return c;
	}
}