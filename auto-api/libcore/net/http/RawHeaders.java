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
    private List<String> namesAndValues = new ArrayList<String>(20);
    private String statusLine;
    private int httpMinorVersion = 1;
    private int responseCode = -1;
    private String responseMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.411 -0400", hash_original_method = "29CBB7411AB87121F534DC6D89E1C3FF", hash_generated_method = "15AC6645C1F6E653E1857608E76C2802")
    @DSModeled(DSC.SAFE)
    public RawHeaders() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.412 -0400", hash_original_method = "E9B27FF414EC11CE1087F7E174CD847B", hash_generated_method = "748B8E3BE3CD5A8CBFD6B8B70EE19CDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RawHeaders(RawHeaders copyFrom) {
        dsTaint.addTaint(copyFrom.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.413 -0400", hash_original_method = "A034EBBE3F64C8F074A3B6C276AAF223", hash_generated_method = "4C6CB0E3A5DD67C71D68B46AC93D547D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStatusLine(String statusLine) {
        dsTaint.addTaint(statusLine);
        statusLine = statusLine.trim();
        {
            boolean varA9C46BADA067E1986BD6C750A900233A_299429875 = (statusLine == null || !statusLine.startsWith("HTTP/"));
        } //End collapsed parenthetic
        statusLine = statusLine.trim();
        int mark;
        mark = statusLine.indexOf(" ") + 1;
        {
            boolean var9BD0A0F1BC978600B99C117EF2818F7C_470392226 = (statusLine.charAt(mark - 2) != '1');
            {
                this.httpMinorVersion = 0;
            } //End block
        } //End collapsed parenthetic
        int last;
        last = mark + 3;
        {
            boolean varFA7F7DD24A01CC7A9339145112306A40_887795328 = (last > statusLine.length());
            {
                last = statusLine.length();
            } //End block
        } //End collapsed parenthetic
        this.responseCode = Integer.parseInt(statusLine.substring(mark, last));
        {
            boolean var4DCC4C385B63926BC6BDB6FBEDBB6BFA_70428151 = (last + 1 <= statusLine.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.413 -0400", hash_original_method = "A2AF11C5A8C661AB11C9AC7FDCDD9C73", hash_generated_method = "E9FEAF55C84E4E7D5BC9B26031F7A893")
    @DSModeled(DSC.SAFE)
    public String getStatusLine() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return statusLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.413 -0400", hash_original_method = "DB8BE97BE5124EB81D65BC5698249D9B", hash_generated_method = "5DB8A592BFD6289E6A803B358AE4B26F")
    @DSModeled(DSC.SAFE)
    public int getHttpMinorVersion() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return httpMinorVersion != -1 ? httpMinorVersion : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.413 -0400", hash_original_method = "9E4A5E9FF258EB24BD25F51C84D6D494", hash_generated_method = "498C3A0C4C7FD2265888901BB929D8AF")
    @DSModeled(DSC.SAFE)
    public int getResponseCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return responseCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.413 -0400", hash_original_method = "84763A1C87A993ECD4976A3E0463024E", hash_generated_method = "6EEAEDBF9720368D198A3CC1DF626679")
    @DSModeled(DSC.SAFE)
    public String getResponseMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return responseMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.413 -0400", hash_original_method = "8393782C8F932A1D751AE7869AA4907E", hash_generated_method = "1A6647374A3935F9D45951B41D317F16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addLine(String line) {
        dsTaint.addTaint(line);
        int index;
        index = line.indexOf(":");
        {
            add("", line);
        } //End block
        {
            add(line.substring(0, index), line.substring(index + 1));
        } //End block
        // ---------- Original Method ----------
        //int index = line.indexOf(":");
        //if (index == -1) {
            //add("", line);
        //} else {
            //add(line.substring(0, index), line.substring(index + 1));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.414 -0400", hash_original_method = "438CB3F0D3B01507EC959AE5277C1434", hash_generated_method = "1F9773A5B50D287309B0606B5A81AEE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void add(String fieldName, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(fieldName);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("fieldName == null");
        } //End block
        {
            System.logW("Ignoring HTTP header field '" + fieldName + "' because its value is null");
        } //End block
        namesAndValues.add(fieldName);
        namesAndValues.add(value.trim());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.414 -0400", hash_original_method = "5C24A819593BC86E0E1AF9616F67E395", hash_generated_method = "C66D96BE8476E1D7AFBD0A779F7B0AAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAll(String fieldName) {
        dsTaint.addTaint(fieldName);
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_1736906124 = (i < namesAndValues.size());
            i += 2;
            {
                {
                    boolean var07383A2EA7E09819D63BC9504487D36B_1432826639 = (fieldName.equalsIgnoreCase(namesAndValues.get(i)));
                    {
                        namesAndValues.remove(i);
                        namesAndValues.remove(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < namesAndValues.size(); i += 2) {
            //if (fieldName.equalsIgnoreCase(namesAndValues.get(i))) {
                //namesAndValues.remove(i); 
                //namesAndValues.remove(i); 
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.416 -0400", hash_original_method = "9CD3B49A68466D363A29D778884154B6", hash_generated_method = "A0B8569D682FFD5F5FD8BEAFFE5F6A38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addAll(String fieldName, List<String> headerFields) {
        dsTaint.addTaint(headerFields.dsTaint);
        dsTaint.addTaint(fieldName);
        {
            Iterator<String> var93BDB38381E029428E418BBDBD1DCEC0_1053072114 = (headerFields).iterator();
            var93BDB38381E029428E418BBDBD1DCEC0_1053072114.hasNext();
            String value = var93BDB38381E029428E418BBDBD1DCEC0_1053072114.next();
            {
                add(fieldName, value);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (String value : headerFields) {
            //add(fieldName, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.417 -0400", hash_original_method = "A964C2ABDA70C3696494D217AFF90E69", hash_generated_method = "CEBAC57EFE1C9055B9CB023B2142BF36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(String fieldName, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(fieldName);
        removeAll(fieldName);
        add(fieldName, value);
        // ---------- Original Method ----------
        //removeAll(fieldName);
        //add(fieldName, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.418 -0400", hash_original_method = "65DB99CA105C788DAB9FE23472075832", hash_generated_method = "951CA5A1ADC1FD2D09AD5FE5DD42D74A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int length() {
        int varBF8405D4CE29AD74DBF95C13A527B3F8_1340106995 = (namesAndValues.size() / 2);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return namesAndValues.size() / 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.418 -0400", hash_original_method = "BE23DD7B1410D37DAEEAE51D9DBF75EB", hash_generated_method = "2BD27AFDC48101E4ACD2BFF90C32EC53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getFieldName(int index) {
        dsTaint.addTaint(index);
        int fieldNameIndex;
        fieldNameIndex = index * 2;
        {
            boolean var0CDCF141294AFA070787D3560D1BE49E_1710921150 = (fieldNameIndex < 0 || fieldNameIndex >= namesAndValues.size());
        } //End collapsed parenthetic
        String varF2CE2054142E2253844C722879C30B48_1552421467 = (namesAndValues.get(fieldNameIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int fieldNameIndex = index * 2;
        //if (fieldNameIndex < 0 || fieldNameIndex >= namesAndValues.size()) {
            //return null;
        //}
        //return namesAndValues.get(fieldNameIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.419 -0400", hash_original_method = "B22E5B19D625D7A351EC2F77115E183E", hash_generated_method = "62E53D8BB7E23702EED8113C67C2A157")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue(int index) {
        dsTaint.addTaint(index);
        int valueIndex;
        valueIndex = index * 2 + 1;
        {
            boolean varD4BC9792B49DEC02A6CF8EBEDA36396C_1223037112 = (valueIndex < 0 || valueIndex >= namesAndValues.size());
        } //End collapsed parenthetic
        String var57BDE892AD1EC58791B89014E10A76FD_1174056931 = (namesAndValues.get(valueIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int valueIndex = index * 2 + 1;
        //if (valueIndex < 0 || valueIndex >= namesAndValues.size()) {
            //return null;
        //}
        //return namesAndValues.get(valueIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.419 -0400", hash_original_method = "5CE86F73873B18464F6757EE122420F2", hash_generated_method = "233A68CA578A278163E52E5148F6C999")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String get(String fieldName) {
        dsTaint.addTaint(fieldName);
        {
            int i;
            i = namesAndValues.size() - 2;
            i -= 2;
            {
                {
                    boolean var07383A2EA7E09819D63BC9504487D36B_1963345628 = (fieldName.equalsIgnoreCase(namesAndValues.get(i)));
                    {
                        String var6188FF4E331AF890FF58B2EF7D460483_997706082 = (namesAndValues.get(i + 1));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //for (int i = namesAndValues.size() - 2; i >= 0; i -= 2) {
            //if (fieldName.equalsIgnoreCase(namesAndValues.get(i))) {
                //return namesAndValues.get(i + 1);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.419 -0400", hash_original_method = "DFF30A75B51A172BE4172930F32BB680", hash_generated_method = "47EFC3BB1561546150D593716BEA4FC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RawHeaders getAll(Set<String> fieldNames) {
        dsTaint.addTaint(fieldNames.dsTaint);
        RawHeaders result;
        result = new RawHeaders();
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_1523992478 = (i < namesAndValues.size());
            i += 2;
            {
                String fieldName;
                fieldName = namesAndValues.get(i);
                {
                    boolean var4B7E45DB6A22ECBD6E888DAA24A0798E_734835175 = (fieldNames.contains(fieldName));
                    {
                        result.add(fieldName, namesAndValues.get(i + 1));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (RawHeaders)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.420 -0400", hash_original_method = "03F9E8D356406A137FAD06FB9E8EE371", hash_generated_method = "63767D04A4C071DD941EC026558E7167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toHeaderString() {
        StringBuilder result;
        result = new StringBuilder(256);
        result.append(statusLine).append("\r\n");
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_75626290 = (i < namesAndValues.size());
            i += 2;
            {
                result.append(namesAndValues.get(i)).append(": ")
                    .append(namesAndValues.get(i + 1)).append("\r\n");
            } //End block
        } //End collapsed parenthetic
        result.append("\r\n");
        String varEA70154FDA28CC59402440C6317B57EF_5423971 = (result.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.420 -0400", hash_original_method = "08275C5AA7086D8C8C86CDE1903B0FA3", hash_generated_method = "94E307D82445535F3D79F5242E6D0A36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Map<String, List<String>> toMultimap() {
        Map<String, List<String>> result;
        result = new TreeMap<String, List<String>>(FIELD_NAME_COMPARATOR);
        {
            int i;
            i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_1024762083 = (i < namesAndValues.size());
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
        Map<String, List<String>> varD884F2259BBA159042604EBF139680A2_125203013 = (Collections.unmodifiableMap(result));
        return (Map<String, List<String>>)dsTaint.getTaint();
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

    
    private static final Comparator<String> FIELD_NAME_COMPARATOR = new Comparator<String>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.420 -0400", hash_original_method = "97A4263BD250C85D737E56C91BCF9DB2", hash_generated_method = "3745C935F9FEE9B5F5121E6070BE9BAA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @FindBugsSuppressWarnings("ES_COMPARING_PARAMETER_STRING_WITH_EQ")
        @Override
        public int compare(String a, String b) {
            dsTaint.addTaint(b);
            dsTaint.addTaint(a);
            {
                int var19956D017C395B4AC52CA5B4F956ED43_1284660706 = (String.CASE_INSENSITIVE_ORDER.compare(a, b));
            } //End block
            return dsTaint.getTaintInt();
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

        
}; //Transformed anonymous class
}

