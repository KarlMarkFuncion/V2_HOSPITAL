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
public class AdminSignup extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminusername = request.getParameter("fname");
        String adminemail = request.getParameter("email");
        String adminpassword = request.getParameter("password");
       
        try {
            createAdmin(adminusername, adminemail, adminpassword);
            response.sendRedirect("/read-admin.jsp?success=true");
        } catch (SQLException e) {
            // Handle database connection error
            response.sendRedirect("/create-admin.jsp?error=Database connection error: " + e.getMessage());
        } catch (Exception e) {
            // Handle other potential exceptions
            response.sendRedirect("/create-admin.jsp?error=" + e.getMessage());
        }
    }

    private void createAdmin(String username, String email, String password) throws SQLException {
        // Attempt to connect to the database
        try (Connection conn = createdb.getConnection()) {
            // Now you have a guaranteed connection within this block
            String sql = "INSERT INTO doctor_appointments (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw e; // Re-throw the exception for handling in the calling method
        }
    }
}