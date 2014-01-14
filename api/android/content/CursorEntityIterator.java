package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.Cursor;
import android.os.RemoteException;

public abstract class CursorEntityIterator implements EntityIterator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.270 -0500", hash_original_field = "4A85E902ED72E65A9AF8F6ED265E4F89", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private  Cursor mCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.272 -0500", hash_original_field = "71243BBA92A200CA5F2A2C2AF2750DFD", hash_generated_field = "A6BB6E42C38AE7C525A0832B55750D8F")

    private boolean mIsClosed;

    /**
     * Constructor that makes initializes the cursor such that the iterator points to the
     * first Entity, if there are any.
     * @param cursor the cursor that contains the rows that make up the entities
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.274 -0500", hash_original_method = "76B86F8C1E31679F8727B434E61B14CB", hash_generated_method = "787E12DE772D7E05097D2055C9409991")
    
public CursorEntityIterator(Cursor cursor) {
        mIsClosed = false;
        mCursor = cursor;
        mCursor.moveToFirst();
    }

    /**
     * Returns the entity that the cursor is currently pointing to. This must take care to advance
     * the cursor past this entity. This will never be called if the cursor is at the end.
     * @param cursor the cursor that contains the entity rows
     * @return the entity that the cursor is currently pointing to
     * @throws RemoteException if a RemoteException is caught while attempting to build the Entity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.276 -0500", hash_original_method = "8E9C8F1DC87A5B0FEC2F1314601A7972", hash_generated_method = "308DEBA12E5A4D5BEE7FAA2B9F418B93")
    
public abstract Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException;

    /**
     * Returns whether there are more elements to iterate, i.e. whether the
     * iterator is positioned in front of an element.
     *
     * @return {@code true} if there are more elements, {@code false} otherwise.
     * @see EntityIterator#next()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.279 -0500", hash_original_method = "EFC615883F392C5E7B7F6E9EF3393B85", hash_generated_method = "0924C60238EDA5C3606627270C16F625")
    
public final boolean hasNext() {
        if (mIsClosed) {
            throw new IllegalStateException("calling hasNext() when the iterator is closed");
        }

        return !mCursor.isAfterLast();
    }

    /**
     * Returns the next object in the iteration, i.e. returns the element in
     * front of the iterator and advances the iterator by one position.
     *
     * @return the next object.
     * @throws java.util.NoSuchElementException
     *             if there are no more elements.
     * @see EntityIterator#hasNext()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.282 -0500", hash_original_method = "D761CE40C9BF5BACB311C894FE3131D0", hash_generated_method = "CEC4763A0AD1E76D825251378A952EB1")
    
public Entity next() {
        if (mIsClosed) {
            throw new IllegalStateException("calling next() when the iterator is closed");
        }
        if (!hasNext()) {
            throw new IllegalStateException("you may only call next() if hasNext() is true");
        }

        try {
            return getEntityAndIncrementCursor(mCursor);
        } catch (RemoteException e) {
            throw new RuntimeException("caught a remote exception, this process will die soon", e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.284 -0500", hash_original_method = "2158F00E167F00121D9D2190C01FAABB", hash_generated_method = "0FD01F63F245931D95A36B4109D5E661")
    
public void remove() {
        throw new UnsupportedOperationException("remove not supported by EntityIterators");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.286 -0500", hash_original_method = "D0360F07FA873653A69218CB10B6D78C", hash_generated_method = "24177ED3C6F3FC195AB3AB3E0371400F")
    
public final void reset() {
        if (mIsClosed) {
            throw new IllegalStateException("calling reset() when the iterator is closed");
        }
        mCursor.moveToFirst();
    }

    /**
     * Indicates that this iterator is no longer needed and that any associated resources
     * may be released (such as a SQLite cursor).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.288 -0500", hash_original_method = "B24D9E2E069589E778F23FCBC29406BF", hash_generated_method = "48933D8E41E4523E6CE836F2AC747B30")
    
public final void close() {
        if (mIsClosed) {
            throw new IllegalStateException("closing when already closed");
        }
        mIsClosed = true;
        mCursor.close();
    }
    
}

