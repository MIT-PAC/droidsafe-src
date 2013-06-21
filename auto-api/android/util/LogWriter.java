package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Writer;

public class LogWriter extends Writer {
    private int mPriority;
    private String mTag;
    private int mBuffer;
    private StringBuilder mBuilder = new StringBuilder(128);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.229 -0400", hash_original_method = "E44EE0F95315B8E0B0AD825ED26FE77A", hash_generated_method = "822AAAB1E06A4B487DCC5C1FCFC5F9D8")
    @DSModeled(DSC.SAFE)
    public LogWriter(int priority, String tag) {
        dsTaint.addTaint(tag);
        dsTaint.addTaint(priority);
        mBuffer = Log.LOG_ID_MAIN;
        // ---------- Original Method ----------
        //mPriority = priority;
        //mTag = tag;
        //mBuffer = Log.LOG_ID_MAIN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.229 -0400", hash_original_method = "ABBE3E1E49A04D726DE9335FE3D64F4B", hash_generated_method = "B6AA1443ACBC5FAF71E3F63496D54A73")
    @DSModeled(DSC.SAFE)
    public LogWriter(int priority, String tag, int buffer) {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(priority);
        // ---------- Original Method ----------
        //mPriority = priority;
        //mTag = tag;
        //mBuffer = buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.230 -0400", hash_original_method = "651C3299C6098C5206251D3395E7F56C", hash_generated_method = "D08D7FDC7D86BF10CFE149353B975CA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() {
        flushBuilder();
        // ---------- Original Method ----------
        //flushBuilder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.230 -0400", hash_original_method = "4397D4B6CC585AD9A2FABC1DB1031654", hash_generated_method = "97F56083B0C8ACED57AE8237C5E7EFB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void flush() {
        flushBuilder();
        // ---------- Original Method ----------
        //flushBuilder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.230 -0400", hash_original_method = "87C8CDE1CE20D2763C465BB465CBAFDD", hash_generated_method = "C5022FED30006EA479BA4D7689386057")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(char[] buf, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        {
            int i;
            i = 0;
            {
                char c;
                c = buf[offset + i];
                {
                    flushBuilder();
                } //End block
                {
                    mBuilder.append(c);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for(int i = 0; i < count; i++) {
            //char c = buf[offset + i];
            //if ( c == '\n') {
                //flushBuilder();
            //}
            //else {
                //mBuilder.append(c);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.234 -0400", hash_original_method = "365F60E44B7DA4848E76578B1D312F6F", hash_generated_method = "501EDE4B41F32F2A7B20336AEA28E28A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void flushBuilder() {
        {
            boolean varEE1A661D6E06AE1B2836B7ED9579764C_866562916 = (mBuilder.length() > 0);
            {
                Log.println_native(mBuffer, mPriority, mTag, mBuilder.toString());
                mBuilder.delete(0, mBuilder.length());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mBuilder.length() > 0) {
            //Log.println_native(mBuffer, mPriority, mTag, mBuilder.toString());
            //mBuilder.delete(0, mBuilder.length());
        //}
    }

    
}

