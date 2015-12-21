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
				"jdbc:mysql://localhost/TransportesRizo","jacobotapia","jacobo");

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
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<Cliente> getAllClientes(){
		try{

			resultado=consulta.executeQuery(
				"SELECT * FROM Clientes;");

			while(resultado.next()){
				Cliente c=new Cliente(
					resultado.getString("nombreCliente"),
					resultado.getString("telefonoCliente"),
					resultado.getString("contactoCliente"),
					resultado.getFloat("deudaCliente"),
					resultado.getInt("ClienteID"),
					resultado.getBoolean("activo"));
				if(c.getActivo()){
					clientes.add(c);
				}
				
			}
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		return clientes;
	}

	public Cliente getClienteFromID(int id){
		Cliente c=null;
		try{

			resultado=consulta.executeQuery(
				"SELECT * FROM Clientes WHERE ClienteID="+id+";");

			while(resultado.next()){
				c=new Cliente(
					resultado.getString("nombreCliente"),
					resultado.getString("telefonoCliente"),
					resultado.getString("contactoCliente"),
					resultado.getFloat("deudaCliente"),
					resultado.getInt("ClienteID"),
					resultado.getBoolean("activo")
					);
			}
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
	}

	public String getNombreClienteFromID(int id){
		String c="";
		try{

			resultado=consulta.executeQuery(
				"SELECT * FROM Clientes WHERE ClienteID="+id+";");

			while(resultado.next()){
				c=resultado.getString("nombreCliente");
			}
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
	}

	public void eliminarCliente(int id){
		try{
			//update users set num_points = ? where first_name = ?
			enunciado=conexion.prepareStatement( 
				"UPDATE Clientes SET activo=? WHERE ClienteID="+id+";");
			enunciado.setBoolean(1,false);	
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void modificarCliente(int id, Cliente c){
		try{
			enunciado=conexion.prepareStatement( 
				"UPDATE Clientes SET nombreCliente=?,telefonoCliente=?,contactoCliente=?,deudaCliente=? WHERE ClienteID="+id+";");
			enunciado.setString(1,c.getNombreCliente());
			enunciado.setString(2,c.getTelefonoCliente());
			enunciado.setString(3,c.getContactoCliente());
			enunciado.setFloat(4,c.getDeudaCliente());
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}



}