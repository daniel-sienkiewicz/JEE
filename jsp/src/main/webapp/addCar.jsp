<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AddCar</title>
</head>
<body bgcolor="silver">
	<jsp:useBean id="car"
		class="com.example.servletjspdemo.web.CarFormBean" scope="session"></jsp:useBean>
	<jsp:useBean id="type"
		class="com.example.servletjspdemo.web.CarFormBean" scope="session"></jsp:useBean>
	<jsp:useBean id="storage"
		class="com.example.servletjspdemo.service.StorageService"
		scope="application" />
			<jsp:setProperty property="*" name="car" />
	
	<fieldset>
		<legend>
			<h2>Following cars has been added to storage:</h2>
		</legend>
		<form action="showAllCar.jsp" method="get">
			<!-- Wypisanie danych o samochodzie z car -->
			Make: ${car.make}<br /> 
			Model: ${car.model}<br /> 
			Year of production: ${car.yop}<br />
			Type: ${car.type}<br />
			Equipment: 
			<%
				String selecte[] = car.getEquipment(); 
				if (selecte != null && selecte.length != 0) {
					for (int i = 0; i < selecte.length; i++) {
						out.println(selecte[i] + ",");
					}
					
					car.setEquipment(selecte);
				} 
			%>
			<br />
			
			<!-- Wypisanie zinterpretowanego capacity -->
			Capacity: 
		
			<%
			String select[] = car.getCapacity(); 
			if (select != null && select.length != 0) {
				for (int i = 0; i < select.length; i++) {
					out.println(select[i] + ",");
				}
				
				car.setCapacity(select);
			} 
			%>
			
			<br />

			Write sth: ${car.info} <br />
			<!-- Dodanie do listy samochodu -->
			<%	
				storage.add(car);

			%>
			
			<input type="submit" value=" Show all cars ">
			
		</form>
	</fieldset>
	<footer>
	<center><address>
		Copyright: <a href="mailto:d.sienkiewicz@interia.eu"> Daniel Sienkiewicz</a>
	</address></center>
	</footer>
</body>
</html>