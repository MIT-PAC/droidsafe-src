package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

abstract class CharArrayBuffer extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.297 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "0CB5FB822B200EFB3152ED27D6D936CC")

    protected char[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.297 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.297 -0400", hash_original_method = "A72F78A13989965B326E51B9BE40A191", hash_generated_method = "5AC0B4427BA97C90E4967231E10723CD")
      CharArrayBuffer(char[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.298 -0400", hash_original_method = "1D86BFBD657FBEBE6746E0A26E3B60D6", hash_generated_method = "60046133E972094317BD5C36FB3E9514")
      CharArrayBuffer(int capacity) {
        this(capacity, new char[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.298 -0400", hash_original_method = "C3B2650154B809A9DCA4173590E7D6FB", hash_generated_method = "73897A527583E88EF7E6726116CBC18B")
      CharArrayBuffer(int capacity, char[] backingArray, int offset) {
        super(capacity);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.299 -0400", hash_original_method = "930271761AD6BA9DD8139CF2E7572A4C", hash_generated_method = "7475B1BC62611B48FE5F254945FD4773")
    @Override
    public final char get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_875013046 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_875013046.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_875013046;
        } //End block
        char varD1A88672373807059A15983DE4C2AC9F_223147622 = (backingArray[offset + position++]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_28325783 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_28325783;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.299 -0400", hash_original_method = "5DC544428BD1C6845537E5987EE9535C", hash_generated_method = "F1280AE19605C25DA266F78329970D19")
    @Override
    public final char get(int index) {
        addTaint(index);
        checkIndex(index);
        char varF4617D5762E2F642102CBB5F4FA87F0A_1298029549 = (backingArray[offset + index]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1776974590 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1776974590;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.299 -0400", hash_original_method = "7C08804A3C6FF079C168DF2ED7D4D9F5", hash_generated_method = "FB9AE7F8234E21678538CCEC8DED4EDB")
    @Override
    public final CharBuffer get(char[] dst, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(dst[0]);
        if(charCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_968516644 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_968516644.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_968516644;
        } //End block
        System.arraycopy(backingArray, offset + position, dst, srcOffset, charCount);
        position += charCount;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1418860762 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1418860762.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1418860762;
        // ---------- Original Method ----------
        //if (charCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, srcOffset, charCount);
        //position += charCount;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.300 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "A8294D6D2CF868B49C9B480B055F1F70")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_1162142469 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1644529776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1644529776;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.300 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "4E02087C8692F1A5DD9406A665821F67")
    @Override
    public final ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_59079726 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_59079726.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_59079726;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.300 -0400", hash_original_method = "4B1929E0A98D3F3896D7290A74598BEB", hash_generated_method = "E502E053096E1EE30ECEFFDD11C42459")
    @Override
    public final CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
        checkStartEndRemaining(start, end);
        CharBuffer result = duplicate();
        result.limit(position + end);
        result.position(position + start);
CharSequence varDC838461EE2FA0CA4C9BBB70A15456B0_211059994 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_211059994.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_211059994;
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharBuffer result = duplicate();
        //result.limit(position + end);
        //result.position(position + start);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.301 -0400", hash_original_method = "955B04A37714208757E4A9A84A4E89C7", hash_generated_method = "87F0062B7A39EF057432EF62BEDA4A85")
    @Override
    public final String toString() {
String varE7E88D2DDF044D9A87865303F889A05C_815917875 =         String.copyValueOf(backingArray, offset + position, remaining());
        varE7E88D2DDF044D9A87865303F889A05C_815917875.addTaint(taint);
        return varE7E88D2DDF044D9A87865303F889A05C_815917875;
        // ---------- Original Method ----------
        //return String.copyValueOf(backingArray, offset + position, remaining());
    }

    
}

