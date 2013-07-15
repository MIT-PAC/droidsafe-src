package android.appwidget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.588 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.589 -0400", hash_original_field = "46173670FA3604779A1C1CD98CB30E8E", hash_generated_field = "D677A4323A370A58C33D323A072CFE1B")

    private DisplayMetrics mDisplayMetrics;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.589 -0400", hash_original_method = "28C84B38FB30543E3D37A9D265756E51", hash_generated_method = "391E3BBAB453694FA7CFC5C70B85397B")
    private  AppWidgetManager(Context context) {
        mContext = context;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.590 -0400", hash_original_method = "C145E9C7D3CA673896555FC1E9B6614C", hash_generated_method = "A696D9AEAE801AFB7F99E71C3640275C")
    public void updateAppWidget(int[] appWidgetIds, RemoteViews views) {
        addTaint(views.getTaint());
        addTaint(appWidgetIds[0]);
        try 
        {
            sService.updateAppWidgetIds(appWidgetIds, views);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varABEC9A7B26F3E87DC5BFEE65B55DFEA5_633417877 = new RuntimeException("system server dead?", e);
            varABEC9A7B26F3E87DC5BFEE65B55DFEA5_633417877.addTaint(taint);
            throw varABEC9A7B26F3E87DC5BFEE65B55DFEA5_633417877;
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.updateAppWidgetIds(appWidgetIds, views);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.591 -0400", hash_original_method = "779A0F382601F89CF93810A3753ED0EE", hash_generated_method = "AE997A55F0668489CF43FD541C8DF2F5")
    public void updateAppWidget(int appWidgetId, RemoteViews views) {
        addTaint(views.getTaint());
        addTaint(appWidgetId);
        updateAppWidget(new int[] { appWidgetId }, views);
        // ---------- Original Method ----------
        //updateAppWidget(new int[] { appWidgetId }, views);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.592 -0400", hash_original_method = "448529D0A668E34D001BA74CD6140A42", hash_generated_method = "00D23D75E45BE5A485C1984DFC44E212")
    public void partiallyUpdateAppWidget(int[] appWidgetIds, RemoteViews views) {
        addTaint(views.getTaint());
        addTaint(appWidgetIds[0]);
        try 
        {
            sService.partiallyUpdateAppWidgetIds(appWidgetIds, views);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varABEC9A7B26F3E87DC5BFEE65B55DFEA5_2035418157 = new RuntimeException("system server dead?", e);
            varABEC9A7B26F3E87DC5BFEE65B55DFEA5_2035418157.addTaint(taint);
            throw varABEC9A7B26F3E87DC5BFEE65B55DFEA5_2035418157;
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.partiallyUpdateAppWidgetIds(appWidgetIds, views);
        //} catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.593 -0400", hash_original_method = "79B313F4E0736B5248A2188C502CE883", hash_generated_method = "1B34C9FDE2360E35E9AF90A825EB4D71")
    public void partiallyUpdateAppWidget(int appWidgetId, RemoteViews views) {
        addTaint(views.getTaint());
        addTaint(appWidgetId);
        partiallyUpdateAppWidget(new int[] { appWidgetId }, views);
        // ---------- Original Method ----------
        //partiallyUpdateAppWidget(new int[] { appWidgetId }, views);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.594 -0400", hash_original_method = "E171ADDB89C92A829FC0A5D980C9CF1B", hash_generated_method = "AF27A223CC36AA10B8C45E5B840EA3F4")
    public void updateAppWidget(ComponentName provider, RemoteViews views) {
        addTaint(views.getTaint());
        addTaint(provider.getTaint());
        try 
        {
            sService.updateAppWidgetProvider(provider, views);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varABEC9A7B26F3E87DC5BFEE65B55DFEA5_594559172 = new RuntimeException("system server dead?", e);
            varABEC9A7B26F3E87DC5BFEE65B55DFEA5_594559172.addTaint(taint);
            throw varABEC9A7B26F3E87DC5BFEE65B55DFEA5_594559172;
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.updateAppWidgetProvider(provider, views);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.594 -0400", hash_original_method = "7C2BF1F364031ACAC78067E68F83C77E", hash_generated_method = "05E3353C70E551004EBC551408CCA0AA")
    public void notifyAppWidgetViewDataChanged(int[] appWidgetIds, int viewId) {
        addTaint(viewId);
        addTaint(appWidgetIds[0]);
        try 
        {
            sService.notifyAppWidgetViewDataChanged(appWidgetIds, viewId);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1563005453 = new RuntimeException("system server dead?", e);
            varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1563005453.addTaint(taint);
            throw varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1563005453;
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.notifyAppWidgetViewDataChanged(appWidgetIds, viewId);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.595 -0400", hash_original_method = "C96E973D3DD249985D67DC789B41FB05", hash_generated_method = "9A5DD218EC3DCC36718CDA76CD8E7F10")
    public void notifyAppWidgetViewDataChanged(int appWidgetId, int viewId) {
        addTaint(viewId);
        addTaint(appWidgetId);
        notifyAppWidgetViewDataChanged(new int[] { appWidgetId }, viewId);
        // ---------- Original Method ----------
        //notifyAppWidgetViewDataChanged(new int[] { appWidgetId }, viewId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.596 -0400", hash_original_method = "3DBC7B8000EA7185811CAD52683B35D0", hash_generated_method = "7FB3DF486F098A955BA7CE21567FB2E7")
    public List<AppWidgetProviderInfo> getInstalledProviders() {
        try 
        {
            List<AppWidgetProviderInfo> providers = sService.getInstalledProviders();
for(AppWidgetProviderInfo info : providers)
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
List<AppWidgetProviderInfo> var3B775FE7F2FF95C6330A1E6EB6B9F5B9_943780120 =             providers;
            var3B775FE7F2FF95C6330A1E6EB6B9F5B9_943780120.addTaint(taint);
            return var3B775FE7F2FF95C6330A1E6EB6B9F5B9_943780120;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1579662804 = new RuntimeException("system server dead?", e);
            varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1579662804.addTaint(taint);
            throw varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1579662804;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.597 -0400", hash_original_method = "57B0FB21059F64A76489662CF361FBD9", hash_generated_method = "CC8543F4426EF38742D9A6EE912E9D9D")
    public AppWidgetProviderInfo getAppWidgetInfo(int appWidgetId) {
        addTaint(appWidgetId);
        try 
        {
            AppWidgetProviderInfo info = sService.getAppWidgetInfo(appWidgetId);
    if(info != null)            
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
AppWidgetProviderInfo var43CF3338FDBA93597A9562D3166E9DC4_898835708 =             info;
            var43CF3338FDBA93597A9562D3166E9DC4_898835708.addTaint(taint);
            return var43CF3338FDBA93597A9562D3166E9DC4_898835708;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varABEC9A7B26F3E87DC5BFEE65B55DFEA5_392832337 = new RuntimeException("system server dead?", e);
            varABEC9A7B26F3E87DC5BFEE65B55DFEA5_392832337.addTaint(taint);
            throw varABEC9A7B26F3E87DC5BFEE65B55DFEA5_392832337;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.598 -0400", hash_original_method = "1B2C655DAB3EC9AC1A1945226B92611F", hash_generated_method = "FA4740B259A3C863ABDF0AB843C0BB75")
    public void bindAppWidgetId(int appWidgetId, ComponentName provider) {
        addTaint(provider.getTaint());
        addTaint(appWidgetId);
        try 
        {
            sService.bindAppWidgetId(appWidgetId, provider);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varABEC9A7B26F3E87DC5BFEE65B55DFEA5_504941757 = new RuntimeException("system server dead?", e);
            varABEC9A7B26F3E87DC5BFEE65B55DFEA5_504941757.addTaint(taint);
            throw varABEC9A7B26F3E87DC5BFEE65B55DFEA5_504941757;
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.bindAppWidgetId(appWidgetId, provider);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.598 -0400", hash_original_method = "9635C6DE1FB30445E1097958A10AD035", hash_generated_method = "E9EF2767187386DC3B3F2F081F9E479E")
    public void bindRemoteViewsService(int appWidgetId, Intent intent, IBinder connection) {
        addTaint(connection.getTaint());
        addTaint(intent.getTaint());
        addTaint(appWidgetId);
        try 
        {
            sService.bindRemoteViewsService(appWidgetId, intent, connection);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varABEC9A7B26F3E87DC5BFEE65B55DFEA5_835985464 = new RuntimeException("system server dead?", e);
            varABEC9A7B26F3E87DC5BFEE65B55DFEA5_835985464.addTaint(taint);
            throw varABEC9A7B26F3E87DC5BFEE65B55DFEA5_835985464;
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.bindRemoteViewsService(appWidgetId, intent, connection);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.599 -0400", hash_original_method = "2B1B0C7D3E264A2CA6F28D675EB000CD", hash_generated_method = "BACC0304AFAC3A12204CEB6A8FE0CA6F")
    public void unbindRemoteViewsService(int appWidgetId, Intent intent) {
        addTaint(intent.getTaint());
        addTaint(appWidgetId);
        try 
        {
            sService.unbindRemoteViewsService(appWidgetId, intent);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1159219904 = new RuntimeException("system server dead?", e);
            varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1159219904.addTaint(taint);
            throw varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1159219904;
        } //End block
        // ---------- Original Method ----------
        //try {
            //sService.unbindRemoteViewsService(appWidgetId, intent);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.600 -0400", hash_original_method = "A8A608804967C37EB91DAF26AED4E71B", hash_generated_method = "3B72C8C73A00837831A433B6EC7EB11E")
    public int[] getAppWidgetIds(ComponentName provider) {
        addTaint(provider.getTaint());
        try 
        {
            int[] var7A304031DD3CDC39433CA437344F1C53_115777924 = (sService.getAppWidgetIds(provider));
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_256955011 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_256955011;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1003184538 = new RuntimeException("system server dead?", e);
            varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1003184538.addTaint(taint);
            throw varABEC9A7B26F3E87DC5BFEE65B55DFEA5_1003184538;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sService.getAppWidgetIds(provider);
        //}
        //catch (RemoteException e) {
            //throw new RuntimeException("system server dead?", e);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.600 -0400", hash_original_field = "795F9047B90EBBAA8DD532999939B96E", hash_generated_field = "15139372293360ACD9E9A83835BD0FA0")

    static final String TAG = "AppWidgetManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.600 -0400", hash_original_field = "C55308E41B22C1F02FC6CDB8F9371D13", hash_generated_field = "7BC4A0D7F6D2F0CE8CF4473E4F17CB7B")

    public static final String ACTION_APPWIDGET_PICK = "android.appwidget.action.APPWIDGET_PICK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.600 -0400", hash_original_field = "6EC2602C81F0C4C7298F5911CBE65163", hash_generated_field = "29A54DA7185D3A0CEAA0506AFCD7D61A")

    public static final String ACTION_APPWIDGET_CONFIGURE = "android.appwidget.action.APPWIDGET_CONFIGURE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.600 -0400", hash_original_field = "C4B1973CD15276A409706125632BFE9C", hash_generated_field = "52451755173E1A1B4473C68640162184")

    public static final String EXTRA_APPWIDGET_ID = "appWidgetId";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.600 -0400", hash_original_field = "0C3ACD3E77F90A71643E5447E87602E6", hash_generated_field = "73164F65E977B1F66D53A6ACB849657A")

    public static final String EXTRA_APPWIDGET_IDS = "appWidgetIds";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.601 -0400", hash_original_field = "7615F8F82E42524FD15F2C86C5EABEF7", hash_generated_field = "924E3ADA2E904BB5ADEBF5CB89F944EA")

    public static final String EXTRA_CUSTOM_INFO = "customInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.601 -0400", hash_original_field = "09299703EA991D1306DD11776A7EB82C", hash_generated_field = "93CEB6820FD68708571774119B5AC9F9")

    public static final String EXTRA_CUSTOM_EXTRAS = "customExtras";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.601 -0400", hash_original_field = "10C8C0FE3A8347726FCDA88A12A6255C", hash_generated_field = "D430C3C2767B1DD0CFF07E35CFCBE524")

    public static final int INVALID_APPWIDGET_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.601 -0400", hash_original_field = "34949A35273A12BEB825121813253A07", hash_generated_field = "79D69A68DD4D290B1A0D0CC4F800242C")

    public static final String ACTION_APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.601 -0400", hash_original_field = "727C2C041DE8CE5B5EAC9B562528386D", hash_generated_field = "E6187DA9D91BF610B3718FD8D9CD1063")

    public static final String ACTION_APPWIDGET_DELETED = "android.appwidget.action.APPWIDGET_DELETED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.601 -0400", hash_original_field = "D0E73C7C5563140B22208037D53AF741", hash_generated_field = "A82A18271537E5E2DB298E9514466058")

    public static final String ACTION_APPWIDGET_DISABLED = "android.appwidget.action.APPWIDGET_DISABLED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.601 -0400", hash_original_field = "02AEE62A2A7753E16151F0585758F1A8", hash_generated_field = "059545A14A98B547028206A792CBA912")

    public static final String ACTION_APPWIDGET_ENABLED = "android.appwidget.action.APPWIDGET_ENABLED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.601 -0400", hash_original_field = "2F045640BA06DA36D78354E60287EF32", hash_generated_field = "FA9432FC0CCE081BF1D65FA63172BCB7")

    public static final String META_DATA_APPWIDGET_PROVIDER = "android.appwidget.provider";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.602 -0400", hash_original_field = "44DD7412DD271B84DF2E2A4F52D99187", hash_generated_field = "5D686610412372E030953571637E228C")

    static WeakHashMap<Context, WeakReference<AppWidgetManager>> sManagerCache = new WeakHashMap<Context, WeakReference<AppWidgetManager>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.602 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "94920F0617D8341AD26C68E1EE00A15C")

    static IAppWidgetService sService;
}

