package com.android.internal.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileInputStream;

import android.os.StrictMode;





public class MemInfoReader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.772 -0400", hash_original_field = "B634495A5206EAC864BE33EEF0379447", hash_generated_field = "D8DB14FD2FF72CF1AA09DD3099C7A5AC")

    byte[] mBuffer = new byte[1024];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.772 -0400", hash_original_field = "F186B07246F1198E09E61F10F37B5A17", hash_generated_field = "7929D370BBAA2A6043EF739E265C3242")

    private long mTotalSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.772 -0400", hash_original_field = "869BB521FA1BF2D70B737238BCDB46CA", hash_generated_field = "BCCA6254E80514BD4181C138C6D39F8D")

    private long mFreeSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.772 -0400", hash_original_field = "309F6866C44A3EB7FB1C2356E4701E1A", hash_generated_field = "2FCE9C963C19BA9992E163CB6895C992")

    private long mCachedSize;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.772 -0400", hash_original_method = "0A3FF658B31652AA0351B8E33261A030", hash_generated_method = "0A3FF658B31652AA0351B8E33261A030")
    public MemInfoReader ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.773 -0400", hash_original_method = "D9BE2698B9CEABDB1C83ECE5A41CE9EF", hash_generated_method = "0BB0FCB6779637691B1140B80A429195")
    private boolean matchText(byte[] buffer, int index, String text) {
        addTaint(text.getTaint());
        addTaint(index);
        addTaint(buffer[0]);
        int N = text.length();
        if((index+N) >= buffer.length)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1753270508 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1818745895 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1818745895;
        } //End block
for(int i=0;i<N;i++)
        {
            if(buffer[index+i] != text.charAt(i))            
            {
                boolean var68934A3E9455FA72420237EB05902327_640919460 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_697090246 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_697090246;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1249549575 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423745767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423745767;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.774 -0400", hash_original_method = "DB73154576977FA52BEDF797ABB76527", hash_generated_method = "91B2174C5202C73DE9FE7113894940F9")
    private long extractMemValue(byte[] buffer, int index) {
        addTaint(index);
        addTaint(buffer[0]);
        while
(index < buffer.length && buffer[index] != '\n')        
        {
            if(buffer[index] >= '0' && buffer[index] <= '9')            
            {
                int start = index;
                index++;
                while
(index < buffer.length && buffer[index] >= '0'
                    && buffer[index] <= '9')                
                {
                    index++;
                } //End block
                String str = new String(buffer, 0, start, index-start);
                long var757A25024648D172453F1B679709E510_746692285 = (((long)Integer.parseInt(str)) * 1024);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_715714550 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_715714550;
            } //End block
            index++;
        } //End block
        long varCFCD208495D565EF66E7DFF9F98764DA_1467972591 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1405536768 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1405536768;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.776 -0400", hash_original_method = "BB97E1D4EA3CA166050B741E23967BDC", hash_generated_method = "3040392CA1B36669D733A25588ECADCD")
    public void readMemInfo() {
        StrictMode.ThreadPolicy savedPolicy = StrictMode.allowThreadDiskReads();
        try 
        {
            mTotalSize = 0;
            mFreeSize = 0;
            mCachedSize = 0;
            FileInputStream is = new FileInputStream("/proc/meminfo");
            int len = is.read(mBuffer);
            is.close();
            final int BUFLEN = mBuffer.length;
            int count = 0;
for(int i=0;i<len && count < 3;i++)
            {
                if(matchText(mBuffer, i, "MemTotal"))                
                {
                    i += 8;
                    mTotalSize = extractMemValue(mBuffer, i);
                    count++;
                } //End block
                else
                if(matchText(mBuffer, i, "MemFree"))                
                {
                    i += 7;
                    mFreeSize = extractMemValue(mBuffer, i);
                    count++;
                } //End block
                else
                if(matchText(mBuffer, i, "Cached"))                
                {
                    i += 6;
                    mCachedSize = extractMemValue(mBuffer, i);
                    count++;
                } //End block
                while
(i < BUFLEN && mBuffer[i] != '\n')                
                {
                    i++;
                } //End block
            } //End block
        } //End block
        catch (java.io.FileNotFoundException e)
        {
        } //End block
        catch (java.io.IOException e)
        {
        } //End block
        finally 
        {
            StrictMode.setThreadPolicy(savedPolicy);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.777 -0400", hash_original_method = "3434AB33F130B66E857E66B11D583682", hash_generated_method = "97CDBF730018BE8AD6D9F8C97DB81F14")
    public long getTotalSize() {
        long varF186B07246F1198E09E61F10F37B5A17_295134687 = (mTotalSize);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_750464268 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_750464268;
        // ---------- Original Method ----------
        //return mTotalSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.777 -0400", hash_original_method = "FACB48AE3A5EF9A0F8A782DC112E6801", hash_generated_method = "99706627A2407E54DE406E4A65C9033B")
    public long getFreeSize() {
        long var869BB521FA1BF2D70B737238BCDB46CA_1318754073 = (mFreeSize);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1173514966 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1173514966;
        // ---------- Original Method ----------
        //return mFreeSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.777 -0400", hash_original_method = "67C7373745CA2083B77127FB7F7EF9BE", hash_generated_method = "1D558A7CE572F31B0BBED4B8550AE058")
    public long getCachedSize() {
        long var309F6866C44A3EB7FB1C2356E4701E1A_2042228894 = (mCachedSize);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1099429685 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1099429685;
        // ---------- Original Method ----------
        //return mCachedSize;
    }

    
}

