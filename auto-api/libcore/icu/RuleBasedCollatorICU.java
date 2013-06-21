package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.CharacterIterator;
import java.text.CollationKey;
import java.text.ParseException;
import java.util.Locale;

public final class RuleBasedCollatorICU implements Cloneable {
    private int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.745 -0400", hash_original_method = "2EB56AAF7E8D69BAE596BFC26154D628", hash_generated_method = "1745DFD7990E3C81A293439DA464552D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuleBasedCollatorICU(String rules) throws ParseException {
        dsTaint.addTaint(rules);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        address = NativeCollation.openCollatorFromRules(rules, VALUE_OFF, VALUE_DEFAULT_STRENGTH);
        // ---------- Original Method ----------
        //if (rules == null) {
            //throw new NullPointerException();
        //}
        //address = NativeCollation.openCollatorFromRules(rules, VALUE_OFF, VALUE_DEFAULT_STRENGTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.745 -0400", hash_original_method = "A5C323A76C17F2A5DAD617321306AD0B", hash_generated_method = "A3C601A03A14451E6F316BF11A77038E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuleBasedCollatorICU(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        address = NativeCollation.openCollator(locale.toString());
        // ---------- Original Method ----------
        //address = NativeCollation.openCollator(locale.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.745 -0400", hash_original_method = "A318B723665122F54B169082CADE3CC3", hash_generated_method = "AA89EE4EBA8DB2549FAE8B3F7B0CC30E")
    @DSModeled(DSC.SAFE)
    private RuleBasedCollatorICU(int address) {
        dsTaint.addTaint(address);
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.745 -0400", hash_original_method = "2DC05452E0FCF4981A0124341AE4FC53", hash_generated_method = "9A6F83B675040CD5FA7F3145A7716F8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        Object var8F5F61AC7EE26E54DFEB001C6201BDE5_1812332319 = (new RuleBasedCollatorICU(NativeCollation.safeClone(address)));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new RuleBasedCollatorICU(NativeCollation.safeClone(address));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.746 -0400", hash_original_method = "49991F8A57E565642E1A41A931B1C001", hash_generated_method = "8D29915A88113BF53833217068D6444C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compare(String source, String target) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(target);
        int var3F8925F8F393AB9ECF7144403EEC9A0B_789061193 = (NativeCollation.compare(address, source, target));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.compare(address, source, target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.746 -0400", hash_original_method = "239D987CE6D9B4CADAB8F872E8E9D57B", hash_generated_method = "AE19C4B3C16BEA8551E22C732DF88C04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDecomposition() {
        int var8764316B4FF2BBD167E95966AD23BE1C_1750022936 = (NativeCollation.getAttribute(address, DECOMPOSITION_MODE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, DECOMPOSITION_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.746 -0400", hash_original_method = "44F9BFBEB06030096990BB2E8C89DED9", hash_generated_method = "79FB9A99822593813957B5B2130310B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDecomposition(int mode) {
        dsTaint.addTaint(mode);
        NativeCollation.setAttribute(address, DECOMPOSITION_MODE, mode);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, DECOMPOSITION_MODE, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.746 -0400", hash_original_method = "AAB074F82BF97FFE28F8563C1D57A964", hash_generated_method = "7A71E614D592589544F7A595B545D2C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStrength() {
        int var2C5F8038E1CD8A7F4593063EC907144D_1666049805 = (NativeCollation.getAttribute(address, STRENGTH));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, STRENGTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.746 -0400", hash_original_method = "B780FC0CB29AFE09B6EA92E53FEFCCC0", hash_generated_method = "440C435C6DF1227B54B5A2D0169A8AE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStrength(int strength) {
        dsTaint.addTaint(strength);
        NativeCollation.setAttribute(address, STRENGTH, strength);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, STRENGTH, strength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.746 -0400", hash_original_method = "EE4A6867E88BF501B4AF7B7DE8C48A39", hash_generated_method = "DB0D2F0B19A3402EB6361F202678F739")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAttribute(int type, int value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(type);
        NativeCollation.setAttribute(address, type, value);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, type, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.747 -0400", hash_original_method = "7E0368EE82E5C263E0341D3245A9B850", hash_generated_method = "A1EA7A71763EE6E874604BB0663504D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAttribute(int type) {
        dsTaint.addTaint(type);
        int var976756D3926C50E33324CA8FC446B22F_2057150341 = (NativeCollation.getAttribute(address, type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.747 -0400", hash_original_method = "AD47FDA34CF9DDAC21CE9DA304C498D4", hash_generated_method = "8887173603707B736F60CF41AA3A8F9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CollationKey getCollationKey(String source) {
        dsTaint.addTaint(source);
        byte[] key;
        key = NativeCollation.getSortKey(address, source);
        CollationKey var3ECFDF51019ECB5A385D4E036EFB00BE_1427480989 = (new CollationKeyICU(source, key));
        return (CollationKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (source == null) {
            //return null;
        //}
        //byte[] key = NativeCollation.getSortKey(address, source);
        //if (key == null) {
            //return null;
        //}
        //return new CollationKeyICU(source, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.747 -0400", hash_original_method = "FFB9880C0352BAA3924C6058A715E6CF", hash_generated_method = "BDB58127192D47D1B7226C8573A9897B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRules() {
        String varD9B42CCEABE925A3BCC5B050F0929BC4_1012310263 = (NativeCollation.getRules(address));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return NativeCollation.getRules(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.747 -0400", hash_original_method = "37423170550704AB69E3E5DFF5BA23DD", hash_generated_method = "D2348C85D373AA8DE2FEE4E3314B45E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CollationElementIteratorICU getCollationElementIterator(String source) {
        dsTaint.addTaint(source);
        CollationElementIteratorICU var136B1F1A0485DBF55E0A8E29C5E82926_432137033 = (CollationElementIteratorICU.getInstance(address, source));
        return (CollationElementIteratorICU)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return CollationElementIteratorICU.getInstance(address, source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.747 -0400", hash_original_method = "C7D7D5ADEA090F255D72693DB837681B", hash_generated_method = "E020AEE506CBE2A75326A867DECB6727")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CollationElementIteratorICU getCollationElementIterator(CharacterIterator it) {
        dsTaint.addTaint(it.dsTaint);
        CollationElementIteratorICU varDE669171530192017DCF658462701754_2129781644 = (getCollationElementIterator(characterIteratorToString(it)));
        return (CollationElementIteratorICU)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getCollationElementIterator(characterIteratorToString(it));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.748 -0400", hash_original_method = "7AE77B5FB071109A54141F0830318144", hash_generated_method = "E27F0DA864966C07EB26876DEED2CA30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String characterIteratorToString(CharacterIterator it) {
        dsTaint.addTaint(it.dsTaint);
        StringBuilder result;
        result = new StringBuilder();
        {
            char ch;
            ch = it.current();
            ch = it.next();
            {
                result.append(ch);
            } //End block
        } //End collapsed parenthetic
        String varEA70154FDA28CC59402440C6317B57EF_2061928185 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (char ch = it.current(); ch != CharacterIterator.DONE; ch = it.next()) {
            //result.append(ch);
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.748 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "4AD6E921A7451B952F62B962966BB07C")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.748 -0400", hash_original_method = "33726095AFF4CCE7845E5A8AF95C560E", hash_generated_method = "88EA2C3897000E95B7AC3168A17CB4E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(String source, String target) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(target);
        boolean var2462A09B5BDA2F592435FFC5DCFB379A_1828146368 = ((compare(source, target) == 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (compare(source, target) == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.748 -0400", hash_original_method = "7C2D1C08D1C2665AA117147559E8D29C", hash_generated_method = "28FE4B0B6D511A24154775A0D6CD25D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean var83F06663CC91C8DF2EADF537513DA66F_1476769898 = (object ==  this);
        } //End collapsed parenthetic
        RuleBasedCollatorICU rhs;
        rhs = (RuleBasedCollatorICU) object;
        boolean varB5945B169E6BD3FC8C510D0EAD3D0F0F_1625625077 = (getRules().equals(rhs.getRules()) &&
                getStrength() == rhs.getStrength() &&
                getDecomposition() == rhs.getDecomposition());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (object ==  this) {
            //return true;
        //}
        //if (!(object instanceof RuleBasedCollatorICU)) {
            //return false;
        //}
        //RuleBasedCollatorICU rhs = (RuleBasedCollatorICU) object;
        //return getRules().equals(rhs.getRules()) &&
                //getStrength() == rhs.getStrength() &&
                //getDecomposition() == rhs.getDecomposition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.748 -0400", hash_original_method = "4A24C365D6C63EAE3926032A3798E7DF", hash_generated_method = "3E9A27D176EE88C06944999305FF2B51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            NativeCollation.closeCollator(address);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //NativeCollation.closeCollator(address);
        //} finally {
            //super.finalize();
        //}
    }

    
    public static final int VALUE_DEFAULT = -1;
    public static final int VALUE_PRIMARY = 0;
    public static final int VALUE_SECONDARY = 1;
    public static final int VALUE_TERTIARY = 2;
    public static final int VALUE_DEFAULT_STRENGTH = VALUE_TERTIARY;
    public static final int VALUE_QUATERNARY = 3;
    public static final int VALUE_IDENTICAL = 15;
    public static final int VALUE_OFF = 16;
    public static final int VALUE_ON = 17;
    public static final int VALUE_SHIFTED = 20;
    public static final int VALUE_NON_IGNORABLE = 21;
    public static final int VALUE_LOWER_FIRST = 24;
    public static final int VALUE_UPPER_FIRST = 25;
    public static final int VALUE_ON_WITHOUT_HANGUL = 28;
    public static final int VALUE_ATTRIBUTE_VALUE_COUNT = 29;
    public static final int FRENCH_COLLATION = 0;
    public static final int ALTERNATE_HANDLING = 1;
    public static final int CASE_FIRST = 2;
    public static final int CASE_LEVEL = 3;
    public static final int DECOMPOSITION_MODE = 4;
    public static final int STRENGTH = 5;
}

