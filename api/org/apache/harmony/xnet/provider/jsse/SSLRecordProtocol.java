package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import javax.net.ssl.SSLProtocolException;

public class SSLRecordProtocol {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.357 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "14A9356888CCC2F5828130712AD7BEEF")

    private SSLSessionImpl session;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.357 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "6DD92B23CCB33B5D152D0944DF44FF29")

    private byte[] version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.357 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "3AE956BBC985F4E127794974EC734E8F")

    private SSLInputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.357 -0400", hash_original_field = "C8D4E1C676644CE99FCC63554749D588", hash_generated_field = "1032E45BD599BACD8B5F207A3C5A48C0")

    private HandshakeProtocol handshakeProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.357 -0400", hash_original_field = "81D2B0D9B2A75D6611E459D125528CA5", hash_generated_field = "7F98BE8FCC656C783F586E8BC58013DC")

    private AlertProtocol alertProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.357 -0400", hash_original_field = "78DC08180DEB6EFF54F49C04C6F3038B", hash_generated_field = "F533AC76CA4BD5C923BAC96FB8431A9D")

    private org.apache.harmony.xnet.provider.jsse.Appendable appData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.357 -0400", hash_original_field = "492C2588B5BE10560BB5ABDF4D815B6E", hash_generated_field = "1F02C7414FAA438A328BE8E1F0311428")

    private ConnectionState activeReadState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.358 -0400", hash_original_field = "4839B2EBC37CDBEEB9D8273FB07187E9", hash_generated_field = "137F21FCE453D326040E0855C91B871E")

    private ConnectionState activeWriteState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.358 -0400", hash_original_field = "FF6B1895B92396394170C04D12D34B7A", hash_generated_field = "EC476235365221866BA37737942327BC")

    private ConnectionState pendingConnectionState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.358 -0400", hash_original_field = "0331443B4F3BFCC0450B177995E0D495", hash_generated_field = "F03EA0DFE6D87F0203C96C7F0E556215")

    private Logger.Stream logger = Logger.getStream("record");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.358 -0400", hash_original_field = "7B807C97ABEF724846709B0A1E8B978C", hash_generated_field = "8B7E0BFDFF53159DB491167D7A53BB75")

    private boolean sessionWasChanged = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.359 -0400", hash_original_method = "0C3980D24E651B574AA14368331D3B6C", hash_generated_method = "8E358A1C35371391D0DCB7A6D780AE7A")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.359 -0400", hash_original_method = "19D70A4F8DD7A34083C18DBEE5C3AF9E", hash_generated_method = "E0FD80BB4DF1DCE8F544E23DDD5E2E58")
    protected SSLSessionImpl getSession() {
SSLSessionImpl varD555E544A66E0F97DA6BCDE940E3E79C_1184358427 =         session;
        varD555E544A66E0F97DA6BCDE940E3E79C_1184358427.addTaint(taint);
        return varD555E544A66E0F97DA6BCDE940E3E79C_1184358427;
        // ---------- Original Method ----------
        //return session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.360 -0400", hash_original_method = "68629F3A6781EB04D799B3D741A0C393", hash_generated_method = "56C2EC2C42CC56189BC96A15F2C16FD1")
    protected int getMinRecordSize() {
        int varAFB060BEF18D1D15523C07EFD6FFBA71_669388080 = ((activeReadState == null)
            ? 6 
            : 5 + activeReadState.getMinFragmentSize());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588722604 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588722604;
        // ---------- Original Method ----------
        //return (activeReadState == null)
            //? 6 
            //: 5 + activeReadState.getMinFragmentSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.360 -0400", hash_original_method = "96A9B5266C66AFA94D8E0CC291B5F152", hash_generated_method = "0331F2D532CAC71A4D7618492BE54471")
    protected int getRecordSize(int data_size) {
        addTaint(data_size);
        if(activeWriteState == null)        
        {
            int var239CE55A5AE9BDD83798F7C4033F7869_800880639 = (5+data_size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333888669 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333888669;
        } //End block
        else
        {
            int res = 5 + activeWriteState.getFragmentSize(data_size);
            int varA5B77233DCA64F929AF4A89A7E96820F_1679860596 = ((res > MAX_CIPHERED_DATA_LENGTH)
                ? MAX_CIPHERED_DATA_LENGTH 
                : res);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325568131 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325568131;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.361 -0400", hash_original_method = "CC13DBD4825E3C45756D9062D61E5D58", hash_generated_method = "88FA7EDA0BBF868D66186EEA3D1887DE")
    protected int getDataSize(int record_size) {
        addTaint(record_size);
        record_size -= 5;
        if(record_size > MAX_CIPHERED_DATA_LENGTH)        
        {
            int varC2E6165532CF4FFAEB702006BA2AB3A9_2092545653 = (MAX_DATA_LENGTH);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882202177 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882202177;
        } //End block
        if(activeReadState == null)        
        {
            int varE77ED5820E231418AE62BDD254429D27_1024810708 = (record_size);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006207208 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006207208;
        } //End block
        int var5856C8FCCA560CBE844D87CBDAA00F35_1291832964 = (activeReadState.getContentSize(record_size));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647565772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647565772;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.361 -0400", hash_original_method = "5F7DF598938706B482CEEA679EFAD91B", hash_generated_method = "4C3097790A77CD13B42D19B9BDDE2739")
    protected byte[] wrap(byte content_type, DataStream dataStream) {
        addTaint(dataStream.getTaint());
        addTaint(content_type);
        byte[] fragment = dataStream.getData(MAX_DATA_LENGTH);
        byte[] var2519B23D0F73BF8C42649E975474F591_1398821640 = (wrap(content_type, fragment, 0, fragment.length));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1235276452 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1235276452;
        // ---------- Original Method ----------
        //byte[] fragment = dataStream.getData(MAX_DATA_LENGTH);
        //return wrap(content_type, fragment, 0, fragment.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.363 -0400", hash_original_method = "55B5DE87A88F61771BAABFB22C57BC6F", hash_generated_method = "276B9430DEA72C4AD3AD25FEC2BB4CE5")
    protected byte[] wrap(byte content_type,
                       byte[] fragment, int offset, int len) {
        addTaint(len);
        addTaint(offset);
        addTaint(fragment[0]);
        addTaint(content_type);
        if(logger != null)        
        {
            logger.println("SSLRecordProtocol.wrap: TLSPlaintext.fragment["
                    +len+"]:");
            logger.print(fragment, offset, len);
        } //End block
        if(len > MAX_DATA_LENGTH)        
        {
            AlertException var72ECBD9ACE893B3681FE38634B652114_86505162 = new AlertException(
                AlertProtocol.INTERNAL_ERROR,
                new SSLProtocolException(
                    "The provided chunk of data is too big: " + len
                    + " > MAX_DATA_LENGTH == "+MAX_DATA_LENGTH));
            var72ECBD9ACE893B3681FE38634B652114_86505162.addTaint(taint);
            throw var72ECBD9ACE893B3681FE38634B652114_86505162;
        } //End block
        byte[] ciphered_fragment = fragment;
        if(activeWriteState != null)        
        {
            ciphered_fragment =
                activeWriteState.encrypt(content_type, fragment, offset, len);
            if(ciphered_fragment.length > MAX_CIPHERED_DATA_LENGTH)            
            {
                AlertException var95CD82F8DA13841835B0AC4A3FE97ADC_1413372652 = new AlertException(
                    AlertProtocol.INTERNAL_ERROR,
                    new SSLProtocolException(
                        "The ciphered data increased more than on 1024 bytes"));
                var95CD82F8DA13841835B0AC4A3FE97ADC_1413372652.addTaint(taint);
                throw var95CD82F8DA13841835B0AC4A3FE97ADC_1413372652;
            } //End block
            if(logger != null)            
            {
                logger.println("SSLRecordProtocol.wrap: TLSCiphertext.fragment["
                        +ciphered_fragment.length+"]:");
                logger.print(ciphered_fragment);
            } //End block
        } //End block
        byte[] var1170D28E7A60B066BB4D9CED6205C833_837168061 = (packetize(content_type, version, ciphered_fragment));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1570033670 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1570033670;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.365 -0400", hash_original_method = "5CCC3748379530494C61DB0E5CDE03DA", hash_generated_method = "C4C01BF8C6109E46E53EFA587F6737F1")
    private byte[] packetize(byte type, byte[] version, byte[] fragment) {
        addTaint(fragment[0]);
        addTaint(version[0]);
        addTaint(type);
        byte[] buff = new byte[5+fragment.length];
        buff[0] = type;
        if(version != null)        
        {
            buff[1] = version[0];
            buff[2] = version[1];
        } //End block
        else
        {
            buff[1] = 3;
            buff[2] = 1;
        } //End block
        buff[3] = (byte) ((0x00FF00 & fragment.length) >> 8);
        buff[4] = (byte) (0x0000FF & fragment.length);
        System.arraycopy(fragment, 0, buff, 5, fragment.length);
        byte[] var93B3D744BAB6E783CC1F4A2C79531378_1065794742 = (buff);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1452124916 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1452124916;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.366 -0400", hash_original_method = "B29F5DC9A2BE75FFC944D86037256C31", hash_generated_method = "5AC86242E8CE8EDF6BD6F94B5207CBE5")
    private void setSession(SSLSessionImpl session) {
        if(!sessionWasChanged)        
        {
            if(logger != null)            
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
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.367 -0400", hash_original_method = "D4A06B5E6BD10843CEED9C48A36D68A3", hash_generated_method = "9B25729670131692BDA2FBE3A34C1342")
    protected byte[] getChangeCipherSpecMesage(SSLSessionImpl session) {
        addTaint(session.getTaint());
        byte[] change_cipher_spec_message;
        if(activeWriteState == null)        
        {
            change_cipher_spec_message = new byte[] {
                    ContentType.CHANGE_CIPHER_SPEC, version[0],
                        version[1], 0, 1, 1
                };
        } //End block
        else
        {
            change_cipher_spec_message =
                packetize(ContentType.CHANGE_CIPHER_SPEC, version,
                        activeWriteState.encrypt(ContentType.CHANGE_CIPHER_SPEC,
                            change_cipher_spec_byte, 0, 1));
        } //End block
        setSession(session);
        activeWriteState = pendingConnectionState;
        if(logger != null)        
        {
            logger.println("SSLRecordProtocol.getChangeCipherSpecMesage");
            logger.println("activeWriteState = pendingConnectionState");
            logger.print(change_cipher_spec_message);
        } //End block
        byte[] varE46FA0A0A49AA2023DD3EA49E87E6F0B_101875488 = (change_cipher_spec_message);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1072413255 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1072413255;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.368 -0400", hash_original_method = "B39FD616EE504B12CB9E5F46F7A6A390", hash_generated_method = "D662A04B784631B915123344A6639653")
    protected int unwrap() throws IOException {
        if(logger != null)        
        {
            logger.println("SSLRecordProtocol.unwrap: BEGIN [");
        } //End block
        int type = in.readUint8();
        if((type < ContentType.CHANGE_CIPHER_SPEC)
                || (type > ContentType.APPLICATION_DATA))        
        {
            if(logger != null)            
            {
                logger.println("Non v3.1 message type:" + type);
            } //End block
            if(type >= 0x80)            
            {
                int length = (type & 0x7f) << 8 | in.read();
                byte[] fragment = in.read(length);
                handshakeProtocol.unwrapSSLv2(fragment);
                if(logger != null)                
                {
                    logger.println(
                            "SSLRecordProtocol:unwrap ] END, SSLv2 type");
                } //End block
                int var7BE4F7A8C74B1CEA810A58C415AC26C8_1854474460 = (ContentType.HANDSHAKE);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093445839 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093445839;
            } //End block
            AlertException var88B2FB02D6F7A28025E19E24D8F6BCC7_1085095211 = new AlertException(AlertProtocol.UNEXPECTED_MESSAGE,
                    new SSLProtocolException(
                        "Unexpected message type has been received: "+type));
            var88B2FB02D6F7A28025E19E24D8F6BCC7_1085095211.addTaint(taint);
            throw var88B2FB02D6F7A28025E19E24D8F6BCC7_1085095211;
        } //End block
        if(logger != null)        
        {
            logger.println("Got the message of type: " + type);
        } //End block
        if(version != null)        
        {
            if((in.read() != version[0])
                    || (in.read() != version[1]))            
            {
                AlertException var88B2FB02D6F7A28025E19E24D8F6BCC7_1920692379 = new AlertException(AlertProtocol.UNEXPECTED_MESSAGE,
                        new SSLProtocolException(
                            "Unexpected message type has been received: " +
                            type));
                var88B2FB02D6F7A28025E19E24D8F6BCC7_1920692379.addTaint(taint);
                throw var88B2FB02D6F7A28025E19E24D8F6BCC7_1920692379;
            } //End block
        } //End block
        else
        {
            in.skip(2);
        } //End block
        int length = in.readUint16();
        if(logger != null)        
        {
            logger.println("TLSCiphertext.fragment["+length+"]: ...");
        } //End block
        if(length > MAX_CIPHERED_DATA_LENGTH)        
        {
            AlertException varF6B25F46FA3E04711B13E7DDE0524207_80660216 = new AlertException(AlertProtocol.RECORD_OVERFLOW,
                    new SSLProtocolException(
                        "Received message is too big."));
            varF6B25F46FA3E04711B13E7DDE0524207_80660216.addTaint(taint);
            throw varF6B25F46FA3E04711B13E7DDE0524207_80660216;
        } //End block
        byte[] fragment = in.read(length);
        if(logger != null)        
        {
            logger.print(fragment);
        } //End block
        if(activeReadState != null)        
        {
            fragment = activeReadState.decrypt((byte) type, fragment);
            if(logger != null)            
            {
                logger.println("TLSPlaintext.fragment:");
                logger.print(fragment);
            } //End block
        } //End block
        if(fragment.length > MAX_DATA_LENGTH)        
        {
            AlertException var288609FC07EF2A149C439A51D7E06583_963265229 = new AlertException(AlertProtocol.DECOMPRESSION_FAILURE,
                    new SSLProtocolException(
                        "Decompressed plain data is too big."));
            var288609FC07EF2A149C439A51D7E06583_963265229.addTaint(taint);
            throw var288609FC07EF2A149C439A51D7E06583_963265229;
        } //End block
switch(type){
        case ContentType.CHANGE_CIPHER_SPEC:
        handshakeProtocol.receiveChangeCipherSpec();
        setSession(handshakeProtocol.getSession());
        if(logger != null)        
        {
            logger.println("activeReadState = pendingConnectionState");
        } //End block
        activeReadState = pendingConnectionState;
        break;
        case ContentType.ALERT:
        alert(fragment[0], fragment[1]);
        break;
        case ContentType.HANDSHAKE:
        handshakeProtocol.unwrap(fragment);
        break;
        case ContentType.APPLICATION_DATA:
        if(logger != null)        
        {
            logger.println(
                            "TLSCiphertext.unwrap: APP DATA["+length+"]:");
            logger.println(new String(fragment));
        } //End block
        appData.append(fragment);
        break;
        default:
        AlertException var88B2FB02D6F7A28025E19E24D8F6BCC7_312195150 = new AlertException(AlertProtocol.UNEXPECTED_MESSAGE,
                        new SSLProtocolException(
                            "Unexpected message type has been received: " +
                            type));
        var88B2FB02D6F7A28025E19E24D8F6BCC7_312195150.addTaint(taint);
        throw var88B2FB02D6F7A28025E19E24D8F6BCC7_312195150;
}        if(logger != null)        
        {
            logger.println("SSLRecordProtocol:unwrap ] END, type: " + type);
        } //End block
        int var599DCCE2998A6B40B1E38E8C6006CB0A_739869434 = (type);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127813327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127813327;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.369 -0400", hash_original_method = "23FCA30C77438F833B36A8A9B6CBC6CC", hash_generated_method = "FE6378E27CB3580198C2014B7ED2A0CA")
    protected void alert(byte level, byte description) {
        addTaint(description);
        addTaint(level);
        if(logger != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.370 -0400", hash_original_method = "DE69782F4CD99CC5C5DEED4E3A6B9F4E", hash_generated_method = "8F61383BC58CF2000382CEE86F416B66")
    protected void setVersion(byte[] ver) {
        this.version = ver;
        // ---------- Original Method ----------
        //this.version = ver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.371 -0400", hash_original_method = "C2A186E08A6901259D50AE521996EDF2", hash_generated_method = "C9069A389B9213669B99E663C216CFD3")
    protected void shutdown() {
        session = null;
        version = null;
        in = null;
        handshakeProtocol = null;
        alertProtocol = null;
        appData = null;
        if(pendingConnectionState != null)        
        {
            pendingConnectionState.shutdown();
        } //End block
        pendingConnectionState = null;
        if(activeReadState != null)        
        {
            activeReadState.shutdown();
        } //End block
        activeReadState = null;
        if(activeReadState != null)        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.371 -0400", hash_original_field = "2F53C2EC19FA8EB5A61C955030F7DAED", hash_generated_field = "87E646BD1D684A2CC2BBDDF46C3B3825")

    protected static final int MAX_DATA_LENGTH = 16384;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.371 -0400", hash_original_field = "433F5FE41C89EA5482842965B42C377B", hash_generated_field = "3DC0909702566A0C923D7A0BA9FB1C56")

    protected static final int MAX_COMPRESSED_DATA_LENGTH = MAX_DATA_LENGTH + 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.371 -0400", hash_original_field = "29055D55024B276B805A05C081EABC3A", hash_generated_field = "1C41081ACDECD110402B056E876963B4")

    protected static final int MAX_CIPHERED_DATA_LENGTH = MAX_COMPRESSED_DATA_LENGTH + 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.371 -0400", hash_original_field = "981AA91818695414A8120138160931CF", hash_generated_field = "9016CFB4E63BFBA851E3F0411B11579B")

    protected static final int MAX_SSL_PACKET_SIZE = MAX_CIPHERED_DATA_LENGTH + 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.371 -0400", hash_original_field = "74310ADA5A45CE0369BE9A6992B9BE5B", hash_generated_field = "AC695E8CF49911104998F741364CAECF")

    private static final byte[] change_cipher_spec_byte = new byte[] {1};
}

