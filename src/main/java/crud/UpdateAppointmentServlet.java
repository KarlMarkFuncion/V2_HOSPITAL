package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateAppointmentServlet")
public class UpdateAppointmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
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

        // Create connection and prepare statement
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Use ConnectionDB for connection
            connection = createdb.getConnection();

            String sql = "UPDATE patient_appointments SET typeOfAppointment = ?, doctor_Type = ?, appointment_date = ?, description = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set appointment details
            preparedStatement.setDate(1, java.sql.Date.valueOf(dateStr));
            preparedStatement.setString(2, typeOfAppointment);
            preparedStatement.setString(3, doctor_name);
//            preparedStatement.setString(4, appointment_date);
            preparedStatement.setString(4, description);

            // Execute the update query
            int rowsUpdated = preparedStatement.executeUpdate();

            // Send success or error message based on the number of rows updated
            if (rowsUpdated > 0) {
                sendSuccessMessage(response, "Appointment updated successfully!");
            } else {
                sendErrorMessage(response, "Appointment ID not found or no update performed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            sendErrorMessage(response, "Error updating appointment.");
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
}
