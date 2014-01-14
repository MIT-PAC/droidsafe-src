package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public abstract class BulkCursorNative extends Binder implements IBulkCursor {

    /**
     * Cast a Binder object into a content resolver interface, generating
     * a proxy if needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.536 -0500", hash_original_method = "C54B271CE44B8B3CA02F34CEBF170328", hash_generated_method = "1D619AF2715A1536034540225DAE3B98")
    
static public IBulkCursor asInterface(IBinder obj)
    {
        if (obj == null) {
            return null;
        }
        IBulkCursor in = (IBulkCursor)obj.queryLocalInterface(descriptor);
        if (in != null) {
            return in;
        }

        return new BulkCursorProxy(obj);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.533 -0500", hash_original_method = "DBBF6D4FB94E7243F8FE13872836805D", hash_generated_method = "50CCF7129DEBE42BE14A842ECF8748F8")
    
public BulkCursorNative()
    {
        attachInterface(this, descriptor);
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.541 -0500", hash_original_method = "974E69C0AD1811D8FB0AF6277EF80D39", hash_generated_method = "44B1EE5FABD9FB2B1CCC833898555361")
    
@Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
            throws RemoteException {
        try {
            switch (code) {
                case GET_CURSOR_WINDOW_TRANSACTION: {
                    data.enforceInterface(IBulkCursor.descriptor);
                    int startPos = data.readInt();
                    CursorWindow window = getWindow(startPos);
                    reply.writeNoException();
                    if (window == null) {
                        reply.writeInt(0);
                    } else {
                        reply.writeInt(1);
                        window.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    }
                    return true;
                }

                case COUNT_TRANSACTION: {
                    data.enforceInterface(IBulkCursor.descriptor);
                    int count = count();
                    reply.writeNoException();
                    reply.writeInt(count);
                    return true;
                }

                case GET_COLUMN_NAMES_TRANSACTION: {
                    data.enforceInterface(IBulkCursor.descriptor);
                    String[] columnNames = getColumnNames();
                    reply.writeNoException();
                    reply.writeInt(columnNames.length);
                    int length = columnNames.length;
                    for (int i = 0; i < length; i++) {
                        reply.writeString(columnNames[i]);
                    }
                    return true;
                }

                case DEACTIVATE_TRANSACTION: {
                    data.enforceInterface(IBulkCursor.descriptor);
                    deactivate();
                    reply.writeNoException();
                    return true;
                }
                
                case CLOSE_TRANSACTION: {
                    data.enforceInterface(IBulkCursor.descriptor);
                    close();
                    reply.writeNoException();
                    return true;
                }

                case REQUERY_TRANSACTION: {
                    data.enforceInterface(IBulkCursor.descriptor);
                    IContentObserver observer =
                            IContentObserver.Stub.asInterface(data.readStrongBinder());
                    int count = requery(observer);
                    reply.writeNoException();
                    reply.writeInt(count);
                    reply.writeBundle(getExtras());
                    return true;
                }

                case ON_MOVE_TRANSACTION: {
                    data.enforceInterface(IBulkCursor.descriptor);
                    int position = data.readInt();
                    onMove(position);
                    reply.writeNoException();
                    return true;
                }

                case WANTS_ON_MOVE_TRANSACTION: {
                    data.enforceInterface(IBulkCursor.descriptor);
                    boolean result = getWantsAllOnMoveCalls();
                    reply.writeNoException();
                    reply.writeInt(result ? 1 : 0);
                    return true;
                }

                case GET_EXTRAS_TRANSACTION: {
                    data.enforceInterface(IBulkCursor.descriptor);
                    Bundle extras = getExtras();
                    reply.writeNoException();
                    reply.writeBundle(extras);
                    return true;
                }

                case RESPOND_TRANSACTION: {
                    data.enforceInterface(IBulkCursor.descriptor);
                    Bundle extras = data.readBundle();
                    Bundle returnExtras = respond(extras);
                    reply.writeNoException();
                    reply.writeBundle(returnExtras);
                    return true;
                }
            }
        } catch (Exception e) {
            DatabaseUtils.writeExceptionToParcel(reply, e);
            return true;
        }

        return super.onTransact(code, data, reply, flags);
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.543 -0500", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "5E3B69CCD103133228ACADBBDEF1CE7E")
    
public IBinder asBinder()
    {
        return this;
    }
    
}

final class BulkCursorProxy implements IBulkCursor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.546 -0500", hash_original_field = "5AE257E0853836D9B54E1EF6497B909F", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.548 -0500", hash_original_field = "8E33C9E28D87B1286C4160446ABF7B5C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    private Bundle mExtras;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.551 -0500", hash_original_method = "D55E49E568C2A68373E38CCE4CBFBB39", hash_generated_method = "4C6435B3F41CD6A1BEB41F8858E76A61")
    
public BulkCursorProxy(IBinder remote)
    {
        mRemote = remote;
        mExtras = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.553 -0500", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "4DCC3A1AD60EC3BEEFB87DCA83743448")
    
public IBinder asBinder()
    {
        return mRemote;
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.556 -0500", hash_original_method = "7540C72731403A44B035590E58ED3901", hash_generated_method = "EA78ADB97DFC3B522B8A78141E40B1BC")
    
public CursorWindow getWindow(int startPos) throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeInt(startPos);

            mRemote.transact(GET_CURSOR_WINDOW_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);

            CursorWindow window = null;
            if (reply.readInt() == 1) {
                window = CursorWindow.newFromParcel(reply);
            }
            return window;
        } finally {
            data.recycle();
            reply.recycle();
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.559 -0500", hash_original_method = "874529548DF9EED6A9EA45E2FAC51D8E", hash_generated_method = "2B91D016CC7D59F3D4E24662B92CAD90")
    
public void onMove(int position) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeInt(position);

            mRemote.transact(ON_MOVE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
        } finally {
            data.recycle();
            reply.recycle();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.561 -0500", hash_original_method = "0FF3A241CF7700F047C406946FE227F4", hash_generated_method = "E9FDB8182FE9955825F9884EDCF6EA7C")
    
public int count() throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken(IBulkCursor.descriptor);

            boolean result = mRemote.transact(COUNT_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);

            int count;
            if (result == false) {
                count = -1;
            } else {
                count = reply.readInt();
            }
            return count;
        } finally {
            data.recycle();
            reply.recycle();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.564 -0500", hash_original_method = "55D53D666D124D26189F4C995847EE3B", hash_generated_method = "73215A2094BBFC88A1DED3BDDBA0B6B8")
    
public String[] getColumnNames() throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken(IBulkCursor.descriptor);

            mRemote.transact(GET_COLUMN_NAMES_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);

            String[] columnNames = null;
            int numColumns = reply.readInt();
            columnNames = new String[numColumns];
            for (int i = 0; i < numColumns; i++) {
                columnNames[i] = reply.readString();
            }
            return columnNames;
        } finally {
            data.recycle();
            reply.recycle();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.567 -0500", hash_original_method = "FD5E9EEC36BE8B65B5A00AF714CC54E0", hash_generated_method = "7C29F510C93EE22F95C7E4ADFC92ECB7")
    
public void deactivate() throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken(IBulkCursor.descriptor);

            mRemote.transact(DEACTIVATE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
        } finally {
            data.recycle();
            reply.recycle();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.569 -0500", hash_original_method = "C12FD550BDAC8145B3664A864E5B60A0", hash_generated_method = "C1A58BF67AE58BAE68468DE633C4FFF1")
    
public void close() throws RemoteException
    {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken(IBulkCursor.descriptor);

            mRemote.transact(CLOSE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
        } finally {
            data.recycle();
            reply.recycle();
        }
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.572 -0500", hash_original_method = "1C7F55EE59A84877DC54C93F1BEC1640", hash_generated_method = "0B3B0CAAE1F340B6EED5FBD38F88B290")
    
public int requery(IContentObserver observer) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeStrongInterface(observer);

            boolean result = mRemote.transact(REQUERY_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);

            int count;
            if (!result) {
                count = -1;
            } else {
                count = reply.readInt();
                mExtras = reply.readBundle();
            }
            return count;
        } finally {
            data.recycle();
            reply.recycle();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.574 -0500", hash_original_method = "A152C23C891E00FCA22CAEB49B705CFA", hash_generated_method = "08FE55F28BBA6423B34740AD73DB2749")
    
public boolean getWantsAllOnMoveCalls() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken(IBulkCursor.descriptor);

            mRemote.transact(WANTS_ON_MOVE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);

            int result = reply.readInt();
            return result != 0;
        } finally {
            data.recycle();
            reply.recycle();
        }
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.576 -0500", hash_original_method = "0BFE1C1B4E3A75686DCBF1FFC3B2E52B", hash_generated_method = "8534442E1A57371CEB797D84E718FD6F")
    
public Bundle getExtras() throws RemoteException {
        if (mExtras == null) {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(IBulkCursor.descriptor);

                mRemote.transact(GET_EXTRAS_TRANSACTION, data, reply, 0);
                DatabaseUtils.readExceptionFromParcel(reply);

                mExtras = reply.readBundle();
            } finally {
                data.recycle();
                reply.recycle();
            }
        }
        return mExtras;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:37.579 -0500", hash_original_method = "482AF4EBF0254C22A07B37919043D33E", hash_generated_method = "6120D436D6E46640E40F529D865E95F5")
    
public Bundle respond(Bundle extras) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeBundle(extras);

            mRemote.transact(RESPOND_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);

            Bundle returnExtras = reply.readBundle();
            return returnExtras;
        } finally {
            data.recycle();
            reply.recycle();
        }
    }
    
}

