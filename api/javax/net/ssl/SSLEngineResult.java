package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SSLEngineResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.411 -0500", hash_original_field = "01A57A198287636A7334A3F559B27DB9", hash_generated_field = "3EDB9D951EE040B1BC6830CF666CCCCD")

    private  SSLEngineResult.Status status;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.414 -0500", hash_original_field = "3A14F952543EDAA000E1BE0FA5E1E8D4", hash_generated_field = "F2C463FCEB0A45B07208B161F9FF9757")

    private  SSLEngineResult.HandshakeStatus handshakeStatus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.416 -0500", hash_original_field = "0EC7C3F85DDFEF55FAE4E8F5616F87AA", hash_generated_field = "B7E40EAAA68ABDE5DDF60571929046AC")

    private  int bytesConsumed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.418 -0500", hash_original_field = "521D00DADB98E8E7E152B2D258E2EEDD", hash_generated_field = "E53D2C5242B0192243BAF7EE50A5F6F7")

    private  int bytesProduced;

    /**
     * Creates a new {@code SSLEngineResult} instance with the specified state
     * values.
     *
     * @param status
     *            the return value of the {@code SSLEngine} operation.
     * @param handshakeStatus
     *            the status of the current handshake
     * @param bytesConsumed
     *            the number of bytes retrieved from the source buffer(s).
     * @param bytesProduced
     *            the number of bytes transferred to the destination buffer(s).
     * @throws IllegalArgumentException
     *             if {@code status} or {@code handshakeStatus} is {@code null},
     *             or if {@code bytesConsumed} or {@code bytesProduces} are
     *             negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.421 -0500", hash_original_method = "7E2A70A53EA60FD8E9743686AFF107DB", hash_generated_method = "8D00F0FF77706F442FC1B3D4ABF61854")
    
public SSLEngineResult(SSLEngineResult.Status status,
            SSLEngineResult.HandshakeStatus handshakeStatus, int bytesConsumed, int bytesProduced) {
        if (status == null) {
            throw new IllegalArgumentException("status is null");
        }
        if (handshakeStatus == null) {
            throw new IllegalArgumentException("handshakeStatus is null");
        }
        if (bytesConsumed < 0) {
            throw new IllegalArgumentException("bytesConsumed is negative");
        }
        if (bytesProduced < 0) {
            throw new IllegalArgumentException("bytesProduced is negative");
        }
        this.status = status;
        this.handshakeStatus = handshakeStatus;
        this.bytesConsumed = bytesConsumed;
        this.bytesProduced = bytesProduced;
    }

    /**
     * Returns the return value of the {@code SSLEngine} operation.
     *
     * @return the return value of the {@code SSLEngine} operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.423 -0500", hash_original_method = "50C43A89B1F71600509DCA8EECE4A168", hash_generated_method = "33939483DCBA9A1831D54896789FDA54")
    
public final Status getStatus() {
        return status;
    }

    /**
     * Returns the status of the current handshake.
     *
     * @return the status of the current handshake.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.426 -0500", hash_original_method = "C7CAF6278BE86BD417FEC0CDFDF808C8", hash_generated_method = "BA884AAB3E7CE7370214ED819888A3FC")
    
public final HandshakeStatus getHandshakeStatus() {
        return handshakeStatus;
    }

    /**
     * Returns the number of bytes retrieved from the source buffer(s).
     *
     * @return the number of bytes retrieved from the source buffer(s).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.428 -0500", hash_original_method = "4F217738DCB333D737660126178B49E9", hash_generated_method = "81679702FD98099E265AE77287253940")
    
public final int bytesConsumed() {
        return bytesConsumed;
    }

    /**
     * Returns the number of bytes transferred to the destination buffer(s).
     *
     * @return the number of bytes transferred to the destination buffer(s).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.430 -0500", hash_original_method = "881854C294C034F2A83844483FCF0823", hash_generated_method = "8E81C7EC04D9BAF42253C785966169E4")
    
public final int bytesProduced() {
        return bytesProduced;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.433 -0500", hash_original_method = "FF10D49A46BF312B9918894EBDEF7098", hash_generated_method = "2AE8A0263080A5FEF60E2F9EDD7084F5")
    
@Override
    public String toString() {
        return "SSLEngineReport: Status = " + status + "  HandshakeStatus = " + handshakeStatus
                + "\n                 bytesConsumed = " + bytesConsumed + " bytesProduced = "
                + bytesProduced;
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

