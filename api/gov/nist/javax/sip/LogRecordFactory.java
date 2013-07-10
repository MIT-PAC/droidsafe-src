package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface LogRecordFactory {

    


    public LogRecord createLogRecord(String message, String source,
            String destination, long timeStamp, boolean isSender,
            String firstLine, String tid, String callId, long timestampVal);

}
