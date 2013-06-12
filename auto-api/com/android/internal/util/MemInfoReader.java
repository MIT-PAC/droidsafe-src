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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.482 -0400", hash_original_method = "D9BE2698B9CEABDB1C83ECE5A41CE9EF", hash_generated_method = "15083CB51C64F97CF7334E792A2A62E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean matchText(byte[] buffer, int index, String text) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(index);
        dsTaint.addTaint(text);
        int N;
        N = text.length();
        {
            int i;
            i = 0;
            {
                {
                    boolean varD666446A75B53823900A4A6FFC983903_75346078 = (buffer[index+i] != text.charAt(i));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.531 -0400", hash_original_method = "DB73154576977FA52BEDF797ABB76527", hash_generated_method = "E43BEA97CB6DB6C8D0505D33495B1045")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long extractMemValue(byte[] buffer, int index) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(index);
        {
            {
                int start;
                start = index;
                index++;
                {
                    index++;
                } //End block
                String str;
                str = new String(buffer, 0, start, index-start);
                long var387EC5FC2C0639E7F95A08F66A2DB6D9_953707603 = (((long)Integer.parseInt(str)) * 1024);
            } //End block
            index++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.639 -0400", hash_original_method = "BB97E1D4EA3CA166050B741E23967BDC", hash_generated_method = "98020C99C8A1471DB080A0DD0CD751FB")
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
                        boolean varECB16495266028F12021205E9D94E458_1063682094 = (matchText(mBuffer, i, "MemTotal"));
                        {
                            i += 8;
                            mTotalSize = extractMemValue(mBuffer, i);
                            count++;
                        } //End block
                        {
                            boolean var0B9C411E6930A2921E8F44E94088809B_232333082 = (matchText(mBuffer, i, "MemFree"));
                            {
                                i += 7;
                                mFreeSize = extractMemValue(mBuffer, i);
                                count++;
                            } //End block
                            {
                                boolean var700D804177A2AFC923A91B385BA28E88_1966846944 = (matchText(mBuffer, i, "Cached"));
                                {
                                    i += 6;
                                    mCachedSize = extractMemValue(mBuffer, i);
                                    count++;
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    {
                        i++;
                    } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.693 -0400", hash_original_method = "3434AB33F130B66E857E66B11D583682", hash_generated_method = "A2494163829A09853DA3EF7C77785974")
    @DSModeled(DSC.SAFE)
    public long getTotalSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mTotalSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.705 -0400", hash_original_method = "FACB48AE3A5EF9A0F8A782DC112E6801", hash_generated_method = "F5B03B503E029C6C412AD4C69CFCBCEE")
    @DSModeled(DSC.SAFE)
    public long getFreeSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mFreeSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.729 -0400", hash_original_method = "67C7373745CA2083B77127FB7F7EF9BE", hash_generated_method = "4C9CEC784032581539971D901D6D99AD")
    @DSModeled(DSC.SAFE)
    public long getCachedSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mCachedSize;
    }

    
}


