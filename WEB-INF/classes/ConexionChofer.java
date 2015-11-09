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

			//INSERT INTO chofers (nombrechofer,telefonochofer,contactochofer,deudachofer) VALUES ("Insumos","5521505060","Armando",0);  
			String rows="(nombreChofer,telefonoChofer,contactoChofer,deudaChofer)";
			enunciado=conexion.prepareStatement( 
				"INSERT INTO Choferes "+rows+ 
				" VALUES(?,?,?);");

			enunciado.setString(1,chofer.getNombreChofer());
			enunciado.setString(2,chofer.getTelefonoChofer());
			enunciado.setFloat(3,chofer.getSalarioChofer());

			enunciado.execute();

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
					resultado.getString("telefonoChofer"),
					resultado.getFloat("salarioChofer")));
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return choferes;
	}
}