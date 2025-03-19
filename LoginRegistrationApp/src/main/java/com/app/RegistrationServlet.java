package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h3>Registration Page</h3>");
        out.println("<form action='register' method='post'>");
        out.println("Username: <input type='text' name='username'/><br/>");
        out.println("Password: <input type='password' name='password'/><br/>");
        out.println("Email: <input type='email' name='email'/><br/>");
        out.println("<input type='submit' value='Register'/>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Example: For simplicity, registration data just echoed back.
        out.println("<h3>Registration Successful!</h3>");
        out.println("Username: " + username + "<br/>");
        out.println("Email: " + email);
    }
}
