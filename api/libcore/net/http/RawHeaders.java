package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class RawHeaders {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.770 -0400", hash_original_field = "A8AC49EE300212F0188F86FAA3B8CBD3", hash_generated_field = "E294623D0BEE32E5166A91061EFF3F0C")

    private final List<String> namesAndValues = new ArrayList<String>(20);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.770 -0400", hash_original_field = "8462E9D9B0BB0450DAF299F1B5423B07", hash_generated_field = "3535C618FCAB072DA70F443EC8961E3F")

    private String statusLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.770 -0400", hash_original_field = "07D1830D3A4E5B468E0D442D6C3FC9AA", hash_generated_field = "518FD222D66780F6300863A063540421")

    private int httpMinorVersion = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.770 -0400", hash_original_field = "343D8113EC60F49B94DCB68676490D2B", hash_generated_field = "D785483FBB4763BBCFA08884D49686B0")

    private int responseCode = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.770 -0400", hash_original_field = "C1E66B2C48B6FCDFA45BCBEAB51F2D59", hash_generated_field = "F2C26AD99124E5993699C59ABECD857F")

    private String responseMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.770 -0400", hash_original_method = "29CBB7411AB87121F534DC6D89E1C3FF", hash_generated_method = "15AC6645C1F6E653E1857608E76C2802")
    public  RawHeaders() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.770 -0400", hash_original_method = "E9B27FF414EC11CE1087F7E174CD847B", hash_generated_method = "95DE4AF15A4442FE8EB3D1946076B466")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.771 -0400", hash_original_method = "A034EBBE3F64C8F074A3B6C276AAF223", hash_generated_method = "53BBC5EAF2223E6D82333D28EB55CCA0")
    public void setStatusLine(String statusLine) {
        statusLine = statusLine.trim();
        this.statusLine = statusLine;
        if(statusLine == null || !statusLine.startsWith("HTTP/"))        
        {
            return;
        } //End block
        statusLine = statusLine.trim();
        int mark = statusLine.indexOf(" ") + 1;
        if(mark == 0)        
        {
            return;
        } //End block
        if(statusLine.charAt(mark - 2) != '1')        
        {
            this.httpMinorVersion = 0;
        } //End block
        int last = mark + 3;
        if(last > statusLine.length())        
        {
            last = statusLine.length();
        } //End block
        this.responseCode = Integer.parseInt(statusLine.substring(mark, last));
        if(last + 1 <= statusLine.length())        
        {
            this.responseMessage = statusLine.substring(last + 1);
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.771 -0400", hash_original_method = "A2AF11C5A8C661AB11C9AC7FDCDD9C73", hash_generated_method = "EC27088EACF240CD2D91D95A8929AC3E")
    public String getStatusLine() {
String var85DBBD945A449462F4B20B9C5986C926_743252110 =         statusLine;
        var85DBBD945A449462F4B20B9C5986C926_743252110.addTaint(taint);
        return var85DBBD945A449462F4B20B9C5986C926_743252110;
        // ---------- Original Method ----------
        //return statusLine;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.771 -0400", hash_original_method = "DB8BE97BE5124EB81D65BC5698249D9B", hash_generated_method = "F06C6DF4DC16B09871CB267499A1D885")
    public int getHttpMinorVersion() {
        int varE3CB6BC3D26619CC09F2D62AAF1FEA4B_2074282202 = (httpMinorVersion != -1 ? httpMinorVersion : 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984625042 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984625042;
        // ---------- Original Method ----------
        //return httpMinorVersion != -1 ? httpMinorVersion : 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.771 -0400", hash_original_method = "9E4A5E9FF258EB24BD25F51C84D6D494", hash_generated_method = "4FFFEA648C011FD1F22318262DA341F7")
    public int getResponseCode() {
        int var30F8CC0A3AD81545F79B55CD4A8D8C8E_126774829 = (responseCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271605549 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271605549;
        // ---------- Original Method ----------
        //return responseCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.771 -0400", hash_original_method = "84763A1C87A993ECD4976A3E0463024E", hash_generated_method = "12FB2085749A72F0D9222D95CE44E946")
    public String getResponseMessage() {
String var0EA3F56E6B543F51FDF09BD18CE60D5C_1927636780 =         responseMessage;
        var0EA3F56E6B543F51FDF09BD18CE60D5C_1927636780.addTaint(taint);
        return var0EA3F56E6B543F51FDF09BD18CE60D5C_1927636780;
        // ---------- Original Method ----------
        //return responseMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.771 -0400", hash_original_method = "8393782C8F932A1D751AE7869AA4907E", hash_generated_method = "6140D26C8B40DBA2BC872D6468399173")
    public void addLine(String line) {
        addTaint(line.getTaint());
        int index = line.indexOf(":");
        if(index == -1)        
        {
            add("", line);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.772 -0400", hash_original_method = "438CB3F0D3B01507EC959AE5277C1434", hash_generated_method = "DDC9B4465874979E190F03898A5A5D34")
    public void add(String fieldName, String value) {
        addTaint(value.getTaint());
        addTaint(fieldName.getTaint());
        if(fieldName == null)        
        {
            IllegalArgumentException varD4DE986D44C47BB6F9B6066E40961F4F_1011995345 = new IllegalArgumentException("fieldName == null");
            varD4DE986D44C47BB6F9B6066E40961F4F_1011995345.addTaint(taint);
            throw varD4DE986D44C47BB6F9B6066E40961F4F_1011995345;
        } //End block
        if(value == null)        
        {
            System.logW("Ignoring HTTP header field '" + fieldName + "' because its value is null");
            return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.772 -0400", hash_original_method = "5C24A819593BC86E0E1AF9616F67E395", hash_generated_method = "63E7B39B3E6BB029B2052F0F8D7522D9")
    public void removeAll(String fieldName) {
        addTaint(fieldName.getTaint());
for(int i = 0;i < namesAndValues.size();i += 2)
        {
            if(fieldName.equalsIgnoreCase(namesAndValues.get(i)))            
            {
                namesAndValues.remove(i);
                namesAndValues.remove(i);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < namesAndValues.size(); i += 2) {
            //if (fieldName.equalsIgnoreCase(namesAndValues.get(i))) {
                //namesAndValues.remove(i); 
                //namesAndValues.remove(i); 
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.772 -0400", hash_original_method = "9CD3B49A68466D363A29D778884154B6", hash_generated_method = "E56F279295B60DA2DEDA4049B37E4A74")
    public void addAll(String fieldName, List<String> headerFields) {
        addTaint(headerFields.getTaint());
        addTaint(fieldName.getTaint());
for(String value : headerFields)
        {
            add(fieldName, value);
        } //End block
        // ---------- Original Method ----------
        //for (String value : headerFields) {
            //add(fieldName, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.772 -0400", hash_original_method = "A964C2ABDA70C3696494D217AFF90E69", hash_generated_method = "92D2E5804FB4736CE669F680A32EED68")
    public void set(String fieldName, String value) {
        addTaint(value.getTaint());
        addTaint(fieldName.getTaint());
        removeAll(fieldName);
        add(fieldName, value);
        // ---------- Original Method ----------
        //removeAll(fieldName);
        //add(fieldName, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.772 -0400", hash_original_method = "65DB99CA105C788DAB9FE23472075832", hash_generated_method = "97D66E6901F6A1EB466241D717CAC0A2")
    public int length() {
        int varE63A1D855242D8FF8D0BF3DDD621831D_1122249175 = (namesAndValues.size() / 2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294738724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294738724;
        // ---------- Original Method ----------
        //return namesAndValues.size() / 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.772 -0400", hash_original_method = "BE23DD7B1410D37DAEEAE51D9DBF75EB", hash_generated_method = "61BFDF3AFDC355427609C503EBF0D52F")
    public String getFieldName(int index) {
        addTaint(index);
        int fieldNameIndex = index * 2;
        if(fieldNameIndex < 0 || fieldNameIndex >= namesAndValues.size())        
        {
String var540C13E9E156B687226421B24F2DF178_239302755 =             null;
            var540C13E9E156B687226421B24F2DF178_239302755.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_239302755;
        } //End block
String var4C1162125A66AB3D5F5C1CB3ACCE21E2_787208004 =         namesAndValues.get(fieldNameIndex);
        var4C1162125A66AB3D5F5C1CB3ACCE21E2_787208004.addTaint(taint);
        return var4C1162125A66AB3D5F5C1CB3ACCE21E2_787208004;
        // ---------- Original Method ----------
        //int fieldNameIndex = index * 2;
        //if (fieldNameIndex < 0 || fieldNameIndex >= namesAndValues.size()) {
            //return null;
        //}
        //return namesAndValues.get(fieldNameIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.772 -0400", hash_original_method = "B22E5B19D625D7A351EC2F77115E183E", hash_generated_method = "A19C214080310B46FF1F4E595B9CEDE7")
    public String getValue(int index) {
        addTaint(index);
        int valueIndex = index * 2 + 1;
        if(valueIndex < 0 || valueIndex >= namesAndValues.size())        
        {
String var540C13E9E156B687226421B24F2DF178_1412911147 =             null;
            var540C13E9E156B687226421B24F2DF178_1412911147.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1412911147;
        } //End block
String varAB0AA5003D99383723C8D8C1BFF8E756_1890307359 =         namesAndValues.get(valueIndex);
        varAB0AA5003D99383723C8D8C1BFF8E756_1890307359.addTaint(taint);
        return varAB0AA5003D99383723C8D8C1BFF8E756_1890307359;
        // ---------- Original Method ----------
        //int valueIndex = index * 2 + 1;
        //if (valueIndex < 0 || valueIndex >= namesAndValues.size()) {
            //return null;
        //}
        //return namesAndValues.get(valueIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.773 -0400", hash_original_method = "5CE86F73873B18464F6757EE122420F2", hash_generated_method = "65B02AAB897ABDF53801667AF5108540")
    public String get(String fieldName) {
        addTaint(fieldName.getTaint());
for(int i = namesAndValues.size() - 2;i >= 0;i -= 2)
        {
            if(fieldName.equalsIgnoreCase(namesAndValues.get(i)))            
            {
String var0C3DC92EE3041149F898372E184451DD_98015921 =                 namesAndValues.get(i + 1);
                var0C3DC92EE3041149F898372E184451DD_98015921.addTaint(taint);
                return var0C3DC92EE3041149F898372E184451DD_98015921;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_1087392450 =         null;
        var540C13E9E156B687226421B24F2DF178_1087392450.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1087392450;
        // ---------- Original Method ----------
        //for (int i = namesAndValues.size() - 2; i >= 0; i -= 2) {
            //if (fieldName.equalsIgnoreCase(namesAndValues.get(i))) {
                //return namesAndValues.get(i + 1);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.773 -0400", hash_original_method = "DFF30A75B51A172BE4172930F32BB680", hash_generated_method = "E1985F5DE8DDAFB53B1D9B969886CD86")
    public RawHeaders getAll(Set<String> fieldNames) {
        addTaint(fieldNames.getTaint());
        RawHeaders result = new RawHeaders();
for(int i = 0;i < namesAndValues.size();i += 2)
        {
            String fieldName = namesAndValues.get(i);
            if(fieldNames.contains(fieldName))            
            {
                result.add(fieldName, namesAndValues.get(i + 1));
            } //End block
        } //End block
RawHeaders varDC838461EE2FA0CA4C9BBB70A15456B0_1829860698 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1829860698.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1829860698;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.773 -0400", hash_original_method = "03F9E8D356406A137FAD06FB9E8EE371", hash_generated_method = "6D20CA2BCBDE8504ABE85B3CE4F2BDA6")
    public String toHeaderString() {
        StringBuilder result = new StringBuilder(256);
        result.append(statusLine).append("\r\n");
for(int i = 0;i < namesAndValues.size();i += 2)
        {
            result.append(namesAndValues.get(i)).append(": ")
                    .append(namesAndValues.get(i + 1)).append("\r\n");
        } //End block
        result.append("\r\n");
String varE65B3A02759122992CB82C0E651AD408_124625034 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_124625034.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_124625034;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.773 -0400", hash_original_method = "08275C5AA7086D8C8C86CDE1903B0FA3", hash_generated_method = "D242E93772CC78E16AA2AC0345CDBE16")
    public Map<String, List<String>> toMultimap() {
        Map<String, List<String>> result = new TreeMap<String, List<String>>(FIELD_NAME_COMPARATOR);
for(int i = 0;i < namesAndValues.size();i += 2)
        {
            String fieldName = namesAndValues.get(i);
            String value = namesAndValues.get(i + 1);
            List<String> allValues = new ArrayList<String>();
            List<String> otherValues = result.get(fieldName);
            if(otherValues != null)            
            {
                allValues.addAll(otherValues);
            } //End block
            allValues.add(value);
            result.put(fieldName, Collections.unmodifiableList(allValues));
        } //End block
        if(statusLine != null)        
        {
            result.put(null, Collections.unmodifiableList(Collections.singletonList(statusLine)));
        } //End block
Map<String, List<String>> var7574B6F28DE66C39A71661FC6443DD41_1433241239 =         Collections.unmodifiableMap(result);
        var7574B6F28DE66C39A71661FC6443DD41_1433241239.addTaint(taint);
        return var7574B6F28DE66C39A71661FC6443DD41_1433241239;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.375 -0400", hash_original_field = "FA7582AED8A9C6860ED135540F90AAFE", hash_generated_field = "F018DC0E2BA01C80BAE5B1A83407ABAC")

    private static final Comparator<String> FIELD_NAME_COMPARATOR = new Comparator<String>() {        
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
}

