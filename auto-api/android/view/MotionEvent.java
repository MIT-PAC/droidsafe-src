package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseArray;

public final class MotionEvent extends InputEvent implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.413 -0400", hash_original_field = "AE1F3581ADE8C1B0F98DFDE5A4F536A3", hash_generated_field = "23CD98EE9F206841B49D023F257D02A5")

    private int mNativePtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.413 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "4ED1BADBA3F9AC6D1D2BD2B16B6BF967")

    private MotionEvent mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.413 -0400", hash_original_field = "285FE8BBC1049056117639C63D1605B9", hash_generated_field = "4E4D5EFD76E218484C8A2F86B097FF08")

    private RuntimeException mRecycledLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.413 -0400", hash_original_field = "1212A62D731F217836716E35FA12386C", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.414 -0400", hash_original_method = "B1B69F583261D8BEEC921FF43580AA66", hash_generated_method = "40B8D4E791D456515D6D7EBB1643CE79")
    private  MotionEvent() {
        // ---------- Original Method ----------
    }

    
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
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeCopy(int destNativePtr, int sourceNativePtr,
            boolean keepHistory) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeDispose(int nativePtr) {
    }

    
        private static void nativeAddBatch(int nativePtr, long eventTimeNanos,
            PointerCoords[] pointerCoords, int metaState) {
    }

    
        private static int nativeGetDeviceId(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeGetSource(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeSetSource(int nativePtr, int source) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeGetAction(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeSetAction(int nativePtr, int action) {
    }

    
        private static boolean nativeIsTouchEvent(int nativePtr) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static int nativeGetFlags(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeSetFlags(int nativePtr, int flags) {
    }

    
        private static int nativeGetEdgeFlags(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeSetEdgeFlags(int nativePtr, int action) {
    }

    
        private static int nativeGetMetaState(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeGetButtonState(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeOffsetLocation(int nativePtr, float deltaX, float deltaY) {
    }

    
        private static float nativeGetXOffset(int nativePtr) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        private static float nativeGetYOffset(int nativePtr) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        private static float nativeGetXPrecision(int nativePtr) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        private static float nativeGetYPrecision(int nativePtr) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        private static long nativeGetDownTimeNanos(int nativePtr) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        private static void nativeSetDownTimeNanos(int nativePtr, long downTime) {
    }

    
        private static int nativeGetPointerCount(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeGetPointerId(int nativePtr, int pointerIndex) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeGetToolType(int nativePtr, int pointerIndex) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeFindPointerIndex(int nativePtr, int pointerId) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeGetHistorySize(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static long nativeGetEventTimeNanos(int nativePtr, int historyPos) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        private static float nativeGetRawAxisValue(int nativePtr,
            int axis, int pointerIndex, int historyPos) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        private static float nativeGetAxisValue(int nativePtr,
            int axis, int pointerIndex, int historyPos) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
        private static void nativeGetPointerCoords(int nativePtr,
            int pointerIndex, int historyPos, PointerCoords outPointerCoords) {
    }

    
        private static void nativeGetPointerProperties(int nativePtr,
            int pointerIndex, PointerProperties outPointerProperties) {
    }

    
        private static void nativeScale(int nativePtr, float scale) {
    }

    
        private static void nativeTransform(int nativePtr, Matrix matrix) {
    }

    
        private static int nativeReadFromParcel(int nativePtr, Parcel parcel) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeWriteToParcel(int nativePtr, Parcel parcel) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.462 -0400", hash_original_method = "3F0B5C050D986DD9F1F0F2A742C616C8", hash_generated_method = "B421B42F481E4C5401D1FD9631DD22BD")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                nativeDispose(mNativePtr);
                mNativePtr = 0;
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (mNativePtr != 0) {
                //nativeDispose(mNativePtr);
                //mNativePtr = 0;
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
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

    
        @Deprecated
    static public MotionEvent obtain(long downTime, long eventTime, int action,
            int pointerCount, float x, float y, float pressure, float size, int metaState,
            float xPrecision, float yPrecision, int deviceId, int edgeFlags) {
        return obtain(downTime, eventTime, action, x, y, pressure, size,
                metaState, xPrecision, yPrecision, deviceId, edgeFlags);
    }

    
        static public MotionEvent obtain(long downTime, long eventTime, int action,
            float x, float y, int metaState) {
        return obtain(downTime, eventTime, action, x, y, 1.0f, 1.0f,
                metaState, 1.0f, 1.0f, 0, 0);
    }

    
        static public MotionEvent obtain(MotionEvent other) {
        if (other == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        }
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeCopy(ev.mNativePtr, other.mNativePtr, true );
        return ev;
    }

    
        static public MotionEvent obtainNoHistory(MotionEvent other) {
        if (other == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        }
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeCopy(ev.mNativePtr, other.mNativePtr, false );
        return ev;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.480 -0400", hash_original_method = "78DE11FBBF58608981D1F74EEB443B54", hash_generated_method = "55C6DBE882DCD57EC23FD4EBE430158C")
    @Override
    public MotionEvent copy() {
        MotionEvent varB4EAC82CA7396A68D541C85D26508E83_1834162525 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1834162525 = obtain(this);
        varB4EAC82CA7396A68D541C85D26508E83_1834162525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1834162525;
        // ---------- Original Method ----------
        //return obtain(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.489 -0400", hash_original_method = "187F7D3A42078A42C8212C3EFE0E8B16", hash_generated_method = "19A0195F7D24E2E1074AAA3598A0B444")
    public final void recycle() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
            } //End block
            mRecycledLocation = new RuntimeException("Last recycled here");
        } //End block
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(toString() + " recycled twice!");
            } //End block
            mRecycled = true;
        } //End block
        {
            {
                mNext = gRecyclerTop;
                gRecyclerTop = this;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (TRACK_RECYCLED_LOCATION) {
            //if (mRecycledLocation != null) {
                //throw new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
            //}
            //mRecycledLocation = new RuntimeException("Last recycled here");
        //} else {
            //if (mRecycled) {
                //throw new RuntimeException(toString() + " recycled twice!");
            //}
            //mRecycled = true;
        //}
        //synchronized (gRecyclerLock) {
            //if (gRecyclerUsed < MAX_RECYCLED) {
                //gRecyclerUsed++;
                //mNext = gRecyclerTop;
                //gRecyclerTop = this;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.497 -0400", hash_original_method = "A082C8E505553F853E56AAFC11CF0CDA", hash_generated_method = "2B685E18605A48F51EF2A58C1BB8F3B5")
    public final void scale(float scale) {
        nativeScale(mNativePtr, scale);
        addTaint(scale);
        // ---------- Original Method ----------
        //nativeScale(mNativePtr, scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.507 -0400", hash_original_method = "E51EA2AB032E4C79CC226174E2601818", hash_generated_method = "937EBEABCC65D9C731841F467D04D2C8")
    @Override
    public final int getDeviceId() {
        int varF3B3D3917F994FE161C0ABB4D3E565B5_1863717508 = (nativeGetDeviceId(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784673683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784673683;
        // ---------- Original Method ----------
        //return nativeGetDeviceId(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.508 -0400", hash_original_method = "44501F684180CAB98F3511C2614C7994", hash_generated_method = "3EC4B2E604F21CEE3F583BECE2035BAF")
    @Override
    public final int getSource() {
        int var626B65A92B0E4AF71704C1098173596F_1328671519 = (nativeGetSource(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840162469 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840162469;
        // ---------- Original Method ----------
        //return nativeGetSource(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.508 -0400", hash_original_method = "1502AF3F26B6DD95879512031D9FB73E", hash_generated_method = "4F9E3DEBB9978F4944F95EF530F213F6")
    @Override
    public final void setSource(int source) {
        nativeSetSource(mNativePtr, source);
        addTaint(source);
        // ---------- Original Method ----------
        //nativeSetSource(mNativePtr, source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.509 -0400", hash_original_method = "FA5880EB8F61D955AC5922ACE620FCE2", hash_generated_method = "5ADF9530F9CDC0AC87432AC52C782429")
    public final int getAction() {
        int var74B8A914B86C4917D117B6A52D32C79D_874993654 = (nativeGetAction(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127903304 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127903304;
        // ---------- Original Method ----------
        //return nativeGetAction(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.509 -0400", hash_original_method = "268411790684740D49A019DF59E1FFBB", hash_generated_method = "15F679052680068D51C754FD2BC04239")
    public final int getActionMasked() {
        int var119771AD723EE5854F55019431496A74_1298632230 = (nativeGetAction(mNativePtr) & ACTION_MASK);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878188573 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878188573;
        // ---------- Original Method ----------
        //return nativeGetAction(mNativePtr) & ACTION_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.509 -0400", hash_original_method = "464EE1689B645958C6F5E17990D5ECA4", hash_generated_method = "D7E1D62B31B4128427B41C83DD228A1E")
    public final int getActionIndex() {
        int var853FB894ACCBEFFE5F8E24DD3377AFAF_362488496 = ((nativeGetAction(mNativePtr) & ACTION_POINTER_INDEX_MASK)
                >> ACTION_POINTER_INDEX_SHIFT);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742389063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742389063;
        // ---------- Original Method ----------
        //return (nativeGetAction(mNativePtr) & ACTION_POINTER_INDEX_MASK)
                //>> ACTION_POINTER_INDEX_SHIFT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.519 -0400", hash_original_method = "3A9CDEA51D903248E7ACBBA8C3F57155", hash_generated_method = "FD26DE23B316F9BD0E1B76EC9FDC49E2")
    public final boolean isTouchEvent() {
        boolean var12F7F7B53A02590E12DD99382B4D1A89_1726071028 = (nativeIsTouchEvent(mNativePtr));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_368122296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_368122296;
        // ---------- Original Method ----------
        //return nativeIsTouchEvent(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.520 -0400", hash_original_method = "A25E485C356A262F519C0A5841CFA47B", hash_generated_method = "8D1D004B64CA099AA6FBCE960279F255")
    public final int getFlags() {
        int var31A262589A0563B992AF6C13BB445DA6_64255259 = (nativeGetFlags(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497490621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497490621;
        // ---------- Original Method ----------
        //return nativeGetFlags(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.521 -0400", hash_original_method = "24A8A0C0077001C335E0B5C917301FE4", hash_generated_method = "3BDBD89AF83D2542B230CF23BB9EFE7B")
    @Override
    public final boolean isTainted() {
        int flags;
        flags = getFlags();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485848791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485848791;
        // ---------- Original Method ----------
        //final int flags = getFlags();
        //return (flags & FLAG_TAINTED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.534 -0400", hash_original_method = "96C1138F844BE852B50B0529E539E061", hash_generated_method = "874C10A27EA2AFC56103FB84F8B23D00")
    @Override
    public final void setTainted(boolean tainted) {
        int flags;
        flags = getFlags();
        nativeSetFlags(mNativePtr, tainted ? flags | FLAG_TAINTED : flags & ~FLAG_TAINTED);
        addTaint(tainted);
        // ---------- Original Method ----------
        //final int flags = getFlags();
        //nativeSetFlags(mNativePtr, tainted ? flags | FLAG_TAINTED : flags & ~FLAG_TAINTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.534 -0400", hash_original_method = "5F4C05CD4E223E38846D15A6EA0DF305", hash_generated_method = "A702EBEA5F95E6FAA696115B984872F9")
    public final long getDownTime() {
        long varA7AEBDC62AD9E48221ED001FAEE4896D_828762218 = (nativeGetDownTimeNanos(mNativePtr) / NS_PER_MS);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1951801536 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1951801536;
        // ---------- Original Method ----------
        //return nativeGetDownTimeNanos(mNativePtr) / NS_PER_MS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.535 -0400", hash_original_method = "97B3432DE604A4A8C3339017F5056697", hash_generated_method = "C82DB4CB82274A97586E19935264D40C")
    public final void setDownTime(long downTime) {
        nativeSetDownTimeNanos(mNativePtr, downTime * NS_PER_MS);
        addTaint(downTime);
        // ---------- Original Method ----------
        //nativeSetDownTimeNanos(mNativePtr, downTime * NS_PER_MS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.535 -0400", hash_original_method = "CCF6A1C7FFBA398090457272FB07E7C9", hash_generated_method = "40A092B59E44ED991F6D6A3978B17A70")
    public final long getEventTime() {
        long varABD7EED75F03AC822986337AA0AEBA8E_571381094 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT) / NS_PER_MS);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2063978858 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2063978858;
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT) / NS_PER_MS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.536 -0400", hash_original_method = "9EB1FC24DA069289850F91A3F8734D9A", hash_generated_method = "1064D649CB165482746CAA70E706D0AE")
    public final long getEventTimeNano() {
        long var9177F0DF4886BA63EBD71602211F864C_1450505505 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_795760726 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_795760726;
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.536 -0400", hash_original_method = "4BF6642E766343B332FD98949BC6C582", hash_generated_method = "59BF124C6011EB65120FD14160F5D51E")
    public final float getX() {
        float var66044244940F058BEDF52F995ECDF659_285767529 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_2076438516 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2076438516;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.546 -0400", hash_original_method = "91A63DEAB3A8AC7438EA04466792BD82", hash_generated_method = "049F34BCFDE24C42F5EE682270C92194")
    public final float getY() {
        float varC75AFE4F07E18DED73B6E9A135DBAA24_596818274 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_1216193283 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1216193283;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.546 -0400", hash_original_method = "6675B94FFDE5461AE8829AF0934758CB", hash_generated_method = "C0EF8F16F937CC4457C8A8BCBFD3E4EC")
    public final float getPressure() {
        float varEF9A2F87450786CEB865F6DB8CC3ECFD_122241658 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_2032108756 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2032108756;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.547 -0400", hash_original_method = "04BA234B263118C319F9FB3039E4C966", hash_generated_method = "16593AD1CD44B41EE353CFBC82115000")
    public final float getSize() {
        float varDFF5D0290CDD1A07C8B97F2F6E962921_314703595 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_764280277 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_764280277;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.547 -0400", hash_original_method = "7EDCA08C9EC8F904EE9855CC249509CB", hash_generated_method = "0F443BA9BEF2D9E236B87BDB6E52E3CC")
    public final float getTouchMajor() {
        float var2C0DAF19E2431B7454CC6F77C73821E0_542320281 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_135745217 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_135745217;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.550 -0400", hash_original_method = "0D1B5526DE02F52B1563B7D7F6F58090", hash_generated_method = "44E199DEC24D27A50A90A0BB1E845D6C")
    public final float getTouchMinor() {
        float var4508F4DDA7AD6F23C2A12D53FC2B6353_1342571017 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_138935206 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_138935206;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.551 -0400", hash_original_method = "88DA06A5CC2E8F8456F3789E8A68ED44", hash_generated_method = "73376952A8904648457AAE2682E6554E")
    public final float getToolMajor() {
        float varC9DDB5D5521C8A6BB646AB1BF9C7D9E2_1982534812 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_1445011658 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1445011658;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.551 -0400", hash_original_method = "68541C2106990EEA679DCE03A62D7FCC", hash_generated_method = "D2F79B142E01BBBB64622FFCAFF30BFC")
    public final float getToolMinor() {
        float var695C0E240E818E6BDB2EBB725DE208C8_946443471 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_2051645043 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2051645043;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.551 -0400", hash_original_method = "6DB87F8256212E2B4D49883D1C47D372", hash_generated_method = "C877781F409B3CA202F9C09B2783AF2A")
    public final float getOrientation() {
        float var75B1DB96187E89974E64BC0FB38B1FEF_1804506757 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_1065650012 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1065650012;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.552 -0400", hash_original_method = "630AA047225B25427528E4D32F567B17", hash_generated_method = "1F567957A984C44E916C6070F8D41672")
    public final float getAxisValue(int axis) {
        float var4FF16B9B17710DEACD9EEA98B643B740_1053028974 = (nativeGetAxisValue(mNativePtr, axis, 0, HISTORY_CURRENT));
        addTaint(axis);
        float var546ADE640B6EDFBC8A086EF31347E768_728926713 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_728926713;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.554 -0400", hash_original_method = "2050CCC0293D52B162C880AD9BC3C6F6", hash_generated_method = "34E2CEC576E82C92FA12BFDF37208CA8")
    public final int getPointerCount() {
        int var5ACA797B73271718F08C07B0FD1465C3_964642293 = (nativeGetPointerCount(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847144072 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847144072;
        // ---------- Original Method ----------
        //return nativeGetPointerCount(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.560 -0400", hash_original_method = "43D465AFB7AC0153BC6ACD556C5FF613", hash_generated_method = "D8CAC4D8719D270B18425FDE7F5261F8")
    public final int getPointerId(int pointerIndex) {
        int var17A8C53C4A6DAF94DA4FE0E64E276DEB_1747269785 = (nativeGetPointerId(mNativePtr, pointerIndex));
        addTaint(pointerIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259427318 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259427318;
        // ---------- Original Method ----------
        //return nativeGetPointerId(mNativePtr, pointerIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.561 -0400", hash_original_method = "4F4E823E6A973C2A4D85C86C0A6A2D9D", hash_generated_method = "E269E7DF3662D9FC0AE82DBFC47F0FFA")
    public final int getToolType(int pointerIndex) {
        int var705074F16347B844E833B41BDB330DC5_1511407193 = (nativeGetToolType(mNativePtr, pointerIndex));
        addTaint(pointerIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27257704 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27257704;
        // ---------- Original Method ----------
        //return nativeGetToolType(mNativePtr, pointerIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.565 -0400", hash_original_method = "396B4C03ADE41E49E928286EB7438AA9", hash_generated_method = "D56370943B900BD67A14D1A2DF055508")
    public final int findPointerIndex(int pointerId) {
        int varCF3227509A91EFEBFB983EC37BCBBB09_1406131962 = (nativeFindPointerIndex(mNativePtr, pointerId));
        addTaint(pointerId);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073378650 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073378650;
        // ---------- Original Method ----------
        //return nativeFindPointerIndex(mNativePtr, pointerId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.566 -0400", hash_original_method = "13E56CEAC1D2714A9A1790EF5117F935", hash_generated_method = "5332F2D2B3F648875FD43ABF01B436F0")
    public final float getX(int pointerIndex) {
        float var22607ACD4999ED3178C2C16BA32F39FA_1467484351 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1244683464 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1244683464;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.566 -0400", hash_original_method = "9A0C47F653E064961B232F3274CD29C9", hash_generated_method = "9F1A767C5DD74CC405EC99363A43E180")
    public final float getY(int pointerIndex) {
        float varEC964DA0D0FCB932F45F9605581B800C_1764250294 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_2079752220 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2079752220;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.579 -0400", hash_original_method = "36E2BAC74F4F826870F428D93CA1D371", hash_generated_method = "83A5B7854B3A26D400BC01A49902C3F4")
    public final float getPressure(int pointerIndex) {
        float varDB60B99C5EF7895E6B92B91772C5962E_553108811 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_781543218 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_781543218;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.579 -0400", hash_original_method = "50DE00A69645B3335E8383A50AB1EB05", hash_generated_method = "57BBABB921C284F945E94D94C8C988AD")
    public final float getSize(int pointerIndex) {
        float varB4E63BA449D57F4253A0AB8919D42D10_1680249250 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1651858344 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1651858344;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.580 -0400", hash_original_method = "28BED69B39230D6E2E593658DA262948", hash_generated_method = "0B0BFD0F6D24B48B30B75584C6A8C65D")
    public final float getTouchMajor(int pointerIndex) {
        float varA24CED3D0F358E3C65B964973B4F5F83_151730559 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1700695718 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1700695718;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.580 -0400", hash_original_method = "2C1FBE2BFEFC6BD6A6EFC25F55DD94B0", hash_generated_method = "F7E241819FE536E1A03CC781B736EF92")
    public final float getTouchMinor(int pointerIndex) {
        float var120D3EDA1AEC95857772396D3ADDF431_916117859 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_646808413 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_646808413;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.585 -0400", hash_original_method = "66B849A9DC257EF38185AFB935434C46", hash_generated_method = "2364026C36D3BE75957F46EE2B6FA713")
    public final float getToolMajor(int pointerIndex) {
        float varE1A0953AB1720A635D0A001029F15F98_488116414 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_699594047 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_699594047;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.585 -0400", hash_original_method = "F39564D767A71A1EAACBC920B100E436", hash_generated_method = "6F6F919F96177CDA36A03723460B7662")
    public final float getToolMinor(int pointerIndex) {
        float varC32F5653C2BD206ECB16EB3579C5B644_33839686 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1895879605 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1895879605;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.609 -0400", hash_original_method = "A9038F286A5A1470BB26B4145360A2CC", hash_generated_method = "8A3CD384242EB1CC8B81BDB2956E4AB9")
    public final float getOrientation(int pointerIndex) {
        float var865B68C13F122391AB0E054D3314ED41_994167394 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_23320124 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_23320124;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.610 -0400", hash_original_method = "3434CDF166CDB98F83BC4BA0F4722E7E", hash_generated_method = "1F37EA5DC59A00DF74CB486836ADE1BA")
    public final float getAxisValue(int axis, int pointerIndex) {
        float varDC8E493A6FB2EE0C0CB23BC5DBBC02F1_1513734045 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, HISTORY_CURRENT));
        addTaint(axis);
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_951695756 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_951695756;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.613 -0400", hash_original_method = "33DE471947CC053A5003BB5AAC41F910", hash_generated_method = "C2634D55CDBB110158610B7C8510FCC1")
    public final void getPointerCoords(int pointerIndex, PointerCoords outPointerCoords) {
        nativeGetPointerCoords(mNativePtr, pointerIndex, HISTORY_CURRENT, outPointerCoords);
        addTaint(pointerIndex);
        addTaint(outPointerCoords.getTaint());
        // ---------- Original Method ----------
        //nativeGetPointerCoords(mNativePtr, pointerIndex, HISTORY_CURRENT, outPointerCoords);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.614 -0400", hash_original_method = "FC8907B12AF62543F5FA0564EA522E62", hash_generated_method = "3817B6CBDA6CAF5BC227122F4E8174BF")
    public final void getPointerProperties(int pointerIndex,
            PointerProperties outPointerProperties) {
        nativeGetPointerProperties(mNativePtr, pointerIndex, outPointerProperties);
        addTaint(pointerIndex);
        addTaint(outPointerProperties.getTaint());
        // ---------- Original Method ----------
        //nativeGetPointerProperties(mNativePtr, pointerIndex, outPointerProperties);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.614 -0400", hash_original_method = "38A68962B5CFD92D43EE16A436EABCF2", hash_generated_method = "2F535DF39EBA7A0AC3099B52F3AFA7D4")
    public final int getMetaState() {
        int var2EB518F4D6071C6F350D1D5C097F88FF_1208684834 = (nativeGetMetaState(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_940376323 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_940376323;
        // ---------- Original Method ----------
        //return nativeGetMetaState(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.615 -0400", hash_original_method = "C8458CE15D5B2817F47A4FD377CE1968", hash_generated_method = "4A98216B8C02428F567470D51520FF84")
    public final int getButtonState() {
        int var6E0173150D4C4630052CCF82C8F7DC9F_661483970 = (nativeGetButtonState(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182262267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182262267;
        // ---------- Original Method ----------
        //return nativeGetButtonState(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.616 -0400", hash_original_method = "6E457CC599C66DF6B9AC57A3DF3B8E7E", hash_generated_method = "7A425E01B3AE5D873AD497A262F98DD6")
    public final float getRawX() {
        float var78851251BB2BADD4A73F875B41E82C95_157694723 = (nativeGetRawAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_1257952989 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1257952989;
        // ---------- Original Method ----------
        //return nativeGetRawAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.617 -0400", hash_original_method = "C18C1837908CE668DE325D32328DA600", hash_generated_method = "1130C43C0544B82FFA9A0015EF4F4210")
    public final float getRawY() {
        float varB2F71D566D9DFEDA8765CB859668364C_542893430 = (nativeGetRawAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_507799131 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_507799131;
        // ---------- Original Method ----------
        //return nativeGetRawAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.617 -0400", hash_original_method = "32503B0D7203271814D12FFB8906664F", hash_generated_method = "C1F54A8BCB521F4885469EE6996997C8")
    public final float getXPrecision() {
        float var8C63D112819BF4307BFC05C55813CC7C_521391527 = (nativeGetXPrecision(mNativePtr));
        float var546ADE640B6EDFBC8A086EF31347E768_2031225353 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2031225353;
        // ---------- Original Method ----------
        //return nativeGetXPrecision(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.617 -0400", hash_original_method = "77B44C5CFF493101D20AF55AA249AFB4", hash_generated_method = "9601E6B96688E1B1E38250E0A6CA30D3")
    public final float getYPrecision() {
        float var2DA4AA757DDFF641DBCEE9F2CC39A8B1_739160499 = (nativeGetYPrecision(mNativePtr));
        float var546ADE640B6EDFBC8A086EF31347E768_912546957 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_912546957;
        // ---------- Original Method ----------
        //return nativeGetYPrecision(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.624 -0400", hash_original_method = "B4D273F4D2084C890DE19B631E3ED869", hash_generated_method = "7C0476DFDAF2DB1B1246605B1857F7DA")
    public final int getHistorySize() {
        int var42FF49C139613133CE8AAF262A0781C4_1570264190 = (nativeGetHistorySize(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980970375 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980970375;
        // ---------- Original Method ----------
        //return nativeGetHistorySize(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.626 -0400", hash_original_method = "4F37DFE9294EB232F86D1F83C2ADDC74", hash_generated_method = "0977503662D033AD2FB46EC2A9F4A3EE")
    public final long getHistoricalEventTime(int pos) {
        long var86B3FEF5B6798FC4F49A53A44960DD31_1317801794 = (nativeGetEventTimeNanos(mNativePtr, pos) / NS_PER_MS);
        addTaint(pos);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_102164023 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_102164023;
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, pos) / NS_PER_MS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.627 -0400", hash_original_method = "52641DCD8C1505610834B8CDD1492B06", hash_generated_method = "B4AB936D6C30B7643164936B9BCE0A00")
    public final float getHistoricalX(int pos) {
        float varD6254ED09F523E7C1E53ADA626DF0C10_2146052825 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_493496140 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_493496140;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.630 -0400", hash_original_method = "456D8725235AB4DBC45E47B4ADD23013", hash_generated_method = "37CCF3093ADB6FF8B8E0A5B66E1CF829")
    public final float getHistoricalY(int pos) {
        float varF753E500532420F185A79C4FC58F3F0B_1979171270 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_502898607 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_502898607;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.630 -0400", hash_original_method = "E822398D8AD69E2A637D6F0BC07F61D8", hash_generated_method = "1B653B35BF4F43961FB3E2B7F9E54824")
    public final float getHistoricalPressure(int pos) {
        float var8CCA0683C3AD89698B4BB2DCB56AF6E0_1542764351 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1550611157 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1550611157;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.631 -0400", hash_original_method = "A43A8374A73078EDB84358D609B2C354", hash_generated_method = "824F023537A1E5E444DA4F5433968139")
    public final float getHistoricalSize(int pos) {
        float varA2CCAFC013471427EED1D8795B79DF34_1834381464 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1400339498 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1400339498;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.643 -0400", hash_original_method = "192AC6C55C0D7020BB0EA3AE5DE4FD65", hash_generated_method = "3CE629D6F7BD91FE1F2C90BF9C23ED80")
    public final float getHistoricalTouchMajor(int pos) {
        float var8E7AD2DB9688820EB8F0B7CB347E27F7_2015821985 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_119624414 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_119624414;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.643 -0400", hash_original_method = "122C0ECAA119AC26B3F087E871FFA312", hash_generated_method = "1A601262BF585D974096874E4E839986")
    public final float getHistoricalTouchMinor(int pos) {
        float var47136F660FFE6DBB3965B94BCAC103FF_295753387 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_399516811 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_399516811;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.644 -0400", hash_original_method = "8097CEA35B3273816C6109CC76A9BC74", hash_generated_method = "FE881162B674AB53F6BB4D1070171231")
    public final float getHistoricalToolMajor(int pos) {
        float varACE33102325AC5113F663D281165CB12_721768101 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1616758806 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1616758806;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.644 -0400", hash_original_method = "E0365AAE3D6BF704A796F5D4E7964FB9", hash_generated_method = "083D76C9B6EF3A7452F44C178A423627")
    public final float getHistoricalToolMinor(int pos) {
        float varBDFEBFC87FD2C86C951881656D01FBFE_580219470 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1645381633 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1645381633;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.645 -0400", hash_original_method = "DC8FCE9CD404D08D0BFF0CC77CEE87C1", hash_generated_method = "C59A4780BC5BEF86360F5FEE0ADF9D81")
    public final float getHistoricalOrientation(int pos) {
        float var9ABC98E782A3870F9AA5DFC3F27D891C_274124265 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_976575987 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_976575987;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.645 -0400", hash_original_method = "697532A0192D8868F2E3AE618301BF20", hash_generated_method = "FE51CF4D016C690A6705577310EA8E34")
    public final float getHistoricalAxisValue(int axis, int pos) {
        float varE580B6B92EAD96F426B34B55A944EC3F_1869567171 = (nativeGetAxisValue(mNativePtr, axis, 0, pos));
        addTaint(axis);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1455058786 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1455058786;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.657 -0400", hash_original_method = "8BFA09569623FF1F941D2134C3D47F02", hash_generated_method = "8A5AA384F12A790F33DB55F89F1FAC23")
    public final float getHistoricalX(int pointerIndex, int pos) {
        float var70F4D2CDA260BE637BE2F366621D1047_759012201 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_815900109 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_815900109;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.658 -0400", hash_original_method = "9787FE8A43AC5153EC8D7EC463FC985B", hash_generated_method = "EF7E4797D387C466333425105EA05949")
    public final float getHistoricalY(int pointerIndex, int pos) {
        float var4338B7951F95F5B1B66FDB2F4DC27413_1322200045 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_352312457 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_352312457;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.658 -0400", hash_original_method = "A8F703E0BCBA29F53C62C25AACD436ED", hash_generated_method = "CED5AC2E1AEBD072F8C1ADE12EB43F63")
    public final float getHistoricalPressure(int pointerIndex, int pos) {
        float var599EE82AA7EED666174FF6603E5D9EDB_1607405100 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_171662769 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_171662769;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.658 -0400", hash_original_method = "66A9DA10859CF6933D658F61BE53F70F", hash_generated_method = "C7B089AE7392E9344B582353EB6A2912")
    public final float getHistoricalSize(int pointerIndex, int pos) {
        float var6ADB36223580AAF1DF6650FEF9BEFE5F_466468447 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_116096664 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_116096664;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.659 -0400", hash_original_method = "38D72D2E0F00AE5C39667CDDD41B271D", hash_generated_method = "9683DEE108AD0AFC4E699500A7ABFA83")
    public final float getHistoricalTouchMajor(int pointerIndex, int pos) {
        float var04576CC24CDC939EA1B84F18BA4AA27C_1655698940 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_2016618448 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2016618448;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.659 -0400", hash_original_method = "F3D94A1F01A3ECEF6DEDEA9361640BF9", hash_generated_method = "55DF68B54B677A8424A66405B325DA90")
    public final float getHistoricalTouchMinor(int pointerIndex, int pos) {
        float varE0E8C51F7817613AD2DBA52263E38B64_1552690611 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1706923545 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1706923545;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.659 -0400", hash_original_method = "78FB77773CB43A5420D0F24849B540AD", hash_generated_method = "BB0184722D82A7F379DAA62EE9FE38BC")
    public final float getHistoricalToolMajor(int pointerIndex, int pos) {
        float var40EEA85674FBE73ABF2A2BD2F2E74CD6_31782725 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1870878556 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1870878556;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.660 -0400", hash_original_method = "4AB7745853006A3796DAD0E637CCA598", hash_generated_method = "D0FABF11A419D27F94C8F6644D2481DA")
    public final float getHistoricalToolMinor(int pointerIndex, int pos) {
        float var784F21A01E3CEC7D68998B91D48C129C_450306487 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_452491036 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_452491036;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.660 -0400", hash_original_method = "160C0106DB8A4C6FBAA9569ABA0D68E8", hash_generated_method = "56F0BB04C7F820691F68F433EB0731A8")
    public final float getHistoricalOrientation(int pointerIndex, int pos) {
        float var02FA0A42AAD0F907D9EB0C172EDB6AB4_1647710941 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1328070570 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1328070570;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.660 -0400", hash_original_method = "F645AABE3B2CF14D2790BA051F9F3FF1", hash_generated_method = "5677F817D521C21A2D9A1EE145E77118")
    public final float getHistoricalAxisValue(int axis, int pointerIndex, int pos) {
        float var675E97582C752387B4365682C4F7B0FA_1790846474 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, pos));
        addTaint(axis);
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1031756460 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1031756460;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.664 -0400", hash_original_method = "D80ADCD256759644414D5CBEC3C57D0B", hash_generated_method = "823891EAFF818A17196A773F0FA5CE89")
    public final void getHistoricalPointerCoords(int pointerIndex, int pos,
            PointerCoords outPointerCoords) {
        nativeGetPointerCoords(mNativePtr, pointerIndex, pos, outPointerCoords);
        addTaint(pointerIndex);
        addTaint(pos);
        addTaint(outPointerCoords.getTaint());
        // ---------- Original Method ----------
        //nativeGetPointerCoords(mNativePtr, pointerIndex, pos, outPointerCoords);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.665 -0400", hash_original_method = "26EA400A9751805DFF1D4CEEB005645B", hash_generated_method = "32C7A3A0DD0F839D542212FE65E62D31")
    public final int getEdgeFlags() {
        int var0FC0D903F55D3C457853DAA4F228A5D4_1703554985 = (nativeGetEdgeFlags(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364012417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364012417;
        // ---------- Original Method ----------
        //return nativeGetEdgeFlags(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.665 -0400", hash_original_method = "348B6A1C5666102E94291FA4791C249A", hash_generated_method = "5A4570138FFF3A25CF234159371B5805")
    public final void setEdgeFlags(int flags) {
        nativeSetEdgeFlags(mNativePtr, flags);
        addTaint(flags);
        // ---------- Original Method ----------
        //nativeSetEdgeFlags(mNativePtr, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.665 -0400", hash_original_method = "34CE363FC32882BC3BBCF2E8ABF2B5B0", hash_generated_method = "A9E08CEA9A55C1AD709C1AB66565DD54")
    public final void setAction(int action) {
        nativeSetAction(mNativePtr, action);
        addTaint(action);
        // ---------- Original Method ----------
        //nativeSetAction(mNativePtr, action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.666 -0400", hash_original_method = "117CE161431F2ECDED077AD7F7467ADD", hash_generated_method = "F7F6376FBB851076E5998FA5155D9734")
    public final void offsetLocation(float deltaX, float deltaY) {
        nativeOffsetLocation(mNativePtr, deltaX, deltaY);
        addTaint(deltaX);
        addTaint(deltaY);
        // ---------- Original Method ----------
        //nativeOffsetLocation(mNativePtr, deltaX, deltaY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.666 -0400", hash_original_method = "D9D9F7662138ADF2F9591F7DFAEB3F74", hash_generated_method = "5B23CED6195458125C002D2EA5275E2D")
    public final void setLocation(float x, float y) {
        float oldX;
        oldX = getX();
        float oldY;
        oldY = getY();
        nativeOffsetLocation(mNativePtr, x - oldX, y - oldY);
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //float oldX = getX();
        //float oldY = getY();
        //nativeOffsetLocation(mNativePtr, x - oldX, y - oldY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.666 -0400", hash_original_method = "622D19544C973DA41E1BE7D7819B5A41", hash_generated_method = "004135DE97E073DF20896A01618AE199")
    public final void transform(Matrix matrix) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("matrix must not be null");
        } //End block
        nativeTransform(mNativePtr, matrix);
        addTaint(matrix.getTaint());
        // ---------- Original Method ----------
        //if (matrix == null) {
            //throw new IllegalArgumentException("matrix must not be null");
        //}
        //nativeTransform(mNativePtr, matrix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.681 -0400", hash_original_method = "F001981BC7F115C74B7EB0136965714D", hash_generated_method = "08D588C17755EF4DD207BB900C2E3B4A")
    public final void addBatch(long eventTime, float x, float y,
            float pressure, float size, int metaState) {
        {
            ensureSharedTempPointerCapacity(1);
            PointerCoords[] pc;
            pc = gSharedTempPointerCoords;
            pc[0].clear();
            pc[0].x = x;
            pc[0].y = y;
            pc[0].pressure = pressure;
            pc[0].size = size;
            nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pc, metaState);
        } //End block
        addTaint(eventTime);
        addTaint(x);
        addTaint(y);
        addTaint(pressure);
        addTaint(size);
        addTaint(metaState);
        // ---------- Original Method ----------
        //synchronized (gSharedTempLock) {
            //ensureSharedTempPointerCapacity(1);
            //final PointerCoords[] pc = gSharedTempPointerCoords;
            //pc[0].clear();
            //pc[0].x = x;
            //pc[0].y = y;
            //pc[0].pressure = pressure;
            //pc[0].size = size;
            //nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pc, metaState);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.681 -0400", hash_original_method = "06E22018450E3E0892CD70DE9E19F211", hash_generated_method = "7A120BD6D13363A133E619C134B29A2E")
    public final void addBatch(long eventTime, PointerCoords[] pointerCoords, int metaState) {
        nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pointerCoords, metaState);
        addTaint(eventTime);
        addTaint(pointerCoords[0].getTaint());
        addTaint(metaState);
        // ---------- Original Method ----------
        //nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pointerCoords, metaState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.682 -0400", hash_original_method = "542474DD15BDDADB068A65C6A3EEA8E2", hash_generated_method = "9E7E218C9273C35754CA5A4625241A5F")
    public final boolean isWithinBoundsNoHistory(float left, float top,
            float right, float bottom) {
        int pointerCount;
        pointerCount = nativeGetPointerCount(mNativePtr);
        {
            int i;
            i = 0;
            {
                float x;
                x = nativeGetAxisValue(mNativePtr, AXIS_X, i, HISTORY_CURRENT);
                float y;
                y = nativeGetAxisValue(mNativePtr, AXIS_Y, i, HISTORY_CURRENT);
            } //End block
        } //End collapsed parenthetic
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833307612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_833307612;
        // ---------- Original Method ----------
        //final int pointerCount = nativeGetPointerCount(mNativePtr);
        //for (int i = 0; i < pointerCount; i++) {
            //final float x = nativeGetAxisValue(mNativePtr, AXIS_X, i, HISTORY_CURRENT);
            //final float y = nativeGetAxisValue(mNativePtr, AXIS_Y, i, HISTORY_CURRENT);
            //if (x < left || x > right || y < top || y > bottom) {
                //return false;
            //}
        //}
        //return true;
    }

    
        private static final float clamp(float value, float low, float high) {
        if (value < low) {
            return low;
        } else if (value > high) {
            return high;
        }
        return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.703 -0400", hash_original_method = "C00E6E79D43678980DA0F4144A65F6A2", hash_generated_method = "1B2CE4EFEA0CD09BC53CD69173175200")
    public final MotionEvent clampNoHistory(float left, float top, float right, float bottom) {
        MotionEvent varB4EAC82CA7396A68D541C85D26508E83_794450536 = null; //Variable for return #1
        MotionEvent ev;
        ev = obtain();
        {
            int pointerCount;
            pointerCount = nativeGetPointerCount(mNativePtr);
            ensureSharedTempPointerCapacity(pointerCount);
            PointerProperties[] pp;
            pp = gSharedTempPointerProperties;
            PointerCoords[] pc;
            pc = gSharedTempPointerCoords;
            {
                int i;
                i = 0;
                {
                    nativeGetPointerProperties(mNativePtr, i, pp[i]);
                    nativeGetPointerCoords(mNativePtr, i, HISTORY_CURRENT, pc[i]);
                    pc[i].x = clamp(pc[i].x, left, right);
                    pc[i].y = clamp(pc[i].y, top, bottom);
                } //End block
            } //End collapsed parenthetic
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
            varB4EAC82CA7396A68D541C85D26508E83_794450536 = ev;
        } //End block
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        varB4EAC82CA7396A68D541C85D26508E83_794450536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_794450536;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.704 -0400", hash_original_method = "FBF170B15B2FFBEE1AB1D4E32A8773CA", hash_generated_method = "644631281A6653BE3791E121C019A7A9")
    public final int getPointerIdBits() {
        int idBits;
        idBits = 0;
        int pointerCount;
        pointerCount = nativeGetPointerCount(mNativePtr);
        {
            int i;
            i = 0;
            {
                idBits |= 1 << nativeGetPointerId(mNativePtr, i);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420610536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420610536;
        // ---------- Original Method ----------
        //int idBits = 0;
        //final int pointerCount = nativeGetPointerCount(mNativePtr);
        //for (int i = 0; i < pointerCount; i++) {
            //idBits |= 1 << nativeGetPointerId(mNativePtr, i);
        //}
        //return idBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.706 -0400", hash_original_method = "4F0FF8B26009CA9D26EE500AEFE507EC", hash_generated_method = "33D31AB9D9241B910BC2394FF034BD41")
    public final MotionEvent split(int idBits) {
        MotionEvent varB4EAC82CA7396A68D541C85D26508E83_1423319898 = null; //Variable for return #1
        MotionEvent ev;
        ev = obtain();
        {
            int oldPointerCount;
            oldPointerCount = nativeGetPointerCount(mNativePtr);
            ensureSharedTempPointerCapacity(oldPointerCount);
            PointerProperties[] pp;
            pp = gSharedTempPointerProperties;
            PointerCoords[] pc;
            pc = gSharedTempPointerCoords;
            int[] map;
            map = gSharedTempPointerIndexMap;
            int oldAction;
            oldAction = nativeGetAction(mNativePtr);
            int oldActionMasked;
            oldActionMasked = oldAction & ACTION_MASK;
            int oldActionPointerIndex;
            oldActionPointerIndex = (oldAction & ACTION_POINTER_INDEX_MASK)
                    >> ACTION_POINTER_INDEX_SHIFT;
            int newActionPointerIndex;
            newActionPointerIndex = -1;
            int newPointerCount;
            newPointerCount = 0;
            int newIdBits;
            newIdBits = 0;
            {
                int i;
                i = 0;
                {
                    nativeGetPointerProperties(mNativePtr, i, pp[newPointerCount]);
                    int idBit;
                    idBit = 1 << pp[newPointerCount].id;
                    {
                        {
                            newActionPointerIndex = newPointerCount;
                        } //End block
                        map[newPointerCount] = i;
                        newPointerCount += 1;
                        newIdBits |= idBit;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("idBits did not match any ids in the event");
            } //End block
            int newAction;
            {
                {
                    newAction = ACTION_MOVE;
                } //End block
                {
                    newAction = oldActionMasked == ACTION_POINTER_DOWN
                            ? ACTION_DOWN : ACTION_UP;
                } //End block
                {
                    newAction = oldActionMasked
                            | (newActionPointerIndex << ACTION_POINTER_INDEX_SHIFT);
                } //End block
            } //End block
            {
                newAction = oldAction;
            } //End block
            int historySize;
            historySize = nativeGetHistorySize(mNativePtr);
            {
                int h;
                h = 0;
                {
                    int historyPos;
                    historyPos = HISTORY_CURRENT;
                    historyPos = h;
                    {
                        int i;
                        i = 0;
                        {
                            nativeGetPointerCoords(mNativePtr, map[i], historyPos, pc[i]);
                        } //End block
                    } //End collapsed parenthetic
                    long eventTimeNanos;
                    eventTimeNanos = nativeGetEventTimeNanos(mNativePtr, historyPos);
                    {
                        ev.mNativePtr = nativeInitialize(ev.mNativePtr,
                            nativeGetDeviceId(mNativePtr), nativeGetSource(mNativePtr),
                            newAction, nativeGetFlags(mNativePtr),
                            nativeGetEdgeFlags(mNativePtr), nativeGetMetaState(mNativePtr),
                            nativeGetButtonState(mNativePtr),
                            nativeGetXOffset(mNativePtr), nativeGetYOffset(mNativePtr),
                            nativeGetXPrecision(mNativePtr), nativeGetYPrecision(mNativePtr),
                            nativeGetDownTimeNanos(mNativePtr), eventTimeNanos,
                            newPointerCount, pp, pc);
                    } //End block
                    {
                        nativeAddBatch(ev.mNativePtr, eventTimeNanos, pc, 0);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1423319898 = ev;
        } //End block
        addTaint(idBits);
        varB4EAC82CA7396A68D541C85D26508E83_1423319898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1423319898;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.720 -0400", hash_original_method = "69A985781D7A79E036178DEB42E5F1F0", hash_generated_method = "18AE75BAFB7017DCC15EC217DC93A9A5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1710289228 = null; //Variable for return #1
        StringBuilder msg;
        msg = new StringBuilder();
        msg.append("MotionEvent { action=").append(actionToString(getAction()));
        int pointerCount;
        pointerCount = getPointerCount();
        {
            int i;
            i = 0;
            {
                msg.append(", id[").append(i).append("]=").append(getPointerId(i));
                msg.append(", x[").append(i).append("]=").append(getX(i));
                msg.append(", y[").append(i).append("]=").append(getY(i));
                msg.append(", toolType[").append(i).append("]=").append(
                    toolTypeToString(getToolType(i)));
            } //End block
        } //End collapsed parenthetic
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
        varB4EAC82CA7396A68D541C85D26508E83_1710289228 = msg.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1710289228.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1710289228;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
        public static String axisToString(int axis) {
        String symbolicName = AXIS_SYMBOLIC_NAMES.get(axis);
        return symbolicName != null ? symbolicName : Integer.toString(axis);
    }

    
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

    
        public static String buttonStateToString(int buttonState) {
        if (buttonState == 0) {
            return "0";
        }
        StringBuilder result = null;
        int i = 0;
        while (buttonState != 0) {
            final boolean isSet = (buttonState & 1) != 0;
            buttonState >>>= 1; 
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

    
        public static String toolTypeToString(int toolType) {
        String symbolicName = TOOL_TYPE_SYMBOLIC_NAMES.get(toolType);
        return symbolicName != null ? symbolicName : Integer.toString(toolType);
    }

    
        public static MotionEvent createFromParcelBody(Parcel in) {
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeReadFromParcel(ev.mNativePtr, in);
        return ev;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.723 -0400", hash_original_method = "D732CA58C71ED959C0E1A12C336FC80D", hash_generated_method = "7F92D8EF6DB846D045EDC9EED70EE51B")
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(PARCEL_TOKEN_MOTION_EVENT);
        nativeWriteToParcel(mNativePtr, out);
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //out.writeInt(PARCEL_TOKEN_MOTION_EVENT);
        //nativeWriteToParcel(mNativePtr, out);
    }

    
    public static final class PointerCoords {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.723 -0400", hash_original_field = "E4845520982C15184227C7CC9D20FD50", hash_generated_field = "616BA79E3CF38111CD6326A774A7BA12")

        private long mPackedAxisBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.723 -0400", hash_original_field = "5195E654A9F1469D3F33B6FBBCE24383", hash_generated_field = "74AC3FA36AA575C3DEE392AD51F3FC84")

        private float[] mPackedAxisValues;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.723 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "0CC4A8770822EF2A4B3BD536BBF6C113")

        public float x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.723 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E8D9A0915E4274087E59C025C4DCDA11")

        public float y;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.723 -0400", hash_original_field = "D99FAD96A5D0A7CB2EB41341EA556093", hash_generated_field = "8D3DD02B3785A296D75D1BFB99C62E42")

        public float pressure;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.723 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "295F60DE48801BD75A245B044AE96BA0")

        public float size;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.723 -0400", hash_original_field = "95BE195AF7AF1434BA03D8E831DC4D43", hash_generated_field = "6D6952CAD458217EEFCB2922EE3D3E82")

        public float touchMajor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.723 -0400", hash_original_field = "AF72E652DB6EACE533A5766E00C83453", hash_generated_field = "492641BCD483F61BC74CAF973D65A13D")

        public float touchMinor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.723 -0400", hash_original_field = "B0B8BF85D8A3FA50D314A293B6CA49AC", hash_generated_field = "32FD2A0018A7199A2ED20949B6E0486E")

        public float toolMajor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.723 -0400", hash_original_field = "2A170207574AE57015C852C226F8048D", hash_generated_field = "173EB15A07C0771733DC98A43E20CE98")

        public float toolMinor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.724 -0400", hash_original_field = "DA1639422AD8F355D2371428471379B5", hash_generated_field = "054A1E23DAAFDEC28AE3DA031EECF136")

        public float orientation;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.724 -0400", hash_original_method = "30C014872AED120D5788F672204C6D56", hash_generated_method = "02D472FB06CC6A49D31A045DF0321860")
        public  PointerCoords() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.724 -0400", hash_original_method = "4C1A041805DDE756B7430BBCF7A4A54D", hash_generated_method = "48391C838CCB750879BFEE73F5AB3F53")
        public  PointerCoords(PointerCoords other) {
            copyFrom(other);
            addTaint(other.getTaint());
            // ---------- Original Method ----------
            //copyFrom(other);
        }

        
                public static PointerCoords[] createArray(int size) {
            PointerCoords[] array = new PointerCoords[size];
            for (int i = 0; i < size; i++) {
                array[i] = new PointerCoords();
            }
            return array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.743 -0400", hash_original_method = "5B10C041062144B27347C9202A1953B2", hash_generated_method = "85A3A31EE556A4BEA00BDAAD4B198A1A")
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
            // ---------- Original Method ----------
            //mPackedAxisBits = 0;
            //x = 0;
            //y = 0;
            //pressure = 0;
            //size = 0;
            //touchMajor = 0;
            //touchMinor = 0;
            //toolMajor = 0;
            //toolMinor = 0;
            //orientation = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.745 -0400", hash_original_method = "A2C68F8615572C95C5947791A8CC8026", hash_generated_method = "C1068ABA63A1D45B4215F86CCF67488C")
        public void copyFrom(PointerCoords other) {
            long bits;
            bits = other.mPackedAxisBits;
            mPackedAxisBits = bits;
            {
                float[] otherValues;
                otherValues = other.mPackedAxisValues;
                int count;
                count = Long.bitCount(bits);
                float[] values;
                values = mPackedAxisValues;
                {
                    values = new float[otherValues.length];
                    mPackedAxisValues = values;
                } //End block
                System.arraycopy(otherValues, 0, values, 0, count);
            } //End block
            x = other.x;
            y = other.y;
            pressure = other.pressure;
            size = other.size;
            touchMajor = other.touchMajor;
            touchMinor = other.touchMinor;
            toolMajor = other.toolMajor;
            toolMinor = other.toolMinor;
            orientation = other.orientation;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.752 -0400", hash_original_method = "566631CFDB34A411EF93513211D62594", hash_generated_method = "5C4A98F9D578F46ED1CFA844B75E0959")
        public float getAxisValue(int axis) {
            //Begin case default 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Axis out of range.");
                } //End block
                long bits;
                bits = mPackedAxisBits;
                long axisBit;
                axisBit = 1L << axis;
                int index;
                index = Long.bitCount(bits & (axisBit - 1L));
            } //End block
            //End case default 
            addTaint(axis);
            float var546ADE640B6EDFBC8A086EF31347E768_563082364 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_563082364;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.760 -0400", hash_original_method = "55E9DEFA01615304E1434A1FAB8328FA", hash_generated_method = "6C8D00841E24A58B2136B160C9323D12")
        public void setAxisValue(int axis, float value) {
            //Begin case AXIS_X 
            x = value;
            //End case AXIS_X 
            //Begin case AXIS_Y 
            y = value;
            //End case AXIS_Y 
            //Begin case AXIS_PRESSURE 
            pressure = value;
            //End case AXIS_PRESSURE 
            //Begin case AXIS_SIZE 
            size = value;
            //End case AXIS_SIZE 
            //Begin case AXIS_TOUCH_MAJOR 
            touchMajor = value;
            //End case AXIS_TOUCH_MAJOR 
            //Begin case AXIS_TOUCH_MINOR 
            touchMinor = value;
            //End case AXIS_TOUCH_MINOR 
            //Begin case AXIS_TOOL_MAJOR 
            toolMajor = value;
            //End case AXIS_TOOL_MAJOR 
            //Begin case AXIS_TOOL_MINOR 
            toolMinor = value;
            //End case AXIS_TOOL_MINOR 
            //Begin case AXIS_ORIENTATION 
            orientation = value;
            //End case AXIS_ORIENTATION 
            //Begin case default 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Axis out of range.");
                } //End block
                long bits;
                bits = mPackedAxisBits;
                long axisBit;
                axisBit = 1L << axis;
                int index;
                index = Long.bitCount(bits & (axisBit - 1L));
                float[] values;
                values = mPackedAxisValues;
                {
                    {
                        values = new float[INITIAL_PACKED_AXIS_VALUES];
                        mPackedAxisValues = values;
                    } //End block
                    {
                        int count;
                        count = Long.bitCount(bits);
                        {
                            {
                                System.arraycopy(values, index, values, index + 1,
                                            count - index);
                            } //End block
                        } //End block
                        {
                            float[] newValues;
                            newValues = new float[count * 2];
                            System.arraycopy(values, 0, newValues, 0, index);
                            System.arraycopy(values, index, newValues, index + 1,
                                        count - index);
                            values = newValues;
                            mPackedAxisValues = values;
                        } //End block
                    } //End block
                    mPackedAxisBits = bits | axisBit;
                } //End block
                values[index] = value;
            } //End block
            //End case default 
            addTaint(axis);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.764 -0400", hash_original_field = "33446AA70F42B7C22C25CFDF4E916659", hash_generated_field = "2B06C98645006D6EA8A2B322BAE430CC")

        private static int INITIAL_PACKED_AXIS_VALUES = 8;
    }


    
    public static final class PointerProperties {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.764 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.764 -0400", hash_original_field = "F803A61F4662F15B2A4B72308BD45F04", hash_generated_field = "E5CA883B5E8E2CF4928B3E305240E7C6")

        public int toolType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.764 -0400", hash_original_method = "D6AAE40F539D7383E827DA395512E95B", hash_generated_method = "207B464AAB7566FD25D2646B7EE6C19D")
        public  PointerProperties() {
            clear();
            // ---------- Original Method ----------
            //clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.765 -0400", hash_original_method = "0B0B44B5B3A0DCF648446956F27785E9", hash_generated_method = "546D6C0D6DB00699FD7A0BFFECCB1CBA")
        public  PointerProperties(PointerProperties other) {
            copyFrom(other);
            addTaint(other.getTaint());
            // ---------- Original Method ----------
            //copyFrom(other);
        }

        
                public static PointerProperties[] createArray(int size) {
            PointerProperties[] array = new PointerProperties[size];
            for (int i = 0; i < size; i++) {
                array[i] = new PointerProperties();
            }
            return array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.765 -0400", hash_original_method = "ADC6A83F955A9ED0C1C75B5F08682583", hash_generated_method = "DFC90B75E706F2F74BBF473BA904F663")
        public void clear() {
            id = INVALID_POINTER_ID;
            toolType = TOOL_TYPE_UNKNOWN;
            // ---------- Original Method ----------
            //id = INVALID_POINTER_ID;
            //toolType = TOOL_TYPE_UNKNOWN;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.770 -0400", hash_original_method = "1E34ECE529256025A33CF5DCBE029131", hash_generated_method = "83EE2C55C6A446D371F6C2FC0D637123")
        public void copyFrom(PointerProperties other) {
            id = other.id;
            toolType = other.toolType;
            // ---------- Original Method ----------
            //id = other.id;
            //toolType = other.toolType;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.773 -0400", hash_original_field = "6E4EF440EBC2808EB9427311B59A1879", hash_generated_field = "5AEA1314C31F61CE0FA4C3D8BBCFD29D")

    private static long NS_PER_MS = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "72335DCE9A3EDFEDA119916AF8BD9A52", hash_generated_field = "F0D09920D6FB669F0AB9A3AB30F9FE63")

    private static boolean TRACK_RECYCLED_LOCATION = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "337218C9F350445474335E0ED8EB52D2", hash_generated_field = "122232306FDB60B34ACA42DBAA65B736")

    public static final int INVALID_POINTER_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "034E2BCD80D0FE32BEE35A26F527AB82", hash_generated_field = "464488178905DF6887AEEC102D03F9BB")

    public static final int ACTION_MASK             = 0xff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "05E3DA568602DAD9EA3C414607B71E65", hash_generated_field = "B56FBABE5CC8DDE909CEA8CDE98BA93D")

    public static final int ACTION_DOWN             = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "6D72F1F84E251024F9C1BAF7B002F529", hash_generated_field = "E9419BD1576C4C89CB972C93BF43E7C5")

    public static final int ACTION_UP               = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "E0AAA7BED07FEFB1355300A23A152F90", hash_generated_field = "0869EE70BD47CB90D812F686B7F0D216")

    public static final int ACTION_MOVE             = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "C46423CE3E5642BA0CB7AB6CB09262AE", hash_generated_field = "CCD39E7D9940D088C4EBAE690B5B3006")

    public static final int ACTION_CANCEL           = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "5B47F521CF7C2C903B879280CC51E19F", hash_generated_field = "B53AF36739EBD3146722B0AB3CAF54B6")

    public static final int ACTION_OUTSIDE          = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "596B10C23830633246B5FE119303CA31", hash_generated_field = "BE1BA8B002AC6D11B1BA8B25140F3104")

    public static final int ACTION_POINTER_DOWN     = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "1CD52FBA3CE6A637AE86BF305E1727A2", hash_generated_field = "779F82BEF077301CD2887D1C33590F74")

    public static final int ACTION_POINTER_UP       = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "A117FB885030C87F8035EE8197E01274", hash_generated_field = "A31BF98337FB8359E97DA48D76D80977")

    public static final int ACTION_HOVER_MOVE       = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "EDD00CD16649F89FF44DD9C0E161B238", hash_generated_field = "D4C11BB0C70739D756D7BA7A8EBDE32D")

    public static final int ACTION_SCROLL           = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "E6889A317885B7F3FCFCB516DDE1B506", hash_generated_field = "6EED9A028D9812B11E3EC6500A22417D")

    public static final int ACTION_HOVER_ENTER      = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "5A019C5D2F9BBBECE84DA46559873CDE", hash_generated_field = "36537B951CA8A88E1E580F444A68C4EB")

    public static final int ACTION_HOVER_EXIT       = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "F94A33E7C5ACFBEFDFBB09F0FB9B278A", hash_generated_field = "E260033975F8D36BD53DB361D54BA2BF")

    public static final int ACTION_POINTER_INDEX_MASK  = 0xff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "DAB0332B2F0024984DE4DD67C040BC0F", hash_generated_field = "3ED9AD85BB2784B1321927FB5C085339")

    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "9592F84893EF5C92909845A138CAE395", hash_generated_field = "0E6D248BF8E40C6A30CD011E4FE93537")

    @Deprecated
    public static final int ACTION_POINTER_1_DOWN   = ACTION_POINTER_DOWN | 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "7F4BF3EB26FAD7B49445118A59CE6146", hash_generated_field = "2A2F376950DB01CC014C8F15C5D29770")

    @Deprecated
    public static final int ACTION_POINTER_2_DOWN   = ACTION_POINTER_DOWN | 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "AA3C2A077F9DEEFBA6F2542C0560FB1B", hash_generated_field = "9C71C2EB30843366313F3020BE578C26")

    @Deprecated
    public static final int ACTION_POINTER_3_DOWN   = ACTION_POINTER_DOWN | 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "449EA013BBCDA169B9EF1D2297500187", hash_generated_field = "CB217DFD0D7D2A2D8289D57696E595C7")

    @Deprecated
    public static final int ACTION_POINTER_1_UP     = ACTION_POINTER_UP | 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "91D34AE0179B0BC5900FFCB630718519", hash_generated_field = "0531D8E2B94086788DA257D61DD61C0F")

    @Deprecated
    public static final int ACTION_POINTER_2_UP     = ACTION_POINTER_UP | 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "F4E6043EA1CA67A36A2F06C954118606", hash_generated_field = "98C2F8F94E43CA43968FDCDBCC9896C4")

    @Deprecated
    public static final int ACTION_POINTER_3_UP     = ACTION_POINTER_UP | 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "E323657B2EB80B422379A9CEBE0A7866", hash_generated_field = "21CA20F1626331DC2869522A2DE48834")

    @Deprecated
    public static final int ACTION_POINTER_ID_MASK  = 0xff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "B6823DDE720D0C768C88F68459F98292", hash_generated_field = "674FBE2D655FD483B823B2E251529FF3")

    @Deprecated
    public static final int ACTION_POINTER_ID_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "029786C6547ED0693759CAAEFEA9CFC0", hash_generated_field = "D55190196D2C1F6E3FFFC84FA0B9D772")

    public static final int FLAG_WINDOW_IS_OBSCURED = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.774 -0400", hash_original_field = "550A819DF1874DD6CBEB9E34B7E02CA2", hash_generated_field = "22C757AFB129CA98FC86BD04BEE94F98")

    public static final int FLAG_TAINTED = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "A633F8D6629EE7B06C2FD6D1B0DC9450", hash_generated_field = "E88E0AA9A676F8906011C2C253859C66")

    public static final int EDGE_TOP = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "A822268AD0B774AEEE14EC8CC8D9F93B", hash_generated_field = "7F13D97BAA00BFCDC5B911BB5B6DCDF3")

    public static final int EDGE_BOTTOM = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "8B1FDF0477E0C35DA2FB7C7B8306974A", hash_generated_field = "96B2B8C704DDAD0603C6C6E2FFC340B1")

    public static final int EDGE_LEFT = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "A3A04219B91FA85B01EA955DFFF5FEB5", hash_generated_field = "4B4418A2700C288E6EFE7AF6B858A111")

    public static final int EDGE_RIGHT = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "F43EDDBFB6367074F45ECA2C476C6565", hash_generated_field = "6AC2F269D8C677A5928AAB4766B0AFA4")

    public static final int AXIS_X = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "B104E19452EE81C2A619F4D57E3AEDBE", hash_generated_field = "1F1942945032A87C66ACA5752705A256")

    public static final int AXIS_Y = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "6542F537176A3A95C9638B5D2D6D3282", hash_generated_field = "5CB739150541FFE06EFD5DECAA58BF2C")

    public static final int AXIS_PRESSURE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "271FFE604598307C9BD49A632CD69F2C", hash_generated_field = "F805D88CFB32566B5D69E445454FA20B")

    public static final int AXIS_SIZE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "76C24AF7C4E7B5EF86EC8B7AA695C99B", hash_generated_field = "4422123708A385A40B3A3EAD28C77CA0")

    public static final int AXIS_TOUCH_MAJOR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "FDD97DCBF16D7D35D1DE9CA5AB8B0EE9", hash_generated_field = "9BD07319C2DC512FC7AFF06DB4C457EB")

    public static final int AXIS_TOUCH_MINOR = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "4CECC8FEA7DFD80C61892B5D9499F332", hash_generated_field = "3A23BEE8699344F8699632E58AAE9D00")

    public static final int AXIS_TOOL_MAJOR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "2280E38346B560BA8AFA6F674CCF146D", hash_generated_field = "F26604DCEE776E17C73C06ABB61691F6")

    public static final int AXIS_TOOL_MINOR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "034AF53CD5FD7BC7833BEAD02993E949", hash_generated_field = "2A1393B38A6522964DCE18C89C02987A")

    public static final int AXIS_ORIENTATION = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "6A09A3E15FC599ADAD44D13102C405DD", hash_generated_field = "3653EDC97D1EC153035B8B2CF03F0D9F")

    public static final int AXIS_VSCROLL = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "ADCA61A712EC2EAE4DA4FCDD6574618C", hash_generated_field = "92F839C5EBC2322D5FA86535F6F819CB")

    public static final int AXIS_HSCROLL = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "5952DC7A036BAD5A2FA3BB4702C69033", hash_generated_field = "AF121E953BE1BD481D0CFED4A68E74C0")

    public static final int AXIS_Z = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "102726DF7AC3CD66F5F16B29BE4E0C36", hash_generated_field = "F9C0DE51E0127685ECA28E542A120E88")

    public static final int AXIS_RX = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.775 -0400", hash_original_field = "225D93A029576C17E912D37880E035F3", hash_generated_field = "0C4C76335C9A3564DACCCDBE8DD301F2")

    public static final int AXIS_RY = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.779 -0400", hash_original_field = "3622454F61D2BEAFB3A7C20E8B67794C", hash_generated_field = "FE837C29D6032EC2960992B9D8A8B178")

    public static final int AXIS_RZ = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "B89A4C4024CEA0CBEF2F49139937E488", hash_generated_field = "95D53DACF181EE3407879E3C0B3371DA")

    public static final int AXIS_HAT_X = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "F8B0B5501EAF46948DD4D8DFF857FF22", hash_generated_field = "448C69D0D61F2BF459C3AC283A9A3DD2")

    public static final int AXIS_HAT_Y = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "08B1FD10B1CA6EAEC83C43A9C0979C60", hash_generated_field = "4450CC9F108DED3391D6ED8F0D534120")

    public static final int AXIS_LTRIGGER = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "980E2D34290DF1ACCB31AFE81E0A824D", hash_generated_field = "275AE4D63A24B8018CE3E210BAC8D939")

    public static final int AXIS_RTRIGGER = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "267E7C0549F05F5D932F84A17DB329C1", hash_generated_field = "538CDE95EB2664616EE4F8F418B16FCF")

    public static final int AXIS_THROTTLE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "44FEE1E278CC7C2339B1E23FBF344BAE", hash_generated_field = "556882041792FB019CA717764224D5C4")

    public static final int AXIS_RUDDER = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "DA830D9524B06F5E2D1FE72F350FA3B0", hash_generated_field = "D3B7AC7DA5A4B49C56D33CA3953C8391")

    public static final int AXIS_WHEEL = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "D9DD16376FECC1C78B4D3A42DFACDB62", hash_generated_field = "B56F86F8DDA863909AE502D90FA7D4A4")

    public static final int AXIS_GAS = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "3D955FBE6867B617A6459F1390B213ED", hash_generated_field = "7148E428BBB18A5A04C2D90A4D20C2D2")

    public static final int AXIS_BRAKE = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "FB55C8949807223E3375F0A2504F360A", hash_generated_field = "53EBC10458EF090346DB7C3BF7B8B449")

    public static final int AXIS_DISTANCE = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "8382AC5A85A82E20003B1AC360EF6D07", hash_generated_field = "579F39E86B98900179C06E9A07BE7C7B")

    public static final int AXIS_TILT = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "70021A9C7A753DA59C64F0581D83C67B", hash_generated_field = "2C24AD3C3E56DD84D0733A0B91218D75")

    public static final int AXIS_GENERIC_1 = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "DE2D083AFBB03257E89BDA922D0E4CAD", hash_generated_field = "D5EDF8D95D30F8707CB60CE48E5D080D")

    public static final int AXIS_GENERIC_2 = 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "9FEFCC69BCFDFC864584838013FE5B46", hash_generated_field = "0FB2B7871027C51D19E6ADDB6629599D")

    public static final int AXIS_GENERIC_3 = 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "9243522AF86AC2FA928B71B7E668CC47", hash_generated_field = "B3834C6A5E7EAC276B34400E316CC889")

    public static final int AXIS_GENERIC_4 = 35;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "F0A6A5F912965A4325BA778B910D6E59", hash_generated_field = "D771A2C8BF7E6631141C9F156725F986")

    public static final int AXIS_GENERIC_5 = 36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "23CC53509B48EF6225466AC21958D6F4", hash_generated_field = "5ADBF1379367815D17640566262ADBDC")

    public static final int AXIS_GENERIC_6 = 37;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "312922167BECA1728E0C8042C725C6BC", hash_generated_field = "CABE9E3D1339B834B58E2AC551B60D70")

    public static final int AXIS_GENERIC_7 = 38;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.780 -0400", hash_original_field = "9FCFEF7D88A4651EAE19D026F4636885", hash_generated_field = "783DFA0925833D6927778A6752C33469")

    public static final int AXIS_GENERIC_8 = 39;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.781 -0400", hash_original_field = "D2142F81309B4EC8E625175D39A4E1F0", hash_generated_field = "844B22BFFE980B1170B8E78B193CD8F8")

    public static final int AXIS_GENERIC_9 = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.781 -0400", hash_original_field = "7575EC92A58C3C2DC2C8CCC553B15C0D", hash_generated_field = "F52491FA1506F81B61F5BBCAD317F2D4")

    public static final int AXIS_GENERIC_10 = 41;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.781 -0400", hash_original_field = "89BA0631B47758FC05670AE71E07238B", hash_generated_field = "441A2A8984D04F945C0B9706F4D91238")

    public static final int AXIS_GENERIC_11 = 42;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.781 -0400", hash_original_field = "898A18C6347222CD54AF74A9ECCCEE58", hash_generated_field = "6EE9D87F1B155C3A9E15C5BFB57DB156")

    public static final int AXIS_GENERIC_12 = 43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.781 -0400", hash_original_field = "B97F163EE5AB936FB897D250305FDD0F", hash_generated_field = "0C980E1F71AC4BD10A6D1136200C35B1")

    public static final int AXIS_GENERIC_13 = 44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.781 -0400", hash_original_field = "5C89506ADEC1D512A306F0807528A45C", hash_generated_field = "08EDA9B50DF874F18FD4A782BFF79258")

    public static final int AXIS_GENERIC_14 = 45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.781 -0400", hash_original_field = "7EB5AA2C6AC2C895F916E91C7C27BF6D", hash_generated_field = "9B7002F98DD35624F49E82F9F27BEA43")

    public static final int AXIS_GENERIC_15 = 46;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.781 -0400", hash_original_field = "42B8B524D844DB897F8E010F49DF34D9", hash_generated_field = "CDB6932C5544664A6FAAE7570CEF1ED8")

    public static final int AXIS_GENERIC_16 = 47;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.782 -0400", hash_original_field = "530A0FA730B9B28A10F6D39E022E143B", hash_generated_field = "D7255FFCEB95B730B4650447F2F79527")

    private static SparseArray<String> AXIS_SYMBOLIC_NAMES = new SparseArray<String>();
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.782 -0400", hash_original_field = "AA456FB196DE0D5C68D5DA0ABB2B1665", hash_generated_field = "ADA948F0304197BC40CACAE24C6ECB05")

    public static final int BUTTON_PRIMARY = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.782 -0400", hash_original_field = "9CDE7875F922E491FF1696F779D48BD9", hash_generated_field = "699964DE06376B73FD25E1C2E308AF7B")

    public static final int BUTTON_SECONDARY = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.782 -0400", hash_original_field = "95C57E1DA2F91AA9F277DFEB59325C0F", hash_generated_field = "0EFC57E0035C368753C281B7448CCAD7")

    public static final int BUTTON_TERTIARY = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.782 -0400", hash_original_field = "87ED530C352322D1000AED214027E0E0", hash_generated_field = "5A526B3B078557E38DB5D4C91419279E")

    public static final int BUTTON_BACK = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.782 -0400", hash_original_field = "02CD6CBC72EC09DBD9089D39090DEFFF", hash_generated_field = "4E2DD22E6782E832F99D62265E33DC7B")

    public static final int BUTTON_FORWARD = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.782 -0400", hash_original_field = "9C9A5C3B4382C6FBD48D16D607582F30", hash_generated_field = "589F50C08C72221D9705F2ECA4BA4117")

    private static String[] BUTTON_SYMBOLIC_NAMES = new String[] {
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.784 -0400", hash_original_field = "D7697B822D45F5BDF64FF3656AE39897", hash_generated_field = "B997CD436D37980DF5D7404E593DC402")

    public static final int TOOL_TYPE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.784 -0400", hash_original_field = "DDF16792C91BD89ED3CEB72B2F655A3A", hash_generated_field = "C864443B9D1FDB0CC8BE96AE33701299")

    public static final int TOOL_TYPE_FINGER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.784 -0400", hash_original_field = "FD13CF4F11329C29AEA3974918542E2A", hash_generated_field = "5BBE29494AB919D60EB460BF7FABACCD")

    public static final int TOOL_TYPE_STYLUS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "EDA620D7300731B22711740B56121B0F", hash_generated_field = "4F5A6CDBC3D361EDE9CAD667AC25320F")

    public static final int TOOL_TYPE_MOUSE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "E8E4790D94F06E7A95BA1EC847CFA0F9", hash_generated_field = "09C1A33B09293914694BF2A3886AC6DB")

    public static final int TOOL_TYPE_ERASER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "E4532CF792A1279111A19DAB2ADAADBA", hash_generated_field = "0718FB5B633B41C6042A429EFE7AA01B")

    private static SparseArray<String> TOOL_TYPE_SYMBOLIC_NAMES = new SparseArray<String>();
    static {
        SparseArray<String> names = TOOL_TYPE_SYMBOLIC_NAMES;
        names.append(TOOL_TYPE_UNKNOWN, "TOOL_TYPE_UNKNOWN");
        names.append(TOOL_TYPE_FINGER, "TOOL_TYPE_FINGER");
        names.append(TOOL_TYPE_STYLUS, "TOOL_TYPE_STYLUS");
        names.append(TOOL_TYPE_MOUSE, "TOOL_TYPE_MOUSE");
        names.append(TOOL_TYPE_ERASER, "TOOL_TYPE_ERASER");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "9319C0C1DC56FFF2B6175EA6D9D0FA3B", hash_generated_field = "EAE9F462EA0CEE89BDB5341CE883C76C")

    private static int HISTORY_CURRENT = -0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "4E0EEF34DE1E78AC4C7D48E7B28D3753", hash_generated_field = "A5933E4A5F04D439547A00DBB4EA1918")

    private static int MAX_RECYCLED = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "79F53341661E7BAB58D441DAC7E61782", hash_generated_field = "BEC139CF931DD3E1019AC5E24E19DEE9")

    private static Object gRecyclerLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "62CB28CE8AC6DBF69FB484B561C6DE93", hash_generated_field = "695DE00CD65E15FE07938D99F2CA2696")

    private static int gRecyclerUsed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "7BA7389C24C0F124608D5C2226AD35F9", hash_generated_field = "E9FD3DB4A4C51C360253148C4F1C8508")

    private static MotionEvent gRecyclerTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "7CC0A11C5494EABD208B60B4042F676B", hash_generated_field = "8C08D7000BCA0FCBC934A38AB3535BA2")

    private static Object gSharedTempLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "7ACA3B441BEC8C942E34BE426D1BD777", hash_generated_field = "1C70655B0F01405596723D256AD5AE2B")

    private static PointerCoords[] gSharedTempPointerCoords;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "909596135E37414184F98BA28ABF7B47", hash_generated_field = "7767E5DED892F800315C4BF8ECA945E5")

    private static PointerProperties[] gSharedTempPointerProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "7D5CE052D163BC3BEA8C336A1127A9FA", hash_generated_field = "A9BB8E94115BE6A30724987AE7313B53")

    private static int[] gSharedTempPointerIndexMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:49.790 -0400", hash_original_field = "92338855F3FDCA2FD9317526465F4D98", hash_generated_field = "C140DAE13300F0DB81E6D0FF25B21CC4")

    public static final Parcelable.Creator<MotionEvent> CREATOR
            = new Parcelable.Creator<MotionEvent>() {
        public MotionEvent createFromParcel(Parcel in) {
            in.readInt(); 
            return MotionEvent.createFromParcelBody(in);
        }

        public MotionEvent[] newArray(int size) {
            return new MotionEvent[size];
        }
    };
}

