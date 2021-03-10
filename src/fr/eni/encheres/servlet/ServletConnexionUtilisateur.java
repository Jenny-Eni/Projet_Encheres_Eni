package fr.eni.encheres.servlet;

import java.io.IOException;
import java.net.CookieStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;


@WebServlet("/Connexion/ServletConnexionUtilisateur")
public class ServletConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private boolean presenceCookieEmailUtilisateur = false;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie c:cookies){
				if(c.getName().equals("idUtilisateur")){
					presenceCookieEmailUtilisateur = true;
					System.out.println(presenceCookieEmailUtilisateur);
					RequestDispatcher rd = request.getRequestDispatcher("/ServletPageAccueil");
					rd.forward(request, response);
					break;
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion/ConnexionUtilisateur.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UtilisateurManager um = new UtilisateurManager();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int id = um.verifierEmail(email);
		boolean validationPassword = um.verifierPassword(id, password);
		if(id == 0 || !validationPassword) {
			System.out.println("Erreur de mot de passe ou d'adresse mail");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Connexion/ErreurDeLogin.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("Login ok");
			Cookie idUtilisateur = new Cookie("idUtilisateur", String.valueOf(id));
			idUtilisateur.setMaxAge(60);
			response.addCookie(idUtilisateur);
			doGet(request, response);
			
		}
	}
}
