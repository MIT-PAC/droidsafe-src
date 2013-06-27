package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileInputStream;
import android.os.StrictMode;

public class MemInfoReader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.407 -0400", hash_original_field = "B634495A5206EAC864BE33EEF0379447", hash_generated_field = "D8DB14FD2FF72CF1AA09DD3099C7A5AC")

    byte[] mBuffer = new byte[1024];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.407 -0400", hash_original_field = "F186B07246F1198E09E61F10F37B5A17", hash_generated_field = "7929D370BBAA2A6043EF739E265C3242")

    private long mTotalSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.407 -0400", hash_original_field = "869BB521FA1BF2D70B737238BCDB46CA", hash_generated_field = "BCCA6254E80514BD4181C138C6D39F8D")

    private long mFreeSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.407 -0400", hash_original_field = "309F6866C44A3EB7FB1C2356E4701E1A", hash_generated_field = "2FCE9C963C19BA9992E163CB6895C992")

    private long mCachedSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.407 -0400", hash_original_method = "0A3FF658B31652AA0351B8E33261A030", hash_generated_method = "0A3FF658B31652AA0351B8E33261A030")
    public MemInfoReader ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.408 -0400", hash_original_method = "D9BE2698B9CEABDB1C83ECE5A41CE9EF", hash_generated_method = "CFE5E95D7559305F6BC07ADA2495CC9D")
    private boolean matchText(byte[] buffer, int index, String text) {
        int N;
        N = text.length();
        {
            int i;
            i = 0;
            {
                {
                    boolean varD666446A75B53823900A4A6FFC983903_506622523 = (buffer[index+i] != text.charAt(i));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer[0]);
        addTaint(index);
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476040574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_476040574;
        // ---------- Original Method ----------
        //int N = text.length();
        //if ((index+N) >= buffer.length) {
            //return false;
        //}
        //for (int i=0; i<N; i++) {
            //if (buffer[index+i] != text.charAt(i)) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.425 -0400", hash_original_method = "DB73154576977FA52BEDF797ABB76527", hash_generated_method = "21E47EDF74FE116DD61D736E3838EB4B")
    private long extractMemValue(byte[] buffer, int index) {
        {
            {
                int start;
                start = index;
                String str;
                str = new String(buffer, 0, start, index-start);
                long var387EC5FC2C0639E7F95A08F66A2DB6D9_1714933194 = (((long)Integer.parseInt(str)) * 1024);
            } //End block
        } //End block
        addTaint(buffer[0]);
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1065480855 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1065480855;
        // ---------- Original Method ----------
        //while (index < buffer.length && buffer[index] != '\n') {
            //if (buffer[index] >= '0' && buffer[index] <= '9') {
                //int start = index;
                //index++;
                //while (index < buffer.length && buffer[index] >= '0'
                    //&& buffer[index] <= '9') {
                    //index++;
                //}
                //String str = new String(buffer, 0, start, index-start);
                //return ((long)Integer.parseInt(str)) * 1024;
            //}
            //index++;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.426 -0400", hash_original_method = "BB97E1D4EA3CA166050B741E23967BDC", hash_generated_method = "93214915C190D1E38C00A4EA00F62B22")
    public void readMemInfo() {
        StrictMode.ThreadPolicy savedPolicy;
        savedPolicy = StrictMode.allowThreadDiskReads();
        try 
        {
            mTotalSize = 0;
            mFreeSize = 0;
            mCachedSize = 0;
            FileInputStream is;
            is = new FileInputStream("/proc/meminfo");
            int len;
            len = is.read(mBuffer);
            is.close();
            int BUFLEN;
            BUFLEN = mBuffer.length;
            int count;
            count = 0;
            {
                int i;
                i = 0;
                {
                    {
                        boolean varECB16495266028F12021205E9D94E458_1167155468 = (matchText(mBuffer, i, "MemTotal"));
                        {
                            i += 8;
                            mTotalSize = extractMemValue(mBuffer, i);
                        } //End block
                        {
                            boolean var0B9C411E6930A2921E8F44E94088809B_1974911381 = (matchText(mBuffer, i, "MemFree"));
                            {
                                i += 7;
                                mFreeSize = extractMemValue(mBuffer, i);
                            } //End block
                            {
                                boolean var700D804177A2AFC923A91B385BA28E88_2069378082 = (matchText(mBuffer, i, "Cached"));
                                {
                                    i += 6;
                                    mCachedSize = extractMemValue(mBuffer, i);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (java.io.FileNotFoundException e)
        { }
        catch (java.io.IOException e)
        { }
        finally 
        {
            StrictMode.setThreadPolicy(savedPolicy);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.427 -0400", hash_original_method = "3434AB33F130B66E857E66B11D583682", hash_generated_method = "1DD34926EFD98810A0BC6BCC998BAA33")
    public long getTotalSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_485865078 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_485865078;
        // ---------- Original Method ----------
        //return mTotalSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.427 -0400", hash_original_method = "FACB48AE3A5EF9A0F8A782DC112E6801", hash_generated_method = "36053BA4B3D9AAB2FA305732C240A608")
    public long getFreeSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_708231202 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_708231202;
        // ---------- Original Method ----------
        //return mFreeSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.427 -0400", hash_original_method = "67C7373745CA2083B77127FB7F7EF9BE", hash_generated_method = "186478C613F88271529AC6453F4A9DA4")
    public long getCachedSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_90189411 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_90189411;
        // ---------- Original Method ----------
        //return mCachedSize;
    }

    
}

