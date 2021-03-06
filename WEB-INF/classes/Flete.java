package beans;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import beans.Cargamento;
import beans.Vehiculo;
import beans.Chofer;
import beans.Cliente;
import beans.Reparto;


public class Flete{

	private int fleteID,clienteID,kilometros;
	private String vehiculoID,choferID,direccionRecoleccion,direccionEntrega,zona;
	private float precio;
	private Timestamp horaSalidaRecoleccion,horaSalidaEntrega;
	private Timestamp fechaHoraRecoleccion,fechaHoraEntrega;
	private boolean recoleccionManiobra,entregaManiobra;
	private String clienteNombre,choferNombre;
	private float peso;
	private String advertencia;
	private ArrayList<Reparto> repartos=new ArrayList<Reparto>();
	private Vehiculo vehiculo;

	public Flete(){

	}

	public Flete(int fleteID,int clienteID,int kilometros,
		String vehiculoID,String choferID,String direccionRecoleccion,
		String direccionEntrega,String zona,float precio,
		Timestamp horaSalidaRecoleccion,Timestamp horaSalidaEntrega,
		Timestamp fechaHoraRecoleccion,Timestamp fechaHoraEntrega,
		boolean recoleccionManiobra,boolean entregaManiobra){

		this.fleteID=fleteID;
		this.clienteID=clienteID;
		this.kilometros=kilometros;
		if(vehiculoID!=null){
			this.vehiculoID=vehiculoID;
		}else{
			vehiculoID=null;
		}
		this.choferID=choferID;
		this.direccionRecoleccion=direccionRecoleccion;
		this.direccionEntrega=direccionEntrega;
		this.zona=zona;
		this.precio=precio;

		if(horaSalidaRecoleccion!=null){
			this.horaSalidaRecoleccion=horaSalidaRecoleccion;
		}else{
			this.horaSalidaRecoleccion=null;
		}

		if(horaSalidaEntrega!=null){
			this.horaSalidaEntrega=horaSalidaEntrega;
		}else{
			this.horaSalidaEntrega=null;
		}

		this.fechaHoraRecoleccion=fechaHoraRecoleccion;
		this.fechaHoraEntrega=fechaHoraEntrega;

		this.recoleccionManiobra=recoleccionManiobra;
		this.entregaManiobra=entregaManiobra;

	}



	public Flete(int clienteID,String choferID,String direccionRecoleccion,
		String direccionEntrega,Timestamp fechaHoraRecoleccion,
		Timestamp fechaHoraEntrega,String zona){
			this.clienteID=clienteID;
			this.choferID=choferID;
			this.direccionRecoleccion=direccionRecoleccion;
			this.direccionEntrega=direccionEntrega;
			this.fechaHoraRecoleccion=fechaHoraRecoleccion;
			this.fechaHoraEntrega=fechaHoraEntrega;
			this.zona=zona;
	}

	public Flete(int clienteID,String choferID,String direccionRecoleccion,
		String direccionEntrega,String zona){

			this.clienteID=clienteID;
			this.choferID=choferID;
			this.direccionRecoleccion=direccionRecoleccion;
			this.direccionEntrega=direccionEntrega;
			this.zona=zona;

	}

	public Flete(int clienteID,String choferID,String direccionRecoleccion,
		String direccionEntrega,Timestamp fechaHoraRecoleccion,
		Timestamp fechaHoraEntrega,String zona,int kilometros){

			this.clienteID=clienteID;
			this.choferID=choferID;
			this.direccionRecoleccion=direccionRecoleccion;
			this.direccionEntrega=direccionEntrega;
			this.fechaHoraRecoleccion=fechaHoraRecoleccion;
			this.fechaHoraEntrega=fechaHoraEntrega;
			this.zona=zona;
			this.kilometros=kilometros;

	}


	public void setFleteID(int fleteID){
		this.fleteID=fleteID;
	}

	public int getFleteID(){
		return this.fleteID;
	}

	public void setClienteID(int clienteID){
		this.clienteID=clienteID;
	}

	public int getClienteID(){
		return this.clienteID;
	}

	public void setKilometros(int kilometros){
		this.kilometros=kilometros;
	}

	public int getKilometros(){
		return this.kilometros;
	}

	public void setVehiculoID(String vehiculoID){
		this.vehiculoID=vehiculoID;
	}

	public String getVehiculoID(){
		return this.vehiculoID;
	}

	public void setChoferID(String choferID){
		this.choferID=choferID;
	}

	public String getChoferID(){
		return this.choferID;
	}

	public void setDireccionRecoleccion(String direccionRecoleccion){
		this.direccionRecoleccion=direccionRecoleccion;
	}

	public String getDireccionRecoleccion(){
		return this.direccionRecoleccion;
	}

	public void setDireccionEntrega(String direccionEntrega){
		this.direccionEntrega=direccionEntrega;
	}

	public String getDireccionEntrega(){
		return this.direccionEntrega;
	}

	public void setZona(String zona){
		this.zona=zona;
	}

	public String getZona(){
		return this.zona;
	}

	public void setHoraSalidaRecoleccion(Timestamp horaSalidaRecoleccion){
		this.horaSalidaRecoleccion=horaSalidaRecoleccion;
	}

	public Timestamp getHoraSalidaRecoleccion(){
		return this.horaSalidaRecoleccion;
	}

	public void setHoraSalidaEntrega(Timestamp horaSalidaEntrega){
		this.horaSalidaEntrega=horaSalidaEntrega;
	}

	public Timestamp getHoraSalidaEntrega(){
		return this.horaSalidaEntrega;
	}

	public void setFechaHoraRecoleccion(Timestamp fechaHoraRecoleccion){
		this.fechaHoraRecoleccion=fechaHoraRecoleccion;
	}

	public Timestamp getFechaHoraRecoleccion(){
		return this.fechaHoraRecoleccion;
	}

	public void setFechaHoraEntrega(Timestamp fechaHoraEntrega){
		this.fechaHoraEntrega=fechaHoraEntrega;
	}

	public Timestamp getFechaHoraEntrega(){
		return this.fechaHoraEntrega;
	}

	public void setRecoleccionManiobra(boolean recoleccionManiobra){
		this.recoleccionManiobra=recoleccionManiobra;
	}

	public boolean getRecoleccionManiobra(){
		return this.recoleccionManiobra;
	}

	public void setEntregaManiobra(boolean entregaManiobra){
		this.entregaManiobra=entregaManiobra;
	}

	public boolean getEntregaManiobra(){
		return this.entregaManiobra;
	}

	public float getPrecio(){
		this.precio=0;
		this.precio+=vehiculo.getCostoVehiculo();
		this.precio+=precioPorZona();
		this.precio+=precioRepartos();
		if(recoleccionManiobra==true){
			this.precio+=((peso/1000)*100);
		}
		if(entregaManiobra==true){
			this.precio+=((peso/1000)*100);
		}
		return precio;
	}

	public float precioPorZona(){
		float p=0;
		if(zona.equals("Norte")){
			p=1000;
		}else if(zona.equals("Sur")){
			p=1200;
		}else if(zona.equals("Oriente")){
			p=1500;
		}else if(zona.equals("Poniente")){
			p=1200;
		}else if(zona.equals("Foraneo")){
			p=kilometros*30;
		}
		return p;
	}

	public float precioRepartos(){
		float precio=0;
		if(repartos.size()!=0){
			for (Reparto r : repartos) {
				precio+=200;
				if(r.getManiobra()==true){
					precio+=100;
				}
			}
		}
		return precio;
	}

	public void setChoferNombre(String choferNombre){
		this.choferNombre=choferNombre;
	}

	public String getChoferNombre(){
		return this.choferNombre;
	}

	public void setClienteNombre(String clienteNombre){
		this.clienteNombre=clienteNombre;
	}

	public String getClienteNombre(){
		return this.clienteNombre;
	}

	public void setPeso(float peso){
		this.peso=peso;
	}

	public float getPeso(){
		return this.peso;
	}

	public void setAdvertencia(String advertencia){
		this.advertencia=advertencia;
	}

	public String getAdvertencia(){
		return this.advertencia;
	}

	public void setVehiculo(Vehiculo vehiculo){
		this.vehiculo=vehiculo;
	}

	public void setRepartos(ArrayList<Reparto> repartos){
		this.repartos=repartos;
	}

}