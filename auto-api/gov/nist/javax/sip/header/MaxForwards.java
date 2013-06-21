package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import javax.sip.InvalidArgumentException;

public class MaxForwards extends SIPHeader implements MaxForwardsHeader {
    protected int maxForwards;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.010 -0400", hash_original_method = "112FF42CCB27FA28BF813D0D5005682D", hash_generated_method = "04D96CD1DE0F0679DECA6B600CDA4279")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MaxForwards() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.011 -0400", hash_original_method = "23B968D979F2A1F7830372508F81A601", hash_generated_method = "6C1416379A35CD257BDC1F76966E3063")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MaxForwards( int m ) throws InvalidArgumentException {
        super(NAME);
        dsTaint.addTaint(m);
        this.setMaxForwards( m );
        // ---------- Original Method ----------
        //this.setMaxForwards( m );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.011 -0400", hash_original_method = "938FE465D8E1495DA17B5EBE827AE012", hash_generated_method = "48166A73DA8CE75DA133CAE1DE4C8423")
    @DSModeled(DSC.SAFE)
    public int getMaxForwards() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maxForwards;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.011 -0400", hash_original_method = "FA1042197B22377DF7A66B8C90EDB406", hash_generated_method = "950ADEEC5665A28802020BA2F28BDFCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaxForwards(int maxForwards) throws InvalidArgumentException {
        dsTaint.addTaint(maxForwards);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "bad max forwards value " + maxForwards);
        // ---------- Original Method ----------
        //if (maxForwards < 0 || maxForwards > 255)
            //throw new InvalidArgumentException(
                //"bad max forwards value " + maxForwards);
        //this.maxForwards = maxForwards;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.011 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "56636E15CD17F5695B5F4F9FD8C75E95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_361202320 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.012 -0400", hash_original_method = "3054700CB5B8914F4AFAE52C6BC42EFB", hash_generated_method = "E1DB109ED0D12128D22D78E682A5D056")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        StringBuffer var2847EDC6B65AF87A998FF2D560F93945_1280155011 = (buffer.append(maxForwards));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return buffer.append(maxForwards);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.012 -0400", hash_original_method = "5954B7E2243EB0AA755A2C7023AF3E50", hash_generated_method = "6B055D892A220BE0A69DC2653767D75E")
    @DSModeled(DSC.SAFE)
    public boolean hasReachedZero() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return maxForwards == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.012 -0400", hash_original_method = "AD70092C1832EBC094F0EF6B8F6DE4A8", hash_generated_method = "68E687119F536C73F51B32EEC65D4BBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void decrementMaxForwards() throws TooManyHopsException {
        if (DroidSafeAndroidRuntime.control) throw new TooManyHopsException ("has already reached 0!");
        // ---------- Original Method ----------
        //if (maxForwards > 0)
            //maxForwards--;
        //else throw new TooManyHopsException ("has already reached 0!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.012 -0400", hash_original_method = "272F5F4A3D96880D7AA6FF639321E7AD", hash_generated_method = "13ED5B5E9A3B40EDF409A6E9000EA277")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            MaxForwardsHeader o;
            o = (MaxForwardsHeader) other;
            boolean var21BF6D3D60EF72E8992E53F7A93EB3D4_1181045457 = (this.getMaxForwards() == o.getMaxForwards());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof MaxForwardsHeader) {
            //final MaxForwardsHeader o = (MaxForwardsHeader) other;
            //return this.getMaxForwards() == o.getMaxForwards();
        //}
        //return false;
    }

    
    private static final long serialVersionUID = -3096874323347175943L;
}

