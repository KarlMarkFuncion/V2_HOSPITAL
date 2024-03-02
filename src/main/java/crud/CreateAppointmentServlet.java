package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;

@WebServlet("/CreateAppointmentServlet")
public class CreateAppointmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get appointment details from request parameters
        String dateStr = request.getParameter("date");
        String typeOfAppointment = request.getParameter("typeOfAppointment");
        String doctorType = request.getParameter("doctorType");
        String description = request.getParameter("description");
        String doctor_name = request.getParameter("doctor_name");
        // Validate input (optional, but recommended)
        if (dateStr == null || typeOfAppointment == null || doctorType == null) {
            sendErrorMessage(response, "Missing required appointment details.");
            return;
        }

        // Parse date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateFormat.parse(dateStr);
        } catch (Exception e) {
            sendErrorMessage(response, "Invalid date format. Please use YYYY-MM-DD.");
            return;
        }

        // Check for existing appointments for the same doctor on the same date
        if (hasExistingAppointment(dateStr, doctorType)) {
            sendErrorMessage(response, "Appointment already exists for " + doctorType + " on " + dateStr + ".");
            return;
        }

        // Create connection and prepare statement
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Use ConnectionDB for connection
            connection = createdb.getConnection();

            String sql = "INSERT INTO PATIENT_APPOINTMENT (typeOfAppointment, doctor_Type, appointment_date, description) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Set appointment details
            preparedStatement.setDate(1, java.sql.Date.valueOf(dateStr));
            preparedStatement.setString(2, typeOfAppointment);
            preparedStatement.setString(3, doctor_name);
//            preparedStatement.setString(4, appointment_date);
            preparedStatement.setString(4, description);

            // Execute the query
            preparedStatement.executeUpdate();

            // Send success message
            sendSuccessMessage(response, "Appointment created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            sendErrorMessage(response, "Error creating appointment.");
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendErrorMessage(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p style=\"color:red;\">" + message + "</p>");
    }

    private void sendSuccessMessage(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p style=\"color:green;\">" + message + "</p>");
    }

    private boolean hasExistingAppointment(String dateStr, String doctorType) {
        // Implement logic to check for existing appointments using JDBC
        // This example uses a placeholder, replace it with your actual query
        return false; // Replace with your actual logic
    }
}
