package android.support.v4.view;

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
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

public class GestureDetectorCompat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.592 -0400", hash_original_field = "8A971C38A16E50B1D10173CD1CAC2884", hash_generated_field = "036BBE30701EEA23262187CD19803D9D")

    private GestureDetectorCompatImpl mImpl;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.592 -0400", hash_original_method = "B489A839D159E7FF17B94DE4C6548B8A", hash_generated_method = "53B4E27B76558B320B313EC2FB1B522C")
    public  GestureDetectorCompat(Context context, OnGestureListener listener) {
        this(context, listener, null);
        addTaint(context.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.593 -0400", hash_original_method = "A4BEFD368B129408AD26BDC86C73C812", hash_generated_method = "DD29205824458BCD9DB5142A87533F41")
    public  GestureDetectorCompat(Context context, OnGestureListener listener, Handler handler) {
        {
            mImpl = new GestureDetectorCompatImplJellybeanMr1(context, listener, handler);
        } //End block
        {
            mImpl = new GestureDetectorCompatImplBase(context, listener, handler);
        } //End block
        // ---------- Original Method ----------
        //if (Build.VERSION.SDK_INT >= 17) {
            //mImpl = new GestureDetectorCompatImplJellybeanMr1(context, listener, handler);
        //} else {
            //mImpl = new GestureDetectorCompatImplBase(context, listener, handler);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.593 -0400", hash_original_method = "A561314D3C1B1E75D0698E5F7C49EB6E", hash_generated_method = "6D6DB294EF78AF244B459EFB1FE043D4")
    public boolean isLongpressEnabled() {
        boolean var0BEF5417CDEB169CC14E120F1EE7972F_1553813371 = (mImpl.isLongpressEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500660290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500660290;
        // ---------- Original Method ----------
        //return mImpl.isLongpressEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.594 -0400", hash_original_method = "8AC0D1224703F0491B06EEE77D787E6B", hash_generated_method = "C7C2521EEEAFD580530734C98C4AA61B")
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean var9C758E14F312F02586E0C16D04CB1BF5_591950213 = (mImpl.onTouchEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592505096 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592505096;
        // ---------- Original Method ----------
        //return mImpl.onTouchEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.597 -0400", hash_original_method = "CE9D16700D0FD12C9940AF8D170F6A2B", hash_generated_method = "A14D6ABA198247FCF8ED25F9F4B3AC0B")
    public void setIsLongpressEnabled(boolean enabled) {
        mImpl.setIsLongpressEnabled(enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //mImpl.setIsLongpressEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.598 -0400", hash_original_method = "6AF653381945FBFC7EE8133ECEAFFC6B", hash_generated_method = "E3FA0BCCB4B34F46D73BD81D6D88D256")
    public void setOnDoubleTapListener(OnDoubleTapListener listener) {
        mImpl.setOnDoubleTapListener(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //mImpl.setOnDoubleTapListener(listener);
    }

    
    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.608 -0400", hash_original_field = "46ABC6D9AB45AE8835C53F4C51724A79", hash_generated_field = "5E5708EA89972028E86242DA050969CA")

        private int mTouchSlopSquare;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "2C56C8DD2FA1BBC384FAD39727EC1B9F", hash_generated_field = "6A78E5989D06DA4C68BA85646B379C51")

        private int mDoubleTapSlopSquare;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "950A8222B535BF5159B013E5329A56C7", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

        private int mMinimumFlingVelocity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "8ED13B950D5803064219CE68BB8F2695", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

        private int mMaximumFlingVelocity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "0F48D0A94630E1FBE9C08A845F9730F2")

        private OnGestureListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "87FD92A1DBA4F7CE0B58869B5E226B45", hash_generated_field = "6BFE5EA6164149F540DE4277F8AF3864")

        private OnDoubleTapListener mDoubleTapListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "2257E716ABB69174128002B6500326E5", hash_generated_field = "09EA51D062ED44D2275BC8E7A65061C0")

        private boolean mStillDown;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "6B06472FC4D3499D4338C0A5A44E3AE4", hash_generated_field = "8FA7640B36D34A443E3A43478682F7F9")

        private boolean mInLongPress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "3685FD4DDDDB8177ACFC47DF2506B51F", hash_generated_field = "54A847320ACF73ACDAB1D622D38FE146")

        private boolean mAlwaysInTapRegion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "32C87B3E60E7CC081197EE23FE48470B", hash_generated_field = "05F405D52B0F8BE7180D2A6B8335B30C")

        private boolean mAlwaysInBiggerTapRegion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "2B841E5864AD9D17F0AEB812951699B4", hash_generated_field = "CAFEE339D8B144D23812ECC71639FEB7")

        private MotionEvent mCurrentDownEvent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.621 -0400", hash_original_field = "FE83D903AD347CA461A9D70C5013239C", hash_generated_field = "2C9915BC9FEEE919EC1B54BA44C7E08E")

        private MotionEvent mPreviousUpEvent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.622 -0400", hash_original_field = "D9B3FFE15EA3AF586B7723E852022824", hash_generated_field = "36A2227955369181C5427F8675061A2C")

        private boolean mIsDoubleTapping;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.622 -0400", hash_original_field = "2B2AC44A2F75B6ED3B28F2B692DC3C05", hash_generated_field = "84CD91C09EAD7174CCB4F3B9EA5CBA95")

        private float mLastFocusX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.622 -0400", hash_original_field = "5F5A7667C22475DFB1630E34528BF0F0", hash_generated_field = "6298DB9E92040E49B36F3F9306873EF7")

        private float mLastFocusY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.622 -0400", hash_original_field = "F1C23FB2305DF7E5137E0C374E9E5205", hash_generated_field = "242E37A6A8338FD7A04B05F9B165C2FE")

        private float mDownFocusX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.622 -0400", hash_original_field = "0939244D969F8AE1C483899F5BA3B363", hash_generated_field = "99DEED00E0728B6FC9DC02081D4D5B0F")

        private float mDownFocusY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.622 -0400", hash_original_field = "AC0E18C364C0753415CC5A3B2FB177AA", hash_generated_field = "A200AEA4E8786AAB09346E7991B4CE6C")

        private boolean mIsLongpressEnabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.622 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

        private VelocityTracker mVelocityTracker;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.623 -0400", hash_original_method = "0E44C690339E9DC4060FF288C9A50E58", hash_generated_method = "7AA78AC212C75AE932AFD3A51C78CE4A")
        public  GestureDetectorCompatImplBase(Context context, OnGestureListener listener,
                Handler handler) {
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
            init(context);
            addTaint(context.getTaint());
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
            //init(context);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.626 -0400", hash_original_method = "74A2F376400AF2C150D1C52FC35C5FC0", hash_generated_method = "A83F6B45451ED02D427C3800F109B3A3")
        private void init(Context context) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Context must not be null");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("OnGestureListener must not be null");
            } //End block
            mIsLongpressEnabled = true;
            ViewConfiguration configuration;
            configuration = ViewConfiguration.get(context);
            int touchSlop;
            touchSlop = configuration.getScaledTouchSlop();
            int doubleTapSlop;
            doubleTapSlop = configuration.getScaledDoubleTapSlop();
            mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
            mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
            mTouchSlopSquare = touchSlop * touchSlop;
            mDoubleTapSlopSquare = doubleTapSlop * doubleTapSlop;
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //if (context == null) {
                //throw new IllegalArgumentException("Context must not be null");
            //}
            //if (mListener == null) {
                //throw new IllegalArgumentException("OnGestureListener must not be null");
            //}
            //mIsLongpressEnabled = true;
            //final ViewConfiguration configuration = ViewConfiguration.get(context);
            //final int touchSlop = configuration.getScaledTouchSlop();
            //final int doubleTapSlop = configuration.getScaledDoubleTapSlop();
            //mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
            //mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
            //mTouchSlopSquare = touchSlop * touchSlop;
            //mDoubleTapSlopSquare = doubleTapSlop * doubleTapSlop;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.627 -0400", hash_original_method = "571B39F87736E3994F3A317209D7E1C6", hash_generated_method = "8874C66605DB2FF6FE5F0E858C5BB080")
        public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            mDoubleTapListener = onDoubleTapListener;
            // ---------- Original Method ----------
            //mDoubleTapListener = onDoubleTapListener;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.639 -0400", hash_original_method = "14829325F18703625EF98BC2472601E3", hash_generated_method = "0B13C9500814A87A70F39F82D929A9E5")
        public void setIsLongpressEnabled(boolean isLongpressEnabled) {
            mIsLongpressEnabled = isLongpressEnabled;
            // ---------- Original Method ----------
            //mIsLongpressEnabled = isLongpressEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.640 -0400", hash_original_method = "880D3BB55D8069819877BA46CC6F055B", hash_generated_method = "FE2D5D1601B67976BBC23161C791FC48")
        public boolean isLongpressEnabled() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_475379731 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_475379731;
            // ---------- Original Method ----------
            //return mIsLongpressEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.761 -0400", hash_original_method = "E5CE0E5B73A1CCAF484886A860A0FDAD", hash_generated_method = "3FC8D771E3618A3753AEAE2397E7C358")
        public boolean onTouchEvent(MotionEvent ev) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            int action;
            action = ev.getAction();
            {
                mVelocityTracker = VelocityTracker.obtain();
            } //End block
            mVelocityTracker.addMovement(ev);
            boolean pointerUp;
            pointerUp = (action & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_POINTER_UP;
            int skipIndex;
            skipIndex = MotionEventCompat.getActionIndex(ev);
            skipIndex = -1;
            float sumX, sumY;
            sumX = 0;
            sumY = 0;
            int count;
            count = MotionEventCompat.getPointerCount(ev);
            {
                int i;
                i = 0;
                {
                    sumX += MotionEventCompat.getX(ev, i);
                    sumY += MotionEventCompat.getY(ev, i);
                } //End block
            } //End collapsed parenthetic
            int div;
            div = count - 1;
            div = count;
            float focusX;
            focusX = sumX / div;
            float focusY;
            focusY = sumY / div;
            boolean handled;
            handled = false;
            //Begin case MotionEventCompat.ACTION_POINTER_DOWN 
            mDownFocusX = mLastFocusX = focusX;
            //End case MotionEventCompat.ACTION_POINTER_DOWN 
            //Begin case MotionEventCompat.ACTION_POINTER_DOWN 
            mDownFocusY = mLastFocusY = focusY;
            //End case MotionEventCompat.ACTION_POINTER_DOWN 
            //Begin case MotionEventCompat.ACTION_POINTER_DOWN 
            cancelTaps();
            //End case MotionEventCompat.ACTION_POINTER_DOWN 
            //Begin case MotionEventCompat.ACTION_POINTER_UP 
            mDownFocusX = mLastFocusX = focusX;
            //End case MotionEventCompat.ACTION_POINTER_UP 
            //Begin case MotionEventCompat.ACTION_POINTER_UP 
            mDownFocusY = mLastFocusY = focusY;
            //End case MotionEventCompat.ACTION_POINTER_UP 
            //Begin case MotionEventCompat.ACTION_POINTER_UP 
            mVelocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
            //End case MotionEventCompat.ACTION_POINTER_UP 
            //Begin case MotionEventCompat.ACTION_POINTER_UP 
            int upIndex;
            upIndex = MotionEventCompat.getActionIndex(ev);
            //End case MotionEventCompat.ACTION_POINTER_UP 
            //Begin case MotionEventCompat.ACTION_POINTER_UP 
            int id1;
            id1 = MotionEventCompat.getPointerId(ev, upIndex);
            //End case MotionEventCompat.ACTION_POINTER_UP 
            //Begin case MotionEventCompat.ACTION_POINTER_UP 
            float x1;
            x1 = VelocityTrackerCompat.getXVelocity(mVelocityTracker, id1);
            //End case MotionEventCompat.ACTION_POINTER_UP 
            //Begin case MotionEventCompat.ACTION_POINTER_UP 
            float y1;
            y1 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, id1);
            //End case MotionEventCompat.ACTION_POINTER_UP 
            //Begin case MotionEventCompat.ACTION_POINTER_UP 
            {
                int i;
                i = 0;
                {
                    int id2;
                    id2 = MotionEventCompat.getPointerId(ev, i);
                    float x;
                    x = x1 * VelocityTrackerCompat.getXVelocity(mVelocityTracker, id2);
                    float y;
                    y = y1 * VelocityTrackerCompat.getYVelocity(mVelocityTracker, id2);
                    float dot;
                    dot = x + y;
                    {
                        mVelocityTracker.clear();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            //End case MotionEventCompat.ACTION_POINTER_UP 
            //Begin case MotionEvent.ACTION_DOWN 
            {
                boolean hadTapMessage;
                hadTapMessage = mHandler.hasMessages(TAP);
                mHandler.removeMessages(TAP);
                {
                    boolean varAB9460F3922422F2E61BC8B2D2ED2BB2_1833475937 = ((mCurrentDownEvent != null) && (mPreviousUpEvent != null) && hadTapMessage &&
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
            mDownFocusX = mLastFocusX = focusX;
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_DOWN 
            mDownFocusY = mLastFocusY = focusY;
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
            float scrollX;
            scrollX = mLastFocusX - focusX;
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            float scrollY;
            scrollY = mLastFocusY - focusY;
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_MOVE 
            {
                handled |= mDoubleTapListener.onDoubleTapEvent(ev);
            } //End block
            {
                int deltaX;
                deltaX = (int) (focusX - mDownFocusX);
                int deltaY;
                deltaY = (int) (focusY - mDownFocusY);
                int distance;
                distance = (deltaX * deltaX) + (deltaY * deltaY);
                {
                    handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
                    mLastFocusX = focusX;
                    mLastFocusY = focusY;
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
                boolean var062DA6E8E5DB27C44E82800836A491BB_1534163811 = ((Math.abs(scrollX) >= 1) || (Math.abs(scrollY) >= 1));
                {
                    handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
                    mLastFocusX = focusX;
                    mLastFocusY = focusY;
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
                int pointerId;
                pointerId = MotionEventCompat.getPointerId(ev, 0);
                velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
                float velocityY;
                velocityY = VelocityTrackerCompat.getYVelocity(
                            velocityTracker, pointerId);
                float velocityX;
                velocityX = VelocityTrackerCompat.getXVelocity(
                            velocityTracker, pointerId);
                {
                    boolean varDA5A7959D5D6091F3A3480A64BCAEEAB_1942696094 = ((Math.abs(velocityY) > mMinimumFlingVelocity)
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
            {
                mVelocityTracker.recycle();
                mVelocityTracker = null;
            } //End block
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8996548 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_8996548;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.763 -0400", hash_original_method = "9B9F1964085C6E9CB79BA6CBFD2B9081", hash_generated_method = "3CC86CBA62883A58172AA842C711B3EC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.770 -0400", hash_original_method = "9E2FBC03F0AF2C678887C1E5B2B3FD14", hash_generated_method = "1CC4916739820E85C7CD9F295FEA01A0")
        private void cancelTaps() {
            mHandler.removeMessages(SHOW_PRESS);
            mHandler.removeMessages(LONG_PRESS);
            mHandler.removeMessages(TAP);
            mIsDoubleTapping = false;
            mAlwaysInTapRegion = false;
            mAlwaysInBiggerTapRegion = false;
            {
                mInLongPress = false;
            } //End block
            // ---------- Original Method ----------
            //mHandler.removeMessages(SHOW_PRESS);
            //mHandler.removeMessages(LONG_PRESS);
            //mHandler.removeMessages(TAP);
            //mIsDoubleTapping = false;
            //mAlwaysInTapRegion = false;
            //mAlwaysInBiggerTapRegion = false;
            //if (mInLongPress) {
                //mInLongPress = false;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.771 -0400", hash_original_method = "EA18A75BD47C1C65D8FE280884C192C1", hash_generated_method = "C3C2803CE0DB148FFAD82824ED5B4135")
        private boolean isConsideredDoubleTap(MotionEvent firstDown, MotionEvent firstUp,
                MotionEvent secondDown) {
            {
                boolean var73F91814DB9D5A64CDE1CE000FCE8D73_1285947965 = (secondDown.getEventTime() - firstUp.getEventTime() > DOUBLE_TAP_TIMEOUT);
            } //End collapsed parenthetic
            int deltaX;
            deltaX = (int) firstDown.getX() - (int) secondDown.getX();
            int deltaY;
            deltaY = (int) firstDown.getY() - (int) secondDown.getY();
            addTaint(firstDown.getTaint());
            addTaint(firstUp.getTaint());
            addTaint(secondDown.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_193670211 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_193670211;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.771 -0400", hash_original_method = "1B110E72A2C7F37DAF94A595462A9E07", hash_generated_method = "E2D9F2F38B3AC8E6DE4DCDABAEFB8284")
        private void dispatchLongPress() {
            mHandler.removeMessages(TAP);
            mInLongPress = true;
            mListener.onLongPress(mCurrentDownEvent);
            // ---------- Original Method ----------
            //mHandler.removeMessages(TAP);
            //mInLongPress = true;
            //mListener.onLongPress(mCurrentDownEvent);
        }

        
        private class GestureHandler extends Handler {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.772 -0400", hash_original_method = "9D2431BB2A48CA4B74BDD0A31919D26A", hash_generated_method = "09E7D20AAEDBA7AC640E49A4D07867CB")
              GestureHandler() {
                super();
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.772 -0400", hash_original_method = "EA154705C095D614E912EA5301C442EC", hash_generated_method = "D0CC6BB0FEB77AE76A15A155A193F978")
              GestureHandler(Handler handler) {
                super(handler.getLooper());
                addTaint(handler.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.784 -0400", hash_original_method = "B97857986444DBB6880EA006296E5D03", hash_generated_method = "537A4AE5BD77A7C590A6DD7496540AFB")
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


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.785 -0400", hash_original_field = "03946F945DD14FD038A89AC23E3E9895", hash_generated_field = "23859687DCFAB2920448F0666C34AE3F")

        private static int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.785 -0400", hash_original_field = "B24987AF4907B1BB2A2C1D179ED1D635", hash_generated_field = "29F80184A37A49D7E188FEBFEFC45873")

        private static int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.785 -0400", hash_original_field = "9DCE62A9F6416FD8B994A292FCC9AAB4", hash_generated_field = "43BDC469F99C53750121E32DE491F2BA")

        private static int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.785 -0400", hash_original_field = "E22475CBEA33A5A68FC84638428B5337", hash_generated_field = "71465BCFEE7966A83A058BF8342E9D65")

        private static int SHOW_PRESS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.785 -0400", hash_original_field = "670F1D0405D600D5CFE141808EED72C3", hash_generated_field = "B3A011834A0D2368F93791E1BFB6376D")

        private static int LONG_PRESS = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.785 -0400", hash_original_field = "D41478F8B08A98FC4EA27BF540E635F4", hash_generated_field = "B5FA5D4A37CA227EFE09D1B600B31533")

        private static int TAP = 3;
    }


    
    static class GestureDetectorCompatImplJellybeanMr1 implements GestureDetectorCompatImpl {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.785 -0400", hash_original_field = "2F4D9480029274787361640D977A81EA", hash_generated_field = "8B30959A4950AA59520C53890F5984A0")

        private GestureDetector mDetector;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.787 -0400", hash_original_method = "453DBA8B82FD89E1ED6E34F9267E5C80", hash_generated_method = "F7242A020153226A8811B61C41ED1698")
        public  GestureDetectorCompatImplJellybeanMr1(Context context, OnGestureListener listener,
                Handler handler) {
            mDetector = new GestureDetector(context, listener, handler);
            // ---------- Original Method ----------
            //mDetector = new GestureDetector(context, listener, handler);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.787 -0400", hash_original_method = "C6DA455D1425086DAAE3C8639C3C0151", hash_generated_method = "D2B34466E533CC3BE3038531E414982E")
        @Override
        public boolean isLongpressEnabled() {
            boolean varC7A6FD53A2FE117BB42375C28B187294_1873255038 = (mDetector.isLongpressEnabled());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_623951548 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_623951548;
            // ---------- Original Method ----------
            //return mDetector.isLongpressEnabled();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.788 -0400", hash_original_method = "0BFF4D0A3E0D6157B437BC7769F18803", hash_generated_method = "E0EF6EF097B1C199693C64A9B9862924")
        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean var2C7A1C4D87E21F669BDCAF9E47A4FB93_373874128 = (mDetector.onTouchEvent(ev));
            addTaint(ev.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1816591735 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1816591735;
            // ---------- Original Method ----------
            //return mDetector.onTouchEvent(ev);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.791 -0400", hash_original_method = "92328785FD6CF04FF7703DA61DF843FA", hash_generated_method = "93654A83AD2DAF6A7DB6510547ECD44B")
        @Override
        public void setIsLongpressEnabled(boolean enabled) {
            mDetector.setIsLongpressEnabled(enabled);
            addTaint(enabled);
            // ---------- Original Method ----------
            //mDetector.setIsLongpressEnabled(enabled);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:35.792 -0400", hash_original_method = "72DDE049C40CEE402301FF3EA4500F5A", hash_generated_method = "C1E173E9DF7667DBBBCDAB3ECD61B016")
        @Override
        public void setOnDoubleTapListener(OnDoubleTapListener listener) {
            mDetector.setOnDoubleTapListener(listener);
            addTaint(listener.getTaint());
            // ---------- Original Method ----------
            //mDetector.setOnDoubleTapListener(listener);
        }

        
    }


    
    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();
        boolean onTouchEvent(MotionEvent ev);
        void setIsLongpressEnabled(boolean enabled);
        void setOnDoubleTapListener(OnDoubleTapListener listener);
    }
    
}

