package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.FaculteDaolmpl;
import dao.IFaculteDao;
import metier.entities.Faculte;

@WebServlet(name = "catServ", urlPatterns = { "/Facultes", "/saisieFaculte", "/saveFaculte", "/supprimerFac",
		"/editerFac", "/updateFac" })

public class FaculteServlet extends HttpServlet {
	IFaculteDao metier;

	@Override
	public void init() throws ServletException {
		metier = new FaculteDaolmpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("PATH " + path);
		if (path.equals("/Facultes")) {
			FaculteModel model = new FaculteModel();
			List<Faculte> facs = metier.getAllFacultes();
			model.setFacultes(facs);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Facultes.jsp").forward(request, response);
		} else if (path.equals("/saisieFaculte")) {
			request.getRequestDispatcher("saisieFaculte.jsp").forward(request, response);
		} else if (path.equals("/saveFaculte") &&

				request.getMethod().equals("POST"))

		{
			Date dateFac = new Date();
			String nom = request.getParameter("nom");
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new

			SimpleDateFormat(pattern);
			try {

				dateFac =

						simpleDateFormat.parse(request.getParameter("dateFac"));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			Faculte fac = metier.save(new Faculte(nom, dateFac));
			request.setAttribute("Faculte", fac);
			response.sendRedirect("Facultes");
		} else if (path.equals("/supprimerCat")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteFaculte(id);
			response.sendRedirect("Facultes");
		} else if (path.equals("/editerCat")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Faculte fac = metier.getFaculte(id);
			request.setAttribute("Faculte", fac);
			request.getRequestDispatcher("editerFaculte.jsp").forward(request, response);
		} else if (path.equals("/updateCat")) {
			Date dateFac = new Date();
			Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			Faculte fac = new Faculte();
			fac.setIdCat(id);
			fac.setNomCat(nom);
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new

			SimpleDateFormat(pattern);
			try {

				dateFac =

						simpleDateFormat.parse(request.getParameter("dateCreation"));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			fac.setDateCreation(dateFac);
			metier.updateFaculte(fac);
			response.sendRedirect("Facultes");
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,

			HttpServletResponse response) throws

	ServletException, IOException {
		doGet(request, response);
	}
}