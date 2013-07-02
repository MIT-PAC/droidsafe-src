package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.155 -0400", hash_original_field = "8A971C38A16E50B1D10173CD1CAC2884", hash_generated_field = "036BBE30701EEA23262187CD19803D9D")

    private GestureDetectorCompatImpl mImpl;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.157 -0400", hash_original_method = "B489A839D159E7FF17B94DE4C6548B8A", hash_generated_method = "53B4E27B76558B320B313EC2FB1B522C")
    public  GestureDetectorCompat(Context context, OnGestureListener listener) {
        this(context, listener, null);
        addTaint(context.getTaint());
        addTaint(listener.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.162 -0400", hash_original_method = "A4BEFD368B129408AD26BDC86C73C812", hash_generated_method = "DD29205824458BCD9DB5142A87533F41")
    public  GestureDetectorCompat(Context context, OnGestureListener listener, Handler handler) {
        {
            mImpl = new GestureDetectorCompatImplJellybeanMr1(context, listener, handler);
        } 
        {
            mImpl = new GestureDetectorCompatImplBase(context, listener, handler);
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.163 -0400", hash_original_method = "A561314D3C1B1E75D0698E5F7C49EB6E", hash_generated_method = "AE5C5429EB26720C79F52E8F6A46A416")
    public boolean isLongpressEnabled() {
        boolean var0BEF5417CDEB169CC14E120F1EE7972F_567561356 = (mImpl.isLongpressEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776243876 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776243876;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.165 -0400", hash_original_method = "8AC0D1224703F0491B06EEE77D787E6B", hash_generated_method = "B33F4EAB94852F8ECA773AF74E4CB3FD")
    public boolean onTouchEvent(MotionEvent event) {
        
        boolean var9C758E14F312F02586E0C16D04CB1BF5_1034205575 = (mImpl.onTouchEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576137056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576137056;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.166 -0400", hash_original_method = "CE9D16700D0FD12C9940AF8D170F6A2B", hash_generated_method = "A14D6ABA198247FCF8ED25F9F4B3AC0B")
    public void setIsLongpressEnabled(boolean enabled) {
        mImpl.setIsLongpressEnabled(enabled);
        addTaint(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.167 -0400", hash_original_method = "6AF653381945FBFC7EE8133ECEAFFC6B", hash_generated_method = "E3FA0BCCB4B34F46D73BD81D6D88D256")
    public void setOnDoubleTapListener(OnDoubleTapListener listener) {
        mImpl.setOnDoubleTapListener(listener);
        addTaint(listener.getTaint());
        
        
    }

    
    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.168 -0400", hash_original_field = "46ABC6D9AB45AE8835C53F4C51724A79", hash_generated_field = "5E5708EA89972028E86242DA050969CA")

        private int mTouchSlopSquare;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.169 -0400", hash_original_field = "2C56C8DD2FA1BBC384FAD39727EC1B9F", hash_generated_field = "6A78E5989D06DA4C68BA85646B379C51")

        private int mDoubleTapSlopSquare;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.169 -0400", hash_original_field = "950A8222B535BF5159B013E5329A56C7", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

        private int mMinimumFlingVelocity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.170 -0400", hash_original_field = "8ED13B950D5803064219CE68BB8F2695", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

        private int mMaximumFlingVelocity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.170 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.171 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "0F48D0A94630E1FBE9C08A845F9730F2")

        private OnGestureListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.171 -0400", hash_original_field = "87FD92A1DBA4F7CE0B58869B5E226B45", hash_generated_field = "6BFE5EA6164149F540DE4277F8AF3864")

        private OnDoubleTapListener mDoubleTapListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.172 -0400", hash_original_field = "2257E716ABB69174128002B6500326E5", hash_generated_field = "09EA51D062ED44D2275BC8E7A65061C0")

        private boolean mStillDown;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.172 -0400", hash_original_field = "6B06472FC4D3499D4338C0A5A44E3AE4", hash_generated_field = "8FA7640B36D34A443E3A43478682F7F9")

        private boolean mInLongPress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.173 -0400", hash_original_field = "3685FD4DDDDB8177ACFC47DF2506B51F", hash_generated_field = "54A847320ACF73ACDAB1D622D38FE146")

        private boolean mAlwaysInTapRegion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.173 -0400", hash_original_field = "32C87B3E60E7CC081197EE23FE48470B", hash_generated_field = "05F405D52B0F8BE7180D2A6B8335B30C")

        private boolean mAlwaysInBiggerTapRegion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.174 -0400", hash_original_field = "2B841E5864AD9D17F0AEB812951699B4", hash_generated_field = "CAFEE339D8B144D23812ECC71639FEB7")

        private MotionEvent mCurrentDownEvent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.174 -0400", hash_original_field = "FE83D903AD347CA461A9D70C5013239C", hash_generated_field = "2C9915BC9FEEE919EC1B54BA44C7E08E")

        private MotionEvent mPreviousUpEvent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.180 -0400", hash_original_field = "D9B3FFE15EA3AF586B7723E852022824", hash_generated_field = "36A2227955369181C5427F8675061A2C")

        private boolean mIsDoubleTapping;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.180 -0400", hash_original_field = "2B2AC44A2F75B6ED3B28F2B692DC3C05", hash_generated_field = "84CD91C09EAD7174CCB4F3B9EA5CBA95")

        private float mLastFocusX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.181 -0400", hash_original_field = "5F5A7667C22475DFB1630E34528BF0F0", hash_generated_field = "6298DB9E92040E49B36F3F9306873EF7")

        private float mLastFocusY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.181 -0400", hash_original_field = "F1C23FB2305DF7E5137E0C374E9E5205", hash_generated_field = "242E37A6A8338FD7A04B05F9B165C2FE")

        private float mDownFocusX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.182 -0400", hash_original_field = "0939244D969F8AE1C483899F5BA3B363", hash_generated_field = "99DEED00E0728B6FC9DC02081D4D5B0F")

        private float mDownFocusY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.182 -0400", hash_original_field = "AC0E18C364C0753415CC5A3B2FB177AA", hash_generated_field = "A200AEA4E8786AAB09346E7991B4CE6C")

        private boolean mIsLongpressEnabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.183 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

        private VelocityTracker mVelocityTracker;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.186 -0400", hash_original_method = "0E44C690339E9DC4060FF288C9A50E58", hash_generated_method = "7AA78AC212C75AE932AFD3A51C78CE4A")
        public  GestureDetectorCompatImplBase(Context context, OnGestureListener listener,
                Handler handler) {
            {
                mHandler = new GestureHandler(handler);
            } 
            {
                mHandler = new GestureHandler();
            } 
            mListener = listener;
            {
                setOnDoubleTapListener((OnDoubleTapListener) listener);
            } 
            init(context);
            addTaint(context.getTaint());
            
            
                
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.200 -0400", hash_original_method = "74A2F376400AF2C150D1C52FC35C5FC0", hash_generated_method = "72DC17E95047C750090BEAFE007368C3")
        private void init(Context context) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Context must not be null");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("OnGestureListener must not be null");
            } 
            mIsLongpressEnabled = true;
            final ViewConfiguration configuration = ViewConfiguration.get(context);
            final int touchSlop = configuration.getScaledTouchSlop();
            final int doubleTapSlop = configuration.getScaledDoubleTapSlop();
            mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
            mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
            mTouchSlopSquare = touchSlop * touchSlop;
            mDoubleTapSlopSquare = doubleTapSlop * doubleTapSlop;
            addTaint(context.getTaint());
            
            
                
            
            
                
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.202 -0400", hash_original_method = "571B39F87736E3994F3A317209D7E1C6", hash_generated_method = "8874C66605DB2FF6FE5F0E858C5BB080")
        public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            mDoubleTapListener = onDoubleTapListener;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.204 -0400", hash_original_method = "14829325F18703625EF98BC2472601E3", hash_generated_method = "0B13C9500814A87A70F39F82D929A9E5")
        public void setIsLongpressEnabled(boolean isLongpressEnabled) {
            mIsLongpressEnabled = isLongpressEnabled;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.205 -0400", hash_original_method = "880D3BB55D8069819877BA46CC6F055B", hash_generated_method = "B2607F28B20D82F2A9738AAC121EBDF9")
        public boolean isLongpressEnabled() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_107911759 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_107911759;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.241 -0400", hash_original_method = "E5CE0E5B73A1CCAF484886A860A0FDAD", hash_generated_method = "B6366DE007FBC212C632E0D52B1AD244")
        public boolean onTouchEvent(MotionEvent ev) {
            
            final int action = ev.getAction();
            {
                mVelocityTracker = VelocityTracker.obtain();
            } 
            mVelocityTracker.addMovement(ev);
            final boolean pointerUp = (action & MotionEventCompat.ACTION_MASK) == MotionEventCompat.ACTION_POINTER_UP;
            int skipIndex;
            skipIndex = MotionEventCompat.getActionIndex(ev);
            skipIndex = -1;
            float sumX = 0;
            float sumY = 0;
            final int count = MotionEventCompat.getPointerCount(ev);
            {
                int i = 0;
                {
                    sumX += MotionEventCompat.getX(ev, i);
                    sumY += MotionEventCompat.getY(ev, i);
                } 
            } 
            int div;
            div = count - 1;
            div = count;
            final float focusX = sumX / div;
            final float focusY = sumY / div;
            boolean handled = false;
            
            mDownFocusX = mLastFocusX = focusX;
            
            
            mDownFocusY = mLastFocusY = focusY;
            
            
            cancelTaps();
            
            
            mDownFocusX = mLastFocusX = focusX;
            
            
            mDownFocusY = mLastFocusY = focusY;
            
            
            mVelocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
            
            
            final int upIndex = MotionEventCompat.getActionIndex(ev);
            
            
            final int id1 = MotionEventCompat.getPointerId(ev, upIndex);
            
            
            final float x1 = VelocityTrackerCompat.getXVelocity(mVelocityTracker, id1);
            
            
            final float y1 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, id1);
            
            
            {
                int i = 0;
                {
                    final int id2 = MotionEventCompat.getPointerId(ev, i);
                    final float x = x1 * VelocityTrackerCompat.getXVelocity(mVelocityTracker, id2);
                    final float y = y1 * VelocityTrackerCompat.getYVelocity(mVelocityTracker, id2);
                    final float dot = x + y;
                    {
                        mVelocityTracker.clear();
                    } 
                } 
            } 
            
            
            {
                boolean hadTapMessage = mHandler.hasMessages(TAP);
                mHandler.removeMessages(TAP);
                {
                    boolean varAB9460F3922422F2E61BC8B2D2ED2BB2_451138278 = ((mCurrentDownEvent != null) && (mPreviousUpEvent != null) && hadTapMessage &&
                            isConsideredDoubleTap(mCurrentDownEvent, mPreviousUpEvent, ev));
                    {
                        mIsDoubleTapping = true;
                        handled |= mDoubleTapListener.onDoubleTap(mCurrentDownEvent);
                        handled |= mDoubleTapListener.onDoubleTapEvent(ev);
                    } 
                    {
                        mHandler.sendEmptyMessageDelayed(TAP, DOUBLE_TAP_TIMEOUT);
                    } 
                } 
            } 
            
            
            mDownFocusX = mLastFocusX = focusX;
            
            
            mDownFocusY = mLastFocusY = focusY;
            
            
            {
                mCurrentDownEvent.recycle();
            } 
            
            
            mCurrentDownEvent = MotionEvent.obtain(ev);
            
            
            mAlwaysInTapRegion = true;
            
            
            mAlwaysInBiggerTapRegion = true;
            
            
            mStillDown = true;
            
            
            mInLongPress = false;
            
            
            {
                mHandler.removeMessages(LONG_PRESS);
                mHandler.sendEmptyMessageAtTime(LONG_PRESS, mCurrentDownEvent.getDownTime()
                            + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
            } 
            
            
            mHandler.sendEmptyMessageAtTime(SHOW_PRESS, mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
            
            
            handled |= mListener.onDown(ev);
            
            
            final float scrollX = mLastFocusX - focusX;
            
            
            final float scrollY = mLastFocusY - focusY;
            
            
            {
                handled |= mDoubleTapListener.onDoubleTapEvent(ev);
            } 
            {
                final int deltaX = (int) (focusX - mDownFocusX);
                final int deltaY = (int) (focusY - mDownFocusY);
                int distance = (deltaX * deltaX) + (deltaY * deltaY);
                {
                    handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
                    mLastFocusX = focusX;
                    mLastFocusY = focusY;
                    mAlwaysInTapRegion = false;
                    mHandler.removeMessages(TAP);
                    mHandler.removeMessages(SHOW_PRESS);
                    mHandler.removeMessages(LONG_PRESS);
                } 
                {
                    mAlwaysInBiggerTapRegion = false;
                } 
            } 
            {
                boolean var062DA6E8E5DB27C44E82800836A491BB_1194845385 = ((Math.abs(scrollX) >= 1) || (Math.abs(scrollY) >= 1));
                {
                    handled = mListener.onScroll(mCurrentDownEvent, ev, scrollX, scrollY);
                    mLastFocusX = focusX;
                    mLastFocusY = focusY;
                } 
            } 
            
            
            mStillDown = false;
            
            
            MotionEvent currentUpEvent = MotionEvent.obtain(ev);
            
            
            {
                handled |= mDoubleTapListener.onDoubleTapEvent(ev);
            } 
            {
                mHandler.removeMessages(TAP);
                mInLongPress = false;
            } 
            {
                handled = mListener.onSingleTapUp(ev);
            } 
            {
                final VelocityTracker velocityTracker = mVelocityTracker;
                final int pointerId = MotionEventCompat.getPointerId(ev, 0);
                velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
                final float velocityY = VelocityTrackerCompat.getYVelocity(
                            velocityTracker, pointerId);
                final float velocityX = VelocityTrackerCompat.getXVelocity(
                            velocityTracker, pointerId);
                {
                    boolean varDA5A7959D5D6091F3A3480A64BCAEEAB_230807058 = ((Math.abs(velocityY) > mMinimumFlingVelocity)
                            || (Math.abs(velocityX) > mMinimumFlingVelocity));
                    {
                        handled = mListener.onFling(mCurrentDownEvent, ev, velocityX, velocityY);
                    } 
                } 
            } 
            
            
            {
                mPreviousUpEvent.recycle();
            } 
            
            
            mPreviousUpEvent = currentUpEvent;
            
            
            {
                mVelocityTracker.recycle();
                mVelocityTracker = null;
            } 
            
            
            mIsDoubleTapping = false;
            
            
            mHandler.removeMessages(SHOW_PRESS);
            
            
            mHandler.removeMessages(LONG_PRESS);
            
            
            cancel();
            
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1129038754 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1129038754;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.252 -0400", hash_original_method = "9B9F1964085C6E9CB79BA6CBFD2B9081", hash_generated_method = "3CC86CBA62883A58172AA842C711B3EC")
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
            } 
            
            
            
            
            
            
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.257 -0400", hash_original_method = "9E2FBC03F0AF2C678887C1E5B2B3FD14", hash_generated_method = "1CC4916739820E85C7CD9F295FEA01A0")
        private void cancelTaps() {
            mHandler.removeMessages(SHOW_PRESS);
            mHandler.removeMessages(LONG_PRESS);
            mHandler.removeMessages(TAP);
            mIsDoubleTapping = false;
            mAlwaysInTapRegion = false;
            mAlwaysInBiggerTapRegion = false;
            {
                mInLongPress = false;
            } 
            
            
            
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.261 -0400", hash_original_method = "EA18A75BD47C1C65D8FE280884C192C1", hash_generated_method = "1BEFC320A082CD13D6CC2F1705DBEC4C")
        private boolean isConsideredDoubleTap(MotionEvent firstDown, MotionEvent firstUp,
                MotionEvent secondDown) {
            {
                boolean var73F91814DB9D5A64CDE1CE000FCE8D73_1422392397 = (secondDown.getEventTime() - firstUp.getEventTime() > DOUBLE_TAP_TIMEOUT);
            } 
            int deltaX = (int) firstDown.getX() - (int) secondDown.getX();
            int deltaY = (int) firstDown.getY() - (int) secondDown.getY();
            addTaint(firstDown.getTaint());
            addTaint(firstUp.getTaint());
            addTaint(secondDown.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_27350406 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_27350406;
            
            
                
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.263 -0400", hash_original_method = "1B110E72A2C7F37DAF94A595462A9E07", hash_generated_method = "E2D9F2F38B3AC8E6DE4DCDABAEFB8284")
        private void dispatchLongPress() {
            mHandler.removeMessages(TAP);
            mInLongPress = true;
            mListener.onLongPress(mCurrentDownEvent);
            
            
            
            
        }

        
        private class GestureHandler extends Handler {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.264 -0400", hash_original_method = "9D2431BB2A48CA4B74BDD0A31919D26A", hash_generated_method = "09E7D20AAEDBA7AC640E49A4D07867CB")
              GestureHandler() {
                super();
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.265 -0400", hash_original_method = "EA154705C095D614E912EA5301C442EC", hash_generated_method = "D0CC6BB0FEB77AE76A15A155A193F978")
              GestureHandler(Handler handler) {
                super(handler.getLooper());
                addTaint(handler.getTaint());
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.266 -0400", hash_original_method = "B97857986444DBB6880EA006296E5D03", hash_generated_method = "537A4AE5BD77A7C590A6DD7496540AFB")
            @Override
            public void handleMessage(Message msg) {
                
                mListener.onShowPress(mCurrentDownEvent);
                
                
                dispatchLongPress();
                
                
                {
                    mDoubleTapListener.onSingleTapConfirmed(mCurrentDownEvent);
                } 
                
                
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown message " + msg);
                
                addTaint(msg.getTaint());
                
                
                
                    
                    
                
                    
                    
                
                    
                        
                    
                    
                
                    
                
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.268 -0400", hash_original_field = "03946F945DD14FD038A89AC23E3E9895", hash_generated_field = "A0C74D07DE33813B70581123FF749A35")

        private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.268 -0400", hash_original_field = "B24987AF4907B1BB2A2C1D179ED1D635", hash_generated_field = "B2C557FED0C410FD936C94D9C495E66C")

        private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.269 -0400", hash_original_field = "9DCE62A9F6416FD8B994A292FCC9AAB4", hash_generated_field = "AF4DBB13E8C6A9BFDCE110BEA6959177")

        private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.269 -0400", hash_original_field = "E22475CBEA33A5A68FC84638428B5337", hash_generated_field = "3EDD79F644F06511146F8C3326C425D3")

        private static final int SHOW_PRESS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.270 -0400", hash_original_field = "670F1D0405D600D5CFE141808EED72C3", hash_generated_field = "4E989C39F54DC49F53402A764DC21A3E")

        private static final int LONG_PRESS = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.270 -0400", hash_original_field = "D41478F8B08A98FC4EA27BF540E635F4", hash_generated_field = "5FB95885301BF4A2A2BE1CAC2FC68081")

        private static final int TAP = 3;
    }


    
    static class GestureDetectorCompatImplJellybeanMr1 implements GestureDetectorCompatImpl {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.271 -0400", hash_original_field = "2F4D9480029274787361640D977A81EA", hash_generated_field = "8B30959A4950AA59520C53890F5984A0")

        private GestureDetector mDetector;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.272 -0400", hash_original_method = "453DBA8B82FD89E1ED6E34F9267E5C80", hash_generated_method = "F7242A020153226A8811B61C41ED1698")
        public  GestureDetectorCompatImplJellybeanMr1(Context context, OnGestureListener listener,
                Handler handler) {
            mDetector = new GestureDetector(context, listener, handler);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.274 -0400", hash_original_method = "C6DA455D1425086DAAE3C8639C3C0151", hash_generated_method = "69A81235D184A5772FC27608BF9BA240")
        @Override
        public boolean isLongpressEnabled() {
            boolean varC7A6FD53A2FE117BB42375C28B187294_1608789624 = (mDetector.isLongpressEnabled());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788310665 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788310665;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.275 -0400", hash_original_method = "0BFF4D0A3E0D6157B437BC7769F18803", hash_generated_method = "97D31C725E9491F2084761E9EC5BB6CF")
        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            
            boolean var2C7A1C4D87E21F669BDCAF9E47A4FB93_2137501005 = (mDetector.onTouchEvent(ev));
            addTaint(ev.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1173269167 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1173269167;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.280 -0400", hash_original_method = "92328785FD6CF04FF7703DA61DF843FA", hash_generated_method = "93654A83AD2DAF6A7DB6510547ECD44B")
        @Override
        public void setIsLongpressEnabled(boolean enabled) {
            mDetector.setIsLongpressEnabled(enabled);
            addTaint(enabled);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.281 -0400", hash_original_method = "72DDE049C40CEE402301FF3EA4500F5A", hash_generated_method = "C1E173E9DF7667DBBBCDAB3ECD61B016")
        @Override
        public void setOnDoubleTapListener(OnDoubleTapListener listener) {
            mDetector.setOnDoubleTapListener(listener);
            addTaint(listener.getTaint());
            
            
        }

        
    }


    
    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();
        boolean onTouchEvent(MotionEvent ev);
        void setIsLongpressEnabled(boolean enabled);
        void setOnDoubleTapListener(OnDoubleTapListener listener);
    }
    
}

