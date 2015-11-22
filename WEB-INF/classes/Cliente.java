package beans;

public class Cliente{
	
	private String nombreCliente,telefonoCliente,contactoCliente;
	private float deudaCliente;
	private int clienteID;
	private boolean activo;

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

	public Cliente(String nombreCliente,String telefonoCliente,
		String contactoCliente,float deudaCliente,int clienteID,
		boolean activo){

		this.nombreCliente=nombreCliente;
		this.telefonoCliente=telefonoCliente;
		this.contactoCliente=contactoCliente;
		this.deudaCliente=deudaCliente;
		this.clienteID=clienteID;
		this.activo=activo;

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

	public void setClienteID(int clienteID){
		this.clienteID=clienteID;
	}

	public int getClienteID(){
		return this.clienteID;
	}

	public void setActivo(boolean activo){
		this.activo=activo;
	}

	public boolean getActivo(){
		return this.activo;
	}

}