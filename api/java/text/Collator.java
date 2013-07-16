package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Comparator;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.RuleBasedCollatorICU;

public abstract class Collator implements Comparator<Object>, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.532 -0400", hash_original_field = "6B1141D8E17A149C65A8272EB5BA314A", hash_generated_field = "571EB1F8C774D603CEDE0C031FD66C11")

    RuleBasedCollatorICU icuColl;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.533 -0400", hash_original_method = "18D47750B740CE28B17D63629E2E6276", hash_generated_method = "C76C95AB4C34DF3BF3A2153AA412ACD4")
      Collator(RuleBasedCollatorICU icuColl) {
        this.icuColl = icuColl;
        // ---------- Original Method ----------
        //this.icuColl = icuColl;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.533 -0400", hash_original_method = "D1E80A5B5BD1C7C64C7B560256B076FF", hash_generated_method = "7031D0D95FB73398508462AD1E04E9F7")
    protected  Collator() {
        icuColl = new RuleBasedCollatorICU(Locale.getDefault());
        // ---------- Original Method ----------
        //icuColl = new RuleBasedCollatorICU(Locale.getDefault());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.533 -0400", hash_original_method = "2284DB2FEC4C2AB3A601FDA70F532028", hash_generated_method = "83F09617DE8CCEE07BF24896B73E05C2")
    @Override
    public Object clone() {
        try 
        {
            Collator clone = (Collator) super.clone();
            clone.icuColl = (RuleBasedCollatorICU) icuColl.clone();
Object var3DE52045BFD3C1BF3742F994ED6139AD_1137284550 =             clone;
            var3DE52045BFD3C1BF3742F994ED6139AD_1137284550.addTaint(taint);
            return var3DE52045BFD3C1BF3742F994ED6139AD_1137284550;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_587921517 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_587921517.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_587921517;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Collator clone = (Collator) super.clone();
            //clone.icuColl = (RuleBasedCollatorICU) icuColl.clone();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.534 -0400", hash_original_method = "7C02E06D11E019F44D80294CC033745E", hash_generated_method = "9533AC8B9795E2F7443AE67789D2C82F")
    public int compare(Object object1, Object object2) {
        addTaint(object2.getTaint());
        addTaint(object1.getTaint());
        int var02525A7221575FD74EB7D78347857663_329200697 = (compare((String) object1, (String) object2));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530653391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530653391;
        // ---------- Original Method ----------
        //return compare((String) object1, (String) object2);
    }

    
    public abstract int compare(String string1, String string2);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.534 -0400", hash_original_method = "F5E912698B2C6614F01702D72214A0C5", hash_generated_method = "31E7F7A64C257A74894BDC1D4D48697B")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(!(object instanceof Collator))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1884823550 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829122684 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829122684;
        } //End block
        Collator collator = (Collator) object;
        boolean var80158B588E8EED50E688A65D8C880751_1686586694 = (icuColl == null ? collator.icuColl == null : icuColl.equals(collator.icuColl));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1001747718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1001747718;
        // ---------- Original Method ----------
        //if (!(object instanceof Collator)) {
            //return false;
        //}
        //Collator collator = (Collator) object;
        //return icuColl == null ? collator.icuColl == null : icuColl.equals(collator.icuColl);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.535 -0400", hash_original_method = "9F5D52877C91EB2005E3609373B16781", hash_generated_method = "E8EFA7BCC7D1EF0186333354F9B6DDBE")
    public boolean equals(String string1, String string2) {
        addTaint(string2.getTaint());
        addTaint(string1.getTaint());
        boolean var4AAA3B865B408D6B0359D885AC8C6D0F_2032544626 = (compare(string1, string2) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_218075873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_218075873;
        // ---------- Original Method ----------
        //return compare(string1, string2) == 0;
    }

    
        @DSModeled(DSC.SAFE)
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableCollatorLocales();
    }

    
    public abstract CollationKey getCollationKey(String string);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.535 -0400", hash_original_method = "80384F871328DEB63A40E323709EFE86", hash_generated_method = "2028A84192BF0FA62C8B6531DB80D39D")
    public int getDecomposition() {
        int var8AFEB19FFDDCB2325F99ABF72712BDF4_1446620889 = (decompositionMode_ICU_Java(icuColl.getDecomposition()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255892288 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255892288;
        // ---------- Original Method ----------
        //return decompositionMode_ICU_Java(icuColl.getDecomposition());
    }

    
        @DSModeled(DSC.SAFE)
    public static Collator getInstance() {
        return getInstance(Locale.getDefault());
    }

    
        @DSModeled(DSC.SAFE)
    public static Collator getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        return new RuleBasedCollator(new RuleBasedCollatorICU(locale));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.536 -0400", hash_original_method = "1088192DB9E30CE77C93098214CBF249", hash_generated_method = "605A9A96A0D84AA75AA85DAE8355EB03")
    public int getStrength() {
        int var777C2C47A424614F34482572726B9CAF_605909012 = (strength_ICU_Java(icuColl.getStrength()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055390600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055390600;
        // ---------- Original Method ----------
        //return strength_ICU_Java(icuColl.getStrength());
    }

    
        @Override
public abstract int hashCode();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.537 -0400", hash_original_method = "B72BC12BA62E721E78973B8AD1CD75B5", hash_generated_method = "8FC4EEACBB82F592FE4B31D881F338D5")
    public void setDecomposition(int value) {
        addTaint(value);
        icuColl.setDecomposition(decompositionMode_Java_ICU(value));
        // ---------- Original Method ----------
        //icuColl.setDecomposition(decompositionMode_Java_ICU(value));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.537 -0400", hash_original_method = "EE6B9836B69B72CAEC3F00255CD1C53E", hash_generated_method = "9DC092124BC10A7BCD833C2ADFB32F5C")
    public void setStrength(int value) {
        addTaint(value);
        icuColl.setStrength(strength_Java_ICU(value));
        // ---------- Original Method ----------
        //icuColl.setStrength(strength_Java_ICU(value));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.537 -0400", hash_original_method = "59C448B2403440A52B430BC264B57CED", hash_generated_method = "353177A350C69F2BE94B0C6FDA8A0338")
    private int decompositionMode_Java_ICU(int mode) {
        addTaint(mode);
switch(mode){
        case Collator.CANONICAL_DECOMPOSITION:
        int var8037F47D6A3401905B635235A06E7265_567014272 = (RuleBasedCollatorICU.VALUE_ON);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709760332 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709760332;
        case Collator.NO_DECOMPOSITION:
        int var5634131098D25D5F8C59E4CAE1222EFA_1794899976 = (RuleBasedCollatorICU.VALUE_OFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132135371 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132135371;
}        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1689867236 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1689867236.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1689867236;
        // ---------- Original Method ----------
        //switch (mode) {
        //case Collator.CANONICAL_DECOMPOSITION:
            //return RuleBasedCollatorICU.VALUE_ON;
        //case Collator.NO_DECOMPOSITION:
            //return RuleBasedCollatorICU.VALUE_OFF;
        //}
        //throw new IllegalArgumentException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.538 -0400", hash_original_method = "221AF1495063A31B1C807B8FB0041DE6", hash_generated_method = "B7BC6C62E79A824E42C9B7AC34A1F87C")
    private int decompositionMode_ICU_Java(int mode) {
        addTaint(mode);
        int javaMode = mode;
switch(mode){
        case RuleBasedCollatorICU.VALUE_OFF:
        javaMode = Collator.NO_DECOMPOSITION;
        break;
        case RuleBasedCollatorICU.VALUE_ON:
        javaMode = Collator.CANONICAL_DECOMPOSITION;
        break;
}        int varD7122828A8C44972D2F5358612FA62CF_1019802414 = (javaMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200086912 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200086912;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.538 -0400", hash_original_method = "8D5EE21418DD2AA072EEA3359693FB17", hash_generated_method = "918534DC12B39D4B59E977A7A11E050D")
    private int strength_Java_ICU(int value) {
        addTaint(value);
switch(value){
        case Collator.PRIMARY:
        int varFA90E93FE5B8B7165CE7D7F4AA4F1FB8_299681327 = (RuleBasedCollatorICU.VALUE_PRIMARY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2032631223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2032631223;
        case Collator.SECONDARY:
        int var0652109A4927527137A2BC2E5666ACCE_1491363642 = (RuleBasedCollatorICU.VALUE_SECONDARY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194519441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194519441;
        case Collator.TERTIARY:
        int var40E3C4BB8548E76FE38EE9BBDCF30C84_1324302494 = (RuleBasedCollatorICU.VALUE_TERTIARY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_28172614 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_28172614;
        case Collator.IDENTICAL:
        int var7138ACE0F178048644292E7A0B5832C5_180233871 = (RuleBasedCollatorICU.VALUE_IDENTICAL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606512058 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606512058;
}        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_485836883 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_485836883.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_485836883;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.539 -0400", hash_original_method = "28CE8F975C7774291F421ACF5AFE6047", hash_generated_method = "835BEE8D73425C8FEA08671329742B88")
    private int strength_ICU_Java(int value) {
        addTaint(value);
        int javaValue = value;
switch(value){
        case RuleBasedCollatorICU.VALUE_PRIMARY:
        javaValue = Collator.PRIMARY;
        break;
        case RuleBasedCollatorICU.VALUE_SECONDARY:
        javaValue = Collator.SECONDARY;
        break;
        case RuleBasedCollatorICU.VALUE_TERTIARY:
        javaValue = Collator.TERTIARY;
        break;
        case RuleBasedCollatorICU.VALUE_IDENTICAL:
        javaValue = Collator.IDENTICAL;
        break;
}        int var8F8828D22EEB1215F16944AB7EA72FED_319180737 = (javaValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857213972 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857213972;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.539 -0400", hash_original_field = "6762616902C4FE35F14AF3BC1C4F2500", hash_generated_field = "9E43ED873605C1C1034619325D9DA889")

    public static final int NO_DECOMPOSITION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.539 -0400", hash_original_field = "50A96EA9E03B0B60EB4DCA1CA6213A49", hash_generated_field = "CD40FC2067D59891F7BA4573BEF1DB6B")

    public static final int CANONICAL_DECOMPOSITION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.539 -0400", hash_original_field = "03BA1A0EFA6772009E54D1243F9D3082", hash_generated_field = "792407D4F0E9907685F71381C9FD4E61")

    public static final int FULL_DECOMPOSITION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.539 -0400", hash_original_field = "52F61C0293E41BBFC5016FA11A7434B3", hash_generated_field = "B6442BE7EB0FE61CE720EB713BF63684")

    public static final int PRIMARY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.540 -0400", hash_original_field = "B69EE0CFDDFB918151F6D2BB7D5A5502", hash_generated_field = "545302936326A1D8CF924AC93757F924")

    public static final int SECONDARY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.540 -0400", hash_original_field = "1080F4A9469C4437D3D2B60A2EB3B472", hash_generated_field = "CA7F342F2246C9B80B01671D88E6D41C")

    public static final int TERTIARY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.540 -0400", hash_original_field = "299489327E17DC0A2DF650B8583A7842", hash_generated_field = "19D42BD9A98581EBEB400999C2E7C1B9")

    public static final int IDENTICAL = 3;
}

