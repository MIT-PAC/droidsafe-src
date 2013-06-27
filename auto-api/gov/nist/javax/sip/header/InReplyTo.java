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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.043 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "F2A7BDC27E688B3BD5C6A8CB27C2DD56")

    protected CallIdentifier callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.050 -0400", hash_original_method = "561B527F5C5623362D2C0AB5E9627468", hash_generated_method = "707E7DE6657A4D9EDF233D4BDC82F475")
    public  InReplyTo() {
        super(IN_REPLY_TO);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.050 -0400", hash_original_method = "92FFE21441DA37C601278DB74C30EBCA", hash_generated_method = "352E400B155B2FEC10BA1BDE1E4626BF")
    public  InReplyTo(CallIdentifier cid) {
        super(IN_REPLY_TO);
        callId = cid;
        // ---------- Original Method ----------
        //callId = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.051 -0400", hash_original_method = "AFE760D92C6B99B9817A49FA1C34A82C", hash_generated_method = "00401468DE4778F3B2C52ED98F78BD40")
    public void setCallId(String callId) throws ParseException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.052 -0400", hash_original_method = "EA32F9E304DDFDAAFD9F10122A085C03", hash_generated_method = "7383DEC0E0BABBB85047B318EF218030")
    public String getCallId() {
        String varB4EAC82CA7396A68D541C85D26508E83_689482828 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1027254707 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_689482828 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1027254707 = callId.encode();
        String varA7E53CE21691AB073D9660D615818899_355747502; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_355747502 = varB4EAC82CA7396A68D541C85D26508E83_689482828;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_355747502 = varB4EAC82CA7396A68D541C85D26508E83_1027254707;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_355747502.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_355747502;
        // ---------- Original Method ----------
        //if (callId == null)
            //return null;
        //return callId.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.052 -0400", hash_original_method = "64901279DBD4FD22B1D7FC340D43545B", hash_generated_method = "3D445008D964E76D41E8C6C1E0595A3B")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1469666993 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1469666993 = callId.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1469666993.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1469666993;
        // ---------- Original Method ----------
        //return callId.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.053 -0400", hash_original_method = "AACC864B78324D30A82E58DDECBB4AB7", hash_generated_method = "67A74A43ADAE143680BCE471ED888538")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2108912575 = null; //Variable for return #1
        InReplyTo retval;
        retval = (InReplyTo) super.clone();
        retval.callId = (CallIdentifier) this.callId.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2108912575 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2108912575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2108912575;
        // ---------- Original Method ----------
        //InReplyTo retval = (InReplyTo) super.clone();
        //if (this.callId != null)
            //retval.callId = (CallIdentifier) this.callId.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.053 -0400", hash_original_field = "1A34C461295F41F2981CC491B776BBF3", hash_generated_field = "144E6D3BE4703BF63005A23A1A151053")

    private static long serialVersionUID = 1682602905733508890L;
}

