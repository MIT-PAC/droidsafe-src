package android.appwidget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.898 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.898 -0400", hash_original_field = "43E2B65B3F22B575CF99A5FA17CF3174", hash_generated_field = "2398AF174D0AD1B38433EB4F0C3826A9")

    Context mRemoteContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.898 -0400", hash_original_field = "905A4BBD5E07D0C7A80D7BBC86A773FE", hash_generated_field = "C187677719C4391D45C59B42615D4AC2")

    int mAppWidgetId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.898 -0400", hash_original_field = "1715FF63502BEC0E28C8D7CA89F0F72E", hash_generated_field = "1435437DCA238203A550D7FEA268A3A7")

    AppWidgetProviderInfo mInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.898 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.898 -0400", hash_original_field = "E17869D55D8B642917403BA0AFD91827", hash_generated_field = "EED3242F95ADA8D723AC1C67E2F7BCD0")

    int mViewMode = VIEW_MODE_NOINIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.898 -0400", hash_original_field = "07B760141AB2313155AA4AFCFA145CAB", hash_generated_field = "AC76DC627A00C6D529BB2CA73C4ED642")

    int mLayoutId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.898 -0400", hash_original_field = "3C65A570099EFE7002E56B3AA8E0754B", hash_generated_field = "E1A7BBCE5FAEE0A4FDB6711CF0250012")

    long mFadeStartTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.898 -0400", hash_original_field = "72B180D2D97D58F0A6E7A12B21299482", hash_generated_field = "52668329A8AD44643F40935F478E774E")

    Bitmap mOld;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.898 -0400", hash_original_field = "6CB4678E6104BE2E3D0770F07A60F8D4", hash_generated_field = "A9017732583166AEDC4465732F15D176")

    Paint mOldPaint = new Paint();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.899 -0400", hash_original_method = "D3533BC730DCD2115B028F12761A2C9B", hash_generated_method = "F26A80AAF2A824187FC47FE81EB7807F")
    public  AppWidgetHostView(Context context) {
        this(context, android.R.anim.fade_in, android.R.anim.fade_out);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.899 -0400", hash_original_method = "F3188887919A2B1ED3E7B00286A01B52", hash_generated_method = "F02C6198DC7A73F95AF906A2D618FBBA")
    @SuppressWarnings({"UnusedDeclaration"})
    public  AppWidgetHostView(Context context, int animationIn, int animationOut) {
        super(context);
        mContext = context;
        setIsRootNamespace(true);
        addTaint(animationIn);
        addTaint(animationOut);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.900 -0400", hash_original_method = "F21DF7E5FB86A76CA26E20C03A95533E", hash_generated_method = "919D741050CBC34FB9F400F60B0E4004")
    public void setAppWidget(int appWidgetId, AppWidgetProviderInfo info) {
        mAppWidgetId = appWidgetId;
        mInfo = info;
        {
            Rect padding = getDefaultPaddingForWidget(mContext, info.provider, null);
            setPadding(padding.left, padding.top, padding.right, padding.bottom);
        } 
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.900 -0400", hash_original_method = "523EC9820CA9D9B6EC1AAD0F0C3D4C58", hash_generated_method = "5D04343C650660E959159A5BA7F008FA")
    public int getAppWidgetId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209801883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209801883;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.902 -0400", hash_original_method = "FF9792E81F5B9850F94285F82FEF7EB6", hash_generated_method = "195BA25D8FC79B0BBBFBF4011BF4BAEC")
    public AppWidgetProviderInfo getAppWidgetInfo() {
        AppWidgetProviderInfo varB4EAC82CA7396A68D541C85D26508E83_1360637706 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1360637706 = mInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1360637706.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1360637706;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.902 -0400", hash_original_method = "CAED7A09C12E7C14DF8180A45912C5C7", hash_generated_method = "2DA245BA2573FA691CC223B5E41B32C7")
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        final ParcelableSparseArray jail = new ParcelableSparseArray();
        super.dispatchSaveInstanceState(jail);
        container.put(generateId(), jail);
        addTaint(container.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.903 -0400", hash_original_method = "11D592545671EB0AE44582AC9EA105B8", hash_generated_method = "D886852F3279245A0E768832E5FF99E0")
    private int generateId() {
        final int id = getId();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381137832 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381137832;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.904 -0400", hash_original_method = "9249C138593FE1EB2CAEA94EA5A08B6D", hash_generated_method = "9DD5091132390E22876BDEF0677398E7")
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        final Parcelable parcelable = container.get(generateId());
        ParcelableSparseArray jail = null;
        {
            jail = (ParcelableSparseArray) parcelable;
        } 
        jail = new ParcelableSparseArray();
        super.dispatchRestoreInstanceState(jail);
        addTaint(container.getTaint());
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.904 -0400", hash_original_method = "C318CB495524FCFBB782D4C68E4F0A8D", hash_generated_method = "15A6E087157DBF5C500B665E59B73257")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_736297529 = null; 
        Context context;
        context = mRemoteContext;
        context = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_736297529 = new FrameLayout.LayoutParams(context, attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_736297529.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_736297529;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.905 -0400", hash_original_method = "8BE5160C40379A67738659300BC656A4", hash_generated_method = "C2BA029743BA7CC450F552DD98EB0229")
     void resetAppWidget(AppWidgetProviderInfo info) {
        mInfo = info;
        mViewMode = VIEW_MODE_NOINIT;
        updateAppWidget(null);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.906 -0400", hash_original_method = "25975B2F0B8D4567FA791238963D6584", hash_generated_method = "9E75624493D30C84B518D3621DA16DCA")
    public void updateAppWidget(RemoteViews remoteViews) {
        Log.d(TAG, "updateAppWidget called mOld=" + mOld);
        boolean recycled = false;
        View content = null;
        Exception exception = null;
        {
            {
                {
                    final int width = mView.getWidth();
                    final int height = mView.getHeight();
                    try 
                    {
                        mOld = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    } 
                    catch (OutOfMemoryError e)
                    {
                        mOld = null;
                    } 
                } 
            } 
        } 
        {
            content = getDefaultView();
            mLayoutId = -1;
            mViewMode = VIEW_MODE_DEFAULT;
        } 
        {
            mRemoteContext = getRemoteContext(remoteViews);
            int layoutId = remoteViews.getLayoutId();
            {
                try 
                {
                    remoteViews.reapply(mContext, mView);
                    content = mView;
                    recycled = true;
                    Log.d(TAG, "was able to recycled existing layout");
                } 
                catch (RuntimeException e)
                {
                    exception = e;
                } 
            } 
            {
                try 
                {
                    content = remoteViews.apply(mContext, this);
                    Log.d(TAG, "had to inflate new layout");
                } 
                catch (RuntimeException e)
                {
                    exception = e;
                } 
            } 
            mLayoutId = layoutId;
            mViewMode = VIEW_MODE_CONTENT;
        } 
        {
            content = getErrorView();
            mViewMode = VIEW_MODE_ERROR;
        } 
        {
            prepareView(content);
            addView(content);
        } 
        {
            removeView(mView);
            mView = content;
        } 
        {
            {
                mFadeStartTime = SystemClock.uptimeMillis();
                invalidate();
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.907 -0400", hash_original_method = "8A7676901BF746B47397B4739377B887", hash_generated_method = "384D4CB51C51E74694A40A40EE9403F1")
     void viewDataChanged(int viewId) {
        View v = findViewById(viewId);
        {
            AdapterView<?> adapterView = (AdapterView<?>) v;
            Adapter adapter = adapterView.getAdapter();
            {
                BaseAdapter baseAdapter = (BaseAdapter) adapter;
                baseAdapter.notifyDataSetChanged();
            } 
            {
                ((RemoteAdapterConnectionCallback) adapterView).deferNotifyDataSetChanged();
            } 
        } 
        addTaint(viewId);
        
        
        
            
            
            
                
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.908 -0400", hash_original_method = "D246979F206AF74202D8DE4F4ED2EC44", hash_generated_method = "52C611FCD02849652A61BC38B26AA757")
    private Context getRemoteContext(RemoteViews views) {
        Context varB4EAC82CA7396A68D541C85D26508E83_2145021887 = null; 
        Context varB4EAC82CA7396A68D541C85D26508E83_2058462525 = null; 
        Context varB4EAC82CA7396A68D541C85D26508E83_925199426 = null; 
        final String packageName = views.getPackage();
        varB4EAC82CA7396A68D541C85D26508E83_2145021887 = mContext;
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2058462525 = mContext.createPackageContext(packageName, Context.CONTEXT_RESTRICTED);
        } 
        catch (NameNotFoundException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_925199426 = mContext;
        } 
        addTaint(views.getTaint());
        Context varA7E53CE21691AB073D9660D615818899_2106826231; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2106826231 = varB4EAC82CA7396A68D541C85D26508E83_2145021887;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2106826231 = varB4EAC82CA7396A68D541C85D26508E83_2058462525;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2106826231 = varB4EAC82CA7396A68D541C85D26508E83_925199426;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2106826231.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2106826231;
        
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.909 -0400", hash_original_method = "5F7FD765CDC0571DEC8D0D27FF96F700", hash_generated_method = "912567437FCA492E061E051FB76625E5")
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        {
            int alpha;
            int l = child.getLeft();
            int t = child.getTop();
            {
                alpha = (int)(((drawingTime-mFadeStartTime)*255)/FADE_DURATION);
                {
                    alpha = 255;
                } 
                Log.d(TAG, "drawChild alpha=" + alpha + " l=" + l + " t=" + t
                        + " w=" + child.getWidth());
                {
                    mOldPaint.setAlpha(255-alpha);
                } 
            } 
            {
                alpha = 255;
            } 
            int restoreTo = canvas.saveLayerAlpha(l, t, child.getWidth(), child.getHeight(), alpha,
                    Canvas.HAS_ALPHA_LAYER_SAVE_FLAG | Canvas.CLIP_TO_LAYER_SAVE_FLAG);
            boolean rv = super.drawChild(canvas, child, drawingTime);
            canvas.restoreToCount(restoreTo);
            {
                invalidate();
            } 
            {
                mFadeStartTime = -1;
                {
                    mOld.recycle();
                    mOld = null;
                } 
            } 
        } 
        {
            boolean var4DFF002E926C8684D37B3C839E3F9C8C_1396592658 = (super.drawChild(canvas, child, drawingTime));
        } 
        addTaint(canvas.getTaint());
        addTaint(child.getTaint());
        addTaint(drawingTime);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741264568 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741264568;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.909 -0400", hash_original_method = "3CF04F67A6E046DD8821A82932E9934D", hash_generated_method = "2FAFD778D498F3F6850221C320B9390C")
    protected void prepareView(View view) {
        FrameLayout.LayoutParams requested = (FrameLayout.LayoutParams)view.getLayoutParams();
        {
            requested = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT);
        } 
        requested.gravity = Gravity.CENTER;
        view.setLayoutParams(requested);
        addTaint(view.getTaint());
        
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.911 -0400", hash_original_method = "7ABED6F7F1F9E200368B812F1C939889", hash_generated_method = "6C9ED84C18FF404F50CF7CC83973820B")
    protected View getDefaultView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1867240945 = null; 
        {
            Log.d(TAG, "getDefaultView");
        } 
        View defaultView = null;
        Exception exception = null;
        try 
        {
            {
                Context theirContext = mContext.createPackageContext(
                        mInfo.provider.getPackageName(), Context.CONTEXT_RESTRICTED);
                mRemoteContext = theirContext;
                LayoutInflater inflater = (LayoutInflater)
                        theirContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater = inflater.cloneInContext(theirContext);
                inflater.setFilter(sInflaterFilter);
                defaultView = inflater.inflate(mInfo.initialLayout, this, false);
            } 
        } 
        catch (PackageManager.NameNotFoundException e)
        {
            exception = e;
        } 
        catch (RuntimeException e)
        {
            exception = e;
        } 
        {
            Log.d(TAG, "getDefaultView couldn't find any view, so inflating error");
            defaultView = getErrorView();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1867240945 = defaultView;
        varB4EAC82CA7396A68D541C85D26508E83_1867240945.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1867240945;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.912 -0400", hash_original_method = "BCED01C90A318EA661B2B3B116D10B95", hash_generated_method = "BB0B1CCE757D550B383A8E6A2968535E")
    protected View getErrorView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1658350196 = null; 
        TextView tv = new TextView(mContext);
        tv.setText(com.android.internal.R.string.gadget_host_error_inflating);
        tv.setBackgroundColor(Color.argb(127, 0, 0, 0));
        varB4EAC82CA7396A68D541C85D26508E83_1658350196 = tv;
        varB4EAC82CA7396A68D541C85D26508E83_1658350196.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1658350196;
        
        
        
        
        
    }

    
    private static class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.913 -0400", hash_original_method = "545E9F4FFC3CA9F22ED723B298F0D3D0", hash_generated_method = "545E9F4FFC3CA9F22ED723B298F0D3D0")
        public ParcelableSparseArray ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.914 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "25EF92D2D22BF37488A8E8C1F68BE86D")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828128269 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828128269;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.915 -0400", hash_original_method = "9373CC647F3D025502C7EB293E3D68C8", hash_generated_method = "675B66F806137AE37B9CDB727FCB4797")
        public void writeToParcel(Parcel dest, int flags) {
            final int count = size();
            dest.writeInt(count);
            {
                int i = 0;
                {
                    dest.writeInt(keyAt(i));
                    dest.writeParcelable(valueAt(i), 0);
                } 
            } 
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
                
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.915 -0400", hash_original_field = "F5815BC7A5C9A6B88AFFA57767233EFB", hash_generated_field = "B3F10EB5585E69660D628228707CD0EE")

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
        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.915 -0400", hash_original_field = "1F410656AF495FF0861F22EDA252470D", hash_generated_field = "D6B7C4B987F35D9DDE3D145EE688DFCE")

    static final String TAG = "AppWidgetHostView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.915 -0400", hash_original_field = "928751A5F820D0540184847C19228178", hash_generated_field = "BFEB05DE2363DCDC9E3DF7C8CCD0F900")

    static final boolean LOGD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.916 -0400", hash_original_field = "79DD27D8E811B7AAD91F16C26B71CFBE", hash_generated_field = "79BFE7DC4EBCF8975387F4AD3344544B")

    static final boolean CROSSFADE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.916 -0400", hash_original_field = "91DE3D2A19797AAC9A3A54C73056B3D9", hash_generated_field = "F7AD4C73992CA1A17A3596C10DDFACE4")

    static final int VIEW_MODE_NOINIT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.916 -0400", hash_original_field = "0F96DDDE8E761A9DC02BCD9C0DC430B9", hash_generated_field = "9A2971924F7CDB718A46A8A14A2164BF")

    static final int VIEW_MODE_CONTENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.916 -0400", hash_original_field = "2C96F5A448CBDEC8562BEC896B8BA0C5", hash_generated_field = "B71CA4BA70FFC9CE03D2F6DF6F6C7C69")

    static final int VIEW_MODE_ERROR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.916 -0400", hash_original_field = "EB0A5E1043ED9B9ABD4AE8A741E5000B", hash_generated_field = "F271F81D3D4FDD7B60DEB1A4DDDEC1F6")

    static final int VIEW_MODE_DEFAULT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.916 -0400", hash_original_field = "6F7CB63B4372A6CA83F1B834C8F1D016", hash_generated_field = "4ED03503C05C610B1278DF7F858B3167")

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

