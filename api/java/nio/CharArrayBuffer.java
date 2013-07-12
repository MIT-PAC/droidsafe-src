package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

abstract class CharArrayBuffer extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.986 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "0CB5FB822B200EFB3152ED27D6D936CC")

    protected char[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.986 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.986 -0400", hash_original_method = "A72F78A13989965B326E51B9BE40A191", hash_generated_method = "5AC0B4427BA97C90E4967231E10723CD")
      CharArrayBuffer(char[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.987 -0400", hash_original_method = "1D86BFBD657FBEBE6746E0A26E3B60D6", hash_generated_method = "60046133E972094317BD5C36FB3E9514")
      CharArrayBuffer(int capacity) {
        this(capacity, new char[capacity], 0);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.988 -0400", hash_original_method = "C3B2650154B809A9DCA4173590E7D6FB", hash_generated_method = "73897A527583E88EF7E6726116CBC18B")
      CharArrayBuffer(int capacity, char[] backingArray, int offset) {
        super(capacity);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.988 -0400", hash_original_method = "930271761AD6BA9DD8139CF2E7572A4C", hash_generated_method = "2344F292235B770243E3708525A1CE52")
    @Override
    public final char get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1867093392 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1867093392.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1867093392;
        } 
        char varD1A88672373807059A15983DE4C2AC9F_1317471290 = (backingArray[offset + position++]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1681797831 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1681797831;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.989 -0400", hash_original_method = "5DC544428BD1C6845537E5987EE9535C", hash_generated_method = "23090C86C227CF2C0F9106F094BDED68")
    @Override
    public final char get(int index) {
        addTaint(index);
        checkIndex(index);
        char varF4617D5762E2F642102CBB5F4FA87F0A_1593486833 = (backingArray[offset + index]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1639237733 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1639237733;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.989 -0400", hash_original_method = "7C08804A3C6FF079C168DF2ED7D4D9F5", hash_generated_method = "1E68EBE554006CEC6B181CC061482263")
    @Override
    public final CharBuffer get(char[] dst, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(dst[0]);
    if(charCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_361878563 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_361878563.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_361878563;
        } 
        System.arraycopy(backingArray, offset + position, dst, srcOffset, charCount);
        position += charCount;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1421725839 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1421725839.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1421725839;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.990 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "CF311EDFA88EFD70A884DA990288A975")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_2082319345 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_377025375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_377025375;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.990 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "B44FACBB346849580139029BEFD6A0B6")
    @Override
    public final ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_544585526 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_544585526.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_544585526;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.991 -0400", hash_original_method = "4B1929E0A98D3F3896D7290A74598BEB", hash_generated_method = "5C080A7A157AC7B750553A2C2A345110")
    @Override
    public final CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
        checkStartEndRemaining(start, end);
        CharBuffer result = duplicate();
        result.limit(position + end);
        result.position(position + start);
CharSequence varDC838461EE2FA0CA4C9BBB70A15456B0_137547676 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_137547676.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_137547676;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.991 -0400", hash_original_method = "955B04A37714208757E4A9A84A4E89C7", hash_generated_method = "D7C3B64AA493D0BED6E32113F515DB07")
    @Override
    public final String toString() {
String varE7E88D2DDF044D9A87865303F889A05C_739711231 =         String.copyValueOf(backingArray, offset + position, remaining());
        varE7E88D2DDF044D9A87865303F889A05C_739711231.addTaint(taint);
        return varE7E88D2DDF044D9A87865303F889A05C_739711231;
        
        
    }

    
}

