package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import org.bouncycastle.util.Arrays;






public class DERUnknownTag extends DERObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.687 -0400", hash_original_field = "81C86C56F2FC47B77A343996A0249448", hash_generated_field = "8267FCF370BB52E90BE4145558A847E9")

    private boolean isConstructed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.687 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.687 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

    private byte[] data;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.688 -0400", hash_original_method = "478E15AF1DCD2422F6EEE25F4A5760E9", hash_generated_method = "D2F6CCC321A159AB5F5E89DD7F5AF587")
    public  DERUnknownTag(
        int     tag,
        byte[]  data) {
        this(false, tag, data);
        addTaint(data[0]);
        addTaint(tag);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.689 -0400", hash_original_method = "2FAC8109F8B8850E3999605ED1A277CD", hash_generated_method = "9A2AFCB36490A2DEB5ABDF4FCC08791C")
    public  DERUnknownTag(
        boolean isConstructed,
        int     tag,
        byte[]  data) {
        this.isConstructed = isConstructed;
        this.tag = tag;
        this.data = data;
        // ---------- Original Method ----------
        //this.isConstructed = isConstructed;
        //this.tag = tag;
        //this.data = data;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.689 -0400", hash_original_method = "4AFA588B499059410429802033BA5ED0", hash_generated_method = "64C720ED12F9221F57DCE4264679CD17")
    public boolean isConstructed() {
        boolean var81C86C56F2FC47B77A343996A0249448_1094224715 = (isConstructed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1738963824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1738963824;
        // ---------- Original Method ----------
        //return isConstructed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.690 -0400", hash_original_method = "749703D76C1808D33D4CAAFA8A986840", hash_generated_method = "0281266D08099B4CAEBCC8CB8174CC34")
    public int getTag() {
        int varE4D23E841D8E8804190027BCE3180FA5_1908487083 = (tag);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473888189 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473888189;
        // ---------- Original Method ----------
        //return tag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.690 -0400", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "3AFD231039F5DAF3397FCD95C64EBCFE")
    public byte[] getData() {
        byte[] var8D777F385D3DFEC8815D20F7496026DC_1863386806 = (data);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_554394129 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_554394129;
        // ---------- Original Method ----------
        //return data;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.691 -0400", hash_original_method = "444E91CF9E2407B92E5AF0788B821FF3", hash_generated_method = "47AA9DB5EE593712CE49E5BC5815C98A")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(isConstructed ? DERTags.CONSTRUCTED : 0, tag, data);
        // ---------- Original Method ----------
        //out.writeEncoded(isConstructed ? DERTags.CONSTRUCTED : 0, tag, data);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.691 -0400", hash_original_method = "FE1F3CE48FE1BAD33C90012410856208", hash_generated_method = "AFC871AE13A2A883B9D4D0C7F51C3502")
    public boolean equals(
        Object o) {
        addTaint(o.getTaint());
        if(!(o instanceof DERUnknownTag))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1744908068 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1978971864 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1978971864;
        } //End block
        DERUnknownTag other = (DERUnknownTag)o;
        boolean varBDE4F17E8E83452693A11277B3EADC7E_1147231961 = (isConstructed == other.isConstructed
            && tag == other.tag
            && Arrays.areEqual(data, other.data));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045479424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045479424;
        // ---------- Original Method ----------
        //if (!(o instanceof DERUnknownTag))
        //{
            //return false;
        //}
        //DERUnknownTag other = (DERUnknownTag)o;
        //return isConstructed == other.isConstructed
            //&& tag == other.tag
            //&& Arrays.areEqual(data, other.data);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.692 -0400", hash_original_method = "6125EE5FC147EEAC675704125571B4F0", hash_generated_method = "837E3611C819F8D82E19643B2209F0EC")
    public int hashCode() {
        int var96ECA5C01A7445DAFC3C524853E3675A_91337341 = ((isConstructed ? ~0 : 0) ^ tag ^ Arrays.hashCode(data));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996412098 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996412098;
        // ---------- Original Method ----------
        //return (isConstructed ? ~0 : 0) ^ tag ^ Arrays.hashCode(data);
    }

    
}

