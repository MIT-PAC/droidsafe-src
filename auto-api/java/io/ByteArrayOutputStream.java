package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class ByteArrayOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.579 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.579 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.586 -0400", hash_original_method = "4DC3C0B5ECFA05562A9AFEF7B1CF9D45", hash_generated_method = "269B013234340EC0E9870BCC0641CB1F")
    public  ByteArrayOutputStream() {
        buf = new byte[32];
        // ---------- Original Method ----------
        //buf = new byte[32];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.587 -0400", hash_original_method = "931B663776F41DA70E9677006016F16F", hash_generated_method = "C8AEC1BC9DA5344BE114C2E13B8FE953")
    public  ByteArrayOutputStream(int size) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.588 -0400", hash_original_method = "04777FE12371C5E12A689BB328BF05B3", hash_generated_method = "56FC2307CB6D5F5D1217DE945E7131B9")
    @Override
    public void close() throws IOException {
        super.close();
        // ---------- Original Method ----------
        //super.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.588 -0400", hash_original_method = "D6EC9446F27E74EA041BF330AAB72CEF", hash_generated_method = "050D05A64B77CFE63D68238CF91FA6EC")
    private void expand(int i) {
        byte[] newbuf;
        newbuf = new byte[(count + i) * 2];
        System.arraycopy(buf, 0, newbuf, 0, count);
        buf = newbuf;
        addTaint(i);
        // ---------- Original Method ----------
        //if (count + i <= buf.length) {
            //return;
        //}
        //byte[] newbuf = new byte[(count + i) * 2];
        //System.arraycopy(buf, 0, newbuf, 0, count);
        //buf = newbuf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.592 -0400", hash_original_method = "D84F167B372983A8A32E17B936FA6E9B", hash_generated_method = "400ADB088DB2A9073490DD652F495E0B")
    public synchronized void reset() {
        count = 0;
        // ---------- Original Method ----------
        //count = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.593 -0400", hash_original_method = "F417CE3385B772AADA134FBE4FF63C9E", hash_generated_method = "834916EB091FD5E8430817F3A2FD63EE")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400347325 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400347325;
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.593 -0400", hash_original_method = "F52D84F15F793E7D52B479C7891604F2", hash_generated_method = "315BE3A0DA43D2DB6E38809E4B701921")
    public synchronized byte[] toByteArray() {
        byte[] newArray;
        newArray = new byte[count];
        System.arraycopy(buf, 0, newArray, 0, count);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_880711576 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_880711576;
        // ---------- Original Method ----------
        //byte[] newArray = new byte[count];
        //System.arraycopy(buf, 0, newArray, 0, count);
        //return newArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.593 -0400", hash_original_method = "2951DD657350D2DCE6E576199EA1BCE5", hash_generated_method = "1722DBA096E4621DDD83ED886C437C1E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_902459146 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_902459146 = new String(buf, 0, count);
        varB4EAC82CA7396A68D541C85D26508E83_902459146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_902459146;
        // ---------- Original Method ----------
        //return new String(buf, 0, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.601 -0400", hash_original_method = "3E105C3C1F43529FE32D861B80701B8D", hash_generated_method = "B8FA0979804CF74925E419FA8187637E")
    @Deprecated
    public String toString(int hibyte) {
        String varB4EAC82CA7396A68D541C85D26508E83_512381517 = null; //Variable for return #1
        char[] newBuf;
        newBuf = new char[size()];
        {
            int i;
            i = 0;
            {
                newBuf[i] = (char) (((hibyte & 0xff) << 8) | (buf[i] & 0xff));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_512381517 = new String(newBuf);
        addTaint(hibyte);
        varB4EAC82CA7396A68D541C85D26508E83_512381517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_512381517;
        // ---------- Original Method ----------
        //char[] newBuf = new char[size()];
        //for (int i = 0; i < newBuf.length; i++) {
            //newBuf[i] = (char) (((hibyte & 0xff) << 8) | (buf[i] & 0xff));
        //}
        //return new String(newBuf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.606 -0400", hash_original_method = "E8B99C45FE2629BCCA1491714FD1F75F", hash_generated_method = "CBFD6A59F22280D98F85A07A44D2A9C5")
    public String toString(String enc) throws UnsupportedEncodingException {
        String varB4EAC82CA7396A68D541C85D26508E83_1037009500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1037009500 = new String(buf, 0, count, enc);
        addTaint(enc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1037009500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1037009500;
        // ---------- Original Method ----------
        //return new String(buf, 0, count, enc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.606 -0400", hash_original_method = "6803EEF19C65AA8F03D81EBEC2EC6C85", hash_generated_method = "1F06199C509226036316D88C5D7FFAE2")
    @Override
    public synchronized void write(byte[] buffer, int offset, int len) {
        Arrays.checkOffsetAndCount(buffer.length, offset, len);
        expand(len);
        System.arraycopy(buffer, offset, buf, this.count, len);
        this.count += len;
        addTaint(buffer[0]);
        addTaint(offset);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, len);
        //if (len == 0) {
            //return;
        //}
        //expand(len);
        //System.arraycopy(buffer, offset, buf, this.count, len);
        //this.count += len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.615 -0400", hash_original_method = "0E8EDDE6C6CD9DF7AD28FE0F8F877448", hash_generated_method = "4A5DAEB004917C0D124C75E6465D2794")
    @Override
    public synchronized void write(int oneByte) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.615 -0400", hash_original_method = "19AD6C910070CA1BF00692AA88EF7627", hash_generated_method = "2A23484A3AD6969EB27052D2891DABF0")
    public synchronized void writeTo(OutputStream out) throws IOException {
        out.write(buf, 0, count);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.write(buf, 0, count);
    }

    
}

