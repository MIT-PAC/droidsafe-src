package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class ASN1Primitive extends ASN1Type {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.601 -0400", hash_original_method = "6E01D122B93A51FA632034F321085BC1", hash_generated_method = "9D56F69B9803BBDA89E5C889018CDCB2")
    public  ASN1Primitive(int tagNumber) {
        super(tagNumber);
        addTaint(tagNumber);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.601 -0400", hash_original_method = "C1AED137C8D8FCE0695617840DD29190", hash_generated_method = "46935F85FE4162CE661E2C740CC1A283")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980912889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980912889;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.601 -0400", hash_original_method = "56680739FC748952853149E66560E94E", hash_generated_method = "25D1D9CE9976FB742A46C9A1FF96788B")
    public void encodeASN(BerOutputStream out) {
        out.encodeTag(id);
        encodeContent(out);
        addTaint(out.getTaint());
        
        
        
    }

    
}

