package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;
import javax.sip.*;
import javax.sip.header.ExtensionHeader;

public class MinSE extends ParametersHeader implements ExtensionHeader, MinSEHeader {
    public int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.505 -0400", hash_original_method = "FF95F949FD2A1D95680CD0A1163B2941", hash_generated_method = "4E41930010A8369BD320B3492D85970B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MinSE() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.505 -0400", hash_original_method = "B1D6BF5FEA5681AEA45EA9D4CACD9FB8", hash_generated_method = "36108631B9B64D5D7841DEDD47315A02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String retval;
        retval = Integer.toString(expires);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_2026612095 = (!parameters.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.505 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.505 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "60423F18F704DCC829EC803D3BFEF274")
    @DSModeled(DSC.SAFE)
    public int getExpires() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.506 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "CCB9F749035467D307A431C280729B50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExpires(int expires) throws InvalidArgumentException {
        dsTaint.addTaint(expires);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad argument " + expires);
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    public static final String NAME = "Min-SE";
    private static final long serialVersionUID = 3134344915465784267L;
}

