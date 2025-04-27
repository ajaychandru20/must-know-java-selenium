package connectDatabase;

import FileOperations.WorkingOnFileReader;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectDataBase {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        FileInputStream fileInputStream = new FileInputStream("config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);


        String location = properties.getProperty("DatabaseResponseFile");
        FileWriter fileWriter = new FileWriter(location);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://root@localhost/selenium_users");
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM `employee_details` WHERE id LIMIT 15");

        System.out.println("ID " + " Name " + " Age " + " Phone " + " Department ");
        bufferedWriter.write("ID " + " Name " + " Age " + " Phone " + " Department " + "\n");

        while (resultSet.next()){

            String data =  resultSet.getInt(1) + " " +
                    resultSet.getString(2) + " " +
                    resultSet.getInt(3) + "  " +
                    resultSet.getBigDecimal(4) + "  " +
                    resultSet.getString(5);
            bufferedWriter.write(data + "\n");
        }
        connection.close();
        bufferedWriter.close();
        WorkingOnFileReader workingOnFileReader = new WorkingOnFileReader();
        workingOnFileReader.readResponseFile();

    }
}
