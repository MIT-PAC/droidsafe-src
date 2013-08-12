package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;






public class ByteArrayOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.465 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.465 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.465 -0400", hash_original_method = "4DC3C0B5ECFA05562A9AFEF7B1CF9D45", hash_generated_method = "269B013234340EC0E9870BCC0641CB1F")
    public  ByteArrayOutputStream() {
        buf = new byte[32];
        // ---------- Original Method ----------
        //buf = new byte[32];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.466 -0400", hash_original_method = "931B663776F41DA70E9677006016F16F", hash_generated_method = "109FDE0F61DF78A99222AB72BE070E82")
    public  ByteArrayOutputStream(int size) {
        if(size >= 0)        
        {
            buf = new byte[size];
        } //End block
        else
        {
            IllegalArgumentException var2382BBC2482763F398967EC587DEA9AE_660968886 = new IllegalArgumentException("size < 0");
            var2382BBC2482763F398967EC587DEA9AE_660968886.addTaint(taint);
            throw var2382BBC2482763F398967EC587DEA9AE_660968886;
        } //End block
        // ---------- Original Method ----------
        //if (size >= 0) {
            //buf = new byte[size];
        //} else {
            //throw new IllegalArgumentException("size < 0");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.467 -0400", hash_original_method = "04777FE12371C5E12A689BB328BF05B3", hash_generated_method = "56FC2307CB6D5F5D1217DE945E7131B9")
    @Override
    public void close() throws IOException {
        super.close();
        // ---------- Original Method ----------
        //super.close();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.468 -0400", hash_original_method = "D6EC9446F27E74EA041BF330AAB72CEF", hash_generated_method = "B52DA47CB0E5954795B9200C0FED4F41")
    private void expand(int i) {
        addTaint(i);
        if(count + i <= buf.length)        
        {
            return;
        } //End block
        byte[] newbuf = new byte[(count + i) * 2];
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.469 -0400", hash_original_method = "D84F167B372983A8A32E17B936FA6E9B", hash_generated_method = "400ADB088DB2A9073490DD652F495E0B")
    public synchronized void reset() {
        count = 0;
        // ---------- Original Method ----------
        //count = 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.470 -0400", hash_original_method = "F417CE3385B772AADA134FBE4FF63C9E", hash_generated_method = "8B3200B8A25CEEF09ABB1B7B54470113")
    public int size() {
        int varE2942A04780E223B215EB8B663CF5353_782386443 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552362184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552362184;
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.471 -0400", hash_original_method = "F52D84F15F793E7D52B479C7891604F2", hash_generated_method = "D4C3C3BC6F80C9DBDF114717DF06E0A4")
    public synchronized byte[] toByteArray() {
        byte[] newArray = new byte[count];
        System.arraycopy(buf, 0, newArray, 0, count);
        byte[] var59B359CCE81DCBF6F03CEDFA21E9B7A3_1437403344 = (newArray);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1487963903 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1487963903;
        // ---------- Original Method ----------
        //byte[] newArray = new byte[count];
        //System.arraycopy(buf, 0, newArray, 0, count);
        //return newArray;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.472 -0400", hash_original_method = "2951DD657350D2DCE6E576199EA1BCE5", hash_generated_method = "3D5643F3A2B58EF07761D2B821FC20AC")
    @Override
    public String toString() {
String var284A4624AC5D82C1992013009E0FB870_737994891 =         new String(buf, 0, count);
        var284A4624AC5D82C1992013009E0FB870_737994891.addTaint(taint);
        return var284A4624AC5D82C1992013009E0FB870_737994891;
        // ---------- Original Method ----------
        //return new String(buf, 0, count);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.474 -0400", hash_original_method = "3E105C3C1F43529FE32D861B80701B8D", hash_generated_method = "1CEC4B79548298F1CCAC859875943B86")
    @Deprecated
    public String toString(int hibyte) {
        addTaint(hibyte);
        char[] newBuf = new char[size()];
for(int i = 0;i < newBuf.length;i++)
        {
            newBuf[i] = (char) (((hibyte & 0xff) << 8) | (buf[i] & 0xff));
        } //End block
String varB2A77A3F22A466F171E40117F4960755_1534551633 =         new String(newBuf);
        varB2A77A3F22A466F171E40117F4960755_1534551633.addTaint(taint);
        return varB2A77A3F22A466F171E40117F4960755_1534551633;
        // ---------- Original Method ----------
        //char[] newBuf = new char[size()];
        //for (int i = 0; i < newBuf.length; i++) {
            //newBuf[i] = (char) (((hibyte & 0xff) << 8) | (buf[i] & 0xff));
        //}
        //return new String(newBuf);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.475 -0400", hash_original_method = "E8B99C45FE2629BCCA1491714FD1F75F", hash_generated_method = "BF900D0BBB2D6BA1A7F0FB3A101B991B")
    public String toString(String enc) throws UnsupportedEncodingException {
        addTaint(enc.getTaint());
String var5E21685371F07E75C95D47BDF9CF6168_777958475 =         new String(buf, 0, count, enc);
        var5E21685371F07E75C95D47BDF9CF6168_777958475.addTaint(taint);
        return var5E21685371F07E75C95D47BDF9CF6168_777958475;
        // ---------- Original Method ----------
        //return new String(buf, 0, count, enc);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.476 -0400", hash_original_method = "6803EEF19C65AA8F03D81EBEC2EC6C85", hash_generated_method = "E5E384291269A029D32437DA8898098C")
    @Override
    public synchronized void write(byte[] buffer, int offset, int len) {
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, len);
        if(len == 0)        
        {
            return;
        } //End block
        expand(len);
        System.arraycopy(buffer, offset, buf, this.count, len);
        this.count += len;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, len);
        //if (len == 0) {
            //return;
        //}
        //expand(len);
        //System.arraycopy(buffer, offset, buf, this.count, len);
        //this.count += len;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.477 -0400", hash_original_method = "0E8EDDE6C6CD9DF7AD28FE0F8F877448", hash_generated_method = "BE160943C7DF044D7B8FE8E01BF770C8")
    @Override
    public synchronized void write(int oneByte) {
        if(count == buf.length)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.478 -0400", hash_original_method = "19AD6C910070CA1BF00692AA88EF7627", hash_generated_method = "BC4F34D67DFB39ED5B878BDE02A99196")
    public synchronized void writeTo(OutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.write(buf, 0, count);
        // ---------- Original Method ----------
        //out.write(buf, 0, count);
    }

    
}

