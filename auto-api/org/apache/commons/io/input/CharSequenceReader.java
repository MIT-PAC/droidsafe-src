package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Reader;
import java.io.Serializable;

public class CharSequenceReader extends Reader implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.925 -0400", hash_original_field = "94F612C486E7BA7B85DF98011E01CF72", hash_generated_field = "628CA2327BAF8770AC77399355FDC52D")

    private CharSequence charSequence;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.925 -0400", hash_original_field = "7F9BEC28BC8902D45D905788D7AA59A1", hash_generated_field = "89AA0A275323729DA7EFED27B4506FAF")

    private int idx;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.925 -0400", hash_original_field = "EA82410C7A9991816B5EEEEBE195E20A", hash_generated_field = "C8691DE93C87EAA877C8B89B47679C83")

    private int mark;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.926 -0400", hash_original_method = "182A6C4ED1D1E19AB9569E928EB756A5", hash_generated_method = "7649B0779FA144D56FC8C85AD6DB095C")
    public  CharSequenceReader(CharSequence charSequence) {
        this.charSequence = charSequence != null ? charSequence : "";
        // ---------- Original Method ----------
        //this.charSequence = charSequence != null ? charSequence : "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.937 -0400", hash_original_method = "40FE3D25511A62018FC369BF8427CEB7", hash_generated_method = "2266D4060420D067CA6CE07C3053E68E")
    @Override
    public void close() {
        idx = 0;
        mark = 0;
        // ---------- Original Method ----------
        //idx = 0;
        //mark = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.937 -0400", hash_original_method = "AE312126AF817511B6AC9FA9A8EAB6F5", hash_generated_method = "F906E7D523EDCEFCE65C629F0CB5465F")
    @Override
    public void mark(int readAheadLimit) {
        mark = idx;
        addTaint(readAheadLimit);
        // ---------- Original Method ----------
        //mark = idx;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.937 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "871D107BE1F4C154206389FB3E6F63D9")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_798781581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_798781581;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.938 -0400", hash_original_method = "9ACE53EBE9E224BA089484C6AABDF5C3", hash_generated_method = "4FFE047CF805834CED1D12B28D9423C9")
    @Override
    public int read() {
        {
            boolean var0BAC35B796DB201D17E4E2BE31ACE3CE_1308127096 = (idx >= charSequence.length());
            {
                int var401D08DA76995D07487593EA36F2A23D_187147872 = (charSequence.charAt(idx++));
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_515842031 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_515842031;
        // ---------- Original Method ----------
        //if (idx >= charSequence.length()) {
            //return -1;
        //} else {
            //return charSequence.charAt(idx++);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.945 -0400", hash_original_method = "9EABECFB34552C6029ED722DF84F07FF", hash_generated_method = "BD09C5F681C641E793C59C51B41A59DA")
    @Override
    public int read(char[] array, int offset, int length) {
        {
            boolean var0BAC35B796DB201D17E4E2BE31ACE3CE_847378820 = (idx >= charSequence.length());
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Character array is missing");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Array Size=" + array.length +
                    ", offset=" + offset + ", length=" + length);
        } //End block
        int count;
        count = 0;
        {
            int i;
            i = 0;
            {
                int c;
                c = read();
                array[offset + i] = (char)c;
            } //End block
        } //End collapsed parenthetic
        addTaint(array[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915785707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915785707;
        // ---------- Original Method ----------
        //if (idx >= charSequence.length()) {
            //return -1;
        //}
        //if (array == null) {
            //throw new NullPointerException("Character array is missing");
        //}
        //if (length < 0 || offset < 0 || offset + length > array.length) {
            //throw new IndexOutOfBoundsException("Array Size=" + array.length +
                    //", offset=" + offset + ", length=" + length);
        //}
        //int count = 0;
        //for (int i = 0; i < length; i++) {
            //int c = read();
            //if (c == -1) {
                //return count;
            //}
            //array[offset + i] = (char)c;
            //count++;
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.950 -0400", hash_original_method = "854753638CC0197CC47838DCD9FB66E4", hash_generated_method = "0D4963B14DD2BC669773665FA36345A5")
    @Override
    public void reset() {
        idx = mark;
        // ---------- Original Method ----------
        //idx = mark;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.951 -0400", hash_original_method = "75F54BDE1C47E9678EFB232794384C6F", hash_generated_method = "2F57A4C29A0F8C2D1F020F07929B43F4")
    @Override
    public long skip(long n) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Number of characters to skip is less than zero: " + n);
        } //End block
        {
            boolean var0BAC35B796DB201D17E4E2BE31ACE3CE_1298308594 = (idx >= charSequence.length());
        } //End collapsed parenthetic
        int dest;
        dest = (int)Math.min(charSequence.length(), idx + n);
        int count;
        count = dest - idx;
        idx = dest;
        addTaint(n);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_109000783 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_109000783;
        // ---------- Original Method ----------
        //if (n < 0) {
            //throw new IllegalArgumentException(
                    //"Number of characters to skip is less than zero: " + n);
        //}
        //if (idx >= charSequence.length()) {
            //return -1;
        //}
        //int dest = (int)Math.min(charSequence.length(), idx + n);
        //int count = dest - idx;
        //idx = dest;
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.951 -0400", hash_original_method = "610F60ED6DB50185F33A85945665EF11", hash_generated_method = "69E3C4DD6ECA344B2ECB15FEFB48C995")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_430059669 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_430059669 = charSequence.toString();
        varB4EAC82CA7396A68D541C85D26508E83_430059669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_430059669;
        // ---------- Original Method ----------
        //return charSequence.toString();
    }

    
}

