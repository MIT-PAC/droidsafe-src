package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class SslClientCertLookupTable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.522 -0400", hash_original_field = "73C6E03F39A61AD78C4635846B1CD52F", hash_generated_field = "AF223C6357D0802EB3E145576B4B5EAA")

    private Map<String, byte[]> privateKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.522 -0400", hash_original_field = "8ADCC2F9F5608D7931B650D777A65656", hash_generated_field = "454999763A0789555FF29C71D8B0E31F")

    private Map<String, byte[][]> certificateChains;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.522 -0400", hash_original_field = "865726B2885FEEF8E8B25B56A2D7C8F8", hash_generated_field = "543000FBC278211CB36B7F98FB0C5E6F")

    private Set<String> denied;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.522 -0400", hash_original_method = "C6A28623CA4FEF2D114418C70282C212", hash_generated_method = "FAE9CFE8528E4732B681D7FF4194F30D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.523 -0400", hash_original_method = "03E82816147715E98B99B8B82D977E8F", hash_generated_method = "8A2140E6E1D41978FA2D1720B5AD801A")
    public void Allow(String host_and_port, byte[] privateKey, byte[][] chain) {
        privateKeys.put(host_and_port, privateKey);
        certificateChains.put(host_and_port, chain);
        denied.remove(host_and_port);
        addTaint(host_and_port.getTaint());
        addTaint(privateKey[0]);
        addTaint(chain[0][0]);
        // ---------- Original Method ----------
        //privateKeys.put(host_and_port, privateKey);
        //certificateChains.put(host_and_port, chain);
        //denied.remove(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.523 -0400", hash_original_method = "4967C7200C7567BE4E38867C3159946A", hash_generated_method = "BCF69976D1A02CD0B5947EB7861F4307")
    public void Deny(String host_and_port) {
        privateKeys.remove(host_and_port);
        certificateChains.remove(host_and_port);
        denied.add(host_and_port);
        addTaint(host_and_port.getTaint());
        // ---------- Original Method ----------
        //privateKeys.remove(host_and_port);
        //certificateChains.remove(host_and_port);
        //denied.add(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.523 -0400", hash_original_method = "317AD55DB06159332BAB288BB6F5C0C0", hash_generated_method = "B4F0FFEE9716FE001ECED555B3C79567")
    public boolean IsAllowed(String host_and_port) {
        boolean var5355A4C0F247E3D34F9D4AC57A01CD03_1339876760 = (privateKeys.containsKey(host_and_port));
        addTaint(host_and_port.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064075812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064075812;
        // ---------- Original Method ----------
        //return privateKeys.containsKey(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.524 -0400", hash_original_method = "49DD78FAF8457E4BC1F7CBA07DA46BF9", hash_generated_method = "5D029B176A7B9F91B0C369DC1F83353E")
    public boolean IsDenied(String host_and_port) {
        boolean varFCD5463C8242316CC93C9BD17B0C2EAE_595695705 = (denied.contains(host_and_port));
        addTaint(host_and_port.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1745061929 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1745061929;
        // ---------- Original Method ----------
        //return denied.contains(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.524 -0400", hash_original_method = "B4AB5EBE6061C1ABF914FF3078A0616E", hash_generated_method = "25D66754670ABCBE1B96D1CAF4F91FD7")
    public byte[] PrivateKey(String host_and_port) {
        byte[] varE032D21FB85636316C42465DED37369E_1471044298 = (privateKeys.get(host_and_port));
        addTaint(host_and_port.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1468437736 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1468437736;
        // ---------- Original Method ----------
        //return privateKeys.get(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.524 -0400", hash_original_method = "8792305F1FF4CDCE892661D9CA1A58D2", hash_generated_method = "E20C9FDFCF004157A97501434350AA79")
    public byte[][] CertificateChain(String host_and_port) {
        byte[][] var0F440A46FC06ECB23A98141390753BCF_800419511 = (certificateChains.get(host_and_port));
        addTaint(host_and_port.getTaint());
        byte[][] var09EEFE93BC05FD972F5A60957AA3195B_2122504285 = {{getTaintByte()}};
        return var09EEFE93BC05FD972F5A60957AA3195B_2122504285;
        // ---------- Original Method ----------
        //return certificateChains.get(host_and_port);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.524 -0400", hash_original_field = "C9695FF7FB5E10741CB2F64B059A67B7", hash_generated_field = "FD0F60510E0871B3E1093B2BFB4789A3")

    private static SslClientCertLookupTable sTable;
}

