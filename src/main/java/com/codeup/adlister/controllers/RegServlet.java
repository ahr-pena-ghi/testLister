package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.RegServlet", urlPatterns = "/register")
public class RegServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");
        String city = request.getParameter("city");
        String state = request.getParameter("state");

        if (request.getParameter("username") == null) {username = "";}
        if (phone_number == null) {phone_number = "";}
        if (email == null) {email = "";}
        if (city == null) {city = "";}
        if (state == null) {state = "";}

        // validate input
        boolean inputHasErrors = username.isEmpty()
                || phone_number.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (! password.equals(passwordConfirmation))
                || city.isEmpty()
                || state.isEmpty();

        if (inputHasErrors) {
            request.getSession().setAttribute("usernameValue", username);
            request.getSession().setAttribute("phoneNumberValue", phone_number);
            request.getSession().setAttribute("emailValue", email);
            request.getSession().setAttribute("cityValue", city);
            request.getSession().setAttribute("stateValue", state);
            response.sendRedirect("/register");
            request.getSession().setAttribute("hintVisible", "display: block");
            if (username.isEmpty()) {
                request.getSession().setAttribute("usernameEmpty", "empty-field");
                request.getSession().setAttribute("usernameEmptyHeader", "empty-header");
            } else {
                request.getSession().setAttribute("usernameEmpty", "");
                request.getSession().setAttribute("usernameEmptyHeader", "");
            }
            if (phone_number.isEmpty()) {
                request.getSession().setAttribute("phoneNumberEmpty", "empty-field");
                request.getSession().setAttribute("phoneNumberEmptyHeader", "empty-header");
            } else {
                request.getSession().setAttribute("phoneNumberEmpty", "");
                request.getSession().setAttribute("phoneNumberEmptyHeader", "");
            }
            if (email.isEmpty()) {
                request.getSession().setAttribute("emailEmpty", "empty-field");
                request.getSession().setAttribute("emailEmptyHeader", "empty-header");
            } else {
                request.getSession().setAttribute("emailEmpty", "");
                request.getSession().setAttribute("emailEmptyHeader", "");
            }
            if (password.isEmpty()) {
                request.getSession().setAttribute("passwordEmpty", "empty-field");
                request.getSession().setAttribute("passwordEmptyHeader", "empty-header");
            } else {
                request.getSession().setAttribute("passwordEmpty", "");
                request.getSession().setAttribute("passwordEmptyHeader", "");
            }
            if (passwordConfirmation.isEmpty()) {
                request.getSession().setAttribute("conPasswordEmpty", "empty-field");
                request.getSession().setAttribute("conPasswordEmptyHeader", "empty-header");
            } else {
                request.getSession().setAttribute("conPasswordEmpty", "");
                request.getSession().setAttribute("conPasswordEmptyHeader", "");
            }
            if (city.isEmpty()) {
                request.getSession().setAttribute("cityEmpty", "empty-field");
                request.getSession().setAttribute("cityEmptyHeader", "empty-header");
            } else {
                request.getSession().setAttribute("cityEmpty", "");
                request.getSession().setAttribute("cityEmptyHeader", "");
            }
            if (state.isEmpty()) {
                request.getSession().setAttribute("stateEmpty", "empty-field");
                request.getSession().setAttribute("stateEmptyHeader", "empty-header");
            } else {
                request.getSession().setAttribute("stateEmpty", "");
                request.getSession().setAttribute("stateEmptyHeader", "");
            }
            return;
        }

        // create and save a new user
        User user = new User(username, phone_number, email, password, city, state);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
