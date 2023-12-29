import java.sql.*;

public class JDBC_sample {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3308/vijai-java";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    private static final int PORT = 8888;
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM bookings";
            ResultSet rs = statement.executeQuery(query);

            boolean isResultSet = statement.execute(query);
            if (isResultSet) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    // Process the retrieved data
                    int id = resultSet.getInt("booking_id");
                    int client = resultSet.getInt("client_id");
                    System.out.println("ID: " + id + ", Name: " + client);
                }
            } else {
                int rowsAffected = statement.getUpdateCount();
                System.out.println("Rows affected: " + rowsAffected);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
