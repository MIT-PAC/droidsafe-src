package com.android.server;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.net.NetworkStats;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import dalvik.system.SocketTagger;
import libcore.io.IoUtils;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.SocketException;
import java.nio.charset.Charsets;

public final class NetworkManagementSocketTagger extends SocketTagger {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.300 -0400", hash_original_method = "00C0D10B5E2369FA378DABF797EE6BED", hash_generated_method = "00C0D10B5E2369FA378DABF797EE6BED")
    public NetworkManagementSocketTagger ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static void install() {
        SocketTagger.set(new NetworkManagementSocketTagger());
    }

    
    @DSModeled(DSC.SAFE)
    public static void setThreadSocketStatsTag(int tag) {
        threadSocketTags.get().statsTag = tag;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getThreadSocketStatsTag() {
        return threadSocketTags.get().statsTag;
    }

    
    @DSModeled(DSC.SAFE)
    public static void setThreadSocketStatsUid(int uid) {
        threadSocketTags.get().statsUid = uid;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.301 -0400", hash_original_method = "754D4D42EA09C30B28CC17EDE05EFAAB", hash_generated_method = "2DD49FF42F056F78C495E9E600C6AE44")
    @Override
    public void tag(FileDescriptor fd) throws SocketException {
        final SocketTags options = threadSocketTags.get();
        {
            Log.d(TAG, "tagSocket(" + fd.getInt$() + ") with statsTag=0x"
                    + Integer.toHexString(options.statsTag) + ", statsUid=" + options.statsUid);
        } 
        tagSocketFd(fd, options.statsTag, options.statsUid);
        addTaint(fd.getTaint());
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.301 -0400", hash_original_method = "C210639DA77D00249F794C3EBD98DE8A", hash_generated_method = "2493A7287DC3768C6CB6D3F8E3BF7BDA")
    private void tagSocketFd(FileDescriptor fd, int tag, int uid) {
        int errno;
        errno = native_tagSocketFd(fd, tag, uid);
        addTaint(fd.getTaint());
        addTaint(tag);
        addTaint(uid);
        
        
        
        
        
            
                  
                  
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.302 -0400", hash_original_method = "4EBF01D3564F87055EEC05DD0727DB2B", hash_generated_method = "F6DD27AB3D8D558851532DA1FA12394E")
    @Override
    public void untag(FileDescriptor fd) throws SocketException {
        unTagSocketFd(fd);
        addTaint(fd.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.302 -0400", hash_original_method = "5654F79E328B73E29CE69FDDA4191C15", hash_generated_method = "0A9B46BF3B38052B3CCCB9A28A5C1F96")
    private void unTagSocketFd(FileDescriptor fd) {
        final SocketTags options = threadSocketTags.get();
        int errno;
        errno = native_untagSocketFd(fd);
        addTaint(fd.getTaint());
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void setKernelCounterSet(int uid, int counterSet) {
        int errno = native_setCounterSet(counterSet, uid);
        if (errno < 0) {
            Log.w(TAG, "setKernelCountSet(" + uid + ", " + counterSet + ") failed with errno " + errno);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetKernelUidStats(int uid) {
        int errno = native_deleteTagData(0, uid);
        if (errno < 0) {
            Slog.w(TAG, "problem clearing counters for uid " + uid + " : errno " + errno);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static int kernelToTag(String string) {
        return (int) (Long.decode(string) >> 32);
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_tagSocketFd(FileDescriptor fd, int tag, int uid) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_untagSocketFd(FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_setCounterSet(int uid, int counterSetNum) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int native_deleteTagData(int tag, int uid) {
        return DSUtils.UNKNOWN_INT;
    }

    
    public static class SocketTags {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.304 -0400", hash_original_field = "43D9A321814CC19839C3B970D085CF8B", hash_generated_field = "50A065B7832C2F855A22AFE5278B6084")

        public int statsTag = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.304 -0400", hash_original_field = "AAAEF0C090C595DB37D6A71350CE5BBC", hash_generated_field = "F090CAEE4F015DE3D658DF54EB1373DA")

        public int statsUid = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.304 -0400", hash_original_method = "9733D1794190B487674895963987601C", hash_generated_method = "9733D1794190B487674895963987601C")
        public SocketTags ()
        {
            
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.304 -0400", hash_original_field = "95528F4C91A8F59FF7FB083630FD1EEE", hash_generated_field = "20F5941A978139BFC6C872DB572C577F")

    private static final String TAG = "NetworkManagementSocketTagger";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.304 -0400", hash_original_field = "928751A5F820D0540184847C19228178", hash_generated_field = "7A4FFF4799751F839BC14FD728217C88")

    private static final boolean LOGD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.304 -0400", hash_original_field = "50D195D854324B4A6E90F599FAF53FD7", hash_generated_field = "C87E4DC0D4A7E46AAC66AA6123EEBFD8")

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
}

