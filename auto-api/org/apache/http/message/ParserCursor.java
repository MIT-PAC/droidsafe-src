package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.util.CharArrayBuffer;

public class ParserCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.304 -0400", hash_original_field = "88584F2BD264A57A30E5142795244349", hash_generated_field = "3D31A0897353409A28F764FE6D5203CA")

    private int lowerBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.304 -0400", hash_original_field = "D28987CBAEDB791EA498927BEA6A9A90", hash_generated_field = "944B6A2B0A5719EC12B474F8C5AB43E8")

    private int upperBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.304 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.305 -0400", hash_original_method = "18E7372DC3B3776B683739AF6C000CE1", hash_generated_method = "03DFF3EEEFA48B8CC792801AAE9724A3")
    public  ParserCursor(int lowerBound, int upperBound) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        } //End block
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.pos = lowerBound;
        // ---------- Original Method ----------
        //if (lowerBound < 0) {
            //throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        //}
        //if (lowerBound > upperBound) {
            //throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        //}
        //this.lowerBound = lowerBound;
        //this.upperBound = upperBound;
        //this.pos = lowerBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.305 -0400", hash_original_method = "B6CD36FF17D4C577E642B4E01F194082", hash_generated_method = "039A3468829228013996456CAAF7F959")
    public int getLowerBound() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1334546505 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1334546505;
        // ---------- Original Method ----------
        //return this.lowerBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.305 -0400", hash_original_method = "66602FD2E118973F9E6D21C36C521447", hash_generated_method = "47F7096F73841ED929534099EC6DCBD3")
    public int getUpperBound() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868648095 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868648095;
        // ---------- Original Method ----------
        //return this.upperBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.312 -0400", hash_original_method = "1216C5DA6D96C0F767DB071179C12F61", hash_generated_method = "86EB17CFD611867B641DED54F6938F10")
    public int getPos() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_392574165 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_392574165;
        // ---------- Original Method ----------
        //return this.pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.314 -0400", hash_original_method = "A3829310204BDE639939B0DAE79170B8", hash_generated_method = "9A856FE2A5E3854FDC2C316AB6BCD9B0")
    public void updatePos(int pos) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        this.pos = pos;
        // ---------- Original Method ----------
        //if (pos < this.lowerBound) {
            //throw new IndexOutOfBoundsException();
        //}
        //if (pos > this.upperBound) {
            //throw new IndexOutOfBoundsException();
        //}
        //this.pos = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.315 -0400", hash_original_method = "159D31ECA8D03F41976CF671BF1C3B8F", hash_generated_method = "176ECF6D66A379CCD0B5DAF235A25403")
    public boolean atEnd() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128374376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128374376;
        // ---------- Original Method ----------
        //return this.pos >= this.upperBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.327 -0400", hash_original_method = "DBE0DD908DEA3CD4A10978C31BD1370E", hash_generated_method = "F5EDD2224FC64FCBD1E831BD9E9E09F2")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1960873341 = null; //Variable for return #1
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(16);
        buffer.append('[');
        buffer.append(Integer.toString(this.lowerBound));
        buffer.append('>');
        buffer.append(Integer.toString(this.pos));
        buffer.append('>');
        buffer.append(Integer.toString(this.upperBound));
        buffer.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_1960873341 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1960873341.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1960873341;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(16);
        //buffer.append('[');
        //buffer.append(Integer.toString(this.lowerBound));
        //buffer.append('>');
        //buffer.append(Integer.toString(this.pos));
        //buffer.append('>');
        //buffer.append(Integer.toString(this.upperBound));
        //buffer.append(']');
        //return buffer.toString();
    }

    
}

