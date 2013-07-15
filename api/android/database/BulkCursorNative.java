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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.959 -0400", hash_original_method = "DBBF6D4FB94E7243F8FE13872836805D", hash_generated_method = "49E124CE99C124C9C743BD828F75C77A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.960 -0400", hash_original_method = "974E69C0AD1811D8FB0AF6277EF80D39", hash_generated_method = "095FC31BE28120C6BD304C9E18D1975C")
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
                boolean varB326B5062B2F0E69046810717534CB09_570176729 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_108535474 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_108535474;
            } //End block
            case COUNT_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                int count = count();
                reply.writeNoException();
                reply.writeInt(count);
                boolean varB326B5062B2F0E69046810717534CB09_1513044493 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024351442 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024351442;
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
                boolean varB326B5062B2F0E69046810717534CB09_1344279995 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1597154574 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1597154574;
            } //End block
            case DEACTIVATE_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                deactivate();
                reply.writeNoException();
                boolean varB326B5062B2F0E69046810717534CB09_1512652036 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2050662545 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2050662545;
            } //End block
            case CLOSE_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                close();
                reply.writeNoException();
                boolean varB326B5062B2F0E69046810717534CB09_1556183125 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1165599817 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1165599817;
            } //End block
            case REQUERY_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                IContentObserver observer = IContentObserver.Stub.asInterface(data.readStrongBinder());
                int count = requery(observer);
                reply.writeNoException();
                reply.writeInt(count);
                reply.writeBundle(getExtras());
                boolean varB326B5062B2F0E69046810717534CB09_190341173 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_911976955 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_911976955;
            } //End block
            case ON_MOVE_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                int position = data.readInt();
                onMove(position);
                reply.writeNoException();
                boolean varB326B5062B2F0E69046810717534CB09_770796205 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1832177823 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1832177823;
            } //End block
            case WANTS_ON_MOVE_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                boolean result = getWantsAllOnMoveCalls();
                reply.writeNoException();
                reply.writeInt(result ? 1 : 0);
                boolean varB326B5062B2F0E69046810717534CB09_1628516062 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1006248648 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1006248648;
            } //End block
            case GET_EXTRAS_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                Bundle extras = getExtras();
                reply.writeNoException();
                reply.writeBundle(extras);
                boolean varB326B5062B2F0E69046810717534CB09_1026909131 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1313227263 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1313227263;
            } //End block
            case RESPOND_TRANSACTION:
            {
                data.enforceInterface(IBulkCursor.descriptor);
                Bundle extras = data.readBundle();
                Bundle returnExtras = respond(extras);
                reply.writeNoException();
                reply.writeBundle(returnExtras);
                boolean varB326B5062B2F0E69046810717534CB09_1378156910 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1014749056 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1014749056;
            } //End block
}
        } //End block
        catch (Exception e)
        {
            DatabaseUtils.writeExceptionToParcel(reply, e);
            boolean varB326B5062B2F0E69046810717534CB09_1394635122 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1132236663 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1132236663;
        } //End block
        boolean var3B3A841664B2F7D5B8C0C4B7B8E31E3B_612169788 = (super.onTransact(code, data, reply, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1195921449 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1195921449;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.962 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "08F1BF28B99B183D621DCBF73A9D846B")
    public IBinder asBinder() {
IBinder var72A74007B2BE62B849F475C7BDA4658B_1307044544 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1307044544.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1307044544;
        // ---------- Original Method ----------
        //return this;
    }

    
}

final class BulkCursorProxy implements IBulkCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.963 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.963 -0400", hash_original_field = "45F5DC4EA541ED660CFEDA0032CA356C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    private Bundle mExtras;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.963 -0400", hash_original_method = "D55E49E568C2A68373E38CCE4CBFBB39", hash_generated_method = "F4E2E7A3DCF84063D978A8615FEA3A5E")
    public  BulkCursorProxy(IBinder remote) {
        mRemote = remote;
        mExtras = null;
        // ---------- Original Method ----------
        //mRemote = remote;
        //mExtras = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.964 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "803F7916C12CF2609F8901FA627EACC2")
    public IBinder asBinder() {
IBinder varF4936CA84F7841A48B466C9D273BE2EB_306998301 =         mRemote;
        varF4936CA84F7841A48B466C9D273BE2EB_306998301.addTaint(taint);
        return varF4936CA84F7841A48B466C9D273BE2EB_306998301;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.964 -0400", hash_original_method = "7540C72731403A44B035590E58ED3901", hash_generated_method = "59C2E03676387DF7521D125BD4A83EB9")
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
CursorWindow var414B2CEBDF7E679ADF378DBBAB956EC0_2037581034 =             window;
            var414B2CEBDF7E679ADF378DBBAB956EC0_2037581034.addTaint(taint);
            return var414B2CEBDF7E679ADF378DBBAB956EC0_2037581034;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.965 -0400", hash_original_method = "874529548DF9EED6A9EA45E2FAC51D8E", hash_generated_method = "3A25E2CA29C678C2E9117CFABCC86AAD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.966 -0400", hash_original_method = "0FF3A241CF7700F047C406946FE227F4", hash_generated_method = "D069AC5F83B9FB5D85B7869064F54D8F")
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
            int varE2942A04780E223B215EB8B663CF5353_230089290 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473790890 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473790890;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.966 -0400", hash_original_method = "55D53D666D124D26189F4C995847EE3B", hash_generated_method = "F24E437106B7AAEF510F975B583691CE")
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
String[] var4DF41AA96E4B5CE54D79E2350D77438A_1131659374 =             columnNames;
            var4DF41AA96E4B5CE54D79E2350D77438A_1131659374.addTaint(taint);
            return var4DF41AA96E4B5CE54D79E2350D77438A_1131659374;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.967 -0400", hash_original_method = "FD5E9EEC36BE8B65B5A00AF714CC54E0", hash_generated_method = "B5795C1CD612DC57C918E50A35075092")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.967 -0400", hash_original_method = "C12FD550BDAC8145B3664A864E5B60A0", hash_generated_method = "794ECD036839A74A6AE936598DC14BB4")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.968 -0400", hash_original_method = "1C7F55EE59A84877DC54C93F1BEC1640", hash_generated_method = "4312EFDFA112A6513764DACC53C6EF1D")
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
            int varE2942A04780E223B215EB8B663CF5353_1792794785 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117578731 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117578731;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.969 -0400", hash_original_method = "A152C23C891E00FCA22CAEB49B705CFA", hash_generated_method = "A42EE6E3EDEF7D03E863824A47DF8CD9")
    public boolean getWantsAllOnMoveCalls() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            mRemote.transact(WANTS_ON_MOVE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int result = reply.readInt();
            boolean var48B2BB9B3785EB1DD7973635DF866605_72847310 = (result != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_708522044 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_708522044;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.969 -0400", hash_original_method = "0BFE1C1B4E3A75686DCBF1FFC3B2E52B", hash_generated_method = "FF6E6D4AE7ADE27BD6979543188B5A08")
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
Bundle var5E49E1FEC958658F846C38CDDBF16A8B_1968489598 =         mExtras;
        var5E49E1FEC958658F846C38CDDBF16A8B_1968489598.addTaint(taint);
        return var5E49E1FEC958658F846C38CDDBF16A8B_1968489598;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.970 -0400", hash_original_method = "482AF4EBF0254C22A07B37919043D33E", hash_generated_method = "3EDBFA6EF4C41694FA8D7B56D2F0608E")
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
Bundle var8F472BA3FFE54B2054DC96B7BE02DF59_883707459 =             returnExtras;
            var8F472BA3FFE54B2054DC96B7BE02DF59_883707459.addTaint(taint);
            return var8F472BA3FFE54B2054DC96B7BE02DF59_883707459;
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

