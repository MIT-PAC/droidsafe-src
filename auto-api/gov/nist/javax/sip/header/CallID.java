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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.404 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "8FC7908A513558296E298532350EE885")

    protected CallIdentifier callIdentifier;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.415 -0400", hash_original_method = "253D83F9785581049F0DE9229A1A9A12", hash_generated_method = "D0160839F48607E2E4B82542420DBAB5")
    public  CallID() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.415 -0400", hash_original_method = "931206B362DAA8816F4CAAC363313ED6", hash_generated_method = "C016BAC8412FB03C8BCF9C3AA8A9D65B")
    public  CallID(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        // ---------- Original Method ----------
        //this.callIdentifier = new CallIdentifier(callId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.415 -0400", hash_original_method = "90F237F3A3B37E6D3BD3A71F3DAA1462", hash_generated_method = "876A35609277B3BC187283E659745372")
    public boolean equals( Object other ) {
        {
            CallIdHeader o;
            o = (CallIdHeader) other;
            boolean var65CC4F8E6FF173BD6EB01E62713DA33D_1994099835 = (this.getCallId().equalsIgnoreCase( o.getCallId() ));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1571957829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1571957829;
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof CallIdHeader) {
            //final CallIdHeader o = (CallIdHeader) other;
            //return this.getCallId().equalsIgnoreCase( o.getCallId() );
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.416 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "BBDDEE330C7DB8059B78281B91878F4A")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1391326488 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1391326488 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1391326488.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1391326488;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.416 -0400", hash_original_method = "FA90F4B44CEDD454BFF7BD5B8D6838EA", hash_generated_method = "CE1583325D14E87DB12BB3A6B8263E34")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_102480397 = null; //Variable for return #1
        callIdentifier.encode(buffer);
        varB4EAC82CA7396A68D541C85D26508E83_102480397 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_102480397.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_102480397;
        // ---------- Original Method ----------
        //if (callIdentifier != null)
            //callIdentifier.encode(buffer);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.417 -0400", hash_original_method = "E18AC147BDD8255E722D716AAB46B0FD", hash_generated_method = "DC038578948BF5C6E125574CB27D4B2B")
    public String getCallId() {
        String varB4EAC82CA7396A68D541C85D26508E83_151502273 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_151502273 = encodeBody();
        varB4EAC82CA7396A68D541C85D26508E83_151502273.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_151502273;
        // ---------- Original Method ----------
        //return encodeBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.417 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "805636D6A082CADFF4E51CC5B8527E69")
    public CallIdentifier getCallIdentifer() {
        CallIdentifier varB4EAC82CA7396A68D541C85D26508E83_424786607 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_424786607 = callIdentifier;
        varB4EAC82CA7396A68D541C85D26508E83_424786607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_424786607;
        // ---------- Original Method ----------
        //return callIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.418 -0400", hash_original_method = "CCC70F9489E78808F4B3E55A9B08CA23", hash_generated_method = "6682CEC32E4B7F4EBCCF527FE3731105")
    public void setCallId(String cid) throws ParseException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.418 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        // ---------- Original Method ----------
        //callIdentifier = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.419 -0400", hash_original_method = "6EEF27DF9C05DE559BD56269DDD0A6F4", hash_generated_method = "2EFA84869C5E1975EA604000098BCF4E")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_31605712 = null; //Variable for return #1
        CallID retval;
        retval = (CallID) super.clone();
        retval.callIdentifier = (CallIdentifier) this.callIdentifier.clone();
        varB4EAC82CA7396A68D541C85D26508E83_31605712 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_31605712.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_31605712;
        // ---------- Original Method ----------
        //CallID retval = (CallID) super.clone();
        //if (this.callIdentifier != null)
            //retval.callIdentifier = (CallIdentifier) this.callIdentifier.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.419 -0400", hash_original_field = "0623C74B7DE1FFDCB070993B828B341D", hash_generated_field = "447F5604472B8BF30C108214021B0814")

    private static long serialVersionUID = -6463630258703731156L;
}

