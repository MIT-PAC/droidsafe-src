package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Comparator;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.RuleBasedCollatorICU;

public abstract class Collator implements Comparator<Object>, Cloneable {
    public static int NO_DECOMPOSITION = 0;
    public static int CANONICAL_DECOMPOSITION = 1;
    public static int FULL_DECOMPOSITION = 2;
    public static int PRIMARY = 0;
    public static int SECONDARY = 1;
    public static int TERTIARY = 2;
    public static int IDENTICAL = 3;
    RuleBasedCollatorICU icuColl;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.571 -0400", hash_original_method = "18D47750B740CE28B17D63629E2E6276", hash_generated_method = "AFFCCB9276D27CEC35FA2CC0DCDC1A4C")
    @DSModeled(DSC.SAFE)
     Collator(RuleBasedCollatorICU icuColl) {
        dsTaint.addTaint(icuColl.dsTaint);
        // ---------- Original Method ----------
        //this.icuColl = icuColl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.573 -0400", hash_original_method = "D1E80A5B5BD1C7C64C7B560256B076FF", hash_generated_method = "1ED53A066CBA5BB99B813518AE1EE1D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collator() {
        icuColl = new RuleBasedCollatorICU(Locale.getDefault());
        // ---------- Original Method ----------
        //icuColl = new RuleBasedCollatorICU(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.576 -0400", hash_original_method = "2284DB2FEC4C2AB3A601FDA70F532028", hash_generated_method = "04991CD77A748A617B143DAEAA0777DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Collator clone;
            clone = (Collator) super.clone();
            clone.icuColl = (RuleBasedCollatorICU) icuColl.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //Collator clone = (Collator) super.clone();
            //clone.icuColl = (RuleBasedCollatorICU) icuColl.clone();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.578 -0400", hash_original_method = "7C02E06D11E019F44D80294CC033745E", hash_generated_method = "37024D4B6D0F695DE2D6037B0B9C02BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compare(Object object1, Object object2) {
        dsTaint.addTaint(object1.dsTaint);
        dsTaint.addTaint(object2.dsTaint);
        int var3D08E6BE7BAEBF1ADD53CD56D75BAFB9_180704831 = (compare((String) object1, (String) object2));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare((String) object1, (String) object2);
    }

    
    public abstract int compare(String string1, String string2);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.585 -0400", hash_original_method = "F5E912698B2C6614F01702D72214A0C5", hash_generated_method = "7C7B690BF0E93E2C9F1C82846700FEEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Collator collator;
        collator = (Collator) object;
        {
            Object varCD4CA96E36BA3373FDF786128F7C41DA_1425727669 = (icuColl.equals(collator.icuColl));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(object instanceof Collator)) {
            //return false;
        //}
        //Collator collator = (Collator) object;
        //return icuColl == null ? collator.icuColl == null : icuColl.equals(collator.icuColl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.588 -0400", hash_original_method = "9F5D52877C91EB2005E3609373B16781", hash_generated_method = "AE9D0E09B900DBBA2372D2C00601C55C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(String string1, String string2) {
        dsTaint.addTaint(string2);
        dsTaint.addTaint(string1);
        boolean var6B3C6DAF5F69B2C178015AF55DE756CF_280425497 = (compare(string1, string2) == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return compare(string1, string2) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.590 -0400", hash_original_method = "079D2BDCF2543C9EF39D2D400341A9D8", hash_generated_method = "746A813ED9B4684977432502F2AA3677")
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableCollatorLocales();
    }

    
    public abstract CollationKey getCollationKey(String string);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.593 -0400", hash_original_method = "80384F871328DEB63A40E323709EFE86", hash_generated_method = "3A9220ECFE175D53751F49FE69DF6E49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDecomposition() {
        int varB36BB4C33019F3C63B2B2F4931AB5EB3_1760823066 = (decompositionMode_ICU_Java(icuColl.getDecomposition()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return decompositionMode_ICU_Java(icuColl.getDecomposition());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.595 -0400", hash_original_method = "36423D53959653C2984C84B905F35ABE", hash_generated_method = "5922C2B7903C130A111FFD3F547D8C2C")
    public static Collator getInstance() {
        return getInstance(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.596 -0400", hash_original_method = "FDDB3D7E9466CD25FA15155141F4B994", hash_generated_method = "8A20382FC64DCF44DF83452E25D2BB49")
    public static Collator getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        return new RuleBasedCollator(new RuleBasedCollatorICU(locale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.598 -0400", hash_original_method = "1088192DB9E30CE77C93098214CBF249", hash_generated_method = "A58C2D1C9FE1D07A6785B0875F766C44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStrength() {
        int varFC203D3A2608E71726BA6B11C75A12F4_174907005 = (strength_ICU_Java(icuColl.getStrength()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return strength_ICU_Java(icuColl.getStrength());
    }

    
        @Override
public abstract int hashCode();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.601 -0400", hash_original_method = "B72BC12BA62E721E78973B8AD1CD75B5", hash_generated_method = "64770E93D05DF3ECDFE7B4E16CB7E7AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDecomposition(int value) {
        dsTaint.addTaint(value);
        icuColl.setDecomposition(decompositionMode_Java_ICU(value));
        // ---------- Original Method ----------
        //icuColl.setDecomposition(decompositionMode_Java_ICU(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.603 -0400", hash_original_method = "EE6B9836B69B72CAEC3F00255CD1C53E", hash_generated_method = "8DBF60EFF2EB4AF0EE63DF6357C25966")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStrength(int value) {
        dsTaint.addTaint(value);
        icuColl.setStrength(strength_Java_ICU(value));
        // ---------- Original Method ----------
        //icuColl.setStrength(strength_Java_ICU(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.606 -0400", hash_original_method = "59C448B2403440A52B430BC264B57CED", hash_generated_method = "F65E02A1193B2B679AA158B7CD868E95")
    @DSModeled(DSC.SAFE)
    private int decompositionMode_Java_ICU(int mode) {
        dsTaint.addTaint(mode);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (mode) {
        //case Collator.CANONICAL_DECOMPOSITION:
            //return RuleBasedCollatorICU.VALUE_ON;
        //case Collator.NO_DECOMPOSITION:
            //return RuleBasedCollatorICU.VALUE_OFF;
        //}
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.609 -0400", hash_original_method = "221AF1495063A31B1C807B8FB0041DE6", hash_generated_method = "D2E46A1D1DC9AF7FFEF7A037D6842F38")
    @DSModeled(DSC.SAFE)
    private int decompositionMode_ICU_Java(int mode) {
        dsTaint.addTaint(mode);
        int javaMode;
        javaMode = mode;
        //Begin case RuleBasedCollatorICU.VALUE_OFF 
        javaMode = Collator.NO_DECOMPOSITION;
        //End case RuleBasedCollatorICU.VALUE_OFF 
        //Begin case RuleBasedCollatorICU.VALUE_ON 
        javaMode = Collator.CANONICAL_DECOMPOSITION;
        //End case RuleBasedCollatorICU.VALUE_ON 
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int javaMode = mode;
        //switch (mode) {
        //case RuleBasedCollatorICU.VALUE_OFF:
            //javaMode = Collator.NO_DECOMPOSITION;
            //break;
        //case RuleBasedCollatorICU.VALUE_ON:
            //javaMode = Collator.CANONICAL_DECOMPOSITION;
            //break;
        //}
        //return javaMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.616 -0400", hash_original_method = "8D5EE21418DD2AA072EEA3359693FB17", hash_generated_method = "5FFE8D53B392407340DF07CB7D7CF021")
    @DSModeled(DSC.SAFE)
    private int strength_Java_ICU(int value) {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (value) {
        //case Collator.PRIMARY:
            //return RuleBasedCollatorICU.VALUE_PRIMARY;
        //case Collator.SECONDARY:
            //return RuleBasedCollatorICU.VALUE_SECONDARY;
        //case Collator.TERTIARY:
            //return RuleBasedCollatorICU.VALUE_TERTIARY;
        //case Collator.IDENTICAL:
            //return RuleBasedCollatorICU.VALUE_IDENTICAL;
        //}
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:06:58.620 -0400", hash_original_method = "28CE8F975C7774291F421ACF5AFE6047", hash_generated_method = "3ED50A01C9287AC467E3B0816800E853")
    @DSModeled(DSC.SAFE)
    private int strength_ICU_Java(int value) {
        dsTaint.addTaint(value);
        int javaValue;
        javaValue = value;
        //Begin case RuleBasedCollatorICU.VALUE_PRIMARY 
        javaValue = Collator.PRIMARY;
        //End case RuleBasedCollatorICU.VALUE_PRIMARY 
        //Begin case RuleBasedCollatorICU.VALUE_SECONDARY 
        javaValue = Collator.SECONDARY;
        //End case RuleBasedCollatorICU.VALUE_SECONDARY 
        //Begin case RuleBasedCollatorICU.VALUE_TERTIARY 
        javaValue = Collator.TERTIARY;
        //End case RuleBasedCollatorICU.VALUE_TERTIARY 
        //Begin case RuleBasedCollatorICU.VALUE_IDENTICAL 
        javaValue = Collator.IDENTICAL;
        //End case RuleBasedCollatorICU.VALUE_IDENTICAL 
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int javaValue = value;
        //switch (value) {
        //case RuleBasedCollatorICU.VALUE_PRIMARY:
            //javaValue = Collator.PRIMARY;
            //break;
        //case RuleBasedCollatorICU.VALUE_SECONDARY:
            //javaValue = Collator.SECONDARY;
            //break;
        //case RuleBasedCollatorICU.VALUE_TERTIARY:
            //javaValue = Collator.TERTIARY;
            //break;
        //case RuleBasedCollatorICU.VALUE_IDENTICAL:
            //javaValue = Collator.IDENTICAL;
            //break;
        //}
        //return javaValue;
    }

    
}


