package ru.alebedev.javacourse.servlets;

import ru.alebedev.javacourse.clinic.Clinic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientDeleteServlet extends HttpServlet {

    private static final Clinic CLINIC = Clinic.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CLINIC.removeClient(request.getParameter("name"));
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/client/view"));
    }
}
