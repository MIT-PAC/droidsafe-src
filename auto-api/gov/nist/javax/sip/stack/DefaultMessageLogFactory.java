package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.LogRecord;
import gov.nist.javax.sip.LogRecordFactory;

public class DefaultMessageLogFactory implements LogRecordFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.799 -0400", hash_original_method = "17484C0AC3F60D27D42A4FA9D282DFBE", hash_generated_method = "17484C0AC3F60D27D42A4FA9D282DFBE")
        public DefaultMessageLogFactory ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.799 -0400", hash_original_method = "1FCBD43A9010493D751AC2489A6EFE82", hash_generated_method = "4EBBC5AAFA08AE3FDF7D7C6EDC4D9DB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LogRecord createLogRecord(String message, String source,
            String destination, String timeStamp, boolean isSender,
            String firstLine, String tid, String callId, long tsHeaderValue) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(isSender);
        dsTaint.addTaint(timeStamp);
        dsTaint.addTaint(source);
        dsTaint.addTaint(tsHeaderValue);
        dsTaint.addTaint(firstLine);
        dsTaint.addTaint(tid);
        dsTaint.addTaint(callId);
        dsTaint.addTaint(destination);
        LogRecord varBECCE4C5B9A7955C6C958F661F59C022_2112512931 = (new MessageLog(message, source, destination, timeStamp,
                isSender, firstLine, tid, callId, tsHeaderValue));
        return (LogRecord)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new MessageLog(message, source, destination, timeStamp,
                //isSender, firstLine, tid, callId, tsHeaderValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.800 -0400", hash_original_method = "6DD4174F440258B3C35BB449B3066E66", hash_generated_method = "179FD3ECD8613B432C083B4588D472CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LogRecord createLogRecord(String message, String source,
            String destination, long timeStamp, boolean isSender,
            String firstLine, String tid, String callId, long timestampVal) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(isSender);
        dsTaint.addTaint(timeStamp);
        dsTaint.addTaint(source);
        dsTaint.addTaint(timestampVal);
        dsTaint.addTaint(firstLine);
        dsTaint.addTaint(tid);
        dsTaint.addTaint(callId);
        dsTaint.addTaint(destination);
        LogRecord var78B10A0217AE6F1E32B98A51D92429CB_1748749540 = (new MessageLog(message, source, destination, timeStamp,
                isSender, firstLine, tid, callId, timestampVal));
        return (LogRecord)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new MessageLog(message, source, destination, timeStamp,
                //isSender, firstLine, tid, callId, timestampVal);
    }

    
}

