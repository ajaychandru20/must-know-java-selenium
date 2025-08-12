package JsonFileHandel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JsonReadExample {
    public static void main(String[] args) throws IOException, ParseException {
        FileInputStream fileInputStream = new FileInputStream("config.properties");
        Properties properties= new Properties();
        properties.load(fileInputStream);
        String location = properties.getProperty("JsonResponseFile");
        // Step 1: Create JSONParser object
        JSONParser parser = new JSONParser();

        // Step 2: Read the file
        FileReader reader = new FileReader(location);

        // Step 3: Parse the content
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        // Step 4: Read simple data
        System.out.println("ID: " + jsonObject.get("id"));
        System.out.println("Name: " + jsonObject.get("name"));

        // Step 5: Read array data
        JSONArray specialities = (JSONArray) jsonObject.get("specialities");
        System.out.println("Specialities:");
        for (Object speciality : specialities) {
            System.out.println("- " + speciality);
        }

        reader.close();
    }
}
