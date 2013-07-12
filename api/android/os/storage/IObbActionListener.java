package android.os.storage;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IObbActionListener extends IInterface {
    
    public static abstract class Stub extends Binder implements IObbActionListener {
        private static final String DESCRIPTOR = "IObbActionListener";

        
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        
        public static IObbActionListener asInterface(IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            IInterface iin = (IInterface) obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof IObbActionListener))) {
                return ((IObbActionListener) iin);
            }
            return new IObbActionListener.Stub.Proxy(obj);
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
                case TRANSACTION_onObbResult: {
                    data.enforceInterface(DESCRIPTOR);
                    String filename;
                    filename = data.readString();
                    int nonce;
                    nonce = data.readInt();
                    int status;
                    status = data.readInt();
                    this.onObbResult(filename, nonce, status);
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements IObbActionListener {
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

            
            public void onObbResult(String filename, int nonce, int status)
                    throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(filename);
                    _data.writeInt(nonce);
                    _data.writeInt(status);
                    mRemote.transact(Stub.TRANSACTION_onObbResult, _data, _reply,
                            android.os.IBinder.FLAG_ONEWAY);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_onObbResult = (IBinder.FIRST_CALL_TRANSACTION + 0);
    }

    
    public void onObbResult(String filename, int nonce, int status) throws RemoteException;
}
