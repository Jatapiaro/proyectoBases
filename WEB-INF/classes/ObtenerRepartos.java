import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Reparto;
import modelos.ListaRepartos;


public class ObtenerRepartos extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{

		int id=Integer.parseInt(request.getParameter("theID"));
		request.setAttribute("fleteID",id);
		javax.swing.JOptionPane.showMessageDialog(null,new ListaRepartos(id).getRepartos().size());
		request.setAttribute("ListaDeRepartos",new ListaRepartos(id).getRepartos());
		request.getRequestDispatcher("VerRepartos.jsp").forward(request,response);

	}

}