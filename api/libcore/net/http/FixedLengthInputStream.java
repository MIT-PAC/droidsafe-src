package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.util.Arrays;

final class FixedLengthInputStream extends AbstractHttpInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.082 -0400", hash_original_field = "4ADE3A97C5FA51FD77AF1423B6FF76A1", hash_generated_field = "ECAE5742BF4A68ADC431E811786D5F2D")

    private int bytesRemaining;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.082 -0400", hash_original_method = "049E0503B3705DE79405E1FD5D2A2E5D", hash_generated_method = "8F023DCAA6C183FA9A2712E8971AE35B")
    public  FixedLengthInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine, int length) throws IOException {
        super(is, httpEngine, cacheRequest);
        addTaint(httpEngine.getTaint());
        addTaint(cacheRequest.getTaint());
        addTaint(is.getTaint());
        bytesRemaining = length;
    if(bytesRemaining == 0)        
        {
            endOfInput(true);
        } //End block
        // ---------- Original Method ----------
        //bytesRemaining = length;
        //if (bytesRemaining == 0) {
            //endOfInput(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.083 -0400", hash_original_method = "5B284B9FC407E028AC176D716362F3C7", hash_generated_method = "D4165663F1F1A283028A57EC4BCD865B")
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        checkNotClosed();
    if(bytesRemaining == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_500769382 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872701319 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872701319;
        } //End block
        int read = in.read(buffer, offset, Math.min(count, bytesRemaining));
    if(read == -1)        
        {
            unexpectedEndOfInput();
            IOException var9FCEBBA092763F5F75BC70A376D097E6_16711953 = new IOException("unexpected end of stream");
            var9FCEBBA092763F5F75BC70A376D097E6_16711953.addTaint(taint);
            throw var9FCEBBA092763F5F75BC70A376D097E6_16711953;
        } //End block
        bytesRemaining -= read;
        cacheWrite(buffer, offset, read);
    if(bytesRemaining == 0)        
        {
            endOfInput(true);
        } //End block
        int varECAE13117D6F0584C25A9DA6C8F8415E_1875368956 = (read);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403938331 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403938331;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //checkNotClosed();
        //if (bytesRemaining == 0) {
            //return -1;
        //}
        //int read = in.read(buffer, offset, Math.min(count, bytesRemaining));
        //if (read == -1) {
            //unexpectedEndOfInput(); 
            //throw new IOException("unexpected end of stream");
        //}
        //bytesRemaining -= read;
        //cacheWrite(buffer, offset, read);
        //if (bytesRemaining == 0) {
            //endOfInput(true);
        //}
        //return read;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.084 -0400", hash_original_method = "7AFD793A00CEC972BF0DC212CD2F3F7C", hash_generated_method = "4757E89A5AECE6153F5BAD0ED70276C7")
    @Override
    public int available() throws IOException {
        checkNotClosed();
        int varE9F2F11852EE927F4A4DAAF813745377_72783136 = (bytesRemaining == 0 ? 0 : Math.min(in.available(), bytesRemaining));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1296398954 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1296398954;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return bytesRemaining == 0 ? 0 : Math.min(in.available(), bytesRemaining);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.084 -0400", hash_original_method = "D3AA3AF2615FFDD211E9642D1EBA797E", hash_generated_method = "3FEC6778DB5C069EC99BAEF3219E375C")
    @Override
    public void close() throws IOException {
    if(closed)        
        {
            return;
        } //End block
        closed = true;
    if(bytesRemaining != 0)        
        {
            unexpectedEndOfInput();
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //return;
        //}
        //closed = true;
        //if (bytesRemaining != 0) {
            //unexpectedEndOfInput();
        //}
    }

    
}

