package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.LogRecord;

class MessageLog implements LogRecord {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.118 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "B2821CE5540C52B19670BB2C4012F012")

    private String message;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.118 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "2D2DC69F3BF28B00B15BD37DFC141996")

    private String source;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.118 -0400", hash_original_field = "6990A54322D9232390A784C5C9247DD6", hash_generated_field = "8BC6EA56B5330B53673CB5DD16E8AC4E")

    private String destination;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.118 -0400", hash_original_field = "87A3CB5C3554B2D9D8A1A773AD0936BE", hash_generated_field = "8839F6F627CF1085C871938312AAE918")

    private long timeStamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.118 -0400", hash_original_field = "19473E77C4CC50B29F8FF43127858000", hash_generated_field = "BF031D181B175207CB4FAF9A21666838")

    private boolean isSender;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.118 -0400", hash_original_field = "71F67F8E91222F095406DD3AD8FD65B2", hash_generated_field = "2D552DD3A1F19C65B36565EE0106C9DB")

    private String firstLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.118 -0400", hash_original_field = "97BEAA21D4819A1131833B897504CE31", hash_generated_field = "6E3A8FD900779FBB9A4728967FE109EF")

    private String tid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.118 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "14745A902962E272FDA1DE862859D03C")

    private String callId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.118 -0400", hash_original_field = "61668CF17C5ADD0EF8C0484BCFFC50C7", hash_generated_field = "D3FCB03CE5B4F679C534C994BCE675D9")

    private long timeStampHeaderValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.124 -0400", hash_original_method = "4DF5C3B1D01E7222DCCDFE20C1B5824A", hash_generated_method = "936CFFE9111E0EE814165E14FBE7C42B")
    public  MessageLog(
        String message,
        String source,
        String destination,
        String timeStamp,
        boolean isSender,
        String firstLine,
        String tid,
        String callId,
        long timeStampHeaderValue) {
        {
            boolean var87EE51FB0574C275E93ACB88F58D7718_847335436 = (message == null || message.equals(""));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null msg");
        } //End collapsed parenthetic
        this.message = message;
        this.source = source;
        this.destination = destination;
        try 
        {
            long ts;
            ts = Long.parseLong(timeStamp);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad time stamp ");
            this.timeStamp = ts;
        } //End block
        catch (NumberFormatException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Bad number format " + timeStamp);
        } //End block
        this.isSender = isSender;
        this.firstLine = firstLine;
        this.tid = tid;
        this.callId = callId;
        this.timeStampHeaderValue = timeStampHeaderValue;
        // ---------- Original Method ----------
        //if (message == null || message.equals(""))
            //throw new IllegalArgumentException("null msg");
        //this.message = message;
        //this.source = source;
        //this.destination = destination;
        //try {
            //long ts = Long.parseLong(timeStamp);
            //if (ts < 0)
                //throw new IllegalArgumentException("Bad time stamp ");
            //this.timeStamp = ts;
        //} catch (NumberFormatException ex) {
            //throw new IllegalArgumentException(
                //"Bad number format " + timeStamp);
        //}
        //this.isSender = isSender;
        //this.firstLine = firstLine;
        //this.tid = tid;
        //this.callId = callId;
        //this.timeStampHeaderValue = timeStampHeaderValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.129 -0400", hash_original_method = "C29CF89B26E4E43BB7B19BB7E4FDCA0D", hash_generated_method = "161BE22C1808C5ABCC183F4C839D5134")
    public  MessageLog(
        String message,
        String source,
        String destination,
        long timeStamp,
        boolean isSender,
        String firstLine,
        String tid,
        String callId,
        long timestampVal) {
        {
            boolean var87EE51FB0574C275E93ACB88F58D7718_388808474 = (message == null || message.equals(""));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null msg");
        } //End collapsed parenthetic
        this.message = message;
        this.source = source;
        this.destination = destination;
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("negative ts");
        this.timeStamp = timeStamp;
        this.isSender = isSender;
        this.firstLine = firstLine;
        this.tid = tid;
        this.callId = callId;
        this.timeStampHeaderValue = timestampVal;
        // ---------- Original Method ----------
        //if (message == null || message.equals(""))
            //throw new IllegalArgumentException("null msg");
        //this.message = message;
        //this.source = source;
        //this.destination = destination;
        //if (timeStamp < 0)
            //throw new IllegalArgumentException("negative ts");
        //this.timeStamp = timeStamp;
        //this.isSender = isSender;
        //this.firstLine = firstLine;
        //this.tid = tid;
        //this.callId = callId;
        //this.timeStampHeaderValue = timestampVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.130 -0400", hash_original_method = "818407DE55CFD10CF1C5E889367D1C2C", hash_generated_method = "56CBD92A4BFFC09C0A935F1D3D99D38C")
    public boolean equals(Object other) {
        {
            MessageLog otherLog;
            otherLog = (MessageLog) other;
            boolean var5BA4675877B9A55A06DCDAB0A337D10C_340847127 = (otherLog.message.equals(message)
                && otherLog.timeStamp == timeStamp);
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1924278805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1924278805;
        // ---------- Original Method ----------
        //if (!(other instanceof MessageLog)) {
            //return false;
        //} else {
            //MessageLog otherLog = (MessageLog) other;
            //return otherLog.message.equals(message)
                //&& otherLog.timeStamp == timeStamp;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.138 -0400", hash_original_method = "41C5D33A303365643BC91460F622FA81", hash_generated_method = "56213056B11A8BC57403AEB754C1830A")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1355431479 = null; //Variable for return #1
        String log;
        log =
                "<message\nfrom=\""
                    + source
                    + "\" \nto=\""
                    + destination
                    + "\" \ntime=\""
                    + timeStamp
                    + "\"" +
                    (this.timeStampHeaderValue != 0 ? "\ntimeStamp = \"" + timeStampHeaderValue + "\"": "")
                    +"\nisSender=\""
                    + isSender
                    + "\" \ntransactionId=\""
                    + tid
                    + "\" \ncallId=\""
                    + callId
                    + "\" \nfirstLine=\""
                    + firstLine.trim() + "\"" +
                    " \n>\n";
        log += "<![CDATA[";
        log += message;
        log += "]]>\n";
        log += "</message>\n";
        varB4EAC82CA7396A68D541C85D26508E83_1355431479 = log;
        varB4EAC82CA7396A68D541C85D26508E83_1355431479.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1355431479;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

