package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import javax.net.ssl.SSLProtocolException;

public class SSLRecordProtocol {
    private SSLSessionImpl session;
    private byte[] version;
    private SSLInputStream in;
    private HandshakeProtocol handshakeProtocol;
    private AlertProtocol alertProtocol;
    private org.apache.harmony.xnet.provider.jsse.Appendable appData;
    private ConnectionState
        activeReadState, activeWriteState, pendingConnectionState;
    private Logger.Stream logger = Logger.getStream("record");
    private boolean sessionWasChanged = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.165 -0400", hash_original_method = "0C3980D24E651B574AA14368331D3B6C", hash_generated_method = "746BA92193988C8B2DCEF0A522D55852")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLRecordProtocol(HandshakeProtocol handshakeProtocol,
            AlertProtocol alertProtocol,
            SSLInputStream in,
            Appendable appData) {
        dsTaint.addTaint(appData.dsTaint);
        dsTaint.addTaint(alertProtocol.dsTaint);
        dsTaint.addTaint(in.dsTaint);
        dsTaint.addTaint(handshakeProtocol.dsTaint);
        this.handshakeProtocol.setRecordProtocol(this);
        this.alertProtocol.setRecordProtocol(this);
        // ---------- Original Method ----------
        //this.handshakeProtocol = handshakeProtocol;
        //this.handshakeProtocol.setRecordProtocol(this);
        //this.alertProtocol = alertProtocol;
        //this.alertProtocol.setRecordProtocol(this);
        //this.in = in;
        //this.appData = appData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.165 -0400", hash_original_method = "19D70A4F8DD7A34083C18DBEE5C3AF9E", hash_generated_method = "767EE2367A275020243BC9793E83860F")
    @DSModeled(DSC.SAFE)
    protected SSLSessionImpl getSession() {
        return (SSLSessionImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.166 -0400", hash_original_method = "68629F3A6781EB04D799B3D741A0C393", hash_generated_method = "48C9C509B8B14B1660A82BE7EB9656F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getMinRecordSize() {
        {
            Object var505350AD6118074BE5ECC8503E31BF74_1995328864 = (5 + activeReadState.getMinFragmentSize());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (activeReadState == null)
            //? 6 
            //: 5 + activeReadState.getMinFragmentSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.166 -0400", hash_original_method = "96A9B5266C66AFA94D8E0CC291B5F152", hash_generated_method = "29A61F92E4B691A7E1CF4CC0EBF0C219")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getRecordSize(int data_size) {
        dsTaint.addTaint(data_size);
        {
            int res;
            res = 5 + activeWriteState.getFragmentSize(data_size);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (activeWriteState == null) {
            //return 5+data_size; 
        //} else {
            //int res = 5 + activeWriteState.getFragmentSize(data_size);
            //return (res > MAX_CIPHERED_DATA_LENGTH)
                //? MAX_CIPHERED_DATA_LENGTH 
                //: res;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.166 -0400", hash_original_method = "CC13DBD4825E3C45756D9062D61E5D58", hash_generated_method = "00B67FD1A2D46FF0EA43B6D5B69B3C20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getDataSize(int record_size) {
        dsTaint.addTaint(record_size);
        record_size -= 5;
        int varCD18B37507D94F9A61BD0EF2FD091149_237851467 = (activeReadState.getContentSize(record_size));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //record_size -= 5;
        //if (record_size > MAX_CIPHERED_DATA_LENGTH) {
            //return MAX_DATA_LENGTH;
        //}
        //if (activeReadState == null) {
            //return record_size;
        //}
        //return activeReadState.getContentSize(record_size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.166 -0400", hash_original_method = "5F7DF598938706B482CEEA679EFAD91B", hash_generated_method = "FE3707078C1EEED237DA19524AD93367")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] wrap(byte content_type, DataStream dataStream) {
        dsTaint.addTaint(content_type);
        dsTaint.addTaint(dataStream.dsTaint);
        byte[] fragment;
        fragment = dataStream.getData(MAX_DATA_LENGTH);
        byte[] var523CFFE143885B906D3AD3CA7379BAEA_170495875 = (wrap(content_type, fragment, 0, fragment.length));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] fragment = dataStream.getData(MAX_DATA_LENGTH);
        //return wrap(content_type, fragment, 0, fragment.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.167 -0400", hash_original_method = "55B5DE87A88F61771BAABFB22C57BC6F", hash_generated_method = "08F8B6E23E5C33C078C5A4620BB01592")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] wrap(byte content_type,
                       byte[] fragment, int offset, int len) {
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fragment[0]);
        dsTaint.addTaint(content_type);
        {
            logger.println("SSLRecordProtocol.wrap: TLSPlaintext.fragment["
                    +len+"]:");
            logger.print(fragment, offset, len);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLProtocolException(
                    "The provided chunk of data is too big: " + len
                    + " > MAX_DATA_LENGTH == "+MAX_DATA_LENGTH));
        } //End block
        byte[] ciphered_fragment;
        ciphered_fragment = fragment;
        {
            ciphered_fragment =
                activeWriteState.encrypt(content_type, fragment, offset, len);
            {
                if (DroidSafeAndroidRuntime.control) throw new AlertException(
                    AlertProtocol.INTERNAL_ERROR,
                    new SSLProtocolException(
                        "The ciphered data increased more than on 1024 bytes"));
            } //End block
            {
                logger.println("SSLRecordProtocol.wrap: TLSCiphertext.fragment["
                        +ciphered_fragment.length+"]:");
                logger.print(ciphered_fragment);
            } //End block
        } //End block
        byte[] var77EE147AD9DB1173D485204C6379E00F_2134542369 = (packetize(content_type, version, ciphered_fragment));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.167 -0400", hash_original_method = "5CCC3748379530494C61DB0E5CDE03DA", hash_generated_method = "5FD6C15E32C1E44122ACAFCEC8B46FD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] packetize(byte type, byte[] version, byte[] fragment) {
        dsTaint.addTaint(type);
        dsTaint.addTaint(fragment[0]);
        dsTaint.addTaint(version[0]);
        byte[] buff;
        buff = new byte[5+fragment.length];
        buff[0] = type;
        {
            buff[1] = version[0];
            buff[2] = version[1];
        } //End block
        {
            buff[1] = 3;
            buff[2] = 1;
        } //End block
        buff[3] = (byte) ((0x00FF00 & fragment.length) >> 8);
        buff[4] = (byte) (0x0000FF & fragment.length);
        System.arraycopy(fragment, 0, buff, 5, fragment.length);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] buff = new byte[5+fragment.length];
        //buff[0] = type;
        //if (version != null) {
            //buff[1] = version[0];
            //buff[2] = version[1];
        //} else {
            //buff[1] = 3;
            //buff[2] = 1;
        //}
        //buff[3] = (byte) ((0x00FF00 & fragment.length) >> 8);
        //buff[4] = (byte) (0x0000FF & fragment.length);
        //System.arraycopy(fragment, 0, buff, 5, fragment.length);
        //return buff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.168 -0400", hash_original_method = "B29F5DC9A2BE75FFC944D86037256C31", hash_generated_method = "4244DDB807FA137E5B076CD80B0709B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setSession(SSLSessionImpl session) {
        dsTaint.addTaint(session.dsTaint);
        {
            {
                logger.println("SSLRecordProtocol.setSession: Set pending session");
                logger.println("  cipher name: " + session.getCipherSuite());
            } //End block
            pendingConnectionState = ((version == null) || (version[1] == 1))
                ? (ConnectionState) new ConnectionStateTLS(getSession())
                : (ConnectionState) new ConnectionStateSSLv3(getSession());
            sessionWasChanged = true;
        } //End block
        {
            sessionWasChanged = false;
        } //End block
        // ---------- Original Method ----------
        //if (!sessionWasChanged) {
            //if (logger != null) {
                //logger.println("SSLRecordProtocol.setSession: Set pending session");
                //logger.println("  cipher name: " + session.getCipherSuite());
            //}
            //this.session = session;
            //pendingConnectionState = ((version == null) || (version[1] == 1))
                //? (ConnectionState) new ConnectionStateTLS(getSession())
                //: (ConnectionState) new ConnectionStateSSLv3(getSession());
            //sessionWasChanged = true;
        //} else {
            //sessionWasChanged = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.168 -0400", hash_original_method = "D4A06B5E6BD10843CEED9C48A36D68A3", hash_generated_method = "8E7970DD3C3DE9FB4F324B4CF9E6E59B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] getChangeCipherSpecMesage(SSLSessionImpl session) {
        dsTaint.addTaint(session.dsTaint);
        byte[] change_cipher_spec_message;
        {
            change_cipher_spec_message = new byte[] {
                    ContentType.CHANGE_CIPHER_SPEC, version[0],
                        version[1], 0, 1, 1
                };
        } //End block
        {
            change_cipher_spec_message =
                packetize(ContentType.CHANGE_CIPHER_SPEC, version,
                        activeWriteState.encrypt(ContentType.CHANGE_CIPHER_SPEC,
                            change_cipher_spec_byte, 0, 1));
        } //End block
        setSession(session);
        activeWriteState = pendingConnectionState;
        {
            logger.println("SSLRecordProtocol.getChangeCipherSpecMesage");
            logger.println("activeWriteState = pendingConnectionState");
            logger.print(change_cipher_spec_message);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.169 -0400", hash_original_method = "B39FD616EE504B12CB9E5F46F7A6A390", hash_generated_method = "061F581A8E5BB4FD85D6298CB7E371A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int unwrap() throws IOException {
        {
            logger.println("SSLRecordProtocol.unwrap: BEGIN [");
        } //End block
        int type;
        type = in.readUint8();
        {
            {
                logger.println("Non v3.1 message type:" + type);
            } //End block
            {
                int length;
                length = (type & 0x7f) << 8 | in.read();
                byte[] fragment;
                fragment = in.read(length);
                handshakeProtocol.unwrapSSLv2(fragment);
                {
                    logger.println(
                            "SSLRecordProtocol:unwrap ] END, SSLv2 type");
                } //End block
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.UNEXPECTED_MESSAGE,
                    new SSLProtocolException(
                        "Unexpected message type has been received: "+type));
        } //End block
        {
            logger.println("Got the message of type: " + type);
        } //End block
        {
            {
                boolean var9CF95A232BA82F79CB810CB1B32E147E_1008233840 = ((in.read() != version[0])
                    || (in.read() != version[1]));
                {
                    if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.UNEXPECTED_MESSAGE,
                        new SSLProtocolException(
                            "Unexpected message type has been received: " +
                            type));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            in.skip(2);
        } //End block
        int length;
        length = in.readUint16();
        {
            logger.println("TLSCiphertext.fragment["+length+"]: ...");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.RECORD_OVERFLOW,
                    new SSLProtocolException(
                        "Received message is too big."));
        } //End block
        byte[] fragment;
        fragment = in.read(length);
        {
            logger.print(fragment);
        } //End block
        {
            fragment = activeReadState.decrypt((byte) type, fragment);
            {
                logger.println("TLSPlaintext.fragment:");
                logger.print(fragment);
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.DECOMPRESSION_FAILURE,
                    new SSLProtocolException(
                        "Decompressed plain data is too big."));
        } //End block
        //Begin case ContentType.CHANGE_CIPHER_SPEC 
        handshakeProtocol.receiveChangeCipherSpec();
        //End case ContentType.CHANGE_CIPHER_SPEC 
        //Begin case ContentType.CHANGE_CIPHER_SPEC 
        setSession(handshakeProtocol.getSession());
        //End case ContentType.CHANGE_CIPHER_SPEC 
        //Begin case ContentType.CHANGE_CIPHER_SPEC 
        {
            logger.println("activeReadState = pendingConnectionState");
        } //End block
        //End case ContentType.CHANGE_CIPHER_SPEC 
        //Begin case ContentType.CHANGE_CIPHER_SPEC 
        activeReadState = pendingConnectionState;
        //End case ContentType.CHANGE_CIPHER_SPEC 
        //Begin case ContentType.ALERT 
        alert(fragment[0], fragment[1]);
        //End case ContentType.ALERT 
        //Begin case ContentType.HANDSHAKE 
        handshakeProtocol.unwrap(fragment);
        //End case ContentType.HANDSHAKE 
        //Begin case ContentType.APPLICATION_DATA 
        {
            logger.println(
                            "TLSCiphertext.unwrap: APP DATA["+length+"]:");
            logger.println(new String(fragment));
        } //End block
        //End case ContentType.APPLICATION_DATA 
        //Begin case ContentType.APPLICATION_DATA 
        appData.append(fragment);
        //End case ContentType.APPLICATION_DATA 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.UNEXPECTED_MESSAGE,
                        new SSLProtocolException(
                            "Unexpected message type has been received: " +
                            type));
        //End case default 
        {
            logger.println("SSLRecordProtocol:unwrap ] END, type: " + type);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.169 -0400", hash_original_method = "23FCA30C77438F833B36A8A9B6CBC6CC", hash_generated_method = "6C078C664BC7A6261864404374B5605E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void alert(byte level, byte description) {
        dsTaint.addTaint(level);
        dsTaint.addTaint(description);
        {
            logger.println("SSLRecordProtocol.allert: "+level+" "+description);
        } //End block
        alertProtocol.alert(level, description);
        // ---------- Original Method ----------
        //if (logger != null) {
            //logger.println("SSLRecordProtocol.allert: "+level+" "+description);
        //}
        //alertProtocol.alert(level, description);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.170 -0400", hash_original_method = "DE69782F4CD99CC5C5DEED4E3A6B9F4E", hash_generated_method = "32827E76F25C403E78F75BF7EFFD8077")
    @DSModeled(DSC.SAFE)
    protected void setVersion(byte[] ver) {
        dsTaint.addTaint(ver[0]);
        // ---------- Original Method ----------
        //this.version = ver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.170 -0400", hash_original_method = "C2A186E08A6901259D50AE521996EDF2", hash_generated_method = "8EEA8EEB165B1F35525BBB964D9E2AAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void shutdown() {
        session = null;
        version = null;
        in = null;
        handshakeProtocol = null;
        alertProtocol = null;
        appData = null;
        {
            pendingConnectionState.shutdown();
        } //End block
        pendingConnectionState = null;
        {
            activeReadState.shutdown();
        } //End block
        activeReadState = null;
        {
            activeReadState.shutdown();
        } //End block
        activeWriteState = null;
        // ---------- Original Method ----------
        //session = null;
        //version = null;
        //in = null;
        //handshakeProtocol = null;
        //alertProtocol = null;
        //appData = null;
        //if (pendingConnectionState != null) {
            //pendingConnectionState.shutdown();
        //}
        //pendingConnectionState = null;
        //if (activeReadState != null) {
            //activeReadState.shutdown();
        //}
        //activeReadState = null;
        //if (activeReadState != null) {
            //activeReadState.shutdown();
        //}
        //activeWriteState = null;
    }

    
    protected static final int MAX_DATA_LENGTH = 16384;
    protected static final int MAX_COMPRESSED_DATA_LENGTH
                                    = MAX_DATA_LENGTH + 1024;
    protected static final int MAX_CIPHERED_DATA_LENGTH
                                    = MAX_COMPRESSED_DATA_LENGTH + 1024;
    protected static final int MAX_SSL_PACKET_SIZE
                                    = MAX_CIPHERED_DATA_LENGTH + 5;
    private static final byte[] change_cipher_spec_byte = new byte[] {1};
}

