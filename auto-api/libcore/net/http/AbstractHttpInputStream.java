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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.702 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1EF0A70CD08BE8D63EB2015C913859E5")

    protected InputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.702 -0400", hash_original_field = "12BD04D71374CA2E73A86679C18FC108", hash_generated_field = "A09A97FB50D803FD23447464F21563B5")

    protected HttpEngine httpEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.702 -0400", hash_original_field = "58E157FA6A49A1EC60FEBC3530BD26A5", hash_generated_field = "B13716E9F9AD1E06D30597F387AAA548")

    private CacheRequest cacheRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.702 -0400", hash_original_field = "E8055301501797F6D5DA45CBF5760200", hash_generated_field = "D0AC45CDB02C56E3854DB3EAB2AF3DBC")

    private OutputStream cacheBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.702 -0400", hash_original_field = "349E686330723975502E9EF4F939A5AC", hash_generated_field = "BA207E645FA463C53A82992C378F82FC")

    protected boolean closed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.707 -0400", hash_original_method = "6245049C2A6A145F2B06E5BE82F53149", hash_generated_method = "9025BC187AC189F7FAAF31CAAE9B3040")
      AbstractHttpInputStream(InputStream in, HttpEngine httpEngine,
            CacheRequest cacheRequest) throws IOException {
        this.in = in;
        this.httpEngine = httpEngine;
        OutputStream cacheBody;
        cacheBody = cacheRequest.getBody();
        cacheBody = null;
        {
            cacheRequest = null;
        } //End block
        this.cacheBody = cacheBody;
        this.cacheRequest = cacheRequest;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.707 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "CBBFEE35B15FD438AE47ACABEF89DD3A")
    @Override
    public final int read() throws IOException {
        int var5941BF1153E2E81479FC3BECE4E461FF_1718280515 = (Streams.readSingleByte(this));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273164101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273164101;
        // ---------- Original Method ----------
        //return Streams.readSingleByte(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.707 -0400", hash_original_method = "9C8C395306DF0EF2B124A9030249421B", hash_generated_method = "7ED5824944EAAD3891275A558A397A99")
    protected final void checkNotClosed() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("stream closed");
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("stream closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.708 -0400", hash_original_method = "F99DAA756C38E790D14E093C328A014A", hash_generated_method = "B05A57987598B08718AF46A218584EEF")
    protected final void cacheWrite(byte[] buffer, int offset, int count) throws IOException {
        {
            cacheBody.write(buffer, offset, count);
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        // ---------- Original Method ----------
        //if (cacheBody != null) {
            //cacheBody.write(buffer, offset, count);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.708 -0400", hash_original_method = "B3EBF796D65123BF085C9E1DA5AFCD9A", hash_generated_method = "AFF72B785300F2D6065348FCCD714AFE")
    protected final void endOfInput(boolean reuseSocket) throws IOException {
        {
            cacheBody.close();
        } //End block
        httpEngine.release(reuseSocket);
        addTaint(reuseSocket);
        // ---------- Original Method ----------
        //if (cacheRequest != null) {
            //cacheBody.close();
        //}
        //httpEngine.release(reuseSocket);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.708 -0400", hash_original_method = "2A1CD1BA2665856DC3A1B988519977B9", hash_generated_method = "F0D36569A02A435A3F084A7BBCFDB27D")
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

