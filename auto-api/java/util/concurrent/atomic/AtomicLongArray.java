package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;
import java.util.*;

public class AtomicLongArray implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.894 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "F7C7881CDFB8EE39A77616767B7E28BC")

    private long[] array;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.906 -0400", hash_original_method = "8B4DC9506BFF677670C5FDC2A32AE870", hash_generated_method = "728AE7633383F3FB5CC7E87BD3B58149")
    public  AtomicLongArray(int length) {
        array = new long[length];
        // ---------- Original Method ----------
        //array = new long[length];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.907 -0400", hash_original_method = "3050E53F51A7E140FB04DB0A1747CE30", hash_generated_method = "B03A0B34F857D2E3D84824AA6149C991")
    public  AtomicLongArray(long[] array) {
        this.array = array.clone();
        // ---------- Original Method ----------
        //this.array = array.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.907 -0400", hash_original_method = "362098406DB6EC351C04D37BE5D9828B", hash_generated_method = "44E230759475E0DDB3CC821C090CE738")
    private long checkedByteOffset(int i) {
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index " + i);
        long varB4F74700E4D7E2A1776EAE2E44E399BE_644397311 = (byteOffset(i));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_337880607 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_337880607;
        // ---------- Original Method ----------
        //if (i < 0 || i >= array.length)
            //throw new IndexOutOfBoundsException("index " + i);
        //return byteOffset(i);
    }

    
        private static long byteOffset(int i) {
        return ((long) i << shift) + base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.908 -0400", hash_original_method = "27E0D57FF2AEBC70EE6BF760C51E525C", hash_generated_method = "82F491337A103F8844C2537950E09582")
    public final int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459242369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459242369;
        // ---------- Original Method ----------
        //return array.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.908 -0400", hash_original_method = "8463D5A45B1A17BDF7D82E5555D69CD7", hash_generated_method = "C59B14E6A6F0FC65D1AD3968DE5D51D0")
    public final long get(int i) {
        long varC6494B614B539A39BAED11972E882A8C_1845975441 = (getRaw(checkedByteOffset(i)));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1670949467 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1670949467;
        // ---------- Original Method ----------
        //return getRaw(checkedByteOffset(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.920 -0400", hash_original_method = "3BC3287D9A4267A89B05E2A24AB18A2F", hash_generated_method = "B54CA798FBE8C586580716D5C2D25F92")
    private long getRaw(long offset) {
        long var119D7574C7133C9795B2E397A6495724_894227761 = (unsafe.getLongVolatile(array, offset));
        addTaint(offset);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_846313811 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_846313811;
        // ---------- Original Method ----------
        //return unsafe.getLongVolatile(array, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.921 -0400", hash_original_method = "4DA52F35ED4F588D120AC15F4A7F5E05", hash_generated_method = "0045765AEC727605D00F5D1D594153CF")
    public final void set(int i, long newValue) {
        unsafe.putLongVolatile(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue);
        // ---------- Original Method ----------
        //unsafe.putLongVolatile(array, checkedByteOffset(i), newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.921 -0400", hash_original_method = "A9BE4DDEF95D04BC8772778BE2B9B289", hash_generated_method = "7986E163AE28CCB53945FB21C2AF2CCA")
    public final void lazySet(int i, long newValue) {
        unsafe.putOrderedLong(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedLong(array, checkedByteOffset(i), newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.924 -0400", hash_original_method = "2B52BF2B27B28F94D4532D1FCB739678", hash_generated_method = "5AD3FBC9A0AFDFF833F71E518154A3A6")
    public final long getAndSet(int i, long newValue) {
        long offset;
        offset = checkedByteOffset(i);
        {
            long current;
            current = getRaw(offset);
            {
                boolean var05742DE3E307187CDC22816DD73B63B6_1077202868 = (compareAndSetRaw(offset, current, newValue));
            } //End collapsed parenthetic
        } //End block
        addTaint(i);
        addTaint(newValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_329891200 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_329891200;
        // ---------- Original Method ----------
        //long offset = checkedByteOffset(i);
        //while (true) {
            //long current = getRaw(offset);
            //if (compareAndSetRaw(offset, current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.939 -0400", hash_original_method = "068332A153A3867D545CC7FAFD9B0A09", hash_generated_method = "C94BE93D8CA4D2D6BAFA400EEFF7E163")
    public final boolean compareAndSet(int i, long expect, long update) {
        boolean var94AC75E965305F903A3C34C46E253232_597773202 = (compareAndSetRaw(checkedByteOffset(i), expect, update));
        addTaint(i);
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_892914280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_892914280;
        // ---------- Original Method ----------
        //return compareAndSetRaw(checkedByteOffset(i), expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.940 -0400", hash_original_method = "6CBE85C613A52AE19528F7E5DBB1A254", hash_generated_method = "5C315ABB7EA3133B4F58E2642B07FB16")
    private boolean compareAndSetRaw(long offset, long expect, long update) {
        boolean var65EFB0056CFA960A8E75E6E3F02DE612_426425950 = (unsafe.compareAndSwapLong(array, offset, expect, update));
        addTaint(offset);
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_619070631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_619070631;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapLong(array, offset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.940 -0400", hash_original_method = "ED72E6FD3A21C5856EAC1B034EC6EA24", hash_generated_method = "3989CC37F956FA276392E5FF1A68FD13")
    public final boolean weakCompareAndSet(int i, long expect, long update) {
        boolean varDF3E4091C1B39F99FA32948E70BEBB49_161194365 = (compareAndSet(i, expect, update));
        addTaint(i);
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2118360560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2118360560;
        // ---------- Original Method ----------
        //return compareAndSet(i, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.940 -0400", hash_original_method = "8FFC94593CC49EC6BAF09336827D1298", hash_generated_method = "3BCBB5964B6942F4F3F4B880B54F3253")
    public final long getAndIncrement(int i) {
        long var136C416B1592D9FE1AACD54D62B13B90_1662311708 = (getAndAdd(i, 1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1049810993 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1049810993;
        // ---------- Original Method ----------
        //return getAndAdd(i, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.941 -0400", hash_original_method = "B27AC0A2F2D69309FD7FE34C486A6DFC", hash_generated_method = "726120EB3D3350CB470F79B04C27DBF8")
    public final long getAndDecrement(int i) {
        long varC4A8E0F10CB61459BC2798BF64582E94_944910614 = (getAndAdd(i, -1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1479484099 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1479484099;
        // ---------- Original Method ----------
        //return getAndAdd(i, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.941 -0400", hash_original_method = "65F34E97002151EAA8279BE0D0462B17", hash_generated_method = "B32589C7CA1E8BEEF47ECD4A9DB1E071")
    public final long getAndAdd(int i, long delta) {
        long offset;
        offset = checkedByteOffset(i);
        {
            long current;
            current = getRaw(offset);
            {
                boolean var8DEC129351396D795A39C504D7822862_320620341 = (compareAndSetRaw(offset, current, current + delta));
            } //End collapsed parenthetic
        } //End block
        addTaint(i);
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_769325466 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_769325466;
        // ---------- Original Method ----------
        //long offset = checkedByteOffset(i);
        //while (true) {
            //long current = getRaw(offset);
            //if (compareAndSetRaw(offset, current, current + delta))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.942 -0400", hash_original_method = "0952BD1EFAF2CADC0C104B904274AAA7", hash_generated_method = "39A4777BC520B055F006A1CFE4136A64")
    public final long incrementAndGet(int i) {
        long varE1FBC73CA1E2114A3FF5E42738F0210E_1240927609 = (addAndGet(i, 1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_484326250 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_484326250;
        // ---------- Original Method ----------
        //return addAndGet(i, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.942 -0400", hash_original_method = "1E049EFA1BA1304180B08336A5F8F226", hash_generated_method = "14F1517AA30370BB38D1563F1EB3F779")
    public final long decrementAndGet(int i) {
        long varD5608860B8E61481645F87210F077E3C_146266523 = (addAndGet(i, -1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_408956367 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_408956367;
        // ---------- Original Method ----------
        //return addAndGet(i, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.942 -0400", hash_original_method = "5A2B115B9C214021381979C4071AE18E", hash_generated_method = "276457462B9D85A20237D4231200071B")
    public long addAndGet(int i, long delta) {
        long offset;
        offset = checkedByteOffset(i);
        {
            long current;
            current = getRaw(offset);
            long next;
            next = current + delta;
            {
                boolean var845A43A37F048E746BD150866EB7710B_1040027883 = (compareAndSetRaw(offset, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(i);
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1062064739 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1062064739;
        // ---------- Original Method ----------
        //long offset = checkedByteOffset(i);
        //while (true) {
            //long current = getRaw(offset);
            //long next = current + delta;
            //if (compareAndSetRaw(offset, current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.943 -0400", hash_original_method = "3492963B9799FA768D7650AC10A0F976", hash_generated_method = "9A13BA9054A6D727205D1F42EC0D339D")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_670741652 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1478760917 = null; //Variable for return #2
        int iMax;
        iMax = array.length - 1;
        varB4EAC82CA7396A68D541C85D26508E83_670741652 = "[]";
        StringBuilder b;
        b = new StringBuilder();
        b.append('[');
        {
            int i;
            i = 0;
            {
                b.append(getRaw(byteOffset(i)));
                varB4EAC82CA7396A68D541C85D26508E83_1478760917 = b.append(']').toString();
                b.append(',').append(' ');
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1341942943; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1341942943 = varB4EAC82CA7396A68D541C85D26508E83_670741652;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1341942943 = varB4EAC82CA7396A68D541C85D26508E83_1478760917;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1341942943.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1341942943;
        // ---------- Original Method ----------
        //int iMax = array.length - 1;
        //if (iMax == -1)
            //return "[]";
        //StringBuilder b = new StringBuilder();
        //b.append('[');
        //for (int i = 0; ; i++) {
            //b.append(getRaw(byteOffset(i)));
            //if (i == iMax)
                //return b.append(']').toString();
            //b.append(',').append(' ');
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.944 -0400", hash_original_field = "13AA564307ACBDDD81DDE330203CD2BD", hash_generated_field = "AEAB1910DA47192660F14EC2CBBEE164")

    private static long serialVersionUID = -2308431214976778248L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.944 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

    private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.944 -0400", hash_original_field = "DD8AED8ADC13F79AD6B0817A71F73A1A", hash_generated_field = "5C138E53C3646D6EFAF1787706892432")

    private static int base = unsafe.arrayBaseOffset(long[].class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.944 -0400", hash_original_field = "2AB64F4EE279E5BAF7AB7059B15E6D12", hash_generated_field = "FF5851CA3D0F293AEAEEEA589F926E4D")

    private static int shift;
    static {
        int scale = unsafe.arrayIndexScale(long[].class);
        if ((scale & (scale - 1)) != 0)
            throw new Error("data type scale not a power of two");
        shift = 31 - Integer.numberOfLeadingZeros(scale);
    }
    
}

