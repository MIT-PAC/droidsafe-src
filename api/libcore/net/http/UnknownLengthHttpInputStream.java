package libcore.net.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.util.Arrays;




final class UnknownLengthHttpInputStream extends AbstractHttpInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.137 -0400", hash_original_field = "136419F556A56B4DD064ACA8F98BADEF", hash_generated_field = "A47BA202024AEED5382C6DACAC7B8715")

    private boolean inputExhausted;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.138 -0400", hash_original_method = "03287555569090C6D887554C44738812", hash_generated_method = "3A1D8FEE56FB11BB824DDC82215FC7FD")
      UnknownLengthHttpInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine) throws IOException {
        super(is, httpEngine, cacheRequest);
        addTaint(httpEngine.getTaint());
        addTaint(cacheRequest.getTaint());
        addTaint(is.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.139 -0400", hash_original_method = "E2336783F7D37948479E1E76BEFE0EF2", hash_generated_method = "680CBC63CE2145942EBB7E8EBD0F701A")
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        checkNotClosed();
        if(in == null || inputExhausted)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_603335859 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681643857 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681643857;
        } //End block
        int read = in.read(buffer, offset, count);
        if(read == -1)        
        {
            inputExhausted = true;
            endOfInput(false);
            int var6BB61E3B7BCE0931DA574D19D1D82C88_907382105 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146655617 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146655617;
        } //End block
        cacheWrite(buffer, offset, read);
        int varECAE13117D6F0584C25A9DA6C8F8415E_231965348 = (read);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694517067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694517067;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //checkNotClosed();
        //if (in == null || inputExhausted) {
            //return -1;
        //}
        //int read = in.read(buffer, offset, count);
        //if (read == -1) {
            //inputExhausted = true;
            //endOfInput(false);
            //return -1;
        //}
        //cacheWrite(buffer, offset, read);
        //return read;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.140 -0400", hash_original_method = "10BF8275103D8B9D888D9077AFBF2526", hash_generated_method = "818BCD87C572D8CDD7F33F740A6858A7")
    @Override
    public int available() throws IOException {
        checkNotClosed();
        int var02A4B89D1E17AA2B50FB5759CFA6C54D_81992211 = (in == null ? 0 : in.available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69893792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69893792;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return in == null ? 0 : in.available();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.141 -0400", hash_original_method = "EFD48677D2EFEA5B0824ED8113A97C5A", hash_generated_method = "1644A54C1517C92C491CDA334BF02BBB")
    @Override
    public void close() throws IOException {
        if(closed)        
        {
            return;
        } //End block
        closed = true;
        if(!inputExhausted)        
        {
            unexpectedEndOfInput();
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //return;
        //}
        //closed = true;
        //if (!inputExhausted) {
            //unexpectedEndOfInput();
        //}
    }

    
}

