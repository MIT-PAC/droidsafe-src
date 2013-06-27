package android.support.v4.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.TrafficStats;
import java.net.Socket;
import java.net.SocketException;

public class TrafficStatsCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.538 -0400", hash_original_method = "5795689F79031FF3296BAAA30A9E46A5", hash_generated_method = "5795689F79031FF3296BAAA30A9E46A5")
    public TrafficStatsCompatIcs ()
    {
        //Synthesized constructor
    }


        public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    
        public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    
        public static void incrementOperationCount(int operationCount) {
        TrafficStats.incrementOperationCount(operationCount);
    }

    
        public static void incrementOperationCount(int tag, int operationCount) {
        TrafficStats.incrementOperationCount(tag, operationCount);
    }

    
        public static void setThreadStatsTag(int tag) {
        TrafficStats.setThreadStatsTag(tag);
    }

    
        public static void tagSocket(Socket socket) throws SocketException {
        TrafficStats.tagSocket(socket);
    }

    
        public static void untagSocket(Socket socket) throws SocketException {
        TrafficStats.untagSocket(socket);
    }

    
}

