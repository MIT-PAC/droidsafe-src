package com.android.server;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.net.SocketException;

import android.util.Log;
import android.util.Slog;
import dalvik.system.SocketTagger;




import droidsafe.helpers.DSUtils;

public final class NetworkManagementSocketTagger extends SocketTagger {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.470 -0400", hash_original_method = "00C0D10B5E2369FA378DABF797EE6BED", hash_generated_method = "00C0D10B5E2369FA378DABF797EE6BED")
    public NetworkManagementSocketTagger ()
    {
        //Synthesized constructor
    }


    public static void install() {
        SocketTagger.set(new NetworkManagementSocketTagger());
    }

    
    public static void setThreadSocketStatsTag(int tag) {
        threadSocketTags.get().statsTag = tag;
    }

    
    public static int getThreadSocketStatsTag() {
        return threadSocketTags.get().statsTag;
    }

    
    public static void setThreadSocketStatsUid(int uid) {
        threadSocketTags.get().statsUid = uid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.472 -0400", hash_original_method = "754D4D42EA09C30B28CC17EDE05EFAAB", hash_generated_method = "C08724034E0A0749FE8AB2626DEF8EEA")
    @Override
    public void tag(FileDescriptor fd) throws SocketException {
        addTaint(fd.getTaint());
        final SocketTags options = threadSocketTags.get();
        if(LOGD)        
        {
            Log.d(TAG, "tagSocket(" + fd.getInt$() + ") with statsTag=0x"
                    + Integer.toHexString(options.statsTag) + ", statsUid=" + options.statsUid);
        } //End block
        tagSocketFd(fd, options.statsTag, options.statsUid);
        // ---------- Original Method ----------
        //final SocketTags options = threadSocketTags.get();
        //if (LOGD) {
            //Log.d(TAG, "tagSocket(" + fd.getInt$() + ") with statsTag=0x"
                    //+ Integer.toHexString(options.statsTag) + ", statsUid=" + options.statsUid);
        //}
        //tagSocketFd(fd, options.statsTag, options.statsUid);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.472 -0400", hash_original_method = "C210639DA77D00249F794C3EBD98DE8A", hash_generated_method = "2512FE3068530B772E6A317B46E23B54")
    private void tagSocketFd(FileDescriptor fd, int tag, int uid) {
        addTaint(uid);
        addTaint(tag);
        addTaint(fd.getTaint());
        int errno;
        if(tag == -1 && uid == -1)        
        return;
        errno = native_tagSocketFd(fd, tag, uid);
        if(errno < 0)        
        {
        } //End block
        // ---------- Original Method ----------
        //int errno;
        //if (tag == -1 && uid == -1) return;
        //errno = native_tagSocketFd(fd, tag, uid);
        //if (errno < 0) {
            //Log.i(TAG, "tagSocketFd(" + fd.getInt$() + ", "
                  //+ tag + ", " +
                  //+ uid + ") failed with errno" + errno);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.472 -0400", hash_original_method = "4EBF01D3564F87055EEC05DD0727DB2B", hash_generated_method = "6C17A1F20DC7B2E0F373FA154A8B8DE8")
    @Override
    public void untag(FileDescriptor fd) throws SocketException {
        addTaint(fd.getTaint());
        if(LOGD)        
        {
        } //End block
        unTagSocketFd(fd);
        // ---------- Original Method ----------
        //if (LOGD) {
            //Log.i(TAG, "untagSocket(" + fd.getInt$() + ")");
        //}
        //unTagSocketFd(fd);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.473 -0400", hash_original_method = "5654F79E328B73E29CE69FDDA4191C15", hash_generated_method = "03F20AD8F0899DAD8FEA5C3BF8FA0FCE")
    private void unTagSocketFd(FileDescriptor fd) {
        addTaint(fd.getTaint());
        final SocketTags options = threadSocketTags.get();
        int errno;
        if(options.statsTag == -1 && options.statsUid == -1)        
        return;
        errno = native_untagSocketFd(fd);
        if(errno < 0)        
        {
        } //End block
        // ---------- Original Method ----------
        //final SocketTags options = threadSocketTags.get();
        //int errno;
        //if (options.statsTag == -1 && options.statsUid == -1) return;
        //errno = native_untagSocketFd(fd);
        //if (errno < 0) {
            //Log.w(TAG, "untagSocket(" + fd.getInt$() + ") failed with errno " + errno);
        //}
    }

    
    public static void setKernelCounterSet(int uid, int counterSet) {
        int errno = native_setCounterSet(counterSet, uid);
        if (errno < 0) {
            Log.w(TAG, "setKernelCountSet(" + uid + ", " + counterSet + ") failed with errno " + errno);
        }
    }

    
    public static void resetKernelUidStats(int uid) {
        int errno = native_deleteTagData(0, uid);
        if (errno < 0) {
            Slog.w(TAG, "problem clearing counters for uid " + uid + " : errno " + errno);
        }
    }

    
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.476 -0400", hash_original_field = "43D9A321814CC19839C3B970D085CF8B", hash_generated_field = "50A065B7832C2F855A22AFE5278B6084")

        public int statsTag = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.476 -0400", hash_original_field = "AAAEF0C090C595DB37D6A71350CE5BBC", hash_generated_field = "F090CAEE4F015DE3D658DF54EB1373DA")

        public int statsUid = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.477 -0400", hash_original_method = "9733D1794190B487674895963987601C", hash_generated_method = "9733D1794190B487674895963987601C")
        public SocketTags ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.477 -0400", hash_original_field = "95528F4C91A8F59FF7FB083630FD1EEE", hash_generated_field = "20F5941A978139BFC6C872DB572C577F")

    private static final String TAG = "NetworkManagementSocketTagger";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.477 -0400", hash_original_field = "928751A5F820D0540184847C19228178", hash_generated_field = "7A4FFF4799751F839BC14FD728217C88")

    private static final boolean LOGD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.477 -0400", hash_original_field = "50D195D854324B4A6E90F599FAF53FD7", hash_generated_field = "C87E4DC0D4A7E46AAC66AA6123EEBFD8")

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

