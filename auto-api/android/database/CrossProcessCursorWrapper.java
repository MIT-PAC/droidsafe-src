package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.691 -0400", hash_original_method = "5197A5F113F85D854415B2B6533E1F8C", hash_generated_method = "EDB046CFA4E85D633587267A6A7E6D56")
    public  CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
        addTaint(cursor.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.691 -0400", hash_original_method = "8AFBAB5134F9C202EA9293756DDD55DE", hash_generated_method = "9DC79D44322A223CA44380DEC861C8CE")
    @Override
    public void fillWindow(int position, CursorWindow window) {
        {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            crossProcessCursor.fillWindow(position, window);
        } 
        DatabaseUtils.cursorFillWindow(mCursor, position, window);
        addTaint(position);
        addTaint(window.getTaint());
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.692 -0400", hash_original_method = "D510FEC99A9AF46DE1EA010D6828DD6E", hash_generated_method = "2599C3BC05920E423B0F803E31862040")
    @Override
    public CursorWindow getWindow() {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_1953608110 = null; 
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_903737023 = null; 
        {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            varB4EAC82CA7396A68D541C85D26508E83_1953608110 = crossProcessCursor.getWindow();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_903737023 = null;
        CursorWindow varA7E53CE21691AB073D9660D615818899_1353289662; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1353289662 = varB4EAC82CA7396A68D541C85D26508E83_1953608110;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1353289662 = varB4EAC82CA7396A68D541C85D26508E83_903737023;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1353289662.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1353289662;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.693 -0400", hash_original_method = "1B4D2A02F9F1E4FEB130E32B375A1C19", hash_generated_method = "4E54B0346514D41432A4E963243FB6E8")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        
        {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            boolean varD68ED0BE77919A2B3EEA3DA50DCFE388_1606972566 = (crossProcessCursor.onMove(oldPosition, newPosition));
        } 
        addTaint(oldPosition);
        addTaint(newPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_279402790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_279402790;
        
        
            
            
        
        
    }

    
}

