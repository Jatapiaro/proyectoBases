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
import conexiones.ConexionFlete;

public class ObtenerFletesAntiguos extends HttpServlet{


	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)throws ServletException,IOException{

		request.setAttribute("ListaDeFletes",
			new ConexionFlete().getAntiguosFletes());
		request.getRequestDispatcher("VerFletes2.jsp").forward(request,response);

	}

	


}