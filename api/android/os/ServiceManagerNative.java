package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class ServiceManagerNative extends Binder implements IServiceManager {
    /**
     * Cast a Binder object into a service manager interface, generating
     * a proxy if needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.140 -0500", hash_original_method = "F8F3061CB658BFF4D286A709EC298A75", hash_generated_method = "E1809C03B742FCFD7814F9D2D09ABC71")
    
static public IServiceManager asInterface(IBinder obj)
    {
        if (obj == null) {
            return null;
        }
        IServiceManager in =
            (IServiceManager)obj.queryLocalInterface(descriptor);
        if (in != null) {
            return in;
        }
        
        return new ServiceManagerProxy(obj);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.143 -0500", hash_original_method = "9F01F56EAD98DCCF5588838D591C9215", hash_generated_method = "7743C90D46ECC76BC540EE37951A682D")
    
public ServiceManagerNative()
    {
        attachInterface(this, descriptor);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.146 -0500", hash_original_method = "77391B19BF1D318FBD43A52170DD3D86", hash_generated_method = "1BDAB90CF42E81C0C6659F856F69AB0F")
    
public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
    {
        try {
            switch (code) {
            case IServiceManager.GET_SERVICE_TRANSACTION: {
                data.enforceInterface(IServiceManager.descriptor);
                String name = data.readString();
                IBinder service = getService(name);
                reply.writeStrongBinder(service);
                return true;
            }
    
            case IServiceManager.CHECK_SERVICE_TRANSACTION: {
                data.enforceInterface(IServiceManager.descriptor);
                String name = data.readString();
                IBinder service = checkService(name);
                reply.writeStrongBinder(service);
                return true;
            }
    
            case IServiceManager.ADD_SERVICE_TRANSACTION: {
                data.enforceInterface(IServiceManager.descriptor);
                String name = data.readString();
                IBinder service = data.readStrongBinder();
                addService(name, service);
                return true;
            }
    
            case IServiceManager.LIST_SERVICES_TRANSACTION: {
                data.enforceInterface(IServiceManager.descriptor);
                String[] list = listServices();
                reply.writeStringArray(list);
                return true;
            }
            
            case IServiceManager.SET_PERMISSION_CONTROLLER_TRANSACTION: {
                data.enforceInterface(IServiceManager.descriptor);
                IPermissionController controller
                        = IPermissionController.Stub.asInterface(
                                data.readStrongBinder());
                setPermissionController(controller);
                return true;
            }
            }
        } catch (RemoteException e) {
        }
        
        return false;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.148 -0500", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "5E3B69CCD103133228ACADBBDEF1CE7E")
    
public IBinder asBinder()
    {
        return this;
    }
    
}

class ServiceManagerProxy implements IServiceManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.167 -0500", hash_original_field = "5AE257E0853836D9B54E1EF6497B909F", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.152 -0500", hash_original_method = "84032B28A83A581245FB022389F526C9", hash_generated_method = "42C47AAA2A67021810601EC88D7ED961")
    
public ServiceManagerProxy(IBinder remote) {
        mRemote = remote;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.154 -0500", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "4DCC3A1AD60EC3BEEFB87DCA83743448")
    
public IBinder asBinder() {
        return mRemote;
    }
    
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.156 -0500", hash_original_method = "02C17092CC4D0E934B4324BDE37272C4", hash_generated_method = "B28DEB8DAA227469176CA94BEABBA96A")
    
public IBinder getService(String name) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeString(name);
        mRemote.transact(GET_SERVICE_TRANSACTION, data, reply, 0);
        IBinder binder = reply.readStrongBinder();
        reply.recycle();
        data.recycle();
        return binder;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.158 -0500", hash_original_method = "5C8E64034E0715CC0FF2A576ACC0AB5A", hash_generated_method = "3EF57A4C129AB110D97F51CF0514509A")
    
public IBinder checkService(String name) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeString(name);
        mRemote.transact(CHECK_SERVICE_TRANSACTION, data, reply, 0);
        IBinder binder = reply.readStrongBinder();
        reply.recycle();
        data.recycle();
        return binder;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.160 -0500", hash_original_method = "5E591506D5DD50AD56DFCE9C7D5E988A", hash_generated_method = "D6C7068FDB2018059FDB473269683540")
    
public void addService(String name, IBinder service)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeString(name);
        data.writeStrongBinder(service);
        mRemote.transact(ADD_SERVICE_TRANSACTION, data, reply, 0);
        reply.recycle();
        data.recycle();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.162 -0500", hash_original_method = "FC27781B3E4C3CFB72E5AC6A897CA1D1", hash_generated_method = "A5C2FD8296378401E5B17AACFA509CF8")
    
public String[] listServices() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        mRemote.transact(LIST_SERVICES_TRANSACTION, data, reply, 0);
        String[] list = reply.readStringArray();
        reply.recycle();
        data.recycle();
        return list;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:35.164 -0500", hash_original_method = "8A24F25196050E86CC22CCEE8401DF5F", hash_generated_method = "74E430F0695CEE5C5E0EC98EA4FD630A")
    
public void setPermissionController(IPermissionController controller)
            throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeStrongBinder(controller.asBinder());
        mRemote.transact(SET_PERMISSION_CONTROLLER_TRANSACTION, data, reply, 0);
        reply.recycle();
        data.recycle();
    }
    
}

