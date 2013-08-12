package libcore.net.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;

import libcore.io.Streams;



abstract class AbstractHttpInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.885 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1EF0A70CD08BE8D63EB2015C913859E5")

    protected InputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.885 -0400", hash_original_field = "12BD04D71374CA2E73A86679C18FC108", hash_generated_field = "A09A97FB50D803FD23447464F21563B5")

    protected HttpEngine httpEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.885 -0400", hash_original_field = "58E157FA6A49A1EC60FEBC3530BD26A5", hash_generated_field = "B13716E9F9AD1E06D30597F387AAA548")

    private CacheRequest cacheRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.885 -0400", hash_original_field = "E8055301501797F6D5DA45CBF5760200", hash_generated_field = "D0AC45CDB02C56E3854DB3EAB2AF3DBC")

    private OutputStream cacheBody;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.885 -0400", hash_original_field = "349E686330723975502E9EF4F939A5AC", hash_generated_field = "BA207E645FA463C53A82992C378F82FC")

    protected boolean closed;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.886 -0400", hash_original_method = "6245049C2A6A145F2B06E5BE82F53149", hash_generated_method = "747761486CF9B3437F7E77A9EE692C7D")
      AbstractHttpInputStream(InputStream in, HttpEngine httpEngine,
            CacheRequest cacheRequest) throws IOException {
        this.in = in;
        this.httpEngine = httpEngine;
        OutputStream cacheBody = cacheRequest != null ? cacheRequest.getBody() : null;
        if(cacheBody == null)        
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.887 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "DD1473F470370183131115D3C58226CE")
    @Override
    public final int read() throws IOException {
        int varC29A5AE95A30EE64395CAB97F32FA4B0_1161882087 = (Streams.readSingleByte(this));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302404461 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302404461;
        // ---------- Original Method ----------
        //return Streams.readSingleByte(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.888 -0400", hash_original_method = "9C8C395306DF0EF2B124A9030249421B", hash_generated_method = "DD2996C5166F22E91F5A8CD850580BE4")
    protected final void checkNotClosed() throws IOException {
        if(closed)        
        {
            IOException var8D1E5C4B5F667C4541A761B82D8E7D19_399767167 = new IOException("stream closed");
            var8D1E5C4B5F667C4541A761B82D8E7D19_399767167.addTaint(taint);
            throw var8D1E5C4B5F667C4541A761B82D8E7D19_399767167;
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("stream closed");
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.888 -0400", hash_original_method = "F99DAA756C38E790D14E093C328A014A", hash_generated_method = "F6AD2B4F17B22D6EA07A6BE0F8D9E8C8")
    protected final void cacheWrite(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        if(cacheBody != null)        
        {
            cacheBody.write(buffer, offset, count);
        } //End block
        // ---------- Original Method ----------
        //if (cacheBody != null) {
            //cacheBody.write(buffer, offset, count);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.889 -0400", hash_original_method = "B3EBF796D65123BF085C9E1DA5AFCD9A", hash_generated_method = "3225D0A341AB3AFFC8E947A7C2344A66")
    protected final void endOfInput(boolean reuseSocket) throws IOException {
        addTaint(reuseSocket);
        if(cacheRequest != null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.889 -0400", hash_original_method = "2A1CD1BA2665856DC3A1B988519977B9", hash_generated_method = "509B0E99DC89A699733427A298F88B04")
    protected final void unexpectedEndOfInput() {
        if(cacheRequest != null)        
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

