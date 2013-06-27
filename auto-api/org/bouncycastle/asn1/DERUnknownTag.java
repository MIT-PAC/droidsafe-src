package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class DERUnknownTag extends DERObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.411 -0400", hash_original_field = "81C86C56F2FC47B77A343996A0249448", hash_generated_field = "8267FCF370BB52E90BE4145558A847E9")

    private boolean isConstructed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.412 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.412 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

    private byte[] data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.413 -0400", hash_original_method = "478E15AF1DCD2422F6EEE25F4A5760E9", hash_generated_method = "FB08F52580F4EB87F97BB5491B8AFDBA")
    public  DERUnknownTag(
        int     tag,
        byte[]  data) {
        this(false, tag, data);
        addTaint(tag);
        addTaint(data[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.427 -0400", hash_original_method = "2FAC8109F8B8850E3999605ED1A277CD", hash_generated_method = "9A2AFCB36490A2DEB5ABDF4FCC08791C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.427 -0400", hash_original_method = "4AFA588B499059410429802033BA5ED0", hash_generated_method = "027B86F2DA8712DA2FE302A447F108F4")
    public boolean isConstructed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498212128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498212128;
        // ---------- Original Method ----------
        //return isConstructed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.428 -0400", hash_original_method = "749703D76C1808D33D4CAAFA8A986840", hash_generated_method = "55B42D0852CBF73C9E04AB264C33C82A")
    public int getTag() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148080356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148080356;
        // ---------- Original Method ----------
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.428 -0400", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "26CBEA55620C98C3CA44EC5F0CD8CA04")
    public byte[] getData() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2092703549 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2092703549;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.428 -0400", hash_original_method = "444E91CF9E2407B92E5AF0788B821FF3", hash_generated_method = "E658D4F29167BC0102B610648E6F3347")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(isConstructed ? DERTags.CONSTRUCTED : 0, tag, data);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(isConstructed ? DERTags.CONSTRUCTED : 0, tag, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.429 -0400", hash_original_method = "FE1F3CE48FE1BAD33C90012410856208", hash_generated_method = "53D4CF9155961EE061327898D8AEBD50")
    public boolean equals(
        Object o) {
        DERUnknownTag other;
        other = (DERUnknownTag)o;
        boolean varFD488BED465DB00A5900E74A280812D9_795101422 = (isConstructed == other.isConstructed
            && tag == other.tag
            && Arrays.areEqual(data, other.data));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1346535237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1346535237;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.430 -0400", hash_original_method = "6125EE5FC147EEAC675704125571B4F0", hash_generated_method = "D42AE1BC02AA9BF6F0A13CD3588BA771")
    public int hashCode() {
        int var8CA60B295F8BF7476F35CD9BACCCA8CE_2128875078 = ((isConstructed ? ~0 : 0) ^ tag ^ Arrays.hashCode(data)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043796471 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043796471;
        // ---------- Original Method ----------
        //return (isConstructed ? ~0 : 0) ^ tag ^ Arrays.hashCode(data);
    }

    
}

