package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class URISyntaxException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.177 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "6283A1859476002FA59A8C77FB48608E")

    private String input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.177 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.178 -0400", hash_original_method = "97528CB9DDAE82ED090B6E0F20E64C52", hash_generated_method = "1C245F8AE9B3DBBA122BC3BDDA38A5A7")
    public  URISyntaxException(String input, String reason, int index) {
        super(reason);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        this.input = input;
        this.index = index;
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //if (input == null || reason == null) {
            //throw new NullPointerException();
        //}
        //if (index < -1) {
            //throw new IllegalArgumentException();
        //}
        //this.input = input;
        //this.index = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.178 -0400", hash_original_method = "9E8506F7D035742973E1D45F72C781FB", hash_generated_method = "018BF50F2F095B6AAC6FD96C1AA9F264")
    public  URISyntaxException(String input, String reason) {
        super(reason);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.input = input;
        index = -1;
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //if (input == null || reason == null) {
            //throw new NullPointerException();
        //}
        //this.input = input;
        //index = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.178 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "AB1D139D035E5FAECD2436F2213FBB50")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998874775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998874775;
        // ---------- Original Method ----------
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.179 -0400", hash_original_method = "D4B65418D906ACD682013E7ACC1989F7", hash_generated_method = "C280C4B8B1DE7EB674837EE9C8B35B41")
    public String getReason() {
        String varB4EAC82CA7396A68D541C85D26508E83_1763875169 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1763875169 = super.getMessage();
        varB4EAC82CA7396A68D541C85D26508E83_1763875169.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1763875169;
        // ---------- Original Method ----------
        //return super.getMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.179 -0400", hash_original_method = "DF4880B690A0BCFCB8F3C337A75DD5A0", hash_generated_method = "E283875E9B4EE58601EFDF14CE8D73CA")
    public String getInput() {
        String varB4EAC82CA7396A68D541C85D26508E83_508775183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_508775183 = input;
        varB4EAC82CA7396A68D541C85D26508E83_508775183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_508775183;
        // ---------- Original Method ----------
        //return input;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.180 -0400", hash_original_method = "2C0C7C544BFDCEB0F806A466417CE15E", hash_generated_method = "259D8FD8385CCD85AFBA41BA25711161")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_345382387 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1771941735 = null; //Variable for return #2
        String reason = super.getMessage();
        {
            varB4EAC82CA7396A68D541C85D26508E83_345382387 = reason + " at index " + index + ": " + input;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1771941735 = reason + ": " + input;
        String varA7E53CE21691AB073D9660D615818899_491101101; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_491101101 = varB4EAC82CA7396A68D541C85D26508E83_345382387;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_491101101 = varB4EAC82CA7396A68D541C85D26508E83_1771941735;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_491101101.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_491101101;
        // ---------- Original Method ----------
        //String reason = super.getMessage();
        //if (index != -1) {
            //return reason + " at index " + index + ": " + input;
        //}
        //return reason + ": " + input;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.180 -0400", hash_original_field = "6BAAC3C8A6CE54C09263198F1E53CEA3", hash_generated_field = "CB65BAFBA372A5B522C6FE0957B2DAA9")

    private static final long serialVersionUID = 2137979680897488891L;
}

