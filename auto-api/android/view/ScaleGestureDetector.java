package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;

public class ScaleGestureDetector {
    private Context mContext;
    private OnScaleGestureListener mListener;
    private boolean mGestureInProgress;
    private MotionEvent mPrevEvent;
    private MotionEvent mCurrEvent;
    private float mFocusX;
    private float mFocusY;
    private float mPrevFingerDiffX;
    private float mPrevFingerDiffY;
    private float mCurrFingerDiffX;
    private float mCurrFingerDiffY;
    private float mCurrLen;
    private float mPrevLen;
    private float mScaleFactor;
    private float mCurrPressure;
    private float mPrevPressure;
    private long mTimeDelta;
    private float mEdgeSlop;
    private float mRightSlopEdge;
    private float mBottomSlopEdge;
    private boolean mSloppyGesture;
    private boolean mInvalidGesture;
    private int mActiveId0;
    private int mActiveId1;
    private boolean mActive0MostRecent;
    private InputEventConsistencyVerifier mInputEventConsistencyVerifier =
            InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.278 -0400", hash_original_method = "3F765CE5C3F1587A362200597A84993F", hash_generated_method = "90E2F59DB9B2155C6BAAA9831167E555")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScaleGestureDetector(Context context, OnScaleGestureListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        ViewConfiguration config;
        config = ViewConfiguration.get(context);
        mEdgeSlop = config.getScaledEdgeSlop();
        // ---------- Original Method ----------
        //ViewConfiguration config = ViewConfiguration.get(context);
        //mContext = context;
        //mListener = listener;
        //mEdgeSlop = config.getScaledEdgeSlop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.282 -0400", hash_original_method = "3D0907AC17DE553CA8E37D6A8A0F580A", hash_generated_method = "1081F936FABABA0B1836A1EF3942F06A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        } //End block
        int action;
        action = event.getActionMasked();
        {
            reset();
        } //End block
        boolean handled;
        handled = true;
        {
            handled = false;
        } //End block
        {
            //Begin case MotionEvent.ACTION_DOWN 
            {
                mActiveId0 = event.getPointerId(0);
                mActive0MostRecent = true;
            } //End block
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_UP 
            reset();
            //End case MotionEvent.ACTION_UP 
            //Begin case MotionEvent.ACTION_POINTER_DOWN 
            {
                DisplayMetrics metrics;
                metrics = mContext.getResources().getDisplayMetrics();
                mRightSlopEdge = metrics.widthPixels - mEdgeSlop;
                mBottomSlopEdge = metrics.heightPixels - mEdgeSlop;
                mPrevEvent.recycle();
                mPrevEvent = MotionEvent.obtain(event);
                mTimeDelta = 0;
                int index1;
                index1 = event.getActionIndex();
                int index0;
                index0 = event.findPointerIndex(mActiveId0);
                mActiveId1 = event.getPointerId(index1);
                {
                    index0 = findNewActiveIndex(event, index0 == index1 ? -1 : mActiveId1, index0);
                    mActiveId0 = event.getPointerId(index0);
                } //End block
                mActive0MostRecent = false;
                setContext(event);
                float edgeSlop;
                edgeSlop = mEdgeSlop;
                float rightSlop;
                rightSlop = mRightSlopEdge;
                float bottomSlop;
                bottomSlop = mBottomSlopEdge;
                float x0;
                x0 = getRawX(event, index0);
                float y0;
                y0 = getRawY(event, index0);
                float x1;
                x1 = getRawX(event, index1);
                float y1;
                y1 = getRawY(event, index1);
                boolean p0sloppy;
                p0sloppy = x0 < edgeSlop || y0 < edgeSlop
                        || x0 > rightSlop || y0 > bottomSlop;
                boolean p1sloppy;
                p1sloppy = x1 < edgeSlop || y1 < edgeSlop
                        || x1 > rightSlop || y1 > bottomSlop;
                {
                    mFocusX = -1;
                    mFocusY = -1;
                    mSloppyGesture = true;
                } //End block
                {
                    mFocusX = event.getX(index1);
                    mFocusY = event.getY(index1);
                    mSloppyGesture = true;
                } //End block
                {
                    mFocusX = event.getX(index0);
                    mFocusY = event.getY(index0);
                    mSloppyGesture = true;
                } //End block
                {
                    mSloppyGesture = false;
                    mGestureInProgress = mListener.onScaleBegin(this);
                } //End block
            } //End block
            //End case MotionEvent.ACTION_POINTER_DOWN 
            //Begin case MotionEvent.ACTION_MOVE 
            {
                float edgeSlop;
                edgeSlop = mEdgeSlop;
                float rightSlop;
                rightSlop = mRightSlopEdge;
                float bottomSlop;
                bottomSlop = mBottomSlopEdge;
                int index0;
                index0 = event.findPointerIndex(mActiveId0);
                int index1;
                index1 = event.findPointerIndex(mActiveId1);
                float x0;
                x0 = getRawX(event, index0);
                float y0;
                y0 = getRawY(event, index0);
                float x1;
                x1 = getRawX(event, index1);
                float y1;
                y1 = getRawY(event, index1);
                boolean p0sloppy;
                p0sloppy = x0 < edgeSlop || y0 < edgeSlop
                            || x0 > rightSlop || y0 > bottomSlop;
                boolean p1sloppy;
                p1sloppy = x1 < edgeSlop || y1 < edgeSlop
                            || x1 > rightSlop || y1 > bottomSlop;
                {
                    int index;
                    index = findNewActiveIndex(event, mActiveId1, index0);
                    {
                        index0 = index;
                        mActiveId0 = event.getPointerId(index);
                        x0 = getRawX(event, index);
                        y0 = getRawY(event, index);
                        p0sloppy = false;
                    } //End block
                } //End block
                {
                    int index;
                    index = findNewActiveIndex(event, mActiveId0, index1);
                    {
                        index1 = index;
                        mActiveId1 = event.getPointerId(index);
                        x1 = getRawX(event, index);
                        y1 = getRawY(event, index);
                        p1sloppy = false;
                    } //End block
                } //End block
                {
                    mFocusX = -1;
                    mFocusY = -1;
                } //End block
                {
                    mFocusX = event.getX(index1);
                    mFocusY = event.getY(index1);
                } //End block
                {
                    mFocusX = event.getX(index0);
                    mFocusY = event.getY(index0);
                } //End block
                {
                    mSloppyGesture = false;
                    mGestureInProgress = mListener.onScaleBegin(this);
                } //End block
            } //End block
            //End case MotionEvent.ACTION_MOVE 
            //Begin case MotionEvent.ACTION_POINTER_UP 
            {
                int pointerCount;
                pointerCount = event.getPointerCount();
                int actionIndex;
                actionIndex = event.getActionIndex();
                int actionId;
                actionId = event.getPointerId(actionIndex);
                {
                    {
                        int newIndex;
                        newIndex = findNewActiveIndex(event, mActiveId1, actionIndex);
                        mActiveId0 = event.getPointerId(newIndex);
                    } //End block
                    {
                        int newIndex;
                        newIndex = findNewActiveIndex(event, mActiveId0, actionIndex);
                        mActiveId1 = event.getPointerId(newIndex);
                    } //End block
                } //End block
                {
                    int index;
                    index = event.findPointerIndex(actionId == mActiveId0 ?
                                mActiveId1 : mActiveId0);//DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        mInvalidGesture = true;
                        {
                            mListener.onScaleEnd(this);
                        } //End block
                    } //End block
                    mActiveId0 = event.getPointerId(index);
                    mActive0MostRecent = true;
                    mActiveId1 = -1;
                    mFocusX = event.getX(index);
                    mFocusY = event.getY(index);
                } //End block
            } //End block
            //End case MotionEvent.ACTION_POINTER_UP 
        } //End block
        {
            //Begin case MotionEvent.ACTION_POINTER_DOWN 
            {
                mListener.onScaleEnd(this);
                int oldActive0;
                oldActive0 = mActiveId0;
                int oldActive1;
                oldActive1 = mActiveId1;
                reset();
                mPrevEvent = MotionEvent.obtain(event);
                mActiveId0 = mActive0MostRecent ? oldActive0 : oldActive1;
                mActiveId1 = event.getPointerId(event.getActionIndex());
                mActive0MostRecent = false;
                int index0;
                index0 = event.findPointerIndex(mActiveId0);
                {
                    index0 = findNewActiveIndex(event,
                                mActiveId0 == mActiveId1 ? -1 : mActiveId1, index0);
                    mActiveId0 = event.getPointerId(index0);
                } //End block
                setContext(event);
                mGestureInProgress = mListener.onScaleBegin(this);
            } //End block
            //End case MotionEvent.ACTION_POINTER_DOWN 
            //Begin case MotionEvent.ACTION_POINTER_UP 
            {
                int pointerCount;
                pointerCount = event.getPointerCount();
                int actionIndex;
                actionIndex = event.getActionIndex();
                int actionId;
                actionId = event.getPointerId(actionIndex);
                boolean gestureEnded;
                gestureEnded = false;
                {
                    {
                        int newIndex;
                        newIndex = findNewActiveIndex(event, mActiveId1, actionIndex);
                        {
                            mListener.onScaleEnd(this);
                            mActiveId0 = event.getPointerId(newIndex);
                            mActive0MostRecent = true;
                            mPrevEvent = MotionEvent.obtain(event);
                            setContext(event);
                            mGestureInProgress = mListener.onScaleBegin(this);
                        } //End block
                        {
                            gestureEnded = true;
                        } //End block
                    } //End block
                    {
                        int newIndex;
                        newIndex = findNewActiveIndex(event, mActiveId0, actionIndex);
                        {
                            mListener.onScaleEnd(this);
                            mActiveId1 = event.getPointerId(newIndex);
                            mActive0MostRecent = false;
                            mPrevEvent = MotionEvent.obtain(event);
                            setContext(event);
                            mGestureInProgress = mListener.onScaleBegin(this);
                        } //End block
                        {
                            gestureEnded = true;
                        } //End block
                    } //End block
                    mPrevEvent.recycle();
                    mPrevEvent = MotionEvent.obtain(event);
                    setContext(event);
                } //End block
                {
                    gestureEnded = true;
                } //End block
                {
                    setContext(event);
                    int activeId;
                    activeId = mActiveId1;
                    activeId = mActiveId0;
                    int index;
                    index = event.findPointerIndex(activeId);
                    mFocusX = event.getX(index);
                    mFocusY = event.getY(index);
                    mListener.onScaleEnd(this);
                    reset();
                    mActiveId0 = activeId;
                    mActive0MostRecent = true;
                } //End block
            } //End block
            //End case MotionEvent.ACTION_POINTER_UP 
            //Begin case MotionEvent.ACTION_CANCEL 
            mListener.onScaleEnd(this);
            //End case MotionEvent.ACTION_CANCEL 
            //Begin case MotionEvent.ACTION_CANCEL 
            reset();
            //End case MotionEvent.ACTION_CANCEL 
            //Begin case MotionEvent.ACTION_UP 
            reset();
            //End case MotionEvent.ACTION_UP 
            //Begin case MotionEvent.ACTION_MOVE 
            {
                setContext(event);
                {
                    boolean updatePrevious;
                    updatePrevious = mListener.onScale(this);
                    {
                        mPrevEvent.recycle();
                        mPrevEvent = MotionEvent.obtain(event);
                    } //End block
                } //End block
            } //End block
            //End case MotionEvent.ACTION_MOVE 
        } //End block
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.283 -0400", hash_original_method = "26EE043A8FDD34A9021E8F106FD508B5", hash_generated_method = "7BC7DA53FDD6D37BBBDC0479A40FEFCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int findNewActiveIndex(MotionEvent ev, int otherActiveId, int oldIndex) {
        dsTaint.addTaint(otherActiveId);
        dsTaint.addTaint(oldIndex);
        dsTaint.addTaint(ev.dsTaint);
        int pointerCount;
        pointerCount = ev.getPointerCount();
        int otherActiveIndex;
        otherActiveIndex = ev.findPointerIndex(otherActiveId);
        int newActiveIndex;
        newActiveIndex = -1;
        {
            int i;
            i = 0;
            {
                {
                    float edgeSlop;
                    edgeSlop = mEdgeSlop;
                    float rightSlop;
                    rightSlop = mRightSlopEdge;
                    float bottomSlop;
                    bottomSlop = mBottomSlopEdge;
                    float x;
                    x = getRawX(ev, i);
                    float y;
                    y = getRawY(ev, i);
                    {
                        newActiveIndex = i;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int pointerCount = ev.getPointerCount();
        //final int otherActiveIndex = ev.findPointerIndex(otherActiveId);
        //int newActiveIndex = -1;
        //for (int i = 0; i < pointerCount; i++) {
            //if (i != oldIndex && i != otherActiveIndex) {
                //final float edgeSlop = mEdgeSlop;
                //final float rightSlop = mRightSlopEdge;
                //final float bottomSlop = mBottomSlopEdge;
                //float x = getRawX(ev, i);
                //float y = getRawY(ev, i);
                //if (x >= edgeSlop && y >= edgeSlop && x <= rightSlop && y <= bottomSlop) {
                    //newActiveIndex = i;
                    //break;
                //}
            //}
        //}
        //return newActiveIndex;
    }

    
        private static float getRawX(MotionEvent event, int pointerIndex) {
        if (pointerIndex < 0) return Float.MIN_VALUE;
        if (pointerIndex == 0) return event.getRawX();
        float offset = event.getRawX() - event.getX();
        return event.getX(pointerIndex) + offset;
    }

    
        private static float getRawY(MotionEvent event, int pointerIndex) {
        if (pointerIndex < 0) return Float.MIN_VALUE;
        if (pointerIndex == 0) return event.getRawY();
        float offset = event.getRawY() - event.getY();
        return event.getY(pointerIndex) + offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.284 -0400", hash_original_method = "E851AC8F08388EEFFE10C17212886186", hash_generated_method = "35259CD198FCF804613740B6ED52CB9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setContext(MotionEvent curr) {
        dsTaint.addTaint(curr.dsTaint);
        {
            mCurrEvent.recycle();
        } //End block
        mCurrEvent = MotionEvent.obtain(curr);
        mCurrLen = -1;
        mPrevLen = -1;
        mScaleFactor = -1;
        MotionEvent prev;
        prev = mPrevEvent;
        int prevIndex0;
        prevIndex0 = prev.findPointerIndex(mActiveId0);
        int prevIndex1;
        prevIndex1 = prev.findPointerIndex(mActiveId1);
        int currIndex0;
        currIndex0 = curr.findPointerIndex(mActiveId0);
        int currIndex1;
        currIndex1 = curr.findPointerIndex(mActiveId1);
        {
            mInvalidGesture = true;
            {
                mListener.onScaleEnd(this);
            } //End block
        } //End block
        float px0;
        px0 = prev.getX(prevIndex0);
        float py0;
        py0 = prev.getY(prevIndex0);
        float px1;
        px1 = prev.getX(prevIndex1);
        float py1;
        py1 = prev.getY(prevIndex1);
        float cx0;
        cx0 = curr.getX(currIndex0);
        float cy0;
        cy0 = curr.getY(currIndex0);
        float cx1;
        cx1 = curr.getX(currIndex1);
        float cy1;
        cy1 = curr.getY(currIndex1);
        float pvx;
        pvx = px1 - px0;
        float pvy;
        pvy = py1 - py0;
        float cvx;
        cvx = cx1 - cx0;
        float cvy;
        cvy = cy1 - cy0;
        mPrevFingerDiffX = pvx;
        mPrevFingerDiffY = pvy;
        mCurrFingerDiffX = cvx;
        mCurrFingerDiffY = cvy;
        mFocusX = cx0 + cvx * 0.5f;
        mFocusY = cy0 + cvy * 0.5f;
        mTimeDelta = curr.getEventTime() - prev.getEventTime();
        mCurrPressure = curr.getPressure(currIndex0) + curr.getPressure(currIndex1);
        mPrevPressure = prev.getPressure(prevIndex0) + prev.getPressure(prevIndex1);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.284 -0400", hash_original_method = "F9E5E3809E5750745599790F573B8504", hash_generated_method = "13E97FC9D617B6DED16F5D4A448F71C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void reset() {
        {
            mPrevEvent.recycle();
            mPrevEvent = null;
        } //End block
        {
            mCurrEvent.recycle();
            mCurrEvent = null;
        } //End block
        mSloppyGesture = false;
        mGestureInProgress = false;
        mActiveId0 = -1;
        mActiveId1 = -1;
        mInvalidGesture = false;
        // ---------- Original Method ----------
        //if (mPrevEvent != null) {
            //mPrevEvent.recycle();
            //mPrevEvent = null;
        //}
        //if (mCurrEvent != null) {
            //mCurrEvent.recycle();
            //mCurrEvent = null;
        //}
        //mSloppyGesture = false;
        //mGestureInProgress = false;
        //mActiveId0 = -1;
        //mActiveId1 = -1;
        //mInvalidGesture = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.284 -0400", hash_original_method = "898B0555390D80294F48D1832D7CA7F1", hash_generated_method = "628F76EA26A165F5982E20F74BCCE28A")
    @DSModeled(DSC.SAFE)
    public boolean isInProgress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mGestureInProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.284 -0400", hash_original_method = "5AA73E7030B433A4A506EA714645F254", hash_generated_method = "F2735F64B18FF2FECEC61DB9C43695C2")
    @DSModeled(DSC.SAFE)
    public float getFocusX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mFocusX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.284 -0400", hash_original_method = "1634272865979B530C4105679871001B", hash_generated_method = "22D1F2E70C83ECDD1F973379FA1DD6D0")
    @DSModeled(DSC.SAFE)
    public float getFocusY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mFocusY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.285 -0400", hash_original_method = "AB0C6BF3BCA5EEB3D5CA8E031A94ABD9", hash_generated_method = "8F0F0801051834F885B4D038844DB488")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getCurrentSpan() {
        {
            float cvx;
            cvx = mCurrFingerDiffX;
            float cvy;
            cvy = mCurrFingerDiffY;
            mCurrLen = FloatMath.sqrt(cvx*cvx + cvy*cvy);
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (mCurrLen == -1) {
            //final float cvx = mCurrFingerDiffX;
            //final float cvy = mCurrFingerDiffY;
            //mCurrLen = FloatMath.sqrt(cvx*cvx + cvy*cvy);
        //}
        //return mCurrLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.285 -0400", hash_original_method = "96703DCF80F0F42B9182D748E24B5F12", hash_generated_method = "0E4CAABA4F8626CF22B1FFD78AF065D7")
    @DSModeled(DSC.SAFE)
    public float getCurrentSpanX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mCurrFingerDiffX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.285 -0400", hash_original_method = "46ABD98E7ABFBBE92F1E1C8C1A82F921", hash_generated_method = "D376B13CE6F721A23F7137134E9F7D59")
    @DSModeled(DSC.SAFE)
    public float getCurrentSpanY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mCurrFingerDiffY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.285 -0400", hash_original_method = "61588E4085777CBFF7E61092314CDCD6", hash_generated_method = "B931A89EFC44C0450B6D45E77863DB59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getPreviousSpan() {
        {
            float pvx;
            pvx = mPrevFingerDiffX;
            float pvy;
            pvy = mPrevFingerDiffY;
            mPrevLen = FloatMath.sqrt(pvx*pvx + pvy*pvy);
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (mPrevLen == -1) {
            //final float pvx = mPrevFingerDiffX;
            //final float pvy = mPrevFingerDiffY;
            //mPrevLen = FloatMath.sqrt(pvx*pvx + pvy*pvy);
        //}
        //return mPrevLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.285 -0400", hash_original_method = "0AFCA4EC344BB39A6FBEFCC5BD88D7B6", hash_generated_method = "62E6EB932E75756352732474BF544D56")
    @DSModeled(DSC.SAFE)
    public float getPreviousSpanX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mPrevFingerDiffX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.286 -0400", hash_original_method = "F0E427EE2F15CB9D89F340FD227EA8BF", hash_generated_method = "8DD2E3883F8E2611D406355E05E6FA57")
    @DSModeled(DSC.SAFE)
    public float getPreviousSpanY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mPrevFingerDiffY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.286 -0400", hash_original_method = "EF10CCD331D0CD8126F652B47BBB1296", hash_generated_method = "D4D9A3E9E80982722C9C0E54228D680C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getScaleFactor() {
        {
            mScaleFactor = getCurrentSpan() / getPreviousSpan();
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (mScaleFactor == -1) {
            //mScaleFactor = getCurrentSpan() / getPreviousSpan();
        //}
        //return mScaleFactor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.286 -0400", hash_original_method = "478681CCF9BA4A844274161522001BDE", hash_generated_method = "D1E440C87498A0EBC9705C861411AD75")
    @DSModeled(DSC.SAFE)
    public long getTimeDelta() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mTimeDelta;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.286 -0400", hash_original_method = "93D380EA2FE2DB10568746F6E0FB3B8E", hash_generated_method = "2A52715F550E3E66B0C26CF4D9B1E77A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getEventTime() {
        long var1C6AD87B9864EE888540D94E95CFDF79_1634330063 = (mCurrEvent.getEventTime());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mCurrEvent.getEventTime();
    }

    
    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.286 -0400", hash_original_method = "C4FB092E5FF1150EC7AEFBBEBFFF48C4", hash_generated_method = "C4FB092E5FF1150EC7AEFBBEBFFF48C4")
                public SimpleOnScaleGestureListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.286 -0400", hash_original_method = "F1A51F1E1A44A60BDE5250CC79B6BF22", hash_generated_method = "4745A1D95151E0F635F6AE929FB1E982")
        @DSModeled(DSC.SAFE)
        public boolean onScale(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(detector.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.286 -0400", hash_original_method = "2018A466C052949DAB40F7C8547E8FA5", hash_generated_method = "2504A17B67F79AE4E9E516493DA3119B")
        @DSModeled(DSC.SAFE)
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(detector.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.287 -0400", hash_original_method = "5B9499EAA38A4A49EE469DC4AE83A358", hash_generated_method = "03AF9275B9878E458F54431AA757E6A2")
        @DSModeled(DSC.SAFE)
        public void onScaleEnd(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(detector.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    public interface OnScaleGestureListener {
        
        public boolean onScale(ScaleGestureDetector detector);

        
        public boolean onScaleBegin(ScaleGestureDetector detector);

        
        public void onScaleEnd(ScaleGestureDetector detector);
    }
    
    private static final String TAG = "ScaleGestureDetector";
    private static final float PRESSURE_THRESHOLD = 0.67f;
}

