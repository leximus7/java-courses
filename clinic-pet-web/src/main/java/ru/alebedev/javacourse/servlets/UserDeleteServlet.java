package ru.alebedev.javacourse.servlets;

import ru.alebedev.javacourse.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {

    private static final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        USER_CACHE.delete(Integer.valueOf(request.getParameter("id")));
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/user/view"));
    }
}
