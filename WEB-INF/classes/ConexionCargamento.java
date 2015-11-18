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
	private ArrayList<Cargamento> cargamentos;

	public ConexionCargamento(){
		try{

			Class.forName("com.mysql.jdbc.Driver");

			conexion=DriverManager.getConnection(
				"jdbc:mysql://localhost/TransportesRizo","jacobo","jacobo");

			consulta=conexion.createStatement();

			cargamentos=null;
			

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void addCargamento(Cargamento cargamento){
		try{

			//INSERT INTO Clientes (nombreCliente,telefonoCliente,contactoCliente,deudaCliente) VALUES ("Insumos","5521505060","Armando",0);  
			String rows="(tipoCargamento,pesoCargamento,delicadoCargamento,fleteID)";
			enunciado=conexion.prepareStatement( 
				"INSERT INTO Cargamentos "+rows+ 
				" VALUES(?,?,?,?);");

			enunciado.setString(1,cargamento.getTipoCargamento());
			enunciado.setFloat(2,cargamento.getPesoCargamento());
			enunciado.setBoolean(3,cargamento.getDelicadoCargamento());
			enunciado.setInt(4,cargamento.getFleteID());
			enunciado.execute();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<Cargamento> getCargamentos(int idFlete){

		try{
			resultado=consulta.executeQuery(
				"SELECT * FROM Cargamentos WHERE fleteID="+idFlete+";");

			while(resultado.next()){
				cargamentos.add(new Cargamento(
					resultado.getString("tipoCargamento"),
					resultado.getFloat("pesoCargamento"),
					resultado.getBoolean("delicadoCargamento"),
					resultado.getInt("cargamentoID")
					));
			}
			resultado.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		return cargamentos;
	}

	public float pesoCargamentos(int idFlete){

		float peso=0;

		try{
			resultado=consulta.executeQuery(
				"SELECT SUM(pesoCargamento) AS pesoTotal FROM Cargamentos WHERE fleteID="
				+idFlete+";");

			while(resultado.next()){
				peso=resultado.getFloat("pesoTotal");
			}

			resultado.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		return peso;
	}

}
