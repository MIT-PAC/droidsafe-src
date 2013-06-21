package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewRootImpl;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;

public class ZoomButtonsController implements View.OnTouchListener {
    private int mTouchPaddingScaledSq;
    private Context mContext;
    private WindowManager mWindowManager;
    private boolean mAutoDismissControls = true;
    private View mOwnerView;
    private int[] mOwnerViewRawLocation = new int[2];
    private FrameLayout mContainer;
    private LayoutParams mContainerLayoutParams;
    private int[] mContainerRawLocation = new int[2];
    private ZoomControls mControls;
    private View mTouchTargetView;
    private int[] mTouchTargetWindowLocation = new int[2];
    private boolean mReleaseTouchListenerOnUp;
    private boolean mIsVisible;
    private Rect mTempRect = new Rect();
    private int[] mTempIntArray = new int[2];
    private OnZoomListener mCallback;
    private Runnable mPostedVisibleInitializer;
    private IntentFilter mConfigurationChangedFilter =
            new IntentFilter(Intent.ACTION_CONFIGURATION_CHANGED);
    private final BroadcastReceiver mConfigurationChangedReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.830 -0400", hash_original_method = "CBA4474B6B69D8EAAD5A5C11EB839616", hash_generated_method = "71A3F865B23E89D67E3F7893E0469967")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            mHandler.removeMessages(MSG_POST_CONFIGURATION_CHANGED);
            mHandler.sendEmptyMessage(MSG_POST_CONFIGURATION_CHANGED);
            // ---------- Original Method ----------
            //if (!mIsVisible) return;
            //mHandler.removeMessages(MSG_POST_CONFIGURATION_CHANGED);
            //mHandler.sendEmptyMessage(MSG_POST_CONFIGURATION_CHANGED);
        }

        
}; //Transformed anonymous class
    private final Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.830 -0400", hash_original_method = "08D68F0747526F6C2171A582DECDF849", hash_generated_method = "4EFE4D7A1739576F747BF79F0B30EA9E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case MSG_POST_CONFIGURATION_CHANGED 
            onPostConfigurationChanged();
            //End case MSG_POST_CONFIGURATION_CHANGED 
            //Begin case MSG_DISMISS_ZOOM_CONTROLS 
            setVisible(false);
            //End case MSG_DISMISS_ZOOM_CONTROLS 
            //Begin case MSG_POST_SET_VISIBLE 
            {
                boolean var2D6B4C7133C3E09470E253CD882AC4AE_1492796947 = (mOwnerView.getWindowToken() == null);
                {
                    setVisible(true);
                } //End block
            } //End collapsed parenthetic
            //End case MSG_POST_SET_VISIBLE 
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case MSG_POST_CONFIGURATION_CHANGED:
                    //onPostConfigurationChanged();
                    //break;
                //case MSG_DISMISS_ZOOM_CONTROLS:
                    //setVisible(false);
                    //break;
                //case MSG_POST_SET_VISIBLE:
                    //if (mOwnerView.getWindowToken() == null) {
                        //Log.e(TAG,
                                //"Cannot make the zoom controller visible if the owner view is " +
                                //"not attached to a window.");
                    //} else {
                        //setVisible(true);
                    //}
                    //break;
            //}
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.831 -0400", hash_original_method = "380DC2A7E4A728E8B8A622AB5FAF03E2", hash_generated_method = "B268F53ABBB8FC4A699E62A47059D3D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZoomButtonsController(View ownerView) {
        dsTaint.addTaint(ownerView.dsTaint);
        mContext = ownerView.getContext();
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        mTouchPaddingScaledSq = (int)
                (ZOOM_CONTROLS_TOUCH_PADDING * mContext.getResources().getDisplayMetrics().density);
        mTouchPaddingScaledSq *= mTouchPaddingScaledSq;
        mContainer = createContainer();
        // ---------- Original Method ----------
        //mContext = ownerView.getContext();
        //mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        //mOwnerView = ownerView;
        //mTouchPaddingScaledSq = (int)
                //(ZOOM_CONTROLS_TOUCH_PADDING * mContext.getResources().getDisplayMetrics().density);
        //mTouchPaddingScaledSq *= mTouchPaddingScaledSq;
        //mContainer = createContainer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.831 -0400", hash_original_method = "3742E544F3AFD5F94AD689FCD74B6DD5", hash_generated_method = "620F6982ABD56003EA61218BD6E6E0C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setZoomInEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        mControls.setIsZoomInEnabled(enabled);
        // ---------- Original Method ----------
        //mControls.setIsZoomInEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.832 -0400", hash_original_method = "1CF0D208E223466BFE0254465182BFD8", hash_generated_method = "53C8E5074DCB055E27FC99EDD36CEAB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setZoomOutEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        mControls.setIsZoomOutEnabled(enabled);
        // ---------- Original Method ----------
        //mControls.setIsZoomOutEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.832 -0400", hash_original_method = "18B39697A9CAB4F925A2FDB6BE61BBD8", hash_generated_method = "16524F37AF1DB1AD854EB527A296B9DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setZoomSpeed(long speed) {
        dsTaint.addTaint(speed);
        mControls.setZoomSpeed(speed);
        // ---------- Original Method ----------
        //mControls.setZoomSpeed(speed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.834 -0400", hash_original_method = "4896FBB838EA68425CC17AB554E92B7B", hash_generated_method = "A392E05372708DBCCC9A6FF871CFD70F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private FrameLayout createContainer() {
        LayoutParams lp;
        lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.TOP | Gravity.LEFT;
        lp.flags = LayoutParams.FLAG_NOT_TOUCHABLE |
                LayoutParams.FLAG_NOT_FOCUSABLE |
                LayoutParams.FLAG_LAYOUT_NO_LIMITS |
                LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        lp.height = LayoutParams.WRAP_CONTENT;
        lp.width = LayoutParams.MATCH_PARENT;
        lp.type = LayoutParams.TYPE_APPLICATION_PANEL;
        lp.format = PixelFormat.TRANSLUCENT;
        lp.windowAnimations = com.android.internal.R.style.Animation_ZoomButtons;
        mContainerLayoutParams = lp;
        FrameLayout container;
        container = new Container(mContext);
        container.setLayoutParams(lp);
        container.setMeasureAllChildren(true);
        LayoutInflater inflater;
        inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(com.android.internal.R.layout.zoom_container, container);
        mControls = (ZoomControls) container.findViewById(com.android.internal.R.id.zoomControls);
        mControls.setOnZoomInClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.834 -0400", hash_original_method = "C8D887B971B187EA9E40E1FCF6E6B11D", hash_generated_method = "A2FE3C6E601A5B037627D68C70EF07F3")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(v.dsTaint);
                dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
                mCallback.onZoom(true);
                // ---------- Original Method ----------
                //dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
                //if (mCallback != null) mCallback.onZoom(true);
            }
});
        mControls.setOnZoomOutClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.834 -0400", hash_original_method = "CBCA91EA6C5A6BFF58378B31FA0529F1", hash_generated_method = "08F430BF6FAFEA1D3FF9DADCD02CA00C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(v.dsTaint);
                dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
                mCallback.onZoom(false);
                // ---------- Original Method ----------
                //dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
                //if (mCallback != null) mCallback.onZoom(false);
            }
});
        return (FrameLayout)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.834 -0400", hash_original_method = "B44D483F6F47563C2A0666A9C41723E6", hash_generated_method = "23C209803E3BBA8B7679D2128B9AC9C1")
    @DSModeled(DSC.SAFE)
    public void setOnZoomListener(OnZoomListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mCallback = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.835 -0400", hash_original_method = "E1DA778FA5C81D94D4F0CBAFCCB18381", hash_generated_method = "8F525E8A02D52C1FE6BC997EA9923086")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFocusable(boolean focusable) {
        dsTaint.addTaint(focusable);
        int oldFlags;
        oldFlags = mContainerLayoutParams.flags;
        {
            mContainerLayoutParams.flags &= ~LayoutParams.FLAG_NOT_FOCUSABLE;
        } //End block
        {
            mContainerLayoutParams.flags |= LayoutParams.FLAG_NOT_FOCUSABLE;
        } //End block
        {
            mWindowManager.updateViewLayout(mContainer, mContainerLayoutParams);
        } //End block
        // ---------- Original Method ----------
        //int oldFlags = mContainerLayoutParams.flags;
        //if (focusable) {
            //mContainerLayoutParams.flags &= ~LayoutParams.FLAG_NOT_FOCUSABLE;
        //} else {
            //mContainerLayoutParams.flags |= LayoutParams.FLAG_NOT_FOCUSABLE;
        //}
        //if ((mContainerLayoutParams.flags != oldFlags) && mIsVisible) {
            //mWindowManager.updateViewLayout(mContainer, mContainerLayoutParams);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.835 -0400", hash_original_method = "CDC5AD23EC463D7BB2411752926A03FA", hash_generated_method = "608DAAD4037821CC5BCA5BC274DE9671")
    @DSModeled(DSC.SAFE)
    public boolean isAutoDismissed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAutoDismissControls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.835 -0400", hash_original_method = "F5C09C601D97CCC2B78CB5FD3ABF9CB9", hash_generated_method = "74D0DF1AFE1238AFE83F63BBC89F4ECD")
    @DSModeled(DSC.SAFE)
    public void setAutoDismissed(boolean autoDismiss) {
        dsTaint.addTaint(autoDismiss);
        // ---------- Original Method ----------
        //if (mAutoDismissControls == autoDismiss) return;
        //mAutoDismissControls = autoDismiss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.835 -0400", hash_original_method = "74E1901CABAC1FE9F1005B36E67FD276", hash_generated_method = "294DECBA0FB8FD168625535088857773")
    @DSModeled(DSC.SAFE)
    public boolean isVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.836 -0400", hash_original_method = "E965560D7B92B1F08EBD9F8DCDBB0D54", hash_generated_method = "FAB0F7363F5CD770A25B95DBE2D8AA07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVisible(boolean visible) {
        dsTaint.addTaint(visible);
        {
            {
                boolean var2D6B4C7133C3E09470E253CD882AC4AE_358134955 = (mOwnerView.getWindowToken() == null);
                {
                    {
                        boolean var9A4E95F470ACBC1003187D9BC10AE161_78243577 = (!mHandler.hasMessages(MSG_POST_SET_VISIBLE));
                        {
                            mHandler.sendEmptyMessage(MSG_POST_SET_VISIBLE);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        } //End block
        {
            {
                mContainerLayoutParams.token = mOwnerView.getWindowToken();
            } //End block
            mWindowManager.addView(mContainer, mContainerLayoutParams);
            {
                mPostedVisibleInitializer = new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.836 -0400", hash_original_method = "EAB472F3FC4942C1E0EBF0AC1701A96E", hash_generated_method = "10B0682055CC46BB4AF0F95C79CAE8B9")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public void run() {
                        refreshPositioningVariables();
                        {
                            mCallback.onVisibilityChanged(true);
                        } //End block
                        // ---------- Original Method ----------
                        //refreshPositioningVariables();
                        //if (mCallback != null) {
                            //mCallback.onVisibilityChanged(true);
                        //}
                    }
};
            } //End block
            mHandler.post(mPostedVisibleInitializer);
            mContext.registerReceiver(mConfigurationChangedReceiver, mConfigurationChangedFilter);
            mOwnerView.setOnTouchListener(this);
            mReleaseTouchListenerOnUp = false;
        } //End block
        {
            {
                mReleaseTouchListenerOnUp = true;
            } //End block
            {
                mOwnerView.setOnTouchListener(null);
            } //End block
            mContext.unregisterReceiver(mConfigurationChangedReceiver);
            mWindowManager.removeView(mContainer);
            mHandler.removeCallbacks(mPostedVisibleInitializer);
            {
                mCallback.onVisibilityChanged(false);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.836 -0400", hash_original_method = "5F28A319C2D73660C6EEE12017C9EFC5", hash_generated_method = "B24C96E020F64E77E941B21F17F7770E")
    @DSModeled(DSC.SAFE)
    public ViewGroup getContainer() {
        return (ViewGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContainer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.836 -0400", hash_original_method = "7C1C4B956CF0AB08A097C4C4837C0B3D", hash_generated_method = "57A6A6AEB9D671996E660465F15170AD")
    @DSModeled(DSC.SAFE)
    public View getZoomControls() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mControls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.836 -0400", hash_original_method = "9FC1F818AD77D871CBB70B150EF10183", hash_generated_method = "B4476EFC01F2AADBEAA92C1744C7EC4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dismissControlsDelayed(int delay) {
        dsTaint.addTaint(delay);
        {
            mHandler.removeMessages(MSG_DISMISS_ZOOM_CONTROLS);
            mHandler.sendEmptyMessageDelayed(MSG_DISMISS_ZOOM_CONTROLS, delay);
        } //End block
        // ---------- Original Method ----------
        //if (mAutoDismissControls) {
            //mHandler.removeMessages(MSG_DISMISS_ZOOM_CONTROLS);
            //mHandler.sendEmptyMessageDelayed(MSG_DISMISS_ZOOM_CONTROLS, delay);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.837 -0400", hash_original_method = "AC8EA5B19015CD5AEB4699B6A0E359A3", hash_generated_method = "088E2A80936C52243E246584002291CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void refreshPositioningVariables() {
        {
            boolean var2D4339CEF2CDEECF31246867A013F13B_1116811921 = (mOwnerView.getWindowToken() == null);
        } //End collapsed parenthetic
        int ownerHeight;
        ownerHeight = mOwnerView.getHeight();
        int ownerWidth;
        ownerWidth = mOwnerView.getWidth();
        int containerOwnerYOffset;
        containerOwnerYOffset = ownerHeight - mContainer.getHeight();
        mOwnerView.getLocationOnScreen(mOwnerViewRawLocation);
        mContainerRawLocation[0] = mOwnerViewRawLocation[0];
        mContainerRawLocation[1] = mOwnerViewRawLocation[1] + containerOwnerYOffset;
        int[] ownerViewWindowLoc;
        ownerViewWindowLoc = mTempIntArray;
        mOwnerView.getLocationInWindow(ownerViewWindowLoc);
        mContainerLayoutParams.x = ownerViewWindowLoc[0];
        mContainerLayoutParams.width = ownerWidth;
        mContainerLayoutParams.y = ownerViewWindowLoc[1] + containerOwnerYOffset;
        {
            mWindowManager.updateViewLayout(mContainer, mContainerLayoutParams);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.837 -0400", hash_original_method = "378B3DC7088565C3BEBCF57941C87615", hash_generated_method = "9C3A09996927D3E87F6BA0A0242B2412")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean onContainerKey(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        int keyCode;
        keyCode = event.getKeyCode();
        {
            boolean varD9C7815C9811CC574B958A7386252FC9_2075039335 = (isInterestingKey(keyCode));
            {
                {
                    {
                        boolean varF456D875C94EFA50F4F83E456081D7DC_308269585 = (event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0);
                        {
                            {
                                KeyEvent.DispatcherState ds;
                                ds = mOwnerView.getKeyDispatcherState();
                                {
                                    ds.startTracking(event, this);
                                } //End block
                            } //End block
                        } //End block
                        {
                            boolean varEC493C69A44980199FBD06318B95FEEB_896716295 = (event.getAction() == KeyEvent.ACTION_UP
                        && event.isTracking() && !event.isCanceled());
                            {
                                setVisible(false);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                {
                    dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
                } //End block
            } //End block
            {
                ViewRootImpl viewRoot;
                viewRoot = getOwnerViewRootImpl();
                {
                    viewRoot.dispatchKey(event);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.837 -0400", hash_original_method = "1F6E6E50114A7831DEC27688067C55C8", hash_generated_method = "A8C05E7F42E454DB82E3C86390FEBA35")
    @DSModeled(DSC.SAFE)
    private boolean isInterestingKey(int keyCode) {
        dsTaint.addTaint(keyCode);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (keyCode) {
            //case KeyEvent.KEYCODE_DPAD_CENTER:
            //case KeyEvent.KEYCODE_DPAD_UP:
            //case KeyEvent.KEYCODE_DPAD_DOWN:
            //case KeyEvent.KEYCODE_DPAD_LEFT:
            //case KeyEvent.KEYCODE_DPAD_RIGHT:
            //case KeyEvent.KEYCODE_ENTER:
            //case KeyEvent.KEYCODE_BACK:
                //return true;
            //default:
                //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.838 -0400", hash_original_method = "682CD28D25D57C221683C84B731CBBF0", hash_generated_method = "2D6734F2B5430D11768E04E5058791EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ViewRootImpl getOwnerViewRootImpl() {
        View rootViewOfOwner;
        rootViewOfOwner = mOwnerView.getRootView();
        ViewParent parentOfRootView;
        parentOfRootView = rootViewOfOwner.getParent();
        return (ViewRootImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //View rootViewOfOwner = mOwnerView.getRootView();
        //if (rootViewOfOwner == null) {
            //return null;
        //}
        //ViewParent parentOfRootView = rootViewOfOwner.getParent();
        //if (parentOfRootView instanceof ViewRootImpl) {
            //return (ViewRootImpl) parentOfRootView;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.838 -0400", hash_original_method = "AC268A3687D4D0CE3C71C1BC69224E9B", hash_generated_method = "613F43C6C314C7AD238EB642CE984DAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTouch(View v, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        int action;
        action = event.getAction();
        {
            boolean var1AEB63FDD5BAA0960B45EA0BA88A4345_556399998 = (event.getPointerCount() > 1);
        } //End collapsed parenthetic
        {
            {
                mOwnerView.setOnTouchListener(null);
                setTouchTargetView(null);
                mReleaseTouchListenerOnUp = false;
            } //End block
        } //End block
        dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        View targetView;
        targetView = mTouchTargetView;
        //Begin case MotionEvent.ACTION_DOWN 
        targetView = findViewForTouch((int) event.getRawX(), (int) event.getRawY());
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        setTouchTargetView(targetView);
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
        setTouchTargetView(null);
        //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
        {
            int targetViewRawX;
            targetViewRawX = mContainerRawLocation[0] + mTouchTargetWindowLocation[0];
            int targetViewRawY;
            targetViewRawY = mContainerRawLocation[1] + mTouchTargetWindowLocation[1];
            MotionEvent containerEvent;
            containerEvent = MotionEvent.obtain(event);
            containerEvent.offsetLocation(mOwnerViewRawLocation[0] - targetViewRawX,
                    mOwnerViewRawLocation[1] - targetViewRawY);
            float containerX;
            containerX = containerEvent.getX();
            float containerY;
            containerY = containerEvent.getY();
            {
                containerEvent.offsetLocation(-containerX, 0);
            } //End block
            {
                containerEvent.offsetLocation(0, -containerY);
            } //End block
            boolean retValue;
            retValue = targetView.dispatchTouchEvent(containerEvent);
            containerEvent.recycle();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.838 -0400", hash_original_method = "5B47D11F01081A67B0DC801C22F3388C", hash_generated_method = "D1DCD186923EAC3F626480C7F3FDAC69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setTouchTargetView(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            view.getLocationInWindow(mTouchTargetWindowLocation);
        } //End block
        // ---------- Original Method ----------
        //mTouchTargetView = view;
        //if (view != null) {
            //view.getLocationInWindow(mTouchTargetWindowLocation);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.839 -0400", hash_original_method = "87725495631184F2D9436EB1CA8B8776", hash_generated_method = "B33ED83D5499B0A192DD0D0B6D686F75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private View findViewForTouch(int rawX, int rawY) {
        dsTaint.addTaint(rawY);
        dsTaint.addTaint(rawX);
        int containerCoordsX;
        containerCoordsX = rawX - mContainerRawLocation[0];
        int containerCoordsY;
        containerCoordsY = rawY - mContainerRawLocation[1];
        Rect frame;
        frame = mTempRect;
        View closestChild;
        closestChild = null;
        int closestChildDistanceSq;
        closestChildDistanceSq = Integer.MAX_VALUE;
        {
            int i;
            i = mContainer.getChildCount() - 1;
            {
                View child;
                child = mContainer.getChildAt(i);
                {
                    boolean varDC14093C8CD60D90554507229044E659_2005987194 = (child.getVisibility() != View.VISIBLE);
                } //End collapsed parenthetic
                child.getHitRect(frame);
                {
                    boolean var066E484B2EAC769EC84C7D51A6C5B7CD_1025050296 = (frame.contains(containerCoordsX, containerCoordsY));
                } //End collapsed parenthetic
                int distanceX;
                {
                    distanceX = 0;
                } //End block
                {
                    distanceX = Math.min(Math.abs(frame.left - containerCoordsX),
                    Math.abs(containerCoordsX - frame.right));
                } //End block
                int distanceY;
                {
                    distanceY = 0;
                } //End block
                {
                    distanceY = Math.min(Math.abs(frame.top - containerCoordsY),
                        Math.abs(containerCoordsY - frame.bottom));
                } //End block
                int distanceSq;
                distanceSq = distanceX * distanceX + distanceY * distanceY;
                {
                    closestChild = child;
                    closestChildDistanceSq = distanceSq;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.839 -0400", hash_original_method = "17B14786F835EF976BE6949F1B3BDF94", hash_generated_method = "F20F1B1E54FFC0101AD0D428F6B397DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onPostConfigurationChanged() {
        dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        refreshPositioningVariables();
        // ---------- Original Method ----------
        //dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        //refreshPositioningVariables();
    }

    
    private class Container extends FrameLayout {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.839 -0400", hash_original_method = "F501EF92597324297985E451C1487263", hash_generated_method = "6F073A3E627A7900350F40751EAF86BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Container(Context context) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.840 -0400", hash_original_method = "9ADB1F3C4E22FAC9B13C38DB47141BED", hash_generated_method = "3A6C87046905C1622B7B372E384B1850")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            dsTaint.addTaint(event.dsTaint);
            {
                boolean var9DAF16109AC94402109430D71D88F9D2_1631485898 = (onContainerKey(event));
                Object varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_2023518214 = (super.dispatchKeyEvent(event));
            } //End flattened ternary
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return onContainerKey(event) ? true : super.dispatchKeyEvent(event);
        }

        
    }


    
    public interface OnZoomListener {

        
        void onVisibilityChanged(boolean visible);

        
        void onZoom(boolean zoomIn);
    }
    
    private static final String TAG = "ZoomButtonsController";
    private static final int ZOOM_CONTROLS_TIMEOUT =
            (int) ViewConfiguration.getZoomControlsTimeout();
    private static final int ZOOM_CONTROLS_TOUCH_PADDING = 20;
    private static final int MSG_POST_CONFIGURATION_CHANGED = 2;
    private static final int MSG_DISMISS_ZOOM_CONTROLS = 3;
    private static final int MSG_POST_SET_VISIBLE = 4;
}

