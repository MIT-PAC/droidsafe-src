package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class BerOutputStream {
    public byte[] encoded;
    protected int offset;
    public int length;
    public Object content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.083 -0400", hash_original_method = "81CFE96D6F27D9F03F842E794C3EC04B", hash_generated_method = "81CFE96D6F27D9F03F842E794C3EC04B")
        public BerOutputStream ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.085 -0400", hash_original_method = "C86EAD42221FC89550F7365AC0B9ACF2", hash_generated_method = "6A0549E71CA819A30F330C45F614121C")
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
            } //End collapsed parenthetic
            encoded[offset] = (byte) (numOctets | 0x80);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.086 -0400", hash_original_method = "EA25C8AA6C461721569737ADD747FC16", hash_generated_method = "B45722CBC940BBC32F80D5D5939709AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeANY() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.086 -0400", hash_original_method = "5C094D2C250154036897578CBC75AFD1", hash_generated_method = "1E85CD9EA7D43E40AA8FD78CB4D35D07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.086 -0400", hash_original_method = "E8ACAA21C20B23BBCED2827068B00143", hash_generated_method = "A200DA987224B0120912C8FD85D8F14F")
    @DSModeled(DSC.SAFE)
    public void encodeBoolean() {
        {
            encoded[offset] = (byte) 0xFF;
        } //End block
        {
            encoded[offset] = 0x00;
        } //End block
        // ---------- Original Method ----------
        //if ((Boolean) content) {
            //encoded[offset] = (byte) 0xFF;
        //} else {
            //encoded[offset] = 0x00;
        //}
        //offset++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.087 -0400", hash_original_method = "E802EB76E66355F21E1DFC6D16124774", hash_generated_method = "B0DDB8DC3A3595453CA9E458A1C87105")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeChoice(ASN1Choice choice) {
        dsTaint.addTaint(choice.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.087 -0400", hash_original_method = "292D7E5BD8ED56974441257C805288C7", hash_generated_method = "C14EC241EA17478B5C8A2FFD22669E90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeExplicit(ASN1Explicit explicit) {
        dsTaint.addTaint(explicit.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.087 -0400", hash_original_method = "2F89F53709F36ECD4B32D0929F0F5EAE", hash_generated_method = "06A3E901D961EA1F69B92AF570DEBAC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeGeneralizedTime() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.087 -0400", hash_original_method = "1CD5409EC89A1F8D9E3008915332B968", hash_generated_method = "0537E7B8D97744D2F152BBFEAD030363")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeUTCTime() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.087 -0400", hash_original_method = "6878EDB9468F416E1691597293C87648", hash_generated_method = "83C24224CDBFA033C347AEC44B9D17F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeInteger() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.087 -0400", hash_original_method = "9339BB7E7D4F4A4E178E3D3139642B19", hash_generated_method = "0C760DC5A5AD4D16EF6F169C5F56F6F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeOctetString() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.088 -0400", hash_original_method = "51F7D06C1A64E7B90214CEB0BC04A311", hash_generated_method = "AEEB30153B3D4D8C7453F13499EE3C55")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.088 -0400", hash_original_method = "D323E1EB3DEEC7478D240465668C5921", hash_generated_method = "426B81B6E06EFC726EAA66048D6351B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeSequence(ASN1Sequence sequence) {
        dsTaint.addTaint(sequence.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.088 -0400", hash_original_method = "8F8FA1CFCDC711CAAAA81FD323F60610", hash_generated_method = "A942DDF260D1B735A66458642E8F28B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeSequenceOf(ASN1SequenceOf sequenceOf) {
        dsTaint.addTaint(sequenceOf.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.089 -0400", hash_original_method = "C800AB149478B24214827D5CC5B7FA3B", hash_generated_method = "CBFB0588605159DBFA75E1BBEFAE829F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeSet(ASN1Set set) {
        dsTaint.addTaint(set.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.089 -0400", hash_original_method = "5BA1B115D777FEA0793A44B700946129", hash_generated_method = "5A33C7D202B2D7812193E65F2CCE7549")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeSetOf(ASN1SetOf setOf) {
        dsTaint.addTaint(setOf.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.089 -0400", hash_original_method = "C20EE97623962055A396212EF514666C", hash_generated_method = "0B6A5DEA08764373F166A7957BABCB05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeString() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.089 -0400", hash_original_method = "3B2CD397D1827B3F55A2B2B2B09D5CEC", hash_generated_method = "B66E43864156F5C65C74C4D9CEA7EDC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getChoiceLength(ASN1Choice choice) {
        dsTaint.addTaint(choice.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.089 -0400", hash_original_method = "D74AD9AD6B17DC6BC5FAEB15F22A4F28", hash_generated_method = "B211F48FB3F1CA84BB75A11A4B2713EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getExplicitLength(ASN1Explicit sequence) {
        dsTaint.addTaint(sequence.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.089 -0400", hash_original_method = "C51A0127E3C370A72526C726CD92E293", hash_generated_method = "A46E66068EE920E9987D9815289EBF60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSequenceLength(ASN1Sequence sequence) {
        dsTaint.addTaint(sequence.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.089 -0400", hash_original_method = "02ACE8DD7FB1180FD62EB5624B511B64", hash_generated_method = "4A9A354E191BA53010A11C5130B96A86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSequenceOfLength(ASN1SequenceOf sequence) {
        dsTaint.addTaint(sequence.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.090 -0400", hash_original_method = "2106F07F5CB10EE3DAB9C7BD5AA5C772", hash_generated_method = "AE3A41A9B2F6E74569F11C1102F2C4DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSetLength(ASN1Set set) {
        dsTaint.addTaint(set.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.090 -0400", hash_original_method = "AAF1C08C7F71173806810BED7152C887", hash_generated_method = "434312625A376179405C5F5E85185181")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSetOfLength(ASN1SetOf setOf) {
        dsTaint.addTaint(setOf.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
}

