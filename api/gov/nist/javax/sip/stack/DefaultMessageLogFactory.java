package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.LogRecord;
import gov.nist.javax.sip.LogRecordFactory;

public class DefaultMessageLogFactory implements LogRecordFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.239 -0400", hash_original_method = "21AC114112EFF523B2B54D53457EBCA3", hash_generated_method = "21AC114112EFF523B2B54D53457EBCA3")
    public DefaultMessageLogFactory ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.240 -0400", hash_original_method = "1FCBD43A9010493D751AC2489A6EFE82", hash_generated_method = "2E78AF34CA038CA5865AF27F6C4D3E70")
    public LogRecord createLogRecord(String message, String source,
            String destination, String timeStamp, boolean isSender,
            String firstLine, String tid, String callId, long tsHeaderValue) {
        LogRecord varB4EAC82CA7396A68D541C85D26508E83_300312001 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_300312001 = new MessageLog(message, source, destination, timeStamp,
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
        varB4EAC82CA7396A68D541C85D26508E83_300312001.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_300312001;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.242 -0400", hash_original_method = "6DD4174F440258B3C35BB449B3066E66", hash_generated_method = "DFA184B31DE8EAEDFD644BAACFF58AA7")
    public LogRecord createLogRecord(String message, String source,
            String destination, long timeStamp, boolean isSender,
            String firstLine, String tid, String callId, long timestampVal) {
        LogRecord varB4EAC82CA7396A68D541C85D26508E83_544613239 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_544613239 = new MessageLog(message, source, destination, timeStamp,
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
        varB4EAC82CA7396A68D541C85D26508E83_544613239.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_544613239;
        
        
                
    }

    
}

