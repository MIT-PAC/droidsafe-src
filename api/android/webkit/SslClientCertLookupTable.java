package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class SslClientCertLookupTable {

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.339 -0500", hash_original_method = "19519BEA477C884A878A69699B4A2178", hash_generated_method = "52A111EE5449CDDBB8C2E7E813D8B995")
    
public static synchronized SslClientCertLookupTable getInstance() {
        if (sTable == null) {
            sTable = new SslClientCertLookupTable();
        }
        return sTable;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.329 -0500", hash_original_field = "395E6744E429BB9E68F8C5F0333FFF93", hash_generated_field = "FD0F60510E0871B3E1093B2BFB4789A3")

    private static SslClientCertLookupTable sTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.332 -0500", hash_original_field = "DDF3592A1AAD5B5E2FBAD14EEC408BC1", hash_generated_field = "AF223C6357D0802EB3E145576B4B5EAA")

    private  Map<String, byte[]> privateKeys;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.334 -0500", hash_original_field = "6BE352D8CB9563A1A02E3A9E8CC8827B", hash_generated_field = "454999763A0789555FF29C71D8B0E31F")

    private  Map<String, byte[][]> certificateChains;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.336 -0500", hash_original_field = "CB0BBC012B8C25740921801922B3CB25", hash_generated_field = "543000FBC278211CB36B7F98FB0C5E6F")

    private  Set<String> denied;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.341 -0500", hash_original_method = "C6A28623CA4FEF2D114418C70282C212", hash_generated_method = "030E23072C43339132C1692FE82C3302")
    
private SslClientCertLookupTable() {
        privateKeys = new HashMap<String, byte[]>();
        certificateChains = new HashMap<String, byte[][]>();
        denied = new HashSet<String>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.343 -0500", hash_original_method = "03E82816147715E98B99B8B82D977E8F", hash_generated_method = "842BAB75564566B78E0E7454D6F1BAD2")
    
public void Allow(String host_and_port, byte[] privateKey, byte[][] chain) {
        privateKeys.put(host_and_port, privateKey);
        certificateChains.put(host_and_port, chain);
        denied.remove(host_and_port);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.346 -0500", hash_original_method = "4967C7200C7567BE4E38867C3159946A", hash_generated_method = "BAEAF89EFA8CBDCBCBD3D4B931525A4C")
    
public void Deny(String host_and_port) {
        privateKeys.remove(host_and_port);
        certificateChains.remove(host_and_port);
        denied.add(host_and_port);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.348 -0500", hash_original_method = "317AD55DB06159332BAB288BB6F5C0C0", hash_generated_method = "C26BE7B7556DB0EA0BE1CC7C0FB5E037")
    
public boolean IsAllowed(String host_and_port) {
        return privateKeys.containsKey(host_and_port);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.350 -0500", hash_original_method = "49DD78FAF8457E4BC1F7CBA07DA46BF9", hash_generated_method = "370BC68A55E8FDF328299307F0C346EE")
    
public boolean IsDenied(String host_and_port) {
        return denied.contains(host_and_port);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.352 -0500", hash_original_method = "B4AB5EBE6061C1ABF914FF3078A0616E", hash_generated_method = "A010CC6FCBA3159468C19D0B99174F6F")
    
public byte[] PrivateKey(String host_and_port) {
        return privateKeys.get(host_and_port);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:44.355 -0500", hash_original_method = "8792305F1FF4CDCE892661D9CA1A58D2", hash_generated_method = "81C5CC99BE913832FF63542D9543B861")
    
public byte[][] CertificateChain(String host_and_port) {
        return certificateChains.get(host_and_port);
    }
}

