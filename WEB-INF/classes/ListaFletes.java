package modelos;
import beans.Flete;
import conexiones.ConexionFlete;
import java.util.*;

public class ListaFletes{
	
	private ArrayList<Flete> fletes;

	public ListaFletes(){
		fletes=new ConexionFlete().getAllFletes();
	}

	public void agregarFlete(Flete flete){
	 	new ConexionFlete().addFlete(flete);
	}

	public ArrayList<Flete> obtenerFletes(){
		//javax.swing.JOptionPane.showMessageDialog(null,fletes.size());
	 	return fletes;
	}
	
}