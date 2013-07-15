package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public interface IBulkCursor extends IInterface  {
    
    public CursorWindow getWindow(int startPos) throws RemoteException;

    public void onMove(int position) throws RemoteException;

    
    public int count() throws RemoteException;

    
    public String[] getColumnNames() throws RemoteException;

    public void deactivate() throws RemoteException;

    public void close() throws RemoteException;

    public int requery(IContentObserver observer) throws RemoteException;

    boolean getWantsAllOnMoveCalls() throws RemoteException;

    Bundle getExtras() throws RemoteException;

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
