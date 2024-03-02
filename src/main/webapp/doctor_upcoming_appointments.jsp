<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="appointment_display.css">
        <link rel="shortcut icon" type="image/x-icon" href="#">
        <title> Upcoming Appointments </title>
    </head>
    <body> 
        <nav>
            <ul class="nav">
              <li class="brandname"><a href="#home">Brand Name</a></li>
              <li class="brandname"><a href="#">User: Doctor</a></li>
              <li class="navbar"><a href="#logout"> Logout </a></li>
              <li class="navbar"><a href="#profile"> Profile </a></li>
            </ul>
        </nav>
        <h1 id="upcomingHeadline"> Upcoming Appointments </h1>
        <h6 id="finishedAppointment"><a href="#"> Finished Appointments</a></h6>
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
            	<% for (int i = 0; i < appointeeName.size(); i++) { %>
   			 <tr>
   			 	<td class="data"> <input type="checkbox"></td>
        		<td class="data"><%= appointeeName.get(i) %></td>
        		<td class="data"><%= appointeeEmail.get(i) %></td>
        		<td class="data"><%= checkupType.get(i) %></td>
        		<td class="data"><%= checkupDescription.get(i) %></td>
        		<td class="data"><%= checkupDate.get(i) %></td>
    		</tr>
			<% } %>
            </tbody>
        </table>
        </body>
    </body>
</html>