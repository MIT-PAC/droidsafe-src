package com.android.server;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = "NetworkManagementSocketTagger";
    private static final boolean LOGD = false;
    public static final String PROP_QTAGUID_ENABLED = "net.qtaguid_enabled";
    private static ThreadLocal<SocketTags> threadSocketTags = new ThreadLocal<SocketTags>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.313 -0400", hash_original_method = "917426AFC28735098682F2B9D9CB79DB", hash_generated_method = "5CC46F27ED7FA65C8E0CD652527D625F")
        @DSModeled(DSC.SAFE)
        @Override
        protected SocketTags initialValue() {
            return (SocketTags)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SocketTags();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.313 -0400", hash_original_method = "41B8F9490AD85E4C6BCBCFAFBA382BC2", hash_generated_method = "E87DD9C8F4BB7D99236F1211D4308FB8")
    public static void install() {
        SocketTagger.set(new NetworkManagementSocketTagger());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.313 -0400", hash_original_method = "6F729B097C28993CBEFD16472D0D447A", hash_generated_method = "0F284DAFCD25113BDFDA67945132B153")
    public static void setThreadSocketStatsTag(int tag) {
        threadSocketTags.get().statsTag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.313 -0400", hash_original_method = "E3B9F3D38B5A7D8684CDC2CE855F9E57", hash_generated_method = "463BE219C5E8223B05731235CE2DA5A3")
    public static int getThreadSocketStatsTag() {
        return threadSocketTags.get().statsTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.313 -0400", hash_original_method = "400CBBAE7C7229B0FEB831AF9C1A3531", hash_generated_method = "C855347EDEB7D4ACFBEB0F21BBCFDBA0")
    public static void setThreadSocketStatsUid(int uid) {
        threadSocketTags.get().statsUid = uid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.313 -0400", hash_original_method = "754D4D42EA09C30B28CC17EDE05EFAAB", hash_generated_method = "E0D3169F671377DFA7FD93E7AE4F64DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void tag(FileDescriptor fd) throws SocketException {
        dsTaint.addTaint(fd.dsTaint);
        final SocketTags options;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.313 -0400", hash_original_method = "C210639DA77D00249F794C3EBD98DE8A", hash_generated_method = "3794890E0C66FF5497EF5A85E6BBF279")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.314 -0400", hash_original_method = "4EBF01D3564F87055EEC05DD0727DB2B", hash_generated_method = "CADBE75E574AF6B91F768DC4486972AE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.314 -0400", hash_original_method = "5654F79E328B73E29CE69FDDA4191C15", hash_generated_method = "051209543BB2348C9680EC1111B02743")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void unTagSocketFd(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        final SocketTags options;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.314 -0400", hash_original_method = "7F537A73D6A9967B4BDEC4868F9D8D29", hash_generated_method = "7C84B7B88A83381B30E9D4EAC840D2B2")
    public static void setKernelCounterSet(int uid, int counterSet) {
        int errno = native_setCounterSet(counterSet, uid);
        if (errno < 0) {
            Log.w(TAG, "setKernelCountSet(" + uid + ", " + counterSet + ") failed with errno " + errno);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.314 -0400", hash_original_method = "E3859F7B49D4547ECF629239DB12F6DE", hash_generated_method = "CC175BBDD3EC01451FDCFBFA492684B8")
    public static void resetKernelUidStats(int uid) {
        int errno = native_deleteTagData(0, uid);
        if (errno < 0) {
            Slog.w(TAG, "problem clearing counters for uid " + uid + " : errno " + errno);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.314 -0400", hash_original_method = "4A93978991A5F9203030C6628AD165FD", hash_generated_method = "E7FC1C5197C28AC3654204B223049FB9")
    public static int kernelToTag(String string) {
        return (int) (Long.decode(string) >> 32);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.314 -0400", hash_original_method = "081EC21A5C31E063CD56E646088D6467", hash_generated_method = "105915814CA864815182E32A81409904")
    private static int native_tagSocketFd(FileDescriptor fd, int tag, int uid) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.314 -0400", hash_original_method = "5BC89F749770F7F386FC81C963596BF9", hash_generated_method = "777C341997BFD8533EE17FC4B69C7623")
    private static int native_untagSocketFd(FileDescriptor fd) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.314 -0400", hash_original_method = "38289C81A6B0B9E0BF52B02CDEBB18A1", hash_generated_method = "DAF94EF72D9F8C3E4DE2DCAA7848B302")
    private static int native_setCounterSet(int uid, int counterSetNum) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.314 -0400", hash_original_method = "1C1FDE365B068FC5A45F49C053096C6C", hash_generated_method = "49B5D8BA598FDD4D0FEAA0372A0F5474")
    private static int native_deleteTagData(int tag, int uid) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    public static class SocketTags {
        public int statsTag = -1;
        public int statsUid = -1;
        
    }


    
}


