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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.106 -0400", hash_original_field = "B54B7D92B744D1F21DF5EE4E44903B54", hash_generated_field = "A7FC64164120C43082DBAEB73DE730FA")

    protected int maxForwards;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.112 -0400", hash_original_method = "112FF42CCB27FA28BF813D0D5005682D", hash_generated_method = "04D96CD1DE0F0679DECA6B600CDA4279")
    public  MaxForwards() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.112 -0400", hash_original_method = "23B968D979F2A1F7830372508F81A601", hash_generated_method = "943657D160DC718FE7AEE0800BC88187")
    public  MaxForwards( int m ) throws InvalidArgumentException {
        super(NAME);
        this.setMaxForwards( m );
        addTaint(m);
        // ---------- Original Method ----------
        //this.setMaxForwards( m );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.113 -0400", hash_original_method = "938FE465D8E1495DA17B5EBE827AE012", hash_generated_method = "5E8B1E88AB5DA6B91CA320393B621850")
    public int getMaxForwards() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_44336818 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_44336818;
        // ---------- Original Method ----------
        //return maxForwards;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.113 -0400", hash_original_method = "FA1042197B22377DF7A66B8C90EDB406", hash_generated_method = "F01F65F3349C966DFD50EBF45EF9783C")
    public void setMaxForwards(int maxForwards) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "bad max forwards value " + maxForwards);
        this.maxForwards = maxForwards;
        // ---------- Original Method ----------
        //if (maxForwards < 0 || maxForwards > 255)
            //throw new InvalidArgumentException(
                //"bad max forwards value " + maxForwards);
        //this.maxForwards = maxForwards;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.113 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "47E2300F5035D0D160B2EE35E5FBE8DC")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1232692559 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1232692559 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1232692559.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1232692559;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.125 -0400", hash_original_method = "3054700CB5B8914F4AFAE52C6BC42EFB", hash_generated_method = "18BE6CEAB711389983DD598136B5DB81")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1788672054 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1788672054 = buffer.append(maxForwards);
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1788672054.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1788672054;
        // ---------- Original Method ----------
        //return buffer.append(maxForwards);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.126 -0400", hash_original_method = "5954B7E2243EB0AA755A2C7023AF3E50", hash_generated_method = "FA84B893445ADD8A58AF05D0BC96308C")
    public boolean hasReachedZero() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1880482744 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1880482744;
        // ---------- Original Method ----------
        //return maxForwards == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.129 -0400", hash_original_method = "AD70092C1832EBC094F0EF6B8F6DE4A8", hash_generated_method = "68E687119F536C73F51B32EEC65D4BBB")
    public void decrementMaxForwards() throws TooManyHopsException {
        if (DroidSafeAndroidRuntime.control) throw new TooManyHopsException ("has already reached 0!");
        // ---------- Original Method ----------
        //if (maxForwards > 0)
            //maxForwards--;
        //else throw new TooManyHopsException ("has already reached 0!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.129 -0400", hash_original_method = "272F5F4A3D96880D7AA6FF639321E7AD", hash_generated_method = "78110D25ED2BC5698001C6B90F479BA5")
    public boolean equals(Object other) {
        {
            MaxForwardsHeader o;
            o = (MaxForwardsHeader) other;
            boolean var21BF6D3D60EF72E8992E53F7A93EB3D4_1778158443 = (this.getMaxForwards() == o.getMaxForwards());
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_616531241 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_616531241;
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof MaxForwardsHeader) {
            //final MaxForwardsHeader o = (MaxForwardsHeader) other;
            //return this.getMaxForwards() == o.getMaxForwards();
        //}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.129 -0400", hash_original_field = "A3BB09F5637A7FA02606816157C94C5C", hash_generated_field = "DF7DA150A1955936A53718DC9AC2AA67")

    private static long serialVersionUID = -3096874323347175943L;
}

