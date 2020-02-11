package de.hhu.gsw.serializer;

import de.hhu.gsw.common.Data;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
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

        // Print data before serialization
        System.out.println("[Before serialization]");
        System.out.println(data.toString());

        // Serialize the data object and write it to disk
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("serializedData.json"), StandardCharsets.UTF_8));
        data.serializeToJSON().write(bw);
        bw.flush();
        bw.close();
    }

}
