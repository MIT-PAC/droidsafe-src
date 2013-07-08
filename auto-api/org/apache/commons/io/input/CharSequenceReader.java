package org.apache.commons.io.input;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Reader;
import java.io.Serializable;

public class CharSequenceReader extends Reader implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.093 -0400", hash_original_field = "94F612C486E7BA7B85DF98011E01CF72", hash_generated_field = "628CA2327BAF8770AC77399355FDC52D")

    private CharSequence charSequence;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.093 -0400", hash_original_field = "7F9BEC28BC8902D45D905788D7AA59A1", hash_generated_field = "89AA0A275323729DA7EFED27B4506FAF")

    private int idx;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.093 -0400", hash_original_field = "EA82410C7A9991816B5EEEEBE195E20A", hash_generated_field = "C8691DE93C87EAA877C8B89B47679C83")

    private int mark;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.093 -0400", hash_original_method = "182A6C4ED1D1E19AB9569E928EB756A5", hash_generated_method = "7649B0779FA144D56FC8C85AD6DB095C")
    public  CharSequenceReader(CharSequence charSequence) {
        this.charSequence = charSequence != null ? charSequence : "";
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.094 -0400", hash_original_method = "40FE3D25511A62018FC369BF8427CEB7", hash_generated_method = "2266D4060420D067CA6CE07C3053E68E")
    @Override
    public void close() {
        idx = 0;
        mark = 0;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.094 -0400", hash_original_method = "AE312126AF817511B6AC9FA9A8EAB6F5", hash_generated_method = "F906E7D523EDCEFCE65C629F0CB5465F")
    @Override
    public void mark(int readAheadLimit) {
        mark = idx;
        addTaint(readAheadLimit);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.094 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "C1A4FD56BFAF058959583A26B4E97262")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1156169638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1156169638;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.094 -0400", hash_original_method = "9ACE53EBE9E224BA089484C6AABDF5C3", hash_generated_method = "DA6DE478F7CA99B1F51433A168A92DD6")
    @Override
    public int read() {
        {
            boolean var0BAC35B796DB201D17E4E2BE31ACE3CE_769468810 = (idx >= charSequence.length());
            {
                int var401D08DA76995D07487593EA36F2A23D_1937376320 = (charSequence.charAt(idx++));
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074761354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074761354;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.095 -0400", hash_original_method = "9EABECFB34552C6029ED722DF84F07FF", hash_generated_method = "B9832C1C4D7C28EE88825513DB0D6853")
    @Override
    public int read(char[] array, int offset, int length) {
        {
            boolean var0BAC35B796DB201D17E4E2BE31ACE3CE_1369890457 = (idx >= charSequence.length());
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Character array is missing");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Array Size=" + array.length +
                    ", offset=" + offset + ", length=" + length);
        } 
        int count = 0;
        {
            int i = 0;
            {
                int c = read();
                array[offset + i] = (char)c;
            } 
        } 
        addTaint(array[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587448687 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587448687;
        
        
            
        
        
            
        
        
            
                    
        
        
        
            
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.096 -0400", hash_original_method = "854753638CC0197CC47838DCD9FB66E4", hash_generated_method = "0D4963B14DD2BC669773665FA36345A5")
    @Override
    public void reset() {
        idx = mark;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.096 -0400", hash_original_method = "75F54BDE1C47E9678EFB232794384C6F", hash_generated_method = "C04B9C0FED947AD4EFCBE98B209119C3")
    @Override
    public long skip(long n) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Number of characters to skip is less than zero: " + n);
        } 
        {
            boolean var0BAC35B796DB201D17E4E2BE31ACE3CE_967479429 = (idx >= charSequence.length());
        } 
        int dest = (int)Math.min(charSequence.length(), idx + n);
        int count = dest - idx;
        idx = dest;
        addTaint(n);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_470887437 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_470887437;
        
        
            
                    
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.097 -0400", hash_original_method = "610F60ED6DB50185F33A85945665EF11", hash_generated_method = "9581E7DBCC987D3123C8FC73850A8A31")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1334389587 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1334389587 = charSequence.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1334389587.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1334389587;
        
        
    }

    
}

