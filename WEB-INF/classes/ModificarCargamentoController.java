import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cargamento;
import modelos.ListaCargamentos;
import conexiones.ConexionFlete;


public class ModificarCargamentoController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{
		Timestamp t=Timestamp.valueOf(request.getParameter("fechaHoraRecoleccion"));
		int cargamentoID=Integer.parseInt(request.getParameter("cargamentoID"));
		request.setAttribute("cargamento",new ListaCargamentos().getCargamentoFromID(cargamentoID));
		request.getRequestDispatcher("ModificarCargamento.jsp").forward(request,response);
		
	}


}