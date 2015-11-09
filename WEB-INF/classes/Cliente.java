package beans;

public class Cliente{
	
	private String nombreCliente,telefonoCliente,contactoCliente;
	private float deudaCliente;

	public Cliente(){

	}

	public Cliente(String nombreCliente,String telefonoCliente,
		String contactoCliente){

		this.nombreCliente=nombreCliente;
		this.telefonoCliente=telefonoCliente;
		this.contactoCliente=contactoCliente;
		this.deudaCliente=0;

	}

	public Cliente(String nombreCliente,String telefonoCliente,
		String contactoCliente,float deudaCliente){

		this.nombreCliente=nombreCliente;
		this.telefonoCliente=telefonoCliente;
		this.contactoCliente=contactoCliente;
		this.deudaCliente=deudaCliente;

	}

	public void setNombreCliente(String nombreCliente){
		this.nombreCliente=nombreCliente;
	}

	public String getNombreCliente(){
		return this.nombreCliente;
	}

	public void setTelefonoCliente(String telefonoCliente){
		this.telefonoCliente=telefonoCliente;
	}

	public String getTelefonoCliente(){
		return this.telefonoCliente;
	}

	public void setContactoCliente(String contactoCliente){
		this.contactoCliente=contactoCliente;
	}

	public String getContactoCliente(){
		return this.contactoCliente;
	}

	public void setDeudaCliente(float deudaCliente){
		this.deudaCliente=deudaCliente;
	}

	public float getDeudaCliente(){
		return this.deudaCliente;
	}

}