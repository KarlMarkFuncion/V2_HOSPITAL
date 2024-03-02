package crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/signup")
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       
        try {
            createEmployee(fullname, email, password);
            response.sendRedirect("/read-employees.jsp?success=true");
        } catch (SQLException e) {
            // Handle database connection error
            response.sendRedirect("/create-employee.jsp?error=Database connection error: " + e.getMessage());
        } catch (Exception e) {
            // Handle other potential exceptions
            response.sendRedirect("/create-employee.jsp?error=" + e.getMessage());
        }
    }

    private void createEmployee(String fname, String email, String password) throws SQLException {
        // Attempt to connect to the database
        try (Connection conn = createdb.getConnection()) {
            // Now you have a guaranteed connection within this block
            String sql = "INSERT INTO patient_appointments (fullname, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fname);
            stmt.setString(2, email);
            stmt.setString(3, password);

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw e; // Re-throw the exception for handling in the calling method
        }
    }
}