package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Token;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;
import javax.sip.header.Parameters;

public class PVisitedNetworkID extends gov.nist.javax.sip.header.ParametersHeader implements PVisitedNetworkIDHeader, SIPHeaderNamesIms, ExtensionHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.655 -0500", hash_original_field = "15E4F121BD56E131F67527180B0E7231", hash_generated_field = "C4CD23BC06318F8990510CDE3BD92C0F")

    private String networkID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.658 -0500", hash_original_field = "671188DE595321A86C3C710E5DBEF055", hash_generated_field = "2863DBAD0B0E1EA5F78AE4C051C969E2")

    private boolean isQuoted;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.662 -0500", hash_original_method = "051A535620162843E1B90678BF3DA49E", hash_generated_method = "A9BE25365A900113C5ACF49C81B6F012")
    
public PVisitedNetworkID() {

        super(P_VISITED_NETWORK_ID);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.665 -0500", hash_original_method = "F3FD852440F29DF78156D2082B766F5C", hash_generated_method = "6175A4D2329A78A81429AD3FE2E9D54C")
    
public PVisitedNetworkID(String networkID) {

        super(P_VISITED_NETWORK_ID);
        setVisitedNetworkID(networkID);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.669 -0500", hash_original_method = "5824AB36695E623B7CAEFD86EE80361A", hash_generated_method = "970765B4F207CE076C20E982FAD854B1")
    
public PVisitedNetworkID(Token tok) {

        super(P_VISITED_NETWORK_ID);
        setVisitedNetworkID(tok.getTokenValue());

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.672 -0500", hash_original_method = "90D5FECE17BBAD01000BE0E34EB90561", hash_generated_method = "6E1F3682D5E66BBADB26E924A61CC7CE")
    
protected String encodeBody() {

        StringBuffer retval = new StringBuffer();

        if (getVisitedNetworkID() != null)
        {
            // issued by Miguel Freitas
            if (isQuoted)
                retval.append(DOUBLE_QUOTE + getVisitedNetworkID() + DOUBLE_QUOTE);
            else
                retval.append(getVisitedNetworkID());
        }

        if (!parameters.isEmpty())
            retval.append(SEMICOLON + this.parameters.encode());

        return retval.toString();

    }

    /**
     * Set the visited network ID as a string. The value will be quoted in the header.
     * @param networkID - string value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.676 -0500", hash_original_method = "F88375989912893742E68A8CB169C4C0", hash_generated_method = "A0E101B3982EE5411CA1C19EFAA039EE")
    
public void setVisitedNetworkID(String networkID) {
        if (networkID == null)
            throw new NullPointerException(" the networkID parameter is null");

        this.networkID = networkID;

        // issued by Miguel Freitas
        this.isQuoted = true;
    }

    /**
     * Set the visited network ID as a token
     * @param networkID - token value
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.679 -0500", hash_original_method = "3764C600A7ABF764E75A7A0F8A4AD296", hash_generated_method = "A1173707E91363EFBFC57DFBA08D2D62")
    
public void setVisitedNetworkID(Token networkID) {
        if (networkID == null)
            throw new NullPointerException(" the networkID parameter is null");

        this.networkID = networkID.getTokenValue();

        // issued by Miguel Freitas
        this.isQuoted = false;
    }

    /**
     * Get the visited network ID value of this header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.683 -0500", hash_original_method = "C32CBAC6FBA17FDD7866AA432385EFB6", hash_generated_method = "E0560C2B1685F867A676C9812F01B0AE")
    
public String getVisitedNetworkID() {
        return networkID;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.686 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    
public void setValue(String value) throws ParseException {
        throw new ParseException (value,0);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.690 -0500", hash_original_method = "BB5BE6B7830212EF4C97BABF52359F44", hash_generated_method = "1B848278E089058D500EA7C1797DCA36")
    
public boolean equals(Object other)
    {
        if (other instanceof PVisitedNetworkIDHeader)
        {
            PVisitedNetworkIDHeader o = (PVisitedNetworkIDHeader) other;
            return (this.getVisitedNetworkID().equals( o.getVisitedNetworkID() )
                && this.equalParameters( (Parameters) o ));
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.693 -0500", hash_original_method = "FDDED33F93F598CF66CA227B3E72EBB0", hash_generated_method = "C7403985FC96F54E1F93F1B0B5AE0496")
    
public Object clone() {
        PVisitedNetworkID retval = (PVisitedNetworkID) super.clone();
        if (this.networkID != null)
            retval.networkID = this.networkID;
        retval.isQuoted = this.isQuoted;
        return retval;
    }
    
}

