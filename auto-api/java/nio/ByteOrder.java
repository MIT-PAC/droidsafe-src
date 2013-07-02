package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class ByteOrder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.815 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.815 -0400", hash_original_field = "891F8A88F62B8EFE8A26063940061E98", hash_generated_field = "4ECB2B3E8E176FD36BB429A3A3830E89")

    public boolean needsSwap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.816 -0400", hash_original_method = "B317EBC8D5650E5C34B265838B9D3EC5", hash_generated_method = "23C748F854E4D36213A9E09C7B4EA27E")
    private  ByteOrder(String name, boolean needsSwap) {
        this.name = name;
        this.needsSwap = needsSwap;
        
        
        
    }

    
    private static boolean isLittleEndian() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    public static ByteOrder nativeOrder() {
        return NATIVE_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.817 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "4CDE331DF1AFFDFE906279B5FDFA0AC6")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1502854660 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1502854660 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1502854660.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1502854660;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.817 -0400", hash_original_field = "AE6E19EF8315BD154B64B6B93A475246", hash_generated_field = "92D01F42E3BD90FA81F44D4D587D8F69")

    private static ByteOrder NATIVE_ORDER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.817 -0400", hash_original_field = "3E3837EDE152D846A1D1C6E4B5DE4432", hash_generated_field = "1234A298A97F3B5962AA23B60561E395")

    public static final ByteOrder BIG_ENDIAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.817 -0400", hash_original_field = "D2A887BA52940D91ADCA3B45876DCF7C", hash_generated_field = "06734A84A8A70D790F1E88567660685A")

    public static final ByteOrder LITTLE_ENDIAN;
    static {
        boolean isLittleEndian = isLittleEndian();
        BIG_ENDIAN = new ByteOrder("BIG_ENDIAN", isLittleEndian);
        LITTLE_ENDIAN = new ByteOrder("LITTLE_ENDIAN", !isLittleEndian);
        NATIVE_ORDER = isLittleEndian ? LITTLE_ENDIAN : BIG_ENDIAN;
    }
    
}

