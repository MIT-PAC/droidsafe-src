package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class CharArrayBuffer extends CharBuffer {
    protected char[] backingArray;
    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.497 -0400", hash_original_method = "A72F78A13989965B326E51B9BE40A191", hash_generated_method = "44229D329496F0D7D9CC1667354C1821")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CharArrayBuffer(char[] array) {
        this(array.length, array, 0);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.497 -0400", hash_original_method = "1D86BFBD657FBEBE6746E0A26E3B60D6", hash_generated_method = "D518D9F5E691B3A009A2029F2612FAF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CharArrayBuffer(int capacity) {
        this(capacity, new char[capacity], 0);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.497 -0400", hash_original_method = "C3B2650154B809A9DCA4173590E7D6FB", hash_generated_method = "E44CB2E3F569EB8EC7295BEC8CE3954F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CharArrayBuffer(int capacity, char[] backingArray, int offset) {
        super(capacity);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.497 -0400", hash_original_method = "930271761AD6BA9DD8139CF2E7572A4C", hash_generated_method = "F12B68C32124E6FED7EC26BB9E0CDAF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final char get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.497 -0400", hash_original_method = "5DC544428BD1C6845537E5987EE9535C", hash_generated_method = "9ABDEA9E02DDA54E395CC895AF753745")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final char get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.498 -0400", hash_original_method = "7C08804A3C6FF079C168DF2ED7D4D9F5", hash_generated_method = "7D2CB34D00D369A49F6FD79D8E60BCCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final CharBuffer get(char[] dst, int srcOffset, int charCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_357583675 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, srcOffset, charCount);
        position += charCount;
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (charCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, srcOffset, charCount);
        //position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.498 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "7E7C9B3B0EC5D6CFC1C636F6242D264A")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isDirect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.498 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "DA9883CCE307E39A03F07FF9A25B8EF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final ByteOrder order() {
        ByteOrder var65FB841C6DEFAE151AADF2CD2F0C0FB5_787020433 = (ByteOrder.nativeOrder());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.498 -0400", hash_original_method = "4B1929E0A98D3F3896D7290A74598BEB", hash_generated_method = "CEC38331E98C6D3902E1A044B76C67C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        checkStartEndRemaining(start, end);
        CharBuffer result;
        result = duplicate();
        result.limit(position + end);
        result.position(position + start);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharBuffer result = duplicate();
        //result.limit(position + end);
        //result.position(position + start);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.499 -0400", hash_original_method = "955B04A37714208757E4A9A84A4E89C7", hash_generated_method = "DC131E7B138331A02152DC97F544E997")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final String toString() {
        String var491184327B0DD4BE359829B7BF2CAE69_989606194 = (String.copyValueOf(backingArray, offset + position, remaining()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return String.copyValueOf(backingArray, offset + position, remaining());
    }

    
}

