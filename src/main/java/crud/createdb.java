package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createdb {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:derby:Appointments;create=true";

		try (
				Connection connection = DriverManager.getConnection(jdbcURL);
				Statement statement = connection.createStatement()) {

		        // Create patient_appointments table if it doesn't exist
		        String patientAppointmentsSQL = "CREATE TABLE patient_appointments ("
		          + "id int, "
		          + "fullname VARCHAR(128),"
		          + "email VARCHAR(128),"
		          + "password VARCHAR(128),"
		          + "typeOfAppointment VARCHAR(60), "
		          + "doctor_Type VARCHAR(100), "
		          + "appointment_date DATE, "
		          + "description VARCHAR(128),"
		          + ")";
		        
		          statement.executeUpdate(patientAppointmentsSQL);
		          System.out.println("Table 'patient_appointments' created successfully (or already existed).");

		        // Create doctor_appointments table if it doesn't exist
		        String doctorAppointmentsSQL = "CREATE TABLE doctor_appointments ("
		        + "id int, "  
				+ "checkup_Type VARCHAR(60), "
		          + "username VARCHAR(128),"
		          + "password VARCHAR(128),"
		          + "patient_name VARCHAR(100), "
		          + "appointment_date DATE, "
		          + "email VARCHAR(50), "
		          + "description VARCHAR(128), "
		          + "is_finished BOOLEAN)";
		          statement.executeUpdate(doctorAppointmentsSQL);
		          System.out.println("Table 'doctor_appointments' created successfully (or already existed).");

		        // Create admin table if it doesn't exist
		        //   String adminAccessSQL = "CREATE TABLE admin_access ("
		        //   + "fullname VARCHAR(60), "
		        //   + "email VARCHAR(50), "
		        //   + "password VARCHAR(128))";
		        //   statement.executeUpdate(adminAccessSQL);
		        //   System.out.println("Table 'admin' created successfully (or already existed).");

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

	public static Connection getConnection() {
		 Connection connection = getConnection();
		return null;
	}
		}