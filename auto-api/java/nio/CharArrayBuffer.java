package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class CharArrayBuffer extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.855 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "0CB5FB822B200EFB3152ED27D6D936CC")

    protected char[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.855 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.855 -0400", hash_original_method = "A72F78A13989965B326E51B9BE40A191", hash_generated_method = "5AC0B4427BA97C90E4967231E10723CD")
      CharArrayBuffer(char[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.856 -0400", hash_original_method = "1D86BFBD657FBEBE6746E0A26E3B60D6", hash_generated_method = "60046133E972094317BD5C36FB3E9514")
      CharArrayBuffer(int capacity) {
        this(capacity, new char[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.856 -0400", hash_original_method = "C3B2650154B809A9DCA4173590E7D6FB", hash_generated_method = "0E36B28088D3CBE70EE8A47BCEBA6FD7")
      CharArrayBuffer(int capacity, char[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        addTaint(capacity);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.857 -0400", hash_original_method = "930271761AD6BA9DD8139CF2E7572A4C", hash_generated_method = "5A54B563BF5DFA49176FB2B72BBEFED2")
    @Override
    public final char get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        char varA87DEB01C5F539E6BDA34829C8EF2368_195282722 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_195282722;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.857 -0400", hash_original_method = "5DC544428BD1C6845537E5987EE9535C", hash_generated_method = "5975BCCC47C41FCA03F711861DBB5C06")
    @Override
    public final char get(int index) {
        checkIndex(index);
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_345922598 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_345922598;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.865 -0400", hash_original_method = "7C08804A3C6FF079C168DF2ED7D4D9F5", hash_generated_method = "F64E301EC970EE0953BAF9C77F13D58F")
    @Override
    public final CharBuffer get(char[] dst, int srcOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_147779501 = null; //Variable for return #1
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_975189932 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, srcOffset, charCount);
        position += charCount;
        varB4EAC82CA7396A68D541C85D26508E83_147779501 = this;
        addTaint(dst[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_147779501.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_147779501;
        // ---------- Original Method ----------
        //if (charCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, srcOffset, charCount);
        //position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.865 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "5EA21B6595B94BB795246AC28EA7BABF")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1171373213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1171373213;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.882 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "9381CD03BC3A007F0447AC032E749BD4")
    @Override
    public final ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_1730689245 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1730689245 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_1730689245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1730689245;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.883 -0400", hash_original_method = "4B1929E0A98D3F3896D7290A74598BEB", hash_generated_method = "9BA172978C439A85D82E19954AD50945")
    @Override
    public final CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2020081043 = null; //Variable for return #1
        checkStartEndRemaining(start, end);
        CharBuffer result;
        result = duplicate();
        result.limit(position + end);
        result.position(position + start);
        varB4EAC82CA7396A68D541C85D26508E83_2020081043 = result;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_2020081043.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2020081043;
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharBuffer result = duplicate();
        //result.limit(position + end);
        //result.position(position + start);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.883 -0400", hash_original_method = "955B04A37714208757E4A9A84A4E89C7", hash_generated_method = "A8A49923AB7A5427BC0331D7325B2443")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_19073068 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_19073068 = String.copyValueOf(backingArray, offset + position, remaining());
        varB4EAC82CA7396A68D541C85D26508E83_19073068.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_19073068;
        // ---------- Original Method ----------
        //return String.copyValueOf(backingArray, offset + position, remaining());
    }

    
}

