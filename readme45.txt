Here's a step-by-step guide to creating an Eclipse-based Java Servlet project with an index page containing "Login" and "Registration" links. Each link will open respective pages for authentication.

✅ Step 1: Create a Java Dynamic Web Project in Eclipse
Open Eclipse IDE.
Select File → New → Dynamic Web Project.
Enter the project name, e.g., LoginRegistrationApp.
Click Finish.
Your project structure will be:

css
Copy
Edit
LoginRegistrationApp
├── Java Resources
│   └── src
├── WebContent
│   ├── META-INF
│   └── WEB-INF
│       └── web.xml
└── build
✅ Step 2: Configure web.xml for Servlet Mapping
Update the web.xml file (WebContent/WEB-INF/web.xml):

xml
Copy
Edit
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee 
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
    </welcome-file-list>

    <servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>com.app.LoginServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>RegistrationServlet</servlet-name>
        <servlet-class>com.app.RegistrationServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>RegistrationServlet</servlet-name>
        <url-pattern>/register</url-pattern>
    </servlet-mapping>

</web-app>
✅ Step 3: Create index.html page
Create index.html under WebContent directory:

html
Copy
Edit
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <h2>Welcome to the App</h2>
    <a href="login">Login</a> | <a href="register">Registration</a>
</body>
</html>
Explanation:
Clicking on the Login link calls the URL /login.
Clicking on the Registration link calls the URL /register.
✅ Step 4: Create Servlet classes
1️⃣ LoginServlet.java
Create package com.app inside src and then create LoginServlet.java:

java
Copy
Edit
package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h3>Login Page</h3>");
        out.println("<form action='login' method='post'>");
        out.println("Username: <input type='text' name='username'/><br/>");
        out.println("Password: <input type='password' name='password'/><br/>");
        out.println("<input type='submit' value='Login'/>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("admin".equals(username) && "password".equals(password)) {
            out.println("<h3>Login Successful!</h3>");
        } else {
            out.println("<h3>Invalid Credentials!</h3>");
        }
    }
}
Explanation:
doGet() renders the Login form.
doPost() processes login form data.
2️⃣ RegistrationServlet.java
In com.app package, create RegistrationServlet.java:

java
Copy
Edit
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
Explanation:
doGet() renders the registration form.
doPost() processes registration data and displays a simple message.
✅ Step 5: Run the Application
Right-click your project → Run As → Run on Server (choose Apache Tomcat).
The server starts, and the index.html page opens automatically.
You will see:

pgsql
Copy
Edit
Welcome to the App
Login | Registration
Click Login to view the login form.
Click Registration to view the registration form.
✅ Code Explanation (Overall Flow):
When the index page loads, the user sees two hyperlinks (Login and Registration).
Clicking a link triggers the corresponding Servlet mapped in web.xml.
The servlet’s doGet() method generates and returns HTML forms.
Form submission triggers the servlet’s doPost() method, handling logic and returning responses.
🚩 Final Directory Structure:
pgsql
Copy
Edit
LoginRegistrationApp
├── Java Resources
│   └── src
│       └── com.app
│           ├── LoginServlet.java
│           └── RegistrationServlet.java
├── WebContent
│   ├── META-INF
│   ├── WEB-INF
│   │   └── web.xml
│   └── index.html
You have successfully created a basic Login/Registration Java Servlet Application in Eclipse!












Search

Deep research


