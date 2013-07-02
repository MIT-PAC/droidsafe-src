package org.xml.sax;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class SAXException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.791 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.791 -0400", hash_original_method = "D831304643C6F5E396859CE263E8CD25", hash_generated_method = "AAA5AC1F47C13D6FA9C3251A3CA70252")
    public  SAXException() {
        this.exception = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.792 -0400", hash_original_method = "0B6772DEF84C5953639B673A22CD2D87", hash_generated_method = "4448F009148543759FC214D525D87C16")
    public  SAXException(String message) {
        super(message);
        this.exception = null;
        addTaint(message.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.792 -0400", hash_original_method = "6C46F13EAE6D974667959E2EC15AB51C", hash_generated_method = "55130B653035BD76E425D4A793596D27")
    public  SAXException(Exception e) {
        this.exception = e;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.792 -0400", hash_original_method = "DAF90944A95CF29FF719B165EE1D8D20", hash_generated_method = "617E751A0D7FFF0A626D2A2AC98F117E")
    public  SAXException(String message, Exception e) {
        super(message);
        this.exception = e;
        addTaint(message.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.793 -0400", hash_original_method = "7F1A7B3B4DC8BE54F069CECA78CE108B", hash_generated_method = "16ACBED59EA161844885C283514FCF61")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_840084349 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_35949544 = null; 
        String message = super.getMessage();
        {
            varB4EAC82CA7396A68D541C85D26508E83_840084349 = exception.getMessage();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_35949544 = message;
        } 
        String varA7E53CE21691AB073D9660D615818899_1508886579; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1508886579 = varB4EAC82CA7396A68D541C85D26508E83_840084349;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1508886579 = varB4EAC82CA7396A68D541C85D26508E83_35949544;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1508886579.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1508886579;
        
        
        
        
    
        
    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.793 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "A9E41A6A259E2A592F62F48C0B4EE3E1")
    public Exception getException() {
        Exception varB4EAC82CA7396A68D541C85D26508E83_395645073 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_395645073 = exception;
        varB4EAC82CA7396A68D541C85D26508E83_395645073.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_395645073;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.794 -0400", hash_original_method = "0BE493810C06D201F4519F1260F94FAA", hash_generated_method = "EB26765A5B962C1F59A293091BB2DAA7")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1815549678 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1419808579 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1815549678 = exception.toString();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1419808579 = super.toString();
        } 
        String varA7E53CE21691AB073D9660D615818899_1042012314; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1042012314 = varB4EAC82CA7396A68D541C85D26508E83_1815549678;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1042012314 = varB4EAC82CA7396A68D541C85D26508E83_1419808579;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1042012314.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1042012314;
        
        
        
    
        
    
    }

    
}

