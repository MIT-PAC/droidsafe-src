package android.support.v4.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import java.io.Writer;

public class LogWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.534 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

    private String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.534 -0400", hash_original_field = "703EB97AE4F88C70A45665101CB2FF61", hash_generated_field = "E8A32971F664F41D368D321D04FCC115")

    private StringBuilder mBuilder = new StringBuilder(128);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.534 -0400", hash_original_method = "9BFCBEDD9F75493AAF00467F3D68B8DC", hash_generated_method = "0DD707CB45BA89D429A8BE7521AD42EB")
    public  LogWriter(String tag) {
        mTag = tag;
        // ---------- Original Method ----------
        //mTag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.535 -0400", hash_original_method = "651C3299C6098C5206251D3395E7F56C", hash_generated_method = "D08D7FDC7D86BF10CFE149353B975CA7")
    @Override
    public void close() {
        flushBuilder();
        // ---------- Original Method ----------
        //flushBuilder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.535 -0400", hash_original_method = "4397D4B6CC585AD9A2FABC1DB1031654", hash_generated_method = "97F56083B0C8ACED57AE8237C5E7EFB5")
    @Override
    public void flush() {
        flushBuilder();
        // ---------- Original Method ----------
        //flushBuilder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.536 -0400", hash_original_method = "87C8CDE1CE20D2763C465BB465CBAFDD", hash_generated_method = "9BDF1371A8F52A0B4DB9441B7A707252")
    @Override
    public void write(char[] buf, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(buf[0]);
for(int i = 0;i < count;i++)
        {
            char c = buf[offset + i];
    if(c == '\n')            
            {
                flushBuilder();
            } //End block
            else
            {
                mBuilder.append(c);
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.536 -0400", hash_original_method = "A3E85FE8F46B76369541B6339B556DCC", hash_generated_method = "D381A8AE144E212E1E6A0EEC9EE319D0")
    private void flushBuilder() {
    if(mBuilder.length() > 0)        
        {
            Log.d(mTag, mBuilder.toString());
            mBuilder.delete(0, mBuilder.length());
        } //End block
        // ---------- Original Method ----------
        //if (mBuilder.length() > 0) {
            //Log.d(mTag, mBuilder.toString());
            //mBuilder.delete(0, mBuilder.length());
        //}
    }

    
}

