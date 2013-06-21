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
    private Map<String, byte[]> privateKeys;
    private Map<String, byte[][]> certificateChains;
    private Set<String> denied;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.747 -0400", hash_original_method = "C6A28623CA4FEF2D114418C70282C212", hash_generated_method = "FAE9CFE8528E4732B681D7FF4194F30D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SslClientCertLookupTable() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.747 -0400", hash_original_method = "03E82816147715E98B99B8B82D977E8F", hash_generated_method = "FC7FEE657265585908FAFFABF7E1E314")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void Allow(String host_and_port, byte[] privateKey, byte[][] chain) {
        dsTaint.addTaint(privateKey[0]);
        dsTaint.addTaint(chain[0][0]);
        dsTaint.addTaint(host_and_port);
        privateKeys.put(host_and_port, privateKey);
        certificateChains.put(host_and_port, chain);
        denied.remove(host_and_port);
        // ---------- Original Method ----------
        //privateKeys.put(host_and_port, privateKey);
        //certificateChains.put(host_and_port, chain);
        //denied.remove(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.747 -0400", hash_original_method = "4967C7200C7567BE4E38867C3159946A", hash_generated_method = "963EFE5BA4476347EFE7DFD04529E54C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void Deny(String host_and_port) {
        dsTaint.addTaint(host_and_port);
        privateKeys.remove(host_and_port);
        certificateChains.remove(host_and_port);
        denied.add(host_and_port);
        // ---------- Original Method ----------
        //privateKeys.remove(host_and_port);
        //certificateChains.remove(host_and_port);
        //denied.add(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.747 -0400", hash_original_method = "317AD55DB06159332BAB288BB6F5C0C0", hash_generated_method = "4EA4715717095410FD9C443AAF3BE8E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean IsAllowed(String host_and_port) {
        dsTaint.addTaint(host_and_port);
        boolean var5355A4C0F247E3D34F9D4AC57A01CD03_769099951 = (privateKeys.containsKey(host_and_port));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return privateKeys.containsKey(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.748 -0400", hash_original_method = "49DD78FAF8457E4BC1F7CBA07DA46BF9", hash_generated_method = "1F1A6672EC363CFDEC11A73C416EA3C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean IsDenied(String host_and_port) {
        dsTaint.addTaint(host_and_port);
        boolean varFCD5463C8242316CC93C9BD17B0C2EAE_1286652894 = (denied.contains(host_and_port));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return denied.contains(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.748 -0400", hash_original_method = "B4AB5EBE6061C1ABF914FF3078A0616E", hash_generated_method = "796577B0DE632F7E40A796F4792F93AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] PrivateKey(String host_and_port) {
        dsTaint.addTaint(host_and_port);
        byte[] varE032D21FB85636316C42465DED37369E_952267522 = (privateKeys.get(host_and_port));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return privateKeys.get(host_and_port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.748 -0400", hash_original_method = "8792305F1FF4CDCE892661D9CA1A58D2", hash_generated_method = "F3DA54F239089744C8598FF32F06E685")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[][] CertificateChain(String host_and_port) {
        dsTaint.addTaint(host_and_port);
        byte[][] var0F440A46FC06ECB23A98141390753BCF_760450884 = (certificateChains.get(host_and_port));
        return (byte[][])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return certificateChains.get(host_and_port);
    }

    
    private static SslClientCertLookupTable sTable;
}

