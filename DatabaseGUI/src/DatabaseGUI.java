/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Lenovo
 */
public class DatabaseGUI {

    
    public static void main(String[] args)  throws ClassNotFoundException, SQLException {
        //-------------------------------------------------------------------------
        //instansiasi koneksi
            String hostname = "localhost";
            String sqlInstanceName = "LAPTOP-43HAT1M2"; //computer name 
            String sqlDatabase = "University";  //sql server database name
            String sqlUser = "123";
            String sqlPassword = "123"; //passwrod sa account

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //jdbc:sqlserver://localhost:1433;instance=COMPUTERBERRY;databaseName=Database;
            String connectURL = "jdbc:sqlserver://" + hostname + ":1433" 
                    + ";instance=" + sqlInstanceName + ";databaseName=" + sqlDatabase + ";encrypt=true;trustServerCertificate=true";

            Connection conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);
            System.out.println("Connect to database successful!!"); 
            
            //-------------------------------------------------------------------------
            //contoh ambil kueri
            Statement st = conn.createStatement();
            String cth = "SELECT TOP 5 * FROM student";
            ResultSet resultSet = st.executeQuery(cth);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ": " + resultSet.getString(2)+ " (" + resultSet.getString(3) + ") " + resultSet.getInt(4));
            }
            //--------------------------------------------------------------------------
    }
}
