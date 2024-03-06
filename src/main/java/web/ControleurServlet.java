package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IMedecinDao;
import dao.IMedecinDao;
import dao.MedecinDaoImpl;
import dao.MedecinDaoImpl;
import metier.entities.Medecin;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	
	 IMedecinDao metier;
	 @Override
	public void init() throws ServletException {
		metier = new MedecinDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{
			request.getRequestDispatcher("medecins.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
			String motCle=request.getParameter("motCle");
			MedecinModele model= new MedecinModele();
			model.setMotCle(motCle);
			List<Medecin> meds = metier.MedecinsParMC(motCle);
			model.setMedecins(meds);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Medecins.jsp").forward(request,response);
		}
		else if (path.equals("/saisie.do")  )
		{
			request.getRequestDispatcher("saisieMedecin.jsp").forward(request,response);
		}
		else if (path.equals("/save.do")  && request.getMethod().equals("POST"))
		{
		    String nom=request.getParameter("nom");
		    String specialite=request.getParameter("specialite");
		    String faculte=request.getParameter("faculte");
			Medecin m = metier.save(new Medecin(nom,specialite,faculte));
			request.setAttribute("Medecin", m);
			request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/supprimer.do"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    metier.deleteMedecin(id);
		    response.sendRedirect("chercher.do?motCle=");
					
			//request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/editer.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    Medecin m = metier.getMedecin(id);
		    request.setAttribute("Medecin", m);
			request.getRequestDispatcher("editerMedecin.jsp").forward(request,response);
		}
		else if (path.equals("/update.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 String specialite=request.getParameter("specialite");
			 String faculte=request.getParameter("faculte");
			 Medecin m = new Medecin();
			 m.setIdMedecin(id);
			 m.setNomMedecin(nom);
			 m.setspecialite(specialite);
			 m.setFaculte(faculte);
			 metier.updateMedecin(m);
			 request.setAttribute("Medecin", m);
			 request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else
		{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}