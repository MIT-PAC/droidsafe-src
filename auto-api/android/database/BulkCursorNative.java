package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public abstract class BulkCursorNative extends Binder implements IBulkCursor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.824 -0400", hash_original_method = "DBBF6D4FB94E7243F8FE13872836805D", hash_generated_method = "49E124CE99C124C9C743BD828F75C77A")
    public  BulkCursorNative() {
        attachInterface(this, descriptor);
        // ---------- Original Method ----------
        //attachInterface(this, descriptor);
    }

    
        static public IBulkCursor asInterface(IBinder obj) {
        if (obj == null) {
            return null;
        }
        IBulkCursor in = (IBulkCursor)obj.queryLocalInterface(descriptor);
        if (in != null) {
            return in;
        }
        return new BulkCursorProxy(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.884 -0400", hash_original_method = "974E69C0AD1811D8FB0AF6277EF80D39", hash_generated_method = "9D74B3C103BFBD82C4A6FFEBBCEAA9AE")
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        try 
        {
            //Begin case GET_CURSOR_WINDOW_TRANSACTION 
            {
                data.enforceInterface(IBulkCursor.descriptor);
                int startPos;
                startPos = data.readInt();
                CursorWindow window;
                window = getWindow(startPos);
                reply.writeNoException();
                {
                    reply.writeInt(0);
                } //End block
                {
                    reply.writeInt(1);
                    window.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } //End block
            } //End block
            //End case GET_CURSOR_WINDOW_TRANSACTION 
            //Begin case COUNT_TRANSACTION 
            {
                data.enforceInterface(IBulkCursor.descriptor);
                int count;
                count = count();
                reply.writeNoException();
                reply.writeInt(count);
            } //End block
            //End case COUNT_TRANSACTION 
            //Begin case GET_COLUMN_NAMES_TRANSACTION 
            {
                data.enforceInterface(IBulkCursor.descriptor);
                String[] columnNames;
                columnNames = getColumnNames();
                reply.writeNoException();
                reply.writeInt(columnNames.length);
                int length;
                length = columnNames.length;
                {
                    int i;
                    i = 0;
                    {
                        reply.writeString(columnNames[i]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case GET_COLUMN_NAMES_TRANSACTION 
            //Begin case DEACTIVATE_TRANSACTION 
            {
                data.enforceInterface(IBulkCursor.descriptor);
                deactivate();
                reply.writeNoException();
            } //End block
            //End case DEACTIVATE_TRANSACTION 
            //Begin case CLOSE_TRANSACTION 
            {
                data.enforceInterface(IBulkCursor.descriptor);
                close();
                reply.writeNoException();
            } //End block
            //End case CLOSE_TRANSACTION 
            //Begin case REQUERY_TRANSACTION 
            {
                data.enforceInterface(IBulkCursor.descriptor);
                IContentObserver observer;
                observer = IContentObserver.Stub.asInterface(data.readStrongBinder());
                int count;
                count = requery(observer);
                reply.writeNoException();
                reply.writeInt(count);
                reply.writeBundle(getExtras());
            } //End block
            //End case REQUERY_TRANSACTION 
            //Begin case ON_MOVE_TRANSACTION 
            {
                data.enforceInterface(IBulkCursor.descriptor);
                int position;
                position = data.readInt();
                onMove(position);
                reply.writeNoException();
            } //End block
            //End case ON_MOVE_TRANSACTION 
            //Begin case WANTS_ON_MOVE_TRANSACTION 
            {
                data.enforceInterface(IBulkCursor.descriptor);
                boolean result;
                result = getWantsAllOnMoveCalls();
                reply.writeNoException();
                reply.writeInt(result ? 1 : 0);
            } //End block
            //End case WANTS_ON_MOVE_TRANSACTION 
            //Begin case GET_EXTRAS_TRANSACTION 
            {
                data.enforceInterface(IBulkCursor.descriptor);
                Bundle extras;
                extras = getExtras();
                reply.writeNoException();
                reply.writeBundle(extras);
            } //End block
            //End case GET_EXTRAS_TRANSACTION 
            //Begin case RESPOND_TRANSACTION 
            {
                data.enforceInterface(IBulkCursor.descriptor);
                Bundle extras;
                extras = data.readBundle();
                Bundle returnExtras;
                returnExtras = respond(extras);
                reply.writeNoException();
                reply.writeBundle(returnExtras);
            } //End block
            //End case RESPOND_TRANSACTION 
        } //End block
        catch (Exception e)
        {
            DatabaseUtils.writeExceptionToParcel(reply, e);
        } //End block
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_238293997 = (super.onTransact(code, data, reply, flags));
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1477772539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1477772539;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.885 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "5791FDF0E3552E8E537AE79E6A2CF854")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_707868401 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_707868401 = this;
        varB4EAC82CA7396A68D541C85D26508E83_707868401.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_707868401;
        // ---------- Original Method ----------
        //return this;
    }

    
}

final class BulkCursorProxy implements IBulkCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.889 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.889 -0400", hash_original_field = "45F5DC4EA541ED660CFEDA0032CA356C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    private Bundle mExtras;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.891 -0400", hash_original_method = "D55E49E568C2A68373E38CCE4CBFBB39", hash_generated_method = "F4E2E7A3DCF84063D978A8615FEA3A5E")
    public  BulkCursorProxy(IBinder remote) {
        mRemote = remote;
        mExtras = null;
        // ---------- Original Method ----------
        //mRemote = remote;
        //mExtras = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.905 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "173FB6A91BC15A0AB76E0BCC1A633F8A")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_823551359 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_823551359 = mRemote;
        varB4EAC82CA7396A68D541C85D26508E83_823551359.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_823551359;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.922 -0400", hash_original_method = "7540C72731403A44B035590E58ED3901", hash_generated_method = "12816BCBA400D655A2E472E293FDD332")
    public CursorWindow getWindow(int startPos) throws RemoteException {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_1729709913 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeInt(startPos);
            mRemote.transact(GET_CURSOR_WINDOW_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            CursorWindow window;
            window = null;
            {
                boolean varE5AB1DE09562BE89A9CEF4B0E885340F_1347979500 = (reply.readInt() == 1);
                {
                    window = CursorWindow.newFromParcel(reply);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1729709913 = window;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(startPos);
        varB4EAC82CA7396A68D541C85D26508E83_1729709913.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1729709913;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IBulkCursor.descriptor);
            //data.writeInt(startPos);
            //mRemote.transact(GET_CURSOR_WINDOW_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //CursorWindow window = null;
            //if (reply.readInt() == 1) {
                //window = CursorWindow.newFromParcel(reply);
            //}
            //return window;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.929 -0400", hash_original_method = "874529548DF9EED6A9EA45E2FAC51D8E", hash_generated_method = "8010E33451ABFECA92DFCFBE4B512506")
    public void onMove(int position) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeInt(position);
            mRemote.transact(ON_MOVE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(position);
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IBulkCursor.descriptor);
            //data.writeInt(position);
            //mRemote.transact(ON_MOVE_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.943 -0400", hash_original_method = "0FF3A241CF7700F047C406946FE227F4", hash_generated_method = "0B038357D9FD9420570D3483CF372D67")
    public int count() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            boolean result;
            result = mRemote.transact(COUNT_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count;
            {
                count = -1;
            } //End block
            {
                count = reply.readInt();
            } //End block
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535648202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535648202;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IBulkCursor.descriptor);
            //boolean result = mRemote.transact(COUNT_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //int count;
            //if (result == false) {
                //count = -1;
            //} else {
                //count = reply.readInt();
            //}
            //return count;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.963 -0400", hash_original_method = "55D53D666D124D26189F4C995847EE3B", hash_generated_method = "8150B0C1D532C982629BB42903E0B620")
    public String[] getColumnNames() throws RemoteException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_51835949 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            mRemote.transact(GET_COLUMN_NAMES_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            String[] columnNames;
            columnNames = null;
            int numColumns;
            numColumns = reply.readInt();
            columnNames = new String[numColumns];
            {
                int i;
                i = 0;
                {
                    columnNames[i] = reply.readString();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_51835949 = columnNames;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_51835949.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_51835949;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IBulkCursor.descriptor);
            //mRemote.transact(GET_COLUMN_NAMES_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //String[] columnNames = null;
            //int numColumns = reply.readInt();
            //columnNames = new String[numColumns];
            //for (int i = 0; i < numColumns; i++) {
                //columnNames[i] = reply.readString();
            //}
            //return columnNames;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.970 -0400", hash_original_method = "FD5E9EEC36BE8B65B5A00AF714CC54E0", hash_generated_method = "CDAFF3ED5790FA0038070B1C60526E4F")
    public void deactivate() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            mRemote.transact(DEACTIVATE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IBulkCursor.descriptor);
            //mRemote.transact(DEACTIVATE_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.985 -0400", hash_original_method = "C12FD550BDAC8145B3664A864E5B60A0", hash_generated_method = "89AC4AD4697E47D38008003C3F93C60F")
    public void close() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            mRemote.transact(CLOSE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IBulkCursor.descriptor);
            //mRemote.transact(CLOSE_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.988 -0400", hash_original_method = "1C7F55EE59A84877DC54C93F1BEC1640", hash_generated_method = "CC574D8446A5C652E05F3B4ECDC6346E")
    public int requery(IContentObserver observer) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeStrongInterface(observer);
            boolean result;
            result = mRemote.transact(REQUERY_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count;
            {
                count = -1;
            } //End block
            {
                count = reply.readInt();
                mExtras = reply.readBundle();
            } //End block
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(observer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692988175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692988175;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IBulkCursor.descriptor);
            //data.writeStrongInterface(observer);
            //boolean result = mRemote.transact(REQUERY_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //int count;
            //if (!result) {
                //count = -1;
            //} else {
                //count = reply.readInt();
                //mExtras = reply.readBundle();
            //}
            //return count;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.002 -0400", hash_original_method = "A152C23C891E00FCA22CAEB49B705CFA", hash_generated_method = "675BC72D11D2B926A1187DCD9A751BB0")
    public boolean getWantsAllOnMoveCalls() throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            mRemote.transact(WANTS_ON_MOVE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int result;
            result = reply.readInt();
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221343503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_221343503;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IBulkCursor.descriptor);
            //mRemote.transact(WANTS_ON_MOVE_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //int result = reply.readInt();
            //return result != 0;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.019 -0400", hash_original_method = "0BFE1C1B4E3A75686DCBF1FFC3B2E52B", hash_generated_method = "88B428284A79AE4FC8D267DA75ED407E")
    public Bundle getExtras() throws RemoteException {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_804703420 = null; //Variable for return #1
        {
            Parcel data;
            data = Parcel.obtain();
            Parcel reply;
            reply = Parcel.obtain();
            try 
            {
                data.writeInterfaceToken(IBulkCursor.descriptor);
                mRemote.transact(GET_EXTRAS_TRANSACTION, data, reply, 0);
                DatabaseUtils.readExceptionFromParcel(reply);
                mExtras = reply.readBundle();
            } //End block
            finally 
            {
                data.recycle();
                reply.recycle();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_804703420 = mExtras;
        varB4EAC82CA7396A68D541C85D26508E83_804703420.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_804703420;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //Parcel data = Parcel.obtain();
            //Parcel reply = Parcel.obtain();
            //try {
                //data.writeInterfaceToken(IBulkCursor.descriptor);
                //mRemote.transact(GET_EXTRAS_TRANSACTION, data, reply, 0);
                //DatabaseUtils.readExceptionFromParcel(reply);
                //mExtras = reply.readBundle();
            //} finally {
                //data.recycle();
                //reply.recycle();
            //}
        //}
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.022 -0400", hash_original_method = "482AF4EBF0254C22A07B37919043D33E", hash_generated_method = "1E1DEAC9C9A8233F8F693283AFF35B35")
    public Bundle respond(Bundle extras) throws RemoteException {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_826069644 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeBundle(extras);
            mRemote.transact(RESPOND_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            Bundle returnExtras;
            returnExtras = reply.readBundle();
            varB4EAC82CA7396A68D541C85D26508E83_826069644 = returnExtras;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_826069644.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_826069644;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //try {
            //data.writeInterfaceToken(IBulkCursor.descriptor);
            //data.writeBundle(extras);
            //mRemote.transact(RESPOND_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //Bundle returnExtras = reply.readBundle();
            //return returnExtras;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
}

