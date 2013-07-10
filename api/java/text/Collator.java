package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Comparator;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.RuleBasedCollatorICU;

public abstract class Collator implements Comparator<Object>, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.610 -0400", hash_original_field = "6B1141D8E17A149C65A8272EB5BA314A", hash_generated_field = "571EB1F8C774D603CEDE0C031FD66C11")

    RuleBasedCollatorICU icuColl;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.610 -0400", hash_original_method = "18D47750B740CE28B17D63629E2E6276", hash_generated_method = "C76C95AB4C34DF3BF3A2153AA412ACD4")
      Collator(RuleBasedCollatorICU icuColl) {
        this.icuColl = icuColl;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.611 -0400", hash_original_method = "D1E80A5B5BD1C7C64C7B560256B076FF", hash_generated_method = "7031D0D95FB73398508462AD1E04E9F7")
    protected  Collator() {
        icuColl = new RuleBasedCollatorICU(Locale.getDefault());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.611 -0400", hash_original_method = "2284DB2FEC4C2AB3A601FDA70F532028", hash_generated_method = "04B34B385D7F1B810EFD769994A37D08")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_797345766 = null; 
        try 
        {
            Collator clone = (Collator) super.clone();
            clone.icuColl = (RuleBasedCollatorICU) icuColl.clone();
            varB4EAC82CA7396A68D541C85D26508E83_797345766 = clone;
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_797345766.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_797345766;
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.611 -0400", hash_original_method = "7C02E06D11E019F44D80294CC033745E", hash_generated_method = "20D25B429DA5AC24F46C3B78E7E76129")
    public int compare(Object object1, Object object2) {
        int var3D08E6BE7BAEBF1ADD53CD56D75BAFB9_2065056881 = (compare((String) object1, (String) object2));
        addTaint(object1.getTaint());
        addTaint(object2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412329811 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412329811;
        
        
    }

    
    public abstract int compare(String string1, String string2);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.612 -0400", hash_original_method = "F5E912698B2C6614F01702D72214A0C5", hash_generated_method = "731178ED4C47943A1818352C254B01A3")
    @Override
    public boolean equals(Object object) {
        Collator collator = (Collator) object;
        {
            Object varCD4CA96E36BA3373FDF786128F7C41DA_45339163 = (icuColl.equals(collator.icuColl));
        } 
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589185700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589185700;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.612 -0400", hash_original_method = "9F5D52877C91EB2005E3609373B16781", hash_generated_method = "71F336AC2A41F10B9A5B6DD18C97CAA2")
    public boolean equals(String string1, String string2) {
        boolean var6B3C6DAF5F69B2C178015AF55DE756CF_1760418611 = (compare(string1, string2) == 0);
        addTaint(string1.getTaint());
        addTaint(string2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866269401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_866269401;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableCollatorLocales();
    }

    
    public abstract CollationKey getCollationKey(String string);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.613 -0400", hash_original_method = "80384F871328DEB63A40E323709EFE86", hash_generated_method = "E0EC6A195FCD43F1A5D3E2B6BB664F55")
    public int getDecomposition() {
        int varB36BB4C33019F3C63B2B2F4931AB5EB3_124969831 = (decompositionMode_ICU_Java(icuColl.getDecomposition()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_80269163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_80269163;
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.614 -0400", hash_original_method = "1088192DB9E30CE77C93098214CBF249", hash_generated_method = "2205BDF52475CBA3947E4F104BDA9451")
    public int getStrength() {
        int varFC203D3A2608E71726BA6B11C75A12F4_1195364988 = (strength_ICU_Java(icuColl.getStrength()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152425657 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152425657;
        
        
    }

    
    @Override
public abstract int hashCode();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.615 -0400", hash_original_method = "B72BC12BA62E721E78973B8AD1CD75B5", hash_generated_method = "317E30DC77BDB084D82C820BA61AD3BE")
    public void setDecomposition(int value) {
        icuColl.setDecomposition(decompositionMode_Java_ICU(value));
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.615 -0400", hash_original_method = "EE6B9836B69B72CAEC3F00255CD1C53E", hash_generated_method = "DF0F24E40FABF9F8EB80DD539CF26F0A")
    public void setStrength(int value) {
        icuColl.setStrength(strength_Java_ICU(value));
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.615 -0400", hash_original_method = "59C448B2403440A52B430BC264B57CED", hash_generated_method = "B09EE3DB70F10CAF37275CB9D32047FF")
    private int decompositionMode_Java_ICU(int mode) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(mode);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240205508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240205508;
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.616 -0400", hash_original_method = "221AF1495063A31B1C807B8FB0041DE6", hash_generated_method = "B12A2B404B4F5740D90CD4FF3A89902E")
    private int decompositionMode_ICU_Java(int mode) {
        int javaMode = mode;
        
        javaMode = Collator.NO_DECOMPOSITION;
        
        
        javaMode = Collator.CANONICAL_DECOMPOSITION;
        
        addTaint(mode);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661563725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661563725;
        
        
        
        
            
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.616 -0400", hash_original_method = "8D5EE21418DD2AA072EEA3359693FB17", hash_generated_method = "2AAF1A2651DEB6703FF238FD5B9E7584")
    private int strength_Java_ICU(int value) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492448761 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492448761;
        
        
        
            
        
            
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.616 -0400", hash_original_method = "28CE8F975C7774291F421ACF5AFE6047", hash_generated_method = "973674BC0026E33E6D40FB9DF2E643D8")
    private int strength_ICU_Java(int value) {
        int javaValue = value;
        
        javaValue = Collator.PRIMARY;
        
        
        javaValue = Collator.SECONDARY;
        
        
        javaValue = Collator.TERTIARY;
        
        
        javaValue = Collator.IDENTICAL;
        
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897574815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897574815;
        
        
        
        
            
            
        
            
            
        
            
            
        
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.616 -0400", hash_original_field = "6762616902C4FE35F14AF3BC1C4F2500", hash_generated_field = "9E43ED873605C1C1034619325D9DA889")

    public static final int NO_DECOMPOSITION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.617 -0400", hash_original_field = "50A96EA9E03B0B60EB4DCA1CA6213A49", hash_generated_field = "CD40FC2067D59891F7BA4573BEF1DB6B")

    public static final int CANONICAL_DECOMPOSITION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.617 -0400", hash_original_field = "03BA1A0EFA6772009E54D1243F9D3082", hash_generated_field = "792407D4F0E9907685F71381C9FD4E61")

    public static final int FULL_DECOMPOSITION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.617 -0400", hash_original_field = "52F61C0293E41BBFC5016FA11A7434B3", hash_generated_field = "B6442BE7EB0FE61CE720EB713BF63684")

    public static final int PRIMARY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.617 -0400", hash_original_field = "B69EE0CFDDFB918151F6D2BB7D5A5502", hash_generated_field = "545302936326A1D8CF924AC93757F924")

    public static final int SECONDARY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.617 -0400", hash_original_field = "1080F4A9469C4437D3D2B60A2EB3B472", hash_generated_field = "CA7F342F2246C9B80B01671D88E6D41C")

    public static final int TERTIARY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.617 -0400", hash_original_field = "299489327E17DC0A2DF650B8583A7842", hash_generated_field = "19D42BD9A98581EBEB400999C2E7C1B9")

    public static final int IDENTICAL = 3;
}

