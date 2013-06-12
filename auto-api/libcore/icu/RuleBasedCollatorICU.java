package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.text.CharacterIterator;
import java.text.CollationKey;
import java.text.ParseException;
import java.util.Locale;

public final class RuleBasedCollatorICU implements Cloneable {
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
    private int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.422 -0400", hash_original_method = "2EB56AAF7E8D69BAE596BFC26154D628", hash_generated_method = "8AE6CA73A13C4E054290C171073AAFC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuleBasedCollatorICU(String rules) throws ParseException {
        dsTaint.addTaint(rules);
        {
            throw new NullPointerException();
        } //End block
        address = NativeCollation.openCollatorFromRules(rules, VALUE_OFF, VALUE_DEFAULT_STRENGTH);
        // ---------- Original Method ----------
        //if (rules == null) {
            //throw new NullPointerException();
        //}
        //address = NativeCollation.openCollatorFromRules(rules, VALUE_OFF, VALUE_DEFAULT_STRENGTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.422 -0400", hash_original_method = "A5C323A76C17F2A5DAD617321306AD0B", hash_generated_method = "D52FF7128BB966049BA811D5ED0FF558")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuleBasedCollatorICU(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        address = NativeCollation.openCollator(locale.toString());
        // ---------- Original Method ----------
        //address = NativeCollation.openCollator(locale.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.422 -0400", hash_original_method = "A318B723665122F54B169082CADE3CC3", hash_generated_method = "48C1668768049F74BD1F92D4EE931AC5")
    @DSModeled(DSC.SAFE)
    private RuleBasedCollatorICU(int address) {
        dsTaint.addTaint(address);
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.422 -0400", hash_original_method = "2DC05452E0FCF4981A0124341AE4FC53", hash_generated_method = "9E9BE4339B2FE687FDE52E1A8F6323E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        Object var8F5F61AC7EE26E54DFEB001C6201BDE5_491927627 = (new RuleBasedCollatorICU(NativeCollation.safeClone(address)));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new RuleBasedCollatorICU(NativeCollation.safeClone(address));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.422 -0400", hash_original_method = "49991F8A57E565642E1A41A931B1C001", hash_generated_method = "8EA7DD14C5E246E9702E46C5E300FE78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compare(String source, String target) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(target);
        int var3F8925F8F393AB9ECF7144403EEC9A0B_338510594 = (NativeCollation.compare(address, source, target));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.compare(address, source, target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.422 -0400", hash_original_method = "239D987CE6D9B4CADAB8F872E8E9D57B", hash_generated_method = "6FA9225F57A0B4121EC80A9D20086C7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDecomposition() {
        int var8764316B4FF2BBD167E95966AD23BE1C_2053431473 = (NativeCollation.getAttribute(address, DECOMPOSITION_MODE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, DECOMPOSITION_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.422 -0400", hash_original_method = "44F9BFBEB06030096990BB2E8C89DED9", hash_generated_method = "9D43085E050FBC3293CC7BCB1794C8F6")
    @DSModeled(DSC.SAFE)
    public void setDecomposition(int mode) {
        dsTaint.addTaint(mode);
        NativeCollation.setAttribute(address, DECOMPOSITION_MODE, mode);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, DECOMPOSITION_MODE, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.422 -0400", hash_original_method = "AAB074F82BF97FFE28F8563C1D57A964", hash_generated_method = "2FAEF19D0089A57695C78CFF814566BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStrength() {
        int var2C5F8038E1CD8A7F4593063EC907144D_1205773583 = (NativeCollation.getAttribute(address, STRENGTH));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, STRENGTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.422 -0400", hash_original_method = "B780FC0CB29AFE09B6EA92E53FEFCCC0", hash_generated_method = "960D8688C759EBCBD9FBFA6B93F05314")
    @DSModeled(DSC.SAFE)
    public void setStrength(int strength) {
        dsTaint.addTaint(strength);
        NativeCollation.setAttribute(address, STRENGTH, strength);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, STRENGTH, strength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.422 -0400", hash_original_method = "EE4A6867E88BF501B4AF7B7DE8C48A39", hash_generated_method = "7763D98F6250EF06DC058142369F232F")
    @DSModeled(DSC.SAFE)
    public void setAttribute(int type, int value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(type);
        NativeCollation.setAttribute(address, type, value);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, type, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.423 -0400", hash_original_method = "7E0368EE82E5C263E0341D3245A9B850", hash_generated_method = "5C19D500B7C626290ADB6995A26BA6DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAttribute(int type) {
        dsTaint.addTaint(type);
        int var976756D3926C50E33324CA8FC446B22F_21265238 = (NativeCollation.getAttribute(address, type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.423 -0400", hash_original_method = "AD47FDA34CF9DDAC21CE9DA304C498D4", hash_generated_method = "2D2821E81542B15FDA5C0738E119125A")
    @DSModeled(DSC.SAFE)
    public CollationKey getCollationKey(String source) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(source);
        byte[] key;
        key = NativeCollation.getSortKey(address, source);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.423 -0400", hash_original_method = "FFB9880C0352BAA3924C6058A715E6CF", hash_generated_method = "BF8AD6BCE31C36C34D7F2C7C8267EF20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRules() {
        String varD9B42CCEABE925A3BCC5B050F0929BC4_1101951311 = (NativeCollation.getRules(address));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return NativeCollation.getRules(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.423 -0400", hash_original_method = "37423170550704AB69E3E5DFF5BA23DD", hash_generated_method = "0281DD27544E195D752F568CB7AD5F85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CollationElementIteratorICU getCollationElementIterator(String source) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(source);
        CollationElementIteratorICU var136B1F1A0485DBF55E0A8E29C5E82926_988144919 = (CollationElementIteratorICU.getInstance(address, source));
        return (CollationElementIteratorICU)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return CollationElementIteratorICU.getInstance(address, source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.423 -0400", hash_original_method = "C7D7D5ADEA090F255D72693DB837681B", hash_generated_method = "CF882D7B667DB82BC07F14739EDF46D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CollationElementIteratorICU getCollationElementIterator(CharacterIterator it) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(it.dsTaint);
        CollationElementIteratorICU varDE669171530192017DCF658462701754_1128089559 = (getCollationElementIterator(characterIteratorToString(it)));
        return (CollationElementIteratorICU)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getCollationElementIterator(characterIteratorToString(it));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.423 -0400", hash_original_method = "7AE77B5FB071109A54141F0830318144", hash_generated_method = "2F5D43B1245F08225BD951197EC87172")
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
        String varEA70154FDA28CC59402440C6317B57EF_479546472 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (char ch = it.current(); ch != CharacterIterator.DONE; ch = it.next()) {
            //result.append(ch);
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.423 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "34D61A94E1D35565606B91BAEFC3E26A")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.423 -0400", hash_original_method = "33726095AFF4CCE7845E5A8AF95C560E", hash_generated_method = "CD9AA4AA83AC0C55E08E11B93174D888")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(String source, String target) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(target);
        boolean var2462A09B5BDA2F592435FFC5DCFB379A_1546670899 = ((compare(source, target) == 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (compare(source, target) == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.423 -0400", hash_original_method = "7C2D1C08D1C2665AA117147559E8D29C", hash_generated_method = "7D39235DE20404CECE9F6EE2C31EC9EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        RuleBasedCollatorICU rhs;
        rhs = (RuleBasedCollatorICU) object;
        boolean varB5945B169E6BD3FC8C510D0EAD3D0F0F_283881615 = (getRules().equals(rhs.getRules()) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.423 -0400", hash_original_method = "4A24C365D6C63EAE3926032A3798E7DF", hash_generated_method = "AD52D163CFD183F7276B3C03EF84D405")
    @DSModeled(DSC.SAFE)
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

    
}


