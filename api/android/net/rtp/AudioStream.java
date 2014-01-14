package android.net.rtp;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.InetAddress;
import java.net.SocketException;

public class AudioStream extends RtpStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.050 -0500", hash_original_field = "D7D3A6F306950CEA4B6FC85D0247F3C1", hash_generated_field = "48FE1FD1A45DD00365BBA4B7AFE1C228")

    private AudioCodec mCodec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.052 -0500", hash_original_field = "BBF38444A5F65E088584B6E688C4174B", hash_generated_field = "AAAC9649291EA7E9AF23C6AFE907EAE5")

    private int mDtmfType = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.055 -0500", hash_original_field = "751B610DA2A5D206C7B5EF0637C4DB48", hash_generated_field = "240D951663574AC277AC31BCA3E190DC")

    private AudioGroup mGroup;

    /**
     * Creates an AudioStream on the given local address. Note that the local
     * port is assigned automatically to conform with RFC 3550.
     *
     * @param address The network address of the local host to bind to.
     * @throws SocketException if the address cannot be bound or a problem
     *     occurs during binding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.057 -0500", hash_original_method = "409408EC0859D4060DA7CEF5328B7220", hash_generated_method = "E546AB87BEEBEDF71AF41D13671F26D0")
    
public AudioStream(InetAddress address) throws SocketException {
        super(address);
    }

    /**
     * Returns {@code true} if the stream has already joined an
     * {@link AudioGroup}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.060 -0500", hash_original_method = "254DAECE553220B60B3DDCDB0D3A9A7B", hash_generated_method = "7B21EB749E29507A4027BA11C4E55BF9")
    
@Override
    public final boolean isBusy() {
        return mGroup != null;
    }

    /**
     * Returns the joined {@link AudioGroup}.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.062 -0500", hash_original_method = "477F536A3076B0B10A19072AA2686CEC", hash_generated_method = "13763D327C25270880CF36A0BD0A059D")
    
public AudioGroup getGroup() {
        return mGroup;
    }

    /**
     * Joins an {@link AudioGroup}. Each stream can join only one group at a
     * time. The group can be changed by passing a different one or removed
     * by calling this method with {@code null}.
     *
     * @param group The AudioGroup to join or {@code null} to leave.
     * @throws IllegalStateException if the stream is not properly configured.
     * @see AudioGroup
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.064 -0500", hash_original_method = "119D45B9BF5FF64C97C7293B3DF5F7E3", hash_generated_method = "29ED583CFA904E738FF127CFB9F0B721")
    
public void join(AudioGroup group) {
        synchronized (this) {
            if (mGroup == group) {
                return;
            }
            if (mGroup != null) {
                mGroup.remove(this);
                mGroup = null;
            }
            if (group != null) {
                group.add(this, mCodec, mDtmfType);
                mGroup = group;
            }
        }
    }

    /**
     * Returns the {@link AudioCodec}, or {@code null} if it is not set.
     *
     * @see #setCodec(AudioCodec)
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.066 -0500", hash_original_method = "477233579E49B9ACBFE0DA40A2D8DF9C", hash_generated_method = "5487DAF43AFC33675BBC0738CAC2EA16")
    
public AudioCodec getCodec() {
        return mCodec;
    }

    /**
     * Sets the {@link AudioCodec}.
     *
     * @param codec The AudioCodec to be used.
     * @throws IllegalArgumentException if its type is used by DTMF.
     * @throws IllegalStateException if the stream is busy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.068 -0500", hash_original_method = "E0A36AFBD97A7B298B1941948E16CA1A", hash_generated_method = "36115B45816A017DE46648F643A7705B")
    
public void setCodec(AudioCodec codec) {
        if (isBusy()) {
            throw new IllegalStateException("Busy");
        }
        if (codec.type == mDtmfType) {
            throw new IllegalArgumentException("The type is used by DTMF");
        }
        mCodec = codec;
    }

    /**
     * Returns the RTP payload type for dual-tone multi-frequency (DTMF) digits,
     * or {@code -1} if it is not enabled.
     *
     * @see #setDtmfType(int)
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.071 -0500", hash_original_method = "67DA2B7B029AD6BDA2A522BA945FCCC7", hash_generated_method = "3C0067CBF059856A8FA81892062A2D81")
    
public int getDtmfType() {
        return mDtmfType;
    }

    /**
     * Sets the RTP payload type for dual-tone multi-frequency (DTMF) digits.
     * The primary usage is to send digits to the remote gateway to perform
     * certain tasks, such as second-stage dialing. According to RFC 2833, the
     * RTP payload type for DTMF is assigned dynamically, so it must be in the
     * range of 96 and 127. One can use {@code -1} to disable DTMF and free up
     * the previous assigned type. This method cannot be called when the stream
     * already joined an {@link AudioGroup}.
     *
     * @param type The RTP payload type to be used or {@code -1} to disable it.
     * @throws IllegalArgumentException if the type is invalid or used by codec.
     * @throws IllegalStateException if the stream is busy.
     * @see AudioGroup#sendDtmf(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:22.073 -0500", hash_original_method = "08CFB9D3491C3CF797064DF404EB556C", hash_generated_method = "069DE761EB980DB42ECB53D4DC66D0C6")
    
public void setDtmfType(int type) {
        if (isBusy()) {
            throw new IllegalStateException("Busy");
        }
        if (type != -1) {
            if (type < 96 || type > 127) {
                throw new IllegalArgumentException("Invalid type");
            }
            if (type == mCodec.type) {
                throw new IllegalArgumentException("The type is used by codec");
            }
        }
        mDtmfType = type;
    }
    
}

