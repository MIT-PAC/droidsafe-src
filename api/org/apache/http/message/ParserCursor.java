package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.util.CharArrayBuffer;

public class ParserCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.152 -0400", hash_original_field = "88584F2BD264A57A30E5142795244349", hash_generated_field = "3D31A0897353409A28F764FE6D5203CA")

    private int lowerBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.152 -0400", hash_original_field = "D28987CBAEDB791EA498927BEA6A9A90", hash_generated_field = "944B6A2B0A5719EC12B474F8C5AB43E8")

    private int upperBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.153 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.154 -0400", hash_original_method = "18E7372DC3B3776B683739AF6C000CE1", hash_generated_method = "226EE40B0EC27673D2CBF8468CEE61CE")
    public  ParserCursor(int lowerBound, int upperBound) {
        super();
        if(lowerBound < 0)        
        {
            IndexOutOfBoundsException var36A97E85AC88615597D0236B61117FA7_1350105819 = new IndexOutOfBoundsException("Lower bound cannot be negative");
            var36A97E85AC88615597D0236B61117FA7_1350105819.addTaint(taint);
            throw var36A97E85AC88615597D0236B61117FA7_1350105819;
        } //End block
        if(lowerBound > upperBound)        
        {
            IndexOutOfBoundsException var1CEF45EC8164657800C75AAC60FAE6FD_99362824 = new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
            var1CEF45EC8164657800C75AAC60FAE6FD_99362824.addTaint(taint);
            throw var1CEF45EC8164657800C75AAC60FAE6FD_99362824;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.155 -0400", hash_original_method = "B6CD36FF17D4C577E642B4E01F194082", hash_generated_method = "4E12F2952EEB7C2F0D96F3D591EFD222")
    public int getLowerBound() {
        int var39781BB417E90C2CDB1675D8E436D2D9_880736867 = (this.lowerBound);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244106094 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244106094;
        // ---------- Original Method ----------
        //return this.lowerBound;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.155 -0400", hash_original_method = "66602FD2E118973F9E6D21C36C521447", hash_generated_method = "B02ECEFD2DC355591ABB69E033187383")
    public int getUpperBound() {
        int var8277DB68548C3DFE081D0E64D66046A8_1901390631 = (this.upperBound);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_99497482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_99497482;
        // ---------- Original Method ----------
        //return this.upperBound;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.155 -0400", hash_original_method = "1216C5DA6D96C0F767DB071179C12F61", hash_generated_method = "B43DDC394EE71D4FB05F88B9A871A962")
    public int getPos() {
        int varC6E42501CCE6A1FF7C3704EF034A434D_1250233874 = (this.pos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669750992 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669750992;
        // ---------- Original Method ----------
        //return this.pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.156 -0400", hash_original_method = "A3829310204BDE639939B0DAE79170B8", hash_generated_method = "DD416349EDF925C8C6FA6A2AE7B3DC19")
    public void updatePos(int pos) {
        if(pos < this.lowerBound)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1823649604 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1823649604.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1823649604;
        } //End block
        if(pos > this.upperBound)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1532735833 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1532735833.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1532735833;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.157 -0400", hash_original_method = "159D31ECA8D03F41976CF671BF1C3B8F", hash_generated_method = "4FC06A23E40283603F1E8E714717906F")
    public boolean atEnd() {
        boolean var0115475EE8D6B4ABAB8E5F11F0957FB9_2137897064 = (this.pos >= this.upperBound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1307094521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1307094521;
        // ---------- Original Method ----------
        //return this.pos >= this.upperBound;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.157 -0400", hash_original_method = "DBE0DD908DEA3CD4A10978C31BD1370E", hash_generated_method = "4D329FDC9D7CA27F5C54407C667D2A91")
    public String toString() {
        CharArrayBuffer buffer = new CharArrayBuffer(16);
        buffer.append('[');
        buffer.append(Integer.toString(this.lowerBound));
        buffer.append('>');
        buffer.append(Integer.toString(this.pos));
        buffer.append('>');
        buffer.append(Integer.toString(this.upperBound));
        buffer.append(']');
String varD03843288D33B9E1D3062E25339ECF6D_1731400200 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_1731400200.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_1731400200;
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

