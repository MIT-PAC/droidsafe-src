package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class BerOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.798 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "8DF314849D9BDCEAE78F4B8DFF0C1E45")

    public byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.798 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.798 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.798 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "57FED7E8E8FF2184EEF7EFF7F0B770B6")

    public Object content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.798 -0400", hash_original_method = "91962B6D78B996175B89159DB336CF3A", hash_generated_method = "91962B6D78B996175B89159DB336CF3A")
    public BerOutputStream ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.799 -0400", hash_original_method = "C86EAD42221FC89550F7365AC0B9ACF2", hash_generated_method = "2F872A209AC2EF6EED57B181F6553783")
    public final void encodeTag(int tag) {
        encoded[offset++] = (byte) tag;
        {
            int eLen = length >> 8;
            byte numOctets = 1;
            {
                eLen = eLen >> 8;
            } 
            encoded[offset] = (byte) (numOctets | 0x80);
            eLen = length;
            int numOffset = offset + numOctets - 1;
            {
                int i = 0;
                eLen = eLen >> 8;
                {
                    encoded[numOffset - i] = (byte) eLen;
                } 
            } 
            offset += numOctets;
        } 
        {
            encoded[offset++] = (byte) length;
        } 
        
        
        
            
            
            
                
            
            
            
            
            
            
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.799 -0400", hash_original_method = "EA25C8AA6C461721569737ADD747FC16", hash_generated_method = "B45722CBC940BBC32F80D5D5939709AF")
    public void encodeANY() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.800 -0400", hash_original_method = "5C094D2C250154036897578CBC75AFD1", hash_generated_method = "BCF34B2A3012F8AA716C0D3745F68C88")
    public void encodeBitString() {
        BitString bStr = (BitString) content;
        encoded[offset] = (byte) bStr.unusedBits;
        System.arraycopy(bStr.bytes, 0, encoded, offset + 1, length - 1);
        offset += length;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.800 -0400", hash_original_method = "E8ACAA21C20B23BBCED2827068B00143", hash_generated_method = "A200DA987224B0120912C8FD85D8F14F")
    public void encodeBoolean() {
        {
            encoded[offset] = (byte) 0xFF;
        } 
        {
            encoded[offset] = 0x00;
        } 
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.800 -0400", hash_original_method = "E802EB76E66355F21E1DFC6D16124774", hash_generated_method = "009DE3EFE72AC769D7F5FA47269C1CD0")
    public void encodeChoice(ASN1Choice choice) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(choice.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.801 -0400", hash_original_method = "292D7E5BD8ED56974441257C805288C7", hash_generated_method = "A849C85B11C36ACD0CF6114502C5594F")
    public void encodeExplicit(ASN1Explicit explicit) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(explicit.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.801 -0400", hash_original_method = "2F89F53709F36ECD4B32D0929F0F5EAE", hash_generated_method = "06A3E901D961EA1F69B92AF570DEBAC0")
    public void encodeGeneralizedTime() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.801 -0400", hash_original_method = "1CD5409EC89A1F8D9E3008915332B968", hash_generated_method = "0537E7B8D97744D2F152BBFEAD030363")
    public void encodeUTCTime() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.802 -0400", hash_original_method = "6878EDB9468F416E1691597293C87648", hash_generated_method = "83C24224CDBFA033C347AEC44B9D17F7")
    public void encodeInteger() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.802 -0400", hash_original_method = "9339BB7E7D4F4A4E178E3D3139642B19", hash_generated_method = "0C760DC5A5AD4D16EF6F169C5F56F6F0")
    public void encodeOctetString() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.803 -0400", hash_original_method = "51F7D06C1A64E7B90214CEB0BC04A311", hash_generated_method = "62E6645ADF82552AC0D0959C5E2E3883")
    public void encodeOID() {
        int[] oid = (int[]) content;
        int oidLen = length;
        int elem;
        {
            int i = oid.length - 1;
            {
                elem = oid[i];
                {
                    encoded[offset + oidLen - 1] = (byte) (elem & 0x7F);
                    elem = elem >> 7;
                    {
                        encoded[offset + oidLen - 1] = (byte) (elem | 0x80);
                        elem = elem >> 7;
                    } 
                } 
                {
                    encoded[offset + oidLen - 1] = (byte) elem;
                } 
            } 
        } 
        elem = oid[0] * 40 + oid[1];
        {
            encoded[offset + oidLen - 1] = (byte) (elem & 0x7F);
            elem = elem >> 7;
            {
                encoded[offset + oidLen - 1] = (byte) (elem | 0x80);
                elem = elem >> 7;
            } 
        } 
        {
            encoded[offset + oidLen - 1] = (byte) elem;
        } 
        offset += length;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.803 -0400", hash_original_method = "D323E1EB3DEEC7478D240465668C5921", hash_generated_method = "E3E15D1108E0040A7500717D0CCBB4B4")
    public void encodeSequence(ASN1Sequence sequence) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(sequence.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.803 -0400", hash_original_method = "8F8FA1CFCDC711CAAAA81FD323F60610", hash_generated_method = "ED6F4E252E599FC8DAB23B4ACCFE49F1")
    public void encodeSequenceOf(ASN1SequenceOf sequenceOf) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(sequenceOf.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.804 -0400", hash_original_method = "C800AB149478B24214827D5CC5B7FA3B", hash_generated_method = "E2E782EBAB4BDA532889CF4D44DF1492")
    public void encodeSet(ASN1Set set) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(set.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.804 -0400", hash_original_method = "5BA1B115D777FEA0793A44B700946129", hash_generated_method = "52EC3D7AE31545D5A6DA0D521C31976B")
    public void encodeSetOf(ASN1SetOf setOf) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(setOf.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.804 -0400", hash_original_method = "C20EE97623962055A396212EF514666C", hash_generated_method = "0B6A5DEA08764373F166A7957BABCB05")
    public void encodeString() {
        System.arraycopy(content, 0, encoded, offset, length);
        offset += length;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.804 -0400", hash_original_method = "3B2CD397D1827B3F55A2B2B2B09D5CEC", hash_generated_method = "AD706D442FD87243F72A94A39570568E")
    public void getChoiceLength(ASN1Choice choice) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(choice.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.804 -0400", hash_original_method = "D74AD9AD6B17DC6BC5FAEB15F22A4F28", hash_generated_method = "705334AEF050CDD2800FC6768D5C7415")
    public void getExplicitLength(ASN1Explicit sequence) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(sequence.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.805 -0400", hash_original_method = "C51A0127E3C370A72526C726CD92E293", hash_generated_method = "C2945E0CA9B04555EB920D89FA694B8E")
    public void getSequenceLength(ASN1Sequence sequence) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(sequence.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.805 -0400", hash_original_method = "02ACE8DD7FB1180FD62EB5624B511B64", hash_generated_method = "CEF1C5E7469DB0C81C86687EAA6FA70A")
    public void getSequenceOfLength(ASN1SequenceOf sequence) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(sequence.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.805 -0400", hash_original_method = "2106F07F5CB10EE3DAB9C7BD5AA5C772", hash_generated_method = "2A91F8B2E74E7B2BA9283E0415FB9232")
    public void getSetLength(ASN1Set set) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(set.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.805 -0400", hash_original_method = "AAF1C08C7F71173806810BED7152C887", hash_generated_method = "7CF260A7FE93E292C3EAEDBB8F638661")
    public void getSetOfLength(ASN1SetOf setOf) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Is not implemented yet");
        addTaint(setOf.getTaint());
        
        
    }

    
}

