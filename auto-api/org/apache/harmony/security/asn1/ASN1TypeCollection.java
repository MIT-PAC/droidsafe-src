package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class ASN1TypeCollection extends ASN1Constructed {
    public ASN1Type[] type;
    public boolean[] OPTIONAL;
    public Object[] DEFAULT;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.018 -0400", hash_original_method = "2D9B8BA6B8763CB3A447E57286A5B8E0", hash_generated_method = "DBEBEC70EA1D08F5CB09C6EFAE336AE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ASN1TypeCollection(int tagNumber, ASN1Type[] type) {
        super(tagNumber);
        dsTaint.addTaint(tagNumber);
        dsTaint.addTaint(type[0].dsTaint);
        this.OPTIONAL = new boolean[type.length];
        this.DEFAULT = new Object[type.length];
        // ---------- Original Method ----------
        //this.type = type;
        //this.OPTIONAL = new boolean[type.length];
        //this.DEFAULT = new Object[type.length];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.019 -0400", hash_original_method = "2E3FD069D2ECECC280341BA5C6DB58FF", hash_generated_method = "7E49BE667A8893BFC83B92ABF76CF6DC")
    @DSModeled(DSC.SAFE)
    protected final void setOptional(int index) {
        dsTaint.addTaint(index);
        OPTIONAL[index] = true;
        // ---------- Original Method ----------
        //OPTIONAL[index] = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.020 -0400", hash_original_method = "5DD4202D21937C15AEFBE0B59FE742F3", hash_generated_method = "544FD51D5F71EE3CA5E77DD301CE926E")
    @DSModeled(DSC.SAFE)
    protected final void setDefault(Object object, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(object.dsTaint);
        OPTIONAL[index] = true;
        DEFAULT[index] = object;
        // ---------- Original Method ----------
        //OPTIONAL[index] = true;
        //DEFAULT[index] = object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.022 -0400", hash_original_method = "C805E3FBD50230AA52139BF018AC9872", hash_generated_method = "CF02A897EBEBD6949FB92A1B39E66663")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void getValues(Object object, Object[] values) {
        dsTaint.addTaint(values[0].dsTaint);
        dsTaint.addTaint(object.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("ASN.1 type is not designed to be encoded: " + getClass().getName());
        // ---------- Original Method ----------
        //throw new RuntimeException("ASN.1 type is not designed to be encoded: " + getClass().getName());
    }

    
}

