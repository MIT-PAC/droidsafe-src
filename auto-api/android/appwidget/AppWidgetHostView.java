package android.appwidget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.091 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.092 -0400", hash_original_field = "43E2B65B3F22B575CF99A5FA17CF3174", hash_generated_field = "2398AF174D0AD1B38433EB4F0C3826A9")

    Context mRemoteContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.092 -0400", hash_original_field = "905A4BBD5E07D0C7A80D7BBC86A773FE", hash_generated_field = "C187677719C4391D45C59B42615D4AC2")

    int mAppWidgetId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.092 -0400", hash_original_field = "1715FF63502BEC0E28C8D7CA89F0F72E", hash_generated_field = "1435437DCA238203A550D7FEA268A3A7")

    AppWidgetProviderInfo mInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.104 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.104 -0400", hash_original_field = "E17869D55D8B642917403BA0AFD91827", hash_generated_field = "EED3242F95ADA8D723AC1C67E2F7BCD0")

    int mViewMode = VIEW_MODE_NOINIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.105 -0400", hash_original_field = "07B760141AB2313155AA4AFCFA145CAB", hash_generated_field = "AC76DC627A00C6D529BB2CA73C4ED642")

    int mLayoutId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.105 -0400", hash_original_field = "3C65A570099EFE7002E56B3AA8E0754B", hash_generated_field = "E1A7BBCE5FAEE0A4FDB6711CF0250012")

    long mFadeStartTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.105 -0400", hash_original_field = "72B180D2D97D58F0A6E7A12B21299482", hash_generated_field = "52668329A8AD44643F40935F478E774E")

    Bitmap mOld;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.106 -0400", hash_original_field = "6CB4678E6104BE2E3D0770F07A60F8D4", hash_generated_field = "A9017732583166AEDC4465732F15D176")

    Paint mOldPaint = new Paint();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.107 -0400", hash_original_method = "D3533BC730DCD2115B028F12761A2C9B", hash_generated_method = "F26A80AAF2A824187FC47FE81EB7807F")
    public  AppWidgetHostView(Context context) {
        this(context, android.R.anim.fade_in, android.R.anim.fade_out);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.123 -0400", hash_original_method = "F3188887919A2B1ED3E7B00286A01B52", hash_generated_method = "F02C6198DC7A73F95AF906A2D618FBBA")
    @SuppressWarnings({"UnusedDeclaration"})
    public  AppWidgetHostView(Context context, int animationIn, int animationOut) {
        super(context);
        mContext = context;
        setIsRootNamespace(true);
        addTaint(animationIn);
        addTaint(animationOut);
        // ---------- Original Method ----------
        //mContext = context;
        //setIsRootNamespace(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.162 -0400", hash_original_method = "F21DF7E5FB86A76CA26E20C03A95533E", hash_generated_method = "5F45093F9147F28194DCD2E29AA2840A")
    public void setAppWidget(int appWidgetId, AppWidgetProviderInfo info) {
        mAppWidgetId = appWidgetId;
        mInfo = info;
        {
            Rect padding;
            padding = getDefaultPaddingForWidget(mContext, info.provider, null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.164 -0400", hash_original_method = "523EC9820CA9D9B6EC1AAD0F0C3D4C58", hash_generated_method = "B684106658CD121A70B746E563976B28")
    public int getAppWidgetId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034663070 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034663070;
        // ---------- Original Method ----------
        //return mAppWidgetId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.182 -0400", hash_original_method = "FF9792E81F5B9850F94285F82FEF7EB6", hash_generated_method = "1717300FE0D30F55790DF66101179DF7")
    public AppWidgetProviderInfo getAppWidgetInfo() {
        AppWidgetProviderInfo varB4EAC82CA7396A68D541C85D26508E83_1382053996 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1382053996 = mInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1382053996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1382053996;
        // ---------- Original Method ----------
        //return mInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.184 -0400", hash_original_method = "CAED7A09C12E7C14DF8180A45912C5C7", hash_generated_method = "B64B043BC32A41F4836DDCC28C0C21B2")
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        ParcelableSparseArray jail;
        jail = new ParcelableSparseArray();
        super.dispatchSaveInstanceState(jail);
        container.put(generateId(), jail);
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //final ParcelableSparseArray jail = new ParcelableSparseArray();
        //super.dispatchSaveInstanceState(jail);
        //container.put(generateId(), jail);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.184 -0400", hash_original_method = "11D592545671EB0AE44582AC9EA105B8", hash_generated_method = "B0FF2D8690B18F6D27A76E6CDD7DEB85")
    private int generateId() {
        int id;
        id = getId();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1588393074 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1588393074;
        // ---------- Original Method ----------
        //final int id = getId();
        //return id == View.NO_ID ? mAppWidgetId : id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.189 -0400", hash_original_method = "9249C138593FE1EB2CAEA94EA5A08B6D", hash_generated_method = "5E6C8A805B7E720257A891E8855B3401")
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        Parcelable parcelable;
        parcelable = container.get(generateId());
        ParcelableSparseArray jail;
        jail = null;
        {
            jail = (ParcelableSparseArray) parcelable;
        } //End block
        jail = new ParcelableSparseArray();
        super.dispatchRestoreInstanceState(jail);
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //final Parcelable parcelable = container.get(generateId());
        //ParcelableSparseArray jail = null;
        //if (parcelable != null && parcelable instanceof ParcelableSparseArray) {
            //jail = (ParcelableSparseArray) parcelable;
        //}
        //if (jail == null) jail = new ParcelableSparseArray();
        //super.dispatchRestoreInstanceState(jail);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.200 -0400", hash_original_method = "C318CB495524FCFBB782D4C68E4F0A8D", hash_generated_method = "C8EB7749195AEC490981141CBF882C65")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1296593288 = null; //Variable for return #1
        Context context;
        context = mRemoteContext;
        context = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_1296593288 = new FrameLayout.LayoutParams(context, attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1296593288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1296593288;
        // ---------- Original Method ----------
        //final Context context = mRemoteContext != null ? mRemoteContext : mContext;
        //return new FrameLayout.LayoutParams(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.201 -0400", hash_original_method = "8BE5160C40379A67738659300BC656A4", hash_generated_method = "C2BA029743BA7CC450F552DD98EB0229")
     void resetAppWidget(AppWidgetProviderInfo info) {
        mInfo = info;
        mViewMode = VIEW_MODE_NOINIT;
        updateAppWidget(null);
        // ---------- Original Method ----------
        //mInfo = info;
        //mViewMode = VIEW_MODE_NOINIT;
        //updateAppWidget(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.225 -0400", hash_original_method = "25975B2F0B8D4567FA791238963D6584", hash_generated_method = "69551794B0BE1E1F479AC9319CFFE165")
    public void updateAppWidget(RemoteViews remoteViews) {
        Log.d(TAG, "updateAppWidget called mOld=" + mOld);
        boolean recycled;
        recycled = false;
        View content;
        content = null;
        Exception exception;
        exception = null;
        {
            {
                {
                    int width;
                    width = mView.getWidth();
                    int height;
                    height = mView.getHeight();
                    try 
                    {
                        mOld = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    } //End block
                    catch (OutOfMemoryError e)
                    {
                        mOld = null;
                    } //End block
                } //End block
            } //End block
        } //End block
        {
            content = getDefaultView();
            mLayoutId = -1;
            mViewMode = VIEW_MODE_DEFAULT;
        } //End block
        {
            mRemoteContext = getRemoteContext(remoteViews);
            int layoutId;
            layoutId = remoteViews.getLayoutId();
            {
                try 
                {
                    remoteViews.reapply(mContext, mView);
                    content = mView;
                    recycled = true;
                    Log.d(TAG, "was able to recycled existing layout");
                } //End block
                catch (RuntimeException e)
                {
                    exception = e;
                } //End block
            } //End block
            {
                try 
                {
                    content = remoteViews.apply(mContext, this);
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
        {
            content = getErrorView();
            mViewMode = VIEW_MODE_ERROR;
        } //End block
        {
            prepareView(content);
            addView(content);
        } //End block
        {
            removeView(mView);
            mView = content;
        } //End block
        {
            {
                mFadeStartTime = SystemClock.uptimeMillis();
                invalidate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.227 -0400", hash_original_method = "8A7676901BF746B47397B4739377B887", hash_generated_method = "FCAB10559546DADF70A3ABC7F62B342D")
     void viewDataChanged(int viewId) {
        View v;
        v = findViewById(viewId);
        {
            AdapterView<?> adapterView;
            adapterView = (AdapterView<?>) v;
            Adapter adapter;
            adapter = adapterView.getAdapter();
            {
                BaseAdapter baseAdapter;
                baseAdapter = (BaseAdapter) adapter;
                baseAdapter.notifyDataSetChanged();
            } //End block
            {
                ((RemoteAdapterConnectionCallback) adapterView).deferNotifyDataSetChanged();
            } //End block
        } //End block
        addTaint(viewId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.246 -0400", hash_original_method = "D246979F206AF74202D8DE4F4ED2EC44", hash_generated_method = "3BC0010C5D1E51D2F20C2E082C7E44B9")
    private Context getRemoteContext(RemoteViews views) {
        Context varB4EAC82CA7396A68D541C85D26508E83_1586993291 = null; //Variable for return #1
        Context varB4EAC82CA7396A68D541C85D26508E83_233066265 = null; //Variable for return #2
        Context varB4EAC82CA7396A68D541C85D26508E83_451686503 = null; //Variable for return #3
        String packageName;
        packageName = views.getPackage();
        varB4EAC82CA7396A68D541C85D26508E83_1586993291 = mContext;
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_233066265 = mContext.createPackageContext(packageName, Context.CONTEXT_RESTRICTED);
        } //End block
        catch (NameNotFoundException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_451686503 = mContext;
        } //End block
        addTaint(views.getTaint());
        Context varA7E53CE21691AB073D9660D615818899_1979740806; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1979740806 = varB4EAC82CA7396A68D541C85D26508E83_1586993291;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1979740806 = varB4EAC82CA7396A68D541C85D26508E83_233066265;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1979740806 = varB4EAC82CA7396A68D541C85D26508E83_451686503;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1979740806.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1979740806;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.258 -0400", hash_original_method = "5F7FD765CDC0571DEC8D0D27FF96F700", hash_generated_method = "DBFB76404092708C3158DACEC4BC7858")
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        {
            int alpha;
            int l;
            l = child.getLeft();
            int t;
            t = child.getTop();
            {
                alpha = (int)(((drawingTime-mFadeStartTime)*255)/FADE_DURATION);
                {
                    alpha = 255;
                } //End block
                Log.d(TAG, "drawChild alpha=" + alpha + " l=" + l + " t=" + t
                        + " w=" + child.getWidth());
                {
                    mOldPaint.setAlpha(255-alpha);
                } //End block
            } //End block
            {
                alpha = 255;
            } //End block
            int restoreTo;
            restoreTo = canvas.saveLayerAlpha(l, t, child.getWidth(), child.getHeight(), alpha,
                    Canvas.HAS_ALPHA_LAYER_SAVE_FLAG | Canvas.CLIP_TO_LAYER_SAVE_FLAG);
            boolean rv;
            rv = super.drawChild(canvas, child, drawingTime);
            canvas.restoreToCount(restoreTo);
            {
                invalidate();
            } //End block
            {
                mFadeStartTime = -1;
                {
                    mOld.recycle();
                    mOld = null;
                } //End block
            } //End block
        } //End block
        {
            boolean var4DFF002E926C8684D37B3C839E3F9C8C_98896520 = (super.drawChild(canvas, child, drawingTime));
        } //End block
        addTaint(canvas.getTaint());
        addTaint(child.getTaint());
        addTaint(drawingTime);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_653488946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_653488946;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.272 -0400", hash_original_method = "3CF04F67A6E046DD8821A82932E9934D", hash_generated_method = "CCA6BC2E2DAE9651E0FDD9DA84F943D5")
    protected void prepareView(View view) {
        FrameLayout.LayoutParams requested;
        requested = (FrameLayout.LayoutParams)view.getLayoutParams();
        {
            requested = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT);
        } //End block
        requested.gravity = Gravity.CENTER;
        view.setLayoutParams(requested);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //FrameLayout.LayoutParams requested = (FrameLayout.LayoutParams)view.getLayoutParams();
        //if (requested == null) {
            //requested = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                    //LayoutParams.MATCH_PARENT);
        //}
        //requested.gravity = Gravity.CENTER;
        //view.setLayoutParams(requested);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.279 -0400", hash_original_method = "7ABED6F7F1F9E200368B812F1C939889", hash_generated_method = "B8B726CE5BAB1FC5748C190E10B96C3C")
    protected View getDefaultView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1617846111 = null; //Variable for return #1
        {
            Log.d(TAG, "getDefaultView");
        } //End block
        View defaultView;
        defaultView = null;
        Exception exception;
        exception = null;
        try 
        {
            {
                Context theirContext;
                theirContext = mContext.createPackageContext(
                        mInfo.provider.getPackageName(), Context.CONTEXT_RESTRICTED);
                mRemoteContext = theirContext;
                LayoutInflater inflater;
                inflater = (LayoutInflater)
                        theirContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater = inflater.cloneInContext(theirContext);
                inflater.setFilter(sInflaterFilter);
                defaultView = inflater.inflate(mInfo.initialLayout, this, false);
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
        {
            Log.d(TAG, "getDefaultView couldn't find any view, so inflating error");
            defaultView = getErrorView();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1617846111 = defaultView;
        varB4EAC82CA7396A68D541C85D26508E83_1617846111.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1617846111;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.306 -0400", hash_original_method = "BCED01C90A318EA661B2B3B116D10B95", hash_generated_method = "D3B5B805E7E4FF70B121D1BD4C5D8E12")
    protected View getErrorView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1113896541 = null; //Variable for return #1
        TextView tv;
        tv = new TextView(mContext);
        tv.setText(com.android.internal.R.string.gadget_host_error_inflating);
        tv.setBackgroundColor(Color.argb(127, 0, 0, 0));
        varB4EAC82CA7396A68D541C85D26508E83_1113896541 = tv;
        varB4EAC82CA7396A68D541C85D26508E83_1113896541.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1113896541;
        // ---------- Original Method ----------
        //TextView tv = new TextView(mContext);
        //tv.setText(com.android.internal.R.string.gadget_host_error_inflating);
        //tv.setBackgroundColor(Color.argb(127, 0, 0, 0));
        //return tv;
    }

    
    private static class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.307 -0400", hash_original_method = "545E9F4FFC3CA9F22ED723B298F0D3D0", hash_generated_method = "545E9F4FFC3CA9F22ED723B298F0D3D0")
        public ParcelableSparseArray ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.307 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "9CB12B39397DC6ED71BE502C36C08E9E")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401094545 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401094545;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.309 -0400", hash_original_method = "9373CC647F3D025502C7EB293E3D68C8", hash_generated_method = "DBDDD967A73DB6A37732EC39F492248D")
        public void writeToParcel(Parcel dest, int flags) {
            int count;
            count = size();
            dest.writeInt(count);
            {
                int i;
                i = 0;
                {
                    dest.writeInt(keyAt(i));
                    dest.writeParcelable(valueAt(i), 0);
                } //End block
            } //End collapsed parenthetic
            addTaint(dest.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //final int count = size();
            //dest.writeInt(count);
            //for (int i = 0; i < count; i++) {
                //dest.writeInt(keyAt(i));
                //dest.writeParcelable(valueAt(i), 0);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.309 -0400", hash_original_field = "F5815BC7A5C9A6B88AFFA57767233EFB", hash_generated_field = "B3F10EB5585E69660D628228707CD0EE")

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
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.310 -0400", hash_original_field = "1F410656AF495FF0861F22EDA252470D", hash_generated_field = "82481E8BCC1953AED843AAA0DB1731FC")

    static String TAG = "AppWidgetHostView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.310 -0400", hash_original_field = "928751A5F820D0540184847C19228178", hash_generated_field = "9845BCEA2049AFD023ABF6F5CAA5DF46")

    static boolean LOGD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.310 -0400", hash_original_field = "79DD27D8E811B7AAD91F16C26B71CFBE", hash_generated_field = "14D15CF646AEA1A78AD88FE5AFBC11CD")

    static boolean CROSSFADE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.311 -0400", hash_original_field = "91DE3D2A19797AAC9A3A54C73056B3D9", hash_generated_field = "8B0B53FB377ED3B4624F750957918087")

    static int VIEW_MODE_NOINIT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.311 -0400", hash_original_field = "0F96DDDE8E761A9DC02BCD9C0DC430B9", hash_generated_field = "AC826EEE77D74980E8C9569D13E9D9C1")

    static int VIEW_MODE_CONTENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.317 -0400", hash_original_field = "2C96F5A448CBDEC8562BEC896B8BA0C5", hash_generated_field = "E1B900E58CA13B3E2BAB6DF3D0600C1F")

    static int VIEW_MODE_ERROR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.318 -0400", hash_original_field = "EB0A5E1043ED9B9ABD4AE8A741E5000B", hash_generated_field = "F5527E9E4057C313278592BC4B8A6235")

    static int VIEW_MODE_DEFAULT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.318 -0400", hash_original_field = "6F7CB63B4372A6CA83F1B834C8F1D016", hash_generated_field = "59B3F912A6E2F3F3B751071F389981E1")

    static int FADE_DURATION = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.349 -0400", hash_original_field = "AB1AD5AD9EFC37F946612C1704046BB6", hash_generated_field = "77D34BF4B79A6FC5C04C203A7824708A")

    static LayoutInflater.Filter sInflaterFilter = new LayoutInflater.Filter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.336 -0400", hash_original_method = "F477B2C7A46FC6FC036CB698F9A6F774", hash_generated_method = "D38F19E4B0131804BBEDD3C4A5C24861")
        public boolean onLoadClass(Class clazz) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean varA10EEDB5B362CDB8AEA79625767F60A9_785075669 = (clazz.isAnnotationPresent(RemoteViews.RemoteView.class));
            addTaint(clazz.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_185904811 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_185904811;
            // ---------- Original Method ----------
            //return clazz.isAnnotationPresent(RemoteViews.RemoteView.class);
        }

        
};
}

