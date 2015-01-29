package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface IServiceManager extends IInterface
{
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public IBinder getService(String name) throws RemoteException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public IBinder checkService(String name) throws RemoteException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void addService(String name, IBinder service) throws RemoteException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String[] listServices() throws RemoteException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setPermissionController(IPermissionController controller)
            throws RemoteException;
    
    static final String descriptor = "android.os.IServiceManager";

    int GET_SERVICE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION;
    int CHECK_SERVICE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+1;
    int ADD_SERVICE_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+2;
    int LIST_SERVICES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+3;
    int CHECK_SERVICES_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+4;
    int SET_PERMISSION_CONTROLLER_TRANSACTION = IBinder.FIRST_CALL_TRANSACTION+5;
}
