package fr.eni.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/ServletPageAccueil")
public class ServletPageAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie c:cookies){
				if(c.getName().equals("idUtilisateur")){
					UtilisateurManager um = new UtilisateurManager();
					Utilisateur utilisateur = um.afficherUtilisateur(Integer.parseInt(c.getValue()));
					request.setAttribute("utilisateur", utilisateur);
					break;
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageAccueilTest.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Page Accueil post");
	}

}
