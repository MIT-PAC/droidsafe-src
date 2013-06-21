package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import libcore.io.Streams;

abstract class AbstractHttpInputStream extends InputStream {
    protected InputStream in;
    protected HttpEngine httpEngine;
    private CacheRequest cacheRequest;
    private OutputStream cacheBody;
    protected boolean closed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.056 -0400", hash_original_method = "6245049C2A6A145F2B06E5BE82F53149", hash_generated_method = "2467E88A33FA87AF80FB4D78AAB442FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     AbstractHttpInputStream(InputStream in, HttpEngine httpEngine,
            CacheRequest cacheRequest) throws IOException {
        dsTaint.addTaint(cacheRequest.dsTaint);
        dsTaint.addTaint(httpEngine.dsTaint);
        dsTaint.addTaint(in.dsTaint);
        OutputStream cacheBody;
        cacheBody = cacheRequest.getBody();
        cacheBody = null;
        {
            cacheRequest = null;
        } //End block
        this.cacheBody = cacheBody;
        // ---------- Original Method ----------
        //this.in = in;
        //this.httpEngine = httpEngine;
        //OutputStream cacheBody = cacheRequest != null ? cacheRequest.getBody() : null;
        //if (cacheBody == null) {
            //cacheRequest = null;
        //}
        //this.cacheBody = cacheBody;
        //this.cacheRequest = cacheRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.056 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "CD7690436657E5E26DB6AFB275352E54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int read() throws IOException {
        int var5941BF1153E2E81479FC3BECE4E461FF_488987976 = (Streams.readSingleByte(this));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Streams.readSingleByte(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.056 -0400", hash_original_method = "9C8C395306DF0EF2B124A9030249421B", hash_generated_method = "7ED5824944EAAD3891275A558A397A99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void checkNotClosed() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("stream closed");
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("stream closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.056 -0400", hash_original_method = "F99DAA756C38E790D14E093C328A014A", hash_generated_method = "6254BC4E7BD7F37E4450EDD5246FC021")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void cacheWrite(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        {
            cacheBody.write(buffer, offset, count);
        } //End block
        // ---------- Original Method ----------
        //if (cacheBody != null) {
            //cacheBody.write(buffer, offset, count);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.057 -0400", hash_original_method = "B3EBF796D65123BF085C9E1DA5AFCD9A", hash_generated_method = "1E7B561C5D97D9BCC6AB7ED5004EC2BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void endOfInput(boolean reuseSocket) throws IOException {
        dsTaint.addTaint(reuseSocket);
        {
            cacheBody.close();
        } //End block
        httpEngine.release(reuseSocket);
        // ---------- Original Method ----------
        //if (cacheRequest != null) {
            //cacheBody.close();
        //}
        //httpEngine.release(reuseSocket);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.057 -0400", hash_original_method = "2A1CD1BA2665856DC3A1B988519977B9", hash_generated_method = "F0D36569A02A435A3F084A7BBCFDB27D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void unexpectedEndOfInput() {
        {
            cacheRequest.abort();
        } //End block
        httpEngine.release(false);
        // ---------- Original Method ----------
        //if (cacheRequest != null) {
            //cacheRequest.abort();
        //}
        //httpEngine.release(false);
    }

    
}

