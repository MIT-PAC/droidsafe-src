package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.LogRecord;
import gov.nist.javax.sip.LogRecordFactory;




public class DefaultMessageLogFactory implements LogRecordFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.199 -0400", hash_original_method = "21AC114112EFF523B2B54D53457EBCA3", hash_generated_method = "21AC114112EFF523B2B54D53457EBCA3")
    public DefaultMessageLogFactory ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.200 -0400", hash_original_method = "1FCBD43A9010493D751AC2489A6EFE82", hash_generated_method = "B79169CE394EF50EA39ADDAE71B9AE2C")
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
LogRecord var78D95E71B445F3D0B3A5C204500A3C42_1669954734 =         new MessageLog(message, source, destination, timeStamp,
                isSender, firstLine, tid, callId, tsHeaderValue);
        var78D95E71B445F3D0B3A5C204500A3C42_1669954734.addTaint(taint);
        return var78D95E71B445F3D0B3A5C204500A3C42_1669954734;
        // ---------- Original Method ----------
        //return new MessageLog(message, source, destination, timeStamp,
                //isSender, firstLine, tid, callId, tsHeaderValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:40.200 -0400", hash_original_method = "6DD4174F440258B3C35BB449B3066E66", hash_generated_method = "1C4DBF0991F60DF4DEDB055FFFB6E246")
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
LogRecord var85CE2421DBC16C4BEEA23E275AA06A8A_1523261343 =         new MessageLog(message, source, destination, timeStamp,
                isSender, firstLine, tid, callId, timestampVal);
        var85CE2421DBC16C4BEEA23E275AA06A8A_1523261343.addTaint(taint);
        return var85CE2421DBC16C4BEEA23E275AA06A8A_1523261343;
        // ---------- Original Method ----------
        //return new MessageLog(message, source, destination, timeStamp,
                //isSender, firstLine, tid, callId, timestampVal);
    }

    
}

