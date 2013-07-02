package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLException;

public class SSLEngineAppData implements org.apache.harmony.xnet.provider.jsse.Appendable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.718 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "3923F3F9F9ECABE8D28493E863FC2CD8")

    byte[] buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.719 -0400", hash_original_method = "06EACE6E653645104AEC16265D727782", hash_generated_method = "A265DEAC1EBA95E175EB1A0A29A2449C")
    protected  SSLEngineAppData() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.719 -0400", hash_original_method = "452DC75F155E1CC98FB8D0CBD4BB0B6D", hash_generated_method = "9679A51BFFC84A3E1928B18708C94EEE")
    public void append(byte[] src) {
        {
            if (DroidSafeAndroidRuntime.control) throw new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLException("Attempt to override the data"));
        } 
        buffer = src;
        
        
            
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.719 -0400", hash_original_method = "26A62B68A47AD8599D541EA0EB845FD0", hash_generated_method = "07F879F9365F9729F3DB5C9DE387FF92")
    protected int placeTo(ByteBuffer[] dsts, int offset, int length) {
        int pos = 0;
        int len = buffer.length;
        int rem;
        {
            int i = offset;
            {
                rem = dsts[i].remaining();
                {
                    dsts[i].put(buffer, pos, len - pos);
                    pos = len;
                } 
                dsts[i].put(buffer, pos, rem);
                pos += rem;
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLException(
                    "The received application data could not be fully written"
                    + "into the destination buffers"));
        } 
        buffer = null;
        addTaint(dsts[0].getTaint());
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_447144948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_447144948;
        
        
    }

    
}

