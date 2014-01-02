package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.util.CharArrayBuffer;






public class ParserCursor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.852 -0500", hash_original_field = "543086182FD473524F324F448DE00B3C", hash_generated_field = "3D31A0897353409A28F764FE6D5203CA")


    private  int lowerBound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.856 -0500", hash_original_field = "DB5F1F75F81625EB0D055946E9FAE4C6", hash_generated_field = "944B6A2B0A5719EC12B474F8C5AB43E8")

    private  int upperBound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.858 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.861 -0500", hash_original_method = "18E7372DC3B3776B683739AF6C000CE1", hash_generated_method = "5FC2B17A5E0389FE2722B969044B0ECD")
    
public ParserCursor(int lowerBound, int upperBound) {
        super();
        if (lowerBound < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        }
        if (lowerBound > upperBound) {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.pos = lowerBound;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.863 -0500", hash_original_method = "B6CD36FF17D4C577E642B4E01F194082", hash_generated_method = "A06AEDE3BA278E173A1C92E13723E624")
    
public int getLowerBound() {
        return this.lowerBound;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.865 -0500", hash_original_method = "66602FD2E118973F9E6D21C36C521447", hash_generated_method = "4F91692B0A98954D5271D88A5F45EAE6")
    
public int getUpperBound() {
        return this.upperBound;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.867 -0500", hash_original_method = "1216C5DA6D96C0F767DB071179C12F61", hash_generated_method = "C0A8457CF7D1D926C1FD5FAADEDCB170")
    
public int getPos() {
        return this.pos;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.870 -0500", hash_original_method = "A3829310204BDE639939B0DAE79170B8", hash_generated_method = "35B4C8AC12A01922848C2A206E9C426D")
    
public void updatePos(int pos) {
        if (pos < this.lowerBound) {
            throw new IndexOutOfBoundsException();
        }
        if (pos > this.upperBound) {
            throw new IndexOutOfBoundsException();
        }
        this.pos = pos;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.872 -0500", hash_original_method = "159D31ECA8D03F41976CF671BF1C3B8F", hash_generated_method = "64928D5A06142DC91C921702614893A9")
    
public boolean atEnd() {
        return this.pos >= this.upperBound;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.875 -0500", hash_original_method = "DBE0DD908DEA3CD4A10978C31BD1370E", hash_generated_method = "2E6E0F6E8C01B37DC93B75B47746ED9B")
    
public String toString() {
        CharArrayBuffer buffer = new CharArrayBuffer(16);
        buffer.append('[');
        buffer.append(Integer.toString(this.lowerBound));
        buffer.append('>');
        buffer.append(Integer.toString(this.pos));
        buffer.append('>');
        buffer.append(Integer.toString(this.upperBound));
        buffer.append(']');
        return buffer.toString();
    }

    
}

