package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.view.BaseIWindow;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.CompatibilityInfo.Translator;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.ParcelFileDescriptor;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class SurfaceView extends View {
    ArrayList<SurfaceHolder.Callback> mCallbacks
            = new ArrayList<SurfaceHolder.Callback>();
    int[] mLocation = new int[2];
    ReentrantLock mSurfaceLock = new ReentrantLock();
    Surface mSurface = new Surface();
    Surface mNewSurface = new Surface();
    boolean mDrawingStopped = true;
    WindowManager.LayoutParams mLayout
            = new WindowManager.LayoutParams();
    IWindowSession mSession;
    MyWindow mWindow;
    Rect mVisibleInsets = new Rect();
    Rect mWinFrame = new Rect();
    Rect mContentInsets = new Rect();
    Configuration mConfiguration = new Configuration();
    int mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
    boolean mIsCreating = false;
    final Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.368 -0400", hash_original_method = "82BE8897E23B3ED9422918649CBA5FAB", hash_generated_method = "207B8A1C80A9BDC28F5D040A42F9DCA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case KEEP_SCREEN_ON_MSG 
            {
                setKeepScreenOn(msg.arg1 != 0);
            } //End block
            //End case KEEP_SCREEN_ON_MSG 
            //Begin case GET_NEW_SURFACE_MSG 
            {
                handleGetNewSurface();
            } //End block
            //End case GET_NEW_SURFACE_MSG 
            //Begin case UPDATE_WINDOW_MSG 
            {
                updateWindow(false, false);
            } //End block
            //End case UPDATE_WINDOW_MSG 
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case KEEP_SCREEN_ON_MSG: {
                    //setKeepScreenOn(msg.arg1 != 0);
                //} break;
                //case GET_NEW_SURFACE_MSG: {
                    //handleGetNewSurface();
                //} break;
                //case UPDATE_WINDOW_MSG: {
                    //updateWindow(false, false);
                //} break;
            //}
        }

        
}; //Transformed anonymous class
    final ViewTreeObserver.OnScrollChangedListener mScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.368 -0400", hash_original_method = "5F51326E8091C450ECA5819AAACF378E", hash_generated_method = "9745D3D4F8B077B019362B4564B9A421")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onScrollChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            updateWindow(false, false);
            // ---------- Original Method ----------
            //updateWindow(false, false);
        }

        
}; //Transformed anonymous class
    boolean mRequestedVisible = false;
    boolean mWindowVisibility = false;
    boolean mViewVisibility = false;
    int mRequestedWidth = -1;
    int mRequestedHeight = -1;
    int mRequestedFormat = PixelFormat.RGB_565;
    boolean mHaveFrame = false;
    boolean mSurfaceCreated = false;
    long mLastLockTime = 0;
    boolean mVisible = false;
    int mLeft = -1;
    int mTop = -1;
    int mWidth = -1;
    int mHeight = -1;
    int mFormat = -1;
    Rect mSurfaceFrame = new Rect();
    Rect mTmpDirty;
    int mLastSurfaceWidth = -1, mLastSurfaceHeight = -1;
    boolean mUpdateWindowNeeded;
    boolean mReportDrawNeeded;
    private Translator mTranslator;
    private final ViewTreeObserver.OnPreDrawListener mDrawListener = new ViewTreeObserver.OnPreDrawListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.368 -0400", hash_original_method = "BFD620CC97E89E709383D7DD902C160A", hash_generated_method = "C21A4F9DF4D1B068460225996B422B49")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onPreDraw() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mHaveFrame = getWidth() > 0 && getHeight() > 0;
            updateWindow(false, false);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //mHaveFrame = getWidth() > 0 && getHeight() > 0;
            //updateWindow(false, false);
            //return true;
        }

        
}; //Transformed anonymous class
    private boolean mGlobalListenersAdded;
    private SurfaceHolder mSurfaceHolder = new SurfaceHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.368 -0400", hash_original_method = "FBEC596A43003FDD0C674BF719352967", hash_generated_method = "B19D481E062842C6A40151D647C40C32")
        @DSModeled(DSC.SAFE)
        public boolean isCreating() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mIsCreating;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.369 -0400", hash_original_method = "A6B53DAA62C6D5AB170B791AD6D4E39D", hash_generated_method = "A16BF10EA928DBABD402694B3B8F9912")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void addCallback(Callback callback) {
            dsTaint.addTaint(callback.dsTaint);
            {
                {
                    boolean var1B2EEED5E498982D843BE645C828D6CD_1479648892 = (mCallbacks.contains(callback) == false);
                    {
                        mCallbacks.add(callback);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //synchronized (mCallbacks) {
                //if (mCallbacks.contains(callback) == false) {      
                    //mCallbacks.add(callback);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.369 -0400", hash_original_method = "C2F2686F3B633A931E5A1A7B954047E4", hash_generated_method = "1752A39C8A85441156E1E2A8065CE591")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void removeCallback(Callback callback) {
            dsTaint.addTaint(callback.dsTaint);
            {
                mCallbacks.remove(callback);
            } //End block
            // ---------- Original Method ----------
            //synchronized (mCallbacks) {
                //mCallbacks.remove(callback);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.369 -0400", hash_original_method = "64431562EF44F0DC495EE5D0EB57FE21", hash_generated_method = "40E0D3BD526B5549497301FAB42B9A6A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setFixedSize(int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            {
                mRequestedWidth = width;
                mRequestedHeight = height;
                requestLayout();
            } //End block
            // ---------- Original Method ----------
            //if (mRequestedWidth != width || mRequestedHeight != height) {
                //mRequestedWidth = width;
                //mRequestedHeight = height;
                //requestLayout();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.369 -0400", hash_original_method = "E36476A0B11513BDBDEF513EF43A7F69", hash_generated_method = "8A56DFCEE733F3CA1DA6DDD667110EAA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setSizeFromLayout() {
            {
                mRequestedWidth = mRequestedHeight = -1;
                requestLayout();
            } //End block
            // ---------- Original Method ----------
            //if (mRequestedWidth != -1 || mRequestedHeight != -1) {
                //mRequestedWidth = mRequestedHeight = -1;
                //requestLayout();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.370 -0400", hash_original_method = "E4680DDEA725EDF754E21194707CA19F", hash_generated_method = "9032D198795F94DBB6F36614B22F66C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setFormat(int format) {
            dsTaint.addTaint(format);
            format = PixelFormat.RGB_565;
            mRequestedFormat = format;
            {
                updateWindow(false, false);
            } //End block
            // ---------- Original Method ----------
            //if (format == PixelFormat.OPAQUE)
                //format = PixelFormat.RGB_565;
            //mRequestedFormat = format;
            //if (mWindow != null) {
                //updateWindow(false, false);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.370 -0400", hash_original_method = "B37A48D0CAD6F4AF8C78DA1B2A495A29", hash_generated_method = "D58E0C395C63F6C19A8741B539DFDDB2")
        @DSModeled(DSC.SAFE)
        @Deprecated
        public void setType(int type) {
            dsTaint.addTaint(type);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.370 -0400", hash_original_method = "2D0915C13785F2B0579D7E71B7329015", hash_generated_method = "367C788EDA7CB82708586629800339F2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setKeepScreenOn(boolean screenOn) {
            dsTaint.addTaint(screenOn);
            Message msg;
            msg = mHandler.obtainMessage(KEEP_SCREEN_ON_MSG);
            msg.arg1 = screenOn ? 1 : 0;
            mHandler.sendMessage(msg);
            // ---------- Original Method ----------
            //Message msg = mHandler.obtainMessage(KEEP_SCREEN_ON_MSG);
            //msg.arg1 = screenOn ? 1 : 0;
            //mHandler.sendMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.370 -0400", hash_original_method = "62E11A68BFE49B76328D9C868319D907", hash_generated_method = "4642365A7496CCEC17939603A0F4E87A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Canvas lockCanvas() {
            Canvas varDBE874E591D0822EF0EFD29F210BE110_888968835 = (internalLockCanvas(null));
            return (Canvas)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return internalLockCanvas(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.370 -0400", hash_original_method = "680C567FEFB26BF9B08DD2E5AA0C3FA9", hash_generated_method = "A4F8F8C2DC17808AFE6796090D3D4B79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Canvas lockCanvas(Rect dirty) {
            dsTaint.addTaint(dirty.dsTaint);
            Canvas var320E0D31F6D87FE2AD3EB31700CDE4F5_867743335 = (internalLockCanvas(dirty));
            return (Canvas)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return internalLockCanvas(dirty);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.371 -0400", hash_original_method = "4B95DCD02F9C44A8215403B28FBCC461", hash_generated_method = "51D5A0C763EE55C155CBD0151BC0491F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private final Canvas internalLockCanvas(Rect dirty) {
            dsTaint.addTaint(dirty.dsTaint);
            mSurfaceLock.lock();
            Canvas c;
            c = null;
            {
                {
                    {
                        mTmpDirty = new Rect();
                    } //End block
                    mTmpDirty.set(mSurfaceFrame);
                    dirty = mTmpDirty;
                } //End block
                try 
                {
                    c = mSurface.lockCanvas(dirty);
                } //End block
                catch (Exception e)
                { }
            } //End block
            {
                mLastLockTime = SystemClock.uptimeMillis();
            } //End block
            long now;
            now = SystemClock.uptimeMillis();
            long nextTime;
            nextTime = mLastLockTime + 100;
            {
                try 
                {
                    Thread.sleep(nextTime-now);
                } //End block
                catch (InterruptedException e)
                { }
                now = SystemClock.uptimeMillis();
            } //End block
            mLastLockTime = now;
            mSurfaceLock.unlock();
            return (Canvas)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.371 -0400", hash_original_method = "94198D6DEEC3932A7E8E0C313FB26861", hash_generated_method = "78C495C6A08AA5AD7A4659A9096511E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void unlockCanvasAndPost(Canvas canvas) {
            dsTaint.addTaint(canvas.dsTaint);
            mSurface.unlockCanvasAndPost(canvas);
            mSurfaceLock.unlock();
            // ---------- Original Method ----------
            //mSurface.unlockCanvasAndPost(canvas);
            //mSurfaceLock.unlock();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.371 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "6892275B4B40A9EB5D5D8351C4113406")
        @DSModeled(DSC.SAFE)
        public Surface getSurface() {
            return (Surface)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mSurface;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.371 -0400", hash_original_method = "BE643F9C45A14CE663214357E2B511D8", hash_generated_method = "AFAF6E59240560D0B13CB731564E9731")
        @DSModeled(DSC.SAFE)
        public Rect getSurfaceFrame() {
            return (Rect)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mSurfaceFrame;
        }

        
        private static final String LOG_TAG = "SurfaceHolder";
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.371 -0400", hash_original_method = "36676A10DA9FEB0757A9258740A87950", hash_generated_method = "C29A9385904F79CD2549B2FBF89F3BFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SurfaceView(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        init();
        // ---------- Original Method ----------
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.372 -0400", hash_original_method = "AC0FAD92FEC32BF55C39DC93EF8576EF", hash_generated_method = "EAFA92DD645C4F6B5E018B968CC9B927")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        init();
        // ---------- Original Method ----------
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.372 -0400", hash_original_method = "56551BC688438C77EC1087EC18E1D5A3", hash_generated_method = "DCD6CBA55BABD9B1E2E0E690E19D7301")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        init();
        // ---------- Original Method ----------
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.372 -0400", hash_original_method = "8A7163C0B5D9260FCDBBE7B713CA285D", hash_generated_method = "EC875459420059988B62E0689FF79ECE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init() {
        setWillNotDraw(true);
        // ---------- Original Method ----------
        //setWillNotDraw(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.372 -0400", hash_original_method = "11B3726B61DA4E45A86A0978E3D5B1EE", hash_generated_method = "C62F9460E075A3077B5607C806753938")
    @DSModeled(DSC.SAFE)
    public SurfaceHolder getHolder() {
        return (SurfaceHolder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSurfaceHolder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.372 -0400", hash_original_method = "D0F196EB2D52CF89A074E8F883CCEE9A", hash_generated_method = "93B471963E8AAAEF19F1DA1573E8E261")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        mParent.requestTransparentRegion(this);
        mSession = getWindowSession();
        mLayout.token = getWindowToken();
        mLayout.setTitle("SurfaceView");
        mViewVisibility = getVisibility() == VISIBLE;
        {
            ViewTreeObserver observer;
            observer = getViewTreeObserver();
            observer.addOnScrollChangedListener(mScrollChangedListener);
            observer.addOnPreDrawListener(mDrawListener);
            mGlobalListenersAdded = true;
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //mParent.requestTransparentRegion(this);
        //mSession = getWindowSession();
        //mLayout.token = getWindowToken();
        //mLayout.setTitle("SurfaceView");
        //mViewVisibility = getVisibility() == VISIBLE;
        //if (!mGlobalListenersAdded) {
            //ViewTreeObserver observer = getViewTreeObserver();
            //observer.addOnScrollChangedListener(mScrollChangedListener);
            //observer.addOnPreDrawListener(mDrawListener);
            //mGlobalListenersAdded = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.373 -0400", hash_original_method = "798A4FFA4C7A67465D94471AB247681B", hash_generated_method = "96966F31613ACEFE01706B33EB263361")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(visibility);
        super.onWindowVisibilityChanged(visibility);
        mWindowVisibility = visibility == VISIBLE;
        mRequestedVisible = mWindowVisibility && mViewVisibility;
        updateWindow(false, false);
        // ---------- Original Method ----------
        //super.onWindowVisibilityChanged(visibility);
        //mWindowVisibility = visibility == VISIBLE;
        //mRequestedVisible = mWindowVisibility && mViewVisibility;
        //updateWindow(false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.373 -0400", hash_original_method = "644621127059D6B23356D81576DC6A8B", hash_generated_method = "B78E49EB1231114483C9293EE49BC78A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setVisibility(int visibility) {
        dsTaint.addTaint(visibility);
        super.setVisibility(visibility);
        mViewVisibility = visibility == VISIBLE;
        mRequestedVisible = mWindowVisibility && mViewVisibility;
        updateWindow(false, false);
        // ---------- Original Method ----------
        //super.setVisibility(visibility);
        //mViewVisibility = visibility == VISIBLE;
        //mRequestedVisible = mWindowVisibility && mViewVisibility;
        //updateWindow(false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.373 -0400", hash_original_method = "4BCDE7E4A5F0F207B0BFA481971C6B8A", hash_generated_method = "7CEA1BFEBC6F5E058D5617D366528F58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            ViewTreeObserver observer;
            observer = getViewTreeObserver();
            observer.removeOnScrollChangedListener(mScrollChangedListener);
            observer.removeOnPreDrawListener(mDrawListener);
            mGlobalListenersAdded = false;
        } //End block
        mRequestedVisible = false;
        updateWindow(false, false);
        mHaveFrame = false;
        {
            try 
            {
                mSession.remove(mWindow);
            } //End block
            catch (RemoteException ex)
            { }
            mWindow = null;
        } //End block
        mSession = null;
        mLayout.token = null;
        super.onDetachedFromWindow();
        // ---------- Original Method ----------
        //if (mGlobalListenersAdded) {
            //ViewTreeObserver observer = getViewTreeObserver();
            //observer.removeOnScrollChangedListener(mScrollChangedListener);
            //observer.removeOnPreDrawListener(mDrawListener);
            //mGlobalListenersAdded = false;
        //}
        //mRequestedVisible = false;
        //updateWindow(false, false);
        //mHaveFrame = false;
        //if (mWindow != null) {
            //try {
                //mSession.remove(mWindow);
            //} catch (RemoteException ex) {
            //}
            //mWindow = null;
        //}
        //mSession = null;
        //mLayout.token = null;
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.373 -0400", hash_original_method = "D2E319C9E98A8DC50F96090A40CA6589", hash_generated_method = "5178143ED9F5D0B66B4830B95E0E0D74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        int width;
        width = resolveSizeAndState(mRequestedWidth, widthMeasureSpec, 0);
        width = getDefaultSize(0, widthMeasureSpec);
        int height;
        height = resolveSizeAndState(mRequestedHeight, heightMeasureSpec, 0);
        height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
        // ---------- Original Method ----------
        //int width = mRequestedWidth >= 0
                //? resolveSizeAndState(mRequestedWidth, widthMeasureSpec, 0)
                //: getDefaultSize(0, widthMeasureSpec);
        //int height = mRequestedHeight >= 0
                //? resolveSizeAndState(mRequestedHeight, heightMeasureSpec, 0)
                //: getDefaultSize(0, heightMeasureSpec);
        //setMeasuredDimension(width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.374 -0400", hash_original_method = "F99ED41FE6B39B12C38A6C99019A5F97", hash_generated_method = "13B62FE442153DB3D3EB89BB00E88738")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        boolean result;
        result = super.setFrame(left, top, right, bottom);
        updateWindow(false, false);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = super.setFrame(left, top, right, bottom);
        //updateWindow(false, false);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.374 -0400", hash_original_method = "41B5D508388526C331B138172391BB1E", hash_generated_method = "53CB7C0213CF6FADF426C92FF1444EFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean gatherTransparentRegion(Region region) {
        dsTaint.addTaint(region.dsTaint);
        {
            boolean varF8A9FBA81D6E6215EBDB1EA7BDD9AC23_1635588977 = (super.gatherTransparentRegion(region));
        } //End block
        boolean opaque;
        opaque = true;
        {
            opaque = super.gatherTransparentRegion(region);
        } //End block
        {
            int w;
            w = getWidth();
            int h;
            h = getHeight();
            {
                getLocationInWindow(mLocation);
                int l;
                l = mLocation[0];
                int t;
                t = mLocation[1];
                region.op(l, t, l+w, t+h, Region.Op.UNION);
            } //End block
        } //End block
        {
            boolean var6B55C97F53CF7E955770F784B7B82E75_1558613866 = (PixelFormat.formatHasAlpha(mRequestedFormat));
            {
                opaque = false;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWindowType == WindowManager.LayoutParams.TYPE_APPLICATION_PANEL) {
            //return super.gatherTransparentRegion(region);
        //}
        //boolean opaque = true;
        //if ((mPrivateFlags & SKIP_DRAW) == 0) {
            //opaque = super.gatherTransparentRegion(region);
        //} else if (region != null) {
            //int w = getWidth();
            //int h = getHeight();
            //if (w>0 && h>0) {
                //getLocationInWindow(mLocation);
                //int l = mLocation[0];
                //int t = mLocation[1];
                //region.op(l, t, l+w, t+h, Region.Op.UNION);
            //}
        //}
        //if (PixelFormat.formatHasAlpha(mRequestedFormat)) {
            //opaque = false;
        //}
        //return opaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.374 -0400", hash_original_method = "B44BAC95FDBF1A2D6C6E955BD515D9FE", hash_generated_method = "347A61ACB328D4022B7C7F5F8DC8021D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            } //End block
        } //End block
        super.draw(canvas);
        // ---------- Original Method ----------
        //if (mWindowType != WindowManager.LayoutParams.TYPE_APPLICATION_PANEL) {
            //if ((mPrivateFlags & SKIP_DRAW) == 0) {
                //canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            //}
        //}
        //super.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.374 -0400", hash_original_method = "1FF1947FA48636DD52DD4F3203EB471D", hash_generated_method = "08B05CF64264662F6D44BD74ECA4F0E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void dispatchDraw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            } //End block
        } //End block
        super.dispatchDraw(canvas);
        // ---------- Original Method ----------
        //if (mWindowType != WindowManager.LayoutParams.TYPE_APPLICATION_PANEL) {
            //if ((mPrivateFlags & SKIP_DRAW) == SKIP_DRAW) {
                //canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            //}
        //}
        //super.dispatchDraw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.375 -0400", hash_original_method = "FB26E6D2AB831E35DDA7A9ED4DEF2DCC", hash_generated_method = "DAF00CC701C37DD35D60CDDF1ECDE986")
    @DSModeled(DSC.SAFE)
    public void setZOrderMediaOverlay(boolean isMediaOverlay) {
        dsTaint.addTaint(isMediaOverlay);
        mWindowType = isMediaOverlay
                ? WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA_OVERLAY
                : WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
        // ---------- Original Method ----------
        //mWindowType = isMediaOverlay
                //? WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA_OVERLAY
                //: WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.375 -0400", hash_original_method = "001C3D591DD99644CBE6444F60EBCCA2", hash_generated_method = "92B39B656C2304D0434D0750A4F42912")
    @DSModeled(DSC.SAFE)
    public void setZOrderOnTop(boolean onTop) {
        dsTaint.addTaint(onTop);
        {
            mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
            mLayout.flags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        } //End block
        {
            mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
            mLayout.flags &= ~WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        } //End block
        // ---------- Original Method ----------
        //if (onTop) {
            //mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
            //mLayout.flags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        //} else {
            //mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
            //mLayout.flags &= ~WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.375 -0400", hash_original_method = "1670DE99B4A30E6D116E6931C42E66D0", hash_generated_method = "96FCE15E963CBA0ED4EC8BA6AE8D27AD")
    @DSModeled(DSC.SAFE)
    public void setWindowType(int type) {
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //mWindowType = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.526 -0400", hash_original_method = "1133978B42097E05A4BF8CED29255FA3", hash_generated_method = "01FC038ECC0C7307D932E514907469CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateWindow(boolean force, boolean redrawNeeded) {
        dsTaint.addTaint(redrawNeeded);
        dsTaint.addTaint(force);
        ViewRootImpl viewRoot;
        viewRoot = (ViewRootImpl) getRootView().getParent();
        {
            mTranslator = viewRoot.mTranslator;
        } //End block
        {
            mSurface.setCompatibilityTranslator(mTranslator);
        } //End block
        int myWidth;
        myWidth = mRequestedWidth;
        myWidth = getWidth();
        int myHeight;
        myHeight = mRequestedHeight;
        myHeight = getHeight();
        getLocationInWindow(mLocation);
        boolean creating;
        creating = mWindow == null;
        boolean formatChanged;
        formatChanged = mFormat != mRequestedFormat;
        boolean sizeChanged;
        sizeChanged = mWidth != myWidth || mHeight != myHeight;
        boolean visibleChanged;
        visibleChanged = mVisible != mRequestedVisible;
        {
            try 
            {
                boolean visible;
                visible = mVisible = mRequestedVisible;
                mLeft = mLocation[0];
                mTop = mLocation[1];
                mWidth = myWidth;
                mHeight = myHeight;
                mFormat = mRequestedFormat;
                mLayout.x = mLeft;
                mLayout.y = mTop;
                mLayout.width = getWidth();
                mLayout.height = getHeight();
                {
                    mTranslator.translateLayoutParamsInAppWindowToScreen(mLayout);
                } //End block
                mLayout.format = mRequestedFormat;
                mLayout.flags |=WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                              | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                              | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                              | WindowManager.LayoutParams.FLAG_SCALED
                              | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                              | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
                {
                    boolean var38615E851EC561AAF5BCBB7AF3CFECB6_564529268 = (!getContext().getResources().getCompatibilityInfo().supportsScreen());
                    {
                        mLayout.flags |= WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                    } //End block
                } //End collapsed parenthetic
                {
                    mWindow = new MyWindow(this);
                    mLayout.type = mWindowType;
                    mLayout.gravity = Gravity.LEFT|Gravity.TOP;
                    mSession.addWithoutInputChannel(mWindow, mWindow.mSeq, mLayout,
                            mVisible ? VISIBLE : GONE, mContentInsets);
                } //End block
                boolean realSizeChanged;
                boolean reportDrawNeeded;
                int relayoutResult;
                mSurfaceLock.lock();
                try 
                {
                    mUpdateWindowNeeded = false;
                    reportDrawNeeded = mReportDrawNeeded;
                    mReportDrawNeeded = false;
                    mDrawingStopped = !visible;
                    relayoutResult = mSession.relayout(
                        mWindow, mWindow.mSeq, mLayout, mWidth, mHeight,
                            visible ? VISIBLE : GONE,
                            WindowManagerImpl.RELAYOUT_DEFER_SURFACE_DESTROY,
                            mWinFrame, mContentInsets,
                            mVisibleInsets, mConfiguration, mNewSurface);
                    {
                        mReportDrawNeeded = true;
                    } //End block
                    mSurfaceFrame.left = 0;
                    mSurfaceFrame.top = 0;
                    {
                        mSurfaceFrame.right = mWinFrame.width();
                        mSurfaceFrame.bottom = mWinFrame.height();
                    } //End block
                    {
                        float appInvertedScale;
                        appInvertedScale = mTranslator.applicationInvertedScale;
                        mSurfaceFrame.right = (int) (mWinFrame.width() * appInvertedScale + 0.5f);
                        mSurfaceFrame.bottom = (int) (mWinFrame.height() * appInvertedScale + 0.5f);
                    } //End block
                    int surfaceWidth;
                    surfaceWidth = mSurfaceFrame.right;
                    int surfaceHeight;
                    surfaceHeight = mSurfaceFrame.bottom;
                    realSizeChanged = mLastSurfaceWidth != surfaceWidth
                            || mLastSurfaceHeight != surfaceHeight;
                    mLastSurfaceWidth = surfaceWidth;
                    mLastSurfaceHeight = surfaceHeight;
                } //End block
                finally 
                {
                    mSurfaceLock.unlock();
                } //End block
                try 
                {
                    redrawNeeded |= creating | reportDrawNeeded;
                    SurfaceHolder.Callback callbacks[];
                    callbacks = null;
                    boolean surfaceChanged;
                    surfaceChanged = (relayoutResult&WindowManagerImpl.RELAYOUT_RES_SURFACE_CHANGED) != 0;
                    {
                        mSurfaceCreated = false;
                        {
                            boolean var5AEFBDF6750B56D533A22F57FAA7F1DC_1124867208 = (mSurface.isValid());
                            {
                                callbacks = getSurfaceCallbacks();
                                {
                                    SurfaceHolder.Callback c = callbacks[0];
                                    {
                                        c.surfaceDestroyed(mSurfaceHolder);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    mSurface.transferFrom(mNewSurface);
                    {
                        {
                            mSurfaceCreated = true;
                            mIsCreating = true;
                            {
                                callbacks = getSurfaceCallbacks();
                            } //End block
                            {
                                SurfaceHolder.Callback c = callbacks[0];
                                {
                                    c.surfaceCreated(mSurfaceHolder);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                callbacks = getSurfaceCallbacks();
                            } //End block
                            {
                                SurfaceHolder.Callback c = callbacks[0];
                                {
                                    c.surfaceChanged(mSurfaceHolder, mFormat, myWidth, myHeight);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                callbacks = getSurfaceCallbacks();
                            } //End block
                            {
                                SurfaceHolder.Callback c = callbacks[0];
                                {
                                    {
                                        ((SurfaceHolder.Callback2)c).surfaceRedrawNeeded(
                                            mSurfaceHolder);
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End block
                finally 
                {
                    mIsCreating = false;
                    {
                        mSession.finishDrawing(mWindow);
                    } //End block
                    mSession.performDeferredDestroy(mWindow);
                } //End block
            } //End block
            catch (RemoteException ex)
            { }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.526 -0400", hash_original_method = "45F3E6A4EE2EB731EF40485FB92CA6AA", hash_generated_method = "5EF60AEA0E93AF7664D094ED7ADF967B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SurfaceHolder.Callback[] getSurfaceCallbacks() {
        SurfaceHolder.Callback callbacks[];
        {
            callbacks = new SurfaceHolder.Callback[mCallbacks.size()];
            mCallbacks.toArray(callbacks);
        } //End block
        return (SurfaceHolder.Callback[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //SurfaceHolder.Callback callbacks[];
        //synchronized (mCallbacks) {
            //callbacks = new SurfaceHolder.Callback[mCallbacks.size()];
            //mCallbacks.toArray(callbacks);
        //}
        //return callbacks;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.527 -0400", hash_original_method = "300B2B985E368655B5E11ADA1916748D", hash_generated_method = "A6C8E4CA52B47BE053F3A9B363230D11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleGetNewSurface() {
        updateWindow(false, false);
        // ---------- Original Method ----------
        //updateWindow(false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.527 -0400", hash_original_method = "A4CE5F54BDA2367531BCEA3F1517BC09", hash_generated_method = "E33B4A79C0C322CA6C418CF01629E772")
    @DSModeled(DSC.SAFE)
    public boolean isFixedSize() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mRequestedWidth != -1 || mRequestedHeight != -1);
    }

    
    private static class MyWindow extends BaseIWindow {
        private WeakReference<SurfaceView> mSurfaceView;
        int mCurWidth = -1;
        int mCurHeight = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.527 -0400", hash_original_method = "636A3C131A2E0F598D9E9841916F7C6A", hash_generated_method = "20E0223489B44871CE6A78CEA4A04983")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MyWindow(SurfaceView surfaceView) {
            dsTaint.addTaint(surfaceView.dsTaint);
            mSurfaceView = new WeakReference<SurfaceView>(surfaceView);
            // ---------- Original Method ----------
            //mSurfaceView = new WeakReference<SurfaceView>(surfaceView);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.527 -0400", hash_original_method = "C97B8379077214A326B52B9AC32750F8", hash_generated_method = "3D89F7E598E9E3A65EC195A76B485F23")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void resized(int w, int h, Rect coveredInsets,
                Rect visibleInsets, boolean reportDraw, Configuration newConfig) {
            dsTaint.addTaint(w);
            dsTaint.addTaint(visibleInsets.dsTaint);
            dsTaint.addTaint(reportDraw);
            dsTaint.addTaint(newConfig.dsTaint);
            dsTaint.addTaint(coveredInsets.dsTaint);
            dsTaint.addTaint(h);
            SurfaceView surfaceView;
            surfaceView = mSurfaceView.get();
            {
                surfaceView.mSurfaceLock.lock();
                try 
                {
                    {
                        surfaceView.mUpdateWindowNeeded = true;
                        surfaceView.mReportDrawNeeded = true;
                        surfaceView.mHandler.sendEmptyMessage(UPDATE_WINDOW_MSG);
                    } //End block
                    {
                        boolean var8486FAD69ADE45C78ED5AA2063613E69_173624429 = (surfaceView.mWinFrame.width() != w
                            || surfaceView.mWinFrame.height() != h);
                        {
                            surfaceView.mUpdateWindowNeeded = true;
                            surfaceView.mHandler.sendEmptyMessage(UPDATE_WINDOW_MSG);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                finally 
                {
                    surfaceView.mSurfaceLock.unlock();
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.528 -0400", hash_original_method = "BE0716F4AD0CF82E07CDF7A02946EA01", hash_generated_method = "7EDA35E6DCECAF8A5FFF06D6B921805C")
        @DSModeled(DSC.SAFE)
        public void dispatchAppVisibility(boolean visible) {
            dsTaint.addTaint(visible);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.528 -0400", hash_original_method = "9244563860F137FED28CE6F0E7AFA6B7", hash_generated_method = "0B6A53A4DAF73FBC65FE64A268111CC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchGetNewSurface() {
            SurfaceView surfaceView;
            surfaceView = mSurfaceView.get();
            {
                Message msg;
                msg = surfaceView.mHandler.obtainMessage(GET_NEW_SURFACE_MSG);
                surfaceView.mHandler.sendMessage(msg);
            } //End block
            // ---------- Original Method ----------
            //SurfaceView surfaceView = mSurfaceView.get();
            //if (surfaceView != null) {
                //Message msg = surfaceView.mHandler.obtainMessage(GET_NEW_SURFACE_MSG);
                //surfaceView.mHandler.sendMessage(msg);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.528 -0400", hash_original_method = "76E66C458D6EE4887227CD5EB1B9C2E4", hash_generated_method = "EC6722B6CC81E3A9826C3BCBAE2D2861")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void windowFocusChanged(boolean hasFocus, boolean touchEnabled) {
            dsTaint.addTaint(touchEnabled);
            dsTaint.addTaint(hasFocus);
            // ---------- Original Method ----------
            //Log.w("SurfaceView", "Unexpected focus in surface: focus=" + hasFocus + ", touchEnabled=" + touchEnabled);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.528 -0400", hash_original_method = "FFE9D2CBC83B323644FA8C6DFE6F40CA", hash_generated_method = "EB41CF4B5154F9AF2BF07F3A57CF266A")
        @DSModeled(DSC.SAFE)
        public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
            dsTaint.addTaint(command);
            dsTaint.addTaint(parameters);
            dsTaint.addTaint(out.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    static private final String TAG = "SurfaceView";
    static private final boolean DEBUG = false;
    static final int KEEP_SCREEN_ON_MSG = 1;
    static final int GET_NEW_SURFACE_MSG = 2;
    static final int UPDATE_WINDOW_MSG = 3;
}

