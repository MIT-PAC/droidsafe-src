package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class ByteArrayOutputStream extends OutputStream {
    protected byte[] buf;
    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.441 -0400", hash_original_method = "4DC3C0B5ECFA05562A9AFEF7B1CF9D45", hash_generated_method = "269B013234340EC0E9870BCC0641CB1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ByteArrayOutputStream() {
        buf = new byte[32];
        // ---------- Original Method ----------
        //buf = new byte[32];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.441 -0400", hash_original_method = "931B663776F41DA70E9677006016F16F", hash_generated_method = "0128B3B5D4D10DC22F65F62E3C333AE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ByteArrayOutputStream(int size) {
        dsTaint.addTaint(size);
        {
            buf = new byte[size];
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 0");
        } //End block
        // ---------- Original Method ----------
        //if (size >= 0) {
            //buf = new byte[size];
        //} else {
            //throw new IllegalArgumentException("size < 0");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.442 -0400", hash_original_method = "04777FE12371C5E12A689BB328BF05B3", hash_generated_method = "56FC2307CB6D5F5D1217DE945E7131B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        super.close();
        // ---------- Original Method ----------
        //super.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.442 -0400", hash_original_method = "D6EC9446F27E74EA041BF330AAB72CEF", hash_generated_method = "0FB2C9D7811BB1E0916426E40BE147EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.442 -0400", hash_original_method = "D84F167B372983A8A32E17B936FA6E9B", hash_generated_method = "400ADB088DB2A9073490DD652F495E0B")
    @DSModeled(DSC.SAFE)
    public synchronized void reset() {
        count = 0;
        // ---------- Original Method ----------
        //count = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.442 -0400", hash_original_method = "F417CE3385B772AADA134FBE4FF63C9E", hash_generated_method = "BC27CC801EC67865C37F88F8E1360D7B")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.442 -0400", hash_original_method = "F52D84F15F793E7D52B479C7891604F2", hash_generated_method = "FE1574436131A1375A8946C21D9B0C84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.443 -0400", hash_original_method = "2951DD657350D2DCE6E576199EA1BCE5", hash_generated_method = "EB9A479DC1C505661C34DB6829CF31C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var77655AA15F8197144DABDC4C3D576A32_1316645337 = (new String(buf, 0, count));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new String(buf, 0, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.443 -0400", hash_original_method = "3E105C3C1F43529FE32D861B80701B8D", hash_generated_method = "357ED2B95334AB506BDB0B354A5ECDC2")
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
        String var22FA02A4BCCC8FDAF74DC4A5BFD01BA9_1944246489 = (new String(newBuf));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //char[] newBuf = new char[size()];
        //for (int i = 0; i < newBuf.length; i++) {
            //newBuf[i] = (char) (((hibyte & 0xff) << 8) | (buf[i] & 0xff));
        //}
        //return new String(newBuf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.443 -0400", hash_original_method = "E8B99C45FE2629BCCA1491714FD1F75F", hash_generated_method = "9A67C98E7B6CAD15F28E24DD91054FBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString(String enc) throws UnsupportedEncodingException {
        dsTaint.addTaint(enc);
        String var4633CF5223F43E78EBE22D4B746A2F10_787043984 = (new String(buf, 0, count, enc));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new String(buf, 0, count, enc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.443 -0400", hash_original_method = "6803EEF19C65AA8F03D81EBEC2EC6C85", hash_generated_method = "FA5AD9BDEF3241BE929F73E6B528BE9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void write(byte[] buffer, int offset, int len) {
        dsTaint.addTaint(buffer[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.444 -0400", hash_original_method = "0E8EDDE6C6CD9DF7AD28FE0F8F877448", hash_generated_method = "431C2F35BA86903BF145B2CC1E810E20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.444 -0400", hash_original_method = "19AD6C910070CA1BF00692AA88EF7627", hash_generated_method = "ED76AFDBF1A5F69580D3482B55C96E88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void writeTo(OutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        out.write(buf, 0, count);
        // ---------- Original Method ----------
        //out.write(buf, 0, count);
    }

    
}

