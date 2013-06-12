package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class BerOutputStream {
    public byte[] encoded;
    protected int offset;
    public int length;
    public Object content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.702 -0400", hash_original_method = "C86EAD42221FC89550F7365AC0B9ACF2", hash_generated_method = "2BC158E94FF19E7E3F6666E3B8E05CAF")
    @DSModeled(DSC.SAFE)
    public final void encodeTag(int tag) {
        dsTaint.addTaint(tag);
        encoded[offset++] = (byte) tag;
        {
            int eLen;
            eLen = length >> 8;
            byte numOctets;
            numOctets = 1;
            {
                eLen = eLen >> 8;
                {
                    numOctets++;
                } //End block
            } //End collapsed parenthetic
            encoded[offset] = (byte) (numOctets | 0x80);
            offset++;
            eLen = length;
            int numOffset;
            numOffset = offset + numOctets - 1;
            {
                int i;
                i = 0;
                eLen = eLen >> 8;
                {
                    encoded[numOffset - i] = (byte) eLen;
                } //End block
            } //End collapsed parenthetic
            offset += numOctets;
        } //End block
        {
            encoded[offset++] = (byte) length;
        } //End block
        // ---------- Original Method ----------
        //encoded[offset++] = (byte) tag;
        //if (length > 127) { 
            //int eLen = length >> 8;
            //byte numOctets = 1;
            //for (; eLen > 0; eLen = eLen >> 8) {
                //numOctets++;
            //}
            //encoded[offset] = (byte) (numOctets | 0x80);
            //offset++;
            //eLen = length;
            //int numOffset = offset + numOctets - 1;
            //for (int i = 0; i < numOctets; i++, eLen = eLen >> 8) {
                //encoded[numOffset - i] = (byte) eLen; 
            //}
            //offset += numOctets;
        //} else { 
            //encoded[offset++] = (byte) length;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.702 -0400", hash_original_method = "EA25C8AA6C461721569737ADD747FC16", hash_generated_method = "F7BF80B1D8A8FCA14B209035A73F5E02")
    @DSModeled(DSC.SAFE)
    public void encodeANY() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.702 -0400", hash_original_method = "5C094D2C250154036897578CBC75AFD1", hash_generated_method = "AECAF2334AB3D8E6DC605BAC749F0F30")
    @DSModeled(DSC.SAFE)
    public void encodeBitString() {
        BitString bStr;
        bStr = (BitString) content;
        encoded[offset] = (byte) bStr.unusedBits;
        System.arraycopy(bStr.bytes, 0, encoded, offset + 1, length - 1);
        offset += length;
        // ---------- Original Method ----------
        //BitString bStr = (BitString) content;
        //encoded[offset] = (byte) bStr.unusedBits;
        //System.arraycopy(bStr.bytes, 0, encoded, offset + 1, length - 1);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.702 -0400", hash_original_method = "E8ACAA21C20B23BBCED2827068B00143", hash_generated_method = "3E13B0890BABEF1936C0D237C2DFCFBC")
    @DSModeled(DSC.SAFE)
    public void encodeBoolean() {
        {
            encoded[offset] = (byte) 0xFF;
        } //End block
        {
            encoded[offset] = 0x00;
        } //End block
        offset++;
        // ---------- Original Method ----------
        //if ((Boolean) content) {
            //encoded[offset] = (byte) 0xFF;
        //} else {
            //encoded[offset] = 0x00;
        //}
        //offset++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.702 -0400", hash_original_method = "E802EB76E66355F21E1DFC6D16124774", hash_generated_method = "0CCCA3E4B259AA96FBC940E929D94459")
    @DSModeled(DSC.SAFE)
    public void encodeChoice(ASN1Choice choice) {
        dsTaint.addTaint(choice.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.702 -0400", hash_original_method = "292D7E5BD8ED56974441257C805288C7", hash_generated_method = "598ED9D6C6FC9CEA7E1F64EAFA3B7232")
    @DSModeled(DSC.SAFE)
    public void encodeExplicit(ASN1Explicit explicit) {
        dsTaint.addTaint(explicit.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.702 -0400", hash_original_method = "2F89F53709F36ECD4B32D0929F0F5EAE", hash_generated_method = "9E32D9949843C3AA82AF10994080A58E")
    @DSModeled(DSC.SAFE)
    public void encodeGeneralizedTime() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.702 -0400", hash_original_method = "1CD5409EC89A1F8D9E3008915332B968", hash_generated_method = "7095978C4D96965A4E881D773085B847")
    @DSModeled(DSC.SAFE)
    public void encodeUTCTime() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "6878EDB9468F416E1691597293C87648", hash_generated_method = "7CBDA6CAC10D1B1900FE9A8790AE9F3C")
    @DSModeled(DSC.SAFE)
    public void encodeInteger() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "9339BB7E7D4F4A4E178E3D3139642B19", hash_generated_method = "DE8CF57D67CDF4AEBE078EF83EE797B1")
    @DSModeled(DSC.SAFE)
    public void encodeOctetString() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "51F7D06C1A64E7B90214CEB0BC04A311", hash_generated_method = "71959B06D0A5C5C43FF0880F0FC339D7")
    @DSModeled(DSC.SAFE)
    public void encodeOID() {
        int[] oid;
        oid = (int[]) content;
        int oidLen;
        oidLen = length;
        int elem;
        {
            int i;
            i = oid.length - 1;
            {
                elem = oid[i];
                {
                    encoded[offset + oidLen - 1] = (byte) (elem & 0x7F);
                    elem = elem >> 7;
                    {
                        oidLen--;
                        encoded[offset + oidLen - 1] = (byte) (elem | 0x80);
                        elem = elem >> 7;
                    } //End block
                } //End block
                {
                    encoded[offset + oidLen - 1] = (byte) elem;
                } //End block
            } //End block
        } //End collapsed parenthetic
        elem = oid[0] * 40 + oid[1];
        {
            encoded[offset + oidLen - 1] = (byte) (elem & 0x7F);
            elem = elem >> 7;
            {
                oidLen--;
                encoded[offset + oidLen - 1] = (byte) (elem | 0x80);
                elem = elem >> 7;
            } //End block
        } //End block
        {
            encoded[offset + oidLen - 1] = (byte) elem;
        } //End block
        offset += length;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "D323E1EB3DEEC7478D240465668C5921", hash_generated_method = "8B5747523FBE3C21D8F1CFE5188AB8AD")
    @DSModeled(DSC.SAFE)
    public void encodeSequence(ASN1Sequence sequence) {
        dsTaint.addTaint(sequence.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "8F8FA1CFCDC711CAAAA81FD323F60610", hash_generated_method = "E23ED265DB9987D0FCF1FFEA91D33E9B")
    @DSModeled(DSC.SAFE)
    public void encodeSequenceOf(ASN1SequenceOf sequenceOf) {
        dsTaint.addTaint(sequenceOf.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "C800AB149478B24214827D5CC5B7FA3B", hash_generated_method = "94F637C9FA413D7BF2AFBA3EF02980EC")
    @DSModeled(DSC.SAFE)
    public void encodeSet(ASN1Set set) {
        dsTaint.addTaint(set.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "5BA1B115D777FEA0793A44B700946129", hash_generated_method = "9D1FB851DB6016456E1E572FFAABE5CC")
    @DSModeled(DSC.SAFE)
    public void encodeSetOf(ASN1SetOf setOf) {
        dsTaint.addTaint(setOf.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "C20EE97623962055A396212EF514666C", hash_generated_method = "5625044AB7D3F078A0E84143A49DC1B1")
    @DSModeled(DSC.SAFE)
    public void encodeString() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "3B2CD397D1827B3F55A2B2B2B09D5CEC", hash_generated_method = "B42C6655A6F2C65256C0CEBF4540039E")
    @DSModeled(DSC.SAFE)
    public void getChoiceLength(ASN1Choice choice) {
        dsTaint.addTaint(choice.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "D74AD9AD6B17DC6BC5FAEB15F22A4F28", hash_generated_method = "D96FBEDD5AD275CF07172B91F58398FC")
    @DSModeled(DSC.SAFE)
    public void getExplicitLength(ASN1Explicit sequence) {
        dsTaint.addTaint(sequence.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "C51A0127E3C370A72526C726CD92E293", hash_generated_method = "6886623583FD5423FEB7B3A19351AE79")
    @DSModeled(DSC.SAFE)
    public void getSequenceLength(ASN1Sequence sequence) {
        dsTaint.addTaint(sequence.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "02ACE8DD7FB1180FD62EB5624B511B64", hash_generated_method = "0DC805EF0050E1BEA4762F46615370A6")
    @DSModeled(DSC.SAFE)
    public void getSequenceOfLength(ASN1SequenceOf sequence) {
        dsTaint.addTaint(sequence.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "2106F07F5CB10EE3DAB9C7BD5AA5C772", hash_generated_method = "DC553F7568CA3114D11EBB2BE00787D0")
    @DSModeled(DSC.SAFE)
    public void getSetLength(ASN1Set set) {
        dsTaint.addTaint(set.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.703 -0400", hash_original_method = "AAF1C08C7F71173806810BED7152C887", hash_generated_method = "122FBD10241D59A726FCF12563331404")
    @DSModeled(DSC.SAFE)
    public void getSetOfLength(ASN1SetOf setOf) {
        dsTaint.addTaint(setOf.dsTaint);
        throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
}


