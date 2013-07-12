package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class SslClientCertLookupTable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.094 -0400", hash_original_field = "73C6E03F39A61AD78C4635846B1CD52F", hash_generated_field = "AF223C6357D0802EB3E145576B4B5EAA")

    private Map<String, byte[]> privateKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.094 -0400", hash_original_field = "8ADCC2F9F5608D7931B650D777A65656", hash_generated_field = "454999763A0789555FF29C71D8B0E31F")

    private Map<String, byte[][]> certificateChains;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.094 -0400", hash_original_field = "865726B2885FEEF8E8B25B56A2D7C8F8", hash_generated_field = "543000FBC278211CB36B7F98FB0C5E6F")

    private Set<String> denied;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.095 -0400", hash_original_method = "C6A28623CA4FEF2D114418C70282C212", hash_generated_method = "FAE9CFE8528E4732B681D7FF4194F30D")
    private  SslClientCertLookupTable() {
        privateKeys = new HashMap<String, byte[]>();
        certificateChains = new HashMap<String, byte[][]>();
        denied = new HashSet<String>();
        // ---------- Original Method ----------
        //privateKeys = new HashMap<String, byte[]>();
        //certificateChains = new HashMap<String, byte[][]>();
        //denied = new HashSet<String>();
    }

    
        public static synchronized SslClientCertLookupTable getInstance() {
        if (sTable == null) {
            sTable = new SslClientCertLookupTable();
        }
        return sTable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.096 -0400", hash_original_method = "03E82816147715E98B99B8B82D977E8F", hash_generated_method = "1ED7876E0BDBBE8EF8F947E57CD0361B")
    public void Allow(String host_and_port, byte[] privateKey, byte[][] chain) {
        addTaint(chain[0][0]);
        addTaint(privateKey[0]);
        addTaint(host_and_port.getTaint());
        privateKeys.put(host_and_port, privateKey);
        certificateChains.put(host_and_port, chain);
        denied.remove(host_and_port);
        // ---------- Original Method ----------
        //privateKeys.put(host_and_port, privateKey);
        //certificateChains.put(host_and_port, chain);
        //denied.remove(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.096 -0400", hash_original_method = "4967C7200C7567BE4E38867C3159946A", hash_generated_method = "21B7F432DAEAA8BC8D1EF2C3397C7755")
    public void Deny(String host_and_port) {
        addTaint(host_and_port.getTaint());
        privateKeys.remove(host_and_port);
        certificateChains.remove(host_and_port);
        denied.add(host_and_port);
        // ---------- Original Method ----------
        //privateKeys.remove(host_and_port);
        //certificateChains.remove(host_and_port);
        //denied.add(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.096 -0400", hash_original_method = "317AD55DB06159332BAB288BB6F5C0C0", hash_generated_method = "C8E759E931929D968D16FFC2CF861295")
    public boolean IsAllowed(String host_and_port) {
        addTaint(host_and_port.getTaint());
        boolean var554E7D4145B926C96C4CAF2FC8B5FE58_1855094025 = (privateKeys.containsKey(host_and_port));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_134816727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_134816727;
        // ---------- Original Method ----------
        //return privateKeys.containsKey(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.097 -0400", hash_original_method = "49DD78FAF8457E4BC1F7CBA07DA46BF9", hash_generated_method = "6A19D775BCD4139691E6F40B42BC0D32")
    public boolean IsDenied(String host_and_port) {
        addTaint(host_and_port.getTaint());
        boolean var4857EF46086F507A63B7BC5CF4DFCB25_525588492 = (denied.contains(host_and_port));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1563156989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1563156989;
        // ---------- Original Method ----------
        //return denied.contains(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.097 -0400", hash_original_method = "B4AB5EBE6061C1ABF914FF3078A0616E", hash_generated_method = "452C9E20CEF5659ECEB2351CB2520803")
    public byte[] PrivateKey(String host_and_port) {
        addTaint(host_and_port.getTaint());
        byte[] var1E57468162B2C5D87AB75EFB58E3E43F_1019046646 = (privateKeys.get(host_and_port));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1802636666 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1802636666;
        // ---------- Original Method ----------
        //return privateKeys.get(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.098 -0400", hash_original_method = "8792305F1FF4CDCE892661D9CA1A58D2", hash_generated_method = "BE768EEFBAF9F68BF6916FAB79845C9D")
    public byte[][] CertificateChain(String host_and_port) {
        addTaint(host_and_port.getTaint());
        byte[][] varD82177E8D08910160012DA92AB7A7C44_2028769524 = (certificateChains.get(host_and_port));
                byte[][] var09EEFE93BC05FD972F5A60957AA3195B_261125414 = {{getTaintByte()}};
        return var09EEFE93BC05FD972F5A60957AA3195B_261125414;
        // ---------- Original Method ----------
        //return certificateChains.get(host_and_port);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.098 -0400", hash_original_field = "C9695FF7FB5E10741CB2F64B059A67B7", hash_generated_field = "FD0F60510E0871B3E1093B2BFB4789A3")

    private static SslClientCertLookupTable sTable;
}

