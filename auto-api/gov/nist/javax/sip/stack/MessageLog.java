package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.LogRecord;

class MessageLog implements LogRecord {
    private String message;
    private String source;
    private String destination;
    private long timeStamp;
    private boolean isSender;
    private String firstLine;
    private String tid;
    private String callId;
    private long timeStampHeaderValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.962 -0400", hash_original_method = "4DF5C3B1D01E7222DCCDFE20C1B5824A", hash_generated_method = "A72FABA0271763B45C2FD40ECE7907FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        dsTaint.addTaint(message);
        dsTaint.addTaint(isSender);
        dsTaint.addTaint(timeStamp);
        dsTaint.addTaint(source);
        dsTaint.addTaint(timeStampHeaderValue);
        dsTaint.addTaint(firstLine);
        dsTaint.addTaint(tid);
        dsTaint.addTaint(callId);
        dsTaint.addTaint(destination);
        {
            boolean var87EE51FB0574C275E93ACB88F58D7718_1532840930 = (message == null || message.equals(""));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null msg");
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.962 -0400", hash_original_method = "C29CF89B26E4E43BB7B19BB7E4FDCA0D", hash_generated_method = "5F82F5C67498C794B06B339058EE54CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        dsTaint.addTaint(message);
        dsTaint.addTaint(isSender);
        dsTaint.addTaint(timeStamp);
        dsTaint.addTaint(source);
        dsTaint.addTaint(timestampVal);
        dsTaint.addTaint(firstLine);
        dsTaint.addTaint(tid);
        dsTaint.addTaint(callId);
        dsTaint.addTaint(destination);
        {
            boolean var87EE51FB0574C275E93ACB88F58D7718_1977952654 = (message == null || message.equals(""));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null msg");
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("negative ts");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.963 -0400", hash_original_method = "818407DE55CFD10CF1C5E889367D1C2C", hash_generated_method = "707AE728FFD0BC5B09E05F495AAF2148")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            MessageLog otherLog;
            otherLog = (MessageLog) other;
            boolean var5BA4675877B9A55A06DCDAB0A337D10C_1852089264 = (otherLog.message.equals(message)
                && otherLog.timeStamp == timeStamp);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(other instanceof MessageLog)) {
            //return false;
        //} else {
            //MessageLog otherLog = (MessageLog) other;
            //return otherLog.message.equals(message)
                //&& otherLog.timeStamp == timeStamp;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.963 -0400", hash_original_method = "41C5D33A303365643BC91460F622FA81", hash_generated_method = "228F2958E3A2B75C241764793EBD657E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

