package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;





public class BerOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.816 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "8DF314849D9BDCEAE78F4B8DFF0C1E45")

    public byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.816 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.816 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.816 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "57FED7E8E8FF2184EEF7EFF7F0B770B6")

    public Object content;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.816 -0400", hash_original_method = "91962B6D78B996175B89159DB336CF3A", hash_generated_method = "91962B6D78B996175B89159DB336CF3A")
    public BerOutputStream ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.818 -0400", hash_original_method = "C86EAD42221FC89550F7365AC0B9ACF2", hash_generated_method = "8C50C1347AD93FE0E9C32BE573486808")
    public final void encodeTag(int tag) {
        encoded[offset++] = (byte) tag;
        if(length > 127)        
        {
            int eLen = length >> 8;
            byte numOctets = 1;
for(;eLen > 0;eLen = eLen >> 8)
            {
                numOctets++;
            } //End block
            encoded[offset] = (byte) (numOctets | 0x80);
            offset++;
            eLen = length;
            int numOffset = offset + numOctets - 1;
for(int i = 0;i < numOctets;i++,eLen = eLen >> 8)
            {
                encoded[numOffset - i] = (byte) eLen;
            } //End block
            offset += numOctets;
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.819 -0400", hash_original_method = "EA25C8AA6C461721569737ADD747FC16", hash_generated_method = "B45722CBC940BBC32F80D5D5939709AF")
    public void encodeANY() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.820 -0400", hash_original_method = "5C094D2C250154036897578CBC75AFD1", hash_generated_method = "BCF34B2A3012F8AA716C0D3745F68C88")
    public void encodeBitString() {
        BitString bStr = (BitString) content;
        encoded[offset] = (byte) bStr.unusedBits;
        System.arraycopy(bStr.bytes, 0, encoded, offset + 1, length - 1);
        offset += length;
        // ---------- Original Method ----------
        //BitString bStr = (BitString) content;
        //encoded[offset] = (byte) bStr.unusedBits;
        //System.arraycopy(bStr.bytes, 0, encoded, offset + 1, length - 1);
        //offset += length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.820 -0400", hash_original_method = "E8ACAA21C20B23BBCED2827068B00143", hash_generated_method = "D0CBA9281912D189047FF598500C2639")
    public void encodeBoolean() {
        if((Boolean) content)        
        {
            encoded[offset] = (byte) 0xFF;
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.821 -0400", hash_original_method = "E802EB76E66355F21E1DFC6D16124774", hash_generated_method = "720F727A8AFC47BDCB8BE611F5F2C7DB")
    public void encodeChoice(ASN1Choice choice) {
        addTaint(choice.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_271677760 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_271677760.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_271677760;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.821 -0400", hash_original_method = "292D7E5BD8ED56974441257C805288C7", hash_generated_method = "340650FFB07D7DCA31645F48B4A94C1C")
    public void encodeExplicit(ASN1Explicit explicit) {
        addTaint(explicit.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_1617347576 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_1617347576.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_1617347576;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.821 -0400", hash_original_method = "2F89F53709F36ECD4B32D0929F0F5EAE", hash_generated_method = "06A3E901D961EA1F69B92AF570DEBAC0")
    public void encodeGeneralizedTime() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.822 -0400", hash_original_method = "1CD5409EC89A1F8D9E3008915332B968", hash_generated_method = "0537E7B8D97744D2F152BBFEAD030363")
    public void encodeUTCTime() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.822 -0400", hash_original_method = "6878EDB9468F416E1691597293C87648", hash_generated_method = "83C24224CDBFA033C347AEC44B9D17F7")
    public void encodeInteger() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.822 -0400", hash_original_method = "9339BB7E7D4F4A4E178E3D3139642B19", hash_generated_method = "0C760DC5A5AD4D16EF6F169C5F56F6F0")
    public void encodeOctetString() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.824 -0400", hash_original_method = "51F7D06C1A64E7B90214CEB0BC04A311", hash_generated_method = "96747EF1BD1CF5922850839F6C990C67")
    public void encodeOID() {
        int[] oid = (int[]) content;
        int oidLen = length;
        int elem;
for(int i = oid.length - 1;i > 1;i--,oidLen--)
        {
            elem = oid[i];
            if(elem > 127)            
            {
                encoded[offset + oidLen - 1] = (byte) (elem & 0x7F);
                elem = elem >> 7;
for(;elem > 0;)
                {
                    oidLen--;
                    encoded[offset + oidLen - 1] = (byte) (elem | 0x80);
                    elem = elem >> 7;
                } //End block
            } //End block
            else
            {
                encoded[offset + oidLen - 1] = (byte) elem;
            } //End block
        } //End block
        elem = oid[0] * 40 + oid[1];
        if(elem > 127)        
        {
            encoded[offset + oidLen - 1] = (byte) (elem & 0x7F);
            elem = elem >> 7;
for(;elem > 0;)
            {
                oidLen--;
                encoded[offset + oidLen - 1] = (byte) (elem | 0x80);
                elem = elem >> 7;
            } //End block
        } //End block
        else
        {
            encoded[offset + oidLen - 1] = (byte) elem;
        } //End block
        offset += length;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.825 -0400", hash_original_method = "D323E1EB3DEEC7478D240465668C5921", hash_generated_method = "3999354F589A40DEB5762C34242E832F")
    public void encodeSequence(ASN1Sequence sequence) {
        addTaint(sequence.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_1978026248 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_1978026248.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_1978026248;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.825 -0400", hash_original_method = "8F8FA1CFCDC711CAAAA81FD323F60610", hash_generated_method = "1339A4C9419E4C80C0844C5152946019")
    public void encodeSequenceOf(ASN1SequenceOf sequenceOf) {
        addTaint(sequenceOf.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_481562603 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_481562603.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_481562603;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.825 -0400", hash_original_method = "C800AB149478B24214827D5CC5B7FA3B", hash_generated_method = "94A2B947E7407CC36AB3CF190BD76E4B")
    public void encodeSet(ASN1Set set) {
        addTaint(set.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_1104034899 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_1104034899.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_1104034899;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.826 -0400", hash_original_method = "5BA1B115D777FEA0793A44B700946129", hash_generated_method = "33476603A20376384C51B8E291AF9CC8")
    public void encodeSetOf(ASN1SetOf setOf) {
        addTaint(setOf.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_713999854 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_713999854.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_713999854;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.826 -0400", hash_original_method = "C20EE97623962055A396212EF514666C", hash_generated_method = "0B6A5DEA08764373F166A7957BABCB05")
    public void encodeString() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.827 -0400", hash_original_method = "3B2CD397D1827B3F55A2B2B2B09D5CEC", hash_generated_method = "B02A2865386F99380891E9EBCB5C2EBF")
    public void getChoiceLength(ASN1Choice choice) {
        addTaint(choice.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_2059545012 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_2059545012.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_2059545012;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.827 -0400", hash_original_method = "D74AD9AD6B17DC6BC5FAEB15F22A4F28", hash_generated_method = "49A18A6FB6A6F9C4195F18EE632C4C33")
    public void getExplicitLength(ASN1Explicit sequence) {
        addTaint(sequence.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_1863383969 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_1863383969.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_1863383969;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.827 -0400", hash_original_method = "C51A0127E3C370A72526C726CD92E293", hash_generated_method = "8A7E1E88D1B1ED830B9B69B33B8FEB94")
    public void getSequenceLength(ASN1Sequence sequence) {
        addTaint(sequence.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_405662580 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_405662580.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_405662580;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.827 -0400", hash_original_method = "02ACE8DD7FB1180FD62EB5624B511B64", hash_generated_method = "C7794C3F922C28F13E356AFD712B3AB2")
    public void getSequenceOfLength(ASN1SequenceOf sequence) {
        addTaint(sequence.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_668649111 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_668649111.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_668649111;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.827 -0400", hash_original_method = "2106F07F5CB10EE3DAB9C7BD5AA5C772", hash_generated_method = "47C4ADC3F8DF30D566FB4CD0A3B0CFA2")
    public void getSetLength(ASN1Set set) {
        addTaint(set.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_186997631 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_186997631.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_186997631;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.828 -0400", hash_original_method = "AAF1C08C7F71173806810BED7152C887", hash_generated_method = "CC766F5F258D5A30C80B9DDA46902637")
    public void getSetOfLength(ASN1SetOf setOf) {
        addTaint(setOf.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_216397390 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_216397390.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_216397390;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
}

