package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class BerOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.956 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "8DF314849D9BDCEAE78F4B8DFF0C1E45")

    public byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.956 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.956 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.956 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "57FED7E8E8FF2184EEF7EFF7F0B770B6")

    public Object content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.956 -0400", hash_original_method = "91962B6D78B996175B89159DB336CF3A", hash_generated_method = "91962B6D78B996175B89159DB336CF3A")
    public BerOutputStream ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.957 -0400", hash_original_method = "C86EAD42221FC89550F7365AC0B9ACF2", hash_generated_method = "8C50C1347AD93FE0E9C32BE573486808")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.958 -0400", hash_original_method = "EA25C8AA6C461721569737ADD747FC16", hash_generated_method = "B45722CBC940BBC32F80D5D5939709AF")
    public void encodeANY() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.958 -0400", hash_original_method = "5C094D2C250154036897578CBC75AFD1", hash_generated_method = "BCF34B2A3012F8AA716C0D3745F68C88")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.959 -0400", hash_original_method = "E8ACAA21C20B23BBCED2827068B00143", hash_generated_method = "D0CBA9281912D189047FF598500C2639")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.959 -0400", hash_original_method = "E802EB76E66355F21E1DFC6D16124774", hash_generated_method = "4ED7A66A27C49A5FEFFD8A7CCE9194BD")
    public void encodeChoice(ASN1Choice choice) {
        addTaint(choice.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_1636959321 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_1636959321.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_1636959321;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.960 -0400", hash_original_method = "292D7E5BD8ED56974441257C805288C7", hash_generated_method = "E50BCE21C7CFFA53F16C7933B3C83D64")
    public void encodeExplicit(ASN1Explicit explicit) {
        addTaint(explicit.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_812304803 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_812304803.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_812304803;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.960 -0400", hash_original_method = "2F89F53709F36ECD4B32D0929F0F5EAE", hash_generated_method = "06A3E901D961EA1F69B92AF570DEBAC0")
    public void encodeGeneralizedTime() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.960 -0400", hash_original_method = "1CD5409EC89A1F8D9E3008915332B968", hash_generated_method = "0537E7B8D97744D2F152BBFEAD030363")
    public void encodeUTCTime() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.961 -0400", hash_original_method = "6878EDB9468F416E1691597293C87648", hash_generated_method = "83C24224CDBFA033C347AEC44B9D17F7")
    public void encodeInteger() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.961 -0400", hash_original_method = "9339BB7E7D4F4A4E178E3D3139642B19", hash_generated_method = "0C760DC5A5AD4D16EF6F169C5F56F6F0")
    public void encodeOctetString() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.963 -0400", hash_original_method = "51F7D06C1A64E7B90214CEB0BC04A311", hash_generated_method = "96747EF1BD1CF5922850839F6C990C67")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.963 -0400", hash_original_method = "D323E1EB3DEEC7478D240465668C5921", hash_generated_method = "9E79ED5C4690C7DEC82AAF82F04D6430")
    public void encodeSequence(ASN1Sequence sequence) {
        addTaint(sequence.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_1051140061 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_1051140061.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_1051140061;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.964 -0400", hash_original_method = "8F8FA1CFCDC711CAAAA81FD323F60610", hash_generated_method = "6F338E76F2F25953626B1A6E641BB55D")
    public void encodeSequenceOf(ASN1SequenceOf sequenceOf) {
        addTaint(sequenceOf.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_593969525 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_593969525.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_593969525;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.964 -0400", hash_original_method = "C800AB149478B24214827D5CC5B7FA3B", hash_generated_method = "C85D5742F14706D5E4D177836C47B6E6")
    public void encodeSet(ASN1Set set) {
        addTaint(set.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_1461922341 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_1461922341.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_1461922341;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.964 -0400", hash_original_method = "5BA1B115D777FEA0793A44B700946129", hash_generated_method = "E78B1CD76EBC155E236491657E6A67CE")
    public void encodeSetOf(ASN1SetOf setOf) {
        addTaint(setOf.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_1687046232 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_1687046232.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_1687046232;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.965 -0400", hash_original_method = "C20EE97623962055A396212EF514666C", hash_generated_method = "0B6A5DEA08764373F166A7957BABCB05")
    public void encodeString() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        // ---------- Original Method ----------
        //System.arraycopy(content, 0, encoded, offset, length);
        //offset += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.965 -0400", hash_original_method = "3B2CD397D1827B3F55A2B2B2B09D5CEC", hash_generated_method = "DD4AE2B07A103DA5171F1D3D03AD7EA4")
    public void getChoiceLength(ASN1Choice choice) {
        addTaint(choice.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_1452908237 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_1452908237.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_1452908237;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.965 -0400", hash_original_method = "D74AD9AD6B17DC6BC5FAEB15F22A4F28", hash_generated_method = "E2309D0C5AB1D86C41DD04DB7EC17E9B")
    public void getExplicitLength(ASN1Explicit sequence) {
        addTaint(sequence.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_226576975 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_226576975.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_226576975;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.965 -0400", hash_original_method = "C51A0127E3C370A72526C726CD92E293", hash_generated_method = "89AAD1A99530027485D3AB57A1470749")
    public void getSequenceLength(ASN1Sequence sequence) {
        addTaint(sequence.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_1078084829 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_1078084829.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_1078084829;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.966 -0400", hash_original_method = "02ACE8DD7FB1180FD62EB5624B511B64", hash_generated_method = "0BAA95D6C1503C711CA1550D1E008941")
    public void getSequenceOfLength(ASN1SequenceOf sequence) {
        addTaint(sequence.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_439794172 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_439794172.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_439794172;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.966 -0400", hash_original_method = "2106F07F5CB10EE3DAB9C7BD5AA5C772", hash_generated_method = "7ADE17BC113801ECFA9E458613287728")
    public void getSetLength(ASN1Set set) {
        addTaint(set.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_826232436 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_826232436.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_826232436;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.967 -0400", hash_original_method = "AAF1C08C7F71173806810BED7152C887", hash_generated_method = "5F4104B790878A19326A057C1E2B95B1")
    public void getSetOfLength(ASN1SetOf setOf) {
        addTaint(setOf.getTaint());
        RuntimeException varEC59468AD844069CA80571C4AAA98A77_1083654800 = new RuntimeException("Is not implemented yet");
        varEC59468AD844069CA80571C4AAA98A77_1083654800.addTaint(taint);
        throw varEC59468AD844069CA80571C4AAA98A77_1083654800;
        // ---------- Original Method ----------
        //throw new RuntimeException("Is not implemented yet");
    }

    
}

