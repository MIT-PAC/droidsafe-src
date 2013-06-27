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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.584 -0400", hash_original_method = "DBBF6D4FB94E7243F8FE13872836805D", hash_generated_method = "49E124CE99C124C9C743BD828F75C77A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.630 -0400", hash_original_method = "974E69C0AD1811D8FB0AF6277EF80D39", hash_generated_method = "215E9DF1A7DDAD3AB9FD2544FC87E6A7")
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
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_1284530705 = (super.onTransact(code, data, reply, flags));
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717854682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_717854682;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.645 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "6AFF6BB6D3914CC4DA3FEFFE0A3C058F")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1142708907 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1142708907 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1142708907.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1142708907;
        // ---------- Original Method ----------
        //return this;
    }

    
}

final class BulkCursorProxy implements IBulkCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.646 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.646 -0400", hash_original_field = "45F5DC4EA541ED660CFEDA0032CA356C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    private Bundle mExtras;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.657 -0400", hash_original_method = "D55E49E568C2A68373E38CCE4CBFBB39", hash_generated_method = "F4E2E7A3DCF84063D978A8615FEA3A5E")
    public  BulkCursorProxy(IBinder remote) {
        mRemote = remote;
        mExtras = null;
        // ---------- Original Method ----------
        //mRemote = remote;
        //mExtras = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.658 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "0C3EB2A5344EA509419B6811133E52D7")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1709433837 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1709433837 = mRemote;
        varB4EAC82CA7396A68D541C85D26508E83_1709433837.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1709433837;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.670 -0400", hash_original_method = "7540C72731403A44B035590E58ED3901", hash_generated_method = "19092129625A6FD85BFD9EA8E9788CD2")
    public CursorWindow getWindow(int startPos) throws RemoteException {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_1176992616 = null; //Variable for return #1
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
                boolean varE5AB1DE09562BE89A9CEF4B0E885340F_1439781072 = (reply.readInt() == 1);
                {
                    window = CursorWindow.newFromParcel(reply);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1176992616 = window;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(startPos);
        varB4EAC82CA7396A68D541C85D26508E83_1176992616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1176992616;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.683 -0400", hash_original_method = "874529548DF9EED6A9EA45E2FAC51D8E", hash_generated_method = "8010E33451ABFECA92DFCFBE4B512506")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.705 -0400", hash_original_method = "0FF3A241CF7700F047C406946FE227F4", hash_generated_method = "C8BFE41224A6B0DD87F04634A749259E")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810740984 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_810740984;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.720 -0400", hash_original_method = "55D53D666D124D26189F4C995847EE3B", hash_generated_method = "5B939BD4B93D09D6DFFD9A4106141A2E")
    public String[] getColumnNames() throws RemoteException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2014690410 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_2014690410 = columnNames;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2014690410.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2014690410;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.738 -0400", hash_original_method = "FD5E9EEC36BE8B65B5A00AF714CC54E0", hash_generated_method = "CDAFF3ED5790FA0038070B1C60526E4F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.749 -0400", hash_original_method = "C12FD550BDAC8145B3664A864E5B60A0", hash_generated_method = "89AC4AD4697E47D38008003C3F93C60F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.752 -0400", hash_original_method = "1C7F55EE59A84877DC54C93F1BEC1640", hash_generated_method = "F220E4376271DC38ABE55BA50D7236B9")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052077246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052077246;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.770 -0400", hash_original_method = "A152C23C891E00FCA22CAEB49B705CFA", hash_generated_method = "2D9BF9C636BC8900D9AB1637D040DD7A")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1674411348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1674411348;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.772 -0400", hash_original_method = "0BFE1C1B4E3A75686DCBF1FFC3B2E52B", hash_generated_method = "50F0668BF503DA98F48FDA2CE602F033")
    public Bundle getExtras() throws RemoteException {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_573523845 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_573523845 = mExtras;
        varB4EAC82CA7396A68D541C85D26508E83_573523845.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_573523845;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.791 -0400", hash_original_method = "482AF4EBF0254C22A07B37919043D33E", hash_generated_method = "8BAA2EFD8DA7E5A59F38D384FB33DBFA")
    public Bundle respond(Bundle extras) throws RemoteException {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1721096612 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1721096612 = returnExtras;
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1721096612.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1721096612;
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

