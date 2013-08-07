package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;





public abstract class ServiceManagerNative extends Binder implements IServiceManager {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.573 -0400", hash_original_method = "9F01F56EAD98DCCF5588838D591C9215", hash_generated_method = "85C73BFA46F2172E7BBE49D58C0ED876")
    public  ServiceManagerNative() {
        attachInterface(this, descriptor);
        // ---------- Original Method ----------
        //attachInterface(this, descriptor);
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.576 -0400", hash_original_method = "77391B19BF1D318FBD43A52170DD3D86", hash_generated_method = "51CBFDC116990946C78165D99B6C56EA")
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(flags);
        addTaint(reply.getTaint());
        addTaint(data.getTaint());
        addTaint(code);
        try 
        {
switch(code){
            case IServiceManager.GET_SERVICE_TRANSACTION:
            {
                data.enforceInterface(IServiceManager.descriptor);
                String name = data.readString();
                IBinder service = getService(name);
                reply.writeStrongBinder(service);
                boolean varB326B5062B2F0E69046810717534CB09_984954155 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2022825103 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2022825103;
            } //End block
            case IServiceManager.CHECK_SERVICE_TRANSACTION:
            {
                data.enforceInterface(IServiceManager.descriptor);
                String name = data.readString();
                IBinder service = checkService(name);
                reply.writeStrongBinder(service);
                boolean varB326B5062B2F0E69046810717534CB09_1144512985 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1374306041 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1374306041;
            } //End block
            case IServiceManager.ADD_SERVICE_TRANSACTION:
            {
                data.enforceInterface(IServiceManager.descriptor);
                String name = data.readString();
                IBinder service = data.readStrongBinder();
                addService(name, service);
                boolean varB326B5062B2F0E69046810717534CB09_1681772978 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056672470 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056672470;
            } //End block
            case IServiceManager.LIST_SERVICES_TRANSACTION:
            {
                data.enforceInterface(IServiceManager.descriptor);
                String[] list = listServices();
                reply.writeStringArray(list);
                boolean varB326B5062B2F0E69046810717534CB09_2123909419 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_311248784 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_311248784;
            } //End block
            case IServiceManager.SET_PERMISSION_CONTROLLER_TRANSACTION:
            {
                data.enforceInterface(IServiceManager.descriptor);
                IPermissionController controller = IPermissionController.Stub.asInterface(
                                data.readStrongBinder());
                setPermissionController(controller);
                boolean varB326B5062B2F0E69046810717534CB09_1040517627 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135094710 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135094710;
            } //End block
}
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_586533423 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98530473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_98530473;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.577 -0400", hash_original_method = "2E6ED031FA2AB47CC2982E0232E351E2", hash_generated_method = "4A5EE40906A818160752CEE34A393C53")
    public IBinder asBinder() {
IBinder var72A74007B2BE62B849F475C7BDA4658B_719639042 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_719639042.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_719639042;
        // ---------- Original Method ----------
        //return this;
    }

    
}

class ServiceManagerProxy implements IServiceManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.577 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "5E1E2B7D69F0EB092684BFF6D1335CA5")

    private IBinder mRemote;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.578 -0400", hash_original_method = "84032B28A83A581245FB022389F526C9", hash_generated_method = "9C93C75DE81E92FB068744B3E68A0310")
    public  ServiceManagerProxy(IBinder remote) {
        mRemote = remote;
        // ---------- Original Method ----------
        //mRemote = remote;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.579 -0400", hash_original_method = "315E1319E410798CBDE68A27410B7DFB", hash_generated_method = "40214C2C818ADC33F7450DFA013D10EE")
    public IBinder asBinder() {
IBinder varF4936CA84F7841A48B466C9D273BE2EB_1937410119 =         mRemote;
        varF4936CA84F7841A48B466C9D273BE2EB_1937410119.addTaint(taint);
        return varF4936CA84F7841A48B466C9D273BE2EB_1937410119;
        // ---------- Original Method ----------
        //return mRemote;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.580 -0400", hash_original_method = "02C17092CC4D0E934B4324BDE37272C4", hash_generated_method = "0E08383D4DE96D1F2EDEBDC808CD074F")
    public IBinder getService(String name) throws RemoteException {
        addTaint(name.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeString(name);
        mRemote.transact(GET_SERVICE_TRANSACTION, data, reply, 0);
        IBinder binder = reply.readStrongBinder();
        reply.recycle();
        data.recycle();
IBinder varE3C074C8A98249A08331B334269AEB91_1615717823 =         binder;
        varE3C074C8A98249A08331B334269AEB91_1615717823.addTaint(taint);
        return varE3C074C8A98249A08331B334269AEB91_1615717823;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.581 -0400", hash_original_method = "5C8E64034E0715CC0FF2A576ACC0AB5A", hash_generated_method = "D5B3D0ACF4145587277E4BCF50168149")
    public IBinder checkService(String name) throws RemoteException {
        addTaint(name.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        data.writeString(name);
        mRemote.transact(CHECK_SERVICE_TRANSACTION, data, reply, 0);
        IBinder binder = reply.readStrongBinder();
        reply.recycle();
        data.recycle();
IBinder varE3C074C8A98249A08331B334269AEB91_1967078545 =         binder;
        varE3C074C8A98249A08331B334269AEB91_1967078545.addTaint(taint);
        return varE3C074C8A98249A08331B334269AEB91_1967078545;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.582 -0400", hash_original_method = "5E591506D5DD50AD56DFCE9C7D5E988A", hash_generated_method = "3E3A623CDA01464FE8B3824D9E7CA1FC")
    public void addService(String name, IBinder service) throws RemoteException {
        addTaint(service.getTaint());
        addTaint(name.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.583 -0400", hash_original_method = "FC27781B3E4C3CFB72E5AC6A897CA1D1", hash_generated_method = "A1DDD74F329F8AF4991AEF89B928786A")
    public String[] listServices() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        data.writeInterfaceToken(IServiceManager.descriptor);
        mRemote.transact(LIST_SERVICES_TRANSACTION, data, reply, 0);
        String[] list = reply.readStringArray();
        reply.recycle();
        data.recycle();
String[] varED12C351C2E8CA4F85F097DDC7E77B4D_969186809 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_969186809.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_969186809;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.583 -0400", hash_original_method = "8A24F25196050E86CC22CCEE8401DF5F", hash_generated_method = "8AEB568954A68ABA39DE5824232BDB43")
    public void setPermissionController(IPermissionController controller) throws RemoteException {
        addTaint(controller.getTaint());
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
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

