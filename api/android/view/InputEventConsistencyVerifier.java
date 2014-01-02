package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Build;
import android.util.Log;





public final class InputEventConsistencyVerifier {

    /**
     * Determines whether the instrumentation should be enabled.
     * @return True if it should be enabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.853 -0500", hash_original_method = "ABC85C1E863250D9F7C830BC7DDD0D2B", hash_generated_method = "1DB2582447DF402A861B9A57D830B421")
    
public static boolean isInstrumentationEnabled() {
        return IS_ENG_BUILD;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.893 -0500", hash_original_method = "F98067EFA794ACF9FB8DE5044A893B73", hash_generated_method = "BC7BC3B62EB722E503DFFD4B2E3182EC")
    
private static void appendEvent(StringBuilder message, int index,
            InputEvent event, boolean unhandled) {
        message.append(index).append(": sent at ").append(event.getEventTimeNano());
        message.append(", ");
        if (unhandled) {
            message.append("(unhandled) ");
        }
        message.append(event);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.781 -0500", hash_original_field = "3C3C2BD02B342D685B1CE8841A554EBE", hash_generated_field = "5633022DA578E314CF52EE3A9C0CF47D")

    private static final boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.783 -0500", hash_original_field = "72463B0737EA8974C13D3A4158DE9BB2", hash_generated_field = "BF7F27BD11752360FD77D3ADB49DCD5E")


    private static final String EVENT_TYPE_KEY = "KeyEvent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.786 -0500", hash_original_field = "D3DCBE09DC4FAD57DF08DAD9069D4DEB", hash_generated_field = "A473C2AB75307FC390ECD2C1507122DA")

    private static final String EVENT_TYPE_TRACKBALL = "TrackballEvent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.789 -0500", hash_original_field = "70556846E56315F0085F44D87058FB0D", hash_generated_field = "D1EB06456AD7E3D660599184311AC822")

    private static final String EVENT_TYPE_TOUCH = "TouchEvent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.792 -0500", hash_original_field = "09D3DCA5372CB02E329AC44A0DA9DE85", hash_generated_field = "357765B7CE50F3956441E3EA77451666")

    private static final String EVENT_TYPE_GENERIC_MOTION = "GenericMotionEvent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.794 -0500", hash_original_field = "7673001A79E849051F287150D58B4DDB", hash_generated_field = "8615C7A2942452ECBA03566DE84D8851")

    // Can be set to 0 to disable logging recent events but the runtime overhead of
    // this feature is negligible on current hardware.
    private static final int RECENT_EVENTS_TO_LOG = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.846 -0500", hash_original_field = "0FEB897487E809575597A2BA79AF7260", hash_generated_field = "1C85819CF19DB466C1BC01FCC89D7D5E")

    public static final int FLAG_RAW_DEVICE_INPUT = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.796 -0500", hash_original_field = "4DAC07999DCDEE7C1A28D71A65B3E748", hash_generated_field = "842464D18B9CC1D906D30912951F1B29")

    private  Object mCaller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.799 -0500", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private  int mFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.801 -0500", hash_original_field = "18BDC329C18DD371A79CC5D2B91C72D1", hash_generated_field = "F8BAEF6DF6ECF676D2E7628F4348D91B")

    // from different verifiers since several can be active at the same time.
    // If not provided defaults to the simple class name.
    private  String mLogTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.804 -0500", hash_original_field = "8E0D2D28DC9E6BD9E968AC409C005C7F", hash_generated_field = "517CCFD687C0981F8E2292E291ED16A4")

    // This is only set when the verifier is called from a nesting level greater than 0
    // so that the verifier can detect when it has been asked to verify the same event twice.
    // It does not make sense to examine the contents of the last event since it may have
    // been recycled.
    private InputEvent mLastEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.806 -0500", hash_original_field = "2EF7A793D82174BE2FC614A8AD5D2F7A", hash_generated_field = "7BD27485A06A6A1AC8080AE3638DE4F4")

    private String mLastEventType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.808 -0500", hash_original_field = "EEE14B661E2BA254267D2FD1F8FF7FB7", hash_generated_field = "6141C906002BAC7131BFF645A86E7469")

    private int mLastNestingLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.810 -0500", hash_original_field = "38D3132386F654292BDE724554EA41CE", hash_generated_field = "860F0DD6CB41AA51A689A023866EB3EC")

    private InputEvent[] mRecentEvents;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.812 -0500", hash_original_field = "2053612B43F74D12B2B6146DAF0AD14A", hash_generated_field = "EA05C25F3223B278A2037BD67E368C3A")

    private boolean[] mRecentEventsUnhandled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.815 -0500", hash_original_field = "3AA11C0DD278CE8B59062800EDC47E46", hash_generated_field = "30754FF941B62BB39BC4DA77B462515F")

    private int mMostRecentEventIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.817 -0500", hash_original_field = "E0B9DCFBD0AD065B71AB5F5EC329AC70", hash_generated_field = "41D4493BA1E5584628EA45425F6D040D")

    private InputEvent mCurrentEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.819 -0500", hash_original_field = "8393AC599C7DE672FD85EEA1E4ADE772", hash_generated_field = "6DB375435025884B6151B31AFFFABC76")

    private String mCurrentEventType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.822 -0500", hash_original_field = "5BDCF66290798FCF7AE1B48B6027A483", hash_generated_field = "54CDF24A71BB09237A10056FCD052ACC")

    private KeyState mKeyStateList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.824 -0500", hash_original_field = "932293C87F92E0379223C0D26D909E8D", hash_generated_field = "EE4A6262291D828DA2F877FD0D0E2FF0")

    private boolean mTrackballDown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.826 -0500", hash_original_field = "0F78D83FA0FC22B9B6F8BB9C3B130419", hash_generated_field = "A06A640C9360F807D330C6AC7DC6EC56")

    private boolean mTrackballUnhandled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.829 -0500", hash_original_field = "E82122BEB8B1B0DED28E2A2C62A5D8B6", hash_generated_field = "8EC5D8CC292DE9BD19BB4D736ABC9516")

    // Assumes that the largest possible pointer id is 31, which is potentially subject to change.
    // (See MAX_POINTER_ID in frameworks/base/include/ui/Input.h)
    private int mTouchEventStreamPointers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.831 -0500", hash_original_field = "80B470805ED1961A7B6BAFC2C21A1F32", hash_generated_field = "55B14E4F3F5DFF6FBC6711B83FE98065")

    private int mTouchEventStreamDeviceId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.833 -0500", hash_original_field = "88D4013EF63E3B68DC4814AAF845B03D", hash_generated_field = "301EA641826E495DAC0F1004C4FD7D72")

    private int mTouchEventStreamSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.836 -0500", hash_original_field = "3F321DE737A08A90C8E1031C8C3ED9A2", hash_generated_field = "14280E11B756B84F414E40A3D5714D00")

    // Reset on down or cancel.
    private boolean mTouchEventStreamIsTainted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.838 -0500", hash_original_field = "0CEEB50A4A922D58A08F3A1BEE2CBB0C", hash_generated_field = "AAA9E205D77F337A8F1503284ADA9497")

    private boolean mTouchEventStreamUnhandled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.841 -0500", hash_original_field = "21B4718C7ED6CAB186EEAAC42424F907", hash_generated_field = "A1EEE3B7C7E4EEB7928D87C1E14B5A64")

    private boolean mHoverEntered;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.843 -0500", hash_original_field = "210A7CC2846FA9512328EC4A9499D867", hash_generated_field = "0E37C0AC706495641748D32B4C94C2EF")

    private StringBuilder mViolationMessage;

    /**
     * Creates an input consistency verifier.
     * @param caller The object to which the verifier is attached.
     * @param flags Flags to the verifier, or 0 if none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.849 -0500", hash_original_method = "D65E8A245B5C473707AFD205D57D3AF8", hash_generated_method = "FE011AEB3F054A1198AF58D1F19BD9CC")
    
public InputEventConsistencyVerifier(Object caller, int flags) {
        this(caller, flags, InputEventConsistencyVerifier.class.getSimpleName());
    }

    /**
     * Creates an input consistency verifier.
     * @param caller The object to which the verifier is attached.
     * @param flags Flags to the verifier, or 0 if none.
     * @param logTag Tag for logging. If null defaults to the short class name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.851 -0500", hash_original_method = "31CA6A116339576A3C7E1C4293F4F7B1", hash_generated_method = "DF869E7652593A82623D11D258A3372E")
    
public InputEventConsistencyVerifier(Object caller, int flags, String logTag) {
        this.mCaller = caller;
        this.mFlags = flags;
        this.mLogTag = (logTag != null) ? logTag : "InputEventConsistencyVerifier";
    }

    /**
     * Resets the state of the input event consistency verifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.856 -0500", hash_original_method = "13418E29B3FCE72BDE84CBF193C1BADD", hash_generated_method = "D3F015A27DBCA9D7F628390A30652935")
    
public void reset() {
        mLastEvent = null;
        mLastNestingLevel = 0;
        mTrackballDown = false;
        mTrackballUnhandled = false;
        mTouchEventStreamPointers = 0;
        mTouchEventStreamIsTainted = false;
        mTouchEventStreamUnhandled = false;
        mHoverEntered = false;

        while (mKeyStateList != null) {
            final KeyState state = mKeyStateList;
            mKeyStateList = state.next;
            state.recycle();
        }
    }

    /**
     * Checks an arbitrary input event.
     * @param event The event.
     * @param nestingLevel The nesting level: 0 if called from the base class,
     * or 1 from a subclass.  If the event was already checked by this consistency verifier
     * at a higher nesting level, it will not be checked again.  Used to handle the situation
     * where a subclass dispatching method delegates to its superclass's dispatching method
     * and both dispatching methods call into the consistency verifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.858 -0500", hash_original_method = "9981F0DD702462FD09DA371539E225DF", hash_generated_method = "08CD887017BEACDA1AECAC968CDD0187")
    
public void onInputEvent(InputEvent event, int nestingLevel) {
        if (event instanceof KeyEvent) {
            final KeyEvent keyEvent = (KeyEvent)event;
            onKeyEvent(keyEvent, nestingLevel);
        } else {
            final MotionEvent motionEvent = (MotionEvent)event;
            if (motionEvent.isTouchEvent()) {
                onTouchEvent(motionEvent, nestingLevel);
            } else if ((motionEvent.getSource() & InputDevice.SOURCE_CLASS_TRACKBALL) != 0) {
                onTrackballEvent(motionEvent, nestingLevel);
            } else {
                onGenericMotionEvent(motionEvent, nestingLevel);
            }
        }
    }

    /**
     * Checks a key event.
     * @param event The event.
     * @param nestingLevel The nesting level: 0 if called from the base class,
     * or 1 from a subclass.  If the event was already checked by this consistency verifier
     * at a higher nesting level, it will not be checked again.  Used to handle the situation
     * where a subclass dispatching method delegates to its superclass's dispatching method
     * and both dispatching methods call into the consistency verifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.862 -0500", hash_original_method = "37A5317EE58F7483AB8019E5DEA39C1C", hash_generated_method = "2F97F52E294F4141DFC538338F3B1C8A")
    
public void onKeyEvent(KeyEvent event, int nestingLevel) {
        if (!startEvent(event, nestingLevel, EVENT_TYPE_KEY)) {
            return;
        }

        try {
            ensureMetaStateIsNormalized(event.getMetaState());

            final int action = event.getAction();
            final int deviceId = event.getDeviceId();
            final int source = event.getSource();
            final int keyCode = event.getKeyCode();
            switch (action) {
                case KeyEvent.ACTION_DOWN: {
                    KeyState state = findKeyState(deviceId, source, keyCode, /*remove*/ false);
                    if (state != null) {
                        // If the key is already down, ensure it is a repeat.
                        // We don't perform this check when processing raw device input
                        // because the input dispatcher itself is responsible for setting
                        // the key repeat count before it delivers input events.
                        if (state.unhandled) {
                            state.unhandled = false;
                        } else if ((mFlags & FLAG_RAW_DEVICE_INPUT) == 0
                                && event.getRepeatCount() == 0) {
                            problem("ACTION_DOWN but key is already down and this event "
                                    + "is not a key repeat.");
                        }
                    } else {
                        addKeyState(deviceId, source, keyCode);
                    }
                    break;
                }
                case KeyEvent.ACTION_UP: {
                    KeyState state = findKeyState(deviceId, source, keyCode, /*remove*/ true);
                    if (state == null) {
                        problem("ACTION_UP but key was not down.");
                    } else {
                        state.recycle();
                    }
                    break;
                }
                case KeyEvent.ACTION_MULTIPLE:
                    break;
                default:
                    problem("Invalid action " + KeyEvent.actionToString(action)
                            + " for key event.");
                    break;
            }
        } finally {
            finishEvent();
        }
    }

    /**
     * Checks a trackball event.
     * @param event The event.
     * @param nestingLevel The nesting level: 0 if called from the base class,
     * or 1 from a subclass.  If the event was already checked by this consistency verifier
     * at a higher nesting level, it will not be checked again.  Used to handle the situation
     * where a subclass dispatching method delegates to its superclass's dispatching method
     * and both dispatching methods call into the consistency verifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.865 -0500", hash_original_method = "742053359AC2416542EBDE8E8736FB44", hash_generated_method = "FDBA56ED74BB7C2A89FD0B5E19A0277E")
    
public void onTrackballEvent(MotionEvent event, int nestingLevel) {
        if (!startEvent(event, nestingLevel, EVENT_TYPE_TRACKBALL)) {
            return;
        }

        try {
            ensureMetaStateIsNormalized(event.getMetaState());

            final int action = event.getAction();
            final int source = event.getSource();
            if ((source & InputDevice.SOURCE_CLASS_TRACKBALL) != 0) {
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        if (mTrackballDown && !mTrackballUnhandled) {
                            problem("ACTION_DOWN but trackball is already down.");
                        } else {
                            mTrackballDown = true;
                            mTrackballUnhandled = false;
                        }
                        ensureHistorySizeIsZeroForThisAction(event);
                        ensurePointerCountIsOneForThisAction(event);
                        break;
                    case MotionEvent.ACTION_UP:
                        if (!mTrackballDown) {
                            problem("ACTION_UP but trackball is not down.");
                        } else {
                            mTrackballDown = false;
                            mTrackballUnhandled = false;
                        }
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
                }

                if (mTrackballDown && event.getPressure() <= 0) {
                    problem("Trackball is down but pressure is not greater than 0.");
                } else if (!mTrackballDown && event.getPressure() != 0) {
                    problem("Trackball is up but pressure is not equal to 0.");
                }
            } else {
                problem("Source was not SOURCE_CLASS_TRACKBALL.");
            }
        } finally {
            finishEvent();
        }
    }

    /**
     * Checks a touch event.
     * @param event The event.
     * @param nestingLevel The nesting level: 0 if called from the base class,
     * or 1 from a subclass.  If the event was already checked by this consistency verifier
     * at a higher nesting level, it will not be checked again.  Used to handle the situation
     * where a subclass dispatching method delegates to its superclass's dispatching method
     * and both dispatching methods call into the consistency verifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.871 -0500", hash_original_method = "F64D7AF6BB2368971DDEEF01EB83BDA6", hash_generated_method = "3B5E3FDB2CCFAA687FF685E5CC77EB91")
    
public void onTouchEvent(MotionEvent event, int nestingLevel) {
        if (!startEvent(event, nestingLevel, EVENT_TYPE_TOUCH)) {
            return;
        }

        final int action = event.getAction();
        final boolean newStream = action == MotionEvent.ACTION_DOWN
                || action == MotionEvent.ACTION_CANCEL;
        if (newStream && (mTouchEventStreamIsTainted || mTouchEventStreamUnhandled)) {
            mTouchEventStreamIsTainted = false;
            mTouchEventStreamUnhandled = false;
            mTouchEventStreamPointers = 0;
        }
        if (mTouchEventStreamIsTainted) {
            event.setTainted(true);
        }

        try {
            ensureMetaStateIsNormalized(event.getMetaState());

            final int deviceId = event.getDeviceId();
            final int source = event.getSource();

            if (!newStream && mTouchEventStreamDeviceId != -1
                    && (mTouchEventStreamDeviceId != deviceId
                            || mTouchEventStreamSource != source)) {
                problem("Touch event stream contains events from multiple sources: "
                        + "previous device id " + mTouchEventStreamDeviceId
                        + ", previous source " + Integer.toHexString(mTouchEventStreamSource)
                        + ", new device id " + deviceId
                        + ", new source " + Integer.toHexString(source));
            }
            mTouchEventStreamDeviceId = deviceId;
            mTouchEventStreamSource = source;

            final int pointerCount = event.getPointerCount();
            if ((source & InputDevice.SOURCE_CLASS_POINTER) != 0) {
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        if (mTouchEventStreamPointers != 0) {
                            problem("ACTION_DOWN but pointers are already down.  "
                                    + "Probably missing ACTION_UP from previous gesture.");
                        }
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
                    case MotionEvent.ACTION_MOVE: {
                        final int expectedPointerCount =
                                Integer.bitCount(mTouchEventStreamPointers);
                        if (pointerCount != expectedPointerCount) {
                            problem("ACTION_MOVE contained " + pointerCount
                                    + " pointers but there are currently "
                                    + expectedPointerCount + " pointers down.");
                            mTouchEventStreamIsTainted = true;
                        }
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL:
                        mTouchEventStreamPointers = 0;
                        mTouchEventStreamIsTainted = false;
                        break;
                    case MotionEvent.ACTION_OUTSIDE:
                        if (mTouchEventStreamPointers != 0) {
                            problem("ACTION_OUTSIDE but pointers are still down.");
                        }
                        ensureHistorySizeIsZeroForThisAction(event);
                        ensurePointerCountIsOneForThisAction(event);
                        mTouchEventStreamIsTainted = false;
                        break;
                    default: {
                        final int actionMasked = event.getActionMasked();
                        final int actionIndex = event.getActionIndex();
                        if (actionMasked == MotionEvent.ACTION_POINTER_DOWN) {
                            if (mTouchEventStreamPointers == 0) {
                                problem("ACTION_POINTER_DOWN but no other pointers were down.");
                                mTouchEventStreamIsTainted = true;
                            }
                            if (actionIndex < 0 || actionIndex >= pointerCount) {
                                problem("ACTION_POINTER_DOWN index is " + actionIndex
                                        + " but the pointer count is " + pointerCount + ".");
                                mTouchEventStreamIsTainted = true;
                            } else {
                                final int id = event.getPointerId(actionIndex);
                                final int idBit = 1 << id;
                                if ((mTouchEventStreamPointers & idBit) != 0) {
                                    problem("ACTION_POINTER_DOWN specified pointer id " + id
                                            + " which is already down.");
                                    mTouchEventStreamIsTainted = true;
                                } else {
                                    mTouchEventStreamPointers |= idBit;
                                }
                            }
                            ensureHistorySizeIsZeroForThisAction(event);
                        } else if (actionMasked == MotionEvent.ACTION_POINTER_UP) {
                            if (actionIndex < 0 || actionIndex >= pointerCount) {
                                problem("ACTION_POINTER_UP index is " + actionIndex
                                        + " but the pointer count is " + pointerCount + ".");
                                mTouchEventStreamIsTainted = true;
                            } else {
                                final int id = event.getPointerId(actionIndex);
                                final int idBit = 1 << id;
                                if ((mTouchEventStreamPointers & idBit) == 0) {
                                    problem("ACTION_POINTER_UP specified pointer id " + id
                                            + " which is not currently down.");
                                    mTouchEventStreamIsTainted = true;
                                } else {
                                    mTouchEventStreamPointers &= ~idBit;
                                }
                            }
                            ensureHistorySizeIsZeroForThisAction(event);
                        } else {
                            problem("Invalid action " + MotionEvent.actionToString(action)
                                    + " for touch event.");
                        }
                        break;
                    }
                }
            } else {
                problem("Source was not SOURCE_CLASS_POINTER.");
            }
        } finally {
            finishEvent();
        }
    }

    /**
     * Checks a generic motion event.
     * @param event The event.
     * @param nestingLevel The nesting level: 0 if called from the base class,
     * or 1 from a subclass.  If the event was already checked by this consistency verifier
     * at a higher nesting level, it will not be checked again.  Used to handle the situation
     * where a subclass dispatching method delegates to its superclass's dispatching method
     * and both dispatching methods call into the consistency verifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.874 -0500", hash_original_method = "23EA37DFEC977078F682E35F151F1942", hash_generated_method = "945189C96917AB1CD5D3FD609E8C62FC")
    
public void onGenericMotionEvent(MotionEvent event, int nestingLevel) {
        if (!startEvent(event, nestingLevel, EVENT_TYPE_GENERIC_MOTION)) {
            return;
        }

        try {
            ensureMetaStateIsNormalized(event.getMetaState());

            final int action = event.getAction();
            final int source = event.getSource();
            if ((source & InputDevice.SOURCE_CLASS_POINTER) != 0) {
                switch (action) {
                    case MotionEvent.ACTION_HOVER_ENTER:
                        ensurePointerCountIsOneForThisAction(event);
                        mHoverEntered = true;
                        break;
                    case MotionEvent.ACTION_HOVER_MOVE:
                        ensurePointerCountIsOneForThisAction(event);
                        break;
                    case MotionEvent.ACTION_HOVER_EXIT:
                        ensurePointerCountIsOneForThisAction(event);
                        if (!mHoverEntered) {
                            problem("ACTION_HOVER_EXIT without prior ACTION_HOVER_ENTER");
                        }
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
            } else if ((source & InputDevice.SOURCE_CLASS_JOYSTICK) != 0) {
                switch (action) {
                    case MotionEvent.ACTION_MOVE:
                        ensurePointerCountIsOneForThisAction(event);
                        break;
                    default:
                        problem("Invalid action for generic joystick event.");
                        break;
                }
            }
        } finally {
            finishEvent();
        }
    }

    /**
     * Notifies the verifier that a given event was unhandled and the rest of the
     * trace for the event should be ignored.
     * This method should only be called if the event was previously checked by
     * the consistency verifier using {@link #onInputEvent} and other methods.
     * @param event The event.
     * @param nestingLevel The nesting level: 0 if called from the base class,
     * or 1 from a subclass.  If the event was already checked by this consistency verifier
     * at a higher nesting level, it will not be checked again.  Used to handle the situation
     * where a subclass dispatching method delegates to its superclass's dispatching method
     * and both dispatching methods call into the consistency verifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.877 -0500", hash_original_method = "95A33BD7B12ABE8439BBD32736BE35D7", hash_generated_method = "3F31F5566F68D34D46F125FC9B780056")
    
public void onUnhandledEvent(InputEvent event, int nestingLevel) {
        if (nestingLevel != mLastNestingLevel) {
            return;
        }

        if (mRecentEventsUnhandled != null) {
            mRecentEventsUnhandled[mMostRecentEventIndex] = true;
        }

        if (event instanceof KeyEvent) {
            final KeyEvent keyEvent = (KeyEvent)event;
            final int deviceId = keyEvent.getDeviceId();
            final int source = keyEvent.getSource();
            final int keyCode = keyEvent.getKeyCode();
            final KeyState state = findKeyState(deviceId, source, keyCode, /*remove*/ false);
            if (state != null) {
                state.unhandled = true;
            }
        } else {
            final MotionEvent motionEvent = (MotionEvent)event;
            if (motionEvent.isTouchEvent()) {
                mTouchEventStreamUnhandled = true;
            } else if ((motionEvent.getSource() & InputDevice.SOURCE_CLASS_TRACKBALL) != 0) {
                if (mTrackballDown) {
                    mTrackballUnhandled = true;
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.880 -0500", hash_original_method = "0D02225F7CFB86AB0627FF86E895BCB3", hash_generated_method = "E5FD72DAC834BBB0A1A8A116BF500630")
    
private void ensureMetaStateIsNormalized(int metaState) {
        final int normalizedMetaState = KeyEvent.normalizeMetaState(metaState);
        if (normalizedMetaState != metaState) {
            problem(String.format("Metastate not normalized.  Was 0x%08x but expected 0x%08x.",
                    metaState, normalizedMetaState));
        }
    }

    
    private static final class KeyState {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.925 -0500", hash_original_method = "E07A46B7C9CA496E8393C71EC1D42E5D", hash_generated_method = "440742E6DEEBD994BE5F4E214F9B8521")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.905 -0500", hash_original_field = "17077E11241666D96423A44B11289496", hash_generated_field = "79BE45FB0228F25C0A9DC9B58E9E4BD0")

        private static Object mRecycledListLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.907 -0500", hash_original_field = "2D9FBBBA8CD65EA5962F3B616CE3522F", hash_generated_field = "379CC4BA4A594A20A4231B542C74B1F1")

        private static KeyState mRecycledList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.910 -0500", hash_original_field = "A293A7A34FA0A1458D0CA1A7AC46383B", hash_generated_field = "A4637F51FF091C45870D06CF8B571722")


        public KeyState next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.912 -0500", hash_original_field = "51A96BAC743342A974612702E055409D", hash_generated_field = "B25950F42C189E4AB05FFB7366B0AA73")

        public int deviceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.914 -0500", hash_original_field = "926255832D3A4770F722E618872D36FC", hash_generated_field = "865C846F4D1F08194526221E7C99DDEB")

        public int source;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.917 -0500", hash_original_field = "AF3F60A45836C339EA3C11B5C54720AC", hash_generated_field = "000F6935635EB02934CE0DE5E09F2D3E")

        public int keyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.919 -0500", hash_original_field = "E4528BA778C57BF81E078BFB9E58B9C5", hash_generated_field = "7DE29E460259F9098EBFCEFDF94DB0DA")

        public boolean unhandled;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.922 -0500", hash_original_method = "9B72C46296302693275D5291E4057DE0", hash_generated_method = "6B5BE5A5B3A51F6690BC5F992EEC0549")
        
private KeyState() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.927 -0500", hash_original_method = "F16B27E6183802CE84F6921B26D81A30", hash_generated_method = "210AED92E6FAD44DEE76AB9E77BC5977")
        
public void recycle() {
            synchronized (mRecycledListLock) {
                next = mRecycledList;
                mRecycledList = next;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.882 -0500", hash_original_method = "960C41882671A36CAB1E6050FF4DEA3B", hash_generated_method = "44D5DB36BDD8DF6B6630B71C66A829F5")
    
private void ensurePointerCountIsOneForThisAction(MotionEvent event) {
        final int pointerCount = event.getPointerCount();
        if (pointerCount != 1) {
            problem("Pointer count is " + pointerCount + " but it should always be 1 for "
                    + MotionEvent.actionToString(event.getAction()));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.884 -0500", hash_original_method = "418A844BE60240583EF50FE17898B3BB", hash_generated_method = "0867002FDA7046589B3E2D1D48E97F35")
    
private void ensureHistorySizeIsZeroForThisAction(MotionEvent event) {
        final int historySize = event.getHistorySize();
        if (historySize != 0) {
            problem("History size is " + historySize + " but it should always be 0 for "
                    + MotionEvent.actionToString(event.getAction()));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.887 -0500", hash_original_method = "4D608F0C62317EB539D3EDD1A5B0BBF8", hash_generated_method = "C8D98A055B25E205D27D64CCE0C6FCF5")
    
private boolean startEvent(InputEvent event, int nestingLevel, String eventType) {
        // Ignore the event if we already checked it at a higher nesting level.
        if (event == mLastEvent && nestingLevel < mLastNestingLevel
                && eventType == mLastEventType) {
            return false;
        }

        if (nestingLevel > 0) {
            mLastEvent = event;
            mLastEventType = eventType;
            mLastNestingLevel = nestingLevel;
        } else {
            mLastEvent = null;
            mLastEventType = null;
            mLastNestingLevel = 0;
        }

        mCurrentEvent = event;
        mCurrentEventType = eventType;
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.890 -0500", hash_original_method = "ED6D322EBF7819A0A849ACCBA13E8A32", hash_generated_method = "38E812172A2A9A0926D672B484E70FF6")
    
private void finishEvent() {
        if (mViolationMessage != null && mViolationMessage.length() != 0) {
            if (!mCurrentEvent.isTainted()) {
                // Write a log message only if the event was not already tainted.
                mViolationMessage.append("\n  in ").append(mCaller);
                mViolationMessage.append("\n  ");
                appendEvent(mViolationMessage, 0, mCurrentEvent, false);

                if (RECENT_EVENTS_TO_LOG != 0 && mRecentEvents != null) {
                    mViolationMessage.append("\n  -- recent events --");
                    for (int i = 0; i < RECENT_EVENTS_TO_LOG; i++) {
                        final int index = (mMostRecentEventIndex + RECENT_EVENTS_TO_LOG - i)
                                % RECENT_EVENTS_TO_LOG;
                        final InputEvent event = mRecentEvents[index];
                        if (event == null) {
                            break;
                        }
                        mViolationMessage.append("\n  ");
                        appendEvent(mViolationMessage, i + 1, event, mRecentEventsUnhandled[index]);
                    }
                }

                Log.d(mLogTag, mViolationMessage.toString());

                // Taint the event so that we do not generate additional violations from it
                // further downstream.
                mCurrentEvent.setTainted(true);
            }
            mViolationMessage.setLength(0);
        }

        if (RECENT_EVENTS_TO_LOG != 0) {
            if (mRecentEvents == null) {
                mRecentEvents = new InputEvent[RECENT_EVENTS_TO_LOG];
                mRecentEventsUnhandled = new boolean[RECENT_EVENTS_TO_LOG];
            }
            final int index = (mMostRecentEventIndex + 1) % RECENT_EVENTS_TO_LOG;
            mMostRecentEventIndex = index;
            if (mRecentEvents[index] != null) {
                mRecentEvents[index].recycle();
            }
            mRecentEvents[index] = mCurrentEvent.copy();
            mRecentEventsUnhandled[index] = false;
        }

        mCurrentEvent = null;
        mCurrentEventType = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.895 -0500", hash_original_method = "C6124E8B7D001D6ECE47F875379D529E", hash_generated_method = "CFC0E333E9DE215BE9F03E939EF29D4C")
    
private void problem(String message) {
        if (mViolationMessage == null) {
            mViolationMessage = new StringBuilder();
        }
        if (mViolationMessage.length() == 0) {
            mViolationMessage.append(mCurrentEventType).append(": ");
        } else {
            mViolationMessage.append("\n  ");
        }
        mViolationMessage.append(message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.899 -0500", hash_original_method = "98F44F7E9C89F442263CA208119E2058", hash_generated_method = "1E44EF6F3064E15D935B7BD9069BC810")
    
private KeyState findKeyState(int deviceId, int source, int keyCode, boolean remove) {
        KeyState last = null;
        KeyState state = mKeyStateList;
        while (state != null) {
            if (state.deviceId == deviceId && state.source == source
                    && state.keyCode == keyCode) {
                if (remove) {
                    if (last != null) {
                        last.next = state.next;
                    } else {
                        mKeyStateList = state.next;
                    }
                    state.next = null;
                }
                return state;
            }
            last = state;
            state = state.next;
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:15.901 -0500", hash_original_method = "49CD2D0DE125B77D543B3E0017318A6E", hash_generated_method = "D11B1D862F9CBFB8EE8DB258D2D53C1F")
    
private void addKeyState(int deviceId, int source, int keyCode) {
        KeyState state = KeyState.obtain(deviceId, source, keyCode);
        state.next = mKeyStateList;
        mKeyStateList = state;
    }
}

