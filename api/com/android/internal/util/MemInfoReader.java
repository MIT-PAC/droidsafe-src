package com.android.internal.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileInputStream;
import android.os.StrictMode;

public class MemInfoReader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.752 -0400", hash_original_field = "B634495A5206EAC864BE33EEF0379447", hash_generated_field = "D8DB14FD2FF72CF1AA09DD3099C7A5AC")

    byte[] mBuffer = new byte[1024];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.752 -0400", hash_original_field = "F186B07246F1198E09E61F10F37B5A17", hash_generated_field = "7929D370BBAA2A6043EF739E265C3242")

    private long mTotalSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.752 -0400", hash_original_field = "869BB521FA1BF2D70B737238BCDB46CA", hash_generated_field = "BCCA6254E80514BD4181C138C6D39F8D")

    private long mFreeSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.752 -0400", hash_original_field = "309F6866C44A3EB7FB1C2356E4701E1A", hash_generated_field = "2FCE9C963C19BA9992E163CB6895C992")

    private long mCachedSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.752 -0400", hash_original_method = "0A3FF658B31652AA0351B8E33261A030", hash_generated_method = "0A3FF658B31652AA0351B8E33261A030")
    public MemInfoReader ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.753 -0400", hash_original_method = "D9BE2698B9CEABDB1C83ECE5A41CE9EF", hash_generated_method = "CF462499B68C97F04E129A88E186143C")
    private boolean matchText(byte[] buffer, int index, String text) {
        addTaint(text.getTaint());
        addTaint(index);
        addTaint(buffer[0]);
        int N = text.length();
    if((index+N) >= buffer.length)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1991628014 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2145113688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2145113688;
        } 
for(int i=0;i<N;i++)
        {
    if(buffer[index+i] != text.charAt(i))            
            {
                boolean var68934A3E9455FA72420237EB05902327_84417235 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1340880819 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1340880819;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_2034905585 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2080335854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2080335854;
        
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.754 -0400", hash_original_method = "DB73154576977FA52BEDF797ABB76527", hash_generated_method = "987BB2D317D2B70B6A8C3AE8E6E913BF")
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
                } 
                String str = new String(buffer, 0, start, index-start);
                long var757A25024648D172453F1B679709E510_2015979120 = (((long)Integer.parseInt(str)) * 1024);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_892000162 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_892000162;
            } 
            index++;
        } 
        long varCFCD208495D565EF66E7DFF9F98764DA_2038587244 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1651413956 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1651413956;
        
        
            
                
                
                
                    
                    
                
                
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.756 -0400", hash_original_method = "BB97E1D4EA3CA166050B741E23967BDC", hash_generated_method = "3040392CA1B36669D733A25588ECADCD")
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
                } 
                else
    if(matchText(mBuffer, i, "MemFree"))                
                {
                    i += 7;
                    mFreeSize = extractMemValue(mBuffer, i);
                    count++;
                } 
                else
    if(matchText(mBuffer, i, "Cached"))                
                {
                    i += 6;
                    mCachedSize = extractMemValue(mBuffer, i);
                    count++;
                } 
                while
(i < BUFLEN && mBuffer[i] != '\n')                
                {
                    i++;
                } 
            } 
        } 
        catch (java.io.FileNotFoundException e)
        {
        } 
        catch (java.io.IOException e)
        {
        } 
        finally 
        {
            StrictMode.setThreadPolicy(savedPolicy);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.756 -0400", hash_original_method = "3434AB33F130B66E857E66B11D583682", hash_generated_method = "90885A48EA5E7B01097968173B9C24D5")
    public long getTotalSize() {
        long varF186B07246F1198E09E61F10F37B5A17_1458136315 = (mTotalSize);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_863028386 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_863028386;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.757 -0400", hash_original_method = "FACB48AE3A5EF9A0F8A782DC112E6801", hash_generated_method = "85B895ED113E7E1806EF743DAE690BCA")
    public long getFreeSize() {
        long var869BB521FA1BF2D70B737238BCDB46CA_932176374 = (mFreeSize);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1382707644 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1382707644;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.757 -0400", hash_original_method = "67C7373745CA2083B77127FB7F7EF9BE", hash_generated_method = "25ABAABE5746BFB9989452DA93AE1E6F")
    public long getCachedSize() {
        long var309F6866C44A3EB7FB1C2356E4701E1A_420177332 = (mCachedSize);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_335594321 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_335594321;
        
        
    }

    
}

