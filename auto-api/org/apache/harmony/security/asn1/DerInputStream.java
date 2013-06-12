package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.InputStream;

public final class DerInputStream extends BerInputStream {
    private static final byte[] UNUSED_BITS_MASK = new byte[] { 0x01, 0x03,
            0x07, 0x0F, 0x1F, 0x3F, 0x7F };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.711 -0400", hash_original_method = "0C4A7C9E977F3C6859980EACEBE18672", hash_generated_method = "E732C08FEDEFE854D21A3EEB80BC28E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DerInputStream(byte[] encoded) throws IOException {
        super(encoded, 0, encoded.length);
        dsTaint.addTaint(encoded);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.711 -0400", hash_original_method = "28091E4E014A0D7A42E8F791C3C64E87", hash_generated_method = "99CD6B0D94DFA2011554D02FD15E65CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DerInputStream(byte[] encoded, int offset, int encodingLen) throws IOException {
        super(encoded, offset, encodingLen);
        dsTaint.addTaint(encodingLen);
        dsTaint.addTaint(encoded);
        dsTaint.addTaint(offset);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.712 -0400", hash_original_method = "BE2CCC0A8AA1ECB77ECF4313FFFD9645", hash_generated_method = "AE920B85527117744558DC92ECBD7381")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DerInputStream(InputStream in) throws IOException {
        super(in);
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.712 -0400", hash_original_method = "ACFD8393341C557A4C5CB85B57910849", hash_generated_method = "EE6502A221E205B4350F274995FAF1ED")
    @DSModeled(DSC.SAFE)
    public int next() throws IOException {
        int tag;
        tag = super.next();
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("DER: only definite length encoding MUST be used");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int tag = super.next();
        //if (length == INDEFINIT_LENGTH) {
            //throw new ASN1Exception("DER: only definite length encoding MUST be used");
        //}
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.712 -0400", hash_original_method = "7A0EADAA1891B960439C6C2BFD607720", hash_generated_method = "436345DCD7844788D45900AC88299F2E")
    @DSModeled(DSC.SAFE)
    public void readBitString() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 bitstring: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        } //End block
        super.readBitString();
        {
            throw new ASN1Exception("ASN.1 bitstring: wrong content at [" + contentOffset
                    + "]. DER requires zero unused bits in final octet.");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.712 -0400", hash_original_method = "10108ACDBF74B8DE65083A6BBAC4052F", hash_generated_method = "C55EDAADBF27B1728AB43AD83940AEB8")
    @DSModeled(DSC.SAFE)
    public void readBoolean() throws IOException {
        super.readBoolean();
        {
            throw new ASN1Exception("ASN.1 boolean: wrong content at [" + contentOffset
                    + "]. DER allows only 0x00 or 0xFF values");
        } //End block
        // ---------- Original Method ----------
        //super.readBoolean();
        //if (buffer[contentOffset] != 0 && buffer[contentOffset] != (byte) 0xFF) {
            //throw new ASN1Exception("ASN.1 boolean: wrong content at [" + contentOffset
                    //+ "]. DER allows only 0x00 or 0xFF values");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.712 -0400", hash_original_method = "71C8318A9CAF457AECB9A25AEA0B0620", hash_generated_method = "7E809F6EBE636D826FA627864A84E4DC")
    @DSModeled(DSC.SAFE)
    public void readOctetString() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 octetstring: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        } //End block
        super.readOctetString();
        // ---------- Original Method ----------
        //if (tag == ASN1Constants.TAG_C_OCTETSTRING) {
            //throw new ASN1Exception("ASN.1 octetstring: constructed identifier at [" + tagOffset
                    //+ "]. Not valid for DER.");
        //}
        //super.readOctetString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.712 -0400", hash_original_method = "D6D26712C70093C458D89C6D3972D749", hash_generated_method = "163821CFD5A59D88AE4F1494E20AB640")
    @DSModeled(DSC.SAFE)
    public void readSequence(ASN1Sequence sequence) throws IOException {
        dsTaint.addTaint(sequence.dsTaint);
        super.readSequence(sequence);
        // ---------- Original Method ----------
        //super.readSequence(sequence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.712 -0400", hash_original_method = "77F51C9B8D3AA50862AF88F76C08878B", hash_generated_method = "E4C6B5D9E870CA9F0A99E95F259FF65D")
    @DSModeled(DSC.SAFE)
    public void readSetOf(ASN1SetOf setOf) throws IOException {
        dsTaint.addTaint(setOf.dsTaint);
        super.readSetOf(setOf);
        // ---------- Original Method ----------
        //super.readSetOf(setOf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.712 -0400", hash_original_method = "E88A2C471E1F01453D6E283D611B31B1", hash_generated_method = "679B0F3BFEEBB95AD6F77176B64E4A5E")
    @DSModeled(DSC.SAFE)
    public void readString(ASN1StringType type) throws IOException {
        dsTaint.addTaint(type.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 string: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        } //End block
        super.readString(type);
        // ---------- Original Method ----------
        //if (tag == type.constrId) {
            //throw new ASN1Exception("ASN.1 string: constructed identifier at [" + tagOffset
                    //+ "]. Not valid for DER.");
        //}
        //super.readString(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.712 -0400", hash_original_method = "DDB0D038D9FFD20754D2BFE5BE49D19D", hash_generated_method = "CC30C0E5F7F20DF7D995683E50037FD6")
    @DSModeled(DSC.SAFE)
    public void readUTCTime() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 UTCTime: constructed identifier at [" + tagOffset
                    + "]. Not valid for DER.");
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 UTCTime: wrong format for DER, identifier at ["
                    + tagOffset + "]");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.712 -0400", hash_original_method = "EBDF2A88B7EE1193AEF8967AC2F99528", hash_generated_method = "D81B1EFC795835B84A1FC2950F414235")
    @DSModeled(DSC.SAFE)
    public void readGeneralizedTime() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 GeneralizedTime: constructed identifier at ["
                    + tagOffset + "]. Not valid for DER.");
        } //End block
        super.readGeneralizedTime();
        // ---------- Original Method ----------
        //if (tag == ASN1Constants.TAG_C_GENERALIZEDTIME) {
            //throw new ASN1Exception("ASN.1 GeneralizedTime: constructed identifier at ["
                    //+ tagOffset + "]. Not valid for DER.");
        //}
        //super.readGeneralizedTime();
    }

    
}


