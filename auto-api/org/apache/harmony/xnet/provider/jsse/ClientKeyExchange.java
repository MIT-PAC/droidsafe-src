package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import libcore.io.Streams;
import libcore.util.EmptyArray;

public class ClientKeyExchange extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.638 -0400", hash_original_field = "B9F55CF4379EB16BB06D0EC8FED510DF", hash_generated_field = "A8EC1747D3C20FCA9F3B799F3E21511E")

    byte[] exchange_keys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.639 -0400", hash_original_field = "CD5CA5155EA3F5FD910C1F295155E9D3", hash_generated_field = "314E39EA2F69CB2F1D5074178AD0D4A9")

    boolean isTLS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.639 -0400", hash_original_field = "CE2AC9A6281889FF0A8A2E4B03C2EAB6", hash_generated_field = "5EC821C040A3584EF0C79FD7C884CE8D")

    boolean isRSA;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.639 -0400", hash_original_method = "C9B8341788FD531DBE072AC5097543AB", hash_generated_method = "62B12B12FB49EC5CC7AE9CA08AC2D5CC")
    public  ClientKeyExchange(byte[] encrypted_pre_master_secret, boolean isTLS) {
        this.exchange_keys = encrypted_pre_master_secret;
        length = this.exchange_keys.length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.643 -0400", hash_original_method = "82DB124C7EE193607645A424E30C3D24", hash_generated_method = "770388687D1543489F1C3E35EF12CB7B")
    public  ClientKeyExchange(BigInteger dh_Yc) {
        byte[] bb;
        bb = dh_Yc.toByteArray();
        {
            exchange_keys = new byte[bb.length-1];
            System.arraycopy(bb, 1, exchange_keys, 0, exchange_keys.length);
        } //End block
        {
            exchange_keys = bb;
        } //End block
        length = exchange_keys.length +2;
        isRSA = false;
        addTaint(dh_Yc.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.643 -0400", hash_original_method = "F9E21C88B251C3A8D5F2F68FD08CDC9E", hash_generated_method = "4533FE8F4312A563E5A5CB5E21E04D95")
    public  ClientKeyExchange() {
        exchange_keys = EmptyArray.BYTE;
        length = 0;
        isRSA = false;
        // ---------- Original Method ----------
        //exchange_keys = EmptyArray.BYTE;
        //length = 0;
        //isRSA = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.644 -0400", hash_original_method = "C1B0A0A6F00EB418D00ABC26C97C8AF6", hash_generated_method = "472424D0FEBA7757EE7704A3E92D688D")
    public  ClientKeyExchange(HandshakeIODataStream in, int length, boolean isTLS, boolean isRSA) throws IOException {
        this.isTLS = isTLS;
        this.isRSA = isRSA;
        {
            this.length = 0;
            exchange_keys = EmptyArray.BYTE;
        } //End block
        {
            int size;
            {
                size = length;
                this.length = size;
            } //End block
            {
                size = in.readUint16();
                this.length = 2 + size;
            } //End block
            exchange_keys = new byte[size];
            Streams.readFully(in, exchange_keys);
            {
                fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ClientKeyExchange");
            } //End block
        } //End block
        addTaint(in.getTaint());
        addTaint(length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.650 -0400", hash_original_method = "355F47F7AE472993E3A2C68F4F83F8CB", hash_generated_method = "77DABBAEB8B6409F28AB795ED8859639")
    @Override
    public void send(HandshakeIODataStream out) {
        {
            {
                out.writeUint16(exchange_keys.length);
            } //End block
            out.write(exchange_keys);
        } //End block
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //if (exchange_keys.length != 0) {
            //if (!isRSA || isTLS) {
                //out.writeUint16(exchange_keys.length);
            //}
            //out.write(exchange_keys);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.651 -0400", hash_original_method = "689E42FE01D543BF62D87A0EDA5093F1", hash_generated_method = "15A7A6A1891A6DEEF361F3BDDDCFA491")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501766654 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501766654;
        // ---------- Original Method ----------
        //return Handshake.CLIENT_KEY_EXCHANGE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.657 -0400", hash_original_method = "A6E948E5B249A2FAEF42B96B088122ED", hash_generated_method = "D4D6C80D5C8555C4CF5BBDB3BE440B02")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_740296801 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_740296801;
        // ---------- Original Method ----------
        //return (exchange_keys.length == 0);
    }

    
}

