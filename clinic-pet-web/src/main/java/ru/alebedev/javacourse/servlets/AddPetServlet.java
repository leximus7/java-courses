package ru.alebedev.javacourse.servlets;

import ru.alebedev.javacourse.clinic.Cat;
import ru.alebedev.javacourse.clinic.Client;
import ru.alebedev.javacourse.clinic.Clinic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AddPetServlet extends HttpServlet {

    private final Clinic CLINIC = Clinic.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.CLINIC.addPet(new Cat(request.getParameter("petName")),
                CLINIC.getClients().get(request.getParameter("clientName")));
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/client/view"));
    }
}
