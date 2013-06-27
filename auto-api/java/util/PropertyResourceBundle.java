package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class PropertyResourceBundle extends ResourceBundle {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.653 -0400", hash_original_field = "55B558C7EF820E6E00E5993B9E55D93B", hash_generated_field = "8C97A55243F1F4D2EF7A784DA96E106B")

    Properties resources;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.654 -0400", hash_original_method = "3D88428E114136417B3FF5D84DADF880", hash_generated_method = "70B95092511E9705BA3EE4889CFA714C")
    public  PropertyResourceBundle(InputStream stream) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        resources = new Properties();
        resources.load(stream);
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //if (stream == null) {
            //throw new NullPointerException();
        //}
        //resources = new Properties();
        //resources.load(stream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.655 -0400", hash_original_method = "51B0205103DDC756BC77F911CC2E7B89", hash_generated_method = "1FF8D3412AA2F38E6D741BC9C89E1030")
    public  PropertyResourceBundle(Reader reader) throws IOException {
        resources = new Properties();
        resources.load(reader);
        addTaint(reader.getTaint());
        // ---------- Original Method ----------
        //resources = new Properties();
        //resources.load(reader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.655 -0400", hash_original_method = "18F63E7C5AB3934B8351CB4BC2CE0CC3", hash_generated_method = "8A0926F55879A629E4406F7F1755D368")
    protected Set<String> handleKeySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1457068679 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1457068679 = resources.stringPropertyNames();
        varB4EAC82CA7396A68D541C85D26508E83_1457068679.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1457068679;
        // ---------- Original Method ----------
        //return resources.stringPropertyNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.656 -0400", hash_original_method = "94C0F4CF2CD414C406604EC575DAD3DD", hash_generated_method = "1E9C13CD71FF452DE210A56B0006A110")
    @SuppressWarnings("unchecked")
    private Enumeration<String> getLocalKeys() {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_1594564822 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1594564822 = (Enumeration<String>) resources.propertyNames();
        varB4EAC82CA7396A68D541C85D26508E83_1594564822.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1594564822;
        // ---------- Original Method ----------
        //return (Enumeration<String>) resources.propertyNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.657 -0400", hash_original_method = "8070DEE7B7CBE3EB8E3AF8AF6FE9DBC6", hash_generated_method = "CDA807E9A374DF2B9F90C54ABB522874")
    @Override
    public Enumeration<String> getKeys() {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_394650061 = null; //Variable for return #1
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_1794080206 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_394650061 = getLocalKeys();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1794080206 = new Enumeration<String>() {
            Enumeration<String> local = getLocalKeys();
            Enumeration<String> pEnum = parent.getKeys();
            String nextElement;
            private boolean findNext() {
                if (nextElement != null) {
                    return true;
                }
                while (pEnum.hasMoreElements()) {
                    String next = pEnum.nextElement();
                    if (!resources.containsKey(next)) {
                        nextElement = next;
                        return true;
                    }
                }
                return false;
            }
            public boolean hasMoreElements() {
                if (local.hasMoreElements()) {
                    return true;
                }
                return findNext();
            }
            public String nextElement() {
                if (local.hasMoreElements()) {
                    return local.nextElement();
                }
                if (findNext()) {
                    String result = nextElement;
                    nextElement = null;
                    return result;
                }
                return pEnum.nextElement();
            }
        };
        Enumeration<String> varA7E53CE21691AB073D9660D615818899_202742137; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_202742137 = varB4EAC82CA7396A68D541C85D26508E83_394650061;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_202742137 = varB4EAC82CA7396A68D541C85D26508E83_1794080206;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_202742137.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_202742137;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.665 -0400", hash_original_method = "23544B256E22E0E7C2784DAFEBE5A56C", hash_generated_method = "0B8D70FCF6B0B1FB4CB317FE786A70BB")
    @Override
    public Object handleGetObject(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_827834479 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_827834479 = resources.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_827834479.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_827834479;
        // ---------- Original Method ----------
        //return resources.get(key);
    }

    
}

