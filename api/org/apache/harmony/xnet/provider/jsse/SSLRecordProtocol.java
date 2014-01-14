package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import javax.net.ssl.SSLProtocolException;

public class SSLRecordProtocol {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.319 -0500", hash_original_field = "739A2DA6AFC09041ECD05E453896E8F2", hash_generated_field = "87E646BD1D684A2CC2BBDDF46C3B3825")

    protected static final int MAX_DATA_LENGTH = 16384;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.322 -0500", hash_original_field = "5EF24E87087082EF652B10D0F5303664", hash_generated_field = "4B17F799B0589759FBE7EC3C4CC947A3")

    /**
     * Maximum length of allowed compressed data fragment
     * as specified by TLS specification.
     */
    protected static final int MAX_COMPRESSED_DATA_LENGTH
                                    = MAX_DATA_LENGTH + 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.324 -0500", hash_original_field = "8CC483EF2B320C33337E7D5BF6D02850", hash_generated_field = "1C41081ACDECD110402B056E876963B4")

    protected static final int MAX_CIPHERED_DATA_LENGTH
                                    = MAX_COMPRESSED_DATA_LENGTH + 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.327 -0500", hash_original_field = "637E15B1572D864E1CB5E1D4E006C497", hash_generated_field = "9016CFB4E63BFBA851E3F0411B11579B")

    protected static final int MAX_SSL_PACKET_SIZE
                                    = MAX_CIPHERED_DATA_LENGTH + 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.349 -0500", hash_original_field = "17FE222AE9E9EF49F9535FD36A32A5E8", hash_generated_field = "AC695E8CF49911104998F741364CAECF")

    private static final byte[] change_cipher_spec_byte = new byte[] {1};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.329 -0500", hash_original_field = "2FEA9607120FF1F874D7A8B19B248896", hash_generated_field = "14A9356888CCC2F5828130712AD7BEEF")

    private SSLSessionImpl session;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.331 -0500", hash_original_field = "1100ACE58905CA2B2E277C1A3E45DA80", hash_generated_field = "6DD92B23CCB33B5D152D0944DF44FF29")

    private byte[] version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.333 -0500", hash_original_field = "FD3E61735D6C990BB124EC8238A6C4D5", hash_generated_field = "3AE956BBC985F4E127794974EC734E8F")

    private SSLInputStream in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.335 -0500", hash_original_field = "C657785F6A0EDCF13D6ABCC66DA9658A", hash_generated_field = "1032E45BD599BACD8B5F207A3C5A48C0")

    private HandshakeProtocol handshakeProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.338 -0500", hash_original_field = "36D0D0F3C543230F133CC70A25806808", hash_generated_field = "7F98BE8FCC656C783F586E8BC58013DC")

    private AlertProtocol alertProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.340 -0500", hash_original_field = "F13A7DB787CF52F553AA5C1B8E8A4F58", hash_generated_field = "F533AC76CA4BD5C923BAC96FB8431A9D")

    private org.apache.harmony.xnet.provider.jsse.Appendable appData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.357 -0400", hash_original_field = "492C2588B5BE10560BB5ABDF4D815B6E", hash_generated_field = "1F02C7414FAA438A328BE8E1F0311428")

    private ConnectionState activeReadState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.358 -0400", hash_original_field = "4839B2EBC37CDBEEB9D8273FB07187E9", hash_generated_field = "137F21FCE453D326040E0855C91B871E")

    private ConnectionState activeWriteState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.358 -0400", hash_original_field = "FF6B1895B92396394170C04D12D34B7A", hash_generated_field = "EC476235365221866BA37737942327BC")

    private ConnectionState pendingConnectionState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.344 -0500", hash_original_field = "BFF5D5906A6DB8E20D31993F2EC6980D", hash_generated_field = "F03EA0DFE6D87F0203C96C7F0E556215")

    private Logger.Stream logger = Logger.getStream("record");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.347 -0500", hash_original_field = "4A5734CD3C7347313739835DFCE26680", hash_generated_field = "25E0EF9283EF0AA778BE7E7930871797")

    // handshake phase (to distinguish session pending state)
    private boolean sessionWasChanged = false;

    /**
     * Creates an instance of record protocol and tunes
     * up the client protocols to use ut.
     * @param   handshakeProtocol:  HandshakeProtocol
     * @param   alertProtocol:  AlertProtocol
     * @param   in: SSLInputStream
     * @param   appData:    Appendable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.353 -0500", hash_original_method = "0C3980D24E651B574AA14368331D3B6C", hash_generated_method = "1DB559FD55A7FA848028D6B734FFE588")
    
protected SSLRecordProtocol(HandshakeProtocol handshakeProtocol,
            AlertProtocol alertProtocol,
            SSLInputStream in,
            Appendable appData) {
        this.handshakeProtocol = handshakeProtocol;
        this.handshakeProtocol.setRecordProtocol(this);
        this.alertProtocol = alertProtocol;
        this.alertProtocol.setRecordProtocol(this);
        this.in = in;
        this.appData = appData;
    }

    /**
     * Returns the session obtained during the handshake negotiation.
     * If the handshake process was not completed, method returns null.
     * @return the session in effect.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.355 -0500", hash_original_method = "19D70A4F8DD7A34083C18DBEE5C3AF9E", hash_generated_method = "6ACDA15C77445167050F19A88935BFFD")
    
protected SSLSessionImpl getSession() {
        return session;
    }

    /**
     * Returns the minimum possible length of the SSL record.
     * @return
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.357 -0500", hash_original_method = "68629F3A6781EB04D799B3D741A0C393", hash_generated_method = "300582CE1BC2A29F6E2CB9BFCDAC5EA5")
    
protected int getMinRecordSize() {
        return (activeReadState == null)
            ? 6 // type + version + length + 1 byte of data
            : 5 + activeReadState.getMinFragmentSize();
    }

    /**
     * Returns the record length for the specified incoming data length.
     * If actual resulting record length is greater than
     * MAX_CIPHERED_DATA_LENGTH, MAX_CIPHERED_DATA_LENGTH is returned.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.359 -0500", hash_original_method = "96A9B5266C66AFA94D8E0CC291B5F152", hash_generated_method = "2244CC45EFEE7C43C8834B306750DAE2")
    
protected int getRecordSize(int data_size) {
        if (activeWriteState == null) {
            return 5+data_size; // type + version + length + data_size
        } else {
            int res = 5 + activeWriteState.getFragmentSize(data_size);
            return (res > MAX_CIPHERED_DATA_LENGTH)
                ? MAX_CIPHERED_DATA_LENGTH // so the source data should be
                                           // split into several packets
                : res;
        }
    }

    /**
     * Returns the upper bound of length of data containing in the record with
     * specified length.
     * If the provided record_size is greater or equal to
     * MAX_CIPHERED_DATA_LENGTH the returned value will be
     * MAX_DATA_LENGTH
     * counted as for data with
     * MAX_CIPHERED_DATA_LENGTH length.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.361 -0500", hash_original_method = "CC13DBD4825E3C45756D9062D61E5D58", hash_generated_method = "CCC6B5502CDF657DF9F718141A9013EF")
    
protected int getDataSize(int record_size) {
        record_size -= 5; // - (type + version + length + data_size)
        if (record_size > MAX_CIPHERED_DATA_LENGTH) {
            // the data of such size consists of the several packets
            return MAX_DATA_LENGTH;
        }
        if (activeReadState == null) {
            return record_size;
        }
        return activeReadState.getContentSize(record_size);
    }

    /**
     * Depending on the Connection State (Session) encrypts and compress
     * the provided data, and packs it into TLSCiphertext structure.
     * @param   content_type: int
     * @return  ssl packet created over the current connection state
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.363 -0500", hash_original_method = "5F7DF598938706B482CEEA679EFAD91B", hash_generated_method = "DDB4886C9569A5BFEA0E41041AB2060E")
    
protected byte[] wrap(byte content_type, DataStream dataStream) {
        byte[] fragment = dataStream.getData(MAX_DATA_LENGTH);
        return wrap(content_type, fragment, 0, fragment.length);
    }

    /**
     * Depending on the Connection State (Session) encrypts and compress
     * the provided data, and packs it into TLSCiphertext structure.
     * @param   content_type: int
     * @param   fragment: byte[]
     * @return  ssl packet created over the current connection state
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.367 -0500", hash_original_method = "55B5DE87A88F61771BAABFB22C57BC6F", hash_generated_method = "36B9F0D7A47193C22EA48CF954978E17")
    
protected byte[] wrap(byte content_type,
                       byte[] fragment, int offset, int len) {
        if (logger != null) {
            logger.println("SSLRecordProtocol.wrap: TLSPlaintext.fragment["
                    +len+"]:");
            logger.print(fragment, offset, len);
        }
        if (len > MAX_DATA_LENGTH) {
            throw new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLProtocolException(
                    "The provided chunk of data is too big: " + len
                    + " > MAX_DATA_LENGTH == "+MAX_DATA_LENGTH));
        }
        byte[] ciphered_fragment = fragment;
        if (activeWriteState != null) {
            ciphered_fragment =
                activeWriteState.encrypt(content_type, fragment, offset, len);
            if (ciphered_fragment.length > MAX_CIPHERED_DATA_LENGTH) {
                throw new AlertException(
                    AlertProtocol.INTERNAL_ERROR,
                    new SSLProtocolException(
                        "The ciphered data increased more than on 1024 bytes"));
            }
            if (logger != null) {
                logger.println("SSLRecordProtocol.wrap: TLSCiphertext.fragment["
                        +ciphered_fragment.length+"]:");
                logger.print(ciphered_fragment);
            }
        }
        return packetize(content_type, version, ciphered_fragment);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.369 -0500", hash_original_method = "5CCC3748379530494C61DB0E5CDE03DA", hash_generated_method = "2A22C92A3FD80E3D66B40145FCD1B917")
    
private byte[] packetize(byte type, byte[] version, byte[] fragment) {
        byte[] buff = new byte[5+fragment.length];
        buff[0] = type;
        if (version != null) {
            buff[1] = version[0];
            buff[2] = version[1];
        } else {
            buff[1] = 3;
            buff[2] = 1;
        }
        buff[3] = (byte) ((0x00FF00 & fragment.length) >> 8);
        buff[4] = (byte) (0x0000FF & fragment.length);
        System.arraycopy(fragment, 0, buff, 5, fragment.length);
        return buff;
    }

    /**
     * Set the ssl session to be used after sending the changeCipherSpec message
     * @param   session:    SSLSessionImpl
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.372 -0500", hash_original_method = "B29F5DC9A2BE75FFC944D86037256C31", hash_generated_method = "FA2A8EAE8ED72A519E2810F9CA7EBF7C")
    
private void setSession(SSLSessionImpl session) {
        if (!sessionWasChanged) {
            // session was not changed for current handshake process
            if (logger != null) {
                logger.println("SSLRecordProtocol.setSession: Set pending session");
                logger.println("  cipher name: " + session.getCipherSuite());
            }
            this.session = session;
            // create new connection state
            pendingConnectionState = ((version == null) || (version[1] == 1))
                ? (ConnectionState) new ConnectionStateTLS(getSession())
                : (ConnectionState) new ConnectionStateSSLv3(getSession());
            sessionWasChanged = true;
        } else {
            // wait for rehandshaking's session
            sessionWasChanged = false;
        }
    }

    /**
     * Returns the change cipher spec message to be sent to another peer.
     * The pending connection state will be built on the base of provided
     * session object
     * The calling of this method triggers pending write connection state to
     * be active.
     * @return ssl record containing the "change cipher spec" message.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.374 -0500", hash_original_method = "D4A06B5E6BD10843CEED9C48A36D68A3", hash_generated_method = "8A3F8C123134B8F25AA00E0B5C6AA559")
    
protected byte[] getChangeCipherSpecMesage(SSLSessionImpl session) {
        // make change_cipher_spec_message:
        byte[] change_cipher_spec_message;
        if (activeWriteState == null) {
            change_cipher_spec_message = new byte[] {
                    ContentType.CHANGE_CIPHER_SPEC, version[0],
                        version[1], 0, 1, 1
                };
        } else {
            change_cipher_spec_message =
                packetize(ContentType.CHANGE_CIPHER_SPEC, version,
                        activeWriteState.encrypt(ContentType.CHANGE_CIPHER_SPEC,
                            change_cipher_spec_byte, 0, 1));
        }
        setSession(session);
        activeWriteState = pendingConnectionState;
        if (logger != null) {
            logger.println("SSLRecordProtocol.getChangeCipherSpecMesage");
            logger.println("activeWriteState = pendingConnectionState");
            logger.print(change_cipher_spec_message);
        }
        return change_cipher_spec_message;
    }

    /**
     * Retrieves the fragment field of TLSCiphertext, and than
     * depending on the established Connection State
     * decrypts and decompresses it. The following structure is expected
     * on the input at the moment of the call:
     *
     *  struct {
     *      ContentType type;
     *      ProtocolVersion version;
     *      uint16 length;
     *      select (CipherSpec.cipher_type) {
     *          case stream: GenericStreamCipher;
     *          case block: GenericBlockCipher;
     *      } fragment;
     *  } TLSCiphertext;
     *
     * (as specified by RFC 2246, TLS v1 Protocol specification)
     *
     * In addition this method can recognize SSLv2 hello message which
     * are often used to establish the SSL/TLS session.
     *
     * @throws IOException if some io errors have been occurred
     * @throws EndOfSourceException if underlying input stream
     *                              has ran out of data.
     * @throws EndOfBufferException if there was not enough data
     *                              to build complete ssl packet.
     * @return the type of unwrapped message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.378 -0500", hash_original_method = "B39FD616EE504B12CB9E5F46F7A6A390", hash_generated_method = "42E2C04CD5150C1C72712478B68A54F2")
    
protected int unwrap() throws IOException {
        if (logger != null) {
            logger.println("SSLRecordProtocol.unwrap: BEGIN [");
        }
        int type = in.readUint8();
        if ((type < ContentType.CHANGE_CIPHER_SPEC)
                || (type > ContentType.APPLICATION_DATA)) {
            if (logger != null) {
                logger.println("Non v3.1 message type:" + type);
            }
            if (type >= 0x80) {
                // it is probably SSL v2 client_hello message
                // (see SSL v2 spec at:
                // http://wp.netscape.com/eng/security/SSL_2.html)
                int length = (type & 0x7f) << 8 | in.read();
                byte[] fragment = in.read(length);
                handshakeProtocol.unwrapSSLv2(fragment);
                if (logger != null) {
                    logger.println(
                            "SSLRecordProtocol:unwrap ] END, SSLv2 type");
                }
                return ContentType.HANDSHAKE;
            }
            throw new AlertException(AlertProtocol.UNEXPECTED_MESSAGE,
                    new SSLProtocolException(
                        "Unexpected message type has been received: "+type));
        }
        if (logger != null) {
            logger.println("Got the message of type: " + type);
        }
        if (version != null) {
            if ((in.read() != version[0])
                    || (in.read() != version[1])) {
                throw new AlertException(AlertProtocol.UNEXPECTED_MESSAGE,
                        new SSLProtocolException(
                            "Unexpected message type has been received: " +
                            type));
            }
        } else {
            in.skip(2); // just skip the version number
        }
        int length = in.readUint16();
        if (logger != null) {
            logger.println("TLSCiphertext.fragment["+length+"]: ...");
        }
        if (length > MAX_CIPHERED_DATA_LENGTH) {
            throw new AlertException(AlertProtocol.RECORD_OVERFLOW,
                    new SSLProtocolException(
                        "Received message is too big."));
        }
        byte[] fragment = in.read(length);
        if (logger != null) {
            logger.print(fragment);
        }
        if (activeReadState != null) {
            fragment = activeReadState.decrypt((byte) type, fragment);
            if (logger != null) {
                logger.println("TLSPlaintext.fragment:");
                logger.print(fragment);
            }
        }
        if (fragment.length > MAX_DATA_LENGTH) {
            throw new AlertException(AlertProtocol.DECOMPRESSION_FAILURE,
                    new SSLProtocolException(
                        "Decompressed plain data is too big."));
        }
        switch (type) {
            case ContentType.CHANGE_CIPHER_SPEC:
                // notify handshake protocol:
                handshakeProtocol.receiveChangeCipherSpec();
                setSession(handshakeProtocol.getSession());
                // change cipher spec message has been received, so:
                if (logger != null) {
                    logger.println("activeReadState = pendingConnectionState");
                }
                activeReadState = pendingConnectionState;
                break;
            case ContentType.ALERT:
                alert(fragment[0], fragment[1]);
                break;
            case ContentType.HANDSHAKE:
                handshakeProtocol.unwrap(fragment);
                break;
            case ContentType.APPLICATION_DATA:
                if (logger != null) {
                    logger.println(
                            "TLSCiphertext.unwrap: APP DATA["+length+"]:");
                    logger.println(new String(fragment));
                }
                appData.append(fragment);
                break;
            default:
                throw new AlertException(AlertProtocol.UNEXPECTED_MESSAGE,
                        new SSLProtocolException(
                            "Unexpected message type has been received: " +
                            type));
        }
        if (logger != null) {
            logger.println("SSLRecordProtocol:unwrap ] END, type: " + type);
        }
        return type;
    }

    /**
     * Passes the alert information to the alert protocol.
     * @param   level:  byte
     * @param   description:    byte
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.381 -0500", hash_original_method = "23FCA30C77438F833B36A8A9B6CBC6CC", hash_generated_method = "5BF51B9D756AC66CA74ED0E535DA5717")
    
protected void alert(byte level, byte description) {
        if (logger != null) {
            logger.println("SSLRecordProtocol.allert: "+level+" "+description);
        }
        alertProtocol.alert(level, description);
    }

    /**
     * Sets up the SSL version used in this connection.
     * This method is calling from the handshake protocol after
     * it becomes known witch protocol version will be used.
     * @param   ver:    byte[]
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.384 -0500", hash_original_method = "DE69782F4CD99CC5C5DEED4E3A6B9F4E", hash_generated_method = "BF804C669D7ECB279B2E41666733DC04")
    
protected void setVersion(byte[] ver) {
        this.version = ver;
    }

    /**
     * Shuts down the protocol. It will be impossible to use the instance
     * after the calling of this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.386 -0500", hash_original_method = "C2A186E08A6901259D50AE521996EDF2", hash_generated_method = "BCC9369DD1AC7B1C7E7AAADD8CD3AEF2")
    
protected void shutdown() {
        session = null;
        version = null;
        in = null;
        handshakeProtocol = null;
        alertProtocol = null;
        appData = null;
        if (pendingConnectionState != null) {
            pendingConnectionState.shutdown();
        }
        pendingConnectionState = null;
        if (activeReadState != null) {
            activeReadState.shutdown();
        }
        activeReadState = null;
        if (activeReadState != null) {
            activeReadState.shutdown();
        }
        activeWriteState = null;
    }
}

