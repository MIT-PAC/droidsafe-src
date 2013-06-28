package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.Cursor;
import android.os.RemoteException;

public abstract class CursorEntityIterator implements EntityIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:25.848 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:25.857 -0400", hash_original_field = "42C51B2F76146A5EC92C9811D57ACF10", hash_generated_field = "A6BB6E42C38AE7C525A0832B55750D8F")

    private boolean mIsClosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:25.863 -0400", hash_original_method = "76B86F8C1E31679F8727B434E61B14CB", hash_generated_method = "547E5BAFEE5949ADE42ED02F4DD92F32")
    public void CursorEntityIterator(Cursor cursor) {
        mIsClosed = false;
        mCursor = cursor;
        mCursor.moveToFirst();
        // ---------- Original Method ----------
        //mIsClosed = false;
        //mCursor = cursor;
        //mCursor.moveToFirst();
    }

    
    public abstract Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:25.870 -0400", hash_original_method = "EFC615883F392C5E7B7F6E9EF3393B85", hash_generated_method = "B3524090D5DD2C857218AB5E52DF7D92")
    public final boolean hasNext() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("calling hasNext() when the iterator is closed");
        } //End block
        boolean var1223B7E5B0B9252AE7BAD96C7FEE91F6_1167118456 = (!mCursor.isAfterLast());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_407286510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_407286510;
        // ---------- Original Method ----------
        //if (mIsClosed) {
            //throw new IllegalStateException("calling hasNext() when the iterator is closed");
        //}
        //return !mCursor.isAfterLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:25.881 -0400", hash_original_method = "D761CE40C9BF5BACB311C894FE3131D0", hash_generated_method = "07405E58FBF028488AAA2574A173D62D")
    public Entity next() {
        Entity var3A1D93BF29359CD4476F0C42D70CD787_1174289805; //For return ordinal 1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("calling next() when the iterator is closed");
        } //End block
        {
            boolean var2CC10AB3C52DD03176ADB3A939341751_737403957 = (!hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("you may only call next() if hasNext() is true");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            var3A1D93BF29359CD4476F0C42D70CD787_1174289805 = getEntityAndIncrementCursor(mCursor);
        } //End block
        catch (RemoteException e)
        {
        	throw new RuntimeException("caught a remote exception, this process will die soon", e);
        } //End block
        Entity var1E6151782509B2C92750CFF962B742CD_1432176429 = var3A1D93BF29359CD4476F0C42D70CD787_1174289805;
        var1E6151782509B2C92750CFF962B742CD_1432176429.addTaint(getTaint()); //Add taint from parent
        return var1E6151782509B2C92750CFF962B742CD_1432176429;
        // ---------- Original Method ----------
        //if (mIsClosed) {
            //throw new IllegalStateException("calling next() when the iterator is closed");
        //}
        //if (!hasNext()) {
            //throw new IllegalStateException("you may only call next() if hasNext() is true");
        //}
        //try {
            //return getEntityAndIncrementCursor(mCursor);
        //} catch (RemoteException e) {
            //throw new RuntimeException("caught a remote exception, this process will die soon", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:25.885 -0400", hash_original_method = "2158F00E167F00121D9D2190C01FAABB", hash_generated_method = "B86A3CB9F87AF9759349B2E60E41A138")
    public void remove() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("remove not supported by EntityIterators");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("remove not supported by EntityIterators");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:25.888 -0400", hash_original_method = "D0360F07FA873653A69218CB10B6D78C", hash_generated_method = "9A2018182EA3267B73725BDBE2D0A16F")
    public final void reset() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("calling reset() when the iterator is closed");
        } //End block
        mCursor.moveToFirst();
        // ---------- Original Method ----------
        //if (mIsClosed) {
            //throw new IllegalStateException("calling reset() when the iterator is closed");
        //}
        //mCursor.moveToFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:25.893 -0400", hash_original_method = "B24D9E2E069589E778F23FCBC29406BF", hash_generated_method = "65E4AB49B4727E6F11386DE5D0AB7526")
    public final void close() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("closing when already closed");
        } //End block
        mIsClosed = true;
        mCursor.close();
        // ---------- Original Method ----------
        //if (mIsClosed) {
            //throw new IllegalStateException("closing when already closed");
        //}
        //mIsClosed = true;
        //mCursor.close();
    }

    
}

