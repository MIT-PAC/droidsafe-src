package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.CallIdHeader;
import java.text.ParseException;

public class CallID extends SIPHeader implements javax.sip.header.CallIdHeader {
    protected CallIdentifier callIdentifier;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.837 -0400", hash_original_method = "253D83F9785581049F0DE9229A1A9A12", hash_generated_method = "D0160839F48607E2E4B82542420DBAB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallID() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.837 -0400", hash_original_method = "931206B362DAA8816F4CAAC363313ED6", hash_generated_method = "58B9D40C586C431E393ADA441E059C24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallID(String callId) throws IllegalArgumentException {
        super(NAME);
        dsTaint.addTaint(callId);
        this.callIdentifier = new CallIdentifier(callId);
        // ---------- Original Method ----------
        //this.callIdentifier = new CallIdentifier(callId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.838 -0400", hash_original_method = "90F237F3A3B37E6D3BD3A71F3DAA1462", hash_generated_method = "9A6122FA5428E9124DE68B24343C5DDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals( Object other ) {
        dsTaint.addTaint(other.dsTaint);
        {
            CallIdHeader o;
            o = (CallIdHeader) other;
            boolean var65CC4F8E6FF173BD6EB01E62713DA33D_1481105959 = (this.getCallId().equalsIgnoreCase( o.getCallId() ));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof CallIdHeader) {
            //final CallIdHeader o = (CallIdHeader) other;
            //return this.getCallId().equalsIgnoreCase( o.getCallId() );
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.838 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "EE8B06EFC0498B08A9A55443765CFD1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_1845540523 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.838 -0400", hash_original_method = "FA90F4B44CEDD454BFF7BD5B8D6838EA", hash_generated_method = "CD94EB5ED8FC049601EFF69D96F13985")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        callIdentifier.encode(buffer);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (callIdentifier != null)
            //callIdentifier.encode(buffer);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.838 -0400", hash_original_method = "E18AC147BDD8255E722D716AAB46B0FD", hash_generated_method = "1B1A1FFCA1AAB4DBB1F1DD869B156C87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCallId() {
        String var29A86416073DA4B9FD8B3AF2E3B90A2B_841915351 = (encodeBody());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.838 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "FED86B4D25B97C95F0A42DFA2DD811D8")
    @DSModeled(DSC.SAFE)
    public CallIdentifier getCallIdentifer() {
        return (CallIdentifier)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return callIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.839 -0400", hash_original_method = "CCC70F9489E78808F4B3E55A9B08CA23", hash_generated_method = "86ACB6C7010890A6577B3F5F9CBCF92C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCallId(String cid) throws ParseException {
        dsTaint.addTaint(cid);
        try 
        {
            callIdentifier = new CallIdentifier(cid);
        } //End block
        catch (IllegalArgumentException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(cid, 0);
        } //End block
        // ---------- Original Method ----------
        //try {
            //callIdentifier = new CallIdentifier(cid);
        //} catch (IllegalArgumentException ex) {
            //throw new ParseException(cid, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.839 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "6DC6E44B1B5E338C185D18F65474D66E")
    @DSModeled(DSC.SAFE)
    public void setCallIdentifier(CallIdentifier cid) {
        dsTaint.addTaint(cid.dsTaint);
        // ---------- Original Method ----------
        //callIdentifier = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.839 -0400", hash_original_method = "6EEF27DF9C05DE559BD56269DDD0A6F4", hash_generated_method = "D4A97B30DA68C5E7EC44EAFA3471267F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        CallID retval;
        retval = (CallID) super.clone();
        retval.callIdentifier = (CallIdentifier) this.callIdentifier.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //CallID retval = (CallID) super.clone();
        //if (this.callIdentifier != null)
            //retval.callIdentifier = (CallIdentifier) this.callIdentifier.clone();
        //return retval;
    }

    
    private static final long serialVersionUID = -6463630258703731156L;
}

