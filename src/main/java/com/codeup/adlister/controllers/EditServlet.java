//package com.codeup.adlister.controllers;
//
//import com.codeup.adlister.dao.DaoFactory;
//import com.codeup.adlister.models.Ad;
//import com.codeup.adlister.models.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "controllers.EditServlet", urlPatterns = "/profile")
//public class EditServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        User user = (User) request.getSession().getAttribute("user");
//
//        request.setAttribute("ads", DaoFactory.getAdsDao().usersAds(user.getId()));
//
////        request.setAttribute("")
//
////        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
//    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = (User) request.getSession().getAttribute("user");
//        String stringValueOfId = request.getParameter("edit");
//        Long norId = Long.parseLong(stringValueOfId);
//
//        Ad ad = new Ad(
//                norId,
//                user.getId(),
//                request.getParameter("title"),
//                request.getParameter("description"),
//                request.getParameter("price"),
//                request.getParameter("picture")
//        );
//        DaoFactory.getAdsDao().updateAd(ad);
//
//        response.sendRedirect("/profile");
//
//
//
//    }
//
//
//}