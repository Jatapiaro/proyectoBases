import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Cargamento;
import modelos.ListaCargamentos;
import conexiones.ConexionFlete;


public class ActualizarCargamentoController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		int fleteID=Integer.parseInt(request.getParameter("fleteID"));
		int cargamentoID=Integer.parseInt(request.getParameter("cargamentoID"));
		String tipoCargamento=request.getParameter("tipoCargamento");
		float pesoCargamento=Float.parseFloat(request.getParameter("pesoCargamento"));
		boolean delicadoCargamento=Boolean.parseBoolean(request.getParameter("delicadoCargamento"));
		Cargamento c=new Cargamento(tipoCargamento,pesoCargamento,delicadoCargamento);
		new ListaCargamentos().modificarCargamento(cargamentoID,c);
		request.setAttribute("mensaje","Cargamento modificado de manera exitosa");
		String color="10E214";
		request.setAttribute("coloreado",color);
		request.setAttribute("ListaDeCargamentos",new ListaCargamentos(fleteID).getCargamentos());
	 	request.getRequestDispatcher("VerCargamentos.jsp").forward(request,response);
	}


}