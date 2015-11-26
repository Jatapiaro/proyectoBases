package beans;

public class Chofer{

	private String nombreChofer,telefonoChofer,usernameChofer,
	passwordChofer;
	private float salarioChofer;
	private boolean esAdmin,activo;

	public Chofer(){

	}

	public Chofer(String nombreChofer,String usernameChofer,
		String passwordChofer,String telefonoChofer,
		float salarioChofer,boolean esAdmin){
		this.nombreChofer=nombreChofer;
		this.telefonoChofer=telefonoChofer;
		this.usernameChofer=usernameChofer;
		this.passwordChofer=passwordChofer;
		this.salarioChofer=salarioChofer;
		this.esAdmin=esAdmin;
	}

	public Chofer(String nombreChofer,String telefonoChofer,float salarioChofer){
		this.nombreChofer=nombreChofer;
		this.telefonoChofer=telefonoChofer;
		this.salarioChofer=salarioChofer;
	}

	public Chofer(String nombreChofer,String usernameChofer,
		String passwordChofer,String telefonoChofer,
		float salarioChofer,boolean esAdmin,boolean activo){
		this.nombreChofer=nombreChofer;
		this.telefonoChofer=telefonoChofer;
		this.usernameChofer=usernameChofer;
		this.passwordChofer=passwordChofer;
		this.salarioChofer=salarioChofer;
		this.esAdmin=esAdmin;
		this.activo=activo;
	}

	public void setNombreChofer(String nombreChofer){
		this.nombreChofer=nombreChofer;
	}

	public String getNombreChofer(){
		return this.nombreChofer;
	}

	public void setUsernameChofer(String usernameChofer){
		this.usernameChofer=usernameChofer;
	}

	public String getUsernameChofer(){
		return this.usernameChofer;
	}

	public void setPasswordChofer(String passwordChofer){
		this.passwordChofer=passwordChofer;
	}

	public String getPasswordChofer(){
		return this.passwordChofer;
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

	public void setEsAdmin(boolean esAdmin){
		this.esAdmin=esAdmin;
	}

	public boolean getEsAdmin(){
		return this.esAdmin;
	}

	public void setActivo(boolean activo){
		this.activo=activo;
	}

	public boolean getActivo(){
		return this.activo;
	}
}