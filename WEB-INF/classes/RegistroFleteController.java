import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Flete;
import beans.Vehiculo;
import beans.Cliente;
import modelos.ListaFletes;
import modelos.ListaClientes;
import modelos.ListaVehiculos;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class RegistroFleteController extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		String kilometros="";
		ArrayList<String> parameters=new ArrayList<String>();
		String clienteID=request.getParameter("elCliente");
		parameters.add(clienteID);
		String fechaHoraRecoleccion=request.getParameter("fechaHoraRecoleccion").replace("T"," ");
		parameters.add(fechaHoraRecoleccion);
		String direccionRecoleccion=request.getParameter("direccionRecoleccion");
		parameters.add(direccionRecoleccion);
		String fechaHoraEntrega=request.getParameter("fechaHoraEntrega").replace("T"," ");
		parameters.add(fechaHoraEntrega);
		String direccionEntrega=request.getParameter("direccionEntrega");
		parameters.add(direccionEntrega);
		String choferID=request.getParameter("elChofer");
		parameters.add(choferID);
		String zona=request.getParameter("zona");
		parameters.add(zona);
		if(zona.equals("Foraneo")){
			kilometros=request.getParameter("kilometros");
			parameters.add(kilometros);
		}

		if(validarParametros(parameters)){
			if(zona.equals("Foraneo")){
					Flete flete=new Flete(
					Integer.parseInt(clienteID),
					choferID,direccionRecoleccion,
					direccionEntrega,
					localDateConverter(fechaHoraRecoleccion),
					localDateConverter(fechaHoraEntrega),
					zona,Integer.parseInt(kilometros)
					);
		    new ListaFletes().agregarFlete(flete);
			request.setAttribute("mensaje","Flete agregado de manera exitosa");
			request.setAttribute("direccion","Index.jsp");
			request.getRequestDispatcher("resultados.jsp").forward(request,response);
			}else{
				Flete flete=new Flete(
					Integer.parseInt(clienteID),
					choferID,direccionRecoleccion,
					direccionEntrega,
					localDateConverter(fechaHoraRecoleccion),
					localDateConverter(fechaHoraEntrega),
					zona
					);	
			new ListaFletes().agregarFlete(flete);
			request.setAttribute("mensaje","Flete agregado de manera exitosa");
			request.setAttribute("direccion","Index.jsp");
			request.getRequestDispatcher("resultados.jsp").forward(request,response);			
			}



		}else{
			request.setAttribute("mensaje","No has ingresado todos los datos");
			request.setAttribute("direccion","RegistroFlete.jsp");
			request.getRequestDispatcher("FaltanDatos.jsp").forward(request,response);
		}

	}

	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)throws ServletException,IOException{

		request.setAttribute("ListaDeFletes",
			new ListaFletes().obtenerProximosFletes());
		//javax.swing.JOptionPane.showMessageDialog(null,new ListaFletes().obtenerProximosFletes().size());
		request.getRequestDispatcher("VerFletes.jsp").forward(request,response);

	}

	
	boolean validarParametros(ArrayList<String> parametros){
		boolean validado=true;
		for (String p : parametros){
			if(p.equals("")){
				validado=false;
				break;
			}
		}
		return validado;
	}

	LocalDateTime localDateConverter(String date){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		return dateTime;
	}

}