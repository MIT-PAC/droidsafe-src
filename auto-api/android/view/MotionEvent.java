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
    private int mNativePtr;
    private MotionEvent mNext;
    private RuntimeException mRecycledLocation;
    private boolean mRecycled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.196 -0400", hash_original_method = "B1B69F583261D8BEEC921FF43580AA66", hash_generated_method = "40B8D4E791D456515D6D7EBB1643CE79")
    @DSModeled(DSC.SAFE)
    private MotionEvent() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.201 -0400", hash_original_method = "3F0B5C050D986DD9F1F0F2A742C616C8", hash_generated_method = "B421B42F481E4C5401D1FD9631DD22BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.202 -0400", hash_original_method = "78DE11FBBF58608981D1F74EEB443B54", hash_generated_method = "CDAFFC0C87614F6DCBC53442BA424E7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public MotionEvent copy() {
        MotionEvent var3FF1A9B3CCF4C4B5A71D5E31BC77BEB8_320619969 = (obtain(this));
        return (MotionEvent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return obtain(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.203 -0400", hash_original_method = "187F7D3A42078A42C8212C3EFE0E8B16", hash_generated_method = "19A0195F7D24E2E1074AAA3598A0B444")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.203 -0400", hash_original_method = "A082C8E505553F853E56AAFC11CF0CDA", hash_generated_method = "2600D7008D26F0DCB232F25BC434B502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void scale(float scale) {
        dsTaint.addTaint(scale);
        nativeScale(mNativePtr, scale);
        // ---------- Original Method ----------
        //nativeScale(mNativePtr, scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.203 -0400", hash_original_method = "E51EA2AB032E4C79CC226174E2601818", hash_generated_method = "BEC9C7B6F8D482816AFEA6F78EFA685F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int getDeviceId() {
        int varF3B3D3917F994FE161C0ABB4D3E565B5_1352938420 = (nativeGetDeviceId(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetDeviceId(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.203 -0400", hash_original_method = "44501F684180CAB98F3511C2614C7994", hash_generated_method = "389F853DA0A544306D6C7D2B797A5F53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int getSource() {
        int var626B65A92B0E4AF71704C1098173596F_1136444408 = (nativeGetSource(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetSource(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.203 -0400", hash_original_method = "1502AF3F26B6DD95879512031D9FB73E", hash_generated_method = "5F1DBFB8415D965B377743949E5A7CCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final void setSource(int source) {
        dsTaint.addTaint(source);
        nativeSetSource(mNativePtr, source);
        // ---------- Original Method ----------
        //nativeSetSource(mNativePtr, source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.204 -0400", hash_original_method = "FA5880EB8F61D955AC5922ACE620FCE2", hash_generated_method = "480043107F391A82A6B5457B292525F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getAction() {
        int var74B8A914B86C4917D117B6A52D32C79D_786490625 = (nativeGetAction(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetAction(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.204 -0400", hash_original_method = "268411790684740D49A019DF59E1FFBB", hash_generated_method = "FA6881EF9D27BDCC720D4782ADEAD3A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getActionMasked() {
        int var119771AD723EE5854F55019431496A74_409659971 = (nativeGetAction(mNativePtr) & ACTION_MASK);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetAction(mNativePtr) & ACTION_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.204 -0400", hash_original_method = "464EE1689B645958C6F5E17990D5ECA4", hash_generated_method = "846500ED89AF24AD765BA27E3202DD8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getActionIndex() {
        int var853FB894ACCBEFFE5F8E24DD3377AFAF_1945002605 = ((nativeGetAction(mNativePtr) & ACTION_POINTER_INDEX_MASK)
                >> ACTION_POINTER_INDEX_SHIFT);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (nativeGetAction(mNativePtr) & ACTION_POINTER_INDEX_MASK)
                //>> ACTION_POINTER_INDEX_SHIFT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.204 -0400", hash_original_method = "3A9CDEA51D903248E7ACBBA8C3F57155", hash_generated_method = "19FF75665E4DAF6F2EBABB68200DD6CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isTouchEvent() {
        boolean var12F7F7B53A02590E12DD99382B4D1A89_696722558 = (nativeIsTouchEvent(mNativePtr));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeIsTouchEvent(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.204 -0400", hash_original_method = "A25E485C356A262F519C0A5841CFA47B", hash_generated_method = "D0A1482AD45544A6E9207CDC5D67BDDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getFlags() {
        int var31A262589A0563B992AF6C13BB445DA6_465729451 = (nativeGetFlags(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetFlags(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.204 -0400", hash_original_method = "24A8A0C0077001C335E0B5C917301FE4", hash_generated_method = "D3B8744BF2755CC13FF34CC0828CED80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final boolean isTainted() {
        int flags;
        flags = getFlags();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int flags = getFlags();
        //return (flags & FLAG_TAINTED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.204 -0400", hash_original_method = "96C1138F844BE852B50B0529E539E061", hash_generated_method = "408801D52CA35470A1DA4D94FC012B9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final void setTainted(boolean tainted) {
        dsTaint.addTaint(tainted);
        int flags;
        flags = getFlags();
        nativeSetFlags(mNativePtr, tainted ? flags | FLAG_TAINTED : flags & ~FLAG_TAINTED);
        // ---------- Original Method ----------
        //final int flags = getFlags();
        //nativeSetFlags(mNativePtr, tainted ? flags | FLAG_TAINTED : flags & ~FLAG_TAINTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.205 -0400", hash_original_method = "5F4C05CD4E223E38846D15A6EA0DF305", hash_generated_method = "E37DF29A585F88B9162701510570AE2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getDownTime() {
        long varA7AEBDC62AD9E48221ED001FAEE4896D_941720289 = (nativeGetDownTimeNanos(mNativePtr) / NS_PER_MS);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return nativeGetDownTimeNanos(mNativePtr) / NS_PER_MS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.205 -0400", hash_original_method = "97B3432DE604A4A8C3339017F5056697", hash_generated_method = "9FE2C9154BCC468E3E93F203E59F88EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setDownTime(long downTime) {
        dsTaint.addTaint(downTime);
        nativeSetDownTimeNanos(mNativePtr, downTime * NS_PER_MS);
        // ---------- Original Method ----------
        //nativeSetDownTimeNanos(mNativePtr, downTime * NS_PER_MS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.205 -0400", hash_original_method = "CCF6A1C7FFBA398090457272FB07E7C9", hash_generated_method = "AA307A1A018F4A7E87CA1D622DE27A5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getEventTime() {
        long varABD7EED75F03AC822986337AA0AEBA8E_28760320 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT) / NS_PER_MS);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT) / NS_PER_MS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.205 -0400", hash_original_method = "9EB1FC24DA069289850F91A3F8734D9A", hash_generated_method = "8E811DC797210C5B25677BC16FE6E639")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getEventTimeNano() {
        long var9177F0DF4886BA63EBD71602211F864C_654276742 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.205 -0400", hash_original_method = "4BF6642E766343B332FD98949BC6C582", hash_generated_method = "70267637038BAB68DE301ED792251A6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getX() {
        float var66044244940F058BEDF52F995ECDF659_1508331225 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.205 -0400", hash_original_method = "91A63DEAB3A8AC7438EA04466792BD82", hash_generated_method = "2048097293A457F2FF51FE6CE8C80E79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getY() {
        float varC75AFE4F07E18DED73B6E9A135DBAA24_101656924 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.206 -0400", hash_original_method = "6675B94FFDE5461AE8829AF0934758CB", hash_generated_method = "B4A6595B456155061F92597D69B462FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getPressure() {
        float varEF9A2F87450786CEB865F6DB8CC3ECFD_167138762 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.206 -0400", hash_original_method = "04BA234B263118C319F9FB3039E4C966", hash_generated_method = "9E5E45E74F138ED5E01252BBE74CF99D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getSize() {
        float varDFF5D0290CDD1A07C8B97F2F6E962921_86265984 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.206 -0400", hash_original_method = "7EDCA08C9EC8F904EE9855CC249509CB", hash_generated_method = "FE68525E4BFA0B42BE6E31AAA1511983")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getTouchMajor() {
        float var2C0DAF19E2431B7454CC6F77C73821E0_1967497659 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.206 -0400", hash_original_method = "0D1B5526DE02F52B1563B7D7F6F58090", hash_generated_method = "55ABBBF47076C4B684E43644755D65E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getTouchMinor() {
        float var4508F4DDA7AD6F23C2A12D53FC2B6353_2085357487 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.206 -0400", hash_original_method = "88DA06A5CC2E8F8456F3789E8A68ED44", hash_generated_method = "272CB261803A34CFA202ADF188A68FDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getToolMajor() {
        float varC9DDB5D5521C8A6BB646AB1BF9C7D9E2_599091781 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.206 -0400", hash_original_method = "68541C2106990EEA679DCE03A62D7FCC", hash_generated_method = "F2806C10319F6635994B0A21227A2215")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getToolMinor() {
        float var695C0E240E818E6BDB2EBB725DE208C8_1879689083 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.207 -0400", hash_original_method = "6DB87F8256212E2B4D49883D1C47D372", hash_generated_method = "092DD11B86352529C259840077EF9F1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getOrientation() {
        float var75B1DB96187E89974E64BC0FB38B1FEF_1206545945 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.207 -0400", hash_original_method = "630AA047225B25427528E4D32F567B17", hash_generated_method = "EB47340637A9EAACFC3F94AA4BCFE6E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getAxisValue(int axis) {
        dsTaint.addTaint(axis);
        float var4FF16B9B17710DEACD9EEA98B643B740_685964751 = (nativeGetAxisValue(mNativePtr, axis, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.207 -0400", hash_original_method = "2050CCC0293D52B162C880AD9BC3C6F6", hash_generated_method = "910BDCA5D59AB1BD4DE7DCE5072F3970")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getPointerCount() {
        int var5ACA797B73271718F08C07B0FD1465C3_1667943761 = (nativeGetPointerCount(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetPointerCount(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.207 -0400", hash_original_method = "43D465AFB7AC0153BC6ACD556C5FF613", hash_generated_method = "D2109B845B07C43C8EEAF6D2DB903EA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getPointerId(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        int var17A8C53C4A6DAF94DA4FE0E64E276DEB_875412145 = (nativeGetPointerId(mNativePtr, pointerIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetPointerId(mNativePtr, pointerIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.207 -0400", hash_original_method = "4F4E823E6A973C2A4D85C86C0A6A2D9D", hash_generated_method = "EACEEC4931FD09913F5BEA010D6E46DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getToolType(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        int var705074F16347B844E833B41BDB330DC5_520366392 = (nativeGetToolType(mNativePtr, pointerIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetToolType(mNativePtr, pointerIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.207 -0400", hash_original_method = "396B4C03ADE41E49E928286EB7438AA9", hash_generated_method = "8A416CE72AEED10552C4313AE1423B0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int findPointerIndex(int pointerId) {
        dsTaint.addTaint(pointerId);
        int varCF3227509A91EFEBFB983EC37BCBBB09_279789743 = (nativeFindPointerIndex(mNativePtr, pointerId));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeFindPointerIndex(mNativePtr, pointerId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.207 -0400", hash_original_method = "13E56CEAC1D2714A9A1790EF5117F935", hash_generated_method = "20DF6B406C71B48448E8D335AAECAE82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getX(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float var22607ACD4999ED3178C2C16BA32F39FA_2084433432 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.208 -0400", hash_original_method = "9A0C47F653E064961B232F3274CD29C9", hash_generated_method = "EC6048C4A0FCDFAC6D98783EFB412D12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getY(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varEC964DA0D0FCB932F45F9605581B800C_1486161288 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.208 -0400", hash_original_method = "36E2BAC74F4F826870F428D93CA1D371", hash_generated_method = "D80AC5F10E626E784B03755A24B39F41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getPressure(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varDB60B99C5EF7895E6B92B91772C5962E_218742544 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.208 -0400", hash_original_method = "50DE00A69645B3335E8383A50AB1EB05", hash_generated_method = "2793024E1B1341D6A624618EA4113BFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getSize(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varB4E63BA449D57F4253A0AB8919D42D10_976603147 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.208 -0400", hash_original_method = "28BED69B39230D6E2E593658DA262948", hash_generated_method = "4C443AD162B351F2E989E95DDFFFE587")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getTouchMajor(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varA24CED3D0F358E3C65B964973B4F5F83_383515552 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.208 -0400", hash_original_method = "2C1FBE2BFEFC6BD6A6EFC25F55DD94B0", hash_generated_method = "F6E43F7B0E0DEA5C85A16C39BA921533")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getTouchMinor(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float var120D3EDA1AEC95857772396D3ADDF431_1485534955 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.208 -0400", hash_original_method = "66B849A9DC257EF38185AFB935434C46", hash_generated_method = "361D292D4C2082AF06B665A9F40BBD76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getToolMajor(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varE1A0953AB1720A635D0A001029F15F98_911762701 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.209 -0400", hash_original_method = "F39564D767A71A1EAACBC920B100E436", hash_generated_method = "213DAEA700775AF24195D0F61545CAD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getToolMinor(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varC32F5653C2BD206ECB16EB3579C5B644_2026200409 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.209 -0400", hash_original_method = "A9038F286A5A1470BB26B4145360A2CC", hash_generated_method = "9386C93E4B507790AD050467B0845A07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getOrientation(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float var865B68C13F122391AB0E054D3314ED41_846040753 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.209 -0400", hash_original_method = "3434CDF166CDB98F83BC4BA0F4722E7E", hash_generated_method = "00F3D78B4919D0481A326F924922B446")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getAxisValue(int axis, int pointerIndex) {
        dsTaint.addTaint(axis);
        dsTaint.addTaint(pointerIndex);
        float varDC8E493A6FB2EE0C0CB23BC5DBBC02F1_1615208266 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.209 -0400", hash_original_method = "33DE471947CC053A5003BB5AAC41F910", hash_generated_method = "AC847B482E3AA50E6279C90A4672A744")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void getPointerCoords(int pointerIndex, PointerCoords outPointerCoords) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(outPointerCoords.dsTaint);
        nativeGetPointerCoords(mNativePtr, pointerIndex, HISTORY_CURRENT, outPointerCoords);
        // ---------- Original Method ----------
        //nativeGetPointerCoords(mNativePtr, pointerIndex, HISTORY_CURRENT, outPointerCoords);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.209 -0400", hash_original_method = "FC8907B12AF62543F5FA0564EA522E62", hash_generated_method = "EFB5B476F5BD1ACFA0E1BE3B26AB6E82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void getPointerProperties(int pointerIndex,
            PointerProperties outPointerProperties) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(outPointerProperties.dsTaint);
        nativeGetPointerProperties(mNativePtr, pointerIndex, outPointerProperties);
        // ---------- Original Method ----------
        //nativeGetPointerProperties(mNativePtr, pointerIndex, outPointerProperties);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.210 -0400", hash_original_method = "38A68962B5CFD92D43EE16A436EABCF2", hash_generated_method = "7FBECE27F300DA8BCE9A70C34B2C865E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getMetaState() {
        int var2EB518F4D6071C6F350D1D5C097F88FF_829074157 = (nativeGetMetaState(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetMetaState(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.210 -0400", hash_original_method = "C8458CE15D5B2817F47A4FD377CE1968", hash_generated_method = "5C174866F8425980D5FD0F08BE09448C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getButtonState() {
        int var6E0173150D4C4630052CCF82C8F7DC9F_1208594666 = (nativeGetButtonState(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetButtonState(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.210 -0400", hash_original_method = "6E457CC599C66DF6B9AC57A3DF3B8E7E", hash_generated_method = "C74437E7EDAFE081200EE39CA2288BA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getRawX() {
        float var78851251BB2BADD4A73F875B41E82C95_30405064 = (nativeGetRawAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetRawAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.210 -0400", hash_original_method = "C18C1837908CE668DE325D32328DA600", hash_generated_method = "12F72168DE5F1BD8D43A4099B957A425")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getRawY() {
        float varB2F71D566D9DFEDA8765CB859668364C_1130652450 = (nativeGetRawAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetRawAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.210 -0400", hash_original_method = "32503B0D7203271814D12FFB8906664F", hash_generated_method = "9081BB08EEFC8B03D23C0AA90EDABC41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getXPrecision() {
        float var8C63D112819BF4307BFC05C55813CC7C_826389699 = (nativeGetXPrecision(mNativePtr));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetXPrecision(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.210 -0400", hash_original_method = "77B44C5CFF493101D20AF55AA249AFB4", hash_generated_method = "9DC15E78D453532E7E490837E6137E7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getYPrecision() {
        float var2DA4AA757DDFF641DBCEE9F2CC39A8B1_1534823151 = (nativeGetYPrecision(mNativePtr));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetYPrecision(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.210 -0400", hash_original_method = "B4D273F4D2084C890DE19B631E3ED869", hash_generated_method = "428A18C0554D38D45760E8EC80853212")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getHistorySize() {
        int var42FF49C139613133CE8AAF262A0781C4_1683838539 = (nativeGetHistorySize(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetHistorySize(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.211 -0400", hash_original_method = "4F37DFE9294EB232F86D1F83C2ADDC74", hash_generated_method = "C2ACE0845470FC8F3D9BC6213F73AD4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getHistoricalEventTime(int pos) {
        dsTaint.addTaint(pos);
        long var86B3FEF5B6798FC4F49A53A44960DD31_723576325 = (nativeGetEventTimeNanos(mNativePtr, pos) / NS_PER_MS);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, pos) / NS_PER_MS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.211 -0400", hash_original_method = "52641DCD8C1505610834B8CDD1492B06", hash_generated_method = "5491818A01172C695E324F1B07B2A643")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalX(int pos) {
        dsTaint.addTaint(pos);
        float varD6254ED09F523E7C1E53ADA626DF0C10_1039192836 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.211 -0400", hash_original_method = "456D8725235AB4DBC45E47B4ADD23013", hash_generated_method = "3E6081D2D503A4871FA466B8D11EBD00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalY(int pos) {
        dsTaint.addTaint(pos);
        float varF753E500532420F185A79C4FC58F3F0B_1811548161 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.211 -0400", hash_original_method = "E822398D8AD69E2A637D6F0BC07F61D8", hash_generated_method = "CD6E1A97168A0E48CF9D75CEF1BDD503")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalPressure(int pos) {
        dsTaint.addTaint(pos);
        float var8CCA0683C3AD89698B4BB2DCB56AF6E0_544324234 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.211 -0400", hash_original_method = "A43A8374A73078EDB84358D609B2C354", hash_generated_method = "6CCD7029490443695BA5D33E6B51CF72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalSize(int pos) {
        dsTaint.addTaint(pos);
        float varA2CCAFC013471427EED1D8795B79DF34_403214706 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.211 -0400", hash_original_method = "192AC6C55C0D7020BB0EA3AE5DE4FD65", hash_generated_method = "B0B8EC96B4A2A2E8E803B44111E1A132")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalTouchMajor(int pos) {
        dsTaint.addTaint(pos);
        float var8E7AD2DB9688820EB8F0B7CB347E27F7_1654131292 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.212 -0400", hash_original_method = "122C0ECAA119AC26B3F087E871FFA312", hash_generated_method = "A6C5DBB10F32B941D6341C23AFD51F6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalTouchMinor(int pos) {
        dsTaint.addTaint(pos);
        float var47136F660FFE6DBB3965B94BCAC103FF_1524383285 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.212 -0400", hash_original_method = "8097CEA35B3273816C6109CC76A9BC74", hash_generated_method = "5668652CE12EDE690D3795D1AF4F7F21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalToolMajor(int pos) {
        dsTaint.addTaint(pos);
        float varACE33102325AC5113F663D281165CB12_1866720313 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.212 -0400", hash_original_method = "E0365AAE3D6BF704A796F5D4E7964FB9", hash_generated_method = "D3CEF13FB9B63AAA9F2097DAE4C935F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalToolMinor(int pos) {
        dsTaint.addTaint(pos);
        float varBDFEBFC87FD2C86C951881656D01FBFE_794326714 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.212 -0400", hash_original_method = "DC8FCE9CD404D08D0BFF0CC77CEE87C1", hash_generated_method = "31A516461F146C00F43E647EEB6B3448")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalOrientation(int pos) {
        dsTaint.addTaint(pos);
        float var9ABC98E782A3870F9AA5DFC3F27D891C_276473432 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.212 -0400", hash_original_method = "697532A0192D8868F2E3AE618301BF20", hash_generated_method = "CE53F9A3C2CF5ED8DBCD3589DF7113EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalAxisValue(int axis, int pos) {
        dsTaint.addTaint(axis);
        dsTaint.addTaint(pos);
        float varE580B6B92EAD96F426B34B55A944EC3F_155922381 = (nativeGetAxisValue(mNativePtr, axis, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.213 -0400", hash_original_method = "8BFA09569623FF1F941D2134C3D47F02", hash_generated_method = "5850A88EC113E6907B3AE8F9D98CD68D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalX(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var70F4D2CDA260BE637BE2F366621D1047_403003036 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.213 -0400", hash_original_method = "9787FE8A43AC5153EC8D7EC463FC985B", hash_generated_method = "72374BC1BEAE2FE88744F4D0178B43F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalY(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var4338B7951F95F5B1B66FDB2F4DC27413_1346817747 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.213 -0400", hash_original_method = "A8F703E0BCBA29F53C62C25AACD436ED", hash_generated_method = "1E0282AE1A3698233EA93BF17CEF6CED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalPressure(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var599EE82AA7EED666174FF6603E5D9EDB_1533282496 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.213 -0400", hash_original_method = "66A9DA10859CF6933D658F61BE53F70F", hash_generated_method = "890C72F31719AFBF62A44A178BA9BB22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalSize(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var6ADB36223580AAF1DF6650FEF9BEFE5F_434188149 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.213 -0400", hash_original_method = "38D72D2E0F00AE5C39667CDDD41B271D", hash_generated_method = "AF6614EE89F19F6F64CBCB2435692702")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalTouchMajor(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var04576CC24CDC939EA1B84F18BA4AA27C_2121701401 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.213 -0400", hash_original_method = "F3D94A1F01A3ECEF6DEDEA9361640BF9", hash_generated_method = "A3F7555E908637DDDFA2EDCA3812F5D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalTouchMinor(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float varE0E8C51F7817613AD2DBA52263E38B64_2036490817 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.214 -0400", hash_original_method = "78FB77773CB43A5420D0F24849B540AD", hash_generated_method = "A7C7FFC07BD5CDF1B7801809777B4EE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalToolMajor(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var40EEA85674FBE73ABF2A2BD2F2E74CD6_794116215 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.214 -0400", hash_original_method = "4AB7745853006A3796DAD0E637CCA598", hash_generated_method = "69FA82BF1A20C1460314CAC732871636")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalToolMinor(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var784F21A01E3CEC7D68998B91D48C129C_935778657 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.214 -0400", hash_original_method = "160C0106DB8A4C6FBAA9569ABA0D68E8", hash_generated_method = "2D86BF5E39B65B903E6924CB07179192")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalOrientation(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var02FA0A42AAD0F907D9EB0C172EDB6AB4_1583711567 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.214 -0400", hash_original_method = "F645AABE3B2CF14D2790BA051F9F3FF1", hash_generated_method = "9782B065E495E7008DDC5DAB4184AAEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalAxisValue(int axis, int pointerIndex, int pos) {
        dsTaint.addTaint(axis);
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var675E97582C752387B4365682C4F7B0FA_463210455 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.214 -0400", hash_original_method = "D80ADCD256759644414D5CBEC3C57D0B", hash_generated_method = "E86BEC1093E3645D6B587BA707C423ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void getHistoricalPointerCoords(int pointerIndex, int pos,
            PointerCoords outPointerCoords) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(outPointerCoords.dsTaint);
        dsTaint.addTaint(pos);
        nativeGetPointerCoords(mNativePtr, pointerIndex, pos, outPointerCoords);
        // ---------- Original Method ----------
        //nativeGetPointerCoords(mNativePtr, pointerIndex, pos, outPointerCoords);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.215 -0400", hash_original_method = "26EA400A9751805DFF1D4CEEB005645B", hash_generated_method = "DA8DDA39E55EADFF4681BD50450B72F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getEdgeFlags() {
        int var0FC0D903F55D3C457853DAA4F228A5D4_1078067178 = (nativeGetEdgeFlags(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetEdgeFlags(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.215 -0400", hash_original_method = "348B6A1C5666102E94291FA4791C249A", hash_generated_method = "4A2A2D47875BBB24B9DA909D863CBB76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setEdgeFlags(int flags) {
        dsTaint.addTaint(flags);
        nativeSetEdgeFlags(mNativePtr, flags);
        // ---------- Original Method ----------
        //nativeSetEdgeFlags(mNativePtr, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.215 -0400", hash_original_method = "34CE363FC32882BC3BBCF2E8ABF2B5B0", hash_generated_method = "5CC4986D62C264C4F52CBC5839AB1DDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setAction(int action) {
        dsTaint.addTaint(action);
        nativeSetAction(mNativePtr, action);
        // ---------- Original Method ----------
        //nativeSetAction(mNativePtr, action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.215 -0400", hash_original_method = "117CE161431F2ECDED077AD7F7467ADD", hash_generated_method = "517F541B89AA31CB390EF25B69368803")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void offsetLocation(float deltaX, float deltaY) {
        dsTaint.addTaint(deltaX);
        dsTaint.addTaint(deltaY);
        nativeOffsetLocation(mNativePtr, deltaX, deltaY);
        // ---------- Original Method ----------
        //nativeOffsetLocation(mNativePtr, deltaX, deltaY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.215 -0400", hash_original_method = "D9D9F7662138ADF2F9591F7DFAEB3F74", hash_generated_method = "36CB05CC0F4AB1ECA757BC15F23D6DFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setLocation(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        float oldX;
        oldX = getX();
        float oldY;
        oldY = getY();
        nativeOffsetLocation(mNativePtr, x - oldX, y - oldY);
        // ---------- Original Method ----------
        //float oldX = getX();
        //float oldY = getY();
        //nativeOffsetLocation(mNativePtr, x - oldX, y - oldY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.215 -0400", hash_original_method = "622D19544C973DA41E1BE7D7819B5A41", hash_generated_method = "DE46627C29A95060CBC8AEE83E5C42CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void transform(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("matrix must not be null");
        } //End block
        nativeTransform(mNativePtr, matrix);
        // ---------- Original Method ----------
        //if (matrix == null) {
            //throw new IllegalArgumentException("matrix must not be null");
        //}
        //nativeTransform(mNativePtr, matrix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.216 -0400", hash_original_method = "F001981BC7F115C74B7EB0136965714D", hash_generated_method = "4021C756D71003F8842BF6DD26472825")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void addBatch(long eventTime, float x, float y,
            float pressure, float size, int metaState) {
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(pressure);
        dsTaint.addTaint(eventTime);
        dsTaint.addTaint(y);
        dsTaint.addTaint(size);
        dsTaint.addTaint(x);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.216 -0400", hash_original_method = "06E22018450E3E0892CD70DE9E19F211", hash_generated_method = "4BE514FB70887235F744CE5F04B97120")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void addBatch(long eventTime, PointerCoords[] pointerCoords, int metaState) {
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(pointerCoords[0].dsTaint);
        dsTaint.addTaint(eventTime);
        nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pointerCoords, metaState);
        // ---------- Original Method ----------
        //nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pointerCoords, metaState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.216 -0400", hash_original_method = "542474DD15BDDADB068A65C6A3EEA8E2", hash_generated_method = "18881386B34768F3730753B4576D9C43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isWithinBoundsNoHistory(float left, float top,
            float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.217 -0400", hash_original_method = "C00E6E79D43678980DA0F4144A65F6A2", hash_generated_method = "EE4BDA0177ACD1E7437F8219A2E6A690")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final MotionEvent clampNoHistory(float left, float top, float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
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
        } //End block
        return (MotionEvent)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.217 -0400", hash_original_method = "FBF170B15B2FFBEE1AB1D4E32A8773CA", hash_generated_method = "1E64F701C87BA1985994ECEAEFA8E739")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int idBits = 0;
        //final int pointerCount = nativeGetPointerCount(mNativePtr);
        //for (int i = 0; i < pointerCount; i++) {
            //idBits |= 1 << nativeGetPointerId(mNativePtr, i);
        //}
        //return idBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.220 -0400", hash_original_method = "4F0FF8B26009CA9D26EE500AEFE507EC", hash_generated_method = "99EDC892658046E45B0B47AC1BDF5E39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final MotionEvent split(int idBits) {
        dsTaint.addTaint(idBits);
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
        } //End block
        return (MotionEvent)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.221 -0400", hash_original_method = "69A985781D7A79E036178DEB42E5F1F0", hash_generated_method = "7737DB5AB70174FBCD1A6A328F203A19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
        String varDF7768E9135E0359312ABB41620E333A_1294636810 = (msg.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.222 -0400", hash_original_method = "D732CA58C71ED959C0E1A12C336FC80D", hash_generated_method = "907355DDE0606243FE09892998E17AF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeInt(PARCEL_TOKEN_MOTION_EVENT);
        nativeWriteToParcel(mNativePtr, out);
        // ---------- Original Method ----------
        //out.writeInt(PARCEL_TOKEN_MOTION_EVENT);
        //nativeWriteToParcel(mNativePtr, out);
    }

    
    public static final class PointerCoords {
        private long mPackedAxisBits;
        private float[] mPackedAxisValues;
        public float x;
        public float y;
        public float pressure;
        public float size;
        public float touchMajor;
        public float touchMinor;
        public float toolMajor;
        public float toolMinor;
        public float orientation;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.223 -0400", hash_original_method = "30C014872AED120D5788F672204C6D56", hash_generated_method = "02D472FB06CC6A49D31A045DF0321860")
        @DSModeled(DSC.SAFE)
        public PointerCoords() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.223 -0400", hash_original_method = "4C1A041805DDE756B7430BBCF7A4A54D", hash_generated_method = "7F1D88911186A8556F37D9410CC36ADC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PointerCoords(PointerCoords other) {
            dsTaint.addTaint(other.dsTaint);
            copyFrom(other);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.223 -0400", hash_original_method = "5B10C041062144B27347C9202A1953B2", hash_generated_method = "85A3A31EE556A4BEA00BDAAD4B198A1A")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.224 -0400", hash_original_method = "A2C68F8615572C95C5947791A8CC8026", hash_generated_method = "96992B8481E7E1FAB70D94C9CAA4E463")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void copyFrom(PointerCoords other) {
            dsTaint.addTaint(other.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.224 -0400", hash_original_method = "566631CFDB34A411EF93513211D62594", hash_generated_method = "BB49EBFA38D861DF19A72743FD64C79C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public float getAxisValue(int axis) {
            dsTaint.addTaint(axis);
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
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.224 -0400", hash_original_method = "55E9DEFA01615304E1434A1FAB8328FA", hash_generated_method = "D7A6CA9DED7EA31F4D8304E1DB54EEC6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setAxisValue(int axis, float value) {
            dsTaint.addTaint(axis);
            dsTaint.addTaint(value);
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final int INITIAL_PACKED_AXIS_VALUES = 8;
    }


    
    public static final class PointerProperties {
        public int id;
        public int toolType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.225 -0400", hash_original_method = "D6AAE40F539D7383E827DA395512E95B", hash_generated_method = "207B464AAB7566FD25D2646B7EE6C19D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PointerProperties() {
            clear();
            // ---------- Original Method ----------
            //clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.225 -0400", hash_original_method = "0B0B44B5B3A0DCF648446956F27785E9", hash_generated_method = "E0946BF5CA39468BC097EAF633A6D8E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PointerProperties(PointerProperties other) {
            dsTaint.addTaint(other.dsTaint);
            copyFrom(other);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.225 -0400", hash_original_method = "ADC6A83F955A9ED0C1C75B5F08682583", hash_generated_method = "DFC90B75E706F2F74BBF473BA904F663")
        @DSModeled(DSC.SAFE)
        public void clear() {
            id = INVALID_POINTER_ID;
            toolType = TOOL_TYPE_UNKNOWN;
            // ---------- Original Method ----------
            //id = INVALID_POINTER_ID;
            //toolType = TOOL_TYPE_UNKNOWN;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.225 -0400", hash_original_method = "1E34ECE529256025A33CF5DCBE029131", hash_generated_method = "7A5624DF20E6E38E3DFF81DA06FD149B")
        @DSModeled(DSC.SAFE)
        public void copyFrom(PointerProperties other) {
            dsTaint.addTaint(other.dsTaint);
            id = other.id;
            toolType = other.toolType;
            // ---------- Original Method ----------
            //id = other.id;
            //toolType = other.toolType;
        }

        
    }


    
    private static final long NS_PER_MS = 1000000;
    private static final boolean TRACK_RECYCLED_LOCATION = false;
    public static final int INVALID_POINTER_ID = -1;
    public static final int ACTION_MASK             = 0xff;
    public static final int ACTION_DOWN             = 0;
    public static final int ACTION_UP               = 1;
    public static final int ACTION_MOVE             = 2;
    public static final int ACTION_CANCEL           = 3;
    public static final int ACTION_OUTSIDE          = 4;
    public static final int ACTION_POINTER_DOWN     = 5;
    public static final int ACTION_POINTER_UP       = 6;
    public static final int ACTION_HOVER_MOVE       = 7;
    public static final int ACTION_SCROLL           = 8;
    public static final int ACTION_HOVER_ENTER      = 9;
    public static final int ACTION_HOVER_EXIT       = 10;
    public static final int ACTION_POINTER_INDEX_MASK  = 0xff00;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    @Deprecated public static final int ACTION_POINTER_1_DOWN   = ACTION_POINTER_DOWN | 0x0000;
    @Deprecated public static final int ACTION_POINTER_2_DOWN   = ACTION_POINTER_DOWN | 0x0100;
    @Deprecated public static final int ACTION_POINTER_3_DOWN   = ACTION_POINTER_DOWN | 0x0200;
    @Deprecated public static final int ACTION_POINTER_1_UP     = ACTION_POINTER_UP | 0x0000;
    @Deprecated public static final int ACTION_POINTER_2_UP     = ACTION_POINTER_UP | 0x0100;
    @Deprecated public static final int ACTION_POINTER_3_UP     = ACTION_POINTER_UP | 0x0200;
    @Deprecated public static final int ACTION_POINTER_ID_MASK  = 0xff00;
    @Deprecated public static final int ACTION_POINTER_ID_SHIFT = 8;
    public static final int FLAG_WINDOW_IS_OBSCURED = 0x1;
    public static final int FLAG_TAINTED = 0x80000000;
    public static final int EDGE_TOP = 0x00000001;
    public static final int EDGE_BOTTOM = 0x00000002;
    public static final int EDGE_LEFT = 0x00000004;
    public static final int EDGE_RIGHT = 0x00000008;
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_PRESSURE = 2;
    public static final int AXIS_SIZE = 3;
    public static final int AXIS_TOUCH_MAJOR = 4;
    public static final int AXIS_TOUCH_MINOR = 5;
    public static final int AXIS_TOOL_MAJOR = 6;
    public static final int AXIS_TOOL_MINOR = 7;
    public static final int AXIS_ORIENTATION = 8;
    public static final int AXIS_VSCROLL = 9;
    public static final int AXIS_HSCROLL = 10;
    public static final int AXIS_Z = 11;
    public static final int AXIS_RX = 12;
    public static final int AXIS_RY = 13;
    public static final int AXIS_RZ = 14;
    public static final int AXIS_HAT_X = 15;
    public static final int AXIS_HAT_Y = 16;
    public static final int AXIS_LTRIGGER = 17;
    public static final int AXIS_RTRIGGER = 18;
    public static final int AXIS_THROTTLE = 19;
    public static final int AXIS_RUDDER = 20;
    public static final int AXIS_WHEEL = 21;
    public static final int AXIS_GAS = 22;
    public static final int AXIS_BRAKE = 23;
    public static final int AXIS_DISTANCE = 24;
    public static final int AXIS_TILT = 25;
    public static final int AXIS_GENERIC_1 = 32;
    public static final int AXIS_GENERIC_2 = 33;
    public static final int AXIS_GENERIC_3 = 34;
    public static final int AXIS_GENERIC_4 = 35;
    public static final int AXIS_GENERIC_5 = 36;
    public static final int AXIS_GENERIC_6 = 37;
    public static final int AXIS_GENERIC_7 = 38;
    public static final int AXIS_GENERIC_8 = 39;
    public static final int AXIS_GENERIC_9 = 40;
    public static final int AXIS_GENERIC_10 = 41;
    public static final int AXIS_GENERIC_11 = 42;
    public static final int AXIS_GENERIC_12 = 43;
    public static final int AXIS_GENERIC_13 = 44;
    public static final int AXIS_GENERIC_14 = 45;
    public static final int AXIS_GENERIC_15 = 46;
    public static final int AXIS_GENERIC_16 = 47;
    private static final SparseArray<String> AXIS_SYMBOLIC_NAMES = new SparseArray<String>();
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
    
    public static final int BUTTON_PRIMARY = 1 << 0;
    public static final int BUTTON_SECONDARY = 1 << 1;
    public static final int BUTTON_TERTIARY = 1 << 2;
    public static final int BUTTON_BACK = 1 << 3;
    public static final int BUTTON_FORWARD = 1 << 4;
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
    public static final int TOOL_TYPE_UNKNOWN = 0;
    public static final int TOOL_TYPE_FINGER = 1;
    public static final int TOOL_TYPE_STYLUS = 2;
    public static final int TOOL_TYPE_MOUSE = 3;
    public static final int TOOL_TYPE_ERASER = 4;
    private static final SparseArray<String> TOOL_TYPE_SYMBOLIC_NAMES = new SparseArray<String>();
    static {
        SparseArray<String> names = TOOL_TYPE_SYMBOLIC_NAMES;
        names.append(TOOL_TYPE_UNKNOWN, "TOOL_TYPE_UNKNOWN");
        names.append(TOOL_TYPE_FINGER, "TOOL_TYPE_FINGER");
        names.append(TOOL_TYPE_STYLUS, "TOOL_TYPE_STYLUS");
        names.append(TOOL_TYPE_MOUSE, "TOOL_TYPE_MOUSE");
        names.append(TOOL_TYPE_ERASER, "TOOL_TYPE_ERASER");
    }
    
    private static final int HISTORY_CURRENT = -0x80000000;
    private static final int MAX_RECYCLED = 10;
    private static final Object gRecyclerLock = new Object();
    private static int gRecyclerUsed;
    private static MotionEvent gRecyclerTop;
    private static final Object gSharedTempLock = new Object();
    private static PointerCoords[] gSharedTempPointerCoords;
    private static PointerProperties[] gSharedTempPointerProperties;
    private static int[] gSharedTempPointerIndexMap;
    public static final Parcelable.Creator<MotionEvent> CREATOR = new Parcelable.Creator<MotionEvent>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.226 -0400", hash_original_method = "E988C06BFCE97E62AC2813BD29B32BEE", hash_generated_method = "7F3B94DB582A9B77D9A26D1D275353F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MotionEvent createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            in.readInt();
            MotionEvent varDBE57DA48AA46F9897DCADB263EB85B9_874046106 = (MotionEvent.createFromParcelBody(in));
            return (MotionEvent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //in.readInt();
            //return MotionEvent.createFromParcelBody(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.226 -0400", hash_original_method = "5EBE0D6E50651488F7881A7509B9CA02", hash_generated_method = "C7A6A07C967ADCF3BF600DCE0BEA6F7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MotionEvent[] newArray(int size) {
            dsTaint.addTaint(size);
            MotionEvent[] varE7EBD01C2A47092755D87420D4AB0600_2069905226 = (new MotionEvent[size]);
            return (MotionEvent[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new MotionEvent[size];
        }

        
}; //Transformed anonymous class
}

