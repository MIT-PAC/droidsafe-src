package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import libcore.io.Streams;
import libcore.util.EmptyArray;

public class ClientKeyExchange extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.893 -0400", hash_original_field = "B9F55CF4379EB16BB06D0EC8FED510DF", hash_generated_field = "A8EC1747D3C20FCA9F3B799F3E21511E")

    byte[] exchange_keys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.893 -0400", hash_original_field = "CD5CA5155EA3F5FD910C1F295155E9D3", hash_generated_field = "314E39EA2F69CB2F1D5074178AD0D4A9")

    boolean isTLS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.893 -0400", hash_original_field = "CE2AC9A6281889FF0A8A2E4B03C2EAB6", hash_generated_field = "5EC821C040A3584EF0C79FD7C884CE8D")

    boolean isRSA;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.894 -0400", hash_original_method = "C9B8341788FD531DBE072AC5097543AB", hash_generated_method = "62B12B12FB49EC5CC7AE9CA08AC2D5CC")
    public  ClientKeyExchange(byte[] encrypted_pre_master_secret, boolean isTLS) {
        this.exchange_keys = encrypted_pre_master_secret;
        length = this.exchange_keys.length;
        {
            length += 2;
        } 
        this.isTLS = isTLS;
        isRSA = true;
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.894 -0400", hash_original_method = "82DB124C7EE193607645A424E30C3D24", hash_generated_method = "948930D871CF5A5032DE6D30AB0FEBE5")
    public  ClientKeyExchange(BigInteger dh_Yc) {
        byte[] bb = dh_Yc.toByteArray();
        {
            exchange_keys = new byte[bb.length-1];
            System.arraycopy(bb, 1, exchange_keys, 0, exchange_keys.length);
        } 
        {
            exchange_keys = bb;
        } 
        length = exchange_keys.length +2;
        isRSA = false;
        addTaint(dh_Yc.getTaint());
        
        
        
            
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.895 -0400", hash_original_method = "F9E21C88B251C3A8D5F2F68FD08CDC9E", hash_generated_method = "4533FE8F4312A563E5A5CB5E21E04D95")
    public  ClientKeyExchange() {
        exchange_keys = EmptyArray.BYTE;
        length = 0;
        isRSA = false;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.895 -0400", hash_original_method = "C1B0A0A6F00EB418D00ABC26C97C8AF6", hash_generated_method = "472424D0FEBA7757EE7704A3E92D688D")
    public  ClientKeyExchange(HandshakeIODataStream in, int length, boolean isTLS, boolean isRSA) throws IOException {
        this.isTLS = isTLS;
        this.isRSA = isRSA;
        {
            this.length = 0;
            exchange_keys = EmptyArray.BYTE;
        } 
        {
            int size;
            {
                size = length;
                this.length = size;
            } 
            {
                size = in.readUint16();
                this.length = 2 + size;
            } 
            exchange_keys = new byte[size];
            Streams.readFully(in, exchange_keys);
            {
                fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ClientKeyExchange");
            } 
        } 
        addTaint(in.getTaint());
        addTaint(length);
        
        
        
        
            
            
        
            
            
                
                
            
                
                
            
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.896 -0400", hash_original_method = "355F47F7AE472993E3A2C68F4F83F8CB", hash_generated_method = "77DABBAEB8B6409F28AB795ED8859639")
    @Override
    public void send(HandshakeIODataStream out) {
        {
            {
                out.writeUint16(exchange_keys.length);
            } 
            out.write(exchange_keys);
        } 
        addTaint(out.getTaint());
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.896 -0400", hash_original_method = "689E42FE01D543BF62D87A0EDA5093F1", hash_generated_method = "9C0A34E57F3E9B5D1AF2AD0FF9832391")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1894344000 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1894344000;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.896 -0400", hash_original_method = "A6E948E5B249A2FAEF42B96B088122ED", hash_generated_method = "9A6B4C663A0AF916AE9B28BC967639E6")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1988076504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1988076504;
        
        
    }

    
}

