package de.java2enterprise.onlineshop;

import de.java2enterprise.onlineshop.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "SigninServlet", value = "/signin")
public class SigninServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String cookie_email = null;
        String cookie_password = null;

        ServletOutputStream out = response.getOutputStream();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>Cookie-Name</td>");
        out.println("<td>Cookie-Value</td>");
        out.println("</tr>");

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            out.println("<tr>");
            out.println("<td>"+name+"</td>");
            out.println("<td>"+value+"</td>");
            out.println("</tr>");

            if ("email".equals(name)){
                cookie_email = name;
            } else if("password".equals(name)){
                cookie_password = value;
            }
        }
        out.println("</table>");
//not ready since here...
        //
        out.println("</body>");
        out.println("</html>");


        final Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);

        final HttpSession httpSession = request.getSession();
        httpSession.setAttribute("customer", customer);
        System.out.println("test=" + httpSession);

//        application example
//        ServletContext application = request.getServletContext();
//        application.setAttribute("customer", customer);
//

        final RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        dispatcher.forward(request,response);


    }
}
