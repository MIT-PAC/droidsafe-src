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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.874 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "14A9356888CCC2F5828130712AD7BEEF")

    private SSLSessionImpl session;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.874 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "6DD92B23CCB33B5D152D0944DF44FF29")

    private byte[] version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.874 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "3AE956BBC985F4E127794974EC734E8F")

    private SSLInputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.874 -0400", hash_original_field = "C8D4E1C676644CE99FCC63554749D588", hash_generated_field = "1032E45BD599BACD8B5F207A3C5A48C0")

    private HandshakeProtocol handshakeProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.874 -0400", hash_original_field = "81D2B0D9B2A75D6611E459D125528CA5", hash_generated_field = "7F98BE8FCC656C783F586E8BC58013DC")

    private AlertProtocol alertProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.874 -0400", hash_original_field = "78DC08180DEB6EFF54F49C04C6F3038B", hash_generated_field = "F533AC76CA4BD5C923BAC96FB8431A9D")

    private org.apache.harmony.xnet.provider.jsse.Appendable appData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.874 -0400", hash_original_field = "492C2588B5BE10560BB5ABDF4D815B6E", hash_generated_field = "1F02C7414FAA438A328BE8E1F0311428")

    private ConnectionState activeReadState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.874 -0400", hash_original_field = "4839B2EBC37CDBEEB9D8273FB07187E9", hash_generated_field = "137F21FCE453D326040E0855C91B871E")

    private ConnectionState activeWriteState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.874 -0400", hash_original_field = "FF6B1895B92396394170C04D12D34B7A", hash_generated_field = "EC476235365221866BA37737942327BC")

    private ConnectionState pendingConnectionState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.874 -0400", hash_original_field = "0331443B4F3BFCC0450B177995E0D495", hash_generated_field = "F03EA0DFE6D87F0203C96C7F0E556215")

    private Logger.Stream logger = Logger.getStream("record");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.874 -0400", hash_original_field = "7B807C97ABEF724846709B0A1E8B978C", hash_generated_field = "8B7E0BFDFF53159DB491167D7A53BB75")

    private boolean sessionWasChanged = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.875 -0400", hash_original_method = "0C3980D24E651B574AA14368331D3B6C", hash_generated_method = "8E358A1C35371391D0DCB7A6D780AE7A")
    protected  SSLRecordProtocol(HandshakeProtocol handshakeProtocol,
            AlertProtocol alertProtocol,
            SSLInputStream in,
            Appendable appData) {
        this.handshakeProtocol = handshakeProtocol;
        this.handshakeProtocol.setRecordProtocol(this);
        this.alertProtocol = alertProtocol;
        this.alertProtocol.setRecordProtocol(this);
        this.in = in;
        this.appData = appData;
        // ---------- Original Method ----------
        //this.handshakeProtocol = handshakeProtocol;
        //this.handshakeProtocol.setRecordProtocol(this);
        //this.alertProtocol = alertProtocol;
        //this.alertProtocol.setRecordProtocol(this);
        //this.in = in;
        //this.appData = appData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.875 -0400", hash_original_method = "19D70A4F8DD7A34083C18DBEE5C3AF9E", hash_generated_method = "B12ED7FC75CC5D30025E2395CDA42B81")
    protected SSLSessionImpl getSession() {
        SSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_725349344 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_725349344 = session;
        varB4EAC82CA7396A68D541C85D26508E83_725349344.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_725349344;
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.876 -0400", hash_original_method = "68629F3A6781EB04D799B3D741A0C393", hash_generated_method = "9565154BA8A14A45C15D1E5E86EC8200")
    protected int getMinRecordSize() {
        {
            Object var505350AD6118074BE5ECC8503E31BF74_1991806118 = (5 + activeReadState.getMinFragmentSize());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1299592508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1299592508;
        // ---------- Original Method ----------
        //return (activeReadState == null)
            //? 6 
            //: 5 + activeReadState.getMinFragmentSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.876 -0400", hash_original_method = "96A9B5266C66AFA94D8E0CC291B5F152", hash_generated_method = "160F5962C9C134706A9A985A66BC02B7")
    protected int getRecordSize(int data_size) {
        {
            int res = 5 + activeWriteState.getFragmentSize(data_size);
        } //End block
        addTaint(data_size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634872921 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634872921;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.876 -0400", hash_original_method = "CC13DBD4825E3C45756D9062D61E5D58", hash_generated_method = "83C241457D5BFCBB59A2401387627885")
    protected int getDataSize(int record_size) {
        record_size -= 5;
        int varCD18B37507D94F9A61BD0EF2FD091149_616046922 = (activeReadState.getContentSize(record_size));
        addTaint(record_size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1326900766 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1326900766;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.877 -0400", hash_original_method = "5F7DF598938706B482CEEA679EFAD91B", hash_generated_method = "B193A5329B76E596E30CCC0FF05D39C5")
    protected byte[] wrap(byte content_type, DataStream dataStream) {
        byte[] fragment = dataStream.getData(MAX_DATA_LENGTH);
        byte[] var523CFFE143885B906D3AD3CA7379BAEA_236594114 = (wrap(content_type, fragment, 0, fragment.length));
        addTaint(content_type);
        addTaint(dataStream.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_167451255 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_167451255;
        // ---------- Original Method ----------
        //byte[] fragment = dataStream.getData(MAX_DATA_LENGTH);
        //return wrap(content_type, fragment, 0, fragment.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.877 -0400", hash_original_method = "55B5DE87A88F61771BAABFB22C57BC6F", hash_generated_method = "E999EFFBDAE0BBE095F8662B36EA458D")
    protected byte[] wrap(byte content_type,
                       byte[] fragment, int offset, int len) {
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
        byte[] ciphered_fragment = fragment;
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
        byte[] var77EE147AD9DB1173D485204C6379E00F_1192286643 = (packetize(content_type, version, ciphered_fragment));
        addTaint(content_type);
        addTaint(fragment[0]);
        addTaint(offset);
        addTaint(len);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_705857689 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_705857689;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.878 -0400", hash_original_method = "5CCC3748379530494C61DB0E5CDE03DA", hash_generated_method = "B2A94CBBD5DE2CB2DE1A18A1695BBC46")
    private byte[] packetize(byte type, byte[] version, byte[] fragment) {
        byte[] buff = new byte[5+fragment.length];
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
        addTaint(type);
        addTaint(version[0]);
        addTaint(fragment[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1094646625 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1094646625;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.879 -0400", hash_original_method = "B29F5DC9A2BE75FFC944D86037256C31", hash_generated_method = "9F2179F09C840CFC2559E4979A9E0B18")
    private void setSession(SSLSessionImpl session) {
        {
            {
                logger.println("SSLRecordProtocol.setSession: Set pending session");
                logger.println("  cipher name: " + session.getCipherSuite());
            } //End block
            this.session = session;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.880 -0400", hash_original_method = "D4A06B5E6BD10843CEED9C48A36D68A3", hash_generated_method = "1DD7FD2DA974B6B2124EF00433041EA3")
    protected byte[] getChangeCipherSpecMesage(SSLSessionImpl session) {
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
        addTaint(session.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1927352834 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1927352834;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.881 -0400", hash_original_method = "B39FD616EE504B12CB9E5F46F7A6A390", hash_generated_method = "30331C56024D3B983CD51BF7896A7E6B")
    protected int unwrap() throws IOException {
        {
            logger.println("SSLRecordProtocol.unwrap: BEGIN [");
        } //End block
        int type = in.readUint8();
        {
            {
                logger.println("Non v3.1 message type:" + type);
            } //End block
            {
                int length = (type & 0x7f) << 8 | in.read();
                byte[] fragment = in.read(length);
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
                boolean var9CF95A232BA82F79CB810CB1B32E147E_612577846 = ((in.read() != version[0])
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
        int length = in.readUint16();
        {
            logger.println("TLSCiphertext.fragment["+length+"]: ...");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.RECORD_OVERFLOW,
                    new SSLProtocolException(
                        "Received message is too big."));
        } //End block
        byte[] fragment = in.read(length);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121057752 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121057752;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.881 -0400", hash_original_method = "23FCA30C77438F833B36A8A9B6CBC6CC", hash_generated_method = "E553C8CAAE28E710497AA3EFD3CE4744")
    protected void alert(byte level, byte description) {
        {
            logger.println("SSLRecordProtocol.allert: "+level+" "+description);
        } //End block
        alertProtocol.alert(level, description);
        addTaint(level);
        addTaint(description);
        // ---------- Original Method ----------
        //if (logger != null) {
            //logger.println("SSLRecordProtocol.allert: "+level+" "+description);
        //}
        //alertProtocol.alert(level, description);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.882 -0400", hash_original_method = "DE69782F4CD99CC5C5DEED4E3A6B9F4E", hash_generated_method = "8F61383BC58CF2000382CEE86F416B66")
    protected void setVersion(byte[] ver) {
        this.version = ver;
        // ---------- Original Method ----------
        //this.version = ver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.882 -0400", hash_original_method = "C2A186E08A6901259D50AE521996EDF2", hash_generated_method = "8EEA8EEB165B1F35525BBB964D9E2AAC")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.882 -0400", hash_original_field = "2F53C2EC19FA8EB5A61C955030F7DAED", hash_generated_field = "87E646BD1D684A2CC2BBDDF46C3B3825")

    protected static final int MAX_DATA_LENGTH = 16384;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.882 -0400", hash_original_field = "433F5FE41C89EA5482842965B42C377B", hash_generated_field = "3DC0909702566A0C923D7A0BA9FB1C56")

    protected static final int MAX_COMPRESSED_DATA_LENGTH = MAX_DATA_LENGTH + 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.882 -0400", hash_original_field = "29055D55024B276B805A05C081EABC3A", hash_generated_field = "1C41081ACDECD110402B056E876963B4")

    protected static final int MAX_CIPHERED_DATA_LENGTH = MAX_COMPRESSED_DATA_LENGTH + 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.882 -0400", hash_original_field = "981AA91818695414A8120138160931CF", hash_generated_field = "9016CFB4E63BFBA851E3F0411B11579B")

    protected static final int MAX_SSL_PACKET_SIZE = MAX_CIPHERED_DATA_LENGTH + 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.882 -0400", hash_original_field = "74310ADA5A45CE0369BE9A6992B9BE5B", hash_generated_field = "AC695E8CF49911104998F741364CAECF")

    private static final byte[] change_cipher_spec_byte = new byte[] {1};
}

