package ru.alebedev.javacourse.servlets;

import ru.alebedev.javacourse.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserViewServlet extends HttpServlet {

    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", this.USER_CACHE.values());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/UserView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        USER_CACHE.close();
    }
}
