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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "A08AF84037A8352C0A5AC97B5C4711DA")

    private OnScaleGestureListener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "061B672487708A5F02C378E108FB2523", hash_generated_field = "503643741A4ED297FCB738F860325A5C")

    private boolean mGestureInProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "447D9F14ED3611B9294BA6E2AF3CD0C3", hash_generated_field = "3C7A422FE0E65BBDCD9090B91410FF41")

    private MotionEvent mPrevEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "382D89AF4BA3BBDD7BD85028FF0C04C2", hash_generated_field = "D61C81DE46CCD592C64D38B586C58E19")

    private MotionEvent mCurrEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "A0FE7B7E6572E9A5C03F808D583D21EF", hash_generated_field = "9E3ECCCE67853EF67D401BC85D54FCDD")

    private float mFocusX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "E371837A8119A3AB321FC558BC169293", hash_generated_field = "E01C42CAE2152A2827127C5E1618E0BF")

    private float mFocusY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "E0D70E96C315A6A926A5DF77407556F0", hash_generated_field = "9B5A74F081F5922B1785428D638AF7EB")

    private float mPrevFingerDiffX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "3BCD82D8995452F8C4D8BC4D6958AFA9", hash_generated_field = "A4ECFDC00DFED0488AC11C35F6454D1A")

    private float mPrevFingerDiffY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "D797CF4A75F206359DDA7851042405DE", hash_generated_field = "0084D8F5F5AEBC86A46E65C48DD6EDDA")

    private float mCurrFingerDiffX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "F613F042D8B78098BEAE14BEDF4D7F31", hash_generated_field = "F58F567C97D8A5647C27000A75D3AF16")

    private float mCurrFingerDiffY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "8E973CE13F974C6D66FFB6DCB3A83421", hash_generated_field = "933BC37DA68F2A67EB299CEE160CB2FB")

    private float mCurrLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "CCB42BE0A7C21CD017DE96ACABD2762C", hash_generated_field = "1E334C6DA5FA5EB33F386FAD0E8F6E8B")

    private float mPrevLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "43B25FDCBE078DC3DA65BC88CAA3AACD", hash_generated_field = "A57936439C19DE90F2AB86ED42237D31")

    private float mScaleFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "D54820A21CA16B0D6974C6228C51B34A", hash_generated_field = "4CF3DF6E70478D8056347848EFB18503")

    private float mCurrPressure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "95C49E098E3097DD95C24477EA21E4C5", hash_generated_field = "2E7516100A12B928A7F1D7C2C6815166")

    private float mPrevPressure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "D088DDA1C27B96429D7E4965433B26E2", hash_generated_field = "24C21D8C9544B70EF997F0DEE65D3C96")

    private long mTimeDelta;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "7572292F9A0C0E3DA861F35B2F9EB690", hash_generated_field = "87E1CD70AA880AA0038E22EA3C795791")

    private float mEdgeSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "2FCB43D8487E22C85D26E570931ABDBA", hash_generated_field = "B70D199FA23802CA3820F738CE6BECA4")

    private float mRightSlopEdge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.293 -0400", hash_original_field = "9B40AAEFF1A30F2DB71620BF5079D6CB", hash_generated_field = "875320F67CC4A12055E0E780DF25AC3E")

    private float mBottomSlopEdge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.300 -0400", hash_original_field = "EE5535D441FD37F5C1D45D0EE2A9289A", hash_generated_field = "F35E4D613A73F5F87B9D2DA4EE86D79A")

    private boolean mSloppyGesture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.300 -0400", hash_original_field = "F0C1B8EC1E31EA252FC6496124D03A56", hash_generated_field = "D40C9FA5D0FB38FD10587BC7707BC6F3")

    private boolean mInvalidGesture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.300 -0400", hash_original_field = "716CFAB11C79FD5737D3D0DFD236254D", hash_generated_field = "5955F7D0EA4751A3620710E99C5064B8")

    private int mActiveId0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.300 -0400", hash_original_field = "791345B6EFB2BD5450963ABCD5B9DACA", hash_generated_field = "6F4F186E958896A650E911389B88CCC0")

    private int mActiveId1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.300 -0400", hash_original_field = "56B3830B6EF16818B0AACCAEE2BD5D01", hash_generated_field = "78AA2DF7FA2FB872FE42414156BB2883")

    private boolean mActive0MostRecent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.300 -0400", hash_original_field = "EFB0BA2843C7293EEB82F8592A2A0298", hash_generated_field = "D54334EA2E7A3839D717E5F2F1FCD778")

    private InputEventConsistencyVerifier mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.301 -0400", hash_original_method = "3F765CE5C3F1587A362200597A84993F", hash_generated_method = "8F1ADC17626C6FA293C744067C7D4CF2")
    public  ScaleGestureDetector(Context context, OnScaleGestureListener listener) {
        ViewConfiguration config;
        config = ViewConfiguration.get(context);
        mContext = context;
        mListener = listener;
        mEdgeSlop = config.getScaledEdgeSlop();
        // ---------- Original Method ----------
        //ViewConfiguration config = ViewConfiguration.get(context);
        //mContext = context;
        //mListener = listener;
        //mEdgeSlop = config.getScaledEdgeSlop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.336 -0400", hash_original_method = "3D0907AC17DE553CA8E37D6A8A0F580A", hash_generated_method = "08324A58412CEBF5BF1E9A0243FF178A")
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_321119342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_321119342;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.338 -0400", hash_original_method = "26EE043A8FDD34A9021E8F106FD508B5", hash_generated_method = "7D0105D3337DFE195B2BCC2812B053C3")
    private int findNewActiveIndex(MotionEvent ev, int otherActiveId, int oldIndex) {
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
        addTaint(ev.getTaint());
        addTaint(otherActiveId);
        addTaint(oldIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210431736 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210431736;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.345 -0400", hash_original_method = "E851AC8F08388EEFFE10C17212886186", hash_generated_method = "40360F17B7E3E43181B8C4B1E93B67D0")
    private void setContext(MotionEvent curr) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.363 -0400", hash_original_method = "F9E5E3809E5750745599790F573B8504", hash_generated_method = "13E97FC9D617B6DED16F5D4A448F71C6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.364 -0400", hash_original_method = "898B0555390D80294F48D1832D7CA7F1", hash_generated_method = "1FC42E99F306D4FAD93E57E24C6DADE4")
    public boolean isInProgress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1784415647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1784415647;
        // ---------- Original Method ----------
        //return mGestureInProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.365 -0400", hash_original_method = "5AA73E7030B433A4A506EA714645F254", hash_generated_method = "699C95BAD054F51A5B595FA8C9C7F3DE")
    public float getFocusX() {
        float var546ADE640B6EDFBC8A086EF31347E768_1856515189 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1856515189;
        // ---------- Original Method ----------
        //return mFocusX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.365 -0400", hash_original_method = "1634272865979B530C4105679871001B", hash_generated_method = "2120C27E6ABD1BD6F9CE461E807BBFBF")
    public float getFocusY() {
        float var546ADE640B6EDFBC8A086EF31347E768_318563922 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_318563922;
        // ---------- Original Method ----------
        //return mFocusY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.366 -0400", hash_original_method = "AB0C6BF3BCA5EEB3D5CA8E031A94ABD9", hash_generated_method = "C96FCF27C4572B9B0C0A6A2AB4380C9B")
    public float getCurrentSpan() {
        {
            float cvx;
            cvx = mCurrFingerDiffX;
            float cvy;
            cvy = mCurrFingerDiffY;
            mCurrLen = FloatMath.sqrt(cvx*cvx + cvy*cvy);
        } //End block
        float var546ADE640B6EDFBC8A086EF31347E768_1771172077 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1771172077;
        // ---------- Original Method ----------
        //if (mCurrLen == -1) {
            //final float cvx = mCurrFingerDiffX;
            //final float cvy = mCurrFingerDiffY;
            //mCurrLen = FloatMath.sqrt(cvx*cvx + cvy*cvy);
        //}
        //return mCurrLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.366 -0400", hash_original_method = "96703DCF80F0F42B9182D748E24B5F12", hash_generated_method = "9F6A1A94880E9C4E0C8A0C012760D465")
    public float getCurrentSpanX() {
        float var546ADE640B6EDFBC8A086EF31347E768_1619294648 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1619294648;
        // ---------- Original Method ----------
        //return mCurrFingerDiffX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.370 -0400", hash_original_method = "46ABD98E7ABFBBE92F1E1C8C1A82F921", hash_generated_method = "A06CB2A0103BA10BC64F08EF2803D6A8")
    public float getCurrentSpanY() {
        float var546ADE640B6EDFBC8A086EF31347E768_1630517985 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1630517985;
        // ---------- Original Method ----------
        //return mCurrFingerDiffY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.378 -0400", hash_original_method = "61588E4085777CBFF7E61092314CDCD6", hash_generated_method = "8ED29F20529077C1E91D4072621911CC")
    public float getPreviousSpan() {
        {
            float pvx;
            pvx = mPrevFingerDiffX;
            float pvy;
            pvy = mPrevFingerDiffY;
            mPrevLen = FloatMath.sqrt(pvx*pvx + pvy*pvy);
        } //End block
        float var546ADE640B6EDFBC8A086EF31347E768_668708458 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_668708458;
        // ---------- Original Method ----------
        //if (mPrevLen == -1) {
            //final float pvx = mPrevFingerDiffX;
            //final float pvy = mPrevFingerDiffY;
            //mPrevLen = FloatMath.sqrt(pvx*pvx + pvy*pvy);
        //}
        //return mPrevLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.379 -0400", hash_original_method = "0AFCA4EC344BB39A6FBEFCC5BD88D7B6", hash_generated_method = "233C2EFE4AD095A406476A8162917F0A")
    public float getPreviousSpanX() {
        float var546ADE640B6EDFBC8A086EF31347E768_535537262 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_535537262;
        // ---------- Original Method ----------
        //return mPrevFingerDiffX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.379 -0400", hash_original_method = "F0E427EE2F15CB9D89F340FD227EA8BF", hash_generated_method = "CA57A27F46976CCF1A51526943AB439A")
    public float getPreviousSpanY() {
        float var546ADE640B6EDFBC8A086EF31347E768_1620177897 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1620177897;
        // ---------- Original Method ----------
        //return mPrevFingerDiffY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.380 -0400", hash_original_method = "EF10CCD331D0CD8126F652B47BBB1296", hash_generated_method = "5F9A375BEAC45DA239BE613390CA32C7")
    public float getScaleFactor() {
        {
            mScaleFactor = getCurrentSpan() / getPreviousSpan();
        } //End block
        float var546ADE640B6EDFBC8A086EF31347E768_1175617289 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1175617289;
        // ---------- Original Method ----------
        //if (mScaleFactor == -1) {
            //mScaleFactor = getCurrentSpan() / getPreviousSpan();
        //}
        //return mScaleFactor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.380 -0400", hash_original_method = "478681CCF9BA4A844274161522001BDE", hash_generated_method = "6B0BC7EF08335727B25DDDF3161C5486")
    public long getTimeDelta() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_392846117 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_392846117;
        // ---------- Original Method ----------
        //return mTimeDelta;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.384 -0400", hash_original_method = "93D380EA2FE2DB10568746F6E0FB3B8E", hash_generated_method = "9017BF7D8BDF34640CC763D4B339F514")
    public long getEventTime() {
        long var1C6AD87B9864EE888540D94E95CFDF79_104211266 = (mCurrEvent.getEventTime());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1263458163 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1263458163;
        // ---------- Original Method ----------
        //return mCurrEvent.getEventTime();
    }

    
    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.384 -0400", hash_original_method = "AD1F4E6C43CD567296DC4B26B7E79B23", hash_generated_method = "AD1F4E6C43CD567296DC4B26B7E79B23")
        public SimpleOnScaleGestureListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.396 -0400", hash_original_method = "F1A51F1E1A44A60BDE5250CC79B6BF22", hash_generated_method = "2B53A3F77A4E2F1253F7C4C675537DFB")
        public boolean onScale(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_855680823 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_855680823;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.397 -0400", hash_original_method = "2018A466C052949DAB40F7C8547E8FA5", hash_generated_method = "071530280B0718BC2A10A00ECBC4B520")
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28592947 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_28592947;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.397 -0400", hash_original_method = "5B9499EAA38A4A49EE469DC4AE83A358", hash_generated_method = "60B04B78A4A04F6C7A1F2B5D39D8EB97")
        public void onScaleEnd(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(detector.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public interface OnScaleGestureListener {
        
        public boolean onScale(ScaleGestureDetector detector);

        
        public boolean onScaleBegin(ScaleGestureDetector detector);

        
        public void onScaleEnd(ScaleGestureDetector detector);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.397 -0400", hash_original_field = "8B2EF3D1B7CA751F5122A037B33DDFA9", hash_generated_field = "9CBCD0F0BC19B95062AB3114D3F29E44")

    private static String TAG = "ScaleGestureDetector";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:50.397 -0400", hash_original_field = "98A2E9AEA633EA3E41254A788CD371FE", hash_generated_field = "4B35A55816E5F429231DFE2E515837C9")

    private static float PRESSURE_THRESHOLD = 0.67f;
}

