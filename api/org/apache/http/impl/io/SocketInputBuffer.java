package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.SocketTimeoutException;
import org.apache.http.params.HttpParams;

public class SocketInputBuffer extends AbstractSessionInputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.243 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.244 -0400", hash_original_method = "7283DB9E346A36B4239C51041B32EE66", hash_generated_method = "0D2ACD98F8D1E64E9695B1CA1B1B84E1")
    public  SocketInputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        super();
        addTaint(params.getTaint());
        addTaint(buffersize);
    if(socket == null)        
        {
            IllegalArgumentException varCBABC6A96FAFFF53CCBEEA230A20A836_1450681802 = new IllegalArgumentException("Socket may not be null");
            varCBABC6A96FAFFF53CCBEEA230A20A836_1450681802.addTaint(taint);
            throw varCBABC6A96FAFFF53CCBEEA230A20A836_1450681802;
        } //End block
        this.socket = socket;
        init(socket.getInputStream(), 8192, params);
        // ---------- Original Method ----------
        //if (socket == null) {
            //throw new IllegalArgumentException("Socket may not be null");
        //}
        //this.socket = socket;
        //init(socket.getInputStream(), 8192, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.244 -0400", hash_original_method = "311ACBA3C6B98FE9C535127054B24088", hash_generated_method = "F4CCB671482D9D83F128D91B014ED826")
    public boolean isDataAvailable(int timeout) throws IOException {
        addTaint(timeout);
        boolean result = hasBufferedData();
    if(!result)        
        {
            int oldtimeout = this.socket.getSoTimeout();
            try 
            {
                this.socket.setSoTimeout(timeout);
                fillBuffer();
                result = hasBufferedData();
            } //End block
            catch (InterruptedIOException e)
            {
    if(!(e instanceof SocketTimeoutException))                
                {
                    e.addTaint(taint);
                    throw e;
                } //End block
            } //End block
            finally 
            {
                socket.setSoTimeout(oldtimeout);
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_2048113791 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1377777816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1377777816;
        // ---------- Original Method ----------
        //boolean result = hasBufferedData();
        //if (!result) {
            //int oldtimeout = this.socket.getSoTimeout();
            //try {
                //this.socket.setSoTimeout(timeout);
                //fillBuffer();
                //result = hasBufferedData();
            //} catch (InterruptedIOException e) {
                //if (!(e instanceof SocketTimeoutException)) {
                    //throw e;
                //}
            //} finally {
                //socket.setSoTimeout(oldtimeout);
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.245 -0400", hash_original_method = "60456E7A862D179906482739ACBD4572", hash_generated_method = "24A7020B05B7AF5169BE9EADBFDC2DB3")
    public boolean isStale() throws IOException {
    if(hasBufferedData())        
        {
            boolean var68934A3E9455FA72420237EB05902327_674743309 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1624260660 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1624260660;
        } //End block
        int oldTimeout = this.socket.getSoTimeout();
        try 
        {
            this.socket.setSoTimeout(1);
            boolean varA211DC4BE010635677D918CB42B101A9_551360419 = (fillBuffer() == -1);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715941096 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_715941096;
        } //End block
        catch (SocketTimeoutException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_72762242 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_46316952 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_46316952;
        } //End block
        catch (IOException e)
        {
            boolean varB326B5062B2F0E69046810717534CB09_741789170 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_454229365 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_454229365;
        } //End block
        finally 
        {
            this.socket.setSoTimeout(oldTimeout);
        } //End block
        // ---------- Original Method ----------
        //if (hasBufferedData()) {
            //return false;
        //}
        //int oldTimeout = this.socket.getSoTimeout();
        //try {
            //this.socket.setSoTimeout(1);
            //return fillBuffer() == -1;
        //} catch (SocketTimeoutException e) {
            //return false; 
        //} catch (IOException e) {
            //return true; 
        //} finally {
            //this.socket.setSoTimeout(oldTimeout);
        //}
    }

    
}

