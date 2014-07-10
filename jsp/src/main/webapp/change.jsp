<%@page import="com.example.servletjspdemo.web.CarFormBean.TypeEnum"%>
<%@page import="com.example.servletjspdemo.web.CarFormBean.CapacityEnum"%>
<%@page
	import="com.example.servletjspdemo.web.CarFormBean.EquipmentEnum"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body bgcolor="silver">
	<jsp:useBean id="car"
		class="com.example.servletjspdemo.web.CarFormBean" scope="session"></jsp:useBean>
	<jsp:useBean id="type"
		class="com.example.servletjspdemo.web.CarFormBean" scope="session"></jsp:useBean>
	<jsp:useBean id="area2"
		class="com.example.servletjspdemo.web.CarFormBean" scope="session"></jsp:useBean>
	<jsp:useBean id="equipment"
		class="com.example.servletjspdemo.web.CarFormBean" scope="session"></jsp:useBean>
	<jsp:useBean id="capacity"
		class="com.example.servletjspdemo.web.CarFormBean" scope="session"></jsp:useBean>
	<h2>
		<center>
			Hello! Today:
			<%=new Date()%></center>
	</h2>
	<fieldset>
		<legend>
			<h3>Add Car:</h3>
		</legend>
		<form action="carData.jsp" method="get">
			<!-- Tekst -->
			Make: <input type="text" name="make" value="${car.make}"><br />
			Model: <input type="text" name="model" value="${car.model}"><br />
			Year of production: <input type="text" name="yop" value="${car.yop}"><br />

			<!-- Radio Button -->
			<br />Body:<br />

			<%
				String cos = car.getType();

				for(TypeEnum e: TypeEnum.values()){
					if(e.toString().equals(cos))
						out.println("<input type='radio' name='type' value=" + e.toString() + " CHECKED >" + e.toString() + "<br />");
					else
						out.println("<input type='radio' name='type' value=" + e.toString() + ">" + e.toString() + "<br />");
				}
			%>

			<!-- Checkbox -->
			<br />Equipment: <br />

			<%
				boolean znaleziono = false;
				String[] equ = car.getEquipment();

				for (EquipmentEnum e : EquipmentEnum.values()) {
					for (int i = 0; i < equ.length; i++)
						if (equ[i].equals(e.toString())) {
							out.print("<input type='checkbox' name='equipment' value=" + e.toString() + " CHECKED>"
									+ e.toString() + "<br /> ");
							znaleziono = true;
						}

					if (!znaleziono)
						out.print("<input type='checkbox' name='equipment' value=" + e.toString() + ">" + e.toString()
								+ "<br /> ");

					znaleziono = false;
				}
			%>

			<!-- Select -->
			<br />Engine capacity:<br /> <select size="3" name="capacity"
				multiple="multiple">

				<%
					boolean znale = false;
					String[] cap = car.getCapacity();

					for (CapacityEnum e : CapacityEnum.values()) {
						for (int i = 0; i < cap.length; i++)
							if (cap[i].equals(e.toString())) {
								out.print("<option SELECTED value=" + e.toString() + ">" + e.toString() + "</option>");
								znale = true;
							}

						if (!znale)
							out.print("<option value=" + e.toString() + ">" + e.toString() + "</option>");

						znale = false;

					}
				%>

			</select> <br />

			<!-- Tekst Area -->
			<br />Write sth: <br />
			<textarea name='area2' rows="2" cols="50">
			${car.info}
			</textarea>
			<br /> <input type="submit" value=" OK "> <a
				href="showAllCar.jsp">Show all Cars</a>
		</form>
	</fieldset>
	<footer>
	<address>
		<center>
			Copyright: <a href="mailto:d.sienkiewicz@interia.eu"> Daniel
				Sienkiewicz</a>
		</center>
	</address>
	</footer>
</body>
</html>