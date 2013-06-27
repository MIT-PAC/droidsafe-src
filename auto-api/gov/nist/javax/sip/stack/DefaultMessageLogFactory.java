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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.786 -0400", hash_original_method = "21AC114112EFF523B2B54D53457EBCA3", hash_generated_method = "21AC114112EFF523B2B54D53457EBCA3")
    public DefaultMessageLogFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.786 -0400", hash_original_method = "1FCBD43A9010493D751AC2489A6EFE82", hash_generated_method = "F43B79ED5889E806569643716F988280")
    public LogRecord createLogRecord(String message, String source,
            String destination, String timeStamp, boolean isSender,
            String firstLine, String tid, String callId, long tsHeaderValue) {
        LogRecord varB4EAC82CA7396A68D541C85D26508E83_1380877357 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1380877357 = new MessageLog(message, source, destination, timeStamp,
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
        varB4EAC82CA7396A68D541C85D26508E83_1380877357.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1380877357;
        // ---------- Original Method ----------
        //return new MessageLog(message, source, destination, timeStamp,
                //isSender, firstLine, tid, callId, tsHeaderValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.787 -0400", hash_original_method = "6DD4174F440258B3C35BB449B3066E66", hash_generated_method = "3362A16A749F167A49D6853B371656A5")
    public LogRecord createLogRecord(String message, String source,
            String destination, long timeStamp, boolean isSender,
            String firstLine, String tid, String callId, long timestampVal) {
        LogRecord varB4EAC82CA7396A68D541C85D26508E83_2081931785 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2081931785 = new MessageLog(message, source, destination, timeStamp,
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
        varB4EAC82CA7396A68D541C85D26508E83_2081931785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2081931785;
        // ---------- Original Method ----------
        //return new MessageLog(message, source, destination, timeStamp,
                //isSender, firstLine, tid, callId, timestampVal);
    }

    
}

