package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.util.Arrays;

final class UnknownLengthHttpInputStream extends AbstractHttpInputStream {
    private boolean inputExhausted;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.565 -0400", hash_original_method = "03287555569090C6D887554C44738812", hash_generated_method = "3D42D6271C7E9632294BBAEA14071FC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     UnknownLengthHttpInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine) throws IOException {
        super(is, httpEngine, cacheRequest);
        dsTaint.addTaint(cacheRequest.dsTaint);
        dsTaint.addTaint(is.dsTaint);
        dsTaint.addTaint(httpEngine.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.566 -0400", hash_original_method = "E2336783F7D37948479E1E76BEFE0EF2", hash_generated_method = "F37DEF6F9533E8375CA0601161F89C98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        checkNotClosed();
        int read;
        read = in.read(buffer, offset, count);
        {
            inputExhausted = true;
            endOfInput(false);
        } //End block
        cacheWrite(buffer, offset, read);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //checkNotClosed();
        //if (in == null || inputExhausted) {
            //return -1;
        //}
        //int read = in.read(buffer, offset, count);
        //if (read == -1) {
            //inputExhausted = true;
            //endOfInput(false);
            //return -1;
        //}
        //cacheWrite(buffer, offset, read);
        //return read;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.566 -0400", hash_original_method = "10BF8275103D8B9D888D9077AFBF2526", hash_generated_method = "4CC2F0D488F25C5017188218250FA039")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        checkNotClosed();
        {
            Object varE4FA4B6C8AF71619986F605D31C31FCE_883418808 = (in.available());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return in == null ? 0 : in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.566 -0400", hash_original_method = "EFD48677D2EFEA5B0824ED8113A97C5A", hash_generated_method = "5BED66F8770F620AC69D821ABE86ED2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        closed = true;
        {
            unexpectedEndOfInput();
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //return;
        //}
        //closed = true;
        //if (!inputExhausted) {
            //unexpectedEndOfInput();
        //}
    }

    
}

