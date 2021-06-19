package de.java2enterprise.onlineshop;

import de.java2enterprise.onlineshop.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "SellServlet", value = "/sell")
@MultipartConfig
public class SellServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        final Part part = request.getPart("foto");

        final PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");


            out.println("ContentType: " + part.getContentType());
            out.println("Size: " + part.getSize());
            out.println("name: " + part.getName());
            out.println("submitted: " + part.getSubmittedFileName());




        out.println("</body>");
        out.println("</html>");

//        final PrintWriter out = response.getWriter();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<body>");
//
//        HttpSession session = request.getSession();
//        Object object = session.getAttribute("customer");
//        if (object != null && object instanceof Customer) {
//            out.println("<h1>logged!</h1>");
//        } else {
//            out.println("<h1>not logged</h1>");
//        }
//
//        out.println("</body>");
//        out.println("</html>");
    }
}
