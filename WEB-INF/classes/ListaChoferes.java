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
}