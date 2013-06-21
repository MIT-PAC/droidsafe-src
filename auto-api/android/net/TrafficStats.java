package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.DownloadManager;
import android.app.backup.BackupManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.NetworkStats.NonMonotonicException;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.android.server.NetworkManagementSocketTagger;
import dalvik.system.SocketTagger;
import java.net.Socket;
import java.net.SocketException;

public class TrafficStats {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.491 -0400", hash_original_method = "021142C75684DE62F5656F7234E5CF6E", hash_generated_method = "021142C75684DE62F5656F7234E5CF6E")
        public TrafficStats ()
    {
    }


        public static void setThreadStatsTag(int tag) {
        NetworkManagementSocketTagger.setThreadSocketStatsTag(tag);
    }

    
        public static int getThreadStatsTag() {
        return NetworkManagementSocketTagger.getThreadSocketStatsTag();
    }

    
        public static void clearThreadStatsTag() {
        NetworkManagementSocketTagger.setThreadSocketStatsTag(-1);
    }

    
        public static void setThreadStatsUid(int uid) {
        NetworkManagementSocketTagger.setThreadSocketStatsUid(uid);
    }

    
        public static void clearThreadStatsUid() {
        NetworkManagementSocketTagger.setThreadSocketStatsUid(-1);
    }

    
        public static void tagSocket(Socket socket) throws SocketException {
        SocketTagger.get().tag(socket);
    }

    
        public static void untagSocket(Socket socket) throws SocketException {
        SocketTagger.get().untag(socket);
    }

    
        public static void startDataProfiling(Context context) {
        synchronized (sProfilingLock) {
            if (sActiveProfilingStart != null) {
                throw new IllegalStateException("already profiling data");
            }
            sActiveProfilingStart = getDataLayerSnapshotForUid(context);
        }
    }

    
        public static NetworkStats stopDataProfiling(Context context) {
        synchronized (sProfilingLock) {
            if (sActiveProfilingStart == null) {
                throw new IllegalStateException("not profiling data");
            }
            try {
                final NetworkStats profilingStop = getDataLayerSnapshotForUid(context);
                final NetworkStats profilingDelta = profilingStop.subtract(sActiveProfilingStart);
                sActiveProfilingStart = null;
                return profilingDelta;
            } catch (NonMonotonicException e) {
                throw new RuntimeException(e);
            }
        }
    }

    
        public static void incrementOperationCount(int operationCount) {
        final int tag = getThreadStatsTag();
        incrementOperationCount(tag, operationCount);
    }

    
        public static void incrementOperationCount(int tag, int operationCount) {
        final INetworkStatsService statsService = INetworkStatsService.Stub.asInterface(
                ServiceManager.getService(Context.NETWORK_STATS_SERVICE));
        final int uid = android.os.Process.myUid();
        try {
            statsService.incrementOperationCount(uid, tag, operationCount);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    
        public static long getMobileTxPackets() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getMobileRxPackets() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getMobileTxBytes() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getMobileRxBytes() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getTxPackets(String iface) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getRxPackets(String iface) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getTxBytes(String iface) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getRxBytes(String iface) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getTotalTxPackets() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getTotalRxPackets() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getTotalTxBytes() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getTotalRxBytes() {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidTxBytes(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidRxBytes(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidTxPackets(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidRxPackets(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidTcpTxBytes(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidTcpRxBytes(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidUdpTxBytes(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidUdpRxBytes(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidTcpTxSegments(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidTcpRxSegments(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidUdpTxPackets(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long getUidUdpRxPackets(int uid) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        private static NetworkStats getDataLayerSnapshotForUid(Context context) {
        final INetworkStatsService statsService = INetworkStatsService.Stub.asInterface(
                ServiceManager.getService(Context.NETWORK_STATS_SERVICE));
        final int uid = android.os.Process.myUid();
        try {
            return statsService.getDataLayerSnapshotForUid(uid);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    
    public final static int UNSUPPORTED = -1;
    public static final int UID_REMOVED = -4;
    public static final int UID_TETHERING = -5;
    public static final int TAG_SYSTEM_DOWNLOAD = 0xFFFFFF01;
    public static final int TAG_SYSTEM_MEDIA = 0xFFFFFF02;
    public static final int TAG_SYSTEM_BACKUP = 0xFFFFFF03;
    private static NetworkStats sActiveProfilingStart;
    private static Object sProfilingLock = new Object();
}

