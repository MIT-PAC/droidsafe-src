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

public interface IMountServiceListener extends IInterface {
    
    public static abstract class Stub extends Binder implements IMountServiceListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.672 -0500", hash_original_field = "73CC64718B9BE72F9002572142E9FA4E", hash_generated_field = "0A9D01B14D46CBF45ED509FCA30C00A1")

        private static final String DESCRIPTOR = "IMountServiceListener";

        /**
         * Cast an IBinder object into an IMountServiceListener interface,
         * generating a proxy if needed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.677 -0500", hash_original_method = "D5F58F01DDBB445E7F554C00D02A8637", hash_generated_method = "F16F27CC328EC1D2369B1A9D4197AFA3")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.703 -0500", hash_original_field = "079AAB84EC132B5F469E490AFE5009EC", hash_generated_field = "455F90DA2DF35AD2740FCBDC8F824EF3")

        static final int TRANSACTION_onUsbMassStorageConnectionChanged = (IBinder.FIRST_CALL_TRANSACTION + 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.705 -0500", hash_original_field = "317AE559BB7FE082ADE3BECC6920D55F", hash_generated_field = "4BBA30AB1DD0FF7A055CBE89BF595DA2")

        static final int TRANSACTION_onStorageStateChanged = (IBinder.FIRST_CALL_TRANSACTION + 1);

        /** Construct the stub at attach it to the interface. */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.674 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        
public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        private static class Proxy implements IMountServiceListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.686 -0500", hash_original_field = "5AE257E0853836D9B54E1EF6497B909F", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

            private IBinder mRemote;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.688 -0500", hash_original_method = "1053F00877073A7D16C7E910C4B2EDC8", hash_generated_method = "1053F00877073A7D16C7E910C4B2EDC8")
            
Proxy(IBinder remote) {
                mRemote = remote;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.691 -0500", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "4DCC3A1AD60EC3BEEFB87DCA83743448")
            
public IBinder asBinder() {
                return mRemote;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.693 -0500", hash_original_method = "93FCABDFBB24901E6298DD02204BB971", hash_generated_method = "CF508C7C95AE462F1450A60346FD4C18")
            
public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            /**
             * Detection state of USB Mass Storage has changed
             * 
             * @param available true if a UMS host is connected.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.696 -0500", hash_original_method = "CA31660626429B1FC154BFCAB52FCEB5", hash_generated_method = "1A8AE6F223EA38456A72AD0C056AD9C2")
            
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

            /**
             * Storage state has changed.
             * 
             * @param path The volume mount path.
             * @param oldState The old state of the volume.
             * @param newState The new state of the volume. Note: State is one
             *            of the values returned by
             *            Environment.getExternalStorageState()
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.698 -0500", hash_original_method = "CD00AB00D1A83361B186C7E93BBCCA09", hash_generated_method = "DCA2DD7C0CA9EAE17499F050A7939D80")
            
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.679 -0500", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "5E3B69CCD103133228ACADBBDEF1CE7E")
        
public IBinder asBinder() {
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.682 -0500", hash_original_method = "4B5CB1439FE22B8015736A798B59DE9B", hash_generated_method = "3ECC4B67388844E26088744A22D40A0B")
        
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
    }
    
    public void onUsbMassStorageConnectionChanged(boolean connected) throws RemoteException;
    
    public void onStorageStateChanged(String path, String oldState, String newState)
            throws RemoteException;
}
