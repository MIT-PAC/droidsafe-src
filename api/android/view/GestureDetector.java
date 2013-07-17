package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

public class GestureDetector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "63791A3FD882CB7E1632DF20805E6846", hash_generated_field = "12BE8B5CD241157C9F0107D5273E27D1")

    private int mBiggerTouchSlopSquare = 20 * 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "46ABC6D9AB45AE8835C53F4C51724A79", hash_generated_field = "5E5708EA89972028E86242DA050969CA")

    private int mTouchSlopSquare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "2C56C8DD2FA1BBC384FAD39727EC1B9F", hash_generated_field = "6A78E5989D06DA4C68BA85646B379C51")

    private int mDoubleTapSlopSquare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "950A8222B535BF5159B013E5329A56C7", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

    private int mMinimumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "8ED13B950D5803064219CE68BB8F2695", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

    private int mMaximumFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "0F48D0A94630E1FBE9C08A845F9730F2")

    private OnGestureListener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "87FD92A1DBA4F7CE0B58869B5E226B45", hash_generated_field = "6BFE5EA6164149F540DE4277F8AF3864")

    private OnDoubleTapListener mDoubleTapListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "2257E716ABB69174128002B6500326E5", hash_generated_field = "09EA51D062ED44D2275BC8E7A65061C0")

    private boolean mStillDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "6B06472FC4D3499D4338C0A5A44E3AE4", hash_generated_field = "8FA7640B36D34A443E3A43478682F7F9")

    private boolean mInLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "3685FD4DDDDB8177ACFC47DF2506B51F", hash_generated_field = "54A847320ACF73ACDAB1D622D38FE146")

    private boolean mAlwaysInTapRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "32C87B3E60E7CC081197EE23FE48470B", hash_generated_field = "05F405D52B0F8BE7180D2A6B8335B30C")

    private boolean mAlwaysInBiggerTapRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "2B841E5864AD9D17F0AEB812951699B4", hash_generated_field = "CAFEE339D8B144D23812ECC71639FEB7")

    private MotionEvent mCurrentDownEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "FE83D903AD347CA461A9D70C5013239C", hash_generated_field = "2C9915BC9FEEE919EC1B54BA44C7E08E")

    private MotionEvent mPreviousUpEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "D9B3FFE15EA3AF586B7723E852022824", hash_generated_field = "36A2227955369181C5427F8675061A2C")

    private boolean mIsDoubleTapping;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.337 -0400", hash_original_field = "4925C8499D6FECBA832A37F55AA6C69B", hash_generated_field = "2D88D85D441545A6227529A03C0B4E71")

    private float mLastMotionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.338 -0400", hash_original_field = "4F6DEDF0BA2D99325BDAE4A27C301E0B", hash_generated_field = "90F53F7625CC0EEE4DC6EBCFF5E518A6")

    private float mLastMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.338 -0400", hash_original_field = "AC0E18C364C0753415CC5A3B2FB177AA", hash_generated_field = "A200AEA4E8786AAB09346E7991B4CE6C")

    private boolean mIsLongpressEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.338 -0400", hash_original_field = "550C04696D5359C75C5C0FE9989EEF84", hash_generated_field = "2B51C50DE25129E94BCC4EA38A0389E2")

    private boolean mIgnoreMultitouch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.338 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.338 -0400", hash_original_field = "EFB0BA2843C7293EEB82F8592A2A0298", hash_generated_field = "69B49DB79681808A97D2CCE1BF25440C")

    private final InputEventConsistencyVerifier mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.338 -0400", hash_original_method = "A860FCB0BF3B13241916CBB6D51694FF", hash_generated_method = "E6CA8D8569D21E79FA473A515330C959")
    @Deprecated
    public  GestureDetector(OnGestureListener listener, Handler handler) {
        this(null, listener, handler);
        addTaint(handler.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.338 -0400", hash_original_method = "6A4A0666EC699D6858654C1F91F62135", hash_generated_method = "91671E28D2A1E7F8AB6B8690B259B1ED")
    @Deprecated
    public  GestureDetector(OnGestureListener listener) {
        this(null, listener, null);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.339 -0400", hash_original_method = "D6C1A078025AA71050A12C76B6AD8601", hash_generated_method = "38776F5E0B561D0B8EC94ED1EF65106E")
    public  GestureDetector(Context context, OnGestureListener listener) {
        this(context, listener, null);
        addTaint(listener.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.339 -0400", hash_original_method = "D04E727BBFBC862644FCD26897C3FDE9", hash_generated_method = "65D33671FADD6210424E5C6191C4445F")
    public  GestureDetector(Context context, OnGestureListener listener, Handler handler) {
        this(context, listener, handler, context != null &&
                context.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.FROYO);
        addTaint(handler.getTaint());
        addTaint(listener.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.340 -0400", hash_original_method = "3A200FED7280634DDE54E1C354EDC878", hash_generated_method = "2ACD6CA9F5DEC57A33DA67091312F2BF")
    public  GestureDetector(Context context, OnGestureListener listener, Handler handler,
            boolean ignoreMultitouch) {
        addTaint(ignoreMultitouch);
        addTaint(context.getTaint());
        if(handler != null)        
        {
            mHandler = new GestureHandler(handler);
        } //End block
        else
        {
            mHandler = new GestureHandler();
        } //End block
        mListener = listener;
        if(listener instanceof OnDoubleTapListener)        
        {
            setOnDoubleTapListener((OnDoubleTapListener) listener);
        } //End block
        init(context, ignoreMultitouch);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.342 -0400", hash_original_method = "452594061FCEBDDF878D27E65F4EBA07", hash_generated_method = "36C70C63702B89C1D978C3AF7BA1A43E")
    private void init(Context context, boolean ignoreMultitouch) {
        addTaint(context.getTaint());
        if(mListener == null)        
        {
            NullPointerException varED1C003194A7D238BD8D57F55A176CB2_472908865 = new NullPointerException("OnGestureListener must not be null");
            varED1C003194A7D238BD8D57F55A176CB2_472908865.addTaint(taint);
            throw varED1C003194A7D238BD8D57F55A176CB2_472908865;
        } //End block
        mIsLongpressEnabled = true;
        mIgnoreMultitouch = ignoreMultitouch;
        int touchSlop;
        int doubleTapSlop;
        if(context == null)        
        {
            touchSlop = ViewConfiguration.getTouchSlop();
            doubleTapSlop = ViewConfiguration.getDoubleTapSlop();
            mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
        } //End block
        else
        {
            final ViewConfiguration configuration = ViewConfiguration.get(context);
            touchSlop = configuration.getScaledTouchSlop();
            doubleTapSlop = configuration.getScaledDoubleTapSlop();
            mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
            mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
        } //End block
        mTouchSlopSquare = touchSlop * touchSlop;
        mDoubleTapSlopSquare = doubleTapSlop * doubleTapSlop;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.342 -0400", hash_original_method = "571B39F87736E3994F3A317209D7E1C6", hash_generated_method = "8874C66605DB2FF6FE5F0E858C5BB080")
    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        mDoubleTapListener = onDoubleTapListener;
        // ---------- Original Method ----------
        //mDoubleTapListener = onDoubleTapListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.343 -0400", hash_original_method = "14829325F18703625EF98BC2472601E3", hash_generated_method = "0B13C9500814A87A70F39F82D929A9E5")
    public void setIsLongpressEnabled(boolean isLongpressEnabled) {
        mIsLongpressEnabled = isLongpressEnabled;
        // ---------- Original Method ----------
        //mIsLongpressEnabled = isLongpressEnabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.343 -0400", hash_original_method = "880D3BB55D8069819877BA46CC6F055B", hash_generated_method = "8688E230DF90C5CB89CC91B44AD6A53C")
    public boolean isLongpressEnabled() {
        boolean varAC0E18C364C0753415CC5A3B2FB177AA_1741130630 = (mIsLongpressEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972177383 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_972177383;
        // ---------- Original Method ----------
        //return mIsLongpressEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.347 -0400", hash_original_method = "83C7BED09A17CDEA8B0FB9700395D72F", hash_generated_method = "D4E2D64EBF77F6B32CC537CB504EECA3")
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onTouchEvent(ev, 0);
        } //End block
        final int action = ev.getAction();
        final float y = ev.getY();
        final float x = ev.getX();
        if(mVelocityTracker == null)        
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        mVelocityTracker.addMovement(ev);
        boolean handled = false;
switch(action & MotionEvent.ACTION_MASK){
        case MotionEvent.ACTION_POINTER_DOWN:
        if(mIgnoreMultitouch)        
        {
            cancel();
        } //End block
        break;
        case MotionEvent.ACTION_POINTER_UP:
        if(mIgnoreMultitouch && ev.getPointerCount() == 2)        
        {
            int index = (((action & MotionEvent.ACTION_POINTER_INDEX_MASK)
                        >> MotionEvent.ACTION_POINTER_INDEX_SHIFT) == 0) ? 1 : 0;
            mLastMotionX = ev.getX(index);
            mLastMotionY = ev.getY(index);
            mVelocityTracker.recycle();
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        break;
        case MotionEvent.ACTION_DOWN:
        if(mDoubleTapListener != null)        
        {
            boolean hadTapMessage = mHandler.hasMessages(TAP);
            if(hadTapMessage)            
            mHandler.removeMessages(TAP);
            if((mCurrentDownEvent != null) && (mPreviousUpEvent != null) && hadTapMessage &&
                        isConsideredDoubleTap(mCurrentDownEvent, mPreviousUpEvent, ev))            
            {
                mIsDoubleTapping = true;
                handled |= mDoubleTapListener.onDoubleTap(mCurrentDownEvent);
                handled |= mDoubleTapListener.onDoubleTapEvent(ev);
            } //End block
            else
            {
                mHandler.sendEmptyMessageDelayed(TAP, DOUBLE_TAP_TIMEOUT);
            } //End block
        } //End block
        mLastMotionX = x;
        mLastMotionY = y;
        if(mCurrentDownEvent != null)        
        {
            mCurrentDownEvent.recycle();
        } //End block
        mCurrentDownEvent = MotionEvent.obtain(ev);
        mAlwaysInTapRegion = true;
        mAlwaysInBiggerTapRegion = true;
        mStillDown = true;
        mInLongPress = false;
        if(mIsLongpressEnabled)        
        {
            mHandler.removeMessages(LONG_PRESS);
            mHandler.sendEmptyMessageAtTime(LONG_PRESS, mCurrentDownEvent.getDownTime()
                        + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
        } //End block
        mHandler.sendEmptyMessageAtTime(SHOW_PRESS, mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
        handled |= mListener.onDown(ev);
        break;
        case MotionEvent.ACTION_MOVE:
        if(mInLongPress || (mIgnoreMultitouch && ev.getPointerCount() > 1))        
        {
            break;
        } //End block
        final float scrollX = mLastMotionX - x;
        final float scrollY = mLastMotionY - y;
        if(mIsDoubleTapping)        
        {
            handled |= mDoubleTapListener.onDoubleTapEvent(ev);
        } //End block
        else
        if(mAlwaysInTapRegion)        
        {
            final int deltaX = (int) (x - mCurrentDownEvent.getX());
            final int deltaY = (int) (y - mCurrentDownEvent.getY());
            int distance = (deltaX * deltaX) + (deltaY * deltaY);
            if(distance > mTouchSlopSquare)            
            {
                handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
                mLastMotionX = x;
                mLastMotionY = y;
                mAlwaysInTapRegion = false;
                mHandler.removeMessages(TAP);
                mHandler.removeMessages(SHOW_PRESS);
                mHandler.removeMessages(LONG_PRESS);
            } //End block
            if(distance > mBiggerTouchSlopSquare)            
            {
                mAlwaysInBiggerTapRegion = false;
            } //End block
        } //End block
        else
        if((Math.abs(scrollX) >= 1) || (Math.abs(scrollY) >= 1))        
        {
            handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
            mLastMotionX = x;
            mLastMotionY = y;
        } //End block
        break;
        case MotionEvent.ACTION_UP:
        mStillDown = false;
        MotionEvent currentUpEvent = MotionEvent.obtain(ev);
        if(mIsDoubleTapping)        
        {
            handled |= mDoubleTapListener.onDoubleTapEvent(ev);
        } //End block
        else
        if(mInLongPress)        
        {
            mHandler.removeMessages(TAP);
            mInLongPress = false;
        } //End block
        else
        if(mAlwaysInTapRegion)        
        {
            handled = mListener.onSingleTapUp(ev);
        } //End block
        else
        {
            final VelocityTracker velocityTracker = mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
            final float velocityY = velocityTracker.getYVelocity();
            final float velocityX = velocityTracker.getXVelocity();
            if((Math.abs(velocityY) > mMinimumFlingVelocity)
                        || (Math.abs(velocityX) > mMinimumFlingVelocity))            
            {
                handled = mListener.onFling(mCurrentDownEvent, ev, velocityX, velocityY);
            } //End block
        } //End block
        if(mPreviousUpEvent != null)        
        {
            mPreviousUpEvent.recycle();
        } //End block
        mPreviousUpEvent = currentUpEvent;
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        mIsDoubleTapping = false;
        mHandler.removeMessages(SHOW_PRESS);
        mHandler.removeMessages(LONG_PRESS);
        break;
        case MotionEvent.ACTION_CANCEL:
        cancel();
        break;
}        if(!handled && mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(ev, 0);
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1644839269 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_294152416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_294152416;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.349 -0400", hash_original_method = "9B9F1964085C6E9CB79BA6CBFD2B9081", hash_generated_method = "796824CC773B7377848C7366EC1CAA07")
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
        if(mInLongPress)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.349 -0400", hash_original_method = "EA18A75BD47C1C65D8FE280884C192C1", hash_generated_method = "8468563D0BB68C6CAD45E2CCE14A9B61")
    private boolean isConsideredDoubleTap(MotionEvent firstDown, MotionEvent firstUp,
            MotionEvent secondDown) {
        addTaint(secondDown.getTaint());
        addTaint(firstUp.getTaint());
        addTaint(firstDown.getTaint());
        if(!mAlwaysInBiggerTapRegion)        
        {
            boolean var68934A3E9455FA72420237EB05902327_257873807 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_759218878 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_759218878;
        } //End block
        if(secondDown.getEventTime() - firstUp.getEventTime() > DOUBLE_TAP_TIMEOUT)        
        {
            boolean var68934A3E9455FA72420237EB05902327_415345170 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984009629 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984009629;
        } //End block
        int deltaX = (int) firstDown.getX() - (int) secondDown.getX();
        int deltaY = (int) firstDown.getY() - (int) secondDown.getY();
        boolean varF3D273F1BF9D7EA8A8933EB9ED1F4682_1547639003 = ((deltaX * deltaX + deltaY * deltaY < mDoubleTapSlopSquare));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2004905856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2004905856;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.349 -0400", hash_original_method = "1B110E72A2C7F37DAF94A595462A9E07", hash_generated_method = "E2D9F2F38B3AC8E6DE4DCDABAEFB8284")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.349 -0400", hash_original_method = "6EE8AB65667171335D0E5E557D623FF3", hash_generated_method = "6EE8AB65667171335D0E5E557D623FF3")
        public SimpleOnGestureListener ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.349 -0400", hash_original_method = "6CD5191C407A0B3CBB6F0A0F3D91B6D6", hash_generated_method = "AAE56E372DADBCF62CB60E0258C5FEF9")
        public boolean onSingleTapUp(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1116879028 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084617065 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084617065;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.350 -0400", hash_original_method = "E609FB951BEBFF493B5A5F179A09A7F5", hash_generated_method = "CE7B5EECBD6FB992C82AB867D868DEBD")
        public void onLongPress(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.350 -0400", hash_original_method = "3D0A16086A925B93F4340895FE1B4CBC", hash_generated_method = "47571CFFEDDF8D803AB839470EDC93C9")
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                float distanceX, float distanceY) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(distanceY);
            addTaint(distanceX);
            addTaint(e2.getTaint());
            addTaint(e1.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_2058774058 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1814818572 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1814818572;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.350 -0400", hash_original_method = "BDBE517451C02C6DD8B1C60030C3C43A", hash_generated_method = "C74EC31E8DE1BA949D5007DB293E5609")
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                float velocityY) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(velocityY);
            addTaint(velocityX);
            addTaint(e2.getTaint());
            addTaint(e1.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1466050769 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_855970207 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_855970207;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.350 -0400", hash_original_method = "54A2BF3809B435C5302401FC76B54B22", hash_generated_method = "59BDBECCD2C5F0A2860E71595A2D2C31")
        public void onShowPress(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.350 -0400", hash_original_method = "124BA11CC014942E61EFD87F7F37262C", hash_generated_method = "D9CECE622D5FF79C58F1ECDCA1818914")
        public boolean onDown(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1023055468 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_40563768 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_40563768;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.350 -0400", hash_original_method = "40BA7E2512EA076BF84D5B49A825B220", hash_generated_method = "C6049AA3D20F43057BC8995C578A1FEF")
        public boolean onDoubleTap(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_235159336 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018563827 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018563827;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.350 -0400", hash_original_method = "D3FAA1FBAE0BE329BB5AEDA3CD619E7D", hash_generated_method = "8A8575DDE14C8AA268BAABBBAA324B36")
        public boolean onDoubleTapEvent(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_250330181 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137645078 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137645078;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.350 -0400", hash_original_method = "5E9F34FF920329D07D248580C4BBB180", hash_generated_method = "ACE38830C49C19A8C301E301111659CB")
        public boolean onSingleTapConfirmed(MotionEvent e) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(e.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1978252615 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867731890 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_867731890;
            // ---------- Original Method ----------
            //return false;
        }

        
    }


    
    private class GestureHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.350 -0400", hash_original_method = "9D2431BB2A48CA4B74BDD0A31919D26A", hash_generated_method = "09E7D20AAEDBA7AC640E49A4D07867CB")
          GestureHandler() {
            super();
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.351 -0400", hash_original_method = "EA154705C095D614E912EA5301C442EC", hash_generated_method = "D0CC6BB0FEB77AE76A15A155A193F978")
          GestureHandler(Handler handler) {
            super(handler.getLooper());
            addTaint(handler.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.351 -0400", hash_original_method = "B97857986444DBB6880EA006296E5D03", hash_generated_method = "EF8F3E679304C3014B25A3B41E90C908")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case SHOW_PRESS:
            mListener.onShowPress(mCurrentDownEvent);
            break;
            case LONG_PRESS:
            dispatchLongPress();
            break;
            case TAP:
            if(mDoubleTapListener != null && !mStillDown)            
            {
                mDoubleTapListener.onSingleTapConfirmed(mCurrentDownEvent);
            } //End block
            break;
            default:
            RuntimeException varD073940B7D772B025CA83558DFEB8953_245042497 = new RuntimeException("Unknown message " + msg);
            varD073940B7D772B025CA83558DFEB8953_245042497.addTaint(taint);
            throw varD073940B7D772B025CA83558DFEB8953_245042497;
}
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.351 -0400", hash_original_field = "03946F945DD14FD038A89AC23E3E9895", hash_generated_field = "A0C74D07DE33813B70581123FF749A35")

    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.351 -0400", hash_original_field = "B24987AF4907B1BB2A2C1D179ED1D635", hash_generated_field = "B2C557FED0C410FD936C94D9C495E66C")

    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.351 -0400", hash_original_field = "9DCE62A9F6416FD8B994A292FCC9AAB4", hash_generated_field = "AF4DBB13E8C6A9BFDCE110BEA6959177")

    private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.351 -0400", hash_original_field = "E22475CBEA33A5A68FC84638428B5337", hash_generated_field = "3EDD79F644F06511146F8C3326C425D3")

    private static final int SHOW_PRESS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.351 -0400", hash_original_field = "670F1D0405D600D5CFE141808EED72C3", hash_generated_field = "4E989C39F54DC49F53402A764DC21A3E")

    private static final int LONG_PRESS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.351 -0400", hash_original_field = "D41478F8B08A98FC4EA27BF540E635F4", hash_generated_field = "5FB95885301BF4A2A2BE1CAC2FC68081")

    private static final int TAP = 3;
}

