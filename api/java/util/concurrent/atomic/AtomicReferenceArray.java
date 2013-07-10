package java.util.concurrent.atomic;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import sun.misc.Unsafe;
import java.util.*;

public class AtomicReferenceArray<E> implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.573 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "1DD4CAAEAF702037B8556F46C93A922C")

    private Object[] array;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.573 -0400", hash_original_method = "3F3B508809AB9C6785D44F9F17208801", hash_generated_method = "1C5ABD6808E6EB4561F6DB27D784F1DA")
    public  AtomicReferenceArray(int length) {
        array = new Object[length];
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.574 -0400", hash_original_method = "4BF361D91BCD73243E073F36EA6D286A", hash_generated_method = "95C7FC50C6E008639AD150106990A546")
    public  AtomicReferenceArray(E[] array) {
        this.array = array.clone();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.575 -0400", hash_original_method = "362098406DB6EC351C04D37BE5D9828B", hash_generated_method = "C79F525E5C26CFDB98C9E76A7311DFBC")
    private long checkedByteOffset(int i) {
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index " + i);
        long varB4F74700E4D7E2A1776EAE2E44E399BE_1274468539 = (byteOffset(i));
        addTaint(i);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1561016315 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1561016315;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static long byteOffset(int i) {
        return ((long) i << shift) + base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.577 -0400", hash_original_method = "27E0D57FF2AEBC70EE6BF760C51E525C", hash_generated_method = "2ECC933CA4EE37DAD1EDBB5E16DAFB07")
    public final int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669042348 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669042348;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.578 -0400", hash_original_method = "1A08AAB0F92ABC3159CC4A0EF89B33D7", hash_generated_method = "606D98F60AD6BBA4C0E5B8AC917FEAB3")
    public final E get(int i) {
        E varB4EAC82CA7396A68D541C85D26508E83_786029630 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_786029630 = getRaw(checkedByteOffset(i));
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_786029630.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_786029630;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.579 -0400", hash_original_method = "5C38AE7D133AF705563A03AB70E3DC4F", hash_generated_method = "47ADB363AD392050269B57FEC1929B24")
    private E getRaw(long offset) {
        E varB4EAC82CA7396A68D541C85D26508E83_172421416 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_172421416 = (E) unsafe.getObjectVolatile(array, offset);
        addTaint(offset);
        varB4EAC82CA7396A68D541C85D26508E83_172421416.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_172421416;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.580 -0400", hash_original_method = "2871A98FC9C1130D313120CFEF808AF1", hash_generated_method = "50B63AAB03A8CA5265ABC4225C3AA910")
    public final void set(int i, E newValue) {
        unsafe.putObjectVolatile(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.580 -0400", hash_original_method = "3F210D61D8876E2D9B64DE55A46FE422", hash_generated_method = "564DFED8895678888D6A1303A28D9AE4")
    public final void lazySet(int i, E newValue) {
        unsafe.putOrderedObject(array, checkedByteOffset(i), newValue);
        addTaint(i);
        addTaint(newValue.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.580 -0400", hash_original_method = "3C2E0EC2E1E9CCF934534C20DF12F899", hash_generated_method = "D80348E7B04A89087EA57117759A8093")
    public final E getAndSet(int i, E newValue) {
        E varB4EAC82CA7396A68D541C85D26508E83_1915753632 = null; 
        long offset = checkedByteOffset(i);
        {
            E current = (E) getRaw(offset);
            {
                boolean var05742DE3E307187CDC22816DD73B63B6_2587411 = (compareAndSetRaw(offset, current, newValue));
                varB4EAC82CA7396A68D541C85D26508E83_1915753632 = current;
            } 
        } 
        addTaint(i);
        addTaint(newValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1915753632.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1915753632;
        
        
        
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.581 -0400", hash_original_method = "B59DE16F8D16118A13A1CCE839A3A85D", hash_generated_method = "7910FDFA304987B52267DD38F1FC1D96")
    public final boolean compareAndSet(int i, E expect, E update) {
        boolean var94AC75E965305F903A3C34C46E253232_1499032334 = (compareAndSetRaw(checkedByteOffset(i), expect, update));
        addTaint(i);
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1452763368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1452763368;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.581 -0400", hash_original_method = "C142592EE20B948DF28BEA68CBD1D6F8", hash_generated_method = "270551AE919F222FB78F6E2CED4DDFBB")
    private boolean compareAndSetRaw(long offset, E expect, E update) {
        boolean var9853DFFBC57BE539224975C6B2501680_1961243790 = (unsafe.compareAndSwapObject(array, offset, expect, update));
        addTaint(offset);
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_557175851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_557175851;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.581 -0400", hash_original_method = "7FEFACA3B4A06CC6BC9F3075614DF7C8", hash_generated_method = "648244275962E114ADAC5C18D19AB89A")
    public final boolean weakCompareAndSet(int i, E expect, E update) {
        boolean varDF3E4091C1B39F99FA32948E70BEBB49_1827165719 = (compareAndSet(i, expect, update));
        addTaint(i);
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1794720031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1794720031;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.582 -0400", hash_original_method = "3492963B9799FA768D7650AC10A0F976", hash_generated_method = "EB73E4A5D67BAFB15CBA531D3BC1EF87")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1295528242 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_833787928 = null; 
        int iMax = array.length - 1;
        varB4EAC82CA7396A68D541C85D26508E83_1295528242 = "[]";
        StringBuilder b = new StringBuilder();
        b.append('[');
        {
            int i = 0;
            {
                b.append(getRaw(byteOffset(i)));
                varB4EAC82CA7396A68D541C85D26508E83_833787928 = b.append(']').toString();
                b.append(',').append(' ');
            } 
        } 
        String varA7E53CE21691AB073D9660D615818899_1264546311; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1264546311 = varB4EAC82CA7396A68D541C85D26508E83_1295528242;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1264546311 = varB4EAC82CA7396A68D541C85D26508E83_833787928;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1264546311.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1264546311;
        
        
        
            
        
        
        
            
            
                
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.582 -0400", hash_original_field = "8E0AC9A4BAC586701B995C239258B0BB", hash_generated_field = "2F36DD6945CCC2B6BE6348A40D0E3487")

    private static final long serialVersionUID = -6209656149925076980L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.582 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.582 -0400", hash_original_field = "2FB3C852DC41FF977B7766EB53DCF31C", hash_generated_field = "2D79D7DB0CAC72547DD2482A0F6D91B6")

    private static final int base = unsafe.arrayBaseOffset(Object[].class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.582 -0400", hash_original_field = "2AB64F4EE279E5BAF7AB7059B15E6D12", hash_generated_field = "FF5851CA3D0F293AEAEEEA589F926E4D")

    private static int shift;
    static {
        int scale = unsafe.arrayIndexScale(Object[].class);
        if ((scale & (scale - 1)) != 0)
            throw new Error("data type scale not a power of two");
        shift = 31 - Integer.numberOfLeadingZeros(scale);
    }
    
}

