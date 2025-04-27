package JsonFileHandel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class JsonWriteExample {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("config.properties");
        Properties properties= new Properties();
        properties.load(fileInputStream);
        String location = properties.getProperty("JsonResponseFile");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("name","Ajay");

        JSONArray array = new JSONArray();
        array.add("tall guy");
        array.add("smart look");
        jsonObject.put("specialities",array);

        System.out.println(jsonObject);

        FileWriter fileWriter = new FileWriter(location);
        fileWriter.write(jsonObject.toJSONString());
        fileWriter.close();


    }
}
