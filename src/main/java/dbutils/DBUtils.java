package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
public class DBUtils {


    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "MEDICINE_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    public DBUtils() {

        try {
            Class.forName(DRIVER);
            connection = DriverManager

                    .getConnection(URL+DB_NAME, USER, PASSWORD);

        }

        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        if(connection==null)
            new DBUtils();

        return connection;
    }

}