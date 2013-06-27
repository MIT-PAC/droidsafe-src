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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.868 -0400", hash_original_method = "21AC114112EFF523B2B54D53457EBCA3", hash_generated_method = "21AC114112EFF523B2B54D53457EBCA3")
    public DefaultMessageLogFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.869 -0400", hash_original_method = "1FCBD43A9010493D751AC2489A6EFE82", hash_generated_method = "ABCC8C2DFD5F8ED50449F58BD9F433C9")
    public LogRecord createLogRecord(String message, String source,
            String destination, String timeStamp, boolean isSender,
            String firstLine, String tid, String callId, long tsHeaderValue) {
        LogRecord varB4EAC82CA7396A68D541C85D26508E83_1108186214 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1108186214 = new MessageLog(message, source, destination, timeStamp,
                isSender, firstLine, tid, callId, tsHeaderValue);
        addTaint(message.getTaint());
        addTaint(source.getTaint());
        addTaint(destination.getTaint());
        addTaint(timeStamp.getTaint());
        addTaint(isSender);
        addTaint(firstLine.getTaint());
        addTaint(tid.getTaint());
        addTaint(callId.getTaint());
        addTaint(tsHeaderValue);
        varB4EAC82CA7396A68D541C85D26508E83_1108186214.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1108186214;
        // ---------- Original Method ----------
        //return new MessageLog(message, source, destination, timeStamp,
                //isSender, firstLine, tid, callId, tsHeaderValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:35.870 -0400", hash_original_method = "6DD4174F440258B3C35BB449B3066E66", hash_generated_method = "9854CB03B2388D4A5EF8B0072D2AC2F6")
    public LogRecord createLogRecord(String message, String source,
            String destination, long timeStamp, boolean isSender,
            String firstLine, String tid, String callId, long timestampVal) {
        LogRecord varB4EAC82CA7396A68D541C85D26508E83_1722759277 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1722759277 = new MessageLog(message, source, destination, timeStamp,
                isSender, firstLine, tid, callId, timestampVal);
        addTaint(message.getTaint());
        addTaint(source.getTaint());
        addTaint(destination.getTaint());
        addTaint(timeStamp);
        addTaint(isSender);
        addTaint(firstLine.getTaint());
        addTaint(tid.getTaint());
        addTaint(callId.getTaint());
        addTaint(timestampVal);
        varB4EAC82CA7396A68D541C85D26508E83_1722759277.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1722759277;
        // ---------- Original Method ----------
        //return new MessageLog(message, source, destination, timeStamp,
                //isSender, firstLine, tid, callId, timestampVal);
    }

    
}

