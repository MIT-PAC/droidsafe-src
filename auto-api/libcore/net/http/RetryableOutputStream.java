package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

final class RetryableOutputStream extends AbstractHttpOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.681 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

    private int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.681 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "311998AF11DA0C9AD3FE931CF69A5C33")

    private ByteArrayOutputStream content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.681 -0400", hash_original_method = "A832DB079A79DDBD6BA954E86DE3CFE0", hash_generated_method = "1352F636065EC36AE68B9261382DE447")
    public  RetryableOutputStream(int limit) {
        this.limit = limit;
        this.content = new ByteArrayOutputStream(limit);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.682 -0400", hash_original_method = "ACF7E60D1B2648BBC92003365E201CCA", hash_generated_method = "A24CA35E6EF5C5C312D9E235C2290F0F")
    public  RetryableOutputStream() {
        this.limit = -1;
        this.content = new ByteArrayOutputStream();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.682 -0400", hash_original_method = "01295B07B18E8DACBE5B67B8ED73AB45", hash_generated_method = "028CC836BEEE83DA929B6CA6E2FCF592")
    @Override
    public synchronized void close() throws IOException {
        closed = true;
        {
            boolean var50E8CD48722C1B9E09AE4A46E08CD76F_687374433 = (content.size() < limit);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("content-length promised "
                    + limit + " bytes, but received " + content.size());
            } 
        } 
        
        
            
        
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.682 -0400", hash_original_method = "E1F3BEFD89D2B57927FA9AF72B0F2441", hash_generated_method = "75C74A8407F349AA7A5989CE2AC6D811")
    @Override
    public synchronized void write(byte[] buffer, int offset, int count) throws IOException {
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        {
            boolean varFBB799FD761160C95C8FC26A815AB363_1449086305 = (limit != -1 && content.size() > limit - count);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("exceeded content-length limit of " + limit + " bytes");
            } 
        } 
        content.write(buffer, offset, count);
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.683 -0400", hash_original_method = "D6DA405C75C9B4A91F36F560BEF2D916", hash_generated_method = "1CAE2101E41E4F8CEB49D12124446827")
    public synchronized int contentLength() throws IOException {
        close();
        int varDB70D34537E06261AFD915EBB900B2E4_270135286 = (content.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137221962 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137221962;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.683 -0400", hash_original_method = "13EC0747B327446249F03815D15BF368", hash_generated_method = "8956C120F517D63DF06A87C9F18A9571")
    public void writeToSocket(OutputStream socketOut) throws IOException {
        content.writeTo(socketOut);
        addTaint(socketOut.getTaint());
        
        
    }

    
}

