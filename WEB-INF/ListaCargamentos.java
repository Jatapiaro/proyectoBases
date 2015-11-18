package modelos;
import beans.Cargamento;
import conexiones.ConexionCargamento;
import java.util.*;

public class ListaCargamentos{

	private ArrayList<Chofer> cargamentos;

	public ListaCargamentos(int idFlete){
		choferes=new ConexionCargamento().getCargamentos(idFlete);
	}

}