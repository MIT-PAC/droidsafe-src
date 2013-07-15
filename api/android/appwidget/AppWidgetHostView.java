package android.appwidget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.531 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.531 -0400", hash_original_field = "43E2B65B3F22B575CF99A5FA17CF3174", hash_generated_field = "2398AF174D0AD1B38433EB4F0C3826A9")

    Context mRemoteContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.531 -0400", hash_original_field = "905A4BBD5E07D0C7A80D7BBC86A773FE", hash_generated_field = "C187677719C4391D45C59B42615D4AC2")

    int mAppWidgetId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.531 -0400", hash_original_field = "1715FF63502BEC0E28C8D7CA89F0F72E", hash_generated_field = "1435437DCA238203A550D7FEA268A3A7")

    AppWidgetProviderInfo mInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.531 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.531 -0400", hash_original_field = "E17869D55D8B642917403BA0AFD91827", hash_generated_field = "EED3242F95ADA8D723AC1C67E2F7BCD0")

    int mViewMode = VIEW_MODE_NOINIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.531 -0400", hash_original_field = "07B760141AB2313155AA4AFCFA145CAB", hash_generated_field = "AC76DC627A00C6D529BB2CA73C4ED642")

    int mLayoutId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.532 -0400", hash_original_field = "3C65A570099EFE7002E56B3AA8E0754B", hash_generated_field = "E1A7BBCE5FAEE0A4FDB6711CF0250012")

    long mFadeStartTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.532 -0400", hash_original_field = "72B180D2D97D58F0A6E7A12B21299482", hash_generated_field = "52668329A8AD44643F40935F478E774E")

    Bitmap mOld;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.532 -0400", hash_original_field = "6CB4678E6104BE2E3D0770F07A60F8D4", hash_generated_field = "A9017732583166AEDC4465732F15D176")

    Paint mOldPaint = new Paint();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.532 -0400", hash_original_method = "D3533BC730DCD2115B028F12761A2C9B", hash_generated_method = "F26A80AAF2A824187FC47FE81EB7807F")
    public  AppWidgetHostView(Context context) {
        this(context, android.R.anim.fade_in, android.R.anim.fade_out);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.533 -0400", hash_original_method = "F3188887919A2B1ED3E7B00286A01B52", hash_generated_method = "136CA60377803D92BB9B27742B07AD7B")
    @SuppressWarnings({"UnusedDeclaration"})
    public  AppWidgetHostView(Context context, int animationIn, int animationOut) {
        super(context);
        addTaint(animationOut);
        addTaint(animationIn);
        mContext = context;
        setIsRootNamespace(true);
        // ---------- Original Method ----------
        //mContext = context;
        //setIsRootNamespace(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.534 -0400", hash_original_method = "F21DF7E5FB86A76CA26E20C03A95533E", hash_generated_method = "CB32FD585665C34317E58443DFC5277A")
    public void setAppWidget(int appWidgetId, AppWidgetProviderInfo info) {
        mAppWidgetId = appWidgetId;
        mInfo = info;
    if(info != null)        
        {
            Rect padding = getDefaultPaddingForWidget(mContext, info.provider, null);
            setPadding(padding.left, padding.top, padding.right, padding.bottom);
        } //End block
        // ---------- Original Method ----------
        //mAppWidgetId = appWidgetId;
        //mInfo = info;
        //if (info != null) {
            //Rect padding = getDefaultPaddingForWidget(mContext, info.provider, null);
            //setPadding(padding.left, padding.top, padding.right, padding.bottom);
        //}
    }

    
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
            return padding;
        }
        if (appInfo.targetSdkVersion >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            Resources r = context.getResources();
            padding.left = r.getDimensionPixelSize(com.android.internal.
                    R.dimen.default_app_widget_padding_left);
            padding.right = r.getDimensionPixelSize(com.android.internal.
                    R.dimen.default_app_widget_padding_right);
            padding.top = r.getDimensionPixelSize(com.android.internal.
                    R.dimen.default_app_widget_padding_top);
            padding.bottom = r.getDimensionPixelSize(com.android.internal.
                    R.dimen.default_app_widget_padding_bottom);
        }
        return padding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.535 -0400", hash_original_method = "523EC9820CA9D9B6EC1AAD0F0C3D4C58", hash_generated_method = "7D4617D75530B0050584F0EA3C734CE7")
    public int getAppWidgetId() {
        int var905A4BBD5E07D0C7A80D7BBC86A773FE_939149883 = (mAppWidgetId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231492696 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_231492696;
        // ---------- Original Method ----------
        //return mAppWidgetId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.535 -0400", hash_original_method = "FF9792E81F5B9850F94285F82FEF7EB6", hash_generated_method = "BADF6804EA53F3ECA51CD22FA7BBD143")
    public AppWidgetProviderInfo getAppWidgetInfo() {
AppWidgetProviderInfo var3A968EAC93D51342CCDD9EFE8723F737_1253630836 =         mInfo;
        var3A968EAC93D51342CCDD9EFE8723F737_1253630836.addTaint(taint);
        return var3A968EAC93D51342CCDD9EFE8723F737_1253630836;
        // ---------- Original Method ----------
        //return mInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.536 -0400", hash_original_method = "CAED7A09C12E7C14DF8180A45912C5C7", hash_generated_method = "88F93933D2227C829E477F6E51A0464B")
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        final ParcelableSparseArray jail = new ParcelableSparseArray();
        super.dispatchSaveInstanceState(jail);
        container.put(generateId(), jail);
        // ---------- Original Method ----------
        //final ParcelableSparseArray jail = new ParcelableSparseArray();
        //super.dispatchSaveInstanceState(jail);
        //container.put(generateId(), jail);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.536 -0400", hash_original_method = "11D592545671EB0AE44582AC9EA105B8", hash_generated_method = "0D76DD4EDF5A3EBE05E3CC8A9BE193E6")
    private int generateId() {
        final int id = getId();
        int var0FB59648925A7BC6C876D2505B11EFEF_605558589 = (id == View.NO_ID ? mAppWidgetId : id);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024359106 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024359106;
        // ---------- Original Method ----------
        //final int id = getId();
        //return id == View.NO_ID ? mAppWidgetId : id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.537 -0400", hash_original_method = "9249C138593FE1EB2CAEA94EA5A08B6D", hash_generated_method = "9EED3A07DF2D60350D873DECA095B554")
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        final Parcelable parcelable = container.get(generateId());
        ParcelableSparseArray jail = null;
    if(parcelable != null && parcelable instanceof ParcelableSparseArray)        
        {
            jail = (ParcelableSparseArray) parcelable;
        } //End block
    if(jail == null)        
        jail = new ParcelableSparseArray();
        super.dispatchRestoreInstanceState(jail);
        // ---------- Original Method ----------
        //final Parcelable parcelable = container.get(generateId());
        //ParcelableSparseArray jail = null;
        //if (parcelable != null && parcelable instanceof ParcelableSparseArray) {
            //jail = (ParcelableSparseArray) parcelable;
        //}
        //if (jail == null) jail = new ParcelableSparseArray();
        //super.dispatchRestoreInstanceState(jail);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.538 -0400", hash_original_method = "C318CB495524FCFBB782D4C68E4F0A8D", hash_generated_method = "9A9E1D9A23FB1B7ABB17FB96B5FDC70C")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
        final Context context = mRemoteContext != null ? mRemoteContext : mContext;
LayoutParams var5C12F614BCDAD79DFD6ABD0FDD1B1EC9_2113820677 =         new FrameLayout.LayoutParams(context, attrs);
        var5C12F614BCDAD79DFD6ABD0FDD1B1EC9_2113820677.addTaint(taint);
        return var5C12F614BCDAD79DFD6ABD0FDD1B1EC9_2113820677;
        // ---------- Original Method ----------
        //final Context context = mRemoteContext != null ? mRemoteContext : mContext;
        //return new FrameLayout.LayoutParams(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.539 -0400", hash_original_method = "8BE5160C40379A67738659300BC656A4", hash_generated_method = "C2BA029743BA7CC450F552DD98EB0229")
     void resetAppWidget(AppWidgetProviderInfo info) {
        mInfo = info;
        mViewMode = VIEW_MODE_NOINIT;
        updateAppWidget(null);
        // ---------- Original Method ----------
        //mInfo = info;
        //mViewMode = VIEW_MODE_NOINIT;
        //updateAppWidget(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.542 -0400", hash_original_method = "25975B2F0B8D4567FA791238963D6584", hash_generated_method = "9CC357C07B547EFE3EBF84CA9F9490D4")
    public void updateAppWidget(RemoteViews remoteViews) {
    if(LOGD)        
        Log.d(TAG, "updateAppWidget called mOld=" + mOld);
        boolean recycled = false;
        View content = null;
        Exception exception = null;
    if(CROSSFADE)        
        {
    if(mFadeStartTime < 0)            
            {
    if(mView != null)                
                {
                    final int width = mView.getWidth();
                    final int height = mView.getHeight();
                    try 
                    {
                        mOld = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    } //End block
                    catch (OutOfMemoryError e)
                    {
                        mOld = null;
                    } //End block
    if(mOld != null)                    
                    {
                    } //End block
                } //End block
            } //End block
        } //End block
    if(remoteViews == null)        
        {
    if(mViewMode == VIEW_MODE_DEFAULT)            
            {
                return;
            } //End block
            content = getDefaultView();
            mLayoutId = -1;
            mViewMode = VIEW_MODE_DEFAULT;
        } //End block
        else
        {
            mRemoteContext = getRemoteContext(remoteViews);
            int layoutId = remoteViews.getLayoutId();
    if(content == null && layoutId == mLayoutId)            
            {
                try 
                {
                    remoteViews.reapply(mContext, mView);
                    content = mView;
                    recycled = true;
    if(LOGD)                    
                    Log.d(TAG, "was able to recycled existing layout");
                } //End block
                catch (RuntimeException e)
                {
                    exception = e;
                } //End block
            } //End block
    if(content == null)            
            {
                try 
                {
                    content = remoteViews.apply(mContext, this);
    if(LOGD)                    
                    Log.d(TAG, "had to inflate new layout");
                } //End block
                catch (RuntimeException e)
                {
                    exception = e;
                } //End block
            } //End block
            mLayoutId = layoutId;
            mViewMode = VIEW_MODE_CONTENT;
        } //End block
    if(content == null)        
        {
    if(mViewMode == VIEW_MODE_ERROR)            
            {
                return;
            } //End block
            content = getErrorView();
            mViewMode = VIEW_MODE_ERROR;
        } //End block
    if(!recycled)        
        {
            prepareView(content);
            addView(content);
        } //End block
    if(mView != content)        
        {
            removeView(mView);
            mView = content;
        } //End block
    if(CROSSFADE)        
        {
    if(mFadeStartTime < 0)            
            {
                mFadeStartTime = SystemClock.uptimeMillis();
                invalidate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.545 -0400", hash_original_method = "8A7676901BF746B47397B4739377B887", hash_generated_method = "CE87891831F789C70C7918C4DB4BE3A8")
     void viewDataChanged(int viewId) {
        addTaint(viewId);
        View v = findViewById(viewId);
    if((v != null) && (v instanceof AdapterView<?>))        
        {
            AdapterView<?> adapterView = (AdapterView<?>) v;
            Adapter adapter = adapterView.getAdapter();
    if(adapter instanceof BaseAdapter)            
            {
                BaseAdapter baseAdapter = (BaseAdapter) adapter;
                baseAdapter.notifyDataSetChanged();
            } //End block
            else
    if(adapter == null && adapterView instanceof RemoteAdapterConnectionCallback)            
            {
                ((RemoteAdapterConnectionCallback) adapterView).deferNotifyDataSetChanged();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //View v = findViewById(viewId);
        //if ((v != null) && (v instanceof AdapterView<?>)) {
            //AdapterView<?> adapterView = (AdapterView<?>) v;
            //Adapter adapter = adapterView.getAdapter();
            //if (adapter instanceof BaseAdapter) {
                //BaseAdapter baseAdapter = (BaseAdapter) adapter;
                //baseAdapter.notifyDataSetChanged();
            //}  else if (adapter == null && adapterView instanceof RemoteAdapterConnectionCallback) {
                //((RemoteAdapterConnectionCallback) adapterView).deferNotifyDataSetChanged();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.548 -0400", hash_original_method = "D246979F206AF74202D8DE4F4ED2EC44", hash_generated_method = "266E4BFA756200A615D105E22924E059")
    private Context getRemoteContext(RemoteViews views) {
        addTaint(views.getTaint());
        final String packageName = views.getPackage();
    if(packageName == null)        
        {
Context var178E2AD52D6FBBB503F908168856B574_1953035098 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_1953035098.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_1953035098;
        }
        try 
        {
Context var15FE925204C6995BDC4863C2BEBDC967_304072381 =             mContext.createPackageContext(packageName, Context.CONTEXT_RESTRICTED);
            var15FE925204C6995BDC4863C2BEBDC967_304072381.addTaint(taint);
            return var15FE925204C6995BDC4863C2BEBDC967_304072381;
        } //End block
        catch (NameNotFoundException e)
        {
Context var178E2AD52D6FBBB503F908168856B574_204667550 =             mContext;
            var178E2AD52D6FBBB503F908168856B574_204667550.addTaint(taint);
            return var178E2AD52D6FBBB503F908168856B574_204667550;
        } //End block
        // ---------- Original Method ----------
        //final String packageName = views.getPackage();
        //if (packageName == null) return mContext;
        //try {
            //return mContext.createPackageContext(packageName, Context.CONTEXT_RESTRICTED);
        //} catch (NameNotFoundException e) {
            //Log.e(TAG, "Package name " + packageName + " not found");
            //return mContext;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.551 -0400", hash_original_method = "5F7FD765CDC0571DEC8D0D27FF96F700", hash_generated_method = "2C231632F498BFCD2A7A1802D3083080")
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        addTaint(drawingTime);
        addTaint(child.getTaint());
        addTaint(canvas.getTaint());
    if(CROSSFADE)        
        {
            int alpha;
            int l = child.getLeft();
            int t = child.getTop();
    if(mFadeStartTime > 0)            
            {
                alpha = (int)(((drawingTime-mFadeStartTime)*255)/FADE_DURATION);
    if(alpha > 255)                
                {
                    alpha = 255;
                } //End block
                Log.d(TAG, "drawChild alpha=" + alpha + " l=" + l + " t=" + t
                        + " w=" + child.getWidth());
    if(alpha != 255 && mOld != null)                
                {
                    mOldPaint.setAlpha(255-alpha);
                } //End block
            } //End block
            else
            {
                alpha = 255;
            } //End block
            int restoreTo = canvas.saveLayerAlpha(l, t, child.getWidth(), child.getHeight(), alpha,
                    Canvas.HAS_ALPHA_LAYER_SAVE_FLAG | Canvas.CLIP_TO_LAYER_SAVE_FLAG);
            boolean rv = super.drawChild(canvas, child, drawingTime);
            canvas.restoreToCount(restoreTo);
    if(alpha < 255)            
            {
                invalidate();
            } //End block
            else
            {
                mFadeStartTime = -1;
    if(mOld != null)                
                {
                    mOld.recycle();
                    mOld = null;
                } //End block
            } //End block
            boolean var108BC7B6961E71B2E770387A378CBC10_1540086321 = (rv);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322798008 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322798008;
        } //End block
        else
        {
            boolean varC1CAB5F89F7BBD877DB44D454088FF65_991653318 = (super.drawChild(canvas, child, drawingTime));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_63131998 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_63131998;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.552 -0400", hash_original_method = "3CF04F67A6E046DD8821A82932E9934D", hash_generated_method = "F80C5275F38B376E550BB3E2A2DFED9B")
    protected void prepareView(View view) {
        addTaint(view.getTaint());
        FrameLayout.LayoutParams requested = (FrameLayout.LayoutParams)view.getLayoutParams();
    if(requested == null)        
        {
            requested = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT);
        } //End block
        requested.gravity = Gravity.CENTER;
        view.setLayoutParams(requested);
        // ---------- Original Method ----------
        //FrameLayout.LayoutParams requested = (FrameLayout.LayoutParams)view.getLayoutParams();
        //if (requested == null) {
            //requested = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                    //LayoutParams.MATCH_PARENT);
        //}
        //requested.gravity = Gravity.CENTER;
        //view.setLayoutParams(requested);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.553 -0400", hash_original_method = "7ABED6F7F1F9E200368B812F1C939889", hash_generated_method = "7C090745010AAE9ABD642E25C60B82F9")
    protected View getDefaultView() {
    if(LOGD)        
        {
            Log.d(TAG, "getDefaultView");
        } //End block
        View defaultView = null;
        Exception exception = null;
        try 
        {
    if(mInfo != null)            
            {
                Context theirContext = mContext.createPackageContext(
                        mInfo.provider.getPackageName(), Context.CONTEXT_RESTRICTED);
                mRemoteContext = theirContext;
                LayoutInflater inflater = (LayoutInflater)
                        theirContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater = inflater.cloneInContext(theirContext);
                inflater.setFilter(sInflaterFilter);
                defaultView = inflater.inflate(mInfo.initialLayout, this, false);
            } //End block
            else
            {
            } //End block
        } //End block
        catch (PackageManager.NameNotFoundException e)
        {
            exception = e;
        } //End block
        catch (RuntimeException e)
        {
            exception = e;
        } //End block
    if(exception != null)        
        {
        } //End block
    if(defaultView == null)        
        {
    if(LOGD)            
            Log.d(TAG, "getDefaultView couldn't find any view, so inflating error");
            defaultView = getErrorView();
        } //End block
View varDA032537A4C8F9680067866F46EBAF02_626481441 =         defaultView;
        varDA032537A4C8F9680067866F46EBAF02_626481441.addTaint(taint);
        return varDA032537A4C8F9680067866F46EBAF02_626481441;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.554 -0400", hash_original_method = "BCED01C90A318EA661B2B3B116D10B95", hash_generated_method = "FB9A940ED6A07DBD285BBC7E7B3FE1F4")
    protected View getErrorView() {
        TextView tv = new TextView(mContext);
        tv.setText(com.android.internal.R.string.gadget_host_error_inflating);
        tv.setBackgroundColor(Color.argb(127, 0, 0, 0));
View var8BB2C09B3FFE775E9F9FBFEC00A28511_97562639 =         tv;
        var8BB2C09B3FFE775E9F9FBFEC00A28511_97562639.addTaint(taint);
        return var8BB2C09B3FFE775E9F9FBFEC00A28511_97562639;
        // ---------- Original Method ----------
        //TextView tv = new TextView(mContext);
        //tv.setText(com.android.internal.R.string.gadget_host_error_inflating);
        //tv.setBackgroundColor(Color.argb(127, 0, 0, 0));
        //return tv;
    }

    
    private static class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.555 -0400", hash_original_method = "545E9F4FFC3CA9F22ED723B298F0D3D0", hash_generated_method = "545E9F4FFC3CA9F22ED723B298F0D3D0")
        public ParcelableSparseArray ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.556 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "AB0373EB2A308473D3F242711BA504DD")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1844620329 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906652406 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906652406;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.556 -0400", hash_original_method = "9373CC647F3D025502C7EB293E3D68C8", hash_generated_method = "6D4EAA31CDFF50119F059BFD5E6425FE")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            final int count = size();
            dest.writeInt(count);
for(int i = 0;i < count;i++)
            {
                dest.writeInt(keyAt(i));
                dest.writeParcelable(valueAt(i), 0);
            } //End block
            // ---------- Original Method ----------
            //final int count = size();
            //dest.writeInt(count);
            //for (int i = 0; i < count; i++) {
                //dest.writeInt(keyAt(i));
                //dest.writeParcelable(valueAt(i), 0);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.557 -0400", hash_original_field = "F5815BC7A5C9A6B88AFFA57767233EFB", hash_generated_field = "B3F10EB5585E69660D628228707CD0EE")

        public static final Parcelable.Creator<ParcelableSparseArray> CREATOR =
                new Parcelable.Creator<ParcelableSparseArray>() {
                    public ParcelableSparseArray createFromParcel(Parcel source) {
                        final ParcelableSparseArray array = new ParcelableSparseArray();
                        final ClassLoader loader = array.getClass().getClassLoader();
                        final int count = source.readInt();
                        for (int i = 0; i < count; i++) {
                            array.put(source.readInt(), source.readParcelable(loader));
                        }
                        return array;
                    }

                    public ParcelableSparseArray[] newArray(int size) {
                        return new ParcelableSparseArray[size];
                    }
                };
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.557 -0400", hash_original_field = "1F410656AF495FF0861F22EDA252470D", hash_generated_field = "D6B7C4B987F35D9DDE3D145EE688DFCE")

    static final String TAG = "AppWidgetHostView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.557 -0400", hash_original_field = "928751A5F820D0540184847C19228178", hash_generated_field = "BFEB05DE2363DCDC9E3DF7C8CCD0F900")

    static final boolean LOGD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.557 -0400", hash_original_field = "79DD27D8E811B7AAD91F16C26B71CFBE", hash_generated_field = "79BFE7DC4EBCF8975387F4AD3344544B")

    static final boolean CROSSFADE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.558 -0400", hash_original_field = "91DE3D2A19797AAC9A3A54C73056B3D9", hash_generated_field = "F7AD4C73992CA1A17A3596C10DDFACE4")

    static final int VIEW_MODE_NOINIT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.558 -0400", hash_original_field = "0F96DDDE8E761A9DC02BCD9C0DC430B9", hash_generated_field = "9A2971924F7CDB718A46A8A14A2164BF")

    static final int VIEW_MODE_CONTENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.558 -0400", hash_original_field = "2C96F5A448CBDEC8562BEC896B8BA0C5", hash_generated_field = "B71CA4BA70FFC9CE03D2F6DF6F6C7C69")

    static final int VIEW_MODE_ERROR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.558 -0400", hash_original_field = "EB0A5E1043ED9B9ABD4AE8A741E5000B", hash_generated_field = "F271F81D3D4FDD7B60DEB1A4DDDEC1F6")

    static final int VIEW_MODE_DEFAULT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.558 -0400", hash_original_field = "6F7CB63B4372A6CA83F1B834C8F1D016", hash_generated_field = "4ED03503C05C610B1278DF7F858B3167")

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
}

