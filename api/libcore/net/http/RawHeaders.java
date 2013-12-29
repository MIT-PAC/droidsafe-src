package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;






public final class RawHeaders {

    /**
     * Creates a new instance from the given map of fields to values. If
     * present, the null field's last element will be used to set the status
     * line.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.465 -0500", hash_original_method = "0E3CF8DED99C22691F37852AF5C558BE", hash_generated_method = "8E4E60A8B3E52C05A5F8E58E2AF1D6EA")
    public static RawHeaders fromMultimap(Map<String, List<String>> map) {
        RawHeaders result = new RawHeaders();
        for (Entry<String, List<String>> entry : map.entrySet()) {
            String fieldName = entry.getKey();
            List<String> values = entry.getValue();
            if (fieldName != null) {
                result.addAll(fieldName, values);
            } else if (!values.isEmpty()) {
                result.setStatusLine(values.get(values.size() - 1));
            }
        }
        return result;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.375 -0400", hash_original_field = "FA7582AED8A9C6860ED135540F90AAFE", hash_generated_field = "F018DC0E2BA01C80BAE5B1A83407ABAC")

    private static final Comparator<String> FIELD_NAME_COMPARATOR = new Comparator<String>() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.375 -0400", hash_original_method = "97A4263BD250C85D737E56C91BCF9DB2", hash_generated_method = "87FDB9F6A8C83D84768E8CB65F606488")
        @FindBugsSuppressWarnings("ES_COMPARING_PARAMETER_STRING_WITH_EQ")
        @Override
        public int compare(String a, String b) {
            {
                int var19956D017C395B4AC52CA5B4F956ED43_584031473 = (String.CASE_INSENSITIVE_ORDER.compare(a, b));
            } 
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091903691 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091903691;
            
            
                
            
                
            
                
            
                
            
        }

        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.445 -0500", hash_original_field = "07F428528BFEF71A200897A68EEF9185", hash_generated_field = "E294623D0BEE32E5166A91061EFF3F0C")


    private final List<String> namesAndValues = new ArrayList<String>(20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.446 -0500", hash_original_field = "A523116C573EF8EFB44D14B8D098B78E", hash_generated_field = "3535C618FCAB072DA70F443EC8961E3F")

    private String statusLine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.447 -0500", hash_original_field = "7BCAE6967DFDC448294B4940D749F7DF", hash_generated_field = "518FD222D66780F6300863A063540421")

    private int httpMinorVersion = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.447 -0500", hash_original_field = "C8334BB5D76A281957EF6D16AB72DEB9", hash_generated_field = "D785483FBB4763BBCFA08884D49686B0")

    private int responseCode = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.448 -0500", hash_original_field = "DB6D15FDCC440703E4CF4DC1D69DBA6B", hash_generated_field = "F2C26AD99124E5993699C59ABECD857F")

    private String responseMessage;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.449 -0500", hash_original_method = "29CBB7411AB87121F534DC6D89E1C3FF", hash_generated_method = "74EA0C366FBBEE690531A70E581FDE00")
    public RawHeaders() {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.450 -0500", hash_original_method = "E9B27FF414EC11CE1087F7E174CD847B", hash_generated_method = "ED57EB2B9D9138A18A01ACBB334D6C99")
    public RawHeaders(RawHeaders copyFrom) {
        namesAndValues.addAll(copyFrom.namesAndValues);
        statusLine = copyFrom.statusLine;
        httpMinorVersion = copyFrom.httpMinorVersion;
        responseCode = copyFrom.responseCode;
        responseMessage = copyFrom.responseMessage;
    }

    /**
     * Sets the response status line (like "HTTP/1.0 200 OK") or request line
     * (like "GET / HTTP/1.1").
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.451 -0500", hash_original_method = "A034EBBE3F64C8F074A3B6C276AAF223", hash_generated_method = "239C992354690A143B33A6E7F66A1BCC")
    public void setStatusLine(String statusLine) {
        statusLine = statusLine.trim();
        this.statusLine = statusLine;

        if (statusLine == null || !statusLine.startsWith("HTTP/")) {
            return;
        }
        statusLine = statusLine.trim();
        int mark = statusLine.indexOf(" ") + 1;
        if (mark == 0) {
            return;
        }
        if (statusLine.charAt(mark - 2) != '1') {
            this.httpMinorVersion = 0;
        }
        int last = mark + 3;
        if (last > statusLine.length()) {
            last = statusLine.length();
        }
        this.responseCode = Integer.parseInt(statusLine.substring(mark, last));
        if (last + 1 <= statusLine.length()) {
            this.responseMessage = statusLine.substring(last + 1);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.452 -0500", hash_original_method = "A2AF11C5A8C661AB11C9AC7FDCDD9C73", hash_generated_method = "9CC8C34428E7A8BFCD11806466340D3D")
    public String getStatusLine() {
        return statusLine;
    }

    /**
     * Returns the status line's HTTP minor version. This returns 0 for HTTP/1.0
     * and 1 for HTTP/1.1. This returns 1 if the HTTP version is unknown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.453 -0500", hash_original_method = "DB8BE97BE5124EB81D65BC5698249D9B", hash_generated_method = "2BEDDFED387FAAC6F8BB5D71134CC577")
    public int getHttpMinorVersion() {
        return httpMinorVersion != -1 ? httpMinorVersion : 1;
    }

    /**
     * Returns the HTTP status code or -1 if it is unknown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.453 -0500", hash_original_method = "9E4A5E9FF258EB24BD25F51C84D6D494", hash_generated_method = "92048A1B8E5D48E862679EB1DB17FC18")
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Returns the HTTP status message or null if it is unknown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.454 -0500", hash_original_method = "84763A1C87A993ECD4976A3E0463024E", hash_generated_method = "301C2D9B6AB506E40ACBEDDC935861DB")
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Add an HTTP header line containing a field name, a literal colon, and a
     * value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.455 -0500", hash_original_method = "8393782C8F932A1D751AE7869AA4907E", hash_generated_method = "A9A2EF97EF85CEE324CE88E14FCBF07C")
    public void addLine(String line) {
        int index = line.indexOf(":");
        if (index == -1) {
            add("", line);
        } else {
            add(line.substring(0, index), line.substring(index + 1));
        }
    }

    /**
     * Add a field with the specified value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.456 -0500", hash_original_method = "438CB3F0D3B01507EC959AE5277C1434", hash_generated_method = "D618B8A0B8645A63526CEA5B342F57A5")
    public void add(String fieldName, String value) {
        if (fieldName == null) {
            throw new IllegalArgumentException("fieldName == null");
        }
        if (value == null) {
            /*
             * Given null values, the RI sends a malformed field line like
             * "Accept\r\n". For platform compatibility and HTTP compliance, we
             * print a warning and ignore null values.
             */
            System.logW("Ignoring HTTP header field '" + fieldName + "' because its value is null");
            return;
        }
        namesAndValues.add(fieldName);
        namesAndValues.add(value.trim());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.457 -0500", hash_original_method = "5C24A819593BC86E0E1AF9616F67E395", hash_generated_method = "03AF4FD7E152091D528E188C28716B37")
    public void removeAll(String fieldName) {
        for (int i = 0; i < namesAndValues.size(); i += 2) {
            if (fieldName.equalsIgnoreCase(namesAndValues.get(i))) {
                namesAndValues.remove(i); // field name
                namesAndValues.remove(i); // value
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.458 -0500", hash_original_method = "9CD3B49A68466D363A29D778884154B6", hash_generated_method = "4D1B90E65EF2A0E35AC831EB519FF610")
    public void addAll(String fieldName, List<String> headerFields) {
        for (String value : headerFields) {
            add(fieldName, value);
        }
    }

    /**
     * Set a field with the specified value. If the field is not found, it is
     * added. If the field is found, the existing values are replaced.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.458 -0500", hash_original_method = "A964C2ABDA70C3696494D217AFF90E69", hash_generated_method = "A2225165535D6A2ABCF867FA2CC2086E")
    public void set(String fieldName, String value) {
        removeAll(fieldName);
        add(fieldName, value);
    }

    /**
     * Returns the number of field values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.459 -0500", hash_original_method = "65DB99CA105C788DAB9FE23472075832", hash_generated_method = "2DD715456B3F88C720AE6031E2E90961")
    public int length() {
        return namesAndValues.size() / 2;
    }

    /**
     * Returns the field at {@code position} or null if that is out of range.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.460 -0500", hash_original_method = "BE23DD7B1410D37DAEEAE51D9DBF75EB", hash_generated_method = "56C6E0712AF3471B5AB2875C9BB88C47")
    public String getFieldName(int index) {
        int fieldNameIndex = index * 2;
        if (fieldNameIndex < 0 || fieldNameIndex >= namesAndValues.size()) {
            return null;
        }
        return namesAndValues.get(fieldNameIndex);
    }

    /**
     * Returns the value at {@code index} or null if that is out of range.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.461 -0500", hash_original_method = "B22E5B19D625D7A351EC2F77115E183E", hash_generated_method = "D103C4940BD1D8B4D8F4506E535D97C8")
    public String getValue(int index) {
        int valueIndex = index * 2 + 1;
        if (valueIndex < 0 || valueIndex >= namesAndValues.size()) {
            return null;
        }
        return namesAndValues.get(valueIndex);
    }

    /**
     * Returns the last value corresponding to the specified field, or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.461 -0500", hash_original_method = "5CE86F73873B18464F6757EE122420F2", hash_generated_method = "B5864FFFC52610C7B478D7A0201FA4C9")
    public String get(String fieldName) {
        for (int i = namesAndValues.size() - 2; i >= 0; i -= 2) {
            if (fieldName.equalsIgnoreCase(namesAndValues.get(i))) {
                return namesAndValues.get(i + 1);
            }
        }
        return null;
    }

    /**
     * @param fieldNames a case-insensitive set of HTTP header field names.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.462 -0500", hash_original_method = "DFF30A75B51A172BE4172930F32BB680", hash_generated_method = "F866F29DDC94BA144419BC2D0696D255")
    public RawHeaders getAll(Set<String> fieldNames) {
        RawHeaders result = new RawHeaders();
        for (int i = 0; i < namesAndValues.size(); i += 2) {
            String fieldName = namesAndValues.get(i);
            if (fieldNames.contains(fieldName)) {
                result.add(fieldName, namesAndValues.get(i + 1));
            }
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.463 -0500", hash_original_method = "03F9E8D356406A137FAD06FB9E8EE371", hash_generated_method = "B479C1FE28922670A2BCFDF1F907920E")
    public String toHeaderString() {
        StringBuilder result = new StringBuilder(256);
        result.append(statusLine).append("\r\n");
        for (int i = 0; i < namesAndValues.size(); i += 2) {
            result.append(namesAndValues.get(i)).append(": ")
                    .append(namesAndValues.get(i + 1)).append("\r\n");
        }
        result.append("\r\n");
        return result.toString();
    }

    /**
     * Returns an immutable map containing each field to its list of values. The
     * status line is mapped to null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.464 -0500", hash_original_method = "08275C5AA7086D8C8C86CDE1903B0FA3", hash_generated_method = "46EAB98AB1F752B052993E5E77B9B081")
    public Map<String, List<String>> toMultimap() {
        Map<String, List<String>> result = new TreeMap<String, List<String>>(FIELD_NAME_COMPARATOR);
        for (int i = 0; i < namesAndValues.size(); i += 2) {
            String fieldName = namesAndValues.get(i);
            String value = namesAndValues.get(i + 1);

            List<String> allValues = new ArrayList<String>();
            List<String> otherValues = result.get(fieldName);
            if (otherValues != null) {
                allValues.addAll(otherValues);
            }
            allValues.add(value);
            result.put(fieldName, Collections.unmodifiableList(allValues));
        }
        if (statusLine != null) {
            result.put(null, Collections.unmodifiableList(Collections.singletonList(statusLine)));
        }
        return Collections.unmodifiableMap(result);
    }
}

