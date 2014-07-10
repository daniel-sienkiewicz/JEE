package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Array;
import com.example.servletjspdemo.web.CarFormBean;

public final class showAllCar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>ShowAllCar</title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"silver\">\n");
      out.write("\t");
      com.example.servletjspdemo.service.StorageService storage = null;
      synchronized (application) {
        storage = (com.example.servletjspdemo.service.StorageService) _jspx_page_context.getAttribute("storage", PageContext.APPLICATION_SCOPE);
        if (storage == null){
          storage = new com.example.servletjspdemo.service.StorageService();
          _jspx_page_context.setAttribute("storage", storage, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("car"), request);
      out.write("\n");
      out.write("\t<fieldset>\n");
      out.write("\t\t<legend>\n");
      out.write("\t\t\t<h2>Added cars:</h2>\n");
      out.write("\t\t</legend>\n");
      out.write("\n");
      out.write("\t\t<!-- wypisanie wszytskich dodanych samochodow-->\n");
      out.write("\t\t\n");
      out.write("\t\t");
		
		List<CarFormBean> tmp = storage.getAllCars();
	
	
			for (CarFormBean car : storage.getAllCars()) {
				out.println("<p>Make: " + car.getMake() + "<br />Model: " + car.getModel()
						+ "<br />Year of production: " + car.getYop() + "<br />Type: " + car.getType() 
						+ "<br />Capacity: " + car.getCapacityToString() + "<br />" + "Equipment: " + car.getEquipmentToString() +
						"<br />Info: " + car.getInfo() + "<br /></p>");
			}
		
			session.removeAttribute("car");
			
		
      out.write("\n");
      out.write("\n");
      out.write("\t\t<!-- Dodanie kolejnego -->\n");
      out.write("\t\t<form action=\"hello.jsp\" method=\"get\">\n");
      out.write("\t\t\t<input type=\"submit\" value=\" Add another Car \">\n");
      out.write("\t\t</form>\n");
      out.write("\t</fieldset>\n");
      out.write("\t<footer>\n");
      out.write("\t<center><address>\n");
      out.write("\t\tCopyright: <a href=\"mailto:d.sienkiewicz@interia.eu\"> Daniel Sienkiewicz</a>\n");
      out.write("\t</address></center>\n");
      out.write("\t</footer>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
