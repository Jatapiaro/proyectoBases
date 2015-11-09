package modelos;
import beans.Cliente;
import conexiones.ConexionCliente;
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
	
}