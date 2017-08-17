package ru.alebedev.javacourse.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.alebedev.javacourse.clinic.Clinic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AddClientServletTest {

    private final Clinic CLINIC = Clinic.getInstance();

    @Test
    public void testAddClient() throws IOException, ServletException {


        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("user1");
        when(request.getContextPath()).thenReturn("cpw");

        assertTrue(CLINIC.getClients().isEmpty());

        new AddClientServlet().doPost(request, response);

        verify(response).sendRedirect("cpw/client/view");
        verifyNoMoreInteractions(response);
        assertFalse(CLINIC.getClients().isEmpty());

    }

}