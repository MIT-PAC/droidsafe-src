package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DERExternal extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.978 -0400", hash_original_field = "87CF319575A80D82C7B08518EB1A138A", hash_generated_field = "8B451B3DBA24F8A6DD2DAC687FC92958")

    private DERObjectIdentifier directReference;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.978 -0400", hash_original_field = "44A5FC20CC91CDBBCCF26603C8D6D3E6", hash_generated_field = "4BDDE807B370ABCD06D1D8B56EE5C7C4")

    private DERInteger indirectReference;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.978 -0400", hash_original_field = "D4C330BFB9DA13B3E1D95A39A28A5037", hash_generated_field = "A8803A57E0AB1FAD59A5878D307FCE93")

    private ASN1Object dataValueDescriptor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.978 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "E77A569AB1DC34BFC03164971297EE8D")

    private int encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.978 -0400", hash_original_field = "44D2CB943C9C2DEB0EDB1C94BEBB0486", hash_generated_field = "8CF4A9E6D02D0338F11DF53BC2A4E23F")

    private DERObject externalContent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.979 -0400", hash_original_method = "5B6E321D0FF0F6E358DB9222EA98BCB7", hash_generated_method = "E49225FE945F1F27317191A5CC1B6EE1")
    public  DERExternal(ASN1EncodableVector vector) {
        addTaint(vector.getTaint());
        int offset = 0;
        DERObject enc = getObjFromVector(vector, offset);
    if(enc instanceof DERObjectIdentifier)        
        {
            directReference = (DERObjectIdentifier)enc;
            offset++;
            enc = getObjFromVector(vector, offset);
        } //End block
    if(enc instanceof DERInteger)        
        {
            indirectReference = (DERInteger) enc;
            offset++;
            enc = getObjFromVector(vector, offset);
        } //End block
    if(!(enc instanceof DERTaggedObject))        
        {
            dataValueDescriptor = (ASN1Object) enc;
            offset++;
            enc = getObjFromVector(vector, offset);
        } //End block
    if(vector.size() != offset + 1)        
        {
            IllegalArgumentException varF5F61BE0B4396FC35A0CF82D33A9A26B_2053457479 = new IllegalArgumentException("input vector too large");
            varF5F61BE0B4396FC35A0CF82D33A9A26B_2053457479.addTaint(taint);
            throw varF5F61BE0B4396FC35A0CF82D33A9A26B_2053457479;
        } //End block
    if(!(enc instanceof DERTaggedObject))        
        {
            IllegalArgumentException varCD2D2A3031ABAE302CB0ACC77E11F9A3_1758618230 = new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
            varCD2D2A3031ABAE302CB0ACC77E11F9A3_1758618230.addTaint(taint);
            throw varCD2D2A3031ABAE302CB0ACC77E11F9A3_1758618230;
        } //End block
        DERTaggedObject obj = (DERTaggedObject)enc;
        setEncoding(obj.getTagNo());
        externalContent = obj.getObject();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.980 -0400", hash_original_method = "3E78E5A9498D2FA8094C2F6169A192AD", hash_generated_method = "C8B7E436AF9393081D28F012D9D6AA41")
    public  DERExternal(DERObjectIdentifier directReference, DERInteger indirectReference, ASN1Object dataValueDescriptor, DERTaggedObject externalData) {
        this(directReference, indirectReference, dataValueDescriptor, externalData.getTagNo(), externalData.getDERObject());
        addTaint(externalData.getTaint());
        addTaint(dataValueDescriptor.getTaint());
        addTaint(indirectReference.getTaint());
        addTaint(directReference.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.980 -0400", hash_original_method = "865736B8E6D41CC27E8C4571B72736D6", hash_generated_method = "5604928AE2196C77F710D75F383E7318")
    public  DERExternal(DERObjectIdentifier directReference, DERInteger indirectReference, ASN1Object dataValueDescriptor, int encoding, DERObject externalData) {
        addTaint(externalData.getTaint());
        addTaint(encoding);
        addTaint(dataValueDescriptor.getTaint());
        addTaint(indirectReference.getTaint());
        addTaint(directReference.getTaint());
        setDirectReference(directReference);
        setIndirectReference(indirectReference);
        setDataValueDescriptor(dataValueDescriptor);
        setEncoding(encoding);
        setExternalContent(externalData.getDERObject());
        // ---------- Original Method ----------
        //setDirectReference(directReference);
        //setIndirectReference(indirectReference);
        //setDataValueDescriptor(dataValueDescriptor);
        //setEncoding(encoding);
        //setExternalContent(externalData.getDERObject());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.981 -0400", hash_original_method = "B967C566758213AD266FDB24FA14151A", hash_generated_method = "3EA78B60E0729942E6B908BBB0CF79FD")
    private DERObject getObjFromVector(ASN1EncodableVector v, int index) {
        addTaint(index);
        addTaint(v.getTaint());
    if(v.size() <= index)        
        {
            IllegalArgumentException var9553EE6D3DD70C60748A5B2FA00CC002_661910761 = new IllegalArgumentException("too few objects in input vector");
            var9553EE6D3DD70C60748A5B2FA00CC002_661910761.addTaint(taint);
            throw var9553EE6D3DD70C60748A5B2FA00CC002_661910761;
        } //End block
DERObject varDCE3C524664FF49CD40212ED0922D544_1818197785 =         v.get(index).getDERObject();
        varDCE3C524664FF49CD40212ED0922D544_1818197785.addTaint(taint);
        return varDCE3C524664FF49CD40212ED0922D544_1818197785;
        // ---------- Original Method ----------
        //if (v.size() <= index)
        //{
            //throw new IllegalArgumentException("too few objects in input vector");
        //}
        //return v.get(index).getDERObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.981 -0400", hash_original_method = "E789B91521559DD1093D7E9087176FAE", hash_generated_method = "FBAD4638DC77A2512BD769B2C6830DAD")
    public int hashCode() {
        int ret = 0;
    if(directReference != null)        
        {
            ret = directReference.hashCode();
        } //End block
    if(indirectReference != null)        
        {
            ret ^= indirectReference.hashCode();
        } //End block
    if(dataValueDescriptor != null)        
        {
            ret ^= dataValueDescriptor.hashCode();
        } //End block
        ret ^= externalContent.hashCode();
        int var2CB9DF9898E55FD0AD829DC202DDBD1C_2009064748 = (ret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1369864343 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1369864343;
        // ---------- Original Method ----------
        //int ret = 0;
        //if (directReference != null)
        //{
            //ret = directReference.hashCode();
        //}
        //if (indirectReference != null)
        //{
            //ret ^= indirectReference.hashCode();
        //}
        //if (dataValueDescriptor != null)
        //{
            //ret ^= dataValueDescriptor.hashCode();
        //}
        //ret ^= externalContent.hashCode();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.982 -0400", hash_original_method = "95E5CCE7002362171E5372628ECC5970", hash_generated_method = "782669D39489FD0F7C5F2695FAD765BA")
     void encode(DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
    if(directReference != null)        
        {
            baos.write(directReference.getDEREncoded());
        } //End block
    if(indirectReference != null)        
        {
            baos.write(indirectReference.getDEREncoded());
        } //End block
    if(dataValueDescriptor != null)        
        {
            baos.write(dataValueDescriptor.getDEREncoded());
        } //End block
        DERTaggedObject obj = new DERTaggedObject(encoding, externalContent);
        baos.write(obj.getDEREncoded());
        out.writeEncoded(DERTags.CONSTRUCTED, DERTags.EXTERNAL, baos.toByteArray());
        // ---------- Original Method ----------
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //if (directReference != null)
        //{
            //baos.write(directReference.getDEREncoded());
        //}
        //if (indirectReference != null)
        //{
            //baos.write(indirectReference.getDEREncoded());
        //}
        //if (dataValueDescriptor != null)
        //{
            //baos.write(dataValueDescriptor.getDEREncoded());
        //}
        //DERTaggedObject obj = new DERTaggedObject(encoding, externalContent);
        //baos.write(obj.getDEREncoded());
        //out.writeEncoded(DERTags.CONSTRUCTED, DERTags.EXTERNAL, baos.toByteArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.983 -0400", hash_original_method = "B6A4F973EBC78A6793C4703762E4E562", hash_generated_method = "B63145F02D1C44DD88317E88C866698A")
     boolean asn1Equals(DERObject o) {
        addTaint(o.getTaint());
    if(!(o instanceof DERExternal))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1120387437 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887181762 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887181762;
        } //End block
    if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1662396949 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_254179515 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_254179515;
        } //End block
        DERExternal other = (DERExternal)o;
    if(directReference != null)        
        {
    if(other.directReference == null || !other.directReference.equals(directReference))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1179598624 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131840111 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_131840111;
            } //End block
        } //End block
    if(indirectReference != null)        
        {
    if(other.indirectReference == null || !other.indirectReference.equals(indirectReference))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1146848586 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1773207794 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1773207794;
            } //End block
        } //End block
    if(dataValueDescriptor != null)        
        {
    if(other.dataValueDescriptor == null || !other.dataValueDescriptor.equals(dataValueDescriptor))            
            {
                boolean var68934A3E9455FA72420237EB05902327_739409720 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1777881737 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1777881737;
            } //End block
        } //End block
        boolean varD0854B60B7117D127DE0B75AAD04FC37_853571961 = (externalContent.equals(other.externalContent));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1507490590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1507490590;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.983 -0400", hash_original_method = "0B6DEA5056C96F68CB576A145B8163A4", hash_generated_method = "D4E003DD499D07D1443AF4C8062F1D66")
    public ASN1Object getDataValueDescriptor() {
ASN1Object var7F5CBFB8592795F817B841B1977CFEEC_996733755 =         dataValueDescriptor;
        var7F5CBFB8592795F817B841B1977CFEEC_996733755.addTaint(taint);
        return var7F5CBFB8592795F817B841B1977CFEEC_996733755;
        // ---------- Original Method ----------
        //return dataValueDescriptor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.984 -0400", hash_original_method = "5D19E791BF0146D74AAC703832ECF7B9", hash_generated_method = "22759A61548D70966CC79124D4D7C8E8")
    public DERObjectIdentifier getDirectReference() {
DERObjectIdentifier var55C2E5FE77E7482E4A8A041A0695CF01_1214580897 =         directReference;
        var55C2E5FE77E7482E4A8A041A0695CF01_1214580897.addTaint(taint);
        return var55C2E5FE77E7482E4A8A041A0695CF01_1214580897;
        // ---------- Original Method ----------
        //return directReference;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.984 -0400", hash_original_method = "20B2CEB64A03B59C5CB213FEC1AC33C9", hash_generated_method = "92351727A0B0C3C46327F14682712FBF")
    public int getEncoding() {
        int var84BEA1F0FD2CE16F7E562A9F06EF03D3_963997150 = (encoding);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_657052009 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_657052009;
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.984 -0400", hash_original_method = "A31A01A5BEAE5C1C675F68CA7DEBC312", hash_generated_method = "E12647F529B6E12464FE51D47BFDA1A9")
    public DERObject getExternalContent() {
DERObject var53BE248C57C176B392026470DE704D1E_2102448274 =         externalContent;
        var53BE248C57C176B392026470DE704D1E_2102448274.addTaint(taint);
        return var53BE248C57C176B392026470DE704D1E_2102448274;
        // ---------- Original Method ----------
        //return externalContent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.984 -0400", hash_original_method = "A48170CD86EA456F3F5BDA9638D90BB1", hash_generated_method = "2878C1C1CFFD46BEF5CDF7CA51E6F200")
    public DERInteger getIndirectReference() {
DERInteger var6F7D586A588E89E70D60AA8FC6714E98_1733112849 =         indirectReference;
        var6F7D586A588E89E70D60AA8FC6714E98_1733112849.addTaint(taint);
        return var6F7D586A588E89E70D60AA8FC6714E98_1733112849;
        // ---------- Original Method ----------
        //return indirectReference;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.985 -0400", hash_original_method = "0BD65C140FCC2077661040D20B226912", hash_generated_method = "EF6BD976ABD259EA66BA89BDDB768754")
    private void setDataValueDescriptor(ASN1Object dataValueDescriptor) {
        this.dataValueDescriptor = dataValueDescriptor;
        // ---------- Original Method ----------
        //this.dataValueDescriptor = dataValueDescriptor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.985 -0400", hash_original_method = "A83523D5E22547A02A231238C93C9842", hash_generated_method = "D6AD4C337C3FD3A0AD5109A0D5A2ACE9")
    private void setDirectReference(DERObjectIdentifier directReferemce) {
        this.directReference = directReferemce;
        // ---------- Original Method ----------
        //this.directReference = directReferemce;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.986 -0400", hash_original_method = "D6EB4173694568A37E5CF8BEC224CE9C", hash_generated_method = "EFA55292B5DA342015C58F7294484ED6")
    private void setEncoding(int encoding) {
    if(encoding < 0 || encoding > 2)        
        {
            IllegalArgumentException varD22B5947E9CA2DF622C70C1688C6F717_1174840702 = new IllegalArgumentException("invalid encoding value: " + encoding);
            varD22B5947E9CA2DF622C70C1688C6F717_1174840702.addTaint(taint);
            throw varD22B5947E9CA2DF622C70C1688C6F717_1174840702;
        } //End block
        this.encoding = encoding;
        // ---------- Original Method ----------
        //if (encoding < 0 || encoding > 2)
        //{
            //throw new IllegalArgumentException("invalid encoding value: " + encoding);
        //}
        //this.encoding = encoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.986 -0400", hash_original_method = "DE6F2795286824746E38E92F0B41BA33", hash_generated_method = "24CEF734212704228B883286898B188C")
    private void setExternalContent(DERObject externalContent) {
        this.externalContent = externalContent;
        // ---------- Original Method ----------
        //this.externalContent = externalContent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.987 -0400", hash_original_method = "0014F60DB99B68C720B34F07B78773E4", hash_generated_method = "D2EB81AEFDE4F6F36CC34563A6AD7814")
    private void setIndirectReference(DERInteger indirectReference) {
        this.indirectReference = indirectReference;
        // ---------- Original Method ----------
        //this.indirectReference = indirectReference;
    }

    
}

