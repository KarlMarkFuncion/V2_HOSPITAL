<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="appointment_display.css">
        <link rel="shortcut icon" type="image/x-icon" href="#">
        <title> Finished Appointments </title>
    </head>
    <body> 
        <nav>
            <ul class="nav">
              <li class="brandname"><a href="#home">Brand Name</a></li>
              <li class="brandname"><a href="#">User: Doctor</a></li>
              <li class="navbar"><a href="login.jsp"> Logout </a></li>
              <li class="navbar"><a href="#profile"> Profile </a></li>
            </ul>
        </nav>
        <h1 id="upcomingHeadline"> Finished Appointments </h1>
        <h6 id="finishedAppointment"><a href="doctor_upcoming_appointments.jsp"> Upcoming Appointments </a></h6>
        <table class="appointmentTable">
            <thead> 
            <!-- table header -->
                <tr>
                <!-- table row --> 
                    <th>  </th>
                    <th> Appointee Name </th> <!-- table header cell -->
                    <th> Email </th>
                    <th> Type </th>
                    <th> Description </th>
                    <th> Date </th>
                </tr>
            </thead>
            <tbody>
            <!-- table body -->
            	<% for (int i = 0; i < finishedAppointments.size(); i++) { %>
                <tr>
                    <td> <input type="checkbox" checked disabled> </td>
                    <td><%= appointeeName.get(i) %></td> 
                    <td><%= appointeeEmail.get(i) %></td>
                    <td><%= checkupType.get(i) %></td>
                    <td><%= checkupDescription.get(i) %></td>
                    <td><%= checkupDate.get(i) %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        </body>
    </body>
</html>