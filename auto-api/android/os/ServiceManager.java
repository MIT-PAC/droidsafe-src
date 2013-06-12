package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.os.BinderInternal;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public final class ServiceManager {
    private static String TAG = "ServiceManager";
    private static IServiceManager sServiceManager;
    private static HashMap<String, IBinder> sCache = new HashMap<String, IBinder>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:32:45.698 -0400", hash_original_method = "F9571D966715D8BEC70F9E92EB17CF43", hash_generated_method = "CFE9E8F9607728329F25F02D79CB7280")
    private static IServiceManager getIServiceManager() {
        if (sServiceManager != null) {
            return sServiceManager;
        }
        sServiceManager = ServiceManagerNative.asInterface(BinderInternal.getContextObject());
        return sServiceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:32:45.724 -0400", hash_original_method = "91BCD4EDAD58333F9E1C5C4BE842F493", hash_generated_method = "665A4D9D0C5DB2BBC4F41D2423DF834A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:32:45.755 -0400", hash_original_method = "DC016D0CDE3AB9177BFA685B2B713EEE", hash_generated_method = "3DA206A48ED4D12B477A14626E7B6573")
    public static void addService(String name, IBinder service) {
        try {
            getIServiceManager().addService(name, service);
        } catch (RemoteException e) {
            Log.e(TAG, "error in addService", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:32:45.801 -0400", hash_original_method = "F39384200C094511E0D76BA57FEA3B98", hash_generated_method = "B0D92FC8866E719A7A052540FDD40F8D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:32:45.832 -0400", hash_original_method = "FBC240376FAD4D50980C7C25336A97EE", hash_generated_method = "73DB8AE50ED830F8DB18E178AD310B32")
    public static String[] listServices() throws RemoteException {
        try {
            return getIServiceManager().listServices();
        } catch (RemoteException e) {
            Log.e(TAG, "error in listServices", e);
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:32:45.847 -0400", hash_original_method = "1132B7677F458160633A6DD9E0917F73", hash_generated_method = "1AA07CB7BC0CF0D2253AB41AB16DFC59")
    public static void initServiceCache(Map<String, IBinder> cache) {
        if (sCache.size() != 0) {
            throw new IllegalStateException("setServiceCache may only be called once");
        }
        sCache.putAll(cache);
    }

    
}


