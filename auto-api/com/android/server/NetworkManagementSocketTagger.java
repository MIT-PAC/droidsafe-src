package com.android.server;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.130 -0400", hash_original_method = "6C9C846B54FD1EC4CDA2F41972B3A196", hash_generated_method = "6C9C846B54FD1EC4CDA2F41972B3A196")
        public NetworkManagementSocketTagger ()
    {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.131 -0400", hash_original_method = "754D4D42EA09C30B28CC17EDE05EFAAB", hash_generated_method = "250DAEF774290C99C536C063B4C95407")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void tag(FileDescriptor fd) throws SocketException {
        dsTaint.addTaint(fd.dsTaint);
        SocketTags options;
        options = threadSocketTags.get();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.131 -0400", hash_original_method = "C210639DA77D00249F794C3EBD98DE8A", hash_generated_method = "D3A2E297DD22695E46142C6F775000BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void tagSocketFd(FileDescriptor fd, int tag, int uid) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(fd.dsTaint);
        int errno;
        errno = native_tagSocketFd(fd, tag, uid);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.131 -0400", hash_original_method = "4EBF01D3564F87055EEC05DD0727DB2B", hash_generated_method = "346DEF51D6EEB2E56B8CCEEFFA95EA82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void untag(FileDescriptor fd) throws SocketException {
        dsTaint.addTaint(fd.dsTaint);
        unTagSocketFd(fd);
        // ---------- Original Method ----------
        //if (LOGD) {
            //Log.i(TAG, "untagSocket(" + fd.getInt$() + ")");
        //}
        //unTagSocketFd(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.131 -0400", hash_original_method = "5654F79E328B73E29CE69FDDA4191C15", hash_generated_method = "E035FAD6DFECF77B9AD695C6E98DE7BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void unTagSocketFd(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        SocketTags options;
        options = threadSocketTags.get();
        int errno;
        errno = native_untagSocketFd(fd);
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

    
        private static int native_tagSocketFd(FileDescriptor fd, int tag, int uid) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_untagSocketFd(FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_setCounterSet(int uid, int counterSetNum) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int native_deleteTagData(int tag, int uid) {
        return DSUtils.UNKNOWN_INT;
    }

    
    public static class SocketTags {
        public int statsTag = -1;
        public int statsUid = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.132 -0400", hash_original_method = "3F1576C8D61BED4A252BACDBB9C480D1", hash_generated_method = "3F1576C8D61BED4A252BACDBB9C480D1")
                public SocketTags ()
        {
        }


    }


    
    private static final String TAG = "NetworkManagementSocketTagger";
    private static final boolean LOGD = false;
    public static final String PROP_QTAGUID_ENABLED = "net.qtaguid_enabled";
    private static ThreadLocal<SocketTags> threadSocketTags = new ThreadLocal<SocketTags>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.132 -0400", hash_original_method = "917426AFC28735098682F2B9D9CB79DB", hash_generated_method = "1E8E843FA45E2D80B6F474D6EB2E6199")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected SocketTags initialValue() {
            SocketTags var35B111C98BC9BC35BCAAEA13C3DE056D_543972403 = (new SocketTags());
            return (SocketTags)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SocketTags();
        }

        
}; //Transformed anonymous class
}

