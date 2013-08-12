package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.nio.ByteBuffer;

import javax.net.ssl.SSLException;






public class SSLEngineAppData implements org.apache.harmony.xnet.provider.jsse.Appendable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.095 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "3923F3F9F9ECABE8D28493E863FC2CD8")

    byte[] buffer;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.095 -0400", hash_original_method = "06EACE6E653645104AEC16265D727782", hash_generated_method = "A265DEAC1EBA95E175EB1A0A29A2449C")
    protected  SSLEngineAppData() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.096 -0400", hash_original_method = "452DC75F155E1CC98FB8D0CBD4BB0B6D", hash_generated_method = "BAD3D6354232E5FFAD1B005B9D9C45A2")
    public void append(byte[] src) {
        if(buffer != null)        
        {
            AlertException var065FFEBD459357CED59A74C4E3B5A523_1123759510 = new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLException("Attempt to override the data"));
            var065FFEBD459357CED59A74C4E3B5A523_1123759510.addTaint(taint);
            throw var065FFEBD459357CED59A74C4E3B5A523_1123759510;
        } //End block
        buffer = src;
        // ---------- Original Method ----------
        //if (buffer != null) {
            //throw new AlertException(
                //AlertProtocol.INTERNAL_ERROR,
                //new SSLException("Attempt to override the data"));
        //}
        //buffer = src;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.098 -0400", hash_original_method = "26A62B68A47AD8599D541EA0EB845FD0", hash_generated_method = "E9B2AC25E881594444FEB405CBC9D9B0")
    protected int placeTo(ByteBuffer[] dsts, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(dsts[0].getTaint());
        if(buffer == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_422813265 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463652763 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463652763;
        } //End block
        int pos = 0;
        int len = buffer.length;
        int rem;
for(int i=offset;i<offset+length;i++)
        {
            rem = dsts[i].remaining();
            if(len - pos < rem)            
            {
                dsts[i].put(buffer, pos, len - pos);
                pos = len;
                break;
            } //End block
            dsts[i].put(buffer, pos, rem);
            pos += rem;
        } //End block
        if(pos != len)        
        {
            AlertException var9D1E8B54783623D66E9493E73F95A168_2092265481 = new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLException(
                    "The received application data could not be fully written"
                    + "into the destination buffers"));
            var9D1E8B54783623D66E9493E73F95A168_2092265481.addTaint(taint);
            throw var9D1E8B54783623D66E9493E73F95A168_2092265481;
        } //End block
        buffer = null;
        int varF5A8E923F8CD24B56B3BAB32358CC58A_1987107746 = (len);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062458035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062458035;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

