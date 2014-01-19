package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Hashtable;

public class ProtocolVersion {

    /**
     *
     * Returns true if protocol version is supported
     *
     * @param version
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.602 -0500", hash_original_method = "231D340B5B0F8FFDB2D731B0FBBB6D7F", hash_generated_method = "4629D1374603155069D144B9514FADD7")
    
public static boolean isSupported(byte[] version) {
        if (version[0] != 3 || (version[1] != 0 && version[1] != 1)) {
            return false;
        }
        return true;
    }

    /**
     * Returns ProtocolVersion
     *
     * @param version
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.605 -0500", hash_original_method = "A8DDB91344A4ACE1DED4563322A3ABB8", hash_generated_method = "43BB4B150DAB7AFC5D44C48D0A361465")
    
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

    /**
     * Returns true if provider supports protocol version
     *
     * @param name
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.607 -0500", hash_original_method = "BCFC763048FB40D22AF5E3F4AE92979E", hash_generated_method = "A6B30A4741083A789C035F2D9F29B245")
    
public static boolean isSupported(String name) {
        return protocolsByName.containsKey(name);
    }

    /**
     * Returns ProtocolVersion
     *
     * @param name
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.610 -0500", hash_original_method = "DE14D065BBEFBE848C75547EEBFDF97D", hash_generated_method = "E358A359DBE14FDA899A9321ACD7AC64")
    
public static ProtocolVersion getByName(String name) {
        return protocolsByName.get(name);
    }

    /**
     * Highest protocol version supported by provider implementation
     *
     * @param protocols
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.612 -0500", hash_original_method = "EAFDD965F3CDE3FC6FA18BAFD86C981E", hash_generated_method = "EA93D29A9FC59AC3B22D5DA79A8A39CB")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.598 -0500", hash_original_field = "AADC7906866EC19CBACD75314AFF4AAE", hash_generated_field = "0B775BA932F113D98A0C1C0F7E102411")

    public static final String[] supportedProtocols = new String[] { "TLSv1",
            "SSLv3" };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.600 -0500", hash_original_field = "E73A82414AF496D0C52CCA5E63946060", hash_generated_field = "AA8F7BF7FB4B29DFC759C981A9544153")

    private static Hashtable<String, ProtocolVersion> protocolsByName = new Hashtable<String, ProtocolVersion>(4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.615 -0500", hash_original_field = "CC4DD00D70F9E1C365FD2AAFAF407F2F", hash_generated_field = "128736E5308FF81E6DD8DC58E7D8F4CC")

    public static final ProtocolVersion SSLv3 = new ProtocolVersion("SSLv3",
            new byte[] { 3, 0 });
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.617 -0500", hash_original_field = "9297BCBFAA59301BA29191898EEFB773", hash_generated_field = "5D9C3CC50D82CBCAC1D9BEAA5E6AE7DD")

    public static final ProtocolVersion TLSv1 = new ProtocolVersion("TLSv1",
            new byte[] { 3, 1 });
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.620 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.623 -0500", hash_original_field = "1100ACE58905CA2B2E277C1A3E45DA80", hash_generated_field = "A66C5B7190F1301206D2305713924AE0")

    public  byte[] version;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.625 -0500", hash_original_method = "B6EFD2221FD9ABD3C193138DD70242C4", hash_generated_method = "F6905066E3F68BFE373CD5D6CAA8EE90")
    
private ProtocolVersion(String name, byte[] version) {
        this.name = name;
        this.version = version;
    }
    static {
        protocolsByName.put(SSLv3.name, SSLv3);
        protocolsByName.put(TLSv1.name, TLSv1);
        protocolsByName.put("SSL", SSLv3);
        protocolsByName.put("TLS", TLSv1);
    }
    
}

