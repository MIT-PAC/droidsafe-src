package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseArray;

public final class MotionEvent extends InputEvent implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.612 -0400", hash_original_field = "AE1F3581ADE8C1B0F98DFDE5A4F536A3", hash_generated_field = "23CD98EE9F206841B49D023F257D02A5")

    private int mNativePtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.612 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "4ED1BADBA3F9AC6D1D2BD2B16B6BF967")

    private MotionEvent mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.612 -0400", hash_original_field = "285FE8BBC1049056117639C63D1605B9", hash_generated_field = "4E4D5EFD76E218484C8A2F86B097FF08")

    private RuntimeException mRecycledLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.612 -0400", hash_original_field = "1212A62D731F217836716E35FA12386C", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.612 -0400", hash_original_method = "B1B69F583261D8BEEC921FF43580AA66", hash_generated_method = "40B8D4E791D456515D6D7EBB1643CE79")
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

    
    private static int nativeCopy(int destNativePtr, int sourceNativePtr,
            boolean keepHistory) {
        return DSUtils.UNKNOWN_INT;
    }

    
    private static void nativeDispose(int nativePtr) {
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.619 -0400", hash_original_method = "3F0B5C050D986DD9F1F0F2A742C616C8", hash_generated_method = "B421B42F481E4C5401D1FD9631DD22BD")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.620 -0400", hash_original_method = "78DE11FBBF58608981D1F74EEB443B54", hash_generated_method = "490B406F8EBBD71C8FF70C26B1BE8646")
    @Override
    public MotionEvent copy() {
        MotionEvent varB4EAC82CA7396A68D541C85D26508E83_2068193084 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2068193084 = obtain(this);
        varB4EAC82CA7396A68D541C85D26508E83_2068193084.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2068193084;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.621 -0400", hash_original_method = "187F7D3A42078A42C8212C3EFE0E8B16", hash_generated_method = "19A0195F7D24E2E1074AAA3598A0B444")
    public final void recycle() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
            } 
            mRecycledLocation = new RuntimeException("Last recycled here");
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(toString() + " recycled twice!");
            } 
            mRecycled = true;
        } 
        {
            {
                mNext = gRecyclerTop;
                gRecyclerTop = this;
            } 
        } 
        
        
            
                
            
            
        
            
                
            
            
        
        
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.621 -0400", hash_original_method = "A082C8E505553F853E56AAFC11CF0CDA", hash_generated_method = "2B685E18605A48F51EF2A58C1BB8F3B5")
    public final void scale(float scale) {
        nativeScale(mNativePtr, scale);
        addTaint(scale);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.621 -0400", hash_original_method = "E51EA2AB032E4C79CC226174E2601818", hash_generated_method = "A715035CAD9EC49AFE523419A30677DE")
    @Override
    public final int getDeviceId() {
        int varF3B3D3917F994FE161C0ABB4D3E565B5_1737781700 = (nativeGetDeviceId(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1984637025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1984637025;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.622 -0400", hash_original_method = "44501F684180CAB98F3511C2614C7994", hash_generated_method = "AE1B7FB36C1EEC37FAC611E3D897EF1E")
    @Override
    public final int getSource() {
        int var626B65A92B0E4AF71704C1098173596F_782240867 = (nativeGetSource(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385934775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385934775;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.622 -0400", hash_original_method = "1502AF3F26B6DD95879512031D9FB73E", hash_generated_method = "4F9E3DEBB9978F4944F95EF530F213F6")
    @Override
    public final void setSource(int source) {
        nativeSetSource(mNativePtr, source);
        addTaint(source);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.622 -0400", hash_original_method = "FA5880EB8F61D955AC5922ACE620FCE2", hash_generated_method = "A70FAA89E4F6836ED93E8FF3D67D7872")
    public final int getAction() {
        int var74B8A914B86C4917D117B6A52D32C79D_1906815705 = (nativeGetAction(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434976703 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434976703;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.622 -0400", hash_original_method = "268411790684740D49A019DF59E1FFBB", hash_generated_method = "2C95FF1C7E6CAAB2F7BDB188E065DA0F")
    public final int getActionMasked() {
        int var119771AD723EE5854F55019431496A74_737531974 = (nativeGetAction(mNativePtr) & ACTION_MASK);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_978696193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_978696193;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.623 -0400", hash_original_method = "464EE1689B645958C6F5E17990D5ECA4", hash_generated_method = "0882B315511760C1B58705DBFCEAFBC1")
    public final int getActionIndex() {
        int var853FB894ACCBEFFE5F8E24DD3377AFAF_520026926 = ((nativeGetAction(mNativePtr) & ACTION_POINTER_INDEX_MASK)
                >> ACTION_POINTER_INDEX_SHIFT);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_849351775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_849351775;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.623 -0400", hash_original_method = "3A9CDEA51D903248E7ACBBA8C3F57155", hash_generated_method = "8AFCA69DFC3FF622DBF7E2389DFE8D32")
    public final boolean isTouchEvent() {
        boolean var12F7F7B53A02590E12DD99382B4D1A89_1835346118 = (nativeIsTouchEvent(mNativePtr));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1155396728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1155396728;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.623 -0400", hash_original_method = "A25E485C356A262F519C0A5841CFA47B", hash_generated_method = "5EE47D7F71FC8248CEB97B7BEA4E6EA4")
    public final int getFlags() {
        int var31A262589A0563B992AF6C13BB445DA6_1999530623 = (nativeGetFlags(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920844947 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920844947;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.624 -0400", hash_original_method = "24A8A0C0077001C335E0B5C917301FE4", hash_generated_method = "EC24DDD9FDBE9F3917A8B7C3AF00128E")
    @Override
    public final boolean isTainted() {
        final int flags = getFlags();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479294130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_479294130;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.624 -0400", hash_original_method = "96C1138F844BE852B50B0529E539E061", hash_generated_method = "9796687FCF1817E2AF4B7B496AC07273")
    @Override
    public final void setTainted(boolean tainted) {
        final int flags = getFlags();
        nativeSetFlags(mNativePtr, tainted ? flags | FLAG_TAINTED : flags & ~FLAG_TAINTED);
        addTaint(tainted);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.625 -0400", hash_original_method = "5F4C05CD4E223E38846D15A6EA0DF305", hash_generated_method = "8FD1493971EC404F38CE7AEB25F2C85C")
    public final long getDownTime() {
        long varA7AEBDC62AD9E48221ED001FAEE4896D_1425451710 = (nativeGetDownTimeNanos(mNativePtr) / NS_PER_MS);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_349669906 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_349669906;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.625 -0400", hash_original_method = "97B3432DE604A4A8C3339017F5056697", hash_generated_method = "C82DB4CB82274A97586E19935264D40C")
    public final void setDownTime(long downTime) {
        nativeSetDownTimeNanos(mNativePtr, downTime * NS_PER_MS);
        addTaint(downTime);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.626 -0400", hash_original_method = "CCF6A1C7FFBA398090457272FB07E7C9", hash_generated_method = "B141D14855FF8C1649933FC1C9B174AE")
    public final long getEventTime() {
        long varABD7EED75F03AC822986337AA0AEBA8E_1629625550 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT) / NS_PER_MS);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1558124494 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1558124494;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.627 -0400", hash_original_method = "9EB1FC24DA069289850F91A3F8734D9A", hash_generated_method = "BF780E394F5D054C81B518949F7B3272")
    public final long getEventTimeNano() {
        long var9177F0DF4886BA63EBD71602211F864C_1698908738 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_428317742 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_428317742;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.627 -0400", hash_original_method = "4BF6642E766343B332FD98949BC6C582", hash_generated_method = "D183D0CF3215B07BC72073604AACA58A")
    public final float getX() {
        float var66044244940F058BEDF52F995ECDF659_1633556416 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_1452240449 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1452240449;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.628 -0400", hash_original_method = "91A63DEAB3A8AC7438EA04466792BD82", hash_generated_method = "7C54A6CCE3BAB80CA5489E46876941EB")
    public final float getY() {
        float varC75AFE4F07E18DED73B6E9A135DBAA24_1769510992 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_1241946683 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1241946683;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.628 -0400", hash_original_method = "6675B94FFDE5461AE8829AF0934758CB", hash_generated_method = "9A24C448DB63AA5B3067D7E700C58722")
    public final float getPressure() {
        float varEF9A2F87450786CEB865F6DB8CC3ECFD_1670870849 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_1431140028 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1431140028;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.629 -0400", hash_original_method = "04BA234B263118C319F9FB3039E4C966", hash_generated_method = "4310AD2137905EC081D8840CF8C57C53")
    public final float getSize() {
        float varDFF5D0290CDD1A07C8B97F2F6E962921_1583957402 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_1124251930 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1124251930;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.629 -0400", hash_original_method = "7EDCA08C9EC8F904EE9855CC249509CB", hash_generated_method = "73F414F40533BE4EFA025E0DD8E33348")
    public final float getTouchMajor() {
        float var2C0DAF19E2431B7454CC6F77C73821E0_899911126 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_1872190437 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1872190437;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.629 -0400", hash_original_method = "0D1B5526DE02F52B1563B7D7F6F58090", hash_generated_method = "A392E64B58881CDADC54DB4B44DAC0BB")
    public final float getTouchMinor() {
        float var4508F4DDA7AD6F23C2A12D53FC2B6353_1477389127 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_655834428 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_655834428;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.630 -0400", hash_original_method = "88DA06A5CC2E8F8456F3789E8A68ED44", hash_generated_method = "A1B37535ECE60125986A63205EF2B569")
    public final float getToolMajor() {
        float varC9DDB5D5521C8A6BB646AB1BF9C7D9E2_273360166 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_1441604782 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1441604782;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.630 -0400", hash_original_method = "68541C2106990EEA679DCE03A62D7FCC", hash_generated_method = "B9E5D88B9F37DCE45B935B020C0D69D3")
    public final float getToolMinor() {
        float var695C0E240E818E6BDB2EBB725DE208C8_1157405650 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_1766314591 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1766314591;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.630 -0400", hash_original_method = "6DB87F8256212E2B4D49883D1C47D372", hash_generated_method = "AF8C61584F023056F47527B539D3460C")
    public final float getOrientation() {
        float var75B1DB96187E89974E64BC0FB38B1FEF_602574146 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_720959979 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_720959979;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.631 -0400", hash_original_method = "630AA047225B25427528E4D32F567B17", hash_generated_method = "04708F699759375791D1A81D1C0FC449")
    public final float getAxisValue(int axis) {
        float var4FF16B9B17710DEACD9EEA98B643B740_1769421616 = (nativeGetAxisValue(mNativePtr, axis, 0, HISTORY_CURRENT));
        addTaint(axis);
        float var546ADE640B6EDFBC8A086EF31347E768_146508881 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_146508881;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.631 -0400", hash_original_method = "2050CCC0293D52B162C880AD9BC3C6F6", hash_generated_method = "5D450F755144F10301E5AF15FF915DBD")
    public final int getPointerCount() {
        int var5ACA797B73271718F08C07B0FD1465C3_1425040036 = (nativeGetPointerCount(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318495306 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318495306;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.631 -0400", hash_original_method = "43D465AFB7AC0153BC6ACD556C5FF613", hash_generated_method = "C9298A18AC359F85F1E99E47B2ABFE3A")
    public final int getPointerId(int pointerIndex) {
        int var17A8C53C4A6DAF94DA4FE0E64E276DEB_801051239 = (nativeGetPointerId(mNativePtr, pointerIndex));
        addTaint(pointerIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_467256779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_467256779;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.632 -0400", hash_original_method = "4F4E823E6A973C2A4D85C86C0A6A2D9D", hash_generated_method = "AA5917A391D483EACA7769E2B45DDB51")
    public final int getToolType(int pointerIndex) {
        int var705074F16347B844E833B41BDB330DC5_579325506 = (nativeGetToolType(mNativePtr, pointerIndex));
        addTaint(pointerIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1256749008 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1256749008;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.632 -0400", hash_original_method = "396B4C03ADE41E49E928286EB7438AA9", hash_generated_method = "F591C1181BEBA611C9D6317330562432")
    public final int findPointerIndex(int pointerId) {
        int varCF3227509A91EFEBFB983EC37BCBBB09_348892716 = (nativeFindPointerIndex(mNativePtr, pointerId));
        addTaint(pointerId);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922905325 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922905325;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.632 -0400", hash_original_method = "13E56CEAC1D2714A9A1790EF5117F935", hash_generated_method = "49C8D60780361115A6E0127D5BD56664")
    public final float getX(int pointerIndex) {
        float var22607ACD4999ED3178C2C16BA32F39FA_390503525 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1234282828 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1234282828;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.632 -0400", hash_original_method = "9A0C47F653E064961B232F3274CD29C9", hash_generated_method = "592E80407983F8CC2A5531AB5855F941")
    public final float getY(int pointerIndex) {
        float varEC964DA0D0FCB932F45F9605581B800C_2127188495 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_2036883359 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2036883359;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.633 -0400", hash_original_method = "36E2BAC74F4F826870F428D93CA1D371", hash_generated_method = "4C1E82E7942BC8EA0B117DE86E973BAC")
    public final float getPressure(int pointerIndex) {
        float varDB60B99C5EF7895E6B92B91772C5962E_1057528584 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1038108137 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1038108137;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.633 -0400", hash_original_method = "50DE00A69645B3335E8383A50AB1EB05", hash_generated_method = "F0AC7F5353AE67A9E5A110E8F5F46429")
    public final float getSize(int pointerIndex) {
        float varB4E63BA449D57F4253A0AB8919D42D10_1604191783 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1384873342 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1384873342;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.633 -0400", hash_original_method = "28BED69B39230D6E2E593658DA262948", hash_generated_method = "1DB96DA051DC92B868A1D25AEC9550B7")
    public final float getTouchMajor(int pointerIndex) {
        float varA24CED3D0F358E3C65B964973B4F5F83_1002559099 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_948704151 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_948704151;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.634 -0400", hash_original_method = "2C1FBE2BFEFC6BD6A6EFC25F55DD94B0", hash_generated_method = "BBE7A3E7E40AC9EEBCF4F8960402C92C")
    public final float getTouchMinor(int pointerIndex) {
        float var120D3EDA1AEC95857772396D3ADDF431_329222475 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1561841878 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1561841878;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.634 -0400", hash_original_method = "66B849A9DC257EF38185AFB935434C46", hash_generated_method = "6CE97DAF681FDD3A5969A057D4E9D8D8")
    public final float getToolMajor(int pointerIndex) {
        float varE1A0953AB1720A635D0A001029F15F98_1492276459 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_2044915549 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2044915549;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.635 -0400", hash_original_method = "F39564D767A71A1EAACBC920B100E436", hash_generated_method = "148BB3A0759AA3E56D760DAA112669F7")
    public final float getToolMinor(int pointerIndex) {
        float varC32F5653C2BD206ECB16EB3579C5B644_1000200606 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_532991087 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_532991087;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.635 -0400", hash_original_method = "A9038F286A5A1470BB26B4145360A2CC", hash_generated_method = "1914AF5F29D5A284DE089C9D2A54DC20")
    public final float getOrientation(int pointerIndex) {
        float var865B68C13F122391AB0E054D3314ED41_1352722590 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, HISTORY_CURRENT));
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_901842017 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_901842017;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.635 -0400", hash_original_method = "3434CDF166CDB98F83BC4BA0F4722E7E", hash_generated_method = "1414FB543B838830E84B47C24ADBC583")
    public final float getAxisValue(int axis, int pointerIndex) {
        float varDC8E493A6FB2EE0C0CB23BC5DBBC02F1_628817717 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, HISTORY_CURRENT));
        addTaint(axis);
        addTaint(pointerIndex);
        float var546ADE640B6EDFBC8A086EF31347E768_1572394473 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1572394473;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.636 -0400", hash_original_method = "33DE471947CC053A5003BB5AAC41F910", hash_generated_method = "C2634D55CDBB110158610B7C8510FCC1")
    public final void getPointerCoords(int pointerIndex, PointerCoords outPointerCoords) {
        nativeGetPointerCoords(mNativePtr, pointerIndex, HISTORY_CURRENT, outPointerCoords);
        addTaint(pointerIndex);
        addTaint(outPointerCoords.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.637 -0400", hash_original_method = "FC8907B12AF62543F5FA0564EA522E62", hash_generated_method = "3817B6CBDA6CAF5BC227122F4E8174BF")
    public final void getPointerProperties(int pointerIndex,
            PointerProperties outPointerProperties) {
        nativeGetPointerProperties(mNativePtr, pointerIndex, outPointerProperties);
        addTaint(pointerIndex);
        addTaint(outPointerProperties.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.637 -0400", hash_original_method = "38A68962B5CFD92D43EE16A436EABCF2", hash_generated_method = "A9B6365FD873175609AE40DFC17FC5A0")
    public final int getMetaState() {
        int var2EB518F4D6071C6F350D1D5C097F88FF_1710692369 = (nativeGetMetaState(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100551512 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100551512;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.638 -0400", hash_original_method = "C8458CE15D5B2817F47A4FD377CE1968", hash_generated_method = "3196D069F67FD8A02AC637594608753E")
    public final int getButtonState() {
        int var6E0173150D4C4630052CCF82C8F7DC9F_458166591 = (nativeGetButtonState(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1968968925 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1968968925;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.638 -0400", hash_original_method = "6E457CC599C66DF6B9AC57A3DF3B8E7E", hash_generated_method = "C6E84B99E24158AD1CF9004AD1200C65")
    public final float getRawX() {
        float var78851251BB2BADD4A73F875B41E82C95_97158451 = (nativeGetRawAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_247136858 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_247136858;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.639 -0400", hash_original_method = "C18C1837908CE668DE325D32328DA600", hash_generated_method = "DD46D612B82D699EC9C8AC3C107F17DA")
    public final float getRawY() {
        float varB2F71D566D9DFEDA8765CB859668364C_341089850 = (nativeGetRawAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
        float var546ADE640B6EDFBC8A086EF31347E768_49657281 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_49657281;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.639 -0400", hash_original_method = "32503B0D7203271814D12FFB8906664F", hash_generated_method = "41FD5BEBDD1A3E41776F2A40313B262B")
    public final float getXPrecision() {
        float var8C63D112819BF4307BFC05C55813CC7C_2047279547 = (nativeGetXPrecision(mNativePtr));
        float var546ADE640B6EDFBC8A086EF31347E768_2118909464 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2118909464;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.639 -0400", hash_original_method = "77B44C5CFF493101D20AF55AA249AFB4", hash_generated_method = "F5426B6F6F07ECBB7430D4BC25C68DDB")
    public final float getYPrecision() {
        float var2DA4AA757DDFF641DBCEE9F2CC39A8B1_1462453861 = (nativeGetYPrecision(mNativePtr));
        float var546ADE640B6EDFBC8A086EF31347E768_1146574766 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1146574766;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.640 -0400", hash_original_method = "B4D273F4D2084C890DE19B631E3ED869", hash_generated_method = "B1B2CE14D893210A3938243564910071")
    public final int getHistorySize() {
        int var42FF49C139613133CE8AAF262A0781C4_1989067487 = (nativeGetHistorySize(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1783854354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1783854354;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.640 -0400", hash_original_method = "4F37DFE9294EB232F86D1F83C2ADDC74", hash_generated_method = "0257F23437ADB1F94B27062E9E10C269")
    public final long getHistoricalEventTime(int pos) {
        long var86B3FEF5B6798FC4F49A53A44960DD31_386230111 = (nativeGetEventTimeNanos(mNativePtr, pos) / NS_PER_MS);
        addTaint(pos);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_449096024 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_449096024;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.640 -0400", hash_original_method = "52641DCD8C1505610834B8CDD1492B06", hash_generated_method = "CAD75B83547A1B2F980907475EC0EE97")
    public final float getHistoricalX(int pos) {
        float varD6254ED09F523E7C1E53ADA626DF0C10_705450721 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1653000787 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1653000787;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.641 -0400", hash_original_method = "456D8725235AB4DBC45E47B4ADD23013", hash_generated_method = "8638D8CBB48B8C10E37FADAE22236E91")
    public final float getHistoricalY(int pos) {
        float varF753E500532420F185A79C4FC58F3F0B_1289594688 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_166965695 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_166965695;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.641 -0400", hash_original_method = "E822398D8AD69E2A637D6F0BC07F61D8", hash_generated_method = "C4A7F0DF75595AA765D0E3742946504B")
    public final float getHistoricalPressure(int pos) {
        float var8CCA0683C3AD89698B4BB2DCB56AF6E0_136747772 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_779153440 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_779153440;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.641 -0400", hash_original_method = "A43A8374A73078EDB84358D609B2C354", hash_generated_method = "4A190FCD2989329A1F2037AD85B63428")
    public final float getHistoricalSize(int pos) {
        float varA2CCAFC013471427EED1D8795B79DF34_1917329834 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_505529519 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_505529519;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.642 -0400", hash_original_method = "192AC6C55C0D7020BB0EA3AE5DE4FD65", hash_generated_method = "18336BD7737796F2442926D84914DD98")
    public final float getHistoricalTouchMajor(int pos) {
        float var8E7AD2DB9688820EB8F0B7CB347E27F7_854681522 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1315775281 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1315775281;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.642 -0400", hash_original_method = "122C0ECAA119AC26B3F087E871FFA312", hash_generated_method = "6AE6D3CFC1B2AAD60DBB803624EC8A61")
    public final float getHistoricalTouchMinor(int pos) {
        float var47136F660FFE6DBB3965B94BCAC103FF_242848897 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1368685339 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1368685339;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.642 -0400", hash_original_method = "8097CEA35B3273816C6109CC76A9BC74", hash_generated_method = "CB538EBC2292AA1CBC311851C0DDA5F7")
    public final float getHistoricalToolMajor(int pos) {
        float varACE33102325AC5113F663D281165CB12_1319440208 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1730641565 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1730641565;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.643 -0400", hash_original_method = "E0365AAE3D6BF704A796F5D4E7964FB9", hash_generated_method = "3988ACE7E744C1E71634A9C8F6911792")
    public final float getHistoricalToolMinor(int pos) {
        float varBDFEBFC87FD2C86C951881656D01FBFE_1873437288 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_405086327 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_405086327;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.643 -0400", hash_original_method = "DC8FCE9CD404D08D0BFF0CC77CEE87C1", hash_generated_method = "D6A258E8032C68FAD005CB575821E5BF")
    public final float getHistoricalOrientation(int pos) {
        float var9ABC98E782A3870F9AA5DFC3F27D891C_1852552499 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, pos));
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_21948505 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_21948505;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.643 -0400", hash_original_method = "697532A0192D8868F2E3AE618301BF20", hash_generated_method = "F050A8C386607A96DF7D3C5601CC3691")
    public final float getHistoricalAxisValue(int axis, int pos) {
        float varE580B6B92EAD96F426B34B55A944EC3F_1307433580 = (nativeGetAxisValue(mNativePtr, axis, 0, pos));
        addTaint(axis);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_777763489 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_777763489;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.643 -0400", hash_original_method = "8BFA09569623FF1F941D2134C3D47F02", hash_generated_method = "424633A2CC2C77817E8E9513BABDB1CD")
    public final float getHistoricalX(int pointerIndex, int pos) {
        float var70F4D2CDA260BE637BE2F366621D1047_1130254907 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1699563135 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1699563135;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.644 -0400", hash_original_method = "9787FE8A43AC5153EC8D7EC463FC985B", hash_generated_method = "AC91E9598F3C5059FB057255F5D2BFB2")
    public final float getHistoricalY(int pointerIndex, int pos) {
        float var4338B7951F95F5B1B66FDB2F4DC27413_1534453923 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1346411639 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1346411639;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.644 -0400", hash_original_method = "A8F703E0BCBA29F53C62C25AACD436ED", hash_generated_method = "5D7F9456AB0D2DF7A423D1A6CEDE866D")
    public final float getHistoricalPressure(int pointerIndex, int pos) {
        float var599EE82AA7EED666174FF6603E5D9EDB_750403965 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1145737615 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1145737615;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.645 -0400", hash_original_method = "66A9DA10859CF6933D658F61BE53F70F", hash_generated_method = "276D7B378FA8E9EB00165955655EB18C")
    public final float getHistoricalSize(int pointerIndex, int pos) {
        float var6ADB36223580AAF1DF6650FEF9BEFE5F_863557431 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1902858600 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1902858600;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.645 -0400", hash_original_method = "38D72D2E0F00AE5C39667CDDD41B271D", hash_generated_method = "E8B97BDC9E9CFF88DC7EF82F8E390320")
    public final float getHistoricalTouchMajor(int pointerIndex, int pos) {
        float var04576CC24CDC939EA1B84F18BA4AA27C_1761933022 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1618058446 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1618058446;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.645 -0400", hash_original_method = "F3D94A1F01A3ECEF6DEDEA9361640BF9", hash_generated_method = "E5D7CE8B0E97EAD2F2CAF07E5A8967A2")
    public final float getHistoricalTouchMinor(int pointerIndex, int pos) {
        float varE0E8C51F7817613AD2DBA52263E38B64_187986116 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_408099542 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_408099542;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.646 -0400", hash_original_method = "78FB77773CB43A5420D0F24849B540AD", hash_generated_method = "A3BB5449A0D1BE9262067A21BC0F59BA")
    public final float getHistoricalToolMajor(int pointerIndex, int pos) {
        float var40EEA85674FBE73ABF2A2BD2F2E74CD6_1632456078 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_440707738 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_440707738;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.646 -0400", hash_original_method = "4AB7745853006A3796DAD0E637CCA598", hash_generated_method = "8D8C6C8B4CA63AC10F80E11E20986A31")
    public final float getHistoricalToolMinor(int pointerIndex, int pos) {
        float var784F21A01E3CEC7D68998B91D48C129C_1088743964 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_982618835 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_982618835;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.647 -0400", hash_original_method = "160C0106DB8A4C6FBAA9569ABA0D68E8", hash_generated_method = "B728D717E54F5C040789CFFC74772203")
    public final float getHistoricalOrientation(int pointerIndex, int pos) {
        float var02FA0A42AAD0F907D9EB0C172EDB6AB4_929344828 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, pos));
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_949400326 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_949400326;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.647 -0400", hash_original_method = "F645AABE3B2CF14D2790BA051F9F3FF1", hash_generated_method = "0BD1BCCBC0471D1352E445C0B8B5C782")
    public final float getHistoricalAxisValue(int axis, int pointerIndex, int pos) {
        float var675E97582C752387B4365682C4F7B0FA_1683679251 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, pos));
        addTaint(axis);
        addTaint(pointerIndex);
        addTaint(pos);
        float var546ADE640B6EDFBC8A086EF31347E768_1146076081 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1146076081;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.648 -0400", hash_original_method = "D80ADCD256759644414D5CBEC3C57D0B", hash_generated_method = "823891EAFF818A17196A773F0FA5CE89")
    public final void getHistoricalPointerCoords(int pointerIndex, int pos,
            PointerCoords outPointerCoords) {
        nativeGetPointerCoords(mNativePtr, pointerIndex, pos, outPointerCoords);
        addTaint(pointerIndex);
        addTaint(pos);
        addTaint(outPointerCoords.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.648 -0400", hash_original_method = "26EA400A9751805DFF1D4CEEB005645B", hash_generated_method = "01AAFE59A87CEF05987674F7546FD2C1")
    public final int getEdgeFlags() {
        int var0FC0D903F55D3C457853DAA4F228A5D4_1620422664 = (nativeGetEdgeFlags(mNativePtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337442212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337442212;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.648 -0400", hash_original_method = "348B6A1C5666102E94291FA4791C249A", hash_generated_method = "5A4570138FFF3A25CF234159371B5805")
    public final void setEdgeFlags(int flags) {
        nativeSetEdgeFlags(mNativePtr, flags);
        addTaint(flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.649 -0400", hash_original_method = "34CE363FC32882BC3BBCF2E8ABF2B5B0", hash_generated_method = "A9E08CEA9A55C1AD709C1AB66565DD54")
    public final void setAction(int action) {
        nativeSetAction(mNativePtr, action);
        addTaint(action);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.649 -0400", hash_original_method = "117CE161431F2ECDED077AD7F7467ADD", hash_generated_method = "F7F6376FBB851076E5998FA5155D9734")
    public final void offsetLocation(float deltaX, float deltaY) {
        nativeOffsetLocation(mNativePtr, deltaX, deltaY);
        addTaint(deltaX);
        addTaint(deltaY);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.649 -0400", hash_original_method = "D9D9F7662138ADF2F9591F7DFAEB3F74", hash_generated_method = "9B1CD4ADDA406CE514648CB8735C1D91")
    public final void setLocation(float x, float y) {
        float oldX = getX();
        float oldY = getY();
        nativeOffsetLocation(mNativePtr, x - oldX, y - oldY);
        addTaint(x);
        addTaint(y);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.650 -0400", hash_original_method = "622D19544C973DA41E1BE7D7819B5A41", hash_generated_method = "004135DE97E073DF20896A01618AE199")
    public final void transform(Matrix matrix) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("matrix must not be null");
        } 
        nativeTransform(mNativePtr, matrix);
        addTaint(matrix.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.650 -0400", hash_original_method = "F001981BC7F115C74B7EB0136965714D", hash_generated_method = "64FE82106A62A0947A7B6AFF121F3865")
    public final void addBatch(long eventTime, float x, float y,
            float pressure, float size, int metaState) {
        {
            ensureSharedTempPointerCapacity(1);
            final PointerCoords[] pc = gSharedTempPointerCoords;
            pc[0].clear();
            pc[0].x = x;
            pc[0].y = y;
            pc[0].pressure = pressure;
            pc[0].size = size;
            nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pc, metaState);
        } 
        addTaint(eventTime);
        addTaint(x);
        addTaint(y);
        addTaint(pressure);
        addTaint(size);
        addTaint(metaState);
        
        
            
            
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.651 -0400", hash_original_method = "06E22018450E3E0892CD70DE9E19F211", hash_generated_method = "7A120BD6D13363A133E619C134B29A2E")
    public final void addBatch(long eventTime, PointerCoords[] pointerCoords, int metaState) {
        nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pointerCoords, metaState);
        addTaint(eventTime);
        addTaint(pointerCoords[0].getTaint());
        addTaint(metaState);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.651 -0400", hash_original_method = "542474DD15BDDADB068A65C6A3EEA8E2", hash_generated_method = "BF69739086F40DBA15F25D7F26B246C9")
    public final boolean isWithinBoundsNoHistory(float left, float top,
            float right, float bottom) {
        final int pointerCount = nativeGetPointerCount(mNativePtr);
        {
            int i = 0;
            {
                final float x = nativeGetAxisValue(mNativePtr, AXIS_X, i, HISTORY_CURRENT);
                final float y = nativeGetAxisValue(mNativePtr, AXIS_Y, i, HISTORY_CURRENT);
            } 
        } 
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_621854888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_621854888;
        
        
        
            
            
            
                
            
        
        
    }

    
    private static final float clamp(float value, float low, float high) {
        if (value < low) {
            return low;
        } else if (value > high) {
            return high;
        }
        return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.652 -0400", hash_original_method = "C00E6E79D43678980DA0F4144A65F6A2", hash_generated_method = "0B0663C026662B11A2BA24CE29AC9ABC")
    public final MotionEvent clampNoHistory(float left, float top, float right, float bottom) {
        MotionEvent varB4EAC82CA7396A68D541C85D26508E83_104941107 = null; 
        MotionEvent ev = obtain();
        {
            final int pointerCount = nativeGetPointerCount(mNativePtr);
            ensureSharedTempPointerCapacity(pointerCount);
            final PointerProperties[] pp = gSharedTempPointerProperties;
            final PointerCoords[] pc = gSharedTempPointerCoords;
            {
                int i = 0;
                {
                    nativeGetPointerProperties(mNativePtr, i, pp[i]);
                    nativeGetPointerCoords(mNativePtr, i, HISTORY_CURRENT, pc[i]);
                    pc[i].x = clamp(pc[i].x, left, right);
                    pc[i].y = clamp(pc[i].y, top, bottom);
                } 
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
            varB4EAC82CA7396A68D541C85D26508E83_104941107 = ev;
        } 
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        varB4EAC82CA7396A68D541C85D26508E83_104941107.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_104941107;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.653 -0400", hash_original_method = "FBF170B15B2FFBEE1AB1D4E32A8773CA", hash_generated_method = "1B03A28C2A058FD24B4934E90F7C288B")
    public final int getPointerIdBits() {
        int idBits = 0;
        final int pointerCount = nativeGetPointerCount(mNativePtr);
        {
            int i = 0;
            {
                idBits |= 1 << nativeGetPointerId(mNativePtr, i);
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_199157307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_199157307;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.654 -0400", hash_original_method = "4F0FF8B26009CA9D26EE500AEFE507EC", hash_generated_method = "0B29DBB51416976977F6EF419782AC86")
    public final MotionEvent split(int idBits) {
        MotionEvent varB4EAC82CA7396A68D541C85D26508E83_2133228132 = null; 
        MotionEvent ev = obtain();
        {
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
            {
                int i = 0;
                {
                    nativeGetPointerProperties(mNativePtr, i, pp[newPointerCount]);
                    final int idBit = 1 << pp[newPointerCount].id;
                    {
                        {
                            newActionPointerIndex = newPointerCount;
                        } 
                        map[newPointerCount] = i;
                        newPointerCount += 1;
                        newIdBits |= idBit;
                    } 
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("idBits did not match any ids in the event");
            } 
            int newAction;
            {
                {
                    newAction = ACTION_MOVE;
                } 
                {
                    newAction = oldActionMasked == ACTION_POINTER_DOWN
                            ? ACTION_DOWN : ACTION_UP;
                } 
                {
                    newAction = oldActionMasked
                            | (newActionPointerIndex << ACTION_POINTER_INDEX_SHIFT);
                } 
            } 
            {
                newAction = oldAction;
            } 
            final int historySize = nativeGetHistorySize(mNativePtr);
            {
                int h = 0;
                {
                    int historyPos;
                    historyPos = HISTORY_CURRENT;
                    historyPos = h;
                    {
                        int i = 0;
                        {
                            nativeGetPointerCoords(mNativePtr, map[i], historyPos, pc[i]);
                        } 
                    } 
                    final long eventTimeNanos = nativeGetEventTimeNanos(mNativePtr, historyPos);
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
                    {
                        nativeAddBatch(ev.mNativePtr, eventTimeNanos, pc, 0);
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2133228132 = ev;
        } 
        addTaint(idBits);
        varB4EAC82CA7396A68D541C85D26508E83_2133228132.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2133228132;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.656 -0400", hash_original_method = "69A985781D7A79E036178DEB42E5F1F0", hash_generated_method = "3BE2B5B2EFFE93814750FD50B86421AC")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1709717389 = null; 
        StringBuilder msg = new StringBuilder();
        msg.append("MotionEvent { action=").append(actionToString(getAction()));
        final int pointerCount = getPointerCount();
        {
            int i = 0;
            {
                msg.append(", id[").append(i).append("]=").append(getPointerId(i));
                msg.append(", x[").append(i).append("]=").append(getX(i));
                msg.append(", y[").append(i).append("]=").append(getY(i));
                msg.append(", toolType[").append(i).append("]=").append(
                    toolTypeToString(getToolType(i)));
            } 
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
        varB4EAC82CA7396A68D541C85D26508E83_1709717389 = msg.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1709717389.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1709717389;
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_method = "D732CA58C71ED959C0E1A12C336FC80D", hash_generated_method = "7F92D8EF6DB846D045EDC9EED70EE51B")
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(PARCEL_TOKEN_MOTION_EVENT);
        nativeWriteToParcel(mNativePtr, out);
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
    }

    
    public static final class PointerCoords {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_field = "E4845520982C15184227C7CC9D20FD50", hash_generated_field = "616BA79E3CF38111CD6326A774A7BA12")

        private long mPackedAxisBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_field = "5195E654A9F1469D3F33B6FBBCE24383", hash_generated_field = "74AC3FA36AA575C3DEE392AD51F3FC84")

        private float[] mPackedAxisValues;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "0CC4A8770822EF2A4B3BD536BBF6C113")

        public float x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "E8D9A0915E4274087E59C025C4DCDA11")

        public float y;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_field = "D99FAD96A5D0A7CB2EB41341EA556093", hash_generated_field = "8D3DD02B3785A296D75D1BFB99C62E42")

        public float pressure;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "295F60DE48801BD75A245B044AE96BA0")

        public float size;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_field = "95BE195AF7AF1434BA03D8E831DC4D43", hash_generated_field = "6D6952CAD458217EEFCB2922EE3D3E82")

        public float touchMajor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_field = "AF72E652DB6EACE533A5766E00C83453", hash_generated_field = "492641BCD483F61BC74CAF973D65A13D")

        public float touchMinor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_field = "B0B8BF85D8A3FA50D314A293B6CA49AC", hash_generated_field = "32FD2A0018A7199A2ED20949B6E0486E")

        public float toolMajor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_field = "2A170207574AE57015C852C226F8048D", hash_generated_field = "173EB15A07C0771733DC98A43E20CE98")

        public float toolMinor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.660 -0400", hash_original_field = "DA1639422AD8F355D2371428471379B5", hash_generated_field = "054A1E23DAAFDEC28AE3DA031EECF136")

        public float orientation;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.661 -0400", hash_original_method = "30C014872AED120D5788F672204C6D56", hash_generated_method = "02D472FB06CC6A49D31A045DF0321860")
        public  PointerCoords() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.661 -0400", hash_original_method = "4C1A041805DDE756B7430BBCF7A4A54D", hash_generated_method = "48391C838CCB750879BFEE73F5AB3F53")
        public  PointerCoords(PointerCoords other) {
            copyFrom(other);
            addTaint(other.getTaint());
            
            
        }

        
        public static PointerCoords[] createArray(int size) {
            PointerCoords[] array = new PointerCoords[size];
            for (int i = 0; i < size; i++) {
                array[i] = new PointerCoords();
            }
            return array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.661 -0400", hash_original_method = "5B10C041062144B27347C9202A1953B2", hash_generated_method = "85A3A31EE556A4BEA00BDAAD4B198A1A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.662 -0400", hash_original_method = "A2C68F8615572C95C5947791A8CC8026", hash_generated_method = "C1F0F677ABF7B6FC5B2CAAEE5D38D46A")
        public void copyFrom(PointerCoords other) {
            final long bits = other.mPackedAxisBits;
            mPackedAxisBits = bits;
            {
                final float[] otherValues = other.mPackedAxisValues;
                final int count = Long.bitCount(bits);
                float[] values = mPackedAxisValues;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.663 -0400", hash_original_method = "566631CFDB34A411EF93513211D62594", hash_generated_method = "ED249138EF303F7C20A20E16498131DE")
        public float getAxisValue(int axis) {
            
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Axis out of range.");
                } 
                final long bits = mPackedAxisBits;
                final long axisBit = 1L << axis;
                final int index = Long.bitCount(bits & (axisBit - 1L));
            } 
            
            addTaint(axis);
            float var546ADE640B6EDFBC8A086EF31347E768_904809049 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_904809049;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.663 -0400", hash_original_method = "55E9DEFA01615304E1434A1FAB8328FA", hash_generated_method = "F1760985D3AA8576BD20F9F7593CEB1C")
        public void setAxisValue(int axis, float value) {
            
            x = value;
            
            
            y = value;
            
            
            pressure = value;
            
            
            size = value;
            
            
            touchMajor = value;
            
            
            touchMinor = value;
            
            
            toolMajor = value;
            
            
            toolMinor = value;
            
            
            orientation = value;
            
            
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Axis out of range.");
                } 
                final long bits = mPackedAxisBits;
                final long axisBit = 1L << axis;
                final int index = Long.bitCount(bits & (axisBit - 1L));
                float[] values = mPackedAxisValues;
                {
                    {
                        values = new float[INITIAL_PACKED_AXIS_VALUES];
                        mPackedAxisValues = values;
                    } 
                    {
                        final int count = Long.bitCount(bits);
                        {
                            {
                                System.arraycopy(values, index, values, index + 1,
                                            count - index);
                            } 
                        } 
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
            
            addTaint(axis);
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.663 -0400", hash_original_field = "33446AA70F42B7C22C25CFDF4E916659", hash_generated_field = "1ED50B8C8EE9915850360B0973B4FC02")

        private static final int INITIAL_PACKED_AXIS_VALUES = 8;
    }


    
    public static final class PointerProperties {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.664 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

        public int id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.664 -0400", hash_original_field = "F803A61F4662F15B2A4B72308BD45F04", hash_generated_field = "E5CA883B5E8E2CF4928B3E305240E7C6")

        public int toolType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.664 -0400", hash_original_method = "D6AAE40F539D7383E827DA395512E95B", hash_generated_method = "207B464AAB7566FD25D2646B7EE6C19D")
        public  PointerProperties() {
            clear();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.664 -0400", hash_original_method = "0B0B44B5B3A0DCF648446956F27785E9", hash_generated_method = "546D6C0D6DB00699FD7A0BFFECCB1CBA")
        public  PointerProperties(PointerProperties other) {
            copyFrom(other);
            addTaint(other.getTaint());
            
            
        }

        
        public static PointerProperties[] createArray(int size) {
            PointerProperties[] array = new PointerProperties[size];
            for (int i = 0; i < size; i++) {
                array[i] = new PointerProperties();
            }
            return array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_method = "ADC6A83F955A9ED0C1C75B5F08682583", hash_generated_method = "DFC90B75E706F2F74BBF473BA904F663")
        public void clear() {
            id = INVALID_POINTER_ID;
            toolType = TOOL_TYPE_UNKNOWN;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_method = "1E34ECE529256025A33CF5DCBE029131", hash_generated_method = "83EE2C55C6A446D371F6C2FC0D637123")
        public void copyFrom(PointerProperties other) {
            id = other.id;
            toolType = other.toolType;
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "6E4EF440EBC2808EB9427311B59A1879", hash_generated_field = "1E55FD918071A214A5C67DF1505BB56B")

    private static final long NS_PER_MS = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "72335DCE9A3EDFEDA119916AF8BD9A52", hash_generated_field = "FA3C17D544830BC1BEE55D29729BDFE3")

    private static final boolean TRACK_RECYCLED_LOCATION = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "337218C9F350445474335E0ED8EB52D2", hash_generated_field = "122232306FDB60B34ACA42DBAA65B736")

    public static final int INVALID_POINTER_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "034E2BCD80D0FE32BEE35A26F527AB82", hash_generated_field = "464488178905DF6887AEEC102D03F9BB")

    public static final int ACTION_MASK             = 0xff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "05E3DA568602DAD9EA3C414607B71E65", hash_generated_field = "B56FBABE5CC8DDE909CEA8CDE98BA93D")

    public static final int ACTION_DOWN             = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "6D72F1F84E251024F9C1BAF7B002F529", hash_generated_field = "E9419BD1576C4C89CB972C93BF43E7C5")

    public static final int ACTION_UP               = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "E0AAA7BED07FEFB1355300A23A152F90", hash_generated_field = "0869EE70BD47CB90D812F686B7F0D216")

    public static final int ACTION_MOVE             = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "C46423CE3E5642BA0CB7AB6CB09262AE", hash_generated_field = "CCD39E7D9940D088C4EBAE690B5B3006")

    public static final int ACTION_CANCEL           = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "5B47F521CF7C2C903B879280CC51E19F", hash_generated_field = "B53AF36739EBD3146722B0AB3CAF54B6")

    public static final int ACTION_OUTSIDE          = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "596B10C23830633246B5FE119303CA31", hash_generated_field = "BE1BA8B002AC6D11B1BA8B25140F3104")

    public static final int ACTION_POINTER_DOWN     = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "1CD52FBA3CE6A637AE86BF305E1727A2", hash_generated_field = "779F82BEF077301CD2887D1C33590F74")

    public static final int ACTION_POINTER_UP       = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "A117FB885030C87F8035EE8197E01274", hash_generated_field = "A31BF98337FB8359E97DA48D76D80977")

    public static final int ACTION_HOVER_MOVE       = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "EDD00CD16649F89FF44DD9C0E161B238", hash_generated_field = "D4C11BB0C70739D756D7BA7A8EBDE32D")

    public static final int ACTION_SCROLL           = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "E6889A317885B7F3FCFCB516DDE1B506", hash_generated_field = "6EED9A028D9812B11E3EC6500A22417D")

    public static final int ACTION_HOVER_ENTER      = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "5A019C5D2F9BBBECE84DA46559873CDE", hash_generated_field = "36537B951CA8A88E1E580F444A68C4EB")

    public static final int ACTION_HOVER_EXIT       = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "F94A33E7C5ACFBEFDFBB09F0FB9B278A", hash_generated_field = "E260033975F8D36BD53DB361D54BA2BF")

    public static final int ACTION_POINTER_INDEX_MASK  = 0xff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "DAB0332B2F0024984DE4DD67C040BC0F", hash_generated_field = "3ED9AD85BB2784B1321927FB5C085339")

    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "9592F84893EF5C92909845A138CAE395", hash_generated_field = "0E6D248BF8E40C6A30CD011E4FE93537")

    @Deprecated
    public static final int ACTION_POINTER_1_DOWN   = ACTION_POINTER_DOWN | 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "7F4BF3EB26FAD7B49445118A59CE6146", hash_generated_field = "2A2F376950DB01CC014C8F15C5D29770")

    @Deprecated
    public static final int ACTION_POINTER_2_DOWN   = ACTION_POINTER_DOWN | 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "AA3C2A077F9DEEFBA6F2542C0560FB1B", hash_generated_field = "9C71C2EB30843366313F3020BE578C26")

    @Deprecated
    public static final int ACTION_POINTER_3_DOWN   = ACTION_POINTER_DOWN | 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "449EA013BBCDA169B9EF1D2297500187", hash_generated_field = "CB217DFD0D7D2A2D8289D57696E595C7")

    @Deprecated
    public static final int ACTION_POINTER_1_UP     = ACTION_POINTER_UP | 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "91D34AE0179B0BC5900FFCB630718519", hash_generated_field = "0531D8E2B94086788DA257D61DD61C0F")

    @Deprecated
    public static final int ACTION_POINTER_2_UP     = ACTION_POINTER_UP | 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "F4E6043EA1CA67A36A2F06C954118606", hash_generated_field = "98C2F8F94E43CA43968FDCDBCC9896C4")

    @Deprecated
    public static final int ACTION_POINTER_3_UP     = ACTION_POINTER_UP | 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "E323657B2EB80B422379A9CEBE0A7866", hash_generated_field = "21CA20F1626331DC2869522A2DE48834")

    @Deprecated
    public static final int ACTION_POINTER_ID_MASK  = 0xff00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "B6823DDE720D0C768C88F68459F98292", hash_generated_field = "674FBE2D655FD483B823B2E251529FF3")

    @Deprecated
    public static final int ACTION_POINTER_ID_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.665 -0400", hash_original_field = "029786C6547ED0693759CAAEFEA9CFC0", hash_generated_field = "D55190196D2C1F6E3FFFC84FA0B9D772")

    public static final int FLAG_WINDOW_IS_OBSCURED = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "550A819DF1874DD6CBEB9E34B7E02CA2", hash_generated_field = "22C757AFB129CA98FC86BD04BEE94F98")

    public static final int FLAG_TAINTED = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "A633F8D6629EE7B06C2FD6D1B0DC9450", hash_generated_field = "E88E0AA9A676F8906011C2C253859C66")

    public static final int EDGE_TOP = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "A822268AD0B774AEEE14EC8CC8D9F93B", hash_generated_field = "7F13D97BAA00BFCDC5B911BB5B6DCDF3")

    public static final int EDGE_BOTTOM = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "8B1FDF0477E0C35DA2FB7C7B8306974A", hash_generated_field = "96B2B8C704DDAD0603C6C6E2FFC340B1")

    public static final int EDGE_LEFT = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "A3A04219B91FA85B01EA955DFFF5FEB5", hash_generated_field = "4B4418A2700C288E6EFE7AF6B858A111")

    public static final int EDGE_RIGHT = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "F43EDDBFB6367074F45ECA2C476C6565", hash_generated_field = "6AC2F269D8C677A5928AAB4766B0AFA4")

    public static final int AXIS_X = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "B104E19452EE81C2A619F4D57E3AEDBE", hash_generated_field = "1F1942945032A87C66ACA5752705A256")

    public static final int AXIS_Y = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "6542F537176A3A95C9638B5D2D6D3282", hash_generated_field = "5CB739150541FFE06EFD5DECAA58BF2C")

    public static final int AXIS_PRESSURE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "271FFE604598307C9BD49A632CD69F2C", hash_generated_field = "F805D88CFB32566B5D69E445454FA20B")

    public static final int AXIS_SIZE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "76C24AF7C4E7B5EF86EC8B7AA695C99B", hash_generated_field = "4422123708A385A40B3A3EAD28C77CA0")

    public static final int AXIS_TOUCH_MAJOR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "FDD97DCBF16D7D35D1DE9CA5AB8B0EE9", hash_generated_field = "9BD07319C2DC512FC7AFF06DB4C457EB")

    public static final int AXIS_TOUCH_MINOR = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "4CECC8FEA7DFD80C61892B5D9499F332", hash_generated_field = "3A23BEE8699344F8699632E58AAE9D00")

    public static final int AXIS_TOOL_MAJOR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "2280E38346B560BA8AFA6F674CCF146D", hash_generated_field = "F26604DCEE776E17C73C06ABB61691F6")

    public static final int AXIS_TOOL_MINOR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "034AF53CD5FD7BC7833BEAD02993E949", hash_generated_field = "2A1393B38A6522964DCE18C89C02987A")

    public static final int AXIS_ORIENTATION = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "6A09A3E15FC599ADAD44D13102C405DD", hash_generated_field = "3653EDC97D1EC153035B8B2CF03F0D9F")

    public static final int AXIS_VSCROLL = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "ADCA61A712EC2EAE4DA4FCDD6574618C", hash_generated_field = "92F839C5EBC2322D5FA86535F6F819CB")

    public static final int AXIS_HSCROLL = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "5952DC7A036BAD5A2FA3BB4702C69033", hash_generated_field = "AF121E953BE1BD481D0CFED4A68E74C0")

    public static final int AXIS_Z = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "102726DF7AC3CD66F5F16B29BE4E0C36", hash_generated_field = "F9C0DE51E0127685ECA28E542A120E88")

    public static final int AXIS_RX = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "225D93A029576C17E912D37880E035F3", hash_generated_field = "0C4C76335C9A3564DACCCDBE8DD301F2")

    public static final int AXIS_RY = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "3622454F61D2BEAFB3A7C20E8B67794C", hash_generated_field = "FE837C29D6032EC2960992B9D8A8B178")

    public static final int AXIS_RZ = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "B89A4C4024CEA0CBEF2F49139937E488", hash_generated_field = "95D53DACF181EE3407879E3C0B3371DA")

    public static final int AXIS_HAT_X = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "F8B0B5501EAF46948DD4D8DFF857FF22", hash_generated_field = "448C69D0D61F2BF459C3AC283A9A3DD2")

    public static final int AXIS_HAT_Y = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "08B1FD10B1CA6EAEC83C43A9C0979C60", hash_generated_field = "4450CC9F108DED3391D6ED8F0D534120")

    public static final int AXIS_LTRIGGER = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "980E2D34290DF1ACCB31AFE81E0A824D", hash_generated_field = "275AE4D63A24B8018CE3E210BAC8D939")

    public static final int AXIS_RTRIGGER = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "267E7C0549F05F5D932F84A17DB329C1", hash_generated_field = "538CDE95EB2664616EE4F8F418B16FCF")

    public static final int AXIS_THROTTLE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "44FEE1E278CC7C2339B1E23FBF344BAE", hash_generated_field = "556882041792FB019CA717764224D5C4")

    public static final int AXIS_RUDDER = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "DA830D9524B06F5E2D1FE72F350FA3B0", hash_generated_field = "D3B7AC7DA5A4B49C56D33CA3953C8391")

    public static final int AXIS_WHEEL = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "D9DD16376FECC1C78B4D3A42DFACDB62", hash_generated_field = "B56F86F8DDA863909AE502D90FA7D4A4")

    public static final int AXIS_GAS = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "3D955FBE6867B617A6459F1390B213ED", hash_generated_field = "7148E428BBB18A5A04C2D90A4D20C2D2")

    public static final int AXIS_BRAKE = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "FB55C8949807223E3375F0A2504F360A", hash_generated_field = "53EBC10458EF090346DB7C3BF7B8B449")

    public static final int AXIS_DISTANCE = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "8382AC5A85A82E20003B1AC360EF6D07", hash_generated_field = "579F39E86B98900179C06E9A07BE7C7B")

    public static final int AXIS_TILT = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "70021A9C7A753DA59C64F0581D83C67B", hash_generated_field = "2C24AD3C3E56DD84D0733A0B91218D75")

    public static final int AXIS_GENERIC_1 = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "DE2D083AFBB03257E89BDA922D0E4CAD", hash_generated_field = "D5EDF8D95D30F8707CB60CE48E5D080D")

    public static final int AXIS_GENERIC_2 = 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "9FEFCC69BCFDFC864584838013FE5B46", hash_generated_field = "0FB2B7871027C51D19E6ADDB6629599D")

    public static final int AXIS_GENERIC_3 = 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "9243522AF86AC2FA928B71B7E668CC47", hash_generated_field = "B3834C6A5E7EAC276B34400E316CC889")

    public static final int AXIS_GENERIC_4 = 35;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "F0A6A5F912965A4325BA778B910D6E59", hash_generated_field = "D771A2C8BF7E6631141C9F156725F986")

    public static final int AXIS_GENERIC_5 = 36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "23CC53509B48EF6225466AC21958D6F4", hash_generated_field = "5ADBF1379367815D17640566262ADBDC")

    public static final int AXIS_GENERIC_6 = 37;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "312922167BECA1728E0C8042C725C6BC", hash_generated_field = "CABE9E3D1339B834B58E2AC551B60D70")

    public static final int AXIS_GENERIC_7 = 38;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "9FCFEF7D88A4651EAE19D026F4636885", hash_generated_field = "783DFA0925833D6927778A6752C33469")

    public static final int AXIS_GENERIC_8 = 39;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "D2142F81309B4EC8E625175D39A4E1F0", hash_generated_field = "844B22BFFE980B1170B8E78B193CD8F8")

    public static final int AXIS_GENERIC_9 = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "7575EC92A58C3C2DC2C8CCC553B15C0D", hash_generated_field = "F52491FA1506F81B61F5BBCAD317F2D4")

    public static final int AXIS_GENERIC_10 = 41;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "89BA0631B47758FC05670AE71E07238B", hash_generated_field = "441A2A8984D04F945C0B9706F4D91238")

    public static final int AXIS_GENERIC_11 = 42;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "898A18C6347222CD54AF74A9ECCCEE58", hash_generated_field = "6EE9D87F1B155C3A9E15C5BFB57DB156")

    public static final int AXIS_GENERIC_12 = 43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.666 -0400", hash_original_field = "B97F163EE5AB936FB897D250305FDD0F", hash_generated_field = "0C980E1F71AC4BD10A6D1136200C35B1")

    public static final int AXIS_GENERIC_13 = 44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "5C89506ADEC1D512A306F0807528A45C", hash_generated_field = "08EDA9B50DF874F18FD4A782BFF79258")

    public static final int AXIS_GENERIC_14 = 45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "7EB5AA2C6AC2C895F916E91C7C27BF6D", hash_generated_field = "9B7002F98DD35624F49E82F9F27BEA43")

    public static final int AXIS_GENERIC_15 = 46;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "42B8B524D844DB897F8E010F49DF34D9", hash_generated_field = "CDB6932C5544664A6FAAE7570CEF1ED8")

    public static final int AXIS_GENERIC_16 = 47;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "530A0FA730B9B28A10F6D39E022E143B", hash_generated_field = "D95AC969582FA3A63A7662A57753465D")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "AA456FB196DE0D5C68D5DA0ABB2B1665", hash_generated_field = "ADA948F0304197BC40CACAE24C6ECB05")

    public static final int BUTTON_PRIMARY = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "9CDE7875F922E491FF1696F779D48BD9", hash_generated_field = "699964DE06376B73FD25E1C2E308AF7B")

    public static final int BUTTON_SECONDARY = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "95C57E1DA2F91AA9F277DFEB59325C0F", hash_generated_field = "0EFC57E0035C368753C281B7448CCAD7")

    public static final int BUTTON_TERTIARY = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "87ED530C352322D1000AED214027E0E0", hash_generated_field = "5A526B3B078557E38DB5D4C91419279E")

    public static final int BUTTON_BACK = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "02CD6CBC72EC09DBD9089D39090DEFFF", hash_generated_field = "4E2DD22E6782E832F99D62265E33DC7B")

    public static final int BUTTON_FORWARD = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "9C9A5C3B4382C6FBD48D16D607582F30", hash_generated_field = "BAA383FC1DC8D8F1DFD855E89C02D485")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "D7697B822D45F5BDF64FF3656AE39897", hash_generated_field = "B997CD436D37980DF5D7404E593DC402")

    public static final int TOOL_TYPE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "DDF16792C91BD89ED3CEB72B2F655A3A", hash_generated_field = "C864443B9D1FDB0CC8BE96AE33701299")

    public static final int TOOL_TYPE_FINGER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "FD13CF4F11329C29AEA3974918542E2A", hash_generated_field = "5BBE29494AB919D60EB460BF7FABACCD")

    public static final int TOOL_TYPE_STYLUS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "EDA620D7300731B22711740B56121B0F", hash_generated_field = "4F5A6CDBC3D361EDE9CAD667AC25320F")

    public static final int TOOL_TYPE_MOUSE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "E8E4790D94F06E7A95BA1EC847CFA0F9", hash_generated_field = "09C1A33B09293914694BF2A3886AC6DB")

    public static final int TOOL_TYPE_ERASER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "E4532CF792A1279111A19DAB2ADAADBA", hash_generated_field = "D272CAAEB0300373C7A6923AD9627B5E")

    private static final SparseArray<String> TOOL_TYPE_SYMBOLIC_NAMES = new SparseArray<String>();
    static {
        SparseArray<String> names = TOOL_TYPE_SYMBOLIC_NAMES;
        names.append(TOOL_TYPE_UNKNOWN, "TOOL_TYPE_UNKNOWN");
        names.append(TOOL_TYPE_FINGER, "TOOL_TYPE_FINGER");
        names.append(TOOL_TYPE_STYLUS, "TOOL_TYPE_STYLUS");
        names.append(TOOL_TYPE_MOUSE, "TOOL_TYPE_MOUSE");
        names.append(TOOL_TYPE_ERASER, "TOOL_TYPE_ERASER");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "9319C0C1DC56FFF2B6175EA6D9D0FA3B", hash_generated_field = "B0BEAD643F65C07DAE0B28D2861E52D4")

    private static final int HISTORY_CURRENT = -0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "4E0EEF34DE1E78AC4C7D48E7B28D3753", hash_generated_field = "632CD138CDBCADE9A63F9B23105E1648")

    private static final int MAX_RECYCLED = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "79F53341661E7BAB58D441DAC7E61782", hash_generated_field = "4D2E3DEDF37103D77BF3BB46692742C8")

    private static final Object gRecyclerLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "62CB28CE8AC6DBF69FB484B561C6DE93", hash_generated_field = "695DE00CD65E15FE07938D99F2CA2696")

    private static int gRecyclerUsed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "7BA7389C24C0F124608D5C2226AD35F9", hash_generated_field = "E9FD3DB4A4C51C360253148C4F1C8508")

    private static MotionEvent gRecyclerTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "7CC0A11C5494EABD208B60B4042F676B", hash_generated_field = "ACFC36EAB247226A536D30FD1648AAC7")

    private static final Object gSharedTempLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "7ACA3B441BEC8C942E34BE426D1BD777", hash_generated_field = "1C70655B0F01405596723D256AD5AE2B")

    private static PointerCoords[] gSharedTempPointerCoords;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "909596135E37414184F98BA28ABF7B47", hash_generated_field = "7767E5DED892F800315C4BF8ECA945E5")

    private static PointerProperties[] gSharedTempPointerProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "7D5CE052D163BC3BEA8C336A1127A9FA", hash_generated_field = "A9BB8E94115BE6A30724987AE7313B53")

    private static int[] gSharedTempPointerIndexMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.667 -0400", hash_original_field = "92338855F3FDCA2FD9317526465F4D98", hash_generated_field = "C140DAE13300F0DB81E6D0FF25B21CC4")

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

