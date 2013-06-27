package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SSLEngineResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.629 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "3EDB9D951EE040B1BC6830CF666CCCCD")

    private SSLEngineResult.Status status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.629 -0400", hash_original_field = "412C59B2DCF10DB9CB06BD36CD184EF1", hash_generated_field = "F2C463FCEB0A45B07208B161F9FF9757")

    private SSLEngineResult.HandshakeStatus handshakeStatus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.629 -0400", hash_original_field = "98DE14CF6ED8BA2A08621F8989CBB73D", hash_generated_field = "B7E40EAAA68ABDE5DDF60571929046AC")

    private int bytesConsumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.629 -0400", hash_original_field = "E2C06B4E3C7D872CA40631F2B897CED4", hash_generated_field = "E53D2C5242B0192243BAF7EE50A5F6F7")

    private int bytesProduced;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.630 -0400", hash_original_method = "7E2A70A53EA60FD8E9743686AFF107DB", hash_generated_method = "39D616708D512CB8CC6FC656F02F7022")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.630 -0400", hash_original_method = "50C43A89B1F71600509DCA8EECE4A168", hash_generated_method = "A12054BCD69E29E6D2541DE866BD959B")
    public final Status getStatus() {
        Status varB4EAC82CA7396A68D541C85D26508E83_1735499286 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1735499286 = status;
        varB4EAC82CA7396A68D541C85D26508E83_1735499286.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1735499286;
        // ---------- Original Method ----------
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.631 -0400", hash_original_method = "C7CAF6278BE86BD417FEC0CDFDF808C8", hash_generated_method = "D0B22728FA7E5B57572E0C41668EE719")
    public final HandshakeStatus getHandshakeStatus() {
        HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_1059345957 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1059345957 = handshakeStatus;
        varB4EAC82CA7396A68D541C85D26508E83_1059345957.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1059345957;
        // ---------- Original Method ----------
        //return handshakeStatus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.631 -0400", hash_original_method = "4F217738DCB333D737660126178B49E9", hash_generated_method = "F20B273EEA8446F223AE6EB92F007D60")
    public final int bytesConsumed() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964568826 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964568826;
        // ---------- Original Method ----------
        //return bytesConsumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.631 -0400", hash_original_method = "881854C294C034F2A83844483FCF0823", hash_generated_method = "3DBF5D34A7A73D1036A176EB44B6FF58")
    public final int bytesProduced() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734613126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734613126;
        // ---------- Original Method ----------
        //return bytesProduced;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.632 -0400", hash_original_method = "FF10D49A46BF312B9918894EBDEF7098", hash_generated_method = "CF8562718FBFAEC751792BB1E0211564")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_761847519 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_761847519 = "SSLEngineReport: Status = " + status + "  HandshakeStatus = " + handshakeStatus
                + "\n                 bytesConsumed = " + bytesConsumed + " bytesProduced = "
                + bytesProduced;
        varB4EAC82CA7396A68D541C85D26508E83_761847519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_761847519;
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

