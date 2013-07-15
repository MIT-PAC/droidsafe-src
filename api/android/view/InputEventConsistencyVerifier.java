package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Build;
import android.util.Log;

public final class InputEventConsistencyVerifier {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.911 -0400", hash_original_field = "02B8E2B08EEFD631BD36F22665C339F2", hash_generated_field = "842464D18B9CC1D906D30912951F1B29")

    private Object mCaller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.911 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private int mFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.911 -0400", hash_original_field = "503F6607C959C61B036C1484733875DB", hash_generated_field = "59F9615F1046A159253328ABFF9EBAC4")

    private String mLogTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.911 -0400", hash_original_field = "EE9CC63E94F20AF8999429F0CFA81933", hash_generated_field = "CAF007840D1F7323B1001E7DD39DA851")

    private InputEvent mLastEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "A0ABA9CA907A59C8D456966BBA1B3887", hash_generated_field = "7BD27485A06A6A1AC8080AE3638DE4F4")

    private String mLastEventType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "9B5513F064DD0C164336A4318307FD8E", hash_generated_field = "6141C906002BAC7131BFF645A86E7469")

    private int mLastNestingLevel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "19DEACD4170AE518A6DE25F40D57CC5E", hash_generated_field = "860F0DD6CB41AA51A689A023866EB3EC")

    private InputEvent[] mRecentEvents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "1CBB3F568975EF8EC30EEC1AB97967F2", hash_generated_field = "EA05C25F3223B278A2037BD67E368C3A")

    private boolean[] mRecentEventsUnhandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "96ABAE2065AC7130FA9A0F86D456D0B5", hash_generated_field = "30754FF941B62BB39BC4DA77B462515F")

    private int mMostRecentEventIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "37155EC34151C4A4C889EC884F50AEEA", hash_generated_field = "41D4493BA1E5584628EA45425F6D040D")

    private InputEvent mCurrentEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "AB1A563C338454CDCDE6E69607B9426B", hash_generated_field = "6DB375435025884B6151B31AFFFABC76")

    private String mCurrentEventType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "EABE08FDF07FFC82E191D864B705E825", hash_generated_field = "54CDF24A71BB09237A10056FCD052ACC")

    private KeyState mKeyStateList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "CC8BB3617BE25520DEF765C8BDA61DEB", hash_generated_field = "EE4A6262291D828DA2F877FD0D0E2FF0")

    private boolean mTrackballDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "401E99879E2D5AB198383085D49D3A06", hash_generated_field = "A06A640C9360F807D330C6AC7DC6EC56")

    private boolean mTrackballUnhandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "29D0EFD7BBEBE9EF2D55C8D205D29A42", hash_generated_field = "2E6E4A3402809A29F95231522CC6E70D")

    private int mTouchEventStreamPointers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "76A973B325B8C28F2B88CFCCE43EA268", hash_generated_field = "55B14E4F3F5DFF6FBC6711B83FE98065")

    private int mTouchEventStreamDeviceId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "36B6F011CE0CBE093880BFCE3E88F860", hash_generated_field = "301EA641826E495DAC0F1004C4FD7D72")

    private int mTouchEventStreamSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "D28D9276F0CCF57EAA41F1CA21516D3A", hash_generated_field = "4ADB7785313125C3F9545C94531D1258")

    private boolean mTouchEventStreamIsTainted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "97E3F7FCB6911501B81AF9CEA6EB9D1F", hash_generated_field = "AAA9E205D77F337A8F1503284ADA9497")

    private boolean mTouchEventStreamUnhandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.912 -0400", hash_original_field = "ABC622DD1CF6B937B2EE57C4308724EF", hash_generated_field = "A1EEE3B7C7E4EEB7928D87C1E14B5A64")

    private boolean mHoverEntered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.913 -0400", hash_original_field = "0FF2EDE5A69E1ED5164E5AE0CA0A580F", hash_generated_field = "0E37C0AC706495641748D32B4C94C2EF")

    private StringBuilder mViolationMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.913 -0400", hash_original_method = "D65E8A245B5C473707AFD205D57D3AF8", hash_generated_method = "33D025E9014950329B11E0EABEA29DB9")
    public  InputEventConsistencyVerifier(Object caller, int flags) {
        this(caller, flags, InputEventConsistencyVerifier.class.getSimpleName());
        addTaint(flags);
        addTaint(caller.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.914 -0400", hash_original_method = "31CA6A116339576A3C7E1C4293F4F7B1", hash_generated_method = "25151441769D8C7D937887594A926350")
    public  InputEventConsistencyVerifier(Object caller, int flags, String logTag) {
        this.mCaller = caller;
        this.mFlags = flags;
        this.mLogTag = (logTag != null) ? logTag : "InputEventConsistencyVerifier";
        // ---------- Original Method ----------
        //this.mCaller = caller;
        //this.mFlags = flags;
        //this.mLogTag = (logTag != null) ? logTag : "InputEventConsistencyVerifier";
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean isInstrumentationEnabled() {
        return IS_ENG_BUILD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.915 -0400", hash_original_method = "13418E29B3FCE72BDE84CBF193C1BADD", hash_generated_method = "718F6BAEBC9F32735511F8F6D427FB0C")
    public void reset() {
        mLastEvent = null;
        mLastNestingLevel = 0;
        mTrackballDown = false;
        mTrackballUnhandled = false;
        mTouchEventStreamPointers = 0;
        mTouchEventStreamIsTainted = false;
        mTouchEventStreamUnhandled = false;
        mHoverEntered = false;
        while
(mKeyStateList != null)        
        {
            final KeyState state = mKeyStateList;
            mKeyStateList = state.next;
            state.recycle();
        } //End block
        // ---------- Original Method ----------
        //mLastEvent = null;
        //mLastNestingLevel = 0;
        //mTrackballDown = false;
        //mTrackballUnhandled = false;
        //mTouchEventStreamPointers = 0;
        //mTouchEventStreamIsTainted = false;
        //mTouchEventStreamUnhandled = false;
        //mHoverEntered = false;
        //while (mKeyStateList != null) {
            //final KeyState state = mKeyStateList;
            //mKeyStateList = state.next;
            //state.recycle();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.915 -0400", hash_original_method = "9981F0DD702462FD09DA371539E225DF", hash_generated_method = "D450634EBB39229DDCE0ADFED1D31DF9")
    public void onInputEvent(InputEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(nestingLevel);
        addTaint(event.getTaint());
    if(event instanceof KeyEvent)        
        {
            final KeyEvent keyEvent = (KeyEvent)event;
            onKeyEvent(keyEvent, nestingLevel);
        } //End block
        else
        {
            final MotionEvent motionEvent = (MotionEvent)event;
    if(motionEvent.isTouchEvent())            
            {
                onTouchEvent(motionEvent, nestingLevel);
            } //End block
            else
    if((motionEvent.getSource() & InputDevice.SOURCE_CLASS_TRACKBALL) != 0)            
            {
                onTrackballEvent(motionEvent, nestingLevel);
            } //End block
            else
            {
                onGenericMotionEvent(motionEvent, nestingLevel);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (event instanceof KeyEvent) {
            //final KeyEvent keyEvent = (KeyEvent)event;
            //onKeyEvent(keyEvent, nestingLevel);
        //} else {
            //final MotionEvent motionEvent = (MotionEvent)event;
            //if (motionEvent.isTouchEvent()) {
                //onTouchEvent(motionEvent, nestingLevel);
            //} else if ((motionEvent.getSource() & InputDevice.SOURCE_CLASS_TRACKBALL) != 0) {
                //onTrackballEvent(motionEvent, nestingLevel);
            //} else {
                //onGenericMotionEvent(motionEvent, nestingLevel);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.916 -0400", hash_original_method = "37A5317EE58F7483AB8019E5DEA39C1C", hash_generated_method = "13650007C3E19A1C39863AEF155C5A15")
    public void onKeyEvent(KeyEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(nestingLevel);
        addTaint(event.getTaint());
    if(!startEvent(event, nestingLevel, EVENT_TYPE_KEY))        
        {
            return;
        } //End block
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            final int action = event.getAction();
            final int deviceId = event.getDeviceId();
            final int source = event.getSource();
            final int keyCode = event.getKeyCode();
switch(action){
            case KeyEvent.ACTION_DOWN:
            {
                KeyState state = findKeyState(deviceId, source, keyCode,  false);
    if(state != null)                
                {
    if(state.unhandled)                    
                    {
                        state.unhandled = false;
                    } //End block
                    else
    if((mFlags & FLAG_RAW_DEVICE_INPUT) == 0
                                && event.getRepeatCount() == 0)                    
                    {
                        problem("ACTION_DOWN but key is already down and this event "
                                    + "is not a key repeat.");
                    } //End block
                } //End block
                else
                {
                    addKeyState(deviceId, source, keyCode);
                } //End block
                break;
            } //End block
            case KeyEvent.ACTION_UP:
            {
                KeyState state = findKeyState(deviceId, source, keyCode,  true);
    if(state == null)                
                {
                    problem("ACTION_UP but key was not down.");
                } //End block
                else
                {
                    state.recycle();
                } //End block
                break;
            } //End block
            case KeyEvent.ACTION_MULTIPLE:
            break;
            default:
            problem("Invalid action " + KeyEvent.actionToString(action)
                            + " for key event.");
            break;
}
        } //End block
        finally 
        {
            finishEvent();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.918 -0400", hash_original_method = "742053359AC2416542EBDE8E8736FB44", hash_generated_method = "1EAB31B8DD546EF73FF5796314609253")
    public void onTrackballEvent(MotionEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(nestingLevel);
        addTaint(event.getTaint());
    if(!startEvent(event, nestingLevel, EVENT_TYPE_TRACKBALL))        
        {
            return;
        } //End block
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            final int action = event.getAction();
            final int source = event.getSource();
    if((source & InputDevice.SOURCE_CLASS_TRACKBALL) != 0)            
            {
switch(action){
                case MotionEvent.ACTION_DOWN:
    if(mTrackballDown && !mTrackballUnhandled)                
                {
                    problem("ACTION_DOWN but trackball is already down.");
                } //End block
                else
                {
                    mTrackballDown = true;
                    mTrackballUnhandled = false;
                } //End block
                ensureHistorySizeIsZeroForThisAction(event);
                ensurePointerCountIsOneForThisAction(event);
                break;
                case MotionEvent.ACTION_UP:
    if(!mTrackballDown)                
                {
                    problem("ACTION_UP but trackball is not down.");
                } //End block
                else
                {
                    mTrackballDown = false;
                    mTrackballUnhandled = false;
                } //End block
                ensureHistorySizeIsZeroForThisAction(event);
                ensurePointerCountIsOneForThisAction(event);
                break;
                case MotionEvent.ACTION_MOVE:
                ensurePointerCountIsOneForThisAction(event);
                break;
                default:
                problem("Invalid action " + MotionEvent.actionToString(action)
                                + " for trackball event.");
                break;
}    if(mTrackballDown && event.getPressure() <= 0)                
                {
                    problem("Trackball is down but pressure is not greater than 0.");
                } //End block
                else
    if(!mTrackballDown && event.getPressure() != 0)                
                {
                    problem("Trackball is up but pressure is not equal to 0.");
                } //End block
            } //End block
            else
            {
                problem("Source was not SOURCE_CLASS_TRACKBALL.");
            } //End block
        } //End block
        finally 
        {
            finishEvent();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.921 -0400", hash_original_method = "F64D7AF6BB2368971DDEEF01EB83BDA6", hash_generated_method = "30B07D87EE31F4C624D5B65631787589")
    public void onTouchEvent(MotionEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(nestingLevel);
    if(!startEvent(event, nestingLevel, EVENT_TYPE_TOUCH))        
        {
            return;
        } //End block
        final int action = event.getAction();
        final boolean newStream = action == MotionEvent.ACTION_DOWN
                || action == MotionEvent.ACTION_CANCEL;
    if(newStream && (mTouchEventStreamIsTainted || mTouchEventStreamUnhandled))        
        {
            mTouchEventStreamIsTainted = false;
            mTouchEventStreamUnhandled = false;
            mTouchEventStreamPointers = 0;
        } //End block
    if(mTouchEventStreamIsTainted)        
        {
            event.setTainted(true);
        } //End block
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            final int deviceId = event.getDeviceId();
            final int source = event.getSource();
    if(!newStream && mTouchEventStreamDeviceId != -1
                    && (mTouchEventStreamDeviceId != deviceId
                            || mTouchEventStreamSource != source))            
            {
                problem("Touch event stream contains events from multiple sources: "
                        + "previous device id " + mTouchEventStreamDeviceId
                        + ", previous source " + Integer.toHexString(mTouchEventStreamSource)
                        + ", new device id " + deviceId
                        + ", new source " + Integer.toHexString(source));
            } //End block
            mTouchEventStreamDeviceId = deviceId;
            mTouchEventStreamSource = source;
            final int pointerCount = event.getPointerCount();
    if((source & InputDevice.SOURCE_CLASS_POINTER) != 0)            
            {
switch(action){
                case MotionEvent.ACTION_DOWN:
    if(mTouchEventStreamPointers != 0)                
                {
                    problem("ACTION_DOWN but pointers are already down.  "
                                    + "Probably missing ACTION_UP from previous gesture.");
                } //End block
                ensureHistorySizeIsZeroForThisAction(event);
                ensurePointerCountIsOneForThisAction(event);
                mTouchEventStreamPointers = 1 << event.getPointerId(0);
                break;
                case MotionEvent.ACTION_UP:
                ensureHistorySizeIsZeroForThisAction(event);
                ensurePointerCountIsOneForThisAction(event);
                mTouchEventStreamPointers = 0;
                mTouchEventStreamIsTainted = false;
                break;
                case MotionEvent.ACTION_MOVE:
                {
                    final int expectedPointerCount = Integer.bitCount(mTouchEventStreamPointers);
    if(pointerCount != expectedPointerCount)                    
                    {
                        problem("ACTION_MOVE contained " + pointerCount
                                    + " pointers but there are currently "
                                    + expectedPointerCount + " pointers down.");
                        mTouchEventStreamIsTainted = true;
                    } //End block
                    break;
                } //End block
                case MotionEvent.ACTION_CANCEL:
                mTouchEventStreamPointers = 0;
                mTouchEventStreamIsTainted = false;
                break;
                case MotionEvent.ACTION_OUTSIDE:
    if(mTouchEventStreamPointers != 0)                
                {
                    problem("ACTION_OUTSIDE but pointers are still down.");
                } //End block
                ensureHistorySizeIsZeroForThisAction(event);
                ensurePointerCountIsOneForThisAction(event);
                mTouchEventStreamIsTainted = false;
                break;
                default:
                {
                    final int actionMasked = event.getActionMasked();
                    final int actionIndex = event.getActionIndex();
    if(actionMasked == MotionEvent.ACTION_POINTER_DOWN)                    
                    {
    if(mTouchEventStreamPointers == 0)                        
                        {
                            problem("ACTION_POINTER_DOWN but no other pointers were down.");
                            mTouchEventStreamIsTainted = true;
                        } //End block
    if(actionIndex < 0 || actionIndex >= pointerCount)                        
                        {
                            problem("ACTION_POINTER_DOWN index is " + actionIndex
                                        + " but the pointer count is " + pointerCount + ".");
                            mTouchEventStreamIsTainted = true;
                        } //End block
                        else
                        {
                            final int id = event.getPointerId(actionIndex);
                            final int idBit = 1 << id;
    if((mTouchEventStreamPointers & idBit) != 0)                            
                            {
                                problem("ACTION_POINTER_DOWN specified pointer id " + id
                                            + " which is already down.");
                                mTouchEventStreamIsTainted = true;
                            } //End block
                            else
                            {
                                mTouchEventStreamPointers |= idBit;
                            } //End block
                        } //End block
                        ensureHistorySizeIsZeroForThisAction(event);
                    } //End block
                    else
    if(actionMasked == MotionEvent.ACTION_POINTER_UP)                    
                    {
    if(actionIndex < 0 || actionIndex >= pointerCount)                        
                        {
                            problem("ACTION_POINTER_UP index is " + actionIndex
                                        + " but the pointer count is " + pointerCount + ".");
                            mTouchEventStreamIsTainted = true;
                        } //End block
                        else
                        {
                            final int id = event.getPointerId(actionIndex);
                            final int idBit = 1 << id;
    if((mTouchEventStreamPointers & idBit) == 0)                            
                            {
                                problem("ACTION_POINTER_UP specified pointer id " + id
                                            + " which is not currently down.");
                                mTouchEventStreamIsTainted = true;
                            } //End block
                            else
                            {
                                mTouchEventStreamPointers &= ~idBit;
                            } //End block
                        } //End block
                        ensureHistorySizeIsZeroForThisAction(event);
                    } //End block
                    else
                    {
                        problem("Invalid action " + MotionEvent.actionToString(action)
                                    + " for touch event.");
                    } //End block
                    break;
                } //End block
}
            } //End block
            else
            {
                problem("Source was not SOURCE_CLASS_POINTER.");
            } //End block
        } //End block
        finally 
        {
            finishEvent();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.923 -0400", hash_original_method = "23EA37DFEC977078F682E35F151F1942", hash_generated_method = "8788FFC06EA0B5B25FB55B44CFCB2631")
    public void onGenericMotionEvent(MotionEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(nestingLevel);
        addTaint(event.getTaint());
    if(!startEvent(event, nestingLevel, EVENT_TYPE_GENERIC_MOTION))        
        {
            return;
        } //End block
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            final int action = event.getAction();
            final int source = event.getSource();
    if((source & InputDevice.SOURCE_CLASS_POINTER) != 0)            
            {
switch(action){
                case MotionEvent.ACTION_HOVER_ENTER:
                ensurePointerCountIsOneForThisAction(event);
                mHoverEntered = true;
                break;
                case MotionEvent.ACTION_HOVER_MOVE:
                ensurePointerCountIsOneForThisAction(event);
                break;
                case MotionEvent.ACTION_HOVER_EXIT:
                ensurePointerCountIsOneForThisAction(event);
    if(!mHoverEntered)                
                {
                    problem("ACTION_HOVER_EXIT without prior ACTION_HOVER_ENTER");
                } //End block
                mHoverEntered = false;
                break;
                case MotionEvent.ACTION_SCROLL:
                ensureHistorySizeIsZeroForThisAction(event);
                ensurePointerCountIsOneForThisAction(event);
                break;
                default:
                problem("Invalid action for generic pointer event.");
                break;
}
            } //End block
            else
    if((source & InputDevice.SOURCE_CLASS_JOYSTICK) != 0)            
            {
switch(action){
                case MotionEvent.ACTION_MOVE:
                ensurePointerCountIsOneForThisAction(event);
                break;
                default:
                problem("Invalid action for generic joystick event.");
                break;
}
            } //End block
        } //End block
        finally 
        {
            finishEvent();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.924 -0400", hash_original_method = "95A33BD7B12ABE8439BBD32736BE35D7", hash_generated_method = "F4063FC04131F87BA8EE9AAE1F233D78")
    public void onUnhandledEvent(InputEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(nestingLevel);
        addTaint(event.getTaint());
    if(nestingLevel != mLastNestingLevel)        
        {
            return;
        } //End block
    if(mRecentEventsUnhandled != null)        
        {
            mRecentEventsUnhandled[mMostRecentEventIndex] = true;
        } //End block
    if(event instanceof KeyEvent)        
        {
            final KeyEvent keyEvent = (KeyEvent)event;
            final int deviceId = keyEvent.getDeviceId();
            final int source = keyEvent.getSource();
            final int keyCode = keyEvent.getKeyCode();
            final KeyState state = findKeyState(deviceId, source, keyCode,  false);
    if(state != null)            
            {
                state.unhandled = true;
            } //End block
        } //End block
        else
        {
            final MotionEvent motionEvent = (MotionEvent)event;
    if(motionEvent.isTouchEvent())            
            {
                mTouchEventStreamUnhandled = true;
            } //End block
            else
    if((motionEvent.getSource() & InputDevice.SOURCE_CLASS_TRACKBALL) != 0)            
            {
    if(mTrackballDown)                
                {
                    mTrackballUnhandled = true;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.924 -0400", hash_original_method = "0D02225F7CFB86AB0627FF86E895BCB3", hash_generated_method = "B318D7FDE241437C730C0CBAC33EB8FB")
    private void ensureMetaStateIsNormalized(int metaState) {
        addTaint(metaState);
        final int normalizedMetaState = KeyEvent.normalizeMetaState(metaState);
    if(normalizedMetaState != metaState)        
        {
            problem(String.format("Metastate not normalized.  Was 0x%08x but expected 0x%08x.",
                    metaState, normalizedMetaState));
        } //End block
        // ---------- Original Method ----------
        //final int normalizedMetaState = KeyEvent.normalizeMetaState(metaState);
        //if (normalizedMetaState != metaState) {
            //problem(String.format("Metastate not normalized.  Was 0x%08x but expected 0x%08x.",
                    //metaState, normalizedMetaState));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.924 -0400", hash_original_method = "960C41882671A36CAB1E6050FF4DEA3B", hash_generated_method = "F1E2266104622299B69C51DB7C8AA106")
    private void ensurePointerCountIsOneForThisAction(MotionEvent event) {
        addTaint(event.getTaint());
        final int pointerCount = event.getPointerCount();
    if(pointerCount != 1)        
        {
            problem("Pointer count is " + pointerCount + " but it should always be 1 for "
                    + MotionEvent.actionToString(event.getAction()));
        } //End block
        // ---------- Original Method ----------
        //final int pointerCount = event.getPointerCount();
        //if (pointerCount != 1) {
            //problem("Pointer count is " + pointerCount + " but it should always be 1 for "
                    //+ MotionEvent.actionToString(event.getAction()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.925 -0400", hash_original_method = "418A844BE60240583EF50FE17898B3BB", hash_generated_method = "8AD94D3E7F70876E28DF6AC01DA0CE55")
    private void ensureHistorySizeIsZeroForThisAction(MotionEvent event) {
        addTaint(event.getTaint());
        final int historySize = event.getHistorySize();
    if(historySize != 0)        
        {
            problem("History size is " + historySize + " but it should always be 0 for "
                    + MotionEvent.actionToString(event.getAction()));
        } //End block
        // ---------- Original Method ----------
        //final int historySize = event.getHistorySize();
        //if (historySize != 0) {
            //problem("History size is " + historySize + " but it should always be 0 for "
                    //+ MotionEvent.actionToString(event.getAction()));
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.926 -0400", hash_original_method = "4D608F0C62317EB539D3EDD1A5B0BBF8", hash_generated_method = "D702D6843E808FFE055E71FCB55FF43A")
    private boolean startEvent(InputEvent event, int nestingLevel, String eventType) {
    if(event == mLastEvent && nestingLevel < mLastNestingLevel
                && eventType == mLastEventType)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1273419640 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757124945 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_757124945;
        } //End block
    if(nestingLevel > 0)        
        {
            mLastEvent = event;
            mLastEventType = eventType;
            mLastNestingLevel = nestingLevel;
        } //End block
        else
        {
            mLastEvent = null;
            mLastEventType = null;
            mLastNestingLevel = 0;
        } //End block
        mCurrentEvent = event;
        mCurrentEventType = eventType;
        boolean varB326B5062B2F0E69046810717534CB09_2136259598 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034138595 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034138595;
        // ---------- Original Method ----------
        //if (event == mLastEvent && nestingLevel < mLastNestingLevel
                //&& eventType == mLastEventType) {
            //return false;
        //}
        //if (nestingLevel > 0) {
            //mLastEvent = event;
            //mLastEventType = eventType;
            //mLastNestingLevel = nestingLevel;
        //} else {
            //mLastEvent = null;
            //mLastEventType = null;
            //mLastNestingLevel = 0;
        //}
        //mCurrentEvent = event;
        //mCurrentEventType = eventType;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.927 -0400", hash_original_method = "ED6D322EBF7819A0A849ACCBA13E8A32", hash_generated_method = "0E728C2AA5DA84F1D56BFD35CC1EC338")
    private void finishEvent() {
    if(mViolationMessage != null && mViolationMessage.length() != 0)        
        {
    if(!mCurrentEvent.isTainted())            
            {
                mViolationMessage.append("\n  in ").append(mCaller);
                mViolationMessage.append("\n  ");
                appendEvent(mViolationMessage, 0, mCurrentEvent, false);
    if(RECENT_EVENTS_TO_LOG != 0 && mRecentEvents != null)                
                {
                    mViolationMessage.append("\n  -- recent events --");
for(int i = 0;i < RECENT_EVENTS_TO_LOG;i++)
                    {
                        final int index = (mMostRecentEventIndex + RECENT_EVENTS_TO_LOG - i)
                                % RECENT_EVENTS_TO_LOG;
                        final InputEvent event = mRecentEvents[index];
    if(event == null)                        
                        {
                            break;
                        } //End block
                        mViolationMessage.append("\n  ");
                        appendEvent(mViolationMessage, i + 1, event, mRecentEventsUnhandled[index]);
                    } //End block
                } //End block
                Log.d(mLogTag, mViolationMessage.toString());
                mCurrentEvent.setTainted(true);
            } //End block
            mViolationMessage.setLength(0);
        } //End block
    if(RECENT_EVENTS_TO_LOG != 0)        
        {
    if(mRecentEvents == null)            
            {
                mRecentEvents = new InputEvent[RECENT_EVENTS_TO_LOG];
                mRecentEventsUnhandled = new boolean[RECENT_EVENTS_TO_LOG];
            } //End block
            final int index = (mMostRecentEventIndex + 1) % RECENT_EVENTS_TO_LOG;
            mMostRecentEventIndex = index;
    if(mRecentEvents[index] != null)            
            {
                mRecentEvents[index].recycle();
            } //End block
            mRecentEvents[index] = mCurrentEvent.copy();
            mRecentEventsUnhandled[index] = false;
        } //End block
        mCurrentEvent = null;
        mCurrentEventType = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void appendEvent(StringBuilder message, int index,
            InputEvent event, boolean unhandled) {
        message.append(index).append(": sent at ").append(event.getEventTimeNano());
        message.append(", ");
        if (unhandled) {
            message.append("(unhandled) ");
        }
        message.append(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.929 -0400", hash_original_method = "C6124E8B7D001D6ECE47F875379D529E", hash_generated_method = "E12CAD1F34500F8FC54B030A85C101BC")
    private void problem(String message) {
        addTaint(message.getTaint());
    if(mViolationMessage == null)        
        {
            mViolationMessage = new StringBuilder();
        } //End block
    if(mViolationMessage.length() == 0)        
        {
            mViolationMessage.append(mCurrentEventType).append(": ");
        } //End block
        else
        {
            mViolationMessage.append("\n  ");
        } //End block
        mViolationMessage.append(message);
        // ---------- Original Method ----------
        //if (mViolationMessage == null) {
            //mViolationMessage = new StringBuilder();
        //}
        //if (mViolationMessage.length() == 0) {
            //mViolationMessage.append(mCurrentEventType).append(": ");
        //} else {
            //mViolationMessage.append("\n  ");
        //}
        //mViolationMessage.append(message);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.930 -0400", hash_original_method = "98F44F7E9C89F442263CA208119E2058", hash_generated_method = "48B545D132DE0E0DFB0C4F4AF149DB8B")
    private KeyState findKeyState(int deviceId, int source, int keyCode, boolean remove) {
        addTaint(remove);
        addTaint(keyCode);
        addTaint(source);
        addTaint(deviceId);
        KeyState last = null;
        KeyState state = mKeyStateList;
        while
(state != null)        
        {
    if(state.deviceId == deviceId && state.source == source
                    && state.keyCode == keyCode)            
            {
    if(remove)                
                {
    if(last != null)                    
                    {
                        last.next = state.next;
                    } //End block
                    else
                    {
                        mKeyStateList = state.next;
                    } //End block
                    state.next = null;
                } //End block
KeyState var37C56C9D63C623261861C16DCFB73F6D_816894037 =                 state;
                var37C56C9D63C623261861C16DCFB73F6D_816894037.addTaint(taint);
                return var37C56C9D63C623261861C16DCFB73F6D_816894037;
            } //End block
            last = state;
            state = state.next;
        } //End block
KeyState var540C13E9E156B687226421B24F2DF178_330038431 =         null;
        var540C13E9E156B687226421B24F2DF178_330038431.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_330038431;
        // ---------- Original Method ----------
        //KeyState last = null;
        //KeyState state = mKeyStateList;
        //while (state != null) {
            //if (state.deviceId == deviceId && state.source == source
                    //&& state.keyCode == keyCode) {
                //if (remove) {
                    //if (last != null) {
                        //last.next = state.next;
                    //} else {
                        //mKeyStateList = state.next;
                    //}
                    //state.next = null;
                //}
                //return state;
            //}
            //last = state;
            //state = state.next;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.932 -0400", hash_original_method = "49CD2D0DE125B77D543B3E0017318A6E", hash_generated_method = "FB1ECE31E15DC3332206BFD06182A06B")
    private void addKeyState(int deviceId, int source, int keyCode) {
        addTaint(keyCode);
        addTaint(source);
        addTaint(deviceId);
        KeyState state = KeyState.obtain(deviceId, source, keyCode);
        state.next = mKeyStateList;
        mKeyStateList = state;
        // ---------- Original Method ----------
        //KeyState state = KeyState.obtain(deviceId, source, keyCode);
        //state.next = mKeyStateList;
        //mKeyStateList = state;
    }

    
    private static final class KeyState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.932 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A4637F51FF091C45870D06CF8B571722")

        public KeyState next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.932 -0400", hash_original_field = "671B750DAD5F30D6EAF736B4CB910D35", hash_generated_field = "B25950F42C189E4AB05FFB7366B0AA73")

        public int deviceId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.932 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "865C846F4D1F08194526221E7C99DDEB")

        public int source;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.932 -0400", hash_original_field = "B96BEB1FB95F7FA45257BB48942AEF8A", hash_generated_field = "000F6935635EB02934CE0DE5E09F2D3E")

        public int keyCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.932 -0400", hash_original_field = "F500732166205CC78FB0A5FC01440B5E", hash_generated_field = "7DE29E460259F9098EBFCEFDF94DB0DA")

        public boolean unhandled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.932 -0400", hash_original_method = "9B72C46296302693275D5291E4057DE0", hash_generated_method = "46EE7D525ED839CFC8CA395DBE68DDF7")
        private  KeyState() {
            // ---------- Original Method ----------
        }

        
                public static KeyState obtain(int deviceId, int source, int keyCode) {
            KeyState state;
            synchronized (mRecycledListLock) {
                state = mRecycledList;
                if (state != null) {
                    mRecycledList = state.next;
                } else {
                    state = new KeyState();
                }
            }
            state.deviceId = deviceId;
            state.source = source;
            state.keyCode = keyCode;
            state.unhandled = false;
            return state;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.933 -0400", hash_original_method = "F16B27E6183802CE84F6921B26D81A30", hash_generated_method = "CC6AC4BC9D70480CD822939542AD2131")
        public void recycle() {
            synchronized
(mRecycledListLock)            {
                next = mRecycledList;
                mRecycledList = next;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mRecycledListLock) {
                //next = mRecycledList;
                //mRecycledList = next;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.933 -0400", hash_original_field = "2F26FA40588BE826278064C5E55CF30D", hash_generated_field = "79BE45FB0228F25C0A9DC9B58E9E4BD0")

        private static Object mRecycledListLock = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.933 -0400", hash_original_field = "FB0BE9294B410C125F1CF9B917162013", hash_generated_field = "379CC4BA4A594A20A4231B542C74B1F1")

        private static KeyState mRecycledList;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.934 -0400", hash_original_field = "9D23AE2E1DF0783311B7EE88635EC302", hash_generated_field = "5633022DA578E314CF52EE3A9C0CF47D")

    private static final boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.934 -0400", hash_original_field = "B23BAD53F57FAA7D6D0DDB56431F1C6D", hash_generated_field = "BF7F27BD11752360FD77D3ADB49DCD5E")

    private static final String EVENT_TYPE_KEY = "KeyEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.934 -0400", hash_original_field = "5693E6626829FCA7F478BA981291812A", hash_generated_field = "A473C2AB75307FC390ECD2C1507122DA")

    private static final String EVENT_TYPE_TRACKBALL = "TrackballEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.934 -0400", hash_original_field = "BD7073E4DEE05ECA262F691840D5A9A5", hash_generated_field = "D1EB06456AD7E3D660599184311AC822")

    private static final String EVENT_TYPE_TOUCH = "TouchEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.934 -0400", hash_original_field = "30F466EA9F17B988DF30952FE936D158", hash_generated_field = "357765B7CE50F3956441E3EA77451666")

    private static final String EVENT_TYPE_GENERIC_MOTION = "GenericMotionEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.934 -0400", hash_original_field = "4CA2B0E213BF2ED28B6656FE58CDEB9B", hash_generated_field = "1520184BDE53EF2FB714CE773B08074D")

    private static final int RECENT_EVENTS_TO_LOG = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.934 -0400", hash_original_field = "C40CAA681DE8375D99C611EE6180DE21", hash_generated_field = "1C85819CF19DB466C1BC01FCC89D7D5E")

    public static final int FLAG_RAW_DEVICE_INPUT = 1 << 0;
}

