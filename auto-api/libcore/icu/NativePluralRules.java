package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;

public final class NativePluralRules {
    private int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.707 -0400", hash_original_method = "AA726DD537B18CF5E6F027FB7C25435F", hash_generated_method = "C2262A18762027CB0C34E0EA7BDA1961")
    @DSModeled(DSC.SAFE)
    private NativePluralRules(int address) {
        dsTaint.addTaint(address);
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.707 -0400", hash_original_method = "FA021A9562CA4E3CEECA6C94C3E7379A", hash_generated_method = "CF596162EA39646094AA7457D60C8B8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        public static NativePluralRules forLocale(Locale locale) {
        return new NativePluralRules(forLocaleImpl(locale.toString()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.708 -0400", hash_original_method = "041DB4B792006075282F7DDDC9E8ADDE", hash_generated_method = "2A07F9D0533845848775E1634214F618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int quantityForInt(int value) {
        dsTaint.addTaint(value);
        int var241482E4026E286350AA36B21F0B0AA5_234129730 = (quantityForIntImpl(address, value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return quantityForIntImpl(address, value);
    }

    
        private static void finalizeImpl(int address) {
    }

    
        private static int forLocaleImpl(String localeName) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int quantityForIntImpl(int address, int value) {
        return DSUtils.UNKNOWN_INT;
    }

    
    public static final int ZERO  = 0;
    public static final int ONE   = 1;
    public static final int TWO   = 2;
    public static final int FEW   = 3;
    public static final int MANY  = 4;
    public static final int OTHER = 5;
}

