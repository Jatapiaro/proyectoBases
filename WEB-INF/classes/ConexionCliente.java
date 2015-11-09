package conexiones;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cliente;

public class ConexionCliente{

	private Connection conexion;
	private Statement consulta;
	private ResultSet resultado;
	private PreparedStatement enunciado;
	private ArrayList<Cliente> clientes;


	public ConexionCliente(){
		try{

			Class.forName("com.mysql.jdbc.Driver");

			conexion=DriverManager.getConnection(
				"jdbc:mysql://localhost/TransportesRizo","jacobo","jacobo");

			consulta=conexion.createStatement();

			clientes=new ArrayList<Cliente>();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void addCliente(Cliente cliente){
		try{

			//INSERT INTO Clientes (nombreCliente,telefonoCliente,contactoCliente,deudaCliente) VALUES ("Insumos","5521505060","Armando",0);  
			String rows="(nombreCliente,telefonoCliente,contactoCliente,deudaCliente)";
			enunciado=conexion.prepareStatement( 
				"INSERT INTO Clientes "+rows+ 
				" VALUES(?,?,?,?);");

			enunciado.setString(1,cliente.getNombreCliente());
			enunciado.setString(2,cliente.getTelefonoCliente());
			enunciado.setString(3,cliente.getContactoCliente());
			enunciado.setFloat(4,0);

			enunciado.execute();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<Cliente> getAllClientes(){
		try{

			resultado=consulta.executeQuery(
				"SELECT * FROM Clientes;");

			while(resultado.next()){
				clientes.add(new Cliente(
					resultado.getString("nombreCliente"),
					resultado.getString("telefonoCliente"),
					resultado.getString("contactoCliente"),
					resultado.getFloat("deudaCliente")));
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return clientes;
	}

}