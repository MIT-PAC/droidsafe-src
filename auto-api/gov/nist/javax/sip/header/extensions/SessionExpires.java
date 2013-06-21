package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.ParametersHeader;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;

public final class SessionExpires extends ParametersHeader implements ExtensionHeader, SessionExpiresHeader {
    public int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.524 -0400", hash_original_method = "A8246024A4BBDCEF318DB7F6B74C4E64", hash_generated_method = "0E464BB06220F15972D6EA6681E34A06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SessionExpires() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.524 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "60423F18F704DCC829EC803D3BFEF274")
    @DSModeled(DSC.SAFE)
    public int getExpires() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.524 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "CCB9F749035467D307A431C280729B50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExpires(int expires) throws InvalidArgumentException {
        dsTaint.addTaint(expires);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad argument " + expires);
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.524 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.525 -0400", hash_original_method = "B1D6BF5FEA5681AEA45EA9D4CACD9FB8", hash_generated_method = "FB53A7B704066D984069DD32864DBCD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String retval;
        retval = Integer.toString(expires);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_907572225 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String retval = Integer.toString(expires);
        //if (!parameters.isEmpty()) {
            //retval += SEMICOLON + parameters.encode();
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.525 -0400", hash_original_method = "5E6D9C5D9628C8E8194658511D516C38", hash_generated_method = "EEF278DED33979C19A8F8C0F79FBACF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRefresher() {
        String varF34E8DBE7E5FD0328E005D175BCF5EED_805034085 = (parameters.getParameter(REFRESHER));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return parameters.getParameter(REFRESHER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.525 -0400", hash_original_method = "B765158B109DFF1FFF87124C5A68F884", hash_generated_method = "C4EE6CA1518141C145A53957C29375E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRefresher(String refresher) {
        dsTaint.addTaint(refresher);
        this.parameters.set(REFRESHER,refresher);
        // ---------- Original Method ----------
        //this.parameters.set(REFRESHER,refresher);
    }

    
    private static final long serialVersionUID = 8765762413224043300L;
    public static final String NAME = "Session-Expires";
    public static final String REFRESHER = "refresher";
}

