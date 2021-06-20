package de.java2enterprise.onlineshop;

import de.java2enterprise.onlineshop.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.time.LocalDateTime;

@WebServlet(name = "SellServlet", value = "/sell", asyncSupported = true)
@MultipartConfig(maxFileSize = 1024*1024*1, maxRequestSize = 1024*1024*30, fileSizeThreshold = 1024*1024, location = "/things")
public class SellServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String title = request.getParameter("title");
        final String description = request.getParameter("description");
        final String price = request.getParameter("price");
        final Part part = request.getPart("foto");

        InputStream is = part.getInputStream();

        String path = "/my_projects/" + part.getSubmittedFileName();
        File file = new File(path);
        OutputStream os = new FileOutputStream(file);

        response.setContentType("text/html;charset=UTF-8");


        final PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<br>contype: "+ title);
        out.println("<br>size: "+ description);
        out.println("<br>name: "+ price);
        out.println("<br>submitted: "+ file.getAbsolutePath());
        out.println("</body>");
        out.println("</html>");

        final AsyncContext ac = request.startAsync();
        ac.start(new FotoService(is, os));
        ac.complete();


//        String path = part.getSubmittedFileName();
//        File file = new File(path);
//        try (OutputStream os = new FileOutputStream(file); InputStream is = part.getInputStream();) {
//            byte[] b = new byte[1024];
//            int i = 0;
//            while ((i = is.read(b)) != -1){
//                os.write(b, 0, i);
//            }
//        } catch (Exception ex){
//            throw new ServletException(
//                    ex.getMessage());
//        }



        //
//        final PrintWriter out = response.getWriter();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<body>");
//        out.println("<br>contype: "+ part.getContentType());
//        out.println("<br>size: "+ part.getSize());
//        out.println("<br>name: "+ part.getName());
//        out.println("<br>submitted: "+ part.getSubmittedFileName());
//
//
//        out.println("</body>");
//        out.println("</html>");

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
//        //        application example
////        ServletContext application = request.getServletContext();
////        Object objtest = application.getAttribute("customer");
////        if (objtest != null && objtest instanceof Customer) {
////            out.println("<h1>testlogged!</h1>");
////        } else {
////            out.println("<h1>testnot logged</h1>");
////        }
//
//        out.println("</body>");
//        out.println("</html>");
    }
}
