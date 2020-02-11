package de.hhu.gsw.common;

import java.util.List;

public class DataChild {

    private double childDoubleValue;
    private String childStringValue;
    private List<String> childStringListValue;

    public DataChild(double childDoubleValue, String childStringValue, List<String> childStringListValue) {
        this.childDoubleValue = childDoubleValue;
        this.childStringValue = childStringValue;
        this.childStringListValue = childStringListValue;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("DataChild:").append("\n");
        sb.append("  DoubleValue: ").append(childDoubleValue).append("\n");
        sb.append("  StringValue: ").append(childStringValue).append("\n");
        sb.append("  ListValue: ").append("\n");
        for(String listEntry : childStringListValue){
            sb.append("    ").append(listEntry).append("\n");
        }
        return sb.toString();
    }
}
