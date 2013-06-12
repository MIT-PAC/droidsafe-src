package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Locale;

public final class NativePluralRules {
    public static final int ZERO  = 0;
    public static final int ONE   = 1;
    public static final int TWO   = 2;
    public static final int FEW   = 3;
    public static final int MANY  = 4;
    public static final int OTHER = 5;
    private final int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.415 -0400", hash_original_method = "AA726DD537B18CF5E6F027FB7C25435F", hash_generated_method = "43CAFB206D983C03DBE95692AD4B8CB1")
    @DSModeled(DSC.SAFE)
    private NativePluralRules(int address) {
        dsTaint.addTaint(address);
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.415 -0400", hash_original_method = "FA021A9562CA4E3CEECA6C94C3E7379A", hash_generated_method = "2F0F760F69804AF872BC637F6319388C")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            finalizeImpl(address);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //finalizeImpl(address);
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.415 -0400", hash_original_method = "4338DBAED1414C4DB4ED582B56BC090E", hash_generated_method = "9D190F0D6F3F0F768AEE2FC593ADE443")
    public static NativePluralRules forLocale(Locale locale) {
        return new NativePluralRules(forLocaleImpl(locale.toString()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.416 -0400", hash_original_method = "041DB4B792006075282F7DDDC9E8ADDE", hash_generated_method = "71AC3A2583C6BF2A865B4DED92A468B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int quantityForInt(int value) {
        dsTaint.addTaint(value);
        int var241482E4026E286350AA36B21F0B0AA5_1527957205 = (quantityForIntImpl(address, value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return quantityForIntImpl(address, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.416 -0400", hash_original_method = "6C0FB45F2D3D59341F679300293E5D6A", hash_generated_method = "0BF4641792333074A7B133C3FE9B1B3F")
    private static void finalizeImpl(int address) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.416 -0400", hash_original_method = "595C7C121D33E635565A2FD6B6E4B355", hash_generated_method = "7A1C7E273B47A1FA82DDB4823617BA40")
    private static int forLocaleImpl(String localeName) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.416 -0400", hash_original_method = "D4407CF23868C0FF3E55DA4D48672E7A", hash_generated_method = "DD6AFBAFFC69D1354F4287111FD7AFEB")
    private static int quantityForIntImpl(int address, int value) {
    	return DSUtils.UNKNOWN_INT;
    }

    
}


