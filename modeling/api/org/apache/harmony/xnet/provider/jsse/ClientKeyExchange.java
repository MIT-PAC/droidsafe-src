package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;

import libcore.io.Streams;
import libcore.util.EmptyArray;

public class ClientKeyExchange extends Message {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.442 -0500", hash_original_field = "A8EC1747D3C20FCA9F3B799F3E21511E", hash_generated_field = "A8EC1747D3C20FCA9F3B799F3E21511E")

     byte[] exchange_keys;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.444 -0500", hash_original_field = "314E39EA2F69CB2F1D5074178AD0D4A9", hash_generated_field = "314E39EA2F69CB2F1D5074178AD0D4A9")

    boolean isTLS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.446 -0500", hash_original_field = "5EC821C040A3584EF0C79FD7C884CE8D", hash_generated_field = "5EC821C040A3584EF0C79FD7C884CE8D")

     boolean isRSA;

    /**
     * Creates outbound message
     * @param encrypted_pre_master_secret
     * @param isTLS
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.448 -0500", hash_original_method = "C9B8341788FD531DBE072AC5097543AB", hash_generated_method = "57D0F1FEAF9444332AF215D389B63E87")
    
public ClientKeyExchange(byte[] encrypted_pre_master_secret, boolean isTLS) {
        this.exchange_keys = encrypted_pre_master_secret;
        length = this.exchange_keys.length;
        if (isTLS) {
            length += 2;
        }
        this.isTLS = isTLS;
        isRSA = true;
    }

    /**
     * Creates outbound message
     * @param dh_Yc
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.451 -0500", hash_original_method = "82DB124C7EE193607645A424E30C3D24", hash_generated_method = "ED188A79BA286B06722DD11D7A6A98D1")
    
public ClientKeyExchange(BigInteger dh_Yc) {
        byte[] bb = dh_Yc.toByteArray();
        if (bb[0] == 0) {
            exchange_keys = new byte[bb.length-1];
            System.arraycopy(bb, 1, exchange_keys, 0, exchange_keys.length);
        } else {
            exchange_keys = bb;
        }
        length = exchange_keys.length +2;
        isRSA = false;
    }

    /**
     * Creates empty message
     *
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.454 -0500", hash_original_method = "F9E21C88B251C3A8D5F2F68FD08CDC9E", hash_generated_method = "898A8CFB30DDF1C33784F7A96F82C351")
    
public ClientKeyExchange() {
        exchange_keys = EmptyArray.BYTE;
        length = 0;
        isRSA = false;
    }

    /**
     * Creates inbound message
     * @param length
     * @param isTLS
     * @param isRSA
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.457 -0500", hash_original_method = "C1B0A0A6F00EB418D00ABC26C97C8AF6", hash_generated_method = "599B1D8D84467266F519B3C099220E67")
    
public ClientKeyExchange(HandshakeIODataStream in, int length, boolean isTLS, boolean isRSA)
            throws IOException {
        this.isTLS = isTLS;
        this.isRSA = isRSA;
        if (length == 0) {
            this.length = 0;
            exchange_keys = EmptyArray.BYTE;
        } else {
            int size;
            if (isRSA && !isTLS) {// SSL3.0 RSA
                size = length;
                this.length = size;
            } else { // DH or TLSv1 RSA
                size = in.readUint16();
                this.length = 2 + size;
            }
            exchange_keys = new byte[size];
            Streams.readFully(in, exchange_keys);
            if (this.length != length) {
                fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ClientKeyExchange");
            }
        }
    }

    /**
     * Sends message
     * @param out
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.459 -0500", hash_original_method = "355F47F7AE472993E3A2C68F4F83F8CB", hash_generated_method = "7DAE11C94B3B5FFEA81184E8A7CC2D91")
    
@Override
    public void send(HandshakeIODataStream out) {
        if (exchange_keys.length != 0) {
            if (!isRSA || isTLS) {// DH or TLSv1 RSA
                out.writeUint16(exchange_keys.length);
            }
            out.write(exchange_keys);
        }
    }

    /**
     * Returns message type
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.462 -0500", hash_original_method = "689E42FE01D543BF62D87A0EDA5093F1", hash_generated_method = "226C47994395815B489D9CA228F6ACD0")
    
@Override
    public int getType() {
        return Handshake.CLIENT_KEY_EXCHANGE;
    }

    /**
     * Returns true if the message is empty (in case of implicit DH Yc)
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.464 -0500", hash_original_method = "A6E948E5B249A2FAEF42B96B088122ED", hash_generated_method = "F0F3E5365C22D2919C02E3C458E1E309")
    
public boolean isEmpty() {
        return (exchange_keys.length == 0);
    }
    
}

