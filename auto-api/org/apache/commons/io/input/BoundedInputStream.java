package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public class BoundedInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.878 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.878 -0400", hash_original_field = "2FFE4E77325D9A7152F7086EA7AA5114", hash_generated_field = "5B2AB7FACB5522D79218E5E18F9B6725")

    private long max;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.878 -0400", hash_original_field = "30905E6E8D02502121446F7E78ED3C72", hash_generated_field = "337E67B29A254DB50F39D690161DCA16")

    private long pos = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.878 -0400", hash_original_field = "AEBE787CB6F497D2AAE0B3BE79923B47", hash_generated_field = "D1E0F56B583923CB5E6B889CBA9E43DD")

    private long mark = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.878 -0400", hash_original_field = "1F73B026F416E2778B6033346294A38D", hash_generated_field = "C13C08818952F3D52164107F1B754367")

    private boolean propagateClose = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.878 -0400", hash_original_method = "BF2D432EB127F7CFDFED5801805EF7D3", hash_generated_method = "53B256EC745E58DF2AB62192FFEA7FD1")
    public  BoundedInputStream(InputStream in, long size) {
        this.max = size;
        this.in = in;
        // ---------- Original Method ----------
        //this.max = size;
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.879 -0400", hash_original_method = "B5B6039E253EDFE159BEF140A8BD9D88", hash_generated_method = "3D617828224D52082369F325A9BBA4F1")
    public  BoundedInputStream(InputStream in) {
        this(in, -1);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.879 -0400", hash_original_method = "3B17BBAD3F2EB7B5AD570704422B04DF", hash_generated_method = "404ED30B5366EFACBB38C267BA7E69A3")
    @Override
    public int read() throws IOException {
        int result;
        result = in.read();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1550566654 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1550566654;
        // ---------- Original Method ----------
        //if (max >= 0 && pos >= max) {
            //return -1;
        //}
        //int result = in.read();
        //pos++;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.879 -0400", hash_original_method = "19F9C1719138FA897C10FCE8AB2E8039", hash_generated_method = "E92689882550D78417A22829107D3042")
    @Override
    public int read(byte[] b) throws IOException {
        int var0DE958D654F2028BD5D4917817F01604_2126517533 = (this.read(b, 0, b.length));
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_551345802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_551345802;
        // ---------- Original Method ----------
        //return this.read(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.880 -0400", hash_original_method = "6E26F3926C5C4BE64BEC3614C2578ECF", hash_generated_method = "C3F34ED6E7D484DD8C509546D1D351EB")
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        long maxRead;
        maxRead = Math.min(len, max-pos);
        maxRead = len;
        int bytesRead;
        bytesRead = in.read(b, off, (int)maxRead);
        pos+=bytesRead;
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33131339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33131339;
        // ---------- Original Method ----------
        //if (max>=0 && pos>=max) {
            //return -1;
        //}
        //long maxRead = max>=0 ? Math.min(len, max-pos) : len;
        //int bytesRead = in.read(b, off, (int)maxRead);
        //if (bytesRead==-1) {
            //return -1;
        //}
        //pos+=bytesRead;
        //return bytesRead;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.880 -0400", hash_original_method = "3E60C451BC527FA5E0EE5111E14B91C6", hash_generated_method = "41A29BD5B4BF96D916C33D8E0838E3F4")
    @Override
    public long skip(long n) throws IOException {
        long toSkip;
        toSkip = Math.min(n, max-pos);
        toSkip = n;
        long skippedBytes;
        skippedBytes = in.skip(toSkip);
        pos+=skippedBytes;
        addTaint(n);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_144341086 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_144341086;
        // ---------- Original Method ----------
        //long toSkip = max>=0 ? Math.min(n, max-pos) : n;
        //long skippedBytes = in.skip(toSkip);
        //pos+=skippedBytes;
        //return skippedBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.881 -0400", hash_original_method = "E5B4C78CEEFEAE7860E3B26DF4558532", hash_generated_method = "78B5EB5E7248F67343243232F91C0885")
    @Override
    public int available() throws IOException {
        int var24EAD6B0ADBE270FACF6DE8FC6FC563A_1155711427 = (in.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619704429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619704429;
        // ---------- Original Method ----------
        //if (max>=0 && pos>=max) {
            //return 0;
        //}
        //return in.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.881 -0400", hash_original_method = "470E22CC32FA86C99C3D62D15B859950", hash_generated_method = "38350BEB714E683F19B7925AA9F944E7")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1575862135 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1575862135 = in.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1575862135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1575862135;
        // ---------- Original Method ----------
        //return in.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.888 -0400", hash_original_method = "1FFBF77FC0F2EDDE2606808C3D8F55E3", hash_generated_method = "6C0BF03FDD81839BF6B71BACBB7250DF")
    @Override
    public void close() throws IOException {
        {
            in.close();
        } //End block
        // ---------- Original Method ----------
        //if (propagateClose) {
            //in.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.888 -0400", hash_original_method = "BD0421AF6C1AA9CFCF6C9B3AE10A8647", hash_generated_method = "0C1B00F020F439C4EE4AFD99409E1601")
    @Override
    public synchronized void reset() throws IOException {
        in.reset();
        pos = mark;
        // ---------- Original Method ----------
        //in.reset();
        //pos = mark;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.888 -0400", hash_original_method = "AEC932ABAD6BD3D26DA661A0D3655827", hash_generated_method = "EFE0BC8A34C8F6E1EB87E9EE8A6A7AA0")
    @Override
    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
        mark = pos;
        addTaint(readlimit);
        // ---------- Original Method ----------
        //in.mark(readlimit);
        //mark = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.893 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "A1F7FE066C2CAB44C1AEC9B5650AB832")
    @Override
    public boolean markSupported() {
        boolean var974D3C16172296A256F3C278ED264ADF_1429356447 = (in.markSupported());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_318061534 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_318061534;
        // ---------- Original Method ----------
        //return in.markSupported();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.893 -0400", hash_original_method = "B87A5A17B4254C830F655DB212D58118", hash_generated_method = "EE1C30719E1B36A1108FC9331044BB3C")
    public boolean isPropagateClose() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_825929048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_825929048;
        // ---------- Original Method ----------
        //return propagateClose;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.899 -0400", hash_original_method = "40C566C4C217B32854110D373EA24264", hash_generated_method = "4DC1CF27DD5AE980E4539ABB5FC5033D")
    public void setPropagateClose(boolean propagateClose) {
        this.propagateClose = propagateClose;
        // ---------- Original Method ----------
        //this.propagateClose = propagateClose;
    }

    
}

