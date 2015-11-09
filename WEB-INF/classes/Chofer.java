package beans;

public class Chofer{

	private String nombreChofer,telefonoChofer;
	private float salarioChofer;

	public Chofer(){

	}

	public Chofer(String nombreChofer,String telefonoChofer,
		float salarioChofer){
		this.nombreChofer=nombreChofer;
		this.telefonoChofer=telefonoChofer;
		this.salarioChofer=salarioChofer;
	}

	public void setNombreChofer(String nombreChofer){
		this.nombreChofer=nombreChofer;
	}

	public String getNombreChofer(){
		return this.nombreChofer;
	}

	public void setTelefonoChofer(String telefonoChofer){
		this.telefonoChofer=telefonoChofer;
	}

	public String getTelefonoChofer(){
		return this.telefonoChofer;
	}

	public void setSalarioChofer(float salarioChofer){
		if(salarioChofer<0){
			salarioChofer=0;
		}
		this.salarioChofer=salarioChofer;
	}

	public float getSalarioChofer(){
		return this.salarioChofer;
	}
}