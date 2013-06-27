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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.389 -0400", hash_original_field = "837B811620D66AECDECD9FB207F3D4F7", hash_generated_field = "FDB0DA7DADF9682B7A13CAE6AF74D826")

    private int bytesRemainingInChunk = NO_CHUNK_YET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.389 -0400", hash_original_field = "F2767B700D21ABCF8D14F590FE4DB4E3", hash_generated_field = "B67E9C22EADF6797D475937CE5ACA397")

    private boolean hasMoreChunks = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.390 -0400", hash_original_method = "F83C2E58EBE5A0D51F69F747FEAA67C2", hash_generated_method = "FAE53C00AF83BDE38A3244498D8D1245")
      ChunkedInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine) throws IOException {
        super(is, httpEngine, cacheRequest);
        addTaint(is.getTaint());
        addTaint(cacheRequest.getTaint());
        addTaint(httpEngine.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.393 -0400", hash_original_method = "A69C93E854B37E522584F08EF88E59BD", hash_generated_method = "B07B80ABC22A2F75FE55AEA2BDCB58A8")
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
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
            boolean var49782277C134C7E7B1CEFEB15EBC50EB_702354709 = (bytesRemainingInChunk == 0 && in.available() >= MIN_LAST_CHUNK_LENGTH);
            {
                readChunkSize();
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906922566 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906922566;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.407 -0400", hash_original_method = "140E1DA8E8861D1C317B4255A250B320", hash_generated_method = "8FF4833797C8F23109B136D599DDD13D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.408 -0400", hash_original_method = "637FFB0CF7184A6B5BB58296121EFC54", hash_generated_method = "222B6D489B5E2AB5826C7BA15BA541D3")
    @Override
    public int available() throws IOException {
        checkNotClosed();
        int varDF44AEADCEEC3FCC61DA4203046614C3_1677216489 = (Math.min(in.available(), bytesRemainingInChunk));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991928187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991928187;
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (!hasMoreChunks || bytesRemainingInChunk == NO_CHUNK_YET) {
            //return 0;
        //}
        //return Math.min(in.available(), bytesRemainingInChunk);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.408 -0400", hash_original_method = "A3F7257F208C4120BEF39F0167994D8B", hash_generated_method = "126BBBDBB234D103394242946C8AACB4")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.408 -0400", hash_original_field = "745082C684F20695677D0834835747B1", hash_generated_field = "5C9C386C0453965F31B38C65AE39E648")

    private static int MIN_LAST_CHUNK_LENGTH = "\r\n0\r\n\r\n".length();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.408 -0400", hash_original_field = "2775A55E130B5CDA97B034600260B7B6", hash_generated_field = "A81B106DC12E1FF26E21CA969615C349")

    private static int NO_CHUNK_YET = -1;
}

