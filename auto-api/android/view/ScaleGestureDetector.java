package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;

public class ScaleGestureDetector {
    private static final String TAG = "ScaleGestureDetector";
    private static final float PRESSURE_THRESHOLD = 0.67f;
    private final Context mContext;
    private final OnScaleGestureListener mListener;
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
    private final float mEdgeSlop;
    private float mRightSlopEdge;
    private float mBottomSlopEdge;
    private boolean mSloppyGesture;
    private boolean mInvalidGesture;
    private int mActiveId0;
    private int mActiveId1;
    private boolean mActive0MostRecent;
    private final InputEventConsistencyVerifier mInputEventConsistencyVerifier =
            InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.520 -0400", hash_original_method = "3F765CE5C3F1587A362200597A84993F", hash_generated_method = "97B0320E1AA9806EDFDA523347714883")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScaleGestureDetector(Context context, OnScaleGestureListener listener) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        ViewConfiguration config;
        config = ViewConfiguration.get(context);
        mEdgeSlop = config.getScaledEdgeSlop();
        // ---------- Original Method ----------
        //ViewConfiguration config = ViewConfiguration.get(context);
        //mContext = context;
        //mListener = listener;
        //mEdgeSlop = config.getScaledEdgeSlop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.522 -0400", hash_original_method = "3D0907AC17DE553CA8E37D6A8A0F580A", hash_generated_method = "1C127810533BE0E1E6C0A2A761E00FA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        } //End block
        final int action;
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
                final float edgeSlop;
                edgeSlop = mEdgeSlop;
                final float rightSlop;
                rightSlop = mRightSlopEdge;
                final float bottomSlop;
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
                final float edgeSlop;
                edgeSlop = mEdgeSlop;
                final float rightSlop;
                rightSlop = mRightSlopEdge;
                final float bottomSlop;
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
                final int pointerCount;
                pointerCount = event.getPointerCount();
                final int actionIndex;
                actionIndex = event.getActionIndex();
                final int actionId;
                actionId = event.getPointerId(actionIndex);
                {
                    {
                        final int newIndex;
                        newIndex = findNewActiveIndex(event, mActiveId1, actionIndex);
                        mActiveId0 = event.getPointerId(newIndex);
                    } //End block
                    {
                        final int newIndex;
                        newIndex = findNewActiveIndex(event, mActiveId0, actionIndex);
                        mActiveId1 = event.getPointerId(newIndex);
                    } //End block
                } //End block
                {
                    final int index;
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
                final int oldActive0;
                oldActive0 = mActiveId0;
                final int oldActive1;
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
                final int pointerCount;
                pointerCount = event.getPointerCount();
                final int actionIndex;
                actionIndex = event.getActionIndex();
                final int actionId;
                actionId = event.getPointerId(actionIndex);
                boolean gestureEnded;
                gestureEnded = false;
                {
                    {
                        final int newIndex;
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
                        final int newIndex;
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
                    final int activeId;
                    activeId = mActiveId1;
                    activeId = mActiveId0;
                    final int index;
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
                    final boolean updatePrevious;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.523 -0400", hash_original_method = "26EE043A8FDD34A9021E8F106FD508B5", hash_generated_method = "A94342A2114DBD8E7E496D1DA7A89254")
    @DSModeled(DSC.SAFE)
    private int findNewActiveIndex(MotionEvent ev, int otherActiveId, int oldIndex) {
        dsTaint.addTaint(otherActiveId);
        dsTaint.addTaint(oldIndex);
        dsTaint.addTaint(ev.dsTaint);
        final int pointerCount;
        pointerCount = ev.getPointerCount();
        final int otherActiveIndex;
        otherActiveIndex = ev.findPointerIndex(otherActiveId);
        int newActiveIndex;
        newActiveIndex = -1;
        {
            int i;
            i = 0;
            {
                {
                    final float edgeSlop;
                    edgeSlop = mEdgeSlop;
                    final float rightSlop;
                    rightSlop = mRightSlopEdge;
                    final float bottomSlop;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.523 -0400", hash_original_method = "1C74B9CEBA7069C1C46FE5AC2377DD74", hash_generated_method = "9F535709078E10633F597DAC5E474805")
    private static float getRawX(MotionEvent event, int pointerIndex) {
        if (pointerIndex < 0) return Float.MIN_VALUE;
        if (pointerIndex == 0) return event.getRawX();
        float offset = event.getRawX() - event.getX();
        return event.getX(pointerIndex) + offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.523 -0400", hash_original_method = "E9D933E20849778B1DB8C91D44A0DC56", hash_generated_method = "F03B96929C9C0CCA5FAA5D104052F336")
    private static float getRawY(MotionEvent event, int pointerIndex) {
        if (pointerIndex < 0) return Float.MIN_VALUE;
        if (pointerIndex == 0) return event.getRawY();
        float offset = event.getRawY() - event.getY();
        return event.getY(pointerIndex) + offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.523 -0400", hash_original_method = "E851AC8F08388EEFFE10C17212886186", hash_generated_method = "266284E1A761940C0D8CE294C8F0AB61")
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
        final MotionEvent prev;
        prev = mPrevEvent;
        final int prevIndex0;
        prevIndex0 = prev.findPointerIndex(mActiveId0);
        final int prevIndex1;
        prevIndex1 = prev.findPointerIndex(mActiveId1);
        final int currIndex0;
        currIndex0 = curr.findPointerIndex(mActiveId0);
        final int currIndex1;
        currIndex1 = curr.findPointerIndex(mActiveId1);
        {
            mInvalidGesture = true;
            {
                mListener.onScaleEnd(this);
            } //End block
        } //End block
        final float px0;
        px0 = prev.getX(prevIndex0);
        final float py0;
        py0 = prev.getY(prevIndex0);
        final float px1;
        px1 = prev.getX(prevIndex1);
        final float py1;
        py1 = prev.getY(prevIndex1);
        final float cx0;
        cx0 = curr.getX(currIndex0);
        final float cy0;
        cy0 = curr.getY(currIndex0);
        final float cx1;
        cx1 = curr.getX(currIndex1);
        final float cy1;
        cy1 = curr.getY(currIndex1);
        final float pvx;
        pvx = px1 - px0;
        final float pvy;
        pvy = py1 - py0;
        final float cvx;
        cvx = cx1 - cx0;
        final float cvy;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.523 -0400", hash_original_method = "F9E5E3809E5750745599790F573B8504", hash_generated_method = "C9B3A84BC9D1DAD098FA38EB567950E5")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.523 -0400", hash_original_method = "898B0555390D80294F48D1832D7CA7F1", hash_generated_method = "770023E2812384C115FF3B325892FF2C")
    @DSModeled(DSC.SAFE)
    public boolean isInProgress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mGestureInProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "5AA73E7030B433A4A506EA714645F254", hash_generated_method = "D172E9F97F51CABDD7EED2A905CAE967")
    @DSModeled(DSC.SAFE)
    public float getFocusX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mFocusX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "1634272865979B530C4105679871001B", hash_generated_method = "322524301766F467F8319B5A27A72A18")
    @DSModeled(DSC.SAFE)
    public float getFocusY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mFocusY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "AB0C6BF3BCA5EEB3D5CA8E031A94ABD9", hash_generated_method = "028CCD11AF46010D327BC55414D855CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getCurrentSpan() {
        {
            final float cvx;
            cvx = mCurrFingerDiffX;
            final float cvy;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "96703DCF80F0F42B9182D748E24B5F12", hash_generated_method = "1BD2471918ED70536CBFDAE9BFE68FC7")
    @DSModeled(DSC.SAFE)
    public float getCurrentSpanX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mCurrFingerDiffX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "46ABD98E7ABFBBE92F1E1C8C1A82F921", hash_generated_method = "9583101056AD2E9FA3A39FEECC91FFE7")
    @DSModeled(DSC.SAFE)
    public float getCurrentSpanY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mCurrFingerDiffY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "61588E4085777CBFF7E61092314CDCD6", hash_generated_method = "814C357FFBB070FCB3E13121998A1DDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getPreviousSpan() {
        {
            final float pvx;
            pvx = mPrevFingerDiffX;
            final float pvy;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "0AFCA4EC344BB39A6FBEFCC5BD88D7B6", hash_generated_method = "19BC6DFDFB78D80A3B0F9312E7473718")
    @DSModeled(DSC.SAFE)
    public float getPreviousSpanX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mPrevFingerDiffX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "F0E427EE2F15CB9D89F340FD227EA8BF", hash_generated_method = "3BA6791F3B997E82A35CDD3081C9C46B")
    @DSModeled(DSC.SAFE)
    public float getPreviousSpanY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mPrevFingerDiffY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "EF10CCD331D0CD8126F652B47BBB1296", hash_generated_method = "D7086EB26024486BE0B23C3BAB325E46")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "478681CCF9BA4A844274161522001BDE", hash_generated_method = "4081647FB03195C9592F74EA34628703")
    @DSModeled(DSC.SAFE)
    public long getTimeDelta() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mTimeDelta;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "93D380EA2FE2DB10568746F6E0FB3B8E", hash_generated_method = "334E1457E46CB093CA32F09B1A577128")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getEventTime() {
        long var1C6AD87B9864EE888540D94E95CFDF79_1589607651 = (mCurrEvent.getEventTime());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mCurrEvent.getEventTime();
    }

    
    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "F1A51F1E1A44A60BDE5250CC79B6BF22", hash_generated_method = "647BF690F646970EE2616FD8B00B263E")
        @DSModeled(DSC.SAFE)
        public boolean onScale(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(detector.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.524 -0400", hash_original_method = "2018A466C052949DAB40F7C8547E8FA5", hash_generated_method = "A4202344A27FD97CB78DD0D05754B147")
        @DSModeled(DSC.SAFE)
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(detector.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.525 -0400", hash_original_method = "5B9499EAA38A4A49EE469DC4AE83A358", hash_generated_method = "0AF5DF76233BB7290CE2C595328BB54D")
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
    
}


