package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

import droidsafe.helpers.DSUtils;

public final class MotionEvent extends InputEvent implements Parcelable {
    
    public static MotionEvent droidsafeObtainEvent(){
        MotionEvent ev = new MotionEvent();
        return ev;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.588 -0500", hash_original_method = "A44B14BB1BCBE206EC593BA2C9AFA143", hash_generated_method = "3A835C7ECC1FDB91788D3E3E10F93466")
    
private static final void ensureSharedTempPointerCapacity(int desiredCapacity) {
        if (gSharedTempPointerCoords == null
                || gSharedTempPointerCoords.length < desiredCapacity) {
            int capacity = gSharedTempPointerCoords != null ? gSharedTempPointerCoords.length : 8;
            while (capacity < desiredCapacity) {
                capacity *= 2;
            }
            gSharedTempPointerCoords = PointerCoords.createArray(capacity);
            gSharedTempPointerProperties = PointerProperties.createArray(capacity);
            gSharedTempPointerIndexMap = new int[capacity];
        }
    }
    
    private static int nativeInitialize(int nativePtr,
            int deviceId, int source, int action, int flags, int edgeFlags,
            int metaState, int buttonState,
            float xOffset, float yOffset, float xPrecision, float yPrecision,
            long downTimeNanos, long eventTimeNanos,
            int pointerCount, PointerProperties[] pointerIds, PointerCoords[] pointerCoords) {
            
            double temp = deviceId + source + action + flags + edgeFlags +
                        metaState + buttonState + xOffset + yOffset  + 
                        xPrecision + yPrecision + downTimeNanos + eventTimeNanos +
                        pointerIds[0].getTaintInt() + pointerCoords[0].getTaintInt();

        return (int)(temp);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCopy(int destNativePtr, int sourceNativePtr,
            boolean keepHistory) {
        int temp = keepHistory? 0: 1; 
        return (destNativePtr + sourceNativePtr + temp);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDispose(int nativePtr) {
    }
    
    private static void nativeAddBatch(int nativePtr, long eventTimeNanos,
            PointerCoords[] pointerCoords, int metaState) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetDeviceId(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetSource(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeSetSource(int nativePtr, int source) {
        return (nativePtr + source);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetAction(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetAction(int nativePtr, int action) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeIsTouchEvent(int nativePtr) {
        return toTaintBoolean(nativePtr);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetFlags(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetFlags(int nativePtr, int flags) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetEdgeFlags(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetEdgeFlags(int nativePtr, int action) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetMetaState(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetButtonState(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeOffsetLocation(int nativePtr, float deltaX, float deltaY) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static float nativeGetXOffset(int nativePtr) {
        return (float)nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static float nativeGetYOffset(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static float nativeGetXPrecision(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static float nativeGetYPrecision(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static long nativeGetDownTimeNanos(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetDownTimeNanos(int nativePtr, long downTime) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetPointerCount(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetPointerId(int nativePtr, int pointerIndex) {
        return nativePtr + pointerIndex;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetToolType(int nativePtr, int pointerIndex) {
        return nativePtr + pointerIndex;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeFindPointerIndex(int nativePtr, int pointerId) {
        return nativePtr + pointerId;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetHistorySize(int nativePtr) {
        return nativePtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static long nativeGetEventTimeNanos(int nativePtr, int historyPos) {
        return nativePtr + historyPos;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static float nativeGetRawAxisValue(int nativePtr,
            int axis, int pointerIndex, int historyPos) {
        return (nativePtr + axis + pointerIndex + historyPos);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static float nativeGetAxisValue(int nativePtr,
            int axis, int pointerIndex, int historyPos) {
        return (nativePtr + axis + pointerIndex + historyPos);
    }
    
    private static void nativeGetPointerCoords(int nativePtr,
            int pointerIndex, int historyPos, PointerCoords outPointerCoords) {
        outPointerCoords.addTaint(nativePtr + pointerIndex + historyPos);
    }
    
    private static void nativeGetPointerProperties(int nativePtr,
            int pointerIndex, PointerProperties outPointerProperties) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeScale(int nativePtr, float scale) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeTransform(int nativePtr, Matrix matrix) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeReadFromParcel(int nativePtr, Parcel parcel) {
        return (nativePtr + parcel.getTaintInt());
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeWriteToParcel(int nativePtr, Parcel parcel) {
        parcel.addTaint(nativePtr);
    }

    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.755 -0500", hash_original_method = "2A0D7EAD7D2D4BD57D90237963E14123", hash_generated_method = "764E77A2466C2EEB909234927FC9E4A0")
    
static private MotionEvent obtain() {
        final MotionEvent ev;
        synchronized (gRecyclerLock) {
            ev = gRecyclerTop;
            if (ev == null) {
                return new MotionEvent();
            }
            gRecyclerTop = ev.mNext;
            gRecyclerUsed -= 1;
        }
        ev.mRecycledLocation = null;
        ev.mRecycled = false;
        ev.mNext = null;
        return ev;
    }

    /**
     * Create a new MotionEvent, filling in all of the basic values that
     * define the motion.
     *
     * @param downTime The time (in ms) when the user originally pressed down to start 
     * a stream of position events.  This must be obtained from {@link SystemClock#uptimeMillis()}.
     * @param eventTime The the time (in ms) when this specific event was generated.  This 
     * must be obtained from {@link SystemClock#uptimeMillis()}.
     * @param action The kind of action being performed, such as {@link #ACTION_DOWN}.
     * @param pointerCount The number of pointers that will be in this event.
     * @param pointerProperties An array of <em>pointerCount</em> values providing
     * a {@link PointerProperties} property object for each pointer, which must
     * include the pointer identifier.
     * @param pointerCoords An array of <em>pointerCount</em> values providing
     * a {@link PointerCoords} coordinate object for each pointer.
     * @param metaState The state of any meta / modifier keys that were in effect when
     * the event was generated.
     * @param buttonState The state of buttons that are pressed.
     * @param xPrecision The precision of the X coordinate being reported.
     * @param yPrecision The precision of the Y coordinate being reported.
     * @param deviceId The id for the device that this event came from.  An id of
     * zero indicates that the event didn't come from a physical device; other
     * numbers are arbitrary and you shouldn't depend on the values.
     * @param edgeFlags A bitfield indicating which edges, if any, were touched by this
     * MotionEvent.
     * @param source The source of this event.
     * @param flags The motion event flags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.758 -0500", hash_original_method = "A204D392D258EF41A56793600F1CE50A", hash_generated_method = "6879D47F66BD84CD6DB9E290DBCB8772")
    
static public MotionEvent obtain(long downTime, long eventTime,
            int action, int pointerCount, PointerProperties[] pointerProperties,
            PointerCoords[] pointerCoords, int metaState, int buttonState,
            float xPrecision, float yPrecision, int deviceId,
            int edgeFlags, int source, int flags) {
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeInitialize(ev.mNativePtr,
                deviceId, source, action, flags, edgeFlags, metaState, buttonState,
                0, 0, xPrecision, yPrecision,
                downTime * NS_PER_MS, eventTime * NS_PER_MS,
                pointerCount, pointerProperties, pointerCoords);
        return ev;
    }

    /**
     * Create a new MotionEvent, filling in all of the basic values that
     * define the motion.
     * 
     * @param downTime The time (in ms) when the user originally pressed down to start
     * a stream of position events.  This must be obtained from {@link SystemClock#uptimeMillis()}.
     * @param eventTime The the time (in ms) when this specific event was generated.  This
     * must be obtained from {@link SystemClock#uptimeMillis()}.
     * @param action The kind of action being performed, such as {@link #ACTION_DOWN}.
     * @param pointerCount The number of pointers that will be in this event.
     * @param pointerIds An array of <em>pointerCount</em> values providing
     * an identifier for each pointer.
     * @param pointerCoords An array of <em>pointerCount</em> values providing
     * a {@link PointerCoords} coordinate object for each pointer.
     * @param metaState The state of any meta / modifier keys that were in effect when
     * the event was generated.
     * @param xPrecision The precision of the X coordinate being reported.
     * @param yPrecision The precision of the Y coordinate being reported.
     * @param deviceId The id for the device that this event came from.  An id of
     * zero indicates that the event didn't come from a physical device; other
     * numbers are arbitrary and you shouldn't depend on the values.
     * @param edgeFlags A bitfield indicating which edges, if any, were touched by this
     * MotionEvent.
     * @param source The source of this event.
     * @param flags The motion event flags.
     *
     * @deprecated Use {@link #obtain(long, long, int, int, PointerProperties[], PointerCoords[], int, int, float, float, int, int, int, int)}
     * instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.762 -0500", hash_original_method = "29303BD9CA676DA8DA0C6D61C95B80AD", hash_generated_method = "4FEA28EE77F11A453C77B10F7808B967")
    
@Deprecated
    static public MotionEvent obtain(long downTime, long eventTime,
            int action, int pointerCount, int[] pointerIds, PointerCoords[] pointerCoords,
            int metaState, float xPrecision, float yPrecision, int deviceId,
            int edgeFlags, int source, int flags) {
        synchronized (gSharedTempLock) {
            ensureSharedTempPointerCapacity(pointerCount);
            final PointerProperties[] pp = gSharedTempPointerProperties;
            for (int i = 0; i < pointerCount; i++) {
                pp[i].clear();
                pp[i].id = pointerIds[i];
            }
            return obtain(downTime, eventTime, action, pointerCount, pp,
                    pointerCoords, metaState, 0, xPrecision, yPrecision, deviceId,
                    edgeFlags, source, flags);
        }
    }

    /**
     * Create a new MotionEvent, filling in all of the basic values that
     * define the motion.
     *
     * @param downTime The time (in ms) when the user originally pressed down to start
     * a stream of position events.  This must be obtained from {@link SystemClock#uptimeMillis()}.
     * @param eventTime  The the time (in ms) when this specific event was generated.  This
     * must be obtained from {@link SystemClock#uptimeMillis()}.
     * @param action The kind of action being performed, such as {@link #ACTION_DOWN}.
     * @param x The X coordinate of this event.
     * @param y The Y coordinate of this event.
     * @param pressure The current pressure of this event.  The pressure generally
     * ranges from 0 (no pressure at all) to 1 (normal pressure), however
     * values higher than 1 may be generated depending on the calibration of
     * the input device.
     * @param size A scaled value of the approximate size of the area being pressed when
     * touched with the finger. The actual value in pixels corresponding to the finger
     * touch is normalized with a device specific range of values
     * and scaled to a value between 0 and 1.
     * @param metaState The state of any meta / modifier keys that were in effect when
     * the event was generated.
     * @param xPrecision The precision of the X coordinate being reported.
     * @param yPrecision The precision of the Y coordinate being reported.
     * @param deviceId The id for the device that this event came from.  An id of
     * zero indicates that the event didn't come from a physical device; other
     * numbers are arbitrary and you shouldn't depend on the values.
     * @param edgeFlags A bitfield indicating which edges, if any, were touched by this
     * MotionEvent.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.765 -0500", hash_original_method = "1E17DF4D2E642F9316AB5D83170D1374", hash_generated_method = "781E6B54E01322E06173924A59BC3BEB")
    
static public MotionEvent obtain(long downTime, long eventTime, int action,
            float x, float y, float pressure, float size, int metaState,
            float xPrecision, float yPrecision, int deviceId, int edgeFlags) {
        MotionEvent ev = obtain();
        synchronized (gSharedTempLock) {
            ensureSharedTempPointerCapacity(1);
            final PointerProperties[] pp = gSharedTempPointerProperties;
            pp[0].clear();
            pp[0].id = 0;

            final PointerCoords pc[] = gSharedTempPointerCoords;
            pc[0].clear();
            pc[0].x = x;
            pc[0].y = y;
            pc[0].pressure = pressure;
            pc[0].size = size;

            ev.mNativePtr = nativeInitialize(ev.mNativePtr,
                    deviceId, InputDevice.SOURCE_UNKNOWN, action, 0, edgeFlags, metaState, 0,
                    0, 0, xPrecision, yPrecision,
                    downTime * NS_PER_MS, eventTime * NS_PER_MS,
                    1, pp, pc);
            return ev;
        }
    }

    /**
     * Create a new MotionEvent, filling in all of the basic values that
     * define the motion.
     *
     * @param downTime The time (in ms) when the user originally pressed down to start
     * a stream of position events.  This must be obtained from {@link SystemClock#uptimeMillis()}.
     * @param eventTime  The the time (in ms) when this specific event was generated.  This
     * must be obtained from {@link SystemClock#uptimeMillis()}.
     * @param action The kind of action being performed, such as {@link #ACTION_DOWN}.
     * @param pointerCount The number of pointers that are active in this event.
     * @param x The X coordinate of this event.
     * @param y The Y coordinate of this event.
     * @param pressure The current pressure of this event.  The pressure generally
     * ranges from 0 (no pressure at all) to 1 (normal pressure), however
     * values higher than 1 may be generated depending on the calibration of
     * the input device.
     * @param size A scaled value of the approximate size of the area being pressed when
     * touched with the finger. The actual value in pixels corresponding to the finger
     * touch is normalized with a device specific range of values
     * and scaled to a value between 0 and 1.
     * @param metaState The state of any meta / modifier keys that were in effect when
     * the event was generated.
     * @param xPrecision The precision of the X coordinate being reported.
     * @param yPrecision The precision of the Y coordinate being reported.
     * @param deviceId The id for the device that this event came from.  An id of
     * zero indicates that the event didn't come from a physical device; other
     * numbers are arbitrary and you shouldn't depend on the values.
     * @param edgeFlags A bitfield indicating which edges, if any, were touched by this
     * MotionEvent.
     * 
     * @deprecated Use {@link #obtain(long, long, int, float, float, float, float, int, float, float, int, int)}
     * instead.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.767 -0500", hash_original_method = "5621B9ADE3B8EF50DDDF7D0ECB510E6B", hash_generated_method = "A59CF82C458A58C478465FFC39AB754F")
    
@Deprecated
    static public MotionEvent obtain(long downTime, long eventTime, int action,
            int pointerCount, float x, float y, float pressure, float size, int metaState,
            float xPrecision, float yPrecision, int deviceId, int edgeFlags) {
        return obtain(downTime, eventTime, action, x, y, pressure, size,
                metaState, xPrecision, yPrecision, deviceId, edgeFlags);
    }

    /**
     * Create a new MotionEvent, filling in a subset of the basic motion
     * values.  Those not specified here are: device id (always 0), pressure
     * and size (always 1), x and y precision (always 1), and edgeFlags (always 0).
     *
     * @param downTime The time (in ms) when the user originally pressed down to start
     * a stream of position events.  This must be obtained from {@link SystemClock#uptimeMillis()}.
     * @param eventTime  The the time (in ms) when this specific event was generated.  This
     * must be obtained from {@link SystemClock#uptimeMillis()}.
     * @param action The kind of action being performed, such as {@link #ACTION_DOWN}.
     * @param x The X coordinate of this event.
     * @param y The Y coordinate of this event.
     * @param metaState The state of any meta / modifier keys that were in effect when
     * the event was generated.
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.770 -0500", hash_original_method = "C4E1548FEFF7CE0FD853413E91CFBE59", hash_generated_method = "BB84597C158113D132EC190F62F58E4F")
    
static public MotionEvent obtain(long downTime, long eventTime, int action,
            float x, float y, int metaState) {
        return obtain(downTime, eventTime, action, x, y, 1.0f, 1.0f,
                metaState, 1.0f, 1.0f, 0, 0);
    }

    /**
     * Create a new MotionEvent, copying from an existing one.
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.772 -0500", hash_original_method = "A056A38EFEDA7A73CC0FCCF73A42E3E9", hash_generated_method = "EF7246B441D70BC6654A3D23D2C639CD")
    
static public MotionEvent obtain(MotionEvent other) {
        if (other == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        }

        MotionEvent ev = obtain();
        ev.mNativePtr = nativeCopy(ev.mNativePtr, other.mNativePtr, true /*keepHistory*/);
        return ev;
    }

    /**
     * Create a new MotionEvent, copying from an existing one, but not including
     * any historical point information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.775 -0500", hash_original_method = "EF06BFAED4C963D2A51D5D03CF5F89C2", hash_generated_method = "9E12C719D4E2F9DE70DB8E186EDBD052")
    
static public MotionEvent obtainNoHistory(MotionEvent other) {
        if (other == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        }

        MotionEvent ev = obtain();
        ev.mNativePtr = nativeCopy(ev.mNativePtr, other.mNativePtr, false /*keepHistory*/);
        return ev;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.978 -0500", hash_original_method = "21B64904C65635047BDD8B29F88F873B", hash_generated_method = "3DFFF6B981AED6A7796A2EE5AF2B6C9B")
    
private static final float clamp(float value, float low, float high) {
        if (value < low) {
            return low;
        } else if (value > high) {
            return high;
        }
        return value;
    }

    /**
     * Returns a string that represents the symbolic name of the specified action
     * such as "ACTION_DOWN", "ACTION_POINTER_DOWN(3)" or an equivalent numeric constant
     * such as "35" if unknown.
     *
     * @param action The action.
     * @return The symbolic name of the specified action.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.995 -0500", hash_original_method = "677EA2B2000D6A74FF8682A7B068EF0E", hash_generated_method = "C16FF6AA6516C4C904778FACB705FBF2")
    
public static String actionToString(int action) {
        switch (action) {
            case ACTION_DOWN:
                return "ACTION_DOWN";
            case ACTION_UP:
                return "ACTION_UP";
            case ACTION_CANCEL:
                return "ACTION_CANCEL";
            case ACTION_OUTSIDE:
                return "ACTION_OUTSIDE";
            case ACTION_MOVE:
                return "ACTION_MOVE";
            case ACTION_HOVER_MOVE:
                return "ACTION_HOVER_MOVE";
            case ACTION_SCROLL:
                return "ACTION_SCROLL";
            case ACTION_HOVER_ENTER:
                return "ACTION_HOVER_ENTER";
            case ACTION_HOVER_EXIT:
                return "ACTION_HOVER_EXIT";
        }
        int index = (action & ACTION_POINTER_INDEX_MASK) >> ACTION_POINTER_INDEX_SHIFT;
        switch (action & ACTION_MASK) {
            case ACTION_POINTER_DOWN:
                return "ACTION_POINTER_DOWN(" + index + ")";
            case ACTION_POINTER_UP:
                return "ACTION_POINTER_UP(" + index + ")";
            default:
                return Integer.toString(action);
        }
    }

    /**
     * Returns a string that represents the symbolic name of the specified axis
     * such as "AXIS_X" or an equivalent numeric constant such as "42" if unknown.
     *
     * @param axis The axis
     * @return The symbolic name of the specified axis.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.997 -0500", hash_original_method = "CD7691F9B0EDFAD8C08008BAAFAB09D1", hash_generated_method = "2AB4D24013CC1BCF0BB0F89D2394C1B4")
    
public static String axisToString(int axis) {
        String symbolicName = AXIS_SYMBOLIC_NAMES.get(axis);
        return symbolicName != null ? symbolicName : Integer.toString(axis);
    }

    /**
     * Gets an axis by its symbolic name such as "AXIS_X" or an
     * equivalent numeric constant such as "42".
     *
     * @param symbolicName The symbolic name of the axis.
     * @return The axis or -1 if not found.
     * @see #keycodeToString
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.000 -0500", hash_original_method = "ED7596641D0AD2A83AA1412880E16E35", hash_generated_method = "9BB01C558D2CFCC5F3F56807099D8790")
    
public static int axisFromString(String symbolicName) {
        if (symbolicName == null) {
            throw new IllegalArgumentException("symbolicName must not be null");
        }

        final int count = AXIS_SYMBOLIC_NAMES.size();
        for (int i = 0; i < count; i++) {
            if (symbolicName.equals(AXIS_SYMBOLIC_NAMES.valueAt(i))) {
                return i;
            }
        }

        try {
            return Integer.parseInt(symbolicName, 10);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    /**
     * Returns a string that represents the symbolic name of the specified combined
     * button state flags such as "0", "BUTTON_PRIMARY",
     * "BUTTON_PRIMARY|BUTTON_SECONDARY" or an equivalent numeric constant such as "0x10000000"
     * if unknown.
     *
     * @param buttonState The button state.
     * @return The symbolic name of the specified combined button state flags.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.003 -0500", hash_original_method = "7E9E2322F8BF9BC3C830467DF1C4FD47", hash_generated_method = "EA345665434FE1E441B8A753E3F3C278")
    
public static String buttonStateToString(int buttonState) {
        if (buttonState == 0) {
            return "0";
        }
        StringBuilder result = null;
        int i = 0;
        while (buttonState != 0) {
            final boolean isSet = (buttonState & 1) != 0;
            buttonState >>>= 1; // unsigned shift!
            if (isSet) {
                final String name = BUTTON_SYMBOLIC_NAMES[i];
                if (result == null) {
                    if (buttonState == 0) {
                        return name;
                    }
                    result = new StringBuilder(name);
                } else {
                    result.append('|');
                    result.append(name);
                }
            }
            i += 1;
        }
        return result.toString();
    }

    /**
     * Returns a string that represents the symbolic name of the specified tool type
     * such as "TOOL_TYPE_FINGER" or an equivalent numeric constant such as "42" if unknown.
     *
     * @param toolType The tool type.
     * @return The symbolic name of the specified tool type.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.005 -0500", hash_original_method = "5EC3F5E4185B2190F76F36B4BDD7355A", hash_generated_method = "9BE93B36307DB8A68E3698A36E3288BF")
    
public static String toolTypeToString(int toolType) {
        String symbolicName = TOOL_TYPE_SYMBOLIC_NAMES.get(toolType);
        return symbolicName != null ? symbolicName : Integer.toString(toolType);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.017 -0500", hash_original_method = "57C17E945EEB836F9B50085EB541FE87", hash_generated_method = "183CC5B595137A77AD15B1BFF9C0E5B5")
    
public static MotionEvent createFromParcelBody(Parcel in) {
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeReadFromParcel(ev.mNativePtr, in);
        return ev;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.343 -0500", hash_original_field = "00F5099701FD2962AB4D6E4530EFC900", hash_generated_field = "1E55FD918071A214A5C67DF1505BB56B")

    private static final long NS_PER_MS = 1000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.346 -0500", hash_original_field = "CD71AEEB5BD3A875E610FF7C5BA69768", hash_generated_field = "FA3C17D544830BC1BEE55D29729BDFE3")

    private static final boolean TRACK_RECYCLED_LOCATION = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.348 -0500", hash_original_field = "364108B745B17C9B3DCA018D6F79B6FF", hash_generated_field = "122232306FDB60B34ACA42DBAA65B736")

    public static final int INVALID_POINTER_ID = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.351 -0500", hash_original_field = "FC4C290B75F77C9110197620363F9111", hash_generated_field = "464488178905DF6887AEEC102D03F9BB")

    public static final int ACTION_MASK             = 0xff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.353 -0500", hash_original_field = "CE75AB6924C9E0A7F48169E5F0A2A68F", hash_generated_field = "B56FBABE5CC8DDE909CEA8CDE98BA93D")

    public static final int ACTION_DOWN             = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.356 -0500", hash_original_field = "FA982872F36C4639DC991EEF44D99302", hash_generated_field = "E9419BD1576C4C89CB972C93BF43E7C5")

    public static final int ACTION_UP               = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.359 -0500", hash_original_field = "A720B9BDF5F4C85A41BAB68B21595665", hash_generated_field = "0869EE70BD47CB90D812F686B7F0D216")

    public static final int ACTION_MOVE             = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.361 -0500", hash_original_field = "5699A13CCA69B96725447E3E00D20F7D", hash_generated_field = "CCD39E7D9940D088C4EBAE690B5B3006")

    public static final int ACTION_CANCEL           = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.363 -0500", hash_original_field = "AB9D452B0C356B73FE29AB0163442344", hash_generated_field = "B53AF36739EBD3146722B0AB3CAF54B6")

    public static final int ACTION_OUTSIDE          = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.366 -0500", hash_original_field = "6B8026AE673197DC4509FD1C52E85893", hash_generated_field = "BE1BA8B002AC6D11B1BA8B25140F3104")

    public static final int ACTION_POINTER_DOWN     = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.368 -0500", hash_original_field = "918CC644F8F3853E02E49713894DFC96", hash_generated_field = "779F82BEF077301CD2887D1C33590F74")

    public static final int ACTION_POINTER_UP       = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.371 -0500", hash_original_field = "C216C2D482483B9B30C7BB2675C50F3F", hash_generated_field = "A31BF98337FB8359E97DA48D76D80977")

    public static final int ACTION_HOVER_MOVE       = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.374 -0500", hash_original_field = "ABED2ED2557F7CC3CCDED7CE69B5434B", hash_generated_field = "D4C11BB0C70739D756D7BA7A8EBDE32D")

    public static final int ACTION_SCROLL           = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.376 -0500", hash_original_field = "6DFA606950D7B0DEC8419F9FB95C2C3C", hash_generated_field = "6EED9A028D9812B11E3EC6500A22417D")

    public static final int ACTION_HOVER_ENTER      = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.380 -0500", hash_original_field = "82CE12F47ED4177C0200CD4F439C144D", hash_generated_field = "36537B951CA8A88E1E580F444A68C4EB")

    public static final int ACTION_HOVER_EXIT       = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.382 -0500", hash_original_field = "B84AC1CDEB7CB6E7A2AD3AF6ED95FD6D", hash_generated_field = "E260033975F8D36BD53DB361D54BA2BF")

    public static final int ACTION_POINTER_INDEX_MASK  = 0xff00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.385 -0500", hash_original_field = "B386A1CE3358CBFE4E59C73CCCF8B604", hash_generated_field = "3ED9AD85BB2784B1321927FB5C085339")

    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.387 -0500", hash_original_field = "8772B0468DB9746D47B180C5FA83EA04", hash_generated_field = "0E6D248BF8E40C6A30CD011E4FE93537")

    @Deprecated
    public static final int ACTION_POINTER_1_DOWN   = ACTION_POINTER_DOWN | 0x0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.390 -0500", hash_original_field = "91FFF3DC811681D51E6D33897BF25E97", hash_generated_field = "2A2F376950DB01CC014C8F15C5D29770")

    @Deprecated
    public static final int ACTION_POINTER_2_DOWN   = ACTION_POINTER_DOWN | 0x0100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.392 -0500", hash_original_field = "DC83272818D8D3C399E43BCE26C05EC8", hash_generated_field = "9C71C2EB30843366313F3020BE578C26")

    @Deprecated
    public static final int ACTION_POINTER_3_DOWN   = ACTION_POINTER_DOWN | 0x0200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.395 -0500", hash_original_field = "095E760A86DDC43E031A464131C3C7C6", hash_generated_field = "CB217DFD0D7D2A2D8289D57696E595C7")

    @Deprecated
    public static final int ACTION_POINTER_1_UP     = ACTION_POINTER_UP | 0x0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.398 -0500", hash_original_field = "78A0DCB1009B3B3CCCF8DC1DD6DAB370", hash_generated_field = "0531D8E2B94086788DA257D61DD61C0F")

    @Deprecated
    public static final int ACTION_POINTER_2_UP     = ACTION_POINTER_UP | 0x0100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.401 -0500", hash_original_field = "01D422DB70C86F6B243C6F5C4C8768F0", hash_generated_field = "98C2F8F94E43CA43968FDCDBCC9896C4")

    @Deprecated
    public static final int ACTION_POINTER_3_UP     = ACTION_POINTER_UP | 0x0200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.403 -0500", hash_original_field = "F78DAF89E15E0412BCC6B9E32D626081", hash_generated_field = "21CA20F1626331DC2869522A2DE48834")

    @Deprecated
    public static final int ACTION_POINTER_ID_MASK  = 0xff00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.406 -0500", hash_original_field = "F1EF28305CB5FC2D916BE6B722DCF327", hash_generated_field = "674FBE2D655FD483B823B2E251529FF3")

    @Deprecated
    public static final int ACTION_POINTER_ID_SHIFT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.408 -0500", hash_original_field = "CBF40A5F23A9C475FC4491E9486E7E61", hash_generated_field = "D55190196D2C1F6E3FFFC84FA0B9D772")

    public static final int FLAG_WINDOW_IS_OBSCURED = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.410 -0500", hash_original_field = "85A63D3EE365696E199B23FBFFDAF4DD", hash_generated_field = "22C757AFB129CA98FC86BD04BEE94F98")

    public static final int FLAG_TAINTED = 0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.413 -0500", hash_original_field = "94124ED35062659642809201B85B5365", hash_generated_field = "E88E0AA9A676F8906011C2C253859C66")

    public static final int EDGE_TOP = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.416 -0500", hash_original_field = "2E5F59199DA39032AE7DE4A47DF84F6D", hash_generated_field = "7F13D97BAA00BFCDC5B911BB5B6DCDF3")

    public static final int EDGE_BOTTOM = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.419 -0500", hash_original_field = "F6DBAC3E89E5F42DC171C9EE72F25B1E", hash_generated_field = "96B2B8C704DDAD0603C6C6E2FFC340B1")

    public static final int EDGE_LEFT = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.421 -0500", hash_original_field = "2199F8F0EA3BA8466E001A254FFF369C", hash_generated_field = "4B4418A2700C288E6EFE7AF6B858A111")

    public static final int EDGE_RIGHT = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.424 -0500", hash_original_field = "D9DD2A24D94EB7276ED3BE96A0CEF8DC", hash_generated_field = "6AC2F269D8C677A5928AAB4766B0AFA4")

    public static final int AXIS_X = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.426 -0500", hash_original_field = "B137A2C573C3C02392EA1740C1B3EB36", hash_generated_field = "1F1942945032A87C66ACA5752705A256")

    public static final int AXIS_Y = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.429 -0500", hash_original_field = "40FA794A7BC188657DFDBC8ED3985D1B", hash_generated_field = "5CB739150541FFE06EFD5DECAA58BF2C")

    public static final int AXIS_PRESSURE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.431 -0500", hash_original_field = "90E2C85B6690E790835BA62AB09530ED", hash_generated_field = "F805D88CFB32566B5D69E445454FA20B")

    public static final int AXIS_SIZE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.434 -0500", hash_original_field = "1E331EA91A89F804A1E9B00066CA1FA8", hash_generated_field = "4422123708A385A40B3A3EAD28C77CA0")

    public static final int AXIS_TOUCH_MAJOR = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.436 -0500", hash_original_field = "5B22CFFB0DCD592106DDACAA071D5E01", hash_generated_field = "9BD07319C2DC512FC7AFF06DB4C457EB")

    public static final int AXIS_TOUCH_MINOR = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.439 -0500", hash_original_field = "0F87577D8A444AF2A9BF4DECEE1B18C2", hash_generated_field = "3A23BEE8699344F8699632E58AAE9D00")

    public static final int AXIS_TOOL_MAJOR = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.442 -0500", hash_original_field = "68BC40844BC5C0156085E9953CCB0809", hash_generated_field = "F26604DCEE776E17C73C06ABB61691F6")

    public static final int AXIS_TOOL_MINOR = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.444 -0500", hash_original_field = "1B818718A00F56F4498E737060977EED", hash_generated_field = "2A1393B38A6522964DCE18C89C02987A")

    public static final int AXIS_ORIENTATION = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.447 -0500", hash_original_field = "6926C1A17472621207B8CCC3212FA82C", hash_generated_field = "3653EDC97D1EC153035B8B2CF03F0D9F")

    public static final int AXIS_VSCROLL = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.449 -0500", hash_original_field = "A6DFB6B5FD87D3F954EC7043CDF31DED", hash_generated_field = "92F839C5EBC2322D5FA86535F6F819CB")

    public static final int AXIS_HSCROLL = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.452 -0500", hash_original_field = "CE039796D5708FB9D47B7800504CBD04", hash_generated_field = "AF121E953BE1BD481D0CFED4A68E74C0")

    public static final int AXIS_Z = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.454 -0500", hash_original_field = "0E5CD6156B4BBEA742CC0AB1691E8D6C", hash_generated_field = "F9C0DE51E0127685ECA28E542A120E88")

    public static final int AXIS_RX = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.456 -0500", hash_original_field = "1115E50CBECE695FF8C2AAD36C7A45C5", hash_generated_field = "0C4C76335C9A3564DACCCDBE8DD301F2")

    public static final int AXIS_RY = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.459 -0500", hash_original_field = "5831759BF81EE0586B822A6C5AABE0D9", hash_generated_field = "FE837C29D6032EC2960992B9D8A8B178")

    public static final int AXIS_RZ = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.462 -0500", hash_original_field = "9CC476EEF9BD43517CCF308E59535AAB", hash_generated_field = "95D53DACF181EE3407879E3C0B3371DA")

    public static final int AXIS_HAT_X = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.464 -0500", hash_original_field = "2433B5722572817FBBF0C4BC438F3D80", hash_generated_field = "448C69D0D61F2BF459C3AC283A9A3DD2")

    public static final int AXIS_HAT_Y = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.467 -0500", hash_original_field = "19A83F702C95568323C0AC280CF76847", hash_generated_field = "4450CC9F108DED3391D6ED8F0D534120")

    public static final int AXIS_LTRIGGER = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.469 -0500", hash_original_field = "8A5555020B399D20ABC110EF9A40A548", hash_generated_field = "275AE4D63A24B8018CE3E210BAC8D939")

    public static final int AXIS_RTRIGGER = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.472 -0500", hash_original_field = "0C5F1E824420B4D6FC5E59D31509DBB6", hash_generated_field = "538CDE95EB2664616EE4F8F418B16FCF")

    public static final int AXIS_THROTTLE = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.474 -0500", hash_original_field = "7C023B4DEE3BA4F96A35B48BB09573C5", hash_generated_field = "556882041792FB019CA717764224D5C4")

    public static final int AXIS_RUDDER = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.477 -0500", hash_original_field = "E4CD08745354294217EE705E8EB0EE9D", hash_generated_field = "D3B7AC7DA5A4B49C56D33CA3953C8391")

    public static final int AXIS_WHEEL = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.479 -0500", hash_original_field = "91E631C5D6FCDA208F619E4CD2770A39", hash_generated_field = "B56F86F8DDA863909AE502D90FA7D4A4")

    public static final int AXIS_GAS = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.483 -0500", hash_original_field = "8E26979E4B1222A2EDC9D3DA3E9F4B48", hash_generated_field = "7148E428BBB18A5A04C2D90A4D20C2D2")

    public static final int AXIS_BRAKE = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.485 -0500", hash_original_field = "30BDA4F485BC21D10A21E0DBFCFF330F", hash_generated_field = "53EBC10458EF090346DB7C3BF7B8B449")

    public static final int AXIS_DISTANCE = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.487 -0500", hash_original_field = "0160A78C3E95BDE9B268BFE8C69DDC1F", hash_generated_field = "579F39E86B98900179C06E9A07BE7C7B")

    public static final int AXIS_TILT = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.490 -0500", hash_original_field = "4761EFE78C037CC438916AF4DD1B5B89", hash_generated_field = "2C24AD3C3E56DD84D0733A0B91218D75")

    public static final int AXIS_GENERIC_1 = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.493 -0500", hash_original_field = "0ABCD5D3A839401DA813B257FDB32F1E", hash_generated_field = "D5EDF8D95D30F8707CB60CE48E5D080D")

    public static final int AXIS_GENERIC_2 = 33;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.495 -0500", hash_original_field = "8A6CCF9CB76EE4BB5EDA5F900CB12748", hash_generated_field = "0FB2B7871027C51D19E6ADDB6629599D")

    public static final int AXIS_GENERIC_3 = 34;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.497 -0500", hash_original_field = "C980ADAF06E5E6FA50CA1A9AC3127189", hash_generated_field = "B3834C6A5E7EAC276B34400E316CC889")

    public static final int AXIS_GENERIC_4 = 35;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.500 -0500", hash_original_field = "9EA79AC0540A0EBA379B3BF0F7176C63", hash_generated_field = "D771A2C8BF7E6631141C9F156725F986")

    public static final int AXIS_GENERIC_5 = 36;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.502 -0500", hash_original_field = "11DE14DE3BC684DEFF4BF8ED111C8435", hash_generated_field = "5ADBF1379367815D17640566262ADBDC")

    public static final int AXIS_GENERIC_6 = 37;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.505 -0500", hash_original_field = "DF7CB5FE84E13F72D7E8358A347EDB53", hash_generated_field = "CABE9E3D1339B834B58E2AC551B60D70")

    public static final int AXIS_GENERIC_7 = 38;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.508 -0500", hash_original_field = "7A476E5E8964A9F0B69317C3387D02FB", hash_generated_field = "783DFA0925833D6927778A6752C33469")

    public static final int AXIS_GENERIC_8 = 39;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.510 -0500", hash_original_field = "1F0933674EBD39680DDFE667D9FAD0D1", hash_generated_field = "844B22BFFE980B1170B8E78B193CD8F8")

    public static final int AXIS_GENERIC_9 = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.513 -0500", hash_original_field = "94075E7A6C4B1D21CC7B437EEC98DB73", hash_generated_field = "F52491FA1506F81B61F5BBCAD317F2D4")

    public static final int AXIS_GENERIC_10 = 41;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.515 -0500", hash_original_field = "B0B05E975C1E79F399DC4A0CCAB60805", hash_generated_field = "441A2A8984D04F945C0B9706F4D91238")

    public static final int AXIS_GENERIC_11 = 42;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.518 -0500", hash_original_field = "D831802A3B857355C42CAD10D102FA22", hash_generated_field = "6EE9D87F1B155C3A9E15C5BFB57DB156")

    public static final int AXIS_GENERIC_12 = 43;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.520 -0500", hash_original_field = "2CFA842CFD2E841561EF7B1E47158FEB", hash_generated_field = "0C980E1F71AC4BD10A6D1136200C35B1")

    public static final int AXIS_GENERIC_13 = 44;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.523 -0500", hash_original_field = "6E9ACCA7E03E55FF5346F7DE49B0D1D1", hash_generated_field = "08EDA9B50DF874F18FD4A782BFF79258")

    public static final int AXIS_GENERIC_14 = 45;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.525 -0500", hash_original_field = "84547065E6B28C6B282FB9DAAAA80676", hash_generated_field = "9B7002F98DD35624F49E82F9F27BEA43")

    public static final int AXIS_GENERIC_15 = 46;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.528 -0500", hash_original_field = "CEBD6217158D1D754722C052DB9FEA46", hash_generated_field = "CDB6932C5544664A6FAAE7570CEF1ED8")

    public static final int AXIS_GENERIC_16 = 47;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.531 -0500", hash_original_field = "A2BD8EDF21D1CC92649EA8829C5E6F17", hash_generated_field = "D5E980B0B69C488D88204FDB2B939C59")

    //  native/include/android/input.h
    //  frameworks/base/include/ui/KeycodeLabels.h

    // Symbolic names of all axes.
    private static final SparseArray<String> AXIS_SYMBOLIC_NAMES = new SparseArray<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.534 -0500", hash_original_field = "FFB531C25BD6F2C3BC3E86A153857BD8", hash_generated_field = "ADA948F0304197BC40CACAE24C6ECB05")

    public static final int BUTTON_PRIMARY = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.537 -0500", hash_original_field = "54CB1E748584BA16A79F3F06C0BFA3E7", hash_generated_field = "699964DE06376B73FD25E1C2E308AF7B")

    public static final int BUTTON_SECONDARY = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.539 -0500", hash_original_field = "CC1344D18E72B927192998B97610CA25", hash_generated_field = "0EFC57E0035C368753C281B7448CCAD7")

    public static final int BUTTON_TERTIARY = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.542 -0500", hash_original_field = "3BED8751DDA83E792A3706B6894956C6", hash_generated_field = "5A526B3B078557E38DB5D4C91419279E")

    public static final int BUTTON_BACK = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.544 -0500", hash_original_field = "8B556B8F94CE5573B788A24858DBE829", hash_generated_field = "4E2DD22E6782E832F99D62265E33DC7B")

    public static final int BUTTON_FORWARD = 1 << 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.547 -0500", hash_original_field = "7FBE5AA665A4D3D859D690E2B707CEF7", hash_generated_field = "6824717A3D90036A44E48A550EFA2584")

    //  native/include/android/input.h

    // Symbolic names of all button states in bit order from least significant
    // to most significant.
    private static final String[] BUTTON_SYMBOLIC_NAMES = new String[] {
        "BUTTON_PRIMARY",
        "BUTTON_SECONDARY",
        "BUTTON_TERTIARY",
        "BUTTON_BACK",
        "BUTTON_FORWARD",
        "0x00000020",
        "0x00000040",
        "0x00000080",
        "0x00000100",
        "0x00000200",
        "0x00000400",
        "0x00000800",
        "0x00001000",
        "0x00002000",
        "0x00004000",
        "0x00008000",
        "0x00010000",
        "0x00020000",
        "0x00040000",
        "0x00080000",
        "0x00100000",
        "0x00200000",
        "0x00400000",
        "0x00800000",
        "0x01000000",
        "0x02000000",
        "0x04000000",
        "0x08000000",
        "0x10000000",
        "0x20000000",
        "0x40000000",
        "0x80000000",
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.549 -0500", hash_original_field = "B44A43F261A0FEDD9C3319CF26696275", hash_generated_field = "B997CD436D37980DF5D7404E593DC402")

    public static final int TOOL_TYPE_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.552 -0500", hash_original_field = "087055297DC803CD496220996FA78465", hash_generated_field = "C864443B9D1FDB0CC8BE96AE33701299")

    public static final int TOOL_TYPE_FINGER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.555 -0500", hash_original_field = "D3B26DAC618F2DE64E2A158A60A5B6B5", hash_generated_field = "5BBE29494AB919D60EB460BF7FABACCD")

    public static final int TOOL_TYPE_STYLUS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.557 -0500", hash_original_field = "1FBFA7252541B31A69D11CF5E243CF0F", hash_generated_field = "4F5A6CDBC3D361EDE9CAD667AC25320F")

    public static final int TOOL_TYPE_MOUSE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.561 -0500", hash_original_field = "5778E78F1F0A3001A6F58470FA4ABA6B", hash_generated_field = "09C1A33B09293914694BF2A3886AC6DB")

    public static final int TOOL_TYPE_ERASER = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.563 -0500", hash_original_field = "868609B90A37725394EFB5653B3CCD85", hash_generated_field = "C1353D235583870DEB97E3AED280D857")

    //  native/include/android/input.h

    // Symbolic names of all tool types.
    private static final SparseArray<String> TOOL_TYPE_SYMBOLIC_NAMES = new SparseArray<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.566 -0500", hash_original_field = "3DB456AC21CF83BB30EF3A2D32B763E5", hash_generated_field = "B0BEAD643F65C07DAE0B28D2861E52D4")

    private static final int HISTORY_CURRENT = -0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.568 -0500", hash_original_field = "F593DBD4ACC5DC484D76C0656C0FB27F", hash_generated_field = "632CD138CDBCADE9A63F9B23105E1648")

    private static final int MAX_RECYCLED = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.571 -0500", hash_original_field = "383C33CA63B8C16F39C24669AA7A3D08", hash_generated_field = "4D2E3DEDF37103D77BF3BB46692742C8")

    private static final Object gRecyclerLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.573 -0500", hash_original_field = "58D63F887B2FB3C0CAE7920E9516E0C7", hash_generated_field = "695DE00CD65E15FE07938D99F2CA2696")

    private static int gRecyclerUsed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.576 -0500", hash_original_field = "024EE4EEE76776AFA371496B2A7268ED", hash_generated_field = "E9FD3DB4A4C51C360253148C4F1C8508")

    private static MotionEvent gRecyclerTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.578 -0500", hash_original_field = "F490227242633854C02A42A9829984F1", hash_generated_field = "6A80BAAD533CA1088E3CB5CD87FA7C16")

    // the caller into single element PointerCoords and pointer id arrays.
    private static final Object gSharedTempLock = new Object();
    
    public static final class PointerCoords {

        /** @hide */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.035 -0500", hash_original_method = "1926C043E5CBC7A33752E32EE0FEC2AA", hash_generated_method = "68EEAFCEF4BADCEA4E4D1A6A07DF5BDE")
        
public static PointerCoords[] createArray(int size) {
            PointerCoords[] array = new PointerCoords[size];
            for (int i = 0; i < size; i++) {
                array[i] = new PointerCoords();
            }
            return array;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.022 -0500", hash_original_field = "CC2228F55F50205CF1C27F136781B59F", hash_generated_field = "1ED50B8C8EE9915850360B0973B4FC02")

        private static final int INITIAL_PACKED_AXIS_VALUES = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.024 -0500", hash_original_field = "B1CE8E8F0B27F2739EAF92EBD091E8CD", hash_generated_field = "616BA79E3CF38111CD6326A774A7BA12")

        private long mPackedAxisBits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.027 -0500", hash_original_field = "A82370F86F44ACA52F8298CA5D551160", hash_generated_field = "74AC3FA36AA575C3DEE392AD51F3FC84")

        private float[] mPackedAxisValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.037 -0500", hash_original_field = "EED2933541FCCE7155092AF77A402EA9", hash_generated_field = "0CC4A8770822EF2A4B3BD536BBF6C113")

        public float x;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.039 -0500", hash_original_field = "531E5158163E3809C8650CC9FEEE1C8C", hash_generated_field = "E8D9A0915E4274087E59C025C4DCDA11")

        public float y;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.042 -0500", hash_original_field = "350CD261C16DCE9228659B272B865DC3", hash_generated_field = "8D3DD02B3785A296D75D1BFB99C62E42")

        public float pressure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.044 -0500", hash_original_field = "A7F331F023D65F880B23A40616F9EBBE", hash_generated_field = "295F60DE48801BD75A245B044AE96BA0")

        public float size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.047 -0500", hash_original_field = "12026FCE9009DF4DC8FA511FE1BC0862", hash_generated_field = "6D6952CAD458217EEFCB2922EE3D3E82")

        public float touchMajor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.049 -0500", hash_original_field = "5A8F3583ECA819D6E8553DAEE6C43B47", hash_generated_field = "492641BCD483F61BC74CAF973D65A13D")

        public float touchMinor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.051 -0500", hash_original_field = "54948981F3547D5F36FF1D09E8E8028D", hash_generated_field = "32FD2A0018A7199A2ED20949B6E0486E")

        public float toolMajor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.054 -0500", hash_original_field = "DF8FCE89741583A287FA5E9BA188EE49", hash_generated_field = "173EB15A07C0771733DC98A43E20CE98")

        public float toolMinor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.056 -0500", hash_original_field = "561CD1342085838FE8F7DB10295A4BFB", hash_generated_field = "054A1E23DAAFDEC28AE3DA031EECF136")

        public float orientation;

        /**
         * Creates a pointer coords object with all axes initialized to zero.
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.029 -0500", hash_original_method = "30C014872AED120D5788F672204C6D56", hash_generated_method = "45EE4D8B4D5F40C0EC03A5329F4F79C2")
        
public PointerCoords() {
        }

        /**
         * Creates a pointer coords object as a copy of the
         * contents of another pointer coords object.
         *
         * @param other The pointer coords object to copy.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.032 -0500", hash_original_method = "4C1A041805DDE756B7430BBCF7A4A54D", hash_generated_method = "74918D1B46A8DB58C5C08D6C7BD61FFF")
        
public PointerCoords(PointerCoords other) {
            copyFrom(other);
        }

        /**
         * Clears the contents of this object.
         * Resets all axes to zero.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.059 -0500", hash_original_method = "5B10C041062144B27347C9202A1953B2", hash_generated_method = "5DD20AF7BF74864D6FF80C4FFD65E2BD")
        
public void clear() {
            mPackedAxisBits = 0;

            x = 0;
            y = 0;
            pressure = 0;
            size = 0;
            touchMajor = 0;
            touchMinor = 0;
            toolMajor = 0;
            toolMinor = 0;
            orientation = 0;
        }

        /**
         * Copies the contents of another pointer coords object.
         *
         * @param other The pointer coords object to copy.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.062 -0500", hash_original_method = "A2C68F8615572C95C5947791A8CC8026", hash_generated_method = "3F5A46C8072690BC5A043F57C3B27AFD")
        
public void copyFrom(PointerCoords other) {
            final long bits = other.mPackedAxisBits;
            mPackedAxisBits = bits;
            if (bits != 0) {
                final float[] otherValues = other.mPackedAxisValues;
                final int count = Long.bitCount(bits);
                float[] values = mPackedAxisValues;
                if (values == null || count > values.length) {
                    values = new float[otherValues.length];
                    mPackedAxisValues = values;
                }
                System.arraycopy(otherValues, 0, values, 0, count);
            }

            x = other.x;
            y = other.y;
            pressure = other.pressure;
            size = other.size;
            touchMajor = other.touchMajor;
            touchMinor = other.touchMinor;
            toolMajor = other.toolMajor;
            toolMinor = other.toolMinor;
            orientation = other.orientation;
        }

        /**
         * Gets the value associated with the specified axis.
         *
         * @param axis The axis identifier for the axis value to retrieve.
         * @return The value associated with the axis, or 0 if none.
         *
         * @see MotionEvent#AXIS_X
         * @see MotionEvent#AXIS_Y
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.065 -0500", hash_original_method = "566631CFDB34A411EF93513211D62594", hash_generated_method = "4014B2633E4A2564CAC6F8E8D55F4E95")
        
public float getAxisValue(int axis) {
            switch (axis) {
                case AXIS_X:
                    return x;
                case AXIS_Y:
                    return y;
                case AXIS_PRESSURE:
                    return pressure;
                case AXIS_SIZE:
                    return size;
                case AXIS_TOUCH_MAJOR:
                    return touchMajor;
                case AXIS_TOUCH_MINOR:
                    return touchMinor;
                case AXIS_TOOL_MAJOR:
                    return toolMajor;
                case AXIS_TOOL_MINOR:
                    return toolMinor;
                case AXIS_ORIENTATION:
                    return orientation;
                default: {
                    if (axis < 0 || axis > 63) {
                        throw new IllegalArgumentException("Axis out of range.");
                    }
                    final long bits = mPackedAxisBits;
                    final long axisBit = 1L << axis;
                    if ((bits & axisBit) == 0) {
                        return 0;
                    }
                    final int index = Long.bitCount(bits & (axisBit - 1L));
                    return mPackedAxisValues[index];
                }
            }
        }

        /**
         * Sets the value associated with the specified axis.
         *
         * @param axis The axis identifier for the axis value to assign.
         * @param value The value to set.
         *
         * @see MotionEvent#AXIS_X
         * @see MotionEvent#AXIS_Y
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.068 -0500", hash_original_method = "55E9DEFA01615304E1434A1FAB8328FA", hash_generated_method = "401C4677197B7A302EAB1CB24B9D2D72")
        
public void setAxisValue(int axis, float value) {
            switch (axis) {
                case AXIS_X:
                    x = value;
                    break;
                case AXIS_Y:
                    y = value;
                    break;
                case AXIS_PRESSURE:
                    pressure = value;
                    break;
                case AXIS_SIZE:
                    size = value;
                    break;
                case AXIS_TOUCH_MAJOR:
                    touchMajor = value;
                    break;
                case AXIS_TOUCH_MINOR:
                    touchMinor = value;
                    break;
                case AXIS_TOOL_MAJOR:
                    toolMajor = value;
                    break;
                case AXIS_TOOL_MINOR:
                    toolMinor = value;
                    break;
                case AXIS_ORIENTATION:
                    orientation = value;
                    break;
                default: {
                    if (axis < 0 || axis > 63) {
                        throw new IllegalArgumentException("Axis out of range.");
                    }
                    final long bits = mPackedAxisBits;
                    final long axisBit = 1L << axis;
                    final int index = Long.bitCount(bits & (axisBit - 1L));
                    float[] values = mPackedAxisValues;
                    if ((bits & axisBit) == 0) {
                        if (values == null) {
                            values = new float[INITIAL_PACKED_AXIS_VALUES];
                            mPackedAxisValues = values;
                        } else {
                            final int count = Long.bitCount(bits);
                            if (count < values.length) {
                                if (index != count) {
                                    System.arraycopy(values, index, values, index + 1,
                                            count - index);
                                }
                            } else {
                                float[] newValues = new float[count * 2];
                                System.arraycopy(values, 0, newValues, 0, index);
                                System.arraycopy(values, index, newValues, index + 1,
                                        count - index);
                                values = newValues;
                                mPackedAxisValues = values;
                            }
                        }
                        mPackedAxisBits = bits | axisBit;
                    }
                    values[index] = value;
                }
            }
        }
    }
    
    public static final class PointerProperties {

        /** @hide */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.082 -0500", hash_original_method = "72739C70491AC0C585CFDF74B7788457", hash_generated_method = "6A44B6989D594E3784198D9AB8835CD0")
        
public static PointerProperties[] createArray(int size) {
            PointerProperties[] array = new PointerProperties[size];
            for (int i = 0; i < size; i++) {
                array[i] = new PointerProperties();
            }
            return array;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.084 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.086 -0500", hash_original_field = "C6E481AF8A3D7BF5693BBF51E5EE7A40", hash_generated_field = "E5CA883B5E8E2CF4928B3E305240E7C6")

        public int toolType;
        /**
         * Creates a pointer properties object with an invalid pointer id.
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.076 -0500", hash_original_method = "D6AAE40F539D7383E827DA395512E95B", hash_generated_method = "6CAFD55FB74ECA4404786941388DD45A")
        
public PointerProperties() {
            clear();
        }

        /**
         * Creates a pointer properties object as a copy of the contents of
         * another pointer properties object.
         * @param other
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.079 -0500", hash_original_method = "0B0B44B5B3A0DCF648446956F27785E9", hash_generated_method = "873E6C0D71869C3EA45C72EE0380FF7D")
        
public PointerProperties(PointerProperties other) {
            copyFrom(other);
        }

        /**
         * Resets the pointer properties to their initial values.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.089 -0500", hash_original_method = "ADC6A83F955A9ED0C1C75B5F08682583", hash_generated_method = "AFCC3B46F8103D1E7497B67D0F397AC5")
        
public void clear() {
            id = INVALID_POINTER_ID;
            toolType = TOOL_TYPE_UNKNOWN;
        }

        /**
         * Copies the contents of another pointer properties object.
         *
         * @param other The pointer properties object to copy.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.091 -0500", hash_original_method = "1E34ECE529256025A33CF5DCBE029131", hash_generated_method = "0B81DE9DA82B50525121F68564DFC47B")
        
public void copyFrom(PointerProperties other) {
            id = other.id;
            toolType = other.toolType;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.581 -0500", hash_original_field = "CACAAA123B9FE51639C2E92276DE6F3E", hash_generated_field = "1C70655B0F01405596723D256AD5AE2B")

    private static PointerCoords[] gSharedTempPointerCoords;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.583 -0500", hash_original_field = "21A9EC6460AD14460A040065AE63BCB7", hash_generated_field = "7767E5DED892F800315C4BF8ECA945E5")

    private static PointerProperties[] gSharedTempPointerProperties;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.585 -0500", hash_original_field = "BACF6A7F7D3FF8F1D1946D41521B3AAD", hash_generated_field = "A9BB8E94115BE6A30724987AE7313B53")

    private static int[] gSharedTempPointerIndexMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "92338855F3FDCA2FD9317526465F4D98", hash_generated_field = "C140DAE13300F0DB81E6D0FF25B21CC4")

    public static final Parcelable.Creator<MotionEvent> CREATOR
            = new Parcelable.Creator<MotionEvent>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.009 -0500", hash_original_method = "E988C06BFCE97E62AC2813BD29B32BEE", hash_generated_method = "EA7995B37BF37B0A751844672E9AEE92")
        
public MotionEvent createFromParcel(Parcel in) {
            in.readInt(); // skip token, we already know this is a MotionEvent
            return MotionEvent.createFromParcelBody(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.011 -0500", hash_original_method = "5EBE0D6E50651488F7881A7509B9CA02", hash_generated_method = "4D30FED25DB971B9595D134CF89886DB")
        
public MotionEvent[] newArray(int size) {
            return new MotionEvent[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.591 -0500", hash_original_field = "41C07C66F04AB96F2A50982AEE89213D", hash_generated_field = "23CD98EE9F206841B49D023F257D02A5")

    private int mNativePtr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.593 -0500", hash_original_field = "0E987E306896478A35079A952971CC41", hash_generated_field = "4ED1BADBA3F9AC6D1D2BD2B16B6BF967")

    private MotionEvent mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.596 -0500", hash_original_field = "7CE140D407E955711B40F90DD17F57EA", hash_generated_field = "4E4D5EFD76E218484C8A2F86B097FF08")

    private RuntimeException mRecycledLocation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.598 -0500", hash_original_field = "54377D1FA2AD41427FB83B9E454546B7", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.752 -0400", hash_original_method = "B1B69F583261D8BEEC921FF43580AA66", hash_generated_method = "40B8D4E791D456515D6D7EBB1643CE79")
    public  MotionEvent() {
        // ---------- Original Method ----------
    
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.752 -0500", hash_original_method = "3F0B5C050D986DD9F1F0F2A742C616C8", hash_generated_method = "9D1B4CBF29CC86076D0E7A276889F27A")
    
@Override
    protected void finalize() throws Throwable {
        try {
            if (mNativePtr != 0) {
                nativeDispose(mNativePtr);
                mNativePtr = 0;
            }
        } finally {
            super.finalize();
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.778 -0500", hash_original_method = "78DE11FBBF58608981D1F74EEB443B54", hash_generated_method = "24D3C42E6E2EEA55FBB3AE165D6E7BAB")
    
@Override
    public MotionEvent copy() {
        return obtain(this);
    }

    /**
     * Recycle the MotionEvent, to be re-used by a later caller.  After calling
     * this function you must not ever touch the event again.
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.780 -0500", hash_original_method = "187F7D3A42078A42C8212C3EFE0E8B16", hash_generated_method = "DDB1558C76E1712D2A8FA62A70F35900")
    
public final void recycle() {
        // Ensure recycle is only called once!
        if (TRACK_RECYCLED_LOCATION) {
            if (mRecycledLocation != null) {
                throw new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
            }
            mRecycledLocation = new RuntimeException("Last recycled here");
            //Log.w("MotionEvent", "Recycling event " + this, mRecycledLocation);
        } else {
            if (mRecycled) {
                throw new RuntimeException(toString() + " recycled twice!");
            }
            mRecycled = true;
        }

        synchronized (gRecyclerLock) {
            if (gRecyclerUsed < MAX_RECYCLED) {
                gRecyclerUsed++;
                mNext = gRecyclerTop;
                gRecyclerTop = this;
            }
        }
    }
    
    /**
     * Scales down the coordination of this event by the given scale.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.783 -0500", hash_original_method = "A082C8E505553F853E56AAFC11CF0CDA", hash_generated_method = "471E50739C85C5CEFB84FC22E144AB1A")
    
public final void scale(float scale) {
        nativeScale(mNativePtr, scale);
    }

    /** {@inheritDoc} */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.785 -0500", hash_original_method = "E51EA2AB032E4C79CC226174E2601818", hash_generated_method = "43DDD167B696D69CB02F56285723C2A8")
    
@Override
    public final int getDeviceId() {
        return nativeGetDeviceId(mNativePtr);
    }

    /** {@inheritDoc} */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.789 -0500", hash_original_method = "44501F684180CAB98F3511C2614C7994", hash_generated_method = "DBFA389EA5B22236C2B11758801E944C")
    
@Override
    public final int getSource() {
        return nativeGetSource(mNativePtr);
    }

    /** {@inheritDoc} */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.791 -0500", hash_original_method = "1502AF3F26B6DD95879512031D9FB73E", hash_generated_method = "A0EBDC00C5620E0317B7BE91C53E9F81")
    
@Override
    public final void setSource(int source) {
        nativeSetSource(mNativePtr, source);
    }

    /**
     * Return the kind of action being performed.
     * Consider using {@link #getActionMasked} and {@link #getActionIndex} to retrieve
     * the separate masked action and pointer index.
     * @return The action, such as {@link #ACTION_DOWN} or
     * the combination of {@link #ACTION_POINTER_DOWN} with a shifted pointer index.
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.794 -0500", hash_original_method = "FA5880EB8F61D955AC5922ACE620FCE2", hash_generated_method = "0179DCDBED0C80F6D103A239F3884634")
    
public final int getAction() {
        return nativeGetAction(mNativePtr);
    }

    /**
     * Return the masked action being performed, without pointer index information.
     * Use {@link #getActionIndex} to return the index associated with pointer actions.
     * @return The action, such as {@link #ACTION_DOWN} or {@link #ACTION_POINTER_DOWN}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.796 -0500", hash_original_method = "268411790684740D49A019DF59E1FFBB", hash_generated_method = "0EF47299C1014B42203BA87354C5061B")
    
public final int getActionMasked() {
        return nativeGetAction(mNativePtr) & ACTION_MASK;
    }

    /**
     * For {@link #ACTION_POINTER_DOWN} or {@link #ACTION_POINTER_UP}
     * as returned by {@link #getActionMasked}, this returns the associated
     * pointer index.
     * The index may be used with {@link #getPointerId(int)},
     * {@link #getX(int)}, {@link #getY(int)}, {@link #getPressure(int)},
     * and {@link #getSize(int)} to get information about the pointer that has
     * gone down or up.
     * @return The index associated with the action.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.798 -0500", hash_original_method = "464EE1689B645958C6F5E17990D5ECA4", hash_generated_method = "64BFF9A86656A73B6BA09A7FE09FC84E")
    
public final int getActionIndex() {
        return (nativeGetAction(mNativePtr) & ACTION_POINTER_INDEX_MASK)
                >> ACTION_POINTER_INDEX_SHIFT;
    }

    /**
     * Returns true if this motion event is a touch event.
     * <p>
     * Specifically excludes pointer events with action {@link #ACTION_HOVER_MOVE},
     * {@link #ACTION_HOVER_ENTER}, {@link #ACTION_HOVER_EXIT}, or {@link #ACTION_SCROLL}
     * because they are not actually touch events (the pointer is not down).
     * </p>
     * @return True if this motion event is a touch event.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.800 -0500", hash_original_method = "3A9CDEA51D903248E7ACBBA8C3F57155", hash_generated_method = "33D1EDE02EE0E1D42A531DA97897513F")
    
public final boolean isTouchEvent() {
        return nativeIsTouchEvent(mNativePtr);
    }

    /**
     * Gets the motion event flags.
     *
     * @see #FLAG_WINDOW_IS_OBSCURED
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.803 -0500", hash_original_method = "A25E485C356A262F519C0A5841CFA47B", hash_generated_method = "1C68C36437F1E1C7170D0450041CAF77")
    
public final int getFlags() {
        return nativeGetFlags(mNativePtr);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.806 -0500", hash_original_method = "24A8A0C0077001C335E0B5C917301FE4", hash_generated_method = "8BF3F140BCBB5C306209E8F51012EE5E")
    
@Override
    public final boolean isTainted() {
        final int flags = getFlags();
        return (flags & FLAG_TAINTED) != 0;
    }

    /** @hide */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.808 -0500", hash_original_method = "96C1138F844BE852B50B0529E539E061", hash_generated_method = "CFA34516CBE0CB108AA68C4A881709C2")
    
@Override
    public final void setTainted(boolean tainted) {
        final int flags = getFlags();
        nativeSetFlags(mNativePtr, tainted ? flags | FLAG_TAINTED : flags & ~FLAG_TAINTED);
    }

    /**
     * Returns the time (in ms) when the user originally pressed down to start
     * a stream of position events.
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.811 -0500", hash_original_method = "5F4C05CD4E223E38846D15A6EA0DF305", hash_generated_method = "BFCB5E2E7AFD8EDA5624FBFBB70790A2")
    
public final long getDownTime() {
        return nativeGetDownTimeNanos(mNativePtr) / NS_PER_MS;
    }

    /**
     * Sets the time (in ms) when the user originally pressed down to start
     * a stream of position events.
     *
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.813 -0500", hash_original_method = "97B3432DE604A4A8C3339017F5056697", hash_generated_method = "CF95B389CACF294F138E0DCA405EF125")
    
public final void setDownTime(long downTime) {
        nativeSetDownTimeNanos(mNativePtr, downTime * NS_PER_MS);
    }

    /**
     * Returns the time (in ms) when this specific event was generated.
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.816 -0500", hash_original_method = "CCF6A1C7FFBA398090457272FB07E7C9", hash_generated_method = "88BA2C3FDA0F218BB6D1E6E0DAFA6CAD")
    
public final long getEventTime() {
        return nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT) / NS_PER_MS;
    }

    /**
     * Returns the time (in ns) when this specific event was generated.
     * The value is in nanosecond precision but it may not have nanosecond accuracy.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.818 -0500", hash_original_method = "9EB1FC24DA069289850F91A3F8734D9A", hash_generated_method = "9D15A455BC25443573C56D33AA58B456")
    
public final long getEventTimeNano() {
        return nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT);
    }

    /**
     * {@link #getX(int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @see #AXIS_X
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.820 -0500", hash_original_method = "4BF6642E766343B332FD98949BC6C582", hash_generated_method = "E774E1D7846DB35D7F1CB7A3E088FA67")
    
public final float getX() {
        return nativeGetAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT);
    }

    /**
     * {@link #getY(int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @see #AXIS_Y
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.823 -0500", hash_original_method = "91A63DEAB3A8AC7438EA04466792BD82", hash_generated_method = "EC2C2BD98A3263DC8F891D4B3BDEE4E1")
    
public final float getY() {
        return nativeGetAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT);
    }

    /**
     * {@link #getPressure(int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @see #AXIS_PRESSURE
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.825 -0500", hash_original_method = "6675B94FFDE5461AE8829AF0934758CB", hash_generated_method = "F4CF8F33390FF62B43DB408D2165DE41")
    
public final float getPressure() {
        return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, HISTORY_CURRENT);
    }

    /**
     * {@link #getSize(int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @see #AXIS_SIZE
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.827 -0500", hash_original_method = "04BA234B263118C319F9FB3039E4C966", hash_generated_method = "734F822408016FA0FD4B36330FA71B0D")
    
public final float getSize() {
        return nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, HISTORY_CURRENT);
    }
    
    /**
     * {@link #getTouchMajor(int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @see #AXIS_TOUCH_MAJOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.830 -0500", hash_original_method = "7EDCA08C9EC8F904EE9855CC249509CB", hash_generated_method = "C33CF46FE6EABF5C716975FF67534A4D")
    
public final float getTouchMajor() {
        return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, HISTORY_CURRENT);
    }

    /**
     * {@link #getTouchMinor(int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @see #AXIS_TOUCH_MINOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.832 -0500", hash_original_method = "0D1B5526DE02F52B1563B7D7F6F58090", hash_generated_method = "6EFD631375D85949D7EA33EAEF2A3D7F")
    
public final float getTouchMinor() {
        return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, HISTORY_CURRENT);
    }
    
    /**
     * {@link #getToolMajor(int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @see #AXIS_TOOL_MAJOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.835 -0500", hash_original_method = "88DA06A5CC2E8F8456F3789E8A68ED44", hash_generated_method = "C625BE07D0902B515405BF35DF7A9F6F")
    
public final float getToolMajor() {
        return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, HISTORY_CURRENT);
    }

    /**
     * {@link #getToolMinor(int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @see #AXIS_TOOL_MINOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.838 -0500", hash_original_method = "68541C2106990EEA679DCE03A62D7FCC", hash_generated_method = "F654819131CCA1E948DF3700EF9B2780")
    
public final float getToolMinor() {
        return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, HISTORY_CURRENT);
    }

    /**
     * {@link #getOrientation(int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @see #AXIS_ORIENTATION
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.840 -0500", hash_original_method = "6DB87F8256212E2B4D49883D1C47D372", hash_generated_method = "02856AC1B9C5A948D1871240562CAF19")
    
public final float getOrientation() {
        return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, HISTORY_CURRENT);
    }

    /**
     * {@link #getAxisValue(int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @param axis The axis identifier for the axis value to retrieve.
     *
     * @see #AXIS_X
     * @see #AXIS_Y
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.843 -0500", hash_original_method = "630AA047225B25427528E4D32F567B17", hash_generated_method = "0A62A911682857734069A577612DF675")
    
public final float getAxisValue(int axis) {
        return nativeGetAxisValue(mNativePtr, axis, 0, HISTORY_CURRENT);
    }

    /**
     * The number of pointers of data contained in this event.  Always
     * >= 1.
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.845 -0500", hash_original_method = "2050CCC0293D52B162C880AD9BC3C6F6", hash_generated_method = "47EC7AB67BCA05539C0F93193D87B8C3")
    
public final int getPointerCount() {
        return nativeGetPointerCount(mNativePtr);
    }
    
    /**
     * Return the pointer identifier associated with a particular pointer
     * data index is this event.  The identifier tells you the actual pointer
     * number associated with the data, accounting for individual pointers
     * going up and down since the start of the current gesture.
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.847 -0500", hash_original_method = "43D465AFB7AC0153BC6ACD556C5FF613", hash_generated_method = "B99662569C98F0E25C05C1CC7A03F83D")
    
public final int getPointerId(int pointerIndex) {
        return nativeGetPointerId(mNativePtr, pointerIndex);
    }

    /**
     * Gets the tool type of a pointer for the given pointer index.
     * The tool type indicates the type of tool used to make contact such
     * as a finger or stylus, if known.
     *
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @return The tool type of the pointer.
     *
     * @see #TOOL_TYPE_UNKNOWN
     * @see #TOOL_TYPE_FINGER
     * @see #TOOL_TYPE_STYLUS
     * @see #TOOL_TYPE_MOUSE
     * @see #TOOL_TYPE_INDIRECT_FINGER
     * @see #TOOL_TYPE_INDIRECT_STYLUS
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.849 -0500", hash_original_method = "4F4E823E6A973C2A4D85C86C0A6A2D9D", hash_generated_method = "04D0FEBBB14D5C63A270CA193E393052")
    
public final int getToolType(int pointerIndex) {
        return nativeGetToolType(mNativePtr, pointerIndex);
    }

    /**
     * Given a pointer identifier, find the index of its data in the event.
     * 
     * @param pointerId The identifier of the pointer to be found.
     * @return Returns either the index of the pointer (for use with
     * {@link #getX(int)} et al.), or -1 if there is no data available for
     * that pointer identifier.
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.852 -0500", hash_original_method = "396B4C03ADE41E49E928286EB7438AA9", hash_generated_method = "21872CD12D012F1BD1E94365B6D0FDDB")
    
public final int findPointerIndex(int pointerId) {
        return nativeFindPointerIndex(mNativePtr, pointerId);
    }

    /**
     * Returns the X coordinate of this event for the given pointer
     * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
     * identifier for this index).
     * Whole numbers are pixels; the 
     * value may have a fraction for input devices that are sub-pixel precise. 
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     *
     * @see #AXIS_X
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.855 -0500", hash_original_method = "13E56CEAC1D2714A9A1790EF5117F935", hash_generated_method = "D7BF3F326723077266BC957BEF7B8FFD")
    
public final float getX(int pointerIndex) {
        return nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, HISTORY_CURRENT);
    }

    /**
     * Returns the Y coordinate of this event for the given pointer
     * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
     * identifier for this index).
     * Whole numbers are pixels; the
     * value may have a fraction for input devices that are sub-pixel precise.
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     *
     * @see #AXIS_Y
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.857 -0500", hash_original_method = "9A0C47F653E064961B232F3274CD29C9", hash_generated_method = "71BE84DA9B597D86FE06FCA23AC26688")
    
public final float getY(int pointerIndex) {
        return nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, HISTORY_CURRENT);
    }

    /**
     * Returns the current pressure of this event for the given pointer
     * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
     * identifier for this index).
     * The pressure generally
     * ranges from 0 (no pressure at all) to 1 (normal pressure), however
     * values higher than 1 may be generated depending on the calibration of
     * the input device.
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     *
     * @see #AXIS_PRESSURE
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.859 -0500", hash_original_method = "36E2BAC74F4F826870F428D93CA1D371", hash_generated_method = "853627536A376AE6FC7AA9CE30E14A34")
    
public final float getPressure(int pointerIndex) {
        return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, HISTORY_CURRENT);
    }

    /**
     * Returns a scaled value of the approximate size for the given pointer
     * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
     * identifier for this index).
     * This represents some approximation of the area of the screen being
     * pressed; the actual value in pixels corresponding to the
     * touch is normalized with the device specific range of values
     * and scaled to a value between 0 and 1. The value of size can be used to
     * determine fat touch events.
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     *
     * @see #AXIS_SIZE
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.862 -0500", hash_original_method = "50DE00A69645B3335E8383A50AB1EB05", hash_generated_method = "DF62F281166AEBA6756CB5BC80308CA9")
    
public final float getSize(int pointerIndex) {
        return nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, HISTORY_CURRENT);
    }
    
    /**
     * Returns the length of the major axis of an ellipse that describes the touch
     * area at the point of contact for the given pointer
     * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
     * identifier for this index).
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     *
     * @see #AXIS_TOUCH_MAJOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.865 -0500", hash_original_method = "28BED69B39230D6E2E593658DA262948", hash_generated_method = "CB44CEA9AFDE439E2F1E70E386850A13")
    
public final float getTouchMajor(int pointerIndex) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, HISTORY_CURRENT);
    }
    
    /**
     * Returns the length of the minor axis of an ellipse that describes the touch
     * area at the point of contact for the given pointer
     * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
     * identifier for this index).
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     *
     * @see #AXIS_TOUCH_MINOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.867 -0500", hash_original_method = "2C1FBE2BFEFC6BD6A6EFC25F55DD94B0", hash_generated_method = "0B2BD74B55548160B531E0B33B45A0C2")
    
public final float getTouchMinor(int pointerIndex) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, HISTORY_CURRENT);
    }
    
    /**
     * Returns the length of the major axis of an ellipse that describes the size of
     * the approaching tool for the given pointer
     * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
     * identifier for this index).
     * The tool area represents the estimated size of the finger or pen that is
     * touching the device independent of its actual touch area at the point of contact.
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     *
     * @see #AXIS_TOOL_MAJOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.869 -0500", hash_original_method = "66B849A9DC257EF38185AFB935434C46", hash_generated_method = "F95037957A3376E9DFB6CECA49D01614")
    
public final float getToolMajor(int pointerIndex) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, HISTORY_CURRENT);
    }
    
    /**
     * Returns the length of the minor axis of an ellipse that describes the size of
     * the approaching tool for the given pointer
     * <em>index</em> (use {@link #getPointerId(int)} to find the pointer
     * identifier for this index).
     * The tool area represents the estimated size of the finger or pen that is
     * touching the device independent of its actual touch area at the point of contact.
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     *
     * @see #AXIS_TOOL_MINOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.872 -0500", hash_original_method = "F39564D767A71A1EAACBC920B100E436", hash_generated_method = "E5F85E9290E57191951525C54417B524")
    
public final float getToolMinor(int pointerIndex) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, HISTORY_CURRENT);
    }
    
    /**
     * Returns the orientation of the touch area and tool area in radians clockwise from vertical
     * for the given pointer <em>index</em> (use {@link #getPointerId(int)} to find the pointer
     * identifier for this index).
     * An angle of 0 radians indicates that the major axis of contact is oriented
     * upwards, is perfectly circular or is of unknown orientation.  A positive angle
     * indicates that the major axis of contact is oriented to the right.  A negative angle
     * indicates that the major axis of contact is oriented to the left.
     * The full range is from -PI/2 radians (finger pointing fully left) to PI/2 radians
     * (finger pointing fully right).
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     *
     * @see #AXIS_ORIENTATION
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.874 -0500", hash_original_method = "A9038F286A5A1470BB26B4145360A2CC", hash_generated_method = "9BF3D41FE79DAC91CCF823B7928B0869")
    
public final float getOrientation(int pointerIndex) {
        return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, HISTORY_CURRENT);
    }

    /**
     * Returns the value of the requested axis for the given pointer <em>index</em>
     * (use {@link #getPointerId(int)} to find the pointer identifier for this index).
     *
     * @param axis The axis identifier for the axis value to retrieve.
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @return The value of the axis, or 0 if the axis is not available.
     *
     * @see #AXIS_X
     * @see #AXIS_Y
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.877 -0500", hash_original_method = "3434CDF166CDB98F83BC4BA0F4722E7E", hash_generated_method = "E23B47FAC3D22052576FF15C6803046E")
    
public final float getAxisValue(int axis, int pointerIndex) {
        return nativeGetAxisValue(mNativePtr, axis, pointerIndex, HISTORY_CURRENT);
    }

    /**
     * Populates a {@link PointerCoords} object with pointer coordinate data for
     * the specified pointer index.
     * 
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param outPointerCoords The pointer coordinate object to populate.
     *
     * @see PointerCoords
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.879 -0500", hash_original_method = "33DE471947CC053A5003BB5AAC41F910", hash_generated_method = "B7C2FB3881C6E8FA2621F8335C83221E")
    
public final void getPointerCoords(int pointerIndex, PointerCoords outPointerCoords) {
        nativeGetPointerCoords(mNativePtr, pointerIndex, HISTORY_CURRENT, outPointerCoords);
    }

    /**
     * Populates a {@link PointerProperties} object with pointer properties for
     * the specified pointer index.
     *
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param outPointerProperties The pointer properties object to populate.
     *
     * @see PointerProperties
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.882 -0500", hash_original_method = "FC8907B12AF62543F5FA0564EA522E62", hash_generated_method = "B56744856A77BCDC6C923E6CA55D1887")
    
public final void getPointerProperties(int pointerIndex,
            PointerProperties outPointerProperties) {
        nativeGetPointerProperties(mNativePtr, pointerIndex, outPointerProperties);
    }

    /**
     * Returns the state of any meta / modifier keys that were in effect when
     * the event was generated.  This is the same values as those
     * returned by {@link KeyEvent#getMetaState() KeyEvent.getMetaState}.
     *
     * @return an integer in which each bit set to 1 represents a pressed
     *         meta key
     *
     * @see KeyEvent#getMetaState()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.884 -0500", hash_original_method = "38A68962B5CFD92D43EE16A436EABCF2", hash_generated_method = "BA821D623441C0FC4B843BFB023046EF")
    
public final int getMetaState() {
        return nativeGetMetaState(mNativePtr);
    }

    /**
     * Gets the state of all buttons that are pressed such as a mouse or stylus button.
     *
     * @return The button state.
     *
     * @see #BUTTON_PRIMARY
     * @see #BUTTON_SECONDARY
     * @see #BUTTON_TERTIARY
     * @see #BUTTON_FORWARD
     * @see #BUTTON_BACK
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.886 -0500", hash_original_method = "C8458CE15D5B2817F47A4FD377CE1968", hash_generated_method = "1B458AB47B3A019583FCC3093E276097")
    
public final int getButtonState() {
        return nativeGetButtonState(mNativePtr);
    }

    /**
     * Returns the original raw X coordinate of this event.  For touch
     * events on the screen, this is the original location of the event
     * on the screen, before it had been adjusted for the containing window
     * and views.
     *
     * @see getX()
     * @see #AXIS_X
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.888 -0500", hash_original_method = "6E457CC599C66DF6B9AC57A3DF3B8E7E", hash_generated_method = "597CB69258293954DEE2444596EE378C")
    
public final float getRawX() {
        return nativeGetRawAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT);
    }

    /**
     * Returns the original raw Y coordinate of this event.  For touch
     * events on the screen, this is the original location of the event
     * on the screen, before it had been adjusted for the containing window
     * and views.
     *
     * @see getY()
     * @see #AXIS_Y
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.891 -0500", hash_original_method = "C18C1837908CE668DE325D32328DA600", hash_generated_method = "8E785BFC8053CFC68155ADB53AB44608")
    
public final float getRawY() {
        return nativeGetRawAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT);
    }

    /**
     * Return the precision of the X coordinates being reported.  You can
     * multiply this number with {@link #getX} to find the actual hardware
     * value of the X coordinate.
     * @return Returns the precision of X coordinates being reported.
     *
     * @see #AXIS_X
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.893 -0500", hash_original_method = "32503B0D7203271814D12FFB8906664F", hash_generated_method = "14EDB92E48A1FE2A6848192BF9462171")
    
public final float getXPrecision() {
        return nativeGetXPrecision(mNativePtr);
    }

    /**
     * Return the precision of the Y coordinates being reported.  You can
     * multiply this number with {@link #getY} to find the actual hardware
     * value of the Y coordinate.
     * @return Returns the precision of Y coordinates being reported.
     *
     * @see #AXIS_Y
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.897 -0500", hash_original_method = "77B44C5CFF493101D20AF55AA249AFB4", hash_generated_method = "2C1783A2FC429C6490226761633705BE")
    
public final float getYPrecision() {
        return nativeGetYPrecision(mNativePtr);
    }

    /**
     * Returns the number of historical points in this event.  These are
     * movements that have occurred between this event and the previous event.
     * This only applies to ACTION_MOVE events -- all other actions will have
     * a size of 0.
     *
     * @return Returns the number of historical points in the event.
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.899 -0500", hash_original_method = "B4D273F4D2084C890DE19B631E3ED869", hash_generated_method = "7FDD08FA1737D3C8FF76FE80EEAFAB72")
    
public final int getHistorySize() {
        return nativeGetHistorySize(mNativePtr);
    }

    /**
     * Returns the time that a historical movement occurred between this event
     * and the previous event.  Only applies to ACTION_MOVE events.
     *
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getEventTime
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.902 -0500", hash_original_method = "4F37DFE9294EB232F86D1F83C2ADDC74", hash_generated_method = "A851AF9B1BB802307F420B87ED8B7DBC")
    
public final long getHistoricalEventTime(int pos) {
        return nativeGetEventTimeNanos(mNativePtr, pos) / NS_PER_MS;
    }

    /**
     * {@link #getHistoricalX(int, int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getX()
     * @see #AXIS_X
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.904 -0500", hash_original_method = "52641DCD8C1505610834B8CDD1492B06", hash_generated_method = "19AAD43E5A94488E256744F678A25D41")
    
public final float getHistoricalX(int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_X, 0, pos);
    }

    /**
     * {@link #getHistoricalY(int, int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getY()
     * @see #AXIS_Y
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.906 -0500", hash_original_method = "456D8725235AB4DBC45E47B4ADD23013", hash_generated_method = "D1C5BB213D8A282F9C2588371E83EE1E")
    
public final float getHistoricalY(int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_Y, 0, pos);
    }

    /**
     * {@link #getHistoricalPressure(int, int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getPressure()
     * @see #AXIS_PRESSURE
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.909 -0500", hash_original_method = "E822398D8AD69E2A637D6F0BC07F61D8", hash_generated_method = "D51D0A816F48D35B65CD1BA1D510DAAF")
    
public final float getHistoricalPressure(int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, pos);
    }

    /**
     * {@link #getHistoricalSize(int, int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getSize()
     * @see #AXIS_SIZE
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.911 -0500", hash_original_method = "A43A8374A73078EDB84358D609B2C354", hash_generated_method = "5415F12F402061F5522BCA4D6AC33764")
    
public final float getHistoricalSize(int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, pos);
    }

    /**
     * {@link #getHistoricalTouchMajor(int, int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getTouchMajor()
     * @see #AXIS_TOUCH_MAJOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.914 -0500", hash_original_method = "192AC6C55C0D7020BB0EA3AE5DE4FD65", hash_generated_method = "853B3A38656CEF199E13D7E6BCD1182A")
    
public final float getHistoricalTouchMajor(int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, pos);
    }

    /**
     * {@link #getHistoricalTouchMinor(int, int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getTouchMinor()
     * @see #AXIS_TOUCH_MINOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.916 -0500", hash_original_method = "122C0ECAA119AC26B3F087E871FFA312", hash_generated_method = "D3CCDC95B1B9DAA4FDF306D58254673B")
    
public final float getHistoricalTouchMinor(int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, pos);
    }
    
    /**
     * {@link #getHistoricalToolMajor(int, int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getToolMajor()
     * @see #AXIS_TOOL_MAJOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.919 -0500", hash_original_method = "8097CEA35B3273816C6109CC76A9BC74", hash_generated_method = "6D9E65A18430A11AD52F88DB056755CC")
    
public final float getHistoricalToolMajor(int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, pos);
    }

    /**
     * {@link #getHistoricalToolMinor(int, int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getToolMinor()
     * @see #AXIS_TOOL_MINOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.921 -0500", hash_original_method = "E0365AAE3D6BF704A796F5D4E7964FB9", hash_generated_method = "587D5AADFF69DF8E262EF1405C88E0C9")
    
public final float getHistoricalToolMinor(int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, pos);
    }
    
    /**
     * {@link #getHistoricalOrientation(int, int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getOrientation()
     * @see #AXIS_ORIENTATION
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.923 -0500", hash_original_method = "DC8FCE9CD404D08D0BFF0CC77CEE87C1", hash_generated_method = "DF7B472583F560FEA6FD9ED7C0853162")
    
public final float getHistoricalOrientation(int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, pos);
    }

    /**
     * {@link #getHistoricalAxisValue(int, int, int)} for the first pointer index (may be an
     * arbitrary pointer identifier).
     *
     * @param axis The axis identifier for the axis value to retrieve.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getAxisValue(int)
     * @see #AXIS_X
     * @see #AXIS_Y
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.926 -0500", hash_original_method = "697532A0192D8868F2E3AE618301BF20", hash_generated_method = "B22E498FF9732924826164858518B846")
    
public final float getHistoricalAxisValue(int axis, int pos) {
        return nativeGetAxisValue(mNativePtr, axis, 0, pos);
    }

    /**
     * Returns a historical X coordinate, as per {@link #getX(int)}, that
     * occurred between this event and the previous event for the given pointer.
     * Only applies to ACTION_MOVE events.
     *
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getX(int)
     * @see #AXIS_X
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.928 -0500", hash_original_method = "8BFA09569623FF1F941D2134C3D47F02", hash_generated_method = "BCA1A9401C71FD53E79AA19C35D77354")
    
public final float getHistoricalX(int pointerIndex, int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, pos);
    }

    /**
     * Returns a historical Y coordinate, as per {@link #getY(int)}, that
     * occurred between this event and the previous event for the given pointer.
     * Only applies to ACTION_MOVE events.
     *
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     *
     * @see #getHistorySize
     * @see #getY(int)
     * @see #AXIS_Y
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.930 -0500", hash_original_method = "9787FE8A43AC5153EC8D7EC463FC985B", hash_generated_method = "93E1612CB6D311B03E5FD0703ACC49DD")
    
public final float getHistoricalY(int pointerIndex, int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, pos);
    }

    /**
     * Returns a historical pressure coordinate, as per {@link #getPressure(int)},
     * that occurred between this event and the previous event for the given
     * pointer.  Only applies to ACTION_MOVE events.
     *
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     * 
     * @see #getHistorySize
     * @see #getPressure(int)
     * @see #AXIS_PRESSURE
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.933 -0500", hash_original_method = "A8F703E0BCBA29F53C62C25AACD436ED", hash_generated_method = "252C97CE72516A9BCA7EE5DABB7C62A2")
    
public final float getHistoricalPressure(int pointerIndex, int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, pos);
    }
    static {
        SparseArray<String> names = AXIS_SYMBOLIC_NAMES;
        names.append(AXIS_X, "AXIS_X");
        names.append(AXIS_Y, "AXIS_Y");
        names.append(AXIS_PRESSURE, "AXIS_PRESSURE");
        names.append(AXIS_SIZE, "AXIS_SIZE");
        names.append(AXIS_TOUCH_MAJOR, "AXIS_TOUCH_MAJOR");
        names.append(AXIS_TOUCH_MINOR, "AXIS_TOUCH_MINOR");
        names.append(AXIS_TOOL_MAJOR, "AXIS_TOOL_MAJOR");
        names.append(AXIS_TOOL_MINOR, "AXIS_TOOL_MINOR");
        names.append(AXIS_ORIENTATION, "AXIS_ORIENTATION");
        names.append(AXIS_VSCROLL, "AXIS_VSCROLL");
        names.append(AXIS_HSCROLL, "AXIS_HSCROLL");
        names.append(AXIS_Z, "AXIS_Z");
        names.append(AXIS_RX, "AXIS_RX");
        names.append(AXIS_RY, "AXIS_RY");
        names.append(AXIS_RZ, "AXIS_RZ");
        names.append(AXIS_HAT_X, "AXIS_HAT_X");
        names.append(AXIS_HAT_Y, "AXIS_HAT_Y");
        names.append(AXIS_LTRIGGER, "AXIS_LTRIGGER");
        names.append(AXIS_RTRIGGER, "AXIS_RTRIGGER");
        names.append(AXIS_THROTTLE, "AXIS_THROTTLE");
        names.append(AXIS_RUDDER, "AXIS_RUDDER");
        names.append(AXIS_WHEEL, "AXIS_WHEEL");
        names.append(AXIS_GAS, "AXIS_GAS");
        names.append(AXIS_BRAKE, "AXIS_BRAKE");
        names.append(AXIS_DISTANCE, "AXIS_DISTANCE");
        names.append(AXIS_TILT, "AXIS_TILT");
        names.append(AXIS_GENERIC_1, "AXIS_GENERIC_1");
        names.append(AXIS_GENERIC_2, "AXIS_GENERIC_2");
        names.append(AXIS_GENERIC_3, "AXIS_GENERIC_3");
        names.append(AXIS_GENERIC_4, "AXIS_GENERIC_4");
        names.append(AXIS_GENERIC_5, "AXIS_GENERIC_5");
        names.append(AXIS_GENERIC_6, "AXIS_GENERIC_6");
        names.append(AXIS_GENERIC_7, "AXIS_GENERIC_7");
        names.append(AXIS_GENERIC_8, "AXIS_GENERIC_8");
        names.append(AXIS_GENERIC_9, "AXIS_GENERIC_9");
        names.append(AXIS_GENERIC_10, "AXIS_GENERIC_10");
        names.append(AXIS_GENERIC_11, "AXIS_GENERIC_11");
        names.append(AXIS_GENERIC_12, "AXIS_GENERIC_12");
        names.append(AXIS_GENERIC_13, "AXIS_GENERIC_13");
        names.append(AXIS_GENERIC_14, "AXIS_GENERIC_14");
        names.append(AXIS_GENERIC_15, "AXIS_GENERIC_15");
        names.append(AXIS_GENERIC_16, "AXIS_GENERIC_16");
    }

    /**
     * Returns a historical size coordinate, as per {@link #getSize(int)}, that
     * occurred between this event and the previous event for the given pointer.
     * Only applies to ACTION_MOVE events.
     *
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     * 
     * @see #getHistorySize
     * @see #getSize(int)
     * @see #AXIS_SIZE
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.935 -0500", hash_original_method = "66A9DA10859CF6933D658F61BE53F70F", hash_generated_method = "7BE64C47B3D0E881DBD3A3FFD89B1986")
    
public final float getHistoricalSize(int pointerIndex, int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, pos);
    }
    
    /**
     * Returns a historical touch major axis coordinate, as per {@link #getTouchMajor(int)}, that
     * occurred between this event and the previous event for the given pointer.
     * Only applies to ACTION_MOVE events.
     *
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     * 
     * @see #getHistorySize
     * @see #getTouchMajor(int)
     * @see #AXIS_TOUCH_MAJOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.937 -0500", hash_original_method = "38D72D2E0F00AE5C39667CDDD41B271D", hash_generated_method = "E421D1DB97E5D29D03E0A0D4836E4B04")
    
public final float getHistoricalTouchMajor(int pointerIndex, int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, pos);
    }

    /**
     * Returns a historical touch minor axis coordinate, as per {@link #getTouchMinor(int)}, that
     * occurred between this event and the previous event for the given pointer.
     * Only applies to ACTION_MOVE events.
     *
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     * 
     * @see #getHistorySize
     * @see #getTouchMinor(int)
     * @see #AXIS_TOUCH_MINOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.941 -0500", hash_original_method = "F3D94A1F01A3ECEF6DEDEA9361640BF9", hash_generated_method = "795E7B6E16D3523E5612604E3F6C8F43")
    
public final float getHistoricalTouchMinor(int pointerIndex, int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, pos);
    }

    /**
     * Returns a historical tool major axis coordinate, as per {@link #getToolMajor(int)}, that
     * occurred between this event and the previous event for the given pointer.
     * Only applies to ACTION_MOVE events.
     *
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     * 
     * @see #getHistorySize
     * @see #getToolMajor(int)
     * @see #AXIS_TOOL_MAJOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.943 -0500", hash_original_method = "78FB77773CB43A5420D0F24849B540AD", hash_generated_method = "81999468B6025EB7D723C2F852E97B52")
    
public final float getHistoricalToolMajor(int pointerIndex, int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, pos);
    }

    /**
     * Returns a historical tool minor axis coordinate, as per {@link #getToolMinor(int)}, that
     * occurred between this event and the previous event for the given pointer.
     * Only applies to ACTION_MOVE events.
     *
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     * 
     * @see #getHistorySize
     * @see #getToolMinor(int)
     * @see #AXIS_TOOL_MINOR
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.946 -0500", hash_original_method = "4AB7745853006A3796DAD0E637CCA598", hash_generated_method = "F81E9736A5EC52512FB5ED93CA8E48AC")
    
public final float getHistoricalToolMinor(int pointerIndex, int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, pos);
    }

    /**
     * Returns a historical orientation coordinate, as per {@link #getOrientation(int)}, that
     * occurred between this event and the previous event for the given pointer.
     * Only applies to ACTION_MOVE events.
     *
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     * 
     * @see #getHistorySize
     * @see #getOrientation(int)
     * @see #AXIS_ORIENTATION
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.948 -0500", hash_original_method = "160C0106DB8A4C6FBAA9569ABA0D68E8", hash_generated_method = "8452C59FE1D08A00B23AC6FAFA75C375")
    
public final float getHistoricalOrientation(int pointerIndex, int pos) {
        return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, pos);
    }

    /**
     * Returns the historical value of the requested axis, as per {@link #getAxisValue(int, int)},
     * occurred between this event and the previous event for the given pointer.
     * Only applies to ACTION_MOVE events.
     *
     * @param axis The axis identifier for the axis value to retrieve.
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     * @return The value of the axis, or 0 if the axis is not available.
     *
     * @see #AXIS_X
     * @see #AXIS_Y
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.951 -0500", hash_original_method = "F645AABE3B2CF14D2790BA051F9F3FF1", hash_generated_method = "951370EAFA3AD7108D5C55E23D9CF0A7")
    
public final float getHistoricalAxisValue(int axis, int pointerIndex, int pos) {
        return nativeGetAxisValue(mNativePtr, axis, pointerIndex, pos);
    }

    /**
     * Populates a {@link PointerCoords} object with historical pointer coordinate data,
     * as per {@link #getPointerCoords}, that occurred between this event and the previous
     * event for the given pointer.
     * Only applies to ACTION_MOVE events.
     * 
     * @param pointerIndex Raw index of pointer to retrieve.  Value may be from 0
     * (the first pointer that is down) to {@link #getPointerCount()}-1.
     * @param pos Which historical value to return; must be less than
     * {@link #getHistorySize}
     * @param outPointerCoords The pointer coordinate object to populate.
     * 
     * @see #getHistorySize
     * @see #getPointerCoords
     * @see PointerCoords
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.953 -0500", hash_original_method = "D80ADCD256759644414D5CBEC3C57D0B", hash_generated_method = "CD0AB40718AAFE85D044EE7CA0775CF1")
    
public final void getHistoricalPointerCoords(int pointerIndex, int pos,
            PointerCoords outPointerCoords) {
        nativeGetPointerCoords(mNativePtr, pointerIndex, pos, outPointerCoords);
    }
    
    /**
     * Returns a bitfield indicating which edges, if any, were touched by this
     * MotionEvent. For touch events, clients can use this to determine if the
     * user's finger was touching the edge of the display.
     *
     * This property is only set for {@link #ACTION_DOWN} events.
     *
     * @see #EDGE_LEFT
     * @see #EDGE_TOP
     * @see #EDGE_RIGHT
     * @see #EDGE_BOTTOM
     */
    @DSComment("Event associated with motion")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.956 -0500", hash_original_method = "26EA400A9751805DFF1D4CEEB005645B", hash_generated_method = "07DFB8FE2306569E4B60247444B66A8A")
    
public final int getEdgeFlags() {
        return nativeGetEdgeFlags(mNativePtr);
    }

    /**
     * Sets the bitfield indicating which edges, if any, were touched by this
     * MotionEvent.
     *
     * @see #getEdgeFlags()
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.958 -0500", hash_original_method = "348B6A1C5666102E94291FA4791C249A", hash_generated_method = "4C920985B6852D8B05DFC1AE4199ADC7")
    
public final void setEdgeFlags(int flags) {
        nativeSetEdgeFlags(mNativePtr, flags);
    }

    /**
     * Sets this event's action.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.960 -0500", hash_original_method = "34CE363FC32882BC3BBCF2E8ABF2B5B0", hash_generated_method = "E5501ABDBC35788D58647DEA4B566E2A")
    
public final void setAction(int action) {
        nativeSetAction(mNativePtr, action);
    }

    /**
     * Adjust this event's location.
     * @param deltaX Amount to add to the current X coordinate of the event.
     * @param deltaY Amount to add to the current Y coordinate of the event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.963 -0500", hash_original_method = "117CE161431F2ECDED077AD7F7467ADD", hash_generated_method = "0A6C79D503436DFDA287DA5C46762097")
    
public final void offsetLocation(float deltaX, float deltaY) {
        nativeOffsetLocation(mNativePtr, deltaX, deltaY);
    }
    static {
        SparseArray<String> names = TOOL_TYPE_SYMBOLIC_NAMES;
        names.append(TOOL_TYPE_UNKNOWN, "TOOL_TYPE_UNKNOWN");
        names.append(TOOL_TYPE_FINGER, "TOOL_TYPE_FINGER");
        names.append(TOOL_TYPE_STYLUS, "TOOL_TYPE_STYLUS");
        names.append(TOOL_TYPE_MOUSE, "TOOL_TYPE_MOUSE");
        names.append(TOOL_TYPE_ERASER, "TOOL_TYPE_ERASER");
    }

    /**
     * Set this event's location.  Applies {@link #offsetLocation} with a
     * delta from the current location to the given new location.
     *
     * @param x New absolute X location.
     * @param y New absolute Y location.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.965 -0500", hash_original_method = "D9D9F7662138ADF2F9591F7DFAEB3F74", hash_generated_method = "BE9399C2E35FFF89AD55B3C33C31552D")
    
public final void setLocation(float x, float y) {
        float oldX = getX();
        float oldY = getY();
        nativeOffsetLocation(mNativePtr, x - oldX, y - oldY);
    }
    
    /**
     * Applies a transformation matrix to all of the points in the event.
     *
     * @param matrix The transformation matrix to apply.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.968 -0500", hash_original_method = "622D19544C973DA41E1BE7D7819B5A41", hash_generated_method = "A2F2AD20F127C56B568674E19E7767FA")
    
public final void transform(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("matrix must not be null");
        }

        nativeTransform(mNativePtr, matrix);
    }

    /**
     * Add a new movement to the batch of movements in this event.  The event's
     * current location, position and size is updated to the new values.
     * The current values in the event are added to a list of historical values.
     *
     * Only applies to {@link #ACTION_MOVE} or {@link #ACTION_HOVER_MOVE} events.
     *
     * @param eventTime The time stamp (in ms) for this data.
     * @param x The new X position.
     * @param y The new Y position.
     * @param pressure The new pressure.
     * @param size The new size.
     * @param metaState Meta key state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.971 -0500", hash_original_method = "F001981BC7F115C74B7EB0136965714D", hash_generated_method = "DA4F47941648F3F02D84A6F758A16C3E")
    
public final void addBatch(long eventTime, float x, float y,
            float pressure, float size, int metaState) {
        synchronized (gSharedTempLock) {
            ensureSharedTempPointerCapacity(1);
            final PointerCoords[] pc = gSharedTempPointerCoords;
            pc[0].clear();
            pc[0].x = x;
            pc[0].y = y;
            pc[0].pressure = pressure;
            pc[0].size = size;

            nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pc, metaState);
        }
    }

    /**
     * Add a new movement to the batch of movements in this event.  The event's
     * current location, position and size is updated to the new values.
     * The current values in the event are added to a list of historical values.
     *
     * Only applies to {@link #ACTION_MOVE} or {@link #ACTION_HOVER_MOVE} events.
     *
     * @param eventTime The time stamp (in ms) for this data.
     * @param pointerCoords The new pointer coordinates.
     * @param metaState Meta key state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.973 -0500", hash_original_method = "06E22018450E3E0892CD70DE9E19F211", hash_generated_method = "609082ED5377B41317B620B33618A9CE")
    
public final void addBatch(long eventTime, PointerCoords[] pointerCoords, int metaState) {
        nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pointerCoords, metaState);
    }

    /**
     * Returns true if all points in the motion event are completely within the specified bounds.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.975 -0500", hash_original_method = "542474DD15BDDADB068A65C6A3EEA8E2", hash_generated_method = "5382BEC9FC26C12CD9CFD624B7778E49")
    
public final boolean isWithinBoundsNoHistory(float left, float top,
            float right, float bottom) {
        final int pointerCount = nativeGetPointerCount(mNativePtr);
        for (int i = 0; i < pointerCount; i++) {
            final float x = nativeGetAxisValue(mNativePtr, AXIS_X, i, HISTORY_CURRENT);
            final float y = nativeGetAxisValue(mNativePtr, AXIS_Y, i, HISTORY_CURRENT);
            if (x < left || x > right || y < top || y > bottom) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a new motion events whose points have been clamped to the specified bounds.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.981 -0500", hash_original_method = "C00E6E79D43678980DA0F4144A65F6A2", hash_generated_method = "9E85982622E02ECD889AA29EF2CC0457")
    
public final MotionEvent clampNoHistory(float left, float top, float right, float bottom) {
        MotionEvent ev = obtain();
        synchronized (gSharedTempLock) {
            final int pointerCount = nativeGetPointerCount(mNativePtr);

            ensureSharedTempPointerCapacity(pointerCount);
            final PointerProperties[] pp = gSharedTempPointerProperties;
            final PointerCoords[] pc = gSharedTempPointerCoords;

            for (int i = 0; i < pointerCount; i++) {
                nativeGetPointerProperties(mNativePtr, i, pp[i]);
                nativeGetPointerCoords(mNativePtr, i, HISTORY_CURRENT, pc[i]);
                pc[i].x = clamp(pc[i].x, left, right);
                pc[i].y = clamp(pc[i].y, top, bottom);
            }
            ev.mNativePtr = nativeInitialize(ev.mNativePtr,
                    nativeGetDeviceId(mNativePtr), nativeGetSource(mNativePtr),
                    nativeGetAction(mNativePtr), nativeGetFlags(mNativePtr),
                    nativeGetEdgeFlags(mNativePtr), nativeGetMetaState(mNativePtr),
                    nativeGetButtonState(mNativePtr),
                    nativeGetXOffset(mNativePtr), nativeGetYOffset(mNativePtr),
                    nativeGetXPrecision(mNativePtr), nativeGetYPrecision(mNativePtr),
                    nativeGetDownTimeNanos(mNativePtr),
                    nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT),
                    pointerCount, pp, pc);
            return ev;
        }
    }

    /**
     * Gets an integer where each pointer id present in the event is marked as a bit.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.983 -0500", hash_original_method = "FBF170B15B2FFBEE1AB1D4E32A8773CA", hash_generated_method = "93AA0F25D200E62716740C67CCFEC35F")
    
public final int getPointerIdBits() {
        int idBits = 0;
        final int pointerCount = nativeGetPointerCount(mNativePtr);
        for (int i = 0; i < pointerCount; i++) {
            idBits |= 1 << nativeGetPointerId(mNativePtr, i);
        }
        return idBits;
    }

    /**
     * Splits a motion event such that it includes only a subset of pointer ids.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.989 -0500", hash_original_method = "4F0FF8B26009CA9D26EE500AEFE507EC", hash_generated_method = "B50BC50C1E5B53A05883DBE2DB4550DB")
    
public final MotionEvent split(int idBits) {
        MotionEvent ev = obtain();
        synchronized (gSharedTempLock) {
            final int oldPointerCount = nativeGetPointerCount(mNativePtr);
            ensureSharedTempPointerCapacity(oldPointerCount);
            final PointerProperties[] pp = gSharedTempPointerProperties;
            final PointerCoords[] pc = gSharedTempPointerCoords;
            final int[] map = gSharedTempPointerIndexMap;

            final int oldAction = nativeGetAction(mNativePtr);
            final int oldActionMasked = oldAction & ACTION_MASK;
            final int oldActionPointerIndex = (oldAction & ACTION_POINTER_INDEX_MASK)
                    >> ACTION_POINTER_INDEX_SHIFT;
            int newActionPointerIndex = -1;
            int newPointerCount = 0;
            int newIdBits = 0;
            for (int i = 0; i < oldPointerCount; i++) {
                nativeGetPointerProperties(mNativePtr, i, pp[newPointerCount]);
                final int idBit = 1 << pp[newPointerCount].id;
                if ((idBit & idBits) != 0) {
                    if (i == oldActionPointerIndex) {
                        newActionPointerIndex = newPointerCount;
                    }
                    map[newPointerCount] = i;
                    newPointerCount += 1;
                    newIdBits |= idBit;
                }
            }

            if (newPointerCount == 0) {
                throw new IllegalArgumentException("idBits did not match any ids in the event");
            }

            final int newAction;
            if (oldActionMasked == ACTION_POINTER_DOWN || oldActionMasked == ACTION_POINTER_UP) {
                if (newActionPointerIndex < 0) {
                    // An unrelated pointer changed.
                    newAction = ACTION_MOVE;
                } else if (newPointerCount == 1) {
                    // The first/last pointer went down/up.
                    newAction = oldActionMasked == ACTION_POINTER_DOWN
                            ? ACTION_DOWN : ACTION_UP;
                } else {
                    // A secondary pointer went down/up.
                    newAction = oldActionMasked
                            | (newActionPointerIndex << ACTION_POINTER_INDEX_SHIFT);
                }
            } else {
                // Simple up/down/cancel/move or other motion action.
                newAction = oldAction;
            }

            final int historySize = nativeGetHistorySize(mNativePtr);
            for (int h = 0; h <= historySize; h++) {
                final int historyPos = h == historySize ? HISTORY_CURRENT : h;

                for (int i = 0; i < newPointerCount; i++) {
                    nativeGetPointerCoords(mNativePtr, map[i], historyPos, pc[i]);
                }

                final long eventTimeNanos = nativeGetEventTimeNanos(mNativePtr, historyPos);
                if (h == 0) {
                    ev.mNativePtr = nativeInitialize(ev.mNativePtr,
                            nativeGetDeviceId(mNativePtr), nativeGetSource(mNativePtr),
                            newAction, nativeGetFlags(mNativePtr),
                            nativeGetEdgeFlags(mNativePtr), nativeGetMetaState(mNativePtr),
                            nativeGetButtonState(mNativePtr),
                            nativeGetXOffset(mNativePtr), nativeGetYOffset(mNativePtr),
                            nativeGetXPrecision(mNativePtr), nativeGetYPrecision(mNativePtr),
                            nativeGetDownTimeNanos(mNativePtr), eventTimeNanos,
                            newPointerCount, pp, pc);
                } else {
                    nativeAddBatch(ev.mNativePtr, eventTimeNanos, pc, 0);
                }
            }
            return ev;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:10.992 -0500", hash_original_method = "69A985781D7A79E036178DEB42E5F1F0", hash_generated_method = "3DA9E049C6F4EDFA08CED09C15031406")
    
@Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("MotionEvent { action=").append(actionToString(getAction()));

        final int pointerCount = getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            msg.append(", id[").append(i).append("]=").append(getPointerId(i));
            msg.append(", x[").append(i).append("]=").append(getX(i));
            msg.append(", y[").append(i).append("]=").append(getY(i));
            msg.append(", toolType[").append(i).append("]=").append(
                    toolTypeToString(getToolType(i)));
        }

        msg.append(", buttonState=").append(MotionEvent.buttonStateToString(getButtonState()));
        msg.append(", metaState=").append(KeyEvent.metaStateToString(getMetaState()));
        msg.append(", flags=0x").append(Integer.toHexString(getFlags()));
        msg.append(", edgeFlags=0x").append(Integer.toHexString(getEdgeFlags()));
        msg.append(", pointerCount=").append(pointerCount);
        msg.append(", historySize=").append(getHistorySize());
        msg.append(", eventTime=").append(getEventTime());
        msg.append(", downTime=").append(getDownTime());
        msg.append(", deviceId=").append(getDeviceId());
        msg.append(", source=0x").append(Integer.toHexString(getSource()));
        msg.append(" }");
        return msg.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:11.019 -0500", hash_original_method = "D732CA58C71ED959C0E1A12C336FC80D", hash_generated_method = "F38E9D4F29DF308154AD36641DD20AED")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeInt(PARCEL_TOKEN_MOTION_EVENT);
        nativeWriteToParcel(mNativePtr, out);
    }
    // orphaned legacy method
    public MotionEvent[] newArray(int size) {
            return new MotionEvent[size];
        }
    
    // orphaned legacy method
    public MotionEvent createFromParcel(Parcel in) {
            in.readInt(); 
            return MotionEvent.createFromParcelBody(in);
        }
    
}

