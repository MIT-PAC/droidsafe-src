package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.594 -0400", hash_original_method = "5197A5F113F85D854415B2B6533E1F8C", hash_generated_method = "EDB046CFA4E85D633587267A6A7E6D56")
    public  CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
        addTaint(cursor.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.595 -0400", hash_original_method = "8AFBAB5134F9C202EA9293756DDD55DE", hash_generated_method = "C9B2274D1084403D8FDF1208449EED05")
    @Override
    public void fillWindow(int position, CursorWindow window) {
        addTaint(window.getTaint());
        addTaint(position);
        if(mCursor instanceof CrossProcessCursor)        
        {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            crossProcessCursor.fillWindow(position, window);
            return;
        } //End block
        DatabaseUtils.cursorFillWindow(mCursor, position, window);
        // ---------- Original Method ----------
        //if (mCursor instanceof CrossProcessCursor) {
            //final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            //crossProcessCursor.fillWindow(position, window);
            //return;
        //}
        //DatabaseUtils.cursorFillWindow(mCursor, position, window);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.595 -0400", hash_original_method = "D510FEC99A9AF46DE1EA010D6828DD6E", hash_generated_method = "0229651D09BB4291E1617725A6F82963")
    @Override
    public CursorWindow getWindow() {
        if(mCursor instanceof CrossProcessCursor)        
        {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
CursorWindow var145B41EDDB49CF863250CAC7162FAECA_632207929 =             crossProcessCursor.getWindow();
            var145B41EDDB49CF863250CAC7162FAECA_632207929.addTaint(taint);
            return var145B41EDDB49CF863250CAC7162FAECA_632207929;
        } //End block
CursorWindow var540C13E9E156B687226421B24F2DF178_553273607 =         null;
        var540C13E9E156B687226421B24F2DF178_553273607.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_553273607;
        // ---------- Original Method ----------
        //if (mCursor instanceof CrossProcessCursor) {
            //final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            //return crossProcessCursor.getWindow();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.597 -0400", hash_original_method = "1B4D2A02F9F1E4FEB130E32B375A1C19", hash_generated_method = "A08F05C7AB95AED0993A7C3609798974")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newPosition);
        addTaint(oldPosition);
        if(mCursor instanceof CrossProcessCursor)        
        {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            boolean varEF708221177168BBA29B52F42DC04C60_1603388723 = (crossProcessCursor.onMove(oldPosition, newPosition));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682626798 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682626798;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_425074917 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_112946510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_112946510;
        // ---------- Original Method ----------
        //if (mCursor instanceof CrossProcessCursor) {
            //final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            //return crossProcessCursor.onMove(oldPosition, newPosition);
        //}
        //return true;
    }

    
}

