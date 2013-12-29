package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;




final class FixedLengthOutputStream extends AbstractHttpOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.230 -0500", hash_original_field = "E040E41AD170B59C0C0B918B5BFE7983", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private  OutputStream socketOut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.230 -0500", hash_original_field = "85E14E76D885CFD0C41B5E514C78B157", hash_generated_field = "ECAE5742BF4A68ADC431E811786D5F2D")

    private int bytesRemaining;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.231 -0500", hash_original_method = "CD6D5F7765163EE89DC0FFBAC0DC51D9", hash_generated_method = "0C6D05D16D091EB795516BBF9E56B72B")
    public FixedLengthOutputStream(OutputStream socketOut, int bytesRemaining) {
        this.socketOut = socketOut;
        this.bytesRemaining = bytesRemaining;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.232 -0500", hash_original_method = "954563C6DA4D081D04FBFCB6C3DCBDF3", hash_generated_method = "2800F8B50156B94FD924ED7965570D8B")
    @Override
public void write(byte[] buffer, int offset, int count) throws IOException {
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        if (count > bytesRemaining) {
            throw new IOException("expected " + bytesRemaining + " bytes but received " + count);
        }
        socketOut.write(buffer, offset, count);
        bytesRemaining -= count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.233 -0500", hash_original_method = "5CB5A053EE4A231C6D0A0D598E9BEDBB", hash_generated_method = "304DBF513455DAB903E1E5D173E3CB18")
    @Override
public void flush() throws IOException {
        if (closed) {
            return; // don't throw; this stream might have been closed on the caller's behalf
        }
        socketOut.flush();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.234 -0500", hash_original_method = "FCB6BF5DC7C6AA8912495FC6DAF3D35C", hash_generated_method = "079CB3A803854F6F5634D5FA3EFEAB3A")
    @Override
public void close() throws IOException {
        if (closed) {
            return;
        }
        closed = true;
        if (bytesRemaining > 0) {
            throw new IOException("unexpected end of stream");
        }
    }

    
}

