package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;

public class ScaleGestureDetector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.961 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.961 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "A08AF84037A8352C0A5AC97B5C4711DA")

    private OnScaleGestureListener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.961 -0400", hash_original_field = "061B672487708A5F02C378E108FB2523", hash_generated_field = "503643741A4ED297FCB738F860325A5C")

    private boolean mGestureInProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.961 -0400", hash_original_field = "447D9F14ED3611B9294BA6E2AF3CD0C3", hash_generated_field = "3C7A422FE0E65BBDCD9090B91410FF41")

    private MotionEvent mPrevEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.961 -0400", hash_original_field = "382D89AF4BA3BBDD7BD85028FF0C04C2", hash_generated_field = "D61C81DE46CCD592C64D38B586C58E19")

    private MotionEvent mCurrEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.961 -0400", hash_original_field = "A0FE7B7E6572E9A5C03F808D583D21EF", hash_generated_field = "9E3ECCCE67853EF67D401BC85D54FCDD")

    private float mFocusX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.961 -0400", hash_original_field = "E371837A8119A3AB321FC558BC169293", hash_generated_field = "E01C42CAE2152A2827127C5E1618E0BF")

    private float mFocusY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.961 -0400", hash_original_field = "E0D70E96C315A6A926A5DF77407556F0", hash_generated_field = "9B5A74F081F5922B1785428D638AF7EB")

    private float mPrevFingerDiffX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.961 -0400", hash_original_field = "3BCD82D8995452F8C4D8BC4D6958AFA9", hash_generated_field = "A4ECFDC00DFED0488AC11C35F6454D1A")

    private float mPrevFingerDiffY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.961 -0400", hash_original_field = "D797CF4A75F206359DDA7851042405DE", hash_generated_field = "0084D8F5F5AEBC86A46E65C48DD6EDDA")

    private float mCurrFingerDiffX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.961 -0400", hash_original_field = "F613F042D8B78098BEAE14BEDF4D7F31", hash_generated_field = "F58F567C97D8A5647C27000A75D3AF16")

    private float mCurrFingerDiffY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "8E973CE13F974C6D66FFB6DCB3A83421", hash_generated_field = "933BC37DA68F2A67EB299CEE160CB2FB")

    private float mCurrLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "CCB42BE0A7C21CD017DE96ACABD2762C", hash_generated_field = "1E334C6DA5FA5EB33F386FAD0E8F6E8B")

    private float mPrevLen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "43B25FDCBE078DC3DA65BC88CAA3AACD", hash_generated_field = "A57936439C19DE90F2AB86ED42237D31")

    private float mScaleFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "D54820A21CA16B0D6974C6228C51B34A", hash_generated_field = "4CF3DF6E70478D8056347848EFB18503")

    private float mCurrPressure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "95C49E098E3097DD95C24477EA21E4C5", hash_generated_field = "2E7516100A12B928A7F1D7C2C6815166")

    private float mPrevPressure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "D088DDA1C27B96429D7E4965433B26E2", hash_generated_field = "24C21D8C9544B70EF997F0DEE65D3C96")

    private long mTimeDelta;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "7572292F9A0C0E3DA861F35B2F9EB690", hash_generated_field = "87E1CD70AA880AA0038E22EA3C795791")

    private float mEdgeSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "2FCB43D8487E22C85D26E570931ABDBA", hash_generated_field = "B70D199FA23802CA3820F738CE6BECA4")

    private float mRightSlopEdge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "9B40AAEFF1A30F2DB71620BF5079D6CB", hash_generated_field = "875320F67CC4A12055E0E780DF25AC3E")

    private float mBottomSlopEdge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "EE5535D441FD37F5C1D45D0EE2A9289A", hash_generated_field = "F35E4D613A73F5F87B9D2DA4EE86D79A")

    private boolean mSloppyGesture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "F0C1B8EC1E31EA252FC6496124D03A56", hash_generated_field = "D40C9FA5D0FB38FD10587BC7707BC6F3")

    private boolean mInvalidGesture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.962 -0400", hash_original_field = "716CFAB11C79FD5737D3D0DFD236254D", hash_generated_field = "5955F7D0EA4751A3620710E99C5064B8")

    private int mActiveId0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.963 -0400", hash_original_field = "791345B6EFB2BD5450963ABCD5B9DACA", hash_generated_field = "6F4F186E958896A650E911389B88CCC0")

    private int mActiveId1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.963 -0400", hash_original_field = "56B3830B6EF16818B0AACCAEE2BD5D01", hash_generated_field = "78AA2DF7FA2FB872FE42414156BB2883")

    private boolean mActive0MostRecent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.963 -0400", hash_original_field = "EFB0BA2843C7293EEB82F8592A2A0298", hash_generated_field = "69B49DB79681808A97D2CCE1BF25440C")

    private final InputEventConsistencyVerifier mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.963 -0400", hash_original_method = "3F765CE5C3F1587A362200597A84993F", hash_generated_method = "A3091C337EBF2CBE7B369D82A6F832E3")
    public  ScaleGestureDetector(Context context, OnScaleGestureListener listener) {
        ViewConfiguration config = ViewConfiguration.get(context);
        mContext = context;
        mListener = listener;
        mEdgeSlop = config.getScaledEdgeSlop();
        // ---------- Original Method ----------
        //ViewConfiguration config = ViewConfiguration.get(context);
        //mContext = context;
        //mListener = listener;
        //mEdgeSlop = config.getScaledEdgeSlop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.980 -0400", hash_original_method = "3D0907AC17DE553CA8E37D6A8A0F580A", hash_generated_method = "9A02A0E103E06C443DB7067304ABEE43")
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        } //End block
        final int action = event.getActionMasked();
        if(action == MotionEvent.ACTION_DOWN)        
        {
            reset();
        } //End block
        boolean handled = true;
        if(mInvalidGesture)        
        {
            handled = false;
        } //End block
        else
        if(!mGestureInProgress)        
        {
switch(action){
            case MotionEvent.ACTION_DOWN:
            {
                mActiveId0 = event.getPointerId(0);
                mActive0MostRecent = true;
            } //End block
            break;
            case MotionEvent.ACTION_UP:
            reset();
            break;
            case MotionEvent.ACTION_POINTER_DOWN:
            {
                DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
                mRightSlopEdge = metrics.widthPixels - mEdgeSlop;
                mBottomSlopEdge = metrics.heightPixels - mEdgeSlop;
                if(mPrevEvent != null)                
                mPrevEvent.recycle();
                mPrevEvent = MotionEvent.obtain(event);
                mTimeDelta = 0;
                int index1 = event.getActionIndex();
                int index0 = event.findPointerIndex(mActiveId0);
                mActiveId1 = event.getPointerId(index1);
                if(index0 < 0 || index0 == index1)                
                {
                    index0 = findNewActiveIndex(event, index0 == index1 ? -1 : mActiveId1, index0);
                    mActiveId0 = event.getPointerId(index0);
                } //End block
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
                if(p0sloppy && p1sloppy)                
                {
                    mFocusX = -1;
                    mFocusY = -1;
                    mSloppyGesture = true;
                } //End block
                else
                if(p0sloppy)                
                {
                    mFocusX = event.getX(index1);
                    mFocusY = event.getY(index1);
                    mSloppyGesture = true;
                } //End block
                else
                if(p1sloppy)                
                {
                    mFocusX = event.getX(index0);
                    mFocusY = event.getY(index0);
                    mSloppyGesture = true;
                } //End block
                else
                {
                    mSloppyGesture = false;
                    mGestureInProgress = mListener.onScaleBegin(this);
                } //End block
            } //End block
            break;
            case MotionEvent.ACTION_MOVE:
            if(mSloppyGesture)            
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
                if(p0sloppy)                
                {
                    int index = findNewActiveIndex(event, mActiveId1, index0);
                    if(index >= 0)                    
                    {
                        index0 = index;
                        mActiveId0 = event.getPointerId(index);
                        x0 = getRawX(event, index);
                        y0 = getRawY(event, index);
                        p0sloppy = false;
                    } //End block
                } //End block
                if(p1sloppy)                
                {
                    int index = findNewActiveIndex(event, mActiveId0, index1);
                    if(index >= 0)                    
                    {
                        index1 = index;
                        mActiveId1 = event.getPointerId(index);
                        x1 = getRawX(event, index);
                        y1 = getRawY(event, index);
                        p1sloppy = false;
                    } //End block
                } //End block
                if(p0sloppy && p1sloppy)                
                {
                    mFocusX = -1;
                    mFocusY = -1;
                } //End block
                else
                if(p0sloppy)                
                {
                    mFocusX = event.getX(index1);
                    mFocusY = event.getY(index1);
                } //End block
                else
                if(p1sloppy)                
                {
                    mFocusX = event.getX(index0);
                    mFocusY = event.getY(index0);
                } //End block
                else
                {
                    mSloppyGesture = false;
                    mGestureInProgress = mListener.onScaleBegin(this);
                } //End block
            } //End block
            break;
            case MotionEvent.ACTION_POINTER_UP:
            if(mSloppyGesture)            
            {
                final int pointerCount = event.getPointerCount();
                final int actionIndex = event.getActionIndex();
                final int actionId = event.getPointerId(actionIndex);
                if(pointerCount > 2)                
                {
                    if(actionId == mActiveId0)                    
                    {
                        final int newIndex = findNewActiveIndex(event, mActiveId1, actionIndex);
                        if(newIndex >= 0)                        
                        mActiveId0 = event.getPointerId(newIndex);
                    } //End block
                    else
                    if(actionId == mActiveId1)                    
                    {
                        final int newIndex = findNewActiveIndex(event, mActiveId0, actionIndex);
                        if(newIndex >= 0)                        
                        mActiveId1 = event.getPointerId(newIndex);
                    } //End block
                } //End block
                else
                {
                    final int index = event.findPointerIndex(actionId == mActiveId0 ?
                                mActiveId1 : mActiveId0);
                    if(index < 0)                    
                    {
                        mInvalidGesture = true;
                        if(mGestureInProgress)                        
                        {
                            mListener.onScaleEnd(this);
                        } //End block
                        boolean var68934A3E9455FA72420237EB05902327_383414207 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79409492 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_79409492;
                    } //End block
                    mActiveId0 = event.getPointerId(index);
                    mActive0MostRecent = true;
                    mActiveId1 = -1;
                    mFocusX = event.getX(index);
                    mFocusY = event.getY(index);
                } //End block
            } //End block
            break;
}
        } //End block
        else
        {
switch(action){
            case MotionEvent.ACTION_POINTER_DOWN:
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
                if(index0 < 0 || mActiveId0 == mActiveId1)                
                {
                    index0 = findNewActiveIndex(event,
                                mActiveId0 == mActiveId1 ? -1 : mActiveId1, index0);
                    mActiveId0 = event.getPointerId(index0);
                } //End block
                setContext(event);
                mGestureInProgress = mListener.onScaleBegin(this);
            } //End block
            break;
            case MotionEvent.ACTION_POINTER_UP:
            {
                final int pointerCount = event.getPointerCount();
                final int actionIndex = event.getActionIndex();
                final int actionId = event.getPointerId(actionIndex);
                boolean gestureEnded = false;
                if(pointerCount > 2)                
                {
                    if(actionId == mActiveId0)                    
                    {
                        final int newIndex = findNewActiveIndex(event, mActiveId1, actionIndex);
                        if(newIndex >= 0)                        
                        {
                            mListener.onScaleEnd(this);
                            mActiveId0 = event.getPointerId(newIndex);
                            mActive0MostRecent = true;
                            mPrevEvent = MotionEvent.obtain(event);
                            setContext(event);
                            mGestureInProgress = mListener.onScaleBegin(this);
                        } //End block
                        else
                        {
                            gestureEnded = true;
                        } //End block
                    } //End block
                    else
                    if(actionId == mActiveId1)                    
                    {
                        final int newIndex = findNewActiveIndex(event, mActiveId0, actionIndex);
                        if(newIndex >= 0)                        
                        {
                            mListener.onScaleEnd(this);
                            mActiveId1 = event.getPointerId(newIndex);
                            mActive0MostRecent = false;
                            mPrevEvent = MotionEvent.obtain(event);
                            setContext(event);
                            mGestureInProgress = mListener.onScaleBegin(this);
                        } //End block
                        else
                        {
                            gestureEnded = true;
                        } //End block
                    } //End block
                    mPrevEvent.recycle();
                    mPrevEvent = MotionEvent.obtain(event);
                    setContext(event);
                } //End block
                else
                {
                    gestureEnded = true;
                } //End block
                if(gestureEnded)                
                {
                    setContext(event);
                    final int activeId = actionId == mActiveId0 ? mActiveId1 : mActiveId0;
                    final int index = event.findPointerIndex(activeId);
                    mFocusX = event.getX(index);
                    mFocusY = event.getY(index);
                    mListener.onScaleEnd(this);
                    reset();
                    mActiveId0 = activeId;
                    mActive0MostRecent = true;
                } //End block
            } //End block
            break;
            case MotionEvent.ACTION_CANCEL:
            mListener.onScaleEnd(this);
            reset();
            break;
            case MotionEvent.ACTION_UP:
            reset();
            break;
            case MotionEvent.ACTION_MOVE:
            {
                setContext(event);
                if(mCurrPressure / mPrevPressure > PRESSURE_THRESHOLD)                
                {
                    final boolean updatePrevious = mListener.onScale(this);
                    if(updatePrevious)                    
                    {
                        mPrevEvent.recycle();
                        mPrevEvent = MotionEvent.obtain(event);
                    } //End block
                } //End block
            } //End block
            break;
}
        } //End block
        if(!handled && mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1407856559 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1991433005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1991433005;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.989 -0400", hash_original_method = "26EE043A8FDD34A9021E8F106FD508B5", hash_generated_method = "6572947CD97A8E41CCE66FB387BDB0A4")
    private int findNewActiveIndex(MotionEvent ev, int otherActiveId, int oldIndex) {
        addTaint(oldIndex);
        addTaint(otherActiveId);
        addTaint(ev.getTaint());
        final int pointerCount = ev.getPointerCount();
        final int otherActiveIndex = ev.findPointerIndex(otherActiveId);
        int newActiveIndex = -1;
for(int i = 0;i < pointerCount;i++)
        {
            if(i != oldIndex && i != otherActiveIndex)            
            {
                final float edgeSlop = mEdgeSlop;
                final float rightSlop = mRightSlopEdge;
                final float bottomSlop = mBottomSlopEdge;
                float x = getRawX(ev, i);
                float y = getRawY(ev, i);
                if(x >= edgeSlop && y >= edgeSlop && x <= rightSlop && y <= bottomSlop)                
                {
                    newActiveIndex = i;
                    break;
                } //End block
            } //End block
        } //End block
        int var211F54CDFC9A5C3404569D77056CA9F3_1791627993 = (newActiveIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770927809 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770927809;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.995 -0400", hash_original_method = "E851AC8F08388EEFFE10C17212886186", hash_generated_method = "CBDF072BFE5829B1D228F253F6D3C44C")
    private void setContext(MotionEvent curr) {
        if(mCurrEvent != null)        
        {
            mCurrEvent.recycle();
        } //End block
        mCurrEvent = MotionEvent.obtain(curr);
        mCurrLen = -1;
        mPrevLen = -1;
        mScaleFactor = -1;
        final MotionEvent prev = mPrevEvent;
        final int prevIndex0 = prev.findPointerIndex(mActiveId0);
        final int prevIndex1 = prev.findPointerIndex(mActiveId1);
        final int currIndex0 = curr.findPointerIndex(mActiveId0);
        final int currIndex1 = curr.findPointerIndex(mActiveId1);
        if(prevIndex0 < 0 || prevIndex1 < 0 || currIndex0 < 0 || currIndex1 < 0)        
        {
            mInvalidGesture = true;
            if(mGestureInProgress)            
            {
                mListener.onScaleEnd(this);
            } //End block
            return;
        } //End block
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.996 -0400", hash_original_method = "F9E5E3809E5750745599790F573B8504", hash_generated_method = "30E2C34A724FADA3EB87CED62FD583BA")
    private void reset() {
        if(mPrevEvent != null)        
        {
            mPrevEvent.recycle();
            mPrevEvent = null;
        } //End block
        if(mCurrEvent != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.997 -0400", hash_original_method = "898B0555390D80294F48D1832D7CA7F1", hash_generated_method = "CB891AAB377E68BC129E76213E2D2A3D")
    public boolean isInProgress() {
        boolean var061B672487708A5F02C378E108FB2523_597886835 = (mGestureInProgress);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_486635111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_486635111;
        // ---------- Original Method ----------
        //return mGestureInProgress;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.998 -0400", hash_original_method = "5AA73E7030B433A4A506EA714645F254", hash_generated_method = "C7E27BFCCD73C62B5BF88BB25DDA5FCC")
    public float getFocusX() {
        float varA0FE7B7E6572E9A5C03F808D583D21EF_1355029930 = (mFocusX);
                float var546ADE640B6EDFBC8A086EF31347E768_1341498628 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1341498628;
        // ---------- Original Method ----------
        //return mFocusX;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.998 -0400", hash_original_method = "1634272865979B530C4105679871001B", hash_generated_method = "5B5078F2371D860B5867873191EC800D")
    public float getFocusY() {
        float varE371837A8119A3AB321FC558BC169293_965800892 = (mFocusY);
                float var546ADE640B6EDFBC8A086EF31347E768_666526343 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_666526343;
        // ---------- Original Method ----------
        //return mFocusY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.999 -0400", hash_original_method = "AB0C6BF3BCA5EEB3D5CA8E031A94ABD9", hash_generated_method = "CAC98F5CC3A268318D31CF23A2583D3E")
    public float getCurrentSpan() {
        if(mCurrLen == -1)        
        {
            final float cvx = mCurrFingerDiffX;
            final float cvy = mCurrFingerDiffY;
            mCurrLen = FloatMath.sqrt(cvx*cvx + cvy*cvy);
        } //End block
        float var8E973CE13F974C6D66FFB6DCB3A83421_343637749 = (mCurrLen);
                float var546ADE640B6EDFBC8A086EF31347E768_1468736498 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1468736498;
        // ---------- Original Method ----------
        //if (mCurrLen == -1) {
            //final float cvx = mCurrFingerDiffX;
            //final float cvy = mCurrFingerDiffY;
            //mCurrLen = FloatMath.sqrt(cvx*cvx + cvy*cvy);
        //}
        //return mCurrLen;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.999 -0400", hash_original_method = "96703DCF80F0F42B9182D748E24B5F12", hash_generated_method = "035DBA03ECE4B1114B14DD12B8A28BFC")
    public float getCurrentSpanX() {
        float varD797CF4A75F206359DDA7851042405DE_79853466 = (mCurrFingerDiffX);
                float var546ADE640B6EDFBC8A086EF31347E768_2037516318 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2037516318;
        // ---------- Original Method ----------
        //return mCurrFingerDiffX;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.000 -0400", hash_original_method = "46ABD98E7ABFBBE92F1E1C8C1A82F921", hash_generated_method = "68C06AEC85BE56DB7914A0E78182CC30")
    public float getCurrentSpanY() {
        float varF613F042D8B78098BEAE14BEDF4D7F31_672657628 = (mCurrFingerDiffY);
                float var546ADE640B6EDFBC8A086EF31347E768_287684637 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_287684637;
        // ---------- Original Method ----------
        //return mCurrFingerDiffY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.000 -0400", hash_original_method = "61588E4085777CBFF7E61092314CDCD6", hash_generated_method = "B90EBCF2623B207E35DB0C3F886E52E1")
    public float getPreviousSpan() {
        if(mPrevLen == -1)        
        {
            final float pvx = mPrevFingerDiffX;
            final float pvy = mPrevFingerDiffY;
            mPrevLen = FloatMath.sqrt(pvx*pvx + pvy*pvy);
        } //End block
        float varCCB42BE0A7C21CD017DE96ACABD2762C_82243884 = (mPrevLen);
                float var546ADE640B6EDFBC8A086EF31347E768_1980260355 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1980260355;
        // ---------- Original Method ----------
        //if (mPrevLen == -1) {
            //final float pvx = mPrevFingerDiffX;
            //final float pvy = mPrevFingerDiffY;
            //mPrevLen = FloatMath.sqrt(pvx*pvx + pvy*pvy);
        //}
        //return mPrevLen;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.000 -0400", hash_original_method = "0AFCA4EC344BB39A6FBEFCC5BD88D7B6", hash_generated_method = "91F94C8C6AE6D0A5A647CB7980787E8D")
    public float getPreviousSpanX() {
        float varE0D70E96C315A6A926A5DF77407556F0_1758401920 = (mPrevFingerDiffX);
                float var546ADE640B6EDFBC8A086EF31347E768_934419697 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_934419697;
        // ---------- Original Method ----------
        //return mPrevFingerDiffX;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.001 -0400", hash_original_method = "F0E427EE2F15CB9D89F340FD227EA8BF", hash_generated_method = "B83FAFBE2434931D56EAC97AAB977A40")
    public float getPreviousSpanY() {
        float var3BCD82D8995452F8C4D8BC4D6958AFA9_910298916 = (mPrevFingerDiffY);
                float var546ADE640B6EDFBC8A086EF31347E768_614161794 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_614161794;
        // ---------- Original Method ----------
        //return mPrevFingerDiffY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.001 -0400", hash_original_method = "EF10CCD331D0CD8126F652B47BBB1296", hash_generated_method = "4DDDDD7A30DF41394F02C504A4F4280C")
    public float getScaleFactor() {
        if(mScaleFactor == -1)        
        {
            mScaleFactor = getCurrentSpan() / getPreviousSpan();
        } //End block
        float var43B25FDCBE078DC3DA65BC88CAA3AACD_746647115 = (mScaleFactor);
                float var546ADE640B6EDFBC8A086EF31347E768_260477004 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_260477004;
        // ---------- Original Method ----------
        //if (mScaleFactor == -1) {
            //mScaleFactor = getCurrentSpan() / getPreviousSpan();
        //}
        //return mScaleFactor;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.001 -0400", hash_original_method = "478681CCF9BA4A844274161522001BDE", hash_generated_method = "5337DAF81481B4885076FD454DA0FC94")
    public long getTimeDelta() {
        long varD088DDA1C27B96429D7E4965433B26E2_73418589 = (mTimeDelta);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_227568006 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_227568006;
        // ---------- Original Method ----------
        //return mTimeDelta;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.002 -0400", hash_original_method = "93D380EA2FE2DB10568746F6E0FB3B8E", hash_generated_method = "E7700E933C36C4712033247A7D033ED1")
    public long getEventTime() {
        long varF5CCD1CFF00A6AFC9E9CD33F09ACC5B7_11605623 = (mCurrEvent.getEventTime());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_321784072 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_321784072;
        // ---------- Original Method ----------
        //return mCurrEvent.getEventTime();
    }

    
    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.002 -0400", hash_original_method = "AD1F4E6C43CD567296DC4B26B7E79B23", hash_generated_method = "AD1F4E6C43CD567296DC4B26B7E79B23")
        public SimpleOnScaleGestureListener ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.002 -0400", hash_original_method = "F1A51F1E1A44A60BDE5250CC79B6BF22", hash_generated_method = "802E8EFB3D0939D19E3F7D53ECDDA9CA")
        public boolean onScale(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(detector.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_246030973 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2107762063 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2107762063;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.003 -0400", hash_original_method = "2018A466C052949DAB40F7C8547E8FA5", hash_generated_method = "849ADF6E8A25D2A5AE1FF4401012E3E1")
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(detector.getTaint());
            boolean varB326B5062B2F0E69046810717534CB09_727021885 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466067710 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_466067710;
            // ---------- Original Method ----------
            //return true;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.003 -0400", hash_original_method = "5B9499EAA38A4A49EE469DC4AE83A358", hash_generated_method = "60B04B78A4A04F6C7A1F2B5D39D8EB97")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.003 -0400", hash_original_field = "8B2EF3D1B7CA751F5122A037B33DDFA9", hash_generated_field = "4649FA3572602ADAEA386A657BBBCE55")

    private static final String TAG = "ScaleGestureDetector";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.003 -0400", hash_original_field = "98A2E9AEA633EA3E41254A788CD371FE", hash_generated_field = "1E49C39436E310C8A58BEAD71FF9190C")

    private static final float PRESSURE_THRESHOLD = 0.67f;
}

