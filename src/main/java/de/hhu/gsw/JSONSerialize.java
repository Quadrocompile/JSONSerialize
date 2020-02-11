package de.hhu.gsw;

import de.hhu.gsw.deserializer.DeserializationExample;
import de.hhu.gsw.serializer.SerializationExample;

import java.io.IOException;

public class JSONSerialize {

    public static void main(String[] args) throws IOException {
        // Perform a serialization. This will create the local file "serializedData.json".
        // Use a tool like http://jsonviewer.stack.hu/ to view the JSON data (Use "Format" and "Remove white space" in the "Text" tab, and view the data in the "Viewer" tab!)
        SerializationExample.runExample();

        // Deserialize the data
        DeserializationExample.runExample();
    }

}
