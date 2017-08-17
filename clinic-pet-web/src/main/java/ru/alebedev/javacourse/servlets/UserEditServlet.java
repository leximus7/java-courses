package ru.alebedev.javacourse.servlets;

import ru.alebedev.javacourse.models.User;
import ru.alebedev.javacourse.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class UserEditServlet extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();

    private static final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", USER_CACHE.get(Integer.valueOf(request.getParameter("id"))));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/EditUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.USER_CACHE.edit(new User(this.ids.incrementAndGet(), request.getParameter("login"),
                request.getParameter("email")));
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/user/view"));

    }


}
