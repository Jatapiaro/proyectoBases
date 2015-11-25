package modelos;
import beans.Cargamento;
import conexiones.ConexionCargamento;
import java.util.*;

public class ListaCargamentos{

	private ArrayList<Cargamento> cargamentos;

	public ListaCargamentos(int idFlete){
		cargamentos=new ConexionCargamento().getCargamentos(idFlete);
	}

	public ListaCargamentos(){

	}

	public ArrayList<Cargamento> getCargamentos(){
		return cargamentos;
	}

	public float pesoCargamentos(int idFlete){
		return new ConexionCargamento().pesoCargamentos(idFlete);
	}

	public Cargamento getCargamentoFromID(int id){
		return new ConexionCargamento().getCargamentoFromID(id);
	}

	public void eliminarCargamento(int idCargamento){
		new ConexionCargamento().eliminarCargamento(idCargamento);
	}

	public void modificarCargamento(int id, Cargamento c){
		 new ConexionCargamento().modificarCargamento(id,c);
	}

}