package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventObject;






public class IOExceptionEvent extends EventObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.944 -0500", hash_original_field = "608081BE7A68D9B383C7D78BD9FDC0E8", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.945 -0500", hash_original_field = "AAAF8A3C293EA5711E38C28140852BDE", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.946 -0500", hash_original_field = "7C1F685C2C639361AD31CAD5281B3BAD", hash_generated_field = "788577C3039958B2B9A8239518A26917")

    private String mTransport;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.947 -0500", hash_original_method = "B65431E37A5EA3D43D49DD68F5D308D7", hash_generated_method = "AD081AAFF61693A30F62CA388B850326")
    public IOExceptionEvent(Object source, String host, int port,
            String transport) {
        super(source);
        mHost = host;
        mPort = port;
        mTransport = transport;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.947 -0500", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "6A355E9CFD8CF295DC08D3692B6B0773")
    public String getHost() {
        return mHost;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.948 -0500", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "33B8E8C1C43AC396F100852932189626")
    public int getPort() {
        return mPort;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.949 -0500", hash_original_method = "CC293D4A58B4AE34EE1EAFE01D7A0F93", hash_generated_method = "D4ED90102791E8149C0CC3A16376CC2F")
    public String getTransport() {
        return mTransport;
    }

    
}

