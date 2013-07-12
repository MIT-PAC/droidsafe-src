package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.util.CharArrayBuffer;

public class ParserCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.765 -0400", hash_original_field = "88584F2BD264A57A30E5142795244349", hash_generated_field = "3D31A0897353409A28F764FE6D5203CA")

    private int lowerBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.765 -0400", hash_original_field = "D28987CBAEDB791EA498927BEA6A9A90", hash_generated_field = "944B6A2B0A5719EC12B474F8C5AB43E8")

    private int upperBound;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.765 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.766 -0400", hash_original_method = "18E7372DC3B3776B683739AF6C000CE1", hash_generated_method = "D56679C74535DF222FFDF6C08D9B4D20")
    public  ParserCursor(int lowerBound, int upperBound) {
        super();
    if(lowerBound < 0)        
        {
            IndexOutOfBoundsException var36A97E85AC88615597D0236B61117FA7_1796985088 = new IndexOutOfBoundsException("Lower bound cannot be negative");
            var36A97E85AC88615597D0236B61117FA7_1796985088.addTaint(taint);
            throw var36A97E85AC88615597D0236B61117FA7_1796985088;
        } 
    if(lowerBound > upperBound)        
        {
            IndexOutOfBoundsException var1CEF45EC8164657800C75AAC60FAE6FD_797625192 = new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
            var1CEF45EC8164657800C75AAC60FAE6FD_797625192.addTaint(taint);
            throw var1CEF45EC8164657800C75AAC60FAE6FD_797625192;
        } 
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.pos = lowerBound;
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.766 -0400", hash_original_method = "B6CD36FF17D4C577E642B4E01F194082", hash_generated_method = "6FC562265C271EA1F2C03FA82975DD99")
    public int getLowerBound() {
        int var39781BB417E90C2CDB1675D8E436D2D9_37831805 = (this.lowerBound);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628410867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628410867;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.766 -0400", hash_original_method = "66602FD2E118973F9E6D21C36C521447", hash_generated_method = "17AC6BAAF877FCC3A677ABF071DC8273")
    public int getUpperBound() {
        int var8277DB68548C3DFE081D0E64D66046A8_70024438 = (this.upperBound);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889390296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889390296;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.767 -0400", hash_original_method = "1216C5DA6D96C0F767DB071179C12F61", hash_generated_method = "7068CE503D88752927546680ABD63470")
    public int getPos() {
        int varC6E42501CCE6A1FF7C3704EF034A434D_1655248425 = (this.pos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410610978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410610978;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.767 -0400", hash_original_method = "A3829310204BDE639939B0DAE79170B8", hash_generated_method = "49319B48C4232442F00219DF437524AB")
    public void updatePos(int pos) {
    if(pos < this.lowerBound)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1506597322 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1506597322.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1506597322;
        } 
    if(pos > this.upperBound)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_537997003 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_537997003.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_537997003;
        } 
        this.pos = pos;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.767 -0400", hash_original_method = "159D31ECA8D03F41976CF671BF1C3B8F", hash_generated_method = "DF26FF396F16E8FB6D40C59B782DEBAC")
    public boolean atEnd() {
        boolean var0115475EE8D6B4ABAB8E5F11F0957FB9_567109707 = (this.pos >= this.upperBound);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_359857640 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_359857640;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.768 -0400", hash_original_method = "DBE0DD908DEA3CD4A10978C31BD1370E", hash_generated_method = "1E7A4AA1B121FE0057B84C68A1807662")
    public String toString() {
        CharArrayBuffer buffer = new CharArrayBuffer(16);
        buffer.append('[');
        buffer.append(Integer.toString(this.lowerBound));
        buffer.append('>');
        buffer.append(Integer.toString(this.pos));
        buffer.append('>');
        buffer.append(Integer.toString(this.upperBound));
        buffer.append(']');
String varD03843288D33B9E1D3062E25339ECF6D_1371268693 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_1371268693.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_1371268693;
        
        
        
        
        
        
        
        
        
        
    }

    
}

