package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.EventObject;

public class IOExceptionEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.013 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.013 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.013 -0400", hash_original_field = "DDB508BA6BDDCDC9D416A8817238314C", hash_generated_field = "788577C3039958B2B9A8239518A26917")

    private String mTransport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.015 -0400", hash_original_method = "B65431E37A5EA3D43D49DD68F5D308D7", hash_generated_method = "F0BFCC67DAF990D0FC5A438F3EC3816E")
    public  IOExceptionEvent(Object source, String host, int port,
            String transport) {
        super(source);
        mHost = host;
        mPort = port;
        mTransport = transport;
        addTaint(source.getTaint());
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.017 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "15B3A67E113B66578EF4AD697235DC98")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_277301549 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_277301549 = mHost;
        varB4EAC82CA7396A68D541C85D26508E83_277301549.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_277301549;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.019 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "BD9A6A9627B08FBA2F2F67C781A20078")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_758747965 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_758747965;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.019 -0400", hash_original_method = "CC293D4A58B4AE34EE1EAFE01D7A0F93", hash_generated_method = "C97096E326D425F2BDA4DBF8C474ADD8")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_390391262 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_390391262 = mTransport;
        varB4EAC82CA7396A68D541C85D26508E83_390391262.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_390391262;
        
        
    }

    
}

