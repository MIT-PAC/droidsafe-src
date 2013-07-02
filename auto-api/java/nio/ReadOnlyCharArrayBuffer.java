package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class ReadOnlyCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.867 -0400", hash_original_method = "45CC985A35F0F1494520573D6ACE292A", hash_generated_method = "DF437A528D95C52D346BC9EB6C3A5357")
      ReadOnlyCharArrayBuffer(int capacity, char[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        
    }

    
    @DSModeled(DSC.SAFE)
    static ReadOnlyCharArrayBuffer copy(CharArrayBuffer other, int markOfOther) {
        ReadOnlyCharArrayBuffer buf =
                new ReadOnlyCharArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.867 -0400", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "7A8C1ADAD62390E9B7B6CC5583541348")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1430558264 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1430558264 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_1430558264.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1430558264;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.868 -0400", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "FDB048D4EFBE0B834B0B887336BCFF0E")
    @Override
    public CharBuffer compact() {
        throw new ReadOnlyBufferException();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.868 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "34AEA3AE25C42B1417DEA145326F234D")
    @Override
    public CharBuffer duplicate() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1920131339 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1920131339 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1920131339.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1920131339;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.868 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "9D8D75146C53304E155D58641EEB549B")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_620378973 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_620378973;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.868 -0400", hash_original_method = "0F9E5668E984B4901FBF78711C9DAE7C", hash_generated_method = "6CAEA782B8A8740CEF7D3716C97041A0")
    @Override
    protected char[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1635852788 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1635852788;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.869 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "0770F2C5D22D63920E837787EDA9A37C")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436404730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436404730;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.869 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "A8C29BDE0995A977A231FD4DACED6476")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297094779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_297094779;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.869 -0400", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "3A85A20458CD46C3155C147F6F048806")
    @Override
    public CharBuffer put(char c) {
         throw new ReadOnlyBufferException();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.870 -0400", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "E150AA8DCB8978B57C618C5428A755CD")
    @Override
    public CharBuffer put(int index, char c) {
        throw new ReadOnlyBufferException();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.870 -0400", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "18EBBD5FFFA53649B304121971BF9CEA")
    @Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        throw new ReadOnlyBufferException();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.870 -0400", hash_original_method = "FB6FEA0A32E7A03D5D90CE6B495DAC9B", hash_generated_method = "41BBA8D35D08A1CA6355F037B035805D")
    @Override
    public final CharBuffer put(CharBuffer src) {
        throw new ReadOnlyBufferException();

        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.871 -0400", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "29F4042A72DFAB1AB12EB8C658A3318C")
    @Override
    public CharBuffer put(String src, int start, int end) {
        throw new ReadOnlyBufferException();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.871 -0400", hash_original_method = "B45CBDD156981DE98E6537855A7A214E", hash_generated_method = "52E5937BA69016053CCAA5E699232508")
    @Override
    public CharBuffer slice() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_337196231 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_337196231 = new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_337196231.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_337196231;
        
        
    }

    
}

