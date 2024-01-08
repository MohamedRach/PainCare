package com.example.paincare.servlets.Profile;

import com.example.paincare.dao.DAOException;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.example.paincare.Bean.userBean;

import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.userdao.userDaoImpl;
import com.example.paincare.dao.userdao.userDao;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    private userDao userDao;

    public void init() {
        daoFacroty daoFactory = com.example.paincare.dao.daoFacroty.getInstance();
        this.userDao = new userDaoImpl(daoFactory);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Obtenir l'email et l'ID de l'utilisateur connecté depuis la session
        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("email");
        int userId = (int) session.getAttribute("id");

        if (userEmail != null && userId != 0) {
            try {
                // Récupérer l'utilisateur à partir de la base de données en utilisant l'ID
                userBean user = userDao.find(userId);

                if (user != null) {
                    // Afficher les informations de l'utilisateur
                    request.setAttribute("user", user);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/UserProfile.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // Gérer le cas où l'utilisateur n'est pas trouvé
                    response.getWriter().println("Utilisateur non trouvé");
                }
            } catch (DAOException e) {
                // Gérer les erreurs liées à la récupération des informations de l'utilisateur
                e.printStackTrace(); // À des fins de débogage, vous pouvez imprimer la trace de la pile

                response.setContentType("text/plain");
                response.getWriter().println("Erreur lors de la récupération des informations de l'utilisateur : " + e.getMessage());
            }
        } else {
            // Gérer le cas où l'email ou l'userId n'est pas défini dans la session
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
