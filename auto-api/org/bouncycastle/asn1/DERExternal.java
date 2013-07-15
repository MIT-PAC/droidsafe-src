package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DERExternal extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.388 -0400", hash_original_field = "87CF319575A80D82C7B08518EB1A138A", hash_generated_field = "8B451B3DBA24F8A6DD2DAC687FC92958")

    private DERObjectIdentifier directReference;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.388 -0400", hash_original_field = "44A5FC20CC91CDBBCCF26603C8D6D3E6", hash_generated_field = "4BDDE807B370ABCD06D1D8B56EE5C7C4")

    private DERInteger indirectReference;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.388 -0400", hash_original_field = "D4C330BFB9DA13B3E1D95A39A28A5037", hash_generated_field = "A8803A57E0AB1FAD59A5878D307FCE93")

    private ASN1Object dataValueDescriptor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.388 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "E77A569AB1DC34BFC03164971297EE8D")

    private int encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.388 -0400", hash_original_field = "44D2CB943C9C2DEB0EDB1C94BEBB0486", hash_generated_field = "8CF4A9E6D02D0338F11DF53BC2A4E23F")

    private DERObject externalContent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.389 -0400", hash_original_method = "5B6E321D0FF0F6E358DB9222EA98BCB7", hash_generated_method = "544AC976587CEA999B13D77A44EC80F6")
    public  DERExternal(ASN1EncodableVector vector) {
        int offset = 0;
        DERObject enc = getObjFromVector(vector, offset);
        {
            directReference = (DERObjectIdentifier)enc;
            enc = getObjFromVector(vector, offset);
        } 
        {
            indirectReference = (DERInteger) enc;
            enc = getObjFromVector(vector, offset);
        } 
        {
            dataValueDescriptor = (ASN1Object) enc;
            enc = getObjFromVector(vector, offset);
        } 
        {
            boolean var6EA570A14539C56A79A93DEAE306A7BD_1636117525 = (vector.size() != offset + 1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input vector too large");
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        } 
        DERTaggedObject obj = (DERTaggedObject)enc;
        setEncoding(obj.getTagNo());
        externalContent = obj.getObject();
        addTaint(vector.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.389 -0400", hash_original_method = "3E78E5A9498D2FA8094C2F6169A192AD", hash_generated_method = "95CAF0C47E93653FB6275114B6596558")
    public  DERExternal(DERObjectIdentifier directReference, DERInteger indirectReference, ASN1Object dataValueDescriptor, DERTaggedObject externalData) {
        this(directReference, indirectReference, dataValueDescriptor, externalData.getTagNo(), externalData.getDERObject());
        addTaint(directReference.getTaint());
        addTaint(indirectReference.getTaint());
        addTaint(dataValueDescriptor.getTaint());
        addTaint(externalData.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.389 -0400", hash_original_method = "865736B8E6D41CC27E8C4571B72736D6", hash_generated_method = "5629508F98BB487327353D098964CB71")
    public  DERExternal(DERObjectIdentifier directReference, DERInteger indirectReference, ASN1Object dataValueDescriptor, int encoding, DERObject externalData) {
        setDirectReference(directReference);
        setIndirectReference(indirectReference);
        setDataValueDescriptor(dataValueDescriptor);
        setEncoding(encoding);
        setExternalContent(externalData.getDERObject());
        addTaint(directReference.getTaint());
        addTaint(indirectReference.getTaint());
        addTaint(dataValueDescriptor.getTaint());
        addTaint(encoding);
        addTaint(externalData.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.390 -0400", hash_original_method = "B967C566758213AD266FDB24FA14151A", hash_generated_method = "9D9726F4BF970C45B07AD487E06B7FD8")
    private DERObject getObjFromVector(ASN1EncodableVector v, int index) {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1666929313 = null; 
        {
            boolean varB4DD559B658EEAA09048D55546AD49A8_746894153 = (v.size() <= index);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("too few objects in input vector");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1666929313 = v.get(index).getDERObject();
        addTaint(v.getTaint());
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1666929313.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1666929313;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.391 -0400", hash_original_method = "E789B91521559DD1093D7E9087176FAE", hash_generated_method = "0D6497EA5F931F587751F7C1388900F7")
    public int hashCode() {
        int ret = 0;
        {
            ret = directReference.hashCode();
        } 
        {
            ret ^= indirectReference.hashCode();
        } 
        {
            ret ^= dataValueDescriptor.hashCode();
        } 
        ret ^= externalContent.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633099198 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633099198;
        
        
        
        
            
        
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.391 -0400", hash_original_method = "95E5CCE7002362171E5372628ECC5970", hash_generated_method = "ABF8D420DAA68F1A291B4E34D197452F")
     void encode(DEROutputStream out) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        {
            baos.write(directReference.getDEREncoded());
        } 
        {
            baos.write(indirectReference.getDEREncoded());
        } 
        {
            baos.write(dataValueDescriptor.getDEREncoded());
        } 
        DERTaggedObject obj = new DERTaggedObject(encoding, externalContent);
        baos.write(obj.getDEREncoded());
        out.writeEncoded(DERTags.CONSTRUCTED, DERTags.EXTERNAL, baos.toByteArray());
        addTaint(out.getTaint());
        
        
        
        
            
        
        
        
            
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.392 -0400", hash_original_method = "B6A4F973EBC78A6793C4703762E4E562", hash_generated_method = "F50D873EA19E172030132F1321365DC7")
     boolean asn1Equals(DERObject o) {
        DERExternal other = (DERExternal)o;
        {
            {
                boolean varBCA992D41F0A8ABD2928F8753178D46A_764433812 = (other.directReference == null || !other.directReference.equals(directReference));
            } 
        } 
        {
            {
                boolean varD78E958F12DFBF6C5C476998EE281259_727663886 = (other.indirectReference == null || !other.indirectReference.equals(indirectReference));
            } 
        } 
        {
            {
                boolean var78A31C65277A5AE8A41B30C47A65F869_982089965 = (other.dataValueDescriptor == null || !other.dataValueDescriptor.equals(dataValueDescriptor));
            } 
        } 
        boolean var99C5035F414E5B2D03D7EFBDDE3288EE_1819591889 = (externalContent.equals(other.externalContent));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387355263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_387355263;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.392 -0400", hash_original_method = "0B6DEA5056C96F68CB576A145B8163A4", hash_generated_method = "B231E932EADD437262323431B297E399")
    public ASN1Object getDataValueDescriptor() {
        ASN1Object varB4EAC82CA7396A68D541C85D26508E83_1867621641 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1867621641 = dataValueDescriptor;
        varB4EAC82CA7396A68D541C85D26508E83_1867621641.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1867621641;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.393 -0400", hash_original_method = "5D19E791BF0146D74AAC703832ECF7B9", hash_generated_method = "C8F8C3AC0E1A7F69CA513CD343BD0BC9")
    public DERObjectIdentifier getDirectReference() {
        DERObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_1635898131 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1635898131 = directReference;
        varB4EAC82CA7396A68D541C85D26508E83_1635898131.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1635898131;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.393 -0400", hash_original_method = "20B2CEB64A03B59C5CB213FEC1AC33C9", hash_generated_method = "0863BCCB3F3F0C20C13B965C3DA08E0C")
    public int getEncoding() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210532877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210532877;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.393 -0400", hash_original_method = "A31A01A5BEAE5C1C675F68CA7DEBC312", hash_generated_method = "AF6DD04876827872533D5EF14EF4DEC6")
    public DERObject getExternalContent() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2115159930 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2115159930 = externalContent;
        varB4EAC82CA7396A68D541C85D26508E83_2115159930.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2115159930;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.394 -0400", hash_original_method = "A48170CD86EA456F3F5BDA9638D90BB1", hash_generated_method = "7465C112A8445520ECBDA054BBEF2E2C")
    public DERInteger getIndirectReference() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_483949882 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_483949882 = indirectReference;
        varB4EAC82CA7396A68D541C85D26508E83_483949882.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_483949882;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.394 -0400", hash_original_method = "0BD65C140FCC2077661040D20B226912", hash_generated_method = "EF6BD976ABD259EA66BA89BDDB768754")
    private void setDataValueDescriptor(ASN1Object dataValueDescriptor) {
        this.dataValueDescriptor = dataValueDescriptor;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.394 -0400", hash_original_method = "A83523D5E22547A02A231238C93C9842", hash_generated_method = "D6AD4C337C3FD3A0AD5109A0D5A2ACE9")
    private void setDirectReference(DERObjectIdentifier directReferemce) {
        this.directReference = directReferemce;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.394 -0400", hash_original_method = "D6EB4173694568A37E5CF8BEC224CE9C", hash_generated_method = "2B487965DAAA3E510EDB70A66A295BF9")
    private void setEncoding(int encoding) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("invalid encoding value: " + encoding);
        } 
        this.encoding = encoding;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.395 -0400", hash_original_method = "DE6F2795286824746E38E92F0B41BA33", hash_generated_method = "24CEF734212704228B883286898B188C")
    private void setExternalContent(DERObject externalContent) {
        this.externalContent = externalContent;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.395 -0400", hash_original_method = "0014F60DB99B68C720B34F07B78773E4", hash_generated_method = "D2EB81AEFDE4F6F36CC34563A6AD7814")
    private void setIndirectReference(DERInteger indirectReference) {
        this.indirectReference = indirectReference;
        
        
    }

    
}

