package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.java2enterprise.onlineshop.model.Customer;

@WebServlet("/revision")
public class RevisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		final PrintWriter out = response.getWriter();

		String remoteAddr = request.getRemoteAddr();

		HttpSession session = request.getSession();
		
		Customer customer = new Customer();
		customer.setEmail("ma@web.de");
		customer.setPassword("pass");
		session.setAttribute("customer", customer);
		
		Customer customerRead = (Customer) session.getAttribute("customer");
		String read = customerRead.getEmail();
		
		
		log("Martin: " + read);

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("Ihre IP-Adresse56: " + remoteAddr);
		out.println("</body>");
		out.println("</html>");
	}
}
