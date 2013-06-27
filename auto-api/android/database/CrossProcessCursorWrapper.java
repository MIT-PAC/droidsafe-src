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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.056 -0400", hash_original_method = "5197A5F113F85D854415B2B6533E1F8C", hash_generated_method = "EDB046CFA4E85D633587267A6A7E6D56")
    public  CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
        addTaint(cursor.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.070 -0400", hash_original_method = "8AFBAB5134F9C202EA9293756DDD55DE", hash_generated_method = "4423D0544751D524792AD5B38C27F305")
    @Override
    public void fillWindow(int position, CursorWindow window) {
        {
            CrossProcessCursor crossProcessCursor;
            crossProcessCursor = (CrossProcessCursor)mCursor;
            crossProcessCursor.fillWindow(position, window);
        } //End block
        DatabaseUtils.cursorFillWindow(mCursor, position, window);
        addTaint(position);
        addTaint(window.getTaint());
        // ---------- Original Method ----------
        //if (mCursor instanceof CrossProcessCursor) {
            //final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            //crossProcessCursor.fillWindow(position, window);
            //return;
        //}
        //DatabaseUtils.cursorFillWindow(mCursor, position, window);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.071 -0400", hash_original_method = "D510FEC99A9AF46DE1EA010D6828DD6E", hash_generated_method = "9FC0C6361006C4C074AEEF417EEF5656")
    @Override
    public CursorWindow getWindow() {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_1197166197 = null; //Variable for return #1
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_2113091458 = null; //Variable for return #2
        {
            CrossProcessCursor crossProcessCursor;
            crossProcessCursor = (CrossProcessCursor)mCursor;
            varB4EAC82CA7396A68D541C85D26508E83_1197166197 = crossProcessCursor.getWindow();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2113091458 = null;
        CursorWindow varA7E53CE21691AB073D9660D615818899_1123388801; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1123388801 = varB4EAC82CA7396A68D541C85D26508E83_1197166197;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1123388801 = varB4EAC82CA7396A68D541C85D26508E83_2113091458;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1123388801.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1123388801;
        // ---------- Original Method ----------
        //if (mCursor instanceof CrossProcessCursor) {
            //final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            //return crossProcessCursor.getWindow();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.085 -0400", hash_original_method = "1B4D2A02F9F1E4FEB130E32B375A1C19", hash_generated_method = "292C1E8BCAEF1E09DBBE0D50BB52DE66")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            CrossProcessCursor crossProcessCursor;
            crossProcessCursor = (CrossProcessCursor)mCursor;
            boolean varD68ED0BE77919A2B3EEA3DA50DCFE388_1393153507 = (crossProcessCursor.onMove(oldPosition, newPosition));
        } //End block
        addTaint(oldPosition);
        addTaint(newPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_410877159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_410877159;
        // ---------- Original Method ----------
        //if (mCursor instanceof CrossProcessCursor) {
            //final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            //return crossProcessCursor.onMove(oldPosition, newPosition);
        //}
        //return true;
    }

    
}

