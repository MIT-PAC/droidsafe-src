package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.text.ParseException;

public class InReplyTo extends SIPHeader implements InReplyToHeader {
    protected CallIdentifier callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.002 -0400", hash_original_method = "561B527F5C5623362D2C0AB5E9627468", hash_generated_method = "707E7DE6657A4D9EDF233D4BDC82F475")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InReplyTo() {
        super(IN_REPLY_TO);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.002 -0400", hash_original_method = "92FFE21441DA37C601278DB74C30EBCA", hash_generated_method = "5ACF02BA63EF2F2D8530E3741249AA34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InReplyTo(CallIdentifier cid) {
        super(IN_REPLY_TO);
        dsTaint.addTaint(cid.dsTaint);
        // ---------- Original Method ----------
        //callId = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.002 -0400", hash_original_method = "AFE760D92C6B99B9817A49FA1C34A82C", hash_generated_method = "624087563139F753ABB1F4B6BC16D83C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCallId(String callId) throws ParseException {
        dsTaint.addTaint(callId);
        try 
        {
            this.callId = new CallIdentifier(callId);
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), 0);
        } //End block
        // ---------- Original Method ----------
        //try {
            //this.callId = new CallIdentifier(callId);
        //} catch (Exception e) {
            //throw new ParseException(e.getMessage(), 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.002 -0400", hash_original_method = "EA32F9E304DDFDAAFD9F10122A085C03", hash_generated_method = "69AB4D5D0C8EB910D49F8D13F0C60812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCallId() {
        String varBFC6D8404FD2E486FACABA67E19FE73A_1218619384 = (callId.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (callId == null)
            //return null;
        //return callId.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.003 -0400", hash_original_method = "64901279DBD4FD22B1D7FC340D43545B", hash_generated_method = "CCBE3441D90C18E1768783B4255C29DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String varBFC6D8404FD2E486FACABA67E19FE73A_771213602 = (callId.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return callId.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.003 -0400", hash_original_method = "AACC864B78324D30A82E58DDECBB4AB7", hash_generated_method = "5C6BB6E21DDBC22C09556A722307F153")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        InReplyTo retval;
        retval = (InReplyTo) super.clone();
        retval.callId = (CallIdentifier) this.callId.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //InReplyTo retval = (InReplyTo) super.clone();
        //if (this.callId != null)
            //retval.callId = (CallIdentifier) this.callId.clone();
        //return retval;
    }

    
    private static final long serialVersionUID = 1682602905733508890L;
}

