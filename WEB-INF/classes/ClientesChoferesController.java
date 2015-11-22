import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cliente;
import beans.Chofer;
import beans.Vehiculo;
import modelos.ListaClientes;
import modelos.ListaChoferes;
import modelos.ListaVehiculos;


public class ClientesChoferesController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{
	}



	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)throws ServletException,IOException{

		ArrayList<Cliente> c=new ListaClientes().obtenerClientes();
		ArrayList<Chofer> ch=new ListaChoferes().obtenerChoferes();
		ArrayList<Vehiculo> v=new ListaVehiculos().getVehiculos();


		if(c.size()==0 && v.size()==0){
			request.setAttribute("mensaje","No tienes registrado ningun Vehiculo o Cliente");
			request.setAttribute("direccion","Index.jsp");
			request.getRequestDispatcher("FaltanDatos.jsp").forward(request,response);
		}else if(c.size()==0){
			request.setAttribute("mensaje","No tienes registrado ningun Cliente");
			request.setAttribute("direccion","Index.jsp");
			request.getRequestDispatcher("FaltanDatos.jsp").forward(request,response);
		}else if(v.size()==0){
			request.setAttribute("mensaje","No tienes registrado ningun Vehiculo");
			request.setAttribute("direccion","Index.jsp");
			request.getRequestDispatcher("FaltanDatos.jsp").forward(request,response);
		}else if(c.size()>0 && v.size()>0){
			request.setAttribute("ListaDeClientes",c);
			request.setAttribute("ListaDeChoferes",ch);
			request.getRequestDispatcher("RegistroFlete.jsp").forward(request,response);	
		}


	}



}