package android.support.v4.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.net.TrafficStats;
import java.net.Socket;
import java.net.SocketException;

public class TrafficStatsCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.382 -0400", hash_original_method = "5795689F79031FF3296BAAA30A9E46A5", hash_generated_method = "5795689F79031FF3296BAAA30A9E46A5")
    public TrafficStatsCompatIcs ()
    {
        
    }


        @DSModeled(DSC.SAFE)
    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    
        @DSModeled(DSC.SAFE)
    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    
        @DSModeled(DSC.SAFE)
    public static void incrementOperationCount(int operationCount) {
        TrafficStats.incrementOperationCount(operationCount);
    }

    
        @DSModeled(DSC.SAFE)
    public static void incrementOperationCount(int tag, int operationCount) {
        TrafficStats.incrementOperationCount(tag, operationCount);
    }

    
        @DSModeled(DSC.SAFE)
    public static void setThreadStatsTag(int tag) {
        TrafficStats.setThreadStatsTag(tag);
    }

    
        @DSModeled(DSC.SAFE)
    public static void tagSocket(Socket socket) throws SocketException {
        TrafficStats.tagSocket(socket);
    }

    
        @DSModeled(DSC.SAFE)
    public static void untagSocket(Socket socket) throws SocketException {
        TrafficStats.untagSocket(socket);
    }

    
}

