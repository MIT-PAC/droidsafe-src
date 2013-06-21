package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import javax.sip.header.*;

public class SIPDateHeader extends SIPHeader implements DateHeader {
    protected SIPDate date;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.268 -0400", hash_original_method = "1EECE0587E859340DA3FB0354A4B8225", hash_generated_method = "82F22B1EC104F5553333AC52A87327F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPDateHeader() {
        super(DATE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.268 -0400", hash_original_method = "C034912C24C8AA492A55E1DAB6749820", hash_generated_method = "23E413D35D9145103EB9FA416F75B608")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var0ED0AE081E9B9FF20AE540BC67A96ECC_2025850209 = (date.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return date.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.268 -0400", hash_original_method = "6C9EAA9AEBF2DE9AF857C9766729F95B", hash_generated_method = "A4D0990F666881CC1BC1E6623978F382")
    @DSModeled(DSC.SAFE)
    public void setDate(SIPDate d) {
        dsTaint.addTaint(d.dsTaint);
        // ---------- Original Method ----------
        //date = d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.268 -0400", hash_original_method = "593883A7F1E198F7FABAA636FE37D3D4", hash_generated_method = "1919CCE1763CED50C35C0BB7457131B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDate(Calendar dat) {
        dsTaint.addTaint(dat.dsTaint);
        date = new SIPDate(dat.getTime().getTime());
        // ---------- Original Method ----------
        //if (dat != null)
            //date = new SIPDate(dat.getTime().getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.270 -0400", hash_original_method = "8348440FA7E2BF46CE5F14E959934430", hash_generated_method = "A32AA468480E44985717E46F5F4C1244")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Calendar getDate() {
        Calendar var53AFADD3C3E38031A85E3925B56994CE_2134816911 = (date.getJavaCal());
        return (Calendar)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (date == null)
            //return null;
        //return date.getJavaCal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.270 -0400", hash_original_method = "D8FA67BA672B59A2560C827929374032", hash_generated_method = "8AC214E08852F01B66F2D1655CB682A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        SIPDateHeader retval;
        retval = (SIPDateHeader) super.clone();
        retval.date = (SIPDate) this.date.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPDateHeader retval = (SIPDateHeader) super.clone();
        //if (this.date != null)
            //retval.date = (SIPDate) this.date.clone();
        //return retval;
    }

    
    private static final long serialVersionUID = 1734186339037274664L;
}

