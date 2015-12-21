package conexiones;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Flete;
import beans.Vehiculo;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import modelos.*;
import modelos.ListaCargamentos;
import modelos.ListaRepartos;
import java.util.Date;
import conexiones.ConexionCargamento;
import conexiones.ConexionReparto;
public class ConexionFlete{

	private Connection conexion;
	private Statement consulta;
	private ResultSet resultado;
	private PreparedStatement enunciado;
	private ArrayList<Flete> fletes;


	public ConexionFlete(){
		try{

			Class.forName("com.mysql.jdbc.Driver");

			conexion=DriverManager.getConnection(
				"jdbc:mysql://localhost/TransportesRizo","jacobo","jacobo");

			consulta=conexion.createStatement();

			fletes=new ArrayList<Flete>();


		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void addFlete(Flete flete){
		try{
			String rows="(clienteID,choferID,direccionRecoleccion,";
			rows+="direccionEntrega,zona,fechaHoraRecoleccion,";
			rows+="fechaHoraEntrega";

			if(flete.getZona().equals("Foraneo")){

				rows+=",kilometros,vehiculoID)";
			    enunciado=conexion.prepareStatement( 
				"INSERT INTO Fletes "+rows+ 
				" VALUES(?,?,?,?,?,?,?,?,?);");

				enunciado.setInt(1,flete.getClienteID());
				enunciado.setString(2,flete.getChoferID());
				enunciado.setString(3,flete.getDireccionRecoleccion());
		        enunciado.setString(4,flete.getDireccionEntrega());
		        enunciado.setString(5,flete.getZona());
		        enunciado.setTimestamp(6,flete.getFechaHoraRecoleccion());
		        enunciado.setTimestamp(7,flete.getFechaHoraEntrega());
		        enunciado.setInt(8,flete.getKilometros());
		        enunciado.setString(9,new ListaVehiculos().menorVehiculo());
		        enunciado.execute();
		        //conexion.close();

			}else{
				rows+=",vehiculoID)";
			    enunciado=conexion.prepareStatement( 
				"INSERT INTO Fletes "+rows+ 
				" VALUES(?,?,?,?,?,?,?,?);");
				enunciado.setInt(1,flete.getClienteID());
				enunciado.setString(2,flete.getChoferID());
				enunciado.setString(3,flete.getDireccionRecoleccion());
		        enunciado.setString(4,flete.getDireccionEntrega());
		        enunciado.setString(5,flete.getZona());
		        enunciado.setTimestamp(6, flete.getFechaHoraRecoleccion());
		        enunciado.setTimestamp(7, flete.getFechaHoraEntrega());
		        enunciado.setString(8,new ListaVehiculos().menorVehiculo());
		        enunciado.execute();
		        //conexion.close();
			}
			consulta.close();
			conexion.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public ArrayList<Flete> getProximosFletes(){
		try{

			resultado=consulta.executeQuery(
				"SELECT * FROM Fletes WHERE DATE(fechaHoraEntrega)>=CURDATE() AND activo=1 ORDER BY fechaHoraRecoleccion ASC;");

			while(resultado.next()){
				
				Flete flete=new Flete(
					resultado.getInt("fleteID"),
					resultado.getInt("clienteID"),
					resultado.getInt("kilometros"),
					resultado.getString("vehiculoID"),
					resultado.getString("choferID"),
					resultado.getString("direccionRecoleccion"),
					resultado.getString("direccionEntrega"),
					resultado.getString("zona"),
					resultado.getFloat("precio"),
					resultado.getTimestamp("horaSalidaRecoleccion"),
					resultado.getTimestamp("horaSalidaEntrega"),
					resultado.getTimestamp("fechaHoraRecoleccion"),
					resultado.getTimestamp("fechaHoraEntrega"),
					resultado.getBoolean("recoleccionManiobra"),
					resultado.getBoolean("entregaManiobra"));

				flete.setChoferNombre(new ListaChoferes().getNombreChoferFromID(flete.getChoferID()));
				flete.setClienteNombre(new ListaClientes().getNombreClienteFromID(flete.getClienteID()));
				float peso=new ListaCargamentos(flete.getFleteID()).pesoCargamentos(flete.getFleteID());
				flete.setVehiculoID(getIDVehiculo(peso));
				flete.setPeso(peso);
				float maxP=new ListaVehiculos().getVehiculoMaxCapacidad();
				if(peso>maxP){
					float aux=peso-maxP;
					flete.setAdvertencia("Estas sobrecargando "+aux+" kilogramos");
				}
				updateFleteVehiculo(flete.getFleteID(),flete.getVehiculoID());
				flete.setVehiculo(new ListaVehiculos().getVehiculoFromID(flete.getVehiculoID()));
				flete.setRepartos(new ListaRepartos(flete.getFleteID()).getRepartos());
				fletes.add(flete);
			}
			
			consulta.close();
			conexion.close();


		}catch(Exception e){
			e.printStackTrace();
		}

		return fletes;
	}

	public String getIDVehiculo(float peso){
		ArrayList<Vehiculo> vehic=new ListaVehiculos().getVehiculos();
		ArrayList<Vehiculo> posibles=new ArrayList<Vehiculo>();
		String s="";

		for (Vehiculo v:vehic) {
			if(v.getCapacidadVehiculo()>=peso){
				//s=v.getPlacasVehiculo();
				posibles.add(v);
			}
		}

		if(posibles.size()>0){
			float min=100000000;
			for (Vehiculo v : posibles) {
				if(v.getCapacidadVehiculo()<min){
					min=v.getCapacidadVehiculo();
					s=v.getPlacasVehiculo();
				}
			}
		}else{
			if(s.equals("")){
				float max=0;
				for (Vehiculo v : vehic) {
					if(v.getCapacidadVehiculo()>max){
						max=v.getCapacidadVehiculo();
						s=v.getPlacasVehiculo();
					}
				}
			}
		}
		return s;
	}

	public void updateFleteVehiculo(int id, String newID){
		try{
			enunciado=conexion.prepareStatement( 
				"UPDATE Fletes SET vehiculoID=? WHERE fleteID="+id+";");	
			enunciado.setString(1,newID);
			enunciado.executeUpdate();	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public LocalDateTime localDateConverter(String date){
		date=date.substring(0,date.length()-5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		return dateTime;
	}

	public int numeroFletesPorCliente(int idCliente){

		//SELECT COUNT(clienteID) AS nFletes FROM Fletes WHERE clienteID=7;
		int n=0;
		try{
			resultado=consulta.executeQuery(
				"SELECT COUNT(clienteID) AS nFletes FROM Fletes WHERE clienteID="
				+idCliente+" AND fechaHoraRecoleccion>=CURDATE() AND activo=1;");

			while(resultado.next()){
				n=resultado.getInt("nFletes");
			}
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return n;
	}

	public void eliminarFletesPorCliente(int idCliente){
		try{
			enunciado=conexion.prepareStatement( 
				"DELETE FROM Fletes WHERE clienteID="+idCliente+" AND activo=1;");	
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void completarRecoleccion(int idFlete,boolean b){
		try{
			enunciado=conexion.prepareStatement( 
				"UPDATE Fletes SET horaSalidaRecoleccion=?, recoleccionManiobra=? WHERE fleteID="+idFlete+";");
			enunciado.setTimestamp(1,timeStamp());
			enunciado.setBoolean(2,b);
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void completarEntrega(int idFlete,boolean m){
		try{
			enunciado=conexion.prepareStatement( 
				"UPDATE Fletes SET horaSalidaEntrega=?, entregaManiobra=? WHERE fleteID="+idFlete+";");
			enunciado.setTimestamp(1,timeStamp());
			enunciado.setBoolean(2,m);
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Timestamp timeStamp(){
		Date d2=new Date();
	    return new Timestamp(d2.getTime());
	}

	public int numeroFletesPorVehiculo(String id){
		int n=0;
		id="\""+id+"\"";
		try{
			resultado=consulta.executeQuery(
				"SELECT COUNT(clienteID) AS nFletes FROM Fletes WHERE vehiculoID="
				+id+" AND fechaHoraRecoleccion>CURDATE() AND activo=1;");

			while(resultado.next()){
				n=resultado.getInt("nFletes");
			}
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return n;
	}

	public Flete getFleteFromID(int id){
		Flete f=null;
		try{

			resultado=consulta.executeQuery(
				"SELECT * FROM Fletes WHERE fleteID="+id+";");

			while(resultado.next()){
				f=new Flete(
					resultado.getInt("clienteID"),
					resultado.getString("choferID"),
					resultado.getString("direccionRecoleccion"),
					resultado.getString("direccionEntrega"),
					resultado.getTimestamp("fechaHoraRecoleccion"),
					resultado.getTimestamp("fechaHoraEntrega"),
					resultado.getString("zona"),
					resultado.getInt("kilometros")
					);
			}
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}

	public void actualizarFlete(int idFlete,Flete f){
		try{
			enunciado=conexion.prepareStatement( 
				"UPDATE Fletes SET clienteID=?,choferID=?,direccionRecoleccion=?,direccionEntrega=?,fechaHoraRecoleccion=?,fechaHoraEntrega=?,zona=?,kilometros=? WHERE fleteID="+idFlete+";");
			enunciado.setInt(1,f.getClienteID());
			enunciado.setString(2,f.getChoferID());
			enunciado.setString(3,f.getDireccionRecoleccion());
			enunciado.setString(4,f.getDireccionEntrega());
			enunciado.setTimestamp(5,f.getFechaHoraRecoleccion());
			enunciado.setTimestamp(6,f.getFechaHoraEntrega());
			enunciado.setString(7,f.getZona());
			enunciado.setInt(8,f.getKilometros());
			enunciado.executeUpdate();
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Timestamp isCollected(int id){
		Timestamp t=null;
		try{

			resultado=consulta.executeQuery(
				"SELECT horaSalidaRecoleccion FROM Fletes WHERE fleteID="+id+";");

			while(resultado.next()){
				t=resultado.getTimestamp("horaSalidaRecoleccion");
			}
			consulta.close();
			conexion.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		return t;
	}

	public int numeroFletesPorChofer(String idChofer){
		idChofer="\""+idChofer+"\"";
		//SELECT COUNT(clienteID) AS nFletes FROM Fletes WHERE clienteID=7;
		int n=0;
		try{
			resultado=consulta.executeQuery(
				"SELECT COUNT(choferID) AS nFletes FROM Fletes WHERE choferID="
				+idChofer+" AND fechaHoraRecoleccion>=CURDATE() AND activo=1;");

			while(resultado.next()){
				n=resultado.getInt("nFletes");
			}
			consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return n;
	}

	public ArrayList<Flete> getAntiguosFletes(){
		try{

			resultado=consulta.executeQuery(
				"SELECT * FROM Fletes WHERE DATE(fechaHoraEntrega)<CURDATE() AND activo=1 ORDER BY fechaHoraRecoleccion ASC;");

			while(resultado.next()){
				
				Flete flete=new Flete(
					resultado.getInt("fleteID"),
					resultado.getInt("clienteID"),
					resultado.getInt("kilometros"),
					resultado.getString("vehiculoID"),
					resultado.getString("choferID"),
					resultado.getString("direccionRecoleccion"),
					resultado.getString("direccionEntrega"),
					resultado.getString("zona"),
					resultado.getFloat("precio"),
					resultado.getTimestamp("horaSalidaRecoleccion"),
					resultado.getTimestamp("horaSalidaEntrega"),
					resultado.getTimestamp("fechaHoraRecoleccion"),
					resultado.getTimestamp("fechaHoraEntrega"),
					resultado.getBoolean("recoleccionManiobra"),
					resultado.getBoolean("entregaManiobra"));

				flete.setChoferNombre(new ListaChoferes().getNombreChoferFromID(flete.getChoferID()));
				flete.setClienteNombre(new ListaClientes().getNombreClienteFromID(flete.getClienteID()));
				float peso=new ListaCargamentos(flete.getFleteID()).pesoCargamentos(flete.getFleteID());
				flete.setVehiculoID(getIDVehiculo(peso));
				flete.setPeso(peso);
				float maxP=new ListaVehiculos().getVehiculoMaxCapacidad();
				if(peso>maxP){
					float aux=peso-maxP;
					flete.setAdvertencia("Estas sobrecargando "+aux+" kilogramos");
				}
				updateFleteVehiculo(flete.getFleteID(),flete.getVehiculoID());
				flete.setVehiculo(new ListaVehiculos().getVehiculoFromID(flete.getVehiculoID()));
				flete.setRepartos(new ListaRepartos(flete.getFleteID()).getRepartos());
				fletes.add(flete);
			}
			
			consulta.close();
			conexion.close();


		}catch(Exception e){
			e.printStackTrace();
		}

		return fletes;
	}

	public void eliminarFlete(int id){
		try{
			enunciado=conexion.prepareStatement("UPDATE Fletes SET activo=0 WHERE fleteID="+id+";");
			enunciado.executeUpdate();
		    consulta.close();
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}


}