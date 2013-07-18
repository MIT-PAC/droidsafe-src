package gov.nist.javax.sip.header;

// Droidsafe Imports
import java.text.ParseException;

import javax.sip.header.CallIdHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class CallID extends SIPHeader implements javax.sip.header.CallIdHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.099 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "8FC7908A513558296E298532350EE885")

    protected CallIdentifier callIdentifier;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.099 -0400", hash_original_method = "253D83F9785581049F0DE9229A1A9A12", hash_generated_method = "D0160839F48607E2E4B82542420DBAB5")
    public  CallID() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.099 -0400", hash_original_method = "931206B362DAA8816F4CAAC363313ED6", hash_generated_method = "C016BAC8412FB03C8BCF9C3AA8A9D65B")
    public  CallID(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        // ---------- Original Method ----------
        //this.callIdentifier = new CallIdentifier(callId);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.100 -0400", hash_original_method = "90F237F3A3B37E6D3BD3A71F3DAA1462", hash_generated_method = "91396A580A0C12DBDBA7311BA068A56E")
    public boolean equals( Object other ) {
        addTaint(other.getTaint());
        if(this==other)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1367328617 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113236920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113236920;
        }
        if(other instanceof CallIdHeader)        
        {
            final CallIdHeader o = (CallIdHeader) other;
            boolean varC3829D5E10711157B5668DCC29A4CF40_527051525 = (this.getCallId().equalsIgnoreCase( o.getCallId() ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1563664236 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1563664236;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1477122338 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2018483303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2018483303;
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof CallIdHeader) {
            //final CallIdHeader o = (CallIdHeader) other;
            //return this.getCallId().equalsIgnoreCase( o.getCallId() );
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.100 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "E781F498B2AF3C9FC115D6B77275FC9D")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1497550472 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1497550472.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1497550472;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.101 -0400", hash_original_method = "FA90F4B44CEDD454BFF7BD5B8D6838EA", hash_generated_method = "5414EF9AE14CA429AE42C89763FA16FA")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(callIdentifier != null)        
        callIdentifier.encode(buffer);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1811024119 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1811024119.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1811024119;
        // ---------- Original Method ----------
        //if (callIdentifier != null)
            //callIdentifier.encode(buffer);
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.101 -0400", hash_original_method = "E18AC147BDD8255E722D716AAB46B0FD", hash_generated_method = "13B2ABE5BBDA5D07FFFFEC272F821116")
    public String getCallId() {
String varDC9B8D6D54EA94B85989E6497F642BED_1407579996 =         encodeBody();
        varDC9B8D6D54EA94B85989E6497F642BED_1407579996.addTaint(taint);
        return varDC9B8D6D54EA94B85989E6497F642BED_1407579996;
        // ---------- Original Method ----------
        //return encodeBody();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.101 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "67CD67CB5FCB3F775524CCEAD3F342EF")
    public CallIdentifier getCallIdentifer() {
CallIdentifier varA526B294D67900709C29EF73993671CB_546572874 =         callIdentifier;
        varA526B294D67900709C29EF73993671CB_546572874.addTaint(taint);
        return varA526B294D67900709C29EF73993671CB_546572874;
        // ---------- Original Method ----------
        //return callIdentifier;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.102 -0400", hash_original_method = "CCC70F9489E78808F4B3E55A9B08CA23", hash_generated_method = "19122561FC1433AE15E487CBE136AA6B")
    public void setCallId(String cid) throws ParseException {
        try 
        {
            callIdentifier = new CallIdentifier(cid);
        } //End block
        catch (IllegalArgumentException ex)
        {
            ParseException var3CEFCB5864EF413E23A8BE66B20EB500_1360405325 = new ParseException(cid, 0);
            var3CEFCB5864EF413E23A8BE66B20EB500_1360405325.addTaint(taint);
            throw var3CEFCB5864EF413E23A8BE66B20EB500_1360405325;
        } //End block
        // ---------- Original Method ----------
        //try {
            //callIdentifier = new CallIdentifier(cid);
        //} catch (IllegalArgumentException ex) {
            //throw new ParseException(cid, 0);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.102 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        // ---------- Original Method ----------
        //callIdentifier = cid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.102 -0400", hash_original_method = "6EEF27DF9C05DE559BD56269DDD0A6F4", hash_generated_method = "C8909DDDC5A7EA98688D48E29E2E1DC0")
    public Object clone() {
        CallID retval = (CallID) super.clone();
        if(this.callIdentifier != null)        
        retval.callIdentifier = (CallIdentifier) this.callIdentifier.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1526552275 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1526552275.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1526552275;
        // ---------- Original Method ----------
        //CallID retval = (CallID) super.clone();
        //if (this.callIdentifier != null)
            //retval.callIdentifier = (CallIdentifier) this.callIdentifier.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.102 -0400", hash_original_field = "0623C74B7DE1FFDCB070993B828B341D", hash_generated_field = "BD88EAFB9547FBFAAD4836DB7C0DFC77")

    private static final long serialVersionUID = -6463630258703731156L;
}

