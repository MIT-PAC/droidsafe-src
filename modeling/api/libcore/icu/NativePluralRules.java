package libcore.icu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import droidsafe.helpers.DSUtils;

public final class NativePluralRules {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.338 -0500", hash_original_method = "4338DBAED1414C4DB4ED582B56BC090E", hash_generated_method = "9D190F0D6F3F0F768AEE2FC593ADE443")
    
public static NativePluralRules forLocale(Locale locale) {
        return new NativePluralRules(forLocaleImpl(locale.toString()));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void finalizeImpl(int address) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int forLocaleImpl(String localeName) {
        return localeName.getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int quantityForIntImpl(int address, int value) {
        return address + value;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.316 -0500", hash_original_field = "220EA0F5275BEF69F5B6DE1C402F7FD3", hash_generated_field = "91C59E99B3C50EDD2FE9E46B39A1B227")

    public static final int ZERO  = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.318 -0500", hash_original_field = "2FF8B0FFBC535D1C21CAF676588363D8", hash_generated_field = "509D320BEED69EC62E39B8CEF3DCC030")

    public static final int ONE   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.320 -0500", hash_original_field = "D1E2584189EEFD39376A860C0546DD88", hash_generated_field = "7E9F843CF6595717ACAAEDE52A536824")

    public static final int TWO   = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.323 -0500", hash_original_field = "D436CCD8A9F154C278096321E054C5F5", hash_generated_field = "7BCE3E2AA021B15714E206F29D57FF6C")

    public static final int FEW   = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.326 -0500", hash_original_field = "934B0B91457FD57B9321A488BD3FC2B6", hash_generated_field = "5A373FB9977B5C40B848F528877A2297")

    public static final int MANY  = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.328 -0500", hash_original_field = "27C3EAEBA1001B849F6EA314F262257D", hash_generated_field = "2DF5E9A8E0E7AE37313B7662EE56454D")

    public static final int OTHER = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.330 -0500", hash_original_field = "0EFD4B56D5F68F850B84173C34758709", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private  int address;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.333 -0500", hash_original_method = "AA726DD537B18CF5E6F027FB7C25435F", hash_generated_method = "7F0AD65A8C9002FE1E82D3A81B3E91FE")
    
private NativePluralRules(int address) {
        this.address = address;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.336 -0500", hash_original_method = "FA021A9562CA4E3CEECA6C94C3E7379A", hash_generated_method = "9C4F3FCCFD73A5AA8593259E80FC8A37")
    
@Override protected void finalize() throws Throwable {
        try {
            finalizeImpl(address);
        } finally {
            super.finalize();
        }
    }

    /**
     * Returns the constant defined in this class corresponding
     * to the first rule that matches the given value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.340 -0500", hash_original_method = "041DB4B792006075282F7DDDC9E8ADDE", hash_generated_method = "A361DE1CBBE16296B41663D63D6C38BE")
    
public int quantityForInt(int value) {
        return quantityForIntImpl(address, value);
    }
}

