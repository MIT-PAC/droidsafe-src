package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import java.io.IOException;
import java.math.BigInteger;

import libcore.io.Streams;
import libcore.util.EmptyArray;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ClientKeyExchange extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.273 -0400", hash_original_field = "B9F55CF4379EB16BB06D0EC8FED510DF", hash_generated_field = "A8EC1747D3C20FCA9F3B799F3E21511E")

    byte[] exchange_keys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.273 -0400", hash_original_field = "CD5CA5155EA3F5FD910C1F295155E9D3", hash_generated_field = "314E39EA2F69CB2F1D5074178AD0D4A9")

    boolean isTLS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.273 -0400", hash_original_field = "CE2AC9A6281889FF0A8A2E4B03C2EAB6", hash_generated_field = "5EC821C040A3584EF0C79FD7C884CE8D")

    boolean isRSA;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.274 -0400", hash_original_method = "C9B8341788FD531DBE072AC5097543AB", hash_generated_method = "324D7AE6FC9C76BE82CA5FA9EE760B5E")
    public  ClientKeyExchange(byte[] encrypted_pre_master_secret, boolean isTLS) {
        this.exchange_keys = encrypted_pre_master_secret;
        length = this.exchange_keys.length;
        if(isTLS)        
        {
            length += 2;
        } //End block
        this.isTLS = isTLS;
        isRSA = true;
        // ---------- Original Method ----------
        //this.exchange_keys = encrypted_pre_master_secret;
        //length = this.exchange_keys.length;
        //if (isTLS) {
            //length += 2;
        //}
        //this.isTLS = isTLS;
        //isRSA = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.276 -0400", hash_original_method = "82DB124C7EE193607645A424E30C3D24", hash_generated_method = "3A30B8A16145844F107E4DA92033B6B4")
    public  ClientKeyExchange(BigInteger dh_Yc) {
        addTaint(dh_Yc.getTaint());
        byte[] bb = dh_Yc.toByteArray();
        if(bb[0] == 0)        
        {
            exchange_keys = new byte[bb.length-1];
            System.arraycopy(bb, 1, exchange_keys, 0, exchange_keys.length);
        } //End block
        else
        {
            exchange_keys = bb;
        } //End block
        length = exchange_keys.length +2;
        isRSA = false;
        // ---------- Original Method ----------
        //byte[] bb = dh_Yc.toByteArray();
        //if (bb[0] == 0) {
            //exchange_keys = new byte[bb.length-1];
            //System.arraycopy(bb, 1, exchange_keys, 0, exchange_keys.length);
        //} else {
            //exchange_keys = bb;
        //}
        //length = exchange_keys.length +2;
        //isRSA = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.277 -0400", hash_original_method = "F9E21C88B251C3A8D5F2F68FD08CDC9E", hash_generated_method = "4533FE8F4312A563E5A5CB5E21E04D95")
    public  ClientKeyExchange() {
        exchange_keys = EmptyArray.BYTE;
        length = 0;
        isRSA = false;
        // ---------- Original Method ----------
        //exchange_keys = EmptyArray.BYTE;
        //length = 0;
        //isRSA = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.279 -0400", hash_original_method = "C1B0A0A6F00EB418D00ABC26C97C8AF6", hash_generated_method = "A5BE4479C1DE23E05ED2358C61C791A5")
    public  ClientKeyExchange(HandshakeIODataStream in, int length, boolean isTLS, boolean isRSA) throws IOException {
        addTaint(length);
        addTaint(in.getTaint());
        this.isTLS = isTLS;
        this.isRSA = isRSA;
        if(length == 0)        
        {
            this.length = 0;
            exchange_keys = EmptyArray.BYTE;
        } //End block
        else
        {
            int size;
            if(isRSA && !isTLS)            
            {
                size = length;
                this.length = size;
            } //End block
            else
            {
                size = in.readUint16();
                this.length = 2 + size;
            } //End block
            exchange_keys = new byte[size];
            Streams.readFully(in, exchange_keys);
            if(this.length != length)            
            {
                fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ClientKeyExchange");
            } //End block
        } //End block
        // ---------- Original Method ----------
        //this.isTLS = isTLS;
        //this.isRSA = isRSA;
        //if (length == 0) {
            //this.length = 0;
            //exchange_keys = EmptyArray.BYTE;
        //} else {
            //int size;
            //if (isRSA && !isTLS) {
                //size = length;
                //this.length = size;
            //} else { 
                //size = in.readUint16();
                //this.length = 2 + size;
            //}
            //exchange_keys = new byte[size];
            //Streams.readFully(in, exchange_keys);
            //if (this.length != length) {
                //fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ClientKeyExchange");
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.280 -0400", hash_original_method = "355F47F7AE472993E3A2C68F4F83F8CB", hash_generated_method = "A9598CA71454CF8D4A05FB12AD659097")
    @Override
    public void send(HandshakeIODataStream out) {
        addTaint(out.getTaint());
        if(exchange_keys.length != 0)        
        {
            if(!isRSA || isTLS)            
            {
                out.writeUint16(exchange_keys.length);
            } //End block
            out.write(exchange_keys);
        } //End block
        // ---------- Original Method ----------
        //if (exchange_keys.length != 0) {
            //if (!isRSA || isTLS) {
                //out.writeUint16(exchange_keys.length);
            //}
            //out.write(exchange_keys);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.281 -0400", hash_original_method = "689E42FE01D543BF62D87A0EDA5093F1", hash_generated_method = "C230270F1112A0B429DED3F5BB1F21B3")
    @Override
    public int getType() {
        int varFD9010CA99062B438748F44D41048A64_1695739245 = (Handshake.CLIENT_KEY_EXCHANGE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98058345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98058345;
        // ---------- Original Method ----------
        //return Handshake.CLIENT_KEY_EXCHANGE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.281 -0400", hash_original_method = "A6E948E5B249A2FAEF42B96B088122ED", hash_generated_method = "A50D8E17F9453904A5795C685994C9A4")
    public boolean isEmpty() {
        boolean var2E112C241549CBD81549BE0A48F7CBCB_1634343349 = ((exchange_keys.length == 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949275658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_949275658;
        // ---------- Original Method ----------
        //return (exchange_keys.length == 0);
    }

    
}

