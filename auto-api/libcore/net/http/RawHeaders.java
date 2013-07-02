package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.363 -0400", hash_original_field = "A8AC49EE300212F0188F86FAA3B8CBD3", hash_generated_field = "E294623D0BEE32E5166A91061EFF3F0C")

    private final List<String> namesAndValues = new ArrayList<String>(20);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.363 -0400", hash_original_field = "8462E9D9B0BB0450DAF299F1B5423B07", hash_generated_field = "3535C618FCAB072DA70F443EC8961E3F")

    private String statusLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.363 -0400", hash_original_field = "07D1830D3A4E5B468E0D442D6C3FC9AA", hash_generated_field = "518FD222D66780F6300863A063540421")

    private int httpMinorVersion = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.363 -0400", hash_original_field = "343D8113EC60F49B94DCB68676490D2B", hash_generated_field = "D785483FBB4763BBCFA08884D49686B0")

    private int responseCode = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.363 -0400", hash_original_field = "C1E66B2C48B6FCDFA45BCBEAB51F2D59", hash_generated_field = "F2C26AD99124E5993699C59ABECD857F")

    private String responseMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.363 -0400", hash_original_method = "29CBB7411AB87121F534DC6D89E1C3FF", hash_generated_method = "15AC6645C1F6E653E1857608E76C2802")
    public  RawHeaders() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.363 -0400", hash_original_method = "E9B27FF414EC11CE1087F7E174CD847B", hash_generated_method = "95DE4AF15A4442FE8EB3D1946076B466")
    public  RawHeaders(RawHeaders copyFrom) {
        namesAndValues.addAll(copyFrom.namesAndValues);
        statusLine = copyFrom.statusLine;
        httpMinorVersion = copyFrom.httpMinorVersion;
        responseCode = copyFrom.responseCode;
        responseMessage = copyFrom.responseMessage;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.364 -0400", hash_original_method = "A034EBBE3F64C8F074A3B6C276AAF223", hash_generated_method = "EDBA356034F27AD6A178E4348FDEB000")
    public void setStatusLine(String statusLine) {
        statusLine = statusLine.trim();
        this.statusLine = statusLine;
        {
            boolean varA9C46BADA067E1986BD6C750A900233A_1965115974 = (statusLine == null || !statusLine.startsWith("HTTP/"));
        } 
        statusLine = statusLine.trim();
        int mark = statusLine.indexOf(" ") + 1;
        {
            boolean var9BD0A0F1BC978600B99C117EF2818F7C_765709247 = (statusLine.charAt(mark - 2) != '1');
            {
                this.httpMinorVersion = 0;
            } 
        } 
        int last = mark + 3;
        {
            boolean varFA7F7DD24A01CC7A9339145112306A40_798322342 = (last > statusLine.length());
            {
                last = statusLine.length();
            } 
        } 
        this.responseCode = Integer.parseInt(statusLine.substring(mark, last));
        {
            boolean var4DCC4C385B63926BC6BDB6FBEDBB6BFA_1473272576 = (last + 1 <= statusLine.length());
            {
                this.responseMessage = statusLine.substring(last + 1);
            } 
        } 
        
        
        
        
            
        
        
        
        
            
        
        
            
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.365 -0400", hash_original_method = "A2AF11C5A8C661AB11C9AC7FDCDD9C73", hash_generated_method = "CDD42C0EA70D694FBE5DA0A4E5EE6C7B")
    public String getStatusLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1962484270 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1962484270 = statusLine;
        varB4EAC82CA7396A68D541C85D26508E83_1962484270.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1962484270;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.365 -0400", hash_original_method = "DB8BE97BE5124EB81D65BC5698249D9B", hash_generated_method = "432AB2AFC794BA7A27DBA0F182A7AD37")
    public int getHttpMinorVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798960957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798960957;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.365 -0400", hash_original_method = "9E4A5E9FF258EB24BD25F51C84D6D494", hash_generated_method = "7CCD45934791980CA96478E3E34CC5BF")
    public int getResponseCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257883827 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257883827;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.365 -0400", hash_original_method = "84763A1C87A993ECD4976A3E0463024E", hash_generated_method = "FCA1D51799F78492175299B42ABC8E16")
    public String getResponseMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_2115850207 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2115850207 = responseMessage;
        varB4EAC82CA7396A68D541C85D26508E83_2115850207.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2115850207;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.366 -0400", hash_original_method = "8393782C8F932A1D751AE7869AA4907E", hash_generated_method = "A8E6ACF8FE3BFCF72973AF5B17EC389D")
    public void addLine(String line) {
        int index = line.indexOf(":");
        {
            add("", line);
        } 
        {
            add(line.substring(0, index), line.substring(index + 1));
        } 
        addTaint(line.getTaint());
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.366 -0400", hash_original_method = "438CB3F0D3B01507EC959AE5277C1434", hash_generated_method = "0F73363E6F7EEB6D7D546DD2ECCC66F6")
    public void add(String fieldName, String value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("fieldName == null");
        } 
        {
            System.logW("Ignoring HTTP header field '" + fieldName + "' because its value is null");
        } 
        namesAndValues.add(fieldName);
        namesAndValues.add(value.trim());
        addTaint(fieldName.getTaint());
        addTaint(value.getTaint());
        
        
            
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.367 -0400", hash_original_method = "5C24A819593BC86E0E1AF9616F67E395", hash_generated_method = "B4DBFB5B46A4F513326911F6D650F0F9")
    public void removeAll(String fieldName) {
        {
            int i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_321450884 = (i < namesAndValues.size());
            i += 2;
            {
                {
                    boolean var07383A2EA7E09819D63BC9504487D36B_1526725823 = (fieldName.equalsIgnoreCase(namesAndValues.get(i)));
                    {
                        namesAndValues.remove(i);
                        namesAndValues.remove(i);
                    } 
                } 
            } 
        } 
        addTaint(fieldName.getTaint());
        
        
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.370 -0400", hash_original_method = "9CD3B49A68466D363A29D778884154B6", hash_generated_method = "88CEBDE859036351EDE6D47D145D1BD8")
    public void addAll(String fieldName, List<String> headerFields) {
        {
            Iterator<String> var93BDB38381E029428E418BBDBD1DCEC0_1863509099 = (headerFields).iterator();
            var93BDB38381E029428E418BBDBD1DCEC0_1863509099.hasNext();
            String value = var93BDB38381E029428E418BBDBD1DCEC0_1863509099.next();
            {
                add(fieldName, value);
            } 
        } 
        addTaint(fieldName.getTaint());
        addTaint(headerFields.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.371 -0400", hash_original_method = "A964C2ABDA70C3696494D217AFF90E69", hash_generated_method = "4ED30F4242025EEA85D5604136F4A214")
    public void set(String fieldName, String value) {
        removeAll(fieldName);
        add(fieldName, value);
        addTaint(fieldName.getTaint());
        addTaint(value.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.371 -0400", hash_original_method = "65DB99CA105C788DAB9FE23472075832", hash_generated_method = "EBEF7D41C7B0DF8F6F26CDB8AC07A3AF")
    public int length() {
        int varBF8405D4CE29AD74DBF95C13A527B3F8_1766841556 = (namesAndValues.size() / 2);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280537504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280537504;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.371 -0400", hash_original_method = "BE23DD7B1410D37DAEEAE51D9DBF75EB", hash_generated_method = "CF0C58251B591C864BAC2EE4D7588857")
    public String getFieldName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_260542381 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1898857669 = null; 
        int fieldNameIndex = index * 2;
        {
            boolean var0CDCF141294AFA070787D3560D1BE49E_908345052 = (fieldNameIndex < 0 || fieldNameIndex >= namesAndValues.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_260542381 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1898857669 = namesAndValues.get(fieldNameIndex);
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1808108677; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1808108677 = varB4EAC82CA7396A68D541C85D26508E83_260542381;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1808108677 = varB4EAC82CA7396A68D541C85D26508E83_1898857669;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1808108677.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1808108677;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.372 -0400", hash_original_method = "B22E5B19D625D7A351EC2F77115E183E", hash_generated_method = "E08112121124AECD66A89DA67EF64679")
    public String getValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_534996389 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_469190576 = null; 
        int valueIndex = index * 2 + 1;
        {
            boolean varD4BC9792B49DEC02A6CF8EBEDA36396C_1738662232 = (valueIndex < 0 || valueIndex >= namesAndValues.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_534996389 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_469190576 = namesAndValues.get(valueIndex);
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1973141435; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1973141435 = varB4EAC82CA7396A68D541C85D26508E83_534996389;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1973141435 = varB4EAC82CA7396A68D541C85D26508E83_469190576;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1973141435.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1973141435;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.372 -0400", hash_original_method = "5CE86F73873B18464F6757EE122420F2", hash_generated_method = "72C70390BF008C4294217FB1BFD310DB")
    public String get(String fieldName) {
        String varB4EAC82CA7396A68D541C85D26508E83_641920140 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1907451771 = null; 
        {
            int i = namesAndValues.size() - 2;
            i -= 2;
            {
                {
                    boolean var07383A2EA7E09819D63BC9504487D36B_880625112 = (fieldName.equalsIgnoreCase(namesAndValues.get(i)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_641920140 = namesAndValues.get(i + 1);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1907451771 = null;
        addTaint(fieldName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_926796866; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_926796866 = varB4EAC82CA7396A68D541C85D26508E83_641920140;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_926796866 = varB4EAC82CA7396A68D541C85D26508E83_1907451771;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_926796866.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_926796866;
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.373 -0400", hash_original_method = "DFF30A75B51A172BE4172930F32BB680", hash_generated_method = "F8CFFF5954376838F0FE4E070E06BAF7")
    public RawHeaders getAll(Set<String> fieldNames) {
        RawHeaders varB4EAC82CA7396A68D541C85D26508E83_134216017 = null; 
        RawHeaders result = new RawHeaders();
        {
            int i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_255755409 = (i < namesAndValues.size());
            i += 2;
            {
                String fieldName = namesAndValues.get(i);
                {
                    boolean var4B7E45DB6A22ECBD6E888DAA24A0798E_1553398272 = (fieldNames.contains(fieldName));
                    {
                        result.add(fieldName, namesAndValues.get(i + 1));
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_134216017 = result;
        addTaint(fieldNames.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_134216017.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_134216017;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.374 -0400", hash_original_method = "03F9E8D356406A137FAD06FB9E8EE371", hash_generated_method = "9B26B4369031A08A6A45497137552D94")
    public String toHeaderString() {
        String varB4EAC82CA7396A68D541C85D26508E83_964089485 = null; 
        StringBuilder result = new StringBuilder(256);
        result.append(statusLine).append("\r\n");
        {
            int i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_2002194075 = (i < namesAndValues.size());
            i += 2;
            {
                result.append(namesAndValues.get(i)).append(": ")
                    .append(namesAndValues.get(i + 1)).append("\r\n");
            } 
        } 
        result.append("\r\n");
        varB4EAC82CA7396A68D541C85D26508E83_964089485 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_964089485.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_964089485;
        
        
        
        
            
                    
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.374 -0400", hash_original_method = "08275C5AA7086D8C8C86CDE1903B0FA3", hash_generated_method = "04A607676309FBAEABC3A4CB86533542")
    public Map<String, List<String>> toMultimap() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_546309983 = null; 
        Map<String, List<String>> result = new TreeMap<String, List<String>>(FIELD_NAME_COMPARATOR);
        {
            int i = 0;
            boolean var40AC02F226E5D6206D3414E2A02E0412_93823062 = (i < namesAndValues.size());
            i += 2;
            {
                String fieldName = namesAndValues.get(i);
                String value = namesAndValues.get(i + 1);
                List<String> allValues = new ArrayList<String>();
                List<String> otherValues = result.get(fieldName);
                {
                    allValues.addAll(otherValues);
                } 
                allValues.add(value);
                result.put(fieldName, Collections.unmodifiableList(allValues));
            } 
        } 
        {
            result.put(null, Collections.unmodifiableList(Collections.singletonList(statusLine)));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_546309983 = Collections.unmodifiableMap(result);
        varB4EAC82CA7396A68D541C85D26508E83_546309983.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_546309983;
        
        
        
            
            
            
            
            
                
            
            
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

