import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Chofer;
import modelos.ListaChoferes;
import java.util.*;
import javax.swing.JOptionPane;

public class LoginController extends HttpServlet{

	private String mensajeError;
	Chofer chofer;
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		ArrayList<Chofer> choferes=new ListaChoferes().obtenerChoferes();
		String username=request.getParameter("usernameChofer");
		String password=request.getParameter("passwordChofer");


		if(validarParametros(username,password) && 
			estaEnSistema(username,password,choferes)){

			HttpSession session=request.getSession();
		  	session.setAttribute("usuario",chofer);
			request.getRequestDispatcher("Index.jsp").forward(request,response);			
			

		}else{
			request.setAttribute("mensaje",
				mensajeError);
			request.setAttribute("direccion","Login.html");
			request.getRequestDispatcher("FaltanDatos.jsp").forward(request,response);
		}
	}

	public boolean validarParametros(String username,String password){

		if(!username.equals("") && !username.equals("")){
			return true;
		}else{
			mensajeError="No has ingresado todos los datos";
			return false;
		}

	}

	public boolean estaEnSistema(String username,String password,
		ArrayList<Chofer> choferes){

		boolean esta=false;
		for (Chofer c : choferes) {

			if(c.getUsernameChofer().equals(username) &&
				c.getPasswordChofer().equals(password)){
					esta=true;
				    chofer=c;
					break;
				}
			
		}

		if(!esta){
			mensajeError="No estas autorizado para entrar";
		}
		return esta;
	}
}