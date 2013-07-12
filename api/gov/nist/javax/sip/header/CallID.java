package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.CallIdHeader;
import java.text.ParseException;

public class CallID extends SIPHeader implements javax.sip.header.CallIdHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.089 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "8FC7908A513558296E298532350EE885")

    protected CallIdentifier callIdentifier;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.090 -0400", hash_original_method = "253D83F9785581049F0DE9229A1A9A12", hash_generated_method = "D0160839F48607E2E4B82542420DBAB5")
    public  CallID() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.090 -0400", hash_original_method = "931206B362DAA8816F4CAAC363313ED6", hash_generated_method = "C016BAC8412FB03C8BCF9C3AA8A9D65B")
    public  CallID(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.091 -0400", hash_original_method = "90F237F3A3B37E6D3BD3A71F3DAA1462", hash_generated_method = "0016BAC6D86B3EE5A038C47867E2A04C")
    public boolean equals( Object other ) {
        addTaint(other.getTaint());
    if(this==other)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1953086675 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402887841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402887841;
        }
    if(other instanceof CallIdHeader)        
        {
            final CallIdHeader o = (CallIdHeader) other;
            boolean varC3829D5E10711157B5668DCC29A4CF40_312186557 = (this.getCallId().equalsIgnoreCase( o.getCallId() ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_990136398 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_990136398;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1222668318 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046171107 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046171107;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.091 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "9DD5C56068C5F3D67EB2434423578B7F")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1535354516 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1535354516.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1535354516;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.092 -0400", hash_original_method = "FA90F4B44CEDD454BFF7BD5B8D6838EA", hash_generated_method = "F01AA2400D49217ACC0D1511A18B3F88")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(callIdentifier != null)        
        callIdentifier.encode(buffer);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_943513675 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_943513675.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_943513675;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.092 -0400", hash_original_method = "E18AC147BDD8255E722D716AAB46B0FD", hash_generated_method = "911D14B65E0F4A06B7B6899BF9B8ACDD")
    public String getCallId() {
String varDC9B8D6D54EA94B85989E6497F642BED_69985761 =         encodeBody();
        varDC9B8D6D54EA94B85989E6497F642BED_69985761.addTaint(taint);
        return varDC9B8D6D54EA94B85989E6497F642BED_69985761;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.092 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "459D9CD7DCA70289E770B5C0FD37A8A4")
    public CallIdentifier getCallIdentifer() {
CallIdentifier varA526B294D67900709C29EF73993671CB_1962892771 =         callIdentifier;
        varA526B294D67900709C29EF73993671CB_1962892771.addTaint(taint);
        return varA526B294D67900709C29EF73993671CB_1962892771;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.093 -0400", hash_original_method = "CCC70F9489E78808F4B3E55A9B08CA23", hash_generated_method = "86432078F866FAE5863C56C8BF00F7AD")
    public void setCallId(String cid) throws ParseException {
        try 
        {
            callIdentifier = new CallIdentifier(cid);
        } 
        catch (IllegalArgumentException ex)
        {
            ParseException var3CEFCB5864EF413E23A8BE66B20EB500_59851685 = new ParseException(cid, 0);
            var3CEFCB5864EF413E23A8BE66B20EB500_59851685.addTaint(taint);
            throw var3CEFCB5864EF413E23A8BE66B20EB500_59851685;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.093 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.093 -0400", hash_original_method = "6EEF27DF9C05DE559BD56269DDD0A6F4", hash_generated_method = "62659741CA3C58A24AEA78785D5E6965")
    public Object clone() {
        CallID retval = (CallID) super.clone();
    if(this.callIdentifier != null)        
        retval.callIdentifier = (CallIdentifier) this.callIdentifier.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1068774118 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1068774118.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1068774118;
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.094 -0400", hash_original_field = "0623C74B7DE1FFDCB070993B828B341D", hash_generated_field = "BD88EAFB9547FBFAAD4836DB7C0DFC77")

    private static final long serialVersionUID = -6463630258703731156L;
}

