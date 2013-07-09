package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;

public class ScaleGestureDetector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "A08AF84037A8352C0A5AC97B5C4711DA")

    private OnScaleGestureListener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "061B672487708A5F02C378E108FB2523", hash_generated_field = "503643741A4ED297FCB738F860325A5C")

    private boolean mGestureInProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "447D9F14ED3611B9294BA6E2AF3CD0C3", hash_generated_field = "3C7A422FE0E65BBDCD9090B91410FF41")

    private MotionEvent mPrevEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "382D89AF4BA3BBDD7BD85028FF0C04C2", hash_generated_field = "D61C81DE46CCD592C64D38B586C58E19")

    private MotionEvent mCurrEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "A0FE7B7E6572E9A5C03F808D583D21EF", hash_generated_field = "9E3ECCCE67853EF67D401BC85D54FCDD")

    private float mFocusX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "E371837A8119A3AB321FC558BC169293", hash_generated_field = "E01C42CAE2152A2827127C5E1618E0BF")

    private float mFocusY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "E0D70E96C315A6A926A5DF77407556F0", hash_generated_field = "9B5A74F081F5922B1785428D638AF7EB")

    private float mPrevFingerDiffX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "3BCD82D8995452F8C4D8BC4D6958AFA9", hash_generated_field = "A4ECFDC00DFED0488AC11C35F6454D1A")

    private float mPrevFingerDiffY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "D797CF4A75F206359DDA7851042405DE", hash_generated_field = "0084D8F5F5AEBC86A46E65C48DD6EDDA")

    private float mCurrFingerDiffX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "F613F042D8B78098BEAE14BEDF4D7F31", hash_generated_field = "F58F567C97D8A5647C27000A75D3AF16")

    private float mCurrFingerDiffY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "8E973CE13F974C6D66FFB6DCB3A83421", hash_generated_field = "933BC37DA68F2A67EB299CEE160CB2FB")

    private float mCurrLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "CCB42BE0A7C21CD017DE96ACABD2762C", hash_generated_field = "1E334C6DA5FA5EB33F386FAD0E8F6E8B")

    private float mPrevLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "43B25FDCBE078DC3DA65BC88CAA3AACD", hash_generated_field = "A57936439C19DE90F2AB86ED42237D31")

    private float mScaleFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "D54820A21CA16B0D6974C6228C51B34A", hash_generated_field = "4CF3DF6E70478D8056347848EFB18503")

    private float mCurrPressure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "95C49E098E3097DD95C24477EA21E4C5", hash_generated_field = "2E7516100A12B928A7F1D7C2C6815166")

    private float mPrevPressure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "D088DDA1C27B96429D7E4965433B26E2", hash_generated_field = "24C21D8C9544B70EF997F0DEE65D3C96")

    private long mTimeDelta;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "7572292F9A0C0E3DA861F35B2F9EB690", hash_generated_field = "87E1CD70AA880AA0038E22EA3C795791")

    private float mEdgeSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "2FCB43D8487E22C85D26E570931ABDBA", hash_generated_field = "B70D199FA23802CA3820F738CE6BECA4")

    private float mRightSlopEdge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "9B40AAEFF1A30F2DB71620BF5079D6CB", hash_generated_field = "875320F67CC4A12055E0E780DF25AC3E")

    private float mBottomSlopEdge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "EE5535D441FD37F5C1D45D0EE2A9289A", hash_generated_field = "F35E4D613A73F5F87B9D2DA4EE86D79A")

    private boolean mSloppyGesture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "F0C1B8EC1E31EA252FC6496124D03A56", hash_generated_field = "D40C9FA5D0FB38FD10587BC7707BC6F3")

    private boolean mInvalidGesture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "716CFAB11C79FD5737D3D0DFD236254D", hash_generated_field = "5955F7D0EA4751A3620710E99C5064B8")

    private int mActiveId0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "791345B6EFB2BD5450963ABCD5B9DACA", hash_generated_field = "6F4F186E958896A650E911389B88CCC0")

    private int mActiveId1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "56B3830B6EF16818B0AACCAEE2BD5D01", hash_generated_field = "78AA2DF7FA2FB872FE42414156BB2883")

    private boolean mActive0MostRecent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.778 -0400", hash_original_field = "EFB0BA2843C7293EEB82F8592A2A0298", hash_generated_field = "69B49DB79681808A97D2CCE1BF25440C")

    private final InputEventConsistencyVerifier mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.779 -0400", hash_original_method = "3F765CE5C3F1587A362200597A84993F", hash_generated_method = "A3091C337EBF2CBE7B369D82A6F832E3")
    public  ScaleGestureDetector(Context context, OnScaleGestureListener listener) {
        ViewConfiguration config = ViewConfiguration.get(context);
        mContext = context;
        mListener = listener;
        mEdgeSlop = config.getScaledEdgeSlop();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.782 -0400", hash_original_method = "3D0907AC17DE553CA8E37D6A8A0F580A", hash_generated_method = "E73F6B623ABC4F0A84304F425DA4593D")
    public boolean onTouchEvent(MotionEvent event) {
        
        {
            mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        } 
        final int action = event.getActionMasked();
        {
            reset();
        } 
        boolean handled = true;
        {
            handled = false;
        } 
        {
            
            {
                mActiveId0 = event.getPointerId(0);
                mActive0MostRecent = true;
            } 
            
            
            reset();
            
            
            {
                DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
                mRightSlopEdge = metrics.widthPixels - mEdgeSlop;
                mBottomSlopEdge = metrics.heightPixels - mEdgeSlop;
                mPrevEvent.recycle();
                mPrevEvent = MotionEvent.obtain(event);
                mTimeDelta = 0;
                int index1 = event.getActionIndex();
                int index0 = event.findPointerIndex(mActiveId0);
                mActiveId1 = event.getPointerId(index1);
                {
                    index0 = findNewActiveIndex(event, index0 == index1 ? -1 : mActiveId1, index0);
                    mActiveId0 = event.getPointerId(index0);
                } 
                mActive0MostRecent = false;
                setContext(event);
                final float edgeSlop = mEdgeSlop;
                final float rightSlop = mRightSlopEdge;
                final float bottomSlop = mBottomSlopEdge;
                float x0 = getRawX(event, index0);
                float y0 = getRawY(event, index0);
                float x1 = getRawX(event, index1);
                float y1 = getRawY(event, index1);
                boolean p0sloppy = x0 < edgeSlop || y0 < edgeSlop
                        || x0 > rightSlop || y0 > bottomSlop;
                boolean p1sloppy = x1 < edgeSlop || y1 < edgeSlop
                        || x1 > rightSlop || y1 > bottomSlop;
                {
                    mFocusX = -1;
                    mFocusY = -1;
                    mSloppyGesture = true;
                } 
                {
                    mFocusX = event.getX(index1);
                    mFocusY = event.getY(index1);
                    mSloppyGesture = true;
                } 
                {
                    mFocusX = event.getX(index0);
                    mFocusY = event.getY(index0);
                    mSloppyGesture = true;
                } 
                {
                    mSloppyGesture = false;
                    mGestureInProgress = mListener.onScaleBegin(this);
                } 
            } 
            
            
            {
                final float edgeSlop = mEdgeSlop;
                final float rightSlop = mRightSlopEdge;
                final float bottomSlop = mBottomSlopEdge;
                int index0 = event.findPointerIndex(mActiveId0);
                int index1 = event.findPointerIndex(mActiveId1);
                float x0 = getRawX(event, index0);
                float y0 = getRawY(event, index0);
                float x1 = getRawX(event, index1);
                float y1 = getRawY(event, index1);
                boolean p0sloppy = x0 < edgeSlop || y0 < edgeSlop
                            || x0 > rightSlop || y0 > bottomSlop;
                boolean p1sloppy = x1 < edgeSlop || y1 < edgeSlop
                            || x1 > rightSlop || y1 > bottomSlop;
                {
                    int index = findNewActiveIndex(event, mActiveId1, index0);
                    {
                        index0 = index;
                        mActiveId0 = event.getPointerId(index);
                        x0 = getRawX(event, index);
                        y0 = getRawY(event, index);
                        p0sloppy = false;
                    } 
                } 
                {
                    int index = findNewActiveIndex(event, mActiveId0, index1);
                    {
                        index1 = index;
                        mActiveId1 = event.getPointerId(index);
                        x1 = getRawX(event, index);
                        y1 = getRawY(event, index);
                        p1sloppy = false;
                    } 
                } 
                {
                    mFocusX = -1;
                    mFocusY = -1;
                } 
                {
                    mFocusX = event.getX(index1);
                    mFocusY = event.getY(index1);
                } 
                {
                    mFocusX = event.getX(index0);
                    mFocusY = event.getY(index0);
                } 
                {
                    mSloppyGesture = false;
                    mGestureInProgress = mListener.onScaleBegin(this);
                } 
            } 
            
            
            {
                final int pointerCount = event.getPointerCount();
                final int actionIndex = event.getActionIndex();
                final int actionId = event.getPointerId(actionIndex);
                {
                    {
                        final int newIndex = findNewActiveIndex(event, mActiveId1, actionIndex);
                        mActiveId0 = event.getPointerId(newIndex);
                    } 
                    {
                        final int newIndex = findNewActiveIndex(event, mActiveId0, actionIndex);
                        mActiveId1 = event.getPointerId(newIndex);
                    } 
                } 
                {
                    final int index = event.findPointerIndex(actionId == mActiveId0 ?
                                mActiveId1 : mActiveId0);
                    {
                        mInvalidGesture = true;
                        {
                            mListener.onScaleEnd(this);
                        } 
                    } 
                    mActiveId0 = event.getPointerId(index);
                    mActive0MostRecent = true;
                    mActiveId1 = -1;
                    mFocusX = event.getX(index);
                    mFocusY = event.getY(index);
                } 
            } 
            
        } 
        {
            
            {
                mListener.onScaleEnd(this);
                final int oldActive0 = mActiveId0;
                final int oldActive1 = mActiveId1;
                reset();
                mPrevEvent = MotionEvent.obtain(event);
                mActiveId0 = mActive0MostRecent ? oldActive0 : oldActive1;
                mActiveId1 = event.getPointerId(event.getActionIndex());
                mActive0MostRecent = false;
                int index0 = event.findPointerIndex(mActiveId0);
                {
                    index0 = findNewActiveIndex(event,
                                mActiveId0 == mActiveId1 ? -1 : mActiveId1, index0);
                    mActiveId0 = event.getPointerId(index0);
                } 
                setContext(event);
                mGestureInProgress = mListener.onScaleBegin(this);
            } 
            
            
            {
                final int pointerCount = event.getPointerCount();
                final int actionIndex = event.getActionIndex();
                final int actionId = event.getPointerId(actionIndex);
                boolean gestureEnded = false;
                {
                    {
                        final int newIndex = findNewActiveIndex(event, mActiveId1, actionIndex);
                        {
                            mListener.onScaleEnd(this);
                            mActiveId0 = event.getPointerId(newIndex);
                            mActive0MostRecent = true;
                            mPrevEvent = MotionEvent.obtain(event);
                            setContext(event);
                            mGestureInProgress = mListener.onScaleBegin(this);
                        } 
                        {
                            gestureEnded = true;
                        } 
                    } 
                    {
                        final int newIndex = findNewActiveIndex(event, mActiveId0, actionIndex);
                        {
                            mListener.onScaleEnd(this);
                            mActiveId1 = event.getPointerId(newIndex);
                            mActive0MostRecent = false;
                            mPrevEvent = MotionEvent.obtain(event);
                            setContext(event);
                            mGestureInProgress = mListener.onScaleBegin(this);
                        } 
                        {
                            gestureEnded = true;
                        } 
                    } 
                    mPrevEvent.recycle();
                    mPrevEvent = MotionEvent.obtain(event);
                    setContext(event);
                } 
                {
                    gestureEnded = true;
                } 
                {
                    setContext(event);
                    int activeId;
                    activeId = mActiveId1;
                    activeId = mActiveId0;
                    final int index = event.findPointerIndex(activeId);
                    mFocusX = event.getX(index);
                    mFocusY = event.getY(index);
                    mListener.onScaleEnd(this);
                    reset();
                    mActiveId0 = activeId;
                    mActive0MostRecent = true;
                } 
            } 
            
            
            mListener.onScaleEnd(this);
            
            
            reset();
            
            
            reset();
            
            
            {
                setContext(event);
                {
                    final boolean updatePrevious = mListener.onScale(this);
                    {
                        mPrevEvent.recycle();
                        mPrevEvent = MotionEvent.obtain(event);
                    } 
                } 
            } 
            
        } 
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_641964623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_641964623;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.783 -0400", hash_original_method = "26EE043A8FDD34A9021E8F106FD508B5", hash_generated_method = "49BCE00B7119C46AE181C13F87B03734")
    private int findNewActiveIndex(MotionEvent ev, int otherActiveId, int oldIndex) {
        final int pointerCount = ev.getPointerCount();
        final int otherActiveIndex = ev.findPointerIndex(otherActiveId);
        int newActiveIndex = -1;
        {
            int i = 0;
            {
                {
                    final float edgeSlop = mEdgeSlop;
                    final float rightSlop = mRightSlopEdge;
                    final float bottomSlop = mBottomSlopEdge;
                    float x = getRawX(ev, i);
                    float y = getRawY(ev, i);
                    {
                        newActiveIndex = i;
                    } 
                } 
            } 
        } 
        addTaint(ev.getTaint());
        addTaint(otherActiveId);
        addTaint(oldIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1613951334 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1613951334;
        
        
        
        
        
            
                
                
                
                
                
                
                    
                    
                
            
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.784 -0400", hash_original_method = "E851AC8F08388EEFFE10C17212886186", hash_generated_method = "1FCEB924D242022EC4521129F588E6FB")
    private void setContext(MotionEvent curr) {
        {
            mCurrEvent.recycle();
        } 
        mCurrEvent = MotionEvent.obtain(curr);
        mCurrLen = -1;
        mPrevLen = -1;
        mScaleFactor = -1;
        final MotionEvent prev = mPrevEvent;
        final int prevIndex0 = prev.findPointerIndex(mActiveId0);
        final int prevIndex1 = prev.findPointerIndex(mActiveId1);
        final int currIndex0 = curr.findPointerIndex(mActiveId0);
        final int currIndex1 = curr.findPointerIndex(mActiveId1);
        {
            mInvalidGesture = true;
            {
                mListener.onScaleEnd(this);
            } 
        } 
        final float px0 = prev.getX(prevIndex0);
        final float py0 = prev.getY(prevIndex0);
        final float px1 = prev.getX(prevIndex1);
        final float py1 = prev.getY(prevIndex1);
        final float cx0 = curr.getX(currIndex0);
        final float cy0 = curr.getY(currIndex0);
        final float cx1 = curr.getX(currIndex1);
        final float cy1 = curr.getY(currIndex1);
        final float pvx = px1 - px0;
        final float pvy = py1 - py0;
        final float cvx = cx1 - cx0;
        final float cvy = cy1 - cy0;
        mPrevFingerDiffX = pvx;
        mPrevFingerDiffY = pvy;
        mCurrFingerDiffX = cvx;
        mCurrFingerDiffY = cvy;
        mFocusX = cx0 + cvx * 0.5f;
        mFocusY = cy0 + cvy * 0.5f;
        mTimeDelta = curr.getEventTime() - prev.getEventTime();
        mCurrPressure = curr.getPressure(currIndex0) + curr.getPressure(currIndex1);
        mPrevPressure = prev.getPressure(prevIndex0) + prev.getPressure(prevIndex1);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.784 -0400", hash_original_method = "F9E5E3809E5750745599790F573B8504", hash_generated_method = "13E97FC9D617B6DED16F5D4A448F71C6")
    private void reset() {
        {
            mPrevEvent.recycle();
            mPrevEvent = null;
        } 
        {
            mCurrEvent.recycle();
            mCurrEvent = null;
        } 
        mSloppyGesture = false;
        mGestureInProgress = false;
        mActiveId0 = -1;
        mActiveId1 = -1;
        mInvalidGesture = false;
        
        
            
            
        
        
            
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.785 -0400", hash_original_method = "898B0555390D80294F48D1832D7CA7F1", hash_generated_method = "2AF3BA1D9C49CFAF3F244C02E3BDF39A")
    public boolean isInProgress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_292601368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_292601368;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.785 -0400", hash_original_method = "5AA73E7030B433A4A506EA714645F254", hash_generated_method = "6F0356CCBB110AC8DE1C640C1B34EA0A")
    public float getFocusX() {
        float var546ADE640B6EDFBC8A086EF31347E768_1832640479 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1832640479;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.785 -0400", hash_original_method = "1634272865979B530C4105679871001B", hash_generated_method = "BF1146DEED444AAC5DBE2375B9041188")
    public float getFocusY() {
        float var546ADE640B6EDFBC8A086EF31347E768_603968210 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_603968210;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.785 -0400", hash_original_method = "AB0C6BF3BCA5EEB3D5CA8E031A94ABD9", hash_generated_method = "161C88A4F637A69702FBBD147156B4D2")
    public float getCurrentSpan() {
        {
            final float cvx = mCurrFingerDiffX;
            final float cvy = mCurrFingerDiffY;
            mCurrLen = FloatMath.sqrt(cvx*cvx + cvy*cvy);
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_689648084 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_689648084;
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.786 -0400", hash_original_method = "96703DCF80F0F42B9182D748E24B5F12", hash_generated_method = "FE4B775B508B99878607543790A43AC2")
    public float getCurrentSpanX() {
        float var546ADE640B6EDFBC8A086EF31347E768_925133810 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_925133810;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.786 -0400", hash_original_method = "46ABD98E7ABFBBE92F1E1C8C1A82F921", hash_generated_method = "3F48B267CF1B92136AA9E7B177083336")
    public float getCurrentSpanY() {
        float var546ADE640B6EDFBC8A086EF31347E768_1253594037 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1253594037;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.787 -0400", hash_original_method = "61588E4085777CBFF7E61092314CDCD6", hash_generated_method = "C3E00DD59EA8260335D0A4FE391C0D69")
    public float getPreviousSpan() {
        {
            final float pvx = mPrevFingerDiffX;
            final float pvy = mPrevFingerDiffY;
            mPrevLen = FloatMath.sqrt(pvx*pvx + pvy*pvy);
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_1821094387 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1821094387;
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.787 -0400", hash_original_method = "0AFCA4EC344BB39A6FBEFCC5BD88D7B6", hash_generated_method = "AE13141CAC1B843FCAABB49BF54FDD27")
    public float getPreviousSpanX() {
        float var546ADE640B6EDFBC8A086EF31347E768_1502447716 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1502447716;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.787 -0400", hash_original_method = "F0E427EE2F15CB9D89F340FD227EA8BF", hash_generated_method = "935A6DF27BAC37E7A2B059545E10DC5A")
    public float getPreviousSpanY() {
        float var546ADE640B6EDFBC8A086EF31347E768_1182573078 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1182573078;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.788 -0400", hash_original_method = "EF10CCD331D0CD8126F652B47BBB1296", hash_generated_method = "080C77722F2340C28A90D4F93A363F11")
    public float getScaleFactor() {
        {
            mScaleFactor = getCurrentSpan() / getPreviousSpan();
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_246806039 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_246806039;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.788 -0400", hash_original_method = "478681CCF9BA4A844274161522001BDE", hash_generated_method = "0FD527671D72B5DF68AE4DA7ADD536DB")
    public long getTimeDelta() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1992878315 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1992878315;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.788 -0400", hash_original_method = "93D380EA2FE2DB10568746F6E0FB3B8E", hash_generated_method = "FA5537EA0B935EBE6FE2BE3336EE3695")
    public long getEventTime() {
        long var1C6AD87B9864EE888540D94E95CFDF79_171136254 = (mCurrEvent.getEventTime());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2136588200 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2136588200;
        
        
    }

    
    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.788 -0400", hash_original_method = "AD1F4E6C43CD567296DC4B26B7E79B23", hash_generated_method = "AD1F4E6C43CD567296DC4B26B7E79B23")
        public SimpleOnScaleGestureListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.788 -0400", hash_original_method = "F1A51F1E1A44A60BDE5250CC79B6BF22", hash_generated_method = "438C189907AFC947701616D25DE070AE")
        public boolean onScale(ScaleGestureDetector detector) {
            
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_885217775 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_885217775;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.789 -0400", hash_original_method = "2018A466C052949DAB40F7C8547E8FA5", hash_generated_method = "05794F51D80370DD96E11460B6B6174F")
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            
            addTaint(detector.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97792164 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_97792164;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.789 -0400", hash_original_method = "5B9499EAA38A4A49EE469DC4AE83A358", hash_generated_method = "60B04B78A4A04F6C7A1F2B5D39D8EB97")
        public void onScaleEnd(ScaleGestureDetector detector) {
            
            addTaint(detector.getTaint());
            
        }

        
    }


    
    public interface OnScaleGestureListener {
        
        public boolean onScale(ScaleGestureDetector detector);

        
        public boolean onScaleBegin(ScaleGestureDetector detector);

        
        public void onScaleEnd(ScaleGestureDetector detector);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.789 -0400", hash_original_field = "8B2EF3D1B7CA751F5122A037B33DDFA9", hash_generated_field = "4649FA3572602ADAEA386A657BBBCE55")

    private static final String TAG = "ScaleGestureDetector";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.789 -0400", hash_original_field = "98A2E9AEA633EA3E41254A788CD371FE", hash_generated_field = "1E49C39436E310C8A58BEAD71FF9190C")

    private static final float PRESSURE_THRESHOLD = 0.67f;
}

