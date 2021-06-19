package de.java2enterprise.onlineshop;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Properties;

//@WebServlet(urlPatterns = {"/db_settings"},
//        initParams = {
//                @WebInitParam(name = "driver", value = "oracle.jdbc.OracleDriver"),
//                @WebInitParam(name = "url", value = "jdbc:oracle:thin:@//localhost:1521/XE"),
//                @WebInitParam(name = "username", value = "onlineshop_user"),
//                @WebInitParam(name = "password", value = "geheim_111")
//        }
//)
public class JdbcServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

//        ServletContext application = getServletContext();
//        final String driver = application.getInitParameter("driver");

//        ServletContext config = getServletContext();
//        final String jdbc_properties = config.getInitParameter("jdbc_properties");

        final String jdbc_properties = getInitParameter("jdbc_properties");
//        final ServletContext application = getServletContext();
//        final InputStream in = application.getResourceAsStream(jdbc_properties);
        final InputStream in = new FileInputStream(jdbc_properties);
        final Properties p = new Properties();
        p.load(in);

        response.setContentType("text/html;charset=UTF-8");

        final PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<br>driver" + p.getProperty("driver"));
        out.println("<br>url" + p.getProperty("url"));
        out.println("<br>username" + p.getProperty("username"));
        out.println("<br>password" + p.getProperty("password"));
        out.println("<br>Datum: " + LocalDateTime.now());
        out.println("</body>");
        out.println("</html>");


        //        final String driver = getInitParameter("driver");
//        final String url = getInitParameter("url");
//        final String username = getInitParameter("username");
//        final String password = getInitParameter("password");

//        PrintWriter out = response.getWriter();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<body>");
//        out.println("driver" + driver);
//        out.println("<br>url" + url);
//        out.println("<br>username" + username);
//        out.println("<br>password" + password);
//        out.println("<br>Datum: " + LocalDateTime.now());
//        out.println("</body>");
//        out.println("</html>");

    }
}
