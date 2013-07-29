package android.widget;

// Droidsafe Imports
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewRootImpl;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ZoomButtonsController implements View.OnTouchListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.358 -0400", hash_original_field = "1CC5B944F91B1CAEF9E1C10ED13D1F97", hash_generated_field = "31366FBB195E6D4943166A1CF4E59210")

    private int mTouchPaddingScaledSq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "FE8EE9D888F7779DD5F42BE5328C37C3", hash_generated_field = "E32C26221A599AF38CE047CEA9708612")

    private boolean mAutoDismissControls = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "9328FA61A62F4AFB2BABF8F19BE1C98A", hash_generated_field = "E5DC02A18C4817B413C22883E087C5E5")

    private View mOwnerView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "4F5AE11A75135D267DFD11C03893C565", hash_generated_field = "778B5A3646480827509FB2BFB25E57EC")

    private final int[] mOwnerViewRawLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "DE7D4566565DA445D3E9FC64F9F679E7")

    private FrameLayout mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "37DF3A2FD7F1A3950C59EB4236FC5193", hash_generated_field = "3C55C1D38F1D3A12D40650C5BEE8D028")

    private LayoutParams mContainerLayoutParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "46F0BA02F06C8EB1652566BC7F9B4CFE", hash_generated_field = "E3C0FB2A785E1B8D5D1C914264C73BEA")

    private final int[] mContainerRawLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "8DA686741271C843AD84C8022C413C01", hash_generated_field = "EA1868BE7D996683F2989202D2AC4DDD")

    private ZoomControls mControls;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "02A61E15C056169827183200421D0E22", hash_generated_field = "4214AAFC096B21883792ABCE78232C36")

    private View mTouchTargetView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "FF2E4B5120660D7EC9A7A9BCC5CD7106", hash_generated_field = "0F94F89170BE0719490D13F384546F40")

    private final int[] mTouchTargetWindowLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "8E4AFED5ED55DE09DBF63202BD03FD89", hash_generated_field = "B050564438297A698F60861F546D1BDC")

    private boolean mReleaseTouchListenerOnUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "3841FA617DC417560C9ACBBE88413EC6", hash_generated_field = "16B558D924DF2404F3A2E9E477E1C239")

    private boolean mIsVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "F6FD3D6247A2F446133C6FE9981D05F5", hash_generated_field = "37699E1557DE199CB1E3D694670D31BB")

    private final int[] mTempIntArray = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "69BC292DD0AFDA8A4F57DC4BCBE69348")

    private OnZoomListener mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "C98BBC28C3ECC9AFA024709DA03CECB8", hash_generated_field = "1ED441E7D4D48C31070345ADC5874E3A")

    private Runnable mPostedVisibleInitializer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.359 -0400", hash_original_field = "54942985B0978FF368CEED03D9313DD3", hash_generated_field = "314D614F45BCFBC7FD4D2764A847AE51")

    private final IntentFilter mConfigurationChangedFilter = new IntentFilter(Intent.ACTION_CONFIGURATION_CHANGED);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.332 -0400", hash_original_field = "F7238A3294ACE5864BA2567DBF187A8E", hash_generated_field = "E4D2EB0B4308FE203FF175FADAC6AA6E")

    private final BroadcastReceiver mConfigurationChangedReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.332 -0400", hash_original_method = "CBA4474B6B69D8EAAD5A5C11EB839616", hash_generated_method = "F83C34B85F2FCA1335A3AC869BD1F32D")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            mHandler.removeMessages(MSG_POST_CONFIGURATION_CHANGED);
            mHandler.sendEmptyMessage(MSG_POST_CONFIGURATION_CHANGED);
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.332 -0400", hash_original_field = "E7709E2A554C5D6ACC0DCFB2BB1FB7B7", hash_generated_field = "F70694DA0401A421E844EF7D59C877AC")

    private final Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.332 -0400", hash_original_method = "08D68F0747526F6C2171A582DECDF849", hash_generated_method = "CFC43127320AFEBB55812F13C5DF794D")
        @Override
        public void handleMessage(Message msg) {
            
            onPostConfigurationChanged();
            
            
            setVisible(false);
            
            
            {
                boolean var2D6B4C7133C3E09470E253CD882AC4AE_619523215 = (mOwnerView.getWindowToken() == null);
                {
                    setVisible(true);
                } 
            } 
            
            addTaint(msg.getTaint());
            
            
                
                    
                    
                
                    
                    
                
                    
                        
                                
                                
                    
                        
                    
                    
            
        }

        
};
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.361 -0400", hash_original_method = "380DC2A7E4A728E8B8A622AB5FAF03E2", hash_generated_method = "0A58F7464A42BDD3A103DF6B2DF3EF11")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.361 -0400", hash_original_method = "3742E544F3AFD5F94AD689FCD74B6DD5", hash_generated_method = "74919EB6329C560320100ABB815E0978")
    public void setZoomInEnabled(boolean enabled) {
        addTaint(enabled);
        mControls.setIsZoomInEnabled(enabled);
        // ---------- Original Method ----------
        //mControls.setIsZoomInEnabled(enabled);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.361 -0400", hash_original_method = "1CF0D208E223466BFE0254465182BFD8", hash_generated_method = "C8B6849187339F3B35B6D392F54382D4")
    public void setZoomOutEnabled(boolean enabled) {
        addTaint(enabled);
        mControls.setIsZoomOutEnabled(enabled);
        // ---------- Original Method ----------
        //mControls.setIsZoomOutEnabled(enabled);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.362 -0400", hash_original_method = "18B39697A9CAB4F925A2FDB6BE61BBD8", hash_generated_method = "B76C315664C8C28690A88C781AC41B91")
    public void setZoomSpeed(long speed) {
        addTaint(speed);
        mControls.setZoomSpeed(speed);
        // ---------- Original Method ----------
        //mControls.setZoomSpeed(speed);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.365 -0400", hash_original_method = "4896FBB838EA68425CC17AB554E92B7B", hash_generated_method = "FC9759EBA7AE84455E945621E605B511")
    private FrameLayout createContainer() {
        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
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
        FrameLayout container = new Container(mContext);
        container.setLayoutParams(lp);
        container.setMeasureAllChildren(true);
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(com.android.internal.R.layout.zoom_container, container);
        mControls = (ZoomControls) container.findViewById(com.android.internal.R.id.zoomControls);
        mControls.setOnZoomInClickListener(new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.365 -0400", hash_original_method = "C8D887B971B187EA9E40E1FCF6E6B11D", hash_generated_method = "03612EFCD0339ACAF16A43992BF4E37B")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
            dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
            if(mCallback != null)            
            mCallback.onZoom(true);
            // ---------- Original Method ----------
            //dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
            //if (mCallback != null) mCallback.onZoom(true);
        }
});
        mControls.setOnZoomOutClickListener(new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.365 -0400", hash_original_method = "CBCA91EA6C5A6BFF58378B31FA0529F1", hash_generated_method = "68BA6D6CFA3F46150FBF7899F2D04E9E")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
            dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
            if(mCallback != null)            
            mCallback.onZoom(false);
            // ---------- Original Method ----------
            //dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
            //if (mCallback != null) mCallback.onZoom(false);
        }
});
FrameLayout var9A7D772301F15796236447FE645B3608_1626315565 =         container;
        var9A7D772301F15796236447FE645B3608_1626315565.addTaint(taint);
        return var9A7D772301F15796236447FE645B3608_1626315565;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.366 -0400", hash_original_method = "B44D483F6F47563C2A0666A9C41723E6", hash_generated_method = "39466DB7BD80A5311AC75D7EF4F60C50")
    public void setOnZoomListener(OnZoomListener listener) {
        mCallback = listener;
        // ---------- Original Method ----------
        //mCallback = listener;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.367 -0400", hash_original_method = "E1DA778FA5C81D94D4F0CBAFCCB18381", hash_generated_method = "D81BF366B940EE33EF4DD576D4F8D2BA")
    public void setFocusable(boolean focusable) {
        addTaint(focusable);
        int oldFlags = mContainerLayoutParams.flags;
        if(focusable)        
        {
            mContainerLayoutParams.flags &= ~LayoutParams.FLAG_NOT_FOCUSABLE;
        } //End block
        else
        {
            mContainerLayoutParams.flags |= LayoutParams.FLAG_NOT_FOCUSABLE;
        } //End block
        if((mContainerLayoutParams.flags != oldFlags) && mIsVisible)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.367 -0400", hash_original_method = "CDC5AD23EC463D7BB2411752926A03FA", hash_generated_method = "8578F9F0E1F375A57F6A4D0C80FAC971")
    public boolean isAutoDismissed() {
        boolean var7AA27D9B0360FEC25432CC2F487F7B06_1346099124 = (mAutoDismissControls);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_747300879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_747300879;
        // ---------- Original Method ----------
        //return mAutoDismissControls;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.367 -0400", hash_original_method = "F5C09C601D97CCC2B78CB5FD3ABF9CB9", hash_generated_method = "380CC679FD665B3A9DE867E005BC6643")
    public void setAutoDismissed(boolean autoDismiss) {
        if(mAutoDismissControls == autoDismiss)        
        return;
        mAutoDismissControls = autoDismiss;
        // ---------- Original Method ----------
        //if (mAutoDismissControls == autoDismiss) return;
        //mAutoDismissControls = autoDismiss;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.368 -0400", hash_original_method = "74E1901CABAC1FE9F1005B36E67FD276", hash_generated_method = "7F43E92C869B8AA62C3A4084B923F611")
    public boolean isVisible() {
        boolean var3841FA617DC417560C9ACBBE88413EC6_2055145973 = (mIsVisible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_855617641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_855617641;
        // ---------- Original Method ----------
        //return mIsVisible;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.369 -0400", hash_original_method = "E965560D7B92B1F08EBD9F8DCDBB0D54", hash_generated_method = "ADD3C16788A4C72311EC09825F9CBC78")
    public void setVisible(boolean visible) {
        if(visible)        
        {
            if(mOwnerView.getWindowToken() == null)            
            {
                if(!mHandler.hasMessages(MSG_POST_SET_VISIBLE))                
                {
                    mHandler.sendEmptyMessage(MSG_POST_SET_VISIBLE);
                } //End block
                return;
            } //End block
            dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        } //End block
        if(mIsVisible == visible)        
        {
            return;
        } //End block
        mIsVisible = visible;
        if(visible)        
        {
            if(mContainerLayoutParams.token == null)            
            {
                mContainerLayoutParams.token = mOwnerView.getWindowToken();
            } //End block
            mWindowManager.addView(mContainer, mContainerLayoutParams);
            if(mPostedVisibleInitializer == null)            
            {
                mPostedVisibleInitializer = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.369 -0400", hash_original_method = "EAB472F3FC4942C1E0EBF0AC1701A96E", hash_generated_method = "98C9A5B475D0C09A3D408B5F89D4EF84")
        public void run() {
            refreshPositioningVariables();
            if(mCallback != null)            
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
        else
        {
            if(mTouchTargetView != null)            
            {
                mReleaseTouchListenerOnUp = true;
            } //End block
            else
            {
                mOwnerView.setOnTouchListener(null);
            } //End block
            mContext.unregisterReceiver(mConfigurationChangedReceiver);
            mWindowManager.removeView(mContainer);
            mHandler.removeCallbacks(mPostedVisibleInitializer);
            if(mCallback != null)            
            {
                mCallback.onVisibilityChanged(false);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.370 -0400", hash_original_method = "5F28A319C2D73660C6EEE12017C9EFC5", hash_generated_method = "545725D28FCB09DFCF9F8101240AE105")
    public ViewGroup getContainer() {
ViewGroup varCFF48C15085C1760829740A9CBEECBE6_716394285 =         mContainer;
        varCFF48C15085C1760829740A9CBEECBE6_716394285.addTaint(taint);
        return varCFF48C15085C1760829740A9CBEECBE6_716394285;
        // ---------- Original Method ----------
        //return mContainer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.370 -0400", hash_original_method = "7C1C4B956CF0AB08A097C4C4837C0B3D", hash_generated_method = "ACEB1F73B3599BB883F062434E2CB04D")
    public View getZoomControls() {
View var4BE15960FF1DC136D3D870EA1777142D_1350050369 =         mControls;
        var4BE15960FF1DC136D3D870EA1777142D_1350050369.addTaint(taint);
        return var4BE15960FF1DC136D3D870EA1777142D_1350050369;
        // ---------- Original Method ----------
        //return mControls;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.371 -0400", hash_original_method = "9FC1F818AD77D871CBB70B150EF10183", hash_generated_method = "1EB452CE8F6E70923C38710D44317FE5")
    private void dismissControlsDelayed(int delay) {
        addTaint(delay);
        if(mAutoDismissControls)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.372 -0400", hash_original_method = "AC8EA5B19015CD5AEB4699B6A0E359A3", hash_generated_method = "99E365AE14BAFFFC3D4A9101BCBBD718")
    private void refreshPositioningVariables() {
        if(mOwnerView.getWindowToken() == null)        
        return;
        int ownerHeight = mOwnerView.getHeight();
        int ownerWidth = mOwnerView.getWidth();
        int containerOwnerYOffset = ownerHeight - mContainer.getHeight();
        mOwnerView.getLocationOnScreen(mOwnerViewRawLocation);
        mContainerRawLocation[0] = mOwnerViewRawLocation[0];
        mContainerRawLocation[1] = mOwnerViewRawLocation[1] + containerOwnerYOffset;
        int[] ownerViewWindowLoc = mTempIntArray;
        mOwnerView.getLocationInWindow(ownerViewWindowLoc);
        mContainerLayoutParams.x = ownerViewWindowLoc[0];
        mContainerLayoutParams.width = ownerWidth;
        mContainerLayoutParams.y = ownerViewWindowLoc[1] + containerOwnerYOffset;
        if(mIsVisible)        
        {
            mWindowManager.updateViewLayout(mContainer, mContainerLayoutParams);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.374 -0400", hash_original_method = "378B3DC7088565C3BEBCF57941C87615", hash_generated_method = "A84F42EEBFEE352B07DD189994E7C2CE")
    private boolean onContainerKey(KeyEvent event) {
        addTaint(event.getTaint());
        int keyCode = event.getKeyCode();
        if(isInterestingKey(keyCode))        
        {
            if(keyCode == KeyEvent.KEYCODE_BACK)            
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0)                
                {
                    if(mOwnerView != null)                    
                    {
                        KeyEvent.DispatcherState ds = mOwnerView.getKeyDispatcherState();
                        if(ds != null)                        
                        {
                            ds.startTracking(event, this);
                        } //End block
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_1215097260 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_604044599 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_604044599;
                } //End block
                else
                if(event.getAction() == KeyEvent.ACTION_UP
                        && event.isTracking() && !event.isCanceled())                
                {
                    setVisible(false);
                    boolean varB326B5062B2F0E69046810717534CB09_788651430 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1965316746 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1965316746;
                } //End block
            } //End block
            else
            {
                dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1359520826 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711169142 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711169142;
        } //End block
        else
        {
            ViewRootImpl viewRoot = getOwnerViewRootImpl();
            if(viewRoot != null)            
            {
                viewRoot.dispatchKey(event);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1264934995 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024170142 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024170142;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.375 -0400", hash_original_method = "1F6E6E50114A7831DEC27688067C55C8", hash_generated_method = "3967CFE7D0CD3B16E637785F405768CB")
    private boolean isInterestingKey(int keyCode) {
        addTaint(keyCode);
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_DPAD_UP:
        case KeyEvent.KEYCODE_DPAD_DOWN:
        case KeyEvent.KEYCODE_DPAD_LEFT:
        case KeyEvent.KEYCODE_DPAD_RIGHT:
        case KeyEvent.KEYCODE_ENTER:
        case KeyEvent.KEYCODE_BACK:
        boolean varB326B5062B2F0E69046810717534CB09_1086073343 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485026333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_485026333;
        default:
        boolean var68934A3E9455FA72420237EB05902327_574425406 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_506278476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_506278476;
}
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.375 -0400", hash_original_method = "682CD28D25D57C221683C84B731CBBF0", hash_generated_method = "CCB7C6D806260ACDC95DC918CFAA754F")
    private ViewRootImpl getOwnerViewRootImpl() {
        View rootViewOfOwner = mOwnerView.getRootView();
        if(rootViewOfOwner == null)        
        {
ViewRootImpl var540C13E9E156B687226421B24F2DF178_1105378961 =             null;
            var540C13E9E156B687226421B24F2DF178_1105378961.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1105378961;
        } //End block
        ViewParent parentOfRootView = rootViewOfOwner.getParent();
        if(parentOfRootView instanceof ViewRootImpl)        
        {
ViewRootImpl var5CEE5ADC2DE246F02A5203E98C4E81BF_184536007 =             (ViewRootImpl) parentOfRootView;
            var5CEE5ADC2DE246F02A5203E98C4E81BF_184536007.addTaint(taint);
            return var5CEE5ADC2DE246F02A5203E98C4E81BF_184536007;
        } //End block
        else
        {
ViewRootImpl var540C13E9E156B687226421B24F2DF178_238603472 =             null;
            var540C13E9E156B687226421B24F2DF178_238603472.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_238603472;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.376 -0400", hash_original_method = "AC268A3687D4D0CE3C71C1BC69224E9B", hash_generated_method = "00DE6735F470255517FC43C7D3F8314C")
    public boolean onTouch(View v, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(v.getTaint());
        int action = event.getAction();
        if(event.getPointerCount() > 1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_726366540 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104654 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_104654;
        } //End block
        if(mReleaseTouchListenerOnUp)        
        {
            if(action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL)            
            {
                mOwnerView.setOnTouchListener(null);
                setTouchTargetView(null);
                mReleaseTouchListenerOnUp = false;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_2050310163 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_952475521 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_952475521;
        } //End block
        dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        View targetView = mTouchTargetView;
switch(action){
        case MotionEvent.ACTION_DOWN:
        targetView = findViewForTouch((int) event.getRawX(), (int) event.getRawY());
        setTouchTargetView(targetView);
        break;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
        setTouchTargetView(null);
        break;
}        if(targetView != null)        
        {
            int targetViewRawX = mContainerRawLocation[0] + mTouchTargetWindowLocation[0];
            int targetViewRawY = mContainerRawLocation[1] + mTouchTargetWindowLocation[1];
            MotionEvent containerEvent = MotionEvent.obtain(event);
            containerEvent.offsetLocation(mOwnerViewRawLocation[0] - targetViewRawX,
                    mOwnerViewRawLocation[1] - targetViewRawY);
            float containerX = containerEvent.getX();
            float containerY = containerEvent.getY();
            if(containerX < 0 && containerX > -ZOOM_CONTROLS_TOUCH_PADDING)            
            {
                containerEvent.offsetLocation(-containerX, 0);
            } //End block
            if(containerY < 0 && containerY > -ZOOM_CONTROLS_TOUCH_PADDING)            
            {
                containerEvent.offsetLocation(0, -containerY);
            } //End block
            boolean retValue = targetView.dispatchTouchEvent(containerEvent);
            containerEvent.recycle();
            boolean var9C7BD17E8EB1C3D0F843684A79A18570_752899178 = (retValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_632729465 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_632729465;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1098077967 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1280824446 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1280824446;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.377 -0400", hash_original_method = "5B47D11F01081A67B0DC801C22F3388C", hash_generated_method = "D28FE4B3DFC9DF5E6FF03450E82BB6BB")
    private void setTouchTargetView(View view) {
        mTouchTargetView = view;
        if(view != null)        
        {
            view.getLocationInWindow(mTouchTargetWindowLocation);
        } //End block
        // ---------- Original Method ----------
        //mTouchTargetView = view;
        //if (view != null) {
            //view.getLocationInWindow(mTouchTargetWindowLocation);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.377 -0400", hash_original_method = "87725495631184F2D9436EB1CA8B8776", hash_generated_method = "CB72F86652CB2241059E4806F16F3541")
    private View findViewForTouch(int rawX, int rawY) {
        addTaint(rawY);
        addTaint(rawX);
        int containerCoordsX = rawX - mContainerRawLocation[0];
        int containerCoordsY = rawY - mContainerRawLocation[1];
        Rect frame = mTempRect;
        View closestChild = null;
        int closestChildDistanceSq = Integer.MAX_VALUE;
for(int i = mContainer.getChildCount() - 1;i >= 0;i--)
        {
            View child = mContainer.getChildAt(i);
            if(child.getVisibility() != View.VISIBLE)            
            {
                continue;
            } //End block
            child.getHitRect(frame);
            if(frame.contains(containerCoordsX, containerCoordsY))            
            {
View var73902FD3E151130B4329B76EF04D2A54_1391096711 =                 child;
                var73902FD3E151130B4329B76EF04D2A54_1391096711.addTaint(taint);
                return var73902FD3E151130B4329B76EF04D2A54_1391096711;
            } //End block
            int distanceX;
            if(containerCoordsX >= frame.left && containerCoordsX <= frame.right)            
            {
                distanceX = 0;
            } //End block
            else
            {
                distanceX = Math.min(Math.abs(frame.left - containerCoordsX),
                    Math.abs(containerCoordsX - frame.right));
            } //End block
            int distanceY;
            if(containerCoordsY >= frame.top && containerCoordsY <= frame.bottom)            
            {
                distanceY = 0;
            } //End block
            else
            {
                distanceY = Math.min(Math.abs(frame.top - containerCoordsY),
                        Math.abs(containerCoordsY - frame.bottom));
            } //End block
            int distanceSq = distanceX * distanceX + distanceY * distanceY;
            if((distanceSq < mTouchPaddingScaledSq) &&
                    (distanceSq < closestChildDistanceSq))            
            {
                closestChild = child;
                closestChildDistanceSq = distanceSq;
            } //End block
        } //End block
View varC364E3ABF5AB6B23AB1C8ACB044B06D1_1307350065 =         closestChild;
        varC364E3ABF5AB6B23AB1C8ACB044B06D1_1307350065.addTaint(taint);
        return varC364E3ABF5AB6B23AB1C8ACB044B06D1_1307350065;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.378 -0400", hash_original_method = "17B14786F835EF976BE6949F1B3BDF94", hash_generated_method = "F20F1B1E54FFC0101AD0D428F6B397DF")
    private void onPostConfigurationChanged() {
        dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        refreshPositioningVariables();
        // ---------- Original Method ----------
        //dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        //refreshPositioningVariables();
    }

    
    private class Container extends FrameLayout {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.378 -0400", hash_original_method = "F501EF92597324297985E451C1487263", hash_generated_method = "6C7FE0A8EC88EB82037FA3CBCBCDAEFE")
        public  Container(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.378 -0400", hash_original_method = "9ADB1F3C4E22FAC9B13C38DB47141BED", hash_generated_method = "03F590273E61AAEDE7D0184035C6A8C4")
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            addTaint(event.getTaint());
            boolean varA0B7F40777AAA5774BA39FF5D2D02708_984411548 = (onContainerKey(event) ? true : super.dispatchKeyEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_627767471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_627767471;
            // ---------- Original Method ----------
            //return onContainerKey(event) ? true : super.dispatchKeyEvent(event);
        }

        
    }


    
    public interface OnZoomListener {

        
        void onVisibilityChanged(boolean visible);

        
        void onZoom(boolean zoomIn);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.378 -0400", hash_original_field = "788A21D54466EA345DF78A210F61BFDB", hash_generated_field = "87F8ED6A4B66277018F995319915D6F8")

    private static final String TAG = "ZoomButtonsController";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.378 -0400", hash_original_field = "5D6E37BCE72DAC569EA42869CC543F50", hash_generated_field = "19FF76A0C8B907CD835165D9C0A3D60D")

    private static final int ZOOM_CONTROLS_TIMEOUT = (int) ViewConfiguration.getZoomControlsTimeout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.378 -0400", hash_original_field = "28FE46A9CB38173700937CBF032F0465", hash_generated_field = "EB3746A9386522BF21631ADC5B5B668F")

    private static final int ZOOM_CONTROLS_TOUCH_PADDING = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.379 -0400", hash_original_field = "DF4E4863EC3A9B2BAA55B086A497D764", hash_generated_field = "29D97A85E5F3DFC1C5D054BECA9FCF49")

    private static final int MSG_POST_CONFIGURATION_CHANGED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.379 -0400", hash_original_field = "9FD71970941437D96FFAD21A41D4DDF8", hash_generated_field = "D23053980B5F5589F5746F54AA99A519")

    private static final int MSG_DISMISS_ZOOM_CONTROLS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.379 -0400", hash_original_field = "B1D6E8B124954621CBC6331033C52C66", hash_generated_field = "9FE51466CFB2AFD8319C533EAB3AA236")

    private static final int MSG_POST_SET_VISIBLE = 4;
}

