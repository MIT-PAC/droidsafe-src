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
    private Cursor mCursor;
    private boolean mIsClosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.152 -0400", hash_original_method = "76B86F8C1E31679F8727B434E61B14CB", hash_generated_method = "A9E6CDB89BF744F00CABDEC3D757486D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CursorEntityIterator(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        mIsClosed = false;
        mCursor.moveToFirst();
        // ---------- Original Method ----------
        //mIsClosed = false;
        //mCursor = cursor;
        //mCursor.moveToFirst();
    }

    
    public abstract Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.156 -0400", hash_original_method = "EFC615883F392C5E7B7F6E9EF3393B85", hash_generated_method = "E4D3B10F9F99964A61C1B34C565D56B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasNext() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("calling hasNext() when the iterator is closed");
        } //End block
        boolean var1223B7E5B0B9252AE7BAD96C7FEE91F6_744061818 = (!mCursor.isAfterLast());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mIsClosed) {
            //throw new IllegalStateException("calling hasNext() when the iterator is closed");
        //}
        //return !mCursor.isAfterLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.174 -0400", hash_original_method = "D761CE40C9BF5BACB311C894FE3131D0", hash_generated_method = "40FE1FCB305F4E8850ADBCCAD8E58E29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entity next() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("calling next() when the iterator is closed");
        } //End block
        {
            boolean var2CC10AB3C52DD03176ADB3A939341751_693815977 = (!hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("you may only call next() if hasNext() is true");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            Entity var9676298C45556318826ADE58CF1C7796_1358529263 = (getEntityAndIncrementCursor(mCursor));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("caught a remote exception, this process will die soon", e);
        } //End block
        return (Entity)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.175 -0400", hash_original_method = "2158F00E167F00121D9D2190C01FAABB", hash_generated_method = "B86A3CB9F87AF9759349B2E60E41A138")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void remove() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("remove not supported by EntityIterators");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("remove not supported by EntityIterators");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.175 -0400", hash_original_method = "D0360F07FA873653A69218CB10B6D78C", hash_generated_method = "9A2018182EA3267B73725BDBE2D0A16F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.175 -0400", hash_original_method = "B24D9E2E069589E778F23FCBC29406BF", hash_generated_method = "65E4AB49B4727E6F11386DE5D0AB7526")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

