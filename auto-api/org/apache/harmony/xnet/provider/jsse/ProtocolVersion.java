package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Hashtable;

public class ProtocolVersion {
    public String name;
    public byte[] version;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.088 -0400", hash_original_method = "B6EFD2221FD9ABD3C193138DD70242C4", hash_generated_method = "8A5C361767535B87238BD0D078E8727F")
    @DSModeled(DSC.SAFE)
    private ProtocolVersion(String name, byte[] version) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(version[0]);
        // ---------- Original Method ----------
        //this.name = name;
        //this.version = version;
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

    
        public static boolean isSupported(String name) {
        return protocolsByName.containsKey(name);
    }

    
        public static ProtocolVersion getByName(String name) {
        return protocolsByName.get(name);
    }

    
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

    
    public static final String[] supportedProtocols = new String[] { "TLSv1",
            "SSLv3" };
    private static Hashtable<String, ProtocolVersion> protocolsByName = new Hashtable<String, ProtocolVersion>(4);
    public static final ProtocolVersion SSLv3 = new ProtocolVersion("SSLv3",
            new byte[] { 3, 0 });
    public static final ProtocolVersion TLSv1 = new ProtocolVersion("TLSv1",
            new byte[] { 3, 1 });
    static {
        protocolsByName.put(SSLv3.name, SSLv3);
        protocolsByName.put(TLSv1.name, TLSv1);
        protocolsByName.put("SSL", SSLv3);
        protocolsByName.put("TLS", TLSv1);
    }
    
}

