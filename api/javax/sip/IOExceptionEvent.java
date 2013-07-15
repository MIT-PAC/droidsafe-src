package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventObject;

public class IOExceptionEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.203 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.203 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.203 -0400", hash_original_field = "DDB508BA6BDDCDC9D416A8817238314C", hash_generated_field = "788577C3039958B2B9A8239518A26917")

    private String mTransport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.204 -0400", hash_original_method = "B65431E37A5EA3D43D49DD68F5D308D7", hash_generated_method = "AFEB496AF910EA84159B004A06B91063")
    public  IOExceptionEvent(Object source, String host, int port,
            String transport) {
        super(source);
        addTaint(source.getTaint());
        mHost = host;
        mPort = port;
        mTransport = transport;
        // ---------- Original Method ----------
        //mHost = host;
        //mPort = port;
        //mTransport = transport;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.205 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "4E165758FEB104C3BB2458F73F777122")
    public String getHost() {
String varE57614B151242FB69B92E61EEA287D33_717141459 =         mHost;
        varE57614B151242FB69B92E61EEA287D33_717141459.addTaint(taint);
        return varE57614B151242FB69B92E61EEA287D33_717141459;
        // ---------- Original Method ----------
        //return mHost;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.205 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "E1DB3B831E83B9CB522D7F98AF898D2B")
    public int getPort() {
        int var5EFA61C4FCA92CA992BE37C2BAF4D350_1980837880 = (mPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323129006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323129006;
        // ---------- Original Method ----------
        //return mPort;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.206 -0400", hash_original_method = "CC293D4A58B4AE34EE1EAFE01D7A0F93", hash_generated_method = "35CDDC7720A2EE43745877BDCDA2604E")
    public String getTransport() {
String varF2CB7A1EAFE712633AC71AFDD720A221_211410361 =         mTransport;
        varF2CB7A1EAFE712633AC71AFDD720A221_211410361.addTaint(taint);
        return varF2CB7A1EAFE712633AC71AFDD720A221_211410361;
        // ---------- Original Method ----------
        //return mTransport;
    }

    
}

