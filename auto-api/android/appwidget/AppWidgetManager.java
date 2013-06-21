package android.appwidget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RemoteViews;
import com.android.internal.appwidget.IAppWidgetService;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;

public class AppWidgetManager {
    Context mContext;
    private DisplayMetrics mDisplayMetrics;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.957 -0400", hash_original_method = "28C84B38FB30543E3D37A9D265756E51", hash_generated_method = "A7695A0FFA122EFECF26585F41B1E588")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AppWidgetManager(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mDisplayMetrics = context.getResources().getDisplayMetrics();
        // ---------- Original Method ----------
        //mContext = context;
        //mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    
        public static AppWidgetManager getInstance(Context context) {
        synchronized (sManagerCache) {
            if (sService == null) {
                IBinder b = ServiceManager.getService(Context.APPWIDGET_SERVICE);
                sService = IAppWidgetService.Stub.asInterface(b);
            }
            WeakReference<AppWidgetManager> ref = sManagerCache.get(context);
            AppWidgetManager result = null;
            if (ref != null) {
                result = ref.get();
            }
            if (result == null) {
                result = new AppWidgetManager(context);
                sManagerCache.put(context, new WeakReference<AppWidgetManager>(result));
            }
            return result;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.958 -0400", hash_original_method = "C145E9C7D3CA673896555FC1E9B6614C", hash_generated_method = "9B6D9BB31B9CE9A990BF623F44FC78A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateAppWidget(int[] appWidgetIds, RemoteViews views) {
        dsTaint.addTaint(views.dsTaint);
        dsTaint.addTaint(appWidgetIds[0]);
        try 
        {
            sService.updateAppWidgetIds(appWidgetIds, views);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.updateAppWidgetIds(appWidgetIds, views);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.958 -0400", hash_original_method = "779A0F382601F89CF93810A3753ED0EE", hash_generated_method = "EDF26BE1D836ACD84177ACC1E3A1B5DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateAppWidget(int appWidgetId, RemoteViews views) {
        dsTaint.addTaint(views.dsTaint);
        dsTaint.addTaint(appWidgetId);
        updateAppWidget(new int[] { appWidgetId }, views);
        // ---------- Original Method ----------
        //updateAppWidget(new int[] { appWidgetId }, views);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.958 -0400", hash_original_method = "448529D0A668E34D001BA74CD6140A42", hash_generated_method = "7CCEFF550D906AF3D194F4038E05CFAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void partiallyUpdateAppWidget(int[] appWidgetIds, RemoteViews views) {
        dsTaint.addTaint(views.dsTaint);
        dsTaint.addTaint(appWidgetIds[0]);
        try 
        {
            sService.partiallyUpdateAppWidgetIds(appWidgetIds, views);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.partiallyUpdateAppWidgetIds(appWidgetIds, views);
        //} catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.959 -0400", hash_original_method = "79B313F4E0736B5248A2188C502CE883", hash_generated_method = "6DD743488C4C919A863A6B29BC8E4456")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void partiallyUpdateAppWidget(int appWidgetId, RemoteViews views) {
        dsTaint.addTaint(views.dsTaint);
        dsTaint.addTaint(appWidgetId);
        partiallyUpdateAppWidget(new int[] { appWidgetId }, views);
        // ---------- Original Method ----------
        //partiallyUpdateAppWidget(new int[] { appWidgetId }, views);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.959 -0400", hash_original_method = "E171ADDB89C92A829FC0A5D980C9CF1B", hash_generated_method = "485CF202525AE086D4013339494E1EC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateAppWidget(ComponentName provider, RemoteViews views) {
        dsTaint.addTaint(views.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        try 
        {
            sService.updateAppWidgetProvider(provider, views);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.updateAppWidgetProvider(provider, views);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.959 -0400", hash_original_method = "7C2BF1F364031ACAC78067E68F83C77E", hash_generated_method = "983651674816016A95C9D5E3E27EDA24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyAppWidgetViewDataChanged(int[] appWidgetIds, int viewId) {
        dsTaint.addTaint(appWidgetIds[0]);
        dsTaint.addTaint(viewId);
        try 
        {
            sService.notifyAppWidgetViewDataChanged(appWidgetIds, viewId);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.notifyAppWidgetViewDataChanged(appWidgetIds, viewId);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.960 -0400", hash_original_method = "C96E973D3DD249985D67DC789B41FB05", hash_generated_method = "1824A054FE2B8B16F81A236A94C8157C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyAppWidgetViewDataChanged(int appWidgetId, int viewId) {
        dsTaint.addTaint(appWidgetId);
        dsTaint.addTaint(viewId);
        notifyAppWidgetViewDataChanged(new int[] { appWidgetId }, viewId);
        // ---------- Original Method ----------
        //notifyAppWidgetViewDataChanged(new int[] { appWidgetId }, viewId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.962 -0400", hash_original_method = "3DBC7B8000EA7185811CAD52683B35D0", hash_generated_method = "AEE581C23A68BA3F2DA88514179B4796")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<AppWidgetProviderInfo> getInstalledProviders() {
        try 
        {
            List<AppWidgetProviderInfo> providers;
            providers = sService.getInstalledProviders();
            {
                Iterator<AppWidgetProviderInfo> var490047D6FEF762A9E172F9B01C6A7138_1995084962 = (providers).iterator();
                var490047D6FEF762A9E172F9B01C6A7138_1995084962.hasNext();
                AppWidgetProviderInfo info = var490047D6FEF762A9E172F9B01C6A7138_1995084962.next();
                {
                    info.minWidth =
                        TypedValue.complexToDimensionPixelSize(info.minWidth, mDisplayMetrics);
                    info.minHeight =
                        TypedValue.complexToDimensionPixelSize(info.minHeight, mDisplayMetrics);
                    info.minResizeWidth =
                    TypedValue.complexToDimensionPixelSize(info.minResizeWidth, mDisplayMetrics);
                    info.minResizeHeight =
                    TypedValue.complexToDimensionPixelSize(info.minResizeHeight, mDisplayMetrics);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } //End block
        return (List<AppWidgetProviderInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.963 -0400", hash_original_method = "57B0FB21059F64A76489662CF361FBD9", hash_generated_method = "C86D8EB480CE0E49A04A99C27F4B1B82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AppWidgetProviderInfo getAppWidgetInfo(int appWidgetId) {
        dsTaint.addTaint(appWidgetId);
        try 
        {
            AppWidgetProviderInfo info;
            info = sService.getAppWidgetInfo(appWidgetId);
            {
                info.minWidth =
                        TypedValue.complexToDimensionPixelSize(info.minWidth, mDisplayMetrics);
                info.minHeight =
                        TypedValue.complexToDimensionPixelSize(info.minHeight, mDisplayMetrics);
                info.minResizeWidth =
                    TypedValue.complexToDimensionPixelSize(info.minResizeWidth, mDisplayMetrics);
                info.minResizeHeight =
                    TypedValue.complexToDimensionPixelSize(info.minResizeHeight, mDisplayMetrics);
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } //End block
        return (AppWidgetProviderInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.963 -0400", hash_original_method = "1B2C655DAB3EC9AC1A1945226B92611F", hash_generated_method = "A1207B171C9FBA87DB5A01E7C61300B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bindAppWidgetId(int appWidgetId, ComponentName provider) {
        dsTaint.addTaint(appWidgetId);
        dsTaint.addTaint(provider.dsTaint);
        try 
        {
            sService.bindAppWidgetId(appWidgetId, provider);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.bindAppWidgetId(appWidgetId, provider);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.964 -0400", hash_original_method = "9635C6DE1FB30445E1097958A10AD035", hash_generated_method = "A5D3A009A2944C950795FA0A803C93C8")
    @DSModeled(DSC.SPEC)
    public void bindRemoteViewsService(int appWidgetId, Intent intent, IBinder connection) {
        dsTaint.addTaint(connection.dsTaint);
        dsTaint.addTaint(appWidgetId);
        dsTaint.addTaint(intent.dsTaint);
        try 
        {
            sService.bindRemoteViewsService(appWidgetId, intent, connection);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.bindRemoteViewsService(appWidgetId, intent, connection);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.964 -0400", hash_original_method = "2B1B0C7D3E264A2CA6F28D675EB000CD", hash_generated_method = "8F922F225EB9BBEC3199AE2D8C4AB437")
    @DSModeled(DSC.SPEC)
    public void unbindRemoteViewsService(int appWidgetId, Intent intent) {
        dsTaint.addTaint(appWidgetId);
        dsTaint.addTaint(intent.dsTaint);
        try 
        {
            sService.unbindRemoteViewsService(appWidgetId, intent);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.unbindRemoteViewsService(appWidgetId, intent);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.964 -0400", hash_original_method = "A8A608804967C37EB91DAF26AED4E71B", hash_generated_method = "57304F1C06DCAD323BCE111560DD90F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int[] getAppWidgetIds(ComponentName provider) {
        dsTaint.addTaint(provider.dsTaint);
        try 
        {
            int[] var3E2B13D6168A7D0206465B3AAF79C430_1736607087 = (sService.getAppWidgetIds(provider));
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } //End block
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return sService.getAppWidgetIds(provider);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    static final String TAG = "AppWidgetManager";
    public static final String ACTION_APPWIDGET_PICK = "android.appwidget.action.APPWIDGET_PICK";
    public static final String ACTION_APPWIDGET_CONFIGURE = "android.appwidget.action.APPWIDGET_CONFIGURE";
    public static final String EXTRA_APPWIDGET_ID = "appWidgetId";
    public static final String EXTRA_APPWIDGET_IDS = "appWidgetIds";
    public static final String EXTRA_CUSTOM_INFO = "customInfo";
    public static final String EXTRA_CUSTOM_EXTRAS = "customExtras";
    public static final int INVALID_APPWIDGET_ID = 0;
    public static final String ACTION_APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";
    public static final String ACTION_APPWIDGET_DELETED = "android.appwidget.action.APPWIDGET_DELETED";
    public static final String ACTION_APPWIDGET_DISABLED = "android.appwidget.action.APPWIDGET_DISABLED";
    public static final String ACTION_APPWIDGET_ENABLED = "android.appwidget.action.APPWIDGET_ENABLED";
    public static final String META_DATA_APPWIDGET_PROVIDER = "android.appwidget.provider";
    static WeakHashMap<Context, WeakReference<AppWidgetManager>> sManagerCache =
        new WeakHashMap<Context, WeakReference<AppWidgetManager>>();
    static IAppWidgetService sService;
}

