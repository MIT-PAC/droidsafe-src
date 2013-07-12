package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;

public final class NativePluralRules {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.426 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.426 -0400", hash_original_method = "AA726DD537B18CF5E6F027FB7C25435F", hash_generated_method = "CE58BB3507445ED0089597718F7F8DAB")
    private  NativePluralRules(int address) {
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.426 -0400", hash_original_method = "FA021A9562CA4E3CEECA6C94C3E7379A", hash_generated_method = "CF596162EA39646094AA7457D60C8B8A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.426 -0400", hash_original_method = "041DB4B792006075282F7DDDC9E8ADDE", hash_generated_method = "94721F2DB2F0F60253E53DDD05BBBD2D")
    public int quantityForInt(int value) {
        addTaint(value);
        int var34D9B36BFCEDCA890A4CCC5EFBCE4CEC_257525493 = (quantityForIntImpl(address, value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87997183 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87997183;
        // ---------- Original Method ----------
        //return quantityForIntImpl(address, value);
    }

    
    @DSModeled(DSC.SAFE)
    private static void finalizeImpl(int address) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int forLocaleImpl(String localeName) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int quantityForIntImpl(int address, int value) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.426 -0400", hash_original_field = "0AD3B5E18BB61DD23BF70C7B49EB081B", hash_generated_field = "91C59E99B3C50EDD2FE9E46B39A1B227")

    public static final int ZERO  = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.426 -0400", hash_original_field = "70607E1584AC27C49ACCCDAD508F4EE4", hash_generated_field = "509D320BEED69EC62E39B8CEF3DCC030")

    public static final int ONE   = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.426 -0400", hash_original_field = "9BCC5B45C25FAADE763D84E9D9A8F0AA", hash_generated_field = "7E9F843CF6595717ACAAEDE52A536824")

    public static final int TWO   = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.426 -0400", hash_original_field = "B12168B230F954C1DB908A0FBA795E0B", hash_generated_field = "7BCE3E2AA021B15714E206F29D57FF6C")

    public static final int FEW   = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.426 -0400", hash_original_field = "865AAED476BE3113F33CD638F08FBDD1", hash_generated_field = "5A373FB9977B5C40B848F528877A2297")

    public static final int MANY  = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.426 -0400", hash_original_field = "60B8CE58AE8D8B095D8728932BA0E690", hash_generated_field = "2DF5E9A8E0E7AE37313B7662EE56454D")

    public static final int OTHER = 5;
}

