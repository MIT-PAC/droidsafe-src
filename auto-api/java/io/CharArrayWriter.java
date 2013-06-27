package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class CharArrayWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.628 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "F3184E7FC423A3DB65CA949884DB59BD")

    protected char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.628 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.628 -0400", hash_original_method = "C9452FB9491532C2A6C52BB5B3D25E39", hash_generated_method = "D4173DDAE8E1B17586789B3DC5C61CB6")
    public  CharArrayWriter() {
        buf = new char[32];
        lock = buf;
        // ---------- Original Method ----------
        //buf = new char[32];
        //lock = buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.632 -0400", hash_original_method = "71C0EC52128D22FED2D8659A81B00E37", hash_generated_method = "5C223D19976B6441603069FBEC7DB473")
    public  CharArrayWriter(int initialSize) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 0");
        } //End block
        buf = new char[initialSize];
        lock = buf;
        // ---------- Original Method ----------
        //if (initialSize < 0) {
            //throw new IllegalArgumentException("size < 0");
        //}
        //buf = new char[initialSize];
        //lock = buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.632 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
    @Override
    public void close() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.633 -0400", hash_original_method = "74E26FDF253668E5689F73596E4C1217", hash_generated_method = "85CAF211D061BB9E2C592FC3E72506E4")
    private void expand(int i) {
        int newLen;
        newLen = Math.max(2 * buf.length, count + i);
        char[] newbuf;
        newbuf = new char[newLen];
        System.arraycopy(buf, 0, newbuf, 0, count);
        buf = newbuf;
        addTaint(i);
        // ---------- Original Method ----------
        //if (count + i <= buf.length) {
            //return;
        //}
        //int newLen = Math.max(2 * buf.length, count + i);
        //char[] newbuf = new char[newLen];
        //System.arraycopy(buf, 0, newbuf, 0, count);
        //buf = newbuf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.633 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.633 -0400", hash_original_method = "41854ED78018FCB86E06DA2ADE584B53", hash_generated_method = "E348718251029EA924D9315E65CEAC33")
    public void reset() {
        {
            count = 0;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //count = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.634 -0400", hash_original_method = "796F2451CF9DC3EF411446EADA3F03C7", hash_generated_method = "4D5C0586D071F058EBDBE793B82EA405")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442307779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442307779;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return count;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.634 -0400", hash_original_method = "A3DCAA229974F9979554B7E0F1F4EF9F", hash_generated_method = "F49187DCB726C43BEC345ABDF207A04B")
    public char[] toCharArray() {
        {
            char[] result;
            result = new char[count];
            System.arraycopy(buf, 0, result, 0, count);
        } //End block
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_520274646 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_520274646;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //char[] result = new char[count];
            //System.arraycopy(buf, 0, result, 0, count);
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.645 -0400", hash_original_method = "F9B2EF7C65F2F351A8955F413D7A1883", hash_generated_method = "F6201C4F1973013DB8DD8965BBD9E71C")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1243665676 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1243665676 = new String(buf, 0, count);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1243665676.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1243665676;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return new String(buf, 0, count);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.658 -0400", hash_original_method = "17F94D6158075BE971F02096E85AEF33", hash_generated_method = "0CDA35C7C61EE25B5184DFDAA7B1A196")
    @Override
    public void write(char[] buffer, int offset, int len) {
        Arrays.checkOffsetAndCount(buffer.length, offset, len);
        {
            expand(len);
            System.arraycopy(buffer, offset, this.buf, this.count, len);
            this.count += len;
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, len);
        //synchronized (lock) {
            //expand(len);
            //System.arraycopy(buffer, offset, this.buf, this.count, len);
            //this.count += len;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.659 -0400", hash_original_method = "F6D5648087F216C6BFDCFB078373F01B", hash_generated_method = "F23FAA88C75C60BF3436D441034562CE")
    @Override
    public void write(int oneChar) {
        {
            expand(1);
            buf[count++] = (char) oneChar;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //expand(1);
            //buf[count++] = (char) oneChar;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.660 -0400", hash_original_method = "9F8082FBB1391041DAA8F1A348E27C2A", hash_generated_method = "7D85B6D412352E922859BF91E2F3C8E9")
    @Override
    public void write(String str, int offset, int count) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("str == null");
        } //End block
        {
            boolean var692490DEFA1D61E18F718478B787B00C_1222270062 = ((offset | count) < 0 || offset > str.length() - count);
            {
                if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(str, offset, count);
            } //End block
        } //End collapsed parenthetic
        {
            expand(count);
            str.getChars(offset, offset + count, buf, this.count);
            this.count += count;
        } //End block
        addTaint(str.getTaint());
        addTaint(offset);
        // ---------- Original Method ----------
        //if (str == null) {
            //throw new NullPointerException("str == null");
        //}
        //if ((offset | count) < 0 || offset > str.length() - count) {
            //throw new StringIndexOutOfBoundsException(str, offset, count);
        //}
        //synchronized (lock) {
            //expand(count);
            //str.getChars(offset, offset + count, buf, this.count);
            //this.count += count;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.661 -0400", hash_original_method = "C2C534AA9A22A4D0AC70B4A5DCDA6B73", hash_generated_method = "C0C128314D3B970E3457D4172734EAEA")
    public void writeTo(Writer out) throws IOException {
        {
            out.write(buf, 0, count);
        } //End block
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //synchronized (lock) {
            //out.write(buf, 0, count);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.662 -0400", hash_original_method = "98F1E9A8C1E20678242580E2421D983C", hash_generated_method = "F903EC9F9BE327A16AB6433492820E70")
    @Override
    public CharArrayWriter append(char c) {
        CharArrayWriter varB4EAC82CA7396A68D541C85D26508E83_1044016377 = null; //Variable for return #1
        write(c);
        varB4EAC82CA7396A68D541C85D26508E83_1044016377 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1044016377.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1044016377;
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.663 -0400", hash_original_method = "B584B42D7A9874698AA3457A3A1D3154", hash_generated_method = "EF4992D6A91B4599686E029BF5A97214")
    @Override
    public CharArrayWriter append(CharSequence csq) {
        CharArrayWriter varB4EAC82CA7396A68D541C85D26508E83_684719463 = null; //Variable for return #1
        {
            csq = "null";
        } //End block
        append(csq, 0, csq.length());
        varB4EAC82CA7396A68D541C85D26508E83_684719463 = this;
        addTaint(csq.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_684719463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_684719463;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //append(csq, 0, csq.length());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.670 -0400", hash_original_method = "A1054C6BA24908274B5EEDCC4DAC29F7", hash_generated_method = "588A42882031F29C06254DBA8E958E01")
    @Override
    public CharArrayWriter append(CharSequence csq, int start, int end) {
        CharArrayWriter varB4EAC82CA7396A68D541C85D26508E83_248540019 = null; //Variable for return #1
        {
            csq = "null";
        } //End block
        String output;
        output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
        varB4EAC82CA7396A68D541C85D26508E83_248540019 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_248540019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_248540019;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //String output = csq.subSequence(start, end).toString();
        //write(output, 0, output.length());
        //return this;
    }

    
}

