package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public interface IBulkCursor extends IInterface  {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public CursorWindow getWindow(int startPos) throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void onMove(int position) throws RemoteException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int count() throws RemoteException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String[] getColumnNames() throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void deactivate() throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void close() throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int requery(IContentObserver observer) throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean getWantsAllOnMoveCalls() throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Bundle getExtras() throws RemoteException;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Bundle respond(Bundle extras) throws RemoteException;
    
    static final String descriptor = "android.content.IBulkCursor";

    static final int GET_CURSOR_WINDOW_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION;
    static final int COUNT_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 1;
    static final int GET_COLUMN_NAMES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 2;
    static final int DEACTIVATE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 5;
    static final int REQUERY_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 6;
    static final int ON_MOVE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 7;
    static final int WANTS_ON_MOVE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 8;
    static final int GET_EXTRAS_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 9;
    static final int RESPOND_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 10;
    static final int CLOSE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION + 11;
}
