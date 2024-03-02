<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="appointment_display.css">
        <link rel="shortcut icon" type="image/x-icon" href="#">
        <title> Appointment Details </title>
    </head>
    <body>
        <nav>
            <ul class="nav">
                <li class="brandname"><a href="#home">Brand Name</a></li>
                <li class="brandname"><a href="#">User: Patient</a></li>
                <li class="navbar"><a href="login.jsp"> Logout </a></li>
                <li class="navbar"><a href="#profile"> Profile </a></li>
              </ul>
        </nav>
        <h2 id="patientUpcomingHeadline"> Appointment Details </h2>
        <h5 id="detailsback"><a href="doctor_upcoming_appointments.jsp"> Back </a></h5>
        <table class="patientAppointmentTable">
            <tbody>
                <tr>
                    <td> <input type="checkbox"> </td>
                    <td><b><%= checkupType.get(n) %></b></td>
                    <td> </td> 
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td><b><%= checkupDate.get(n) %></b></td>
                </tr>
                <tr>
                    <td>  </td>
                    <td> with Dr. <%= appointeeDoctor.get(n) %> </td>
                    <td> </td> 
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                </tr>
                <tr>
                    <td>  </td>
                    <td><b>Reason for Checkup:</b></td>
                    <td><%= checkupReason.get(n) %></td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                </tr>
                <tr>
                    <td>  </td>
                    <td><%= checkupDescription.get(n) %></td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                </tr>
                <tr>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> </td>
                    <td> <button> Email your doctor </button> </td>
                    <td> <button> Reschedule Appointment </button> </td>
                    <td class="bottom"> <button> Cancel Appointment </button> </td>
                </tr>
            </tbody>
        </table>
        <br>
    </body>
</html>