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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.818 -0400", hash_original_method = "5197A5F113F85D854415B2B6533E1F8C", hash_generated_method = "EDB046CFA4E85D633587267A6A7E6D56")
    public  CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
        addTaint(cursor.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.832 -0400", hash_original_method = "8AFBAB5134F9C202EA9293756DDD55DE", hash_generated_method = "4423D0544751D524792AD5B38C27F305")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.833 -0400", hash_original_method = "D510FEC99A9AF46DE1EA010D6828DD6E", hash_generated_method = "67D2EF078FEF879AE4CC19FBEE239A34")
    @Override
    public CursorWindow getWindow() {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_980008158 = null; //Variable for return #1
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_691496454 = null; //Variable for return #2
        {
            CrossProcessCursor crossProcessCursor;
            crossProcessCursor = (CrossProcessCursor)mCursor;
            varB4EAC82CA7396A68D541C85D26508E83_980008158 = crossProcessCursor.getWindow();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_691496454 = null;
        CursorWindow varA7E53CE21691AB073D9660D615818899_1448927978; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1448927978 = varB4EAC82CA7396A68D541C85D26508E83_980008158;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1448927978 = varB4EAC82CA7396A68D541C85D26508E83_691496454;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1448927978.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1448927978;
        // ---------- Original Method ----------
        //if (mCursor instanceof CrossProcessCursor) {
            //final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            //return crossProcessCursor.getWindow();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.842 -0400", hash_original_method = "1B4D2A02F9F1E4FEB130E32B375A1C19", hash_generated_method = "6BD9DFB32662DFE707784FD22F4A8D47")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            CrossProcessCursor crossProcessCursor;
            crossProcessCursor = (CrossProcessCursor)mCursor;
            boolean varD68ED0BE77919A2B3EEA3DA50DCFE388_813441934 = (crossProcessCursor.onMove(oldPosition, newPosition));
        } //End block
        addTaint(oldPosition);
        addTaint(newPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1907387868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1907387868;
        // ---------- Original Method ----------
        //if (mCursor instanceof CrossProcessCursor) {
            //final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            //return crossProcessCursor.onMove(oldPosition, newPosition);
        //}
        //return true;
    }

    
}

