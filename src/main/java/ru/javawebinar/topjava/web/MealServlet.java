package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class MealServlet extends HttpServlet {
    private Meal[] meals = new Meal[] {
            new Meal(LocalDateTime.of(2018, 7, 31, 16, 25),
                    "Hamburger", 700),
            new Meal(LocalDateTime.of(2018, 7, 31, 17, 23),
                    "Hamburger", 700),
            new Meal(LocalDateTime.of(2018, 7, 31, 18, 17),
                    "Hamburger", 700),
            new Meal(LocalDateTime.of(2018, 7, 30, 18, 17),
                    "Hamburger", 700),
            new Meal(LocalDateTime.of(2018, 7, 30, 18, 17),
                    "Hamburger", 700),
            new Meal(LocalDateTime.of(2018, 7, 30, 18, 17),
                    "Hamburger", 700),
            new Meal(LocalDateTime.of(2018, 7, 30, 18, 17),
                    "Hamburger", 700),
            new Meal(LocalDateTime.of(2018, 7, 30, 18, 17),
                    "Hamburger", 700),
            new Meal(LocalDateTime.of(2018, 7, 29, 18, 17),
                    "Hamburger", 700)
    };

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        List<MealWithExceed> mealsWithExceed = MealsUtil.getWithExceed(Arrays.asList(meals), 2000);
        req.setAttribute("mealsWithExceed", mealsWithExceed);
        req.setAttribute("dateTimeFormatter", FORMATTER);
        req.getRequestDispatcher("meals.jsp").forward(req, resp);
    }
}
