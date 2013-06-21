package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLException;

public class SSLEngineAppData implements org.apache.harmony.xnet.provider.jsse.Appendable {
    byte[] buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.098 -0400", hash_original_method = "06EACE6E653645104AEC16265D727782", hash_generated_method = "A265DEAC1EBA95E175EB1A0A29A2449C")
    @DSModeled(DSC.SAFE)
    protected SSLEngineAppData() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.098 -0400", hash_original_method = "452DC75F155E1CC98FB8D0CBD4BB0B6D", hash_generated_method = "C18EA7473E3AEC62A7508615DACB4D7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void append(byte[] src) {
        dsTaint.addTaint(src[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLException("Attempt to override the data"));
        } //End block
        // ---------- Original Method ----------
        //if (buffer != null) {
            //throw new AlertException(
                //AlertProtocol.INTERNAL_ERROR,
                //new SSLException("Attempt to override the data"));
        //}
        //buffer = src;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.098 -0400", hash_original_method = "26A62B68A47AD8599D541EA0EB845FD0", hash_generated_method = "BD278418A8E0D5C3417BE60B9A8AAC79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int placeTo(ByteBuffer[] dsts, int offset, int length) {
        dsTaint.addTaint(dsts[0].dsTaint);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        int pos;
        pos = 0;
        int len;
        len = buffer.length;
        int rem;
        {
            int i;
            i = offset;
            {
                rem = dsts[i].remaining();
                {
                    dsts[i].put(buffer, pos, len - pos);
                    pos = len;
                } //End block
                dsts[i].put(buffer, pos, rem);
                pos += rem;
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLException(
                    "The received application data could not be fully written"
                    + "into the destination buffers"));
        } //End block
        buffer = null;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

