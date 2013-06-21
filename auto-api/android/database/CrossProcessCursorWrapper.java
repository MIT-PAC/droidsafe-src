package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.977 -0400", hash_original_method = "5197A5F113F85D854415B2B6533E1F8C", hash_generated_method = "3C61B721B198120CC41FD929FE8FE6B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
        dsTaint.addTaint(cursor.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.978 -0400", hash_original_method = "8AFBAB5134F9C202EA9293756DDD55DE", hash_generated_method = "819006045BDBCFC53B4A7FF594CF2D26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void fillWindow(int position, CursorWindow window) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(window.dsTaint);
        {
            CrossProcessCursor crossProcessCursor;
            crossProcessCursor = (CrossProcessCursor)mCursor;
            crossProcessCursor.fillWindow(position, window);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.978 -0400", hash_original_method = "D510FEC99A9AF46DE1EA010D6828DD6E", hash_generated_method = "29A71263E8742FBCAF56F9A88A4E003A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CursorWindow getWindow() {
        {
            CrossProcessCursor crossProcessCursor;
            crossProcessCursor = (CrossProcessCursor)mCursor;
            CursorWindow var22E38C5519EAA0E428419E008B3FEAA7_237247346 = (crossProcessCursor.getWindow());
        } //End block
        return (CursorWindow)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mCursor instanceof CrossProcessCursor) {
            //final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            //return crossProcessCursor.getWindow();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.978 -0400", hash_original_method = "1B4D2A02F9F1E4FEB130E32B375A1C19", hash_generated_method = "B12F456DBAA1CF3526B237A17A83E635")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newPosition);
        dsTaint.addTaint(oldPosition);
        {
            CrossProcessCursor crossProcessCursor;
            crossProcessCursor = (CrossProcessCursor)mCursor;
            boolean varD68ED0BE77919A2B3EEA3DA50DCFE388_1437638946 = (crossProcessCursor.onMove(oldPosition, newPosition));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mCursor instanceof CrossProcessCursor) {
            //final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            //return crossProcessCursor.onMove(oldPosition, newPosition);
        //}
        //return true;
    }

    
}

