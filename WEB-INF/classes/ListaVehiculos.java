package modelos;
import java.util.*;
import beans.Vehiculo;
import conexiones.ConexionVehiculo;

public class ListaVehiculos{

	public ArrayList<Vehiculo> vehiculos;
	
	public ListaVehiculos(){
		vehiculos= new ConexionVehiculo().getAllVehiculos();
	}

	public void agregarVehiculo(Vehiculo vehiculo){
		new ConexionVehiculo().agregarVehiculo(vehiculo);
	}
	
	public ArrayList <Vehiculo> getVehiculos(){
		return vehiculos;
	} 

}