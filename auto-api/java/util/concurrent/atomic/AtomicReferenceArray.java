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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.038 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "1DD4CAAEAF702037B8556F46C93A922C")

    private Object[] array;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.039 -0400", hash_original_method = "3F3B508809AB9C6785D44F9F17208801", hash_generated_method = "1C5ABD6808E6EB4561F6DB27D784F1DA")
    public  AtomicReferenceArray(int length) {
        array = new Object[length];
        // ---------- Original Method ----------
        //array = new Object[length];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.039 -0400", hash_original_method = "4BF361D91BCD73243E073F36EA6D286A", hash_generated_method = "95C7FC50C6E008639AD150106990A546")
    public  AtomicReferenceArray(E[] array) {
        this.array = array.clone();
        // ---------- Original Method ----------
        //this.array = array.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.039 -0400", hash_original_method = "362098406DB6EC351C04D37BE5D9828B", hash_generated_method = "E9F73A17A9563D4E3DB9277E16F8C20D")
    private long checkedByteOffset(int i) {
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index " + i);
        long varB4F74700E4D7E2A1776EAE2E44E399BE_644971925 = (byteOffset(i));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1963193365 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1963193365;
        // ---------- Original Method ----------
        //if (i < 0 || i >= array.length)
            //throw new IndexOutOfBoundsException("index " + i);
        //return byteOffset(i);
    }

    
        private static long byteOffset(int i) {
        return ((long) i << shift) + base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.040 -0400", hash_original_method = "27E0D57FF2AEBC70EE6BF760C51E525C", hash_generated_method = "B51D343497C1FB0E277046F5A0E3B738")
    public final int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608347453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608347453;
        // ---------- Original Method ----------
        //return array.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.040 -0400", hash_original_method = "1A08AAB0F92ABC3159CC4A0EF89B33D7", hash_generated_method = "4DE4E7E4A18B37D53A533DE02E978E2D")
    public final E get(int i) {
        E varB4EAC82CA7396A68D541C85D26508E83_1013422925 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1013422925 = getRaw(checkedByteOffset(i));
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_1013422925.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1013422925;
        // ---------- Original Method ----------
        //return getRaw(checkedByteOffset(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.041 -0400", hash_original_method = "5C38AE7D133AF705563A03AB70E3DC4F", hash_generated_method = "F5394AD347E8DD463AC45310F6CA9EEC")
    private E getRaw(long offset) {
        E varB4EAC82CA7396A68D541C85D26508E83_2114323737 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2114323737 = (E) unsafe.getObjectVolatile(array, offset);
        addTaint(offset);
        varB4EAC82CA7396A68D541C85D26508E83_2114323737.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2114323737;
        // ---------- Original Method ----------
        //return (E) unsafe.getObjectVolatile(array, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.056 -0400", hash_original_method = "2871A98FC9C1130D313120CFEF808AF1", hash_generated_method = "50B63AAB03A8CA5265ABC4225C3AA910")
    public final void set(int i, E newValue) {
        unsafe.putObjectVolatile(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //unsafe.putObjectVolatile(array, checkedByteOffset(i), newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.057 -0400", hash_original_method = "3F210D61D8876E2D9B64DE55A46FE422", hash_generated_method = "564DFED8895678888D6A1303A28D9AE4")
    public final void lazySet(int i, E newValue) {
        unsafe.putOrderedObject(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //unsafe.putOrderedObject(array, checkedByteOffset(i), newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.058 -0400", hash_original_method = "3C2E0EC2E1E9CCF934534C20DF12F899", hash_generated_method = "EC69B641AB34C4AD2A9E070A47BC2F42")
    public final E getAndSet(int i, E newValue) {
        E varB4EAC82CA7396A68D541C85D26508E83_605500458 = null; //Variable for return #1
        long offset;
        offset = checkedByteOffset(i);
        {
            E current;
            current = (E) getRaw(offset);
            {
                boolean var05742DE3E307187CDC22816DD73B63B6_128637232 = (compareAndSetRaw(offset, current, newValue));
                varB4EAC82CA7396A68D541C85D26508E83_605500458 = current;
            } //End collapsed parenthetic
        } //End block
        addTaint(i);
        addTaint(newValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_605500458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_605500458;
        // ---------- Original Method ----------
        //long offset = checkedByteOffset(i);
        //while (true) {
            //E current = (E) getRaw(offset);
            //if (compareAndSetRaw(offset, current, newValue))
                //return current;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.062 -0400", hash_original_method = "B59DE16F8D16118A13A1CCE839A3A85D", hash_generated_method = "4167F1BAC6320B22DF77156A3C28B787")
    public final boolean compareAndSet(int i, E expect, E update) {
        boolean var94AC75E965305F903A3C34C46E253232_797086581 = (compareAndSetRaw(checkedByteOffset(i), expect, update));
        addTaint(i);
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1667450293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1667450293;
        // ---------- Original Method ----------
        //return compareAndSetRaw(checkedByteOffset(i), expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.066 -0400", hash_original_method = "C142592EE20B948DF28BEA68CBD1D6F8", hash_generated_method = "5B1F4B120B4A4BE4AB61302BBB391C56")
    private boolean compareAndSetRaw(long offset, E expect, E update) {
        boolean var9853DFFBC57BE539224975C6B2501680_1998968085 = (unsafe.compareAndSwapObject(array, offset, expect, update));
        addTaint(offset);
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2042655475 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2042655475;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(array, offset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.066 -0400", hash_original_method = "7FEFACA3B4A06CC6BC9F3075614DF7C8", hash_generated_method = "B92DAB2D306CFF2F8C79F5C7B064FD1C")
    public final boolean weakCompareAndSet(int i, E expect, E update) {
        boolean varDF3E4091C1B39F99FA32948E70BEBB49_138541871 = (compareAndSet(i, expect, update));
        addTaint(i);
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162271981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_162271981;
        // ---------- Original Method ----------
        //return compareAndSet(i, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.077 -0400", hash_original_method = "3492963B9799FA768D7650AC10A0F976", hash_generated_method = "E722C7F96267905365767B64C0CDC66F")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2094517899 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1386987475 = null; //Variable for return #2
        int iMax;
        iMax = array.length - 1;
        varB4EAC82CA7396A68D541C85D26508E83_2094517899 = "[]";
        StringBuilder b;
        b = new StringBuilder();
        b.append('[');
        {
            int i;
            i = 0;
            {
                b.append(getRaw(byteOffset(i)));
                varB4EAC82CA7396A68D541C85D26508E83_1386987475 = b.append(']').toString();
                b.append(',').append(' ');
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1026627074; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1026627074 = varB4EAC82CA7396A68D541C85D26508E83_2094517899;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1026627074 = varB4EAC82CA7396A68D541C85D26508E83_1386987475;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1026627074.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1026627074;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.077 -0400", hash_original_field = "8E0AC9A4BAC586701B995C239258B0BB", hash_generated_field = "F546389D618C16788694AFE2FC995B49")

    private static long serialVersionUID = -6209656149925076980L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.077 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

    private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.077 -0400", hash_original_field = "2FB3C852DC41FF977B7766EB53DCF31C", hash_generated_field = "287BBAF14B586EF769E7FB0D22EFC1BD")

    private static int base = unsafe.arrayBaseOffset(Object[].class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.077 -0400", hash_original_field = "2AB64F4EE279E5BAF7AB7059B15E6D12", hash_generated_field = "FF5851CA3D0F293AEAEEEA589F926E4D")

    private static int shift;
    static {
        int scale = unsafe.arrayIndexScale(Object[].class);
        if ((scale & (scale - 1)) != 0)
            throw new Error("data type scale not a power of two");
        shift = 31 - Integer.numberOfLeadingZeros(scale);
    }
    
}

