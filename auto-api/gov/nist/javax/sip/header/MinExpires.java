package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.*;
import javax.sip.header.*;

public class MinExpires extends SIPHeader implements MinExpiresHeader {
    protected int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.019 -0400", hash_original_method = "E220E899B716906991999B2A4C081552", hash_generated_method = "CD25F29B29CDBECA1004AA69954293B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MinExpires() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.019 -0400", hash_original_method = "D42EEF06048E7D77F00EA781D2005D33", hash_generated_method = "0D454E321A2BC94C0BA6512EE8DEBFFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String varB918ABA1D3EE4098C8FD819D955AA7F7_1146495324 = (Integer.toString(expires));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toString(expires);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.019 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "60423F18F704DCC829EC803D3BFEF274")
    @DSModeled(DSC.SAFE)
    public int getExpires() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.019 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "CCB9F749035467D307A431C280729B50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExpires(int expires) throws InvalidArgumentException {
        dsTaint.addTaint(expires);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad argument " + expires);
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    private static final long serialVersionUID = 7001828209606095801L;
}

