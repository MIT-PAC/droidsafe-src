package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;
import java.text.ParseException;

public class InReplyTo extends SIPHeader implements InReplyToHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.527 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "F2A7BDC27E688B3BD5C6A8CB27C2DD56")

    protected CallIdentifier callId;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.527 -0400", hash_original_method = "561B527F5C5623362D2C0AB5E9627468", hash_generated_method = "707E7DE6657A4D9EDF233D4BDC82F475")
    public  InReplyTo() {
        super(IN_REPLY_TO);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.528 -0400", hash_original_method = "92FFE21441DA37C601278DB74C30EBCA", hash_generated_method = "352E400B155B2FEC10BA1BDE1E4626BF")
    public  InReplyTo(CallIdentifier cid) {
        super(IN_REPLY_TO);
        callId = cid;
        // ---------- Original Method ----------
        //callId = cid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.528 -0400", hash_original_method = "AFE760D92C6B99B9817A49FA1C34A82C", hash_generated_method = "CB93A58B7721776895CD0E2197BCE6BA")
    public void setCallId(String callId) throws ParseException {
        try 
        {
            this.callId = new CallIdentifier(callId);
        } //End block
        catch (Exception e)
        {
            ParseException varAC1698F4D240F9E8C781C7FF37C9875F_722120631 = new ParseException(e.getMessage(), 0);
            varAC1698F4D240F9E8C781C7FF37C9875F_722120631.addTaint(taint);
            throw varAC1698F4D240F9E8C781C7FF37C9875F_722120631;
        } //End block
        // ---------- Original Method ----------
        //try {
            //this.callId = new CallIdentifier(callId);
        //} catch (Exception e) {
            //throw new ParseException(e.getMessage(), 0);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.528 -0400", hash_original_method = "EA32F9E304DDFDAAFD9F10122A085C03", hash_generated_method = "FA010C085D3CAE7FFA7AA8706777A32B")
    public String getCallId() {
        if(callId == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1659469474 =         null;
        var540C13E9E156B687226421B24F2DF178_1659469474.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1659469474;
        }
String var458701EC323B8ACB74F03E71B901A251_189778959 =         callId.encode();
        var458701EC323B8ACB74F03E71B901A251_189778959.addTaint(taint);
        return var458701EC323B8ACB74F03E71B901A251_189778959;
        // ---------- Original Method ----------
        //if (callId == null)
            //return null;
        //return callId.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.529 -0400", hash_original_method = "64901279DBD4FD22B1D7FC340D43545B", hash_generated_method = "C2FABA0DC1D137866BB5D7E0C5B1432F")
    public String encodeBody() {
String var458701EC323B8ACB74F03E71B901A251_1257323051 =         callId.encode();
        var458701EC323B8ACB74F03E71B901A251_1257323051.addTaint(taint);
        return var458701EC323B8ACB74F03E71B901A251_1257323051;
        // ---------- Original Method ----------
        //return callId.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.529 -0400", hash_original_method = "AACC864B78324D30A82E58DDECBB4AB7", hash_generated_method = "8ABBE76AF7EAF45A26DD5DF12F76BFA3")
    public Object clone() {
        InReplyTo retval = (InReplyTo) super.clone();
        if(this.callId != null)        
        retval.callId = (CallIdentifier) this.callId.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_537319978 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_537319978.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_537319978;
        // ---------- Original Method ----------
        //InReplyTo retval = (InReplyTo) super.clone();
        //if (this.callId != null)
            //retval.callId = (CallIdentifier) this.callId.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.529 -0400", hash_original_field = "1A34C461295F41F2981CC491B776BBF3", hash_generated_field = "62113CBAA9CAEBCC0941329C8D032899")

    private static final long serialVersionUID = 1682602905733508890L;
}

