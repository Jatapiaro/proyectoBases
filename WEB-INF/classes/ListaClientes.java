package modelos;
import beans.Cliente;
import conexiones.ConexionCliente;
import conexiones.ConexionFlete;

import java.util.*;

public class ListaClientes{
	
	private ArrayList<Cliente> clientes;

	public ListaClientes(){
		clientes=new ConexionCliente().getAllClientes();
	}

	public void agregarCliente(Cliente cliente){
		new ConexionCliente().addCliente(cliente);
	}

	public ArrayList<Cliente> obtenerClientes(){
		return clientes;
	}

	public Cliente getClienteFromID(int id){
		Cliente c=new ConexionCliente().getClienteFromID(id);
		if(c!=null){
			return c;
		}else{
			return new Cliente("Cliente dado de baja","xx","xx",0,0);
		}
	}

	public void eliminarCliente(int id){
		new ConexionCliente().eliminarCliente(id);
	}



	
}