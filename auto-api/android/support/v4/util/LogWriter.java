package android.support.v4.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import java.io.Writer;

public class LogWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.285 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

    private String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.285 -0400", hash_original_field = "703EB97AE4F88C70A45665101CB2FF61", hash_generated_field = "E8A32971F664F41D368D321D04FCC115")

    private StringBuilder mBuilder = new StringBuilder(128);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.285 -0400", hash_original_method = "9BFCBEDD9F75493AAF00467F3D68B8DC", hash_generated_method = "0DD707CB45BA89D429A8BE7521AD42EB")
    public  LogWriter(String tag) {
        mTag = tag;
        // ---------- Original Method ----------
        //mTag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.286 -0400", hash_original_method = "651C3299C6098C5206251D3395E7F56C", hash_generated_method = "D08D7FDC7D86BF10CFE149353B975CA7")
    @Override
    public void close() {
        flushBuilder();
        // ---------- Original Method ----------
        //flushBuilder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.287 -0400", hash_original_method = "4397D4B6CC585AD9A2FABC1DB1031654", hash_generated_method = "97F56083B0C8ACED57AE8237C5E7EFB5")
    @Override
    public void flush() {
        flushBuilder();
        // ---------- Original Method ----------
        //flushBuilder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.287 -0400", hash_original_method = "87C8CDE1CE20D2763C465BB465CBAFDD", hash_generated_method = "615F1BF9D4DEB4746A45B574E25EE0B8")
    @Override
    public void write(char[] buf, int offset, int count) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.291 -0400", hash_original_method = "A3E85FE8F46B76369541B6339B556DCC", hash_generated_method = "A8BF0BA8F03DF1B54D39B4B71550CDC5")
    private void flushBuilder() {
        {
            boolean varEE1A661D6E06AE1B2836B7ED9579764C_686511445 = (mBuilder.length() > 0);
            {
                Log.d(mTag, mBuilder.toString());
                mBuilder.delete(0, mBuilder.length());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mBuilder.length() > 0) {
            //Log.d(mTag, mBuilder.toString());
            //mBuilder.delete(0, mBuilder.length());
        //}
    }

    
}

