package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SSLEngineResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.274 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "3EDB9D951EE040B1BC6830CF666CCCCD")

    private SSLEngineResult.Status status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.274 -0400", hash_original_field = "412C59B2DCF10DB9CB06BD36CD184EF1", hash_generated_field = "F2C463FCEB0A45B07208B161F9FF9757")

    private SSLEngineResult.HandshakeStatus handshakeStatus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.274 -0400", hash_original_field = "98DE14CF6ED8BA2A08621F8989CBB73D", hash_generated_field = "B7E40EAAA68ABDE5DDF60571929046AC")

    private int bytesConsumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.274 -0400", hash_original_field = "E2C06B4E3C7D872CA40631F2B897CED4", hash_generated_field = "E53D2C5242B0192243BAF7EE50A5F6F7")

    private int bytesProduced;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.275 -0400", hash_original_method = "7E2A70A53EA60FD8E9743686AFF107DB", hash_generated_method = "39D616708D512CB8CC6FC656F02F7022")
    public  SSLEngineResult(SSLEngineResult.Status status,
            SSLEngineResult.HandshakeStatus handshakeStatus, int bytesConsumed, int bytesProduced) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("status is null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("handshakeStatus is null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bytesConsumed is negative");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("bytesProduced is negative");
        } //End block
        this.status = status;
        this.handshakeStatus = handshakeStatus;
        this.bytesConsumed = bytesConsumed;
        this.bytesProduced = bytesProduced;
        // ---------- Original Method ----------
        //if (status == null) {
            //throw new IllegalArgumentException("status is null");
        //}
        //if (handshakeStatus == null) {
            //throw new IllegalArgumentException("handshakeStatus is null");
        //}
        //if (bytesConsumed < 0) {
            //throw new IllegalArgumentException("bytesConsumed is negative");
        //}
        //if (bytesProduced < 0) {
            //throw new IllegalArgumentException("bytesProduced is negative");
        //}
        //this.status = status;
        //this.handshakeStatus = handshakeStatus;
        //this.bytesConsumed = bytesConsumed;
        //this.bytesProduced = bytesProduced;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.276 -0400", hash_original_method = "50C43A89B1F71600509DCA8EECE4A168", hash_generated_method = "C5612E544F3E798E452AE4A46A385E44")
    public final Status getStatus() {
        Status varB4EAC82CA7396A68D541C85D26508E83_1796763944 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1796763944 = status;
        varB4EAC82CA7396A68D541C85D26508E83_1796763944.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1796763944;
        // ---------- Original Method ----------
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.276 -0400", hash_original_method = "C7CAF6278BE86BD417FEC0CDFDF808C8", hash_generated_method = "F4101F005E45607801D8FD42418184E6")
    public final HandshakeStatus getHandshakeStatus() {
        HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_1877310739 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1877310739 = handshakeStatus;
        varB4EAC82CA7396A68D541C85D26508E83_1877310739.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1877310739;
        // ---------- Original Method ----------
        //return handshakeStatus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.277 -0400", hash_original_method = "4F217738DCB333D737660126178B49E9", hash_generated_method = "4F7A58AB4DBA980862CAE3E875FB6816")
    public final int bytesConsumed() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270302232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270302232;
        // ---------- Original Method ----------
        //return bytesConsumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.290 -0400", hash_original_method = "881854C294C034F2A83844483FCF0823", hash_generated_method = "6E3B2548056F2E0915343E06BF1ECE8A")
    public final int bytesProduced() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92963917 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92963917;
        // ---------- Original Method ----------
        //return bytesProduced;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.290 -0400", hash_original_method = "FF10D49A46BF312B9918894EBDEF7098", hash_generated_method = "F6A22F86E07EBE3CCBFE2920BCFFF023")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1745217075 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1745217075 = "SSLEngineReport: Status = " + status + "  HandshakeStatus = " + handshakeStatus
                + "\n                 bytesConsumed = " + bytesConsumed + " bytesProduced = "
                + bytesProduced;
        varB4EAC82CA7396A68D541C85D26508E83_1745217075.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1745217075;
        // ---------- Original Method ----------
        //return "SSLEngineReport: Status = " + status + "  HandshakeStatus = " + handshakeStatus
                //+ "\n                 bytesConsumed = " + bytesConsumed + " bytesProduced = "
                //+ bytesProduced;
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

