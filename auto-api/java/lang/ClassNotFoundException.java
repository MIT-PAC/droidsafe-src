package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ClassNotFoundException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.435 -0400", hash_original_field = "54D54A126A783BC9CBA8C06137136943", hash_generated_field = "F73E8300D821D42895FBD4F8215B8AE6")

    private Throwable ex;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.436 -0400", hash_original_method = "0639B59AB447390D4DDFBD24616B4C1C", hash_generated_method = "1E5153620BBC3A8E1E248DD972E06BD5")
    public  ClassNotFoundException() {
        super((Throwable) null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.436 -0400", hash_original_method = "298BE36926392F30C6A667D05BCFC9E5", hash_generated_method = "6ADA4533E6B0190347B8DB281C46029B")
    public  ClassNotFoundException(String detailMessage) {
        super(detailMessage, null);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.437 -0400", hash_original_method = "3941F53B9B07ECD0ECA0F56417778218", hash_generated_method = "5E57F9C4EC681FCC299F499F12E75BD6")
    public  ClassNotFoundException(String detailMessage, Throwable exception) {
        super(detailMessage);
        ex = exception;
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //ex = exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.437 -0400", hash_original_method = "4088520C94C7E98A0F8384BC5CAC9A7D", hash_generated_method = "DA4F8B257BDF40782367A51564B99974")
    public Throwable getException() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_169668440 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_169668440 = ex;
        varB4EAC82CA7396A68D541C85D26508E83_169668440.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_169668440;
        // ---------- Original Method ----------
        //return ex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.443 -0400", hash_original_method = "8471E555B70ADD40A898DC66BF7F4D1C", hash_generated_method = "B300B16EC4D6311A6BF3E42A192F2E54")
    @Override
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_716340348 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_716340348 = ex;
        varB4EAC82CA7396A68D541C85D26508E83_716340348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_716340348;
        // ---------- Original Method ----------
        //return ex;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.443 -0400", hash_original_field = "1ED7BB21E00FE119FAC2A7C8AF6A93B9", hash_generated_field = "AB133E052E4F6036FDEDEBA0C5C7D3C6")

    private static long serialVersionUID = 9176873029745254542L;
}

