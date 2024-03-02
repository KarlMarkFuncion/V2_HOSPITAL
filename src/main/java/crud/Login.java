package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate user credentials
        try {
            if (isValidUser(username, password)) {
                // Login successful, redirect to welcome page
                response.sendRedirect("/welcome.jsp");
            } else {
                // Login failed, display error message
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<p style=\"color:red;\">Invalid username or password.</p>");
                // Include link back to login page
                out.println("<a href=\"/Login.jsp\">Back to Login</a>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/error.jsp"); // Redirect to error page if any database issue
        }
    }

    private boolean isValidUser(String username, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Use ConnectionDB for connection
            connection = createdb.getConnection();

            // Prepare query to check user credentials
            String sql = "SELECT * FROM employees WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Execute query and check for results
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
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
    }
}
