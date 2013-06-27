package java.util.concurrent.atomic;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import sun.misc.Unsafe;
import java.util.*;

public class AtomicReferenceArray<E> implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.000 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "1DD4CAAEAF702037B8556F46C93A922C")

    private Object[] array;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.002 -0400", hash_original_method = "3F3B508809AB9C6785D44F9F17208801", hash_generated_method = "1C5ABD6808E6EB4561F6DB27D784F1DA")
    public  AtomicReferenceArray(int length) {
        array = new Object[length];
        // ---------- Original Method ----------
        //array = new Object[length];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.018 -0400", hash_original_method = "4BF361D91BCD73243E073F36EA6D286A", hash_generated_method = "95C7FC50C6E008639AD150106990A546")
    public  AtomicReferenceArray(E[] array) {
        this.array = array.clone();
        // ---------- Original Method ----------
        //this.array = array.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.019 -0400", hash_original_method = "362098406DB6EC351C04D37BE5D9828B", hash_generated_method = "1129F9588580F16B2A44C706471632C1")
    private long checkedByteOffset(int i) {
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index " + i);
        long varB4F74700E4D7E2A1776EAE2E44E399BE_475220654 = (byteOffset(i));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_955283182 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_955283182;
        // ---------- Original Method ----------
        //if (i < 0 || i >= array.length)
            //throw new IndexOutOfBoundsException("index " + i);
        //return byteOffset(i);
    }

    
        private static long byteOffset(int i) {
        return ((long) i << shift) + base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.019 -0400", hash_original_method = "27E0D57FF2AEBC70EE6BF760C51E525C", hash_generated_method = "4FA992FB34D51F0DC2206B4E4D8D8937")
    public final int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295369851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295369851;
        // ---------- Original Method ----------
        //return array.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.020 -0400", hash_original_method = "1A08AAB0F92ABC3159CC4A0EF89B33D7", hash_generated_method = "2E533D5C9820DA474626CCF4EFB2BE05")
    public final E get(int i) {
        E varB4EAC82CA7396A68D541C85D26508E83_1709281333 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1709281333 = getRaw(checkedByteOffset(i));
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_1709281333.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1709281333;
        // ---------- Original Method ----------
        //return getRaw(checkedByteOffset(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.020 -0400", hash_original_method = "5C38AE7D133AF705563A03AB70E3DC4F", hash_generated_method = "87B07E18DEC08522F3923305F5A15FCA")
    private E getRaw(long offset) {
        E varB4EAC82CA7396A68D541C85D26508E83_1745341282 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1745341282 = (E) unsafe.getObjectVolatile(array, offset);
        addTaint(offset);
        varB4EAC82CA7396A68D541C85D26508E83_1745341282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1745341282;
        // ---------- Original Method ----------
        //return (E) unsafe.getObjectVolatile(array, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.021 -0400", hash_original_method = "2871A98FC9C1130D313120CFEF808AF1", hash_generated_method = "50B63AAB03A8CA5265ABC4225C3AA910")
    public final void set(int i, E newValue) {
        unsafe.putObjectVolatile(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //unsafe.putObjectVolatile(array, checkedByteOffset(i), newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.021 -0400", hash_original_method = "3F210D61D8876E2D9B64DE55A46FE422", hash_generated_method = "564DFED8895678888D6A1303A28D9AE4")
    public final void lazySet(int i, E newValue) {
        unsafe.putOrderedObject(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //unsafe.putOrderedObject(array, checkedByteOffset(i), newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.028 -0400", hash_original_method = "3C2E0EC2E1E9CCF934534C20DF12F899", hash_generated_method = "A7742F6DE816EB5C3AF460987A0AC250")
    public final E getAndSet(int i, E newValue) {
        E varB4EAC82CA7396A68D541C85D26508E83_1372401567 = null; //Variable for return #1
        long offset;
        offset = checkedByteOffset(i);
        {
            E current;
            current = (E) getRaw(offset);
            {
                boolean var05742DE3E307187CDC22816DD73B63B6_2032566268 = (compareAndSetRaw(offset, current, newValue));
                varB4EAC82CA7396A68D541C85D26508E83_1372401567 = current;
            } //End collapsed parenthetic
        } //End block
        addTaint(i);
        addTaint(newValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1372401567.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1372401567;
        // ---------- Original Method ----------
        //long offset = checkedByteOffset(i);
        //while (true) {
            //E current = (E) getRaw(offset);
            //if (compareAndSetRaw(offset, current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.029 -0400", hash_original_method = "B59DE16F8D16118A13A1CCE839A3A85D", hash_generated_method = "5CD0EBFFA33621967EA2ED354F217BCC")
    public final boolean compareAndSet(int i, E expect, E update) {
        boolean var94AC75E965305F903A3C34C46E253232_1670811533 = (compareAndSetRaw(checkedByteOffset(i), expect, update));
        addTaint(i);
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045830899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045830899;
        // ---------- Original Method ----------
        //return compareAndSetRaw(checkedByteOffset(i), expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.029 -0400", hash_original_method = "C142592EE20B948DF28BEA68CBD1D6F8", hash_generated_method = "094FF21D4FD4829BFFF73B668CEC6553")
    private boolean compareAndSetRaw(long offset, E expect, E update) {
        boolean var9853DFFBC57BE539224975C6B2501680_1535436733 = (unsafe.compareAndSwapObject(array, offset, expect, update));
        addTaint(offset);
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302200392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_302200392;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(array, offset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.052 -0400", hash_original_method = "7FEFACA3B4A06CC6BC9F3075614DF7C8", hash_generated_method = "4F7C9EB7117A6FF6E763B4CD46E343E9")
    public final boolean weakCompareAndSet(int i, E expect, E update) {
        boolean varDF3E4091C1B39F99FA32948E70BEBB49_1306993999 = (compareAndSet(i, expect, update));
        addTaint(i);
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_930036062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_930036062;
        // ---------- Original Method ----------
        //return compareAndSet(i, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.054 -0400", hash_original_method = "3492963B9799FA768D7650AC10A0F976", hash_generated_method = "00358ED325A58EF2418F5E95507CE0F6")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1721160659 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1694188680 = null; //Variable for return #2
        int iMax;
        iMax = array.length - 1;
        varB4EAC82CA7396A68D541C85D26508E83_1721160659 = "[]";
        StringBuilder b;
        b = new StringBuilder();
        b.append('[');
        {
            int i;
            i = 0;
            {
                b.append(getRaw(byteOffset(i)));
                varB4EAC82CA7396A68D541C85D26508E83_1694188680 = b.append(']').toString();
                b.append(',').append(' ');
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1405885820; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1405885820 = varB4EAC82CA7396A68D541C85D26508E83_1721160659;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1405885820 = varB4EAC82CA7396A68D541C85D26508E83_1694188680;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1405885820.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1405885820;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.054 -0400", hash_original_field = "8E0AC9A4BAC586701B995C239258B0BB", hash_generated_field = "F546389D618C16788694AFE2FC995B49")

    private static long serialVersionUID = -6209656149925076980L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.054 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

    private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.054 -0400", hash_original_field = "2FB3C852DC41FF977B7766EB53DCF31C", hash_generated_field = "287BBAF14B586EF769E7FB0D22EFC1BD")

    private static int base = unsafe.arrayBaseOffset(Object[].class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.054 -0400", hash_original_field = "2AB64F4EE279E5BAF7AB7059B15E6D12", hash_generated_field = "FF5851CA3D0F293AEAEEEA589F926E4D")

    private static int shift;
    static {
        int scale = unsafe.arrayIndexScale(Object[].class);
        if ((scale & (scale - 1)) != 0)
            throw new Error("data type scale not a power of two");
        shift = 31 - Integer.numberOfLeadingZeros(scale);
    }
    
}

