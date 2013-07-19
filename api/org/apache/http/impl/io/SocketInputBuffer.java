package org.apache.http.impl.io;

// Droidsafe Imports
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.http.params.HttpParams;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class SocketInputBuffer extends AbstractSessionInputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.641 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.642 -0400", hash_original_method = "7283DB9E346A36B4239C51041B32EE66", hash_generated_method = "857010EDEC3B759C88CA59C08AE425E1")
    public  SocketInputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        super();
        addTaint(params.getTaint());
        addTaint(buffersize);
        if(socket == null)        
        {
            IllegalArgumentException varCBABC6A96FAFFF53CCBEEA230A20A836_975045933 = new IllegalArgumentException("Socket may not be null");
            varCBABC6A96FAFFF53CCBEEA230A20A836_975045933.addTaint(taint);
            throw varCBABC6A96FAFFF53CCBEEA230A20A836_975045933;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.643 -0400", hash_original_method = "311ACBA3C6B98FE9C535127054B24088", hash_generated_method = "8DF51BCA2A7D9C779715959BE9BBC17A")
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
        boolean varB4A88417B3D0170D754C647C30B7216A_1852277281 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_245068960 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_245068960;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.644 -0400", hash_original_method = "60456E7A862D179906482739ACBD4572", hash_generated_method = "B5EA4E6C795570B2DD4122094306122A")
    public boolean isStale() throws IOException {
        if(hasBufferedData())        
        {
            boolean var68934A3E9455FA72420237EB05902327_607704467 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1965421807 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1965421807;
        } //End block
        int oldTimeout = this.socket.getSoTimeout();
        try 
        {
            this.socket.setSoTimeout(1);
            boolean varA211DC4BE010635677D918CB42B101A9_266285022 = (fillBuffer() == -1);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_616861501 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_616861501;
        } //End block
        catch (SocketTimeoutException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_137339826 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_176091045 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_176091045;
        } //End block
        catch (IOException e)
        {
            boolean varB326B5062B2F0E69046810717534CB09_1307540117 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000318037 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000318037;
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

