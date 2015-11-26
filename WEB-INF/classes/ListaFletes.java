package modelos;
import beans.Flete;
import conexiones.ConexionFlete;
import java.util.*;
import java.sql.*;

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

	public Flete getFleteFromID(int id){
		return new ConexionFlete().getFleteFromID(id);
	}

	public void actualizarFlete(int idFlete,Flete f){
		new ConexionFlete().actualizarFlete(idFlete,f);
	}

	public Timestamp isCollected(int id){
		return new ConexionFlete().isCollected(id);
	}
	
}