package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class URISyntaxException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.032 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "6283A1859476002FA59A8C77FB48608E")

    private String input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.032 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.034 -0400", hash_original_method = "97528CB9DDAE82ED090B6E0F20E64C52", hash_generated_method = "1C245F8AE9B3DBBA122BC3BDDA38A5A7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.035 -0400", hash_original_method = "9E8506F7D035742973E1D45F72C781FB", hash_generated_method = "018BF50F2F095B6AAC6FD96C1AA9F264")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.035 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "E74CC36460550A0B7F16F9AEBF19551C")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548884526 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548884526;
        // ---------- Original Method ----------
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.035 -0400", hash_original_method = "D4B65418D906ACD682013E7ACC1989F7", hash_generated_method = "F6030AAED4B427C025D4C2A0128E9E67")
    public String getReason() {
        String varB4EAC82CA7396A68D541C85D26508E83_2026191895 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2026191895 = super.getMessage();
        varB4EAC82CA7396A68D541C85D26508E83_2026191895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2026191895;
        // ---------- Original Method ----------
        //return super.getMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.036 -0400", hash_original_method = "DF4880B690A0BCFCB8F3C337A75DD5A0", hash_generated_method = "390D3DD3A722CEC3F6AF963206F4EAAB")
    public String getInput() {
        String varB4EAC82CA7396A68D541C85D26508E83_1013873059 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1013873059 = input;
        varB4EAC82CA7396A68D541C85D26508E83_1013873059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1013873059;
        // ---------- Original Method ----------
        //return input;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.036 -0400", hash_original_method = "2C0C7C544BFDCEB0F806A466417CE15E", hash_generated_method = "DCC850E4F19DB5ECEB1F3249BA1035C3")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1261058855 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1730495393 = null; //Variable for return #2
        String reason;
        reason = super.getMessage();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1261058855 = reason + " at index " + index + ": " + input;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1730495393 = reason + ": " + input;
        String varA7E53CE21691AB073D9660D615818899_1986087732; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1986087732 = varB4EAC82CA7396A68D541C85D26508E83_1261058855;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1986087732 = varB4EAC82CA7396A68D541C85D26508E83_1730495393;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1986087732.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1986087732;
        // ---------- Original Method ----------
        //String reason = super.getMessage();
        //if (index != -1) {
            //return reason + " at index " + index + ": " + input;
        //}
        //return reason + ": " + input;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.037 -0400", hash_original_field = "6BAAC3C8A6CE54C09263198F1E53CEA3", hash_generated_field = "9CED5CA04BF5E73E99B2C9725F0DEEE4")

    private static long serialVersionUID = 2137979680897488891L;
}

