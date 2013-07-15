package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;

public final class DerInputStream extends BerInputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.991 -0400", hash_original_method = "0C4A7C9E977F3C6859980EACEBE18672", hash_generated_method = "2DAC332C35F56196C474BC40BD9CC6B5")
    public  DerInputStream(byte[] encoded) throws IOException {
        super(encoded, 0, encoded.length);
        addTaint(encoded[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.992 -0400", hash_original_method = "28091E4E014A0D7A42E8F791C3C64E87", hash_generated_method = "20A04CC92DF588609E21BDEAC19731B1")
    public  DerInputStream(byte[] encoded, int offset, int encodingLen) throws IOException {
        super(encoded, offset, encodingLen);
        addTaint(encodingLen);
        addTaint(offset);
        addTaint(encoded[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.992 -0400", hash_original_method = "BE2CCC0A8AA1ECB77ECF4313FFFD9645", hash_generated_method = "4248547F37FF25E76C7631771B383ED9")
    public  DerInputStream(InputStream in) throws IOException {
        super(in);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.992 -0400", hash_original_method = "ACFD8393341C557A4C5CB85B57910849", hash_generated_method = "1DFB852ED62A72B9DBDB8D2BC7D6DA5D")
    public int next() throws IOException {
        int tag = super.next();
    if(length == INDEFINIT_LENGTH)        
        {
            ASN1Exception var79FB8FE365E5415E87FEBC66DA46AA51_2114031268 = new ASN1Exception("DER: only definite length encoding MUST be used");
            var79FB8FE365E5415E87FEBC66DA46AA51_2114031268.addTaint(taint);
            throw var79FB8FE365E5415E87FEBC66DA46AA51_2114031268;
        } //End block
        int varE4D23E841D8E8804190027BCE3180FA5_1096844564 = (tag);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971596202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971596202;
        // ---------- Original Method ----------
        //int tag = super.next();
        //if (length == INDEFINIT_LENGTH) {
            //throw new ASN1Exception("DER: only definite length encoding MUST be used");
        //}
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.993 -0400", hash_original_method = "7A0EADAA1891B960439C6C2BFD607720", hash_generated_method = "0FD1317CA7F7465D5494B793B2C2DB3A")
    public void readBitString() throws IOException {
    if(tag == ASN1Constants.TAG_C_BITSTRING)        
        {
            ASN1Exception var6CD6A9EA5E0C8948411E1E925C2D51F9_1936201672 = new ASN1Exception("ASN.1 bitstring: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
            var6CD6A9EA5E0C8948411E1E925C2D51F9_1936201672.addTaint(taint);
            throw var6CD6A9EA5E0C8948411E1E925C2D51F9_1936201672;
        } //End block
        super.readBitString();
    if(length > 1
                && buffer[contentOffset] != 0
                && (buffer[offset - 1] & UNUSED_BITS_MASK[buffer[contentOffset] - 1]) != 0)        
        {
            ASN1Exception varEBFFE941DAAEA9E661A60F1B3386799A_1417583344 = new ASN1Exception("ASN.1 bitstring: wrong content at [" + contentOffset
                    + "]. DER requires zero unused bits in final octet.");
            varEBFFE941DAAEA9E661A60F1B3386799A_1417583344.addTaint(taint);
            throw varEBFFE941DAAEA9E661A60F1B3386799A_1417583344;
        } //End block
        // ---------- Original Method ----------
        //if (tag == ASN1Constants.TAG_C_BITSTRING) {
            //throw new ASN1Exception("ASN.1 bitstring: constructed identifier at [" + tagOffset
                    //+ "]. Not valid for DER.");
        //}
        //super.readBitString();
        //if (length > 1
                //&& buffer[contentOffset] != 0
                //&& (buffer[offset - 1] & UNUSED_BITS_MASK[buffer[contentOffset] - 1]) != 0) {
            //throw new ASN1Exception("ASN.1 bitstring: wrong content at [" + contentOffset
                    //+ "]. DER requires zero unused bits in final octet.");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.993 -0400", hash_original_method = "10108ACDBF74B8DE65083A6BBAC4052F", hash_generated_method = "AF48270BE6AA86925A9E519375C77091")
    public void readBoolean() throws IOException {
        super.readBoolean();
    if(buffer[contentOffset] != 0 && buffer[contentOffset] != (byte) 0xFF)        
        {
            ASN1Exception varB125633AA5460073F05A56E3593082A3_1335486514 = new ASN1Exception("ASN.1 boolean: wrong content at [" + contentOffset
                    + "]. DER allows only 0x00 or 0xFF values");
            varB125633AA5460073F05A56E3593082A3_1335486514.addTaint(taint);
            throw varB125633AA5460073F05A56E3593082A3_1335486514;
        } //End block
        // ---------- Original Method ----------
        //super.readBoolean();
        //if (buffer[contentOffset] != 0 && buffer[contentOffset] != (byte) 0xFF) {
            //throw new ASN1Exception("ASN.1 boolean: wrong content at [" + contentOffset
                    //+ "]. DER allows only 0x00 or 0xFF values");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.994 -0400", hash_original_method = "71C8318A9CAF457AECB9A25AEA0B0620", hash_generated_method = "3F3ED9FFF8F74F763E0366FDA53B92C1")
    public void readOctetString() throws IOException {
    if(tag == ASN1Constants.TAG_C_OCTETSTRING)        
        {
            ASN1Exception var1F9F782176D2FDD117D43B5E6751BBBF_2119677361 = new ASN1Exception("ASN.1 octetstring: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
            var1F9F782176D2FDD117D43B5E6751BBBF_2119677361.addTaint(taint);
            throw var1F9F782176D2FDD117D43B5E6751BBBF_2119677361;
        } //End block
        super.readOctetString();
        // ---------- Original Method ----------
        //if (tag == ASN1Constants.TAG_C_OCTETSTRING) {
            //throw new ASN1Exception("ASN.1 octetstring: constructed identifier at [" + tagOffset
                    //+ "]. Not valid for DER.");
        //}
        //super.readOctetString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.994 -0400", hash_original_method = "D6D26712C70093C458D89C6D3972D749", hash_generated_method = "0A4D0CF92FB1B13F2F6E35F1B41F5F2C")
    public void readSequence(ASN1Sequence sequence) throws IOException {
        addTaint(sequence.getTaint());
        super.readSequence(sequence);
        // ---------- Original Method ----------
        //super.readSequence(sequence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.994 -0400", hash_original_method = "77F51C9B8D3AA50862AF88F76C08878B", hash_generated_method = "A41A9981412AAE9C2CB6576D9502BD46")
    public void readSetOf(ASN1SetOf setOf) throws IOException {
        addTaint(setOf.getTaint());
        super.readSetOf(setOf);
        // ---------- Original Method ----------
        //super.readSetOf(setOf);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.995 -0400", hash_original_method = "E88A2C471E1F01453D6E283D611B31B1", hash_generated_method = "D7FD8EF9B0CA0450813AF87E5F76A564")
    public void readString(ASN1StringType type) throws IOException {
        addTaint(type.getTaint());
    if(tag == type.constrId)        
        {
            ASN1Exception var76D39CA87E04FEC450D76EC3ABE22F69_1390859148 = new ASN1Exception("ASN.1 string: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
            var76D39CA87E04FEC450D76EC3ABE22F69_1390859148.addTaint(taint);
            throw var76D39CA87E04FEC450D76EC3ABE22F69_1390859148;
        } //End block
        super.readString(type);
        // ---------- Original Method ----------
        //if (tag == type.constrId) {
            //throw new ASN1Exception("ASN.1 string: constructed identifier at [" + tagOffset
                    //+ "]. Not valid for DER.");
        //}
        //super.readString(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.995 -0400", hash_original_method = "DDB0D038D9FFD20754D2BFE5BE49D19D", hash_generated_method = "B09E34AF9AD2DF94CB7D6AA54C3AE006")
    public void readUTCTime() throws IOException {
    if(tag == ASN1Constants.TAG_C_UTCTIME)        
        {
            ASN1Exception var9A64E9F3EA8159E550967BD985B9752C_130800046 = new ASN1Exception("ASN.1 UTCTime: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
            var9A64E9F3EA8159E550967BD985B9752C_130800046.addTaint(taint);
            throw var9A64E9F3EA8159E550967BD985B9752C_130800046;
        } //End block
    if(length != ASN1UTCTime.UTC_HMS)        
        {
            ASN1Exception var14034AAB8EBDC0C614D4A1C14A104C70_1705579427 = new ASN1Exception("ASN.1 UTCTime: wrong format for DER, identifier at ["
                    + tagOffset + "]");
            var14034AAB8EBDC0C614D4A1C14A104C70_1705579427.addTaint(taint);
            throw var14034AAB8EBDC0C614D4A1C14A104C70_1705579427;
        } //End block
        super.readUTCTime();
        // ---------- Original Method ----------
        //if (tag == ASN1Constants.TAG_C_UTCTIME) {
            //throw new ASN1Exception("ASN.1 UTCTime: constructed identifier at [" + tagOffset
                    //+ "]. Not valid for DER.");
        //}
        //if (length != ASN1UTCTime.UTC_HMS) {
            //throw new ASN1Exception("ASN.1 UTCTime: wrong format for DER, identifier at ["
                    //+ tagOffset + "]");
        //}
        //super.readUTCTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.996 -0400", hash_original_method = "EBDF2A88B7EE1193AEF8967AC2F99528", hash_generated_method = "694446CB78EA8A0E354BB23AF7BFB110")
    public void readGeneralizedTime() throws IOException {
    if(tag == ASN1Constants.TAG_C_GENERALIZEDTIME)        
        {
            ASN1Exception var7CF4C5D60863B65C33DC7DC92560200E_1214103438 = new ASN1Exception("ASN.1 GeneralizedTime: constructed identifier at ["
                    + tagOffset + "]. Not valid for DER.");
            var7CF4C5D60863B65C33DC7DC92560200E_1214103438.addTaint(taint);
            throw var7CF4C5D60863B65C33DC7DC92560200E_1214103438;
        } //End block
        super.readGeneralizedTime();
        // ---------- Original Method ----------
        //if (tag == ASN1Constants.TAG_C_GENERALIZEDTIME) {
            //throw new ASN1Exception("ASN.1 GeneralizedTime: constructed identifier at ["
                    //+ tagOffset + "]. Not valid for DER.");
        //}
        //super.readGeneralizedTime();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.996 -0400", hash_original_field = "82CCDAFE687F4C5E52BCE6F42F3F9E97", hash_generated_field = "08355CA64E34182C7E05F703D55502C7")

    private static final byte[] UNUSED_BITS_MASK = new byte[] { 0x01, 0x03,
            0x07, 0x0F, 0x1F, 0x3F, 0x7F };
}

