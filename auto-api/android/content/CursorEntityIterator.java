package android.content;

// Droidsafe Imports
import android.database.Cursor;
import android.os.RemoteException;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public abstract class CursorEntityIterator implements EntityIterator {
    private final Cursor mCursor;
    private boolean mIsClosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.517 -0400", hash_original_method = "76B86F8C1E31679F8727B434E61B14CB", hash_generated_method = "003A50EB5C7BFAE3F9D33C25E685D471")
    @DSModeled(DSC.SAFE)
    public CursorEntityIterator(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        mIsClosed = false;
        mCursor = cursor;
        mCursor.moveToFirst();
        // ---------- Original Method ----------
        //mIsClosed = false;
        //mCursor = cursor;
        //mCursor.moveToFirst();
    }

    
    public abstract Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.518 -0400", hash_original_method = "EFC615883F392C5E7B7F6E9EF3393B85", hash_generated_method = "D78E0431F2A3C8B1D886E3CEB106CE86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasNext() {
        {
        	if (DroidSafeAndroidRuntime.control)throw new IllegalStateException("calling hasNext() when the iterator is closed");
        } //End block
        boolean var1223B7E5B0B9252AE7BAD96C7FEE91F6_1165292258 = (!mCursor.isAfterLast());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mIsClosed) {
            //throw new IllegalStateException("calling hasNext() when the iterator is closed");
        //}
        //return !mCursor.isAfterLast();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.518 -0400", hash_original_method = "D761CE40C9BF5BACB311C894FE3131D0", hash_generated_method = "2497ED9A3C002C346B8CD9DAA1DF61B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entity next() {
        {
        	if (DroidSafeAndroidRuntime.control)throw new IllegalStateException("calling next() when the iterator is closed");
        } //End block
        {
            boolean var2CC10AB3C52DD03176ADB3A939341751_993337022 = (!hasNext());
            {
            	if (DroidSafeAndroidRuntime.control)throw new IllegalStateException("you may only call next() if hasNext() is true");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            Entity var9676298C45556318826ADE58CF1C7796_400775931 = (getEntityAndIncrementCursor(mCursor));
        } //End block
        catch (RemoteException e)
        {
            throw new RuntimeException("caught a remote exception, this process will die soon", e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.518 -0400", hash_original_method = "2158F00E167F00121D9D2190C01FAABB", hash_generated_method = "BB63CD81F8C4D05933E93048D2CA6B01")
    @DSModeled(DSC.SAFE)
    public void remove() {
        throw new UnsupportedOperationException("remove not supported by EntityIterators");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("remove not supported by EntityIterators");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.518 -0400", hash_original_method = "D0360F07FA873653A69218CB10B6D78C", hash_generated_method = "6A98D7A50BA732A40BE0DE345FE993C3")
    @DSModeled(DSC.SAFE)
    public final void reset() {
        {
        	if (DroidSafeAndroidRuntime.control)throw new IllegalStateException("calling reset() when the iterator is closed");
        } //End block
        mCursor.moveToFirst();
        // ---------- Original Method ----------
        //if (mIsClosed) {
            //throw new IllegalStateException("calling reset() when the iterator is closed");
        //}
        //mCursor.moveToFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.519 -0400", hash_original_method = "B24D9E2E069589E778F23FCBC29406BF", hash_generated_method = "26A8AD9E96A33030BDD904D21797460E")
    @DSModeled(DSC.SAFE)
    public final void close() {
        {
        	if (DroidSafeAndroidRuntime.control)throw new IllegalStateException("closing when already closed");
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


