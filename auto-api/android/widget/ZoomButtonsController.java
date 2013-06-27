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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.666 -0400", hash_original_field = "1CC5B944F91B1CAEF9E1C10ED13D1F97", hash_generated_field = "31366FBB195E6D4943166A1CF4E59210")

    private int mTouchPaddingScaledSq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.666 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.666 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.666 -0400", hash_original_field = "FE8EE9D888F7779DD5F42BE5328C37C3", hash_generated_field = "E32C26221A599AF38CE047CEA9708612")

    private boolean mAutoDismissControls = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.666 -0400", hash_original_field = "9328FA61A62F4AFB2BABF8F19BE1C98A", hash_generated_field = "E5DC02A18C4817B413C22883E087C5E5")

    private View mOwnerView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.666 -0400", hash_original_field = "4F5AE11A75135D267DFD11C03893C565", hash_generated_field = "559495B950DF1669D23D36FAF1107DD9")

    private int[] mOwnerViewRawLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "DE7D4566565DA445D3E9FC64F9F679E7")

    private FrameLayout mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "37DF3A2FD7F1A3950C59EB4236FC5193", hash_generated_field = "3C55C1D38F1D3A12D40650C5BEE8D028")

    private LayoutParams mContainerLayoutParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "46F0BA02F06C8EB1652566BC7F9B4CFE", hash_generated_field = "D48F12305776FA6E99878DB676CC226E")

    private int[] mContainerRawLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "8DA686741271C843AD84C8022C413C01", hash_generated_field = "EA1868BE7D996683F2989202D2AC4DDD")

    private ZoomControls mControls;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "02A61E15C056169827183200421D0E22", hash_generated_field = "4214AAFC096B21883792ABCE78232C36")

    private View mTouchTargetView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "FF2E4B5120660D7EC9A7A9BCC5CD7106", hash_generated_field = "0B05305DB7910A02136AD9D3707473C9")

    private int[] mTouchTargetWindowLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "8E4AFED5ED55DE09DBF63202BD03FD89", hash_generated_field = "B050564438297A698F60861F546D1BDC")

    private boolean mReleaseTouchListenerOnUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "3841FA617DC417560C9ACBBE88413EC6", hash_generated_field = "16B558D924DF2404F3A2E9E477E1C239")

    private boolean mIsVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AFFA54D19F07A10EE8847CF76FC95323")

    private Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "F6FD3D6247A2F446133C6FE9981D05F5", hash_generated_field = "3F37314F4AB77205AD54497621D94DB8")

    private int[] mTempIntArray = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "69BC292DD0AFDA8A4F57DC4BCBE69348")

    private OnZoomListener mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "C98BBC28C3ECC9AFA024709DA03CECB8", hash_generated_field = "1ED441E7D4D48C31070345ADC5874E3A")

    private Runnable mPostedVisibleInitializer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.667 -0400", hash_original_field = "54942985B0978FF368CEED03D9313DD3", hash_generated_field = "2685C6012FE6DC8BEA0BBFFF2E0AB460")

    private IntentFilter mConfigurationChangedFilter = new IntentFilter(Intent.ACTION_CONFIGURATION_CHANGED);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.676 -0400", hash_original_field = "F7238A3294ACE5864BA2567DBF187A8E", hash_generated_field = "BAAE595D4E689390312885504C70ED17")

    private BroadcastReceiver mConfigurationChangedReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.676 -0400", hash_original_method = "CBA4474B6B69D8EAAD5A5C11EB839616", hash_generated_method = "F83C34B85F2FCA1335A3AC869BD1F32D")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mHandler.removeMessages(MSG_POST_CONFIGURATION_CHANGED);
            mHandler.sendEmptyMessage(MSG_POST_CONFIGURATION_CHANGED);
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //if (!mIsVisible) return;
            //mHandler.removeMessages(MSG_POST_CONFIGURATION_CHANGED);
            //mHandler.sendEmptyMessage(MSG_POST_CONFIGURATION_CHANGED);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.678 -0400", hash_original_field = "E7709E2A554C5D6ACC0DCFB2BB1FB7B7", hash_generated_field = "9DE2B2FAECDA9819A898CDA82270A91B")

    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.677 -0400", hash_original_method = "08D68F0747526F6C2171A582DECDF849", hash_generated_method = "1EC545380A826523EC5C0F42F053E5FA")
        @Override
        public void handleMessage(Message msg) {
            //Begin case MSG_POST_CONFIGURATION_CHANGED 
            onPostConfigurationChanged();
            //End case MSG_POST_CONFIGURATION_CHANGED 
            //Begin case MSG_DISMISS_ZOOM_CONTROLS 
            setVisible(false);
            //End case MSG_DISMISS_ZOOM_CONTROLS 
            //Begin case MSG_POST_SET_VISIBLE 
            {
                boolean var2D6B4C7133C3E09470E253CD882AC4AE_1308596196 = (mOwnerView.getWindowToken() == null);
                {
                    setVisible(true);
                } //End block
            } //End collapsed parenthetic
            //End case MSG_POST_SET_VISIBLE 
            addTaint(msg.getTaint());
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

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.678 -0400", hash_original_method = "380DC2A7E4A728E8B8A622AB5FAF03E2", hash_generated_method = "0A58F7464A42BDD3A103DF6B2DF3EF11")
    public  ZoomButtonsController(View ownerView) {
        mContext = ownerView.getContext();
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        mOwnerView = ownerView;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.688 -0400", hash_original_method = "3742E544F3AFD5F94AD689FCD74B6DD5", hash_generated_method = "5B5524A67352B23E546BDFBCDCF3BABB")
    public void setZoomInEnabled(boolean enabled) {
        mControls.setIsZoomInEnabled(enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //mControls.setIsZoomInEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.688 -0400", hash_original_method = "1CF0D208E223466BFE0254465182BFD8", hash_generated_method = "C2B70333222D9B2089EBD0281528A3C2")
    public void setZoomOutEnabled(boolean enabled) {
        mControls.setIsZoomOutEnabled(enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //mControls.setIsZoomOutEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.688 -0400", hash_original_method = "18B39697A9CAB4F925A2FDB6BE61BBD8", hash_generated_method = "2C45338C4D3F860DD9834F9C40C14B9B")
    public void setZoomSpeed(long speed) {
        mControls.setZoomSpeed(speed);
        addTaint(speed);
        // ---------- Original Method ----------
        //mControls.setZoomSpeed(speed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.698 -0400", hash_original_method = "4896FBB838EA68425CC17AB554E92B7B", hash_generated_method = "94D772088500E2CD90072928C5843538")
    private FrameLayout createContainer() {
        FrameLayout varB4EAC82CA7396A68D541C85D26508E83_1335044626 = null; //Variable for return #1
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.694 -0400", hash_original_method = "C8D887B971B187EA9E40E1FCF6E6B11D", hash_generated_method = "F9D4F3B6846D05276EA8F4AB2A7DE190")
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
                mCallback.onZoom(true);
                addTaint(v.getTaint());
                // ---------- Original Method ----------
                //dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
                //if (mCallback != null) mCallback.onZoom(true);
            }
});
        mControls.setOnZoomOutClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.696 -0400", hash_original_method = "CBCA91EA6C5A6BFF58378B31FA0529F1", hash_generated_method = "B3CABA981A0915206EC38E80A85E32B5")
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
                mCallback.onZoom(false);
                addTaint(v.getTaint());
                // ---------- Original Method ----------
                //dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
                //if (mCallback != null) mCallback.onZoom(false);
            }
});
        varB4EAC82CA7396A68D541C85D26508E83_1335044626 = container;
        varB4EAC82CA7396A68D541C85D26508E83_1335044626.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1335044626;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.699 -0400", hash_original_method = "B44D483F6F47563C2A0666A9C41723E6", hash_generated_method = "39466DB7BD80A5311AC75D7EF4F60C50")
    public void setOnZoomListener(OnZoomListener listener) {
        mCallback = listener;
        // ---------- Original Method ----------
        //mCallback = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.707 -0400", hash_original_method = "E1DA778FA5C81D94D4F0CBAFCCB18381", hash_generated_method = "6ED1C33B0C4275B875818C9D2B82F47E")
    public void setFocusable(boolean focusable) {
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
        addTaint(focusable);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.708 -0400", hash_original_method = "CDC5AD23EC463D7BB2411752926A03FA", hash_generated_method = "8DDA5744E2A2DE4BC6CF86F318B003A9")
    public boolean isAutoDismissed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1713599078 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1713599078;
        // ---------- Original Method ----------
        //return mAutoDismissControls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.708 -0400", hash_original_method = "F5C09C601D97CCC2B78CB5FD3ABF9CB9", hash_generated_method = "0658DFBD9214CCF478A566E2F117C6C3")
    public void setAutoDismissed(boolean autoDismiss) {
        mAutoDismissControls = autoDismiss;
        // ---------- Original Method ----------
        //if (mAutoDismissControls == autoDismiss) return;
        //mAutoDismissControls = autoDismiss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.708 -0400", hash_original_method = "74E1901CABAC1FE9F1005B36E67FD276", hash_generated_method = "CF00E755EF2E283D04B97093DE42F7B5")
    public boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351536558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_351536558;
        // ---------- Original Method ----------
        //return mIsVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.728 -0400", hash_original_method = "E965560D7B92B1F08EBD9F8DCDBB0D54", hash_generated_method = "5EA65E75770CCF88EED6FFC14170B981")
    public void setVisible(boolean visible) {
        {
            {
                boolean var2D6B4C7133C3E09470E253CD882AC4AE_798437448 = (mOwnerView.getWindowToken() == null);
                {
                    {
                        boolean var9A4E95F470ACBC1003187D9BC10AE161_1297005812 = (!mHandler.hasMessages(MSG_POST_SET_VISIBLE));
                        {
                            mHandler.sendEmptyMessage(MSG_POST_SET_VISIBLE);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        } //End block
        mIsVisible = visible;
        {
            {
                mContainerLayoutParams.token = mOwnerView.getWindowToken();
            } //End block
            mWindowManager.addView(mContainer, mContainerLayoutParams);
            {
                mPostedVisibleInitializer = new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.727 -0400", hash_original_method = "EAB472F3FC4942C1E0EBF0AC1701A96E", hash_generated_method = "10B0682055CC46BB4AF0F95C79CAE8B9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.735 -0400", hash_original_method = "5F28A319C2D73660C6EEE12017C9EFC5", hash_generated_method = "0328A02E03E78CC29BF45DBD89803383")
    public ViewGroup getContainer() {
        ViewGroup varB4EAC82CA7396A68D541C85D26508E83_2096627050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2096627050 = mContainer;
        varB4EAC82CA7396A68D541C85D26508E83_2096627050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2096627050;
        // ---------- Original Method ----------
        //return mContainer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.736 -0400", hash_original_method = "7C1C4B956CF0AB08A097C4C4837C0B3D", hash_generated_method = "0412CBEE44BEFA4FEE03B16DBF44947A")
    public View getZoomControls() {
        View varB4EAC82CA7396A68D541C85D26508E83_551386064 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_551386064 = mControls;
        varB4EAC82CA7396A68D541C85D26508E83_551386064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_551386064;
        // ---------- Original Method ----------
        //return mControls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.736 -0400", hash_original_method = "9FC1F818AD77D871CBB70B150EF10183", hash_generated_method = "934674E6B4B6B9EC034599A9FD28A0D7")
    private void dismissControlsDelayed(int delay) {
        {
            mHandler.removeMessages(MSG_DISMISS_ZOOM_CONTROLS);
            mHandler.sendEmptyMessageDelayed(MSG_DISMISS_ZOOM_CONTROLS, delay);
        } //End block
        addTaint(delay);
        // ---------- Original Method ----------
        //if (mAutoDismissControls) {
            //mHandler.removeMessages(MSG_DISMISS_ZOOM_CONTROLS);
            //mHandler.sendEmptyMessageDelayed(MSG_DISMISS_ZOOM_CONTROLS, delay);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.737 -0400", hash_original_method = "AC8EA5B19015CD5AEB4699B6A0E359A3", hash_generated_method = "D8E767193C2A13289F45D11B49715306")
    private void refreshPositioningVariables() {
        {
            boolean var2D4339CEF2CDEECF31246867A013F13B_583425887 = (mOwnerView.getWindowToken() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.790 -0400", hash_original_method = "378B3DC7088565C3BEBCF57941C87615", hash_generated_method = "A1AD89CFBD346EFF05A769E619C51848")
    private boolean onContainerKey(KeyEvent event) {
        int keyCode;
        keyCode = event.getKeyCode();
        {
            boolean varD9C7815C9811CC574B958A7386252FC9_651412867 = (isInterestingKey(keyCode));
            {
                {
                    {
                        boolean varF456D875C94EFA50F4F83E456081D7DC_1924978187 = (event.getAction() == KeyEvent.ACTION_DOWN
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
                            boolean varEC493C69A44980199FBD06318B95FEEB_1807063651 = (event.getAction() == KeyEvent.ACTION_UP
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
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354665281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354665281;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.791 -0400", hash_original_method = "1F6E6E50114A7831DEC27688067C55C8", hash_generated_method = "ABA9B0402ADE280B24FB0D4554FDCFC4")
    private boolean isInterestingKey(int keyCode) {
        addTaint(keyCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659015956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659015956;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.792 -0400", hash_original_method = "682CD28D25D57C221683C84B731CBBF0", hash_generated_method = "A5A6E66872A5392E73359ADCF8B4179F")
    private ViewRootImpl getOwnerViewRootImpl() {
        ViewRootImpl varB4EAC82CA7396A68D541C85D26508E83_496281839 = null; //Variable for return #1
        ViewRootImpl varB4EAC82CA7396A68D541C85D26508E83_2115480736 = null; //Variable for return #2
        ViewRootImpl varB4EAC82CA7396A68D541C85D26508E83_298932930 = null; //Variable for return #3
        View rootViewOfOwner;
        rootViewOfOwner = mOwnerView.getRootView();
        {
            varB4EAC82CA7396A68D541C85D26508E83_496281839 = null;
        } //End block
        ViewParent parentOfRootView;
        parentOfRootView = rootViewOfOwner.getParent();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2115480736 = (ViewRootImpl) parentOfRootView;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_298932930 = null;
        } //End block
        ViewRootImpl varA7E53CE21691AB073D9660D615818899_1619666870; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1619666870 = varB4EAC82CA7396A68D541C85D26508E83_496281839;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1619666870 = varB4EAC82CA7396A68D541C85D26508E83_2115480736;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1619666870 = varB4EAC82CA7396A68D541C85D26508E83_298932930;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1619666870.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1619666870;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.793 -0400", hash_original_method = "AC268A3687D4D0CE3C71C1BC69224E9B", hash_generated_method = "7C9DB587D501B93C2AB6A43ECA731781")
    public boolean onTouch(View v, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int action;
        action = event.getAction();
        {
            boolean var1AEB63FDD5BAA0960B45EA0BA88A4345_797780095 = (event.getPointerCount() > 1);
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
        addTaint(v.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1815294553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1815294553;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.794 -0400", hash_original_method = "5B47D11F01081A67B0DC801C22F3388C", hash_generated_method = "5F4FB54A418235009CE2C82EBDBF8503")
    private void setTouchTargetView(View view) {
        mTouchTargetView = view;
        {
            view.getLocationInWindow(mTouchTargetWindowLocation);
        } //End block
        // ---------- Original Method ----------
        //mTouchTargetView = view;
        //if (view != null) {
            //view.getLocationInWindow(mTouchTargetWindowLocation);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.795 -0400", hash_original_method = "87725495631184F2D9436EB1CA8B8776", hash_generated_method = "32212605D54F7A7D3E12C1C82A5AA7D4")
    private View findViewForTouch(int rawX, int rawY) {
        View varB4EAC82CA7396A68D541C85D26508E83_2014166526 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1627540805 = null; //Variable for return #2
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
                    boolean varDC14093C8CD60D90554507229044E659_1900348425 = (child.getVisibility() != View.VISIBLE);
                } //End collapsed parenthetic
                child.getHitRect(frame);
                {
                    boolean var066E484B2EAC769EC84C7D51A6C5B7CD_1255853435 = (frame.contains(containerCoordsX, containerCoordsY));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2014166526 = child;
                    } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_1627540805 = closestChild;
        addTaint(rawX);
        addTaint(rawY);
        View varA7E53CE21691AB073D9660D615818899_1607948730; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1607948730 = varB4EAC82CA7396A68D541C85D26508E83_2014166526;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1607948730 = varB4EAC82CA7396A68D541C85D26508E83_1627540805;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1607948730.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1607948730;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.796 -0400", hash_original_method = "17B14786F835EF976BE6949F1B3BDF94", hash_generated_method = "F20F1B1E54FFC0101AD0D428F6B397DF")
    private void onPostConfigurationChanged() {
        dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        refreshPositioningVariables();
        // ---------- Original Method ----------
        //dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        //refreshPositioningVariables();
    }

    
    private class Container extends FrameLayout {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.796 -0400", hash_original_method = "F501EF92597324297985E451C1487263", hash_generated_method = "6C7FE0A8EC88EB82037FA3CBCBCDAEFE")
        public  Container(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.804 -0400", hash_original_method = "9ADB1F3C4E22FAC9B13C38DB47141BED", hash_generated_method = "EC8530F142C6790DE4D71BB83DC5D5C3")
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            {
                boolean var9DAF16109AC94402109430D71D88F9D2_1595848869 = (onContainerKey(event));
                Object varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_1205687938 = (super.dispatchKeyEvent(event));
            } //End flattened ternary
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1063990022 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1063990022;
            // ---------- Original Method ----------
            //return onContainerKey(event) ? true : super.dispatchKeyEvent(event);
        }

        
    }


    
    public interface OnZoomListener {

        
        void onVisibilityChanged(boolean visible);

        
        void onZoom(boolean zoomIn);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.804 -0400", hash_original_field = "788A21D54466EA345DF78A210F61BFDB", hash_generated_field = "4EBFDC0CF7EA368DE9C7C091D395F272")

    private static String TAG = "ZoomButtonsController";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.805 -0400", hash_original_field = "5D6E37BCE72DAC569EA42869CC543F50", hash_generated_field = "FCE967ABC3937F16571B698CADCDDDF2")

    private static int ZOOM_CONTROLS_TIMEOUT = (int) ViewConfiguration.getZoomControlsTimeout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.805 -0400", hash_original_field = "28FE46A9CB38173700937CBF032F0465", hash_generated_field = "6EDDCAC16313FA2EDBDC02151E4911C6")

    private static int ZOOM_CONTROLS_TOUCH_PADDING = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.805 -0400", hash_original_field = "DF4E4863EC3A9B2BAA55B086A497D764", hash_generated_field = "F80DD488C6EE193B5189853008E9DD5B")

    private static int MSG_POST_CONFIGURATION_CHANGED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.805 -0400", hash_original_field = "9FD71970941437D96FFAD21A41D4DDF8", hash_generated_field = "A4F5B53AA4024FBB2F155389323393A2")

    private static int MSG_DISMISS_ZOOM_CONTROLS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.805 -0400", hash_original_field = "B1D6E8B124954621CBC6331033C52C66", hash_generated_field = "214B9A229CA53E18604CFAD0EF7EACD2")

    private static int MSG_POST_SET_VISIBLE = 4;
}

