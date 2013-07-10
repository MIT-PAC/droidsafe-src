package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class PropertyResourceBundle extends ResourceBundle {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.480 -0400", hash_original_field = "55B558C7EF820E6E00E5993B9E55D93B", hash_generated_field = "8C97A55243F1F4D2EF7A784DA96E106B")

    Properties resources;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.480 -0400", hash_original_method = "3D88428E114136417B3FF5D84DADF880", hash_generated_method = "70B95092511E9705BA3EE4889CFA714C")
    public  PropertyResourceBundle(InputStream stream) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        resources = new Properties();
        resources.load(stream);
        addTaint(stream.getTaint());
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.481 -0400", hash_original_method = "51B0205103DDC756BC77F911CC2E7B89", hash_generated_method = "1FF8D3412AA2F38E6D741BC9C89E1030")
    public  PropertyResourceBundle(Reader reader) throws IOException {
        resources = new Properties();
        resources.load(reader);
        addTaint(reader.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.482 -0400", hash_original_method = "18F63E7C5AB3934B8351CB4BC2CE0CC3", hash_generated_method = "1EABEC2F73059E84FFA530E0D2943DD5")
    protected Set<String> handleKeySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_406231614 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_406231614 = resources.stringPropertyNames();
        varB4EAC82CA7396A68D541C85D26508E83_406231614.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_406231614;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.482 -0400", hash_original_method = "94C0F4CF2CD414C406604EC575DAD3DD", hash_generated_method = "0FF1E47A732268292B380E74D4EFAA2F")
    @SuppressWarnings("unchecked")
    private Enumeration<String> getLocalKeys() {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_717064166 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_717064166 = (Enumeration<String>) resources.propertyNames();
        varB4EAC82CA7396A68D541C85D26508E83_717064166.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_717064166;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.483 -0400", hash_original_method = "8070DEE7B7CBE3EB8E3AF8AF6FE9DBC6", hash_generated_method = "1A964180A58883289AC6FE49490DDE1C")
    @Override
    public Enumeration<String> getKeys() {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_1293183610 = null; 
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_372181081 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1293183610 = getLocalKeys();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_372181081 = new Enumeration<String>() {
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
        Enumeration<String> varA7E53CE21691AB073D9660D615818899_496778526; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_496778526 = varB4EAC82CA7396A68D541C85D26508E83_1293183610;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_496778526 = varB4EAC82CA7396A68D541C85D26508E83_372181081;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_496778526.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_496778526;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.484 -0400", hash_original_method = "23544B256E22E0E7C2784DAFEBE5A56C", hash_generated_method = "41E9D424173A45A796A84F16498AA876")
    @Override
    public Object handleGetObject(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1554001868 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1554001868 = resources.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1554001868.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1554001868;
        
        
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
    
    
    Enumeration<String> local = getLocalKeys();
    
    
    Enumeration<String> pEnum = parent.getKeys();
    
    
    String nextElement;
    
}

