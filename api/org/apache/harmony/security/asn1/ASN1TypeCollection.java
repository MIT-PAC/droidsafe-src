package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class ASN1TypeCollection extends ASN1Constructed {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.468 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "24AC453E9AFABA0FC5B4FCBCBDACD1C1")

    public ASN1Type[] type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.468 -0400", hash_original_field = "7951811E4B085CF68ED3DC3191F36405", hash_generated_field = "1BA87DFAEE4319F98EF6412C37781A6A")

    public boolean[] OPTIONAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.468 -0400", hash_original_field = "5B39C8B553C821E7CDDC6DA64B5BD2EE", hash_generated_field = "F208B7C91C0EC690D5447FD30675E5BF")

    public Object[] DEFAULT;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.469 -0400", hash_original_method = "2D9B8BA6B8763CB3A447E57286A5B8E0", hash_generated_method = "F4FE42E5FDBCC705F1F18E33AB127556")
    protected  ASN1TypeCollection(int tagNumber, ASN1Type[] type) {
        super(tagNumber);
        addTaint(tagNumber);
        this.type = type;
        this.OPTIONAL = new boolean[type.length];
        this.DEFAULT = new Object[type.length];
        // ---------- Original Method ----------
        //this.type = type;
        //this.OPTIONAL = new boolean[type.length];
        //this.DEFAULT = new Object[type.length];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.469 -0400", hash_original_method = "2E3FD069D2ECECC280341BA5C6DB58FF", hash_generated_method = "92AA06D5807671C4D16BB1AC57792687")
    protected final void setOptional(int index) {
        OPTIONAL[index] = true;
        // ---------- Original Method ----------
        //OPTIONAL[index] = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.470 -0400", hash_original_method = "5DD4202D21937C15AEFBE0B59FE742F3", hash_generated_method = "65229AAE60F364531E55690317D4E80D")
    protected final void setDefault(Object object, int index) {
        OPTIONAL[index] = true;
        DEFAULT[index] = object;
        // ---------- Original Method ----------
        //OPTIONAL[index] = true;
        //DEFAULT[index] = object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.470 -0400", hash_original_method = "C805E3FBD50230AA52139BF018AC9872", hash_generated_method = "F18CA42582C9209C967FC6D6F31BF898")
    protected void getValues(Object object, Object[] values) {
        addTaint(values[0].getTaint());
        addTaint(object.getTaint());
        RuntimeException varE65FBD5F1AC3348889AAF04FEDF96B49_991787457 = new RuntimeException("ASN.1 type is not designed to be encoded: " + getClass().getName());
        varE65FBD5F1AC3348889AAF04FEDF96B49_991787457.addTaint(taint);
        throw varE65FBD5F1AC3348889AAF04FEDF96B49_991787457;
        // ---------- Original Method ----------
        //throw new RuntimeException("ASN.1 type is not designed to be encoded: " + getClass().getName());
    }

    
}

