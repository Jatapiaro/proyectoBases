import java.io.*;
import java.util.Date;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import beans.Chofer;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class PruebaServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{
			
			Date d2=new Date();
			Timestamp t=new Timestamp(d2.getTime());
			String str=request.getParameter("fechaHoraRecoleccion").replace("T"," ");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
			String[] sd=t.toString().split("\\.");
			JOptionPane.showMessageDialog(null,sd[0]);


	}

	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)throws ServletException,IOException{

		HttpSession session=request.getSession();
		boolean isA=((Chofer)session.getAttribute("usuario")).getEsAdmin();
		if(isA){
			request.getRequestDispatcher("RegistroChofer.html").forward(request,response);
		}else{
			request.setAttribute("mensaje","No estas autorizado para realizar esta opreación");
			request.setAttribute("direccion","index.html");
			request.getRequestDispatcher("FaltanDatos.jsp").forward(request,response);
		}


	}

	public LocalDateTime localDateConverter(String date){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		return dateTime;
	}



}