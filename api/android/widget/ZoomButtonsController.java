package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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

public class ZoomButtonsController implements View.OnTouchListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.753 -0500", hash_original_field = "088CEC03F96A186C9069CEBD593BFDAE", hash_generated_field = "87F8ED6A4B66277018F995319915D6F8")

    private static final String TAG = "ZoomButtonsController";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.755 -0500", hash_original_field = "FF3835BE3D163537015161673097AB27", hash_generated_field = "19FF76A0C8B907CD835165D9C0A3D60D")

    private static final int ZOOM_CONTROLS_TIMEOUT =
            (int) ViewConfiguration.getZoomControlsTimeout();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.757 -0500", hash_original_field = "246A69F95DD6398F549FCFA1CC6E0D81", hash_generated_field = "EB3746A9386522BF21631ADC5B5B668F")

    private static final int ZOOM_CONTROLS_TOUCH_PADDING = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.807 -0500", hash_original_field = "2C52CA783EAD9EC1EA9D3D67B3B8575E", hash_generated_field = "29D97A85E5F3DFC1C5D054BECA9FCF49")

    private static final int MSG_POST_CONFIGURATION_CHANGED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.809 -0500", hash_original_field = "900F7D6A1089B5F7C947CDB94905213E", hash_generated_field = "D23053980B5F5589F5746F54AA99A519")

    private static final int MSG_DISMISS_ZOOM_CONTROLS = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.812 -0500", hash_original_field = "03CB8B97871EF4C81136F4EA55A692E3", hash_generated_field = "9FE51466CFB2AFD8319C533EAB3AA236")

    private static final int MSG_POST_SET_VISIBLE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.759 -0500", hash_original_field = "B4F7302099756A6A1AFD3409895773CC", hash_generated_field = "31366FBB195E6D4943166A1CF4E59210")

    private int mTouchPaddingScaledSq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.761 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.763 -0500", hash_original_field = "83A062836C11DD52DC32F4325712F233", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private  WindowManager mWindowManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.766 -0500", hash_original_field = "3A0EA3F5AD16E555168A8413E5E3505F", hash_generated_field = "E32C26221A599AF38CE047CEA9708612")

    private boolean mAutoDismissControls = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.768 -0500", hash_original_field = "9C695DC1D40D6D46AAF401A08122ADF6", hash_generated_field = "E5DC02A18C4817B413C22883E087C5E5")

    private  View mOwnerView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.771 -0500", hash_original_field = "1F0822204C747011406E10E882701006", hash_generated_field = "778B5A3646480827509FB2BFB25E57EC")

    private final int[] mOwnerViewRawLocation = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.773 -0500", hash_original_field = "6FD3497BA63774639788CAEEBDBF3ED0", hash_generated_field = "DE7D4566565DA445D3E9FC64F9F679E7")

    private  FrameLayout mContainer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.775 -0500", hash_original_field = "BD1CB594592ACB115EF577A6CE19172E", hash_generated_field = "3C55C1D38F1D3A12D40650C5BEE8D028")

    private LayoutParams mContainerLayoutParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.777 -0500", hash_original_field = "AE4BE88CF7BD84D9A897153425DE51B8", hash_generated_field = "E3C0FB2A785E1B8D5D1C914264C73BEA")

    private final int[] mContainerRawLocation = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.779 -0500", hash_original_field = "BD6422D8D3D68472890BF6BE2F946030", hash_generated_field = "EA1868BE7D996683F2989202D2AC4DDD")

    private ZoomControls mControls;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.781 -0500", hash_original_field = "892FB1636B3A1011EB3003C5C76B1100", hash_generated_field = "4214AAFC096B21883792ABCE78232C36")

    private View mTouchTargetView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.784 -0500", hash_original_field = "8A8B0194765CFE82E38BC72BDCC5667F", hash_generated_field = "0F94F89170BE0719490D13F384546F40")

    private final int[] mTouchTargetWindowLocation = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.786 -0500", hash_original_field = "0522047260F9D4639CFCDA8872844FFE", hash_generated_field = "B050564438297A698F60861F546D1BDC")

    private boolean mReleaseTouchListenerOnUp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.788 -0500", hash_original_field = "CF26E637FBA1A523DAD075F56D355E3F", hash_generated_field = "16B558D924DF2404F3A2E9E477E1C239")

    private boolean mIsVisible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.790 -0500", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.792 -0500", hash_original_field = "EC57765186F8CE1B0FE7E00067E34101", hash_generated_field = "37699E1557DE199CB1E3D694670D31BB")

    private final int[] mTempIntArray = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.795 -0500", hash_original_field = "A4F4373AE8BF6262F07EAE3E5C5E7C9F", hash_generated_field = "69BC292DD0AFDA8A4F57DC4BCBE69348")

    private OnZoomListener mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.797 -0500", hash_original_field = "532B9FB72EF88B924FD76ACB5F32FB89", hash_generated_field = "1ED441E7D4D48C31070345ADC5874E3A")

    private Runnable mPostedVisibleInitializer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.799 -0500", hash_original_field = "77631D28C931EDEC89D2F849FC747650", hash_generated_field = "314D614F45BCFBC7FD4D2764A847AE51")

    private final IntentFilter mConfigurationChangedFilter =
            new IntentFilter(Intent.ACTION_CONFIGURATION_CHANGED);
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

    /**
     * Constructor for the {@link ZoomButtonsController}.
     *
     * @param ownerView The view that is being zoomed by the zoom controls. The
     *            zoom controls will be displayed aligned with this view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.821 -0500", hash_original_method = "380DC2A7E4A728E8B8A622AB5FAF03E2", hash_generated_method = "B6D4B1FBE089D868F01FDD5F1E2C9F91")
    
public ZoomButtonsController(View ownerView) {
        mContext = ownerView.getContext();
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        mOwnerView = ownerView;

        mTouchPaddingScaledSq = (int)
                (ZOOM_CONTROLS_TOUCH_PADDING * mContext.getResources().getDisplayMetrics().density);
        mTouchPaddingScaledSq *= mTouchPaddingScaledSq;

        mContainer = createContainer();
    }

    /**
     * Whether to enable the zoom in control.
     *
     * @param enabled Whether to enable the zoom in control.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.823 -0500", hash_original_method = "3742E544F3AFD5F94AD689FCD74B6DD5", hash_generated_method = "C310AF3AC3298A18E1908AF4FE069C24")
    
public void setZoomInEnabled(boolean enabled) {
        mControls.setIsZoomInEnabled(enabled);
    }

    /**
     * Whether to enable the zoom out control.
     *
     * @param enabled Whether to enable the zoom out control.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.825 -0500", hash_original_method = "1CF0D208E223466BFE0254465182BFD8", hash_generated_method = "8C424E3E9379072103AC380843E123F5")
    
public void setZoomOutEnabled(boolean enabled) {
        mControls.setIsZoomOutEnabled(enabled);
    }

    /**
     * Sets the delay between zoom callbacks as the user holds a zoom button.
     *
     * @param speed The delay in milliseconds between zoom callbacks.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.828 -0500", hash_original_method = "18B39697A9CAB4F925A2FDB6BE61BBD8", hash_generated_method = "49BD1E930E9E075A4870520DC620F185")
    
public void setZoomSpeed(long speed) {
        mControls.setZoomSpeed(speed);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.836 -0500", hash_original_method = "4896FBB838EA68425CC17AB554E92B7B", hash_generated_method = "CEC5A4FE8590A0164FA34999C2EA3878")
    
private FrameLayout createContainer() {
        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        // Controls are positioned BOTTOM | CENTER with respect to the owner view.
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
            public void onClick(View v) {
                dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
                if (mCallback != null) mCallback.onZoom(true);
            }
        });
        mControls.setOnZoomOutClickListener(new OnClickListener() {
            public void onClick(View v) {
                dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
                if (mCallback != null) mCallback.onZoom(false);
            }
        });

        return container;
    }

    /**
     * Sets the {@link OnZoomListener} listener that receives callbacks to zoom.
     *
     * @param listener The listener that will be told to zoom.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.838 -0500", hash_original_method = "B44D483F6F47563C2A0666A9C41723E6", hash_generated_method = "4A7C2A82299214746000C268A032BAD4")
    
public void setOnZoomListener(OnZoomListener listener) {
        mCallback = listener;
    }

    /**
     * Sets whether the zoom controls should be focusable. If the controls are
     * focusable, then trackball and arrow key interactions are possible.
     * Otherwise, only touch interactions are possible.
     *
     * @param focusable Whether the zoom controls should be focusable.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.841 -0500", hash_original_method = "E1DA778FA5C81D94D4F0CBAFCCB18381", hash_generated_method = "61EB6D295900F029494C28C2B03A3CF0")
    
public void setFocusable(boolean focusable) {
        int oldFlags = mContainerLayoutParams.flags;
        if (focusable) {
            mContainerLayoutParams.flags &= ~LayoutParams.FLAG_NOT_FOCUSABLE;
        } else {
            mContainerLayoutParams.flags |= LayoutParams.FLAG_NOT_FOCUSABLE;
        }

        if ((mContainerLayoutParams.flags != oldFlags) && mIsVisible) {
            mWindowManager.updateViewLayout(mContainer, mContainerLayoutParams);
        }
    }

    /**
     * Whether the zoom controls will be automatically dismissed after showing.
     *
     * @return Whether the zoom controls will be auto dismissed after showing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.843 -0500", hash_original_method = "CDC5AD23EC463D7BB2411752926A03FA", hash_generated_method = "0210DC58C33E70C39885F8DC6CD5B70B")
    
public boolean isAutoDismissed() {
        return mAutoDismissControls;
    }

    /**
     * Sets whether the zoom controls will be automatically dismissed after
     * showing.
     */
    @DSComment("ZoomButtonController")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.845 -0500", hash_original_method = "F5C09C601D97CCC2B78CB5FD3ABF9CB9", hash_generated_method = "8E88D1617A868301FE9A0E781BF2BF81")
    
public void setAutoDismissed(boolean autoDismiss) {
        if (mAutoDismissControls == autoDismiss) return;
        mAutoDismissControls = autoDismiss;
    }

    /**
     * Whether the zoom controls are visible to the user.
     *
     * @return Whether the zoom controls are visible to the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.847 -0500", hash_original_method = "74E1901CABAC1FE9F1005B36E67FD276", hash_generated_method = "1697AECC8916166453022FDC56BF0C19")
    
public boolean isVisible() {
        return mIsVisible;
    }

    /**
     * Sets whether the zoom controls should be visible to the user.
     *
     * @param visible Whether the zoom controls should be visible to the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.853 -0500", hash_original_method = "E965560D7B92B1F08EBD9F8DCDBB0D54", hash_generated_method = "802AD5B01F3A0D49D3E1567DFFBCD182")
    
public void setVisible(boolean visible) {

        if (visible) {
            if (mOwnerView.getWindowToken() == null) {
                /*
                 * We need a window token to show ourselves, maybe the owner's
                 * window hasn't been created yet but it will have been by the
                 * time the looper is idle, so post the setVisible(true) call.
                 */
                if (!mHandler.hasMessages(MSG_POST_SET_VISIBLE)) {
                    mHandler.sendEmptyMessage(MSG_POST_SET_VISIBLE);
                }
                return;
            }

            dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        }

        if (mIsVisible == visible) {
            return;
        }
        mIsVisible = visible;

        if (visible) {
            if (mContainerLayoutParams.token == null) {
                mContainerLayoutParams.token = mOwnerView.getWindowToken();
            }

            mWindowManager.addView(mContainer, mContainerLayoutParams);

            if (mPostedVisibleInitializer == null) {
                mPostedVisibleInitializer = new Runnable() {
                    public void run() {
                        refreshPositioningVariables();

                        if (mCallback != null) {
                            mCallback.onVisibilityChanged(true);
                        }
                    }
                };
            }

            mHandler.post(mPostedVisibleInitializer);

            // Handle configuration changes when visible
            mContext.registerReceiver(mConfigurationChangedReceiver, mConfigurationChangedFilter);

            // Steal touches events from the owner
            mOwnerView.setOnTouchListener(this);
            mReleaseTouchListenerOnUp = false;

        } else {
            // Don't want to steal any more touches
            if (mTouchTargetView != null) {
                // We are still stealing the touch events for this touch
                // sequence, so release the touch listener later
                mReleaseTouchListenerOnUp = true;
            } else {
                mOwnerView.setOnTouchListener(null);
            }

            // No longer care about configuration changes
            mContext.unregisterReceiver(mConfigurationChangedReceiver);

            mWindowManager.removeView(mContainer);
            mHandler.removeCallbacks(mPostedVisibleInitializer);

            if (mCallback != null) {
                mCallback.onVisibilityChanged(false);
            }
        }

    }

    /**
     * Gets the container that is the parent of the zoom controls.
     * <p>
     * The client can add other views to this container to link them with the
     * zoom controls.
     *
     * @return The container of the zoom controls. It will be a layout that
     *         respects the gravity of a child's layout parameters.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.855 -0500", hash_original_method = "5F28A319C2D73660C6EEE12017C9EFC5", hash_generated_method = "FD6439A5E132E5A8EF11E18C5B1D675F")
    
public ViewGroup getContainer() {
        return mContainer;
    }

    /**
     * Gets the view for the zoom controls.
     *
     * @return The zoom controls view.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.857 -0500", hash_original_method = "7C1C4B956CF0AB08A097C4C4837C0B3D", hash_generated_method = "A076B1E7AAD5DD479A122098DC2C9293")
    
public View getZoomControls() {
        return mControls;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.860 -0500", hash_original_method = "9FC1F818AD77D871CBB70B150EF10183", hash_generated_method = "41A1B932AC959AF41D283AE9164621E0")
    
private void dismissControlsDelayed(int delay) {
        if (mAutoDismissControls) {
            mHandler.removeMessages(MSG_DISMISS_ZOOM_CONTROLS);
            mHandler.sendEmptyMessageDelayed(MSG_DISMISS_ZOOM_CONTROLS, delay);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.863 -0500", hash_original_method = "AC8EA5B19015CD5AEB4699B6A0E359A3", hash_generated_method = "86259CDB13C61790476C282DBB86B2A4")
    
private void refreshPositioningVariables() {
        // if the mOwnerView is detached from window then skip.
        if (mOwnerView.getWindowToken() == null) return;

        // Position the zoom controls on the bottom of the owner view.
        int ownerHeight = mOwnerView.getHeight();
        int ownerWidth = mOwnerView.getWidth();
        // The gap between the top of the owner and the top of the container
        int containerOwnerYOffset = ownerHeight - mContainer.getHeight();

        // Calculate the owner view's bounds
        mOwnerView.getLocationOnScreen(mOwnerViewRawLocation);
        mContainerRawLocation[0] = mOwnerViewRawLocation[0];
        mContainerRawLocation[1] = mOwnerViewRawLocation[1] + containerOwnerYOffset;

        int[] ownerViewWindowLoc = mTempIntArray;
        mOwnerView.getLocationInWindow(ownerViewWindowLoc);

        // lp.x and lp.y should be relative to the owner's window top-left
        mContainerLayoutParams.x = ownerViewWindowLoc[0];
        mContainerLayoutParams.width = ownerWidth;
        mContainerLayoutParams.y = ownerViewWindowLoc[1] + containerOwnerYOffset;
        if (mIsVisible) {
            mWindowManager.updateViewLayout(mContainer, mContainerLayoutParams);
        }

    }

    /* This will only be called when the container has focus. */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.866 -0500", hash_original_method = "378B3DC7088565C3BEBCF57941C87615", hash_generated_method = "7F41C5970058127C5472ADF68525807C")
    
private boolean onContainerKey(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (isInterestingKey(keyCode)) {

            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getRepeatCount() == 0) {
                    if (mOwnerView != null) {
                        KeyEvent.DispatcherState ds = mOwnerView.getKeyDispatcherState();
                        if (ds != null) {
                            ds.startTracking(event, this);
                        }
                    }
                    return true;
                } else if (event.getAction() == KeyEvent.ACTION_UP
                        && event.isTracking() && !event.isCanceled()) {
                    setVisible(false);
                    return true;
                }
                
            } else {
                dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
            }

            // Let the container handle the key
            return false;

        } else {

            ViewRootImpl viewRoot = getOwnerViewRootImpl();
            if (viewRoot != null) {
                viewRoot.dispatchKey(event);
            }

            // We gave the key to the owner, don't let the container handle this key
            return true;
        }
    }
    
    private class Container extends FrameLayout {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.886 -0500", hash_original_method = "F501EF92597324297985E451C1487263", hash_generated_method = "3320562F774FDE06D2AD489A63E04674")
        
public Container(Context context) {
            super(context);
        }

        /*
         * Need to override this to intercept the key events. Otherwise, we
         * would attach a key listener to the container but its superclass
         * ViewGroup gives it to the focused View instead of calling the key
         * listener, and so we wouldn't get the events.
         */
        @DSSpec(DSCat.TO_MODEL)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.889 -0500", hash_original_method = "9ADB1F3C4E22FAC9B13C38DB47141BED", hash_generated_method = "3BD78329324C2B0558959EB39476D20D")
        
@Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            return onContainerKey(event) ? true : super.dispatchKeyEvent(event);
        }
        
    }
    
    public interface OnZoomListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onVisibilityChanged(boolean visible);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onZoom(boolean zoomIn);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.868 -0500", hash_original_method = "1F6E6E50114A7831DEC27688067C55C8", hash_generated_method = "B03AAA01D2E9486C1C702AE99636C247")
    
private boolean isInterestingKey(int keyCode) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_DPAD_DOWN:
            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_BACK:
                return true;
            default:
                return false;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.870 -0500", hash_original_method = "682CD28D25D57C221683C84B731CBBF0", hash_generated_method = "0BB71EE9B4987F8C135E89AA3B466756")
    
private ViewRootImpl getOwnerViewRootImpl() {
        View rootViewOfOwner = mOwnerView.getRootView();
        if (rootViewOfOwner == null) {
            return null;
        }

        ViewParent parentOfRootView = rootViewOfOwner.getParent();
        if (parentOfRootView instanceof ViewRootImpl) {
            return (ViewRootImpl) parentOfRootView;
        } else {
            return null;
        }
    }

    /**
     * @hide The ZoomButtonsController implements the OnTouchListener, but this
     *       does not need to be shown in its public API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.873 -0500", hash_original_method = "AC268A3687D4D0CE3C71C1BC69224E9B", hash_generated_method = "5D20DD5DCC986CDDF57CB3E65D694CE3")
    
public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();

        if (event.getPointerCount() > 1) {
            // ZoomButtonsController doesn't handle mutitouch. Give up control.
            return false;
        }

        if (mReleaseTouchListenerOnUp) {
            // The controls were dismissed but we need to throw away all events until the up
            if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                mOwnerView.setOnTouchListener(null);
                setTouchTargetView(null);
                mReleaseTouchListenerOnUp = false;
            }

            // Eat this event
            return true;
        }

        dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);

        View targetView = mTouchTargetView;

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                targetView = findViewForTouch((int) event.getRawX(), (int) event.getRawY());
                setTouchTargetView(targetView);
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                setTouchTargetView(null);
                break;
        }

        if (targetView != null) {
            // The upperleft corner of the target view in raw coordinates
            int targetViewRawX = mContainerRawLocation[0] + mTouchTargetWindowLocation[0];
            int targetViewRawY = mContainerRawLocation[1] + mTouchTargetWindowLocation[1];

            MotionEvent containerEvent = MotionEvent.obtain(event);
            // Convert the motion event into the target view's coordinates (from
            // owner view's coordinates)
            containerEvent.offsetLocation(mOwnerViewRawLocation[0] - targetViewRawX,
                    mOwnerViewRawLocation[1] - targetViewRawY);
            /* Disallow negative coordinates (which can occur due to
             * ZOOM_CONTROLS_TOUCH_PADDING) */
            // These are floats because we need to potentially offset away this exact amount
            float containerX = containerEvent.getX();
            float containerY = containerEvent.getY();
            if (containerX < 0 && containerX > -ZOOM_CONTROLS_TOUCH_PADDING) {
                containerEvent.offsetLocation(-containerX, 0);
            }
            if (containerY < 0 && containerY > -ZOOM_CONTROLS_TOUCH_PADDING) {
                containerEvent.offsetLocation(0, -containerY);
            }
            boolean retValue = targetView.dispatchTouchEvent(containerEvent);
            containerEvent.recycle();
            return retValue;

        } else {
            return false;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.876 -0500", hash_original_method = "5B47D11F01081A67B0DC801C22F3388C", hash_generated_method = "F8728FD1EC127FFB3A84F98BFFE3CCF7")
    
private void setTouchTargetView(View view) {
        mTouchTargetView = view;
        if (view != null) {
            view.getLocationInWindow(mTouchTargetWindowLocation);
        }
    }

    /**
     * Returns the View that should receive a touch at the given coordinates.
     *
     * @param rawX The raw X.
     * @param rawY The raw Y.
     * @return The view that should receive the touches, or null if there is not one.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.879 -0500", hash_original_method = "87725495631184F2D9436EB1CA8B8776", hash_generated_method = "F430E449E9BF40F720FCAA90C74B2995")
    
private View findViewForTouch(int rawX, int rawY) {
        // Reverse order so the child drawn on top gets first dibs.
        int containerCoordsX = rawX - mContainerRawLocation[0];
        int containerCoordsY = rawY - mContainerRawLocation[1];
        Rect frame = mTempRect;

        View closestChild = null;
        int closestChildDistanceSq = Integer.MAX_VALUE;

        for (int i = mContainer.getChildCount() - 1; i >= 0; i--) {
            View child = mContainer.getChildAt(i);
            if (child.getVisibility() != View.VISIBLE) {
                continue;
            }

            child.getHitRect(frame);
            if (frame.contains(containerCoordsX, containerCoordsY)) {
                return child;
            }

            int distanceX;
            if (containerCoordsX >= frame.left && containerCoordsX <= frame.right) {
                distanceX = 0;
            } else {
                distanceX = Math.min(Math.abs(frame.left - containerCoordsX),
                    Math.abs(containerCoordsX - frame.right));
            }
            int distanceY;
            if (containerCoordsY >= frame.top && containerCoordsY <= frame.bottom) {
                distanceY = 0;
            } else {
                distanceY = Math.min(Math.abs(frame.top - containerCoordsY),
                        Math.abs(containerCoordsY - frame.bottom));
            }
            int distanceSq = distanceX * distanceX + distanceY * distanceY;

            if ((distanceSq < mTouchPaddingScaledSq) &&
                    (distanceSq < closestChildDistanceSq)) {
                closestChild = child;
                closestChildDistanceSq = distanceSq;
            }
        }

        return closestChild;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:26.881 -0500", hash_original_method = "17B14786F835EF976BE6949F1B3BDF94", hash_generated_method = "8DBF1BF3BF51BDDB4CD4145724804379")
    
private void onPostConfigurationChanged() {
        dismissControlsDelayed(ZOOM_CONTROLS_TIMEOUT);
        refreshPositioningVariables();
    }
}

