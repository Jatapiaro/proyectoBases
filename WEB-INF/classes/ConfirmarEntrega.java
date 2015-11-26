import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import conexiones.ConexionFlete;
import modelos.ListaFletes;
import beans.Flete;
import java.util.Date;
import modelos.ListaRepartos;
import beans.Reparto;


public class ConfirmarEntrega extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{


		int idFlete=Integer.parseInt(request.getParameter("theID"));
		String fechaHoraEntrega=request.getParameter("fechaHoraEntrega");

		String horaSalidaRecoleccion=request.getParameter("horaSalidaRecoleccion");
		boolean man=Boolean.parseBoolean(request.getParameter("maniobraEntrega"));
		Timestamp myTime=timeStamp();
		ArrayList<Reparto> r=new ListaRepartos(idFlete).getRepartos();
		boolean todosEntregados=true;
		if(r.size()!=0){
			for (Reparto re : r) {
				if(re.getEntregado()==false){
					todosEntregados=false;
					break;
				}
			}
		}

		if(horaSalidaRecoleccion.equals("")){
			//javax.swing.JOptionPane.showMessageDialog(null,"Entro 1");
			request.setAttribute("mensaje","Aún no has recolectado el flete");
		    request.setAttribute("ListaDeFletes",new ListaFletes().obtenerProximosFletes());
			request.getRequestDispatcher("VerFletes.jsp").forward(request,response);
		}
		else if(myTime.compareTo(Timestamp.valueOf(fechaHoraEntrega))<0 && !horaSalidaRecoleccion.equals("")){
			//javax.swing.JOptionPane.showMessageDialog(null,"Entro 2");
			request.setAttribute("mensaje","Aun no es tiempo de entregar el flete");
		    request.setAttribute("ListaDeFletes",new ListaFletes().obtenerProximosFletes());
			request.getRequestDispatcher("VerFletes.jsp").forward(request,response);
		}
		else if(todosEntregados==false && myTime.compareTo(Timestamp.valueOf(fechaHoraEntrega))>=0 && horaSalidaRecoleccion.length()>0){
			request.setAttribute("mensaje","No has entregado todos los repartos");
		    request.setAttribute("ListaDeFletes",new ListaFletes().obtenerProximosFletes());
			request.getRequestDispatcher("VerFletes.jsp").forward(request,response);
		}
		else if(todosEntregados==true && myTime.compareTo(Timestamp.valueOf(fechaHoraEntrega))>=0 && horaSalidaRecoleccion.length()>0){
			new ConexionFlete().completarEntrega(idFlete,man);
			request.setAttribute("ListaDeFletes",new ListaFletes().obtenerProximosFletes());
			request.getRequestDispatcher("VerFletes.jsp").forward(request,response);
		}

	}

	public Timestamp timeStamp(){
		Date d2=new Date();
	    return new Timestamp(d2.getTime());
	}

}