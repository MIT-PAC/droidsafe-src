package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class ASN1Constructed extends ASN1Type {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.243 -0400", hash_original_method = "9FFE4A234D2E2DB42C06DD57E257B3F5", hash_generated_method = "FB8D52ECAFCCCA9AC4D6B778E247FD10")
    protected  ASN1Constructed(int tagNumber) {
        super(CLASS_UNIVERSAL, tagNumber);
        addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.243 -0400", hash_original_method = "0ED0D05BF14BE7B30955286BAE5204E3", hash_generated_method = "54D1A80DE22E55591D27EA9989B25016")
    protected  ASN1Constructed(int tagClass, int tagNumber) {
        super(tagClass, tagNumber);
        addTaint(tagNumber);
        addTaint(tagClass);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.244 -0400", hash_original_method = "B936C5375D6639A303C6027641033901", hash_generated_method = "FCF9DDF920AE0F9B266FFE2017671EAE")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
        boolean var5F6CD01099DCA59D1C64531AD36A6496_1568780775 = (this.constrId == identifier);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_562802927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_562802927;
        // ---------- Original Method ----------
        //return this.constrId == identifier;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.244 -0400", hash_original_method = "D76B5AEAE2B5495729712535531D2D80", hash_generated_method = "E722662B4269D1E0D51D2EC5A319D71E")
    public void encodeASN(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeTag(constrId);
        encodeContent(out);
        // ---------- Original Method ----------
        //out.encodeTag(constrId);
        //encodeContent(out);
    }

    
}

