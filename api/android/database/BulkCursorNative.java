package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public abstract class BulkCursorNative extends Binder implements IBulkCursor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.474 -0400", hash_original_method = "DBBF6D4FB94E7243F8FE13872836805D", hash_generated_method = "49E124CE99C124C9C743BD828F75C77A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.476 -0400", hash_original_method = "974E69C0AD1811D8FB0AF6277EF80D39", hash_generated_method = "1E9077DD4B7AB7DF16E9076DE1E8612E")
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(flags);
        addTaint(reply.getTaint());
        addTaint(data.getTaint());
        addTaint(code);
        try 
        {
switch(code){
            case GET_CURSOR_WINDOW_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                int startPos = data.readInt();
                CursorWindow window = getWindow(startPos);
                reply.writeNoException();
                if(window == null)                
                {
                    reply.writeInt(0);
                } //End block
                else
                {
                    reply.writeInt(1);
                    window.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_2048051987 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1530859521 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1530859521;
            } //End block
            case COUNT_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                int count = count();
                reply.writeNoException();
                reply.writeInt(count);
                boolean varB326B5062B2F0E69046810717534CB09_1434212836 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_317863565 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_317863565;
            } //End block
            case GET_COLUMN_NAMES_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                String[] columnNames = getColumnNames();
                reply.writeNoException();
                reply.writeInt(columnNames.length);
                int length = columnNames.length;
for(int i = 0;i < length;i++)
                {
                    reply.writeString(columnNames[i]);
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_2001164614 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1545792215 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1545792215;
            } //End block
            case DEACTIVATE_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                deactivate();
                reply.writeNoException();
                boolean varB326B5062B2F0E69046810717534CB09_1145752281 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1156705158 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1156705158;
            } //End block
            case CLOSE_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                close();
                reply.writeNoException();
                boolean varB326B5062B2F0E69046810717534CB09_578616050 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852814559 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852814559;
            } //End block
            case REQUERY_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                IContentObserver observer = IContentObserver.Stub.asInterface(data.readStrongBinder());
                int count = requery(observer);
                reply.writeNoException();
                reply.writeInt(count);
                reply.writeBundle(getExtras());
                boolean varB326B5062B2F0E69046810717534CB09_1537518960 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182300096 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182300096;
            } //End block
            case ON_MOVE_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                int position = data.readInt();
                onMove(position);
                reply.writeNoException();
                boolean varB326B5062B2F0E69046810717534CB09_743937510 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677284866 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677284866;
            } //End block
            case WANTS_ON_MOVE_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                boolean result = getWantsAllOnMoveCalls();
                reply.writeNoException();
                reply.writeInt(result ? 1 : 0);
                boolean varB326B5062B2F0E69046810717534CB09_1650015080 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826097648 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_826097648;
            } //End block
            case GET_EXTRAS_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                Bundle extras = getExtras();
                reply.writeNoException();
                reply.writeBundle(extras);
                boolean varB326B5062B2F0E69046810717534CB09_995351594 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1836827936 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1836827936;
            } //End block
            case RESPOND_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                Bundle extras = data.readBundle();
                Bundle returnExtras = respond(extras);
                reply.writeNoException();
                reply.writeBundle(returnExtras);
                boolean varB326B5062B2F0E69046810717534CB09_1160322862 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_228146012 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_228146012;
            } //End block
}
        } //End block
        catch (Exception e)
        {
            DatabaseUtils.writeExceptionToParcel(reply, e);
            boolean varB326B5062B2F0E69046810717534CB09_1634876947 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_417347661 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_417347661;
        } //End block
        boolean var3B3A841664B2F7D5B8C0C4B7B8E31E3B_2090652835 = (super.onTransact(code, data, reply, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073565823 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073565823;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.478 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "98BFC6F0283ADC16A7FA9AF6731C4F1E")
    public IBinder asBinder() {
IBinder var72A74007B2BE62B849F475C7BDA4658B_1449447870 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1449447870.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1449447870;
        // ---------- Original Method ----------
        //return this;
    }

    
}

final class BulkCursorProxy implements IBulkCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.478 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.478 -0400", hash_original_field = "45F5DC4EA541ED660CFEDA0032CA356C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    private Bundle mExtras;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.479 -0400", hash_original_method = "D55E49E568C2A68373E38CCE4CBFBB39", hash_generated_method = "F4E2E7A3DCF84063D978A8615FEA3A5E")
    public  BulkCursorProxy(IBinder remote) {
        mRemote = remote;
        mExtras = null;
        // ---------- Original Method ----------
        //mRemote = remote;
        //mExtras = null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.480 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "141ACE0FA3B24542A5BFF9FE4DE54200")
    public IBinder asBinder() {
IBinder varF4936CA84F7841A48B466C9D273BE2EB_406247651 =         mRemote;
        varF4936CA84F7841A48B466C9D273BE2EB_406247651.addTaint(taint);
        return varF4936CA84F7841A48B466C9D273BE2EB_406247651;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.481 -0400", hash_original_method = "7540C72731403A44B035590E58ED3901", hash_generated_method = "975DD6B57F8A49C7BF0F92CE4D4A26F1")
    public CursorWindow getWindow(int startPos) throws RemoteException {
        addTaint(startPos);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeInt(startPos);
            mRemote.transact(GET_CURSOR_WINDOW_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            CursorWindow window = null;
            if(reply.readInt() == 1)            
            {
                window = CursorWindow.newFromParcel(reply);
            } //End block
CursorWindow var414B2CEBDF7E679ADF378DBBAB956EC0_1737347589 =             window;
            var414B2CEBDF7E679ADF378DBBAB956EC0_1737347589.addTaint(taint);
            return var414B2CEBDF7E679ADF378DBBAB956EC0_1737347589;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.483 -0400", hash_original_method = "874529548DF9EED6A9EA45E2FAC51D8E", hash_generated_method = "3A25E2CA29C678C2E9117CFABCC86AAD")
    public void onMove(int position) throws RemoteException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(position);
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.484 -0400", hash_original_method = "0FF3A241CF7700F047C406946FE227F4", hash_generated_method = "D346D44AF79D31E2D5D4DC0BA5F031D3")
    public int count() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            boolean result = mRemote.transact(COUNT_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count;
            if(result == false)            
            {
                count = -1;
            } //End block
            else
            {
                count = reply.readInt();
            } //End block
            int varE2942A04780E223B215EB8B663CF5353_2075363687 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447924350 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447924350;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.485 -0400", hash_original_method = "55D53D666D124D26189F4C995847EE3B", hash_generated_method = "AA0905F70F23CA32C0F286E377C858D4")
    public String[] getColumnNames() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            mRemote.transact(GET_COLUMN_NAMES_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            String[] columnNames = null;
            int numColumns = reply.readInt();
            columnNames = new String[numColumns];
for(int i = 0;i < numColumns;i++)
            {
                columnNames[i] = reply.readString();
            } //End block
String[] var4DF41AA96E4B5CE54D79E2350D77438A_112267419 =             columnNames;
            var4DF41AA96E4B5CE54D79E2350D77438A_112267419.addTaint(taint);
            return var4DF41AA96E4B5CE54D79E2350D77438A_112267419;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.486 -0400", hash_original_method = "FD5E9EEC36BE8B65B5A00AF714CC54E0", hash_generated_method = "B5795C1CD612DC57C918E50A35075092")
    public void deactivate() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.486 -0400", hash_original_method = "C12FD550BDAC8145B3664A864E5B60A0", hash_generated_method = "794ECD036839A74A6AE936598DC14BB4")
    public void close() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.487 -0400", hash_original_method = "1C7F55EE59A84877DC54C93F1BEC1640", hash_generated_method = "E6DCD61483FCDCC5503A76E0E222C69F")
    public int requery(IContentObserver observer) throws RemoteException {
        addTaint(observer.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeStrongInterface(observer);
            boolean result = mRemote.transact(REQUERY_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count;
            if(!result)            
            {
                count = -1;
            } //End block
            else
            {
                count = reply.readInt();
                mExtras = reply.readBundle();
            } //End block
            int varE2942A04780E223B215EB8B663CF5353_1375370701 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984510655 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984510655;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.489 -0400", hash_original_method = "A152C23C891E00FCA22CAEB49B705CFA", hash_generated_method = "DDDED5952E9308B5C8578599089DA6E1")
    public boolean getWantsAllOnMoveCalls() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            mRemote.transact(WANTS_ON_MOVE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int result = reply.readInt();
            boolean var48B2BB9B3785EB1DD7973635DF866605_210583596 = (result != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1607425455 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1607425455;
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
            //mRemote.transact(WANTS_ON_MOVE_TRANSACTION, data, reply, 0);
            //DatabaseUtils.readExceptionFromParcel(reply);
            //int result = reply.readInt();
            //return result != 0;
        //} finally {
            //data.recycle();
            //reply.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.491 -0400", hash_original_method = "0BFE1C1B4E3A75686DCBF1FFC3B2E52B", hash_generated_method = "90574E105F06E699FEB1DB0BC78E2399")
    public Bundle getExtras() throws RemoteException {
        if(mExtras == null)        
        {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
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
Bundle var5E49E1FEC958658F846C38CDDBF16A8B_893179817 =         mExtras;
        var5E49E1FEC958658F846C38CDDBF16A8B_893179817.addTaint(taint);
        return var5E49E1FEC958658F846C38CDDBF16A8B_893179817;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.492 -0400", hash_original_method = "482AF4EBF0254C22A07B37919043D33E", hash_generated_method = "7C31DD47122CC5C593434C8F5DC2702E")
    public Bundle respond(Bundle extras) throws RemoteException {
        addTaint(extras.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeBundle(extras);
            mRemote.transact(RESPOND_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            Bundle returnExtras = reply.readBundle();
Bundle var8F472BA3FFE54B2054DC96B7BE02DF59_453218111 =             returnExtras;
            var8F472BA3FFE54B2054DC96B7BE02DF59_453218111.addTaint(taint);
            return var8F472BA3FFE54B2054DC96B7BE02DF59_453218111;
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

