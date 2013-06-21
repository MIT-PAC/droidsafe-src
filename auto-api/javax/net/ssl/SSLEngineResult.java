package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SSLEngineResult {
    private SSLEngineResult.Status status;
    private SSLEngineResult.HandshakeStatus handshakeStatus;
    private int bytesConsumed;
    private int bytesProduced;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.080 -0400", hash_original_method = "7E2A70A53EA60FD8E9743686AFF107DB", hash_generated_method = "5425C377A73A4FF7C043571EA7072DBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLEngineResult(SSLEngineResult.Status status,
            SSLEngineResult.HandshakeStatus handshakeStatus, int bytesConsumed, int bytesProduced) {
        dsTaint.addTaint(bytesConsumed);
        dsTaint.addTaint(status.dsTaint);
        dsTaint.addTaint(handshakeStatus.dsTaint);
        dsTaint.addTaint(bytesProduced);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.080 -0400", hash_original_method = "50C43A89B1F71600509DCA8EECE4A168", hash_generated_method = "8DA75072676846806B3F5998F647AA62")
    @DSModeled(DSC.SAFE)
    public final Status getStatus() {
        return (Status)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.081 -0400", hash_original_method = "C7CAF6278BE86BD417FEC0CDFDF808C8", hash_generated_method = "DB6345B89DC4B2A6A6EC2B3C6DBF176E")
    @DSModeled(DSC.SAFE)
    public final HandshakeStatus getHandshakeStatus() {
        return (HandshakeStatus)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return handshakeStatus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.081 -0400", hash_original_method = "4F217738DCB333D737660126178B49E9", hash_generated_method = "F3B488E9836B8A8AFE0995D32084940A")
    @DSModeled(DSC.SAFE)
    public final int bytesConsumed() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return bytesConsumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.081 -0400", hash_original_method = "881854C294C034F2A83844483FCF0823", hash_generated_method = "C9E9CEC9DB8DDB2133719DB96E947FEC")
    @DSModeled(DSC.SAFE)
    public final int bytesProduced() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return bytesProduced;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.081 -0400", hash_original_method = "FF10D49A46BF312B9918894EBDEF7098", hash_generated_method = "BF4A70020AD3DE3D6F46C485E5F2B6B9")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
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

