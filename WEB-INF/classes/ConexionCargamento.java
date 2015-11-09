package conexiones;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cargamento;

public class ConexionCargamento{

	private Statement consulta;
	private ResultSet resultado;
	private PreparedStatement enunciado;
	private Connection conexion;
	private Cargamento cargamento;

	public ConexionCargamento(){
		try{

			Class.forName("com.mysql.jdbc.Driver");

			conexion=DriverManager.getConnection(
				"jdbc:mysql://localhost/TransportesRizo","jacobo","jacobo");

			consulta=conexion.createStatement();

			cargamento=null;
			

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void addCargamento(Cargamento cargamento){
		try{

			//INSERT INTO Clientes (nombreCliente,telefonoCliente,contactoCliente,deudaCliente) VALUES ("Insumos","5521505060","Armando",0);  
			String rows="(tipoCargamento,pesoCargamento,delicadoCargamento)";
			enunciado=conexion.prepareStatement( 
				"INSERT INTO Cargamentos "+rows+ 
				" VALUES(?,?,?);");

			enunciado.setString(1,cargamento.getTipoCargamento());
			enunciado.setFloat(2,cargamento.getPesoCargamento());
			enunciado.setBoolean(3,cargamento.getDelicadoCargamento());
			enunciado.execute();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Cargamento getCargamento(int idFlete){
		/*
		**Obtiene un cargamento relacionado a un flete
		try{

			resultado=consulta.executeQuery(
				"SELECT * FROM Clientes;");

		}catch(Exception e){
			e.printStackTrace();
		}
		*/
		return cargamento;
		
	}

}
