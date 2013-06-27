package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.SocketTimeoutException;
import org.apache.http.params.HttpParams;

public class SocketInputBuffer extends AbstractSessionInputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.830 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.831 -0400", hash_original_method = "7283DB9E346A36B4239C51041B32EE66", hash_generated_method = "292FEE9031B9265B2400AEC25482C231")
    public  SocketInputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket may not be null");
        } //End block
        this.socket = socket;
        init(socket.getInputStream(), 8192, params);
        addTaint(buffersize);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (socket == null) {
            //throw new IllegalArgumentException("Socket may not be null");
        //}
        //this.socket = socket;
        //init(socket.getInputStream(), 8192, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.832 -0400", hash_original_method = "311ACBA3C6B98FE9C535127054B24088", hash_generated_method = "45905F7CB4608B1B5ECEEF989684F70B")
    public boolean isDataAvailable(int timeout) throws IOException {
        boolean result;
        result = hasBufferedData();
        {
            int oldtimeout;
            oldtimeout = this.socket.getSoTimeout();
            try 
            {
                this.socket.setSoTimeout(timeout);
                fillBuffer();
                result = hasBufferedData();
            } //End block
            catch (InterruptedIOException e)
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
            } //End block
            finally 
            {
                socket.setSoTimeout(oldtimeout);
            } //End block
        } //End block
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_788010773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_788010773;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.836 -0400", hash_original_method = "60456E7A862D179906482739ACBD4572", hash_generated_method = "A4D8F2769987DBE05D0C71DA8EF7D2FA")
    public boolean isStale() throws IOException {
        {
            boolean varB375C9FBB8674FD44EC5D7689147F560_809737148 = (hasBufferedData());
        } //End collapsed parenthetic
        int oldTimeout;
        oldTimeout = this.socket.getSoTimeout();
        try 
        {
            this.socket.setSoTimeout(1);
            boolean var54D909F0FF0CB86D2219C78D758AE242_492924846 = (fillBuffer() == -1);
        } //End block
        catch (SocketTimeoutException e)
        { }
        catch (IOException e)
        { }
        finally 
        {
            this.socket.setSoTimeout(oldTimeout);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_653133504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_653133504;
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

