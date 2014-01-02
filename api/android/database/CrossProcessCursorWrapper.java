package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    /**
     * Creates a cross process cursor wrapper.
     * @param cursor The underlying cursor to wrap.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.987 -0500", hash_original_method = "5197A5F113F85D854415B2B6533E1F8C", hash_generated_method = "AE455A2594CA87F4AA1FE2262F4153C1")
    
public CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.990 -0500", hash_original_method = "8AFBAB5134F9C202EA9293756DDD55DE", hash_generated_method = "5BEBB5BB2469261611900B3E1EBDF372")
    
@Override
    public void fillWindow(int position, CursorWindow window) {
        if (mCursor instanceof CrossProcessCursor) {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            crossProcessCursor.fillWindow(position, window);
            return;
        }

        DatabaseUtils.cursorFillWindow(mCursor, position, window);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.992 -0500", hash_original_method = "D510FEC99A9AF46DE1EA010D6828DD6E", hash_generated_method = "B274170C8BD2FA2D26833AA62279DD73")
    
@Override
    public CursorWindow getWindow() {
        if (mCursor instanceof CrossProcessCursor) {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            return crossProcessCursor.getWindow();
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.995 -0500", hash_original_method = "1B4D2A02F9F1E4FEB130E32B375A1C19", hash_generated_method = "39EC9CB83A8BDF1263B4668B66D96CF6")
    
@Override
    public boolean onMove(int oldPosition, int newPosition) {
        if (mCursor instanceof CrossProcessCursor) {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            return crossProcessCursor.onMove(oldPosition, newPosition);
        }

        return true;
    }

    
}

