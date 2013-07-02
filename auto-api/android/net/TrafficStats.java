package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.047 -0400", hash_original_method = "0A5769A7A7853AFB0195EA94063CCE5B", hash_generated_method = "0A5769A7A7853AFB0195EA94063CCE5B")
    public TrafficStats ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static void setThreadStatsTag(int tag) {
        NetworkManagementSocketTagger.setThreadSocketStatsTag(tag);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getThreadStatsTag() {
        return NetworkManagementSocketTagger.getThreadSocketStatsTag();
    }

    
    @DSModeled(DSC.SAFE)
    public static void clearThreadStatsTag() {
        NetworkManagementSocketTagger.setThreadSocketStatsTag(-1);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setThreadStatsUid(int uid) {
        NetworkManagementSocketTagger.setThreadSocketStatsUid(uid);
    }

    
    @DSModeled(DSC.SAFE)
    public static void clearThreadStatsUid() {
        NetworkManagementSocketTagger.setThreadSocketStatsUid(-1);
    }

    
    public static void tagSocket(Socket socket) throws SocketException {
        SocketTagger.get().tag(socket);
    }

    
    public static void untagSocket(Socket socket) throws SocketException {
        SocketTagger.get().untag(socket);
    }

    
    @DSModeled(DSC.SAFE)
    public static void startDataProfiling(Context context) {
        synchronized (sProfilingLock) {
            if (sActiveProfilingStart != null) {
                throw new IllegalStateException("already profiling data");
            }
            sActiveProfilingStart = getDataLayerSnapshotForUid(context);
        }
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static void incrementOperationCount(int operationCount) {
        final int tag = getThreadStatsTag();
        incrementOperationCount(tag, operationCount);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.052 -0400", hash_original_field = "3F655497757230114D239BA2502B6CE2", hash_generated_field = "82588A84F039BA87CFCB0C2E0F69AEDF")

    public final static int UNSUPPORTED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.052 -0400", hash_original_field = "59B29A0888D12C0AC0A2D189EA7E55E2", hash_generated_field = "5D1A2E1D99D4168BA62937248EBA0BBB")

    public static final int UID_REMOVED = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.052 -0400", hash_original_field = "EC4E0BB25CEE65B7B54C1A406B826117", hash_generated_field = "89FB936B328F723630C3AAD4B9AC514B")

    public static final int UID_TETHERING = -5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.052 -0400", hash_original_field = "5D5EC103C8574B41FF9B220A089674C9", hash_generated_field = "C02A5C3A2945DD3A9498E9A2B3ADE3E8")

    public static final int TAG_SYSTEM_DOWNLOAD = 0xFFFFFF01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.053 -0400", hash_original_field = "F8192C4A6230C85D4B220748EF35DD04", hash_generated_field = "F2074CB1C4379C5B50BB4B1FF63B0820")

    public static final int TAG_SYSTEM_MEDIA = 0xFFFFFF02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.053 -0400", hash_original_field = "BA2581B5BE2A1274F7AFF01BCF938CBE", hash_generated_field = "F9E20E050386391004636FE05F2369DA")

    public static final int TAG_SYSTEM_BACKUP = 0xFFFFFF03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.053 -0400", hash_original_field = "AD321283FE5B86D89FE96906C476EF5E", hash_generated_field = "9EB86C19C4E01418DA01359F0C805E43")

    private static NetworkStats sActiveProfilingStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.053 -0400", hash_original_field = "86EF3750A556F1AA383A4BA6C31747B4", hash_generated_field = "A1F5981D31D6D64C0FB7AA0C9780DCFC")

    private static Object sProfilingLock = new Object();
}

