package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public class ServerKeyExchange extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.290 -0400", hash_original_field = "A4B5CEBA5CB5266E48EF58509253C548", hash_generated_field = "F2393EDA2114C170A28B32BCFE39CA4A")

    BigInteger par1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.291 -0400", hash_original_field = "A44801A7A0E742E9C7A7556B9B22A51D", hash_generated_field = "EACF62C123FC164BE029507CCE179CCF")

    byte[] bytes1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.291 -0400", hash_original_field = "E88C2E31C94DBA9E37EB394165345BE2", hash_generated_field = "49DF98649AA30F777A7B9E97B2259031")

    BigInteger par2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.291 -0400", hash_original_field = "23ACCEECF103768F091B36010844EA27", hash_generated_field = "A1E23DAADE58A1B5E338B97B1B783D02")

    byte[] bytes2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.291 -0400", hash_original_field = "B2CD717F860FE999FE1B3F4F4CBFD70D", hash_generated_field = "04ADECD493FBEAF3F6DA9C0D47888E6A")

    BigInteger par3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.291 -0400", hash_original_field = "DA1812648B0B1EC93962F174E6095D65", hash_generated_field = "A96D0DD7D69372A4FE08B07AE1E6E7B2")

    byte[] bytes3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.291 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "6195FCC77BFDBC9D95F3A31F9C19748F")

    byte[] hash;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.291 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "2C21B14519E4B3866FCF3554754DEBAE")

    private RSAPublicKey key;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.291 -0400", hash_original_method = "BAF04F24660E6C5095996548EBED85A1", hash_generated_method = "261F38D8CE093F00967CC6B20C7465C3")
    public  ServerKeyExchange(BigInteger par1, BigInteger par2, BigInteger par3,
            byte[] hash) {
        this.par1 = par1;
        this.par2 = par2;
        this.par3 = par3;
        this.hash = hash;
        bytes1 = toUnsignedByteArray(this.par1);
        bytes2 = toUnsignedByteArray(this.par2);
        length = 4 + bytes1.length + bytes2.length;
        {
            length += 2 + hash.length;
        } //End block
        {
            bytes3 = null;
        } //End block
        bytes3 = toUnsignedByteArray(this.par3);
        length += 2 + bytes3.length;
        // ---------- Original Method ----------
        //this.par1 = par1;
        //this.par2 = par2;
        //this.par3 = par3;
        //this.hash = hash;
        //bytes1 = toUnsignedByteArray(this.par1);
        //bytes2 = toUnsignedByteArray(this.par2);
        //length = 4 + bytes1.length + bytes2.length;
        //if (hash != null) {
            //length += 2 + hash.length;
        //}
        //if (par3 == null) {
            //bytes3 = null;
            //return;
        //}
        //bytes3 = toUnsignedByteArray(this.par3);
        //length += 2 + bytes3.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.292 -0400", hash_original_method = "0FED75D6D7B207E32712BBEB8093B91D", hash_generated_method = "8F67DFAA1274E5FC0BD57F34A66D201A")
    public  ServerKeyExchange(HandshakeIODataStream in, int length,
            int keyExchange) throws IOException {
        int size = in.readUint16();
        bytes1 = in.read(size);
        par1 = new BigInteger(1, bytes1);
        this.length = 2 + bytes1.length;
        size = in.readUint16();
        bytes2 = in.read(size);
        par2 = new BigInteger(1, bytes2);
        this.length += 2 + bytes2.length;
        {
            size = in.readUint16();
            bytes3 = in.read(size);
            par3 = new BigInteger(1, bytes3);
            this.length += 2 + bytes3.length;
        } //End block
        {
            par3 = null;
            bytes3 = null;
        } //End block
        {
            size = in.readUint16();
            hash = in.read(size);
            this.length += 2 + hash.length;
        } //End block
        {
            hash = null;
        } //End block
        {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect ServerKeyExchange");
        } //End block
        addTaint(length);
        addTaint(keyExchange);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static byte[] toUnsignedByteArray(BigInteger bi) {
        if (bi == null) {
            return null;
        }
        byte[] bb = bi.toByteArray();
        if (bb[0] == 0) {
            byte[] noZero = new byte[bb.length - 1];
            System.arraycopy(bb, 1, noZero, 0, noZero.length);
            return noZero;
        } else {
            return bb;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.293 -0400", hash_original_method = "2B7BAEA20D94561E69BFE5897EA1BEB9", hash_generated_method = "7E005FEEAB5E933C76537489AA7460F6")
    @Override
    public void send(HandshakeIODataStream out) {
        out.writeUint16(bytes1.length);
        out.write(bytes1);
        out.writeUint16(bytes2.length);
        out.write(bytes2);
        {
            out.writeUint16(bytes3.length);
            out.write(bytes3);
        } //End block
        {
            out.writeUint16(hash.length);
            out.write(hash);
        } //End block
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeUint16(bytes1.length);
        //out.write(bytes1);
        //out.writeUint16(bytes2.length);
        //out.write(bytes2);
        //if (bytes3 != null) {
            //out.writeUint16(bytes3.length);
            //out.write(bytes3);
        //}
        //if (hash != null) {
            //out.writeUint16(hash.length);
            //out.write(hash);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.294 -0400", hash_original_method = "72FB1E0FC95B638A772EDD07E458B713", hash_generated_method = "2438997009A55A8D543512B787C467D0")
    public RSAPublicKey getRSAPublicKey() {
        RSAPublicKey varB4EAC82CA7396A68D541C85D26508E83_353398870 = null; //Variable for return #1
        RSAPublicKey varB4EAC82CA7396A68D541C85D26508E83_2128190718 = null; //Variable for return #2
        RSAPublicKey varB4EAC82CA7396A68D541C85D26508E83_818752431 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_353398870 = key;
        } //End block
        try 
        {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            key = (RSAPublicKey) kf.generatePublic(new RSAPublicKeySpec(par1,
                    par2));
        } //End block
        catch (Exception e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2128190718 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_818752431 = key;
        RSAPublicKey varA7E53CE21691AB073D9660D615818899_1982594480; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1982594480 = varB4EAC82CA7396A68D541C85D26508E83_353398870;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1982594480 = varB4EAC82CA7396A68D541C85D26508E83_2128190718;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1982594480 = varB4EAC82CA7396A68D541C85D26508E83_818752431;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1982594480.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1982594480;
        // ---------- Original Method ----------
        //if (key != null) {
            //return key;
        //}
        //try {
            //KeyFactory kf = KeyFactory.getInstance("RSA");
            //key = (RSAPublicKey) kf.generatePublic(new RSAPublicKeySpec(par1,
                    //par2));
        //} catch (Exception e) {
            //return null;
        //}
        //return key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.295 -0400", hash_original_method = "620B9D3699DFA1CCAA0EB56AC40BC192", hash_generated_method = "31BDCE4F5B019062403DE99BEEBBEC44")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522659360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522659360;
        // ---------- Original Method ----------
        //return Handshake.SERVER_KEY_EXCHANGE;
    }

    
}

