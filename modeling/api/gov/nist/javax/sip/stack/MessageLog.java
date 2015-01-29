package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import gov.nist.javax.sip.LogRecord;

class MessageLog implements LogRecord {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.269 -0500", hash_original_field = "C9795C94D34B39950C581203743BD4FC", hash_generated_field = "B2821CE5540C52B19670BB2C4012F012")

    private String message;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.272 -0500", hash_original_field = "113A199BE68A5F67DC2655549852AA2D", hash_generated_field = "2D2DC69F3BF28B00B15BD37DFC141996")

    private String source;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.275 -0500", hash_original_field = "9C0B0021197F106E280DA8DF3BF9C5F6", hash_generated_field = "8BC6EA56B5330B53673CB5DD16E8AC4E")

    private String destination;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.278 -0500", hash_original_field = "B8645A227D0EF41C75E91388EE726ECD", hash_generated_field = "8839F6F627CF1085C871938312AAE918")

    private long timeStamp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.281 -0500", hash_original_field = "053B99682D05D7B6BC4286FE0D4AE99F", hash_generated_field = "BF031D181B175207CB4FAF9A21666838")

    private boolean isSender;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.284 -0500", hash_original_field = "8DF830CCA9AB6C89377476D5F6D51F6B", hash_generated_field = "2D552DD3A1F19C65B36565EE0106C9DB")

    private String firstLine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.287 -0500", hash_original_field = "1995A0A393E0F3B67BD2EEA9BA9CBC01", hash_generated_field = "6E3A8FD900779FBB9A4728967FE109EF")

    private String tid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.290 -0500", hash_original_field = "2657C3812CAC2EE2FF30C5C628C0A470", hash_generated_field = "14745A902962E272FDA1DE862859D03C")

    private String callId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.293 -0500", hash_original_field = "D0464372A446FB6E7C549A32B39119FD", hash_generated_field = "D3FCB03CE5B4F679C534C994BCE675D9")

    private long timeStampHeaderValue;

    /**
     * Constructor
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.299 -0500", hash_original_method = "4DF5C3B1D01E7222DCCDFE20C1B5824A", hash_generated_method = "6198DE5F64540E33559AA54ED7AD97D2")
    
public MessageLog(
        String message,
        String source,
        String destination,
        String timeStamp,
        boolean isSender,
        String firstLine,
        String tid,
        String callId,
        long timeStampHeaderValue) {
        if (message == null || message.equals(""))
            throw new IllegalArgumentException("null msg");
        this.message = message;
        this.source = source;
        this.destination = destination;
        try {
            long ts = Long.parseLong(timeStamp);
            if (ts < 0)
                throw new IllegalArgumentException("Bad time stamp ");
            this.timeStamp = ts;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(
                "Bad number format " + timeStamp);
        }
        this.isSender = isSender;
        this.firstLine = firstLine;
        this.tid = tid;
        this.callId = callId;
        this.timeStampHeaderValue = timeStampHeaderValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.302 -0500", hash_original_method = "C29CF89B26E4E43BB7B19BB7E4FDCA0D", hash_generated_method = "E55185EE1833A5A5CD9DA8AA6333AD15")
    
public MessageLog(
        String message,
        String source,
        String destination,
        long timeStamp,
        boolean isSender,
        String firstLine,
        String tid,
        String callId,
        long timestampVal) {
        if (message == null || message.equals(""))
            throw new IllegalArgumentException("null msg");
        this.message = message;
        this.source = source;
        this.destination = destination;
        if (timeStamp < 0)
            throw new IllegalArgumentException("negative ts");
        this.timeStamp = timeStamp;
        this.isSender = isSender;
        this.firstLine = firstLine;
        this.tid = tid;
        this.callId = callId;
        this.timeStampHeaderValue = timestampVal;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.stack.LogRecord#equals(java.lang.Object)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.296 -0500", hash_original_method = "818407DE55CFD10CF1C5E889367D1C2C", hash_generated_method = "0E1513C8FDADA8E0E75BF9906AEEF3EC")
    
public boolean equals(Object other) {
        if (!(other instanceof MessageLog)) {
            return false;
        } else {
            MessageLog otherLog = (MessageLog) other;
            return otherLog.message.equals(message)
                && otherLog.timeStamp == timeStamp;
        }
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.stack.LogRecord#toString()
     */

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:19.305 -0500", hash_original_method = "41C5D33A303365643BC91460F622FA81", hash_generated_method = "A3E5892A70B20FFEC295C1E6893FF92C")
    
public String toString() {
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

        return log;
    }
    
}

