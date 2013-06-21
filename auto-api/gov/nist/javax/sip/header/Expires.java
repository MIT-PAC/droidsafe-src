package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.*;

public class Expires extends SIPHeader implements javax.sip.header.ExpiresHeader {
    protected int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.932 -0400", hash_original_method = "0542B72E4A4F7744BB9DEA78B33603A7", hash_generated_method = "2BE5D43F7C2297EF5B98693F09A128A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Expires() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.933 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "90A377FA367DB8F1313533337E0BCE5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_666435544 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.933 -0400", hash_original_method = "D18BC4E3774CF43CFCD5002AEFE6A6EE", hash_generated_method = "3195808EB7741A49F508E452C8CBDEFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        StringBuffer varD973CEDDEDAFC175AAE72C3048B445D6_1577605061 = (buffer.append(expires));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return buffer.append(expires);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.933 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "60423F18F704DCC829EC803D3BFEF274")
    @DSModeled(DSC.SAFE)
    public int getExpires() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.933 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "CCB9F749035467D307A431C280729B50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExpires(int expires) throws InvalidArgumentException {
        dsTaint.addTaint(expires);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad argument " + expires);
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    private static final long serialVersionUID = 3134344915465784267L;
}

