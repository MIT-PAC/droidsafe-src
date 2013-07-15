package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public final class DerInputStream extends BerInputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.849 -0400", hash_original_method = "0C4A7C9E977F3C6859980EACEBE18672", hash_generated_method = "2DAC332C35F56196C474BC40BD9CC6B5")
    public  DerInputStream(byte[] encoded) throws IOException {
        super(encoded, 0, encoded.length);
        addTaint(encoded[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.850 -0400", hash_original_method = "28091E4E014A0D7A42E8F791C3C64E87", hash_generated_method = "E65272E1F6D00B6B81FEC92CA58B8418")
    public  DerInputStream(byte[] encoded, int offset, int encodingLen) throws IOException {
        super(encoded, offset, encodingLen);
        addTaint(encoded[0]);
        addTaint(offset);
        addTaint(encodingLen);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.850 -0400", hash_original_method = "BE2CCC0A8AA1ECB77ECF4313FFFD9645", hash_generated_method = "4248547F37FF25E76C7631771B383ED9")
    public  DerInputStream(InputStream in) throws IOException {
        super(in);
        addTaint(in.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.850 -0400", hash_original_method = "ACFD8393341C557A4C5CB85B57910849", hash_generated_method = "05EE564F4F879AF86A583DD50C0EC7DC")
    public int next() throws IOException {
        int tag = super.next();
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("DER: only definite length encoding MUST be used");
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699093280 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699093280;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.851 -0400", hash_original_method = "7A0EADAA1891B960439C6C2BFD607720", hash_generated_method = "CA831A5EBF48CDB21EDB349FB201D116")
    public void readBitString() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 bitstring: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        } 
        super.readBitString();
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 bitstring: wrong content at [" + contentOffset
                    + "]. DER requires zero unused bits in final octet.");
        } 
        
        
            
                    
        
        
        
                
                
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.851 -0400", hash_original_method = "10108ACDBF74B8DE65083A6BBAC4052F", hash_generated_method = "DD71DB16F842EEAFC5BD451EBD7ED996")
    public void readBoolean() throws IOException {
        super.readBoolean();
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 boolean: wrong content at [" + contentOffset
                    + "]. DER allows only 0x00 or 0xFF values");
        } 
        
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.852 -0400", hash_original_method = "71C8318A9CAF457AECB9A25AEA0B0620", hash_generated_method = "0B61958143A3176F298DDE994DE1DCD1")
    public void readOctetString() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 octetstring: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        } 
        super.readOctetString();
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.852 -0400", hash_original_method = "D6D26712C70093C458D89C6D3972D749", hash_generated_method = "F6E5153C4AFEA561279563B562501838")
    public void readSequence(ASN1Sequence sequence) throws IOException {
        super.readSequence(sequence);
        addTaint(sequence.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.853 -0400", hash_original_method = "77F51C9B8D3AA50862AF88F76C08878B", hash_generated_method = "60F69F0737B9CF07B45112012F253B53")
    public void readSetOf(ASN1SetOf setOf) throws IOException {
        super.readSetOf(setOf);
        addTaint(setOf.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.853 -0400", hash_original_method = "E88A2C471E1F01453D6E283D611B31B1", hash_generated_method = "2289D8207EC871FD062D573ADFF1CC6E")
    public void readString(ASN1StringType type) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 string: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        } 
        super.readString(type);
        addTaint(type.getTaint());
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.854 -0400", hash_original_method = "DDB0D038D9FFD20754D2BFE5BE49D19D", hash_generated_method = "56FDD1097E354302C728B648D2A91AAA")
    public void readUTCTime() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 UTCTime: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 UTCTime: wrong format for DER, identifier at ["
                    + tagOffset + "]");
        } 
        super.readUTCTime();
        
        
            
                    
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.854 -0400", hash_original_method = "EBDF2A88B7EE1193AEF8967AC2F99528", hash_generated_method = "0C18BC2A865490ABE5C23DFB580DCA5A")
    public void readGeneralizedTime() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 GeneralizedTime: constructed identifier at ["
                    + tagOffset + "]. Not valid for DER.");
        } 
        super.readGeneralizedTime();
        
        
            
                    
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.854 -0400", hash_original_field = "82CCDAFE687F4C5E52BCE6F42F3F9E97", hash_generated_field = "08355CA64E34182C7E05F703D55502C7")

    private static final byte[] UNUSED_BITS_MASK = new byte[] { 0x01, 0x03,
            0x07, 0x0F, 0x1F, 0x3F, 0x7F };
}

