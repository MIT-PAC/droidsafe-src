package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class EnumConstantNotPresentException extends RuntimeException {
    private static final long serialVersionUID = -6046998521960521108L;
    @SuppressWarnings("unchecked")
    private final Class<? extends Enum> enumType;
    private final String constantName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.644 -0400", hash_original_method = "93E52C49B58E57608E024A09EFB5393A", hash_generated_method = "8264F6818167D55F900ED77651D66A82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public EnumConstantNotPresentException(Class<? extends Enum> enumType, String constantName) {
        super("enum constant " + enumType.getName() + "." + constantName + " is missing");
        dsTaint.addTaint(enumType.dsTaint);
        dsTaint.addTaint(constantName);
        this.enumType = enumType;
        this.constantName = constantName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.656 -0400", hash_original_method = "993C51C687E08EF24896DA5A822225E0", hash_generated_method = "3781B2E36A83DEBEBA7696A6C0047D69")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public Class<? extends Enum> enumType() {
        return (Class<? extends Enum>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return enumType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.664 -0400", hash_original_method = "4A3898E47508F62B3E9000B8E032EC41", hash_generated_method = "8069C5C4702BA4B64F5B04508A5F34D6")
    @DSModeled(DSC.SAFE)
    public String constantName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return constantName;
    }

    
}


