package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.MaxForwardsHeader;
import javax.sip.header.TooManyHopsException;

public class MaxForwards extends SIPHeader implements MaxForwardsHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.756 -0500", hash_original_field = "D9775AA801F210D5CECF25591E61CB22", hash_generated_field = "A999D5831FAE9A2CB5D83E10B325A89A")

    private static final long serialVersionUID = -3096874323347175943L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.762 -0500", hash_original_field = "9C0DC10D1BD6CA2C8B2EAD1A7C372272", hash_generated_field = "A7FC64164120C43082DBAEB73DE730FA")

    protected int maxForwards;

    /** Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.768 -0500", hash_original_method = "112FF42CCB27FA28BF813D0D5005682D", hash_generated_method = "B8A1AA2ED7A081F7B36310F2B22C2B73")
    
public MaxForwards() {
        super(NAME);
    }

  @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.775 -0500", hash_original_method = "23B968D979F2A1F7830372508F81A601", hash_generated_method = "3C8F142BE284AC6E9363FCDF39770559")
    
public MaxForwards( int m ) throws InvalidArgumentException {
        super(NAME);
        this.setMaxForwards( m );
    }

    /** get the MaxForwards field.
     * @return the maxForwards member.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.781 -0500", hash_original_method = "938FE465D8E1495DA17B5EBE827AE012", hash_generated_method = "5D411B80736C63B0B65BC65395AF0617")
    
public int getMaxForwards() {
        return maxForwards;
    }

    /**
         * Set the maxForwards member
         * @param maxForwards maxForwards parameter to set
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.787 -0500", hash_original_method = "FA1042197B22377DF7A66B8C90EDB406", hash_generated_method = "C1078083B891E1DAFAABA4A9AF100632")
    
public void setMaxForwards(int maxForwards)
        throws InvalidArgumentException {
        if (maxForwards < 0 || maxForwards > 255)
            throw new InvalidArgumentException(
                "bad max forwards value " + maxForwards);
        this.maxForwards = maxForwards;
    }

    /**
         * Encode into a string.
         * @return encoded string.
         *
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.793 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "74B066602ECC20A74FD97E770D65E8BD")
    
public String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.797 -0500", hash_original_method = "3054700CB5B8914F4AFAE52C6BC42EFB", hash_generated_method = "FF374059AE5FA7629E38477A2273692C")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        return buffer.append(maxForwards);
    }

    /** Boolean function
     * @return true if MaxForwards field reached zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.800 -0500", hash_original_method = "5954B7E2243EB0AA755A2C7023AF3E50", hash_generated_method = "E4EC00F798DD35579B3FA9A6C74222C7")
    
public boolean hasReachedZero() {
        return maxForwards == 0;
    }

    /** decrement MaxForwards field one by one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.804 -0500", hash_original_method = "AD70092C1832EBC094F0EF6B8F6DE4A8", hash_generated_method = "F11749F786740540B14A8CA16535621F")
    
public void decrementMaxForwards() throws TooManyHopsException {
        if (maxForwards > 0)
            maxForwards--;
        else throw new TooManyHopsException ("has already reached 0!");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:54.808 -0500", hash_original_method = "272F5F4A3D96880D7AA6FF639321E7AD", hash_generated_method = "D24AA88A20F30BC54F9479F34F32F85A")
    
public boolean equals(Object other) {
        if (this==other) return true;
        if (other instanceof MaxForwardsHeader) {
            final MaxForwardsHeader o = (MaxForwardsHeader) other;
            return this.getMaxForwards() == o.getMaxForwards();
        }
        return false;
    }
}

