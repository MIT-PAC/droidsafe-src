package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class DERUnknownTag extends DERObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.823 -0400", hash_original_field = "81C86C56F2FC47B77A343996A0249448", hash_generated_field = "8267FCF370BB52E90BE4145558A847E9")

    private boolean isConstructed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.823 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.823 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

    private byte[] data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.823 -0400", hash_original_method = "478E15AF1DCD2422F6EEE25F4A5760E9", hash_generated_method = "FB08F52580F4EB87F97BB5491B8AFDBA")
    public  DERUnknownTag(
        int     tag,
        byte[]  data) {
        this(false, tag, data);
        addTaint(tag);
        addTaint(data[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.824 -0400", hash_original_method = "2FAC8109F8B8850E3999605ED1A277CD", hash_generated_method = "9A2AFCB36490A2DEB5ABDF4FCC08791C")
    public  DERUnknownTag(
        boolean isConstructed,
        int     tag,
        byte[]  data) {
        this.isConstructed = isConstructed;
        this.tag = tag;
        this.data = data;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.824 -0400", hash_original_method = "4AFA588B499059410429802033BA5ED0", hash_generated_method = "12BF1976319733202B4351BC43E29A0B")
    public boolean isConstructed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500622125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500622125;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.824 -0400", hash_original_method = "749703D76C1808D33D4CAAFA8A986840", hash_generated_method = "1BCA7758926A3197BD6EAE849C737DD9")
    public int getTag() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1344177878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1344177878;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.824 -0400", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "1295DB232613D7CE0CA0DDDD566FC149")
    public byte[] getData() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1828843077 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1828843077;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.825 -0400", hash_original_method = "444E91CF9E2407B92E5AF0788B821FF3", hash_generated_method = "E658D4F29167BC0102B610648E6F3347")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(isConstructed ? DERTags.CONSTRUCTED : 0, tag, data);
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.825 -0400", hash_original_method = "FE1F3CE48FE1BAD33C90012410856208", hash_generated_method = "4BA7AFC4A4CCF41F432006FDF6881A41")
    public boolean equals(
        Object o) {
        DERUnknownTag other = (DERUnknownTag)o;
        boolean varFD488BED465DB00A5900E74A280812D9_1910834178 = (isConstructed == other.isConstructed
            && tag == other.tag
            && Arrays.areEqual(data, other.data));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467517414 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467517414;
        
        
        
            
        
        
        
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.825 -0400", hash_original_method = "6125EE5FC147EEAC675704125571B4F0", hash_generated_method = "4A9C1E6303A1E17EC90D6FF17FAB1739")
    public int hashCode() {
        int var8CA60B295F8BF7476F35CD9BACCCA8CE_248840644 = ((isConstructed ? ~0 : 0) ^ tag ^ Arrays.hashCode(data)); 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973514010 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973514010;
        
        
    }

    
}

