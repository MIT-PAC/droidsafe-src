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
import libcore.io.Streams;

final class ChunkedInputStream extends AbstractHttpInputStream {
    private int bytesRemainingInChunk = NO_CHUNK_YET;
    private boolean hasMoreChunks = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.062 -0400", hash_original_method = "F83C2E58EBE5A0D51F69F747FEAA67C2", hash_generated_method = "6585ED4335C690F23EDE93AA153CCC10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ChunkedInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine) throws IOException {
        super(is, httpEngine, cacheRequest);
        dsTaint.addTaint(cacheRequest.dsTaint);
        dsTaint.addTaint(is.dsTaint);
        dsTaint.addTaint(httpEngine.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.062 -0400", hash_original_method = "A69C93E854B37E522584F08EF88E59BD", hash_generated_method = "402DEDAE7E40911CE861BFA2923B54E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        checkNotClosed();
        {
            readChunkSize();
        } //End block
        int read;
        read = in.read(buffer, offset, Math.min(count, bytesRemainingInChunk));
        {
            unexpectedEndOfInput();
            if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected end of stream");
        } //End block
        bytesRemainingInChunk -= read;
        cacheWrite(buffer, offset, read);
        {
            boolean var49782277C134C7E7B1CEFEB15EBC50EB_295741766 = (bytesRemainingInChunk == 0 && in.available() >= MIN_LAST_CHUNK_LENGTH);
            {
                readChunkSize();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //checkNotClosed();
        //if (!hasMoreChunks) {
            //return -1;
        //}
        //if (bytesRemainingInChunk == 0 || bytesRemainingInChunk == NO_CHUNK_YET) {
            //readChunkSize();
            //if (!hasMoreChunks) {
                //return -1;
            //}
        //}
        //int read = in.read(buffer, offset, Math.min(count, bytesRemainingInChunk));
        //if (read == -1) {
            //unexpectedEndOfInput(); 
            //throw new IOException("unexpected end of stream");
        //}
        //bytesRemainingInChunk -= read;
        //cacheWrite(buffer, offset, read);
        //if (bytesRemainingInChunk == 0 && in.available() >= MIN_LAST_CHUNK_LENGTH) {
            //readChunkSize();
        //}
        //return read;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.063 -0400", hash_original_method = "140E1DA8E8861D1C317B4255A250B320", hash_generated_method = "8FF4833797C8F23109B136D599DDD13D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readChunkSize() throws IOException {
        {
            Streams.readAsciiLine(in);
        } //End block
        String chunkSizeString;
        chunkSizeString = Streams.readAsciiLine(in);
        int index;
        index = chunkSizeString.indexOf(";");
        {
            chunkSizeString = chunkSizeString.substring(0, index);
        } //End block
        try 
        {
            bytesRemainingInChunk = Integer.parseInt(chunkSizeString.trim(), 16);
        } //End block
        catch (NumberFormatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Expected a hex chunk size, but was " + chunkSizeString);
        } //End block
        {
            hasMoreChunks = false;
            httpEngine.readTrailers();
            endOfInput(true);
        } //End block
        // ---------- Original Method ----------
        //if (bytesRemainingInChunk != NO_CHUNK_YET) {
            //Streams.readAsciiLine(in);
        //}
        //String chunkSizeString = Streams.readAsciiLine(in);
        //int index = chunkSizeString.indexOf(";");
        //if (index != -1) {
            //chunkSizeString = chunkSizeString.substring(0, index);
        //}
        //try {
            //bytesRemainingInChunk = Integer.parseInt(chunkSizeString.trim(), 16);
        //} catch (NumberFormatException e) {
            //throw new IOException("Expected a hex chunk size, but was " + chunkSizeString);
        //}
        //if (bytesRemainingInChunk == 0) {
            //hasMoreChunks = false;
            //httpEngine.readTrailers();
            //endOfInput(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.063 -0400", hash_original_method = "637FFB0CF7184A6B5BB58296121EFC54", hash_generated_method = "63A988CBB8BA13B3F4B3A6291C0681A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        checkNotClosed();
        int varDF44AEADCEEC3FCC61DA4203046614C3_1597403807 = (Math.min(in.available(), bytesRemainingInChunk));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (!hasMoreChunks || bytesRemainingInChunk == NO_CHUNK_YET) {
            //return 0;
        //}
        //return Math.min(in.available(), bytesRemainingInChunk);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.063 -0400", hash_original_method = "A3F7257F208C4120BEF39F0167994D8B", hash_generated_method = "126BBBDBB234D103394242946C8AACB4")
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
        //if (hasMoreChunks) {
            //unexpectedEndOfInput();
        //}
    }

    
    private static final int MIN_LAST_CHUNK_LENGTH = "\r\n0\r\n\r\n".length();
    private static final int NO_CHUNK_YET = -1;
}

