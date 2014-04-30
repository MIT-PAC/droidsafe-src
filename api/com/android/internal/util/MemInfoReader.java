package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileInputStream;

import android.os.StrictMode;

public class MemInfoReader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:45.237 -0500", hash_original_field = "D8DB14FD2FF72CF1AA09DD3099C7A5AC", hash_generated_field = "D8DB14FD2FF72CF1AA09DD3099C7A5AC")

    byte[] mBuffer = new byte[1024];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:45.239 -0500", hash_original_field = "6D00962622134601C809BF42998E8D12", hash_generated_field = "7929D370BBAA2A6043EF739E265C3242")

    private long mTotalSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:45.242 -0500", hash_original_field = "1AAFE5F5E1A8763ED987466D6531C05E", hash_generated_field = "BCCA6254E80514BD4181C138C6D39F8D")

    private long mFreeSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:45.244 -0500", hash_original_field = "73E4FAE08BAE013F3963E3268557FE31", hash_generated_field = "2FCE9C963C19BA9992E163CB6895C992")

    private long mCachedSize;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.772 -0400", hash_original_method = "0A3FF658B31652AA0351B8E33261A030", hash_generated_method = "0A3FF658B31652AA0351B8E33261A030")
    public MemInfoReader ()
    {
        //Synthesized constructor
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:45.246 -0500", hash_original_method = "D9BE2698B9CEABDB1C83ECE5A41CE9EF", hash_generated_method = "ECDA8EE868F3228CAAF2451D7A1A2B99")
    
private boolean matchText(byte[] buffer, int index, String text) {
        int N = text.length();
        if ((index+N) >= buffer.length) {
            return false;
        }
        for (int i=0; i<N; i++) {
            if (buffer[index+i] != text.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:45.249 -0500", hash_original_method = "DB73154576977FA52BEDF797ABB76527", hash_generated_method = "EEEBF45D062C00900A093C5FF4CB0C11")
    
private long extractMemValue(byte[] buffer, int index) {
        while (index < buffer.length && buffer[index] != '\n') {
            if (buffer[index] >= '0' && buffer[index] <= '9') {
                int start = index;
                index++;
                while (index < buffer.length && buffer[index] >= '0'
                    && buffer[index] <= '9') {
                    index++;
                }
                String str = new String(buffer, 0, start, index-start);
                return ((long)Integer.parseInt(str)) * 1024;
            }
            index++;
        }
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:45.251 -0500", hash_original_method = "BB97E1D4EA3CA166050B741E23967BDC", hash_generated_method = "A10F79202FF74EA72DA2492BD6C96241")
    
public void readMemInfo() {
        // Permit disk reads here, as /proc/meminfo isn't really "on
        // disk" and should be fast.  TODO: make BlockGuard ignore
        // /proc/ and /sys/ files perhaps?
        StrictMode.ThreadPolicy savedPolicy = StrictMode.allowThreadDiskReads();
        try {
            mTotalSize = 0;
            mFreeSize = 0;
            mCachedSize = 0;
            FileInputStream is = new FileInputStream("/proc/meminfo");
            int len = is.read(mBuffer);
            is.close();
            final int BUFLEN = mBuffer.length;
            int count = 0;
            for (int i=0; i<len && count < 3; i++) {
                if (matchText(mBuffer, i, "MemTotal")) {
                    i += 8;
                    mTotalSize = extractMemValue(mBuffer, i);
                    count++;
                } else if (matchText(mBuffer, i, "MemFree")) {
                    i += 7;
                    mFreeSize = extractMemValue(mBuffer, i);
                    count++;
                } else if (matchText(mBuffer, i, "Cached")) {
                    i += 6;
                    mCachedSize = extractMemValue(mBuffer, i);
                    count++;
                }
                while (i < BUFLEN && mBuffer[i] != '\n') {
                    i++;
                }
            }
        } catch (java.io.FileNotFoundException e) {
        } catch (java.io.IOException e) {
        } finally {
            StrictMode.setThreadPolicy(savedPolicy);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:45.253 -0500", hash_original_method = "3434AB33F130B66E857E66B11D583682", hash_generated_method = "9B29D867E46F40BDB379803D4131A9AA")
    
public long getTotalSize() {
        return mTotalSize;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:45.255 -0500", hash_original_method = "FACB48AE3A5EF9A0F8A782DC112E6801", hash_generated_method = "468BB80E6307F748437203E2B7FEE575")
    
public long getFreeSize() {
        return mFreeSize;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:45.257 -0500", hash_original_method = "67C7373745CA2083B77127FB7F7EF9BE", hash_generated_method = "F4400F45D0DD65E2B797051FE78FA6D2")
    
public long getCachedSize() {
        return mCachedSize;
    }
    
}

