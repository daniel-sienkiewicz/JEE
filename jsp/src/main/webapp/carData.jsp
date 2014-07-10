<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CarData</title>
</head>
<body bgcolor="silver">
	<jsp:useBean id="car"
		class="com.example.servletjspdemo.web.CarFormBean" scope="session"></jsp:useBean>
	<jsp:useBean id="type"
		class="com.example.servletjspdemo.web.CarFormBean" scope="session"></jsp:useBean>
	<jsp:useBean id="area"
		class="com.example.servletjspdemo.web.CarFormBean" scope="session"></jsp:useBean>
			<jsp:useBean id="area2"
		class="com.example.servletjspdemo.web.CarFormBean" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="car" />
	
	<fieldset>
		<legend>
			<h2>Car to add:</h2>
		</legend>
	<form action="addCar.jsp" method="get">
		<!-- Wypisanie danych o samochodzie z car -->
		Make: ${car.make}<br /> 
		Model: ${car.model}<br /> 
		Year of production: ${car.yop}<br /> 
		Type: ${car.type }<br /> 
		
		<!-- Wypisanie equipment z sesji -->
		Equipment:
		
		<%
		String select[] = request.getParameterValues("equipment"); 
		if (select != null && select.length != 0) {
			for (int i = 0; i < select.length; i++) {
				out.println(select[i] + ",");
			}
			
			car.setEquipment(request.getParameterValues("equipment"));
		}
		%>
	
	
		<!-- Wypisanie zinterpretowanego capacity z sesji -->
		<br /> Capacity:
		<%
		String selectcap[] = request.getParameterValues("capacity"); 
		if (selectcap != null && selectcap.length != 0) {
			for (int i = 0; i < selectcap.length; i++) {
				out.println(selectcap[i] + ",");
			}
			
			car.setCapacity(request.getParameterValues("capacity"));
		}
		%>
		

		<!-- Wypisanie tekst area z sesji -->
		<br/>
		Tekst area: 
		<%
			car.setInfo(request.getParameter("area2"));
		%>
		
		${car.info}
	
		<br /><br />
			<input type="submit" value=" OK ">
		</form>
		<a href="change.jsp">
			<font size="4" color="blue">edit</font>
		</a>
	</fieldset>
	<footer>
	<center>
		<address>
			Copyright: <a href="mailto:d.sienkiewicz@interia.eu"> Daniel Sienkiewicz</a>
		</address>
	</center>
	</footer>
</body>
</html>