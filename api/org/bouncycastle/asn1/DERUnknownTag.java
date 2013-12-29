package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.bouncycastle.util.Arrays;






public class DERUnknownTag extends DERObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.813 -0500", hash_original_field = "9E3BCD745F0AFBDCD90F57B999378CC1", hash_generated_field = "8267FCF370BB52E90BE4145558A847E9")

    private boolean   isConstructed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.814 -0500", hash_original_field = "0870A130AAC33D99955FFBF59B769627", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int       tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.814 -0500", hash_original_field = "B330DF564CD90A5498A9E4F0AB344BB9", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

    private byte[]    data;

    /**
     * @param tag the tag value.
     * @param data the contents octets.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.815 -0500", hash_original_method = "478E15AF1DCD2422F6EEE25F4A5760E9", hash_generated_method = "B98FF90FFA8DA70D68D7BD99B6DEE1DB")
    public DERUnknownTag(
        int     tag,
        byte[]  data)
    {
        this(false, tag, data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.816 -0500", hash_original_method = "2FAC8109F8B8850E3999605ED1A277CD", hash_generated_method = "DD198991CC84D65031F5D32C38AEBD52")
    public DERUnknownTag(
        boolean isConstructed,
        int     tag,
        byte[]  data)
    {
        this.isConstructed = isConstructed;
        this.tag = tag;
        this.data = data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.817 -0500", hash_original_method = "4AFA588B499059410429802033BA5ED0", hash_generated_method = "C1AB853C45CE61BA2090D0ECBB795DD8")
    public boolean isConstructed()
    {
        return isConstructed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.818 -0500", hash_original_method = "749703D76C1808D33D4CAAFA8A986840", hash_generated_method = "FE377F96B9123DA66C921247212B9DB8")
    public int getTag()
    {
        return tag;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.819 -0500", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "EDCB50AB1FD1DF9A8143361DF3DCCF05")
    public byte[] getData()
    {
        return data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.819 -0500", hash_original_method = "444E91CF9E2407B92E5AF0788B821FF3", hash_generated_method = "444E91CF9E2407B92E5AF0788B821FF3")
    void encode(
        DEROutputStream  out)
        throws IOException
    {
        out.writeEncoded(isConstructed ? DERTags.CONSTRUCTED : 0, tag, data);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.820 -0500", hash_original_method = "FE1F3CE48FE1BAD33C90012410856208", hash_generated_method = "ABDC6AF96F022683DA39CD32DA0B3CDB")
    public boolean equals(
        Object o)
    {
        if (!(o instanceof DERUnknownTag))
        {
            return false;
        }
        
        DERUnknownTag other = (DERUnknownTag)o;

        return isConstructed == other.isConstructed
            && tag == other.tag
            && Arrays.areEqual(data, other.data);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:51.821 -0500", hash_original_method = "6125EE5FC147EEAC675704125571B4F0", hash_generated_method = "9D4B600040F00865B640FB3BB3DBD4DD")
    public int hashCode()
    {
        return (isConstructed ? ~0 : 0) ^ tag ^ Arrays.hashCode(data);
    }

    
}

