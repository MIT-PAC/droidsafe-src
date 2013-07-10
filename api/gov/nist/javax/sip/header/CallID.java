package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.CallIdHeader;
import java.text.ParseException;

public class CallID extends SIPHeader implements javax.sip.header.CallIdHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.241 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "8FC7908A513558296E298532350EE885")

    protected CallIdentifier callIdentifier;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.242 -0400", hash_original_method = "253D83F9785581049F0DE9229A1A9A12", hash_generated_method = "D0160839F48607E2E4B82542420DBAB5")
    public  CallID() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.242 -0400", hash_original_method = "931206B362DAA8816F4CAAC363313ED6", hash_generated_method = "C016BAC8412FB03C8BCF9C3AA8A9D65B")
    public  CallID(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.243 -0400", hash_original_method = "90F237F3A3B37E6D3BD3A71F3DAA1462", hash_generated_method = "5BCBEB8E4642E84F75FB3C9193AC8029")
    public boolean equals( Object other ) {
        {
            final CallIdHeader o = (CallIdHeader) other;
            boolean var65CC4F8E6FF173BD6EB01E62713DA33D_131920860 = (this.getCallId().equalsIgnoreCase( o.getCallId() ));
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_226139471 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_226139471;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.243 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "B98B411ABD5EA5221A93809B09AF50B8")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_465876135 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_465876135 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_465876135.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_465876135;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.244 -0400", hash_original_method = "FA90F4B44CEDD454BFF7BD5B8D6838EA", hash_generated_method = "B7999DAAFC817F35D5895BA634244F82")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1059758171 = null; 
        callIdentifier.encode(buffer);
        varB4EAC82CA7396A68D541C85D26508E83_1059758171 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1059758171.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1059758171;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.245 -0400", hash_original_method = "E18AC147BDD8255E722D716AAB46B0FD", hash_generated_method = "4A46F3A69ED7A3A2EA4C8C2935E56ED5")
    public String getCallId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1460029507 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1460029507 = encodeBody();
        varB4EAC82CA7396A68D541C85D26508E83_1460029507.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1460029507;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.245 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "24EBC74BB20574D4485978E989C144BF")
    public CallIdentifier getCallIdentifer() {
        CallIdentifier varB4EAC82CA7396A68D541C85D26508E83_655184808 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_655184808 = callIdentifier;
        varB4EAC82CA7396A68D541C85D26508E83_655184808.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_655184808;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.246 -0400", hash_original_method = "CCC70F9489E78808F4B3E55A9B08CA23", hash_generated_method = "6682CEC32E4B7F4EBCCF527FE3731105")
    public void setCallId(String cid) throws ParseException {
        try 
        {
            callIdentifier = new CallIdentifier(cid);
        } 
        catch (IllegalArgumentException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(cid, 0);
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.246 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.247 -0400", hash_original_method = "6EEF27DF9C05DE559BD56269DDD0A6F4", hash_generated_method = "748D3028C6B27CBAA24D0BEA24F55CA9")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2113875616 = null; 
        CallID retval = (CallID) super.clone();
        retval.callIdentifier = (CallIdentifier) this.callIdentifier.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2113875616 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2113875616.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2113875616;
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.247 -0400", hash_original_field = "0623C74B7DE1FFDCB070993B828B341D", hash_generated_field = "BD88EAFB9547FBFAAD4836DB7C0DFC77")

    private static final long serialVersionUID = -6463630258703731156L;
}

