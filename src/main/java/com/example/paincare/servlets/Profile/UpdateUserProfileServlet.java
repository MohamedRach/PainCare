package com.example.paincare.servlets.Profile;

import com.example.paincare.dao.DAOException;
import java.io.IOException;

import com.example.paincare.servlets.authentification.authentification;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.example.paincare.Bean.userBean;
import com.example.paincare.servlets.authentification.authentification;
import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.userdao.userDaoImpl;
import com.example.paincare.dao.userdao.userDao;

@WebServlet(name = "UpdateUserProfileServlet", value = {"/update-user-profile"})
public class UpdateUserProfileServlet extends HttpServlet {
    private userDao userDao;
    private authentification auth;

    public void init() {
        daoFacroty daoFactory =  com.example.paincare.dao.daoFacroty.getInstance();
        this.userDao = new userDaoImpl(daoFactory);
        this.auth = new authentification();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Récupérer l'ID de l'utilisateur à modifier
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("id");
        System.out.println(userId);

        if (userId != null) {


            try {
                // Récupérer l'utilisateur à partir de la base de données
                userBean user = userDao.find(userId);

                if (user != null) {
                    // Afficher le formulaire de modification avec les données de l'utilisateur
                    request.setAttribute("user", user);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdateProfile.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // Gérer le cas où l'utilisateur n'est pas trouvé
                    response.getWriter().println("Utilisateur non trouvé");
                }
            } catch (DAOException e) {
                // Gérer les erreurs liées à la récupération de l'utilisateur
                e.printStackTrace();
                response.getWriter().println("Erreur lors de la récupération de l'utilisateur");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Récupérer les données du formulaire
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("id");
        System.out.println(userId);
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");


        // Créer un objet UserBean avec les données du formulaire
        userBean userToUpdate = new userBean();
        userToUpdate.setId(userId);
        userToUpdate.setNom(nom);
        userToUpdate.setPrenom(prenom);
        userToUpdate.setEmail(email);

        // Vérifier si un nouveau mot de passe est spécifié dans le formulaire


        try {
            // Mettre à jour l'utilisateur dans la base de données
            userDao.update(userToUpdate);

            // Rediriger vers la page /user-profile après la mise à jour réussie
            response.sendRedirect(request.getContextPath() + "/user-profile");
        } catch (DAOException e) {
            // Gérer les erreurs liées à la mise à jour de l'utilisateur
            e.printStackTrace();
            response.getWriter().println("Erreur lors de la mise à jour de l'utilisateur");
        }
    }


    // ... (autres méthodes, si nécessaires)
}