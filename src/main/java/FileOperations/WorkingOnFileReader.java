package FileOperations;

import java.io.*;
import java.util.Properties;

public class WorkingOnFileReader {
    public void readResponseFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        String location = properties.getProperty("DatabaseResponseFile");
        FileReader fileReader = new FileReader(location);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.readLine() != null){
            System.out.println(bufferedReader.readLine());
        }
        bufferedReader.close();
    }
    public static void main(String[] args) throws IOException {

        WorkingOnFileReader workingOnFileReader = new WorkingOnFileReader();
        workingOnFileReader.readResponseFile();
    }
}
