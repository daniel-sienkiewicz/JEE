package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletjspdemo.domain.Counter;
import com.example.servletjspdemo.service.StorageService;

@WebServlet(urlPatterns = "/Friday")
public class Friday extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		HttpSession session = request.getSession();

		if (session.getAttribute("sCounter") == null) {
			// wrzucanie czegos do sesji
			session.setAttribute("sCounter", new Counter());
		}
		
		Counter sessionCounter = (Counter) session.getAttribute("sCounter");
		sessionCounter.increment();

		Counter globalCounter = (Counter) getServletContext().getAttribute("gCounter");
		globalCounter.increment();
		
		PrintWriter out = response.getWriter();
		
		
		//StorageService ss = (StorageService) getServletContext().getAttribute("storage");
		//ss.add(person);
		
		out.println("<html><body><h2>Session Counter: " + sessionCounter.getValue() + " " + globalCounter.getValue() + "</body></html>");
		out.close();
	}
	
	@Override
	public void init() throws ServletException {
		//getServletContext().setAttribute("storage", new StorageService());
		
		getServletContext().setAttribute("gCounter", new Counter());
	}	
	
}