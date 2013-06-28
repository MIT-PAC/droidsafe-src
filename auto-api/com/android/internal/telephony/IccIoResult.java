package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IccIoResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.948 -0400", hash_original_field = "CF7AB46209C6D3BE84FA81C940CD6249", hash_generated_field = "605D00358F6732BF4A4D044EA247A970")

    public int sw1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.948 -0400", hash_original_field = "9EEA8D4260140900C6819477BB4E6D89", hash_generated_field = "3291FE8B1F0E4F6843EB8729B855E0A4")

    public int sw2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.948 -0400", hash_original_field = "321C3CF486ED509164EDEC1E1981FEC8", hash_generated_field = "85C99161735D908FB014CA702C49895B")

    public byte[] payload;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.949 -0400", hash_original_method = "FC114C268C65B1E20AA18C3590A39E31", hash_generated_method = "C79C721930FC7A3D7D5BF6B30DC8FA95")
    public  IccIoResult(int sw1, int sw2, byte[] payload) {
        this.sw1 = sw1;
        this.sw2 = sw2;
        this.payload = payload;
        // ---------- Original Method ----------
        //this.sw1 = sw1;
        //this.sw2 = sw2;
        //this.payload = payload;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.949 -0400", hash_original_method = "ECAE0DFB5EB8DE1F7EC625CCCC39CE4E", hash_generated_method = "B9F729083C9E8F6E07C3BFC7B4E311A7")
    public  IccIoResult(int sw1, int sw2, String hexString) {
        this(sw1, sw2, IccUtils.hexStringToBytes(hexString));
        addTaint(sw1);
        addTaint(sw2);
        addTaint(hexString.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.949 -0400", hash_original_method = "C2E2D21A49FBAEB09CAD48E279230B17", hash_generated_method = "D2A56E5DFA3402E4A3518259094DC55C")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_136408690 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_136408690 = "IccIoResponse sw1:0x" + Integer.toHexString(sw1) + " sw2:0x"
                + Integer.toHexString(sw2);
        varB4EAC82CA7396A68D541C85D26508E83_136408690.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_136408690;
        // ---------- Original Method ----------
        //return "IccIoResponse sw1:0x" + Integer.toHexString(sw1) + " sw2:0x"
                //+ Integer.toHexString(sw2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.950 -0400", hash_original_method = "E45E4CA02C1498571B14F8EF02CBA542", hash_generated_method = "2851E708BC48FD4F7EF7A79FE7FE0A23")
    public boolean success() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146224837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146224837;
        // ---------- Original Method ----------
        //return sw1 == 0x90 || sw1 == 0x91 || sw1 == 0x9e || sw1 == 0x9f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.950 -0400", hash_original_method = "6314A49369EA2E2C83A84515E57327FB", hash_generated_method = "60CF3B67E31099E559666997623F4E57")
    public IccException getException() {
        IccException varB4EAC82CA7396A68D541C85D26508E83_946242827 = null; //Variable for return #1
        IccException varB4EAC82CA7396A68D541C85D26508E83_2098074679 = null; //Variable for return #2
        IccException varB4EAC82CA7396A68D541C85D26508E83_1482467305 = null; //Variable for return #3
        IccException varB4EAC82CA7396A68D541C85D26508E83_1314502772 = null; //Variable for return #4
        {
            boolean var18DA1CA4961A92F50E39298FDC380586_1308339048 = (success());
            varB4EAC82CA7396A68D541C85D26508E83_946242827 = null;
        } //End collapsed parenthetic
        //Begin case 0x94 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2098074679 = new IccFileTypeMismatch();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1482467305 = new IccFileNotFound();
        } //End block
        //End case 0x94 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_1314502772 = new IccException("sw1:" + sw1 + " sw2:" + sw2);
        //End case default 
        IccException varA7E53CE21691AB073D9660D615818899_751909310; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_751909310 = varB4EAC82CA7396A68D541C85D26508E83_946242827;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_751909310 = varB4EAC82CA7396A68D541C85D26508E83_2098074679;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_751909310 = varB4EAC82CA7396A68D541C85D26508E83_1482467305;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_751909310 = varB4EAC82CA7396A68D541C85D26508E83_1314502772;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_751909310.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_751909310;
        // ---------- Original Method ----------
        //if (success()) return null;
        //switch (sw1) {
            //case 0x94:
                //if (sw2 == 0x08) {
                    //return new IccFileTypeMismatch();
                //} else {
                    //return new IccFileNotFound();
                //}
            //default:
                //return new IccException("sw1:" + sw1 + " sw2:" + sw2);
        //}
    }

    
}

