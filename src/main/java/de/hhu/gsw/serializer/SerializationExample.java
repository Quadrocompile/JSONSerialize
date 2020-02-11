package de.hhu.gsw.serializer;

import de.hhu.gsw.common.Data;
import de.hhu.gsw.common.DataChild;
import de.hhu.gsw.common.DataParent;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SerializationExample {

    public static void runExample() throws IOException {
        // Construct example Data object
        String stringValue = "Hello World!";
        Map<String, String> stringToStringMap = new LinkedHashMap<>(); // LinkedHashMap will retain the insertion order in comparison to the HashMap class. Change to HashMap to see the difference
        stringToStringMap.put("Erster Eintrag", "A");
        stringToStringMap.put("Zweiter Eintrag", "B");
        stringToStringMap.put("Dritter Eintrag", "C");
        stringToStringMap.put("Vierter Eintrag", "D");

        Data data = new Data(stringValue, stringToStringMap);

        /*
        //TODO @Task7: Uncomment lines
        int intValue = 42;
        double childDoubleValue = 13.37;
        String childStringValue = "Hello nested world!";
        List<String> childListValue = new ArrayList<>();
        childListValue.add("Wert 1");
        childListValue.add("Wert 2");
        childListValue.add("Wert 3");
        DataChild dataChild = new DataChild(childDoubleValue, childStringValue, childListValue);
        DataParent dataParent = new DataParent(intValue, stringValue, stringToStringMap, dataChild);
        */

        // Print data before serialization
        System.out.println("[Before serialization]");
        System.out.println(data.toString());
        /*
        //TODO @Task7: Uncomment lines
        System.out.println(dataParent.toString());
         */

        // Serialize the data object and write it to disk
        writeJSONToFile(data.serializeToJSON(), "serializedData.json");

        /*
        //TODO @Task7: Implement a serializeToJSON function for the class DataParent and its nested class DataChild. Serialize dataParent and write the representation to disk
        writeJSONToFile(dataParent.serializeToJSON(), "serializedDataParent.json");
         */
    }

    private static void writeJSONToFile(JSONObject json, String fileName) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8));
        json.write(bw);
        bw.flush();
        bw.close();
    }

}
