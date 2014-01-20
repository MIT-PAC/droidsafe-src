package com.android.server;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.net.SocketException;

import android.util.Log;
import android.util.Slog;
import dalvik.system.SocketTagger;

import droidsafe.helpers.DSUtils;

public final class NetworkManagementSocketTagger extends SocketTagger {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.111 -0500", hash_original_method = "41B8F9490AD85E4C6BCBCFAFBA382BC2", hash_generated_method = "E87DD9C8F4BB7D99236F1211D4308FB8")
    
public static void install() {
        SocketTagger.set(new NetworkManagementSocketTagger());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.113 -0500", hash_original_method = "6F729B097C28993CBEFD16472D0D447A", hash_generated_method = "0F284DAFCD25113BDFDA67945132B153")
    
public static void setThreadSocketStatsTag(int tag) {
        threadSocketTags.get().statsTag = tag;
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.115 -0500", hash_original_method = "E3B9F3D38B5A7D8684CDC2CE855F9E57", hash_generated_method = "463BE219C5E8223B05731235CE2DA5A3")
    
public static int getThreadSocketStatsTag() {
        return threadSocketTags.get().statsTag;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.118 -0500", hash_original_method = "400CBBAE7C7229B0FEB831AF9C1A3531", hash_generated_method = "C855347EDEB7D4ACFBEB0F21BBCFDBA0")
    
public static void setThreadSocketStatsUid(int uid) {
        threadSocketTags.get().statsUid = uid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.138 -0500", hash_original_method = "7F537A73D6A9967B4BDEC4868F9D8D29", hash_generated_method = "7C84B7B88A83381B30E9D4EAC840D2B2")
    
public static void setKernelCounterSet(int uid, int counterSet) {
        int errno = native_setCounterSet(counterSet, uid);
        if (errno < 0) {
            Log.w(TAG, "setKernelCountSet(" + uid + ", " + counterSet + ") failed with errno " + errno);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.140 -0500", hash_original_method = "E3859F7B49D4547ECF629239DB12F6DE", hash_generated_method = "CC175BBDD3EC01451FDCFBFA492684B8")
    
public static void resetKernelUidStats(int uid) {
        int errno = native_deleteTagData(0, uid);
        if (errno < 0) {
            Slog.w(TAG, "problem clearing counters for uid " + uid + " : errno " + errno);
        }
    }

    /**
     * Convert {@code /proc/} tag format to {@link Integer}. Assumes incoming
     * format like {@code 0x7fffffff00000000}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.142 -0500", hash_original_method = "4A93978991A5F9203030C6628AD165FD", hash_generated_method = "436FE8751D9E6716F7E214A8B97B637C")
    
public static int kernelToTag(String string) {
        // TODO: migrate to direct integer instead of odd shifting
        return (int) (Long.decode(string) >> 32);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_tagSocketFd(FileDescriptor fd, int tag, int uid) {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_untagSocketFd(FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_setCounterSet(int uid, int counterSetNum) {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_deleteTagData(int tag, int uid) {
        return DSUtils.UNKNOWN_INT;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.097 -0500", hash_original_field = "61BC72D0885B6C4EA30ED1602CCC52E9", hash_generated_field = "20F5941A978139BFC6C872DB572C577F")

    private static final String TAG = "NetworkManagementSocketTagger";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.099 -0500", hash_original_field = "D4ECFFBD11965A74CC5370FCF966AD54", hash_generated_field = "7A4FFF4799751F839BC14FD728217C88")

    private static final boolean LOGD = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.103 -0500", hash_original_field = "B91AD9E8B31233CC34130EB3C7E999CB", hash_generated_field = "D4F9328CABBD6F574B23D476C7CE563E")

    // TODO: remove when always enabled, or once socket tagging silently fails.
    public static final String PROP_QTAGUID_ENABLED = "net.qtaguid_enabled";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.307 -0400", hash_original_field = "EABA550F7532129DA0224DDFD599C69B", hash_generated_field = "B660FFA0D74AD531880904FF2390B2ED")

    private static ThreadLocal<SocketTags> threadSocketTags = new ThreadLocal<SocketTags>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.307 -0400", hash_original_method = "917426AFC28735098682F2B9D9CB79DB", hash_generated_method = "4CB69161806046B457CE14C356A34E9E")
        @Override
        protected SocketTags initialValue() {
            SocketTags varB4EAC82CA7396A68D541C85D26508E83_1634980402 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1634980402 = new SocketTags();
            varB4EAC82CA7396A68D541C85D26508E83_1634980402.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1634980402;
            
        }
        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.470 -0400", hash_original_method = "00C0D10B5E2369FA378DABF797EE6BED", hash_generated_method = "00C0D10B5E2369FA378DABF797EE6BED")
    public NetworkManagementSocketTagger ()
    {
        //Synthesized constructor
    }
    
    public static class SocketTags {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.131 -0500", hash_original_field = "428DFC4B7464E02F8075B1184461884F", hash_generated_field = "50A065B7832C2F855A22AFE5278B6084")

        public int statsTag = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.134 -0500", hash_original_field = "C3667ECDCC7446894904D3FE4CB70F2B", hash_generated_field = "F090CAEE4F015DE3D658DF54EB1373DA")

        public int statsUid = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.477 -0400", hash_original_method = "9733D1794190B487674895963987601C", hash_generated_method = "9733D1794190B487674895963987601C")
        public SocketTags ()
        {
            //Synthesized constructor
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.120 -0500", hash_original_method = "754D4D42EA09C30B28CC17EDE05EFAAB", hash_generated_method = "3D2E4F712EDA27FAEEDA9B354360BFFD")
    
@Override
    public void tag(FileDescriptor fd) throws SocketException {
        final SocketTags options = threadSocketTags.get();
        if (LOGD) {
            Log.d(TAG, "tagSocket(" + fd.getInt$() + ") with statsTag=0x"
                    + Integer.toHexString(options.statsTag) + ", statsUid=" + options.statsUid);
        }
        // TODO: skip tagging when options would be no-op
        tagSocketFd(fd, options.statsTag, options.statsUid);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.123 -0500", hash_original_method = "C210639DA77D00249F794C3EBD98DE8A", hash_generated_method = "71DB2DFA15FBBD8AB4660E7136F1492B")
    
private void tagSocketFd(FileDescriptor fd, int tag, int uid) {
        int errno;
        if (tag == -1 && uid == -1) return;

        errno = native_tagSocketFd(fd, tag, uid);
        if (errno < 0) {
            Log.i(TAG, "tagSocketFd(" + fd.getInt$() + ", "
                  + tag + ", " +
                  + uid + ") failed with errno" + errno);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.125 -0500", hash_original_method = "4EBF01D3564F87055EEC05DD0727DB2B", hash_generated_method = "A487B2F5DD9225F248713821C88E5587")
    
@Override
    public void untag(FileDescriptor fd) throws SocketException {
        if (LOGD) {
            Log.i(TAG, "untagSocket(" + fd.getInt$() + ")");
        }
        unTagSocketFd(fd);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:07.128 -0500", hash_original_method = "5654F79E328B73E29CE69FDDA4191C15", hash_generated_method = "F22BD5C4A1110D48875F78BE41ACD95F")
    
private void unTagSocketFd(FileDescriptor fd) {
        final SocketTags options = threadSocketTags.get();
        int errno;
        if (options.statsTag == -1 && options.statsUid == -1) return;

        errno = native_untagSocketFd(fd);
        if (errno < 0) {
            Log.w(TAG, "untagSocket(" + fd.getInt$() + ") failed with errno " + errno);
        }
    }
}

