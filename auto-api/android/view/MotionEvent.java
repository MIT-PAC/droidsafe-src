package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseArray;

public final class MotionEvent extends InputEvent implements Parcelable {
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
    @Deprecated
    public static final int ACTION_POINTER_1_DOWN   = ACTION_POINTER_DOWN | 0x0000;
    @Deprecated
    public static final int ACTION_POINTER_2_DOWN   = ACTION_POINTER_DOWN | 0x0100;
    @Deprecated
    public static final int ACTION_POINTER_3_DOWN   = ACTION_POINTER_DOWN | 0x0200;
    @Deprecated
    public static final int ACTION_POINTER_1_UP     = ACTION_POINTER_UP | 0x0000;
    @Deprecated
    public static final int ACTION_POINTER_2_UP     = ACTION_POINTER_UP | 0x0100;
    @Deprecated
    public static final int ACTION_POINTER_3_UP     = ACTION_POINTER_UP | 0x0200;
    @Deprecated
    public static final int ACTION_POINTER_ID_MASK  = 0xff00;
    @Deprecated
    public static final int ACTION_POINTER_ID_SHIFT = 8;
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
    private static final int HISTORY_CURRENT = -0x80000000;
    private static final int MAX_RECYCLED = 10;
    private static final Object gRecyclerLock = new Object();
    private static int gRecyclerUsed;
    private static MotionEvent gRecyclerTop;
    private static final Object gSharedTempLock = new Object();
    private static PointerCoords[] gSharedTempPointerCoords;
    private static PointerProperties[] gSharedTempPointerProperties;
    private static int[] gSharedTempPointerIndexMap;
    private int mNativePtr;
    private MotionEvent mNext;
    private RuntimeException mRecycledLocation;
    private boolean mRecycled;
    public static final Parcelable.Creator<MotionEvent> CREATOR = new Parcelable.Creator<MotionEvent>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.462 -0400", hash_original_method = "E988C06BFCE97E62AC2813BD29B32BEE", hash_generated_method = "E8C43A1B94E86DA9156357D5B24D64FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MotionEvent createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            in.readInt();
            MotionEvent varDBE57DA48AA46F9897DCADB263EB85B9_941366718 = (MotionEvent.createFromParcelBody(in));
            return (MotionEvent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //in.readInt();
            //return MotionEvent.createFromParcelBody(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "5EBE0D6E50651488F7881A7509B9CA02", hash_generated_method = "EAEF18D774FEE68FA1976CD56B0EA564")
        @DSModeled(DSC.SAFE)
        public MotionEvent[] newArray(int size) {
            dsTaint.addTaint(size);
            return (MotionEvent[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new MotionEvent[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "B1B69F583261D8BEEC921FF43580AA66", hash_generated_method = "902E7BA04B062B00AEF8D59D8D160930")
    @DSModeled(DSC.SAFE)
    private MotionEvent() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "A44B14BB1BCBE206EC593BA2C9AFA143", hash_generated_method = "3A835C7ECC1FDB91788D3E3E10F93466")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "176BBFD665D14549DC6FF833F240560F", hash_generated_method = "66530336D36B95EC2ACA0D8EBB6FD38A")
    private static int nativeInitialize(int nativePtr,
            int deviceId, int source, int action, int flags, int edgeFlags,
            int metaState, int buttonState,
            float xOffset, float yOffset, float xPrecision, float yPrecision,
            long downTimeNanos, long eventTimeNanos,
            int pointerCount, PointerProperties[] pointerIds, PointerCoords[] pointerCoords) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "3931BEFA904A71840BACD682D3930219", hash_generated_method = "CF390FB622C011BADDD126FD696C6EF4")
    private static int nativeCopy(int destNativePtr, int sourceNativePtr,
            boolean keepHistory) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "85F2811547B6E62289C539C01CF4553F", hash_generated_method = "EF4690D6756F52F8780A0772799A17DF")
    private static void nativeDispose(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "8F9DDB8066AB14A845BBD1FC61490D9A", hash_generated_method = "D8AF38222FACAC26808BC86879284340")
    private static void nativeAddBatch(int nativePtr, long eventTimeNanos,
            PointerCoords[] pointerCoords, int metaState) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "8F457399C3B86508DC88F208AD81F3D6", hash_generated_method = "3F112E1E5DD9D12202F94337B5FACB2D")
    private static int nativeGetDeviceId(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "E35EA4C5AAA13D7EC6B4D3C67D34D6C2", hash_generated_method = "60EE2E4CE512391F44EE2B1468645BF7")
    private static int nativeGetSource(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "881BA3DC05D7FAB1E14969BB7554D837", hash_generated_method = "2CBABCD3BF8CA23E31A80460D6C9C5C6")
    private static int nativeSetSource(int nativePtr, int source) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "E63E0010FA4D2BCBC3170DB4FACD7D07", hash_generated_method = "415EE074866E03655E2E9D23BB7CD9A2")
    private static int nativeGetAction(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "1BF36452E0AD4A42AEE03E3135306570", hash_generated_method = "6730D7D9328C0C489AF864BCA35FDEFE")
    private static void nativeSetAction(int nativePtr, int action) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "418A9A800CC76120E2E4B3CBFA6DA998", hash_generated_method = "500C4C2DA84434227EA66F7E6BFB9BEE")
    private static boolean nativeIsTouchEvent(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "0107E7A144D7BE9A100FCC646E0E2BD5", hash_generated_method = "DB5F4962BC2A41807572887A5FE7532C")
    private static int nativeGetFlags(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "AF56E7AD033D43AF8CF426AE9823F3D7", hash_generated_method = "9CAD983B6485B0C42BF02CB5B2F5C90F")
    private static void nativeSetFlags(int nativePtr, int flags) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "969618AE9ACE30C02D65862F540C0B92", hash_generated_method = "11A720E4FC337B15465DEAB7804C4A8C")
    private static int nativeGetEdgeFlags(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.463 -0400", hash_original_method = "7E104FF3878D53FB9E999E4A646374F3", hash_generated_method = "17DFA97350A9AC3770A5B7AB601CDB8E")
    private static void nativeSetEdgeFlags(int nativePtr, int action) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "6AA8D6AAA4782793EC835E26737CAE3D", hash_generated_method = "E70264A1A7D33D79871C06A083330BBD")
    private static int nativeGetMetaState(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "893FA11E803051C59517A2E01EBCB730", hash_generated_method = "54E5A4FA8A32E6F3A2D1FF2771944989")
    private static int nativeGetButtonState(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "A662CEBF5C6628DBF3B96F0FFB7703BC", hash_generated_method = "E379B6ECAEED44021F7AF2DDF9F5E3B0")
    private static void nativeOffsetLocation(int nativePtr, float deltaX, float deltaY) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "8B899AD2A2D04DB635FC889CC88468E3", hash_generated_method = "DB3E0C97B059BA2BC8CD5CF8DBA6F5C7")
    private static float nativeGetXOffset(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "42A28853B7877222116C0D28692BD512", hash_generated_method = "FCCA8291A918C8C878C2CD17FAF47CDF")
    private static float nativeGetYOffset(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "DBB417121CF85464641171A39A7AED5F", hash_generated_method = "E73E230417EBF2B9A3057AC1D640C905")
    private static float nativeGetXPrecision(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "CA15B209D783BB9700FE164831D6A9A6", hash_generated_method = "BFEE415ECBD762FE571F3E99A24A74AD")
    private static float nativeGetYPrecision(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "F4BC785B707CE30720404C383AF91944", hash_generated_method = "084DF80F377F2961889998B49CF42803")
    private static long nativeGetDownTimeNanos(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "AD87358BEE532C3C52727262DF9FD62A", hash_generated_method = "D02B1BE04198C4FDBF855B9514849E1E")
    private static void nativeSetDownTimeNanos(int nativePtr, long downTime) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "E62BAA3CF98967AC72C66426518472B7", hash_generated_method = "9D7B44C90FE007D72DC6544BFB167018")
    private static int nativeGetPointerCount(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "1B118AB6BCC4888802F81272B0E9A148", hash_generated_method = "C3B14E510DCEC38DC2CB13885A7283FD")
    private static int nativeGetPointerId(int nativePtr, int pointerIndex) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "1622303212AF711BA017234FDA34F89F", hash_generated_method = "ADBE30ADD5F678E8B672696337DF5D97")
    private static int nativeGetToolType(int nativePtr, int pointerIndex) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "5F4CFDF74C81091A23750DC0B89D1453", hash_generated_method = "54DFBBF9C12054DD239154D4498AF5BE")
    private static int nativeFindPointerIndex(int nativePtr, int pointerId) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "F0BEFEBAD9FE9F4AB2B06BFC0104F7D0", hash_generated_method = "651930D8F4D705998C7A9A31CF83124F")
    private static int nativeGetHistorySize(int nativePtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "D2C3F6B91C08359472E8D9F95590CC00", hash_generated_method = "F033520B7C1AD25073D76EC73D0AF5C2")
    private static long nativeGetEventTimeNanos(int nativePtr, int historyPos) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "C7469FAD3FB9BAB63476FB9F7E5D7E26", hash_generated_method = "64FD7881D0D40E4451447217F8B7B28B")
    private static float nativeGetRawAxisValue(int nativePtr,
            int axis, int pointerIndex, int historyPos) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "382C0D41BF3E13609D7C4EAD7202E6FF", hash_generated_method = "F303360ED87A391058197904BFB2F4CF")
    private static float nativeGetAxisValue(int nativePtr,
            int axis, int pointerIndex, int historyPos) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "D5BDE08682075FA59904F8058738B435", hash_generated_method = "54902C86078F319D6AC5859E86AB4111")
    private static void nativeGetPointerCoords(int nativePtr,
            int pointerIndex, int historyPos, PointerCoords outPointerCoords) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "6C14B1FEE1AA0DCD5106E28A032E4356", hash_generated_method = "DB71C26289441EF87901E0FDA52F2706")
    private static void nativeGetPointerProperties(int nativePtr,
            int pointerIndex, PointerProperties outPointerProperties) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.464 -0400", hash_original_method = "8210E248772B53A21F7A63B37C0A027B", hash_generated_method = "4ED7432E18556B715D49B31C90A7835E")
    private static void nativeScale(int nativePtr, float scale) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.465 -0400", hash_original_method = "2995F046A6F912F85BE431AAEA227191", hash_generated_method = "F8F983D6161CE2F3BC63D74915E4A479")
    private static void nativeTransform(int nativePtr, Matrix matrix) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.465 -0400", hash_original_method = "A5FB8C7E53EBA09BEB1DDD3F0F8E158A", hash_generated_method = "DFF5429FF814385079A74F6259DB9563")
    private static int nativeReadFromParcel(int nativePtr, Parcel parcel) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.465 -0400", hash_original_method = "A902914546327DD6D575B1B8BF8F94C6", hash_generated_method = "1C9924477137D96453344781D95E5241")
    private static void nativeWriteToParcel(int nativePtr, Parcel parcel) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.465 -0400", hash_original_method = "3F0B5C050D986DD9F1F0F2A742C616C8", hash_generated_method = "58CFCC0CF6E09BBC8E8FDE4346127245")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.465 -0400", hash_original_method = "2A0D7EAD7D2D4BD57D90237963E14123", hash_generated_method = "764E77A2466C2EEB909234927FC9E4A0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.465 -0400", hash_original_method = "A204D392D258EF41A56793600F1CE50A", hash_generated_method = "6879D47F66BD84CD6DB9E290DBCB8772")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.465 -0400", hash_original_method = "29303BD9CA676DA8DA0C6D61C95B80AD", hash_generated_method = "4FEA28EE77F11A453C77B10F7808B967")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.465 -0400", hash_original_method = "1E17DF4D2E642F9316AB5D83170D1374", hash_generated_method = "781E6B54E01322E06173924A59BC3BEB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.465 -0400", hash_original_method = "5621B9ADE3B8EF50DDDF7D0ECB510E6B", hash_generated_method = "A59CF82C458A58C478465FFC39AB754F")
    @Deprecated
    static public MotionEvent obtain(long downTime, long eventTime, int action,
            int pointerCount, float x, float y, float pressure, float size, int metaState,
            float xPrecision, float yPrecision, int deviceId, int edgeFlags) {
        return obtain(downTime, eventTime, action, x, y, pressure, size,
                metaState, xPrecision, yPrecision, deviceId, edgeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.465 -0400", hash_original_method = "C4E1548FEFF7CE0FD853413E91CFBE59", hash_generated_method = "BB84597C158113D132EC190F62F58E4F")
    static public MotionEvent obtain(long downTime, long eventTime, int action,
            float x, float y, int metaState) {
        return obtain(downTime, eventTime, action, x, y, 1.0f, 1.0f,
                metaState, 1.0f, 1.0f, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.465 -0400", hash_original_method = "A056A38EFEDA7A73CC0FCCF73A42E3E9", hash_generated_method = "67BDA9EFDB28A1E46B512170077D337E")
    static public MotionEvent obtain(MotionEvent other) {
        if (other == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        }
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeCopy(ev.mNativePtr, other.mNativePtr, true );
        return ev;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "EF06BFAED4C963D2A51D5D03CF5F89C2", hash_generated_method = "A8EAB45A99A963709AFA787A3BF96157")
    static public MotionEvent obtainNoHistory(MotionEvent other) {
        if (other == null) {
            throw new IllegalArgumentException("other motion event must not be null");
        }
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeCopy(ev.mNativePtr, other.mNativePtr, false );
        return ev;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "78DE11FBBF58608981D1F74EEB443B54", hash_generated_method = "F631AB9AED3969B45C309D0CF8E1311F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public MotionEvent copy() {
        MotionEvent var3FF1A9B3CCF4C4B5A71D5E31BC77BEB8_692295551 = (obtain(this));
        return (MotionEvent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return obtain(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "187F7D3A42078A42C8212C3EFE0E8B16", hash_generated_method = "CD38BB6732904157557131C2842546E0")
    @DSModeled(DSC.SAFE)
    public final void recycle() {
        {
            {
                throw new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
            } //End block
            mRecycledLocation = new RuntimeException("Last recycled here");
        } //End block
        {
            {
                throw new RuntimeException(toString() + " recycled twice!");
            } //End block
            mRecycled = true;
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "A082C8E505553F853E56AAFC11CF0CDA", hash_generated_method = "E5AE41D6106C46DC147832D274CB7A2B")
    @DSModeled(DSC.SAFE)
    public final void scale(float scale) {
        dsTaint.addTaint(scale);
        nativeScale(mNativePtr, scale);
        // ---------- Original Method ----------
        //nativeScale(mNativePtr, scale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "E51EA2AB032E4C79CC226174E2601818", hash_generated_method = "332AF00DC1DF8CA96910BFF46E9F1626")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int getDeviceId() {
        int varF3B3D3917F994FE161C0ABB4D3E565B5_138271076 = (nativeGetDeviceId(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetDeviceId(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "44501F684180CAB98F3511C2614C7994", hash_generated_method = "16466CA17542E8AA098E236F58E6D320")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int getSource() {
        int var626B65A92B0E4AF71704C1098173596F_976462820 = (nativeGetSource(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetSource(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "1502AF3F26B6DD95879512031D9FB73E", hash_generated_method = "5A41B62381EFFA3F59B2295BD67055A8")
    @DSModeled(DSC.SAFE)
    @Override
    public final void setSource(int source) {
        dsTaint.addTaint(source);
        nativeSetSource(mNativePtr, source);
        // ---------- Original Method ----------
        //nativeSetSource(mNativePtr, source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "FA5880EB8F61D955AC5922ACE620FCE2", hash_generated_method = "C07B48A2C9C3881DDD422085D62B9BB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getAction() {
        int var74B8A914B86C4917D117B6A52D32C79D_1626511930 = (nativeGetAction(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetAction(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "268411790684740D49A019DF59E1FFBB", hash_generated_method = "D4A4CE73BAAC8C295C71913D088520E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getActionMasked() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int var119771AD723EE5854F55019431496A74_2063492499 = (nativeGetAction(mNativePtr) & ACTION_MASK);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetAction(mNativePtr) & ACTION_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "464EE1689B645958C6F5E17990D5ECA4", hash_generated_method = "B764C555D3A44737DEB0526C9896C508")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getActionIndex() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int var853FB894ACCBEFFE5F8E24DD3377AFAF_1285366496 = ((nativeGetAction(mNativePtr) & ACTION_POINTER_INDEX_MASK)
                >> ACTION_POINTER_INDEX_SHIFT);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (nativeGetAction(mNativePtr) & ACTION_POINTER_INDEX_MASK)
                //>> ACTION_POINTER_INDEX_SHIFT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "3A9CDEA51D903248E7ACBBA8C3F57155", hash_generated_method = "F53F5DA167F3721438366068304B8DEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isTouchEvent() {
        boolean var12F7F7B53A02590E12DD99382B4D1A89_147224410 = (nativeIsTouchEvent(mNativePtr));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeIsTouchEvent(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.466 -0400", hash_original_method = "A25E485C356A262F519C0A5841CFA47B", hash_generated_method = "C34FE0717413C656624806792A5B0173")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getFlags() {
        int var31A262589A0563B992AF6C13BB445DA6_1264628624 = (nativeGetFlags(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetFlags(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "24A8A0C0077001C335E0B5C917301FE4", hash_generated_method = "6046E8AF46BF1B52215F4BED1EB82D85")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isTainted() {
        final int flags;
        flags = getFlags();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int flags = getFlags();
        //return (flags & FLAG_TAINTED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "96C1138F844BE852B50B0529E539E061", hash_generated_method = "319B306168852B5DC4BD40D12ADE79DB")
    @DSModeled(DSC.SAFE)
    @Override
    public final void setTainted(boolean tainted) {
        dsTaint.addTaint(tainted);
        final int flags;
        flags = getFlags();
        nativeSetFlags(mNativePtr, tainted ? flags | FLAG_TAINTED : flags & ~FLAG_TAINTED);
        // ---------- Original Method ----------
        //final int flags = getFlags();
        //nativeSetFlags(mNativePtr, tainted ? flags | FLAG_TAINTED : flags & ~FLAG_TAINTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "5F4C05CD4E223E38846D15A6EA0DF305", hash_generated_method = "D70EC9AFC551328498D5D49241813E0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getDownTime() {
        long varA7AEBDC62AD9E48221ED001FAEE4896D_283089190 = (nativeGetDownTimeNanos(mNativePtr) / NS_PER_MS);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return nativeGetDownTimeNanos(mNativePtr) / NS_PER_MS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "97B3432DE604A4A8C3339017F5056697", hash_generated_method = "46970573CE007AFAB58AA23ED5E88B86")
    @DSModeled(DSC.SAFE)
    public final void setDownTime(long downTime) {
        dsTaint.addTaint(downTime);
        nativeSetDownTimeNanos(mNativePtr, downTime * NS_PER_MS);
        // ---------- Original Method ----------
        //nativeSetDownTimeNanos(mNativePtr, downTime * NS_PER_MS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "CCF6A1C7FFBA398090457272FB07E7C9", hash_generated_method = "B17EF7DF1E4A24BAC69826BE8B03B9F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getEventTime() {
        long varABD7EED75F03AC822986337AA0AEBA8E_769939818 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT) / NS_PER_MS);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT) / NS_PER_MS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "9EB1FC24DA069289850F91A3F8734D9A", hash_generated_method = "086A64879F9974E81806976935F003A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getEventTimeNano() {
        long var9177F0DF4886BA63EBD71602211F864C_1162485415 = (nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "4BF6642E766343B332FD98949BC6C582", hash_generated_method = "D0C99256AAB7D6475F1A0035A50DCF89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getX() {
        float var66044244940F058BEDF52F995ECDF659_37813940 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "91A63DEAB3A8AC7438EA04466792BD82", hash_generated_method = "299D5FDDDD046C54228A7C4619BA9547")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getY() {
        float varC75AFE4F07E18DED73B6E9A135DBAA24_1796179246 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "6675B94FFDE5461AE8829AF0934758CB", hash_generated_method = "DB5EDF26CF05DC964DA6A10403B7B065")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getPressure() {
        float varEF9A2F87450786CEB865F6DB8CC3ECFD_358613681 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "04BA234B263118C319F9FB3039E4C966", hash_generated_method = "BD12144819958B64843E2F213804390A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getSize() {
        float varDFF5D0290CDD1A07C8B97F2F6E962921_495059519 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "7EDCA08C9EC8F904EE9855CC249509CB", hash_generated_method = "887D2EBD9CA5EB907E78CEC95D94029B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getTouchMajor() {
        float var2C0DAF19E2431B7454CC6F77C73821E0_771585223 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "0D1B5526DE02F52B1563B7D7F6F58090", hash_generated_method = "669645F9228B917088AA73F07DAEB7FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getTouchMinor() {
        float var4508F4DDA7AD6F23C2A12D53FC2B6353_1662880813 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.467 -0400", hash_original_method = "88DA06A5CC2E8F8456F3789E8A68ED44", hash_generated_method = "86508DC24DE9B27FD41A49443535F6F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getToolMajor() {
        float varC9DDB5D5521C8A6BB646AB1BF9C7D9E2_331474788 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "68541C2106990EEA679DCE03A62D7FCC", hash_generated_method = "F35A0E56CC1CAC0E2ECBB72DCBF75940")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getToolMinor() {
        float var695C0E240E818E6BDB2EBB725DE208C8_1988395379 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "6DB87F8256212E2B4D49883D1C47D372", hash_generated_method = "E54A67875F3EDE757A423E813623DC2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getOrientation() {
        float var75B1DB96187E89974E64BC0FB38B1FEF_1095148901 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "630AA047225B25427528E4D32F567B17", hash_generated_method = "4FF1EDF08320DF751849A8A3B9A7447B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getAxisValue(int axis) {
        dsTaint.addTaint(axis);
        float var4FF16B9B17710DEACD9EEA98B643B740_743275898 = (nativeGetAxisValue(mNativePtr, axis, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "2050CCC0293D52B162C880AD9BC3C6F6", hash_generated_method = "23BA2374E957AF813F0223AABE6BF788")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getPointerCount() {
        int var5ACA797B73271718F08C07B0FD1465C3_1738227998 = (nativeGetPointerCount(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetPointerCount(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "43D465AFB7AC0153BC6ACD556C5FF613", hash_generated_method = "DF1906EE0C48837FCA453CBDA6F3B499")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getPointerId(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        int var17A8C53C4A6DAF94DA4FE0E64E276DEB_1904343743 = (nativeGetPointerId(mNativePtr, pointerIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetPointerId(mNativePtr, pointerIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "4F4E823E6A973C2A4D85C86C0A6A2D9D", hash_generated_method = "A575E19F58D52E1D4C8E67A6A4F77731")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getToolType(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        int var705074F16347B844E833B41BDB330DC5_443153741 = (nativeGetToolType(mNativePtr, pointerIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetToolType(mNativePtr, pointerIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "396B4C03ADE41E49E928286EB7438AA9", hash_generated_method = "589D63C8ECF7A637E856096C38081126")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int findPointerIndex(int pointerId) {
        dsTaint.addTaint(pointerId);
        int varCF3227509A91EFEBFB983EC37BCBBB09_1305949257 = (nativeFindPointerIndex(mNativePtr, pointerId));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeFindPointerIndex(mNativePtr, pointerId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "13E56CEAC1D2714A9A1790EF5117F935", hash_generated_method = "197C60C8E17D1647230AA4F2C8FCE0AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getX(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float var22607ACD4999ED3178C2C16BA32F39FA_1639088007 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "9A0C47F653E064961B232F3274CD29C9", hash_generated_method = "CA2EA152C3526DFC6E92EF66F58B0DB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getY(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varEC964DA0D0FCB932F45F9605581B800C_2075181069 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "36E2BAC74F4F826870F428D93CA1D371", hash_generated_method = "98E993C3B0D62E2B3F66A9BA27B6AD1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getPressure(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varDB60B99C5EF7895E6B92B91772C5962E_327975946 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "50DE00A69645B3335E8383A50AB1EB05", hash_generated_method = "9C75401223B376294093B7CBF2332DBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getSize(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varB4E63BA449D57F4253A0AB8919D42D10_1189148399 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "28BED69B39230D6E2E593658DA262948", hash_generated_method = "3A0EB24CA6E706F3176E0844F55248BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getTouchMajor(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varA24CED3D0F358E3C65B964973B4F5F83_1330471154 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.468 -0400", hash_original_method = "2C1FBE2BFEFC6BD6A6EFC25F55DD94B0", hash_generated_method = "48F64F55ABDE4F808FDBC4DB902A6D60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getTouchMinor(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float var120D3EDA1AEC95857772396D3ADDF431_1945342792 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "66B849A9DC257EF38185AFB935434C46", hash_generated_method = "57AE15A8F6178161354CEC27DA47C39F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getToolMajor(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varE1A0953AB1720A635D0A001029F15F98_1612322673 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "F39564D767A71A1EAACBC920B100E436", hash_generated_method = "451D9AC00773A1C9D2B5848EF8147DBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getToolMinor(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float varC32F5653C2BD206ECB16EB3579C5B644_1888729241 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "A9038F286A5A1470BB26B4145360A2CC", hash_generated_method = "5100BFC0ED5F9ADC78C0F78C04D98084")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getOrientation(int pointerIndex) {
        dsTaint.addTaint(pointerIndex);
        float var865B68C13F122391AB0E054D3314ED41_335683619 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "3434CDF166CDB98F83BC4BA0F4722E7E", hash_generated_method = "3B39B19036EA9C4AF563B8DFE85EA9D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getAxisValue(int axis, int pointerIndex) {
        dsTaint.addTaint(axis);
        dsTaint.addTaint(pointerIndex);
        float varDC8E493A6FB2EE0C0CB23BC5DBBC02F1_1568175215 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, pointerIndex, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "33DE471947CC053A5003BB5AAC41F910", hash_generated_method = "F5D1EC2BAE485D3C91CACCA6A4C9EFC6")
    @DSModeled(DSC.SAFE)
    public final void getPointerCoords(int pointerIndex, PointerCoords outPointerCoords) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(outPointerCoords.dsTaint);
        nativeGetPointerCoords(mNativePtr, pointerIndex, HISTORY_CURRENT, outPointerCoords);
        // ---------- Original Method ----------
        //nativeGetPointerCoords(mNativePtr, pointerIndex, HISTORY_CURRENT, outPointerCoords);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "FC8907B12AF62543F5FA0564EA522E62", hash_generated_method = "45D1278686775F99128010143C6109A2")
    @DSModeled(DSC.SAFE)
    public final void getPointerProperties(int pointerIndex,
            PointerProperties outPointerProperties) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(outPointerProperties.dsTaint);
        nativeGetPointerProperties(mNativePtr, pointerIndex, outPointerProperties);
        // ---------- Original Method ----------
        //nativeGetPointerProperties(mNativePtr, pointerIndex, outPointerProperties);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "38A68962B5CFD92D43EE16A436EABCF2", hash_generated_method = "A93DDC4DD01B3BCBF3C4B33DD3005408")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getMetaState() {
        int var2EB518F4D6071C6F350D1D5C097F88FF_994728068 = (nativeGetMetaState(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetMetaState(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "C8458CE15D5B2817F47A4FD377CE1968", hash_generated_method = "DD4BFEA338EEF173D2CA768AFCB431E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getButtonState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int var6E0173150D4C4630052CCF82C8F7DC9F_1917890872 = (nativeGetButtonState(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetButtonState(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "6E457CC599C66DF6B9AC57A3DF3B8E7E", hash_generated_method = "5A9AF1D4F90D1E45BB6D49079EE82D3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getRawX() {
        float var78851251BB2BADD4A73F875B41E82C95_975334394 = (nativeGetRawAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetRawAxisValue(mNativePtr, AXIS_X, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "C18C1837908CE668DE325D32328DA600", hash_generated_method = "213816F815E1C1CC7BD4A610D49AE2FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getRawY() {
        float varB2F71D566D9DFEDA8765CB859668364C_491588550 = (nativeGetRawAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetRawAxisValue(mNativePtr, AXIS_Y, 0, HISTORY_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "32503B0D7203271814D12FFB8906664F", hash_generated_method = "BCA3865FEF1B586B1262A790375E5D52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getXPrecision() {
        float var8C63D112819BF4307BFC05C55813CC7C_1248711071 = (nativeGetXPrecision(mNativePtr));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetXPrecision(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "77B44C5CFF493101D20AF55AA249AFB4", hash_generated_method = "AA8F2C82CCBA9243B8DFCE11B2246C2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getYPrecision() {
        float var2DA4AA757DDFF641DBCEE9F2CC39A8B1_1714996256 = (nativeGetYPrecision(mNativePtr));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetYPrecision(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "B4D273F4D2084C890DE19B631E3ED869", hash_generated_method = "55745841E2632E3B53A949C547D7B9D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getHistorySize() {
        int var42FF49C139613133CE8AAF262A0781C4_957203232 = (nativeGetHistorySize(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetHistorySize(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.469 -0400", hash_original_method = "4F37DFE9294EB232F86D1F83C2ADDC74", hash_generated_method = "CA4165ECA44ECDF76ADBB052A90B3EDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long getHistoricalEventTime(int pos) {
        dsTaint.addTaint(pos);
        long var86B3FEF5B6798FC4F49A53A44960DD31_362684035 = (nativeGetEventTimeNanos(mNativePtr, pos) / NS_PER_MS);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return nativeGetEventTimeNanos(mNativePtr, pos) / NS_PER_MS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "52641DCD8C1505610834B8CDD1492B06", hash_generated_method = "5A6692D058ECD3C97B586F6D64B8BCED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalX(int pos) {
        dsTaint.addTaint(pos);
        float varD6254ED09F523E7C1E53ADA626DF0C10_1524971196 = (nativeGetAxisValue(mNativePtr, AXIS_X, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "456D8725235AB4DBC45E47B4ADD23013", hash_generated_method = "2AC5226939C5C89885C9C600CE41BCB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalY(int pos) {
        dsTaint.addTaint(pos);
        float varF753E500532420F185A79C4FC58F3F0B_695705340 = (nativeGetAxisValue(mNativePtr, AXIS_Y, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "E822398D8AD69E2A637D6F0BC07F61D8", hash_generated_method = "6881395537EF874DED4BD4586F9B3592")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalPressure(int pos) {
        dsTaint.addTaint(pos);
        float var8CCA0683C3AD89698B4BB2DCB56AF6E0_1280149595 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "A43A8374A73078EDB84358D609B2C354", hash_generated_method = "F52C7F0C798ECA635D6B7B94F30433AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalSize(int pos) {
        dsTaint.addTaint(pos);
        float varA2CCAFC013471427EED1D8795B79DF34_1471683617 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "192AC6C55C0D7020BB0EA3AE5DE4FD65", hash_generated_method = "FFDD78203A6BF47AFC3A9BF9AD633F65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalTouchMajor(int pos) {
        dsTaint.addTaint(pos);
        float var8E7AD2DB9688820EB8F0B7CB347E27F7_372963472 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "122C0ECAA119AC26B3F087E871FFA312", hash_generated_method = "0347AC725F06CDBA15B31808C26F2FAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalTouchMinor(int pos) {
        dsTaint.addTaint(pos);
        float var47136F660FFE6DBB3965B94BCAC103FF_116398409 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "8097CEA35B3273816C6109CC76A9BC74", hash_generated_method = "550DEB8B401AECB0CDDA2E17B7C72B87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalToolMajor(int pos) {
        dsTaint.addTaint(pos);
        float varACE33102325AC5113F663D281165CB12_1233515162 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "E0365AAE3D6BF704A796F5D4E7964FB9", hash_generated_method = "7F9D7E2A23FBB421CDC3FDAB73833CDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalToolMinor(int pos) {
        dsTaint.addTaint(pos);
        float varBDFEBFC87FD2C86C951881656D01FBFE_272762466 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "DC8FCE9CD404D08D0BFF0CC77CEE87C1", hash_generated_method = "902F423AC062AB67C8E47F84940EFEFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalOrientation(int pos) {
        dsTaint.addTaint(pos);
        float var9ABC98E782A3870F9AA5DFC3F27D891C_171035155 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "697532A0192D8868F2E3AE618301BF20", hash_generated_method = "6A3BA2DCA8DBA1063BE1EA533D6578F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalAxisValue(int axis, int pos) {
        dsTaint.addTaint(axis);
        dsTaint.addTaint(pos);
        float varE580B6B92EAD96F426B34B55A944EC3F_260461949 = (nativeGetAxisValue(mNativePtr, axis, 0, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, 0, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "8BFA09569623FF1F941D2134C3D47F02", hash_generated_method = "89599A52505C54F86629938DDA7919A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalX(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var70F4D2CDA260BE637BE2F366621D1047_1966032956 = (nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_X, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "9787FE8A43AC5153EC8D7EC463FC985B", hash_generated_method = "D8D66364F8D8C8C58C3239BDA4C4D58D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalY(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var4338B7951F95F5B1B66FDB2F4DC27413_784008045 = (nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_Y, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.470 -0400", hash_original_method = "A8F703E0BCBA29F53C62C25AACD436ED", hash_generated_method = "30FD34EB9869BBFC7E0D9B41255F0401")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalPressure(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var599EE82AA7EED666174FF6603E5D9EDB_2003394302 = (nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_PRESSURE, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "66A9DA10859CF6933D658F61BE53F70F", hash_generated_method = "61C8FA8252AC67A21A907EBA1139C04D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalSize(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var6ADB36223580AAF1DF6650FEF9BEFE5F_877924808 = (nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_SIZE, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "38D72D2E0F00AE5C39667CDDD41B271D", hash_generated_method = "636DED21A7971AA00EEB67F52A9442BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalTouchMajor(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var04576CC24CDC939EA1B84F18BA4AA27C_1758075808 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MAJOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "F3D94A1F01A3ECEF6DEDEA9361640BF9", hash_generated_method = "FA40FACABFAB5B3DA408E4231184DF33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalTouchMinor(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float varE0E8C51F7817613AD2DBA52263E38B64_1854299260 = (nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOUCH_MINOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "78FB77773CB43A5420D0F24849B540AD", hash_generated_method = "86CEF648FE03463BFE02B7320585E02B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalToolMajor(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var40EEA85674FBE73ABF2A2BD2F2E74CD6_1052717172 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MAJOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "4AB7745853006A3796DAD0E637CCA598", hash_generated_method = "626C732A902C3CEC0CD262621A2F5DE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalToolMinor(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var784F21A01E3CEC7D68998B91D48C129C_312076320 = (nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_TOOL_MINOR, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "160C0106DB8A4C6FBAA9569ABA0D68E8", hash_generated_method = "74DEAA6EE39F4D730270E6F7CC51FB7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalOrientation(int pointerIndex, int pos) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var02FA0A42AAD0F907D9EB0C172EDB6AB4_2032572315 = (nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, AXIS_ORIENTATION, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "F645AABE3B2CF14D2790BA051F9F3FF1", hash_generated_method = "973502D8F79EF694CA70AC8C592388B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getHistoricalAxisValue(int axis, int pointerIndex, int pos) {
        dsTaint.addTaint(axis);
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        float var675E97582C752387B4365682C4F7B0FA_1882865529 = (nativeGetAxisValue(mNativePtr, axis, pointerIndex, pos));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return nativeGetAxisValue(mNativePtr, axis, pointerIndex, pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "D80ADCD256759644414D5CBEC3C57D0B", hash_generated_method = "5B31CFC6D8DF6448D81C5430D5616BE8")
    @DSModeled(DSC.SAFE)
    public final void getHistoricalPointerCoords(int pointerIndex, int pos,
            PointerCoords outPointerCoords) {
        dsTaint.addTaint(pointerIndex);
        dsTaint.addTaint(pos);
        dsTaint.addTaint(outPointerCoords.dsTaint);
        nativeGetPointerCoords(mNativePtr, pointerIndex, pos, outPointerCoords);
        // ---------- Original Method ----------
        //nativeGetPointerCoords(mNativePtr, pointerIndex, pos, outPointerCoords);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "26EA400A9751805DFF1D4CEEB005645B", hash_generated_method = "ED846E32876DB5CBFCE7291E7600765B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getEdgeFlags() {
        int var0FC0D903F55D3C457853DAA4F228A5D4_546632835 = (nativeGetEdgeFlags(mNativePtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetEdgeFlags(mNativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "348B6A1C5666102E94291FA4791C249A", hash_generated_method = "2B0AFCF0F827F3CA3197B25A790C656A")
    @DSModeled(DSC.SAFE)
    public final void setEdgeFlags(int flags) {
        dsTaint.addTaint(flags);
        nativeSetEdgeFlags(mNativePtr, flags);
        // ---------- Original Method ----------
        //nativeSetEdgeFlags(mNativePtr, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "34CE363FC32882BC3BBCF2E8ABF2B5B0", hash_generated_method = "2407DFE8B49960A372B49AEFDD3BC7EB")
    @DSModeled(DSC.SAFE)
    public final void setAction(int action) {
        dsTaint.addTaint(action);
        nativeSetAction(mNativePtr, action);
        // ---------- Original Method ----------
        //nativeSetAction(mNativePtr, action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.471 -0400", hash_original_method = "117CE161431F2ECDED077AD7F7467ADD", hash_generated_method = "AD07EF521117163BCC8530A19F18C3D4")
    @DSModeled(DSC.SAFE)
    public final void offsetLocation(float deltaX, float deltaY) {
        dsTaint.addTaint(deltaX);
        dsTaint.addTaint(deltaY);
        nativeOffsetLocation(mNativePtr, deltaX, deltaY);
        // ---------- Original Method ----------
        //nativeOffsetLocation(mNativePtr, deltaX, deltaY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.472 -0400", hash_original_method = "D9D9F7662138ADF2F9591F7DFAEB3F74", hash_generated_method = "DC5E0A4804C0577140B86C127C906A33")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.472 -0400", hash_original_method = "622D19544C973DA41E1BE7D7819B5A41", hash_generated_method = "ABC9A9DBB24C9DBF368FFDEF2E9E8EE4")
    @DSModeled(DSC.SAFE)
    public final void transform(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        {
            throw new IllegalArgumentException("matrix must not be null");
        } //End block
        nativeTransform(mNativePtr, matrix);
        // ---------- Original Method ----------
        //if (matrix == null) {
            //throw new IllegalArgumentException("matrix must not be null");
        //}
        //nativeTransform(mNativePtr, matrix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.472 -0400", hash_original_method = "F001981BC7F115C74B7EB0136965714D", hash_generated_method = "F25F944D4911109353B325747EA0B153")
    @DSModeled(DSC.SAFE)
    public final void addBatch(long eventTime, float x, float y,
            float pressure, float size, int metaState) {
        dsTaint.addTaint(pressure);
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(eventTime);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        dsTaint.addTaint(size);
        {
            ensureSharedTempPointerCapacity(1);
            final PointerCoords[] pc;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.472 -0400", hash_original_method = "06E22018450E3E0892CD70DE9E19F211", hash_generated_method = "3E18F701205DB8917FE4F0C5D2078837")
    @DSModeled(DSC.SAFE)
    public final void addBatch(long eventTime, PointerCoords[] pointerCoords, int metaState) {
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(pointerCoords.dsTaint);
        dsTaint.addTaint(eventTime);
        nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pointerCoords, metaState);
        // ---------- Original Method ----------
        //nativeAddBatch(mNativePtr, eventTime * NS_PER_MS, pointerCoords, metaState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.472 -0400", hash_original_method = "542474DD15BDDADB068A65C6A3EEA8E2", hash_generated_method = "B2345768D14849673224312036251683")
    @DSModeled(DSC.SAFE)
    public final boolean isWithinBoundsNoHistory(float left, float top,
            float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        final int pointerCount;
        pointerCount = nativeGetPointerCount(mNativePtr);
        {
            int i;
            i = 0;
            {
                final float x;
                x = nativeGetAxisValue(mNativePtr, AXIS_X, i, HISTORY_CURRENT);
                final float y;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.472 -0400", hash_original_method = "21B64904C65635047BDD8B29F88F873B", hash_generated_method = "3DFFF6B981AED6A7796A2EE5AF2B6C9B")
    private static final float clamp(float value, float low, float high) {
        if (value < low) {
            return low;
        } else if (value > high) {
            return high;
        }
        return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.473 -0400", hash_original_method = "C00E6E79D43678980DA0F4144A65F6A2", hash_generated_method = "B444B3A5764102643F0B79FFDDAA14F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final MotionEvent clampNoHistory(float left, float top, float right, float bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        MotionEvent ev;
        ev = obtain();
        {
            final int pointerCount;
            pointerCount = nativeGetPointerCount(mNativePtr);
            ensureSharedTempPointerCapacity(pointerCount);
            final PointerProperties[] pp;
            pp = gSharedTempPointerProperties;
            final PointerCoords[] pc;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.473 -0400", hash_original_method = "FBF170B15B2FFBEE1AB1D4E32A8773CA", hash_generated_method = "90B1821A168EEF6BDFBB6341A9DA1D88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getPointerIdBits() {
        int idBits;
        idBits = 0;
        final int pointerCount;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.473 -0400", hash_original_method = "4F0FF8B26009CA9D26EE500AEFE507EC", hash_generated_method = "2F4AF7F37B1DE53D315D412C12AC7734")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final MotionEvent split(int idBits) {
        dsTaint.addTaint(idBits);
        MotionEvent ev;
        ev = obtain();
        {
            final int oldPointerCount;
            oldPointerCount = nativeGetPointerCount(mNativePtr);
            ensureSharedTempPointerCapacity(oldPointerCount);
            final PointerProperties[] pp;
            pp = gSharedTempPointerProperties;
            final PointerCoords[] pc;
            pc = gSharedTempPointerCoords;
            final int[] map;
            map = gSharedTempPointerIndexMap;
            final int oldAction;
            oldAction = nativeGetAction(mNativePtr);
            final int oldActionMasked;
            oldActionMasked = oldAction & ACTION_MASK;
            final int oldActionPointerIndex;
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
                    final int idBit;
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
                throw new IllegalArgumentException("idBits did not match any ids in the event");
            } //End block
            final int newAction;
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
            final int historySize;
            historySize = nativeGetHistorySize(mNativePtr);
            {
                int h;
                h = 0;
                {
                    final int historyPos;
                    historyPos = HISTORY_CURRENT;
                    historyPos = h;
                    {
                        int i;
                        i = 0;
                        {
                            nativeGetPointerCoords(mNativePtr, map[i], historyPos, pc[i]);
                        } //End block
                    } //End collapsed parenthetic
                    final long eventTimeNanos;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.474 -0400", hash_original_method = "69A985781D7A79E036178DEB42E5F1F0", hash_generated_method = "FDB5BB4872E25F8A20C10BAD2B85005D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder msg;
        msg = new StringBuilder();
        msg.append("MotionEvent { action=").append(actionToString(getAction()));
        final int pointerCount;
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
        String varDF7768E9135E0359312ABB41620E333A_238605826 = (msg.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.474 -0400", hash_original_method = "677EA2B2000D6A74FF8682A7B068EF0E", hash_generated_method = "5DBA7EC1D97BBD86785F5894ED81E4FD")
    public static String actionToString(int action) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.474 -0400", hash_original_method = "CD7691F9B0EDFAD8C08008BAAFAB09D1", hash_generated_method = "2AB4D24013CC1BCF0BB0F89D2394C1B4")
    public static String axisToString(int axis) {
        String symbolicName = AXIS_SYMBOLIC_NAMES.get(axis);
        return symbolicName != null ? symbolicName : Integer.toString(axis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.474 -0400", hash_original_method = "ED7596641D0AD2A83AA1412880E16E35", hash_generated_method = "9BB01C558D2CFCC5F3F56807099D8790")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.474 -0400", hash_original_method = "7E9E2322F8BF9BC3C830467DF1C4FD47", hash_generated_method = "9CCEC3AEC544F08A593C2357B4862EA1")
    public static String buttonStateToString(int buttonState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.474 -0400", hash_original_method = "5EC3F5E4185B2190F76F36B4BDD7355A", hash_generated_method = "9BE93B36307DB8A68E3698A36E3288BF")
    public static String toolTypeToString(int toolType) {
        String symbolicName = TOOL_TYPE_SYMBOLIC_NAMES.get(toolType);
        return symbolicName != null ? symbolicName : Integer.toString(toolType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.474 -0400", hash_original_method = "57C17E945EEB836F9B50085EB541FE87", hash_generated_method = "183CC5B595137A77AD15B1BFF9C0E5B5")
    public static MotionEvent createFromParcelBody(Parcel in) {
        MotionEvent ev = obtain();
        ev.mNativePtr = nativeReadFromParcel(ev.mNativePtr, in);
        return ev;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.474 -0400", hash_original_method = "D732CA58C71ED959C0E1A12C336FC80D", hash_generated_method = "4678745CD5A5A93592116D7BB9766DD0")
    @DSModeled(DSC.SAFE)
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
        private static final int INITIAL_PACKED_AXIS_VALUES = 8;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.475 -0400", hash_original_method = "30C014872AED120D5788F672204C6D56", hash_generated_method = "7CA747A7C9C5E93049967E5E117B082B")
        @DSModeled(DSC.SAFE)
        public PointerCoords() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.475 -0400", hash_original_method = "4C1A041805DDE756B7430BBCF7A4A54D", hash_generated_method = "FBC41229928DFA63EF602C8D11FE37BC")
        @DSModeled(DSC.SAFE)
        public PointerCoords(PointerCoords other) {
            dsTaint.addTaint(other.dsTaint);
            copyFrom(other);
            // ---------- Original Method ----------
            //copyFrom(other);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.475 -0400", hash_original_method = "1926C043E5CBC7A33752E32EE0FEC2AA", hash_generated_method = "68EEAFCEF4BADCEA4E4D1A6A07DF5BDE")
        public static PointerCoords[] createArray(int size) {
            PointerCoords[] array = new PointerCoords[size];
            for (int i = 0; i < size; i++) {
                array[i] = new PointerCoords();
            }
            return array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.475 -0400", hash_original_method = "5B10C041062144B27347C9202A1953B2", hash_generated_method = "2A8763CF0E442AFEBD76CC956847F225")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.475 -0400", hash_original_method = "A2C68F8615572C95C5947791A8CC8026", hash_generated_method = "5ADF0628F133A577FE3D9CB9A802D0A4")
        @DSModeled(DSC.SAFE)
        public void copyFrom(PointerCoords other) {
            dsTaint.addTaint(other.dsTaint);
            final long bits;
            bits = other.mPackedAxisBits;
            mPackedAxisBits = bits;
            {
                final float[] otherValues;
                otherValues = other.mPackedAxisValues;
                final int count;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.475 -0400", hash_original_method = "566631CFDB34A411EF93513211D62594", hash_generated_method = "2F723C251A139A00D0F52547FF09FC2F")
        @DSModeled(DSC.SAFE)
        public float getAxisValue(int axis) {
            dsTaint.addTaint(axis);
            //Begin case default 
            {
                {
                    throw new IllegalArgumentException("Axis out of range.");
                } //End block
                final long bits;
                bits = mPackedAxisBits;
                final long axisBit;
                axisBit = 1L << axis;
                final int index;
                index = Long.bitCount(bits & (axisBit - 1L));
            } //End block
            //End case default 
            return dsTaint.getTaintFloat();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.476 -0400", hash_original_method = "55E9DEFA01615304E1434A1FAB8328FA", hash_generated_method = "C01EA5167100C0980D97F4D167A6C262")
        @DSModeled(DSC.SAFE)
        public void setAxisValue(int axis, float value) {
            dsTaint.addTaint(axis);
            dsTaint.addTaint(value);
            //Begin case default 
            {
                {
                    throw new IllegalArgumentException("Axis out of range.");
                } //End block
                final long bits;
                bits = mPackedAxisBits;
                final long axisBit;
                axisBit = 1L << axis;
                final int index;
                index = Long.bitCount(bits & (axisBit - 1L));
                float[] values;
                values = mPackedAxisValues;
                {
                    {
                        values = new float[INITIAL_PACKED_AXIS_VALUES];
                        mPackedAxisValues = values;
                    } //End block
                    {
                        final int count;
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

        
    }


    
    public static final class PointerProperties {
        public int id;
        public int toolType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.476 -0400", hash_original_method = "D6AAE40F539D7383E827DA395512E95B", hash_generated_method = "90C30F600314F22BDD0CDD6AE1EFE865")
        @DSModeled(DSC.SAFE)
        public PointerProperties() {
            clear();
            // ---------- Original Method ----------
            //clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.476 -0400", hash_original_method = "0B0B44B5B3A0DCF648446956F27785E9", hash_generated_method = "2E4EEA78FE7B2AE0AE8BF02C8677D479")
        @DSModeled(DSC.SAFE)
        public PointerProperties(PointerProperties other) {
            dsTaint.addTaint(other.dsTaint);
            copyFrom(other);
            // ---------- Original Method ----------
            //copyFrom(other);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.476 -0400", hash_original_method = "72739C70491AC0C585CFDF74B7788457", hash_generated_method = "6A44B6989D594E3784198D9AB8835CD0")
        public static PointerProperties[] createArray(int size) {
            PointerProperties[] array = new PointerProperties[size];
            for (int i = 0; i < size; i++) {
                array[i] = new PointerProperties();
            }
            return array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.476 -0400", hash_original_method = "ADC6A83F955A9ED0C1C75B5F08682583", hash_generated_method = "BF1D5C4ABCB8E4ADD2599596A24DF7EA")
        @DSModeled(DSC.SAFE)
        public void clear() {
            id = INVALID_POINTER_ID;
            toolType = TOOL_TYPE_UNKNOWN;
            // ---------- Original Method ----------
            //id = INVALID_POINTER_ID;
            //toolType = TOOL_TYPE_UNKNOWN;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.476 -0400", hash_original_method = "1E34ECE529256025A33CF5DCBE029131", hash_generated_method = "A0CEA2D627662402C3C3D7AA8E624972")
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
    
    static {
        SparseArray<String> names = TOOL_TYPE_SYMBOLIC_NAMES;
        names.append(TOOL_TYPE_UNKNOWN, "TOOL_TYPE_UNKNOWN");
        names.append(TOOL_TYPE_FINGER, "TOOL_TYPE_FINGER");
        names.append(TOOL_TYPE_STYLUS, "TOOL_TYPE_STYLUS");
        names.append(TOOL_TYPE_MOUSE, "TOOL_TYPE_MOUSE");
        names.append(TOOL_TYPE_ERASER, "TOOL_TYPE_ERASER");
    }
    
}


