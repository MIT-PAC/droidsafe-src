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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.976 -0400", hash_original_field = "02B8E2B08EEFD631BD36F22665C339F2", hash_generated_field = "842464D18B9CC1D906D30912951F1B29")

    private Object mCaller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.976 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private int mFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.976 -0400", hash_original_field = "503F6607C959C61B036C1484733875DB", hash_generated_field = "59F9615F1046A159253328ABFF9EBAC4")

    private String mLogTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.976 -0400", hash_original_field = "EE9CC63E94F20AF8999429F0CFA81933", hash_generated_field = "CAF007840D1F7323B1001E7DD39DA851")

    private InputEvent mLastEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.976 -0400", hash_original_field = "A0ABA9CA907A59C8D456966BBA1B3887", hash_generated_field = "7BD27485A06A6A1AC8080AE3638DE4F4")

    private String mLastEventType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.976 -0400", hash_original_field = "9B5513F064DD0C164336A4318307FD8E", hash_generated_field = "6141C906002BAC7131BFF645A86E7469")

    private int mLastNestingLevel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "19DEACD4170AE518A6DE25F40D57CC5E", hash_generated_field = "860F0DD6CB41AA51A689A023866EB3EC")

    private InputEvent[] mRecentEvents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "1CBB3F568975EF8EC30EEC1AB97967F2", hash_generated_field = "EA05C25F3223B278A2037BD67E368C3A")

    private boolean[] mRecentEventsUnhandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "96ABAE2065AC7130FA9A0F86D456D0B5", hash_generated_field = "30754FF941B62BB39BC4DA77B462515F")

    private int mMostRecentEventIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "37155EC34151C4A4C889EC884F50AEEA", hash_generated_field = "41D4493BA1E5584628EA45425F6D040D")

    private InputEvent mCurrentEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "AB1A563C338454CDCDE6E69607B9426B", hash_generated_field = "6DB375435025884B6151B31AFFFABC76")

    private String mCurrentEventType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "EABE08FDF07FFC82E191D864B705E825", hash_generated_field = "54CDF24A71BB09237A10056FCD052ACC")

    private KeyState mKeyStateList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "CC8BB3617BE25520DEF765C8BDA61DEB", hash_generated_field = "EE4A6262291D828DA2F877FD0D0E2FF0")

    private boolean mTrackballDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "401E99879E2D5AB198383085D49D3A06", hash_generated_field = "A06A640C9360F807D330C6AC7DC6EC56")

    private boolean mTrackballUnhandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "29D0EFD7BBEBE9EF2D55C8D205D29A42", hash_generated_field = "2E6E4A3402809A29F95231522CC6E70D")

    private int mTouchEventStreamPointers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "76A973B325B8C28F2B88CFCCE43EA268", hash_generated_field = "55B14E4F3F5DFF6FBC6711B83FE98065")

    private int mTouchEventStreamDeviceId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "36B6F011CE0CBE093880BFCE3E88F860", hash_generated_field = "301EA641826E495DAC0F1004C4FD7D72")

    private int mTouchEventStreamSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "D28D9276F0CCF57EAA41F1CA21516D3A", hash_generated_field = "4ADB7785313125C3F9545C94531D1258")

    private boolean mTouchEventStreamIsTainted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "97E3F7FCB6911501B81AF9CEA6EB9D1F", hash_generated_field = "AAA9E205D77F337A8F1503284ADA9497")

    private boolean mTouchEventStreamUnhandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "ABC622DD1CF6B937B2EE57C4308724EF", hash_generated_field = "A1EEE3B7C7E4EEB7928D87C1E14B5A64")

    private boolean mHoverEntered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_field = "0FF2EDE5A69E1ED5164E5AE0CA0A580F", hash_generated_field = "0E37C0AC706495641748D32B4C94C2EF")

    private StringBuilder mViolationMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.977 -0400", hash_original_method = "D65E8A245B5C473707AFD205D57D3AF8", hash_generated_method = "591FC6399E9E7DE182F3E81EA2CB9081")
    public  InputEventConsistencyVerifier(Object caller, int flags) {
        this(caller, flags, InputEventConsistencyVerifier.class.getSimpleName());
        addTaint(caller.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.978 -0400", hash_original_method = "31CA6A116339576A3C7E1C4293F4F7B1", hash_generated_method = "25151441769D8C7D937887594A926350")
    public  InputEventConsistencyVerifier(Object caller, int flags, String logTag) {
        this.mCaller = caller;
        this.mFlags = flags;
        this.mLogTag = (logTag != null) ? logTag : "InputEventConsistencyVerifier";
        // ---------- Original Method ----------
        //this.mCaller = caller;
        //this.mFlags = flags;
        //this.mLogTag = (logTag != null) ? logTag : "InputEventConsistencyVerifier";
    }

    
        public static boolean isInstrumentationEnabled() {
        return IS_ENG_BUILD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.988 -0400", hash_original_method = "13418E29B3FCE72BDE84CBF193C1BADD", hash_generated_method = "D7CDA61C79F157179A553E8CADD14BCE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.989 -0400", hash_original_method = "9981F0DD702462FD09DA371539E225DF", hash_generated_method = "762934E226DB1D6EB411EE03F9410969")
    public void onInputEvent(InputEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            KeyEvent keyEvent;
            keyEvent = (KeyEvent)event;
            onKeyEvent(keyEvent, nestingLevel);
        } //End block
        {
            MotionEvent motionEvent;
            motionEvent = (MotionEvent)event;
            {
                boolean var1D97065BD820BD0456B45C7E9DBBA082_852384091 = (motionEvent.isTouchEvent());
                {
                    onTouchEvent(motionEvent, nestingLevel);
                } //End block
                {
                    boolean var1548696A1C108F52D98124BF03CF8313_1527107370 = ((motionEvent.getSource() & InputDevice.SOURCE_CLASS_TRACKBALL) != 0);
                    {
                        onTrackballEvent(motionEvent, nestingLevel);
                    } //End block
                    {
                        onGenericMotionEvent(motionEvent, nestingLevel);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        addTaint(event.getTaint());
        addTaint(nestingLevel);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.001 -0400", hash_original_method = "37A5317EE58F7483AB8019E5DEA39C1C", hash_generated_method = "B389C3118EC441A28C9D3B1EF453F0AF")
    public void onKeyEvent(KeyEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var1C9540E6394A7A11097E4E4C24A69E5A_1194586588 = (!startEvent(event, nestingLevel, EVENT_TYPE_KEY));
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
                        boolean varBB7C3BAA0F2DE303A64E00E840FF7A59_188130969 = ((mFlags & FLAG_RAW_DEVICE_INPUT) == 0
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
        addTaint(event.getTaint());
        addTaint(nestingLevel);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.006 -0400", hash_original_method = "742053359AC2416542EBDE8E8736FB44", hash_generated_method = "D013072F326B9F661757689DB4712AA0")
    public void onTrackballEvent(MotionEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var5BA64422812B4CD0774617583F7E1D53_1495917839 = (!startEvent(event, nestingLevel, EVENT_TYPE_TRACKBALL));
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
                    boolean varF8125AB1D243142529D579C7BF1C5525_2008302702 = (mTrackballDown && event.getPressure() <= 0);
                    {
                        problem("Trackball is down but pressure is not greater than 0.");
                    } //End block
                    {
                        boolean var48456D7B62EC643623B97245B65EE0A7_1155964012 = (!mTrackballDown && event.getPressure() != 0);
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
        addTaint(event.getTaint());
        addTaint(nestingLevel);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.021 -0400", hash_original_method = "F64D7AF6BB2368971DDEEF01EB83BDA6", hash_generated_method = "4CF15748C5640246BC99E31925470B60")
    public void onTouchEvent(MotionEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var5C200FBFC1B0213F6CDA14409F83D214_1496806189 = (!startEvent(event, nestingLevel, EVENT_TYPE_TOUCH));
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
        addTaint(nestingLevel);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.035 -0400", hash_original_method = "23EA37DFEC977078F682E35F151F1942", hash_generated_method = "E2F668E1AFCECD36DCFBA7AF5642CA57")
    public void onGenericMotionEvent(MotionEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var6C693FE76F7AB1F8804D07C4E7E4F955_998918289 = (!startEvent(event, nestingLevel, EVENT_TYPE_GENERIC_MOTION));
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
        addTaint(event.getTaint());
        addTaint(nestingLevel);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.036 -0400", hash_original_method = "95A33BD7B12ABE8439BBD32736BE35D7", hash_generated_method = "541FB9F4849ED4E4C5ED92C27B866A78")
    public void onUnhandledEvent(InputEvent event, int nestingLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
                boolean var1D97065BD820BD0456B45C7E9DBBA082_1661095907 = (motionEvent.isTouchEvent());
                {
                    mTouchEventStreamUnhandled = true;
                } //End block
                {
                    boolean var1548696A1C108F52D98124BF03CF8313_1954052309 = ((motionEvent.getSource() & InputDevice.SOURCE_CLASS_TRACKBALL) != 0);
                    {
                        {
                            mTrackballUnhandled = true;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        addTaint(event.getTaint());
        addTaint(nestingLevel);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.046 -0400", hash_original_method = "0D02225F7CFB86AB0627FF86E895BCB3", hash_generated_method = "E0CE0EC0BF1FFD9E2AF81039BE46804E")
    private void ensureMetaStateIsNormalized(int metaState) {
        int normalizedMetaState;
        normalizedMetaState = KeyEvent.normalizeMetaState(metaState);
        {
            problem(String.format("Metastate not normalized.  Was 0x%08x but expected 0x%08x.",
                    metaState, normalizedMetaState));
        } //End block
        addTaint(metaState);
        // ---------- Original Method ----------
        //final int normalizedMetaState = KeyEvent.normalizeMetaState(metaState);
        //if (normalizedMetaState != metaState) {
            //problem(String.format("Metastate not normalized.  Was 0x%08x but expected 0x%08x.",
                    //metaState, normalizedMetaState));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.046 -0400", hash_original_method = "960C41882671A36CAB1E6050FF4DEA3B", hash_generated_method = "B94DA7A6A6E3346BC9CC70B4145A7347")
    private void ensurePointerCountIsOneForThisAction(MotionEvent event) {
        int pointerCount;
        pointerCount = event.getPointerCount();
        {
            problem("Pointer count is " + pointerCount + " but it should always be 1 for "
                    + MotionEvent.actionToString(event.getAction()));
        } //End block
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //final int pointerCount = event.getPointerCount();
        //if (pointerCount != 1) {
            //problem("Pointer count is " + pointerCount + " but it should always be 1 for "
                    //+ MotionEvent.actionToString(event.getAction()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.051 -0400", hash_original_method = "418A844BE60240583EF50FE17898B3BB", hash_generated_method = "35B453FCF85CB5051E1019CB59546869")
    private void ensureHistorySizeIsZeroForThisAction(MotionEvent event) {
        int historySize;
        historySize = event.getHistorySize();
        {
            problem("History size is " + historySize + " but it should always be 0 for "
                    + MotionEvent.actionToString(event.getAction()));
        } //End block
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //final int historySize = event.getHistorySize();
        //if (historySize != 0) {
            //problem("History size is " + historySize + " but it should always be 0 for "
                    //+ MotionEvent.actionToString(event.getAction()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.068 -0400", hash_original_method = "4D608F0C62317EB539D3EDD1A5B0BBF8", hash_generated_method = "1E9976CC457BC00FBB583D0C828492AE")
    private boolean startEvent(InputEvent event, int nestingLevel, String eventType) {
        {
            mLastEvent = event;
            mLastEventType = eventType;
            mLastNestingLevel = nestingLevel;
        } //End block
        {
            mLastEvent = null;
            mLastEventType = null;
            mLastNestingLevel = 0;
        } //End block
        mCurrentEvent = event;
        mCurrentEventType = eventType;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1851644153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1851644153;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.070 -0400", hash_original_method = "ED6D322EBF7819A0A849ACCBA13E8A32", hash_generated_method = "3F0AC713E82BF68590D0AD81BA2546B9")
    private void finishEvent() {
        {
            boolean var900C4014E5F18032AC7EF14D50B77173_1855938284 = (mViolationMessage != null && mViolationMessage.length() != 0);
            {
                {
                    boolean varF73E249DD60ACAF7AD897F2896801AA9_1833500838 = (!mCurrentEvent.isTainted());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.079 -0400", hash_original_method = "C6124E8B7D001D6ECE47F875379D529E", hash_generated_method = "C5112479FC00F171A7C27EA6964A3151")
    private void problem(String message) {
        {
            mViolationMessage = new StringBuilder();
        } //End block
        {
            boolean varADDF521E749D23BF1A55223D8CD76170_871181816 = (mViolationMessage.length() == 0);
            {
                mViolationMessage.append(mCurrentEventType).append(": ");
            } //End block
            {
                mViolationMessage.append("\n  ");
            } //End block
        } //End collapsed parenthetic
        mViolationMessage.append(message);
        addTaint(message.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.080 -0400", hash_original_method = "98F44F7E9C89F442263CA208119E2058", hash_generated_method = "0E25810081881DFBAFBF8B891BAECD3D")
    private KeyState findKeyState(int deviceId, int source, int keyCode, boolean remove) {
        KeyState varB4EAC82CA7396A68D541C85D26508E83_1151734405 = null; //Variable for return #1
        KeyState varB4EAC82CA7396A68D541C85D26508E83_1138485214 = null; //Variable for return #2
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
                varB4EAC82CA7396A68D541C85D26508E83_1151734405 = state;
            } //End block
            last = state;
            state = state.next;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1138485214 = null;
        addTaint(deviceId);
        addTaint(source);
        addTaint(keyCode);
        addTaint(remove);
        KeyState varA7E53CE21691AB073D9660D615818899_1887406926; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1887406926 = varB4EAC82CA7396A68D541C85D26508E83_1151734405;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1887406926 = varB4EAC82CA7396A68D541C85D26508E83_1138485214;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1887406926.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1887406926;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.080 -0400", hash_original_method = "49CD2D0DE125B77D543B3E0017318A6E", hash_generated_method = "B0E416B4B2EB08133AF21178DE4D94E4")
    private void addKeyState(int deviceId, int source, int keyCode) {
        KeyState state;
        state = KeyState.obtain(deviceId, source, keyCode);
        state.next = mKeyStateList;
        mKeyStateList = state;
        addTaint(deviceId);
        addTaint(source);
        addTaint(keyCode);
        // ---------- Original Method ----------
        //KeyState state = KeyState.obtain(deviceId, source, keyCode);
        //state.next = mKeyStateList;
        //mKeyStateList = state;
    }

    
    private static final class KeyState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.081 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A4637F51FF091C45870D06CF8B571722")

        public KeyState next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.081 -0400", hash_original_field = "671B750DAD5F30D6EAF736B4CB910D35", hash_generated_field = "B25950F42C189E4AB05FFB7366B0AA73")

        public int deviceId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.081 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "865C846F4D1F08194526221E7C99DDEB")

        public int source;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.081 -0400", hash_original_field = "B96BEB1FB95F7FA45257BB48942AEF8A", hash_generated_field = "000F6935635EB02934CE0DE5E09F2D3E")

        public int keyCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.081 -0400", hash_original_field = "F500732166205CC78FB0A5FC01440B5E", hash_generated_field = "7DE29E460259F9098EBFCEFDF94DB0DA")

        public boolean unhandled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.081 -0400", hash_original_method = "9B72C46296302693275D5291E4057DE0", hash_generated_method = "46EE7D525ED839CFC8CA395DBE68DDF7")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.098 -0400", hash_original_method = "F16B27E6183802CE84F6921B26D81A30", hash_generated_method = "B629E2138B7F43397A9CD306024B7EA5")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.098 -0400", hash_original_field = "2F26FA40588BE826278064C5E55CF30D", hash_generated_field = "79BE45FB0228F25C0A9DC9B58E9E4BD0")

        private static Object mRecycledListLock = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.098 -0400", hash_original_field = "FB0BE9294B410C125F1CF9B917162013", hash_generated_field = "379CC4BA4A594A20A4231B542C74B1F1")

        private static KeyState mRecycledList;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.098 -0400", hash_original_field = "9D23AE2E1DF0783311B7EE88635EC302", hash_generated_field = "B7A55850ECF055033089690CFA190DA8")

    private static boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.098 -0400", hash_original_field = "B23BAD53F57FAA7D6D0DDB56431F1C6D", hash_generated_field = "53548A5D439E2265BC79B7422266ABF2")

    private static String EVENT_TYPE_KEY = "KeyEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.098 -0400", hash_original_field = "5693E6626829FCA7F478BA981291812A", hash_generated_field = "41B52FAD3A1D463DCA89CC8DBFC25B6B")

    private static String EVENT_TYPE_TRACKBALL = "TrackballEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.098 -0400", hash_original_field = "BD7073E4DEE05ECA262F691840D5A9A5", hash_generated_field = "7ECD85670C6C5433FACC5AE0C2A30627")

    private static String EVENT_TYPE_TOUCH = "TouchEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.098 -0400", hash_original_field = "30F466EA9F17B988DF30952FE936D158", hash_generated_field = "FC4529E0E88EA798396AE4FE922255FB")

    private static String EVENT_TYPE_GENERIC_MOTION = "GenericMotionEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.098 -0400", hash_original_field = "4CA2B0E213BF2ED28B6656FE58CDEB9B", hash_generated_field = "EE668DE3F5CA3329543E1A9CC0D7F6ED")

    private static int RECENT_EVENTS_TO_LOG = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.098 -0400", hash_original_field = "C40CAA681DE8375D99C611EE6180DE21", hash_generated_field = "1C85819CF19DB466C1BC01FCC89D7D5E")

    public static final int FLAG_RAW_DEVICE_INPUT = 1 << 0;
}

