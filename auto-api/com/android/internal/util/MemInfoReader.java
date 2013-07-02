package com.android.internal.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FileInputStream;
import android.os.StrictMode;

public class MemInfoReader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.738 -0400", hash_original_field = "B634495A5206EAC864BE33EEF0379447", hash_generated_field = "D8DB14FD2FF72CF1AA09DD3099C7A5AC")

    byte[] mBuffer = new byte[1024];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.738 -0400", hash_original_field = "F186B07246F1198E09E61F10F37B5A17", hash_generated_field = "7929D370BBAA2A6043EF739E265C3242")

    private long mTotalSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.738 -0400", hash_original_field = "869BB521FA1BF2D70B737238BCDB46CA", hash_generated_field = "BCCA6254E80514BD4181C138C6D39F8D")

    private long mFreeSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.738 -0400", hash_original_field = "309F6866C44A3EB7FB1C2356E4701E1A", hash_generated_field = "2FCE9C963C19BA9992E163CB6895C992")

    private long mCachedSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.739 -0400", hash_original_method = "0A3FF658B31652AA0351B8E33261A030", hash_generated_method = "0A3FF658B31652AA0351B8E33261A030")
    public MemInfoReader ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.739 -0400", hash_original_method = "D9BE2698B9CEABDB1C83ECE5A41CE9EF", hash_generated_method = "1871C42D1BEDA7F490AD7B9B36739D5C")
    private boolean matchText(byte[] buffer, int index, String text) {
        int N = text.length();
        {
            int i = 0;
            {
                {
                    boolean varD666446A75B53823900A4A6FFC983903_1545595629 = (buffer[index+i] != text.charAt(i));
                } 
            } 
        } 
        addTaint(buffer[0]);
        addTaint(index);
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_915148583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_915148583;
        
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.740 -0400", hash_original_method = "DB73154576977FA52BEDF797ABB76527", hash_generated_method = "6D39962C5989E0124646D01D45994D44")
    private long extractMemValue(byte[] buffer, int index) {
        {
            {
                int start = index;
                String str = new String(buffer, 0, start, index-start);
                long var387EC5FC2C0639E7F95A08F66A2DB6D9_696676079 = (((long)Integer.parseInt(str)) * 1024);
            } 
        } 
        addTaint(buffer[0]);
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1796650885 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1796650885;
        
        
            
                
                
                
                    
                    
                
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.742 -0400", hash_original_method = "BB97E1D4EA3CA166050B741E23967BDC", hash_generated_method = "5A57F5D877729FEB145D55DBCE221436")
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
            {
                int i = 0;
                {
                    {
                        boolean varECB16495266028F12021205E9D94E458_818712725 = (matchText(mBuffer, i, "MemTotal"));
                        {
                            i += 8;
                            mTotalSize = extractMemValue(mBuffer, i);
                        } 
                        {
                            boolean var0B9C411E6930A2921E8F44E94088809B_1462947250 = (matchText(mBuffer, i, "MemFree"));
                            {
                                i += 7;
                                mFreeSize = extractMemValue(mBuffer, i);
                            } 
                            {
                                boolean var700D804177A2AFC923A91B385BA28E88_1553618433 = (matchText(mBuffer, i, "Cached"));
                                {
                                    i += 6;
                                    mCachedSize = extractMemValue(mBuffer, i);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        catch (java.io.FileNotFoundException e)
        { }
        catch (java.io.IOException e)
        { }
        finally 
        {
            StrictMode.setThreadPolicy(savedPolicy);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.743 -0400", hash_original_method = "3434AB33F130B66E857E66B11D583682", hash_generated_method = "236E513568196EA53F67028D32C1D45B")
    public long getTotalSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1107853020 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1107853020;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.745 -0400", hash_original_method = "FACB48AE3A5EF9A0F8A782DC112E6801", hash_generated_method = "917692B8383BE4493EDCDF5FB091C133")
    public long getFreeSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1095878691 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1095878691;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.745 -0400", hash_original_method = "67C7373745CA2083B77127FB7F7EF9BE", hash_generated_method = "89459EFDF3AD8C89437A1027CAC50E9B")
    public long getCachedSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_863836822 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_863836822;
        
        
    }

    
}

