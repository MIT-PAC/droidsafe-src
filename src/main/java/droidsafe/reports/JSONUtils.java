/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

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
