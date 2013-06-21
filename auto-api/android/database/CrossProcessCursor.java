package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface CrossProcessCursor extends Cursor {
    
    CursorWindow getWindow();

    
    void fillWindow(int position, CursorWindow window);

    
    boolean onMove(int oldPosition, int newPosition); 
}
