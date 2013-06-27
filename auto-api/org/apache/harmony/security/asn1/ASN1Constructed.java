package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class ASN1Constructed extends ASN1Type {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.150 -0400", hash_original_method = "9FFE4A234D2E2DB42C06DD57E257B3F5", hash_generated_method = "FB8D52ECAFCCCA9AC4D6B778E247FD10")
    protected  ASN1Constructed(int tagNumber) {
        super(CLASS_UNIVERSAL, tagNumber);
        addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.150 -0400", hash_original_method = "0ED0D05BF14BE7B30955286BAE5204E3", hash_generated_method = "2F50AC05C085BB3D47D7460E71C84EEA")
    protected  ASN1Constructed(int tagClass, int tagNumber) {
        super(tagClass, tagNumber);
        addTaint(tagClass);
        addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.151 -0400", hash_original_method = "B936C5375D6639A303C6027641033901", hash_generated_method = "96F931D7373AC206D4EF7E8DFBC39EA7")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910024686 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910024686;
        // ---------- Original Method ----------
        //return this.constrId == identifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.151 -0400", hash_original_method = "D76B5AEAE2B5495729712535531D2D80", hash_generated_method = "046D4CD4CC3DB548D742508889386314")
    public void encodeASN(BerOutputStream out) {
        out.encodeTag(constrId);
        encodeContent(out);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeTag(constrId);
        //encodeContent(out);
    }

    
}

