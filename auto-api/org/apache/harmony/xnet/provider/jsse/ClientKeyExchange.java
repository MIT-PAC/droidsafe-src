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
    byte[] exchange_keys;
    boolean isTLS;
    boolean isRSA;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.660 -0400", hash_original_method = "C9B8341788FD531DBE072AC5097543AB", hash_generated_method = "9AA186768A882C9B1E204372AD8B7871")
    @DSModeled(DSC.SAFE)
    public ClientKeyExchange(byte[] encrypted_pre_master_secret, boolean isTLS) {
        dsTaint.addTaint(isTLS);
        dsTaint.addTaint(encrypted_pre_master_secret[0]);
        length = this.exchange_keys.length;
        {
            length += 2;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.660 -0400", hash_original_method = "82DB124C7EE193607645A424E30C3D24", hash_generated_method = "DFE459A7DF9593CB586FB8228D9340DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClientKeyExchange(BigInteger dh_Yc) {
        dsTaint.addTaint(dh_Yc.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.660 -0400", hash_original_method = "F9E21C88B251C3A8D5F2F68FD08CDC9E", hash_generated_method = "4533FE8F4312A563E5A5CB5E21E04D95")
    @DSModeled(DSC.SAFE)
    public ClientKeyExchange() {
        exchange_keys = EmptyArray.BYTE;
        length = 0;
        isRSA = false;
        // ---------- Original Method ----------
        //exchange_keys = EmptyArray.BYTE;
        //length = 0;
        //isRSA = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.660 -0400", hash_original_method = "C1B0A0A6F00EB418D00ABC26C97C8AF6", hash_generated_method = "40D2BFEF09FF8CF26BE01E9EB1DE1347")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClientKeyExchange(HandshakeIODataStream in, int length, boolean isTLS, boolean isRSA) throws IOException {
        dsTaint.addTaint(isTLS);
        dsTaint.addTaint(isRSA);
        dsTaint.addTaint(length);
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.661 -0400", hash_original_method = "355F47F7AE472993E3A2C68F4F83F8CB", hash_generated_method = "417294B09332B4F09757AC97E5DB408E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void send(HandshakeIODataStream out) {
        dsTaint.addTaint(out.dsTaint);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.661 -0400", hash_original_method = "689E42FE01D543BF62D87A0EDA5093F1", hash_generated_method = "BEF6E99FEBB5ECF680054511A21CFC74")
    @DSModeled(DSC.SAFE)
    @Override
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Handshake.CLIENT_KEY_EXCHANGE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.661 -0400", hash_original_method = "A6E948E5B249A2FAEF42B96B088122ED", hash_generated_method = "3EBDDBF2D0A1DEC70E9240EC307B375C")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (exchange_keys.length == 0);
    }

    
}

