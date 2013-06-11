package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface CrossProcessCursor extends Cursor {
    
    CursorWindow getWindow();

    
    void fillWindow(int position, CursorWindow window);

    
    boolean onMove(int oldPosition, int newPosition); 
}

