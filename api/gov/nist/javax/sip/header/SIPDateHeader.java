package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import javax.sip.header.*;

public class SIPDateHeader extends SIPHeader implements DateHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.115 -0400", hash_original_field = "5FC732311905CB27E82D67F4F6511F7F", hash_generated_field = "E6B895F7293606CA8C9A3D5102653BE1")

    protected SIPDate date;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.115 -0400", hash_original_method = "1EECE0587E859340DA3FB0354A4B8225", hash_generated_method = "82F22B1EC104F5553333AC52A87327F2")
    public  SIPDateHeader() {
        super(DATE);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.116 -0400", hash_original_method = "C034912C24C8AA492A55E1DAB6749820", hash_generated_method = "E4A93EFC48AAA2DD551E94F7ACC29FE2")
    public String encodeBody() {
String varAB0A6A99E7ADC519115C61506D7E0E96_1245296964 =         date.encode();
        varAB0A6A99E7ADC519115C61506D7E0E96_1245296964.addTaint(taint);
        return varAB0A6A99E7ADC519115C61506D7E0E96_1245296964;
        // ---------- Original Method ----------
        //return date.encode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.116 -0400", hash_original_method = "6C9EAA9AEBF2DE9AF857C9766729F95B", hash_generated_method = "79D01558A8C4EA0E589F8A4773D04A84")
    public void setDate(SIPDate d) {
        date = d;
        // ---------- Original Method ----------
        //date = d;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.117 -0400", hash_original_method = "593883A7F1E198F7FABAA636FE37D3D4", hash_generated_method = "4F5C43478833B68B5E8F7B037A53E638")
    public void setDate(Calendar dat) {
    if(dat != null)        
        date = new SIPDate(dat.getTime().getTime());
        // ---------- Original Method ----------
        //if (dat != null)
            //date = new SIPDate(dat.getTime().getTime());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.117 -0400", hash_original_method = "8348440FA7E2BF46CE5F14E959934430", hash_generated_method = "D7691046099EB2AA473BDE77393F2CF2")
    public Calendar getDate() {
    if(date == null)        
        {
Calendar var540C13E9E156B687226421B24F2DF178_1244527238 =         null;
        var540C13E9E156B687226421B24F2DF178_1244527238.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1244527238;
        }
Calendar var4FD0607D72EE0073FA4AD42201EADE7F_1652722091 =         date.getJavaCal();
        var4FD0607D72EE0073FA4AD42201EADE7F_1652722091.addTaint(taint);
        return var4FD0607D72EE0073FA4AD42201EADE7F_1652722091;
        // ---------- Original Method ----------
        //if (date == null)
            //return null;
        //return date.getJavaCal();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.117 -0400", hash_original_method = "D8FA67BA672B59A2560C827929374032", hash_generated_method = "D3FDA24B1F2EB535622C9B98264E4718")
    public Object clone() {
        SIPDateHeader retval = (SIPDateHeader) super.clone();
    if(this.date != null)        
        retval.date = (SIPDate) this.date.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_862594523 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_862594523.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_862594523;
        // ---------- Original Method ----------
        //SIPDateHeader retval = (SIPDateHeader) super.clone();
        //if (this.date != null)
            //retval.date = (SIPDate) this.date.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.118 -0400", hash_original_field = "1A67EF30C59B59085B13D3BAF5F6DFA1", hash_generated_field = "FB9F215913247CD3C2C1FF9CAC7EC54C")

    private static final long serialVersionUID = 1734186339037274664L;
}

