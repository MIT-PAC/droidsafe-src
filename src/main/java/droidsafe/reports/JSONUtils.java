package droidsafe.reports;

import java.util.Map;

public class JSONUtils {

    public static String json_call_graph_header(String type, Map<String,Boolean> visibility_map) {
    
        String out = String.format("{\n")
        + String.format("  %s,\n", json_field ("indicator-type", type))
        + String.format("  %s {", json_field ("visibility"));
        
        String delim = "\n";
        for (String name : visibility_map.keySet()) {
            out += delim;
            delim = ",\n";
            out += String.format ("    %s", json_field (name, visibility_map.get(name)));
        }
        out += String.format("  },\n")
        + String.format("  %s {\n", json_field ("display"))
        + String.format("    %s,\n", json_field ("calls", false))
        + String.format("    %s,\n", json_field ("syscalls", false))
        + String.format("    %s\n", json_field ("score", false))
        + String.format("  },\n")
        + String.format (" %s [\n", json_field ("contents"));        
        
        return out;
    }
    
    public static String json_field (String name) {
        return json_field (name, null);
    }
    public static String json_field (String name, String value) {
        name = "\"" + name + "\"";
        if (value == null)
            return String.format ("%-12s : ", name);
        return String.format ("%-12s : \"%s\"", name, value);
    }
    
    public static String json_field (String name, int value) {
        return String.format ("%-12s : %d", "\"" + name + "\"", value);
    }
          
    public static String json_field (String name, boolean value) {
        return String.format ("%-12s : %b", "\"" + name + "\"", value);
    }
}
