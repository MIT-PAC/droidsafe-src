package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.Socket;
import java.net.SocketException;

import android.content.Context;
import android.net.NetworkStats.NonMonotonicException;
import android.os.RemoteException;
import android.os.ServiceManager;

import com.android.server.NetworkManagementSocketTagger;

import dalvik.system.SocketTagger;

import droidsafe.helpers.DSUtils;

public class TrafficStats {

    /**
     * Set active tag to use when accounting {@link Socket} traffic originating
     * from the current thread. Only one active tag per thread is supported.
     * <p>
     * Changes only take effect during subsequent calls to
     * {@link #tagSocket(Socket)}.
     * <p>
     * Tags between {@code 0xFFFFFF00} and {@code 0xFFFFFFFF} are reserved and
     * used internally by system services like {@link DownloadManager} when
     * performing traffic on behalf of an application.
     */
    @DSComment("Traffic statistics")
    @DSSpec(DSCat.NETWORK_STATS)
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.258 -0500", hash_original_method = "8A6683AC46C482376EDB137406895EA4", hash_generated_method = "82DCC980DC0931619D28A669069BC53B")
    
public static void setThreadStatsTag(int tag) {
        NetworkManagementSocketTagger.setThreadSocketStatsTag(tag);
    }

    /**
     * Get the active tag used when accounting {@link Socket} traffic originating
     * from the current thread. Only one active tag per thread is supported.
     * {@link #tagSocket(Socket)}.
     */
    @DSComment("Traffic statistics")
    @DSSpec(DSCat.NETWORK_STATS)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.261 -0500", hash_original_method = "241455C0E3DABE2C90F976AA351D8F6B", hash_generated_method = "D358E2458BE1AB76C109717C0B831B41")
    
public static int getThreadStatsTag() {
        return NetworkManagementSocketTagger.getThreadSocketStatsTag();
    }

    @DSComment("Traffic statistics")
    @DSSpec(DSCat.NETWORK_STATS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.264 -0500", hash_original_method = "6E8825218B2DFD130436D4F78968BA20", hash_generated_method = "9CF251DF482A98A69EB969015F5F34D1")
    
public static void clearThreadStatsTag() {
        NetworkManagementSocketTagger.setThreadSocketStatsTag(-1);
    }

    /**
     * Set specific UID to use when accounting {@link Socket} traffic
     * originating from the current thread. Designed for use when performing an
     * operation on behalf of another application.
     * <p>
     * Changes only take effect during subsequent calls to
     * {@link #tagSocket(Socket)}.
     * <p>
     * To take effect, caller must hold
     * {@link android.Manifest.permission#UPDATE_DEVICE_STATS} permission.
     *
     * {@hide}
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.266 -0500", hash_original_method = "2465ECE023EA6F6315B38940B5A27E11", hash_generated_method = "FB4612769C2D600C361EC2D31F9241CD")
    
public static void setThreadStatsUid(int uid) {
        NetworkManagementSocketTagger.setThreadSocketStatsUid(uid);
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.268 -0500", hash_original_method = "9B50381898D777B449A29A4F0559E088", hash_generated_method = "B10C7BA9F99F7FD95D2913E937E095B1")
    
public static void clearThreadStatsUid() {
        NetworkManagementSocketTagger.setThreadSocketStatsUid(-1);
    }

    /**
     * Tag the given {@link Socket} with any statistics parameters active for
     * the current thread. Subsequent calls always replace any existing
     * parameters. When finished, call {@link #untagSocket(Socket)} to remove
     * statistics parameters.
     *
     * @see #setThreadStatsTag(int)
     * @see #setThreadStatsUid(int)
     */
    @DSComment("Traffic statistics")
    @DSSpec(DSCat.NETWORK_STATS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.270 -0500", hash_original_method = "821AB37695B594727ABEEFF11698960F", hash_generated_method = "DB98BE8A084ABCF5B145BA68E9905BB0")
    
public static void tagSocket(Socket socket) throws SocketException {
        SocketTagger.get().tag(socket);
    }

    /**
     * Remove any statistics parameters from the given {@link Socket}.
     */
    @DSComment("Traffic statistics")
    @DSSpec(DSCat.NETWORK_STATS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.273 -0500", hash_original_method = "554BE569F7BDC3C8D27CCE859115D1B1", hash_generated_method = "A68AAA62167732901D231CB17AB81680")
    
public static void untagSocket(Socket socket) throws SocketException {
        SocketTagger.get().untag(socket);
    }

    /**
     * Start profiling data usage for current UID. Only one profiling session
     * can be active at a time.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.275 -0500", hash_original_method = "2941E7D87CA3D32F9ED426806A173E79", hash_generated_method = "EB3FD27410C95C1DF24D1F0C00CA8AC6")
    
public static void startDataProfiling(Context context) {
        synchronized (sProfilingLock) {
            if (sActiveProfilingStart != null) {
                throw new IllegalStateException("already profiling data");
            }

            // take snapshot in time; we calculate delta later
            sActiveProfilingStart = getDataLayerSnapshotForUid(context);
        }
    }

    /**
     * Stop profiling data usage for current UID.
     *
     * @return Detailed {@link NetworkStats} of data that occurred since last
     *         {@link #startDataProfiling(Context)} call.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.277 -0500", hash_original_method = "3E7A0A4AB8A0BE85D7EB3547E24BD537", hash_generated_method = "F69BF5865306F676EC83FF7CD18A229E")
    
public static NetworkStats stopDataProfiling(Context context) {
        synchronized (sProfilingLock) {
            if (sActiveProfilingStart == null) {
                throw new IllegalStateException("not profiling data");
            }

            try {
                // subtract starting values and return delta
                final NetworkStats profilingStop = getDataLayerSnapshotForUid(context);
                final NetworkStats profilingDelta = profilingStop.subtract(sActiveProfilingStart);
                sActiveProfilingStart = null;
                return profilingDelta;
            } catch (NonMonotonicException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Increment count of network operations performed under the accounting tag
     * currently active on the calling thread. This can be used to derive
     * bytes-per-operation.
     *
     * @param operationCount Number of operations to increment count by.
     */
    @DSComment("Traffic statistics")
    @DSSpec(DSCat.NETWORK_STATS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.280 -0500", hash_original_method = "DBD8969F9F8A15C1B81C767022D4A852", hash_generated_method = "5221A9A6564F97816880393CB890BC0A")
    
public static void incrementOperationCount(int operationCount) {
        final int tag = getThreadStatsTag();
        incrementOperationCount(tag, operationCount);
    }

    /**
     * Increment count of network operations performed under the given
     * accounting tag. This can be used to derive bytes-per-operation.
     *
     * @param tag Accounting tag used in {@link #setThreadStatsTag(int)}.
     * @param operationCount Number of operations to increment count by.
     */
    @DSComment("Traffic statistics")
    @DSSpec(DSCat.NETWORK_STATS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.282 -0500", hash_original_method = "171C5D5D16A1A39BAF8B5EAF02935E25", hash_generated_method = "9D87F629693BDA83CCD42A680700F21C")
    
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
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getMobileTxPackets() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getMobileRxPackets() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getMobileTxBytes() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getMobileRxBytes() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getTxPackets(String iface) {
        return iface.getTaintInt();
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getRxPackets(String iface) {
        return iface.getTaintInt();
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getTxBytes(String iface) {
        return iface.getTaintInt();
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getRxBytes(String iface) {
        return iface.getTaintInt();
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getTotalTxPackets() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getTotalRxPackets() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    @DSComment("Traffic statistics")
    @DSSpec(DSCat.NETWORK_STATS)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getTotalTxBytes() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    @DSComment("Traffic statistics")
    @DSSpec(DSCat.NETWORK_STATS)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    public static long getTotalRxBytes() {
        return DSUtils.UNKNOWN_LONG;
    }
    
    @DSComment("Traffic statistics")
    @DSSpec(DSCat.NETWORK_STATS)
    public static long getUidTxBytes(int uid) {
        return uid;
    }
    
    @DSComment("Traffic statistics")
    @DSSpec(DSCat.NETWORK_STATS)
    public static long getUidRxBytes(int uid) {
        return uid;
    }
    
    public static long getUidTxPackets(int uid) {
        return uid;
    }
    
    public static long getUidRxPackets(int uid) {
        return uid;
    }
    
    public static long getUidTcpTxBytes(int uid) {
        return uid;
    }
    
    public static long getUidTcpRxBytes(int uid) {
        return uid;
    }
    
    public static long getUidUdpTxBytes(int uid) {
        return uid;
    }
    
    public static long getUidUdpRxBytes(int uid) {
        return uid;
    }
    
    public static long getUidTcpTxSegments(int uid) {
        return uid;
    }
    
    public static long getUidTcpRxSegments(int uid) {
        return uid;
    }
    
    public static long getUidUdpTxPackets(int uid) {
        return uid;
    }
    
    public static long getUidUdpRxPackets(int uid) {
        return uid;
    }

    /**
     * Return detailed {@link NetworkStats} for the current UID. Requires no
     * special permission.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.375 -0500", hash_original_method = "4800E1BB809552A3F41F215D24E3D8D6", hash_generated_method = "39A8F7F76955E0CF923C47F2D8EC1439")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.240 -0500", hash_original_field = "C15544477D456E69CC5B1C4D10553EC7", hash_generated_field = "82588A84F039BA87CFCB0C2E0F69AEDF")

    public final static int UNSUPPORTED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.243 -0500", hash_original_field = "2CD45C833F20F5CAD5DAB3B9FEDCF160", hash_generated_field = "5D1A2E1D99D4168BA62937248EBA0BBB")

    public static final int UID_REMOVED = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.245 -0500", hash_original_field = "22002541AFFA2EDC0FD539D79571D710", hash_generated_field = "89FB936B328F723630C3AAD4B9AC514B")

    public static final int UID_TETHERING = -5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.247 -0500", hash_original_field = "96BA30B91B1F13729F72FFEFCC2554F7", hash_generated_field = "C02A5C3A2945DD3A9498E9A2B3ADE3E8")

    public static final int TAG_SYSTEM_DOWNLOAD = 0xFFFFFF01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.249 -0500", hash_original_field = "899B5BE0143CE89E6ACAEACC469EEC31", hash_generated_field = "F2074CB1C4379C5B50BB4B1FF63B0820")

    public static final int TAG_SYSTEM_MEDIA = 0xFFFFFF02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.251 -0500", hash_original_field = "1B6449ED5A6102664B9B18D9B0800D3A", hash_generated_field = "F9E20E050386391004636FE05F2369DA")

    public static final int TAG_SYSTEM_BACKUP = 0xFFFFFF03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.253 -0500", hash_original_field = "5D2F33191A2E616D4B50301CB47004EA", hash_generated_field = "9EB86C19C4E01418DA01359F0C805E43")

    private static NetworkStats sActiveProfilingStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:23.256 -0500", hash_original_field = "F20A45A0061992FE154D37C68124F98C", hash_generated_field = "A1F5981D31D6D64C0FB7AA0C9780DCFC")

    private static Object sProfilingLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.336 -0400", hash_original_method = "0A5769A7A7853AFB0195EA94063CCE5B", hash_generated_method = "0A5769A7A7853AFB0195EA94063CCE5B")
    public TrafficStats ()
    {
        //Synthesized constructor
    }
}

