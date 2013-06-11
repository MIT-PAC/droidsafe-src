package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;

public class ByteArrayOutputStream extends OutputStream {
    protected byte[] buf;
    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.401 -0400", hash_original_method = "4DC3C0B5ECFA05562A9AFEF7B1CF9D45", hash_generated_method = "E6136D457930A8536644FB9129EBFE0D")
    @DSModeled(DSC.SAFE)
    public ByteArrayOutputStream() {
        buf = new byte[32];
        // ---------- Original Method ----------
        //buf = new byte[32];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.401 -0400", hash_original_method = "931B663776F41DA70E9677006016F16F", hash_generated_method = "7E516F09880B80DF82FE0B94A4BC240D")
    @DSModeled(DSC.SAFE)
    public ByteArrayOutputStream(int size) {
        dsTaint.addTaint(size);
        {
            buf = new byte[size];
        } //End block
        {
            throw new IllegalArgumentException("size < 0");
        } //End block
        // ---------- Original Method ----------
        //if (size >= 0) {
            //buf = new byte[size];
        //} else {
            //throw new IllegalArgumentException("size < 0");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.401 -0400", hash_original_method = "04777FE12371C5E12A689BB328BF05B3", hash_generated_method = "7634D140A7D352291FB336C985D0FBF7")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() throws IOException {
        super.close();
        // ---------- Original Method ----------
        //super.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.402 -0400", hash_original_method = "D6EC9446F27E74EA041BF330AAB72CEF", hash_generated_method = "2E28D91B4523B52D0F85663F30ADBE50")
    @DSModeled(DSC.SAFE)
    private void expand(int i) {
        dsTaint.addTaint(i);
        byte[] newbuf;
        newbuf = new byte[(count + i) * 2];
        System.arraycopy(buf, 0, newbuf, 0, count);
        buf = newbuf;
        // ---------- Original Method ----------
        //if (count + i <= buf.length) {
            //return;
        //}
        //byte[] newbuf = new byte[(count + i) * 2];
        //System.arraycopy(buf, 0, newbuf, 0, count);
        //buf = newbuf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.402 -0400", hash_original_method = "D84F167B372983A8A32E17B936FA6E9B", hash_generated_method = "E13B6DC638A0CAF32522EE6BADDFB556")
    @DSModeled(DSC.SAFE)
    public synchronized void reset() {
        count = 0;
        // ---------- Original Method ----------
        //count = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.402 -0400", hash_original_method = "F417CE3385B772AADA134FBE4FF63C9E", hash_generated_method = "29A5FA459A653406A8EC5005A3351299")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.402 -0400", hash_original_method = "F52D84F15F793E7D52B479C7891604F2", hash_generated_method = "F0B54909F337BCD8AB5415407E6D681D")
    @DSModeled(DSC.SAFE)
    public synchronized byte[] toByteArray() {
        byte[] newArray;
        newArray = new byte[count];
        System.arraycopy(buf, 0, newArray, 0, count);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] newArray = new byte[count];
        //System.arraycopy(buf, 0, newArray, 0, count);
        //return newArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.402 -0400", hash_original_method = "2951DD657350D2DCE6E576199EA1BCE5", hash_generated_method = "DDD89D3842F4D695CFFF742D9471DC0A")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new String(buf, 0, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.402 -0400", hash_original_method = "3E105C3C1F43529FE32D861B80701B8D", hash_generated_method = "598B4B53C2B63CD920EFCFD6A84DF244")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String toString(int hibyte) {
        dsTaint.addTaint(hibyte);
        char[] newBuf;
        newBuf = new char[size()];
        {
            int i;
            i = 0;
            {
                newBuf[i] = (char) (((hibyte & 0xff) << 8) | (buf[i] & 0xff));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //char[] newBuf = new char[size()];
        //for (int i = 0; i < newBuf.length; i++) {
            //newBuf[i] = (char) (((hibyte & 0xff) << 8) | (buf[i] & 0xff));
        //}
        //return new String(newBuf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.402 -0400", hash_original_method = "E8B99C45FE2629BCCA1491714FD1F75F", hash_generated_method = "2A9CCD70C31DBDCD32BEAE1D660643DF")
    @DSModeled(DSC.SAFE)
    public String toString(String enc) throws UnsupportedEncodingException {
        dsTaint.addTaint(enc);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new String(buf, 0, count, enc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.402 -0400", hash_original_method = "6803EEF19C65AA8F03D81EBEC2EC6C85", hash_generated_method = "E9BE91CC22B5C81AF40D12E18A579370")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void write(byte[] buffer, int offset, int len) {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, len);
        expand(len);
        System.arraycopy(buffer, offset, buf, this.count, len);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, len);
        //if (len == 0) {
            //return;
        //}
        //expand(len);
        //System.arraycopy(buffer, offset, buf, this.count, len);
        //this.count += len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.402 -0400", hash_original_method = "0E8EDDE6C6CD9DF7AD28FE0F8F877448", hash_generated_method = "9654FEAE33E9EC4A1C6E1C8A9BEEF732")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void write(int oneByte) {
        dsTaint.addTaint(oneByte);
        {
            expand(1);
        } //End block
        buf[count++] = (byte) oneByte;
        // ---------- Original Method ----------
        //if (count == buf.length) {
            //expand(1);
        //}
        //buf[count++] = (byte) oneByte;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.402 -0400", hash_original_method = "19AD6C910070CA1BF00692AA88EF7627", hash_generated_method = "06D62D08B2940C135DFEE9B38DE7F741")
    @DSModeled(DSC.SAFE)
    public synchronized void writeTo(OutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        out.write(buf, 0, count);
        // ---------- Original Method ----------
        //out.write(buf, 0, count);
    }

    
}


