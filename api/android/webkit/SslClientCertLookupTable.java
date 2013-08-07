package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;




final class SslClientCertLookupTable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.932 -0400", hash_original_field = "73C6E03F39A61AD78C4635846B1CD52F", hash_generated_field = "AF223C6357D0802EB3E145576B4B5EAA")

    private Map<String, byte[]> privateKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.932 -0400", hash_original_field = "8ADCC2F9F5608D7931B650D777A65656", hash_generated_field = "454999763A0789555FF29C71D8B0E31F")

    private Map<String, byte[][]> certificateChains;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.932 -0400", hash_original_field = "865726B2885FEEF8E8B25B56A2D7C8F8", hash_generated_field = "543000FBC278211CB36B7F98FB0C5E6F")

    private Set<String> denied;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.933 -0400", hash_original_method = "C6A28623CA4FEF2D114418C70282C212", hash_generated_method = "FAE9CFE8528E4732B681D7FF4194F30D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.934 -0400", hash_original_method = "03E82816147715E98B99B8B82D977E8F", hash_generated_method = "1ED7876E0BDBBE8EF8F947E57CD0361B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.934 -0400", hash_original_method = "4967C7200C7567BE4E38867C3159946A", hash_generated_method = "21B7F432DAEAA8BC8D1EF2C3397C7755")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.934 -0400", hash_original_method = "317AD55DB06159332BAB288BB6F5C0C0", hash_generated_method = "56AA250FB361E0ECF56BD8A59186DDD4")
    public boolean IsAllowed(String host_and_port) {
        addTaint(host_and_port.getTaint());
        boolean var554E7D4145B926C96C4CAF2FC8B5FE58_281368788 = (privateKeys.containsKey(host_and_port));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_723691293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_723691293;
        // ---------- Original Method ----------
        //return privateKeys.containsKey(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.935 -0400", hash_original_method = "49DD78FAF8457E4BC1F7CBA07DA46BF9", hash_generated_method = "AC104017B2756B5C3B7598471912A46E")
    public boolean IsDenied(String host_and_port) {
        addTaint(host_and_port.getTaint());
        boolean var4857EF46086F507A63B7BC5CF4DFCB25_338489482 = (denied.contains(host_and_port));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099450990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099450990;
        // ---------- Original Method ----------
        //return denied.contains(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.935 -0400", hash_original_method = "B4AB5EBE6061C1ABF914FF3078A0616E", hash_generated_method = "B3DA52E34B28134C8E0A1AF3FB6C2E85")
    public byte[] PrivateKey(String host_and_port) {
        addTaint(host_and_port.getTaint());
        byte[] var1E57468162B2C5D87AB75EFB58E3E43F_880904484 = (privateKeys.get(host_and_port));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_966861554 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_966861554;
        // ---------- Original Method ----------
        //return privateKeys.get(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.935 -0400", hash_original_method = "8792305F1FF4CDCE892661D9CA1A58D2", hash_generated_method = "524845DE0350B89F47F0DC75198D851A")
    public byte[][] CertificateChain(String host_and_port) {
        addTaint(host_and_port.getTaint());
        byte[][] varD82177E8D08910160012DA92AB7A7C44_572437156 = (certificateChains.get(host_and_port));
                byte[][] var09EEFE93BC05FD972F5A60957AA3195B_1642002741 = {{getTaintByte()}};
        return var09EEFE93BC05FD972F5A60957AA3195B_1642002741;
        // ---------- Original Method ----------
        //return certificateChains.get(host_and_port);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.936 -0400", hash_original_field = "C9695FF7FB5E10741CB2F64B059A67B7", hash_generated_field = "FD0F60510E0871B3E1093B2BFB4789A3")

    private static SslClientCertLookupTable sTable;
}

