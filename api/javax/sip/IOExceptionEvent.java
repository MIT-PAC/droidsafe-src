package javax.sip;

// Droidsafe Imports
import java.util.EventObject;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class IOExceptionEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.246 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.246 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.246 -0400", hash_original_field = "DDB508BA6BDDCDC9D416A8817238314C", hash_generated_field = "788577C3039958B2B9A8239518A26917")

    private String mTransport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.248 -0400", hash_original_method = "B65431E37A5EA3D43D49DD68F5D308D7", hash_generated_method = "AFEB496AF910EA84159B004A06B91063")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.248 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "AF841C781C2B13747991F243AC7C4564")
    public String getHost() {
String varE57614B151242FB69B92E61EEA287D33_302643395 =         mHost;
        varE57614B151242FB69B92E61EEA287D33_302643395.addTaint(taint);
        return varE57614B151242FB69B92E61EEA287D33_302643395;
        // ---------- Original Method ----------
        //return mHost;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.249 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "9176EF16450CED35979D3E430D05B449")
    public int getPort() {
        int var5EFA61C4FCA92CA992BE37C2BAF4D350_2041994168 = (mPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103850823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103850823;
        // ---------- Original Method ----------
        //return mPort;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.249 -0400", hash_original_method = "CC293D4A58B4AE34EE1EAFE01D7A0F93", hash_generated_method = "A1326B8424C22E2EBB0096AD467F90B8")
    public String getTransport() {
String varF2CB7A1EAFE712633AC71AFDD720A221_1948543077 =         mTransport;
        varF2CB7A1EAFE712633AC71AFDD720A221_1948543077.addTaint(taint);
        return varF2CB7A1EAFE712633AC71AFDD720A221_1948543077;
        // ---------- Original Method ----------
        //return mTransport;
    }

    
}

