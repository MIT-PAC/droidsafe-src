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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.878 -0400", hash_original_method = "DBBF6D4FB94E7243F8FE13872836805D", hash_generated_method = "49E124CE99C124C9C743BD828F75C77A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BulkCursorNative() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.880 -0400", hash_original_method = "974E69C0AD1811D8FB0AF6277EF80D39", hash_generated_method = "8B4EC2A890BCC4F3052F3CDCF599658B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(flags);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(reply.dsTaint);
        dsTaint.addTaint(code);
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
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_1805517518 = (super.onTransact(code, data, reply, flags));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.880 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "1992535F0C7EB8757F965477F5292EC0")
    @DSModeled(DSC.SAFE)
    public IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
}

final class BulkCursorProxy implements IBulkCursor {
    private IBinder mRemote;
    private Bundle mExtras;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.881 -0400", hash_original_method = "D55E49E568C2A68373E38CCE4CBFBB39", hash_generated_method = "4CD313E3D7158D5FAE82B39C4042DA46")
    @DSModeled(DSC.SAFE)
    public BulkCursorProxy(IBinder remote) {
        dsTaint.addTaint(remote.dsTaint);
        mExtras = null;
        // ---------- Original Method ----------
        //mRemote = remote;
        //mExtras = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.881 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "DD6FDB77557F0A5920AFCE061E8D4085")
    @DSModeled(DSC.SAFE)
    public IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.881 -0400", hash_original_method = "7540C72731403A44B035590E58ED3901", hash_generated_method = "32D79DBDDF49B36EF300DAC5DBEC6F7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CursorWindow getWindow(int startPos) throws RemoteException {
        dsTaint.addTaint(startPos);
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
                boolean varE5AB1DE09562BE89A9CEF4B0E885340F_1385018455 = (reply.readInt() == 1);
                {
                    window = CursorWindow.newFromParcel(reply);
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        return (CursorWindow)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.882 -0400", hash_original_method = "874529548DF9EED6A9EA45E2FAC51D8E", hash_generated_method = "9D224631750C674955BF80608BD5CCC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onMove(int position) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(position);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.882 -0400", hash_original_method = "0FF3A241CF7700F047C406946FE227F4", hash_generated_method = "88B650FC2EA998CE8E039F39907A4CBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.883 -0400", hash_original_method = "55D53D666D124D26189F4C995847EE3B", hash_generated_method = "0A3269757865CDD8BAD7673CBBAC00F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getColumnNames() throws RemoteException {
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
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.884 -0400", hash_original_method = "FD5E9EEC36BE8B65B5A00AF714CC54E0", hash_generated_method = "CDAFF3ED5790FA0038070B1C60526E4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.884 -0400", hash_original_method = "C12FD550BDAC8145B3664A864E5B60A0", hash_generated_method = "89AC4AD4697E47D38008003C3F93C60F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.885 -0400", hash_original_method = "1C7F55EE59A84877DC54C93F1BEC1640", hash_generated_method = "716805CE7D177483A4534561BE597A54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int requery(IContentObserver observer) throws RemoteException {
        dsTaint.addTaint(observer.dsTaint);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.885 -0400", hash_original_method = "A152C23C891E00FCA22CAEB49B705CFA", hash_generated_method = "BE6E47F7EB3074394F85685C7AA68C08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.886 -0400", hash_original_method = "0BFE1C1B4E3A75686DCBF1FFC3B2E52B", hash_generated_method = "246BE69D3F023C68B2C5495AF22B4530")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle getExtras() throws RemoteException {
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
        return (Bundle)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.896 -0400", hash_original_method = "482AF4EBF0254C22A07B37919043D33E", hash_generated_method = "30C7C5F8F5824A1B9A8C07C1B9B9F20C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle respond(Bundle extras) throws RemoteException {
        dsTaint.addTaint(extras.dsTaint);
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
        } //End block
        finally 
        {
            data.recycle();
            reply.recycle();
        } //End block
        return (Bundle)dsTaint.getTaint();
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

