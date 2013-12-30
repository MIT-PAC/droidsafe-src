package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import android.util.Log;

import com.android.internal.os.BinderInternal;






public final class ServiceManager {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.610 -0500", hash_original_method = "F9571D966715D8BEC70F9E92EB17CF43", hash_generated_method = "766A7A92FFAB823331AD1C30295700FC")
    
private static IServiceManager getIServiceManager() {
        if (sServiceManager != null) {
            return sServiceManager;
        }

        // Find the service manager
        sServiceManager = ServiceManagerNative.asInterface(BinderInternal.getContextObject());
        return sServiceManager;
    }

    /**
     * Returns a reference to a service with the given name.
     * 
     * @param name the name of the service to get
     * @return a reference to the service, or <code>null</code> if the service doesn't exist
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.612 -0500", hash_original_method = "91BCD4EDAD58333F9E1C5C4BE842F493", hash_generated_method = "665A4D9D0C5DB2BBC4F41D2423DF834A")
    
public static IBinder getService(String name) {
        try {
            IBinder service = sCache.get(name);
            if (service != null) {
                return service;
            } else {
                return getIServiceManager().getService(name);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "error in getService", e);
        }
        return null;
    }

    /**
     * Place a new @a service called @a name into the service
     * manager.
     * 
     * @param name the name of the new service
     * @param service the service object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.615 -0500", hash_original_method = "DC016D0CDE3AB9177BFA685B2B713EEE", hash_generated_method = "3DA206A48ED4D12B477A14626E7B6573")
    
public static void addService(String name, IBinder service) {
        try {
            getIServiceManager().addService(name, service);
        } catch (RemoteException e) {
            Log.e(TAG, "error in addService", e);
        }
    }
    
    /**
     * Retrieve an existing service called @a name from the
     * service manager.  Non-blocking.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.617 -0500", hash_original_method = "F39384200C094511E0D76BA57FEA3B98", hash_generated_method = "B0D92FC8866E719A7A052540FDD40F8D")
    
public static IBinder checkService(String name) {
        try {
            IBinder service = sCache.get(name);
            if (service != null) {
                return service;
            } else {
                return getIServiceManager().checkService(name);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "error in checkService", e);
            return null;
        }
    }

    /**
     * Return a list of all currently running services.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.619 -0500", hash_original_method = "FBC240376FAD4D50980C7C25336A97EE", hash_generated_method = "73DB8AE50ED830F8DB18E178AD310B32")
    
public static String[] listServices() throws RemoteException {
        try {
            return getIServiceManager().listServices();
        } catch (RemoteException e) {
            Log.e(TAG, "error in listServices", e);
            return null;
        }
    }

    /**
     * This is only intended to be called when the process is first being brought
     * up and bound by the activity manager. There is only one thread in the process
     * at that time, so no locking is done.
     * 
     * @param cache the cache of service references
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.622 -0500", hash_original_method = "1132B7677F458160633A6DD9E0917F73", hash_generated_method = "1AA07CB7BC0CF0D2253AB41AB16DFC59")
    
public static void initServiceCache(Map<String, IBinder> cache) {
        if (sCache.size() != 0) {
            throw new IllegalStateException("setServiceCache may only be called once");
        }
        sCache.putAll(cache);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.603 -0500", hash_original_field = "62161AF0A9176581D1C26768E8E28F18", hash_generated_field = "D08E65FF3FC18CA9D021769624546E55")

    private static final String TAG = "ServiceManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.605 -0500", hash_original_field = "49E97B67A8135B0FE40C72B6F275884E", hash_generated_field = "3BB7F9DC69203897D3C71ABD26F66EDE")


    private static IServiceManager sServiceManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:32.607 -0500", hash_original_field = "C28D97969055C58044C0252A8704C292", hash_generated_field = "6C748830FB2F6F43238FB57437EDD7E8")

    private static HashMap<String, IBinder> sCache = new HashMap<String, IBinder>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.547 -0400", hash_original_method = "C0ECF0E19363472551754760850E1958", hash_generated_method = "C0ECF0E19363472551754760850E1958")
    public ServiceManager ()
    {
        //Synthesized constructor
    }
}

