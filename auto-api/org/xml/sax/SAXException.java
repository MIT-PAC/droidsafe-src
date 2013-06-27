package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SAXException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.098 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.106 -0400", hash_original_method = "D831304643C6F5E396859CE263E8CD25", hash_generated_method = "AAA5AC1F47C13D6FA9C3251A3CA70252")
    public  SAXException() {
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.106 -0400", hash_original_method = "0B6772DEF84C5953639B673A22CD2D87", hash_generated_method = "4448F009148543759FC214D525D87C16")
    public  SAXException(String message) {
        super(message);
        this.exception = null;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.106 -0400", hash_original_method = "6C46F13EAE6D974667959E2EC15AB51C", hash_generated_method = "55130B653035BD76E425D4A793596D27")
    public  SAXException(Exception e) {
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.107 -0400", hash_original_method = "DAF90944A95CF29FF719B165EE1D8D20", hash_generated_method = "617E751A0D7FFF0A626D2A2AC98F117E")
    public  SAXException(String message, Exception e) {
        super(message);
        this.exception = e;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.107 -0400", hash_original_method = "7F1A7B3B4DC8BE54F069CECA78CE108B", hash_generated_method = "CE6C07211F2A4C8C11F9E33F6B5378CF")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_324137243 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1675997009 = null; //Variable for return #2
        String message;
        message = super.getMessage();
        {
            varB4EAC82CA7396A68D541C85D26508E83_324137243 = exception.getMessage();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1675997009 = message;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1020713827; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1020713827 = varB4EAC82CA7396A68D541C85D26508E83_324137243;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1020713827 = varB4EAC82CA7396A68D541C85D26508E83_1675997009;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1020713827.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1020713827;
        // ---------- Original Method ----------
        //String message = super.getMessage();
        //if (message == null && exception != null) {
        //return exception.getMessage();
    //} else {
        //return message;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.108 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "257618B9C8C32573D59D9E6A3F977B8A")
    public Exception getException() {
        Exception varB4EAC82CA7396A68D541C85D26508E83_837704607 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_837704607 = exception;
        varB4EAC82CA7396A68D541C85D26508E83_837704607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_837704607;
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.109 -0400", hash_original_method = "0BE493810C06D201F4519F1260F94FAA", hash_generated_method = "A3F58D6B919DA166916971541835C168")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_22132632 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1647504105 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_22132632 = exception.toString();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1647504105 = super.toString();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_57411144; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_57411144 = varB4EAC82CA7396A68D541C85D26508E83_22132632;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_57411144 = varB4EAC82CA7396A68D541C85D26508E83_1647504105;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_57411144.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_57411144;
        // ---------- Original Method ----------
        //if (exception != null) {
        //return exception.toString();
    //} else {
        //return super.toString();
    //}
    }

    
}

