package android.appwidget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;

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

public class AppWidgetManager {

    /**
     * Get the AppWidgetManager instance to use for the supplied {@link android.content.Context
     * Context} object.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.836 -0500", hash_original_method = "B3DF940F92A954D76F9893B692CC4E1A", hash_generated_method = "FBD8819BDCBC06F139EF4AD791BDB899")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.782 -0500", hash_original_field = "BD4D44CF37F125732C772B76426B6D20", hash_generated_field = "15139372293360ACD9E9A83835BD0FA0")

    static final String TAG = "AppWidgetManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.786 -0500", hash_original_field = "87400870E96198DA7AFF768824A796A8", hash_generated_field = "7BC4A0D7F6D2F0CE8CF4473E4F17CB7B")

    public static final String ACTION_APPWIDGET_PICK = "android.appwidget.action.APPWIDGET_PICK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.789 -0500", hash_original_field = "5BCC432367CB35469B8291CE7080A734", hash_generated_field = "29A54DA7185D3A0CEAA0506AFCD7D61A")

    public static final String ACTION_APPWIDGET_CONFIGURE = "android.appwidget.action.APPWIDGET_CONFIGURE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.792 -0500", hash_original_field = "CB4B0EF4E24195BB25004FB9BE8E4D04", hash_generated_field = "52451755173E1A1B4473C68640162184")

    public static final String EXTRA_APPWIDGET_ID = "appWidgetId";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.795 -0500", hash_original_field = "D37299407D1A76F9A2975BC29CA5250E", hash_generated_field = "73164F65E977B1F66D53A6ACB849657A")

    public static final String EXTRA_APPWIDGET_IDS = "appWidgetIds";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.798 -0500", hash_original_field = "5EA13C06BAD21E9F009DB96D670629CE", hash_generated_field = "924E3ADA2E904BB5ADEBF5CB89F944EA")

    public static final String EXTRA_CUSTOM_INFO = "customInfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.801 -0500", hash_original_field = "F1226F5E13E704B96DC19645B76F3C02", hash_generated_field = "93CEB6820FD68708571774119B5AC9F9")

    public static final String EXTRA_CUSTOM_EXTRAS = "customExtras";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.804 -0500", hash_original_field = "372AE719309B2563816AF700F593B0E8", hash_generated_field = "D430C3C2767B1DD0CFF07E35CFCBE524")

    public static final int INVALID_APPWIDGET_ID = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.808 -0500", hash_original_field = "889285C7257FFBE51BAD97570F46D5BC", hash_generated_field = "79D69A68DD4D290B1A0D0CC4F800242C")

    public static final String ACTION_APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.811 -0500", hash_original_field = "0CE73108192C6A34E4E05A2D9A95A9FF", hash_generated_field = "E6187DA9D91BF610B3718FD8D9CD1063")

    public static final String ACTION_APPWIDGET_DELETED = "android.appwidget.action.APPWIDGET_DELETED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.814 -0500", hash_original_field = "61975161196D98852A249EC44BC9CF9E", hash_generated_field = "A82A18271537E5E2DB298E9514466058")

    public static final String ACTION_APPWIDGET_DISABLED = "android.appwidget.action.APPWIDGET_DISABLED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.817 -0500", hash_original_field = "4AAD7795F47E6B77E10F79FD70A41BA8", hash_generated_field = "059545A14A98B547028206A792CBA912")

    public static final String ACTION_APPWIDGET_ENABLED = "android.appwidget.action.APPWIDGET_ENABLED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.821 -0500", hash_original_field = "C040B4CF60BAB696F3BE9B1BC6E20B1F", hash_generated_field = "FA9432FC0CCE081BF1D65FA63172BCB7")

    public static final String META_DATA_APPWIDGET_PROVIDER = "android.appwidget.provider";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.824 -0500", hash_original_field = "EBC000C84EFA17F58F5DA2CEB61814F2", hash_generated_field = "5D686610412372E030953571637E228C")

    static WeakHashMap<Context, WeakReference<AppWidgetManager>> sManagerCache =
        new WeakHashMap<Context, WeakReference<AppWidgetManager>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.827 -0500", hash_original_field = "7BEAA5F14979DBA9A1EB5C251A94638F", hash_generated_field = "94920F0617D8341AD26C68E1EE00A15C")

    static IAppWidgetService sService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.830 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.833 -0500", hash_original_field = "04C1AD4CD176D3E2FCA1F38653BFD089", hash_generated_field = "D677A4323A370A58C33D323A072CFE1B")

    private DisplayMetrics mDisplayMetrics;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.839 -0500", hash_original_method = "28C84B38FB30543E3D37A9D265756E51", hash_generated_method = "28C41E57995342459E5B2F477FA6DD69")
    
private AppWidgetManager(Context context) {
        mContext = context;
        mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    /**
     * Set the RemoteViews to use for the specified appWidgetIds.
     *
     * Note that the RemoteViews parameter will be cached by the AppWidgetService, and hence should
     * contain a complete representation of the widget. For performing partial widget updates, see
     * {@link #partiallyUpdateAppWidget(int[], RemoteViews)}.
     *
     * <p>
     * It is okay to call this method both inside an {@link #ACTION_APPWIDGET_UPDATE} broadcast,
     * and outside of the handler.
     * This method will only work when called from the uid that owns the AppWidget provider.
     *
     * @param appWidgetIds     The AppWidget instances for which to set the RemoteViews.
     * @param views         The RemoteViews object to show.
     */
    @DSComment("Request update on remote view")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.842 -0500", hash_original_method = "C145E9C7D3CA673896555FC1E9B6614C", hash_generated_method = "CF3C48A2B5433CB1B9F054F36DD33C3C")
    
public void updateAppWidget(int[] appWidgetIds, RemoteViews views) {
        try {
            sService.updateAppWidgetIds(appWidgetIds, views);
        }
        catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    /**
     * Set the RemoteViews to use for the specified appWidgetId.
     *
     * Note that the RemoteViews parameter will be cached by the AppWidgetService, and hence should
     * contain a complete representation of the widget. For performing partial widget updates, see
     * {@link #partiallyUpdateAppWidget(int, RemoteViews)}.
     *
     * <p>
     * It is okay to call this method both inside an {@link #ACTION_APPWIDGET_UPDATE} broadcast,
     * and outside of the handler.
     * This method will only work when called from the uid that owns the AppWidget provider.
     *
     * @param appWidgetId      The AppWidget instance for which to set the RemoteViews.
     * @param views         The RemoteViews object to show.
     */
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.845 -0500", hash_original_method = "779A0F382601F89CF93810A3753ED0EE", hash_generated_method = "D5BA8051AFB8D90F24D576EC7BAF20E1")
    
public void updateAppWidget(int appWidgetId, RemoteViews views) {
        updateAppWidget(new int[] { appWidgetId }, views);
    }

    /**
     * Perform an incremental update or command on the widget(s) specified by appWidgetIds.
     *
     * This update  differs from {@link #updateAppWidget(int[], RemoteViews)} in that the
     * RemoteViews object which is passed is understood to be an incomplete representation of the 
     * widget, and hence is not cached by the AppWidgetService. Note that because these updates are 
     * not cached, any state that they modify that is not restored by restoreInstanceState will not
     * persist in the case that the widgets are restored using the cached version in
     * AppWidgetService.
     *
     * Use with {@link RemoteViews#showNext(int)}, {@link RemoteViews#showPrevious(int)},
     * {@link RemoteViews#setScrollPosition(int, int)} and similar commands.
     *
     * <p>
     * It is okay to call this method both inside an {@link #ACTION_APPWIDGET_UPDATE} broadcast,
     * and outside of the handler.
     * This method will only work when called from the uid that owns the AppWidget provider.
     *
     * @param appWidgetIds     The AppWidget instances for which to set the RemoteViews.
     * @param views            The RemoteViews object containing the incremental update / command.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.849 -0500", hash_original_method = "448529D0A668E34D001BA74CD6140A42", hash_generated_method = "23C11067BD87228EC1C79B735C4E742D")
    
public void partiallyUpdateAppWidget(int[] appWidgetIds, RemoteViews views) {
        try {
            sService.partiallyUpdateAppWidgetIds(appWidgetIds, views);
        } catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    /**
     * Perform an incremental update or command on the widget specified by appWidgetId.
     *
     * This update  differs from {@link #updateAppWidget(int, RemoteViews)} in that the RemoteViews
     * object which is passed is understood to be an incomplete representation of the widget, and
     * hence is not cached by the AppWidgetService. Note that because these updates are not cached,
     * any state that they modify that is not restored by restoreInstanceState will not persist in
     * the case that the widgets are restored using the cached version in AppWidgetService.
     *
     * Use with {@link RemoteViews#showNext(int)}, {@link RemoteViews#showPrevious(int)},
     * {@link RemoteViews#setScrollPosition(int, int)} and similar commands.
     *
     * <p>
     * It is okay to call this method both inside an {@link #ACTION_APPWIDGET_UPDATE} broadcast,
     * and outside of the handler.
     * This method will only work when called from the uid that owns the AppWidget provider.
     *
     * @param appWidgetId      The AppWidget instance for which to set the RemoteViews.
     * @param views            The RemoteViews object containing the incremental update / command.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.852 -0500", hash_original_method = "79B313F4E0736B5248A2188C502CE883", hash_generated_method = "8B9C955201546757512D650BA7044796")
    
public void partiallyUpdateAppWidget(int appWidgetId, RemoteViews views) {
        partiallyUpdateAppWidget(new int[] { appWidgetId }, views);
    }

    /**
     * Set the RemoteViews to use for all AppWidget instances for the supplied AppWidget provider.
     *
     * <p>
     * It is okay to call this method both inside an {@link #ACTION_APPWIDGET_UPDATE} broadcast,
     * and outside of the handler.
     * This method will only work when called from the uid that owns the AppWidget provider.
     *
     * @param provider      The {@link ComponentName} for the {@link
     * android.content.BroadcastReceiver BroadcastReceiver} provider
     *                      for your AppWidget.
     * @param views         The RemoteViews object to show.
     */
    
    @DSComment("Request update on remote view")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.855 -0500", hash_original_method = "E171ADDB89C92A829FC0A5D980C9CF1B", hash_generated_method = "853134522A21D08D57F15F190C06DF1F")
    
public void updateAppWidget(ComponentName provider, RemoteViews views) {
        try {
            sService.updateAppWidgetProvider(provider, views);
        }
        catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    /**
     * Notifies the specified collection view in all the specified AppWidget instances
     * to invalidate their currently data.
     *
     * @param appWidgetIds  The AppWidget instances for which to notify of view data changes.
     * @param viewId        The collection view id.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.857 -0500", hash_original_method = "7C2BF1F364031ACAC78067E68F83C77E", hash_generated_method = "DBC8946E26182285CBFCD652E9A61948")
    
public void notifyAppWidgetViewDataChanged(int[] appWidgetIds, int viewId) {
        try {
            sService.notifyAppWidgetViewDataChanged(appWidgetIds, viewId);
        }
        catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    /**
     * Notifies the specified collection view in all the specified AppWidget instance
     * to invalidate it's currently data.
     *
     * @param appWidgetId  The AppWidget instance for which to notify of view data changes.
     * @param viewId        The collection view id.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.860 -0500", hash_original_method = "C96E973D3DD249985D67DC789B41FB05", hash_generated_method = "49FA704FE1EBD1FB743F960B79C013B7")
    
public void notifyAppWidgetViewDataChanged(int appWidgetId, int viewId) {
        notifyAppWidgetViewDataChanged(new int[] { appWidgetId }, viewId);
    }

    /**
     * Return a list of the AppWidget providers that are currently installed.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.863 -0500", hash_original_method = "3DBC7B8000EA7185811CAD52683B35D0", hash_generated_method = "112169541D7F940EBE8A4B72359681AA")
    
public List<AppWidgetProviderInfo> getInstalledProviders() {
        try {
            List<AppWidgetProviderInfo> providers = sService.getInstalledProviders();
            for (AppWidgetProviderInfo info : providers) {
                // Converting complex to dp.
                info.minWidth =
                        TypedValue.complexToDimensionPixelSize(info.minWidth, mDisplayMetrics);
                info.minHeight =
                        TypedValue.complexToDimensionPixelSize(info.minHeight, mDisplayMetrics);
                info.minResizeWidth =
                    TypedValue.complexToDimensionPixelSize(info.minResizeWidth, mDisplayMetrics);
                info.minResizeHeight =
                    TypedValue.complexToDimensionPixelSize(info.minResizeHeight, mDisplayMetrics);
            }
            return providers;
        }
        catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    /**
     * Get the available info about the AppWidget.
     *
     * @return A appWidgetId.  If the appWidgetId has not been bound to a provider yet, or
     * you don't have access to that appWidgetId, null is returned.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.867 -0500", hash_original_method = "57B0FB21059F64A76489662CF361FBD9", hash_generated_method = "187662D62236692025123F6003B36470")
    
public AppWidgetProviderInfo getAppWidgetInfo(int appWidgetId) {
        try {
            AppWidgetProviderInfo info = sService.getAppWidgetInfo(appWidgetId);
            if (info != null) {
                // Converting complex to dp.
                info.minWidth =
                        TypedValue.complexToDimensionPixelSize(info.minWidth, mDisplayMetrics);
                info.minHeight =
                        TypedValue.complexToDimensionPixelSize(info.minHeight, mDisplayMetrics);
                info.minResizeWidth =
                    TypedValue.complexToDimensionPixelSize(info.minResizeWidth, mDisplayMetrics);
                info.minResizeHeight =
                    TypedValue.complexToDimensionPixelSize(info.minResizeHeight, mDisplayMetrics);
            }
            return info;
        }
        catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    /**
     * Set the component for a given appWidgetId.
     *
     * <p class="note">You need the APPWIDGET_LIST permission.  This method is to be used by the
     * AppWidget picker.
     *
     * @param appWidgetId     The AppWidget instance for which to set the RemoteViews.
     * @param provider      The {@link android.content.BroadcastReceiver} that will be the AppWidget
     *                      provider for this AppWidget.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.870 -0500", hash_original_method = "1B2C655DAB3EC9AC1A1945226B92611F", hash_generated_method = "7A82EE1E230AFFAA2F73B70B12376610")
    
public void bindAppWidgetId(int appWidgetId, ComponentName provider) {
        try {
            sService.bindAppWidgetId(appWidgetId, provider);
        }
        catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    /**
     * Binds the RemoteViewsService for a given appWidgetId and intent.
     *
     * The appWidgetId specified must already be bound to the calling AppWidgetHost via
     * {@link android.appwidget.AppWidgetManager#bindAppWidgetId AppWidgetManager.bindAppWidgetId()}.
     *
     * @param appWidgetId   The AppWidget instance for which to bind the RemoteViewsService.
     * @param intent        The intent of the service which will be providing the data to the
     *                      RemoteViewsAdapter.
     * @param connection    The callback interface to be notified when a connection is made or lost.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.873 -0500", hash_original_method = "9635C6DE1FB30445E1097958A10AD035", hash_generated_method = "5C4D50551BECB7C9C7C040341B9A562B")
    
public void bindRemoteViewsService(int appWidgetId, Intent intent, IBinder connection) {
        try {
            sService.bindRemoteViewsService(appWidgetId, intent, connection);
        }
        catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    /**
     * Unbinds the RemoteViewsService for a given appWidgetId and intent.
     *
     * The appWidgetId specified muse already be bound to the calling AppWidgetHost via
     * {@link android.appwidget.AppWidgetManager#bindAppWidgetId AppWidgetManager.bindAppWidgetId()}.
     *
     * @param appWidgetId   The AppWidget instance for which to bind the RemoteViewsService.
     * @param intent        The intent of the service which will be providing the data to the
     *                      RemoteViewsAdapter.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.876 -0500", hash_original_method = "2B1B0C7D3E264A2CA6F28D675EB000CD", hash_generated_method = "73C5ECA991904249736DD08F7C642F75")
    
public void unbindRemoteViewsService(int appWidgetId, Intent intent) {
        try {
            sService.unbindRemoteViewsService(appWidgetId, intent);
        }
        catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }

    /**
     * Get the list of appWidgetIds that have been bound to the given AppWidget
     * provider.
     *
     * @param provider The {@link android.content.BroadcastReceiver} that is the
     *            AppWidget provider to find appWidgetIds for.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.879 -0500", hash_original_method = "A8A608804967C37EB91DAF26AED4E71B", hash_generated_method = "EBB6C66BAE2A4CCABAEDA2DBEF6D8A88")
    
public int[] getAppWidgetIds(ComponentName provider) {
        try {
            return sService.getAppWidgetIds(provider);
        }
        catch (RemoteException e) {
            throw new RuntimeException("system server dead?", e);
        }
    }
}

