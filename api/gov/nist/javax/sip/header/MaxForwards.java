package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;
import javax.sip.InvalidArgumentException;

public class MaxForwards extends SIPHeader implements MaxForwardsHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.572 -0400", hash_original_field = "B54B7D92B744D1F21DF5EE4E44903B54", hash_generated_field = "A7FC64164120C43082DBAEB73DE730FA")

    protected int maxForwards;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.572 -0400", hash_original_method = "112FF42CCB27FA28BF813D0D5005682D", hash_generated_method = "04D96CD1DE0F0679DECA6B600CDA4279")
    public  MaxForwards() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.573 -0400", hash_original_method = "23B968D979F2A1F7830372508F81A601", hash_generated_method = "F05FAF277873E93451BFC3CDDBD3D483")
    public  MaxForwards( int m ) throws InvalidArgumentException {
        super(NAME);
        addTaint(m);
        this.setMaxForwards( m );
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.573 -0400", hash_original_method = "938FE465D8E1495DA17B5EBE827AE012", hash_generated_method = "77F2152F19428C71D01CF02BE1B00FD6")
    public int getMaxForwards() {
        int varB54B7D92B744D1F21DF5EE4E44903B54_724404736 = (maxForwards);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038805245 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038805245;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.574 -0400", hash_original_method = "FA1042197B22377DF7A66B8C90EDB406", hash_generated_method = "7E2D4CA517B609E8D0C6E6FE4DC70DB3")
    public void setMaxForwards(int maxForwards) throws InvalidArgumentException {
    if(maxForwards < 0 || maxForwards > 255)        
        {
        InvalidArgumentException var3145BF195F59E1DDE6E46AB44D52BBFF_1969463352 = new InvalidArgumentException(
                "bad max forwards value " + maxForwards);
        var3145BF195F59E1DDE6E46AB44D52BBFF_1969463352.addTaint(taint);
        throw var3145BF195F59E1DDE6E46AB44D52BBFF_1969463352;
        }
        this.maxForwards = maxForwards;
        
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.575 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "101D91183AD023AB624D2FB2A6AAAEB1")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_428477386 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_428477386.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_428477386;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.575 -0400", hash_original_method = "3054700CB5B8914F4AFAE52C6BC42EFB", hash_generated_method = "D6A59395DE7502C31C0CCD9617728786")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer varE7F20B7624E9FB6EB4C0C5FDDB74C470_2085713908 =         buffer.append(maxForwards);
        varE7F20B7624E9FB6EB4C0C5FDDB74C470_2085713908.addTaint(taint);
        return varE7F20B7624E9FB6EB4C0C5FDDB74C470_2085713908;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.575 -0400", hash_original_method = "5954B7E2243EB0AA755A2C7023AF3E50", hash_generated_method = "2494D63E7ED398455FF111F925B3F5DF")
    public boolean hasReachedZero() {
        boolean var99965430D9B630C77DB771A3C82DCA9F_1571773504 = (maxForwards == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225048158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225048158;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.575 -0400", hash_original_method = "AD70092C1832EBC094F0EF6B8F6DE4A8", hash_generated_method = "F130C1B0D4624F8C12B5145D2CF3EB60")
    public void decrementMaxForwards() throws TooManyHopsException {
    if(maxForwards > 0)        
        maxForwards--;
        else
        {
        TooManyHopsException var904B3B22A82D2B4F304848596D4CF99B_1322078427 = new TooManyHopsException ("has already reached 0!");
        var904B3B22A82D2B4F304848596D4CF99B_1322078427.addTaint(taint);
        throw var904B3B22A82D2B4F304848596D4CF99B_1322078427;
        }
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.576 -0400", hash_original_method = "272F5F4A3D96880D7AA6FF639321E7AD", hash_generated_method = "A7C38ADDF84BBE68BA112AE2364C57F5")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(this==other)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1583127135 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_395475218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_395475218;
        }
    if(other instanceof MaxForwardsHeader)        
        {
            final MaxForwardsHeader o = (MaxForwardsHeader) other;
            boolean var618B16848B9A65B698C8D0251081E9DA_1947983096 = (this.getMaxForwards() == o.getMaxForwards());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1778512253 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1778512253;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1305936447 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1279839564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1279839564;
        
        
        
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.576 -0400", hash_original_field = "A3BB09F5637A7FA02606816157C94C5C", hash_generated_field = "A999D5831FAE9A2CB5D83E10B325A89A")

    private static final long serialVersionUID = -3096874323347175943L;
}

