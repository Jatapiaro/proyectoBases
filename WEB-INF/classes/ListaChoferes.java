package modelos;
import beans.Chofer;
import conexiones.ConexionChofer;
import java.util.*;

public class ListaChoferes{

	private ArrayList<Chofer> choferes;

	public ListaChoferes(){
		choferes=new ConexionChofer().getAllChoferes();
	}

	public void agregarChofer(Chofer chofer){
		new ConexionChofer().addChofer(chofer);
	}

	public ArrayList<Chofer> obtenerChoferes(){
		return choferes;
	}

	public Chofer getChoferFromID(String id){
		return new ConexionChofer().getChoferFromID(id);
	}

	public String getNombreChoferFromID(String id){
		return new ConexionChofer().getNombreChoferFromID(id);
	}

	public void eliminarChofer(String id){
		new ConexionChofer().eliminarChofer(id);
	}

	public void updateChofer(String id, Chofer c){
		new ConexionChofer().updateChofer(id,c);
	}
}