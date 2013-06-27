package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SAXException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.022 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.023 -0400", hash_original_method = "D831304643C6F5E396859CE263E8CD25", hash_generated_method = "AAA5AC1F47C13D6FA9C3251A3CA70252")
    public  SAXException() {
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.023 -0400", hash_original_method = "0B6772DEF84C5953639B673A22CD2D87", hash_generated_method = "4448F009148543759FC214D525D87C16")
    public  SAXException(String message) {
        super(message);
        this.exception = null;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.024 -0400", hash_original_method = "6C46F13EAE6D974667959E2EC15AB51C", hash_generated_method = "55130B653035BD76E425D4A793596D27")
    public  SAXException(Exception e) {
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.024 -0400", hash_original_method = "DAF90944A95CF29FF719B165EE1D8D20", hash_generated_method = "617E751A0D7FFF0A626D2A2AC98F117E")
    public  SAXException(String message, Exception e) {
        super(message);
        this.exception = e;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.025 -0400", hash_original_method = "7F1A7B3B4DC8BE54F069CECA78CE108B", hash_generated_method = "CEDF28F79AF05CA59F0D1849D8AD2EDC")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_108155088 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1493846039 = null; //Variable for return #2
        String message;
        message = super.getMessage();
        {
            varB4EAC82CA7396A68D541C85D26508E83_108155088 = exception.getMessage();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1493846039 = message;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1663741508; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1663741508 = varB4EAC82CA7396A68D541C85D26508E83_108155088;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1663741508 = varB4EAC82CA7396A68D541C85D26508E83_1493846039;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1663741508.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1663741508;
        // ---------- Original Method ----------
        //String message = super.getMessage();
        //if (message == null && exception != null) {
        //return exception.getMessage();
    //} else {
        //return message;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.027 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "1DFF9B8E8C8053F51D6F3C9D21E956B9")
    public Exception getException() {
        Exception varB4EAC82CA7396A68D541C85D26508E83_1876638465 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1876638465 = exception;
        varB4EAC82CA7396A68D541C85D26508E83_1876638465.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1876638465;
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.028 -0400", hash_original_method = "0BE493810C06D201F4519F1260F94FAA", hash_generated_method = "BBCB3D7B3EEF7DB5AC6D5F00360DE3E2")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1111907468 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_48624234 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1111907468 = exception.toString();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_48624234 = super.toString();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_2051782452; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2051782452 = varB4EAC82CA7396A68D541C85D26508E83_1111907468;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2051782452 = varB4EAC82CA7396A68D541C85D26508E83_48624234;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2051782452.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2051782452;
        // ---------- Original Method ----------
        //if (exception != null) {
        //return exception.toString();
    //} else {
        //return super.toString();
    //}
    }

    
}

