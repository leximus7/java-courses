package ru.alebedev.javacourse.servlets;

import ru.alebedev.javacourse.clinic.Clinic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientViewServlet extends HttpServlet {

    private final Clinic CLINIC = Clinic.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clients", this.CLINIC.getClients());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/clinic/ClientView.jsp");
        dispatcher.forward(request, response);
    }
}
