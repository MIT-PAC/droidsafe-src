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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.791 -0400", hash_original_field = "55B558C7EF820E6E00E5993B9E55D93B", hash_generated_field = "8C97A55243F1F4D2EF7A784DA96E106B")

    Properties resources;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.803 -0400", hash_original_method = "3D88428E114136417B3FF5D84DADF880", hash_generated_method = "70B95092511E9705BA3EE4889CFA714C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.803 -0400", hash_original_method = "51B0205103DDC756BC77F911CC2E7B89", hash_generated_method = "1FF8D3412AA2F38E6D741BC9C89E1030")
    public  PropertyResourceBundle(Reader reader) throws IOException {
        resources = new Properties();
        resources.load(reader);
        addTaint(reader.getTaint());
        // ---------- Original Method ----------
        //resources = new Properties();
        //resources.load(reader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.804 -0400", hash_original_method = "18F63E7C5AB3934B8351CB4BC2CE0CC3", hash_generated_method = "A4D1AF97A81F48F205ACE63A295B7E72")
    protected Set<String> handleKeySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1345900091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1345900091 = resources.stringPropertyNames();
        varB4EAC82CA7396A68D541C85D26508E83_1345900091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1345900091;
        // ---------- Original Method ----------
        //return resources.stringPropertyNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.804 -0400", hash_original_method = "94C0F4CF2CD414C406604EC575DAD3DD", hash_generated_method = "B6949EFA014B2425F342BA4FA36B6599")
    @SuppressWarnings("unchecked")
    private Enumeration<String> getLocalKeys() {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_1149338 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1149338 = (Enumeration<String>) resources.propertyNames();
        varB4EAC82CA7396A68D541C85D26508E83_1149338.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1149338;
        // ---------- Original Method ----------
        //return (Enumeration<String>) resources.propertyNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.805 -0400", hash_original_method = "8070DEE7B7CBE3EB8E3AF8AF6FE9DBC6", hash_generated_method = "F72B851181F9450C9588785560B23433")
    @Override
    public Enumeration<String> getKeys() {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_28047772 = null; //Variable for return #1
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_531925267 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_28047772 = getLocalKeys();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_531925267 = new Enumeration<String>() {
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
        Enumeration<String> varA7E53CE21691AB073D9660D615818899_1626743572; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1626743572 = varB4EAC82CA7396A68D541C85D26508E83_28047772;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1626743572 = varB4EAC82CA7396A68D541C85D26508E83_531925267;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1626743572.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1626743572;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.805 -0400", hash_original_method = "23544B256E22E0E7C2784DAFEBE5A56C", hash_generated_method = "7209E3C1B22A1E6DB73BA1A88EFD6B61")
    @Override
    public Object handleGetObject(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_59357528 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_59357528 = resources.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_59357528.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_59357528;
        // ---------- Original Method ----------
        //return resources.get(key);
    }

    
}

