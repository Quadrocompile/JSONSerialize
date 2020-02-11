package de.hhu.gsw.deserializer;

import de.hhu.gsw.common.Data;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DeserializationExample {

    public static void runExample() throws IOException {
        // Read the serialized data from disk and convert it into a JSONObject
        JSONObject json = readJSONFromFile("serializedData.json");

        // Deserialize the Data object
        Data data = Data.deserializeFromJSON(json);

        /*
        //TODO @Task7: Implement deserializeFromJSON factory function for DataParent and its nested class DataChild. Deserialize DataParent from disk
        DataParent dataParent = DataParent.deserializeFromJSON(json);
         */

        // Print data after deserialization
        System.out.println("[After deserialization]");
        System.out.println(data.toString());
        /*
        //TODO @Task7: Uncomment lines
        System.out.println(dataParent.toString());
         */
    }

    private static JSONObject readJSONFromFile(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=br.readLine())!=null){ // Read lines (line = br.readLine()) until there is no more data. In this case readLine will return null and thus line will become null
            // Append all lines to the StringBuilder. Note: This will remove all newline characters as they are used as delimeter by the BufferedReaders' readLine function!
            sb.append(line);
        }

        String serializedData = sb.toString(); // Convert all appended lines to a String
        return new JSONObject(serializedData); // Create a JSONObject from the gathered data
    }

}
