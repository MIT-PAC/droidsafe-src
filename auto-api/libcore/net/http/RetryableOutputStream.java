package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

final class RetryableOutputStream extends AbstractHttpOutputStream {
    private int limit;
    private ByteArrayOutputStream content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.562 -0400", hash_original_method = "A832DB079A79DDBD6BA954E86DE3CFE0", hash_generated_method = "AF7CE7DCB739F82ECFA73981EB9BC473")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RetryableOutputStream(int limit) {
        dsTaint.addTaint(limit);
        this.content = new ByteArrayOutputStream(limit);
        // ---------- Original Method ----------
        //this.limit = limit;
        //this.content = new ByteArrayOutputStream(limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.562 -0400", hash_original_method = "ACF7E60D1B2648BBC92003365E201CCA", hash_generated_method = "A24CA35E6EF5C5C312D9E235C2290F0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RetryableOutputStream() {
        this.limit = -1;
        this.content = new ByteArrayOutputStream();
        // ---------- Original Method ----------
        //this.limit = -1;
        //this.content = new ByteArrayOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.563 -0400", hash_original_method = "01295B07B18E8DACBE5B67B8ED73AB45", hash_generated_method = "BE7A2238AA4263332FE06C0B6A27EDD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void close() throws IOException {
        closed = true;
        {
            boolean var50E8CD48722C1B9E09AE4A46E08CD76F_638131600 = (content.size() < limit);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("content-length promised "
                    + limit + " bytes, but received " + content.size());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (closed) {
            //return;
        //}
        //closed = true;
        //if (content.size() < limit) {
            //throw new IOException("content-length promised "
                    //+ limit + " bytes, but received " + content.size());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.563 -0400", hash_original_method = "E1F3BEFD89D2B57927FA9AF72B0F2441", hash_generated_method = "C8E251951E2218299E29A76B1D71278C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void write(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        {
            boolean varFBB799FD761160C95C8FC26A815AB363_1631105614 = (limit != -1 && content.size() > limit - count);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("exceeded content-length limit of " + limit + " bytes");
            } //End block
        } //End collapsed parenthetic
        content.write(buffer, offset, count);
        // ---------- Original Method ----------
        //checkNotClosed();
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //if (limit != -1 && content.size() > limit - count) {
            //throw new IOException("exceeded content-length limit of " + limit + " bytes");
        //}
        //content.write(buffer, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.563 -0400", hash_original_method = "D6DA405C75C9B4A91F36F560BEF2D916", hash_generated_method = "BEC6B69FC7859958438CF4063682D81A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int contentLength() throws IOException {
        close();
        int varDB70D34537E06261AFD915EBB900B2E4_1894665076 = (content.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //close();
        //return content.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.563 -0400", hash_original_method = "13EC0747B327446249F03815D15BF368", hash_generated_method = "68C248CDF080F0F396C007D14FCF40D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToSocket(OutputStream socketOut) throws IOException {
        dsTaint.addTaint(socketOut.dsTaint);
        content.writeTo(socketOut);
        // ---------- Original Method ----------
        //content.writeTo(socketOut);
    }

    
}

