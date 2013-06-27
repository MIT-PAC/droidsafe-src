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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.725 -0400", hash_original_field = "B634495A5206EAC864BE33EEF0379447", hash_generated_field = "D8DB14FD2FF72CF1AA09DD3099C7A5AC")

    byte[] mBuffer = new byte[1024];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.725 -0400", hash_original_field = "F186B07246F1198E09E61F10F37B5A17", hash_generated_field = "7929D370BBAA2A6043EF739E265C3242")

    private long mTotalSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.725 -0400", hash_original_field = "869BB521FA1BF2D70B737238BCDB46CA", hash_generated_field = "BCCA6254E80514BD4181C138C6D39F8D")

    private long mFreeSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.726 -0400", hash_original_field = "309F6866C44A3EB7FB1C2356E4701E1A", hash_generated_field = "2FCE9C963C19BA9992E163CB6895C992")

    private long mCachedSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.726 -0400", hash_original_method = "0A3FF658B31652AA0351B8E33261A030", hash_generated_method = "0A3FF658B31652AA0351B8E33261A030")
    public MemInfoReader ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.726 -0400", hash_original_method = "D9BE2698B9CEABDB1C83ECE5A41CE9EF", hash_generated_method = "DC75CD2A2EA5509F3B39F35F972738D9")
    private boolean matchText(byte[] buffer, int index, String text) {
        int N;
        N = text.length();
        {
            int i;
            i = 0;
            {
                {
                    boolean varD666446A75B53823900A4A6FFC983903_2065881749 = (buffer[index+i] != text.charAt(i));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer[0]);
        addTaint(index);
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2064906034 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2064906034;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.736 -0400", hash_original_method = "DB73154576977FA52BEDF797ABB76527", hash_generated_method = "300C66A0E8EBEE4E9BD8141D0E4A1EC7")
    private long extractMemValue(byte[] buffer, int index) {
        {
            {
                int start;
                start = index;
                String str;
                str = new String(buffer, 0, start, index-start);
                long var387EC5FC2C0639E7F95A08F66A2DB6D9_1946515556 = (((long)Integer.parseInt(str)) * 1024);
            } //End block
        } //End block
        addTaint(buffer[0]);
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1815321440 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1815321440;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.737 -0400", hash_original_method = "BB97E1D4EA3CA166050B741E23967BDC", hash_generated_method = "DFFE552764AB5E9C8F5FDADDE5D6F8AF")
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
                        boolean varECB16495266028F12021205E9D94E458_2006069916 = (matchText(mBuffer, i, "MemTotal"));
                        {
                            i += 8;
                            mTotalSize = extractMemValue(mBuffer, i);
                        } //End block
                        {
                            boolean var0B9C411E6930A2921E8F44E94088809B_1104012440 = (matchText(mBuffer, i, "MemFree"));
                            {
                                i += 7;
                                mFreeSize = extractMemValue(mBuffer, i);
                            } //End block
                            {
                                boolean var700D804177A2AFC923A91B385BA28E88_1932275652 = (matchText(mBuffer, i, "Cached"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.737 -0400", hash_original_method = "3434AB33F130B66E857E66B11D583682", hash_generated_method = "892C922E2D8D708C59CC0E0D2B90F8AE")
    public long getTotalSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1236102514 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1236102514;
        // ---------- Original Method ----------
        //return mTotalSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.738 -0400", hash_original_method = "FACB48AE3A5EF9A0F8A782DC112E6801", hash_generated_method = "EB674D364B9F3F28A93A0885AD84CD86")
    public long getFreeSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1376991794 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1376991794;
        // ---------- Original Method ----------
        //return mFreeSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.738 -0400", hash_original_method = "67C7373745CA2083B77127FB7F7EF9BE", hash_generated_method = "B842552E00A5B5752C1894BA9E17756A")
    public long getCachedSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_106201156 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_106201156;
        // ---------- Original Method ----------
        //return mCachedSize;
    }

    
}

