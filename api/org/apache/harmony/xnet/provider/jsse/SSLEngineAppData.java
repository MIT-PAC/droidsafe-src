package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLException;

public class SSLEngineAppData implements org.apache.harmony.xnet.provider.jsse.Appendable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.916 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "3923F3F9F9ECABE8D28493E863FC2CD8")

    byte[] buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.917 -0400", hash_original_method = "06EACE6E653645104AEC16265D727782", hash_generated_method = "A265DEAC1EBA95E175EB1A0A29A2449C")
    protected  SSLEngineAppData() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.917 -0400", hash_original_method = "452DC75F155E1CC98FB8D0CBD4BB0B6D", hash_generated_method = "B43B10FEE3CDF7C1E06CE2EB2B06F093")
    public void append(byte[] src) {
    if(buffer != null)        
        {
            AlertException var065FFEBD459357CED59A74C4E3B5A523_514230473 = new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLException("Attempt to override the data"));
            var065FFEBD459357CED59A74C4E3B5A523_514230473.addTaint(taint);
            throw var065FFEBD459357CED59A74C4E3B5A523_514230473;
        } 
        buffer = src;
        
        
            
                
                
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.918 -0400", hash_original_method = "26A62B68A47AD8599D541EA0EB845FD0", hash_generated_method = "F63F7F40D2E1B66E2F4653E1BF0B139B")
    protected int placeTo(ByteBuffer[] dsts, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(dsts[0].getTaint());
    if(buffer == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_151104617 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311384882 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_311384882;
        } 
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
            } 
            dsts[i].put(buffer, pos, rem);
            pos += rem;
        } 
    if(pos != len)        
        {
            AlertException var9D1E8B54783623D66E9493E73F95A168_2015714125 = new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLException(
                    "The received application data could not be fully written"
                    + "into the destination buffers"));
            var9D1E8B54783623D66E9493E73F95A168_2015714125.addTaint(taint);
            throw var9D1E8B54783623D66E9493E73F95A168_2015714125;
        } 
        buffer = null;
        int varF5A8E923F8CD24B56B3BAB32358CC58A_359687249 = (len);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396901898 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396901898;
        
        
    }

    
}

