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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.829 -0400", hash_original_field = "A8AC49EE300212F0188F86FAA3B8CBD3", hash_generated_field = "52C80FFB7641F86E69CE98F5BFE61C2A")

    private List<String> namesAndValues = new ArrayList<String>(20);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.830 -0400", hash_original_field = "8462E9D9B0BB0450DAF299F1B5423B07", hash_generated_field = "3535C618FCAB072DA70F443EC8961E3F")

    private String statusLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.830 -0400", hash_original_field = "07D1830D3A4E5B468E0D442D6C3FC9AA", hash_generated_field = "518FD222D66780F6300863A063540421")

    private int httpMinorVersion = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.830 -0400", hash_original_field = "343D8113EC60F49B94DCB68676490D2B", hash_generated_field = "D785483FBB4763BBCFA08884D49686B0")

    private int responseCode = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.830 -0400", hash_original_field = "C1E66B2C48B6FCDFA45BCBEAB51F2D59", hash_generated_field = "F2C26AD99124E5993699C59ABECD857F")

    private String responseMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.830 -0400", hash_original_method = "29CBB7411AB87121F534DC6D89E1C3FF", hash_generated_method = "15AC6645C1F6E653E1857608E76C2802")
    public  RawHeaders() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.830 -0400", hash_original_method = "E9B27FF414EC11CE1087F7E174CD847B", hash_generated_method = "95DE4AF15A4442FE8EB3D1946076B466")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.835 -0400", hash_original_method = "A034EBBE3F64C8F074A3B6C276AAF223", hash_generated_method = "8A3326861438AD8BDA0C7C0D801BB478")
    public void setStatusLine(String statusLine) {
        statusLine = statusLine.trim();
        this.statusLine = statusLine;
        {
            boolean varA9C46BADA067E1986BD6C750A900233A_273550645 = (statusLine == null || !statusLine.startsWith("HTTP/"));
        } //End collapsed parenthetic
        statusLine = statusLine.trim();
        int mark;
        mark = statusLine.indexOf(" ") + 1;
        {
            boolean var9BD0A0F1BC978600B99C117EF2818F7C_574268215 = (statusLine.charAt(mark - 2) != '1');
            {
                this.httpMinorVersion = 0;
            } //End block
        } //End collapsed parenthetic
        int last;
        last = mark + 3;
        {
            boolean varFA7F7DD24A01CC7A9339145112306A40_1121433995 = (last > statusLine.length());
            {
                last = statusLine.length();
            } //End block
        } //End collapsed parenthetic
        this.responseCode = Integer.parseInt(statusLine.substring(mark, last));
        {
            boolean var4DCC4C385B63926BC6BDB6FBEDBB6BFA_1614988816 = (last + 1 <= statusLine.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.846 -0400", hash_original_method = "A2AF11C5A8C661AB11C9AC7FDCDD9C73", hash_generated_method = "04FB5495697C162E1E6229B3766031FC")
    public String getStatusLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_295946002 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_295946002 = statusLine;
        varB4EAC82CA7396A68D541C85D26508E83_295946002.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_295946002;
        // ---------- Original Method ----------
        //return statusLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.846 -0400", hash_original_method = "DB8BE97BE5124EB81D65BC5698249D9B", hash_generated_method = "4960CD0AAC48F396861DA867391AF5C4")
    public int getHttpMinorVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704094445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704094445;
        // ---------- Original Method ----------
        //return httpMinorVersion != -1 ? httpMinorVersion : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.847 -0400", hash_original_method = "9E4A5E9FF258EB24BD25F51C84D6D494", hash_generated_method = "CE4F49A1042A58791F0ACF5AB95573D7")
    public int getResponseCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699239570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699239570;
        // ---------- Original Method ----------
        //return responseCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.847 -0400", hash_original_method = "84763A1C87A993ECD4976A3E0463024E", hash_generated_method = "75276F26FD0B286EB034FD26011ACA6A")
    public String getResponseMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1825361998 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1825361998 = responseMessage;
        varB4EAC82CA7396A68D541C85D26508E83_1825361998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1825361998;
        // ---------- Original Method ----------
        //return responseMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.848 -0400", hash_original_method = "8393782C8F932A1D751AE7869AA4907E", hash_generated_method = "8E1A738929E928FBC57F4C559A6AF8FF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.849 -0400", hash_original_method = "438CB3F0D3B01507EC959AE5277C1434", hash_generated_method = "0F73363E6F7EEB6D7D546DD2ECCC66F6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.851 -0400", hash_original_method = "5C24A819593BC86E0E1AF9616F67E395", hash_generated_method = "B4A719EDD868DCDD3D92DB2D80C2CB04")
    public void removeAll(String fieldName) {
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_1993128501 = (i < namesAndValues.size());
            i += 2;
            {
                {
                    boolean var07383A2EA7E09819D63BC9504487D36B_931770254 = (fieldName.equalsIgnoreCase(namesAndValues.get(i)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.863 -0400", hash_original_method = "9CD3B49A68466D363A29D778884154B6", hash_generated_method = "359C599EE9223CA32B8553D082CF9F7A")
    public void addAll(String fieldName, List<String> headerFields) {
        {
            Iterator<String> var93BDB38381E029428E418BBDBD1DCEC0_1332354901 = (headerFields).iterator();
            var93BDB38381E029428E418BBDBD1DCEC0_1332354901.hasNext();
            String value = var93BDB38381E029428E418BBDBD1DCEC0_1332354901.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.870 -0400", hash_original_method = "A964C2ABDA70C3696494D217AFF90E69", hash_generated_method = "4ED30F4242025EEA85D5604136F4A214")
    public void set(String fieldName, String value) {
        removeAll(fieldName);
        add(fieldName, value);
        addTaint(fieldName.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //removeAll(fieldName);
        //add(fieldName, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.870 -0400", hash_original_method = "65DB99CA105C788DAB9FE23472075832", hash_generated_method = "A7127D30F4B13EE317CFB4144106F566")
    public int length() {
        int varBF8405D4CE29AD74DBF95C13A527B3F8_1415356354 = (namesAndValues.size() / 2);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627344701 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627344701;
        // ---------- Original Method ----------
        //return namesAndValues.size() / 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.874 -0400", hash_original_method = "BE23DD7B1410D37DAEEAE51D9DBF75EB", hash_generated_method = "6B3E9F6A17692F230289B81271E17B63")
    public String getFieldName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1875460857 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1468388958 = null; //Variable for return #2
        int fieldNameIndex;
        fieldNameIndex = index * 2;
        {
            boolean var0CDCF141294AFA070787D3560D1BE49E_1549919139 = (fieldNameIndex < 0 || fieldNameIndex >= namesAndValues.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1875460857 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1468388958 = namesAndValues.get(fieldNameIndex);
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_249986866; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_249986866 = varB4EAC82CA7396A68D541C85D26508E83_1875460857;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_249986866 = varB4EAC82CA7396A68D541C85D26508E83_1468388958;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_249986866.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_249986866;
        // ---------- Original Method ----------
        //int fieldNameIndex = index * 2;
        //if (fieldNameIndex < 0 || fieldNameIndex >= namesAndValues.size()) {
            //return null;
        //}
        //return namesAndValues.get(fieldNameIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.875 -0400", hash_original_method = "B22E5B19D625D7A351EC2F77115E183E", hash_generated_method = "5473686AF5E48DE43B9E0E388610601D")
    public String getValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1735369770 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_965418670 = null; //Variable for return #2
        int valueIndex;
        valueIndex = index * 2 + 1;
        {
            boolean varD4BC9792B49DEC02A6CF8EBEDA36396C_1849241282 = (valueIndex < 0 || valueIndex >= namesAndValues.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1735369770 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_965418670 = namesAndValues.get(valueIndex);
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1597196670; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1597196670 = varB4EAC82CA7396A68D541C85D26508E83_1735369770;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1597196670 = varB4EAC82CA7396A68D541C85D26508E83_965418670;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1597196670.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1597196670;
        // ---------- Original Method ----------
        //int valueIndex = index * 2 + 1;
        //if (valueIndex < 0 || valueIndex >= namesAndValues.size()) {
            //return null;
        //}
        //return namesAndValues.get(valueIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.920 -0400", hash_original_method = "5CE86F73873B18464F6757EE122420F2", hash_generated_method = "5F205A5B2B1C787DBE7852C28EB617D3")
    public String get(String fieldName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1477190229 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_635874586 = null; //Variable for return #2
        {
            int i;
            i = namesAndValues.size() - 2;
            i -= 2;
            {
                {
                    boolean var07383A2EA7E09819D63BC9504487D36B_1055617110 = (fieldName.equalsIgnoreCase(namesAndValues.get(i)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1477190229 = namesAndValues.get(i + 1);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_635874586 = null;
        addTaint(fieldName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1812593337; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1812593337 = varB4EAC82CA7396A68D541C85D26508E83_1477190229;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1812593337 = varB4EAC82CA7396A68D541C85D26508E83_635874586;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1812593337.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1812593337;
        // ---------- Original Method ----------
        //for (int i = namesAndValues.size() - 2; i >= 0; i -= 2) {
            //if (fieldName.equalsIgnoreCase(namesAndValues.get(i))) {
                //return namesAndValues.get(i + 1);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.927 -0400", hash_original_method = "DFF30A75B51A172BE4172930F32BB680", hash_generated_method = "19AC78889A685475F3D9EE2D61B56F5B")
    public RawHeaders getAll(Set<String> fieldNames) {
        RawHeaders varB4EAC82CA7396A68D541C85D26508E83_230581489 = null; //Variable for return #1
        RawHeaders result;
        result = new RawHeaders();
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_450438229 = (i < namesAndValues.size());
            i += 2;
            {
                String fieldName;
                fieldName = namesAndValues.get(i);
                {
                    boolean var4B7E45DB6A22ECBD6E888DAA24A0798E_485438780 = (fieldNames.contains(fieldName));
                    {
                        result.add(fieldName, namesAndValues.get(i + 1));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_230581489 = result;
        addTaint(fieldNames.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_230581489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_230581489;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.936 -0400", hash_original_method = "03F9E8D356406A137FAD06FB9E8EE371", hash_generated_method = "917F9CB0D117ABB075469450E0EE7486")
    public String toHeaderString() {
        String varB4EAC82CA7396A68D541C85D26508E83_901052423 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(256);
        result.append(statusLine).append("\r\n");
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_676474962 = (i < namesAndValues.size());
            i += 2;
            {
                result.append(namesAndValues.get(i)).append(": ")
                    .append(namesAndValues.get(i + 1)).append("\r\n");
            } //End block
        } //End collapsed parenthetic
        result.append("\r\n");
        varB4EAC82CA7396A68D541C85D26508E83_901052423 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_901052423.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_901052423;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.942 -0400", hash_original_method = "08275C5AA7086D8C8C86CDE1903B0FA3", hash_generated_method = "1E55D454C550F96FD1D4C50A6B3B2690")
    public Map<String, List<String>> toMultimap() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_818175319 = null; //Variable for return #1
        Map<String, List<String>> result;
        result = new TreeMap<String, List<String>>(FIELD_NAME_COMPARATOR);
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_1353510299 = (i < namesAndValues.size());
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
        varB4EAC82CA7396A68D541C85D26508E83_818175319 = Collections.unmodifiableMap(result);
        varB4EAC82CA7396A68D541C85D26508E83_818175319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_818175319;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.952 -0400", hash_original_field = "FA7582AED8A9C6860ED135540F90AAFE", hash_generated_field = "6E24EF1C66A251A95419C8D04A1828B8")

    private static Comparator<String> FIELD_NAME_COMPARATOR = new Comparator<String>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.952 -0400", hash_original_method = "97A4263BD250C85D737E56C91BCF9DB2", hash_generated_method = "B5BA3B048460956818F956DE41D3923A")
        @FindBugsSuppressWarnings("ES_COMPARING_PARAMETER_STRING_WITH_EQ")
        @Override
        public int compare(String a, String b) {
            {
                int var19956D017C395B4AC52CA5B4F956ED43_477157959 = (String.CASE_INSENSITIVE_ORDER.compare(a, b));
            } //End block
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1299650531 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1299650531;
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

