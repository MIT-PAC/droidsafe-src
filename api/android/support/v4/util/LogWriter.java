package android.support.v4.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Writer;

import android.util.Log;

public class LogWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.545 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "0950070738D23525D6B35F116326FC98")

    private  String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.547 -0500", hash_original_field = "F56AAA678AD284A339D9BF0BD3A2B91B", hash_generated_field = "E8A32971F664F41D368D321D04FCC115")

    private StringBuilder mBuilder = new StringBuilder(128);

    /**
     * Create a new Writer that sends to the log with the given priority
     * and tag.
     *
     * @param tag A string tag to associate with each printed log statement.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.550 -0500", hash_original_method = "9BFCBEDD9F75493AAF00467F3D68B8DC", hash_generated_method = "AC1E71F298BF5447E8007D0AC71DCE1D")
    
public LogWriter(String tag) {
        mTag = tag;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.552 -0500", hash_original_method = "651C3299C6098C5206251D3395E7F56C", hash_generated_method = "1CD08D4D2256B0899718D98755C4D248")
    
@Override public void close() {
        flushBuilder();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.555 -0500", hash_original_method = "4397D4B6CC585AD9A2FABC1DB1031654", hash_generated_method = "64C92D353792C9C77A9951308C9A0855")
    
@Override public void flush() {
        flushBuilder();
    }

    @DSSink(DSSinkKind.IO)
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.558 -0500", hash_original_method = "87C8CDE1CE20D2763C465BB465CBAFDD", hash_generated_method = "72F623F59FC9F90F70CCD532565A22B3")
    
@Override public void write(char[] buf, int offset, int count) {
        for(int i = 0; i < count; i++) {
            char c = buf[offset + i];
            if ( c == '\n') {
                flushBuilder();
            }
            else {
                mBuilder.append(c);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.560 -0500", hash_original_method = "A3E85FE8F46B76369541B6339B556DCC", hash_generated_method = "F54FE92EA92674829E386B9EB3BD3D09")
    
private void flushBuilder() {
        if (mBuilder.length() > 0) {
            Log.d(mTag, mBuilder.toString());
            mBuilder.delete(0, mBuilder.length());
        }
    }
    
}

