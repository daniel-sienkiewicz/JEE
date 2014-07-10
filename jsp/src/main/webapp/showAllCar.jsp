<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="com.example.servletjspdemo.web.CarFormBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ShowAllCar</title>
</head>
<body bgcolor="silver">
	<jsp:useBean id="storage"
		class="com.example.servletjspdemo.service.StorageService"
		scope="application" />
			<jsp:setProperty property="*" name="car" />
	<fieldset>
		<legend>
			<h2>Added cars:</h2>
		</legend>

		<!-- wypisanie wszytskich dodanych samochodow-->
		
		<%		
		List<CarFormBean> tmp = storage.getAllCars();
	
	
			for (CarFormBean car : storage.getAllCars()) {
				out.println("<p>Make: " + car.getMake() + "<br />Model: " + car.getModel()
						+ "<br />Year of production: " + car.getYop() + "<br />Type: " + car.getType() 
						+ "<br />Capacity: " + car.getCapacityToString() + "<br />" + "Equipment: " + car.getEquipmentToString() +
						"<br />Info: " + car.getInfo() + "<br /></p>");
			}
		
			session.removeAttribute("car");
			
		%>

		<!-- Dodanie kolejnego -->
		<form action="hello.jsp" method="get">
			<input type="submit" value=" Add another Car ">
		</form>
	</fieldset>
	<footer>
	<center><address>
		Copyright: <a href="mailto:d.sienkiewicz@interia.eu"> Daniel Sienkiewicz</a>
	</address></center>
	</footer>
</body>
</html>