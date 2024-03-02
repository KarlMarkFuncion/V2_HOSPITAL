<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="appointment_display.css">
        <link rel="shortcut icon" type="image/x-icon" href="#">
        <title> Email </title>
    </head>
    <body>
        <nav>
            <ul class="nav">
                <li class="brandname"><a href="#home">Brand Name</a></li>
                <li class="brandname"><a href="#">User: Patient</a></li>
                <li class="navbar"><a href="#logout"> Logout </a></li>
                <li class="navbar"><a href="#profile"> Profile </a></li>
              </ul>
        </nav>
        <div class="container">
            <h1 class="headline"> Email Dr. <%= appointeeDoctor.get(i) %> </h1>
            <p class="back"><a href="#back"> Back </a></p>
            <div class ="form">
                <form action = "#" method = "post">
                    Subject Line <br>
                    <input name = "subject" type ="text" required class="input"><br>
                    Description <br>
                    <input name="description" type="text" class="input description"><br>
                    <button type = "submit" class="submit"> Submit </button><br>
                </form>
            </div>
        </div>
    </body>
</html>