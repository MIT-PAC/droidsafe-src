package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;

public class BasicHeader implements Header, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.871 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.871 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.872 -0400", hash_original_method = "2FB38EAD7D5E85502A5A04936633433A", hash_generated_method = "BB65EDD64E2DB1C6D12A4CC9EE3596BA")
    public  BasicHeader(final String name, final String value) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } //End block
        this.name = name;
        this.value = value;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Name may not be null");
        //}
        //this.name = name;
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.875 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "67931D38B45F36A9E61151FEF07A2BD2")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1356669678 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1356669678 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_1356669678.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1356669678;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.876 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "AFDB613EF67AFCE189183989B6FD7F5E")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1629031034 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1629031034 = this.value;
        varB4EAC82CA7396A68D541C85D26508E83_1629031034.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1629031034;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.876 -0400", hash_original_method = "F969228997B8CD2234867EA0CA894312", hash_generated_method = "66DB47B77430CA9A09105435BECB6793")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1593572198 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1593572198 = BasicLineFormatter.DEFAULT.formatHeader(null, this).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1593572198.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1593572198;
        // ---------- Original Method ----------
        //return BasicLineFormatter.DEFAULT.formatHeader(null, this).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.880 -0400", hash_original_method = "4A0D34AA034E5A375AA25DFEEA935661", hash_generated_method = "4BF7743EF34C02D3B8F8764F71BC5FF7")
    public HeaderElement[] getElements() throws ParseException {
        HeaderElement[] varB4EAC82CA7396A68D541C85D26508E83_1042075208 = null; //Variable for return #1
        HeaderElement[] varB4EAC82CA7396A68D541C85D26508E83_1643699557 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1042075208 = BasicHeaderValueParser.parseElements(this.value, null);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1643699557 = new HeaderElement[] {};
        } //End block
        HeaderElement[] varA7E53CE21691AB073D9660D615818899_1574089817; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1574089817 = varB4EAC82CA7396A68D541C85D26508E83_1042075208;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1574089817 = varB4EAC82CA7396A68D541C85D26508E83_1643699557;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1574089817.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1574089817;
        // ---------- Original Method ----------
        //if (this.value != null) {
            //return BasicHeaderValueParser.parseElements(this.value, null);
        //} else {
            //return new HeaderElement[] {}; 
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.881 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "4CBB3AEF45AF888F3DE676153BA67E50")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_866441368 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_866441368 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_866441368.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_866441368;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

