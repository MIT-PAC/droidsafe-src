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
    byte[] mBuffer = new byte[1024];
    private long mTotalSize;
    private long mFreeSize;
    private long mCachedSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.728 -0400", hash_original_method = "CF3FFFDB0877E61A8219D2CC134610A9", hash_generated_method = "CF3FFFDB0877E61A8219D2CC134610A9")
        public MemInfoReader ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.730 -0400", hash_original_method = "D9BE2698B9CEABDB1C83ECE5A41CE9EF", hash_generated_method = "AA85314B5B25B7AFAF3EFBDD01742455")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean matchText(byte[] buffer, int index, String text) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(text);
        dsTaint.addTaint(index);
        int N;
        N = text.length();
        {
            int i;
            i = 0;
            {
                {
                    boolean varD666446A75B53823900A4A6FFC983903_1906275305 = (buffer[index+i] != text.charAt(i));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.731 -0400", hash_original_method = "DB73154576977FA52BEDF797ABB76527", hash_generated_method = "CE85E1744B6C5E19C8274CF0AC73E18F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long extractMemValue(byte[] buffer, int index) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(index);
        {
            {
                int start;
                start = index;
                String str;
                str = new String(buffer, 0, start, index-start);
                long var387EC5FC2C0639E7F95A08F66A2DB6D9_394968314 = (((long)Integer.parseInt(str)) * 1024);
            } //End block
        } //End block
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.733 -0400", hash_original_method = "BB97E1D4EA3CA166050B741E23967BDC", hash_generated_method = "D43FFD4A6072A4A41E40CBB9C7B5E977")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                        boolean varECB16495266028F12021205E9D94E458_1099769788 = (matchText(mBuffer, i, "MemTotal"));
                        {
                            i += 8;
                            mTotalSize = extractMemValue(mBuffer, i);
                        } //End block
                        {
                            boolean var0B9C411E6930A2921E8F44E94088809B_531104520 = (matchText(mBuffer, i, "MemFree"));
                            {
                                i += 7;
                                mFreeSize = extractMemValue(mBuffer, i);
                            } //End block
                            {
                                boolean var700D804177A2AFC923A91B385BA28E88_588166204 = (matchText(mBuffer, i, "Cached"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.733 -0400", hash_original_method = "3434AB33F130B66E857E66B11D583682", hash_generated_method = "4B1FFEB996D577435E37EF289C3F44FD")
    @DSModeled(DSC.SAFE)
    public long getTotalSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mTotalSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.733 -0400", hash_original_method = "FACB48AE3A5EF9A0F8A782DC112E6801", hash_generated_method = "2AD1F82866E7077489F71E003D3EE046")
    @DSModeled(DSC.SAFE)
    public long getFreeSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mFreeSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.734 -0400", hash_original_method = "67C7373745CA2083B77127FB7F7EF9BE", hash_generated_method = "B2AE62EFC9A9E150ECA84399C182FB3A")
    @DSModeled(DSC.SAFE)
    public long getCachedSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mCachedSize;
    }

    
}

