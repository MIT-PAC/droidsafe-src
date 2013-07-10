package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Arrays;

public class CharArrayWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.561 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "F3184E7FC423A3DB65CA949884DB59BD")

    protected char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.561 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.562 -0400", hash_original_method = "C9452FB9491532C2A6C52BB5B3D25E39", hash_generated_method = "D4173DDAE8E1B17586789B3DC5C61CB6")
    public  CharArrayWriter() {
        buf = new char[32];
        lock = buf;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.562 -0400", hash_original_method = "71C0EC52128D22FED2D8659A81B00E37", hash_generated_method = "5C223D19976B6441603069FBEC7DB473")
    public  CharArrayWriter(int initialSize) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size < 0");
        } 
        buf = new char[initialSize];
        lock = buf;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.562 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
    @Override
    public void close() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.563 -0400", hash_original_method = "74E26FDF253668E5689F73596E4C1217", hash_generated_method = "C2602F2045274F0C09E94BD50B2136B1")
    private void expand(int i) {
        int newLen = Math.max(2 * buf.length, count + i);
        char[] newbuf = new char[newLen];
        System.arraycopy(buf, 0, newbuf, 0, count);
        buf = newbuf;
        addTaint(i);
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.563 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @Override
    public void flush() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.563 -0400", hash_original_method = "41854ED78018FCB86E06DA2ADE584B53", hash_generated_method = "E348718251029EA924D9315E65CEAC33")
    public void reset() {
        {
            count = 0;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.564 -0400", hash_original_method = "796F2451CF9DC3EF411446EADA3F03C7", hash_generated_method = "5B62EB1438541B6B9EB8AD6441F2557B")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557640005 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557640005;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.564 -0400", hash_original_method = "A3DCAA229974F9979554B7E0F1F4EF9F", hash_generated_method = "4013FE2FE04CE7E59D6C42F2E62159AE")
    public char[] toCharArray() {
        {
            char[] result = new char[count];
            System.arraycopy(buf, 0, result, 0, count);
        } 
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1483047722 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1483047722;
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.565 -0400", hash_original_method = "F9B2EF7C65F2F351A8955F413D7A1883", hash_generated_method = "F6649FF7BFB44A8FBD811C955C5E5CB6")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_14735715 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_14735715 = new String(buf, 0, count);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_14735715.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_14735715;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.565 -0400", hash_original_method = "17F94D6158075BE971F02096E85AEF33", hash_generated_method = "0CDA35C7C61EE25B5184DFDAA7B1A196")
    @Override
    public void write(char[] buffer, int offset, int len) {
        Arrays.checkOffsetAndCount(buffer.length, offset, len);
        {
            expand(len);
            System.arraycopy(buffer, offset, this.buf, this.count, len);
            this.count += len;
        } 
        addTaint(buffer[0]);
        addTaint(offset);
        
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.566 -0400", hash_original_method = "F6D5648087F216C6BFDCFB078373F01B", hash_generated_method = "F23FAA88C75C60BF3436D441034562CE")
    @Override
    public void write(int oneChar) {
        {
            expand(1);
            buf[count++] = (char) oneChar;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.566 -0400", hash_original_method = "9F8082FBB1391041DAA8F1A348E27C2A", hash_generated_method = "8F98C67D43BFC43B6A5AA319ED9A83FC")
    @Override
    public void write(String str, int offset, int count) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("str == null");
        } 
        {
            boolean var692490DEFA1D61E18F718478B787B00C_367752586 = ((offset | count) < 0 || offset > str.length() - count);
            {
                if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(str, offset, count);
            } 
        } 
        {
            expand(count);
            str.getChars(offset, offset + count, buf, this.count);
            this.count += count;
        } 
        addTaint(str.getTaint());
        addTaint(offset);
        
        
            
        
        
            
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.567 -0400", hash_original_method = "C2C534AA9A22A4D0AC70B4A5DCDA6B73", hash_generated_method = "C0C128314D3B970E3457D4172734EAEA")
    public void writeTo(Writer out) throws IOException {
        {
            out.write(buf, 0, count);
        } 
        addTaint(out.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.568 -0400", hash_original_method = "98F1E9A8C1E20678242580E2421D983C", hash_generated_method = "34FDF9FA1846F057BD41D028288A5D14")
    @Override
    public CharArrayWriter append(char c) {
        CharArrayWriter varB4EAC82CA7396A68D541C85D26508E83_2096768594 = null; 
        write(c);
        varB4EAC82CA7396A68D541C85D26508E83_2096768594 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_2096768594.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2096768594;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.569 -0400", hash_original_method = "B584B42D7A9874698AA3457A3A1D3154", hash_generated_method = "C4BE00ACC7445D73D8E54E77FF09B908")
    @Override
    public CharArrayWriter append(CharSequence csq) {
        CharArrayWriter varB4EAC82CA7396A68D541C85D26508E83_2024412591 = null; 
        {
            csq = "null";
        } 
        append(csq, 0, csq.length());
        varB4EAC82CA7396A68D541C85D26508E83_2024412591 = this;
        addTaint(csq.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2024412591.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2024412591;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.569 -0400", hash_original_method = "A1054C6BA24908274B5EEDCC4DAC29F7", hash_generated_method = "E3C625E7D7650048476F81D2535F2D77")
    @Override
    public CharArrayWriter append(CharSequence csq, int start, int end) {
        CharArrayWriter varB4EAC82CA7396A68D541C85D26508E83_1870057727 = null; 
        {
            csq = "null";
        } 
        String output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
        varB4EAC82CA7396A68D541C85D26508E83_1870057727 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1870057727.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1870057727;
        
        
            
        
        
        
        
    }

    
}

