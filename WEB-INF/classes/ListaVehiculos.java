package modelos;
import java.util.*;
import beans.Vehiculo;
import conexiones.ConexionVehiculo;

public class ListaVehiculos{

	private ArrayList<Vehiculo> vehiculos;
	
	public ListaVehiculos(){
		vehiculos= new ConexionVehiculo().getAllVehiculos();
	}

	public void agregarVehiculo(Vehiculo vehiculo){
		new ConexionVehiculo().agregarVehiculo(vehiculo);
	}
	
	public ArrayList <Vehiculo> getVehiculos(){
		return vehiculos;
	} 

	public Vehiculo getVehiculoForWeight(float weight){
		return new ConexionVehiculo().getVehiculoForWeight(weight);
	}

	public String menorVehiculo(){
		Vehiculo menor=vehiculos.get(0);
		float min=vehiculos.get(0).getCapacidadVehiculo();
		for (Vehiculo v : vehiculos) {
			if(v.getCapacidadVehiculo()<min){
				min=v.getCapacidadVehiculo();
				menor=v;
			}
		}
		return menor.getPlacasVehiculo();	
	}

	public void eliminarVehiculo(String id){
		new ConexionVehiculo().eliminarVehiculo(id);
	}

	public void modificarVehiculo(String id,Vehiculo v){
		new ConexionVehiculo().updateVehiculo(id,v);
	}	

	public float getVehiculoMaxCapacidad(){
		return new ConexionVehiculo().getVehiculoMaxCapacidad();
	}

	public Vehiculo getVehiculoFromID(String id){
		return new ConexionVehiculo().getVehiculoFromID(id);
	}


}