package beans;

public class Vehiculo {
	
	private String placasVehiculo;
	private float costoVehiculo,capacidadVehiculo;
	
	public Vehiculo(){
		
	}
	
	public Vehiculo(String placasVehiculo, float costoVehiculo,
	 float capacidadVehiculo) {

	 	if(costoVehiculo<0){
			costoVehiculo=0;
		}

		if(capacidadVehiculo<0){
			capacidadVehiculo=0;
		}

		this.placasVehiculo = placasVehiculo;
		this.costoVehiculo = costoVehiculo;
		this.capacidadVehiculo = capacidadVehiculo;
	}

	public void setPlacasVehiculo(String placasVehiculo) {
		this.placasVehiculo = placasVehiculo;
	}

	public String getPlacasVehiculo() {
		return this.placasVehiculo;
	}

	public void setCostoVehiculo(float costoVehiculo) {
		if(costoVehiculo<0){
			costoVehiculo=0;
		}
		this.costoVehiculo = costoVehiculo;
	}

	public float getCostoVehiculo() {
		return this.costoVehiculo;
	}

	public void setCapacidadVehiculo(float capacidadVehiculo) {
		if(capacidadVehiculo<0){
			capacidadVehiculo=0;
		}
		this.capacidadVehiculo = capacidadVehiculo;
	}

	public float getCapacidadVehiculo() {
		return this.capacidadVehiculo;
	}
	

}