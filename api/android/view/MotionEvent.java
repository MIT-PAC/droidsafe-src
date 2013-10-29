package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;




import droidsafe.helpers.DSUtils;

public final class MotionEvent extends InputEvent implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.752 -0400", hash_original_field = "AE1F3581ADE8C1B0F98DFDE5A4F536A3", hash_generated_field = "23CD98EE9F206841B49D023F257D02A5")

    private int mNativePtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.752 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "4ED1BADBA3F9AC6D1D2BD2B16B6BF967")

    private MotionEvent mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.752 -0400", hash_original_field = "285FE8BBC1049056117639C63D1605B9", hash_generated_field = "4E4D5EFD76E218484C8A2F86B097FF08")

    private RuntimeException mRecycledLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.752 -0400", hash_original_field = "1212A62D731F217836716E35FA12386C", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.752 -0400", hash_original_method = "B1B69F583261D8BEEC921FF43580AA66", hash_generated_method = "40B8D4E791D456515D6D7EBB1643CE79")
    public  MotionEvent() {
        // ---------- Original Method ----------
    }
    
    @DSModeled(DSC.BAN)
    public static MotionEvent droidsafeObtainEvent(){
        MotionEvent ev = new MotionEvent();
        return ev;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
    private static int nativeInitialize(int nativePtr,
            int deviceId, int source, int action, int flags, int edgeFlags,
            int metaState, int buttonState,
            float xOffset, float yOffset, float xPrecision, float yPrecision,
            long downTimeNanos, long eventTimeNanos,
            int pointerCount, PointerProperties[] pointerIds, PointerCoords[] pointerCoords) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCopy(int destNativePtr, int sourceNativePtr,
            boolean keepHistory) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDispose(int nativePtr) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeAddBatch(int nativePtr, long eventTimeNanos,
            PointerCoords[] pointerCoords, int metaState) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetDeviceId(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetSource(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeSetSource(int nativePtr, int source) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetAction(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetAction(int nativePtr, int action) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeIsTouchEvent(int nativePtr) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetFlags(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetFlags(int nativePtr, int flags) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetEdgeFlags(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetEdgeFlags(int nativePtr, int action) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetMetaState(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetButtonState(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeOffsetLocation(int nativePtr, float deltaX, float deltaY) {
    }

    
    @DSModeled(DSC.SAFE)
    private static float nativeGetXOffset(int nativePtr) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    private static float nativeGetYOffset(int nativePtr) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    private static float nativeGetXPrecision(int nativePtr) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    private static float nativeGetYPrecision(int nativePtr) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    private static long nativeGetDownTimeNanos(int nativePtr) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetDownTimeNanos(int nativePtr, long downTime) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetPointerCount(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetPointerId(int nativePtr, int pointerIndex) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetToolType(int nativePtr, int pointerIndex) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeFindPointerIndex(int nativePtr, int pointerId) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetHistorySize(int nativePtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static long nativeGetEventTimeNanos(int nativePtr, int historyPos) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    private static float nativeGetRawAxisValue(int nativePtr,
            int axis, int pointerIndex, int historyPos) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    private static float nativeGetAxisValue(int nativePtr,
            int axis, int pointerIndex, int historyPos) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeGetPointerCoords(int nativePtr,
            int pointerIndex, int historyPos, PointerCoords outPointerCoords) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeGetPointerProperties(int nativePtr,
            int pointerIndex, PointerProperties outPointerProperties) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeScale(int nativePtr, float scale) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeTransform(int nativePtr, Matrix matrix) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeReadFromParcel(int nativePtr, Parcel parcel) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeWriteToParcel(int nativePtr, Parcel parcel) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.763 -0400", hash_original_method = "3F0B5C050D986DD9F1F0F2A742C616C8", hash_generated_method = "385D2C3489242CAC5323F682E351928B")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            if(mNativePtr != 0)            
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    static public MotionEvent obtain(long downTime, long eventTime, int action,
            int pointerCount, float x, float y, float pressure, float size, int metaState,
            float xPrecision, float yPrecision, int deviceId, int edgeFlags) {
        return obtain(downTime, eventTime, action, x, y, pressure, size,
                metaState, xPrecision, yPrecision, deviceId, edgeFlags);
    }

    
    @DSModeled(DSC.SAFE)
    static public MotionEvent obtain(long downTime, long eventTime, int action,
            float x, float y, int metaState) {
        return obtain(downTime, eventTime, action, x, y, 1.0f, 1.0f,
                metaState, 1.0f, 1.0f, 0, 0);
    }

    
    @DSModeled(DSC.SAFE)
    static public MotionEvent obtain(MotionEvent other) {
        if (other == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        }
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeCopy(ev.mNativePtr, other.mNativePtr, true );
        return ev;
    }

    
    @DSModeled(DSC.SAFE)
    static public MotionEvent obtainNoHistory(MotionEvent other) {
        if (other == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        }
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeCopy(ev.mNativePtr, other.mNativePtr, false );
        return ev;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.764 -0400", hash_original_method = "78DE11FBBF58608981D1F74EEB443B54", hash_generated_method = "9527F964637F3EFC3AB37597B1B98663")
    @Override
    public MotionEvent copy() {
MotionEvent var3E50018916F9DBFE0D39D9282EBAD97D_1446976778 =         obtain(this);
        var3E50018916F9DBFE0D39D9282EBAD97D_1446976778.addTaint(taint);
        return var3E50018916F9DBFE0D39D9282EBAD97D_1446976778;
        // ---------- Original Method ----------
        //return obtain(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.764 -0400", hash_original_method = "187F7D3A42078A42C8212C3EFE0E8B16", hash_generated_method = "B5993FF85078ECCF8FA62AB69B6F4EEE")
    public final void recycle() {
        if(TRACK_RECYCLED_LOCATION)        
        {
            if(mRecycledLocation != null)            
            {
                RuntimeException var560DEC13FEE3B93EDBE65D649F29206C_1567442175 = new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
                var560DEC13FEE3B93EDBE65D649F29206C_1567442175.addTaint(taint);
                throw var560DEC13FEE3B93EDBE65D649F29206C_1567442175;
            } //End block
            mRecycledLocation = new RuntimeException("Last recycled here");
        } //End block
        else
        {
            if(mRecycled)            
            {
                RuntimeException var4B7E168C1631949DA6BD5DCA24D52129_1130973791 = new RuntimeException(toString() + " recycled twice!");
                var4B7E168C1631949DA6BD5DCA24D52129_1130973791.addTaint(taint);
                throw var4B7E168C1631949DA6BD5DCA24D52129_1130973791;
            } //End block
            mRecycled = true;
        } //End block
        synchronized
(gRecyclerLock)        {
            if(gRecyclerUsed < MAX_RECYCLED)            
            {
                gRecyclerUsed++;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.764 -0400", hash_original_method = "A082C8E505553F853E56AAFC11CF0CDA", hash_generated_method = "7607C4622D338DF7A6F483ECCB464AFD")
    public final void scale(float scale) {
        addTaint(scale);
        nativeScale(mNativePtr, scale);
        // ---------- Original Method ----------
        //nativeScale(mNativePtr, scale);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.764 -0400", hash_original_method = "E51EA2AB032E4C79CC226174E2601818", hash_generated_method = "54F12DC50C23959A034424BE29DE222E")
    @Override
    public final int getDeviceId() {
        int varD5036D44BBD58011C7C3053FEF587C41_1029445782 = (nativeGetDeviceId(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273158390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273158390;
        // ---------- Original Method ----------
        //return nativeGetDeviceId(mNativePtr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.765 -0400", hash_original_method = "44501F684180CAB98F3511C2614C7994", hash_generated_method = "B3E688D4D76419A256A7718E00615F11")
    @Override
    public final int getSource() {
        int varD7C59EEED2658A02199C3A3437633508_694446474 = (nativeGetSource(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_640482870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_640482870;
        // ---------- Original Method ----------
        //return nativeGetSource(mNativePtr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.765 -0400", hash_original_method = "1502AF3F26B6DD95879512031D9FB73E", hash_generated_method = "07A1FD7FD3D3FD477882D5EF4A4A6E49")
    @Override
    public final void setSource(int source) {
        addTaint(source);
        nativeSetSource(mNativePtr, source);
        // ---------- Original Method ----------
        //nativeSetSource(mNativePtr, source);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.765 -0400", hash_original_method = "FA5880EB8F61D955AC5922ACE620FCE2", hash_generated_method = "ED1013841C248D8FEA98F00C51C92E68")
    public final int getAction() {
        int var80A98A7BBE69E4DF94992B8C4CCEB9C8_1465204828 = (nativeGetAction(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1002007811 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1002007811;
        // ---------- Original Method ----------
        //return nativeGetAction(mNativePtr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.765 -0400", hash_original_method = "268411790684740D49A019DF59E1FFBB", hash_generated_method = "845CE5F44A92E85F87C047A9FCA94AF2")
    public final int getActionMasked() {
        int varACC094C520CCDFB8E868FFF09CB65B46_245484013 = (nativeGetAction(mNativePtr) & ACTION_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461746298 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461746298;
        // ---------- Original Method ----------
        //return nativeGetAction(mNativePtr) & ACTION_MASK;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.765 -0400", hash_original_method = "464EE1689B645958C6F5E17990D5ECA4", hash_generated_method = "98F6FF23B0123E5DACFC477BD6155FFE")
    public final int getActionIndex() {
        int var7500415F7360866D42A5FB7EE3347BCF_121730432 = ((nativeGetAction(mNativePtr) & ACTION_POINTER_INDEX_MASK)
                >> ACTION_POINTER_INDEX_SHIFT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579487176 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579487176;
        // ---------- Original Method ----------
        //return (nativeGetAction(mNativePtr) & ACTION_POINTER_INDEX_MASK)
                //>> ACTION_POINTER_INDEX_SHIFT;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.765 -0400", hash_original_method = "3A9CDEA51D903248E7ACBBA8C3F57155", hash_generated_method = "29FE3AF9DF4DC4A53809421B23F6D675")
    public final boolean isTouchEvent() {
        boolean varDFE61C24DD01208F966A163BDD38A4CD_763986490 = (nativeIsTouchEvent(mNativePtr));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590782214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_590782214;
        // ---------- Original Method ----------
        //return nativeIsTouchEvent(mNativePtr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.765 -0400", hash_original_method = "A25E485C356A262F519C0A5841CFA47B", hash_generated_method = "7249C44305B2C9A81C744C042A01BCAD")
    public final int getFlags() {
        int varA526BA649589E0CDCE94D6C8B3100B23_346371018 = (nativeGetFlags(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430135938 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430135938;
        // ---------- Original Method ----------
        //return nativeGetFlags(mNativePtr);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.765 -0400", hash_original_method = "24A8A0C0077001C335E0B5C917301FE4", hash_generated_method = "DE3C3D95A2490110A6039ABB70C2E54F")
    @Override
    public final boolean isTainted() {
        final int flags = getFlags();
        boolean varF9FF507AC72E6282571250C24C98B15B_718161051 = ((flags & FLAG_TAINTED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695256526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695256526;
        // ---------- Original Method ----------
        //final int flags = getFlags();
        //return (flags & FLAG_TAINTED) != 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.766 -0400", hash_original_method = "96C1138F844BE852B50B0529E539E061", hash_generated_method = "57EF329636FE9540DF3DC82261F2E901")
    @Override
    public final void setTainted(boolean tainted) {
        addTaint(tainted);
        final int flags = getFlags();
        nativeSetFlags(mNativePtr, tainted ? flags | FLAG_TAINTED : flags & ~FLAG_TAINTED);
        // ---------- Original Method ----------
        //final int flags = getFlags();
        //nativeSetFlags(mNativePtr, tainted ? flags | FLAG_TAINTED : flags & ~FLAG_TAINTED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.766 -0400", hash_original_method = "5F4C05CD4E223E38846D15A6EA0DF305", hash_generated_method = "BD8F615DF238A9D30A130D0183ACB38C")
    public final long getDownTime() {
        long var11BA13D60255B6CD28CC817BD12A69DC_1388766154 = (nativeGetDownTimeNanos(mNativePtr) / NS_PER_MS);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_848605161 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_848605161;
        // ---------- Original Method ----------
        //return nativeGetDownTimeNanos(mNativePtr) / NS_PER_MS;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.766 -0400", hash_original_method = "97B3432DE604A4A8C3339017F5056697", hash_generated_method = "204CBCF8A37B0B817930F4C634EFA42C")
    public final void setDownTime(long downTime) {
        addTaint(downTime);
        nativeSetDownTimeNanos(mNativePtr, downTime * NS_PER_MS);
        // ---------- Original Method ----------
        //nativeSetDownTimeNanos(mNativePtr, downTime * NS_PER_MS);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.766 -0400", hash_original_method = "CCF6A1C7FFBA398090457272FB07E7C9", hash_generated_method = "617589CD889869502FEDB69472ED8909")
    public final long getEventTime() {
        long var2B7CDB1B7E0B9584D608D19D659E6265_1327842437 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT) / NS_PER_MS);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_267997285 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_267997285;
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT) / NS_PER_MS;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.766 -0400", hash_original_method = "9EB1FC24DA069289850F91A3F8734D9A", hash_generated_method = "4F051836F91DBB2A1A68CA60F07F3BDE")
    public final long getEventTimeNano() {
        long varB79ED88242A7E101FD2975DEAA6D4999_1187871124 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_484329396 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_484329396;
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.766 -0400", hash_original_method = "4BF6642E766343B332FD98949BC6C582", hash_generated_method = "B985C63393B6EF6104BCBDB3031CC359")
    public final float getX() {
        float var3EF7A7583F95AE482084502D0DB5A8CD_75610388 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_580856656 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_580856656;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.766 -0400", hash_original_method = "91A63DEAB3A8AC7438EA04466792BD82", hash_generated_method = "9B765CBB9CA853344709D367D297F3BC")
    public final float getY() {
        float var7709F8DC42991A9E1DFD10831DB35973_527341509 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1693453917 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1693453917;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.767 -0400", hash_original_method = "6675B94FFDE5461AE8829AF0934758CB", hash_generated_method = "0A2346F4CB687D9925F864CA87E2BCA6")
    public final float getPressure() {
        float varC8B9B3D4B8B60D775828193450E8BE3F_471805044 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_901242204 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_901242204;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.767 -0400", hash_original_method = "04BA234B263118C319F9FB3039E4C966", hash_generated_method = "7E7AC1A2F3892F1156C190CE0EF3D79A")
    public final float getSize() {
        float var6E061C316CD065948A93F098D1140243_170123024 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1357207234 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1357207234;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.767 -0400", hash_original_method = "7EDCA08C9EC8F904EE9855CC249509CB", hash_generated_method = "DE53E1B91B45E4A43EA645879DB94B0E")
    public final float getTouchMajor() {
        float varBDD96393822720D4B1BFA1D54C6BD258_181297461 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_2050684276 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2050684276;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.767 -0400", hash_original_method = "0D1B5526DE02F52B1563B7D7F6F58090", hash_generated_method = "8E1FE6C4ADC072B3BB66E23EDBF580A2")
    public final float getTouchMinor() {
        float var1F412634D4A047597000DDD05740D35E_1179010665 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1404477532 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1404477532;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.767 -0400", hash_original_method = "88DA06A5CC2E8F8456F3789E8A68ED44", hash_generated_method = "D99AFB246ECA8992DA6721B613F802C4")
    public final float getToolMajor() {
        float var1F91C2975A484921DAC7E89073521880_945209371 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1143322007 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1143322007;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.767 -0400", hash_original_method = "68541C2106990EEA679DCE03A62D7FCC", hash_generated_method = "A461C280FE6C59E43C7C818397427278")
    public final float getToolMinor() {
        float varF9BF461A999AEC47E41774F9DA67773D_1264323762 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_586978133 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_586978133;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.767 -0400", hash_original_method = "6DB87F8256212E2B4D49883D1C47D372", hash_generated_method = "1C59325723287F8886933939733CCD04")
    public final float getOrientation() {
        float var6737447A3971B8877C8DF74C50D93D2F_1631952659 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_18153487 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_18153487;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.767 -0400", hash_original_method = "630AA047225B25427528E4D32F567B17", hash_generated_method = "5E38F503A45958F88DDCFC9DFC9482C7")
    public final float getAxisValue(int axis) {
        addTaint(axis);
        float var822AAE1DFCB4316BA34CD1785FDDF097_49145059 = (nativeGetAxisValue(mNativePtr, axis, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_351271700 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_351271700;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.767 -0400", hash_original_method = "2050CCC0293D52B162C880AD9BC3C6F6", hash_generated_method = "69D94D77427BCDC4FEC7F4829652EEBC")
    public final int getPointerCount() {
        int var7A4B6F285807138C0798AE2E9C4D751D_164721999 = (nativeGetPointerCount(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1766353441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1766353441;
        // ---------- Original Method ----------
        //return nativeGetPointerCount(mNativePtr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.768 -0400", hash_original_method = "43D465AFB7AC0153BC6ACD556C5FF613", hash_generated_method = "E11127DE2054BEC8893F6659E489ED2F")
    public final int getPointerId(int pointerIndex) {
        addTaint(pointerIndex);
        int var8E8F6655A8D22D3BAB9DC7FA287A80A7_1037630821 = (nativeGetPointerId(mNativePtr, pointerIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332184064 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332184064;
        // ---------- Original Method ----------
        //return nativeGetPointerId(mNativePtr, pointerIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.768 -0400", hash_original_method = "4F4E823E6A973C2A4D85C86C0A6A2D9D", hash_generated_method = "159F085AB9D93F70B1985C47AFB3632F")
    public final int getToolType(int pointerIndex) {
        addTaint(pointerIndex);
        int varB87A49BC30F5D03ED839617274948661_1431203236 = (nativeGetToolType(mNativePtr, pointerIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964663642 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964663642;
        // ---------- Original Method ----------
        //return nativeGetToolType(mNativePtr, pointerIndex);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.768 -0400", hash_original_method = "396B4C03ADE41E49E928286EB7438AA9", hash_generated_method = "0243526694D94528B3079B2792898326")
    public final int findPointerIndex(int pointerId) {
        addTaint(pointerId);
        int varC2DCDDA09AB188B9E320373B4ECD5290_11511046 = (nativeFindPointerIndex(mNativePtr, pointerId));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975324067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975324067;
        // ---------- Original Method ----------
        //return nativeFindPointerIndex(mNativePtr, pointerId);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.768 -0400", hash_original_method = "13E56CEAC1D2714A9A1790EF5117F935", hash_generated_method = "A4F3A33D9588D47BD607219149950F7B")
    public final float getX(int pointerIndex) {
        addTaint(pointerIndex);
        float var0A588BA531FA804F2F27535A22C357F5_1164611532 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_939263450 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_939263450;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.768 -0400", hash_original_method = "9A0C47F653E064961B232F3274CD29C9", hash_generated_method = "83F977A39CF05AD6742C4B61A78005E7")
    public final float getY(int pointerIndex) {
        addTaint(pointerIndex);
        float var10D450FE3C08AF57C6CA49990B2D3955_430964223 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_726671671 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_726671671;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.768 -0400", hash_original_method = "36E2BAC74F4F826870F428D93CA1D371", hash_generated_method = "31AE75079036FE0292B0CE373C59AEDE")
    public final float getPressure(int pointerIndex) {
        addTaint(pointerIndex);
        float var30AC2BB8D820520FA3A5E2CB9658F590_1525731046 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_453878157 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_453878157;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.768 -0400", hash_original_method = "50DE00A69645B3335E8383A50AB1EB05", hash_generated_method = "4A394BF56B8256E955B3E256D7A7AFD4")
    public final float getSize(int pointerIndex) {
        addTaint(pointerIndex);
        float varE9D3E0C74CCF4ADE9064F8432DFA8E19_150562827 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1225544654 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1225544654;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.768 -0400", hash_original_method = "28BED69B39230D6E2E593658DA262948", hash_generated_method = "0704A5E7AC75FC43A5F8B332A5F1A10B")
    public final float getTouchMajor(int pointerIndex) {
        addTaint(pointerIndex);
        float var312F092DC7738998C91B1C650C9208C5_1955360870 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1072630795 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1072630795;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.768 -0400", hash_original_method = "2C1FBE2BFEFC6BD6A6EFC25F55DD94B0", hash_generated_method = "8BA31B738A536893D1FD62D6A540D907")
    public final float getTouchMinor(int pointerIndex) {
        addTaint(pointerIndex);
        float var1D2ADBCE62DF15318D292A2184D5A6F8_1824090819 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1857732422 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1857732422;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.768 -0400", hash_original_method = "66B849A9DC257EF38185AFB935434C46", hash_generated_method = "C1BBA4101F7C09B87217776E2E688437")
    public final float getToolMajor(int pointerIndex) {
        addTaint(pointerIndex);
        float var661E79BA458A3CC6D15AED49C15A7B30_1578859382 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_222932548 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_222932548;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.769 -0400", hash_original_method = "F39564D767A71A1EAACBC920B100E436", hash_generated_method = "8AE72D0AFA99289AFEB5141E5FEFE917")
    public final float getToolMinor(int pointerIndex) {
        addTaint(pointerIndex);
        float var5BC97869170DDF7295F74C5E4FB9C67A_366444322 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_961767768 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_961767768;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.769 -0400", hash_original_method = "A9038F286A5A1470BB26B4145360A2CC", hash_generated_method = "A4F568D2FFD6D934EFC51D79B2B6076A")
    public final float getOrientation(int pointerIndex) {
        addTaint(pointerIndex);
        float varF92B55DACDDA8C7C897B27D94BC39D00_214741659 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_214972026 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_214972026;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.769 -0400", hash_original_method = "3434CDF166CDB98F83BC4BA0F4722E7E", hash_generated_method = "367199BAFA68F2513F6C2761F56C1B50")
    public final float getAxisValue(int axis, int pointerIndex) {
        addTaint(pointerIndex);
        addTaint(axis);
        float var66245FED39B2BDF31F7C19DE02F912F2_1404241379 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_464061420 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_464061420;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.769 -0400", hash_original_method = "33DE471947CC053A5003BB5AAC41F910", hash_generated_method = "E7823BC7B19A0EC5CE34184C01125684")
    public final void getPointerCoords(int pointerIndex, PointerCoords outPointerCoords) {
        addTaint(outPointerCoords.getTaint());
        addTaint(pointerIndex);
        nativeGetPointerCoords(mNativePtr, pointerIndex, HISTORY_CURRENT, outPointerCoords);
        // ---------- Original Method ----------
        //nativeGetPointerCoords(mNativePtr, pointerIndex, HISTORY_CURRENT, outPointerCoords);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.769 -0400", hash_original_method = "FC8907B12AF62543F5FA0564EA522E62", hash_generated_method = "DE55870116B99FA0B12E297135A7A19B")
    public final void getPointerProperties(int pointerIndex,
            PointerProperties outPointerProperties) {
        addTaint(outPointerProperties.getTaint());
        addTaint(pointerIndex);
        nativeGetPointerProperties(mNativePtr, pointerIndex, outPointerProperties);
        // ---------- Original Method ----------
        //nativeGetPointerProperties(mNativePtr, pointerIndex, outPointerProperties);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.769 -0400", hash_original_method = "38A68962B5CFD92D43EE16A436EABCF2", hash_generated_method = "8B69FB5349030EB7F9BECBA82F330992")
    public final int getMetaState() {
        int var8B31B809A1E02B825F144CA38A97CC53_369873563 = (nativeGetMetaState(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607138566 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607138566;
        // ---------- Original Method ----------
        //return nativeGetMetaState(mNativePtr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.769 -0400", hash_original_method = "C8458CE15D5B2817F47A4FD377CE1968", hash_generated_method = "8C1D6E7CB409E4373333FD34AF807761")
    public final int getButtonState() {
        int var9B60F673C42B84E229E1898D796679E0_1217979475 = (nativeGetButtonState(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_784259040 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_784259040;
        // ---------- Original Method ----------
        //return nativeGetButtonState(mNativePtr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.769 -0400", hash_original_method = "6E457CC599C66DF6B9AC57A3DF3B8E7E", hash_generated_method = "24E9507715AA5B26CF0034CDFE0DB921")
    public final float getRawX() {
        float var0D854522731FBDAB87403300A649F3D3_1067711276 = (nativeGetRawAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_228594491 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_228594491;
        // ---------- Original Method ----------
        //return nativeGetRawAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.770 -0400", hash_original_method = "C18C1837908CE668DE325D32328DA600", hash_generated_method = "01CFF570AB2C41C5E1223FEB0F9C880B")
    public final float getRawY() {
        float var52B0E43324F1F3642461105A906C8523_1986156642 = (nativeGetRawAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_2050218912 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2050218912;
        // ---------- Original Method ----------
        //return nativeGetRawAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.770 -0400", hash_original_method = "32503B0D7203271814D12FFB8906664F", hash_generated_method = "517322C3EAE0AC2E790EE60C53BEAC14")
    public final float getXPrecision() {
        float var2A7917A86613FB742B65FF142C135D3E_628438830 = (nativeGetXPrecision(mNativePtr));
                float var546ADE640B6EDFBC8A086EF31347E768_1741639692 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1741639692;
        // ---------- Original Method ----------
        //return nativeGetXPrecision(mNativePtr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.770 -0400", hash_original_method = "77B44C5CFF493101D20AF55AA249AFB4", hash_generated_method = "EDAB879031CFF9CAB9BE318804571076")
    public final float getYPrecision() {
        float varE236F74B3ABE497BD8C08E81B74F9DD0_1703123036 = (nativeGetYPrecision(mNativePtr));
                float var546ADE640B6EDFBC8A086EF31347E768_817898167 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_817898167;
        // ---------- Original Method ----------
        //return nativeGetYPrecision(mNativePtr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.770 -0400", hash_original_method = "B4D273F4D2084C890DE19B631E3ED869", hash_generated_method = "CD6D08546E20AF52EED98DC8B5CE7CC5")
    public final int getHistorySize() {
        int var066A735E1D7E1073E9C19404D62C6B62_435977999 = (nativeGetHistorySize(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_406705659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_406705659;
        // ---------- Original Method ----------
        //return nativeGetHistorySize(mNativePtr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.770 -0400", hash_original_method = "4F37DFE9294EB232F86D1F83C2ADDC74", hash_generated_method = "D7B5C8DB239066EF1395870D6550AF85")
    public final long getHistoricalEventTime(int pos) {
        addTaint(pos);
        long var02012D1A8B849D7B9F09E733FF57B5ED_1756551917 = (nativeGetEventTimeNanos(mNativePtr, pos) / NS_PER_MS);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1071350432 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1071350432;
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, pos) / NS_PER_MS;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.770 -0400", hash_original_method = "52641DCD8C1505610834B8CDD1492B06", hash_generated_method = "C0D5DCEFA0D0BA3FE0F88CDDC8CEE7A1")
    public final float getHistoricalX(int pos) {
        addTaint(pos);
        float var026B183B319CDB0CC5DB3209786BAC2A_1337763143 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1390827007 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1390827007;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, 0, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.770 -0400", hash_original_method = "456D8725235AB4DBC45E47B4ADD23013", hash_generated_method = "CB16A7A92E7F3ECDFA7827C0B66B1A5F")
    public final float getHistoricalY(int pos) {
        addTaint(pos);
        float var7BBA8D16B64D4DA25994BEC47B24F1B6_515078762 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1247007813 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1247007813;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, 0, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.770 -0400", hash_original_method = "E822398D8AD69E2A637D6F0BC07F61D8", hash_generated_method = "90808BBFBE871772340A6F2B67A187C1")
    public final float getHistoricalPressure(int pos) {
        addTaint(pos);
        float var0FE43FE23EC2880FC993C9BC19B652EE_116735808 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_395830338 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_395830338;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.771 -0400", hash_original_method = "A43A8374A73078EDB84358D609B2C354", hash_generated_method = "41DBB045601E18BD73609E13BC0D42BD")
    public final float getHistoricalSize(int pos) {
        addTaint(pos);
        float var661F53AD036895262E5A525987FAB1AB_121209596 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1750153177 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1750153177;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.771 -0400", hash_original_method = "192AC6C55C0D7020BB0EA3AE5DE4FD65", hash_generated_method = "08D219D29F9280CC4093715671DF3C98")
    public final float getHistoricalTouchMajor(int pos) {
        addTaint(pos);
        float varA35EDC0ABAA1029D85F4BD3C2711FDEC_675046263 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1075198201 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1075198201;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.771 -0400", hash_original_method = "122C0ECAA119AC26B3F087E871FFA312", hash_generated_method = "C8EA3CF35A36263CB0BAE59CE774F28E")
    public final float getHistoricalTouchMinor(int pos) {
        addTaint(pos);
        float var9019E6BDE5FF77EB81396A1FFAEAE74D_1586814047 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1482064070 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1482064070;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.771 -0400", hash_original_method = "8097CEA35B3273816C6109CC76A9BC74", hash_generated_method = "F6DD6E130E3FE1BF9CB31FA99C24C7F3")
    public final float getHistoricalToolMajor(int pos) {
        addTaint(pos);
        float varB2AA9900B676244450FE7A01259BC28F_1763820111 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_40665016 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_40665016;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.771 -0400", hash_original_method = "E0365AAE3D6BF704A796F5D4E7964FB9", hash_generated_method = "277FA43CC49EEC7952CA26F73CDE7F38")
    public final float getHistoricalToolMinor(int pos) {
        addTaint(pos);
        float var45C6454A6618661C0DF4FDBFD9DAC0FA_1571796779 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_596628889 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_596628889;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.772 -0400", hash_original_method = "DC8FCE9CD404D08D0BFF0CC77CEE87C1", hash_generated_method = "54BD7BBF5639A2AACE3BEA6E2050CFCC")
    public final float getHistoricalOrientation(int pos) {
        addTaint(pos);
        float var9A2C8140AF67A1D4D386DE4259B1787C_1952618766 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1983161637 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1983161637;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.772 -0400", hash_original_method = "697532A0192D8868F2E3AE618301BF20", hash_generated_method = "CD9CDAC5BFAB3F89CB87EE25016D731F")
    public final float getHistoricalAxisValue(int axis, int pos) {
        addTaint(pos);
        addTaint(axis);
        float var8B571BE607B83E206E56C84370B33DA8_981250152 = (nativeGetAxisValue(mNativePtr, axis, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1169869508 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1169869508;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, 0, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.772 -0400", hash_original_method = "8BFA09569623FF1F941D2134C3D47F02", hash_generated_method = "5FF0877F5C456F0FD3D2FDDB0B748E19")
    public final float getHistoricalX(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var4AF32255F4A4F1264762696ED715D5C4_649715363 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_486567245 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_486567245;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.772 -0400", hash_original_method = "9787FE8A43AC5153EC8D7EC463FC985B", hash_generated_method = "9516A4ABD79A8EE2895C842DE1CD35AD")
    public final float getHistoricalY(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float varF2AC8D1DA84755F35269C73FC6495FD0_640986484 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_33996539 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_33996539;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.772 -0400", hash_original_method = "A8F703E0BCBA29F53C62C25AACD436ED", hash_generated_method = "695AD7A1407D48AA859FCC275EF4F495")
    public final float getHistoricalPressure(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var20169B30E644D54B9D66666865A50453_1912640428 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_841183413 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_841183413;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.772 -0400", hash_original_method = "66A9DA10859CF6933D658F61BE53F70F", hash_generated_method = "8F8112D048D2AFE4CE3741A61BF3692B")
    public final float getHistoricalSize(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float varEB7E60A947D456C834868D628B623593_1181195995 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1206673457 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1206673457;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.773 -0400", hash_original_method = "38D72D2E0F00AE5C39667CDDD41B271D", hash_generated_method = "D9CAF2DB0C281E72B180F24FDCC272C9")
    public final float getHistoricalTouchMajor(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float varDF2819CE064A1865E5C3505BF5B5D067_1518950916 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_2140235343 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2140235343;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.773 -0400", hash_original_method = "F3D94A1F01A3ECEF6DEDEA9361640BF9", hash_generated_method = "5E0D0BA87BD6CDBBC17BF998BC100067")
    public final float getHistoricalTouchMinor(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var4582A20AC28A85EA5725F71AE41C85C6_566660334 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_917567384 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_917567384;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.773 -0400", hash_original_method = "78FB77773CB43A5420D0F24849B540AD", hash_generated_method = "89E18EDDA6B56B77DBB5AFC84A26422E")
    public final float getHistoricalToolMajor(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var6108293C3F62F2149B6B7EB334942C59_779191263 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_365654205 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_365654205;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.773 -0400", hash_original_method = "4AB7745853006A3796DAD0E637CCA598", hash_generated_method = "64BFB6224E93E312E91345F0804A502F")
    public final float getHistoricalToolMinor(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var258F12248C69A4F414E1524429C431A2_873447025 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_287115267 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_287115267;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.774 -0400", hash_original_method = "160C0106DB8A4C6FBAA9569ABA0D68E8", hash_generated_method = "36897BB7B83197380277F3BC51B9DAD4")
    public final float getHistoricalOrientation(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var76B6D2D13D0E715410E04459FA7F94D1_2073822957 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1878508319 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1878508319;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.774 -0400", hash_original_method = "F645AABE3B2CF14D2790BA051F9F3FF1", hash_generated_method = "69698ABAF7FF6C338D857BCCDD0F4CE7")
    public final float getHistoricalAxisValue(int axis, int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        addTaint(axis);
        float var0EB5AC306AF9423D2AD5DFC87B794696_245849204 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_761358291 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_761358291;
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, pointerIndex, pos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.774 -0400", hash_original_method = "D80ADCD256759644414D5CBEC3C57D0B", hash_generated_method = "CE6881A87663F4E9E04A9F00FBC88289")
    public final void getHistoricalPointerCoords(int pointerIndex, int pos,
            PointerCoords outPointerCoords) {
        addTaint(outPointerCoords.getTaint());
        addTaint(pos);
        addTaint(pointerIndex);
        nativeGetPointerCoords(mNativePtr, pointerIndex, pos, outPointerCoords);
        // ---------- Original Method ----------
        //nativeGetPointerCoords(mNativePtr, pointerIndex, pos, outPointerCoords);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.774 -0400", hash_original_method = "26EA400A9751805DFF1D4CEEB005645B", hash_generated_method = "C494BF29960E344A51EB00A0E7460E04")
    public final int getEdgeFlags() {
        int var1F1A88DFEB524E5410CE9FDD29B55811_720260723 = (nativeGetEdgeFlags(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396721540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396721540;
        // ---------- Original Method ----------
        //return nativeGetEdgeFlags(mNativePtr);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.775 -0400", hash_original_method = "348B6A1C5666102E94291FA4791C249A", hash_generated_method = "EA090D97895AD6564575A4AFA6B859B5")
    public final void setEdgeFlags(int flags) {
        addTaint(flags);
        nativeSetEdgeFlags(mNativePtr, flags);
        // ---------- Original Method ----------
        //nativeSetEdgeFlags(mNativePtr, flags);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.775 -0400", hash_original_method = "34CE363FC32882BC3BBCF2E8ABF2B5B0", hash_generated_method = "F19B003A8A5DCF26BEDE0687FC59DBBE")
    public final void setAction(int action) {
        addTaint(action);
        nativeSetAction(mNativePtr, action);
        // ---------- Original Method ----------
        //nativeSetAction(mNativePtr, action);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.775 -0400", hash_original_method = "117CE161431F2ECDED077AD7F7467ADD", hash_generated_method = "A43AFFD412B7469BD843E7F8AC77342F")
    public final void offsetLocation(float deltaX, float deltaY) {
        addTaint(deltaY);
        addTaint(deltaX);
        nativeOffsetLocation(mNativePtr, deltaX, deltaY);
        // ---------- Original Method ----------
        //nativeOffsetLocation(mNativePtr, deltaX, deltaY);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.777 -0400", hash_original_method = "D9D9F7662138ADF2F9591F7DFAEB3F74", hash_generated_method = "4B343E5D10F32270E24CB92BB72969F7")
    public final void setLocation(float x, float y) {
        addTaint(y);
        addTaint(x);
        float oldX = getX();
        float oldY = getY();
        nativeOffsetLocation(mNativePtr, x - oldX, y - oldY);
        // ---------- Original Method ----------
        //float oldX = getX();
        //float oldY = getY();
        //nativeOffsetLocation(mNativePtr, x - oldX, y - oldY);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.777 -0400", hash_original_method = "622D19544C973DA41E1BE7D7819B5A41", hash_generated_method = "B526B313EECACB61293EDCBF9D94087D")
    public final void transform(Matrix matrix) {
        addTaint(matrix.getTaint());
        if(matrix == null)        
        {
            IllegalArgumentException var881CB0E00A863276B1D2E4F1FD5A1042_1050628889 = new IllegalArgumentException("matrix must not be null");
            var881CB0E00A863276B1D2E4F1FD5A1042_1050628889.addTaint(taint);
            throw var881CB0E00A863276B1D2E4F1FD5A1042_1050628889;
        } //End block
        nativeTransform(mNativePtr, matrix);
        // ---------- Original Method ----------
        //if (matrix == null) {
            //throw new IllegalArgumentException("matrix must not be null");
        //}
        //nativeTransform(mNativePtr, matrix);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.778 -0400", hash_original_method = "F001981BC7F115C74B7EB0136965714D", hash_generated_method = "B86CC0D9EC9660C246B11A2BA6B03DB4")
    public final void addBatch(long eventTime, float x, float y,
            float pressure, float size, int metaState) {
        addTaint(metaState);
        addTaint(size);
        addTaint(pressure);
        addTaint(y);
        addTaint(x);
        addTaint(eventTime);
        synchronized
(gSharedTempLock)        {
            ensureSharedTempPointerCapacity(1);
            final PointerCoords[] pc = gSharedTempPointerCoords;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.778 -0400", hash_original_method = "06E22018450E3E0892CD70DE9E19F211", hash_generated_method = "4D90FFB2F0E581C77625DC7738D7AAB0")
    public final void addBatch(long eventTime, PointerCoords[] pointerCoords, int metaState) {
        addTaint(metaState);
        addTaint(pointerCoords[0].getTaint());
        addTaint(eventTime);
        nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pointerCoords, metaState);
        // ---------- Original Method ----------
        //nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pointerCoords, metaState);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.778 -0400", hash_original_method = "542474DD15BDDADB068A65C6A3EEA8E2", hash_generated_method = "9FC0BA1A8E705CC83EBC4C1D62C0A07C")
    public final boolean isWithinBoundsNoHistory(float left, float top,
            float right, float bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        final int pointerCount = nativeGetPointerCount(mNativePtr);
for(int i = 0;i < pointerCount;i++)
        {
            final float x = nativeGetAxisValue(mNativePtr, AXIS_X, i, HISTORY_CURRENT);
            final float y = nativeGetAxisValue(mNativePtr, AXIS_Y, i, HISTORY_CURRENT);
            if(x < left || x > right || y < top || y > bottom)            
            {
                boolean var68934A3E9455FA72420237EB05902327_623977358 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1690566962 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1690566962;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_695048601 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1943554267 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1943554267;
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

    
    @DSModeled(DSC.BAN)
    private static final float clamp(float value, float low, float high) {
        if (value < low) {
            return low;
        } else if (value > high) {
            return high;
        }
        return value;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.780 -0400", hash_original_method = "C00E6E79D43678980DA0F4144A65F6A2", hash_generated_method = "12FB9FC8A1DED9DF8DAC7AFA2261E87E")
    public final MotionEvent clampNoHistory(float left, float top, float right, float bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        MotionEvent ev = obtain();
        synchronized
(gSharedTempLock)        {
            final int pointerCount = nativeGetPointerCount(mNativePtr);
            ensureSharedTempPointerCapacity(pointerCount);
            final PointerProperties[] pp = gSharedTempPointerProperties;
            final PointerCoords[] pc = gSharedTempPointerCoords;
for(int i = 0;i < pointerCount;i++)
            {
                nativeGetPointerProperties(mNativePtr, i, pp[i]);
                nativeGetPointerCoords(mNativePtr, i, HISTORY_CURRENT, pc[i]);
                pc[i].x = clamp(pc[i].x, left, right);
                pc[i].y = clamp(pc[i].y, top, bottom);
            } //End block
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
MotionEvent var589F943EB1E905D6F47E9BDE80F73551_1327258170 =             ev;
            var589F943EB1E905D6F47E9BDE80F73551_1327258170.addTaint(taint);
            return var589F943EB1E905D6F47E9BDE80F73551_1327258170;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.781 -0400", hash_original_method = "FBF170B15B2FFBEE1AB1D4E32A8773CA", hash_generated_method = "92B748DD5FDCA9FDF54DE391F46E363B")
    public final int getPointerIdBits() {
        int idBits = 0;
        final int pointerCount = nativeGetPointerCount(mNativePtr);
for(int i = 0;i < pointerCount;i++)
        {
            idBits |= 1 << nativeGetPointerId(mNativePtr, i);
        } //End block
        int var23FF2890029E50A8E723EA8D41956EF0_148179699 = (idBits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753347192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753347192;
        // ---------- Original Method ----------
        //int idBits = 0;
        //final int pointerCount = nativeGetPointerCount(mNativePtr);
        //for (int i = 0; i < pointerCount; i++) {
            //idBits |= 1 << nativeGetPointerId(mNativePtr, i);
        //}
        //return idBits;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.783 -0400", hash_original_method = "4F0FF8B26009CA9D26EE500AEFE507EC", hash_generated_method = "C69B9F3F9BDD6610297F374D69A3C0AF")
    public final MotionEvent split(int idBits) {
        addTaint(idBits);
        MotionEvent ev = obtain();
        synchronized
(gSharedTempLock)        {
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
for(int i = 0;i < oldPointerCount;i++)
            {
                nativeGetPointerProperties(mNativePtr, i, pp[newPointerCount]);
                final int idBit = 1 << pp[newPointerCount].id;
                if((idBit & idBits) != 0)                
                {
                    if(i == oldActionPointerIndex)                    
                    {
                        newActionPointerIndex = newPointerCount;
                    } //End block
                    map[newPointerCount] = i;
                    newPointerCount += 1;
                    newIdBits |= idBit;
                } //End block
            } //End block
            if(newPointerCount == 0)            
            {
                IllegalArgumentException varFB983EDAA1F0122ADE5F02B00A9FBB6B_1622115962 = new IllegalArgumentException("idBits did not match any ids in the event");
                varFB983EDAA1F0122ADE5F02B00A9FBB6B_1622115962.addTaint(taint);
                throw varFB983EDAA1F0122ADE5F02B00A9FBB6B_1622115962;
            } //End block
            int newAction;
            if(oldActionMasked == ACTION_POINTER_DOWN || oldActionMasked == ACTION_POINTER_UP)            
            {
                if(newActionPointerIndex < 0)                
                {
                    newAction = ACTION_MOVE;
                } //End block
                else
                if(newPointerCount == 1)                
                {
                    newAction = oldActionMasked == ACTION_POINTER_DOWN
                            ? ACTION_DOWN : ACTION_UP;
                } //End block
                else
                {
                    newAction = oldActionMasked
                            | (newActionPointerIndex << ACTION_POINTER_INDEX_SHIFT);
                } //End block
            } //End block
            else
            {
                newAction = oldAction;
            } //End block
            final int historySize = nativeGetHistorySize(mNativePtr);
for(int h = 0;h <= historySize;h++)
            {
                final int historyPos = h == historySize ? HISTORY_CURRENT : h;
for(int i = 0;i < newPointerCount;i++)
                {
                    nativeGetPointerCoords(mNativePtr, map[i], historyPos, pc[i]);
                } //End block
                final long eventTimeNanos = nativeGetEventTimeNanos(mNativePtr, historyPos);
                if(h == 0)                
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
                else
                {
                    nativeAddBatch(ev.mNativePtr, eventTimeNanos, pc, 0);
                } //End block
            } //End block
MotionEvent var589F943EB1E905D6F47E9BDE80F73551_1806414872 =             ev;
            var589F943EB1E905D6F47E9BDE80F73551_1806414872.addTaint(taint);
            return var589F943EB1E905D6F47E9BDE80F73551_1806414872;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.787 -0400", hash_original_method = "69A985781D7A79E036178DEB42E5F1F0", hash_generated_method = "45C356F1FD084331533DC59DB02353C0")
    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("MotionEvent { action=").append(actionToString(getAction()));
        final int pointerCount = getPointerCount();
for(int i = 0;i < pointerCount;i++)
        {
            msg.append(", id[").append(i).append("]=").append(getPointerId(i));
            msg.append(", x[").append(i).append("]=").append(getX(i));
            msg.append(", y[").append(i).append("]=").append(getY(i));
            msg.append(", toolType[").append(i).append("]=").append(
                    toolTypeToString(getToolType(i)));
        } //End block
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
String var684DADA25689ED258BFAD9F9C4AD23D2_1220090895 =         msg.toString();
        var684DADA25689ED258BFAD9F9C4AD23D2_1220090895.addTaint(taint);
        return var684DADA25689ED258BFAD9F9C4AD23D2_1220090895;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
    public static String axisToString(int axis) {
        String symbolicName = AXIS_SYMBOLIC_NAMES.get(axis);
        return symbolicName != null ? symbolicName : Integer.toString(axis);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    public static String toolTypeToString(int toolType) {
        String symbolicName = TOOL_TYPE_SYMBOLIC_NAMES.get(toolType);
        return symbolicName != null ? symbolicName : Integer.toString(toolType);
    }

    
    @DSModeled(DSC.BAN)
    public static MotionEvent createFromParcelBody(Parcel in) {
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeReadFromParcel(ev.mNativePtr, in);
        return ev;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.788 -0400", hash_original_method = "D732CA58C71ED959C0E1A12C336FC80D", hash_generated_method = "3F40403E65BDFBE08917BC35DE7F1C38")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeInt(PARCEL_TOKEN_MOTION_EVENT);
        nativeWriteToParcel(mNativePtr, out);
        // ---------- Original Method ----------
        //out.writeInt(PARCEL_TOKEN_MOTION_EVENT);
        //nativeWriteToParcel(mNativePtr, out);
    }

    
    public static final class PointerCoords {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.809 -0400", hash_original_field = "E4845520982C15184227C7CC9D20FD50", hash_generated_field = "616BA79E3CF38111CD6326A774A7BA12")

        private long mPackedAxisBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.809 -0400", hash_original_field = "5195E654A9F1469D3F33B6FBBCE24383", hash_generated_field = "74AC3FA36AA575C3DEE392AD51F3FC84")

        private float[] mPackedAxisValues;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.809 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "0CC4A8770822EF2A4B3BD536BBF6C113")

        public float x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.809 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E8D9A0915E4274087E59C025C4DCDA11")

        public float y;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.809 -0400", hash_original_field = "D99FAD96A5D0A7CB2EB41341EA556093", hash_generated_field = "8D3DD02B3785A296D75D1BFB99C62E42")

        public float pressure;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.809 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "295F60DE48801BD75A245B044AE96BA0")

        public float size;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.809 -0400", hash_original_field = "95BE195AF7AF1434BA03D8E831DC4D43", hash_generated_field = "6D6952CAD458217EEFCB2922EE3D3E82")

        public float touchMajor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.809 -0400", hash_original_field = "AF72E652DB6EACE533A5766E00C83453", hash_generated_field = "492641BCD483F61BC74CAF973D65A13D")

        public float touchMinor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.809 -0400", hash_original_field = "B0B8BF85D8A3FA50D314A293B6CA49AC", hash_generated_field = "32FD2A0018A7199A2ED20949B6E0486E")

        public float toolMajor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.809 -0400", hash_original_field = "2A170207574AE57015C852C226F8048D", hash_generated_field = "173EB15A07C0771733DC98A43E20CE98")

        public float toolMinor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.809 -0400", hash_original_field = "DA1639422AD8F355D2371428471379B5", hash_generated_field = "054A1E23DAAFDEC28AE3DA031EECF136")

        public float orientation;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.810 -0400", hash_original_method = "30C014872AED120D5788F672204C6D56", hash_generated_method = "02D472FB06CC6A49D31A045DF0321860")
        public  PointerCoords() {
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.810 -0400", hash_original_method = "4C1A041805DDE756B7430BBCF7A4A54D", hash_generated_method = "1C66435E307BF04A88E45A81EECD37FF")
        public  PointerCoords(PointerCoords other) {
            addTaint(other.getTaint());
            copyFrom(other);
            // ---------- Original Method ----------
            //copyFrom(other);
        }

        
        @DSModeled(DSC.SAFE)
        public static PointerCoords[] createArray(int size) {
            PointerCoords[] array = new PointerCoords[size];
            for (int i = 0; i < size; i++) {
                array[i] = new PointerCoords();
            }
            return array;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.810 -0400", hash_original_method = "5B10C041062144B27347C9202A1953B2", hash_generated_method = "85A3A31EE556A4BEA00BDAAD4B198A1A")
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.811 -0400", hash_original_method = "A2C68F8615572C95C5947791A8CC8026", hash_generated_method = "5DCA61032438B6B62952CB867DFFA53B")
        public void copyFrom(PointerCoords other) {
            final long bits = other.mPackedAxisBits;
            mPackedAxisBits = bits;
            if(bits != 0)            
            {
                final float[] otherValues = other.mPackedAxisValues;
                final int count = Long.bitCount(bits);
                float[] values = mPackedAxisValues;
                if(values == null || count > values.length)                
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.812 -0400", hash_original_method = "566631CFDB34A411EF93513211D62594", hash_generated_method = "F9590C8D45B9DFC59D1DC5B6CEAC7A3A")
        public float getAxisValue(int axis) {
            addTaint(axis);
switch(axis){
            case AXIS_X:
            float var9DD4E461268C8034F5C8564E155C67A6_1962722338 = (x);
                        float var546ADE640B6EDFBC8A086EF31347E768_194801435 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_194801435;
            case AXIS_Y:
            float var415290769594460E2E485922904F345D_1213823274 = (y);
                        float var546ADE640B6EDFBC8A086EF31347E768_1585287236 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1585287236;
            case AXIS_PRESSURE:
            float varD99FAD96A5D0A7CB2EB41341EA556093_165092171 = (pressure);
                        float var546ADE640B6EDFBC8A086EF31347E768_1279411742 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1279411742;
            case AXIS_SIZE:
            float varF7BD60B75B29D79B660A2859395C1A24_2024467331 = (size);
                        float var546ADE640B6EDFBC8A086EF31347E768_1944964876 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1944964876;
            case AXIS_TOUCH_MAJOR:
            float var95BE195AF7AF1434BA03D8E831DC4D43_653772770 = (touchMajor);
                        float var546ADE640B6EDFBC8A086EF31347E768_1843197222 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1843197222;
            case AXIS_TOUCH_MINOR:
            float varAF72E652DB6EACE533A5766E00C83453_1447559225 = (touchMinor);
                        float var546ADE640B6EDFBC8A086EF31347E768_229048371 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_229048371;
            case AXIS_TOOL_MAJOR:
            float varB0B8BF85D8A3FA50D314A293B6CA49AC_969737696 = (toolMajor);
                        float var546ADE640B6EDFBC8A086EF31347E768_38413388 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_38413388;
            case AXIS_TOOL_MINOR:
            float var2A170207574AE57015C852C226F8048D_888019350 = (toolMinor);
                        float var546ADE640B6EDFBC8A086EF31347E768_378090198 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_378090198;
            case AXIS_ORIENTATION:
            float varDA1639422AD8F355D2371428471379B5_1944474495 = (orientation);
                        float var546ADE640B6EDFBC8A086EF31347E768_1834047471 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1834047471;
            default:
            {
                if(axis < 0 || axis > 63)                
                {
                    IllegalArgumentException var1E87AAB4E5870C79215018F1CF48E911_1401062028 = new IllegalArgumentException("Axis out of range.");
                    var1E87AAB4E5870C79215018F1CF48E911_1401062028.addTaint(taint);
                    throw var1E87AAB4E5870C79215018F1CF48E911_1401062028;
                } //End block
                final long bits = mPackedAxisBits;
                final long axisBit = 1L << axis;
                if((bits & axisBit) == 0)                
                {
                    float varCFCD208495D565EF66E7DFF9F98764DA_660852233 = (0);
                                        float var546ADE640B6EDFBC8A086EF31347E768_1575941196 = getTaintFloat();
                    return var546ADE640B6EDFBC8A086EF31347E768_1575941196;
                } //End block
                final int index = Long.bitCount(bits & (axisBit - 1L));
                float var8A9471727EC5AB63F646A708829DFF04_1114356862 = (mPackedAxisValues[index]);
                                float var546ADE640B6EDFBC8A086EF31347E768_210464808 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_210464808;
            } //End block
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.813 -0400", hash_original_method = "55E9DEFA01615304E1434A1FAB8328FA", hash_generated_method = "CCD08BBA72A703484708E23DCCC286B2")
        public void setAxisValue(int axis, float value) {
            addTaint(axis);
switch(axis){
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
            default:
            {
                if(axis < 0 || axis > 63)                
                {
                    IllegalArgumentException var1E87AAB4E5870C79215018F1CF48E911_631455452 = new IllegalArgumentException("Axis out of range.");
                    var1E87AAB4E5870C79215018F1CF48E911_631455452.addTaint(taint);
                    throw var1E87AAB4E5870C79215018F1CF48E911_631455452;
                } //End block
                final long bits = mPackedAxisBits;
                final long axisBit = 1L << axis;
                final int index = Long.bitCount(bits & (axisBit - 1L));
                float[] values = mPackedAxisValues;
                if((bits & axisBit) == 0)                
                {
                    if(values == null)                    
                    {
                        values = new float[INITIAL_PACKED_AXIS_VALUES];
                        mPackedAxisValues = values;
                    } //End block
                    else
                    {
                        final int count = Long.bitCount(bits);
                        if(count < values.length)                        
                        {
                            if(index != count)                            
                            {
                                System.arraycopy(values, index, values, index + 1,
                                            count - index);
                            } //End block
                        } //End block
                        else
                        {
                            float[] newValues = new float[count * 2];
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
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.813 -0400", hash_original_field = "33446AA70F42B7C22C25CFDF4E916659", hash_generated_field = "1ED50B8C8EE9915850360B0973B4FC02")

        private static final int INITIAL_PACKED_AXIS_VALUES = 8;
    }


    
    public static final class PointerProperties {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.813 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.813 -0400", hash_original_field = "F803A61F4662F15B2A4B72308BD45F04", hash_generated_field = "E5CA883B5E8E2CF4928B3E305240E7C6")

        public int toolType;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.813 -0400", hash_original_method = "D6AAE40F539D7383E827DA395512E95B", hash_generated_method = "207B464AAB7566FD25D2646B7EE6C19D")
        public  PointerProperties() {
            clear();
            // ---------- Original Method ----------
            //clear();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.813 -0400", hash_original_method = "0B0B44B5B3A0DCF648446956F27785E9", hash_generated_method = "ADD0C86B658EF40FE7B592A4493E84A0")
        public  PointerProperties(PointerProperties other) {
            addTaint(other.getTaint());
            copyFrom(other);
            // ---------- Original Method ----------
            //copyFrom(other);
        }

        
        @DSModeled(DSC.SAFE)
        public static PointerProperties[] createArray(int size) {
            PointerProperties[] array = new PointerProperties[size];
            for (int i = 0; i < size; i++) {
                array[i] = new PointerProperties();
            }
            return array;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.813 -0400", hash_original_method = "ADC6A83F955A9ED0C1C75B5F08682583", hash_generated_method = "DFC90B75E706F2F74BBF473BA904F663")
        public void clear() {
            id = INVALID_POINTER_ID;
            toolType = TOOL_TYPE_UNKNOWN;
            // ---------- Original Method ----------
            //id = INVALID_POINTER_ID;
            //toolType = TOOL_TYPE_UNKNOWN;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_method = "1E34ECE529256025A33CF5DCBE029131", hash_generated_method = "83EE2C55C6A446D371F6C2FC0D637123")
        public void copyFrom(PointerProperties other) {
            id = other.id;
            toolType = other.toolType;
            // ---------- Original Method ----------
            //id = other.id;
            //toolType = other.toolType;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "6E4EF440EBC2808EB9427311B59A1879", hash_generated_field = "1E55FD918071A214A5C67DF1505BB56B")

    private static final long NS_PER_MS = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "72335DCE9A3EDFEDA119916AF8BD9A52", hash_generated_field = "FA3C17D544830BC1BEE55D29729BDFE3")

    private static final boolean TRACK_RECYCLED_LOCATION = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "337218C9F350445474335E0ED8EB52D2", hash_generated_field = "122232306FDB60B34ACA42DBAA65B736")

    public static final int INVALID_POINTER_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "034E2BCD80D0FE32BEE35A26F527AB82", hash_generated_field = "464488178905DF6887AEEC102D03F9BB")

    public static final int ACTION_MASK             = 0xff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "05E3DA568602DAD9EA3C414607B71E65", hash_generated_field = "B56FBABE5CC8DDE909CEA8CDE98BA93D")

    public static final int ACTION_DOWN             = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "6D72F1F84E251024F9C1BAF7B002F529", hash_generated_field = "E9419BD1576C4C89CB972C93BF43E7C5")

    public static final int ACTION_UP               = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "E0AAA7BED07FEFB1355300A23A152F90", hash_generated_field = "0869EE70BD47CB90D812F686B7F0D216")

    public static final int ACTION_MOVE             = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "C46423CE3E5642BA0CB7AB6CB09262AE", hash_generated_field = "CCD39E7D9940D088C4EBAE690B5B3006")

    public static final int ACTION_CANCEL           = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "5B47F521CF7C2C903B879280CC51E19F", hash_generated_field = "B53AF36739EBD3146722B0AB3CAF54B6")

    public static final int ACTION_OUTSIDE          = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "596B10C23830633246B5FE119303CA31", hash_generated_field = "BE1BA8B002AC6D11B1BA8B25140F3104")

    public static final int ACTION_POINTER_DOWN     = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "1CD52FBA3CE6A637AE86BF305E1727A2", hash_generated_field = "779F82BEF077301CD2887D1C33590F74")

    public static final int ACTION_POINTER_UP       = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "A117FB885030C87F8035EE8197E01274", hash_generated_field = "A31BF98337FB8359E97DA48D76D80977")

    public static final int ACTION_HOVER_MOVE       = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "EDD00CD16649F89FF44DD9C0E161B238", hash_generated_field = "D4C11BB0C70739D756D7BA7A8EBDE32D")

    public static final int ACTION_SCROLL           = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "E6889A317885B7F3FCFCB516DDE1B506", hash_generated_field = "6EED9A028D9812B11E3EC6500A22417D")

    public static final int ACTION_HOVER_ENTER      = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "5A019C5D2F9BBBECE84DA46559873CDE", hash_generated_field = "36537B951CA8A88E1E580F444A68C4EB")

    public static final int ACTION_HOVER_EXIT       = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.816 -0400", hash_original_field = "F94A33E7C5ACFBEFDFBB09F0FB9B278A", hash_generated_field = "E260033975F8D36BD53DB361D54BA2BF")

    public static final int ACTION_POINTER_INDEX_MASK  = 0xff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "DAB0332B2F0024984DE4DD67C040BC0F", hash_generated_field = "3ED9AD85BB2784B1321927FB5C085339")

    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "9592F84893EF5C92909845A138CAE395", hash_generated_field = "0E6D248BF8E40C6A30CD011E4FE93537")

    @Deprecated
    public static final int ACTION_POINTER_1_DOWN   = ACTION_POINTER_DOWN | 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "7F4BF3EB26FAD7B49445118A59CE6146", hash_generated_field = "2A2F376950DB01CC014C8F15C5D29770")

    @Deprecated
    public static final int ACTION_POINTER_2_DOWN   = ACTION_POINTER_DOWN | 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "AA3C2A077F9DEEFBA6F2542C0560FB1B", hash_generated_field = "9C71C2EB30843366313F3020BE578C26")

    @Deprecated
    public static final int ACTION_POINTER_3_DOWN   = ACTION_POINTER_DOWN | 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "449EA013BBCDA169B9EF1D2297500187", hash_generated_field = "CB217DFD0D7D2A2D8289D57696E595C7")

    @Deprecated
    public static final int ACTION_POINTER_1_UP     = ACTION_POINTER_UP | 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "91D34AE0179B0BC5900FFCB630718519", hash_generated_field = "0531D8E2B94086788DA257D61DD61C0F")

    @Deprecated
    public static final int ACTION_POINTER_2_UP     = ACTION_POINTER_UP | 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "F4E6043EA1CA67A36A2F06C954118606", hash_generated_field = "98C2F8F94E43CA43968FDCDBCC9896C4")

    @Deprecated
    public static final int ACTION_POINTER_3_UP     = ACTION_POINTER_UP | 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "E323657B2EB80B422379A9CEBE0A7866", hash_generated_field = "21CA20F1626331DC2869522A2DE48834")

    @Deprecated
    public static final int ACTION_POINTER_ID_MASK  = 0xff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "B6823DDE720D0C768C88F68459F98292", hash_generated_field = "674FBE2D655FD483B823B2E251529FF3")

    @Deprecated
    public static final int ACTION_POINTER_ID_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "029786C6547ED0693759CAAEFEA9CFC0", hash_generated_field = "D55190196D2C1F6E3FFFC84FA0B9D772")

    public static final int FLAG_WINDOW_IS_OBSCURED = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "550A819DF1874DD6CBEB9E34B7E02CA2", hash_generated_field = "22C757AFB129CA98FC86BD04BEE94F98")

    public static final int FLAG_TAINTED = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "A633F8D6629EE7B06C2FD6D1B0DC9450", hash_generated_field = "E88E0AA9A676F8906011C2C253859C66")

    public static final int EDGE_TOP = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "A822268AD0B774AEEE14EC8CC8D9F93B", hash_generated_field = "7F13D97BAA00BFCDC5B911BB5B6DCDF3")

    public static final int EDGE_BOTTOM = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "8B1FDF0477E0C35DA2FB7C7B8306974A", hash_generated_field = "96B2B8C704DDAD0603C6C6E2FFC340B1")

    public static final int EDGE_LEFT = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "A3A04219B91FA85B01EA955DFFF5FEB5", hash_generated_field = "4B4418A2700C288E6EFE7AF6B858A111")

    public static final int EDGE_RIGHT = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "F43EDDBFB6367074F45ECA2C476C6565", hash_generated_field = "6AC2F269D8C677A5928AAB4766B0AFA4")

    public static final int AXIS_X = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "B104E19452EE81C2A619F4D57E3AEDBE", hash_generated_field = "1F1942945032A87C66ACA5752705A256")

    public static final int AXIS_Y = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "6542F537176A3A95C9638B5D2D6D3282", hash_generated_field = "5CB739150541FFE06EFD5DECAA58BF2C")

    public static final int AXIS_PRESSURE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "271FFE604598307C9BD49A632CD69F2C", hash_generated_field = "F805D88CFB32566B5D69E445454FA20B")

    public static final int AXIS_SIZE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "76C24AF7C4E7B5EF86EC8B7AA695C99B", hash_generated_field = "4422123708A385A40B3A3EAD28C77CA0")

    public static final int AXIS_TOUCH_MAJOR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "FDD97DCBF16D7D35D1DE9CA5AB8B0EE9", hash_generated_field = "9BD07319C2DC512FC7AFF06DB4C457EB")

    public static final int AXIS_TOUCH_MINOR = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "4CECC8FEA7DFD80C61892B5D9499F332", hash_generated_field = "3A23BEE8699344F8699632E58AAE9D00")

    public static final int AXIS_TOOL_MAJOR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "2280E38346B560BA8AFA6F674CCF146D", hash_generated_field = "F26604DCEE776E17C73C06ABB61691F6")

    public static final int AXIS_TOOL_MINOR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "034AF53CD5FD7BC7833BEAD02993E949", hash_generated_field = "2A1393B38A6522964DCE18C89C02987A")

    public static final int AXIS_ORIENTATION = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "6A09A3E15FC599ADAD44D13102C405DD", hash_generated_field = "3653EDC97D1EC153035B8B2CF03F0D9F")

    public static final int AXIS_VSCROLL = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "ADCA61A712EC2EAE4DA4FCDD6574618C", hash_generated_field = "92F839C5EBC2322D5FA86535F6F819CB")

    public static final int AXIS_HSCROLL = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "5952DC7A036BAD5A2FA3BB4702C69033", hash_generated_field = "AF121E953BE1BD481D0CFED4A68E74C0")

    public static final int AXIS_Z = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "102726DF7AC3CD66F5F16B29BE4E0C36", hash_generated_field = "F9C0DE51E0127685ECA28E542A120E88")

    public static final int AXIS_RX = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.817 -0400", hash_original_field = "225D93A029576C17E912D37880E035F3", hash_generated_field = "0C4C76335C9A3564DACCCDBE8DD301F2")

    public static final int AXIS_RY = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "3622454F61D2BEAFB3A7C20E8B67794C", hash_generated_field = "FE837C29D6032EC2960992B9D8A8B178")

    public static final int AXIS_RZ = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "B89A4C4024CEA0CBEF2F49139937E488", hash_generated_field = "95D53DACF181EE3407879E3C0B3371DA")

    public static final int AXIS_HAT_X = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "F8B0B5501EAF46948DD4D8DFF857FF22", hash_generated_field = "448C69D0D61F2BF459C3AC283A9A3DD2")

    public static final int AXIS_HAT_Y = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "08B1FD10B1CA6EAEC83C43A9C0979C60", hash_generated_field = "4450CC9F108DED3391D6ED8F0D534120")

    public static final int AXIS_LTRIGGER = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "980E2D34290DF1ACCB31AFE81E0A824D", hash_generated_field = "275AE4D63A24B8018CE3E210BAC8D939")

    public static final int AXIS_RTRIGGER = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "267E7C0549F05F5D932F84A17DB329C1", hash_generated_field = "538CDE95EB2664616EE4F8F418B16FCF")

    public static final int AXIS_THROTTLE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "44FEE1E278CC7C2339B1E23FBF344BAE", hash_generated_field = "556882041792FB019CA717764224D5C4")

    public static final int AXIS_RUDDER = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "DA830D9524B06F5E2D1FE72F350FA3B0", hash_generated_field = "D3B7AC7DA5A4B49C56D33CA3953C8391")

    public static final int AXIS_WHEEL = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "D9DD16376FECC1C78B4D3A42DFACDB62", hash_generated_field = "B56F86F8DDA863909AE502D90FA7D4A4")

    public static final int AXIS_GAS = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "3D955FBE6867B617A6459F1390B213ED", hash_generated_field = "7148E428BBB18A5A04C2D90A4D20C2D2")

    public static final int AXIS_BRAKE = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "FB55C8949807223E3375F0A2504F360A", hash_generated_field = "53EBC10458EF090346DB7C3BF7B8B449")

    public static final int AXIS_DISTANCE = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "8382AC5A85A82E20003B1AC360EF6D07", hash_generated_field = "579F39E86B98900179C06E9A07BE7C7B")

    public static final int AXIS_TILT = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "70021A9C7A753DA59C64F0581D83C67B", hash_generated_field = "2C24AD3C3E56DD84D0733A0B91218D75")

    public static final int AXIS_GENERIC_1 = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "DE2D083AFBB03257E89BDA922D0E4CAD", hash_generated_field = "D5EDF8D95D30F8707CB60CE48E5D080D")

    public static final int AXIS_GENERIC_2 = 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "9FEFCC69BCFDFC864584838013FE5B46", hash_generated_field = "0FB2B7871027C51D19E6ADDB6629599D")

    public static final int AXIS_GENERIC_3 = 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "9243522AF86AC2FA928B71B7E668CC47", hash_generated_field = "B3834C6A5E7EAC276B34400E316CC889")

    public static final int AXIS_GENERIC_4 = 35;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "F0A6A5F912965A4325BA778B910D6E59", hash_generated_field = "D771A2C8BF7E6631141C9F156725F986")

    public static final int AXIS_GENERIC_5 = 36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.818 -0400", hash_original_field = "23CC53509B48EF6225466AC21958D6F4", hash_generated_field = "5ADBF1379367815D17640566262ADBDC")

    public static final int AXIS_GENERIC_6 = 37;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "312922167BECA1728E0C8042C725C6BC", hash_generated_field = "CABE9E3D1339B834B58E2AC551B60D70")

    public static final int AXIS_GENERIC_7 = 38;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "9FCFEF7D88A4651EAE19D026F4636885", hash_generated_field = "783DFA0925833D6927778A6752C33469")

    public static final int AXIS_GENERIC_8 = 39;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "D2142F81309B4EC8E625175D39A4E1F0", hash_generated_field = "844B22BFFE980B1170B8E78B193CD8F8")

    public static final int AXIS_GENERIC_9 = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "7575EC92A58C3C2DC2C8CCC553B15C0D", hash_generated_field = "F52491FA1506F81B61F5BBCAD317F2D4")

    public static final int AXIS_GENERIC_10 = 41;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "89BA0631B47758FC05670AE71E07238B", hash_generated_field = "441A2A8984D04F945C0B9706F4D91238")

    public static final int AXIS_GENERIC_11 = 42;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "898A18C6347222CD54AF74A9ECCCEE58", hash_generated_field = "6EE9D87F1B155C3A9E15C5BFB57DB156")

    public static final int AXIS_GENERIC_12 = 43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "B97F163EE5AB936FB897D250305FDD0F", hash_generated_field = "0C980E1F71AC4BD10A6D1136200C35B1")

    public static final int AXIS_GENERIC_13 = 44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "5C89506ADEC1D512A306F0807528A45C", hash_generated_field = "08EDA9B50DF874F18FD4A782BFF79258")

    public static final int AXIS_GENERIC_14 = 45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "7EB5AA2C6AC2C895F916E91C7C27BF6D", hash_generated_field = "9B7002F98DD35624F49E82F9F27BEA43")

    public static final int AXIS_GENERIC_15 = 46;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "42B8B524D844DB897F8E010F49DF34D9", hash_generated_field = "CDB6932C5544664A6FAAE7570CEF1ED8")

    public static final int AXIS_GENERIC_16 = 47;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "530A0FA730B9B28A10F6D39E022E143B", hash_generated_field = "D95AC969582FA3A63A7662A57753465D")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "AA456FB196DE0D5C68D5DA0ABB2B1665", hash_generated_field = "ADA948F0304197BC40CACAE24C6ECB05")

    public static final int BUTTON_PRIMARY = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "9CDE7875F922E491FF1696F779D48BD9", hash_generated_field = "699964DE06376B73FD25E1C2E308AF7B")

    public static final int BUTTON_SECONDARY = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "95C57E1DA2F91AA9F277DFEB59325C0F", hash_generated_field = "0EFC57E0035C368753C281B7448CCAD7")

    public static final int BUTTON_TERTIARY = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "87ED530C352322D1000AED214027E0E0", hash_generated_field = "5A526B3B078557E38DB5D4C91419279E")

    public static final int BUTTON_BACK = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "02CD6CBC72EC09DBD9089D39090DEFFF", hash_generated_field = "4E2DD22E6782E832F99D62265E33DC7B")

    public static final int BUTTON_FORWARD = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "9C9A5C3B4382C6FBD48D16D607582F30", hash_generated_field = "BAA383FC1DC8D8F1DFD855E89C02D485")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "D7697B822D45F5BDF64FF3656AE39897", hash_generated_field = "B997CD436D37980DF5D7404E593DC402")

    public static final int TOOL_TYPE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "DDF16792C91BD89ED3CEB72B2F655A3A", hash_generated_field = "C864443B9D1FDB0CC8BE96AE33701299")

    public static final int TOOL_TYPE_FINGER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "FD13CF4F11329C29AEA3974918542E2A", hash_generated_field = "5BBE29494AB919D60EB460BF7FABACCD")

    public static final int TOOL_TYPE_STYLUS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.819 -0400", hash_original_field = "EDA620D7300731B22711740B56121B0F", hash_generated_field = "4F5A6CDBC3D361EDE9CAD667AC25320F")

    public static final int TOOL_TYPE_MOUSE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "E8E4790D94F06E7A95BA1EC847CFA0F9", hash_generated_field = "09C1A33B09293914694BF2A3886AC6DB")

    public static final int TOOL_TYPE_ERASER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "E4532CF792A1279111A19DAB2ADAADBA", hash_generated_field = "D272CAAEB0300373C7A6923AD9627B5E")

    private static final SparseArray<String> TOOL_TYPE_SYMBOLIC_NAMES = new SparseArray<String>();
    static {
        SparseArray<String> names = TOOL_TYPE_SYMBOLIC_NAMES;
        names.append(TOOL_TYPE_UNKNOWN, "TOOL_TYPE_UNKNOWN");
        names.append(TOOL_TYPE_FINGER, "TOOL_TYPE_FINGER");
        names.append(TOOL_TYPE_STYLUS, "TOOL_TYPE_STYLUS");
        names.append(TOOL_TYPE_MOUSE, "TOOL_TYPE_MOUSE");
        names.append(TOOL_TYPE_ERASER, "TOOL_TYPE_ERASER");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "9319C0C1DC56FFF2B6175EA6D9D0FA3B", hash_generated_field = "B0BEAD643F65C07DAE0B28D2861E52D4")

    private static final int HISTORY_CURRENT = -0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "4E0EEF34DE1E78AC4C7D48E7B28D3753", hash_generated_field = "632CD138CDBCADE9A63F9B23105E1648")

    private static final int MAX_RECYCLED = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "79F53341661E7BAB58D441DAC7E61782", hash_generated_field = "4D2E3DEDF37103D77BF3BB46692742C8")

    private static final Object gRecyclerLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "62CB28CE8AC6DBF69FB484B561C6DE93", hash_generated_field = "695DE00CD65E15FE07938D99F2CA2696")

    private static int gRecyclerUsed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "7BA7389C24C0F124608D5C2226AD35F9", hash_generated_field = "E9FD3DB4A4C51C360253148C4F1C8508")

    private static MotionEvent gRecyclerTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "7CC0A11C5494EABD208B60B4042F676B", hash_generated_field = "ACFC36EAB247226A536D30FD1648AAC7")

    private static final Object gSharedTempLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "7ACA3B441BEC8C942E34BE426D1BD777", hash_generated_field = "1C70655B0F01405596723D256AD5AE2B")

    private static PointerCoords[] gSharedTempPointerCoords;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "909596135E37414184F98BA28ABF7B47", hash_generated_field = "7767E5DED892F800315C4BF8ECA945E5")

    private static PointerProperties[] gSharedTempPointerProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "7D5CE052D163BC3BEA8C336A1127A9FA", hash_generated_field = "A9BB8E94115BE6A30724987AE7313B53")

    private static int[] gSharedTempPointerIndexMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.820 -0400", hash_original_field = "92338855F3FDCA2FD9317526465F4D98", hash_generated_field = "C140DAE13300F0DB81E6D0FF25B21CC4")

    public static final Parcelable.Creator<MotionEvent> CREATOR
            = new Parcelable.Creator<MotionEvent>() {
        @DSModeled(DSC.SAFE)
        public MotionEvent createFromParcel(Parcel in) {
            in.readInt(); 
            return MotionEvent.createFromParcelBody(in);
        }

        @DSModeled(DSC.SAFE)
        public MotionEvent[] newArray(int size) {
            return new MotionEvent[size];
        }
    };
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

