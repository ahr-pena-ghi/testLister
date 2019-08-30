package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.IndividualAdServlet", urlPatterns = "/individualad")

public class IndividualAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stringId = request.getParameter("id");
        Long convertedId = Long.parseLong(stringId);

        System.out.println(DaoFactory.getAdsDao().findAdsById(convertedId));

        request.setAttribute("ad", DaoFactory.getAdsDao().findAdsById(convertedId));
        request.getRequestDispatcher("/WEB-INF/ads/individualad.jsp").forward(request, response);
    }
}
