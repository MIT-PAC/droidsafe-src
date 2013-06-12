package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import java.util.HashMap;

public final class LatencyTimer {
    String TAG = "LatencyTimer";
    int mSampleSize;
    int mScaleFactor;
    volatile HashMap<String, long[]> store = new HashMap<String, long[]>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.996 -0400", hash_original_method = "835FE1F7A54E064837749981F903873B", hash_generated_method = "B138705B2FA4A607DFD8FA8CF0DF5963")
    @DSModeled(DSC.SAFE)
    public LatencyTimer(int sampleSize, int scaleFactor) {
        dsTaint.addTaint(sampleSize);
        dsTaint.addTaint(scaleFactor);
        {
            scaleFactor = 1;
        } //End block
        // ---------- Original Method ----------
        //if (scaleFactor == 0) {
            //scaleFactor = 1;
        //}
        //mScaleFactor = scaleFactor;
        //mSampleSize = sampleSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.997 -0400", hash_original_method = "D9E098017BDD3A062F96DACECBFE33D0", hash_generated_method = "CBD535BDDA6F16C7193412BA49581261")
    @DSModeled(DSC.SAFE)
    public void sample(String tag, long delta) {
        dsTaint.addTaint(tag);
        dsTaint.addTaint(delta);
        long[] array;
        array = getArray(tag);
        int index;
        index = (int) array[mSampleSize]++;
        array[index] = delta;
        {
            long totalDelta;
            totalDelta = 0;
            {
                long d = array[0];
                {
                    totalDelta += d/mScaleFactor;
                } //End block
            } //End collapsed parenthetic
            array[mSampleSize] = 0;
        } //End block
        // ---------- Original Method ----------
        //long[] array = getArray(tag);
        //final int index = (int) array[mSampleSize]++;
        //array[index] = delta;
        //if (array[mSampleSize] == mSampleSize) {
            //long totalDelta = 0;
            //for (long d : array) {
                //totalDelta += d/mScaleFactor;
            //}
            //array[mSampleSize] = 0;
            //Log.i(TAG, tag + " average = " + totalDelta / mSampleSize);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.998 -0400", hash_original_method = "CB4383AB457909CC128F04335BC91797", hash_generated_method = "E69FA8F059D7889B0940DF210E69CF92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long[] getArray(String tag) {
        dsTaint.addTaint(tag);
        long[] data;
        data = store.get(tag);
        {
            {
                data = store.get(tag);
                {
                    data = new long[mSampleSize + 1];
                    store.put(tag, data);
                    data[mSampleSize] = 0;
                } //End block
            } //End block
        } //End block
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //long[] data = store.get(tag);
        //if (data == null) {
            //synchronized(store) {
                //data = store.get(tag);
                //if (data == null) {
                    //data = new long[mSampleSize + 1];
                    //store.put(tag, data);
                    //data[mSampleSize] = 0;
                //}
            //}
        //}
        //return data;
    }

    
}


