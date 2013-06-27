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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.874 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "F7C7881CDFB8EE39A77616767B7E28BC")

    private long[] array;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.875 -0400", hash_original_method = "8B4DC9506BFF677670C5FDC2A32AE870", hash_generated_method = "728AE7633383F3FB5CC7E87BD3B58149")
    public  AtomicLongArray(int length) {
        array = new long[length];
        // ---------- Original Method ----------
        //array = new long[length];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.875 -0400", hash_original_method = "3050E53F51A7E140FB04DB0A1747CE30", hash_generated_method = "B03A0B34F857D2E3D84824AA6149C991")
    public  AtomicLongArray(long[] array) {
        this.array = array.clone();
        // ---------- Original Method ----------
        //this.array = array.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.876 -0400", hash_original_method = "362098406DB6EC351C04D37BE5D9828B", hash_generated_method = "B01BEBA4B338BC7F8236CF1F28D8A233")
    private long checkedByteOffset(int i) {
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index " + i);
        long varB4F74700E4D7E2A1776EAE2E44E399BE_148584360 = (byteOffset(i));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_295967284 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_295967284;
        // ---------- Original Method ----------
        //if (i < 0 || i >= array.length)
            //throw new IndexOutOfBoundsException("index " + i);
        //return byteOffset(i);
    }

    
        private static long byteOffset(int i) {
        return ((long) i << shift) + base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.876 -0400", hash_original_method = "27E0D57FF2AEBC70EE6BF760C51E525C", hash_generated_method = "AACD01A6081EEF5B7EBE0CE97CCA8AF3")
    public final int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665304967 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665304967;
        // ---------- Original Method ----------
        //return array.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.898 -0400", hash_original_method = "8463D5A45B1A17BDF7D82E5555D69CD7", hash_generated_method = "DC567D81ED8ADCFC77CF4F42057659A5")
    public final long get(int i) {
        long varC6494B614B539A39BAED11972E882A8C_1624373009 = (getRaw(checkedByteOffset(i)));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_701270787 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_701270787;
        // ---------- Original Method ----------
        //return getRaw(checkedByteOffset(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.899 -0400", hash_original_method = "3BC3287D9A4267A89B05E2A24AB18A2F", hash_generated_method = "799D9D844A0850270EA2C15713A943CB")
    private long getRaw(long offset) {
        long var119D7574C7133C9795B2E397A6495724_25078060 = (unsafe.getLongVolatile(array, offset));
        addTaint(offset);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1598174318 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1598174318;
        // ---------- Original Method ----------
        //return unsafe.getLongVolatile(array, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.899 -0400", hash_original_method = "4DA52F35ED4F588D120AC15F4A7F5E05", hash_generated_method = "0045765AEC727605D00F5D1D594153CF")
    public final void set(int i, long newValue) {
        unsafe.putLongVolatile(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue);
        // ---------- Original Method ----------
        //unsafe.putLongVolatile(array, checkedByteOffset(i), newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.900 -0400", hash_original_method = "A9BE4DDEF95D04BC8772778BE2B9B289", hash_generated_method = "7986E163AE28CCB53945FB21C2AF2CCA")
    public final void lazySet(int i, long newValue) {
        unsafe.putOrderedLong(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue);
        // ---------- Original Method ----------
        //unsafe.putOrderedLong(array, checkedByteOffset(i), newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.900 -0400", hash_original_method = "2B52BF2B27B28F94D4532D1FCB739678", hash_generated_method = "60A2C44846442F0A467D95F2EE10207D")
    public final long getAndSet(int i, long newValue) {
        long offset;
        offset = checkedByteOffset(i);
        {
            long current;
            current = getRaw(offset);
            {
                boolean var05742DE3E307187CDC22816DD73B63B6_1950558465 = (compareAndSetRaw(offset, current, newValue));
            } //End collapsed parenthetic
        } //End block
        addTaint(i);
        addTaint(newValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_7853464 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_7853464;
        // ---------- Original Method ----------
        //long offset = checkedByteOffset(i);
        //while (true) {
            //long current = getRaw(offset);
            //if (compareAndSetRaw(offset, current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.905 -0400", hash_original_method = "068332A153A3867D545CC7FAFD9B0A09", hash_generated_method = "0E255287E44B1F3E053283617F539D6B")
    public final boolean compareAndSet(int i, long expect, long update) {
        boolean var94AC75E965305F903A3C34C46E253232_1159459570 = (compareAndSetRaw(checkedByteOffset(i), expect, update));
        addTaint(i);
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898525875 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_898525875;
        // ---------- Original Method ----------
        //return compareAndSetRaw(checkedByteOffset(i), expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.906 -0400", hash_original_method = "6CBE85C613A52AE19528F7E5DBB1A254", hash_generated_method = "0E349FF39931F269AE3308B926025B81")
    private boolean compareAndSetRaw(long offset, long expect, long update) {
        boolean var65EFB0056CFA960A8E75E6E3F02DE612_1016822788 = (unsafe.compareAndSwapLong(array, offset, expect, update));
        addTaint(offset);
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805654356 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_805654356;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapLong(array, offset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.906 -0400", hash_original_method = "ED72E6FD3A21C5856EAC1B034EC6EA24", hash_generated_method = "E493094B34F493CA2D8989251343C0C4")
    public final boolean weakCompareAndSet(int i, long expect, long update) {
        boolean varDF3E4091C1B39F99FA32948E70BEBB49_2070054896 = (compareAndSet(i, expect, update));
        addTaint(i);
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1254652625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1254652625;
        // ---------- Original Method ----------
        //return compareAndSet(i, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.906 -0400", hash_original_method = "8FFC94593CC49EC6BAF09336827D1298", hash_generated_method = "76D68FBB1ACDD300466A3159CBAA52D4")
    public final long getAndIncrement(int i) {
        long var136C416B1592D9FE1AACD54D62B13B90_1057454768 = (getAndAdd(i, 1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_978565492 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_978565492;
        // ---------- Original Method ----------
        //return getAndAdd(i, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.906 -0400", hash_original_method = "B27AC0A2F2D69309FD7FE34C486A6DFC", hash_generated_method = "49214481B958EC90E9BF2DBF0E43CED0")
    public final long getAndDecrement(int i) {
        long varC4A8E0F10CB61459BC2798BF64582E94_1887281027 = (getAndAdd(i, -1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_376891489 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_376891489;
        // ---------- Original Method ----------
        //return getAndAdd(i, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.907 -0400", hash_original_method = "65F34E97002151EAA8279BE0D0462B17", hash_generated_method = "8FCD9D2C88E90EF8EE2D6BC0F9801EC3")
    public final long getAndAdd(int i, long delta) {
        long offset;
        offset = checkedByteOffset(i);
        {
            long current;
            current = getRaw(offset);
            {
                boolean var8DEC129351396D795A39C504D7822862_48530573 = (compareAndSetRaw(offset, current, current + delta));
            } //End collapsed parenthetic
        } //End block
        addTaint(i);
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1312598700 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1312598700;
        // ---------- Original Method ----------
        //long offset = checkedByteOffset(i);
        //while (true) {
            //long current = getRaw(offset);
            //if (compareAndSetRaw(offset, current, current + delta))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.907 -0400", hash_original_method = "0952BD1EFAF2CADC0C104B904274AAA7", hash_generated_method = "321F65B03B70EBC6CEC7A1D6A16522BF")
    public final long incrementAndGet(int i) {
        long varE1FBC73CA1E2114A3FF5E42738F0210E_742607594 = (addAndGet(i, 1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_509277109 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_509277109;
        // ---------- Original Method ----------
        //return addAndGet(i, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.920 -0400", hash_original_method = "1E049EFA1BA1304180B08336A5F8F226", hash_generated_method = "D6DDAF33876819CB2E57656CF00877C4")
    public final long decrementAndGet(int i) {
        long varD5608860B8E61481645F87210F077E3C_1493869555 = (addAndGet(i, -1));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1007233199 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1007233199;
        // ---------- Original Method ----------
        //return addAndGet(i, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.921 -0400", hash_original_method = "5A2B115B9C214021381979C4071AE18E", hash_generated_method = "D31221AB16FD5D8893AC9F18C689774E")
    public long addAndGet(int i, long delta) {
        long offset;
        offset = checkedByteOffset(i);
        {
            long current;
            current = getRaw(offset);
            long next;
            next = current + delta;
            {
                boolean var845A43A37F048E746BD150866EB7710B_968065554 = (compareAndSetRaw(offset, current, next));
            } //End collapsed parenthetic
        } //End block
        addTaint(i);
        addTaint(delta);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_275407957 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_275407957;
        // ---------- Original Method ----------
        //long offset = checkedByteOffset(i);
        //while (true) {
            //long current = getRaw(offset);
            //long next = current + delta;
            //if (compareAndSetRaw(offset, current, next))
                //return next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.922 -0400", hash_original_method = "3492963B9799FA768D7650AC10A0F976", hash_generated_method = "CAA5B0E4FDB33625AF90BA6DD98B7A01")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1289513665 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_771788228 = null; //Variable for return #2
        int iMax;
        iMax = array.length - 1;
        varB4EAC82CA7396A68D541C85D26508E83_1289513665 = "[]";
        StringBuilder b;
        b = new StringBuilder();
        b.append('[');
        {
            int i;
            i = 0;
            {
                b.append(getRaw(byteOffset(i)));
                varB4EAC82CA7396A68D541C85D26508E83_771788228 = b.append(']').toString();
                b.append(',').append(' ');
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_2121470875; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2121470875 = varB4EAC82CA7396A68D541C85D26508E83_1289513665;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2121470875 = varB4EAC82CA7396A68D541C85D26508E83_771788228;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2121470875.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2121470875;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.922 -0400", hash_original_field = "13AA564307ACBDDD81DDE330203CD2BD", hash_generated_field = "AEAB1910DA47192660F14EC2CBBEE164")

    private static long serialVersionUID = -2308431214976778248L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.922 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

    private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.922 -0400", hash_original_field = "DD8AED8ADC13F79AD6B0817A71F73A1A", hash_generated_field = "5C138E53C3646D6EFAF1787706892432")

    private static int base = unsafe.arrayBaseOffset(long[].class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.922 -0400", hash_original_field = "2AB64F4EE279E5BAF7AB7059B15E6D12", hash_generated_field = "FF5851CA3D0F293AEAEEEA589F926E4D")

    private static int shift;
    static {
        int scale = unsafe.arrayIndexScale(long[].class);
        if ((scale & (scale - 1)) != 0)
            throw new Error("data type scale not a power of two");
        shift = 31 - Integer.numberOfLeadingZeros(scale);
    }
    
}

