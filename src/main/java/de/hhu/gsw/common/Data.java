package de.hhu.gsw.common;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class Data {

    private String stringValue;
    private Map<String, String> stringToStringMapValue;

    public Data(String stringValue, Map<String, String> stringToStringMapValue) {
        this.stringValue = stringValue;
        this.stringToStringMapValue = stringToStringMapValue;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Data:").append("\n");
        sb.append("  StringValue: ").append(stringValue).append("\n");
        sb.append("  StringToStringMap: ").append("\n");
        for(Map.Entry<String, String> mapEntry : stringToStringMapValue.entrySet()){
            String key = mapEntry.getKey(); // First value of the entry
            String value = mapEntry.getValue(); // Second value of the entry, which is assigned to the key
            sb.append("    ").append(key).append(" -> ").append(value).append("\n");
        }
        return sb.toString();
    }

    public JSONObject serializeToJSON(){
        JSONObject json = new JSONObject();

        // Serialize the stringValue
        json.put("STRINGVALUE", stringValue);

        // Create a new  Object that will store all entries of the map.
        /* You could also use new JSONObject(stringToStringMapObject) instead of assigning all entries in a loop with
            the map key as the object key. This would result in a flatter structure, however this is to demonstrate how
            to build up complex structures (e.g. if you want to serialize nested classes)

            JSONObject stringToStringMapObject = new JSONObject(stringToStringMapValue);
            json.put("STRINGTOSTRINGMAP", stringToStringMapObject);

            Instead we will create a JSONObject for each of the maps' entries and add it to a JSONArray. This has
            the advantage, that we will retain the exact order of the entries, as JSONObjects do not retain the insertion
            order. This is because JSONObject internally uses a HashMap. For retaining the insertion order it would
            need to implement the LinkedHashMap.
         */
        JSONArray stringToStringMapEntryArray = new JSONArray();
        for(Map.Entry<String, String> mapEntry : stringToStringMapValue.entrySet()){
            JSONObject entryObject = new JSONObject();
            entryObject.put("KEY", mapEntry.getKey());
            entryObject.put("VALUE", mapEntry.getValue());
            stringToStringMapEntryArray.put(entryObject);
        }
        json.put("STRINGTOSTRINGMAP", stringToStringMapEntryArray);

        return json;
    }


    public static Data deserializeFromJSON(JSONObject json){
        try{
            // Deserialize the stringValue
            String stringValue = json.getString("STRINGVALUE");

            // Deserialize the stringToStringMap
            Map<String, String> stringToStringMapValue = new LinkedHashMap<>();
            JSONArray stringToStringMapEntryArray = json.getJSONArray("STRINGTOSTRINGMAP");
            for (int i = 0; i < stringToStringMapEntryArray.length(); i++) {
                JSONObject entryObject = stringToStringMapEntryArray.getJSONObject(i);
                stringToStringMapValue.put(entryObject.getString("KEY"), entryObject.getString("VALUE"));
            }

            // Construct a new Data object with the deserialized values as arguments.
            return new Data(stringValue, stringToStringMapValue);
        }
        catch (Exception ex){
            System.err.println("Failed to deserialize JSONObject '" + json.toString() + "'. Wrong deserializer?");
            return null;
        }
    }
}
