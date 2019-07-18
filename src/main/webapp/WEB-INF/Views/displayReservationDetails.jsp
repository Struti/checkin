<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTM 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Reservation Details</title>
</head>
<body>
<h2>Flight Details</h2>

Airlines: ${reservation.flight.operatingAirlines}<br/>
Flight Number: ${reservation.flight.flightNumber}<br/>
Departure City: ${reservation.flight.departureCity}<br/>
Arrival City: ${reservation.flight.arrivalCity}<br/>
Departure Date: ${reservation.flight.dateOfDeparture}<br/>
Estimated Departure: ${reservation.flight.estimatedDepartureTime}<br/>

<h2>Passenger Details</h2>

First Name: ${reservation.passenger.firstName}<br/>
Last Name: ${reservation.passenger.lastName}<br/>
Email: ${reservation.passenger.email}<br/>
Phone: ${reservation.passenger.phone}<br/>

<form action="completeCheckIn" method="post">
    <pre>
        Enter the number of bags: <input type="text" name="numberOfBags"/>
        <input type="hidden" value="${reservation.id}" name="reservationId">
        <input type="submit" value="Check In"/>
    </pre>
</form>
</body>
</html>