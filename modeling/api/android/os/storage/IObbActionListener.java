package android.os.storage;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IObbActionListener extends IInterface {
    
    public static abstract class Stub extends Binder implements IObbActionListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.801 -0500", hash_original_field = "1583988C7187CD9914FE486EFF42E441", hash_generated_field = "F5BE1ED873DA85F3DED7803BB64F122D")

        private static final String DESCRIPTOR = "IObbActionListener";

        /**
         * Cast an IBinder object into an IObbActionListener interface,
         * generating a proxy if needed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.806 -0500", hash_original_method = "73ADBDA3056DFCD7A14AF4475EBE7481", hash_generated_method = "4A3B4BED8537FF909B3504E365C1C34D")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.829 -0500", hash_original_field = "BF0F37D07317086440192C1E6917874B", hash_generated_field = "CF631EDA0B331B24DF35259CA6EC0C91")

        static final int TRANSACTION_onObbResult = (IBinder.FIRST_CALL_TRANSACTION + 0);

        /** Construct the stub at attach it to the interface. */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.804 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.809 -0500", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "5E3B69CCD103133228ACADBBDEF1CE7E")
        
public IBinder asBinder() {
            return this;
        }

        private static class Proxy implements IObbActionListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.814 -0500", hash_original_field = "5AE257E0853836D9B54E1EF6497B909F", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

            private IBinder mRemote;

            @DSComment("Package priviledge")
            @DSBan(DSCat.DEFAULT_MODIFIER)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.817 -0500", hash_original_method = "1053F00877073A7D16C7E910C4B2EDC8", hash_generated_method = "1053F00877073A7D16C7E910C4B2EDC8")
            
Proxy(IBinder remote) {
                mRemote = remote;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.819 -0500", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "4DCC3A1AD60EC3BEEFB87DCA83743448")
            
public IBinder asBinder() {
                return mRemote;
            }

            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.822 -0500", hash_original_method = "93FCABDFBB24901E6298DD02204BB971", hash_generated_method = "CF508C7C95AE462F1450A60346FD4C18")
            
public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            /**
             * Return from an OBB action result.
             * 
             * @param filename the path to the OBB the operation was performed
             *            on
             * @param returnCode status of the operation
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.824 -0500", hash_original_method = "D8ACC621C10B2C8FB7C7E89B47A47912", hash_generated_method = "18221EBF374BC69CFA4761400A8FFDD9")
            
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

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.811 -0500", hash_original_method = "9539FE731056E0FF2462D4372775357D", hash_generated_method = "C03C803BEF78164EE0C2E0815119446A")
        
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
    }
    
    public void onObbResult(String filename, int nonce, int status) throws RemoteException;
}
