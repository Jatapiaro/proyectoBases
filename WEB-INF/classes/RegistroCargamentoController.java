import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Date;
import beans.Cargamento;
import modelos.ListaCargamentos;
import conexiones.ConexionCargamento;


public class RegistroCargamentoController extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		ArrayList<String> parameters=new ArrayList<String>();
		int fleteID=Integer.parseInt(request.getParameter("idFromFlete"));

		String tipoCargamento=request.getParameter("tipoCargamento");
		parameters.add(tipoCargamento);
		String pesoCargamento=request.getParameter("pesoCargamento");
		parameters.add(pesoCargamento);
		String delicadoCargamento=request.getParameter("delicadoCargamento");
		parameters.add(delicadoCargamento);
		Timestamp t=Timestamp.valueOf(request.getParameter("fechaHoraRecoleccion"));
		if(validarParametros(parameters)){

			Cargamento cargamento=new Cargamento(
				fleteID,tipoCargamento,
				Float.parseFloat(pesoCargamento),
				Boolean.parseBoolean(delicadoCargamento));

			new ConexionCargamento().addCargamento(cargamento);

		request.setAttribute("mensaje","Cargamento agregado de manera exitosa");
		String color="10E214";
		request.setAttribute("fleteID",fleteID);
		request.setAttribute("fechaHoraRecoleccion",t);
		request.setAttribute("coloreado",color);
		request.setAttribute("ListaDeCargamentos",new ListaCargamentos(fleteID).getCargamentos());
	 	request.getRequestDispatcher("VerCargamentos.jsp").forward(request,response);

		}else{
			request.setAttribute("mensaje",
				"No has ingresado todos los datos");
			request.setAttribute("direccion","RegistrarCargamento.html");
			request.getRequestDispatcher("FaltanDatos.jsp").forward(request,response);
		}

	}

	public Timestamp timeStamp(){
		Date d2=new Date();
	    return new Timestamp(d2.getTime());
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

}