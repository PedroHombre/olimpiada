import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseController {
    private static Connection connection;

    public static void initialize() {
        String url = "jdbc:mysql://localhost:3306/olimpijczycy";
        String user = "root";
        try {
            connection = DriverManager.getConnection(url, user, "");


        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void clearEventDataFromDatabase() {
        if (connection != null) {
            try {
                Statement myStmt = connection.createStatement();
                myStmt.executeUpdate("DELETE FROM olimpijczycy WHERE 1;");
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    public static void saveToDatabase(ArrayList<Olympian> olympians){
        if (connection != null) {
            for (Olympian o : olympians) {
                try {
                    Statement myStmt = connection.createStatement();
                    String sql = "INSERT INTO olimpijczycy (name,country,gold,silver,bronze) VALUES ('"+o.name + "','" + o.country + "'," + o.goldenMedals + "," + o.silverMedals + "," + o.bronzeMedals + ");";
                    System.out.println(sql);
                    myStmt.executeUpdate(sql);
                } catch (SQLException se) {
//                    se.printStackTrace();
                }
            }
        }
    }

}
