import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Flete;
import modelos.ListaFletes;
import conexiones.ConexionFlete;


public class ModificarFleteController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		int fleteID=Integer.parseInt(request.getParameter("theID"));
		String kilometros="";
		String clienteID=request.getParameter("elCliente");
		String fechaHoraRecoleccion=request.getParameter("fechaHoraRecoleccion").replace("T"," ");
		fechaHoraRecoleccion+=":00.00";
		String direccionRecoleccion=request.getParameter("direccionRecoleccion");
		String fechaHoraEntrega=request.getParameter("fechaHoraEntrega").replace("T"," ");
		fechaHoraEntrega+=":00.00";

		String direccionEntrega=request.getParameter("direccionEntrega");
		String choferID=request.getParameter("elChofer");
		String zona=request.getParameter("zona");
		kilometros=request.getParameter("kilometros");
		
		//javax.swing.JOptionPane.showMessageDialog(null,fleteID);

		Flete flete=new Flete(
				Integer.parseInt(clienteID),
				choferID,direccionRecoleccion,
				direccionEntrega,
				Timestamp.valueOf(fechaHoraRecoleccion),
				Timestamp.valueOf(fechaHoraEntrega),
				zona,Integer.parseInt(kilometros)
				);
		new ListaFletes().actualizarFlete(fleteID,flete);
		request.setAttribute("mensaje","Flete modificado");
		request.setAttribute("direccion","Index.jsp");
		request.getRequestDispatcher("resultados.jsp").forward(request,response);

	}


}