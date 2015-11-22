package modelos;
import beans.Flete;
import conexiones.ConexionFlete;
import java.util.*;

public class ListaFletes{
	
	private ArrayList<Flete> fletes;

	public ListaFletes(){
	}

	public void agregarFlete(Flete flete){
	 	new ConexionFlete().addFlete(flete);
	}

	public ArrayList<Flete> obtenerProximosFletes(){
		return new ConexionFlete().getProximosFletes();
	}
	
}