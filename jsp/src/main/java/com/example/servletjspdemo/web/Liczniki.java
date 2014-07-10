package com.example.servletjspdemo.web;

import java.awt.Container;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletjspdemo.domain.Counter;

@WebServlet("/licznik")
public class Liczniki extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		HttpSession session = request.getSession();

		if (session.getAttribute("lCounter") == null) {
			session.setAttribute("lCounter", new Counter());
		}

		Counter localCounter = (Counter) session.getAttribute("lCounter");
		localCounter.increment();

		Counter globalCounter = (Counter) getServletContext().getAttribute("gCounter");
		globalCounter.increment();

		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Local: " + localCounter.getValue() + " Global: " + globalCounter.getValue() + "</h2></body></html>");
		out.close();
	}

	public void init() throws ServletException {
		getServletContext().setAttribute("gCounter", new Counter());
	}
}