package modelos;
import beans.Cargamento;
import conexiones.ConexionCargamento;
import java.util.*;

public class ListaCargamentos{

	private ArrayList<Cargamento> cargamentos;

	public ListaCargamentos(){

	}

	public ListaCargamentos(int idFlete){
		cargamentos=new ConexionCargamento().getCargamentos(idFlete);
	}

	public ArrayList<Cargamento> getCargamentos(){
		return cargamentos;
	}

	public float pesoCargamentos(int idFlete){
		return new ConexionCargamento().pesoCargamentos(idFlete);
	}

}