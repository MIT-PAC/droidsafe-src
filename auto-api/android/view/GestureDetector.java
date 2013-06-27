package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

public class GestureDetector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.989 -0400", hash_original_field = "63791A3FD882CB7E1632DF20805E6846", hash_generated_field = "12BE8B5CD241157C9F0107D5273E27D1")

    private int mBiggerTouchSlopSquare = 20 * 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "46ABC6D9AB45AE8835C53F4C51724A79", hash_generated_field = "5E5708EA89972028E86242DA050969CA")

    private int mTouchSlopSquare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "2C56C8DD2FA1BBC384FAD39727EC1B9F", hash_generated_field = "6A78E5989D06DA4C68BA85646B379C51")

    private int mDoubleTapSlopSquare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "950A8222B535BF5159B013E5329A56C7", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

    private int mMinimumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "8ED13B950D5803064219CE68BB8F2695", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

    private int mMaximumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "0F48D0A94630E1FBE9C08A845F9730F2")

    private OnGestureListener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "87FD92A1DBA4F7CE0B58869B5E226B45", hash_generated_field = "6BFE5EA6164149F540DE4277F8AF3864")

    private OnDoubleTapListener mDoubleTapListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "2257E716ABB69174128002B6500326E5", hash_generated_field = "09EA51D062ED44D2275BC8E7A65061C0")

    private boolean mStillDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "6B06472FC4D3499D4338C0A5A44E3AE4", hash_generated_field = "8FA7640B36D34A443E3A43478682F7F9")

    private boolean mInLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "3685FD4DDDDB8177ACFC47DF2506B51F", hash_generated_field = "54A847320ACF73ACDAB1D622D38FE146")

    private boolean mAlwaysInTapRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "32C87B3E60E7CC081197EE23FE48470B", hash_generated_field = "05F405D52B0F8BE7180D2A6B8335B30C")

    private boolean mAlwaysInBiggerTapRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "2B841E5864AD9D17F0AEB812951699B4", hash_generated_field = "CAFEE339D8B144D23812ECC71639FEB7")

    private MotionEvent mCurrentDownEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "FE83D903AD347CA461A9D70C5013239C", hash_generated_field = "2C9915BC9FEEE919EC1B54BA44C7E08E")

    private MotionEvent mPreviousUpEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "D9B3FFE15EA3AF586B7723E852022824", hash_generated_field = "36A2227955369181C5427F8675061A2C")

    private boolean mIsDoubleTapping;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "4925C8499D6FECBA832A37F55AA6C69B", hash_generated_field = "2D88D85D441545A6227529A03C0B4E71")

    private float mLastMotionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "4F6DEDF0BA2D99325BDAE4A27C301E0B", hash_generated_field = "90F53F7625CC0EEE4DC6EBCFF5E518A6")

    private float mLastMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "AC0E18C364C0753415CC5A3B2FB177AA", hash_generated_field = "A200AEA4E8786AAB09346E7991B4CE6C")

    private boolean mIsLongpressEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "550C04696D5359C75C5C0FE9989EEF84", hash_generated_field = "2B51C50DE25129E94BCC4EA38A0389E2")

    private boolean mIgnoreMultitouch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.990 -0400", hash_original_field = "EFB0BA2843C7293EEB82F8592A2A0298", hash_generated_field = "D54334EA2E7A3839D717E5F2F1FCD778")

    private InputEventConsistencyVerifier mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.991 -0400", hash_original_method = "A860FCB0BF3B13241916CBB6D51694FF", hash_generated_method = "D522669AC627072263059E3D3366048D")
    @Deprecated
    public  GestureDetector(OnGestureListener listener, Handler handler) {
        this(null, listener, handler);
        addTaint(listener.getTaint());
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.991 -0400", hash_original_method = "6A4A0666EC699D6858654C1F91F62135", hash_generated_method = "91671E28D2A1E7F8AB6B8690B259B1ED")
    @Deprecated
    public  GestureDetector(OnGestureListener listener) {
        this(null, listener, null);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:46.992 -0400", hash_original_method = "D6C1A078025AA71050A12C76B6AD8601", hash_generated_method = "824E5356E2AF70D3600E101C0208309C")
    public  GestureDetector(Context context, OnGestureListener listener) {
        this(context, listener, null);
        addTaint(context.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.002 -0400", hash_original_method = "D04E727BBFBC862644FCD26897C3FDE9", hash_generated_method = "51BAC8FD51929E47EDFD8038C1DA5850")
    public  GestureDetector(Context context, OnGestureListener listener, Handler handler) {
        this(context, listener, handler, context != null &&
                context.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.FROYO);
        addTaint(context.getTaint());
        addTaint(listener.getTaint());
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.003 -0400", hash_original_method = "3A200FED7280634DDE54E1C354EDC878", hash_generated_method = "CEA94AB197E5666D3721C8972E5A37EC")
    public  GestureDetector(Context context, OnGestureListener listener, Handler handler,
            boolean ignoreMultitouch) {
        {
            mHandler = new GestureHandler(handler);
        } //End block
        {
            mHandler = new GestureHandler();
        } //End block
        mListener = listener;
        {
            setOnDoubleTapListener((OnDoubleTapListener) listener);
        } //End block
        init(context, ignoreMultitouch);
        addTaint(context.getTaint());
        addTaint(ignoreMultitouch);
        // ---------- Original Method ----------
        //if (handler != null) {
            //mHandler = new GestureHandler(handler);
        //} else {
            //mHandler = new GestureHandler();
        //}
        //mListener = listener;
        //if (listener instanceof OnDoubleTapListener) {
            //setOnDoubleTapListener((OnDoubleTapListener) listener);
        //}
        //init(context, ignoreMultitouch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.004 -0400", hash_original_method = "452594061FCEBDDF878D27E65F4EBA07", hash_generated_method = "520A1FFDB980F20A01770618D86CB57F")
    private void init(Context context, boolean ignoreMultitouch) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("OnGestureListener must not be null");
        } //End block
        mIsLongpressEnabled = true;
        mIgnoreMultitouch = ignoreMultitouch;
        int touchSlop, doubleTapSlop;
        {
            touchSlop = ViewConfiguration.getTouchSlop();
            doubleTapSlop = ViewConfiguration.getDoubleTapSlop();
            mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
        } //End block
        {
            ViewConfiguration configuration;
            configuration = ViewConfiguration.get(context);
            touchSlop = configuration.getScaledTouchSlop();
            doubleTapSlop = configuration.getScaledDoubleTapSlop();
            mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
            mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
        } //End block
        mTouchSlopSquare = touchSlop * touchSlop;
        mDoubleTapSlopSquare = doubleTapSlop * doubleTapSlop;
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.021 -0400", hash_original_method = "571B39F87736E3994F3A317209D7E1C6", hash_generated_method = "8874C66605DB2FF6FE5F0E858C5BB080")
    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        mDoubleTapListener = onDoubleTapListener;
        // ---------- Original Method ----------
        //mDoubleTapListener = onDoubleTapListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.022 -0400", hash_original_method = "14829325F18703625EF98BC2472601E3", hash_generated_method = "0B13C9500814A87A70F39F82D929A9E5")
    public void setIsLongpressEnabled(boolean isLongpressEnabled) {
        mIsLongpressEnabled = isLongpressEnabled;
        // ---------- Original Method ----------
        //mIsLongpressEnabled = isLongpressEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.022 -0400", hash_original_method = "880D3BB55D8069819877BA46CC6F055B", hash_generated_method = "F8D5C65317932E7906E6CF6274D2099E")
    public boolean isLongpressEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225025210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_225025210;
        // ---------- Original Method ----------
        //return mIsLongpressEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.041 -0400", hash_original_method = "83C7BED09A17CDEA8B0FB9700395D72F", hash_generated_method = "4556CDE89E7339F65CCB0733194DB6D6")
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mInputEventConsistencyVerifier.onTouchEvent(ev, 0);
        } //End block
        int action;
        action = ev.getAction();
        float y;
        y = ev.getY();
        float x;
        x = ev.getX();
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        mVelocityTracker.addMovement(ev);
        boolean handled;
        handled = false;
        //Begin case MotionEvent.ACTION_POINTER_DOWN 
        {
            cancel();
        } //End block
        //End case MotionEvent.ACTION_POINTER_DOWN 
        //Begin case MotionEvent.ACTION_POINTER_UP 
        {
            boolean varD97C0174A9E1D80C003E38A351EDCFB2_1829232968 = (mIgnoreMultitouch && ev.getPointerCount() == 2);
            {
                int index;
                index = 1;
                index = 0;
                mLastMotionX = ev.getX(index);
                mLastMotionY = ev.getY(index);
                mVelocityTracker.recycle();
                mVelocityTracker = VelocityTracker.obtain();
            } //End block
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_POINTER_UP 
        //Begin case MotionEvent.ACTION_DOWN 
        {
            boolean hadTapMessage;
            hadTapMessage = mHandler.hasMessages(TAP);
            mHandler.removeMessages(TAP);
            {
                boolean var311B179313FE8C67F2BE87EC759DDC8F_1097666025 = ((mCurrentDownEvent != null) && (mPreviousUpEvent != null) && hadTapMessage &&
                        isConsideredDoubleTap(mCurrentDownEvent, mPreviousUpEvent, ev));
                {
                    mIsDoubleTapping = true;
                    handled |= mDoubleTapListener.onDoubleTap(mCurrentDownEvent);
                    handled |= mDoubleTapListener.onDoubleTapEvent(ev);
                } //End block
                {
                    mHandler.sendEmptyMessageDelayed(TAP, DOUBLE_TAP_TIMEOUT);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        mLastMotionX = x;
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        mLastMotionY = y;
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        {
            mCurrentDownEvent.recycle();
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        mCurrentDownEvent = MotionEvent.obtain(ev);
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        mAlwaysInTapRegion = true;
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        mAlwaysInBiggerTapRegion = true;
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        mStillDown = true;
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        mInLongPress = false;
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        {
            mHandler.removeMessages(LONG_PRESS);
            mHandler.sendEmptyMessageAtTime(LONG_PRESS, mCurrentDownEvent.getDownTime()
                        + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        mHandler.sendEmptyMessageAtTime(SHOW_PRESS, mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        handled |= mListener.onDown(ev);
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            boolean var0ACAD9C5E0F01680210FDA43D38031BC_1279594266 = (mInLongPress || (mIgnoreMultitouch && ev.getPointerCount() > 1));
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_MOVE 
        float scrollX;
        scrollX = mLastMotionX - x;
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_MOVE 
        float scrollY;
        scrollY = mLastMotionY - y;
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            handled |= mDoubleTapListener.onDoubleTapEvent(ev);
        } //End block
        {
            int deltaX;
            deltaX = (int) (x - mCurrentDownEvent.getX());
            int deltaY;
            deltaY = (int) (y - mCurrentDownEvent.getY());
            int distance;
            distance = (deltaX * deltaX) + (deltaY * deltaY);
            {
                handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
                mLastMotionX = x;
                mLastMotionY = y;
                mAlwaysInTapRegion = false;
                mHandler.removeMessages(TAP);
                mHandler.removeMessages(SHOW_PRESS);
                mHandler.removeMessages(LONG_PRESS);
            } //End block
            {
                mAlwaysInBiggerTapRegion = false;
            } //End block
        } //End block
        {
            boolean varD653EA082922524D916E73AEEA170500_692391129 = ((Math.abs(scrollX) >= 1) || (Math.abs(scrollY) >= 1));
            {
                handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
                mLastMotionX = x;
                mLastMotionY = y;
            } //End block
        } //End collapsed parenthetic
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_UP 
        mStillDown = false;
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        MotionEvent currentUpEvent;
        currentUpEvent = MotionEvent.obtain(ev);
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        {
            handled |= mDoubleTapListener.onDoubleTapEvent(ev);
        } //End block
        {
            mHandler.removeMessages(TAP);
            mInLongPress = false;
        } //End block
        {
            handled = mListener.onSingleTapUp(ev);
        } //End block
        {
            VelocityTracker velocityTracker;
            velocityTracker = mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
            float velocityY;
            velocityY = velocityTracker.getYVelocity();
            float velocityX;
            velocityX = velocityTracker.getXVelocity();
            {
                boolean var167DF1FA2BFEE68BD6A6CC794311CBFB_488848634 = ((Math.abs(velocityY) > mMinimumFlingVelocity)
                        || (Math.abs(velocityX) > mMinimumFlingVelocity));
                {
                    handled = mListener.onFling(mCurrentDownEvent, ev, velocityX, velocityY);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        {
            mPreviousUpEvent.recycle();
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        mPreviousUpEvent = currentUpEvent;
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        mVelocityTracker.recycle();
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        mVelocityTracker = null;
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        mIsDoubleTapping = false;
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        mHandler.removeMessages(SHOW_PRESS);
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        mHandler.removeMessages(LONG_PRESS);
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL 
        cancel();
        //End case MotionEvent.ACTION_CANCEL 
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(ev, 0);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_749959706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_749959706;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.043 -0400", hash_original_method = "9B9F1964085C6E9CB79BA6CBFD2B9081", hash_generated_method = "3CC86CBA62883A58172AA842C711B3EC")
    private void cancel() {
        mHandler.removeMessages(SHOW_PRESS);
        mHandler.removeMessages(LONG_PRESS);
        mHandler.removeMessages(TAP);
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        mIsDoubleTapping = false;
        mStillDown = false;
        mAlwaysInTapRegion = false;
        mAlwaysInBiggerTapRegion = false;
        {
            mInLongPress = false;
        } //End block
        // ---------- Original Method ----------
        //mHandler.removeMessages(SHOW_PRESS);
        //mHandler.removeMessages(LONG_PRESS);
        //mHandler.removeMessages(TAP);
        //mVelocityTracker.recycle();
        //mVelocityTracker = null;
        //mIsDoubleTapping = false;
        //mStillDown = false;
        //mAlwaysInTapRegion = false;
        //mAlwaysInBiggerTapRegion = false;
        //if (mInLongPress) {
            //mInLongPress = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.055 -0400", hash_original_method = "EA18A75BD47C1C65D8FE280884C192C1", hash_generated_method = "60556A0E20B999D58FF6D3CBC84704D1")
    private boolean isConsideredDoubleTap(MotionEvent firstDown, MotionEvent firstUp,
            MotionEvent secondDown) {
        {
            boolean var9D1A46F7666A3DD5BFCF5808BD1BCDCA_858941003 = (secondDown.getEventTime() - firstUp.getEventTime() > DOUBLE_TAP_TIMEOUT);
        } //End collapsed parenthetic
        int deltaX;
        deltaX = (int) firstDown.getX() - (int) secondDown.getX();
        int deltaY;
        deltaY = (int) firstDown.getY() - (int) secondDown.getY();
        addTaint(firstDown.getTaint());
        addTaint(firstUp.getTaint());
        addTaint(secondDown.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_196343289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_196343289;
        // ---------- Original Method ----------
        //if (!mAlwaysInBiggerTapRegion) {
            //return false;
        //}
        //if (secondDown.getEventTime() - firstUp.getEventTime() > DOUBLE_TAP_TIMEOUT) {
            //return false;
        //}
        //int deltaX = (int) firstDown.getX() - (int) secondDown.getX();
        //int deltaY = (int) firstDown.getY() - (int) secondDown.getY();
        //return (deltaX * deltaX + deltaY * deltaY < mDoubleTapSlopSquare);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.056 -0400", hash_original_method = "1B110E72A2C7F37DAF94A595462A9E07", hash_generated_method = "E2D9F2F38B3AC8E6DE4DCDABAEFB8284")
    private void dispatchLongPress() {
        mHandler.removeMessages(TAP);
        mInLongPress = true;
        mListener.onLongPress(mCurrentDownEvent);
        // ---------- Original Method ----------
        //mHandler.removeMessages(TAP);
        //mInLongPress = true;
        //mListener.onLongPress(mCurrentDownEvent);
    }

    
    public static class SimpleOnGestureListener implements OnGestureListener, OnDoubleTapListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.056 -0400", hash_original_method = "6EE8AB65667171335D0E5E557D623FF3", hash_generated_method = "6EE8AB65667171335D0E5E557D623FF3")
        public SimpleOnGestureListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.056 -0400", hash_original_method = "6CD5191C407A0B3CBB6F0A0F3D91B6D6", hash_generated_method = "789FCD61A041656DC6F3A73337EDF5BF")
        public boolean onSingleTapUp(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018309582 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018309582;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.057 -0400", hash_original_method = "E609FB951BEBFF493B5A5F179A09A7F5", hash_generated_method = "CE7B5EECBD6FB992C82AB867D868DEBD")
        public void onLongPress(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.057 -0400", hash_original_method = "3D0A16086A925B93F4340895FE1B4CBC", hash_generated_method = "D67E79375251B70379F219DA37CA8280")
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                float distanceX, float distanceY) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e1.getTaint());
            addTaint(e2.getTaint());
            addTaint(distanceX);
            addTaint(distanceY);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1819769736 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1819769736;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.057 -0400", hash_original_method = "BDBE517451C02C6DD8B1C60030C3C43A", hash_generated_method = "D68AFB1D421E9F42BD71DEA8D46B2603")
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                float velocityY) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e1.getTaint());
            addTaint(e2.getTaint());
            addTaint(velocityX);
            addTaint(velocityY);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1574840207 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1574840207;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.058 -0400", hash_original_method = "54A2BF3809B435C5302401FC76B54B22", hash_generated_method = "59BDBECCD2C5F0A2860E71595A2D2C31")
        public void onShowPress(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.058 -0400", hash_original_method = "124BA11CC014942E61EFD87F7F37262C", hash_generated_method = "1584B8650ADB84DB99875777B3A05ED6")
        public boolean onDown(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_741345943 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_741345943;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.058 -0400", hash_original_method = "40BA7E2512EA076BF84D5B49A825B220", hash_generated_method = "ED7426CAFC7DE2202CFE602353826361")
        public boolean onDoubleTap(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1539621946 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1539621946;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.059 -0400", hash_original_method = "D3FAA1FBAE0BE329BB5AEDA3CD619E7D", hash_generated_method = "2F385F249EBF189C8469CACD02AB10FC")
        public boolean onDoubleTapEvent(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_999229852 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_999229852;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.073 -0400", hash_original_method = "5E9F34FF920329D07D248580C4BBB180", hash_generated_method = "CD1E21DEFF3C9DE296D7B51A69EAFCF2")
        public boolean onSingleTapConfirmed(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142395770 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142395770;
            // ---------- Original Method ----------
            //return false;
        }

        
    }


    
    private class GestureHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.073 -0400", hash_original_method = "9D2431BB2A48CA4B74BDD0A31919D26A", hash_generated_method = "09E7D20AAEDBA7AC640E49A4D07867CB")
          GestureHandler() {
            super();
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.073 -0400", hash_original_method = "EA154705C095D614E912EA5301C442EC", hash_generated_method = "D0CC6BB0FEB77AE76A15A155A193F978")
          GestureHandler(Handler handler) {
            super(handler.getLooper());
            addTaint(handler.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.074 -0400", hash_original_method = "B97857986444DBB6880EA006296E5D03", hash_generated_method = "537A4AE5BD77A7C590A6DD7496540AFB")
        @Override
        public void handleMessage(Message msg) {
            //Begin case SHOW_PRESS 
            mListener.onShowPress(mCurrentDownEvent);
            //End case SHOW_PRESS 
            //Begin case LONG_PRESS 
            dispatchLongPress();
            //End case LONG_PRESS 
            //Begin case TAP 
            {
                mDoubleTapListener.onSingleTapConfirmed(mCurrentDownEvent);
            } //End block
            //End case TAP 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown message " + msg);
            //End case default 
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            //switch (msg.what) {
            //case SHOW_PRESS:
                //mListener.onShowPress(mCurrentDownEvent);
                //break;
            //case LONG_PRESS:
                //dispatchLongPress();
                //break;
            //case TAP:
                //if (mDoubleTapListener != null && !mStillDown) {
                    //mDoubleTapListener.onSingleTapConfirmed(mCurrentDownEvent);
                //}
                //break;
            //default:
                //throw new RuntimeException("Unknown message " + msg); 
            //}
        }

        
    }


    
    public interface OnGestureListener {

        
        boolean onDown(MotionEvent e);

        
        void onShowPress(MotionEvent e);

        
        boolean onSingleTapUp(MotionEvent e);

        
        boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);

        
        void onLongPress(MotionEvent e);

        
        boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY);
    }
    
    public interface OnDoubleTapListener {
        
        boolean onSingleTapConfirmed(MotionEvent e);
 
        
        boolean onDoubleTap(MotionEvent e);

        
        boolean onDoubleTapEvent(MotionEvent e);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.075 -0400", hash_original_field = "03946F945DD14FD038A89AC23E3E9895", hash_generated_field = "23859687DCFAB2920448F0666C34AE3F")

    private static int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.075 -0400", hash_original_field = "B24987AF4907B1BB2A2C1D179ED1D635", hash_generated_field = "29F80184A37A49D7E188FEBFEFC45873")

    private static int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.075 -0400", hash_original_field = "9DCE62A9F6416FD8B994A292FCC9AAB4", hash_generated_field = "43BDC469F99C53750121E32DE491F2BA")

    private static int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.075 -0400", hash_original_field = "E22475CBEA33A5A68FC84638428B5337", hash_generated_field = "71465BCFEE7966A83A058BF8342E9D65")

    private static int SHOW_PRESS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.075 -0400", hash_original_field = "670F1D0405D600D5CFE141808EED72C3", hash_generated_field = "B3A011834A0D2368F93791E1BFB6376D")

    private static int LONG_PRESS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:47.075 -0400", hash_original_field = "D41478F8B08A98FC4EA27BF540E635F4", hash_generated_field = "B5FA5D4A37CA227EFE09D1B600B31533")

    private static int TAP = 3;
}

