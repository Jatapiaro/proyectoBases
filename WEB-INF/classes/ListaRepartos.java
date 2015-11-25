package modelos;
import java.util.*;
import java.sql.*;
import beans.Reparto;
import conexiones.ConexionReparto;

public class ListaRepartos{

	private ArrayList<Reparto> repartos;
	
	public ListaRepartos(int fleteID){
		repartos=new ConexionReparto().getRepartos(fleteID);
	}

	public ArrayList<Reparto> getRepartos(){
		return this.repartos;
	}

	public void addReparto(Reparto reparto){
		new ConexionReparto().addReparto(reparto);
	}

	public Reparto getRepartoFromID(int id){
		return new ConexionReparto().getRepartoFromID(id);
	}

	public void setEntregado(int id, boolean m,Timestamp t){
		new ConexionReparto().entregado(id,m,t);
	}

}