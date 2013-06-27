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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.888 -0400", hash_original_field = "6B1141D8E17A149C65A8272EB5BA314A", hash_generated_field = "571EB1F8C774D603CEDE0C031FD66C11")

    RuleBasedCollatorICU icuColl;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.889 -0400", hash_original_method = "18D47750B740CE28B17D63629E2E6276", hash_generated_method = "C76C95AB4C34DF3BF3A2153AA412ACD4")
      Collator(RuleBasedCollatorICU icuColl) {
        this.icuColl = icuColl;
        // ---------- Original Method ----------
        //this.icuColl = icuColl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.889 -0400", hash_original_method = "D1E80A5B5BD1C7C64C7B560256B076FF", hash_generated_method = "7031D0D95FB73398508462AD1E04E9F7")
    protected  Collator() {
        icuColl = new RuleBasedCollatorICU(Locale.getDefault());
        // ---------- Original Method ----------
        //icuColl = new RuleBasedCollatorICU(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.890 -0400", hash_original_method = "2284DB2FEC4C2AB3A601FDA70F532028", hash_generated_method = "E348E7725E0F7B366359D4FE2922F491")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_742306115 = null; //Variable for return #1
        try 
        {
            Collator clone;
            clone = (Collator) super.clone();
            clone.icuColl = (RuleBasedCollatorICU) icuColl.clone();
            varB4EAC82CA7396A68D541C85D26508E83_742306115 = clone;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_742306115.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_742306115;
        // ---------- Original Method ----------
        //try {
            //Collator clone = (Collator) super.clone();
            //clone.icuColl = (RuleBasedCollatorICU) icuColl.clone();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.894 -0400", hash_original_method = "7C02E06D11E019F44D80294CC033745E", hash_generated_method = "79C50372897C8207075B06F6ABD49FA3")
    public int compare(Object object1, Object object2) {
        int var3D08E6BE7BAEBF1ADD53CD56D75BAFB9_1241177502 = (compare((String) object1, (String) object2));
        addTaint(object1.getTaint());
        addTaint(object2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22514122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22514122;
        // ---------- Original Method ----------
        //return compare((String) object1, (String) object2);
    }

    
    public abstract int compare(String string1, String string2);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.894 -0400", hash_original_method = "F5E912698B2C6614F01702D72214A0C5", hash_generated_method = "C5C9F462AD4813A05B1C7B7C6623A192")
    @Override
    public boolean equals(Object object) {
        Collator collator;
        collator = (Collator) object;
        {
            Object varCD4CA96E36BA3373FDF786128F7C41DA_524265284 = (icuColl.equals(collator.icuColl));
        } //End flattened ternary
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117656984 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117656984;
        // ---------- Original Method ----------
        //if (!(object instanceof Collator)) {
            //return false;
        //}
        //Collator collator = (Collator) object;
        //return icuColl == null ? collator.icuColl == null : icuColl.equals(collator.icuColl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.899 -0400", hash_original_method = "9F5D52877C91EB2005E3609373B16781", hash_generated_method = "55A9E4B2CA798A6539261002A8BF07AD")
    public boolean equals(String string1, String string2) {
        boolean var6B3C6DAF5F69B2C178015AF55DE756CF_1493533939 = (compare(string1, string2) == 0);
        addTaint(string1.getTaint());
        addTaint(string2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_454230811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_454230811;
        // ---------- Original Method ----------
        //return compare(string1, string2) == 0;
    }

    
        public static Locale[] getAvailableLocales() {
        return ICU.getAvailableCollatorLocales();
    }

    
    public abstract CollationKey getCollationKey(String string);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.900 -0400", hash_original_method = "80384F871328DEB63A40E323709EFE86", hash_generated_method = "315189D271F24EC8C9E10A1DF28B9A2F")
    public int getDecomposition() {
        int varB36BB4C33019F3C63B2B2F4931AB5EB3_59134417 = (decompositionMode_ICU_Java(icuColl.getDecomposition()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102731706 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102731706;
        // ---------- Original Method ----------
        //return decompositionMode_ICU_Java(icuColl.getDecomposition());
    }

    
        public static Collator getInstance() {
        return getInstance(Locale.getDefault());
    }

    
        public static Collator getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        return new RuleBasedCollator(new RuleBasedCollatorICU(locale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.906 -0400", hash_original_method = "1088192DB9E30CE77C93098214CBF249", hash_generated_method = "4C6B95F1E599E51FE6B11BE9B0EF89FF")
    public int getStrength() {
        int varFC203D3A2608E71726BA6B11C75A12F4_972735819 = (strength_ICU_Java(icuColl.getStrength()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790242228 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790242228;
        // ---------- Original Method ----------
        //return strength_ICU_Java(icuColl.getStrength());
    }

    
        @Override
public abstract int hashCode();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.907 -0400", hash_original_method = "B72BC12BA62E721E78973B8AD1CD75B5", hash_generated_method = "317E30DC77BDB084D82C820BA61AD3BE")
    public void setDecomposition(int value) {
        icuColl.setDecomposition(decompositionMode_Java_ICU(value));
        addTaint(value);
        // ---------- Original Method ----------
        //icuColl.setDecomposition(decompositionMode_Java_ICU(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.907 -0400", hash_original_method = "EE6B9836B69B72CAEC3F00255CD1C53E", hash_generated_method = "DF0F24E40FABF9F8EB80DD539CF26F0A")
    public void setStrength(int value) {
        icuColl.setStrength(strength_Java_ICU(value));
        addTaint(value);
        // ---------- Original Method ----------
        //icuColl.setStrength(strength_Java_ICU(value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.907 -0400", hash_original_method = "59C448B2403440A52B430BC264B57CED", hash_generated_method = "4FD547A44251651303A4214525F41CC3")
    private int decompositionMode_Java_ICU(int mode) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(mode);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902533787 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902533787;
        // ---------- Original Method ----------
        //switch (mode) {
        //case Collator.CANONICAL_DECOMPOSITION:
            //return RuleBasedCollatorICU.VALUE_ON;
        //case Collator.NO_DECOMPOSITION:
            //return RuleBasedCollatorICU.VALUE_OFF;
        //}
        //throw new IllegalArgumentException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.913 -0400", hash_original_method = "221AF1495063A31B1C807B8FB0041DE6", hash_generated_method = "816E6938BC628569E37832F2678D432B")
    private int decompositionMode_ICU_Java(int mode) {
        int javaMode;
        javaMode = mode;
        //Begin case RuleBasedCollatorICU.VALUE_OFF 
        javaMode = Collator.NO_DECOMPOSITION;
        //End case RuleBasedCollatorICU.VALUE_OFF 
        //Begin case RuleBasedCollatorICU.VALUE_ON 
        javaMode = Collator.CANONICAL_DECOMPOSITION;
        //End case RuleBasedCollatorICU.VALUE_ON 
        addTaint(mode);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042543849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042543849;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.913 -0400", hash_original_method = "8D5EE21418DD2AA072EEA3359693FB17", hash_generated_method = "58CDABA9ECFAD498BD2D4180D28E82A9")
    private int strength_Java_ICU(int value) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_648071795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_648071795;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.919 -0400", hash_original_method = "28CE8F975C7774291F421ACF5AFE6047", hash_generated_method = "84EE9B2F7B09F2FEC46FC754BD493417")
    private int strength_ICU_Java(int value) {
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
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183629626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183629626;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.919 -0400", hash_original_field = "6762616902C4FE35F14AF3BC1C4F2500", hash_generated_field = "9E43ED873605C1C1034619325D9DA889")

    public static final int NO_DECOMPOSITION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.919 -0400", hash_original_field = "50A96EA9E03B0B60EB4DCA1CA6213A49", hash_generated_field = "CD40FC2067D59891F7BA4573BEF1DB6B")

    public static final int CANONICAL_DECOMPOSITION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.919 -0400", hash_original_field = "03BA1A0EFA6772009E54D1243F9D3082", hash_generated_field = "792407D4F0E9907685F71381C9FD4E61")

    public static final int FULL_DECOMPOSITION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.919 -0400", hash_original_field = "52F61C0293E41BBFC5016FA11A7434B3", hash_generated_field = "B6442BE7EB0FE61CE720EB713BF63684")

    public static final int PRIMARY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.919 -0400", hash_original_field = "B69EE0CFDDFB918151F6D2BB7D5A5502", hash_generated_field = "545302936326A1D8CF924AC93757F924")

    public static final int SECONDARY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.919 -0400", hash_original_field = "1080F4A9469C4437D3D2B60A2EB3B472", hash_generated_field = "CA7F342F2246C9B80B01671D88E6D41C")

    public static final int TERTIARY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.919 -0400", hash_original_field = "299489327E17DC0A2DF650B8583A7842", hash_generated_field = "19D42BD9A98581EBEB400999C2E7C1B9")

    public static final int IDENTICAL = 3;
}

