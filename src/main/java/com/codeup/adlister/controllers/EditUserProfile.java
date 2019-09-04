package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.EditUserServlet", urlPatterns = "/profile/edit")
public class EditUserProfile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/ads/editProfile.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        String stringValueOfId = request.getParameter("edit");
        Long norId = Long.parseLong(stringValueOfId);


        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone_number");
        String oldPassword = request.getParameter("old_password");
        String newPassword = request.getParameter("password");
        String confirmationPassword = request.getParameter("confirm_password");
        String city = request.getParameter("city");
        String state = request.getParameter("state");




        boolean validAttempt = BCrypt.checkpw(oldPassword, user.getPassword());
        if(validAttempt != true) {
            request.getRequestDispatcher("/WEB-INF/ads/editProfile.jsp").forward(request, response);

        }
User userUpdate = new User(
        norId,
        username,
        phoneNumber,
        email,
        confirmationPassword,
        city,
        state
        );


        DaoFactory.getUsersDao().updateUser(userUpdate);
        response.sendRedirect("/login");
    }
}