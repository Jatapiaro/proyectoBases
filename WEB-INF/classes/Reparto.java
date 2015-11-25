package beans;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.time.LocalDateTime;
public class Reparto{
	private int repartoID,fleteID;
	private boolean maniobra,entregado;
	private String direccion;
	private Timestamp horaSalida;

	public Reparto(){

	}

	public Reparto(String direccion, int fleteID){
		this.direccion=direccion;
		this.fleteID=fleteID;
	}

	public Reparto(int repartoID,int fleteID,
		boolean maniobra,boolean entregado,String direccion,
		Timestamp horaSalida){

		this.repartoID=repartoID;
		this.fleteID=fleteID;
		this.maniobra=maniobra;
		this.entregado=entregado;
		this.direccion=direccion;
		if(horaSalida!=null){
			this.horaSalida=horaSalida;
		}else{
			this.horaSalida=null;
		}

	}

	public Reparto(int repartoID,int fleteID,
		boolean maniobra,boolean entregado,String direccion){

		this.repartoID=repartoID;
		this.fleteID=fleteID;
		this.maniobra=maniobra;
		this.entregado=entregado;
		this.direccion=direccion;

	}

	public Reparto(int repartoID,String direccion){
		this.repartoID=repartoID;
		this.direccion=direccion;
	}

	public int getRepartoID(){
		return this.repartoID;
	}

	public int getFleteID(){
		return this.fleteID;
	}

	public boolean getManiobra(){
		return this.maniobra;
	}

	public boolean getEntregado(){
		return this.entregado;
	}

	public String getDireccion(){
		return this.direccion;
	}

	public Timestamp getHoraSalida(){
		return this.horaSalida;
	}
}