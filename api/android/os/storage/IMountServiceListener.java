package android.os.storage;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMountServiceListener extends IInterface {
    
    public static abstract class Stub extends Binder implements IMountServiceListener {
        private static final String DESCRIPTOR = "IMountServiceListener";

        
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        
        public static IMountServiceListener asInterface(IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            IInterface iin = (IInterface) obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof IMountServiceListener))) {
                return ((IMountServiceListener) iin);
            }
            return new IMountServiceListener.Stub.Proxy(obj);
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
                case TRANSACTION_onUsbMassStorageConnectionChanged: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean connected;
                    connected = (0 != data.readInt());
                    this.onUsbMassStorageConnectionChanged(connected);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onStorageStateChanged: {
                    data.enforceInterface(DESCRIPTOR);
                    String path;
                    path = data.readString();
                    String oldState;
                    oldState = data.readString();
                    String newState;
                    newState = data.readString();
                    this.onStorageStateChanged(path, oldState, newState);
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements IMountServiceListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                mRemote = remote;
            }

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            
            public void onUsbMassStorageConnectionChanged(boolean connected) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(((connected) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_onUsbMassStorageConnectionChanged, _data,
                            _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            
            public void onStorageStateChanged(String path, String oldState, String newState)
                    throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(path);
                    _data.writeString(oldState);
                    _data.writeString(newState);
                    mRemote.transact(Stub.TRANSACTION_onStorageStateChanged, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_onUsbMassStorageConnectionChanged = (IBinder.FIRST_CALL_TRANSACTION + 0);

        static final int TRANSACTION_onStorageStateChanged = (IBinder.FIRST_CALL_TRANSACTION + 1);
    }

    
    public void onUsbMassStorageConnectionChanged(boolean connected) throws RemoteException;

    
    public void onStorageStateChanged(String path, String oldState, String newState)
            throws RemoteException;
}
