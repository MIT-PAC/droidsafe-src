package org.apache.commons.io.input;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public class BoundedInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.066 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.066 -0400", hash_original_field = "2FFE4E77325D9A7152F7086EA7AA5114", hash_generated_field = "5B2AB7FACB5522D79218E5E18F9B6725")

    private long max;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.066 -0400", hash_original_field = "30905E6E8D02502121446F7E78ED3C72", hash_generated_field = "337E67B29A254DB50F39D690161DCA16")

    private long pos = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.066 -0400", hash_original_field = "AEBE787CB6F497D2AAE0B3BE79923B47", hash_generated_field = "D1E0F56B583923CB5E6B889CBA9E43DD")

    private long mark = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.066 -0400", hash_original_field = "1F73B026F416E2778B6033346294A38D", hash_generated_field = "C13C08818952F3D52164107F1B754367")

    private boolean propagateClose = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.066 -0400", hash_original_method = "BF2D432EB127F7CFDFED5801805EF7D3", hash_generated_method = "53B256EC745E58DF2AB62192FFEA7FD1")
    public  BoundedInputStream(InputStream in, long size) {
        this.max = size;
        this.in = in;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.066 -0400", hash_original_method = "B5B6039E253EDFE159BEF140A8BD9D88", hash_generated_method = "3D617828224D52082369F325A9BBA4F1")
    public  BoundedInputStream(InputStream in) {
        this(in, -1);
        addTaint(in.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.067 -0400", hash_original_method = "3B17BBAD3F2EB7B5AD570704422B04DF", hash_generated_method = "D690E67E69AEB144A22591EC508E8675")
    @Override
    public int read() throws IOException {
        int result = in.read();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306592159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306592159;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.067 -0400", hash_original_method = "19F9C1719138FA897C10FCE8AB2E8039", hash_generated_method = "CDDA03326171A6E2A50F54EF86F2C6D9")
    @Override
    public int read(byte[] b) throws IOException {
        int var0DE958D654F2028BD5D4917817F01604_946260647 = (this.read(b, 0, b.length));
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1380813530 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1380813530;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.067 -0400", hash_original_method = "6E26F3926C5C4BE64BEC3614C2578ECF", hash_generated_method = "673C3FB4FAF871A3352A29DF69E7CF9F")
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        long maxRead;
        maxRead = Math.min(len, max-pos);
        maxRead = len;
        int bytesRead = in.read(b, off, (int)maxRead);
        pos+=bytesRead;
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_167984807 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_167984807;
        
        
            
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.068 -0400", hash_original_method = "3E60C451BC527FA5E0EE5111E14B91C6", hash_generated_method = "2F6CB7BE1A7759874573DA25044C67B7")
    @Override
    public long skip(long n) throws IOException {
        long toSkip;
        toSkip = Math.min(n, max-pos);
        toSkip = n;
        long skippedBytes = in.skip(toSkip);
        pos+=skippedBytes;
        addTaint(n);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1878293982 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1878293982;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.068 -0400", hash_original_method = "E5B4C78CEEFEAE7860E3B26DF4558532", hash_generated_method = "CB781E8F2C6AB5D191593C15DA1CF8C5")
    @Override
    public int available() throws IOException {
        int var24EAD6B0ADBE270FACF6DE8FC6FC563A_901816686 = (in.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280872373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280872373;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.068 -0400", hash_original_method = "470E22CC32FA86C99C3D62D15B859950", hash_generated_method = "C507D350F4C01172F3E790E412F0415B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1261634029 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1261634029 = in.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1261634029.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1261634029;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.069 -0400", hash_original_method = "1FFBF77FC0F2EDDE2606808C3D8F55E3", hash_generated_method = "6C0BF03FDD81839BF6B71BACBB7250DF")
    @Override
    public void close() throws IOException {
        {
            in.close();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.070 -0400", hash_original_method = "BD0421AF6C1AA9CFCF6C9B3AE10A8647", hash_generated_method = "0C1B00F020F439C4EE4AFD99409E1601")
    @Override
    public synchronized void reset() throws IOException {
        in.reset();
        pos = mark;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.070 -0400", hash_original_method = "AEC932ABAD6BD3D26DA661A0D3655827", hash_generated_method = "EFE0BC8A34C8F6E1EB87E9EE8A6A7AA0")
    @Override
    public synchronized void mark(int readlimit) {
        in.mark(readlimit);
        mark = pos;
        addTaint(readlimit);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.071 -0400", hash_original_method = "41BA5D3E6CD82551F6C2FAFF3850B986", hash_generated_method = "96A8EAA60BCD207D0C45A15361F16FB6")
    @Override
    public boolean markSupported() {
        boolean var974D3C16172296A256F3C278ED264ADF_978643170 = (in.markSupported());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813444516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_813444516;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.071 -0400", hash_original_method = "B87A5A17B4254C830F655DB212D58118", hash_generated_method = "2970725D2E5C846245DEB4D1625195D9")
    public boolean isPropagateClose() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_367352108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_367352108;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.071 -0400", hash_original_method = "40C566C4C217B32854110D373EA24264", hash_generated_method = "4DC1CF27DD5AE980E4539ABB5FC5033D")
    public void setPropagateClose(boolean propagateClose) {
        this.propagateClose = propagateClose;
        
        
    }

    
}

