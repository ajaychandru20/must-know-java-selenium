package FileOperations;

import java.io.*;
import java.util.Properties;

public class WorkingOnFileWritter {

    public static void main(String[] args) throws IOException {
        String jsonData = "{\\n\" +\n" +
                "                \"  \\\"name\\\": \\\"Vijay\\\",\\n\" +\n" +
                "                \"  \\\"age\\\": 23,\\n\" +\n" +
                "                \"  \\\"department\\\": \\\"Arts\\\",\\n\" +\n" +
                "                \"  \\\"email\\\": \\\"testing002@gmail.com\\\"\\n\" +\n" +
                "                \"}";
        FileInputStream fileInputStream = new FileInputStream("config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        String location = properties.getProperty("DatabaseResponseFile");
        FileWriter fileWriter = new FileWriter(location);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(jsonData);
        bufferedWriter.close();

    }
}
