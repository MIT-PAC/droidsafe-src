package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.SocketTimeoutException;
import org.apache.http.params.HttpParams;

public class SocketInputBuffer extends AbstractSessionInputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.862 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.863 -0400", hash_original_method = "7283DB9E346A36B4239C51041B32EE66", hash_generated_method = "292FEE9031B9265B2400AEC25482C231")
    public  SocketInputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket may not be null");
        } 
        this.socket = socket;
        init(socket.getInputStream(), 8192, params);
        addTaint(buffersize);
        addTaint(params.getTaint());
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.863 -0400", hash_original_method = "311ACBA3C6B98FE9C535127054B24088", hash_generated_method = "AD9640A07F5DD5976B03F3B48DB36D7A")
    public boolean isDataAvailable(int timeout) throws IOException {
        boolean result = hasBufferedData();
        {
            int oldtimeout = this.socket.getSoTimeout();
            try 
            {
                this.socket.setSoTimeout(timeout);
                fillBuffer();
                result = hasBufferedData();
            } 
            catch (InterruptedIOException e)
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } 
            } 
            finally 
            {
                socket.setSoTimeout(oldtimeout);
            } 
        } 
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1914570230 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1914570230;
        
        
        
            
            
                
                
                
            
                
                    
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.864 -0400", hash_original_method = "60456E7A862D179906482739ACBD4572", hash_generated_method = "9503BADA5D684FA285F2E77DA222D7FE")
    public boolean isStale() throws IOException {
        {
            boolean varB375C9FBB8674FD44EC5D7689147F560_205304154 = (hasBufferedData());
        } 
        int oldTimeout = this.socket.getSoTimeout();
        try 
        {
            this.socket.setSoTimeout(1);
            boolean var54D909F0FF0CB86D2219C78D758AE242_989320326 = (fillBuffer() == -1);
        } 
        catch (SocketTimeoutException e)
        { }
        catch (IOException e)
        { }
        finally 
        {
            this.socket.setSoTimeout(oldTimeout);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413281656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_413281656;
        
        
            
        
        
        
            
            
        
            
        
            
        
            
        
    }

    
}

