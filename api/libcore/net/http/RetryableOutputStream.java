package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;




final class RetryableOutputStream extends AbstractHttpOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.163 -0500", hash_original_field = "136FDC88CA742E83C109AD31983DA2BF", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

    private  int limit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.164 -0500", hash_original_field = "5B891CF437E7C28CDACFA0315335EFAA", hash_generated_field = "311998AF11DA0C9AD3FE931CF69A5C33")

    private  ByteArrayOutputStream content;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.165 -0500", hash_original_method = "A832DB079A79DDBD6BA954E86DE3CFE0", hash_generated_method = "C160383339CD23C2EB800543D7FEB927")
    public RetryableOutputStream(int limit) {
        this.limit = limit;
        this.content = new ByteArrayOutputStream(limit);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.166 -0500", hash_original_method = "ACF7E60D1B2648BBC92003365E201CCA", hash_generated_method = "1F009154985A291FDCB976FF76C38E99")
    public RetryableOutputStream() {
        this.limit = -1;
        this.content = new ByteArrayOutputStream();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.167 -0500", hash_original_method = "01295B07B18E8DACBE5B67B8ED73AB45", hash_generated_method = "CAA57D29E89B67611D095D7DF9C3D773")
    @Override
public synchronized void close() throws IOException {
        if (closed) {
            return;
        }
        closed = true;
        if (content.size() < limit) {
            throw new IOException("content-length promised "
                    + limit + " bytes, but received " + content.size());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.168 -0500", hash_original_method = "E1F3BEFD89D2B57927FA9AF72B0F2441", hash_generated_method = "1CB3ED1636ECEADDD866DBB78357D3E2")
    @Override
public synchronized void write(byte[] buffer, int offset, int count)
            throws IOException {
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        if (limit != -1 && content.size() > limit - count) {
            throw new IOException("exceeded content-length limit of " + limit + " bytes");
        }
        content.write(buffer, offset, count);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.169 -0500", hash_original_method = "D6DA405C75C9B4A91F36F560BEF2D916", hash_generated_method = "FE91EA0708A0A997565867A1304F2EBA")
    public synchronized int contentLength() throws IOException {
        close();
        return content.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.170 -0500", hash_original_method = "13EC0747B327446249F03815D15BF368", hash_generated_method = "E60703C4EBDB22BBCBC5BC9258CE5D1D")
    public void writeToSocket(OutputStream socketOut) throws IOException  {
        content.writeTo(socketOut);
    }

    
}

