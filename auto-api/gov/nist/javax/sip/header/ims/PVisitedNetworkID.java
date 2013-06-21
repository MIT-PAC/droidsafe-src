package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.Parameters;
import gov.nist.core.Token;

public class PVisitedNetworkID extends gov.nist.javax.sip.header.ParametersHeader implements PVisitedNetworkIDHeader, SIPHeaderNamesIms, ExtensionHeader {
    private String networkID;
    private boolean isQuoted;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.626 -0400", hash_original_method = "051A535620162843E1B90678BF3DA49E", hash_generated_method = "3CE366DEE4998CA432B3DC12C1B2E9D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PVisitedNetworkID() {
        super(P_VISITED_NETWORK_ID);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.627 -0400", hash_original_method = "F3FD852440F29DF78156D2082B766F5C", hash_generated_method = "71715B8D03EC919D3BB4C80CA16405E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PVisitedNetworkID(String networkID) {
        super(P_VISITED_NETWORK_ID);
        dsTaint.addTaint(networkID);
        setVisitedNetworkID(networkID);
        // ---------- Original Method ----------
        //setVisitedNetworkID(networkID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.627 -0400", hash_original_method = "5824AB36695E623B7CAEFD86EE80361A", hash_generated_method = "80367AA05F9EF2570B9B2EC38300B4EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PVisitedNetworkID(Token tok) {
        super(P_VISITED_NETWORK_ID);
        dsTaint.addTaint(tok.dsTaint);
        setVisitedNetworkID(tok.getTokenValue());
        // ---------- Original Method ----------
        //setVisitedNetworkID(tok.getTokenValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.627 -0400", hash_original_method = "90D5FECE17BBAD01000BE0E34EB90561", hash_generated_method = "BC76C3CB27DA04CE1B8FF13281102753")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varD46735F28D1AB9461F89ACF0E219DFC3_678352010 = (getVisitedNetworkID() != null);
            {
                retval.append(DOUBLE_QUOTE + getVisitedNetworkID() + DOUBLE_QUOTE);
                retval.append(getVisitedNetworkID());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_865977892 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } //End collapsed parenthetic
        String var0F1F65BA89BF920BA1A29FC87F91B969_1511015079 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //if (getVisitedNetworkID() != null)
        //{
            //if (isQuoted)
                //retval.append(DOUBLE_QUOTE + getVisitedNetworkID() + DOUBLE_QUOTE);
            //else
                //retval.append(getVisitedNetworkID());
        //}
        //if (!parameters.isEmpty())
            //retval.append(SEMICOLON + this.parameters.encode());
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.628 -0400", hash_original_method = "F88375989912893742E68A8CB169C4C0", hash_generated_method = "88B22A7777D3564995217D36C89A224D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVisitedNetworkID(String networkID) {
        dsTaint.addTaint(networkID);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the networkID parameter is null");
        this.isQuoted = true;
        // ---------- Original Method ----------
        //if (networkID == null)
            //throw new NullPointerException(" the networkID parameter is null");
        //this.networkID = networkID;
        //this.isQuoted = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.628 -0400", hash_original_method = "3764C600A7ABF764E75A7A0F8A4AD296", hash_generated_method = "82D9549109A8C4010CF8F4DEB2E0E93E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVisitedNetworkID(Token networkID) {
        dsTaint.addTaint(networkID.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the networkID parameter is null");
        this.networkID = networkID.getTokenValue();
        this.isQuoted = false;
        // ---------- Original Method ----------
        //if (networkID == null)
            //throw new NullPointerException(" the networkID parameter is null");
        //this.networkID = networkID.getTokenValue();
        //this.isQuoted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.628 -0400", hash_original_method = "C32CBAC6FBA17FDD7866AA432385EFB6", hash_generated_method = "A563636103C3921A32FC6E91E24D9A58")
    @DSModeled(DSC.SAFE)
    public String getVisitedNetworkID() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return networkID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.628 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException (value,0);
        // ---------- Original Method ----------
        //throw new ParseException (value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.628 -0400", hash_original_method = "BB5BE6B7830212EF4C97BABF52359F44", hash_generated_method = "13A719BBB9A426FC62A1F16905485A25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            PVisitedNetworkIDHeader o;
            o = (PVisitedNetworkIDHeader) other;
            boolean var661AAE0247993E36076F6683D7B53893_369777695 = ((this.getVisitedNetworkID().equals( o.getVisitedNetworkID() )
                && this.equalParameters( (Parameters) o )));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other instanceof PVisitedNetworkIDHeader)
        //{
            //PVisitedNetworkIDHeader o = (PVisitedNetworkIDHeader) other;
            //return (this.getVisitedNetworkID().equals( o.getVisitedNetworkID() )
                //&& this.equalParameters( (Parameters) o ));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.628 -0400", hash_original_method = "FDDED33F93F598CF66CA227B3E72EBB0", hash_generated_method = "31359CDAAE5D6A9610CB17DC9CBF7AFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PVisitedNetworkID retval;
        retval = (PVisitedNetworkID) super.clone();
        retval.networkID = this.networkID;
        retval.isQuoted = this.isQuoted;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PVisitedNetworkID retval = (PVisitedNetworkID) super.clone();
        //if (this.networkID != null)
            //retval.networkID = this.networkID;
        //retval.isQuoted = this.isQuoted;
        //return retval;
    }

    
}

