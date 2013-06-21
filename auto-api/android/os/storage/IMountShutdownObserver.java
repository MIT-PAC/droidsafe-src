package android.os.storage;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMountShutdownObserver extends IInterface {
    
    public static abstract class Stub extends Binder implements IMountShutdownObserver {
        private static final java.lang.String DESCRIPTOR = "IMountShutdownObserver";

        
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        
        public static IMountShutdownObserver asInterface(IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            IInterface iin = (IInterface) obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof IMountShutdownObserver))) {
                return ((IMountShutdownObserver) iin);
            }
            return new IMountShutdownObserver.Stub.Proxy(obj);
        }

        public IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
                throws RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_onShutDownComplete: {
                    data.enforceInterface(DESCRIPTOR);
                    int statusCode;
                    statusCode = data.readInt();
                    this.onShutDownComplete(statusCode);
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements IMountShutdownObserver {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                mRemote = remote;
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            
            public void onShutDownComplete(int statusCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(statusCode);
                    mRemote.transact(Stub.TRANSACTION_onShutDownComplete, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_onShutDownComplete = (IBinder.FIRST_CALL_TRANSACTION + 0);
    }

    
    public void onShutDownComplete(int statusCode) throws RemoteException;
}
