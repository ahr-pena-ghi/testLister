package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.CategsAds;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "controllers.IndividualAdServlet", urlPatterns = "/individualad")

public class IndividualAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stringId = request.getParameter("id");
        Long convertedId = Long.parseLong(stringId);

        System.out.println(DaoFactory.getAdsDao().findAdsById(convertedId));

        request.setAttribute("ad", DaoFactory.getAdsDao().findAdsById(convertedId));
        request.getRequestDispatcher("/WEB-INF/ads/individualad.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//request.setAttribute("user", DaoFactory.getUsersDao().findByUsername())
//request.getSession().getAttribute("user").equals("user_id") {
//
//
//        }
//        if(request.getSession().getAttribute("user").equals(DaoFactory.getAdsDao().usersAds()))
        String activateDelete = request.getParameter("delete");
        String activateEdit = request.getParameter("edit");
        if (activateDelete != null) {
            String stringValOfId = request.getParameter("delete");
            Long idNor = Long.parseLong(stringValOfId);
            DaoFactory.getAdsDao().deleteCatAds(idNor);
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
            String[] categories = request.getParameterValues("category_id");
            List<String> cats = Arrays.asList(categories);
            List<CategsAds> categoriesFromDB = DaoFactory.getAdsDao().findCategoriesByAdId(norId);

            for (String c : cats) {
                if (!categoriesFromDB.contains(c)) {
                    CategsAds categsAds = new CategsAds(Long.parseLong(c), norId);
                    DaoFactory.getAdsDao().insertCategoryAds(categsAds);
                }
            }
            DaoFactory.getAdsDao().updateAd(ad);
            response.sendRedirect("/individualad?id="+norId);
        }
    }
}