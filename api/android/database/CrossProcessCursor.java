package android.database;

// Droidsafe Imports

public interface CrossProcessCursor extends Cursor {
    
    CursorWindow getWindow();

    
    void fillWindow(int position, CursorWindow window);

    
    boolean onMove(int oldPosition, int newPosition); 
}
