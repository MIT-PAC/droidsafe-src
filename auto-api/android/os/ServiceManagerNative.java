package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class ServiceManagerNative extends Binder implements IServiceManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.208 -0400", hash_original_method = "9F01F56EAD98DCCF5588838D591C9215", hash_generated_method = "85C73BFA46F2172E7BBE49D58C0ED876")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceManagerNative() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.209 -0400", hash_original_method = "77391B19BF1D318FBD43A52170DD3D86", hash_generated_method = "7AE70AE8EA2AE8EED4A3AE80C3F25D3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(flags);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(reply.dsTaint);
        dsTaint.addTaint(code);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.210 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "1992535F0C7EB8757F965477F5292EC0")
    @DSModeled(DSC.SAFE)
    public IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
}

class ServiceManagerProxy implements IServiceManager {
    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.211 -0400", hash_original_method = "84032B28A83A581245FB022389F526C9", hash_generated_method = "B3D035B579EE2F057C2F3BEA51AE412C")
    @DSModeled(DSC.SAFE)
    public ServiceManagerProxy(IBinder remote) {
        dsTaint.addTaint(remote.dsTaint);
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.212 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "DD6FDB77557F0A5920AFCE061E8D4085")
    @DSModeled(DSC.SAFE)
    public IBinder asBinder() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.213 -0400", hash_original_method = "02C17092CC4D0E934B4324BDE37272C4", hash_generated_method = "93B0B4E5D59CC90BEA3AE4E5B88B8E28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IBinder getService(String name) throws RemoteException {
        dsTaint.addTaint(name);
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
        return (IBinder)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.214 -0400", hash_original_method = "5C8E64034E0715CC0FF2A576ACC0AB5A", hash_generated_method = "BEC919ABBA65F597AA645075C766BCFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IBinder checkService(String name) throws RemoteException {
        dsTaint.addTaint(name);
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
        return (IBinder)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.214 -0400", hash_original_method = "5E591506D5DD50AD56DFCE9C7D5E988A", hash_generated_method = "722242D2B6357948F9666F7318DB4A05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addService(String name, IBinder service) throws RemoteException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(service.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.214 -0400", hash_original_method = "FC27781B3E4C3CFB72E5AC6A897CA1D1", hash_generated_method = "B453F9004C13EF390C0B6FB9AE965D80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] listServices() throws RemoteException {
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
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.215 -0400", hash_original_method = "8A24F25196050E86CC22CCEE8401DF5F", hash_generated_method = "61BEAD5E1A4F592535807222D303F8FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPermissionController(IPermissionController controller) throws RemoteException {
        dsTaint.addTaint(controller.dsTaint);
        Parcel data;
        data = Parcel.obtain();
        Parcel reply;
        reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeStrongBinder(controller.asBinder());
        mRemote.transact(SET_PERMISSION_CONTROLLER_TRANSACTION, data, reply, 0);
        reply.recycle();
        data.recycle();
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

