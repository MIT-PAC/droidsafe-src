package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.LogRecord;
import gov.nist.javax.sip.LogRecordFactory;

public class DefaultMessageLogFactory implements LogRecordFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.375 -0400", hash_original_method = "21AC114112EFF523B2B54D53457EBCA3", hash_generated_method = "21AC114112EFF523B2B54D53457EBCA3")
    public DefaultMessageLogFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.377 -0400", hash_original_method = "1FCBD43A9010493D751AC2489A6EFE82", hash_generated_method = "F7ED9852DF235BFFFF83153057F034F2")
    public LogRecord createLogRecord(String message, String source,
            String destination, String timeStamp, boolean isSender,
            String firstLine, String tid, String callId, long tsHeaderValue) {
        addTaint(tsHeaderValue);
        addTaint(callId.getTaint());
        addTaint(tid.getTaint());
        addTaint(firstLine.getTaint());
        addTaint(isSender);
        addTaint(timeStamp.getTaint());
        addTaint(destination.getTaint());
        addTaint(source.getTaint());
        addTaint(message.getTaint());
LogRecord var78D95E71B445F3D0B3A5C204500A3C42_677581852 =         new MessageLog(message, source, destination, timeStamp,
                isSender, firstLine, tid, callId, tsHeaderValue);
        var78D95E71B445F3D0B3A5C204500A3C42_677581852.addTaint(taint);
        return var78D95E71B445F3D0B3A5C204500A3C42_677581852;
        // ---------- Original Method ----------
        //return new MessageLog(message, source, destination, timeStamp,
                //isSender, firstLine, tid, callId, tsHeaderValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:43.377 -0400", hash_original_method = "6DD4174F440258B3C35BB449B3066E66", hash_generated_method = "43B8F40FF1679D2D429CE51A1B9BA535")
    public LogRecord createLogRecord(String message, String source,
            String destination, long timeStamp, boolean isSender,
            String firstLine, String tid, String callId, long timestampVal) {
        addTaint(timestampVal);
        addTaint(callId.getTaint());
        addTaint(tid.getTaint());
        addTaint(firstLine.getTaint());
        addTaint(isSender);
        addTaint(timeStamp);
        addTaint(destination.getTaint());
        addTaint(source.getTaint());
        addTaint(message.getTaint());
LogRecord var85CE2421DBC16C4BEEA23E275AA06A8A_706947927 =         new MessageLog(message, source, destination, timeStamp,
                isSender, firstLine, tid, callId, timestampVal);
        var85CE2421DBC16C4BEEA23E275AA06A8A_706947927.addTaint(taint);
        return var85CE2421DBC16C4BEEA23E275AA06A8A_706947927;
        // ---------- Original Method ----------
        //return new MessageLog(message, source, destination, timeStamp,
                //isSender, firstLine, tid, callId, timestampVal);
    }

    
}

