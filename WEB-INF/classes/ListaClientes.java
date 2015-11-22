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
		return new ConexionCliente().getClienteFromID(id);
	}

	public String getNombreClienteFromID(int id){
		return new ConexionCliente().getNombreClienteFromID(id);
	}

	public void eliminarCliente(int id){
		new ConexionCliente().eliminarCliente(id);
	}

	public void modificarCliente(int id,Cliente c){
		new ConexionCliente().modificarCliente(id,c);
	}

}