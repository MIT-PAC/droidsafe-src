package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.MaxForwardsHeader;
import javax.sip.header.TooManyHopsException;






public class MaxForwards extends SIPHeader implements MaxForwardsHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.545 -0400", hash_original_field = "B54B7D92B744D1F21DF5EE4E44903B54", hash_generated_field = "A7FC64164120C43082DBAEB73DE730FA")

    protected int maxForwards;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.545 -0400", hash_original_method = "112FF42CCB27FA28BF813D0D5005682D", hash_generated_method = "04D96CD1DE0F0679DECA6B600CDA4279")
    public  MaxForwards() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.545 -0400", hash_original_method = "23B968D979F2A1F7830372508F81A601", hash_generated_method = "F05FAF277873E93451BFC3CDDBD3D483")
    public  MaxForwards( int m ) throws InvalidArgumentException {
        super(NAME);
        addTaint(m);
        this.setMaxForwards( m );
        // ---------- Original Method ----------
        //this.setMaxForwards( m );
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.546 -0400", hash_original_method = "938FE465D8E1495DA17B5EBE827AE012", hash_generated_method = "CEA2F4DEB9145AD9C8C9D6C7E3814141")
    public int getMaxForwards() {
        int varB54B7D92B744D1F21DF5EE4E44903B54_419034717 = (maxForwards);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207223239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207223239;
        // ---------- Original Method ----------
        //return maxForwards;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.547 -0400", hash_original_method = "FA1042197B22377DF7A66B8C90EDB406", hash_generated_method = "E44081283ED3EB3BE16648CCC528A8C3")
    public void setMaxForwards(int maxForwards) throws InvalidArgumentException {
        if(maxForwards < 0 || maxForwards > 255)        
        {
        InvalidArgumentException var3145BF195F59E1DDE6E46AB44D52BBFF_828591761 = new InvalidArgumentException(
                "bad max forwards value " + maxForwards);
        var3145BF195F59E1DDE6E46AB44D52BBFF_828591761.addTaint(taint);
        throw var3145BF195F59E1DDE6E46AB44D52BBFF_828591761;
        }
        this.maxForwards = maxForwards;
        // ---------- Original Method ----------
        //if (maxForwards < 0 || maxForwards > 255)
            //throw new InvalidArgumentException(
                //"bad max forwards value " + maxForwards);
        //this.maxForwards = maxForwards;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.548 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "64723F203835F4597D380B155EE2A510")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_2053947044 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_2053947044.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_2053947044;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.548 -0400", hash_original_method = "3054700CB5B8914F4AFAE52C6BC42EFB", hash_generated_method = "B6C7DB8AA563481BDB502DD22890E61E")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer varE7F20B7624E9FB6EB4C0C5FDDB74C470_997019036 =         buffer.append(maxForwards);
        varE7F20B7624E9FB6EB4C0C5FDDB74C470_997019036.addTaint(taint);
        return varE7F20B7624E9FB6EB4C0C5FDDB74C470_997019036;
        // ---------- Original Method ----------
        //return buffer.append(maxForwards);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.549 -0400", hash_original_method = "5954B7E2243EB0AA755A2C7023AF3E50", hash_generated_method = "D39FC9A232178E58A86E59327D3C22CF")
    public boolean hasReachedZero() {
        boolean var99965430D9B630C77DB771A3C82DCA9F_1218115544 = (maxForwards == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1233328789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1233328789;
        // ---------- Original Method ----------
        //return maxForwards == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.549 -0400", hash_original_method = "AD70092C1832EBC094F0EF6B8F6DE4A8", hash_generated_method = "1BF1357FE9205F15F50DE64B4119B61B")
    public void decrementMaxForwards() throws TooManyHopsException {
        if(maxForwards > 0)        
        maxForwards--;
        else
        {
        TooManyHopsException var904B3B22A82D2B4F304848596D4CF99B_432610140 = new TooManyHopsException ("has already reached 0!");
        var904B3B22A82D2B4F304848596D4CF99B_432610140.addTaint(taint);
        throw var904B3B22A82D2B4F304848596D4CF99B_432610140;
        }
        // ---------- Original Method ----------
        //if (maxForwards > 0)
            //maxForwards--;
        //else throw new TooManyHopsException ("has already reached 0!");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.550 -0400", hash_original_method = "272F5F4A3D96880D7AA6FF639321E7AD", hash_generated_method = "C55695FC51D95211044945CC62A0C2C2")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(this==other)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1073318877 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1511200171 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1511200171;
        }
        if(other instanceof MaxForwardsHeader)        
        {
            final MaxForwardsHeader o = (MaxForwardsHeader) other;
            boolean var618B16848B9A65B698C8D0251081E9DA_380952742 = (this.getMaxForwards() == o.getMaxForwards());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_660464278 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_660464278;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1792889088 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666012281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666012281;
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof MaxForwardsHeader) {
            //final MaxForwardsHeader o = (MaxForwardsHeader) other;
            //return this.getMaxForwards() == o.getMaxForwards();
        //}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.551 -0400", hash_original_field = "A3BB09F5637A7FA02606816157C94C5C", hash_generated_field = "A999D5831FAE9A2CB5D83E10B325A89A")

    private static final long serialVersionUID = -3096874323347175943L;
}

