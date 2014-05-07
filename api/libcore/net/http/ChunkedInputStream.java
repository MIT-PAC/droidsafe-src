package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.util.Arrays;

import libcore.io.Streams;

final class ChunkedInputStream extends AbstractHttpInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.177 -0500", hash_original_field = "7C2F50DA7B80834C3EBC5883220B91A4", hash_generated_field = "C5956A6D669A15373C0A4736E4DBDA7D")

    private static final int MIN_LAST_CHUNK_LENGTH = "\r\n0\r\n\r\n".length();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.179 -0500", hash_original_field = "8A758D378B9E66356E80A5AADCF1F5D4", hash_generated_field = "D686DA2F205CF442EB1A44AB0D31BF16")

    private static final int NO_CHUNK_YET = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.181 -0500", hash_original_field = "0BF31337EFE4D6E35B41A33FCF8225B8", hash_generated_field = "FDB0DA7DADF9682B7A13CAE6AF74D826")

    private int bytesRemainingInChunk = NO_CHUNK_YET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.184 -0500", hash_original_field = "5C9E22882196AB45785F170A34492461", hash_generated_field = "B67E9C22EADF6797D475937CE5ACA397")

    private boolean hasMoreChunks = true;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.186 -0500", hash_original_method = "F83C2E58EBE5A0D51F69F747FEAA67C2", hash_generated_method = "F83C2E58EBE5A0D51F69F747FEAA67C2")
    
ChunkedInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine) throws IOException {
        super(is, httpEngine, cacheRequest);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.189 -0500", hash_original_method = "A69C93E854B37E522584F08EF88E59BD", hash_generated_method = "DBB71B4DE0D29A8F21B556BD955CF36C")
    
@Override public int read(byte[] buffer, int offset, int count) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        checkNotClosed();

        if (!hasMoreChunks) {
            return -1;
        }
        if (bytesRemainingInChunk == 0 || bytesRemainingInChunk == NO_CHUNK_YET) {
            readChunkSize();
            if (!hasMoreChunks) {
                return -1;
            }
        }
        int read = in.read(buffer, offset, Math.min(count, bytesRemainingInChunk));
        if (read == -1) {
            unexpectedEndOfInput(); // the server didn't supply the promised chunk length
            throw new IOException("unexpected end of stream");
        }
        bytesRemainingInChunk -= read;
        cacheWrite(buffer, offset, read);

        /*
         * If we're at the end of a chunk and the next chunk size is readable,
         * read it! Reading the last chunk causes the underlying connection to
         * be recycled and we want to do that as early as possible. Otherwise
         * self-delimiting streams like gzip will never be recycled.
         * http://code.google.com/p/android/issues/detail?id=7059
         */
        if (bytesRemainingInChunk == 0 && in.available() >= MIN_LAST_CHUNK_LENGTH) {
            readChunkSize();
        }

        return read;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.192 -0500", hash_original_method = "140E1DA8E8861D1C317B4255A250B320", hash_generated_method = "70353ABF92C74D7D5E8E619BA9901C71")
    
private void readChunkSize() throws IOException {
        // read the suffix of the previous chunk
        if (bytesRemainingInChunk != NO_CHUNK_YET) {
            Streams.readAsciiLine(in);
        }
        String chunkSizeString = Streams.readAsciiLine(in);
        int index = chunkSizeString.indexOf(";");
        if (index != -1) {
            chunkSizeString = chunkSizeString.substring(0, index);
        }
        try {
            bytesRemainingInChunk = Integer.parseInt(chunkSizeString.trim(), 16);
        } catch (NumberFormatException e) {
            throw new IOException("Expected a hex chunk size, but was " + chunkSizeString);
        }
        if (bytesRemainingInChunk == 0) {
            hasMoreChunks = false;
            httpEngine.readTrailers();
            endOfInput(true);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.195 -0500", hash_original_method = "637FFB0CF7184A6B5BB58296121EFC54", hash_generated_method = "97EA194C9760A426EFA8CDE2FE8F0AAD")
    
@Override public int available() throws IOException {
        checkNotClosed();
        if (!hasMoreChunks || bytesRemainingInChunk == NO_CHUNK_YET) {
            return 0;
        }
        return Math.min(in.available(), bytesRemainingInChunk);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.198 -0500", hash_original_method = "A3F7257F208C4120BEF39F0167994D8B", hash_generated_method = "43ADE6742C42963FB294025234398842")
    
@Override public void close() throws IOException {
        if (closed) {
            return;
        }

        closed = true;
        if (hasMoreChunks) {
            unexpectedEndOfInput();
        }
    }
}

