package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        User user = (User) request.getSession().getAttribute("user");

        request.setAttribute("ads", DaoFactory.getAdsDao().usersAds(user.getId()));

//        request.setAttribute("")

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


      String activateDelete = request.getParameter("delete");
      String activateEdit = request.getParameter("edit");
      if(activateDelete != null) {
          String stringValOfId = request.getParameter("delete");
          Long idNor = Long.parseLong(stringValOfId);
          DaoFactory.getAdsDao().deleteAd(idNor);

          response.sendRedirect("/profile");
      } else if (activateEdit != null) {
          User user = (User) request.getSession().getAttribute("user");
          String stringValueOfId = request.getParameter("edit");
          Long norId = Long.parseLong(stringValueOfId);

          Ad ad = new Ad(
                  norId,
                  user.getId(),
                  request.getParameter("title"),
                  request.getParameter("description"),
                  request.getParameter("price"),
                  request.getParameter("picture")
          );
          DaoFactory.getAdsDao().updateAd(ad);

          response.sendRedirect("/profile");
      }




//          User user = (User) request.getSession().getAttribute("user");
//          String stringValueOfId = request.getParameter("edit");
//          Long norId = Long.parseLong(stringValueOfId);
//
//          Ad ad = new Ad(
//                  norId,
//                  user.getId(),
//                  request.getParameter("title"),
//                  request.getParameter("description"),
//                  request.getParameter("price"),
//                  request.getParameter("picture")
//          );
//          DaoFactory.getAdsDao().updateAd(ad);
//
//          response.sendRedirect("/profile");








    }
}
