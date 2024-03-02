<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="appointment_display.css">
        <link rel="shortcut icon" type="image/x-icon" href="#">
        <title> Set an Appointment </title>
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
        <div class="container">
            <h1 class="headline"> Set an Appointment </h1>
            <div class ="form">
                <form action = "#" method = "post">
                    Email <br>
                    <input name = "email" type = "text" required class="input"><br>
                    Type of Appointment <br>
                    <select name="appointment_type">
                        <option value="---"> --- </option>
                        <option value="routine"> Routine Checkup </option>
                        <option value="follow-up"> Follow-up Checkup</option>
                        <option value="urgent">Urgent Checkup</option>
                        <option value="diagnostic"> Diagnostic Checkup</option>
                        <option value="other"> Other </option>
                    </select><br>
                    Subject Line <br>
                    <input name = "subject" type ="text" required class="input"><br>
                    Appointment Date <br>
                    <input name = "date" type ="date" required class="input"><br>
                    Description <br>
                    <input name="description" type="text" class="input description"><br>
                    <button type = "submit" class="submit" value="submit"> Submit </button><br>
                </form>
            </div>
        </div>
    </body>
</html>