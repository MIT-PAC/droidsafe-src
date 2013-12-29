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

public interface IMountShutdownObserver extends IInterface {
    
    public static abstract class Stub extends Binder implements IMountShutdownObserver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.675 -0500", hash_original_field = "99C0A83C57661129EE0E746E9B90E1F5", hash_generated_field = "AA5BD657178480518DAF0FC157C103E8")

        private static final java.lang.String DESCRIPTOR = "IMountShutdownObserver";

        /**
         * Cast an IBinder object into an IMountShutdownObserver interface,
         * generating a proxy if needed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.677 -0500", hash_original_method = "6AA63A8287DD7E9A23BDF1D48810A80B", hash_generated_method = "30F32D6CE84560F2931269B43C232A4E")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.685 -0500", hash_original_field = "FE6431F007A319105110956C23CCDBD0", hash_generated_field = "BAAA97529B723D191501B7A68EA1668F")


        static final int TRANSACTION_onShutDownComplete = (IBinder.FIRST_CALL_TRANSACTION + 0);

        /** Construct the stub at attach it to the interface. */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.676 -0500", hash_original_method = "02D67B7BBDDCEC9BC9A477128D96A70E", hash_generated_method = "73DCA79669D2BAEA0D08C443D09F446C")
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.677 -0500", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "5E3B69CCD103133228ACADBBDEF1CE7E")
        public IBinder asBinder() {
            return this;
        }

        private static class Proxy implements IMountShutdownObserver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.679 -0500", hash_original_field = "5AE257E0853836D9B54E1EF6497B909F", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

            private IBinder mRemote;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.680 -0500", hash_original_method = "1053F00877073A7D16C7E910C4B2EDC8", hash_generated_method = "1053F00877073A7D16C7E910C4B2EDC8")
            Proxy(IBinder remote) {
                mRemote = remote;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.681 -0500", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "4DCC3A1AD60EC3BEEFB87DCA83743448")
            public IBinder asBinder() {
                return mRemote;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.682 -0500", hash_original_method = "3362E889B22D3412E9E5749AB1353327", hash_generated_method = "EC5547681CA8A7D03904A2398DFFE30D")
            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            /**
             * This method is called when the shutdown of MountService
             * completed.
             * 
             * @param statusCode indicates success or failure of the shutdown.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.683 -0500", hash_original_method = "A4221FE2747F2722CD7817ABD50D3BD6", hash_generated_method = "BEC0710E7388338BC63FD11CA7A05744")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:39.678 -0500", hash_original_method = "5DA3CCD9795611414F9D41B6C38F3E8B", hash_generated_method = "81F0A3182DDAE3DC041EF91BDCF73E06")
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
    }

    
    public void onShutDownComplete(int statusCode) throws RemoteException;
}
