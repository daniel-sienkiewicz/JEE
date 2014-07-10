package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.example.servletjspdemo.web.CarFormBean.EquipmentEnum;
import com.example.servletjspdemo.web.CarFormBean.CapacityEnum;
import com.example.servletjspdemo.web.CarFormBean.TypeEnum;
import java.util.Date;

public final class hello_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Hello</title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"silver\">\n");
      out.write("\t");
      com.example.servletjspdemo.web.CarFormBean car = null;
      synchronized (session) {
        car = (com.example.servletjspdemo.web.CarFormBean) _jspx_page_context.getAttribute("car", PageContext.SESSION_SCOPE);
        if (car == null){
          car = new com.example.servletjspdemo.web.CarFormBean();
          _jspx_page_context.setAttribute("car", car, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      out.write('	');
      com.example.servletjspdemo.web.CarFormBean type = null;
      synchronized (session) {
        type = (com.example.servletjspdemo.web.CarFormBean) _jspx_page_context.getAttribute("type", PageContext.SESSION_SCOPE);
        if (type == null){
          type = new com.example.servletjspdemo.web.CarFormBean();
          _jspx_page_context.setAttribute("type", type, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\t\t");
      com.example.servletjspdemo.web.CarFormBean area2 = null;
      synchronized (session) {
        area2 = (com.example.servletjspdemo.web.CarFormBean) _jspx_page_context.getAttribute("area2", PageContext.SESSION_SCOPE);
        if (area2 == null){
          area2 = new com.example.servletjspdemo.web.CarFormBean();
          _jspx_page_context.setAttribute("area2", area2, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      out.write('	');
      com.example.servletjspdemo.web.CarFormBean equipment = null;
      synchronized (session) {
        equipment = (com.example.servletjspdemo.web.CarFormBean) _jspx_page_context.getAttribute("equipment", PageContext.SESSION_SCOPE);
        if (equipment == null){
          equipment = new com.example.servletjspdemo.web.CarFormBean();
          _jspx_page_context.setAttribute("equipment", equipment, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      out.write('	');
      com.example.servletjspdemo.web.CarFormBean capacity = null;
      synchronized (session) {
        capacity = (com.example.servletjspdemo.web.CarFormBean) _jspx_page_context.getAttribute("capacity", PageContext.SESSION_SCOPE);
        if (capacity == null){
          capacity = new com.example.servletjspdemo.web.CarFormBean();
          _jspx_page_context.setAttribute("capacity", capacity, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\t<h2>\n");
      out.write("\t\t<center>\n");
      out.write("\t\t\tHello! Today:\n");
      out.write("\t\t\t");
      out.print(new Date());
      out.write("</center>\n");
      out.write("\t</h2>\n");
      out.write("\t<fieldset>\n");
      out.write("\t\t<legend>\n");
      out.write("\t\t\t<h3>Add Car:</h3>\n");
      out.write("\t\t</legend>\n");
      out.write("\t\t<form action=\"carData.jsp\" method=\"get\">\n");
      out.write("\t\t\t<!-- Tekst -->\n");
      out.write("\t\t\tMake: <input type=\"text\" name=\"make\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${car.make}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br />\n");
      out.write("\t\t\tModel: <input type=\"text\" name=\"model\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${car.model}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br />\n");
      out.write("\t\t\tYear of production: <input type=\"text\" name=\"yop\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${car.yop}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><br />\n");
      out.write("\n");
      out.write("\t\t\t<!-- Radio Button -->\n");
      out.write("\t\t\t<br />Body:<br />\n");
      out.write("\t\t\t");

				for(TypeEnum e: TypeEnum.values()) 	
					out.print("<input type='radio' name='type' value=" + e.toString() + ">" + e.toString() + "<br />");
			
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<!-- Checkbox -->\n");
      out.write("\t\t\t<br />Equipment: <br /> \n");
      out.write("\t\t\t");

				for(EquipmentEnum e: EquipmentEnum.values()) 	
					out.print("<input type='checkbox' name='equipment' value=" + e.toString() + ">" + e.toString() +"<br /> ");
			
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<!-- Select -->\n");
      out.write("\t\t\t<br />Engine capacity:<br /> \n");
      out.write("\t\t\t<select size=\"3\" name=\"capacity\" multiple=\"multiple\">\n");
      out.write("\t\t\t");

				for(CapacityEnum e: CapacityEnum.values())
					out.print("<option value=" + e.toString() + ">" + e.toString() + "</option>");
			
      out.write("\n");
      out.write("\t\t\t</select> <br /> \n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t<!-- Tekst Area -->\n");
      out.write("\t\t\t<br />Write sth: <br /> \t\t\t\n");
      out.write("\t\t\t<textarea name='area2' rows=\"2\" cols=\"50\" >\n");
      out.write("\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${car.info}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\t\t\t</textarea>\n");
      out.write("\t\t\t<br />\n");
      out.write("\t\t\t<input type=\"submit\" value=\" OK \"> <a href=\"showAllCar.jsp\">Show all Cars</a>\n");
      out.write("\t\t</form>\n");
      out.write("\t</fieldset>\n");
      out.write("\t<footer>\n");
      out.write("\t<address>\n");
      out.write("\t\t<center>Copyright: <a href=\"mailto:d.sienkiewicz@interia.eu\"> Daniel Sienkiewicz</a></center>\n");
      out.write("\t</address>\n");
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
