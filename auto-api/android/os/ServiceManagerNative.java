package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class ServiceManagerNative extends Binder implements IServiceManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.547 -0400", hash_original_method = "9F01F56EAD98DCCF5588838D591C9215", hash_generated_method = "85C73BFA46F2172E7BBE49D58C0ED876")
    public  ServiceManagerNative() {
        attachInterface(this, descriptor);
        // ---------- Original Method ----------
        //attachInterface(this, descriptor);
    }

    
        static public IServiceManager asInterface(IBinder obj) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.562 -0400", hash_original_method = "77391B19BF1D318FBD43A52170DD3D86", hash_generated_method = "442F64B2C61E6B1A45F8FF1D4AFEA335")
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        try 
        {
            //Begin case IServiceManager.GET_SERVICE_TRANSACTION 
            {
                data.enforceInterface(IServiceManager.descriptor);
                String name;
                name = data.readString();
                IBinder service;
                service = getService(name);
                reply.writeStrongBinder(service);
            } //End block
            //End case IServiceManager.GET_SERVICE_TRANSACTION 
            //Begin case IServiceManager.CHECK_SERVICE_TRANSACTION 
            {
                data.enforceInterface(IServiceManager.descriptor);
                String name;
                name = data.readString();
                IBinder service;
                service = checkService(name);
                reply.writeStrongBinder(service);
            } //End block
            //End case IServiceManager.CHECK_SERVICE_TRANSACTION 
            //Begin case IServiceManager.ADD_SERVICE_TRANSACTION 
            {
                data.enforceInterface(IServiceManager.descriptor);
                String name;
                name = data.readString();
                IBinder service;
                service = data.readStrongBinder();
                addService(name, service);
            } //End block
            //End case IServiceManager.ADD_SERVICE_TRANSACTION 
            //Begin case IServiceManager.LIST_SERVICES_TRANSACTION 
            {
                data.enforceInterface(IServiceManager.descriptor);
                String[] list;
                list = listServices();
                reply.writeStringArray(list);
            } //End block
            //End case IServiceManager.LIST_SERVICES_TRANSACTION 
            //Begin case IServiceManager.SET_PERMISSION_CONTROLLER_TRANSACTION 
            {
                data.enforceInterface(IServiceManager.descriptor);
                IPermissionController controller;
                controller = IPermissionController.Stub.asInterface(
                                data.readStrongBinder());
                setPermissionController(controller);
            } //End block
            //End case IServiceManager.SET_PERMISSION_CONTROLLER_TRANSACTION 
        } //End block
        catch (RemoteException e)
        { }
        addTaint(code);
        addTaint(data.getTaint());
        addTaint(reply.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_438238784 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_438238784;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.563 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "EBCDCCA4700796301B20F1D4A56A7FEB")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1932377117 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1932377117 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1932377117.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1932377117;
        // ---------- Original Method ----------
        //return this;
    }

    
}

class ServiceManagerProxy implements IServiceManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.564 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.575 -0400", hash_original_method = "84032B28A83A581245FB022389F526C9", hash_generated_method = "9C93C75DE81E92FB068744B3E68A0310")
    public  ServiceManagerProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.577 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "22E46CD9705C056CF3A06F6D6C1C6C03")
    public IBinder asBinder() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_409267139 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_409267139 = mRemote;
        varB4EAC82CA7396A68D541C85D26508E83_409267139.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_409267139;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.593 -0400", hash_original_method = "02C17092CC4D0E934B4324BDE37272C4", hash_generated_method = "A0E88ECC74C63A306EBDFC6E5EFEB741")
    public IBinder getService(String name) throws RemoteException {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1171715940 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeString(name);
        mRemote.transact(GET_SERVICE_TRANSACTION, data, reply, 0);
        IBinder binder;
        binder = reply.readStrongBinder();
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1171715940 = binder;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1171715940.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1171715940;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IServiceManager.descriptor);
        //data.writeString(name);
        //mRemote.transact(GET_SERVICE_TRANSACTION, data, reply, 0);
        //IBinder binder = reply.readStrongBinder();
        //reply.recycle();
        //data.recycle();
        //return binder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.594 -0400", hash_original_method = "5C8E64034E0715CC0FF2A576ACC0AB5A", hash_generated_method = "FF9DCEE54E4657B5AAF1AF681C7AF612")
    public IBinder checkService(String name) throws RemoteException {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1461398641 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeString(name);
        mRemote.transact(CHECK_SERVICE_TRANSACTION, data, reply, 0);
        IBinder binder;
        binder = reply.readStrongBinder();
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1461398641 = binder;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1461398641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1461398641;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IServiceManager.descriptor);
        //data.writeString(name);
        //mRemote.transact(CHECK_SERVICE_TRANSACTION, data, reply, 0);
        //IBinder binder = reply.readStrongBinder();
        //reply.recycle();
        //data.recycle();
        //return binder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.598 -0400", hash_original_method = "5E591506D5DD50AD56DFCE9C7D5E988A", hash_generated_method = "DA943F0ABD001A16720BDAB73005D5F5")
    public void addService(String name, IBinder service) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeString(name);
        data.writeStrongBinder(service);
        mRemote.transact(ADD_SERVICE_TRANSACTION, data, reply, 0);
        reply.recycle();
        data.recycle();
        addTaint(name.getTaint());
        addTaint(service.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IServiceManager.descriptor);
        //data.writeString(name);
        //data.writeStrongBinder(service);
        //mRemote.transact(ADD_SERVICE_TRANSACTION, data, reply, 0);
        //reply.recycle();
        //data.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.610 -0400", hash_original_method = "FC27781B3E4C3CFB72E5AC6A897CA1D1", hash_generated_method = "B73D6A30236FD3E0E661AB3036349074")
    public String[] listServices() throws RemoteException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_706655529 = null; //Variable for return #1
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        mRemote.transact(LIST_SERVICES_TRANSACTION, data, reply, 0);
        String[] list;
        list = reply.readStringArray();
        reply.recycle();
        data.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_706655529 = list;
        varB4EAC82CA7396A68D541C85D26508E83_706655529.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_706655529;
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IServiceManager.descriptor);
        //mRemote.transact(LIST_SERVICES_TRANSACTION, data, reply, 0);
        //String[] list = reply.readStringArray();
        //reply.recycle();
        //data.recycle();
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.612 -0400", hash_original_method = "8A24F25196050E86CC22CCEE8401DF5F", hash_generated_method = "15868B32BDA09D4939D623101A2674EC")
    public void setPermissionController(IPermissionController controller) throws RemoteException {
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeStrongBinder(controller.asBinder());
        mRemote.transact(SET_PERMISSION_CONTROLLER_TRANSACTION, data, reply, 0);
        reply.recycle();
        data.recycle();
        addTaint(controller.getTaint());
        // ---------- Original Method ----------
        //Parcel data = Parcel.obtain();
        //Parcel reply = Parcel.obtain();
        //data.writeInterfaceToken(IServiceManager.descriptor);
        //data.writeStrongBinder(controller.asBinder());
        //mRemote.transact(SET_PERMISSION_CONTROLLER_TRANSACTION, data, reply, 0);
        //reply.recycle();
        //data.recycle();
    }

    
}

