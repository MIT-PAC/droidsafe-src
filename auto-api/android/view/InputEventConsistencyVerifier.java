package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Build;
import android.util.Log;

public final class InputEventConsistencyVerifier {
    private Object mCaller;
    private int mFlags;
    private String mLogTag;
    private InputEvent mLastEvent;
    private String mLastEventType;
    private int mLastNestingLevel;
    private InputEvent[] mRecentEvents;
    private boolean[] mRecentEventsUnhandled;
    private int mMostRecentEventIndex;
    private InputEvent mCurrentEvent;
    private String mCurrentEventType;
    private KeyState mKeyStateList;
    private boolean mTrackballDown;
    private boolean mTrackballUnhandled;
    private int mTouchEventStreamPointers;
    private int mTouchEventStreamDeviceId = -1;
    private int mTouchEventStreamSource;
    private boolean mTouchEventStreamIsTainted;
    private boolean mTouchEventStreamUnhandled;
    private boolean mHoverEntered;
    private StringBuilder mViolationMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.916 -0400", hash_original_method = "D65E8A245B5C473707AFD205D57D3AF8", hash_generated_method = "A5B1D2DFA661EA3A2B6688AE8E01B091")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputEventConsistencyVerifier(Object caller, int flags) {
        this(caller, flags, InputEventConsistencyVerifier.class.getSimpleName());
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.916 -0400", hash_original_method = "31CA6A116339576A3C7E1C4293F4F7B1", hash_generated_method = "A0214F5B2C0D9EB10AE4F93D054F16EF")
    @DSModeled(DSC.SAFE)
    public InputEventConsistencyVerifier(Object caller, int flags, String logTag) {
        dsTaint.addTaint(caller.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(logTag);
        this.mLogTag = (logTag != null) ? logTag : "InputEventConsistencyVerifier";
        // ---------- Original Method ----------
        //this.mCaller = caller;
        //this.mFlags = flags;
        //this.mLogTag = (logTag != null) ? logTag : "InputEventConsistencyVerifier";
    }

    
        public static boolean isInstrumentationEnabled() {
        return IS_ENG_BUILD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.916 -0400", hash_original_method = "13418E29B3FCE72BDE84CBF193C1BADD", hash_generated_method = "D7CDA61C79F157179A553E8CADD14BCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reset() {
        mLastEvent = null;
        mLastNestingLevel = 0;
        mTrackballDown = false;
        mTrackballUnhandled = false;
        mTouchEventStreamPointers = 0;
        mTouchEventStreamIsTainted = false;
        mTouchEventStreamUnhandled = false;
        mHoverEntered = false;
        {
            KeyState state;
            state = mKeyStateList;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.917 -0400", hash_original_method = "9981F0DD702462FD09DA371539E225DF", hash_generated_method = "B43F408134FF34BCBE90E803D49C72A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onInputEvent(InputEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(nestingLevel);
        dsTaint.addTaint(event.dsTaint);
        {
            KeyEvent keyEvent;
            keyEvent = (KeyEvent)event;
            onKeyEvent(keyEvent, nestingLevel);
        } //End block
        {
            MotionEvent motionEvent;
            motionEvent = (MotionEvent)event;
            {
                boolean var1D97065BD820BD0456B45C7E9DBBA082_934563949 = (motionEvent.isTouchEvent());
                {
                    onTouchEvent(motionEvent, nestingLevel);
                } //End block
                {
                    boolean var1548696A1C108F52D98124BF03CF8313_295093095 = ((motionEvent.getSource() & InputDevice.SOURCE_CLASS_TRACKBALL) != 0);
                    {
                        onTrackballEvent(motionEvent, nestingLevel);
                    } //End block
                    {
                        onGenericMotionEvent(motionEvent, nestingLevel);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.918 -0400", hash_original_method = "37A5317EE58F7483AB8019E5DEA39C1C", hash_generated_method = "6DDEC731A11D4A37634A74B754AB8AE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onKeyEvent(KeyEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(nestingLevel);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var1C9540E6394A7A11097E4E4C24A69E5A_1601965182 = (!startEvent(event, nestingLevel, EVENT_TYPE_KEY));
        } //End collapsed parenthetic
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            int action;
            action = event.getAction();
            int deviceId;
            deviceId = event.getDeviceId();
            int source;
            source = event.getSource();
            int keyCode;
            keyCode = event.getKeyCode();
            //Begin case KeyEvent.ACTION_DOWN 
            {
                KeyState state;
                state = findKeyState(deviceId, source, keyCode,  false);
                {
                    {
                        state.unhandled = false;
                    } //End block
                    {
                        boolean varBB7C3BAA0F2DE303A64E00E840FF7A59_386258291 = ((mFlags & FLAG_RAW_DEVICE_INPUT) == 0
                                && event.getRepeatCount() == 0);
                        {
                            problem("ACTION_DOWN but key is already down and this event "
                                    + "is not a key repeat.");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    addKeyState(deviceId, source, keyCode);
                } //End block
            } //End block
            //End case KeyEvent.ACTION_DOWN 
            //Begin case KeyEvent.ACTION_UP 
            {
                KeyState state;
                state = findKeyState(deviceId, source, keyCode,  true);
                {
                    problem("ACTION_UP but key was not down.");
                } //End block
                {
                    state.recycle();
                } //End block
            } //End block
            //End case KeyEvent.ACTION_UP 
            //Begin case default 
            problem("Invalid action " + KeyEvent.actionToString(action)
                            + " for key event.");
            //End case default 
        } //End block
        finally 
        {
            finishEvent();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.919 -0400", hash_original_method = "742053359AC2416542EBDE8E8736FB44", hash_generated_method = "1FBFA141258AA45200CBFCDD5F0E47AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onTrackballEvent(MotionEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(nestingLevel);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var5BA64422812B4CD0774617583F7E1D53_1478293655 = (!startEvent(event, nestingLevel, EVENT_TYPE_TRACKBALL));
        } //End collapsed parenthetic
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            int action;
            action = event.getAction();
            int source;
            source = event.getSource();
            {
                //Begin case MotionEvent.ACTION_DOWN 
                {
                    problem("ACTION_DOWN but trackball is already down.");
                } //End block
                {
                    mTrackballDown = true;
                    mTrackballUnhandled = false;
                } //End block
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                ensureHistorySizeIsZeroForThisAction(event);
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                ensurePointerCountIsOneForThisAction(event);
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_UP 
                {
                    problem("ACTION_UP but trackball is not down.");
                } //End block
                {
                    mTrackballDown = false;
                    mTrackballUnhandled = false;
                } //End block
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_UP 
                ensureHistorySizeIsZeroForThisAction(event);
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_UP 
                ensurePointerCountIsOneForThisAction(event);
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_MOVE 
                ensurePointerCountIsOneForThisAction(event);
                //End case MotionEvent.ACTION_MOVE 
                //Begin case default 
                problem("Invalid action " + MotionEvent.actionToString(action)
                                + " for trackball event.");
                //End case default 
                {
                    boolean varF8125AB1D243142529D579C7BF1C5525_17804765 = (mTrackballDown && event.getPressure() <= 0);
                    {
                        problem("Trackball is down but pressure is not greater than 0.");
                    } //End block
                    {
                        boolean var48456D7B62EC643623B97245B65EE0A7_264703654 = (!mTrackballDown && event.getPressure() != 0);
                        {
                            problem("Trackball is up but pressure is not equal to 0.");
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.921 -0400", hash_original_method = "F64D7AF6BB2368971DDEEF01EB83BDA6", hash_generated_method = "FCC50A5F2889233F1965AFD3A4C8B110")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onTouchEvent(MotionEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(nestingLevel);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var5C200FBFC1B0213F6CDA14409F83D214_976177908 = (!startEvent(event, nestingLevel, EVENT_TYPE_TOUCH));
        } //End collapsed parenthetic
        int action;
        action = event.getAction();
        boolean newStream;
        newStream = action == MotionEvent.ACTION_DOWN
                || action == MotionEvent.ACTION_CANCEL;
        {
            mTouchEventStreamIsTainted = false;
            mTouchEventStreamUnhandled = false;
            mTouchEventStreamPointers = 0;
        } //End block
        {
            event.setTainted(true);
        } //End block
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            int deviceId;
            deviceId = event.getDeviceId();
            int source;
            source = event.getSource();
            {
                problem("Touch event stream contains events from multiple sources: "
                        + "previous device id " + mTouchEventStreamDeviceId
                        + ", previous source " + Integer.toHexString(mTouchEventStreamSource)
                        + ", new device id " + deviceId
                        + ", new source " + Integer.toHexString(source));
            } //End block
            mTouchEventStreamDeviceId = deviceId;
            mTouchEventStreamSource = source;
            int pointerCount;
            pointerCount = event.getPointerCount();
            {
                //Begin case MotionEvent.ACTION_DOWN 
                {
                    problem("ACTION_DOWN but pointers are already down.  "
                                    + "Probably missing ACTION_UP from previous gesture.");
                } //End block
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                ensureHistorySizeIsZeroForThisAction(event);
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                ensurePointerCountIsOneForThisAction(event);
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_DOWN 
                mTouchEventStreamPointers = 1 << event.getPointerId(0);
                //End case MotionEvent.ACTION_DOWN 
                //Begin case MotionEvent.ACTION_UP 
                ensureHistorySizeIsZeroForThisAction(event);
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_UP 
                ensurePointerCountIsOneForThisAction(event);
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_UP 
                mTouchEventStreamPointers = 0;
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_UP 
                mTouchEventStreamIsTainted = false;
                //End case MotionEvent.ACTION_UP 
                //Begin case MotionEvent.ACTION_MOVE 
                {
                    int expectedPointerCount;
                    expectedPointerCount = Integer.bitCount(mTouchEventStreamPointers);
                    {
                        problem("ACTION_MOVE contained " + pointerCount
                                    + " pointers but there are currently "
                                    + expectedPointerCount + " pointers down.");
                        mTouchEventStreamIsTainted = true;
                    } //End block
                } //End block
                //End case MotionEvent.ACTION_MOVE 
                //Begin case MotionEvent.ACTION_CANCEL 
                mTouchEventStreamPointers = 0;
                //End case MotionEvent.ACTION_CANCEL 
                //Begin case MotionEvent.ACTION_CANCEL 
                mTouchEventStreamIsTainted = false;
                //End case MotionEvent.ACTION_CANCEL 
                //Begin case MotionEvent.ACTION_OUTSIDE 
                {
                    problem("ACTION_OUTSIDE but pointers are still down.");
                } //End block
                //End case MotionEvent.ACTION_OUTSIDE 
                //Begin case MotionEvent.ACTION_OUTSIDE 
                ensureHistorySizeIsZeroForThisAction(event);
                //End case MotionEvent.ACTION_OUTSIDE 
                //Begin case MotionEvent.ACTION_OUTSIDE 
                ensurePointerCountIsOneForThisAction(event);
                //End case MotionEvent.ACTION_OUTSIDE 
                //Begin case MotionEvent.ACTION_OUTSIDE 
                mTouchEventStreamIsTainted = false;
                //End case MotionEvent.ACTION_OUTSIDE 
                //Begin case default 
                {
                    int actionMasked;
                    actionMasked = event.getActionMasked();
                    int actionIndex;
                    actionIndex = event.getActionIndex();
                    {
                        {
                            problem("ACTION_POINTER_DOWN but no other pointers were down.");
                            mTouchEventStreamIsTainted = true;
                        } //End block
                        {
                            problem("ACTION_POINTER_DOWN index is " + actionIndex
                                        + " but the pointer count is " + pointerCount + ".");
                            mTouchEventStreamIsTainted = true;
                        } //End block
                        {
                            int id;
                            id = event.getPointerId(actionIndex);
                            int idBit;
                            idBit = 1 << id;
                            {
                                problem("ACTION_POINTER_DOWN specified pointer id " + id
                                            + " which is already down.");
                                mTouchEventStreamIsTainted = true;
                            } //End block
                            {
                                mTouchEventStreamPointers |= idBit;
                            } //End block
                        } //End block
                        ensureHistorySizeIsZeroForThisAction(event);
                    } //End block
                    {
                        {
                            problem("ACTION_POINTER_UP index is " + actionIndex
                                        + " but the pointer count is " + pointerCount + ".");
                            mTouchEventStreamIsTainted = true;
                        } //End block
                        {
                            int id;
                            id = event.getPointerId(actionIndex);
                            int idBit;
                            idBit = 1 << id;
                            {
                                problem("ACTION_POINTER_UP specified pointer id " + id
                                            + " which is not currently down.");
                                mTouchEventStreamIsTainted = true;
                            } //End block
                            {
                                mTouchEventStreamPointers &= ~idBit;
                            } //End block
                        } //End block
                        ensureHistorySizeIsZeroForThisAction(event);
                    } //End block
                    {
                        problem("Invalid action " + MotionEvent.actionToString(action)
                                    + " for touch event.");
                    } //End block
                } //End block
                //End case default 
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.922 -0400", hash_original_method = "23EA37DFEC977078F682E35F151F1942", hash_generated_method = "84FC8A465DE60E2E8DE529484AA88A48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onGenericMotionEvent(MotionEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(nestingLevel);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var6C693FE76F7AB1F8804D07C4E7E4F955_1675192995 = (!startEvent(event, nestingLevel, EVENT_TYPE_GENERIC_MOTION));
        } //End collapsed parenthetic
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            int action;
            action = event.getAction();
            int source;
            source = event.getSource();
            {
                //Begin case MotionEvent.ACTION_HOVER_ENTER 
                ensurePointerCountIsOneForThisAction(event);
                //End case MotionEvent.ACTION_HOVER_ENTER 
                //Begin case MotionEvent.ACTION_HOVER_ENTER 
                mHoverEntered = true;
                //End case MotionEvent.ACTION_HOVER_ENTER 
                //Begin case MotionEvent.ACTION_HOVER_MOVE 
                ensurePointerCountIsOneForThisAction(event);
                //End case MotionEvent.ACTION_HOVER_MOVE 
                //Begin case MotionEvent.ACTION_HOVER_EXIT 
                ensurePointerCountIsOneForThisAction(event);
                //End case MotionEvent.ACTION_HOVER_EXIT 
                //Begin case MotionEvent.ACTION_HOVER_EXIT 
                {
                    problem("ACTION_HOVER_EXIT without prior ACTION_HOVER_ENTER");
                } //End block
                //End case MotionEvent.ACTION_HOVER_EXIT 
                //Begin case MotionEvent.ACTION_HOVER_EXIT 
                mHoverEntered = false;
                //End case MotionEvent.ACTION_HOVER_EXIT 
                //Begin case MotionEvent.ACTION_SCROLL 
                ensureHistorySizeIsZeroForThisAction(event);
                //End case MotionEvent.ACTION_SCROLL 
                //Begin case MotionEvent.ACTION_SCROLL 
                ensurePointerCountIsOneForThisAction(event);
                //End case MotionEvent.ACTION_SCROLL 
                //Begin case default 
                problem("Invalid action for generic pointer event.");
                //End case default 
            } //End block
            {
                //Begin case MotionEvent.ACTION_MOVE 
                ensurePointerCountIsOneForThisAction(event);
                //End case MotionEvent.ACTION_MOVE 
                //Begin case default 
                problem("Invalid action for generic joystick event.");
                //End case default 
            } //End block
        } //End block
        finally 
        {
            finishEvent();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.922 -0400", hash_original_method = "95A33BD7B12ABE8439BBD32736BE35D7", hash_generated_method = "F075A780DF8F9C2A44D985933CAAC9F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onUnhandledEvent(InputEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(nestingLevel);
        dsTaint.addTaint(event.dsTaint);
        {
            mRecentEventsUnhandled[mMostRecentEventIndex] = true;
        } //End block
        {
            KeyEvent keyEvent;
            keyEvent = (KeyEvent)event;
            int deviceId;
            deviceId = keyEvent.getDeviceId();
            int source;
            source = keyEvent.getSource();
            int keyCode;
            keyCode = keyEvent.getKeyCode();
            KeyState state;
            state = findKeyState(deviceId, source, keyCode,  false);
            {
                state.unhandled = true;
            } //End block
        } //End block
        {
            MotionEvent motionEvent;
            motionEvent = (MotionEvent)event;
            {
                boolean var1D97065BD820BD0456B45C7E9DBBA082_346291604 = (motionEvent.isTouchEvent());
                {
                    mTouchEventStreamUnhandled = true;
                } //End block
                {
                    boolean var1548696A1C108F52D98124BF03CF8313_303553665 = ((motionEvent.getSource() & InputDevice.SOURCE_CLASS_TRACKBALL) != 0);
                    {
                        {
                            mTrackballUnhandled = true;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.922 -0400", hash_original_method = "0D02225F7CFB86AB0627FF86E895BCB3", hash_generated_method = "010DF0382C9141526390EC3C0A9B643E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureMetaStateIsNormalized(int metaState) {
        dsTaint.addTaint(metaState);
        int normalizedMetaState;
        normalizedMetaState = KeyEvent.normalizeMetaState(metaState);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.923 -0400", hash_original_method = "960C41882671A36CAB1E6050FF4DEA3B", hash_generated_method = "E0D0B2BA3B3A58717B7E7E0A461E60BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensurePointerCountIsOneForThisAction(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        int pointerCount;
        pointerCount = event.getPointerCount();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.923 -0400", hash_original_method = "418A844BE60240583EF50FE17898B3BB", hash_generated_method = "D36AA3C2E475EE3E0504FB4BE55F8871")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureHistorySizeIsZeroForThisAction(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        int historySize;
        historySize = event.getHistorySize();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.923 -0400", hash_original_method = "4D608F0C62317EB539D3EDD1A5B0BBF8", hash_generated_method = "92C16905BFED32AE90BB15146E5C0EAD")
    @DSModeled(DSC.SAFE)
    private boolean startEvent(InputEvent event, int nestingLevel, String eventType) {
        dsTaint.addTaint(nestingLevel);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(eventType);
        {
            mLastEvent = null;
            mLastEventType = null;
            mLastNestingLevel = 0;
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.924 -0400", hash_original_method = "ED6D322EBF7819A0A849ACCBA13E8A32", hash_generated_method = "0508F019E47243A4022B22E240AC3D42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finishEvent() {
        {
            boolean var900C4014E5F18032AC7EF14D50B77173_209534243 = (mViolationMessage != null && mViolationMessage.length() != 0);
            {
                {
                    boolean varF73E249DD60ACAF7AD897F2896801AA9_1227500004 = (!mCurrentEvent.isTainted());
                    {
                        mViolationMessage.append("\n  in ").append(mCaller);
                        mViolationMessage.append("\n  ");
                        appendEvent(mViolationMessage, 0, mCurrentEvent, false);
                        {
                            mViolationMessage.append("\n  -- recent events --");
                            {
                                int i;
                                i = 0;
                                {
                                    int index;
                                    index = (mMostRecentEventIndex + RECENT_EVENTS_TO_LOG - i)
                                % RECENT_EVENTS_TO_LOG;
                                    InputEvent event;
                                    event = mRecentEvents[index];
                                    mViolationMessage.append("\n  ");
                                    appendEvent(mViolationMessage, i + 1, event, mRecentEventsUnhandled[index]);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        Log.d(mLogTag, mViolationMessage.toString());
                        mCurrentEvent.setTainted(true);
                    } //End block
                } //End collapsed parenthetic
                mViolationMessage.setLength(0);
            } //End block
        } //End collapsed parenthetic
        {
            {
                mRecentEvents = new InputEvent[RECENT_EVENTS_TO_LOG];
                mRecentEventsUnhandled = new boolean[RECENT_EVENTS_TO_LOG];
            } //End block
            int index;
            index = (mMostRecentEventIndex + 1) % RECENT_EVENTS_TO_LOG;
            mMostRecentEventIndex = index;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.924 -0400", hash_original_method = "C6124E8B7D001D6ECE47F875379D529E", hash_generated_method = "2A2A94841288E9B98A25C2AB17EBBE53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void problem(String message) {
        dsTaint.addTaint(message);
        {
            mViolationMessage = new StringBuilder();
        } //End block
        {
            boolean varADDF521E749D23BF1A55223D8CD76170_414047376 = (mViolationMessage.length() == 0);
            {
                mViolationMessage.append(mCurrentEventType).append(": ");
            } //End block
            {
                mViolationMessage.append("\n  ");
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.924 -0400", hash_original_method = "98F44F7E9C89F442263CA208119E2058", hash_generated_method = "BF125DDFC2F4AACC3A7DA4DD7A6A8635")
    @DSModeled(DSC.SAFE)
    private KeyState findKeyState(int deviceId, int source, int keyCode, boolean remove) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(remove);
        dsTaint.addTaint(source);
        dsTaint.addTaint(deviceId);
        KeyState last;
        last = null;
        KeyState state;
        state = mKeyStateList;
        {
            {
                {
                    {
                        last.next = state.next;
                    } //End block
                    {
                        mKeyStateList = state.next;
                    } //End block
                    state.next = null;
                } //End block
            } //End block
            last = state;
            state = state.next;
        } //End block
        return (KeyState)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.925 -0400", hash_original_method = "49CD2D0DE125B77D543B3E0017318A6E", hash_generated_method = "90FD06C36AAD8409BB8B39BE042B976C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addKeyState(int deviceId, int source, int keyCode) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(source);
        dsTaint.addTaint(deviceId);
        KeyState state;
        state = KeyState.obtain(deviceId, source, keyCode);
        state.next = mKeyStateList;
        mKeyStateList = state;
        // ---------- Original Method ----------
        //KeyState state = KeyState.obtain(deviceId, source, keyCode);
        //state.next = mKeyStateList;
        //mKeyStateList = state;
    }

    
    private static final class KeyState {
        public KeyState next;
        public int deviceId;
        public int source;
        public int keyCode;
        public boolean unhandled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.925 -0400", hash_original_method = "9B72C46296302693275D5291E4057DE0", hash_generated_method = "46EE7D525ED839CFC8CA395DBE68DDF7")
        @DSModeled(DSC.SAFE)
        private KeyState() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.925 -0400", hash_original_method = "F16B27E6183802CE84F6921B26D81A30", hash_generated_method = "B629E2138B7F43397A9CD306024B7EA5")
        @DSModeled(DSC.SAFE)
        public void recycle() {
            {
                next = mRecycledList;
                mRecycledList = next;
            } //End block
            // ---------- Original Method ----------
            //synchronized (mRecycledListLock) {
                //next = mRecycledList;
                //mRecycledList = next;
            //}
        }

        
        private static Object mRecycledListLock = new Object();
        private static KeyState mRecycledList;
    }


    
    private static final boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
    private static final String EVENT_TYPE_KEY = "KeyEvent";
    private static final String EVENT_TYPE_TRACKBALL = "TrackballEvent";
    private static final String EVENT_TYPE_TOUCH = "TouchEvent";
    private static final String EVENT_TYPE_GENERIC_MOTION = "GenericMotionEvent";
    private static final int RECENT_EVENTS_TO_LOG = 5;
    public static final int FLAG_RAW_DEVICE_INPUT = 1 << 0;
}

