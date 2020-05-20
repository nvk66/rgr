import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static Connection dbConnection;
    private static Boolean status = false;

    private static Connection getDbConnection() {
        if(!status) {
            String connectionString = "jdbc:mysql://127.0.0.1:3306/taxi?&useUnicode=true&serverTimezone=UTC&useSSL=false";

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                dbConnection = DriverManager.getConnection(connectionString, "root", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            status = true;
        }
        System.out.println(dbConnection);
        return dbConnection;
    }








}
