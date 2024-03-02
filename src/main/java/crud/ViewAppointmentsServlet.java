package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ViewAppointmentsServlet")
public class ViewAppointmentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Model> appointments = new ArrayList<>();

        // Get user ID from session (optional, if filtering by user)
        HttpSession session = request.getSession(false); // Don't create a new session if not existing
        int userId = session != null ? (int) session.getAttribute("id") : 0; // Default to 0 if not logged in

        // Create connection and prepare statement
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Use ConnectionDB for connection
            connection = createdb.getConnection();

            String sql = "SELECT * FROM patient_appointments"; // Modify to add WHERE clause if filtering by user ID
            if (userId > 0) {
                sql += " WHERE id = ?";
            }

            preparedStatement = connection.prepareStatement(sql);
            if (userId > 0) {
                preparedStatement.setInt(1, userId); // Set user ID parameter if filtering
            }

            resultSet = preparedStatement.executeQuery();

            // Extract appointment data and create Appointment objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                java.sql.Date date = resultSet.getDate("date");
                String typeOfAppointment = resultSet.getString("type_of_appointment");
                String doctor_name = resultSet.getString("doctor_type");
                String description = resultSet.getString("note");

                Model appointment = new Model();
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) {	
                    resultSet.close();
                }
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

        // Set appointment list as request attribute
        request.setAttribute("appointments", appointments);

        // Forward request to JSP to display data
        request.getRequestDispatcher("/view_appointments.jsp").forward(request, response);
    }
}
