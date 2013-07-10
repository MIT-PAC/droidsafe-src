package android.appwidget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.944 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.944 -0400", hash_original_field = "46173670FA3604779A1C1CD98CB30E8E", hash_generated_field = "D677A4323A370A58C33D323A072CFE1B")

    private DisplayMetrics mDisplayMetrics;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.944 -0400", hash_original_method = "28C84B38FB30543E3D37A9D265756E51", hash_generated_method = "391E3BBAB453694FA7CFC5C70B85397B")
    private  AppWidgetManager(Context context) {
        mContext = context;
        mDisplayMetrics = context.getResources().getDisplayMetrics();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.945 -0400", hash_original_method = "C145E9C7D3CA673896555FC1E9B6614C", hash_generated_method = "4E75448DCB6A8B9B6C58F7797F6B56DB")
    public void updateAppWidget(int[] appWidgetIds, RemoteViews views) {
        try 
        {
            sService.updateAppWidgetIds(appWidgetIds, views);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } 
        addTaint(appWidgetIds[0]);
        addTaint(views.getTaint());
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.946 -0400", hash_original_method = "779A0F382601F89CF93810A3753ED0EE", hash_generated_method = "259DBC6BC4063451DE57241D3B22A0D0")
    public void updateAppWidget(int appWidgetId, RemoteViews views) {
        updateAppWidget(new int[] { appWidgetId }, views);
        addTaint(appWidgetId);
        addTaint(views.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.946 -0400", hash_original_method = "448529D0A668E34D001BA74CD6140A42", hash_generated_method = "425F32A99CB4379DFBFBAF5D37BB7B2C")
    public void partiallyUpdateAppWidget(int[] appWidgetIds, RemoteViews views) {
        try 
        {
            sService.partiallyUpdateAppWidgetIds(appWidgetIds, views);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } 
        addTaint(appWidgetIds[0]);
        addTaint(views.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.947 -0400", hash_original_method = "79B313F4E0736B5248A2188C502CE883", hash_generated_method = "4D304565F6AAA45FE45AF7BCCE448F61")
    public void partiallyUpdateAppWidget(int appWidgetId, RemoteViews views) {
        partiallyUpdateAppWidget(new int[] { appWidgetId }, views);
        addTaint(appWidgetId);
        addTaint(views.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.948 -0400", hash_original_method = "E171ADDB89C92A829FC0A5D980C9CF1B", hash_generated_method = "BFC7BE365D3EA1C397D214BFBA2499A7")
    public void updateAppWidget(ComponentName provider, RemoteViews views) {
        try 
        {
            sService.updateAppWidgetProvider(provider, views);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } 
        addTaint(provider.getTaint());
        addTaint(views.getTaint());
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.948 -0400", hash_original_method = "7C2BF1F364031ACAC78067E68F83C77E", hash_generated_method = "7B8CF863FE4F0ACB21E6ED215A1114A0")
    public void notifyAppWidgetViewDataChanged(int[] appWidgetIds, int viewId) {
        try 
        {
            sService.notifyAppWidgetViewDataChanged(appWidgetIds, viewId);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } 
        addTaint(appWidgetIds[0]);
        addTaint(viewId);
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.948 -0400", hash_original_method = "C96E973D3DD249985D67DC789B41FB05", hash_generated_method = "1E9FE83E9138D7DA0BAF6881F9C3E652")
    public void notifyAppWidgetViewDataChanged(int appWidgetId, int viewId) {
        notifyAppWidgetViewDataChanged(new int[] { appWidgetId }, viewId);
        addTaint(appWidgetId);
        addTaint(viewId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.951 -0400", hash_original_method = "3DBC7B8000EA7185811CAD52683B35D0", hash_generated_method = "E7786716154DE987F66DF2A66A779C67")
    public List<AppWidgetProviderInfo> getInstalledProviders() {
        List<AppWidgetProviderInfo> varB4EAC82CA7396A68D541C85D26508E83_1981535176 = null; 
        try 
        {
            List<AppWidgetProviderInfo> providers = sService.getInstalledProviders();
            {
                Iterator<AppWidgetProviderInfo> var490047D6FEF762A9E172F9B01C6A7138_787307172 = (providers).iterator();
                var490047D6FEF762A9E172F9B01C6A7138_787307172.hasNext();
                AppWidgetProviderInfo info = var490047D6FEF762A9E172F9B01C6A7138_787307172.next();
                {
                    info.minWidth =
                        TypedValue.complexToDimensionPixelSize(info.minWidth, mDisplayMetrics);
                    info.minHeight =
                        TypedValue.complexToDimensionPixelSize(info.minHeight, mDisplayMetrics);
                    info.minResizeWidth =
                    TypedValue.complexToDimensionPixelSize(info.minResizeWidth, mDisplayMetrics);
                    info.minResizeHeight =
                    TypedValue.complexToDimensionPixelSize(info.minResizeHeight, mDisplayMetrics);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1981535176 = providers;
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1981535176.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1981535176;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.953 -0400", hash_original_method = "57B0FB21059F64A76489662CF361FBD9", hash_generated_method = "EA2F3F6C422753AF782512493E88058A")
    public AppWidgetProviderInfo getAppWidgetInfo(int appWidgetId) {
        AppWidgetProviderInfo varB4EAC82CA7396A68D541C85D26508E83_1972098304 = null; 
        try 
        {
            AppWidgetProviderInfo info = sService.getAppWidgetInfo(appWidgetId);
            {
                info.minWidth =
                        TypedValue.complexToDimensionPixelSize(info.minWidth, mDisplayMetrics);
                info.minHeight =
                        TypedValue.complexToDimensionPixelSize(info.minHeight, mDisplayMetrics);
                info.minResizeWidth =
                    TypedValue.complexToDimensionPixelSize(info.minResizeWidth, mDisplayMetrics);
                info.minResizeHeight =
                    TypedValue.complexToDimensionPixelSize(info.minResizeHeight, mDisplayMetrics);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1972098304 = info;
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } 
        addTaint(appWidgetId);
        varB4EAC82CA7396A68D541C85D26508E83_1972098304.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1972098304;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.953 -0400", hash_original_method = "1B2C655DAB3EC9AC1A1945226B92611F", hash_generated_method = "807EB520C7684D37E55B92C9CF1CF8C1")
    public void bindAppWidgetId(int appWidgetId, ComponentName provider) {
        try 
        {
            sService.bindAppWidgetId(appWidgetId, provider);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } 
        addTaint(appWidgetId);
        addTaint(provider.getTaint());
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.954 -0400", hash_original_method = "9635C6DE1FB30445E1097958A10AD035", hash_generated_method = "298C091155C6ED85D34088E10E30A2CA")
    public void bindRemoteViewsService(int appWidgetId, Intent intent, IBinder connection) {
        try 
        {
            sService.bindRemoteViewsService(appWidgetId, intent, connection);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } 
        addTaint(appWidgetId);
        addTaint(intent.getTaint());
        addTaint(connection.getTaint());
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.954 -0400", hash_original_method = "2B1B0C7D3E264A2CA6F28D675EB000CD", hash_generated_method = "54AAA5A8ABD34120EC9E572782A129F1")
    public void unbindRemoteViewsService(int appWidgetId, Intent intent) {
        try 
        {
            sService.unbindRemoteViewsService(appWidgetId, intent);
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } 
        addTaint(appWidgetId);
        addTaint(intent.getTaint());
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_method = "A8A608804967C37EB91DAF26AED4E71B", hash_generated_method = "1614FDD22E2D9FD0F0A5B05866249B0B")
    public int[] getAppWidgetIds(ComponentName provider) {
        try 
        {
            int[] var3E2B13D6168A7D0206465B3AAF79C430_464039626 = (sService.getAppWidgetIds(provider));
        } 
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("system server dead?", e);
        } 
        addTaint(provider.getTaint());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_959031888 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_959031888;
        
        
            
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "795F9047B90EBBAA8DD532999939B96E", hash_generated_field = "15139372293360ACD9E9A83835BD0FA0")

    static final String TAG = "AppWidgetManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "C55308E41B22C1F02FC6CDB8F9371D13", hash_generated_field = "7BC4A0D7F6D2F0CE8CF4473E4F17CB7B")

    public static final String ACTION_APPWIDGET_PICK = "android.appwidget.action.APPWIDGET_PICK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "6EC2602C81F0C4C7298F5911CBE65163", hash_generated_field = "29A54DA7185D3A0CEAA0506AFCD7D61A")

    public static final String ACTION_APPWIDGET_CONFIGURE = "android.appwidget.action.APPWIDGET_CONFIGURE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "C4B1973CD15276A409706125632BFE9C", hash_generated_field = "52451755173E1A1B4473C68640162184")

    public static final String EXTRA_APPWIDGET_ID = "appWidgetId";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "0C3ACD3E77F90A71643E5447E87602E6", hash_generated_field = "73164F65E977B1F66D53A6ACB849657A")

    public static final String EXTRA_APPWIDGET_IDS = "appWidgetIds";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "7615F8F82E42524FD15F2C86C5EABEF7", hash_generated_field = "924E3ADA2E904BB5ADEBF5CB89F944EA")

    public static final String EXTRA_CUSTOM_INFO = "customInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "09299703EA991D1306DD11776A7EB82C", hash_generated_field = "93CEB6820FD68708571774119B5AC9F9")

    public static final String EXTRA_CUSTOM_EXTRAS = "customExtras";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "10C8C0FE3A8347726FCDA88A12A6255C", hash_generated_field = "D430C3C2767B1DD0CFF07E35CFCBE524")

    public static final int INVALID_APPWIDGET_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "34949A35273A12BEB825121813253A07", hash_generated_field = "79D69A68DD4D290B1A0D0CC4F800242C")

    public static final String ACTION_APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "727C2C041DE8CE5B5EAC9B562528386D", hash_generated_field = "E6187DA9D91BF610B3718FD8D9CD1063")

    public static final String ACTION_APPWIDGET_DELETED = "android.appwidget.action.APPWIDGET_DELETED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "D0E73C7C5563140B22208037D53AF741", hash_generated_field = "A82A18271537E5E2DB298E9514466058")

    public static final String ACTION_APPWIDGET_DISABLED = "android.appwidget.action.APPWIDGET_DISABLED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "02AEE62A2A7753E16151F0585758F1A8", hash_generated_field = "059545A14A98B547028206A792CBA912")

    public static final String ACTION_APPWIDGET_ENABLED = "android.appwidget.action.APPWIDGET_ENABLED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.955 -0400", hash_original_field = "2F045640BA06DA36D78354E60287EF32", hash_generated_field = "FA9432FC0CCE081BF1D65FA63172BCB7")

    public static final String META_DATA_APPWIDGET_PROVIDER = "android.appwidget.provider";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.956 -0400", hash_original_field = "44DD7412DD271B84DF2E2A4F52D99187", hash_generated_field = "5D686610412372E030953571637E228C")

    static WeakHashMap<Context, WeakReference<AppWidgetManager>> sManagerCache = new WeakHashMap<Context, WeakReference<AppWidgetManager>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.956 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "94920F0617D8341AD26C68E1EE00A15C")

    static IAppWidgetService sService;
}

