package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Hashtable;

public class ProtocolVersion {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.669 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.669 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "A66C5B7190F1301206D2305713924AE0")

    public byte[] version;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.669 -0400", hash_original_method = "B6EFD2221FD9ABD3C193138DD70242C4", hash_generated_method = "CD103DD1931067F9E6DAD4D4E3F86EC8")
    private  ProtocolVersion(String name, byte[] version) {
        this.name = name;
        this.version = version;
        
        
        
    }

    
    public static boolean isSupported(byte[] version) {
        if (version[0] != 3 || (version[1] != 0 && version[1] != 1)) {
            return false;
        }
        return true;
    }

    
    public static ProtocolVersion getByVersion(byte[] version) {
        if (version[0] == 3) {
            if (version[1] == 1) {
                return TLSv1;
            }
            if (version[1] == 0) {
                return SSLv3;
            }
        }
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isSupported(String name) {
        return protocolsByName.containsKey(name);
    }

    
    @DSModeled(DSC.SAFE)
    public static ProtocolVersion getByName(String name) {
        return protocolsByName.get(name);
    }

    
    @DSModeled(DSC.SAFE)
    public static ProtocolVersion getLatestVersion(String[] protocols) {
        if (protocols == null || protocols.length == 0) {
            return null;
        }
        ProtocolVersion latest = getByName(protocols[0]);
        ProtocolVersion current;
        for (int i = 1; i < protocols.length; i++) {
            current = getByName(protocols[i]);
            if (current == null) {
                continue;
            }
            if ((latest == null)
                    || (latest.version[0] < current.version[0])
                    || (latest.version[0] == current.version[0] && latest.version[1] < current.version[1])) {
                latest = current;
            }
        }
        return latest;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.670 -0400", hash_original_field = "76437FCAD8FC9D5F31FAD6C51FBF2C5E", hash_generated_field = "0B775BA932F113D98A0C1C0F7E102411")

    public static final String[] supportedProtocols = new String[] { "TLSv1",
            "SSLv3" };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.670 -0400", hash_original_field = "C6E9ACC55D5BC391037D2F298B178AB5", hash_generated_field = "AA8F7BF7FB4B29DFC759C981A9544153")

    private static Hashtable<String, ProtocolVersion> protocolsByName = new Hashtable<String, ProtocolVersion>(4);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.670 -0400", hash_original_field = "7ED50C36D9CEC9F38C161ED03E2C49AA", hash_generated_field = "128736E5308FF81E6DD8DC58E7D8F4CC")

    public static final ProtocolVersion SSLv3 = new ProtocolVersion("SSLv3",
            new byte[] { 3, 0 });
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.670 -0400", hash_original_field = "9C544736AA33F9CE04FE37F5115856C3", hash_generated_field = "5D9C3CC50D82CBCAC1D9BEAA5E6AE7DD")

    public static final ProtocolVersion TLSv1 = new ProtocolVersion("TLSv1",
            new byte[] { 3, 1 });
    static {
        protocolsByName.put(SSLv3.name, SSLv3);
        protocolsByName.put(TLSv1.name, TLSv1);
        protocolsByName.put("SSL", SSLv3);
        protocolsByName.put("TLS", TLSv1);
    }
    
}

