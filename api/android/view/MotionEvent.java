package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseArray;

public final class MotionEvent extends InputEvent implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.538 -0400", hash_original_field = "AE1F3581ADE8C1B0F98DFDE5A4F536A3", hash_generated_field = "23CD98EE9F206841B49D023F257D02A5")

    private int mNativePtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.538 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "4ED1BADBA3F9AC6D1D2BD2B16B6BF967")

    private MotionEvent mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.538 -0400", hash_original_field = "285FE8BBC1049056117639C63D1605B9", hash_generated_field = "4E4D5EFD76E218484C8A2F86B097FF08")

    private RuntimeException mRecycledLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.538 -0400", hash_original_field = "1212A62D731F217836716E35FA12386C", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.539 -0400", hash_original_method = "B1B69F583261D8BEEC921FF43580AA66", hash_generated_method = "40B8D4E791D456515D6D7EBB1643CE79")
    private  MotionEvent() {
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.541 -0400", hash_original_method = "3F0B5C050D986DD9F1F0F2A742C616C8", hash_generated_method = "385D2C3489242CAC5323F682E351928B")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
    if(mNativePtr != 0)            
            {
                nativeDispose(mNativePtr);
                mNativePtr = 0;
            } 
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
                
                
            
        
            
        
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.542 -0400", hash_original_method = "78DE11FBBF58608981D1F74EEB443B54", hash_generated_method = "74DD44E334932FCFCDB270A995A4BE5D")
    @Override
    public MotionEvent copy() {
MotionEvent var3E50018916F9DBFE0D39D9282EBAD97D_1788282765 =         obtain(this);
        var3E50018916F9DBFE0D39D9282EBAD97D_1788282765.addTaint(taint);
        return var3E50018916F9DBFE0D39D9282EBAD97D_1788282765;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.543 -0400", hash_original_method = "187F7D3A42078A42C8212C3EFE0E8B16", hash_generated_method = "2C0E5F30F189C3475E78FBBB5441F3DC")
    public final void recycle() {
    if(TRACK_RECYCLED_LOCATION)        
        {
    if(mRecycledLocation != null)            
            {
                RuntimeException var560DEC13FEE3B93EDBE65D649F29206C_395622628 = new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
                var560DEC13FEE3B93EDBE65D649F29206C_395622628.addTaint(taint);
                throw var560DEC13FEE3B93EDBE65D649F29206C_395622628;
            } 
            mRecycledLocation = new RuntimeException("Last recycled here");
        } 
        else
        {
    if(mRecycled)            
            {
                RuntimeException var4B7E168C1631949DA6BD5DCA24D52129_1372245177 = new RuntimeException(toString() + " recycled twice!");
                var4B7E168C1631949DA6BD5DCA24D52129_1372245177.addTaint(taint);
                throw var4B7E168C1631949DA6BD5DCA24D52129_1372245177;
            } 
            mRecycled = true;
        } 
        synchronized
(gRecyclerLock)        {
    if(gRecyclerUsed < MAX_RECYCLED)            
            {
                gRecyclerUsed++;
                mNext = gRecyclerTop;
                gRecyclerTop = this;
            } 
        } 
        
        
            
                
            
            
        
            
                
            
            
        
        
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.543 -0400", hash_original_method = "A082C8E505553F853E56AAFC11CF0CDA", hash_generated_method = "7607C4622D338DF7A6F483ECCB464AFD")
    public final void scale(float scale) {
        addTaint(scale);
        nativeScale(mNativePtr, scale);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.543 -0400", hash_original_method = "E51EA2AB032E4C79CC226174E2601818", hash_generated_method = "62830FEE1EF7624C592641173B8F6DEC")
    @Override
    public final int getDeviceId() {
        int varD5036D44BBD58011C7C3053FEF587C41_1016687158 = (nativeGetDeviceId(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012625669 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012625669;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.543 -0400", hash_original_method = "44501F684180CAB98F3511C2614C7994", hash_generated_method = "20727B06B010BC13FC6762BFD673E3E5")
    @Override
    public final int getSource() {
        int varD7C59EEED2658A02199C3A3437633508_1213597577 = (nativeGetSource(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691601768 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691601768;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.543 -0400", hash_original_method = "1502AF3F26B6DD95879512031D9FB73E", hash_generated_method = "07A1FD7FD3D3FD477882D5EF4A4A6E49")
    @Override
    public final void setSource(int source) {
        addTaint(source);
        nativeSetSource(mNativePtr, source);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.543 -0400", hash_original_method = "FA5880EB8F61D955AC5922ACE620FCE2", hash_generated_method = "7D4A938FFE310A996DFA73DA68D9F655")
    public final int getAction() {
        int var80A98A7BBE69E4DF94992B8C4CCEB9C8_2008316375 = (nativeGetAction(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_104041371 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_104041371;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.543 -0400", hash_original_method = "268411790684740D49A019DF59E1FFBB", hash_generated_method = "2B366797046497BB1EABA41075F8E5BE")
    public final int getActionMasked() {
        int varACC094C520CCDFB8E868FFF09CB65B46_1331207271 = (nativeGetAction(mNativePtr) & ACTION_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1446718385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1446718385;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.544 -0400", hash_original_method = "464EE1689B645958C6F5E17990D5ECA4", hash_generated_method = "14F7E47ABD81C440EB3872FF35AA09B3")
    public final int getActionIndex() {
        int var7500415F7360866D42A5FB7EE3347BCF_479802053 = ((nativeGetAction(mNativePtr) & ACTION_POINTER_INDEX_MASK)
                >> ACTION_POINTER_INDEX_SHIFT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215346125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215346125;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.544 -0400", hash_original_method = "3A9CDEA51D903248E7ACBBA8C3F57155", hash_generated_method = "62A6F1281B469D6CF76BE0A64390B140")
    public final boolean isTouchEvent() {
        boolean varDFE61C24DD01208F966A163BDD38A4CD_2074422938 = (nativeIsTouchEvent(mNativePtr));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1012227304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1012227304;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.544 -0400", hash_original_method = "A25E485C356A262F519C0A5841CFA47B", hash_generated_method = "99CF4970FA2F4BD53BC18B2FA6E4CAE6")
    public final int getFlags() {
        int varA526BA649589E0CDCE94D6C8B3100B23_603956284 = (nativeGetFlags(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1700625679 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1700625679;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.544 -0400", hash_original_method = "24A8A0C0077001C335E0B5C917301FE4", hash_generated_method = "4E5006250BE13B1DA19E293A693425B8")
    @Override
    public final boolean isTainted() {
        final int flags = getFlags();
        boolean varF9FF507AC72E6282571250C24C98B15B_1358648073 = ((flags & FLAG_TAINTED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524276067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524276067;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.544 -0400", hash_original_method = "96C1138F844BE852B50B0529E539E061", hash_generated_method = "57EF329636FE9540DF3DC82261F2E901")
    @Override
    public final void setTainted(boolean tainted) {
        addTaint(tainted);
        final int flags = getFlags();
        nativeSetFlags(mNativePtr, tainted ? flags | FLAG_TAINTED : flags & ~FLAG_TAINTED);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.544 -0400", hash_original_method = "5F4C05CD4E223E38846D15A6EA0DF305", hash_generated_method = "EC8437A4EC3563BAAD45427CCA355F60")
    public final long getDownTime() {
        long var11BA13D60255B6CD28CC817BD12A69DC_1728612884 = (nativeGetDownTimeNanos(mNativePtr) / NS_PER_MS);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1125249744 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1125249744;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.544 -0400", hash_original_method = "97B3432DE604A4A8C3339017F5056697", hash_generated_method = "204CBCF8A37B0B817930F4C634EFA42C")
    public final void setDownTime(long downTime) {
        addTaint(downTime);
        nativeSetDownTimeNanos(mNativePtr, downTime * NS_PER_MS);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.544 -0400", hash_original_method = "CCF6A1C7FFBA398090457272FB07E7C9", hash_generated_method = "ADBE1AF3F6B5A6644070DB193DC35970")
    public final long getEventTime() {
        long var2B7CDB1B7E0B9584D608D19D659E6265_261685018 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT) / NS_PER_MS);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_911494273 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_911494273;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.544 -0400", hash_original_method = "9EB1FC24DA069289850F91A3F8734D9A", hash_generated_method = "1D61851DCF751F1EED172E8DE63A0D8F")
    public final long getEventTimeNano() {
        long varB79ED88242A7E101FD2975DEAA6D4999_2040502051 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1653064604 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1653064604;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.545 -0400", hash_original_method = "4BF6642E766343B332FD98949BC6C582", hash_generated_method = "A412148B073FAC714CB5291FB3503C92")
    public final float getX() {
        float var3EF7A7583F95AE482084502D0DB5A8CD_805849790 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1798130210 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1798130210;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.545 -0400", hash_original_method = "91A63DEAB3A8AC7438EA04466792BD82", hash_generated_method = "6A3768F428AF42E7AC3EE2A91F8743C1")
    public final float getY() {
        float var7709F8DC42991A9E1DFD10831DB35973_260583332 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_822090529 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_822090529;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.545 -0400", hash_original_method = "6675B94FFDE5461AE8829AF0934758CB", hash_generated_method = "332C4B2D3F03BF8069E7072562A3EC5A")
    public final float getPressure() {
        float varC8B9B3D4B8B60D775828193450E8BE3F_1621079882 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_2023828923 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2023828923;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.545 -0400", hash_original_method = "04BA234B263118C319F9FB3039E4C966", hash_generated_method = "F26F9F6E6D38C33638FD5B2DC627FD58")
    public final float getSize() {
        float var6E061C316CD065948A93F098D1140243_1977200912 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_528823099 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_528823099;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.545 -0400", hash_original_method = "7EDCA08C9EC8F904EE9855CC249509CB", hash_generated_method = "55B9A56684BD61EFDE45E83F8B023D0C")
    public final float getTouchMajor() {
        float varBDD96393822720D4B1BFA1D54C6BD258_1730316310 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1363701567 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1363701567;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.545 -0400", hash_original_method = "0D1B5526DE02F52B1563B7D7F6F58090", hash_generated_method = "014E14C183C488F1EAA1187146D07135")
    public final float getTouchMinor() {
        float var1F412634D4A047597000DDD05740D35E_778602457 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_337558649 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_337558649;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.545 -0400", hash_original_method = "88DA06A5CC2E8F8456F3789E8A68ED44", hash_generated_method = "60A50B11673DA475494426B593AC7C16")
    public final float getToolMajor() {
        float var1F91C2975A484921DAC7E89073521880_1545111767 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1564471315 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1564471315;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.545 -0400", hash_original_method = "68541C2106990EEA679DCE03A62D7FCC", hash_generated_method = "83571546D950742AF11F0659C424F895")
    public final float getToolMinor() {
        float varF9BF461A999AEC47E41774F9DA67773D_384063515 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_870788515 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_870788515;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.545 -0400", hash_original_method = "6DB87F8256212E2B4D49883D1C47D372", hash_generated_method = "A384D32C1FAB074EEEAFF230B4C348FE")
    public final float getOrientation() {
        float var6737447A3971B8877C8DF74C50D93D2F_168713661 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_548120855 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_548120855;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.546 -0400", hash_original_method = "630AA047225B25427528E4D32F567B17", hash_generated_method = "34D59EB29DD7F8484A68A6D2354B2A2C")
    public final float getAxisValue(int axis) {
        addTaint(axis);
        float var822AAE1DFCB4316BA34CD1785FDDF097_2144988852 = (nativeGetAxisValue(mNativePtr, axis, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_193241341 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_193241341;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.546 -0400", hash_original_method = "2050CCC0293D52B162C880AD9BC3C6F6", hash_generated_method = "E6F1067DAD18EBB05431FEBB806E5EDB")
    public final int getPointerCount() {
        int var7A4B6F285807138C0798AE2E9C4D751D_412796596 = (nativeGetPointerCount(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83719548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83719548;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.546 -0400", hash_original_method = "43D465AFB7AC0153BC6ACD556C5FF613", hash_generated_method = "2B67D5D96E5E5E3F36C3257763F5CCF6")
    public final int getPointerId(int pointerIndex) {
        addTaint(pointerIndex);
        int var8E8F6655A8D22D3BAB9DC7FA287A80A7_869550679 = (nativeGetPointerId(mNativePtr, pointerIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584997113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584997113;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.546 -0400", hash_original_method = "4F4E823E6A973C2A4D85C86C0A6A2D9D", hash_generated_method = "1FCEC7D4F89522072BFB8E1292664F9B")
    public final int getToolType(int pointerIndex) {
        addTaint(pointerIndex);
        int varB87A49BC30F5D03ED839617274948661_1198167035 = (nativeGetToolType(mNativePtr, pointerIndex));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720243083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720243083;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.546 -0400", hash_original_method = "396B4C03ADE41E49E928286EB7438AA9", hash_generated_method = "7783545B8A9AA571156DAD1744AFB636")
    public final int findPointerIndex(int pointerId) {
        addTaint(pointerId);
        int varC2DCDDA09AB188B9E320373B4ECD5290_297174916 = (nativeFindPointerIndex(mNativePtr, pointerId));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622907696 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_622907696;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.547 -0400", hash_original_method = "13E56CEAC1D2714A9A1790EF5117F935", hash_generated_method = "068F020E937D3036E823ED228316C3D6")
    public final float getX(int pointerIndex) {
        addTaint(pointerIndex);
        float var0A588BA531FA804F2F27535A22C357F5_2094940558 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_810434326 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_810434326;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.548 -0400", hash_original_method = "9A0C47F653E064961B232F3274CD29C9", hash_generated_method = "8308FA27478526CF77A8F62ADF95B256")
    public final float getY(int pointerIndex) {
        addTaint(pointerIndex);
        float var10D450FE3C08AF57C6CA49990B2D3955_1178571930 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1507363021 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1507363021;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.548 -0400", hash_original_method = "36E2BAC74F4F826870F428D93CA1D371", hash_generated_method = "4BD5164AD312876068CB7EB655B3121A")
    public final float getPressure(int pointerIndex) {
        addTaint(pointerIndex);
        float var30AC2BB8D820520FA3A5E2CB9658F590_1452736564 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_238516693 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_238516693;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.548 -0400", hash_original_method = "50DE00A69645B3335E8383A50AB1EB05", hash_generated_method = "08AFA2BAA80D11C375F89ED8D4A8617D")
    public final float getSize(int pointerIndex) {
        addTaint(pointerIndex);
        float varE9D3E0C74CCF4ADE9064F8432DFA8E19_986034000 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1605583612 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1605583612;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.548 -0400", hash_original_method = "28BED69B39230D6E2E593658DA262948", hash_generated_method = "BCBC1C8CCB1BE082AD626F3B5812EFC0")
    public final float getTouchMajor(int pointerIndex) {
        addTaint(pointerIndex);
        float var312F092DC7738998C91B1C650C9208C5_341532000 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_810029650 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_810029650;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.548 -0400", hash_original_method = "2C1FBE2BFEFC6BD6A6EFC25F55DD94B0", hash_generated_method = "CA109EEC414D078AD7BBA45D1006B5A4")
    public final float getTouchMinor(int pointerIndex) {
        addTaint(pointerIndex);
        float var1D2ADBCE62DF15318D292A2184D5A6F8_2132844961 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1206866763 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1206866763;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.548 -0400", hash_original_method = "66B849A9DC257EF38185AFB935434C46", hash_generated_method = "15656F4603A9684F831454E67CB95460")
    public final float getToolMajor(int pointerIndex) {
        addTaint(pointerIndex);
        float var661E79BA458A3CC6D15AED49C15A7B30_1073312665 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_2000417987 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2000417987;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.548 -0400", hash_original_method = "F39564D767A71A1EAACBC920B100E436", hash_generated_method = "E1685CE7D0F9F2DEE539EEA8777475D8")
    public final float getToolMinor(int pointerIndex) {
        addTaint(pointerIndex);
        float var5BC97869170DDF7295F74C5E4FB9C67A_415325898 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_62764272 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_62764272;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.549 -0400", hash_original_method = "A9038F286A5A1470BB26B4145360A2CC", hash_generated_method = "F59DC3577A139DE1652C83ACC61D9A0E")
    public final float getOrientation(int pointerIndex) {
        addTaint(pointerIndex);
        float varF92B55DACDDA8C7C897B27D94BC39D00_728664798 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_276630332 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_276630332;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.550 -0400", hash_original_method = "3434CDF166CDB98F83BC4BA0F4722E7E", hash_generated_method = "9027161CE3A27439425A005F4E20C1E5")
    public final float getAxisValue(int axis, int pointerIndex) {
        addTaint(pointerIndex);
        addTaint(axis);
        float var66245FED39B2BDF31F7C19DE02F912F2_1559563369 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_942076082 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_942076082;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.550 -0400", hash_original_method = "33DE471947CC053A5003BB5AAC41F910", hash_generated_method = "E7823BC7B19A0EC5CE34184C01125684")
    public final void getPointerCoords(int pointerIndex, PointerCoords outPointerCoords) {
        addTaint(outPointerCoords.getTaint());
        addTaint(pointerIndex);
        nativeGetPointerCoords(mNativePtr, pointerIndex, HISTORY_CURRENT, outPointerCoords);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.550 -0400", hash_original_method = "FC8907B12AF62543F5FA0564EA522E62", hash_generated_method = "DE55870116B99FA0B12E297135A7A19B")
    public final void getPointerProperties(int pointerIndex,
            PointerProperties outPointerProperties) {
        addTaint(outPointerProperties.getTaint());
        addTaint(pointerIndex);
        nativeGetPointerProperties(mNativePtr, pointerIndex, outPointerProperties);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.550 -0400", hash_original_method = "38A68962B5CFD92D43EE16A436EABCF2", hash_generated_method = "04FBDC79B7B2DB7FBAE1444267EEEFA4")
    public final int getMetaState() {
        int var8B31B809A1E02B825F144CA38A97CC53_939175601 = (nativeGetMetaState(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745659191 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745659191;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.550 -0400", hash_original_method = "C8458CE15D5B2817F47A4FD377CE1968", hash_generated_method = "BA86C37C963E1D2FF371141592A15F70")
    public final int getButtonState() {
        int var9B60F673C42B84E229E1898D796679E0_219422240 = (nativeGetButtonState(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993663005 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993663005;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.550 -0400", hash_original_method = "6E457CC599C66DF6B9AC57A3DF3B8E7E", hash_generated_method = "5E50C2FD61C6876E2EFAB936F67C5075")
    public final float getRawX() {
        float var0D854522731FBDAB87403300A649F3D3_416318973 = (nativeGetRawAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1349026916 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1349026916;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.552 -0400", hash_original_method = "C18C1837908CE668DE325D32328DA600", hash_generated_method = "ACC698F79D389211EACA9978A453A12C")
    public final float getRawY() {
        float var52B0E43324F1F3642461105A906C8523_217179319 = (nativeGetRawAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
                float var546ADE640B6EDFBC8A086EF31347E768_1070541765 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1070541765;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.552 -0400", hash_original_method = "32503B0D7203271814D12FFB8906664F", hash_generated_method = "2790B3F0426E8B765345203B918C1B85")
    public final float getXPrecision() {
        float var2A7917A86613FB742B65FF142C135D3E_90591433 = (nativeGetXPrecision(mNativePtr));
                float var546ADE640B6EDFBC8A086EF31347E768_595481765 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_595481765;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.552 -0400", hash_original_method = "77B44C5CFF493101D20AF55AA249AFB4", hash_generated_method = "F2B300DB16291066EB7CE1884B3D3EE2")
    public final float getYPrecision() {
        float varE236F74B3ABE497BD8C08E81B74F9DD0_1661667202 = (nativeGetYPrecision(mNativePtr));
                float var546ADE640B6EDFBC8A086EF31347E768_163953578 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_163953578;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.552 -0400", hash_original_method = "B4D273F4D2084C890DE19B631E3ED869", hash_generated_method = "18054147B5CD59B3652C8244E78A8E5A")
    public final int getHistorySize() {
        int var066A735E1D7E1073E9C19404D62C6B62_1731554341 = (nativeGetHistorySize(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83963401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83963401;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.552 -0400", hash_original_method = "4F37DFE9294EB232F86D1F83C2ADDC74", hash_generated_method = "FA8C7D32B9411222DC859E0BC780AD44")
    public final long getHistoricalEventTime(int pos) {
        addTaint(pos);
        long var02012D1A8B849D7B9F09E733FF57B5ED_808713327 = (nativeGetEventTimeNanos(mNativePtr, pos) / NS_PER_MS);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_933540688 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_933540688;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.552 -0400", hash_original_method = "52641DCD8C1505610834B8CDD1492B06", hash_generated_method = "474516C427058B0644A3B7854968CAD8")
    public final float getHistoricalX(int pos) {
        addTaint(pos);
        float var026B183B319CDB0CC5DB3209786BAC2A_678832004 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1669387880 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1669387880;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.553 -0400", hash_original_method = "456D8725235AB4DBC45E47B4ADD23013", hash_generated_method = "DA33B21F2AD7078D532ACB35ACCEC5DD")
    public final float getHistoricalY(int pos) {
        addTaint(pos);
        float var7BBA8D16B64D4DA25994BEC47B24F1B6_1656643467 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_564132245 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_564132245;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.553 -0400", hash_original_method = "E822398D8AD69E2A637D6F0BC07F61D8", hash_generated_method = "E0F29A93069B9EFD4B4D59DBD92CCA5C")
    public final float getHistoricalPressure(int pos) {
        addTaint(pos);
        float var0FE43FE23EC2880FC993C9BC19B652EE_1998422902 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_354079345 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_354079345;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.553 -0400", hash_original_method = "A43A8374A73078EDB84358D609B2C354", hash_generated_method = "5BD3CEB092D23F6F57780995473C13D2")
    public final float getHistoricalSize(int pos) {
        addTaint(pos);
        float var661F53AD036895262E5A525987FAB1AB_445018051 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_468959924 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_468959924;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.554 -0400", hash_original_method = "192AC6C55C0D7020BB0EA3AE5DE4FD65", hash_generated_method = "054D2A1D0F9A3539C3DD7F446BD07129")
    public final float getHistoricalTouchMajor(int pos) {
        addTaint(pos);
        float varA35EDC0ABAA1029D85F4BD3C2711FDEC_637303376 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_435533357 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_435533357;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.554 -0400", hash_original_method = "122C0ECAA119AC26B3F087E871FFA312", hash_generated_method = "2286CEFCED4621440BD6D759A6754757")
    public final float getHistoricalTouchMinor(int pos) {
        addTaint(pos);
        float var9019E6BDE5FF77EB81396A1FFAEAE74D_2098331927 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1434003258 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1434003258;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.554 -0400", hash_original_method = "8097CEA35B3273816C6109CC76A9BC74", hash_generated_method = "870BAA9D55F572E6CD84982F491A4531")
    public final float getHistoricalToolMajor(int pos) {
        addTaint(pos);
        float varB2AA9900B676244450FE7A01259BC28F_642022781 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1766042757 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1766042757;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.554 -0400", hash_original_method = "E0365AAE3D6BF704A796F5D4E7964FB9", hash_generated_method = "3C9551236431BA81794533677A884A16")
    public final float getHistoricalToolMinor(int pos) {
        addTaint(pos);
        float var45C6454A6618661C0DF4FDBFD9DAC0FA_133747292 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_626280383 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_626280383;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.554 -0400", hash_original_method = "DC8FCE9CD404D08D0BFF0CC77CEE87C1", hash_generated_method = "1B07290D81BA9CFA16FBD481762C5575")
    public final float getHistoricalOrientation(int pos) {
        addTaint(pos);
        float var9A2C8140AF67A1D4D386DE4259B1787C_2034345285 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_2030261909 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2030261909;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.554 -0400", hash_original_method = "697532A0192D8868F2E3AE618301BF20", hash_generated_method = "412BA0780C976B462EF58F694A6E8CB2")
    public final float getHistoricalAxisValue(int axis, int pos) {
        addTaint(pos);
        addTaint(axis);
        float var8B571BE607B83E206E56C84370B33DA8_1225031753 = (nativeGetAxisValue(mNativePtr, axis, 0, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_442567852 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_442567852;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.554 -0400", hash_original_method = "8BFA09569623FF1F941D2134C3D47F02", hash_generated_method = "6853B42AB930DF4F7C08A6E7F844D057")
    public final float getHistoricalX(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var4AF32255F4A4F1264762696ED715D5C4_1859320759 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1517401240 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1517401240;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.556 -0400", hash_original_method = "9787FE8A43AC5153EC8D7EC463FC985B", hash_generated_method = "88A5497983245BE5B0D2EB6600B7E273")
    public final float getHistoricalY(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float varF2AC8D1DA84755F35269C73FC6495FD0_738198738 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_665360076 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_665360076;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.556 -0400", hash_original_method = "A8F703E0BCBA29F53C62C25AACD436ED", hash_generated_method = "3AADC7C8CAD2BA6961083C73DA27F28B")
    public final float getHistoricalPressure(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var20169B30E644D54B9D66666865A50453_1151317013 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_415489944 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_415489944;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.556 -0400", hash_original_method = "66A9DA10859CF6933D658F61BE53F70F", hash_generated_method = "FD1ECC463EF25434893CFB522789DC86")
    public final float getHistoricalSize(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float varEB7E60A947D456C834868D628B623593_671859696 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1727943526 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1727943526;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.556 -0400", hash_original_method = "38D72D2E0F00AE5C39667CDDD41B271D", hash_generated_method = "30962DC7DC9377C12E2EE30105647A36")
    public final float getHistoricalTouchMajor(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float varDF2819CE064A1865E5C3505BF5B5D067_1912008919 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1298842298 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1298842298;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.556 -0400", hash_original_method = "F3D94A1F01A3ECEF6DEDEA9361640BF9", hash_generated_method = "C0900BB3800B6159EF2E8E9838FF3197")
    public final float getHistoricalTouchMinor(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var4582A20AC28A85EA5725F71AE41C85C6_2054523567 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_145280956 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_145280956;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.556 -0400", hash_original_method = "78FB77773CB43A5420D0F24849B540AD", hash_generated_method = "CE7F1E2CEB9AF62505BD21750D1787E2")
    public final float getHistoricalToolMajor(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var6108293C3F62F2149B6B7EB334942C59_795892261 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_65314061 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_65314061;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.556 -0400", hash_original_method = "4AB7745853006A3796DAD0E637CCA598", hash_generated_method = "9A9DE4D426420F7FE228351A96422A26")
    public final float getHistoricalToolMinor(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var258F12248C69A4F414E1524429C431A2_494280052 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_892627586 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_892627586;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.558 -0400", hash_original_method = "160C0106DB8A4C6FBAA9569ABA0D68E8", hash_generated_method = "FE3A0B1AB807CDEAC98BA6D5BBC7A677")
    public final float getHistoricalOrientation(int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        float var76B6D2D13D0E715410E04459FA7F94D1_116253317 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1994550684 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1994550684;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.558 -0400", hash_original_method = "F645AABE3B2CF14D2790BA051F9F3FF1", hash_generated_method = "22B9F14014E0B25895F48D93EEE5970E")
    public final float getHistoricalAxisValue(int axis, int pointerIndex, int pos) {
        addTaint(pos);
        addTaint(pointerIndex);
        addTaint(axis);
        float var0EB5AC306AF9423D2AD5DFC87B794696_1594676320 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, pos));
                float var546ADE640B6EDFBC8A086EF31347E768_1659352602 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1659352602;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.558 -0400", hash_original_method = "D80ADCD256759644414D5CBEC3C57D0B", hash_generated_method = "CE6881A87663F4E9E04A9F00FBC88289")
    public final void getHistoricalPointerCoords(int pointerIndex, int pos,
            PointerCoords outPointerCoords) {
        addTaint(outPointerCoords.getTaint());
        addTaint(pos);
        addTaint(pointerIndex);
        nativeGetPointerCoords(mNativePtr, pointerIndex, pos, outPointerCoords);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.558 -0400", hash_original_method = "26EA400A9751805DFF1D4CEEB005645B", hash_generated_method = "2E457E8BE0BF6B307D3F0EECDD706F41")
    public final int getEdgeFlags() {
        int var1F1A88DFEB524E5410CE9FDD29B55811_406085048 = (nativeGetEdgeFlags(mNativePtr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571594339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571594339;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.558 -0400", hash_original_method = "348B6A1C5666102E94291FA4791C249A", hash_generated_method = "EA090D97895AD6564575A4AFA6B859B5")
    public final void setEdgeFlags(int flags) {
        addTaint(flags);
        nativeSetEdgeFlags(mNativePtr, flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.558 -0400", hash_original_method = "34CE363FC32882BC3BBCF2E8ABF2B5B0", hash_generated_method = "F19B003A8A5DCF26BEDE0687FC59DBBE")
    public final void setAction(int action) {
        addTaint(action);
        nativeSetAction(mNativePtr, action);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.558 -0400", hash_original_method = "117CE161431F2ECDED077AD7F7467ADD", hash_generated_method = "A43AFFD412B7469BD843E7F8AC77342F")
    public final void offsetLocation(float deltaX, float deltaY) {
        addTaint(deltaY);
        addTaint(deltaX);
        nativeOffsetLocation(mNativePtr, deltaX, deltaY);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.561 -0400", hash_original_method = "D9D9F7662138ADF2F9591F7DFAEB3F74", hash_generated_method = "4B343E5D10F32270E24CB92BB72969F7")
    public final void setLocation(float x, float y) {
        addTaint(y);
        addTaint(x);
        float oldX = getX();
        float oldY = getY();
        nativeOffsetLocation(mNativePtr, x - oldX, y - oldY);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.561 -0400", hash_original_method = "622D19544C973DA41E1BE7D7819B5A41", hash_generated_method = "EC0538EB070E4F325F4E1CC0070C0355")
    public final void transform(Matrix matrix) {
        addTaint(matrix.getTaint());
    if(matrix == null)        
        {
            IllegalArgumentException var881CB0E00A863276B1D2E4F1FD5A1042_1241380419 = new IllegalArgumentException("matrix must not be null");
            var881CB0E00A863276B1D2E4F1FD5A1042_1241380419.addTaint(taint);
            throw var881CB0E00A863276B1D2E4F1FD5A1042_1241380419;
        } 
        nativeTransform(mNativePtr, matrix);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.561 -0400", hash_original_method = "F001981BC7F115C74B7EB0136965714D", hash_generated_method = "B86CC0D9EC9660C246B11A2BA6B03DB4")
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
        } 
        
        
            
            
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.561 -0400", hash_original_method = "06E22018450E3E0892CD70DE9E19F211", hash_generated_method = "4D90FFB2F0E581C77625DC7738D7AAB0")
    public final void addBatch(long eventTime, PointerCoords[] pointerCoords, int metaState) {
        addTaint(metaState);
        addTaint(pointerCoords[0].getTaint());
        addTaint(eventTime);
        nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pointerCoords, metaState);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.562 -0400", hash_original_method = "542474DD15BDDADB068A65C6A3EEA8E2", hash_generated_method = "B778227663359910985CAFA1F7B68B17")
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
                boolean var68934A3E9455FA72420237EB05902327_310958127 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_901271487 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_901271487;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1769081497 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1201922758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1201922758;
        
        
        
            
            
            
                
            
        
        
    }

    
        private static final float clamp(float value, float low, float high) {
        if (value < low) {
            return low;
        } else if (value > high) {
            return high;
        }
        return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.563 -0400", hash_original_method = "C00E6E79D43678980DA0F4144A65F6A2", hash_generated_method = "6837F5E613DA072ECD8C5E587EE2435A")
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
MotionEvent var589F943EB1E905D6F47E9BDE80F73551_667348660 =             ev;
            var589F943EB1E905D6F47E9BDE80F73551_667348660.addTaint(taint);
            return var589F943EB1E905D6F47E9BDE80F73551_667348660;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.563 -0400", hash_original_method = "FBF170B15B2FFBEE1AB1D4E32A8773CA", hash_generated_method = "798F69AD1F29EB2861FCF9CD3DDC4E2E")
    public final int getPointerIdBits() {
        int idBits = 0;
        final int pointerCount = nativeGetPointerCount(mNativePtr);
for(int i = 0;i < pointerCount;i++)
        {
            idBits |= 1 << nativeGetPointerId(mNativePtr, i);
        } 
        int var23FF2890029E50A8E723EA8D41956EF0_308103505 = (idBits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901092636 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901092636;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.566 -0400", hash_original_method = "4F0FF8B26009CA9D26EE500AEFE507EC", hash_generated_method = "8A4F78443C85EA6233D50E8F086AE95A")
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
                    } 
                    map[newPointerCount] = i;
                    newPointerCount += 1;
                    newIdBits |= idBit;
                } 
            } 
    if(newPointerCount == 0)            
            {
                IllegalArgumentException varFB983EDAA1F0122ADE5F02B00A9FBB6B_1328853937 = new IllegalArgumentException("idBits did not match any ids in the event");
                varFB983EDAA1F0122ADE5F02B00A9FBB6B_1328853937.addTaint(taint);
                throw varFB983EDAA1F0122ADE5F02B00A9FBB6B_1328853937;
            } 
            int newAction;
    if(oldActionMasked == ACTION_POINTER_DOWN || oldActionMasked == ACTION_POINTER_UP)            
            {
    if(newActionPointerIndex < 0)                
                {
                    newAction = ACTION_MOVE;
                } 
                else
    if(newPointerCount == 1)                
                {
                    newAction = oldActionMasked == ACTION_POINTER_DOWN
                            ? ACTION_DOWN : ACTION_UP;
                } 
                else
                {
                    newAction = oldActionMasked
                            | (newActionPointerIndex << ACTION_POINTER_INDEX_SHIFT);
                } 
            } 
            else
            {
                newAction = oldAction;
            } 
            final int historySize = nativeGetHistorySize(mNativePtr);
for(int h = 0;h <= historySize;h++)
            {
                final int historyPos = h == historySize ? HISTORY_CURRENT : h;
for(int i = 0;i < newPointerCount;i++)
                {
                    nativeGetPointerCoords(mNativePtr, map[i], historyPos, pc[i]);
                } 
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
                } 
                else
                {
                    nativeAddBatch(ev.mNativePtr, eventTimeNanos, pc, 0);
                } 
            } 
MotionEvent var589F943EB1E905D6F47E9BDE80F73551_382186292 =             ev;
            var589F943EB1E905D6F47E9BDE80F73551_382186292.addTaint(taint);
            return var589F943EB1E905D6F47E9BDE80F73551_382186292;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.567 -0400", hash_original_method = "69A985781D7A79E036178DEB42E5F1F0", hash_generated_method = "484ABDD4C8E51F8B7595BA42A96316C5")
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
String var684DADA25689ED258BFAD9F9C4AD23D2_1578607967 =         msg.toString();
        var684DADA25689ED258BFAD9F9C4AD23D2_1578607967.addTaint(taint);
        return var684DADA25689ED258BFAD9F9C4AD23D2_1578607967;
        
        
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
    public static String toolTypeToString(int toolType) {
        String symbolicName = TOOL_TYPE_SYMBOLIC_NAMES.get(toolType);
        return symbolicName != null ? symbolicName : Integer.toString(toolType);
    }

    
        @DSModeled(DSC.SAFE)
    public static MotionEvent createFromParcelBody(Parcel in) {
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeReadFromParcel(ev.mNativePtr, in);
        return ev;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.568 -0400", hash_original_method = "D732CA58C71ED959C0E1A12C336FC80D", hash_generated_method = "3F40403E65BDFBE08917BC35DE7F1C38")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeInt(PARCEL_TOKEN_MOTION_EVENT);
        nativeWriteToParcel(mNativePtr, out);
        
        
        
    }

    
    public static final class PointerCoords {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.568 -0400", hash_original_field = "E4845520982C15184227C7CC9D20FD50", hash_generated_field = "616BA79E3CF38111CD6326A774A7BA12")

        private long mPackedAxisBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.568 -0400", hash_original_field = "5195E654A9F1469D3F33B6FBBCE24383", hash_generated_field = "74AC3FA36AA575C3DEE392AD51F3FC84")

        private float[] mPackedAxisValues;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.568 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "0CC4A8770822EF2A4B3BD536BBF6C113")

        public float x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.568 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E8D9A0915E4274087E59C025C4DCDA11")

        public float y;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.569 -0400", hash_original_field = "D99FAD96A5D0A7CB2EB41341EA556093", hash_generated_field = "8D3DD02B3785A296D75D1BFB99C62E42")

        public float pressure;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.570 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "295F60DE48801BD75A245B044AE96BA0")

        public float size;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.570 -0400", hash_original_field = "95BE195AF7AF1434BA03D8E831DC4D43", hash_generated_field = "6D6952CAD458217EEFCB2922EE3D3E82")

        public float touchMajor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.570 -0400", hash_original_field = "AF72E652DB6EACE533A5766E00C83453", hash_generated_field = "492641BCD483F61BC74CAF973D65A13D")

        public float touchMinor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.570 -0400", hash_original_field = "B0B8BF85D8A3FA50D314A293B6CA49AC", hash_generated_field = "32FD2A0018A7199A2ED20949B6E0486E")

        public float toolMajor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.570 -0400", hash_original_field = "2A170207574AE57015C852C226F8048D", hash_generated_field = "173EB15A07C0771733DC98A43E20CE98")

        public float toolMinor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.570 -0400", hash_original_field = "DA1639422AD8F355D2371428471379B5", hash_generated_field = "054A1E23DAAFDEC28AE3DA031EECF136")

        public float orientation;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.570 -0400", hash_original_method = "30C014872AED120D5788F672204C6D56", hash_generated_method = "02D472FB06CC6A49D31A045DF0321860")
        public  PointerCoords() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.570 -0400", hash_original_method = "4C1A041805DDE756B7430BBCF7A4A54D", hash_generated_method = "1C66435E307BF04A88E45A81EECD37FF")
        public  PointerCoords(PointerCoords other) {
            addTaint(other.getTaint());
            copyFrom(other);
            
            
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.570 -0400", hash_original_method = "5B10C041062144B27347C9202A1953B2", hash_generated_method = "85A3A31EE556A4BEA00BDAAD4B198A1A")
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.572 -0400", hash_original_method = "A2C68F8615572C95C5947791A8CC8026", hash_generated_method = "5DCA61032438B6B62952CB867DFFA53B")
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.572 -0400", hash_original_method = "566631CFDB34A411EF93513211D62594", hash_generated_method = "4AF261353C0DB7C5300B99A8F07AC792")
        public float getAxisValue(int axis) {
            addTaint(axis);
switch(axis){
            case AXIS_X:
            float var9DD4E461268C8034F5C8564E155C67A6_491851232 = (x);
                        float var546ADE640B6EDFBC8A086EF31347E768_201645566 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_201645566;
            case AXIS_Y:
            float var415290769594460E2E485922904F345D_1028048743 = (y);
                        float var546ADE640B6EDFBC8A086EF31347E768_1861542872 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1861542872;
            case AXIS_PRESSURE:
            float varD99FAD96A5D0A7CB2EB41341EA556093_61514060 = (pressure);
                        float var546ADE640B6EDFBC8A086EF31347E768_125320844 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_125320844;
            case AXIS_SIZE:
            float varF7BD60B75B29D79B660A2859395C1A24_1144515980 = (size);
                        float var546ADE640B6EDFBC8A086EF31347E768_137600411 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_137600411;
            case AXIS_TOUCH_MAJOR:
            float var95BE195AF7AF1434BA03D8E831DC4D43_949578762 = (touchMajor);
                        float var546ADE640B6EDFBC8A086EF31347E768_948616992 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_948616992;
            case AXIS_TOUCH_MINOR:
            float varAF72E652DB6EACE533A5766E00C83453_1295220738 = (touchMinor);
                        float var546ADE640B6EDFBC8A086EF31347E768_1924287887 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1924287887;
            case AXIS_TOOL_MAJOR:
            float varB0B8BF85D8A3FA50D314A293B6CA49AC_1330331618 = (toolMajor);
                        float var546ADE640B6EDFBC8A086EF31347E768_678078835 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_678078835;
            case AXIS_TOOL_MINOR:
            float var2A170207574AE57015C852C226F8048D_1767062628 = (toolMinor);
                        float var546ADE640B6EDFBC8A086EF31347E768_843313276 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_843313276;
            case AXIS_ORIENTATION:
            float varDA1639422AD8F355D2371428471379B5_729285434 = (orientation);
                        float var546ADE640B6EDFBC8A086EF31347E768_1716587390 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1716587390;
            default:
            {
    if(axis < 0 || axis > 63)                
                {
                    IllegalArgumentException var1E87AAB4E5870C79215018F1CF48E911_351356353 = new IllegalArgumentException("Axis out of range.");
                    var1E87AAB4E5870C79215018F1CF48E911_351356353.addTaint(taint);
                    throw var1E87AAB4E5870C79215018F1CF48E911_351356353;
                } 
                final long bits = mPackedAxisBits;
                final long axisBit = 1L << axis;
    if((bits & axisBit) == 0)                
                {
                    float varCFCD208495D565EF66E7DFF9F98764DA_2034561224 = (0);
                                        float var546ADE640B6EDFBC8A086EF31347E768_794309711 = getTaintFloat();
                    return var546ADE640B6EDFBC8A086EF31347E768_794309711;
                } 
                final int index = Long.bitCount(bits & (axisBit - 1L));
                float var8A9471727EC5AB63F646A708829DFF04_1760242814 = (mPackedAxisValues[index]);
                                float var546ADE640B6EDFBC8A086EF31347E768_413149019 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_413149019;
            } 
}
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.576 -0400", hash_original_method = "55E9DEFA01615304E1434A1FAB8328FA", hash_generated_method = "550B72F2333A2EF1605AA1160A00E8E8")
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
                    IllegalArgumentException var1E87AAB4E5870C79215018F1CF48E911_458936695 = new IllegalArgumentException("Axis out of range.");
                    var1E87AAB4E5870C79215018F1CF48E911_458936695.addTaint(taint);
                    throw var1E87AAB4E5870C79215018F1CF48E911_458936695;
                } 
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
                    } 
                    else
                    {
                        final int count = Long.bitCount(bits);
    if(count < values.length)                        
                        {
    if(index != count)                            
                            {
                                System.arraycopy(values, index, values, index + 1,
                                            count - index);
                            } 
                        } 
                        else
                        {
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.576 -0400", hash_original_field = "33446AA70F42B7C22C25CFDF4E916659", hash_generated_field = "1ED50B8C8EE9915850360B0973B4FC02")

        private static final int INITIAL_PACKED_AXIS_VALUES = 8;
    }


    
    public static final class PointerProperties {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.576 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.576 -0400", hash_original_field = "F803A61F4662F15B2A4B72308BD45F04", hash_generated_field = "E5CA883B5E8E2CF4928B3E305240E7C6")

        public int toolType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.576 -0400", hash_original_method = "D6AAE40F539D7383E827DA395512E95B", hash_generated_method = "207B464AAB7566FD25D2646B7EE6C19D")
        public  PointerProperties() {
            clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.576 -0400", hash_original_method = "0B0B44B5B3A0DCF648446956F27785E9", hash_generated_method = "ADD0C86B658EF40FE7B592A4493E84A0")
        public  PointerProperties(PointerProperties other) {
            addTaint(other.getTaint());
            copyFrom(other);
            
            
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.577 -0400", hash_original_method = "ADC6A83F955A9ED0C1C75B5F08682583", hash_generated_method = "DFC90B75E706F2F74BBF473BA904F663")
        public void clear() {
            id = INVALID_POINTER_ID;
            toolType = TOOL_TYPE_UNKNOWN;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_method = "1E34ECE529256025A33CF5DCBE029131", hash_generated_method = "83EE2C55C6A446D371F6C2FC0D637123")
        public void copyFrom(PointerProperties other) {
            id = other.id;
            toolType = other.toolType;
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "6E4EF440EBC2808EB9427311B59A1879", hash_generated_field = "1E55FD918071A214A5C67DF1505BB56B")

    private static final long NS_PER_MS = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "72335DCE9A3EDFEDA119916AF8BD9A52", hash_generated_field = "FA3C17D544830BC1BEE55D29729BDFE3")

    private static final boolean TRACK_RECYCLED_LOCATION = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "337218C9F350445474335E0ED8EB52D2", hash_generated_field = "122232306FDB60B34ACA42DBAA65B736")

    public static final int INVALID_POINTER_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "034E2BCD80D0FE32BEE35A26F527AB82", hash_generated_field = "464488178905DF6887AEEC102D03F9BB")

    public static final int ACTION_MASK             = 0xff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "05E3DA568602DAD9EA3C414607B71E65", hash_generated_field = "B56FBABE5CC8DDE909CEA8CDE98BA93D")

    public static final int ACTION_DOWN             = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "6D72F1F84E251024F9C1BAF7B002F529", hash_generated_field = "E9419BD1576C4C89CB972C93BF43E7C5")

    public static final int ACTION_UP               = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "E0AAA7BED07FEFB1355300A23A152F90", hash_generated_field = "0869EE70BD47CB90D812F686B7F0D216")

    public static final int ACTION_MOVE             = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "C46423CE3E5642BA0CB7AB6CB09262AE", hash_generated_field = "CCD39E7D9940D088C4EBAE690B5B3006")

    public static final int ACTION_CANCEL           = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "5B47F521CF7C2C903B879280CC51E19F", hash_generated_field = "B53AF36739EBD3146722B0AB3CAF54B6")

    public static final int ACTION_OUTSIDE          = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "596B10C23830633246B5FE119303CA31", hash_generated_field = "BE1BA8B002AC6D11B1BA8B25140F3104")

    public static final int ACTION_POINTER_DOWN     = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "1CD52FBA3CE6A637AE86BF305E1727A2", hash_generated_field = "779F82BEF077301CD2887D1C33590F74")

    public static final int ACTION_POINTER_UP       = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "A117FB885030C87F8035EE8197E01274", hash_generated_field = "A31BF98337FB8359E97DA48D76D80977")

    public static final int ACTION_HOVER_MOVE       = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "EDD00CD16649F89FF44DD9C0E161B238", hash_generated_field = "D4C11BB0C70739D756D7BA7A8EBDE32D")

    public static final int ACTION_SCROLL           = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.578 -0400", hash_original_field = "E6889A317885B7F3FCFCB516DDE1B506", hash_generated_field = "6EED9A028D9812B11E3EC6500A22417D")

    public static final int ACTION_HOVER_ENTER      = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "5A019C5D2F9BBBECE84DA46559873CDE", hash_generated_field = "36537B951CA8A88E1E580F444A68C4EB")

    public static final int ACTION_HOVER_EXIT       = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "F94A33E7C5ACFBEFDFBB09F0FB9B278A", hash_generated_field = "E260033975F8D36BD53DB361D54BA2BF")

    public static final int ACTION_POINTER_INDEX_MASK  = 0xff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "DAB0332B2F0024984DE4DD67C040BC0F", hash_generated_field = "3ED9AD85BB2784B1321927FB5C085339")

    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "9592F84893EF5C92909845A138CAE395", hash_generated_field = "0E6D248BF8E40C6A30CD011E4FE93537")

    @Deprecated
    public static final int ACTION_POINTER_1_DOWN   = ACTION_POINTER_DOWN | 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "7F4BF3EB26FAD7B49445118A59CE6146", hash_generated_field = "2A2F376950DB01CC014C8F15C5D29770")

    @Deprecated
    public static final int ACTION_POINTER_2_DOWN   = ACTION_POINTER_DOWN | 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "AA3C2A077F9DEEFBA6F2542C0560FB1B", hash_generated_field = "9C71C2EB30843366313F3020BE578C26")

    @Deprecated
    public static final int ACTION_POINTER_3_DOWN   = ACTION_POINTER_DOWN | 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "449EA013BBCDA169B9EF1D2297500187", hash_generated_field = "CB217DFD0D7D2A2D8289D57696E595C7")

    @Deprecated
    public static final int ACTION_POINTER_1_UP     = ACTION_POINTER_UP | 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "91D34AE0179B0BC5900FFCB630718519", hash_generated_field = "0531D8E2B94086788DA257D61DD61C0F")

    @Deprecated
    public static final int ACTION_POINTER_2_UP     = ACTION_POINTER_UP | 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "F4E6043EA1CA67A36A2F06C954118606", hash_generated_field = "98C2F8F94E43CA43968FDCDBCC9896C4")

    @Deprecated
    public static final int ACTION_POINTER_3_UP     = ACTION_POINTER_UP | 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "E323657B2EB80B422379A9CEBE0A7866", hash_generated_field = "21CA20F1626331DC2869522A2DE48834")

    @Deprecated
    public static final int ACTION_POINTER_ID_MASK  = 0xff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "B6823DDE720D0C768C88F68459F98292", hash_generated_field = "674FBE2D655FD483B823B2E251529FF3")

    @Deprecated
    public static final int ACTION_POINTER_ID_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "029786C6547ED0693759CAAEFEA9CFC0", hash_generated_field = "D55190196D2C1F6E3FFFC84FA0B9D772")

    public static final int FLAG_WINDOW_IS_OBSCURED = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "550A819DF1874DD6CBEB9E34B7E02CA2", hash_generated_field = "22C757AFB129CA98FC86BD04BEE94F98")

    public static final int FLAG_TAINTED = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "A633F8D6629EE7B06C2FD6D1B0DC9450", hash_generated_field = "E88E0AA9A676F8906011C2C253859C66")

    public static final int EDGE_TOP = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "A822268AD0B774AEEE14EC8CC8D9F93B", hash_generated_field = "7F13D97BAA00BFCDC5B911BB5B6DCDF3")

    public static final int EDGE_BOTTOM = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "8B1FDF0477E0C35DA2FB7C7B8306974A", hash_generated_field = "96B2B8C704DDAD0603C6C6E2FFC340B1")

    public static final int EDGE_LEFT = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "A3A04219B91FA85B01EA955DFFF5FEB5", hash_generated_field = "4B4418A2700C288E6EFE7AF6B858A111")

    public static final int EDGE_RIGHT = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "F43EDDBFB6367074F45ECA2C476C6565", hash_generated_field = "6AC2F269D8C677A5928AAB4766B0AFA4")

    public static final int AXIS_X = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "B104E19452EE81C2A619F4D57E3AEDBE", hash_generated_field = "1F1942945032A87C66ACA5752705A256")

    public static final int AXIS_Y = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "6542F537176A3A95C9638B5D2D6D3282", hash_generated_field = "5CB739150541FFE06EFD5DECAA58BF2C")

    public static final int AXIS_PRESSURE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "271FFE604598307C9BD49A632CD69F2C", hash_generated_field = "F805D88CFB32566B5D69E445454FA20B")

    public static final int AXIS_SIZE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "76C24AF7C4E7B5EF86EC8B7AA695C99B", hash_generated_field = "4422123708A385A40B3A3EAD28C77CA0")

    public static final int AXIS_TOUCH_MAJOR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "FDD97DCBF16D7D35D1DE9CA5AB8B0EE9", hash_generated_field = "9BD07319C2DC512FC7AFF06DB4C457EB")

    public static final int AXIS_TOUCH_MINOR = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "4CECC8FEA7DFD80C61892B5D9499F332", hash_generated_field = "3A23BEE8699344F8699632E58AAE9D00")

    public static final int AXIS_TOOL_MAJOR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.579 -0400", hash_original_field = "2280E38346B560BA8AFA6F674CCF146D", hash_generated_field = "F26604DCEE776E17C73C06ABB61691F6")

    public static final int AXIS_TOOL_MINOR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "034AF53CD5FD7BC7833BEAD02993E949", hash_generated_field = "2A1393B38A6522964DCE18C89C02987A")

    public static final int AXIS_ORIENTATION = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "6A09A3E15FC599ADAD44D13102C405DD", hash_generated_field = "3653EDC97D1EC153035B8B2CF03F0D9F")

    public static final int AXIS_VSCROLL = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "ADCA61A712EC2EAE4DA4FCDD6574618C", hash_generated_field = "92F839C5EBC2322D5FA86535F6F819CB")

    public static final int AXIS_HSCROLL = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "5952DC7A036BAD5A2FA3BB4702C69033", hash_generated_field = "AF121E953BE1BD481D0CFED4A68E74C0")

    public static final int AXIS_Z = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "102726DF7AC3CD66F5F16B29BE4E0C36", hash_generated_field = "F9C0DE51E0127685ECA28E542A120E88")

    public static final int AXIS_RX = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "225D93A029576C17E912D37880E035F3", hash_generated_field = "0C4C76335C9A3564DACCCDBE8DD301F2")

    public static final int AXIS_RY = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "3622454F61D2BEAFB3A7C20E8B67794C", hash_generated_field = "FE837C29D6032EC2960992B9D8A8B178")

    public static final int AXIS_RZ = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "B89A4C4024CEA0CBEF2F49139937E488", hash_generated_field = "95D53DACF181EE3407879E3C0B3371DA")

    public static final int AXIS_HAT_X = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "F8B0B5501EAF46948DD4D8DFF857FF22", hash_generated_field = "448C69D0D61F2BF459C3AC283A9A3DD2")

    public static final int AXIS_HAT_Y = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "08B1FD10B1CA6EAEC83C43A9C0979C60", hash_generated_field = "4450CC9F108DED3391D6ED8F0D534120")

    public static final int AXIS_LTRIGGER = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "980E2D34290DF1ACCB31AFE81E0A824D", hash_generated_field = "275AE4D63A24B8018CE3E210BAC8D939")

    public static final int AXIS_RTRIGGER = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "267E7C0549F05F5D932F84A17DB329C1", hash_generated_field = "538CDE95EB2664616EE4F8F418B16FCF")

    public static final int AXIS_THROTTLE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "44FEE1E278CC7C2339B1E23FBF344BAE", hash_generated_field = "556882041792FB019CA717764224D5C4")

    public static final int AXIS_RUDDER = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "DA830D9524B06F5E2D1FE72F350FA3B0", hash_generated_field = "D3B7AC7DA5A4B49C56D33CA3953C8391")

    public static final int AXIS_WHEEL = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "D9DD16376FECC1C78B4D3A42DFACDB62", hash_generated_field = "B56F86F8DDA863909AE502D90FA7D4A4")

    public static final int AXIS_GAS = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "3D955FBE6867B617A6459F1390B213ED", hash_generated_field = "7148E428BBB18A5A04C2D90A4D20C2D2")

    public static final int AXIS_BRAKE = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "FB55C8949807223E3375F0A2504F360A", hash_generated_field = "53EBC10458EF090346DB7C3BF7B8B449")

    public static final int AXIS_DISTANCE = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "8382AC5A85A82E20003B1AC360EF6D07", hash_generated_field = "579F39E86B98900179C06E9A07BE7C7B")

    public static final int AXIS_TILT = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "70021A9C7A753DA59C64F0581D83C67B", hash_generated_field = "2C24AD3C3E56DD84D0733A0B91218D75")

    public static final int AXIS_GENERIC_1 = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "DE2D083AFBB03257E89BDA922D0E4CAD", hash_generated_field = "D5EDF8D95D30F8707CB60CE48E5D080D")

    public static final int AXIS_GENERIC_2 = 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "9FEFCC69BCFDFC864584838013FE5B46", hash_generated_field = "0FB2B7871027C51D19E6ADDB6629599D")

    public static final int AXIS_GENERIC_3 = 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "9243522AF86AC2FA928B71B7E668CC47", hash_generated_field = "B3834C6A5E7EAC276B34400E316CC889")

    public static final int AXIS_GENERIC_4 = 35;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "F0A6A5F912965A4325BA778B910D6E59", hash_generated_field = "D771A2C8BF7E6631141C9F156725F986")

    public static final int AXIS_GENERIC_5 = 36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "23CC53509B48EF6225466AC21958D6F4", hash_generated_field = "5ADBF1379367815D17640566262ADBDC")

    public static final int AXIS_GENERIC_6 = 37;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "312922167BECA1728E0C8042C725C6BC", hash_generated_field = "CABE9E3D1339B834B58E2AC551B60D70")

    public static final int AXIS_GENERIC_7 = 38;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "9FCFEF7D88A4651EAE19D026F4636885", hash_generated_field = "783DFA0925833D6927778A6752C33469")

    public static final int AXIS_GENERIC_8 = 39;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "D2142F81309B4EC8E625175D39A4E1F0", hash_generated_field = "844B22BFFE980B1170B8E78B193CD8F8")

    public static final int AXIS_GENERIC_9 = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "7575EC92A58C3C2DC2C8CCC553B15C0D", hash_generated_field = "F52491FA1506F81B61F5BBCAD317F2D4")

    public static final int AXIS_GENERIC_10 = 41;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "89BA0631B47758FC05670AE71E07238B", hash_generated_field = "441A2A8984D04F945C0B9706F4D91238")

    public static final int AXIS_GENERIC_11 = 42;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "898A18C6347222CD54AF74A9ECCCEE58", hash_generated_field = "6EE9D87F1B155C3A9E15C5BFB57DB156")

    public static final int AXIS_GENERIC_12 = 43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "B97F163EE5AB936FB897D250305FDD0F", hash_generated_field = "0C980E1F71AC4BD10A6D1136200C35B1")

    public static final int AXIS_GENERIC_13 = 44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.580 -0400", hash_original_field = "5C89506ADEC1D512A306F0807528A45C", hash_generated_field = "08EDA9B50DF874F18FD4A782BFF79258")

    public static final int AXIS_GENERIC_14 = 45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.581 -0400", hash_original_field = "7EB5AA2C6AC2C895F916E91C7C27BF6D", hash_generated_field = "9B7002F98DD35624F49E82F9F27BEA43")

    public static final int AXIS_GENERIC_15 = 46;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.581 -0400", hash_original_field = "42B8B524D844DB897F8E010F49DF34D9", hash_generated_field = "CDB6932C5544664A6FAAE7570CEF1ED8")

    public static final int AXIS_GENERIC_16 = 47;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.581 -0400", hash_original_field = "530A0FA730B9B28A10F6D39E022E143B", hash_generated_field = "D95AC969582FA3A63A7662A57753465D")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.581 -0400", hash_original_field = "AA456FB196DE0D5C68D5DA0ABB2B1665", hash_generated_field = "ADA948F0304197BC40CACAE24C6ECB05")

    public static final int BUTTON_PRIMARY = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.581 -0400", hash_original_field = "9CDE7875F922E491FF1696F779D48BD9", hash_generated_field = "699964DE06376B73FD25E1C2E308AF7B")

    public static final int BUTTON_SECONDARY = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.581 -0400", hash_original_field = "95C57E1DA2F91AA9F277DFEB59325C0F", hash_generated_field = "0EFC57E0035C368753C281B7448CCAD7")

    public static final int BUTTON_TERTIARY = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.581 -0400", hash_original_field = "87ED530C352322D1000AED214027E0E0", hash_generated_field = "5A526B3B078557E38DB5D4C91419279E")

    public static final int BUTTON_BACK = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "02CD6CBC72EC09DBD9089D39090DEFFF", hash_generated_field = "4E2DD22E6782E832F99D62265E33DC7B")

    public static final int BUTTON_FORWARD = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "9C9A5C3B4382C6FBD48D16D607582F30", hash_generated_field = "BAA383FC1DC8D8F1DFD855E89C02D485")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "D7697B822D45F5BDF64FF3656AE39897", hash_generated_field = "B997CD436D37980DF5D7404E593DC402")

    public static final int TOOL_TYPE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "DDF16792C91BD89ED3CEB72B2F655A3A", hash_generated_field = "C864443B9D1FDB0CC8BE96AE33701299")

    public static final int TOOL_TYPE_FINGER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "FD13CF4F11329C29AEA3974918542E2A", hash_generated_field = "5BBE29494AB919D60EB460BF7FABACCD")

    public static final int TOOL_TYPE_STYLUS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "EDA620D7300731B22711740B56121B0F", hash_generated_field = "4F5A6CDBC3D361EDE9CAD667AC25320F")

    public static final int TOOL_TYPE_MOUSE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "E8E4790D94F06E7A95BA1EC847CFA0F9", hash_generated_field = "09C1A33B09293914694BF2A3886AC6DB")

    public static final int TOOL_TYPE_ERASER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "E4532CF792A1279111A19DAB2ADAADBA", hash_generated_field = "D272CAAEB0300373C7A6923AD9627B5E")

    private static final SparseArray<String> TOOL_TYPE_SYMBOLIC_NAMES = new SparseArray<String>();
    static {
        SparseArray<String> names = TOOL_TYPE_SYMBOLIC_NAMES;
        names.append(TOOL_TYPE_UNKNOWN, "TOOL_TYPE_UNKNOWN");
        names.append(TOOL_TYPE_FINGER, "TOOL_TYPE_FINGER");
        names.append(TOOL_TYPE_STYLUS, "TOOL_TYPE_STYLUS");
        names.append(TOOL_TYPE_MOUSE, "TOOL_TYPE_MOUSE");
        names.append(TOOL_TYPE_ERASER, "TOOL_TYPE_ERASER");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "9319C0C1DC56FFF2B6175EA6D9D0FA3B", hash_generated_field = "B0BEAD643F65C07DAE0B28D2861E52D4")

    private static final int HISTORY_CURRENT = -0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "4E0EEF34DE1E78AC4C7D48E7B28D3753", hash_generated_field = "632CD138CDBCADE9A63F9B23105E1648")

    private static final int MAX_RECYCLED = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "79F53341661E7BAB58D441DAC7E61782", hash_generated_field = "4D2E3DEDF37103D77BF3BB46692742C8")

    private static final Object gRecyclerLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "62CB28CE8AC6DBF69FB484B561C6DE93", hash_generated_field = "695DE00CD65E15FE07938D99F2CA2696")

    private static int gRecyclerUsed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.582 -0400", hash_original_field = "7BA7389C24C0F124608D5C2226AD35F9", hash_generated_field = "E9FD3DB4A4C51C360253148C4F1C8508")

    private static MotionEvent gRecyclerTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.583 -0400", hash_original_field = "7CC0A11C5494EABD208B60B4042F676B", hash_generated_field = "ACFC36EAB247226A536D30FD1648AAC7")

    private static final Object gSharedTempLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.583 -0400", hash_original_field = "7ACA3B441BEC8C942E34BE426D1BD777", hash_generated_field = "1C70655B0F01405596723D256AD5AE2B")

    private static PointerCoords[] gSharedTempPointerCoords;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.583 -0400", hash_original_field = "909596135E37414184F98BA28ABF7B47", hash_generated_field = "7767E5DED892F800315C4BF8ECA945E5")

    private static PointerProperties[] gSharedTempPointerProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.583 -0400", hash_original_field = "7D5CE052D163BC3BEA8C336A1127A9FA", hash_generated_field = "A9BB8E94115BE6A30724987AE7313B53")

    private static int[] gSharedTempPointerIndexMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.583 -0400", hash_original_field = "92338855F3FDCA2FD9317526465F4D98", hash_generated_field = "C140DAE13300F0DB81E6D0FF25B21CC4")

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
    
    public MotionEvent[] newArray(int size) {
            return new MotionEvent[size];
        }
    
    
    public MotionEvent createFromParcel(Parcel in) {
            in.readInt(); 
            return MotionEvent.createFromParcelBody(in);
        }
    
}

