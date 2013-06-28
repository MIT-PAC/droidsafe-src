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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.451 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "F7C7881CDFB8EE39A77616767B7E28BC")

    private long[] array;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.451 -0400", hash_original_method = "8B4DC9506BFF677670C5FDC2A32AE870", hash_generated_method = "728AE7633383F3FB5CC7E87BD3B58149")
    public  AtomicLongArray(int length) {
        array = new long[length];
        // ---------- Original Method ----------
        //array = new long[length];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.452 -0400", hash_original_method = "3050E53F51A7E140FB04DB0A1747CE30", hash_generated_method = "B03A0B34F857D2E3D84824AA6149C991")
    public  AtomicLongArray(long[] array) {
        this.array = array.clone();
        // ---------- Original Method ----------
        //this.array = array.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.452 -0400", hash_original_method = "362098406DB6EC351C04D37BE5D9828B", hash_generated_method = "B875EFD058A93EA4B1DE419137BA7EE4")
    private long checkedByteOffset(int i) {
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index " + i);
        long varB4F74700E4D7E2A1776EAE2E44E399BE_885326989 = (byteOffset(i));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2144125809 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2144125809;
        // ---------- Original Method ----------
        //if (i < 0 || i >= array.length)
            //throw new IndexOutOfBoundsException("index " + i);
        //return byteOffset(i);
    }

    
    private static long byteOffset(int i) {
        return ((long) i << shift) + base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.453 -0400", hash_original_method = "27E0D57FF2AEBC70EE6BF760C51E525C", hash_generated_method = "A656A6DA3620FC9775D46A3517BC374A")
    public final int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839749149 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839749149;
        // ---------- Original Method ----------
        //return array.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.453 -0400", hash_original_method = "8463D5A45B1A17BDF7D82E5555D69CD7", hash_generated_method = "F1E82850E85F0997768C9ADBB855334C")
    public final long get(int i) {
        long varC6494B614B539A39BAED11972E882A8C_1620433918 = (getRaw(checkedByteOffset(i)));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1659514936 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1659514936;
        // ---------- Original Method ----------
        //return getRaw(checkedByteOffset(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.454 -0400", hash_original_method = "3BC3287D9A4267A89B05E2A24AB18A2F", hash_generated_method = "D0894B49E2173DB6CD6429AFCA785C5A")
    private long getRaw(long offset) {
        long var119D7574C7133C9795B2E397A6495724_586355312 = (unsafe.getLongVolatile(array, offset));
        addTaint(offset);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1182523513 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1182523513;
        // ---------- Original Method ----------
        //return unsafe.getLongVolatile(array, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.454 -0400", hash_original_method = "4DA52F35ED4F588D120AC15F4A7F5E05", hash_generated_method = "0045765AEC727605D00F5D1D594153CF")
    public final void set(int i, long newValue) {
        unsafe.putLongVolatile(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue);
        // ---------- Original Method ----------
        //unsafe.putLongVolatile(array, checkedByteOffset(i), newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.454 -0400", hash_original_method = "A9BE4DDEF95D04BC8772778BE2B9B289", hash_generated_method = "7986E163AE28CCB53945FB21C2AF2CCA")
    public final void lazySet(int i, long newValue) {
        unsafe.putOrderedLong(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedLong(array, checkedByteOffset(i), newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.455 -0400", hash_original_method = "2B52BF2B27B28F94D4532D1FCB739678", hash_generated_method = "40D3FCDC1BFE415F87815FDB4F1B2DF3")
    public final long getAndSet(int i, long newValue) {
        long offset = checkedByteOffset(i);
        {
            long current = getRaw(offset);
            {
                boolean var05742DE3E307187CDC22816DD73B63B6_1433096145 = (compareAndSetRaw(offset, current, newValue));
            } //End collapsed parenthetic
        } //End block
        addTaint(i);
        addTaint(newValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1270430466 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1270430466;
        // ---------- Original Method ----------
        //long offset = checkedByteOffset(i);
        //while (true) {
            //long current = getRaw(offset);
            //if (compareAndSetRaw(offset, current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.455 -0400", hash_original_method = "068332A153A3867D545CC7FAFD9B0A09", hash_generated_method = "CFE76C49CAF9F5A837D74362F6EE2175")
    public final boolean compareAndSet(int i, long expect, long update) {
        boolean var94AC75E965305F903A3C34C46E253232_1915278131 = (compareAndSetRaw(checkedByteOffset(i), expect, update));
        addTaint(i);
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350478771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350478771;
        // ---------- Original Method ----------
        //return compareAndSetRaw(checkedByteOffset(i), expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.455 -0400", hash_original_method = "6CBE85C613A52AE19528F7E5DBB1A254", hash_generated_method = "496E769BD8B0EC668AE669F9B591AF73")
    private boolean compareAndSetRaw(long offset, long expect, long update) {
        boolean var65EFB0056CFA960A8E75E6E3F02DE612_599517985 = (unsafe.compareAndSwapLong(array, offset, expect, update));
        addTaint(offset);
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_800302170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_800302170;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapLong(array, offset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.455 -0400", hash_original_method = "ED72E6FD3A21C5856EAC1B034EC6EA24", hash_generated_method = "1E849003383CDD7CA9749C41D5AB53FE")
    public final boolean weakCompareAndSet(int i, long expect, long update) {
        boolean varDF3E4091C1B39F99FA32948E70BEBB49_1437154331 = (compareAndSet(i, expect, update));
        addTaint(i);
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_465894442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_465894442;
        // ---------- Original Method ----------
        //return compareAndSet(i, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.456 -0400", hash_original_method = "8FFC94593CC49EC6BAF09336827D1298", hash_generated_method = "BE718926E24FE05C260D6D09A02FE0E7")
    public final long getAndIncrement(int i) {
        long var136C416B1592D9FE1AACD54D62B13B90_48589810 = (getAndAdd(i, 1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2059902984 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2059902984;
        // ---------- Original Method ----------
        //return getAndAdd(i, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.456 -0400", hash_original_method = "B27AC0A2F2D69309FD7FE34C486A6DFC", hash_generated_method = "E8533F6BFDCC74FA523C70B280C3A82C")
    public final long getAndDecrement(int i) {
        long varC4A8E0F10CB61459BC2798BF64582E94_589426327 = (getAndAdd(i, -1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_155025810 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_155025810;
        // ---------- Original Method ----------
        //return getAndAdd(i, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.456 -0400", hash_original_method = "65F34E97002151EAA8279BE0D0462B17", hash_generated_method = "92116860AD585FB9C5685D96FF7E5004")
    public final long getAndAdd(int i, long delta) {
        long offset = checkedByteOffset(i);
        {
            long current = getRaw(offset);
            {
                boolean var8DEC129351396D795A39C504D7822862_2123431113 = (compareAndSetRaw(offset, current, current + delta));
            } //End collapsed parenthetic
        } //End block
        addTaint(i);
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_668186346 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_668186346;
        // ---------- Original Method ----------
        //long offset = checkedByteOffset(i);
        //while (true) {
            //long current = getRaw(offset);
            //if (compareAndSetRaw(offset, current, current + delta))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.456 -0400", hash_original_method = "0952BD1EFAF2CADC0C104B904274AAA7", hash_generated_method = "16E8511E27A7785F3B7681B857BF4ED8")
    public final long incrementAndGet(int i) {
        long varE1FBC73CA1E2114A3FF5E42738F0210E_606970576 = (addAndGet(i, 1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1285808958 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1285808958;
        // ---------- Original Method ----------
        //return addAndGet(i, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.457 -0400", hash_original_method = "1E049EFA1BA1304180B08336A5F8F226", hash_generated_method = "9A83E518C3B09CC02DC0F85AF9A652A1")
    public final long decrementAndGet(int i) {
        long varD5608860B8E61481645F87210F077E3C_1342851607 = (addAndGet(i, -1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1365739584 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1365739584;
        // ---------- Original Method ----------
        //return addAndGet(i, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.457 -0400", hash_original_method = "5A2B115B9C214021381979C4071AE18E", hash_generated_method = "741915A8CEA670A19C45676738F14E8D")
    public long addAndGet(int i, long delta) {
        long offset = checkedByteOffset(i);
        {
            long current = getRaw(offset);
            long next = current + delta;
            {
                boolean var845A43A37F048E746BD150866EB7710B_1827724781 = (compareAndSetRaw(offset, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(i);
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1134906415 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1134906415;
        // ---------- Original Method ----------
        //long offset = checkedByteOffset(i);
        //while (true) {
            //long current = getRaw(offset);
            //long next = current + delta;
            //if (compareAndSetRaw(offset, current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.458 -0400", hash_original_method = "3492963B9799FA768D7650AC10A0F976", hash_generated_method = "DEDCEC4833D88B6E34DC86A0E05EB2EA")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2092145409 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1834978074 = null; //Variable for return #2
        int iMax = array.length - 1;
        varB4EAC82CA7396A68D541C85D26508E83_2092145409 = "[]";
        StringBuilder b = new StringBuilder();
        b.append('[');
        {
            int i = 0;
            {
                b.append(getRaw(byteOffset(i)));
                varB4EAC82CA7396A68D541C85D26508E83_1834978074 = b.append(']').toString();
                b.append(',').append(' ');
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_781445737; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_781445737 = varB4EAC82CA7396A68D541C85D26508E83_2092145409;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_781445737 = varB4EAC82CA7396A68D541C85D26508E83_1834978074;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_781445737.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_781445737;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.458 -0400", hash_original_field = "13AA564307ACBDDD81DDE330203CD2BD", hash_generated_field = "353A0DB9401B29217EF8D77B58FE3997")

    private static final long serialVersionUID = -2308431214976778248L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.458 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.458 -0400", hash_original_field = "DD8AED8ADC13F79AD6B0817A71F73A1A", hash_generated_field = "E840612BC13BA3439D2963C9AE6D7EF3")

    private static final int base = unsafe.arrayBaseOffset(long[].class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.458 -0400", hash_original_field = "2AB64F4EE279E5BAF7AB7059B15E6D12", hash_generated_field = "FF5851CA3D0F293AEAEEEA589F926E4D")

    private static int shift;
    static {
        int scale = unsafe.arrayIndexScale(long[].class);
        if ((scale & (scale - 1)) != 0)
            throw new Error("data type scale not a power of two");
        shift = 31 - Integer.numberOfLeadingZeros(scale);
    }
    
}

