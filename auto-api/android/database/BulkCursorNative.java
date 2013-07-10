package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public abstract class BulkCursorNative extends Binder implements IBulkCursor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.601 -0400", hash_original_method = "DBBF6D4FB94E7243F8FE13872836805D", hash_generated_method = "49E124CE99C124C9C743BD828F75C77A")
    public  BulkCursorNative() {
        attachInterface(this, descriptor);
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.602 -0400", hash_original_method = "974E69C0AD1811D8FB0AF6277EF80D39", hash_generated_method = "9C0B17C1EED218BBCBCFCBD85A8CC211")
    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        
        try 
        {
            
            {
                data.enforceInterface(IBulkCursor.descriptor);
                int startPos = data.readInt();
                CursorWindow window = getWindow(startPos);
                reply.writeNoException();
                {
                    reply.writeInt(0);
                } 
                {
                    reply.writeInt(1);
                    window.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                } 
            } 
            
            
            {
                data.enforceInterface(IBulkCursor.descriptor);
                int count = count();
                reply.writeNoException();
                reply.writeInt(count);
            } 
            
            
            {
                data.enforceInterface(IBulkCursor.descriptor);
                String[] columnNames = getColumnNames();
                reply.writeNoException();
                reply.writeInt(columnNames.length);
                int length = columnNames.length;
                {
                    int i = 0;
                    {
                        reply.writeString(columnNames[i]);
                    } 
                } 
            } 
            
            
            {
                data.enforceInterface(IBulkCursor.descriptor);
                deactivate();
                reply.writeNoException();
            } 
            
            
            {
                data.enforceInterface(IBulkCursor.descriptor);
                close();
                reply.writeNoException();
            } 
            
            
            {
                data.enforceInterface(IBulkCursor.descriptor);
                IContentObserver observer = IContentObserver.Stub.asInterface(data.readStrongBinder());
                int count = requery(observer);
                reply.writeNoException();
                reply.writeInt(count);
                reply.writeBundle(getExtras());
            } 
            
            
            {
                data.enforceInterface(IBulkCursor.descriptor);
                int position = data.readInt();
                onMove(position);
                reply.writeNoException();
            } 
            
            
            {
                data.enforceInterface(IBulkCursor.descriptor);
                boolean result = getWantsAllOnMoveCalls();
                reply.writeNoException();
                reply.writeInt(result ? 1 : 0);
            } 
            
            
            {
                data.enforceInterface(IBulkCursor.descriptor);
                Bundle extras = getExtras();
                reply.writeNoException();
                reply.writeBundle(extras);
            } 
            
            
            {
                data.enforceInterface(IBulkCursor.descriptor);
                Bundle extras = data.readBundle();
                Bundle returnExtras = respond(extras);
                reply.writeNoException();
                reply.writeBundle(returnExtras);
            } 
            
        } 
        catch (Exception e)
        {
            DatabaseUtils.writeExceptionToParcel(reply, e);
        } 
        boolean var3746A99EF74DBE66CD43EDAE5F9B6D9F_492256769 = (super.onTransact(code, data, reply, flags));
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1681402124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1681402124;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.604 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "51312D1805041D0544CF161B7E70C05D")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1316645225 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1316645225 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1316645225.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1316645225;
        
        
    }

    
}

final class BulkCursorProxy implements IBulkCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.604 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.604 -0400", hash_original_field = "45F5DC4EA541ED660CFEDA0032CA356C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    private Bundle mExtras;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.605 -0400", hash_original_method = "D55E49E568C2A68373E38CCE4CBFBB39", hash_generated_method = "F4E2E7A3DCF84063D978A8615FEA3A5E")
    public  BulkCursorProxy(IBinder remote) {
        mRemote = remote;
        mExtras = null;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.605 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "40FF415059923D4EAEF64EBF92E08D64")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1480046156 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1480046156 = mRemote;
        varB4EAC82CA7396A68D541C85D26508E83_1480046156.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1480046156;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.606 -0400", hash_original_method = "7540C72731403A44B035590E58ED3901", hash_generated_method = "CB767920B5EED201871405F232BA491A")
    public CursorWindow getWindow(int startPos) throws RemoteException {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_1177280667 = null; 
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeInt(startPos);
            mRemote.transact(GET_CURSOR_WINDOW_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            CursorWindow window = null;
            {
                boolean varE5AB1DE09562BE89A9CEF4B0E885340F_139932866 = (reply.readInt() == 1);
                {
                    window = CursorWindow.newFromParcel(reply);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1177280667 = window;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(startPos);
        varB4EAC82CA7396A68D541C85D26508E83_1177280667.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1177280667;
        
        
        
        
            
            
            
            
            
            
                
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.607 -0400", hash_original_method = "874529548DF9EED6A9EA45E2FAC51D8E", hash_generated_method = "29400E3FFEF44D158916620C877070B4")
    public void onMove(int position) throws RemoteException {
        
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeInt(position);
            mRemote.transact(ON_MOVE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(position);
        
        
        
        
            
            
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.607 -0400", hash_original_method = "0FF3A241CF7700F047C406946FE227F4", hash_generated_method = "F26F5DEBDB146219D739AC6E96E06D76")
    public int count() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            boolean result = mRemote.transact(COUNT_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count;
            {
                count = -1;
            } 
            {
                count = reply.readInt();
            } 
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_323720135 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_323720135;
        
        
        
        
            
            
            
            
            
                
            
                
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.608 -0400", hash_original_method = "55D53D666D124D26189F4C995847EE3B", hash_generated_method = "2836E30C622E28610615F082E7836BAC")
    public String[] getColumnNames() throws RemoteException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_798116345 = null; 
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
            {
                int i = 0;
                {
                    columnNames[i] = reply.readString();
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_798116345 = columnNames;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_798116345.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_798116345;
        
        
        
        
            
            
            
            
            
            
            
                
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.609 -0400", hash_original_method = "FD5E9EEC36BE8B65B5A00AF714CC54E0", hash_generated_method = "B5795C1CD612DC57C918E50A35075092")
    public void deactivate() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            mRemote.transact(DEACTIVATE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        
        
        
        
            
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.610 -0400", hash_original_method = "C12FD550BDAC8145B3664A864E5B60A0", hash_generated_method = "794ECD036839A74A6AE936598DC14BB4")
    public void close() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            mRemote.transact(CLOSE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        
        
        
        
            
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.610 -0400", hash_original_method = "1C7F55EE59A84877DC54C93F1BEC1640", hash_generated_method = "6D4C230C3A5A29B759C1262F895B2DF5")
    public int requery(IContentObserver observer) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeStrongInterface(observer);
            boolean result = mRemote.transact(REQUERY_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int count;
            {
                count = -1;
            } 
            {
                count = reply.readInt();
                mExtras = reply.readBundle();
            } 
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(observer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026638540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026638540;
        
        
        
        
            
            
            
            
            
            
                
            
                
                
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.611 -0400", hash_original_method = "A152C23C891E00FCA22CAEB49B705CFA", hash_generated_method = "5236BDDCFE7C5E8B3071D5B4F798B635")
    public boolean getWantsAllOnMoveCalls() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            mRemote.transact(WANTS_ON_MOVE_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            int result = reply.readInt();
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541775047 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_541775047;
        
        
        
        
            
            
            
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.612 -0400", hash_original_method = "0BFE1C1B4E3A75686DCBF1FFC3B2E52B", hash_generated_method = "D6DEE14FD3BBC42968C13452372013CD")
    public Bundle getExtras() throws RemoteException {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_83040380 = null; 
        {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try 
            {
                data.writeInterfaceToken(IBulkCursor.descriptor);
                mRemote.transact(GET_EXTRAS_TRANSACTION, data, reply, 0);
                DatabaseUtils.readExceptionFromParcel(reply);
                mExtras = reply.readBundle();
            } 
            finally 
            {
                data.recycle();
                reply.recycle();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_83040380 = mExtras;
        varB4EAC82CA7396A68D541C85D26508E83_83040380.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_83040380;
        
        
            
            
            
                
                
                
                
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.612 -0400", hash_original_method = "482AF4EBF0254C22A07B37919043D33E", hash_generated_method = "2F6F516DB96A24137C2CABBAD147FB63")
    public Bundle respond(Bundle extras) throws RemoteException {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_93284307 = null; 
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try 
        {
            data.writeInterfaceToken(IBulkCursor.descriptor);
            data.writeBundle(extras);
            mRemote.transact(RESPOND_TRANSACTION, data, reply, 0);
            DatabaseUtils.readExceptionFromParcel(reply);
            Bundle returnExtras = reply.readBundle();
            varB4EAC82CA7396A68D541C85D26508E83_93284307 = returnExtras;
        } 
        finally 
        {
            data.recycle();
            reply.recycle();
        } 
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_93284307.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_93284307;
        
        
        
        
            
            
            
            
            
            
        
            
            
        
    }

    
}

