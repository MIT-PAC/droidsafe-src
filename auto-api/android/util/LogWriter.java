package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Writer;

public class LogWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.360 -0400", hash_original_field = "22FC7A378B4F7C5F90F70A47BE1E4FCD", hash_generated_field = "032B46B6D9E42E1E80E269F8E583852A")

    private int mPriority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.360 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

    private String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.360 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "364E92680041A3D3F5423C96BD78F11B")

    private int mBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.360 -0400", hash_original_field = "703EB97AE4F88C70A45665101CB2FF61", hash_generated_field = "E8A32971F664F41D368D321D04FCC115")

    private StringBuilder mBuilder = new StringBuilder(128);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.360 -0400", hash_original_method = "E44EE0F95315B8E0B0AD825ED26FE77A", hash_generated_method = "D7AD5B779E6E88DC7856B65491B83776")
    public  LogWriter(int priority, String tag) {
        mPriority = priority;
        mTag = tag;
        mBuffer = Log.LOG_ID_MAIN;
        // ---------- Original Method ----------
        //mPriority = priority;
        //mTag = tag;
        //mBuffer = Log.LOG_ID_MAIN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.360 -0400", hash_original_method = "ABBE3E1E49A04D726DE9335FE3D64F4B", hash_generated_method = "5C49E3626BD0C6D8215CFB8F659F0B8A")
    public  LogWriter(int priority, String tag, int buffer) {
        mPriority = priority;
        mTag = tag;
        mBuffer = buffer;
        // ---------- Original Method ----------
        //mPriority = priority;
        //mTag = tag;
        //mBuffer = buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.361 -0400", hash_original_method = "651C3299C6098C5206251D3395E7F56C", hash_generated_method = "D08D7FDC7D86BF10CFE149353B975CA7")
    @Override
    public void close() {
        flushBuilder();
        // ---------- Original Method ----------
        //flushBuilder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.361 -0400", hash_original_method = "4397D4B6CC585AD9A2FABC1DB1031654", hash_generated_method = "97F56083B0C8ACED57AE8237C5E7EFB5")
    @Override
    public void flush() {
        flushBuilder();
        // ---------- Original Method ----------
        //flushBuilder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.361 -0400", hash_original_method = "87C8CDE1CE20D2763C465BB465CBAFDD", hash_generated_method = "03D51D5DF3E455A5387A1417034A33D9")
    @Override
    public void write(char[] buf, int offset, int count) {
        {
            int i = 0;
            {
                char c = buf[offset + i];
                {
                    flushBuilder();
                } //End block
                {
                    mBuilder.append(c);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(count);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.362 -0400", hash_original_method = "365F60E44B7DA4848E76578B1D312F6F", hash_generated_method = "FC833C62FA817011D77079C0912322FB")
    private void flushBuilder() {
        {
            boolean varEE1A661D6E06AE1B2836B7ED9579764C_188291435 = (mBuilder.length() > 0);
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

