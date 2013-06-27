package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class RawHeaders {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.542 -0400", hash_original_field = "A8AC49EE300212F0188F86FAA3B8CBD3", hash_generated_field = "52C80FFB7641F86E69CE98F5BFE61C2A")

    private List<String> namesAndValues = new ArrayList<String>(20);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.542 -0400", hash_original_field = "8462E9D9B0BB0450DAF299F1B5423B07", hash_generated_field = "3535C618FCAB072DA70F443EC8961E3F")

    private String statusLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.542 -0400", hash_original_field = "07D1830D3A4E5B468E0D442D6C3FC9AA", hash_generated_field = "518FD222D66780F6300863A063540421")

    private int httpMinorVersion = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.542 -0400", hash_original_field = "343D8113EC60F49B94DCB68676490D2B", hash_generated_field = "D785483FBB4763BBCFA08884D49686B0")

    private int responseCode = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.542 -0400", hash_original_field = "C1E66B2C48B6FCDFA45BCBEAB51F2D59", hash_generated_field = "F2C26AD99124E5993699C59ABECD857F")

    private String responseMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.542 -0400", hash_original_method = "29CBB7411AB87121F534DC6D89E1C3FF", hash_generated_method = "15AC6645C1F6E653E1857608E76C2802")
    public  RawHeaders() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.553 -0400", hash_original_method = "E9B27FF414EC11CE1087F7E174CD847B", hash_generated_method = "95DE4AF15A4442FE8EB3D1946076B466")
    public  RawHeaders(RawHeaders copyFrom) {
        namesAndValues.addAll(copyFrom.namesAndValues);
        statusLine = copyFrom.statusLine;
        httpMinorVersion = copyFrom.httpMinorVersion;
        responseCode = copyFrom.responseCode;
        responseMessage = copyFrom.responseMessage;
        // ---------- Original Method ----------
        //namesAndValues.addAll(copyFrom.namesAndValues);
        //statusLine = copyFrom.statusLine;
        //httpMinorVersion = copyFrom.httpMinorVersion;
        //responseCode = copyFrom.responseCode;
        //responseMessage = copyFrom.responseMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.555 -0400", hash_original_method = "A034EBBE3F64C8F074A3B6C276AAF223", hash_generated_method = "9B416742223B9B393E83B62EEB4DAF95")
    public void setStatusLine(String statusLine) {
        statusLine = statusLine.trim();
        this.statusLine = statusLine;
        {
            boolean varA9C46BADA067E1986BD6C750A900233A_356932056 = (statusLine == null || !statusLine.startsWith("HTTP/"));
        } //End collapsed parenthetic
        statusLine = statusLine.trim();
        int mark;
        mark = statusLine.indexOf(" ") + 1;
        {
            boolean var9BD0A0F1BC978600B99C117EF2818F7C_1679607489 = (statusLine.charAt(mark - 2) != '1');
            {
                this.httpMinorVersion = 0;
            } //End block
        } //End collapsed parenthetic
        int last;
        last = mark + 3;
        {
            boolean varFA7F7DD24A01CC7A9339145112306A40_995950148 = (last > statusLine.length());
            {
                last = statusLine.length();
            } //End block
        } //End collapsed parenthetic
        this.responseCode = Integer.parseInt(statusLine.substring(mark, last));
        {
            boolean var4DCC4C385B63926BC6BDB6FBEDBB6BFA_1842657895 = (last + 1 <= statusLine.length());
            {
                this.responseMessage = statusLine.substring(last + 1);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //statusLine = statusLine.trim();
        //this.statusLine = statusLine;
        //if (statusLine == null || !statusLine.startsWith("HTTP/")) {
            //return;
        //}
        //statusLine = statusLine.trim();
        //int mark = statusLine.indexOf(" ") + 1;
        //if (mark == 0) {
            //return;
        //}
        //if (statusLine.charAt(mark - 2) != '1') {
            //this.httpMinorVersion = 0;
        //}
        //int last = mark + 3;
        //if (last > statusLine.length()) {
            //last = statusLine.length();
        //}
        //this.responseCode = Integer.parseInt(statusLine.substring(mark, last));
        //if (last + 1 <= statusLine.length()) {
            //this.responseMessage = statusLine.substring(last + 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.556 -0400", hash_original_method = "A2AF11C5A8C661AB11C9AC7FDCDD9C73", hash_generated_method = "D42E571E6DEA506D8366CE21E2E7B87D")
    public String getStatusLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_44712284 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_44712284 = statusLine;
        varB4EAC82CA7396A68D541C85D26508E83_44712284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_44712284;
        // ---------- Original Method ----------
        //return statusLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.556 -0400", hash_original_method = "DB8BE97BE5124EB81D65BC5698249D9B", hash_generated_method = "F39B389422CE55FE127D29EC4CD9E068")
    public int getHttpMinorVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125591134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125591134;
        // ---------- Original Method ----------
        //return httpMinorVersion != -1 ? httpMinorVersion : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.556 -0400", hash_original_method = "9E4A5E9FF258EB24BD25F51C84D6D494", hash_generated_method = "B50CFA6397664366BF9FDACB2098640E")
    public int getResponseCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1161016210 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1161016210;
        // ---------- Original Method ----------
        //return responseCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.561 -0400", hash_original_method = "84763A1C87A993ECD4976A3E0463024E", hash_generated_method = "E19E82990CE4D2167AF4FEBEB176128F")
    public String getResponseMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1049349658 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1049349658 = responseMessage;
        varB4EAC82CA7396A68D541C85D26508E83_1049349658.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1049349658;
        // ---------- Original Method ----------
        //return responseMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.573 -0400", hash_original_method = "8393782C8F932A1D751AE7869AA4907E", hash_generated_method = "8E1A738929E928FBC57F4C559A6AF8FF")
    public void addLine(String line) {
        int index;
        index = line.indexOf(":");
        {
            add("", line);
        } //End block
        {
            add(line.substring(0, index), line.substring(index + 1));
        } //End block
        addTaint(line.getTaint());
        // ---------- Original Method ----------
        //int index = line.indexOf(":");
        //if (index == -1) {
            //add("", line);
        //} else {
            //add(line.substring(0, index), line.substring(index + 1));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.573 -0400", hash_original_method = "438CB3F0D3B01507EC959AE5277C1434", hash_generated_method = "0F73363E6F7EEB6D7D546DD2ECCC66F6")
    public void add(String fieldName, String value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("fieldName == null");
        } //End block
        {
            System.logW("Ignoring HTTP header field '" + fieldName + "' because its value is null");
        } //End block
        namesAndValues.add(fieldName);
        namesAndValues.add(value.trim());
        addTaint(fieldName.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (fieldName == null) {
            //throw new IllegalArgumentException("fieldName == null");
        //}
        //if (value == null) {
            //System.logW("Ignoring HTTP header field '" + fieldName + "' because its value is null");
            //return;
        //}
        //namesAndValues.add(fieldName);
        //namesAndValues.add(value.trim());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.574 -0400", hash_original_method = "5C24A819593BC86E0E1AF9616F67E395", hash_generated_method = "76ED05F8C217032641DD4370B04B457D")
    public void removeAll(String fieldName) {
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_1267207546 = (i < namesAndValues.size());
            i += 2;
            {
                {
                    boolean var07383A2EA7E09819D63BC9504487D36B_210089817 = (fieldName.equalsIgnoreCase(namesAndValues.get(i)));
                    {
                        namesAndValues.remove(i);
                        namesAndValues.remove(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(fieldName.getTaint());
        // ---------- Original Method ----------
        //for (int i = 0; i < namesAndValues.size(); i += 2) {
            //if (fieldName.equalsIgnoreCase(namesAndValues.get(i))) {
                //namesAndValues.remove(i); 
                //namesAndValues.remove(i); 
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.582 -0400", hash_original_method = "9CD3B49A68466D363A29D778884154B6", hash_generated_method = "EF9EDB62737D36A626F3C25FC565C1E7")
    public void addAll(String fieldName, List<String> headerFields) {
        {
            Iterator<String> var93BDB38381E029428E418BBDBD1DCEC0_393057950 = (headerFields).iterator();
            var93BDB38381E029428E418BBDBD1DCEC0_393057950.hasNext();
            String value = var93BDB38381E029428E418BBDBD1DCEC0_393057950.next();
            {
                add(fieldName, value);
            } //End block
        } //End collapsed parenthetic
        addTaint(fieldName.getTaint());
        addTaint(headerFields.getTaint());
        // ---------- Original Method ----------
        //for (String value : headerFields) {
            //add(fieldName, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.582 -0400", hash_original_method = "A964C2ABDA70C3696494D217AFF90E69", hash_generated_method = "4ED30F4242025EEA85D5604136F4A214")
    public void set(String fieldName, String value) {
        removeAll(fieldName);
        add(fieldName, value);
        addTaint(fieldName.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //removeAll(fieldName);
        //add(fieldName, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.600 -0400", hash_original_method = "65DB99CA105C788DAB9FE23472075832", hash_generated_method = "78441F5D819FD187E63BA06FD956D00E")
    public int length() {
        int varBF8405D4CE29AD74DBF95C13A527B3F8_1051240872 = (namesAndValues.size() / 2);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844032085 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844032085;
        // ---------- Original Method ----------
        //return namesAndValues.size() / 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.600 -0400", hash_original_method = "BE23DD7B1410D37DAEEAE51D9DBF75EB", hash_generated_method = "B4E69FBF679BECE6A6427A6460998028")
    public String getFieldName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_652861305 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_518206367 = null; //Variable for return #2
        int fieldNameIndex;
        fieldNameIndex = index * 2;
        {
            boolean var0CDCF141294AFA070787D3560D1BE49E_701768517 = (fieldNameIndex < 0 || fieldNameIndex >= namesAndValues.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_652861305 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_518206367 = namesAndValues.get(fieldNameIndex);
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_759738784; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_759738784 = varB4EAC82CA7396A68D541C85D26508E83_652861305;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_759738784 = varB4EAC82CA7396A68D541C85D26508E83_518206367;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_759738784.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_759738784;
        // ---------- Original Method ----------
        //int fieldNameIndex = index * 2;
        //if (fieldNameIndex < 0 || fieldNameIndex >= namesAndValues.size()) {
            //return null;
        //}
        //return namesAndValues.get(fieldNameIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.601 -0400", hash_original_method = "B22E5B19D625D7A351EC2F77115E183E", hash_generated_method = "88CE6D38DA44F0F2B1CAD771B9E7FA5B")
    public String getValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_531966266 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_529190172 = null; //Variable for return #2
        int valueIndex;
        valueIndex = index * 2 + 1;
        {
            boolean varD4BC9792B49DEC02A6CF8EBEDA36396C_66137788 = (valueIndex < 0 || valueIndex >= namesAndValues.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_531966266 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_529190172 = namesAndValues.get(valueIndex);
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_851125248; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_851125248 = varB4EAC82CA7396A68D541C85D26508E83_531966266;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_851125248 = varB4EAC82CA7396A68D541C85D26508E83_529190172;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_851125248.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_851125248;
        // ---------- Original Method ----------
        //int valueIndex = index * 2 + 1;
        //if (valueIndex < 0 || valueIndex >= namesAndValues.size()) {
            //return null;
        //}
        //return namesAndValues.get(valueIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.602 -0400", hash_original_method = "5CE86F73873B18464F6757EE122420F2", hash_generated_method = "BD9641321951D9A2D6748938B527F8B8")
    public String get(String fieldName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1386648343 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_507278717 = null; //Variable for return #2
        {
            int i;
            i = namesAndValues.size() - 2;
            i -= 2;
            {
                {
                    boolean var07383A2EA7E09819D63BC9504487D36B_526519364 = (fieldName.equalsIgnoreCase(namesAndValues.get(i)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1386648343 = namesAndValues.get(i + 1);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_507278717 = null;
        addTaint(fieldName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_935963529; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_935963529 = varB4EAC82CA7396A68D541C85D26508E83_1386648343;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_935963529 = varB4EAC82CA7396A68D541C85D26508E83_507278717;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_935963529.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_935963529;
        // ---------- Original Method ----------
        //for (int i = namesAndValues.size() - 2; i >= 0; i -= 2) {
            //if (fieldName.equalsIgnoreCase(namesAndValues.get(i))) {
                //return namesAndValues.get(i + 1);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.609 -0400", hash_original_method = "DFF30A75B51A172BE4172930F32BB680", hash_generated_method = "8ABD864C96CD5495C16E9CD352C10EB4")
    public RawHeaders getAll(Set<String> fieldNames) {
        RawHeaders varB4EAC82CA7396A68D541C85D26508E83_1212921078 = null; //Variable for return #1
        RawHeaders result;
        result = new RawHeaders();
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_1204562439 = (i < namesAndValues.size());
            i += 2;
            {
                String fieldName;
                fieldName = namesAndValues.get(i);
                {
                    boolean var4B7E45DB6A22ECBD6E888DAA24A0798E_1116966769 = (fieldNames.contains(fieldName));
                    {
                        result.add(fieldName, namesAndValues.get(i + 1));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1212921078 = result;
        addTaint(fieldNames.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1212921078.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1212921078;
        // ---------- Original Method ----------
        //RawHeaders result = new RawHeaders();
        //for (int i = 0; i < namesAndValues.size(); i += 2) {
            //String fieldName = namesAndValues.get(i);
            //if (fieldNames.contains(fieldName)) {
                //result.add(fieldName, namesAndValues.get(i + 1));
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.611 -0400", hash_original_method = "03F9E8D356406A137FAD06FB9E8EE371", hash_generated_method = "B3D5018F5867CACBA24E4393B231AF42")
    public String toHeaderString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1702765463 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(256);
        result.append(statusLine).append("\r\n");
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_667102139 = (i < namesAndValues.size());
            i += 2;
            {
                result.append(namesAndValues.get(i)).append(": ")
                    .append(namesAndValues.get(i + 1)).append("\r\n");
            } //End block
        } //End collapsed parenthetic
        result.append("\r\n");
        varB4EAC82CA7396A68D541C85D26508E83_1702765463 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1702765463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1702765463;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(256);
        //result.append(statusLine).append("\r\n");
        //for (int i = 0; i < namesAndValues.size(); i += 2) {
            //result.append(namesAndValues.get(i)).append(": ")
                    //.append(namesAndValues.get(i + 1)).append("\r\n");
        //}
        //result.append("\r\n");
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.614 -0400", hash_original_method = "08275C5AA7086D8C8C86CDE1903B0FA3", hash_generated_method = "37889AB36EB980349F25FDA567DDB0E3")
    public Map<String, List<String>> toMultimap() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_923532041 = null; //Variable for return #1
        Map<String, List<String>> result;
        result = new TreeMap<String, List<String>>(FIELD_NAME_COMPARATOR);
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_1818357045 = (i < namesAndValues.size());
            i += 2;
            {
                String fieldName;
                fieldName = namesAndValues.get(i);
                String value;
                value = namesAndValues.get(i + 1);
                List<String> allValues;
                allValues = new ArrayList<String>();
                List<String> otherValues;
                otherValues = result.get(fieldName);
                {
                    allValues.addAll(otherValues);
                } //End block
                allValues.add(value);
                result.put(fieldName, Collections.unmodifiableList(allValues));
            } //End block
        } //End collapsed parenthetic
        {
            result.put(null, Collections.unmodifiableList(Collections.singletonList(statusLine)));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_923532041 = Collections.unmodifiableMap(result);
        varB4EAC82CA7396A68D541C85D26508E83_923532041.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_923532041;
        // ---------- Original Method ----------
        //Map<String, List<String>> result = new TreeMap<String, List<String>>(FIELD_NAME_COMPARATOR);
        //for (int i = 0; i < namesAndValues.size(); i += 2) {
            //String fieldName = namesAndValues.get(i);
            //String value = namesAndValues.get(i + 1);
            //List<String> allValues = new ArrayList<String>();
            //List<String> otherValues = result.get(fieldName);
            //if (otherValues != null) {
                //allValues.addAll(otherValues);
            //}
            //allValues.add(value);
            //result.put(fieldName, Collections.unmodifiableList(allValues));
        //}
        //if (statusLine != null) {
            //result.put(null, Collections.unmodifiableList(Collections.singletonList(statusLine)));
        //}
        //return Collections.unmodifiableMap(result);
    }

    
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.615 -0400", hash_original_field = "FA7582AED8A9C6860ED135540F90AAFE", hash_generated_field = "908A27C1A04811BFF3213E515D42A4F5")

    private static Comparator<String> FIELD_NAME_COMPARATOR = new Comparator<String>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.615 -0400", hash_original_method = "97A4263BD250C85D737E56C91BCF9DB2", hash_generated_method = "9F47B407723E422B5411D30268C126E9")
        @FindBugsSuppressWarnings("ES_COMPARING_PARAMETER_STRING_WITH_EQ")
        @Override
        public int compare(String a, String b) {
            {
                int var19956D017C395B4AC52CA5B4F956ED43_693560445 = (String.CASE_INSENSITIVE_ORDER.compare(a, b));
            } //End block
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_648183653 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_648183653;
            // ---------- Original Method ----------
            //if (a == b) {
                //return 0;
            //} else if (a == null) {
                //return -1;
            //} else if (b == null) {
                //return 1;
            //} else {
                //return String.CASE_INSENSITIVE_ORDER.compare(a, b);
            //}
        }

        
};
}

