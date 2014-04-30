package android.appwidget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback;
import android.widget.TextView;

public class AppWidgetHostView extends FrameLayout {

    /**
     * As of ICE_CREAM_SANDWICH we are automatically adding padding to widgets targeting
     * ICE_CREAM_SANDWICH and higher. The new widget design guidelines strongly recommend
     * that widget developers do not add extra padding to their widgets. This will help
     * achieve consistency among widgets.
     *
     * Note: this method is only needed by developers of AppWidgetHosts. The method is provided in
     * order for the AppWidgetHost to account for the automatic padding when computing the number
     * of cells to allocate to a particular widget.
     *
     * @param context the current context
     * @param component the component name of the widget
     * @param padding Rect in which to place the output, if null, a new Rect will be allocated and
     *                returned
     * @return default padding for this widget
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.289 -0500", hash_original_method = "B8C74F371A57AFB639B19B5C3B488D27", hash_generated_method = "515FE23CFB2A00F84A98824E0CDC1225")
    
public static Rect getDefaultPaddingForWidget(Context context, ComponentName component,
            Rect padding) {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo appInfo;

        if (padding == null) {
            padding = new Rect(0, 0, 0, 0);
        } else {
            padding.set(0, 0, 0, 0);
        }

        try {
            appInfo = packageManager.getApplicationInfo(component.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            // if we can't find the package, return 0 padding
            return padding;
        }

        if (appInfo.targetSdkVersion >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            Resources r = context.getResources();
            padding.addTaint(r.getDimensionPixelSize(com.android.internal.R.dimen.default_app_widget_padding_left) +
                   r.getDimensionPixelSize(com.android.internal.R.dimen.default_app_widget_padding_right) + 
                    r.getDimensionPixelSize(com.android.internal.R.dimen.default_app_widget_padding_bottom) + 
                    r.getDimensionPixelSize(com.android.internal.R.dimen.default_app_widget_padding_top));  
        }
        return padding;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.214 -0500", hash_original_field = "CC70414FF6F2D19CD15DD1B1E6270E7D", hash_generated_field = "D6B7C4B987F35D9DDE3D145EE688DFCE")

    static final String TAG = "AppWidgetHostView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.217 -0500", hash_original_field = "D4ECFFBD11965A74CC5370FCF966AD54", hash_generated_field = "BFEB05DE2363DCDC9E3DF7C8CCD0F900")

    static final boolean LOGD = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.220 -0500", hash_original_field = "D6CF6944B018DD7CE269260F707B3657", hash_generated_field = "79BFE7DC4EBCF8975387F4AD3344544B")

    static final boolean CROSSFADE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.223 -0500", hash_original_field = "A433FEFB2165ED723E4749A4FD28A8E6", hash_generated_field = "F7AD4C73992CA1A17A3596C10DDFACE4")

    static final int VIEW_MODE_NOINIT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.227 -0500", hash_original_field = "AAAE873E4D5D3B2BBD6A2F85CBEA76B8", hash_generated_field = "9A2971924F7CDB718A46A8A14A2164BF")

    static final int VIEW_MODE_CONTENT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.230 -0500", hash_original_field = "754330C10EE5B83CB46792F8A44330EB", hash_generated_field = "B71CA4BA70FFC9CE03D2F6DF6F6C7C69")

    static final int VIEW_MODE_ERROR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.233 -0500", hash_original_field = "4F83D36BC181716E8A79EC96A7DF02A8", hash_generated_field = "F271F81D3D4FDD7B60DEB1A4DDDEC1F6")

    static final int VIEW_MODE_DEFAULT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.236 -0500", hash_original_field = "292A865B82BE52F595A5567827D8A4A4", hash_generated_field = "4ED03503C05C610B1278DF7F858B3167")

    static final int FADE_DURATION = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.916 -0400", hash_original_field = "AB1AD5AD9EFC37F946612C1704046BB6", hash_generated_field = "A5276D8BCCAE3AF74C059FB37DDF3DEF")

    static final LayoutInflater.Filter sInflaterFilter = new LayoutInflater.Filter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.916 -0400", hash_original_method = "F477B2C7A46FC6FC036CB698F9A6F774", hash_generated_method = "1B683B60B4AD6DEBDC1B0BCB27CC0F2B")
        public boolean onLoadClass(Class clazz) {
            
            boolean varA10EEDB5B362CDB8AEA79625767F60A9_575585635 = (clazz.isAnnotationPresent(RemoteViews.RemoteView.class));
            addTaint(clazz.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_681207852 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_681207852;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.247 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.250 -0500", hash_original_field = "2398AF174D0AD1B38433EB4F0C3826A9", hash_generated_field = "2398AF174D0AD1B38433EB4F0C3826A9")

    Context mRemoteContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.253 -0500", hash_original_field = "C187677719C4391D45C59B42615D4AC2", hash_generated_field = "C187677719C4391D45C59B42615D4AC2")

    int mAppWidgetId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.256 -0500", hash_original_field = "1435437DCA238203A550D7FEA268A3A7", hash_generated_field = "1435437DCA238203A550D7FEA268A3A7")

    AppWidgetProviderInfo mInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.260 -0500", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.263 -0500", hash_original_field = "EED3242F95ADA8D723AC1C67E2F7BCD0", hash_generated_field = "EED3242F95ADA8D723AC1C67E2F7BCD0")

    int mViewMode = VIEW_MODE_NOINIT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.266 -0500", hash_original_field = "AC76DC627A00C6D529BB2CA73C4ED642", hash_generated_field = "AC76DC627A00C6D529BB2CA73C4ED642")

    int mLayoutId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.269 -0500", hash_original_field = "E1A7BBCE5FAEE0A4FDB6711CF0250012", hash_generated_field = "E1A7BBCE5FAEE0A4FDB6711CF0250012")

    long mFadeStartTime = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.272 -0500", hash_original_field = "52668329A8AD44643F40935F478E774E", hash_generated_field = "52668329A8AD44643F40935F478E774E")

    Bitmap mOld;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.275 -0500", hash_original_field = "A9017732583166AEDC4465732F15D176", hash_generated_field = "A9017732583166AEDC4465732F15D176")

    Paint mOldPaint = new Paint();
    
    /**
     * Create a host view.  Uses default fade animations.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.279 -0500", hash_original_method = "D3533BC730DCD2115B028F12761A2C9B", hash_generated_method = "7F50C522F4B68CA7E0C0A921198A7547")
    
public AppWidgetHostView(Context context) {
        this(context, android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /**
     * Create a host view. Uses specified animations when pushing
     * {@link #updateAppWidget(RemoteViews)}.
     * 
     * @param animationIn Resource ID of in animation to use
     * @param animationOut Resource ID of out animation to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.282 -0500", hash_original_method = "F3188887919A2B1ED3E7B00286A01B52", hash_generated_method = "C351F72170E6239FA1A62AC00339195C")
    
@SuppressWarnings({"UnusedDeclaration"})
    public AppWidgetHostView(Context context, int animationIn, int animationOut) {
        super(context);
        mContext = context;

        // We want to segregate the view ids within AppWidgets to prevent
        // problems when those ids collide with view ids in the AppWidgetHost.
        setIsRootNamespace(true);
    }

    /**
     * Set the AppWidget that will be displayed by this view. This method also adds default padding
     * to widgets, as described in {@link #getDefaultPaddingForWidget(Context, ComponentName, Rect)}
     * and can be overridden in order to add custom padding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.286 -0500", hash_original_method = "F21DF7E5FB86A76CA26E20C03A95533E", hash_generated_method = "4EC513E23623115A1F5CFA19E6936CBE")
    
public void setAppWidget(int appWidgetId, AppWidgetProviderInfo info) {
        mAppWidgetId = appWidgetId;
        mInfo = info;

        // Sometimes the AppWidgetManager returns a null AppWidgetProviderInfo object for
        // a widget, eg. for some widgets in safe mode.
        if (info != null) {
            // We add padding to the AppWidgetHostView if necessary
            Rect padding = getDefaultPaddingForWidget(mContext, info.provider, null);
            setPadding(padding.left, padding.top, padding.right, padding.bottom);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.292 -0500", hash_original_method = "523EC9820CA9D9B6EC1AAD0F0C3D4C58", hash_generated_method = "FC650BC77E07DB97B4FA15FA76A18E59")
    
public int getAppWidgetId() {
        return mAppWidgetId;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.297 -0500", hash_original_method = "FF9792E81F5B9850F94285F82FEF7EB6", hash_generated_method = "0B72448D9371593290B2FC833C8312DB")
    
public AppWidgetProviderInfo getAppWidgetInfo() {
        return mInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.300 -0500", hash_original_method = "CAED7A09C12E7C14DF8180A45912C5C7", hash_generated_method = "DD549EE1566FD62C6634201E0F0EE321")
    
@Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        final ParcelableSparseArray jail = new ParcelableSparseArray();
        super.dispatchSaveInstanceState(jail);
        container.put(generateId(), jail);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.303 -0500", hash_original_method = "11D592545671EB0AE44582AC9EA105B8", hash_generated_method = "7D2DCB7D8AF2943E5C896DE4C95E4242")
    
private int generateId() {
        final int id = getId();
        return (mAppWidgetId + id);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.306 -0500", hash_original_method = "9249C138593FE1EB2CAEA94EA5A08B6D", hash_generated_method = "1224F5B1E7A48675964760C9C9D46D1C")
    
@Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        final Parcelable parcelable = container.get(generateId());

        ParcelableSparseArray jail = null;
        if (parcelable != null && parcelable instanceof ParcelableSparseArray) {
            jail = (ParcelableSparseArray) parcelable;
        }

        if (jail == null) jail = new ParcelableSparseArray();

        super.dispatchRestoreInstanceState(jail);
    }
    
    private static class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.705 -0400", hash_original_field = "F5815BC7A5C9A6B88AFFA57767233EFB", hash_generated_field = "B3F10EB5585E69660D628228707CD0EE")

        public static final Parcelable.Creator<ParcelableSparseArray> CREATOR =
                new Parcelable.Creator<ParcelableSparseArray>() {
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.348 -0500", hash_original_method = "3205CF4E54D89354D52F839F1E99A1A2", hash_generated_method = "467BB9ECCEFE2242B9A388E9ECB88876")
            
public ParcelableSparseArray createFromParcel(Parcel source) {
                        final ParcelableSparseArray array = new ParcelableSparseArray();
                        final ClassLoader loader = array.getClass().getClassLoader();
                        final int count = source.readInt();
                        for (int i = 0; i < count; i++) {
                            array.put(source.readInt(), source.readParcelable(loader));
                        }
                        return array;
                    }

                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.351 -0500", hash_original_method = "D62D1778F6B43A91D597E96F716C0B43", hash_generated_method = "DAF63C220A429FFA489A6658B1524E5D")
            
public ParcelableSparseArray[] newArray(int size) {
                        return new ParcelableSparseArray[size];
                    }
                };
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.704 -0400", hash_original_method = "545E9F4FFC3CA9F22ED723B298F0D3D0", hash_generated_method = "545E9F4FFC3CA9F22ED723B298F0D3D0")
        public ParcelableSparseArray ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.340 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.344 -0500", hash_original_method = "9373CC647F3D025502C7EB293E3D68C8", hash_generated_method = "BFF3F1D2770EDE4CEC9749526795CC3B")
        
public void writeToParcel(Parcel dest, int flags) {
            final int count = size();
            dest.writeInt(count);
            for (int i = 0; i < count; i++) {
                dest.writeInt(keyAt(i));
                dest.writeParcelable(valueAt(i), 0);
            }
        }
        // orphaned legacy method
        public ParcelableSparseArray createFromParcel(Parcel source) {
                        final ParcelableSparseArray array = new ParcelableSparseArray();
                        final ClassLoader loader = array.getClass().getClassLoader();
                        final int count = source.readInt();
                        for (int i = 0; i < count; i++) {
                            array.put(source.readInt(), source.readParcelable(loader));
                        }
                        return array;
                    }
        
        // orphaned legacy method
        public ParcelableSparseArray[] newArray(int size) {
                        return new ParcelableSparseArray[size];
                    }
        
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.309 -0500", hash_original_method = "C318CB495524FCFBB782D4C68E4F0A8D", hash_generated_method = "4A556AEF25246BAD35E4182FC57BEB75")
    
@Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        // We're being asked to inflate parameters, probably by a LayoutInflater
        // in a remote Context. To help resolve any remote references, we
        // inflate through our last mRemoteContext when it exists.
        final Context context = mRemoteContext != null ? mRemoteContext : mContext;
        return new FrameLayout.LayoutParams(context, attrs);
    }

    /**
     * Update the AppWidgetProviderInfo for this view, and reset it to the
     * initial layout.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.312 -0500", hash_original_method = "8BE5160C40379A67738659300BC656A4", hash_generated_method = "8BE5160C40379A67738659300BC656A4")
    
void resetAppWidget(AppWidgetProviderInfo info) {
        mInfo = info;
        mViewMode = VIEW_MODE_NOINIT;
        updateAppWidget(null);
    }

    /**
     * Process a set of {@link RemoteViews} coming in as an update from the
     * AppWidget provider. Will animate into these new views as needed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.317 -0500", hash_original_method = "25975B2F0B8D4567FA791238963D6584", hash_generated_method = "0C817F7B6C6EE899E0A15B061CC26A59")
    
public void updateAppWidget(RemoteViews remoteViews) {
        if (LOGD) Log.d(TAG, "updateAppWidget called mOld=" + mOld);

        boolean recycled = false;
        View content = null;
        Exception exception = null;
        
        // Capture the old view into a bitmap so we can do the crossfade.
        if (CROSSFADE) {
            if (mFadeStartTime < 0) {
                if (mView != null) {
                    final int width = mView.getWidth();
                    final int height = mView.getHeight();
                    try {
                        mOld = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError e) {
                        // we just won't do the fade
                        mOld = null;
                    }
                    if (mOld != null) {
                        //mView.drawIntoBitmap(mOld);
                    }
                }
            }
        }
        
        if (remoteViews == null) {
            if (mViewMode == VIEW_MODE_DEFAULT) {
                // We've already done this -- nothing to do.
                return;
            }
            content = getDefaultView();
            mLayoutId = -1;
            mViewMode = VIEW_MODE_DEFAULT;
        } else {
            // Prepare a local reference to the remote Context so we're ready to
            // inflate any requested LayoutParams.
            mRemoteContext = getRemoteContext(remoteViews);
            int layoutId = remoteViews.getLayoutId();

            // If our stale view has been prepared to match active, and the new
            // layout matches, try recycling it
            if (content == null && layoutId == mLayoutId) {
                try {
                    remoteViews.reapply(mContext, mView);
                    content = mView;
                    recycled = true;
                    if (LOGD) Log.d(TAG, "was able to recycled existing layout");
                } catch (RuntimeException e) {
                    exception = e;
                }
            }
            
            // Try normal RemoteView inflation
            if (content == null) {
                try {
                    content = remoteViews.apply(mContext, this);
                    if (LOGD) Log.d(TAG, "had to inflate new layout");
                } catch (RuntimeException e) {
                    exception = e;
                }
            }

            mLayoutId = layoutId;
            mViewMode = VIEW_MODE_CONTENT;
        }
        
        if (content == null) {
            if (mViewMode == VIEW_MODE_ERROR) {
                // We've already done this -- nothing to do.
                return ;
            }
            Log.w(TAG, "updateAppWidget couldn't find any view, using error view", exception);
            content = getErrorView();
            mViewMode = VIEW_MODE_ERROR;
        }
        
        if (!recycled) {
            prepareView(content);
            addView(content);
        }

        if (mView != content) {
            removeView(mView);
            mView = content;
        }

        if (CROSSFADE) {
            if (mFadeStartTime < 0) {
                // if there is already an animation in progress, don't do anything --
                // the new view will pop in on top of the old one during the cross fade,
                // and that looks okay.
                mFadeStartTime = SystemClock.uptimeMillis();
                invalidate();
            }
        }
    }

    /**
     * Process data-changed notifications for the specified view in the specified
     * set of {@link RemoteViews} views.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.320 -0500", hash_original_method = "8A7676901BF746B47397B4739377B887", hash_generated_method = "A2ACB4BEE4EB98666512CFACCC922F1F")
    
void viewDataChanged(int viewId) {
        View v = findViewById(viewId);
        if ((v != null) && (v instanceof AdapterView<?>)) {
            AdapterView<?> adapterView = (AdapterView<?>) v;
            Adapter adapter = adapterView.getAdapter();
            if (adapter instanceof BaseAdapter) {
                BaseAdapter baseAdapter = (BaseAdapter) adapter;
                baseAdapter.notifyDataSetChanged();
            }  else if (adapter == null && adapterView instanceof RemoteAdapterConnectionCallback) {
                // If the adapter is null, it may mean that the RemoteViewsAapter has not yet
                // connected to its associated service, and hence the adapter hasn't been set.
                // In this case, we need to defer the notify call until it has been set.
                ((RemoteAdapterConnectionCallback) adapterView).deferNotifyDataSetChanged();
            }
        }
    }

    /**
     * Build a {@link Context} cloned into another package name, usually for the
     * purposes of reading remote resources.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.323 -0500", hash_original_method = "D246979F206AF74202D8DE4F4ED2EC44", hash_generated_method = "C2DDC85515C9FF1B8C3027D79EF1D24B")
    
private Context getRemoteContext(RemoteViews views) {
        // Bail if missing package name
        final String packageName = views.getPackage();
        if (packageName == null) return mContext;

        try {
            // Return if cloned successfully, otherwise default
            return mContext.createPackageContext(packageName, Context.CONTEXT_RESTRICTED);
        } catch (NameNotFoundException e) {
            Log.e(TAG, "Package name " + packageName + " not found");
            return mContext;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.327 -0500", hash_original_method = "5F7FD765CDC0571DEC8D0D27FF96F700", hash_generated_method = "BCCA16B5AB7E99AB5987ACFE5D1B2ECD")
    
@Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        if (CROSSFADE) {
            int alpha;
            int l = child.getLeft();
            int t = child.getTop();
            if (mFadeStartTime > 0) {
                alpha = (int)(((drawingTime-mFadeStartTime)*255)/FADE_DURATION);
                if (alpha > 255) {
                    alpha = 255;
                }
                Log.d(TAG, "drawChild alpha=" + alpha + " l=" + l + " t=" + t
                        + " w=" + child.getWidth());
                if (alpha != 255 && mOld != null) {
                    mOldPaint.setAlpha(255-alpha);
                    //canvas.drawBitmap(mOld, l, t, mOldPaint);
                }
            } else {
                alpha = 255;
            }
            int restoreTo = canvas.saveLayerAlpha(l, t, child.getWidth(), child.getHeight(), alpha,
                    Canvas.HAS_ALPHA_LAYER_SAVE_FLAG | Canvas.CLIP_TO_LAYER_SAVE_FLAG);
            boolean rv = super.drawChild(canvas, child, drawingTime);
            canvas.restoreToCount(restoreTo);
            if (alpha < 255) {
                invalidate();
            } else {
                mFadeStartTime = -1;
                if (mOld != null) {
                    mOld.recycle();
                    mOld = null;
                }
            }
            return rv;
        } else {
            return super.drawChild(canvas, child, drawingTime);
        }
    }
    
    /**
     * Prepare the given view to be shown. This might include adjusting
     * {@link FrameLayout.LayoutParams} before inserting.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.330 -0500", hash_original_method = "3CF04F67A6E046DD8821A82932E9934D", hash_generated_method = "71A97065E086D508054B2BB90CF6989B")
    
protected void prepareView(View view) {
        // Take requested dimensions from child, but apply default gravity.
        FrameLayout.LayoutParams requested = (FrameLayout.LayoutParams)view.getLayoutParams();
        if (requested == null) {
            requested = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT);
        }

        requested.gravity = Gravity.CENTER;
        view.setLayoutParams(requested);
    }
    
    /**
     * Inflate and return the default layout requested by AppWidget provider.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.333 -0500", hash_original_method = "7ABED6F7F1F9E200368B812F1C939889", hash_generated_method = "718C9FAB9FEED095A4025ABA05BE3400")
    
protected View getDefaultView() {
        if (LOGD) {
            Log.d(TAG, "getDefaultView");
        }
        View defaultView = null;
        Exception exception = null;
        
        try {
            if (mInfo != null) {
                Context theirContext = mContext.createPackageContext(
                        mInfo.provider.getPackageName(), Context.CONTEXT_RESTRICTED);
                mRemoteContext = theirContext;
                LayoutInflater inflater = (LayoutInflater)
                        theirContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater = inflater.cloneInContext(theirContext);
                inflater.setFilter(sInflaterFilter);
                defaultView = inflater.inflate(mInfo.initialLayout, this, false);
            } else {
                Log.w(TAG, "can't inflate defaultView because mInfo is missing");
            }
        } catch (PackageManager.NameNotFoundException e) {
            exception = e;
        } catch (RuntimeException e) {
            exception = e;
        }
        
        if (exception != null) {
            Log.w(TAG, "Error inflating AppWidget " + mInfo + ": " + exception.toString());
        }
        
        if (defaultView == null) {
            if (LOGD) Log.d(TAG, "getDefaultView couldn't find any view, so inflating error");
            defaultView = getErrorView();
        }
        
        return defaultView;
    }
    
    /**
     * Inflate and return a view that represents an error state.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:55.336 -0500", hash_original_method = "BCED01C90A318EA661B2B3B116D10B95", hash_generated_method = "BA35D9B9C456C174E063C5725DE72D03")
    
protected View getErrorView() {
        TextView tv = new TextView(mContext);
        tv.setText(com.android.internal.R.string.gadget_host_error_inflating);
        // TODO: get this color from somewhere.
        tv.setBackgroundColor(Color.argb(127, 0, 0, 0));
        return tv;
    }
}

