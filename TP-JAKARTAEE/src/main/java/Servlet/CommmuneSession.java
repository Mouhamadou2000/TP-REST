package Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Models.Client;
import Models.Commune;
import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class CommmuneSession
 */
@WebServlet("/CommmuneSession")
public class CommmuneSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COUNT = "count";
	private static final String COMMUNE = "commune";
	private static final String BADINPUT = "badInput";
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommmuneSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		Commune commune=new Commune();
		String vue;
		if(session.getAttribute(COUNT)!=null) {
			vue="commune-session.jsp";
			commune =(Commune)session.getAttribute(COMMUNE);
			Long count=(Long)session.getAttribute(COUNT);
			count++;
			session.setAttribute(COUNT, count);
			session.setAttribute(BADINPUT, "");	
		}else {
			vue="user-form.jsp";
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher(vue);	
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session =request.getSession();
		if(session.getAttribute(COUNT)==null) {
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		Client client =new Client(nom,prenom);
		request.setAttribute("Commune_Session", client);
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);
		session.setAttribute(COUNT, 0L);
		RequestDispatcher dispatcher= request.getRequestDispatcher("commune-session.jsp");
		dispatcher.forward(request,response);
		
		//doGet(request, response);
		}else {
		
		Long count=(Long)session.getAttribute(COUNT);
		count++;
		session.setAttribute(COUNT, count);
		String cpString = request.getParameter("cp");
		String name = request.getParameter("name");
		if(cpString != null && !cpString.isEmpty() && name != null && !name.isEmpty() ){
		long codePostal=Long.parseLong(cpString);
		
		Commune com=new Commune(codePostal,name);
		session.setAttribute(COMMUNE, com);
		}
		RequestDispatcher dispatcher_2= request.getRequestDispatcher("commune-session.jsp");
		dispatcher_2.forward(request,response);
		
		}
	}

}
