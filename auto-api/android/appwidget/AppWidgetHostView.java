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
    Context mContext;
    Context mRemoteContext;
    int mAppWidgetId;
    AppWidgetProviderInfo mInfo;
    View mView;
    int mViewMode = VIEW_MODE_NOINIT;
    int mLayoutId = -1;
    long mFadeStartTime = -1;
    Bitmap mOld;
    Paint mOldPaint = new Paint();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.930 -0400", hash_original_method = "D3533BC730DCD2115B028F12761A2C9B", hash_generated_method = "CD49598B365B3D1ECD46FB3F2F36291C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AppWidgetHostView(Context context) {
        this(context, android.R.anim.fade_in, android.R.anim.fade_out);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.931 -0400", hash_original_method = "F3188887919A2B1ED3E7B00286A01B52", hash_generated_method = "644EC0B006111CEB5AEE955F4838602E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedDeclaration"})
    public AppWidgetHostView(Context context, int animationIn, int animationOut) {
        super(context);
        dsTaint.addTaint(animationOut);
        dsTaint.addTaint(animationIn);
        dsTaint.addTaint(context.dsTaint);
        setIsRootNamespace(true);
        // ---------- Original Method ----------
        //mContext = context;
        //setIsRootNamespace(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.931 -0400", hash_original_method = "F21DF7E5FB86A76CA26E20C03A95533E", hash_generated_method = "E53BC490839F3A24A3ABB475277B6653")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAppWidget(int appWidgetId, AppWidgetProviderInfo info) {
        dsTaint.addTaint(appWidgetId);
        dsTaint.addTaint(info.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.932 -0400", hash_original_method = "523EC9820CA9D9B6EC1AAD0F0C3D4C58", hash_generated_method = "6141CF848F70B0261729B987DFFF724C")
    @DSModeled(DSC.SAFE)
    public int getAppWidgetId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAppWidgetId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.932 -0400", hash_original_method = "FF9792E81F5B9850F94285F82FEF7EB6", hash_generated_method = "1E2C43A757532E1A4806B6310F5D132B")
    @DSModeled(DSC.SAFE)
    public AppWidgetProviderInfo getAppWidgetInfo() {
        return (AppWidgetProviderInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.932 -0400", hash_original_method = "CAED7A09C12E7C14DF8180A45912C5C7", hash_generated_method = "B69B15FAB8D01668E4B8E77F27D0BA0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        ParcelableSparseArray jail;
        jail = new ParcelableSparseArray();
        super.dispatchSaveInstanceState(jail);
        container.put(generateId(), jail);
        // ---------- Original Method ----------
        //final ParcelableSparseArray jail = new ParcelableSparseArray();
        //super.dispatchSaveInstanceState(jail);
        //container.put(generateId(), jail);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.933 -0400", hash_original_method = "11D592545671EB0AE44582AC9EA105B8", hash_generated_method = "D5490724BF928E48CC8995A79298C34C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int generateId() {
        int id;
        id = getId();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int id = getId();
        //return id == View.NO_ID ? mAppWidgetId : id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.933 -0400", hash_original_method = "9249C138593FE1EB2CAEA94EA5A08B6D", hash_generated_method = "2BFA8B6D1B2677D313B46E91CEA04578")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dsTaint.addTaint(container.dsTaint);
        Parcelable parcelable;
        parcelable = container.get(generateId());
        ParcelableSparseArray jail;
        jail = null;
        {
            jail = (ParcelableSparseArray) parcelable;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.933 -0400", hash_original_method = "C318CB495524FCFBB782D4C68E4F0A8D", hash_generated_method = "7A1792B522AC6BE14829FBD2D03229B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        Context context;
        context = mRemoteContext;
        context = mContext;
        LayoutParams var06159F6201419D65AC28F2E66693022F_652135678 = (new FrameLayout.LayoutParams(context, attrs));
        return (LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final Context context = mRemoteContext != null ? mRemoteContext : mContext;
        //return new FrameLayout.LayoutParams(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.934 -0400", hash_original_method = "8BE5160C40379A67738659300BC656A4", hash_generated_method = "78D0A7EE767DEF1432B724C8759C005F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void resetAppWidget(AppWidgetProviderInfo info) {
        dsTaint.addTaint(info.dsTaint);
        mViewMode = VIEW_MODE_NOINIT;
        updateAppWidget(null);
        // ---------- Original Method ----------
        //mInfo = info;
        //mViewMode = VIEW_MODE_NOINIT;
        //updateAppWidget(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.936 -0400", hash_original_method = "25975B2F0B8D4567FA791238963D6584", hash_generated_method = "B1865579F8D29F122CC805C1175C3533")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateAppWidget(RemoteViews remoteViews) {
        dsTaint.addTaint(remoteViews.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.937 -0400", hash_original_method = "8A7676901BF746B47397B4739377B887", hash_generated_method = "30740BD9E0564E1767A7F0D56E233264")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void viewDataChanged(int viewId) {
        dsTaint.addTaint(viewId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.937 -0400", hash_original_method = "D246979F206AF74202D8DE4F4ED2EC44", hash_generated_method = "EE44AB252BB57CDA2156BD422DD0961B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Context getRemoteContext(RemoteViews views) {
        dsTaint.addTaint(views.dsTaint);
        String packageName;
        packageName = views.getPackage();
        try 
        {
            Context var04A9C3ED1C0D2E80FCEA549372583D44_1016082876 = (mContext.createPackageContext(packageName, Context.CONTEXT_RESTRICTED));
        } //End block
        catch (NameNotFoundException e)
        { }
        return (Context)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.938 -0400", hash_original_method = "5F7FD765CDC0571DEC8D0D27FF96F700", hash_generated_method = "A225A7FE2C46CB207D5B817EC3377191")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(drawingTime);
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
            boolean var4DFF002E926C8684D37B3C839E3F9C8C_527784190 = (super.drawChild(canvas, child, drawingTime));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.939 -0400", hash_original_method = "3CF04F67A6E046DD8821A82932E9934D", hash_generated_method = "EBE010F3FF33411E1D50C0DEA9E2FBDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void prepareView(View view) {
        dsTaint.addTaint(view.dsTaint);
        FrameLayout.LayoutParams requested;
        requested = (FrameLayout.LayoutParams)view.getLayoutParams();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.940 -0400", hash_original_method = "7ABED6F7F1F9E200368B812F1C939889", hash_generated_method = "C1E6FC31E46271B81E8A4A5EFB624814")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View getDefaultView() {
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
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.940 -0400", hash_original_method = "BCED01C90A318EA661B2B3B116D10B95", hash_generated_method = "951EE0CBE84E5AC0A4557A153F3D129E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View getErrorView() {
        TextView tv;
        tv = new TextView(mContext);
        tv.setText(com.android.internal.R.string.gadget_host_error_inflating);
        tv.setBackgroundColor(Color.argb(127, 0, 0, 0));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //TextView tv = new TextView(mContext);
        //tv.setText(com.android.internal.R.string.gadget_host_error_inflating);
        //tv.setBackgroundColor(Color.argb(127, 0, 0, 0));
        //return tv;
    }

    
    private static class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.940 -0400", hash_original_method = "FD015273E2E474FA9766A2572DB00684", hash_generated_method = "FD015273E2E474FA9766A2572DB00684")
                public ParcelableSparseArray ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.941 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.941 -0400", hash_original_method = "9373CC647F3D025502C7EB293E3D68C8", hash_generated_method = "FFC9AB8C1916E25546BF41CF42B10462")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
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
            // ---------- Original Method ----------
            //final int count = size();
            //dest.writeInt(count);
            //for (int i = 0; i < count; i++) {
                //dest.writeInt(keyAt(i));
                //dest.writeParcelable(valueAt(i), 0);
            //}
        }

        
        public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = new Parcelable.Creator<ParcelableSparseArray>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.942 -0400", hash_original_method = "3205CF4E54D89354D52F839F1E99A1A2", hash_generated_method = "BED6E3432052368D127D29E74635FA0B")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public ParcelableSparseArray createFromParcel(Parcel source) {
                dsTaint.addTaint(source.dsTaint);
                ParcelableSparseArray array;
                array = new ParcelableSparseArray();
                ClassLoader loader;
                loader = array.getClass().getClassLoader();
                int count;
                count = source.readInt();
                {
                    int i;
                    i = 0;
                    {
                        array.put(source.readInt(), source.readParcelable(loader));
                    } //End block
                } //End collapsed parenthetic
                return (ParcelableSparseArray)dsTaint.getTaint();
                // ---------- Original Method ----------
                //final ParcelableSparseArray array = new ParcelableSparseArray();
                //final ClassLoader loader = array.getClass().getClassLoader();
                //final int count = source.readInt();
                //for (int i = 0; i < count; i++) {
                            //array.put(source.readInt(), source.readParcelable(loader));
                        //}
                //return array;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.942 -0400", hash_original_method = "D62D1778F6B43A91D597E96F716C0B43", hash_generated_method = "B29A29D49788CC42C4D2E1D954714823")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public ParcelableSparseArray[] newArray(int size) {
                dsTaint.addTaint(size);
                ParcelableSparseArray[] var58EDD58895887A8AA4CB9C705036501D_2074734271 = (new ParcelableSparseArray[size]);
                return (ParcelableSparseArray[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new ParcelableSparseArray[size];
            }

            
}; //Transformed anonymous class
    }


    
    static final String TAG = "AppWidgetHostView";
    static final boolean LOGD = false;
    static final boolean CROSSFADE = false;
    static final int VIEW_MODE_NOINIT = 0;
    static final int VIEW_MODE_CONTENT = 1;
    static final int VIEW_MODE_ERROR = 2;
    static final int VIEW_MODE_DEFAULT = 3;
    static final int FADE_DURATION = 1000;
    static final LayoutInflater.Filter sInflaterFilter = new LayoutInflater.Filter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.943 -0400", hash_original_method = "F477B2C7A46FC6FC036CB698F9A6F774", hash_generated_method = "76C8733F23990B67C468B04681DCD579")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onLoadClass(Class clazz) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(clazz.dsTaint);
            boolean varA10EEDB5B362CDB8AEA79625767F60A9_826588572 = (clazz.isAnnotationPresent(RemoteViews.RemoteView.class));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return clazz.isAnnotationPresent(RemoteViews.RemoteView.class);
        }

        
}; //Transformed anonymous class
}

