package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.util.CharArrayBuffer;

public class ParserCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.383 -0400", hash_original_field = "88584F2BD264A57A30E5142795244349", hash_generated_field = "3D31A0897353409A28F764FE6D5203CA")

    private int lowerBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.383 -0400", hash_original_field = "D28987CBAEDB791EA498927BEA6A9A90", hash_generated_field = "944B6A2B0A5719EC12B474F8C5AB43E8")

    private int upperBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.383 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.384 -0400", hash_original_method = "18E7372DC3B3776B683739AF6C000CE1", hash_generated_method = "03DFF3EEEFA48B8CC792801AAE9724A3")
    public  ParserCursor(int lowerBound, int upperBound) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        } 
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.pos = lowerBound;
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.384 -0400", hash_original_method = "B6CD36FF17D4C577E642B4E01F194082", hash_generated_method = "9CB0291362105E580E880EED59B89413")
    public int getLowerBound() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007700967 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007700967;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.385 -0400", hash_original_method = "66602FD2E118973F9E6D21C36C521447", hash_generated_method = "F18FE64A8D4B99785F6E476E7694FFA4")
    public int getUpperBound() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132928425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132928425;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.385 -0400", hash_original_method = "1216C5DA6D96C0F767DB071179C12F61", hash_generated_method = "67727B8E1FA59AAA166BC8469F7249C6")
    public int getPos() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137186611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137186611;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.386 -0400", hash_original_method = "A3829310204BDE639939B0DAE79170B8", hash_generated_method = "9A856FE2A5E3854FDC2C316AB6BCD9B0")
    public void updatePos(int pos) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        this.pos = pos;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.386 -0400", hash_original_method = "159D31ECA8D03F41976CF671BF1C3B8F", hash_generated_method = "96B080EDC26256261586A5B23C69E77E")
    public boolean atEnd() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_847198818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_847198818;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.387 -0400", hash_original_method = "DBE0DD908DEA3CD4A10978C31BD1370E", hash_generated_method = "7196C206804F7B3F15870CD8ED4F0D96")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1433460591 = null; 
        CharArrayBuffer buffer = new CharArrayBuffer(16);
        buffer.append('[');
        buffer.append(Integer.toString(this.lowerBound));
        buffer.append('>');
        buffer.append(Integer.toString(this.pos));
        buffer.append('>');
        buffer.append(Integer.toString(this.upperBound));
        buffer.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_1433460591 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1433460591.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1433460591;
        
        
        
        
        
        
        
        
        
        
    }

    
}

