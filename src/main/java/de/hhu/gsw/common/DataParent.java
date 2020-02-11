package de.hhu.gsw.common;

import java.util.Map;

public class DataParent {

    private int intValue;
    private String stringValue;
    private Map<String, String> stringToStringMapValue;
    private DataChild childObject;

    public DataParent(int intValue, String stringValue, Map<String, String> stringToStringMapValue, DataChild childObject) {
        this.intValue = intValue;
        this.stringValue = stringValue;
        this.stringToStringMapValue = stringToStringMapValue;
        this.childObject = childObject;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("DataParent:").append("\n");
        sb.append("  IntValue: ").append(intValue).append("\n");
        sb.append("  StringValue: ").append(stringValue).append("\n");
        sb.append("  StringToStringMap: ").append("\n");
        for(Map.Entry<String, String> mapEntry : stringToStringMapValue.entrySet()){
            String key = mapEntry.getKey(); // First value of the entry
            String value = mapEntry.getValue(); // Second value of the entry, which is assigned to the key
            sb.append("    ").append(key).append(" -> ").append(value).append("\n");
        }
        sb.append(childObject.toString());
        return sb.toString();
    }

    /*
    //TODO @Task7: Implement

    public JSONObject serializeToJSON(){
        ...
    }

    public static DataParent deserializeFromJSON(JSONObject json){
        ...
    }
     */

}
