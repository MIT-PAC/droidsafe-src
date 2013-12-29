package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public abstract class ASN1Constructed extends ASN1Type {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.164 -0500", hash_original_method = "9FFE4A234D2E2DB42C06DD57E257B3F5", hash_generated_method = "DDA4CA69895680CCA70E5259C13ABA9B")
    protected ASN1Constructed(int tagNumber) {
        super(CLASS_UNIVERSAL, tagNumber);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.165 -0500", hash_original_method = "0ED0D05BF14BE7B30955286BAE5204E3", hash_generated_method = "2EA06A250B4FC28D3ED6C6A2B565CACF")
    protected ASN1Constructed(int tagClass, int tagNumber) {
        super(tagClass, tagNumber);
    }

    /**
     * Tests provided identifier.
     *
     * @param identifier - identifier to be verified
     * @return - true if identifier correspond to constructed identifier of
     *           this ASN.1 type, otherwise false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.166 -0500", hash_original_method = "B936C5375D6639A303C6027641033901", hash_generated_method = "0D91481D29B7299D61A329B8CF47B660")
    public final boolean checkTag(int identifier) {
        return this.constrId == identifier;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.167 -0500", hash_original_method = "D76B5AEAE2B5495729712535531D2D80", hash_generated_method = "4E64FD309E4F4498BE08BC799A7BB31D")
    public void encodeASN(BerOutputStream out) {
        out.encodeTag(constrId);
        encodeContent(out);
    }

    
}

