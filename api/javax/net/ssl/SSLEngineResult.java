package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class SSLEngineResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.628 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "3EDB9D951EE040B1BC6830CF666CCCCD")

    private SSLEngineResult.Status status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.628 -0400", hash_original_field = "412C59B2DCF10DB9CB06BD36CD184EF1", hash_generated_field = "F2C463FCEB0A45B07208B161F9FF9757")

    private SSLEngineResult.HandshakeStatus handshakeStatus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.628 -0400", hash_original_field = "98DE14CF6ED8BA2A08621F8989CBB73D", hash_generated_field = "B7E40EAAA68ABDE5DDF60571929046AC")

    private int bytesConsumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.628 -0400", hash_original_field = "E2C06B4E3C7D872CA40631F2B897CED4", hash_generated_field = "E53D2C5242B0192243BAF7EE50A5F6F7")

    private int bytesProduced;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.629 -0400", hash_original_method = "7E2A70A53EA60FD8E9743686AFF107DB", hash_generated_method = "39D616708D512CB8CC6FC656F02F7022")
    public  SSLEngineResult(SSLEngineResult.Status status,
            SSLEngineResult.HandshakeStatus handshakeStatus, int bytesConsumed, int bytesProduced) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("status is null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("handshakeStatus is null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bytesConsumed is negative");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bytesProduced is negative");
        } 
        this.status = status;
        this.handshakeStatus = handshakeStatus;
        this.bytesConsumed = bytesConsumed;
        this.bytesProduced = bytesProduced;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.629 -0400", hash_original_method = "50C43A89B1F71600509DCA8EECE4A168", hash_generated_method = "7C1E49D1107B04A8ED497D2650BD91C5")
    public final Status getStatus() {
        Status varB4EAC82CA7396A68D541C85D26508E83_1158174427 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1158174427 = status;
        varB4EAC82CA7396A68D541C85D26508E83_1158174427.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1158174427;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.630 -0400", hash_original_method = "C7CAF6278BE86BD417FEC0CDFDF808C8", hash_generated_method = "89182FDEBFCB3D5BDD2D0D8F0A7AA1E9")
    public final HandshakeStatus getHandshakeStatus() {
        HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_1604393035 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1604393035 = handshakeStatus;
        varB4EAC82CA7396A68D541C85D26508E83_1604393035.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1604393035;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.630 -0400", hash_original_method = "4F217738DCB333D737660126178B49E9", hash_generated_method = "BB2E66B1A8ED38A3C54476CBC60EEFEE")
    public final int bytesConsumed() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495501764 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495501764;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.630 -0400", hash_original_method = "881854C294C034F2A83844483FCF0823", hash_generated_method = "E6D13A5153D470CCFDD30E8AD979564E")
    public final int bytesProduced() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868726037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1868726037;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.631 -0400", hash_original_method = "FF10D49A46BF312B9918894EBDEF7098", hash_generated_method = "AF0E1F6EBCFA628DB4EC34DCF0ECB41B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_396210034 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_396210034 = "SSLEngineReport: Status = " + status + "  HandshakeStatus = " + handshakeStatus
                + "\n                 bytesConsumed = " + bytesConsumed + " bytesProduced = "
                + bytesProduced;
        varB4EAC82CA7396A68D541C85D26508E83_396210034.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_396210034;
        
        
                
                
    }

    
    public enum HandshakeStatus {
        NOT_HANDSHAKING,
        FINISHED,
        NEED_TASK,
        NEED_WRAP,
        NEED_UNWRAP
    }

    
    public static enum Status {
        BUFFER_OVERFLOW,
        BUFFER_UNDERFLOW,
        CLOSED,
        OK
    }

    
}

