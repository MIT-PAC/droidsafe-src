package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Build;
import android.util.Log;

public final class InputEventConsistencyVerifier {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "02B8E2B08EEFD631BD36F22665C339F2", hash_generated_field = "842464D18B9CC1D906D30912951F1B29")

    private Object mCaller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private int mFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "503F6607C959C61B036C1484733875DB", hash_generated_field = "59F9615F1046A159253328ABFF9EBAC4")

    private String mLogTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "EE9CC63E94F20AF8999429F0CFA81933", hash_generated_field = "CAF007840D1F7323B1001E7DD39DA851")

    private InputEvent mLastEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "A0ABA9CA907A59C8D456966BBA1B3887", hash_generated_field = "7BD27485A06A6A1AC8080AE3638DE4F4")

    private String mLastEventType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "9B5513F064DD0C164336A4318307FD8E", hash_generated_field = "6141C906002BAC7131BFF645A86E7469")

    private int mLastNestingLevel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "19DEACD4170AE518A6DE25F40D57CC5E", hash_generated_field = "860F0DD6CB41AA51A689A023866EB3EC")

    private InputEvent[] mRecentEvents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "1CBB3F568975EF8EC30EEC1AB97967F2", hash_generated_field = "EA05C25F3223B278A2037BD67E368C3A")

    private boolean[] mRecentEventsUnhandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "96ABAE2065AC7130FA9A0F86D456D0B5", hash_generated_field = "30754FF941B62BB39BC4DA77B462515F")

    private int mMostRecentEventIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "37155EC34151C4A4C889EC884F50AEEA", hash_generated_field = "41D4493BA1E5584628EA45425F6D040D")

    private InputEvent mCurrentEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "AB1A563C338454CDCDE6E69607B9426B", hash_generated_field = "6DB375435025884B6151B31AFFFABC76")

    private String mCurrentEventType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "EABE08FDF07FFC82E191D864B705E825", hash_generated_field = "54CDF24A71BB09237A10056FCD052ACC")

    private KeyState mKeyStateList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "CC8BB3617BE25520DEF765C8BDA61DEB", hash_generated_field = "EE4A6262291D828DA2F877FD0D0E2FF0")

    private boolean mTrackballDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "401E99879E2D5AB198383085D49D3A06", hash_generated_field = "A06A640C9360F807D330C6AC7DC6EC56")

    private boolean mTrackballUnhandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "29D0EFD7BBEBE9EF2D55C8D205D29A42", hash_generated_field = "2E6E4A3402809A29F95231522CC6E70D")

    private int mTouchEventStreamPointers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "76A973B325B8C28F2B88CFCCE43EA268", hash_generated_field = "55B14E4F3F5DFF6FBC6711B83FE98065")

    private int mTouchEventStreamDeviceId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "36B6F011CE0CBE093880BFCE3E88F860", hash_generated_field = "301EA641826E495DAC0F1004C4FD7D72")

    private int mTouchEventStreamSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "D28D9276F0CCF57EAA41F1CA21516D3A", hash_generated_field = "4ADB7785313125C3F9545C94531D1258")

    private boolean mTouchEventStreamIsTainted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "97E3F7FCB6911501B81AF9CEA6EB9D1F", hash_generated_field = "AAA9E205D77F337A8F1503284ADA9497")

    private boolean mTouchEventStreamUnhandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "ABC622DD1CF6B937B2EE57C4308724EF", hash_generated_field = "A1EEE3B7C7E4EEB7928D87C1E14B5A64")

    private boolean mHoverEntered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_field = "0FF2EDE5A69E1ED5164E5AE0CA0A580F", hash_generated_field = "0E37C0AC706495641748D32B4C94C2EF")

    private StringBuilder mViolationMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.097 -0400", hash_original_method = "D65E8A245B5C473707AFD205D57D3AF8", hash_generated_method = "591FC6399E9E7DE182F3E81EA2CB9081")
    public  InputEventConsistencyVerifier(Object caller, int flags) {
        this(caller, flags, InputEventConsistencyVerifier.class.getSimpleName());
        addTaint(caller.getTaint());
        addTaint(flags);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.098 -0400", hash_original_method = "31CA6A116339576A3C7E1C4293F4F7B1", hash_generated_method = "25151441769D8C7D937887594A926350")
    public  InputEventConsistencyVerifier(Object caller, int flags, String logTag) {
        this.mCaller = caller;
        this.mFlags = flags;
        this.mLogTag = (logTag != null) ? logTag : "InputEventConsistencyVerifier";
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isInstrumentationEnabled() {
        return IS_ENG_BUILD;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.098 -0400", hash_original_method = "13418E29B3FCE72BDE84CBF193C1BADD", hash_generated_method = "2446BF42931AD240C640B25505DC599F")
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
            final KeyState state = mKeyStateList;
            mKeyStateList = state.next;
            state.recycle();
        } 
        
        
        
        
        
        
        
        
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.099 -0400", hash_original_method = "9981F0DD702462FD09DA371539E225DF", hash_generated_method = "01177B91D0A6D67B081710F67306769E")
    public void onInputEvent(InputEvent event, int nestingLevel) {
        
        {
            final KeyEvent keyEvent = (KeyEvent)event;
            onKeyEvent(keyEvent, nestingLevel);
        } 
        {
            final MotionEvent motionEvent = (MotionEvent)event;
            {
                boolean var1D97065BD820BD0456B45C7E9DBBA082_1325981818 = (motionEvent.isTouchEvent());
                {
                    onTouchEvent(motionEvent, nestingLevel);
                } 
                {
                    boolean var1548696A1C108F52D98124BF03CF8313_1724490205 = ((motionEvent.getSource() & InputDevice.SOURCE_CLASS_TRACKBALL) != 0);
                    {
                        onTrackballEvent(motionEvent, nestingLevel);
                    } 
                    {
                        onGenericMotionEvent(motionEvent, nestingLevel);
                    } 
                } 
            } 
        } 
        addTaint(event.getTaint());
        addTaint(nestingLevel);
        
        
            
            
        
            
            
                
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.100 -0400", hash_original_method = "37A5317EE58F7483AB8019E5DEA39C1C", hash_generated_method = "73D0664F1D5AEACB85D5E8954364A742")
    public void onKeyEvent(KeyEvent event, int nestingLevel) {
        
        {
            boolean var1C9540E6394A7A11097E4E4C24A69E5A_173564809 = (!startEvent(event, nestingLevel, EVENT_TYPE_KEY));
        } 
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            final int action = event.getAction();
            final int deviceId = event.getDeviceId();
            final int source = event.getSource();
            final int keyCode = event.getKeyCode();
            
            {
                KeyState state = findKeyState(deviceId, source, keyCode,  false);
                {
                    {
                        state.unhandled = false;
                    } 
                    {
                        boolean varBB7C3BAA0F2DE303A64E00E840FF7A59_1491207514 = ((mFlags & FLAG_RAW_DEVICE_INPUT) == 0
                                && event.getRepeatCount() == 0);
                        {
                            problem("ACTION_DOWN but key is already down and this event "
                                    + "is not a key repeat.");
                        } 
                    } 
                } 
                {
                    addKeyState(deviceId, source, keyCode);
                } 
            } 
            
            
            {
                KeyState state = findKeyState(deviceId, source, keyCode,  true);
                {
                    problem("ACTION_UP but key was not down.");
                } 
                {
                    state.recycle();
                } 
            } 
            
            
            problem("Invalid action " + KeyEvent.actionToString(action)
                            + " for key event.");
            
        } 
        finally 
        {
            finishEvent();
        } 
        addTaint(event.getTaint());
        addTaint(nestingLevel);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.101 -0400", hash_original_method = "742053359AC2416542EBDE8E8736FB44", hash_generated_method = "67D5194C093B7DB24B4C41CAD7500294")
    public void onTrackballEvent(MotionEvent event, int nestingLevel) {
        
        {
            boolean var5BA64422812B4CD0774617583F7E1D53_1969828250 = (!startEvent(event, nestingLevel, EVENT_TYPE_TRACKBALL));
        } 
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            final int action = event.getAction();
            final int source = event.getSource();
            {
                
                {
                    problem("ACTION_DOWN but trackball is already down.");
                } 
                {
                    mTrackballDown = true;
                    mTrackballUnhandled = false;
                } 
                
                
                ensureHistorySizeIsZeroForThisAction(event);
                
                
                ensurePointerCountIsOneForThisAction(event);
                
                
                {
                    problem("ACTION_UP but trackball is not down.");
                } 
                {
                    mTrackballDown = false;
                    mTrackballUnhandled = false;
                } 
                
                
                ensureHistorySizeIsZeroForThisAction(event);
                
                
                ensurePointerCountIsOneForThisAction(event);
                
                
                ensurePointerCountIsOneForThisAction(event);
                
                
                problem("Invalid action " + MotionEvent.actionToString(action)
                                + " for trackball event.");
                
                {
                    boolean varF8125AB1D243142529D579C7BF1C5525_253918015 = (mTrackballDown && event.getPressure() <= 0);
                    {
                        problem("Trackball is down but pressure is not greater than 0.");
                    } 
                    {
                        boolean var48456D7B62EC643623B97245B65EE0A7_1237072842 = (!mTrackballDown && event.getPressure() != 0);
                        {
                            problem("Trackball is up but pressure is not equal to 0.");
                        } 
                    } 
                } 
            } 
            {
                problem("Source was not SOURCE_CLASS_TRACKBALL.");
            } 
        } 
        finally 
        {
            finishEvent();
        } 
        addTaint(event.getTaint());
        addTaint(nestingLevel);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.102 -0400", hash_original_method = "F64D7AF6BB2368971DDEEF01EB83BDA6", hash_generated_method = "BF607E2C808441E0C5E6F81C02BFDE58")
    public void onTouchEvent(MotionEvent event, int nestingLevel) {
        
        {
            boolean var5C200FBFC1B0213F6CDA14409F83D214_2100975379 = (!startEvent(event, nestingLevel, EVENT_TYPE_TOUCH));
        } 
        final int action = event.getAction();
        final boolean newStream = action == MotionEvent.ACTION_DOWN
                || action == MotionEvent.ACTION_CANCEL;
        {
            mTouchEventStreamIsTainted = false;
            mTouchEventStreamUnhandled = false;
            mTouchEventStreamPointers = 0;
        } 
        {
            event.setTainted(true);
        } 
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            final int deviceId = event.getDeviceId();
            final int source = event.getSource();
            {
                problem("Touch event stream contains events from multiple sources: "
                        + "previous device id " + mTouchEventStreamDeviceId
                        + ", previous source " + Integer.toHexString(mTouchEventStreamSource)
                        + ", new device id " + deviceId
                        + ", new source " + Integer.toHexString(source));
            } 
            mTouchEventStreamDeviceId = deviceId;
            mTouchEventStreamSource = source;
            final int pointerCount = event.getPointerCount();
            {
                
                {
                    problem("ACTION_DOWN but pointers are already down.  "
                                    + "Probably missing ACTION_UP from previous gesture.");
                } 
                
                
                ensureHistorySizeIsZeroForThisAction(event);
                
                
                ensurePointerCountIsOneForThisAction(event);
                
                
                mTouchEventStreamPointers = 1 << event.getPointerId(0);
                
                
                ensureHistorySizeIsZeroForThisAction(event);
                
                
                ensurePointerCountIsOneForThisAction(event);
                
                
                mTouchEventStreamPointers = 0;
                
                
                mTouchEventStreamIsTainted = false;
                
                
                {
                    final int expectedPointerCount = Integer.bitCount(mTouchEventStreamPointers);
                    {
                        problem("ACTION_MOVE contained " + pointerCount
                                    + " pointers but there are currently "
                                    + expectedPointerCount + " pointers down.");
                        mTouchEventStreamIsTainted = true;
                    } 
                } 
                
                
                mTouchEventStreamPointers = 0;
                
                
                mTouchEventStreamIsTainted = false;
                
                
                {
                    problem("ACTION_OUTSIDE but pointers are still down.");
                } 
                
                
                ensureHistorySizeIsZeroForThisAction(event);
                
                
                ensurePointerCountIsOneForThisAction(event);
                
                
                mTouchEventStreamIsTainted = false;
                
                
                {
                    final int actionMasked = event.getActionMasked();
                    final int actionIndex = event.getActionIndex();
                    {
                        {
                            problem("ACTION_POINTER_DOWN but no other pointers were down.");
                            mTouchEventStreamIsTainted = true;
                        } 
                        {
                            problem("ACTION_POINTER_DOWN index is " + actionIndex
                                        + " but the pointer count is " + pointerCount + ".");
                            mTouchEventStreamIsTainted = true;
                        } 
                        {
                            final int id = event.getPointerId(actionIndex);
                            final int idBit = 1 << id;
                            {
                                problem("ACTION_POINTER_DOWN specified pointer id " + id
                                            + " which is already down.");
                                mTouchEventStreamIsTainted = true;
                            } 
                            {
                                mTouchEventStreamPointers |= idBit;
                            } 
                        } 
                        ensureHistorySizeIsZeroForThisAction(event);
                    } 
                    {
                        {
                            problem("ACTION_POINTER_UP index is " + actionIndex
                                        + " but the pointer count is " + pointerCount + ".");
                            mTouchEventStreamIsTainted = true;
                        } 
                        {
                            final int id = event.getPointerId(actionIndex);
                            final int idBit = 1 << id;
                            {
                                problem("ACTION_POINTER_UP specified pointer id " + id
                                            + " which is not currently down.");
                                mTouchEventStreamIsTainted = true;
                            } 
                            {
                                mTouchEventStreamPointers &= ~idBit;
                            } 
                        } 
                        ensureHistorySizeIsZeroForThisAction(event);
                    } 
                    {
                        problem("Invalid action " + MotionEvent.actionToString(action)
                                    + " for touch event.");
                    } 
                } 
                
            } 
            {
                problem("Source was not SOURCE_CLASS_POINTER.");
            } 
        } 
        finally 
        {
            finishEvent();
        } 
        addTaint(nestingLevel);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.103 -0400", hash_original_method = "23EA37DFEC977078F682E35F151F1942", hash_generated_method = "748E33D074125C187219837654B851F7")
    public void onGenericMotionEvent(MotionEvent event, int nestingLevel) {
        
        {
            boolean var6C693FE76F7AB1F8804D07C4E7E4F955_1743276934 = (!startEvent(event, nestingLevel, EVENT_TYPE_GENERIC_MOTION));
        } 
        try 
        {
            ensureMetaStateIsNormalized(event.getMetaState());
            final int action = event.getAction();
            final int source = event.getSource();
            {
                
                ensurePointerCountIsOneForThisAction(event);
                
                
                mHoverEntered = true;
                
                
                ensurePointerCountIsOneForThisAction(event);
                
                
                ensurePointerCountIsOneForThisAction(event);
                
                
                {
                    problem("ACTION_HOVER_EXIT without prior ACTION_HOVER_ENTER");
                } 
                
                
                mHoverEntered = false;
                
                
                ensureHistorySizeIsZeroForThisAction(event);
                
                
                ensurePointerCountIsOneForThisAction(event);
                
                
                problem("Invalid action for generic pointer event.");
                
            } 
            {
                
                ensurePointerCountIsOneForThisAction(event);
                
                
                problem("Invalid action for generic joystick event.");
                
            } 
        } 
        finally 
        {
            finishEvent();
        } 
        addTaint(event.getTaint());
        addTaint(nestingLevel);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.104 -0400", hash_original_method = "95A33BD7B12ABE8439BBD32736BE35D7", hash_generated_method = "B315F3DAB2DEFBCB6968393FCF1B8A6F")
    public void onUnhandledEvent(InputEvent event, int nestingLevel) {
        
        {
            mRecentEventsUnhandled[mMostRecentEventIndex] = true;
        } 
        {
            final KeyEvent keyEvent = (KeyEvent)event;
            final int deviceId = keyEvent.getDeviceId();
            final int source = keyEvent.getSource();
            final int keyCode = keyEvent.getKeyCode();
            final KeyState state = findKeyState(deviceId, source, keyCode,  false);
            {
                state.unhandled = true;
            } 
        } 
        {
            final MotionEvent motionEvent = (MotionEvent)event;
            {
                boolean var1D97065BD820BD0456B45C7E9DBBA082_580614457 = (motionEvent.isTouchEvent());
                {
                    mTouchEventStreamUnhandled = true;
                } 
                {
                    boolean var1548696A1C108F52D98124BF03CF8313_1176021076 = ((motionEvent.getSource() & InputDevice.SOURCE_CLASS_TRACKBALL) != 0);
                    {
                        {
                            mTrackballUnhandled = true;
                        } 
                    } 
                } 
            } 
        } 
        addTaint(event.getTaint());
        addTaint(nestingLevel);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.104 -0400", hash_original_method = "0D02225F7CFB86AB0627FF86E895BCB3", hash_generated_method = "A541D7AB642E747488FAB36ECC41162E")
    private void ensureMetaStateIsNormalized(int metaState) {
        final int normalizedMetaState = KeyEvent.normalizeMetaState(metaState);
        {
            problem(String.format("Metastate not normalized.  Was 0x%08x but expected 0x%08x.",
                    metaState, normalizedMetaState));
        } 
        addTaint(metaState);
        
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.104 -0400", hash_original_method = "960C41882671A36CAB1E6050FF4DEA3B", hash_generated_method = "D740BCD4EA5F5B249CF326D29D24B15B")
    private void ensurePointerCountIsOneForThisAction(MotionEvent event) {
        final int pointerCount = event.getPointerCount();
        {
            problem("Pointer count is " + pointerCount + " but it should always be 1 for "
                    + MotionEvent.actionToString(event.getAction()));
        } 
        addTaint(event.getTaint());
        
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.105 -0400", hash_original_method = "418A844BE60240583EF50FE17898B3BB", hash_generated_method = "6FC7E3C13AB9D1601299CB6F9EA0E6F8")
    private void ensureHistorySizeIsZeroForThisAction(MotionEvent event) {
        final int historySize = event.getHistorySize();
        {
            problem("History size is " + historySize + " but it should always be 0 for "
                    + MotionEvent.actionToString(event.getAction()));
        } 
        addTaint(event.getTaint());
        
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.105 -0400", hash_original_method = "4D608F0C62317EB539D3EDD1A5B0BBF8", hash_generated_method = "F6293A1351A0BA831415CFF159382A21")
    private boolean startEvent(InputEvent event, int nestingLevel, String eventType) {
        {
            mLastEvent = event;
            mLastEventType = eventType;
            mLastNestingLevel = nestingLevel;
        } 
        {
            mLastEvent = null;
            mLastEventType = null;
            mLastNestingLevel = 0;
        } 
        mCurrentEvent = event;
        mCurrentEventType = eventType;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1816113617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1816113617;
        
        
                
            
        
        
            
            
            
        
            
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.106 -0400", hash_original_method = "ED6D322EBF7819A0A849ACCBA13E8A32", hash_generated_method = "9EF3E838AF6B8448D8F661649F7643D3")
    private void finishEvent() {
        {
            boolean var900C4014E5F18032AC7EF14D50B77173_84143958 = (mViolationMessage != null && mViolationMessage.length() != 0);
            {
                {
                    boolean varF73E249DD60ACAF7AD897F2896801AA9_416335220 = (!mCurrentEvent.isTainted());
                    {
                        mViolationMessage.append("\n  in ").append(mCaller);
                        mViolationMessage.append("\n  ");
                        appendEvent(mViolationMessage, 0, mCurrentEvent, false);
                        {
                            mViolationMessage.append("\n  -- recent events --");
                            {
                                int i = 0;
                                {
                                    final int index = (mMostRecentEventIndex + RECENT_EVENTS_TO_LOG - i)
                                % RECENT_EVENTS_TO_LOG;
                                    final InputEvent event = mRecentEvents[index];
                                    mViolationMessage.append("\n  ");
                                    appendEvent(mViolationMessage, i + 1, event, mRecentEventsUnhandled[index]);
                                } 
                            } 
                        } 
                        Log.d(mLogTag, mViolationMessage.toString());
                        mCurrentEvent.setTainted(true);
                    } 
                } 
                mViolationMessage.setLength(0);
            } 
        } 
        {
            {
                mRecentEvents = new InputEvent[RECENT_EVENTS_TO_LOG];
                mRecentEventsUnhandled = new boolean[RECENT_EVENTS_TO_LOG];
            } 
            final int index = (mMostRecentEventIndex + 1) % RECENT_EVENTS_TO_LOG;
            mMostRecentEventIndex = index;
            {
                mRecentEvents[index].recycle();
            } 
            mRecentEvents[index] = mCurrentEvent.copy();
            mRecentEventsUnhandled[index] = false;
        } 
        mCurrentEvent = null;
        mCurrentEventType = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void appendEvent(StringBuilder message, int index,
            InputEvent event, boolean unhandled) {
        message.append(index).append(": sent at ").append(event.getEventTimeNano());
        message.append(", ");
        if (unhandled) {
            message.append("(unhandled) ");
        }
        message.append(event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.107 -0400", hash_original_method = "C6124E8B7D001D6ECE47F875379D529E", hash_generated_method = "C30013576538A5A2641D80EAC5E473F6")
    private void problem(String message) {
        {
            mViolationMessage = new StringBuilder();
        } 
        {
            boolean varADDF521E749D23BF1A55223D8CD76170_787817714 = (mViolationMessage.length() == 0);
            {
                mViolationMessage.append(mCurrentEventType).append(": ");
            } 
            {
                mViolationMessage.append("\n  ");
            } 
        } 
        mViolationMessage.append(message);
        addTaint(message.getTaint());
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.107 -0400", hash_original_method = "98F44F7E9C89F442263CA208119E2058", hash_generated_method = "454091B39206E4B0121CA7A45CD923EB")
    private KeyState findKeyState(int deviceId, int source, int keyCode, boolean remove) {
        KeyState varB4EAC82CA7396A68D541C85D26508E83_876023940 = null; 
        KeyState varB4EAC82CA7396A68D541C85D26508E83_63653847 = null; 
        KeyState last = null;
        KeyState state = mKeyStateList;
        {
            {
                {
                    {
                        last.next = state.next;
                    } 
                    {
                        mKeyStateList = state.next;
                    } 
                    state.next = null;
                } 
                varB4EAC82CA7396A68D541C85D26508E83_876023940 = state;
            } 
            last = state;
            state = state.next;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_63653847 = null;
        addTaint(deviceId);
        addTaint(source);
        addTaint(keyCode);
        addTaint(remove);
        KeyState varA7E53CE21691AB073D9660D615818899_1909493803; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1909493803 = varB4EAC82CA7396A68D541C85D26508E83_876023940;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1909493803 = varB4EAC82CA7396A68D541C85D26508E83_63653847;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1909493803.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1909493803;
        
        
        
        
            
                    
                
                    
                        
                    
                        
                    
                    
                
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.108 -0400", hash_original_method = "49CD2D0DE125B77D543B3E0017318A6E", hash_generated_method = "C9EAB3BAB5A4D89669611384D2A06C93")
    private void addKeyState(int deviceId, int source, int keyCode) {
        KeyState state = KeyState.obtain(deviceId, source, keyCode);
        state.next = mKeyStateList;
        mKeyStateList = state;
        addTaint(deviceId);
        addTaint(source);
        addTaint(keyCode);
        
        
        
        
    }

    
    private static final class KeyState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.108 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A4637F51FF091C45870D06CF8B571722")

        public KeyState next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.108 -0400", hash_original_field = "671B750DAD5F30D6EAF736B4CB910D35", hash_generated_field = "B25950F42C189E4AB05FFB7366B0AA73")

        public int deviceId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.108 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "865C846F4D1F08194526221E7C99DDEB")

        public int source;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.108 -0400", hash_original_field = "B96BEB1FB95F7FA45257BB48942AEF8A", hash_generated_field = "000F6935635EB02934CE0DE5E09F2D3E")

        public int keyCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.108 -0400", hash_original_field = "F500732166205CC78FB0A5FC01440B5E", hash_generated_field = "7DE29E460259F9098EBFCEFDF94DB0DA")

        public boolean unhandled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.108 -0400", hash_original_method = "9B72C46296302693275D5291E4057DE0", hash_generated_method = "46EE7D525ED839CFC8CA395DBE68DDF7")
        private  KeyState() {
            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.109 -0400", hash_original_method = "F16B27E6183802CE84F6921B26D81A30", hash_generated_method = "B629E2138B7F43397A9CD306024B7EA5")
        public void recycle() {
            {
                next = mRecycledList;
                mRecycledList = next;
            } 
            
            
                
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.109 -0400", hash_original_field = "2F26FA40588BE826278064C5E55CF30D", hash_generated_field = "79BE45FB0228F25C0A9DC9B58E9E4BD0")

        private static Object mRecycledListLock = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.109 -0400", hash_original_field = "FB0BE9294B410C125F1CF9B917162013", hash_generated_field = "379CC4BA4A594A20A4231B542C74B1F1")

        private static KeyState mRecycledList;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.109 -0400", hash_original_field = "9D23AE2E1DF0783311B7EE88635EC302", hash_generated_field = "5633022DA578E314CF52EE3A9C0CF47D")

    private static final boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.109 -0400", hash_original_field = "B23BAD53F57FAA7D6D0DDB56431F1C6D", hash_generated_field = "BF7F27BD11752360FD77D3ADB49DCD5E")

    private static final String EVENT_TYPE_KEY = "KeyEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.109 -0400", hash_original_field = "5693E6626829FCA7F478BA981291812A", hash_generated_field = "A473C2AB75307FC390ECD2C1507122DA")

    private static final String EVENT_TYPE_TRACKBALL = "TrackballEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.109 -0400", hash_original_field = "BD7073E4DEE05ECA262F691840D5A9A5", hash_generated_field = "D1EB06456AD7E3D660599184311AC822")

    private static final String EVENT_TYPE_TOUCH = "TouchEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.109 -0400", hash_original_field = "30F466EA9F17B988DF30952FE936D158", hash_generated_field = "357765B7CE50F3956441E3EA77451666")

    private static final String EVENT_TYPE_GENERIC_MOTION = "GenericMotionEvent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.109 -0400", hash_original_field = "4CA2B0E213BF2ED28B6656FE58CDEB9B", hash_generated_field = "1520184BDE53EF2FB714CE773B08074D")

    private static final int RECENT_EVENTS_TO_LOG = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.109 -0400", hash_original_field = "C40CAA681DE8375D99C611EE6180DE21", hash_generated_field = "1C85819CF19DB466C1BC01FCC89D7D5E")

    public static final int FLAG_RAW_DEVICE_INPUT = 1 << 0;
}

