package ru.alebedev.javacourse.servlets;

import ru.alebedev.javacourse.clinic.Clinic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddClientServlet extends HttpServlet {

    private final Clinic CLINIC = Clinic.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.CLINIC.addClient(request.getParameter("name"));
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/client/view"));
    }

}
