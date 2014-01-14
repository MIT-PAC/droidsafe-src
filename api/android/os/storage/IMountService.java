package android.os.storage;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface IMountService extends IInterface {
    
    public static abstract class Stub extends Binder implements IMountService {
        private static class Proxy implements IMountService {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.303 -0500", hash_original_field = "5AE257E0853836D9B54E1EF6497B909F", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

            private  IBinder mRemote;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.306 -0500", hash_original_method = "1053F00877073A7D16C7E910C4B2EDC8", hash_generated_method = "1053F00877073A7D16C7E910C4B2EDC8")
            
Proxy(IBinder remote) {
                mRemote = remote;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.308 -0500", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "4DCC3A1AD60EC3BEEFB87DCA83743448")
            
public IBinder asBinder() {
                return mRemote;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.311 -0500", hash_original_method = "93FCABDFBB24901E6298DD02204BB971", hash_generated_method = "CF508C7C95AE462F1450A60346FD4C18")
            
public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            /**
             * Registers an IMountServiceListener for receiving async
             * notifications.
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.313 -0500", hash_original_method = "432D4DA07A81324E52484ED697960EAF", hash_generated_method = "5D72FFEC989124D9B7560B0700D8657A")
            
public void registerListener(IMountServiceListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((listener != null ? listener.asBinder() : null));
                    mRemote.transact(Stub.TRANSACTION_registerListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Unregisters an IMountServiceListener
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.315 -0500", hash_original_method = "104DC1C3C93BF8D379F5E457769153F4", hash_generated_method = "F60C01365B082245DB3EEEDCD24A1FFB")
            
public void unregisterListener(IMountServiceListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((listener != null ? listener.asBinder() : null));
                    mRemote.transact(Stub.TRANSACTION_unregisterListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Returns true if a USB mass storage host is connected
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.318 -0500", hash_original_method = "F57CBFBBE97FE02AF4360D82E5EA1E4C", hash_generated_method = "B8F42390D19CF62333BAFA2F7E22E6B8")
            
public boolean isUsbMassStorageConnected() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_isUsbMassStorageConnected, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Enables / disables USB mass storage. The caller should check
             * actual status of enabling/disabling USB mass storage via
             * StorageEventListener.
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.320 -0500", hash_original_method = "7E6ADC2C4F0D160D81DDB8683669CD56", hash_generated_method = "FBE07A474D1C3257B58D64D1F96BAE99")
            
public void setUsbMassStorageEnabled(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt((enable ? 1 : 0));
                    mRemote.transact(Stub.TRANSACTION_setUsbMassStorageEnabled, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Returns true if a USB mass storage host is enabled (media is
             * shared)
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.323 -0500", hash_original_method = "D13E568BFB5E76177ED9A69D6C997D7C", hash_generated_method = "8C298631A33766A808F5FE9E3B859C98")
            
public boolean isUsbMassStorageEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_isUsbMassStorageEnabled, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Mount external storage at given mount point. Returns an int
             * consistent with MountServiceResultCode
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.326 -0500", hash_original_method = "A703B230AB4D168CF76B72D053DDBD85", hash_generated_method = "007534CF83335C06938BF772D22012A1")
            
public int mountVolume(String mountPoint) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(mountPoint);
                    mRemote.transact(Stub.TRANSACTION_mountVolume, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Safely unmount external storage at given mount point. The unmount
             * is an asynchronous operation. Applications should register
             * StorageEventListener for storage related status changes.
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.329 -0500", hash_original_method = "D0918211FE4E4321F90DD339A64DC727", hash_generated_method = "24E6C31B866B94E2F1A5E726C3D834B1")
            
public void unmountVolume(String mountPoint, boolean force, boolean removeEncryption)
                    throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(mountPoint);
                    _data.writeInt((force ? 1 : 0));
                    _data.writeInt((removeEncryption ? 1 : 0));
                    mRemote.transact(Stub.TRANSACTION_unmountVolume, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Format external storage given a mount point. Returns an int
             * consistent with MountServiceResultCode
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.332 -0500", hash_original_method = "D310FDCD034CEDE1E86BDA4C2CC451E5", hash_generated_method = "0C417F25673C7C0FEBB3F12EA275724F")
            
public int formatVolume(String mountPoint) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(mountPoint);
                    mRemote.transact(Stub.TRANSACTION_formatVolume, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Returns an array of pids with open files on the specified path.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.335 -0500", hash_original_method = "EF80E67EBD23D96C475A053A3A7D5616", hash_generated_method = "E92E9747B7D5F2BDAED70BEB80E268EC")
            
public int[] getStorageUsers(String path) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int[] _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(path);
                    mRemote.transact(Stub.TRANSACTION_getStorageUsers, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createIntArray();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Gets the state of a volume via its mountpoint.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.338 -0500", hash_original_method = "17ED92B23E19B6A37033A4B1459E27D0", hash_generated_method = "C7FB1AF0CD559A71100F5026795AFAED")
            
public String getVolumeState(String mountPoint) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(mountPoint);
                    mRemote.transact(Stub.TRANSACTION_getVolumeState, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /*
             * Creates a secure container with the specified parameters. Returns
             * an int consistent with MountServiceResultCode
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.340 -0500", hash_original_method = "8BF982A4940A35A08D65E3FB4582122B", hash_generated_method = "6EF017A703DE821BB8948712155D56FF")
            
public int createSecureContainer(String id, int sizeMb, String fstype, String key,
                    int ownerUid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(id);
                    _data.writeInt(sizeMb);
                    _data.writeString(fstype);
                    _data.writeString(key);
                    _data.writeInt(ownerUid);
                    mRemote.transact(Stub.TRANSACTION_createSecureContainer, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /*
             * Destroy a secure container, and free up all resources associated
             * with it. NOTE: Ensure all references are released prior to
             * deleting. Returns an int consistent with MountServiceResultCode
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.343 -0500", hash_original_method = "CA9F7E257385D5A87F91AD73E55F57E8", hash_generated_method = "8155432016D862E894FB52176AFDB565")
            
public int destroySecureContainer(String id, boolean force) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(id);
                    _data.writeInt((force ? 1 : 0));
                    mRemote.transact(Stub.TRANSACTION_destroySecureContainer, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /*
             * Finalize a container which has just been created and populated.
             * After finalization, the container is immutable. Returns an int
             * consistent with MountServiceResultCode
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.346 -0500", hash_original_method = "A4DAB19B1FEAFE344BCE106DF3FA3392", hash_generated_method = "207DF75BBD05E3A13B85390B63B962F1")
            
public int finalizeSecureContainer(String id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(id);
                    mRemote.transact(Stub.TRANSACTION_finalizeSecureContainer, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /*
             * Mount a secure container with the specified key and owner UID.
             * Returns an int consistent with MountServiceResultCode
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.348 -0500", hash_original_method = "8A5E77F08D64A5B78181B82F4578EDB6", hash_generated_method = "9606FC0F6D1610BB2816D459CA689A00")
            
public int mountSecureContainer(String id, String key, int ownerUid)
                    throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(id);
                    _data.writeString(key);
                    _data.writeInt(ownerUid);
                    mRemote.transact(Stub.TRANSACTION_mountSecureContainer, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /*
             * Unount a secure container. Returns an int consistent with
             * MountServiceResultCode
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.351 -0500", hash_original_method = "6978945A846D6E5B15F850A18852865E", hash_generated_method = "4B90AF9249CEFCA50161950F5BFC1D34")
            
public int unmountSecureContainer(String id, boolean force) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(id);
                    _data.writeInt((force ? 1 : 0));
                    mRemote.transact(Stub.TRANSACTION_unmountSecureContainer, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /*
             * Returns true if the specified container is mounted
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.354 -0500", hash_original_method = "6491FB5884D4CAE796EDDB3C964A7614", hash_generated_method = "1147AB56E6F00AD2A35560C960C642DB")
            
public boolean isSecureContainerMounted(String id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(id);
                    mRemote.transact(Stub.TRANSACTION_isSecureContainerMounted, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /*
             * Rename an unmounted secure container. Returns an int consistent
             * with MountServiceResultCode
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.356 -0500", hash_original_method = "EC14CB34666A3F7CB103B1F58B95D735", hash_generated_method = "80D5EB992E7B891D942F2FE949753C3A")
            
public int renameSecureContainer(String oldId, String newId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(oldId);
                    _data.writeString(newId);
                    mRemote.transact(Stub.TRANSACTION_renameSecureContainer, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /*
             * Returns the filesystem path of a mounted secure container.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.359 -0500", hash_original_method = "BDB886652E9A432DB3B2E893E4B41734", hash_generated_method = "BA2EE16EBFF6B4A8AA3F3E3C15EA098C")
            
public String getSecureContainerPath(String id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(id);
                    mRemote.transact(Stub.TRANSACTION_getSecureContainerPath, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Gets an Array of currently known secure container IDs
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.361 -0500", hash_original_method = "567890A8612D287E24312EFA9D0BF1EA", hash_generated_method = "8899C08C252D1BF00161208617A55885")
            
public String[] getSecureContainerList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                String[] _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getSecureContainerList, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createStringArray();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Shuts down the MountService and gracefully unmounts all external
             * media. Invokes call back once the shutdown is complete.
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.365 -0500", hash_original_method = "F7717214D3FB0B312C80864347208755", hash_generated_method = "F7C4009BD73E3AD8E0E5376FBBE7DDB4")
            
public void shutdown(IMountShutdownObserver observer)
                    throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((observer != null ? observer.asBinder() : null));
                    mRemote.transact(Stub.TRANSACTION_shutdown, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Call into MountService by PackageManager to notify that its done
             * processing the media status update request.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.367 -0500", hash_original_method = "E2AB52B281F5EC7EB0F807D72D17CEB3", hash_generated_method = "66874A7B8C8F76E947C738FCCFF15447")
            
public void finishMediaUpdate() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_finishMediaUpdate, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Mounts an Opaque Binary Blob (OBB) with the specified decryption
             * key and only allows the calling process's UID access to the
             * contents. MountService will call back to the supplied
             * IObbActionListener to inform it of the terminal state of the
             * call.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.370 -0500", hash_original_method = "44077744DD0D52C8F3591CC9067FCB75", hash_generated_method = "C8499FD3C15E0FEE23C4BB8D3A03A1E2")
            
public void mountObb(String filename, String key, IObbActionListener token, int nonce)
                    throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(filename);
                    _data.writeString(key);
                    _data.writeStrongBinder((token != null ? token.asBinder() : null));
                    _data.writeInt(nonce);
                    mRemote.transact(Stub.TRANSACTION_mountObb, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Unmounts an Opaque Binary Blob (OBB). When the force flag is
             * specified, any program using it will be forcibly killed to
             * unmount the image. MountService will call back to the supplied
             * IObbActionListener to inform it of the terminal state of the
             * call.
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.372 -0500", hash_original_method = "E253E13DECFD996BFF6116409A895E0C", hash_generated_method = "1B1BB52CFA126CC30EC979DCBAA9DCD7")
            
public void unmountObb(String filename, boolean force, IObbActionListener token,
                    int nonce) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(filename);
                    _data.writeInt((force ? 1 : 0));
                    _data.writeStrongBinder((token != null ? token.asBinder() : null));
                    _data.writeInt(nonce);
                    mRemote.transact(Stub.TRANSACTION_unmountObb, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Checks whether the specified Opaque Binary Blob (OBB) is mounted
             * somewhere.
             */
            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.375 -0500", hash_original_method = "93DD7D3C97BC2E36D2B231088046CCC4", hash_generated_method = "56FCE838B754F6742FDC09562FBE1639")
            
public boolean isObbMounted(String filename) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(filename);
                    mRemote.transact(Stub.TRANSACTION_isObbMounted, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Gets the path to the mounted Opaque Binary Blob (OBB).
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.378 -0500", hash_original_method = "C39211C64ADEB0A0D9BA593373386E8B", hash_generated_method = "50AEC4E4B3ADC2C34C549A11EE93DCB7")
            
public String getMountedObbPath(String filename) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(filename);
                    mRemote.transact(Stub.TRANSACTION_getMountedObbPath, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Returns whether the external storage is emulated.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.380 -0500", hash_original_method = "97242E7B00359BC230A580EA53895961", hash_generated_method = "A4AD1B5499F723CB1E7780DBE097B1B9")
            
public boolean isExternalStorageEmulated() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_isExternalStorageEmulated, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.384 -0500", hash_original_method = "ED1E0407894A7EB5D0D0E56D6C14BE92", hash_generated_method = "47F0800E663632789B8D6D2CB79FFC6F")
            
public int getEncryptionState() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getEncryptionState, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.386 -0500", hash_original_method = "B8BF80B32E6DEB3F7721B20DF54F27C6", hash_generated_method = "B28BCD6C92F256E6785D930CB234C25F")
            
public int decryptStorage(String password) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(password);
                    mRemote.transact(Stub.TRANSACTION_decryptStorage, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.389 -0500", hash_original_method = "FD9B1240C64EBE4B14FE1D91F0257414", hash_generated_method = "173660D512AFD5938FC6C5ED0DA82496")
            
public int encryptStorage(String password) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(password);
                    mRemote.transact(Stub.TRANSACTION_encryptStorage, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.392 -0500", hash_original_method = "EADD544B27D7A5E0D258AA2FC1D3878D", hash_generated_method = "0068559E61CF5062BB6ECFF413D4E192")
            
public int changeEncryptionPassword(String password) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(password);
                    mRemote.transact(Stub.TRANSACTION_changeEncryptionPassword, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.394 -0500", hash_original_method = "228BEE3E8E2C3507ED968D0FB4C7E14C", hash_generated_method = "333EDC85FA989CB2202136CE49460CF5")
            
@Override
            public int verifyEncryptionPassword(String password) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(password);
                    mRemote.transact(Stub.TRANSACTION_verifyEncryptionPassword, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.397 -0500", hash_original_method = "7AF768DD36BCFF391FF5CFABC199787F", hash_generated_method = "3E65DD3AEBCAB4C16878F636A58B6C04")
            
public Parcelable[] getVolumeList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                Parcelable[] _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getVolumeList, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readParcelableArray(StorageVolume.class.getClassLoader());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /*
             * Returns the filesystem path of a mounted secure container.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.400 -0500", hash_original_method = "25AEC33191B8CCE7D20A608F91457F74", hash_generated_method = "15006C2E10D6DEBD21717D7A5831DA33")
            
public String getSecureContainerFilesystemPath(String id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(id);
                    mRemote.transact(Stub.TRANSACTION_getSecureContainerFilesystemPath, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.411 -0500", hash_original_field = "4F09AA82090578B465E0290638F85CF4", hash_generated_field = "3D44606D17E49521067F8F2F240E3EAE")

        private static final String DESCRIPTOR = "IMountService";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.413 -0500", hash_original_field = "4389A9EBF86B35AC5942040705EE7EC9", hash_generated_field = "90B67300C6DA0DF403C45E2A22E02AFC")

        static final int TRANSACTION_registerListener = IBinder.FIRST_CALL_TRANSACTION + 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.416 -0500", hash_original_field = "D432F860A59CB5F1321212506F5FCCF0", hash_generated_field = "9C30FA96DBE72C54624499FF2FBFBB02")

        static final int TRANSACTION_unregisterListener = IBinder.FIRST_CALL_TRANSACTION + 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.419 -0500", hash_original_field = "3CF030324138CB721CF6C574DE51D05A", hash_generated_field = "6C32D912FCFB4B6C6B6E2EF8F7E45F22")

        static final int TRANSACTION_isUsbMassStorageConnected = IBinder.FIRST_CALL_TRANSACTION + 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.421 -0500", hash_original_field = "92D17A38835DF8BA1A85C04EB22BE8A1", hash_generated_field = "9C73145296C5A71E45E54829B8D4CFCE")

        static final int TRANSACTION_setUsbMassStorageEnabled = IBinder.FIRST_CALL_TRANSACTION + 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.423 -0500", hash_original_field = "88EC86420254D3B4C37FFDE970FC21B4", hash_generated_field = "F6B35E6F9120983F511A376E09068F90")

        static final int TRANSACTION_isUsbMassStorageEnabled = IBinder.FIRST_CALL_TRANSACTION + 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.426 -0500", hash_original_field = "09DEBB9184AE0D9571E4018FA8238CA5", hash_generated_field = "5DF81ACAF96F06015F25835BFDBF5DCF")

        static final int TRANSACTION_mountVolume = IBinder.FIRST_CALL_TRANSACTION + 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.428 -0500", hash_original_field = "BC2391534718F30885E1573E220296CC", hash_generated_field = "74A313C609792DA957B3EA370FD3A2E4")

        static final int TRANSACTION_unmountVolume = IBinder.FIRST_CALL_TRANSACTION + 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.430 -0500", hash_original_field = "6B2C36C88D301CCC6DC483C1A73535C9", hash_generated_field = "457B8AE5DF731B9C79D855EA76BA1D7D")

        static final int TRANSACTION_formatVolume = IBinder.FIRST_CALL_TRANSACTION + 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.433 -0500", hash_original_field = "4E84208DC30D627C31436F34CDA842E0", hash_generated_field = "5D2713A868A9D71DE5F68160C24C5433")

        static final int TRANSACTION_getStorageUsers = IBinder.FIRST_CALL_TRANSACTION + 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.435 -0500", hash_original_field = "E66E4C7A7D2B6F65ED55E3369E8D84A4", hash_generated_field = "B362F6B685BB29F3F239EEBC70BDAE05")

        static final int TRANSACTION_getVolumeState = IBinder.FIRST_CALL_TRANSACTION + 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.437 -0500", hash_original_field = "22857F0FB3C1283C65112EE82F513245", hash_generated_field = "049D78252FE4938DD62FF00A8D8965AF")

        static final int TRANSACTION_createSecureContainer = IBinder.FIRST_CALL_TRANSACTION + 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.440 -0500", hash_original_field = "680281B9E0D60A54CEE88E3A35706B36", hash_generated_field = "1D3F6A0D82BD4A3C706EA703FEA4DD6A")

        static final int TRANSACTION_finalizeSecureContainer = IBinder.FIRST_CALL_TRANSACTION + 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.443 -0500", hash_original_field = "4ABD4A16FF47D514224B7E966476CF0E", hash_generated_field = "D96832AB9CEFCF7169CFBB68895B0FFB")

        static final int TRANSACTION_destroySecureContainer = IBinder.FIRST_CALL_TRANSACTION + 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.445 -0500", hash_original_field = "9800A269643C9F9ADC193801F4DC5D92", hash_generated_field = "65B77DBA2D0386EE71F29023AB07D724")

        static final int TRANSACTION_mountSecureContainer = IBinder.FIRST_CALL_TRANSACTION + 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.448 -0500", hash_original_field = "80353C6E7A3FA455269EAF5013D08CAF", hash_generated_field = "9E947653C98851751833EC93980F77C7")

        static final int TRANSACTION_unmountSecureContainer = IBinder.FIRST_CALL_TRANSACTION + 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.450 -0500", hash_original_field = "4F687195DF7455810A685A9AFFEA1398", hash_generated_field = "4E346409CCDD5720330463C6BC5BE5F4")

        static final int TRANSACTION_isSecureContainerMounted = IBinder.FIRST_CALL_TRANSACTION + 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.452 -0500", hash_original_field = "38905312709669351AD2870C2E827D45", hash_generated_field = "1E1CE00D9D3CE6D61067EFCE32941951")

        static final int TRANSACTION_renameSecureContainer = IBinder.FIRST_CALL_TRANSACTION + 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.454 -0500", hash_original_field = "CABEB5FB66E8CF6E7A8BD9DC61B71FE5", hash_generated_field = "1079D57DE86232E4E309262DC01CCC6E")

        static final int TRANSACTION_getSecureContainerPath = IBinder.FIRST_CALL_TRANSACTION + 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.456 -0500", hash_original_field = "0A6B0D9930A5626ABB7D01F5296365C5", hash_generated_field = "32EC6FB0D2B6D49435F692B41FFA86A6")

        static final int TRANSACTION_getSecureContainerList = IBinder.FIRST_CALL_TRANSACTION + 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.459 -0500", hash_original_field = "DDB67DCF8FC6691D7E9042FD5F73C1EF", hash_generated_field = "269F22595DFC740297E7E174CDA1E34E")

        static final int TRANSACTION_shutdown = IBinder.FIRST_CALL_TRANSACTION + 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.462 -0500", hash_original_field = "C07E6C0524F3B209E04D1EF750C3E588", hash_generated_field = "BF2D4C81079191B5257A475CF88D7A5B")

        static final int TRANSACTION_finishMediaUpdate = IBinder.FIRST_CALL_TRANSACTION + 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.464 -0500", hash_original_field = "149C0472A304EAE09E5DE5E416778F3C", hash_generated_field = "0626862BA936119943B3E9FFA4816C49")

        static final int TRANSACTION_mountObb = IBinder.FIRST_CALL_TRANSACTION + 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.466 -0500", hash_original_field = "BCD923F385D4EF2AE26514B23A1F0295", hash_generated_field = "E2490FD856899DFBDA7DF74F6F428CCC")

        static final int TRANSACTION_unmountObb = IBinder.FIRST_CALL_TRANSACTION + 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.468 -0500", hash_original_field = "9B12EE251AF69181425938BBDB72ECB5", hash_generated_field = "79060EDEC5C9F7B59A833D9775336025")

        static final int TRANSACTION_isObbMounted = IBinder.FIRST_CALL_TRANSACTION + 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.471 -0500", hash_original_field = "082314EA41CF272BCDA50F76E17322B5", hash_generated_field = "F66AF6DF14A228F1B14CB78C25F45AAF")

        static final int TRANSACTION_getMountedObbPath = IBinder.FIRST_CALL_TRANSACTION + 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.473 -0500", hash_original_field = "5DDC962C684451E516EB1F17348D1665", hash_generated_field = "91E38B3FEA4500125E4D7352DCF317CA")

        static final int TRANSACTION_isExternalStorageEmulated = IBinder.FIRST_CALL_TRANSACTION + 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.475 -0500", hash_original_field = "4D8D725EF53CD54D027826F251F70A94", hash_generated_field = "CB42E335375D46CFCEDC80F659BABA72")

        static final int TRANSACTION_decryptStorage = IBinder.FIRST_CALL_TRANSACTION + 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.478 -0500", hash_original_field = "20CB5EABF5995667D676F0E57194086B", hash_generated_field = "A31E2066BCF5D3041158A960030ED946")

        static final int TRANSACTION_encryptStorage = IBinder.FIRST_CALL_TRANSACTION + 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.481 -0500", hash_original_field = "21C10E51F65CA19D08EF49AB7A5FDE2E", hash_generated_field = "5ABF8A1FE04CA12599DF1BABAF9BD067")

        static final int TRANSACTION_changeEncryptionPassword = IBinder.FIRST_CALL_TRANSACTION + 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.483 -0500", hash_original_field = "240EE23ACB7A5CF9A82C0559C434D840", hash_generated_field = "B3B6F83E4A0222637C9373C25AD482ED")

        static final int TRANSACTION_getVolumeList = IBinder.FIRST_CALL_TRANSACTION + 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.485 -0500", hash_original_field = "9259E597F3A42878CECF6ADA39071E4A", hash_generated_field = "85A7AAFCA008A36D03309B17C2761860")

        static final int TRANSACTION_getSecureContainerFilesystemPath = IBinder.FIRST_CALL_TRANSACTION + 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.488 -0500", hash_original_field = "D99B8C977D349D0DB7DF1FC9DABB401B", hash_generated_field = "A0900B1172AB1CFEA81F27826BC32A2D")

        static final int TRANSACTION_getEncryptionState = IBinder.FIRST_CALL_TRANSACTION + 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.491 -0500", hash_original_field = "5B954003990596E2CC17173921D02AFF", hash_generated_field = "E2A2B8DEF6800C6148B863AE3C9E1EAA")

        static final int TRANSACTION_verifyEncryptionPassword = IBinder.FIRST_CALL_TRANSACTION + 32;

        /**
         * Cast an IBinder object into an IMountService interface, generating a
         * proxy if needed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.494 -0500", hash_original_method = "40C08BB77162FCBEA75650162992A05C", hash_generated_method = "5EFD6DEA400978BD7E152F26C4144266")
        
public static IMountService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && iin instanceof IMountService) {
                return (IMountService) iin;
            }
            return new IMountService.Stub.Proxy(obj);
        }

        /** Construct the stub at attach it to the interface. */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.496 -0500", hash_original_method = "9DF31EF661086A2E329E9935CEC58DE7", hash_generated_method = "CC82F397266B7554FEE0F3D6A48B029B")
        
public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.498 -0500", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "5E3B69CCD103133228ACADBBDEF1CE7E")
        
public IBinder asBinder() {
            return this;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:34.507 -0500", hash_original_method = "95AA17A698F30BB2942B919588F5BED1", hash_generated_method = "0D962984399DA13D30B612C3593E4153")
        
@Override
        public boolean onTransact(int code, Parcel data, Parcel reply,
                int flags) throws RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_registerListener: {
                    data.enforceInterface(DESCRIPTOR);
                    IMountServiceListener listener;
                    listener = IMountServiceListener.Stub.asInterface(data.readStrongBinder());
                    registerListener(listener);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_unregisterListener: {
                    data.enforceInterface(DESCRIPTOR);
                    IMountServiceListener listener;
                    listener = IMountServiceListener.Stub.asInterface(data.readStrongBinder());
                    unregisterListener(listener);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isUsbMassStorageConnected: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean result = isUsbMassStorageConnected();
                    reply.writeNoException();
                    reply.writeInt((result ? 1 : 0));
                    return true;
                }
                case TRANSACTION_setUsbMassStorageEnabled: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean enable;
                    enable = 0 != data.readInt();
                    setUsbMassStorageEnabled(enable);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isUsbMassStorageEnabled: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean result = isUsbMassStorageEnabled();
                    reply.writeNoException();
                    reply.writeInt((result ? 1 : 0));
                    return true;
                }
                case TRANSACTION_mountVolume: {
                    data.enforceInterface(DESCRIPTOR);
                    String mountPoint;
                    mountPoint = data.readString();
                    int resultCode = mountVolume(mountPoint);
                    reply.writeNoException();
                    reply.writeInt(resultCode);
                    return true;
                }
                case TRANSACTION_unmountVolume: {
                    data.enforceInterface(DESCRIPTOR);
                    String mountPoint;
                    mountPoint = data.readString();
                    boolean force = 0 != data.readInt();
                    boolean removeEncrypt = 0 != data.readInt();
                    unmountVolume(mountPoint, force, removeEncrypt);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_formatVolume: {
                    data.enforceInterface(DESCRIPTOR);
                    String mountPoint;
                    mountPoint = data.readString();
                    int result = formatVolume(mountPoint);
                    reply.writeNoException();
                    reply.writeInt(result);
                    return true;
                }
                case TRANSACTION_getStorageUsers: {
                    data.enforceInterface(DESCRIPTOR);
                    String path;
                    path = data.readString();
                    int[] pids = getStorageUsers(path);
                    reply.writeNoException();
                    reply.writeIntArray(pids);
                    return true;
                }
                case TRANSACTION_getVolumeState: {
                    data.enforceInterface(DESCRIPTOR);
                    String mountPoint;
                    mountPoint = data.readString();
                    String state = getVolumeState(mountPoint);
                    reply.writeNoException();
                    reply.writeString(state);
                    return true;
                }
                case TRANSACTION_createSecureContainer: {
                    data.enforceInterface(DESCRIPTOR);
                    String id;
                    id = data.readString();
                    int sizeMb;
                    sizeMb = data.readInt();
                    String fstype;
                    fstype = data.readString();
                    String key;
                    key = data.readString();
                    int ownerUid;
                    ownerUid = data.readInt();
                    int resultCode = createSecureContainer(id, sizeMb, fstype, key, ownerUid);
                    reply.writeNoException();
                    reply.writeInt(resultCode);
                    return true;
                }
                case TRANSACTION_finalizeSecureContainer: {
                    data.enforceInterface(DESCRIPTOR);
                    String id;
                    id = data.readString();
                    int resultCode = finalizeSecureContainer(id);
                    reply.writeNoException();
                    reply.writeInt(resultCode);
                    return true;
                }
                case TRANSACTION_destroySecureContainer: {
                    data.enforceInterface(DESCRIPTOR);
                    String id;
                    id = data.readString();
                    boolean force;
                    force = 0 != data.readInt();
                    int resultCode = destroySecureContainer(id, force);
                    reply.writeNoException();
                    reply.writeInt(resultCode);
                    return true;
                }
                case TRANSACTION_mountSecureContainer: {
                    data.enforceInterface(DESCRIPTOR);
                    String id;
                    id = data.readString();
                    String key;
                    key = data.readString();
                    int ownerUid;
                    ownerUid = data.readInt();
                    int resultCode = mountSecureContainer(id, key, ownerUid);
                    reply.writeNoException();
                    reply.writeInt(resultCode);
                    return true;
                }
                case TRANSACTION_unmountSecureContainer: {
                    data.enforceInterface(DESCRIPTOR);
                    String id;
                    id = data.readString();
                    boolean force;
                    force = 0 != data.readInt();
                    int resultCode = unmountSecureContainer(id, force);
                    reply.writeNoException();
                    reply.writeInt(resultCode);
                    return true;
                }
                case TRANSACTION_isSecureContainerMounted: {
                    data.enforceInterface(DESCRIPTOR);
                    String id;
                    id = data.readString();
                    boolean status = isSecureContainerMounted(id);
                    reply.writeNoException();
                    reply.writeInt((status ? 1 : 0));
                    return true;
                }
                case TRANSACTION_renameSecureContainer: {
                    data.enforceInterface(DESCRIPTOR);
                    String oldId;
                    oldId = data.readString();
                    String newId;
                    newId = data.readString();
                    int resultCode = renameSecureContainer(oldId, newId);
                    reply.writeNoException();
                    reply.writeInt(resultCode);
                    return true;
                }
                case TRANSACTION_getSecureContainerPath: {
                    data.enforceInterface(DESCRIPTOR);
                    String id;
                    id = data.readString();
                    String path = getSecureContainerPath(id);
                    reply.writeNoException();
                    reply.writeString(path);
                    return true;
                }
                case TRANSACTION_getSecureContainerList: {
                    data.enforceInterface(DESCRIPTOR);
                    String[] ids = getSecureContainerList();
                    reply.writeNoException();
                    reply.writeStringArray(ids);
                    return true;
                }
                case TRANSACTION_shutdown: {
                    data.enforceInterface(DESCRIPTOR);
                    IMountShutdownObserver observer;
                    observer = IMountShutdownObserver.Stub.asInterface(data
                            .readStrongBinder());
                    shutdown(observer);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_finishMediaUpdate: {
                    data.enforceInterface(DESCRIPTOR);
                    finishMediaUpdate();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_mountObb: {
                    data.enforceInterface(DESCRIPTOR);
                    String filename;
                    filename = data.readString();
                    String key;
                    key = data.readString();
                    IObbActionListener observer;
                    observer = IObbActionListener.Stub.asInterface(data.readStrongBinder());
                    int nonce;
                    nonce = data.readInt();
                    mountObb(filename, key, observer, nonce);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_unmountObb: {
                    data.enforceInterface(DESCRIPTOR);
                    String filename;
                    filename = data.readString();
                    boolean force;
                    force = 0 != data.readInt();
                    IObbActionListener observer;
                    observer = IObbActionListener.Stub.asInterface(data.readStrongBinder());
                    int nonce;
                    nonce = data.readInt();
                    unmountObb(filename, force, observer, nonce);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isObbMounted: {
                    data.enforceInterface(DESCRIPTOR);
                    String filename;
                    filename = data.readString();
                    boolean status = isObbMounted(filename);
                    reply.writeNoException();
                    reply.writeInt((status ? 1 : 0));
                    return true;
                }
                case TRANSACTION_getMountedObbPath: {
                    data.enforceInterface(DESCRIPTOR);
                    String filename;
                    filename = data.readString();
                    String mountedPath = getMountedObbPath(filename);
                    reply.writeNoException();
                    reply.writeString(mountedPath);
                    return true;
                }
                case TRANSACTION_isExternalStorageEmulated: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean emulated = isExternalStorageEmulated();
                    reply.writeNoException();
                    reply.writeInt(emulated ? 1 : 0);
                    return true;
                }
                case TRANSACTION_decryptStorage: {
                    data.enforceInterface(DESCRIPTOR);
                    String password = data.readString();
                    int result = decryptStorage(password);
                    reply.writeNoException();
                    reply.writeInt(result);
                    return true;
                }
                case TRANSACTION_encryptStorage: {
                    data.enforceInterface(DESCRIPTOR);
                    String password = data.readString();
                    int result = encryptStorage(password);
                    reply.writeNoException();
                    reply.writeInt(result);
                    return true;
                }
                case TRANSACTION_changeEncryptionPassword: {
                    data.enforceInterface(DESCRIPTOR);
                    String password = data.readString();
                    int result = changeEncryptionPassword(password);
                    reply.writeNoException();
                    reply.writeInt(result);
                    return true;
                }
                case TRANSACTION_getVolumeList: {
                    data.enforceInterface(DESCRIPTOR);
                    Parcelable[] result = getVolumeList();
                    reply.writeNoException();
                    reply.writeParcelableArray(result, 0);
                    return true;
                }
                case TRANSACTION_getSecureContainerFilesystemPath: {
                    data.enforceInterface(DESCRIPTOR);
                    String id;
                    id = data.readString();
                    String path = getSecureContainerFilesystemPath(id);
                    reply.writeNoException();
                    reply.writeString(path);
                    return true;
                }
                case TRANSACTION_getEncryptionState: {
                    data.enforceInterface(DESCRIPTOR);
                    int result = getEncryptionState();
                    reply.writeNoException();
                    reply.writeInt(result);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
    }
    
    public int createSecureContainer(String id, int sizeMb, String fstype, String key, int ownerUid)
            throws RemoteException;
    
    public int destroySecureContainer(String id, boolean force) throws RemoteException;
    
    public int finalizeSecureContainer(String id) throws RemoteException;
    
    public void finishMediaUpdate() throws RemoteException;
    
    public int formatVolume(String mountPoint) throws RemoteException;
    
    public String getMountedObbPath(String filename) throws RemoteException;
    
    public String[] getSecureContainerList() throws RemoteException;
    
    public String getSecureContainerPath(String id) throws RemoteException;
    
    public int[] getStorageUsers(String path) throws RemoteException;
    
    public String getVolumeState(String mountPoint) throws RemoteException;
    
    public boolean isObbMounted(String filename) throws RemoteException;
    
    public boolean isSecureContainerMounted(String id) throws RemoteException;
    
    public boolean isUsbMassStorageConnected() throws RemoteException;
    
    public boolean isUsbMassStorageEnabled() throws RemoteException;
    
    public void mountObb(String filename, String key, IObbActionListener token, int nonce)
            throws RemoteException;
    
    public int mountSecureContainer(String id, String key, int ownerUid) throws RemoteException;
    
    public int mountVolume(String mountPoint) throws RemoteException;
    
    public void registerListener(IMountServiceListener listener) throws RemoteException;
    
    public int renameSecureContainer(String oldId, String newId) throws RemoteException;
    
    public void setUsbMassStorageEnabled(boolean enable) throws RemoteException;
    
    public void shutdown(IMountShutdownObserver observer) throws RemoteException;
    
    public void unmountObb(String filename, boolean force, IObbActionListener token, int nonce)
            throws RemoteException;
    
    public int unmountSecureContainer(String id, boolean force) throws RemoteException;
    
    public void unmountVolume(String mountPoint, boolean force, boolean removeEncryption)
            throws RemoteException;
    
    public void unregisterListener(IMountServiceListener listener) throws RemoteException;
    
    public boolean isExternalStorageEmulated() throws RemoteException;
    
    static final int ENCRYPTION_STATE_NONE = 1;
    
    static final int ENCRYPTION_STATE_OK = 0;
    
    static final int ENCRYPTION_STATE_ERROR_UNKNOWN = -1;
    
    static final int ENCRYPTION_STATE_ERROR_INCOMPLETE = -2;
    
    public int getEncryptionState() throws RemoteException;
    
    public int decryptStorage(String password) throws RemoteException;
    
    public int encryptStorage(String password) throws RemoteException;
    
    public int changeEncryptionPassword(String password) throws RemoteException;
    
    public int verifyEncryptionPassword(String password) throws RemoteException;
    
    public Parcelable[] getVolumeList() throws RemoteException;

    public String getSecureContainerFilesystemPath(String id) throws RemoteException;
}
