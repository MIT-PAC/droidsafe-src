package libcore.icu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.CharacterIterator;
import java.text.CollationKey;
import java.text.ParseException;
import java.util.Locale;

public final class RuleBasedCollatorICU implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.738 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.739 -0400", hash_original_method = "2EB56AAF7E8D69BAE596BFC26154D628", hash_generated_method = "E3A6EB757FBE6FC6FCB4E558BD869D72")
    public  RuleBasedCollatorICU(String rules) throws ParseException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        address = NativeCollation.openCollatorFromRules(rules, VALUE_OFF, VALUE_DEFAULT_STRENGTH);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.739 -0400", hash_original_method = "A5C323A76C17F2A5DAD617321306AD0B", hash_generated_method = "07D3C04B8B8E2257419AF3C327B3B479")
    public  RuleBasedCollatorICU(Locale locale) {
        address = NativeCollation.openCollator(locale.toString());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.739 -0400", hash_original_method = "A318B723665122F54B169082CADE3CC3", hash_generated_method = "372D2CB5171EA86DC45CCC1173FBD6F1")
    private  RuleBasedCollatorICU(int address) {
        this.address = address;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.739 -0400", hash_original_method = "2DC05452E0FCF4981A0124341AE4FC53", hash_generated_method = "CBFF8B9536A5BBD7111565FC493702F4")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1186603885 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1186603885 = new RuleBasedCollatorICU(NativeCollation.safeClone(address));
        varB4EAC82CA7396A68D541C85D26508E83_1186603885.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1186603885;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.740 -0400", hash_original_method = "49991F8A57E565642E1A41A931B1C001", hash_generated_method = "F113EEBACEF2B4883838F05C637BD98A")
    public int compare(String source, String target) {
        int var3F8925F8F393AB9ECF7144403EEC9A0B_591166730 = (NativeCollation.compare(address, source, target));
        addTaint(source.getTaint());
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_700519283 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_700519283;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.740 -0400", hash_original_method = "239D987CE6D9B4CADAB8F872E8E9D57B", hash_generated_method = "AF3CB3D70E3732630CF11CEAFBAA4539")
    public int getDecomposition() {
        int var8764316B4FF2BBD167E95966AD23BE1C_1185090071 = (NativeCollation.getAttribute(address, DECOMPOSITION_MODE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049144139 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049144139;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.740 -0400", hash_original_method = "44F9BFBEB06030096990BB2E8C89DED9", hash_generated_method = "65AFB072C1A139B1E1D8C32991941680")
    public void setDecomposition(int mode) {
        NativeCollation.setAttribute(address, DECOMPOSITION_MODE, mode);
        addTaint(mode);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.740 -0400", hash_original_method = "AAB074F82BF97FFE28F8563C1D57A964", hash_generated_method = "35884C8F689AF08DD4C9FDE122551BE1")
    public int getStrength() {
        int var2C5F8038E1CD8A7F4593063EC907144D_1497137766 = (NativeCollation.getAttribute(address, STRENGTH));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221836511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221836511;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.740 -0400", hash_original_method = "B780FC0CB29AFE09B6EA92E53FEFCCC0", hash_generated_method = "44AABDABF4F6B523B77A2D51FACC010F")
    public void setStrength(int strength) {
        NativeCollation.setAttribute(address, STRENGTH, strength);
        addTaint(strength);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.740 -0400", hash_original_method = "EE4A6867E88BF501B4AF7B7DE8C48A39", hash_generated_method = "B11D913D938D259E41634BA82EDDF187")
    public void setAttribute(int type, int value) {
        NativeCollation.setAttribute(address, type, value);
        addTaint(type);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.741 -0400", hash_original_method = "7E0368EE82E5C263E0341D3245A9B850", hash_generated_method = "7CAB898F02CC106AB8CD33BCB546FBB2")
    public int getAttribute(int type) {
        int var976756D3926C50E33324CA8FC446B22F_383897354 = (NativeCollation.getAttribute(address, type));
        addTaint(type);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602477213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602477213;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.742 -0400", hash_original_method = "AD47FDA34CF9DDAC21CE9DA304C498D4", hash_generated_method = "F551E1ACAE32352BA93766B1FE2E976B")
    public CollationKey getCollationKey(String source) {
        CollationKey varB4EAC82CA7396A68D541C85D26508E83_1232189867 = null; 
        CollationKey varB4EAC82CA7396A68D541C85D26508E83_2016996007 = null; 
        CollationKey varB4EAC82CA7396A68D541C85D26508E83_1519943237 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1232189867 = null;
        } 
        byte[] key = NativeCollation.getSortKey(address, source);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2016996007 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1519943237 = new CollationKeyICU(source, key);
        addTaint(source.getTaint());
        CollationKey varA7E53CE21691AB073D9660D615818899_1318681677; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1318681677 = varB4EAC82CA7396A68D541C85D26508E83_1232189867;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1318681677 = varB4EAC82CA7396A68D541C85D26508E83_2016996007;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1318681677 = varB4EAC82CA7396A68D541C85D26508E83_1519943237;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1318681677.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1318681677;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.743 -0400", hash_original_method = "FFB9880C0352BAA3924C6058A715E6CF", hash_generated_method = "11924C3CFA94950D15B9133238CE167A")
    public String getRules() {
        String varB4EAC82CA7396A68D541C85D26508E83_1326577544 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1326577544 = NativeCollation.getRules(address);
        varB4EAC82CA7396A68D541C85D26508E83_1326577544.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1326577544;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.743 -0400", hash_original_method = "37423170550704AB69E3E5DFF5BA23DD", hash_generated_method = "81AE43B275C4C3030F845F58DCBD1A33")
    public CollationElementIteratorICU getCollationElementIterator(String source) {
        CollationElementIteratorICU varB4EAC82CA7396A68D541C85D26508E83_1366418712 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1366418712 = CollationElementIteratorICU.getInstance(address, source);
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1366418712.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1366418712;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.744 -0400", hash_original_method = "C7D7D5ADEA090F255D72693DB837681B", hash_generated_method = "7CA5AAB33CF370FE04E68874DF12DFC5")
    public CollationElementIteratorICU getCollationElementIterator(CharacterIterator it) {
        CollationElementIteratorICU varB4EAC82CA7396A68D541C85D26508E83_1481704102 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1481704102 = getCollationElementIterator(characterIteratorToString(it));
        addTaint(it.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1481704102.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1481704102;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.744 -0400", hash_original_method = "7AE77B5FB071109A54141F0830318144", hash_generated_method = "4988D9E5A08D8CDD35344B663F92BEB0")
    private String characterIteratorToString(CharacterIterator it) {
        String varB4EAC82CA7396A68D541C85D26508E83_538938132 = null; 
        StringBuilder result = new StringBuilder();
        {
            char ch = it.current();
            ch = it.next();
            {
                result.append(ch);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_538938132 = result.toString();
        addTaint(it.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_538938132.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_538938132;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.744 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "EF196BB36B3359E56DD7D5979558B6C4")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2087207630 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2087207630;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_method = "33726095AFF4CCE7845E5A8AF95C560E", hash_generated_method = "ED0FF03A0157CF4C9A1EF0F5FBF7E265")
    public boolean equals(String source, String target) {
        boolean var2462A09B5BDA2F592435FFC5DCFB379A_241493548 = ((compare(source, target) == 0));
        addTaint(source.getTaint());
        addTaint(target.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_239725075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_239725075;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_method = "7C2D1C08D1C2665AA117147559E8D29C", hash_generated_method = "E24BF28CB71955C10BEAD494B401BBEF")
    @Override
    public boolean equals(Object object) {
        {
            boolean var83F06663CC91C8DF2EADF537513DA66F_2043306793 = (object ==  this);
        } 
        RuleBasedCollatorICU rhs = (RuleBasedCollatorICU) object;
        boolean varB5945B169E6BD3FC8C510D0EAD3D0F0F_371502375 = (getRules().equals(rhs.getRules()) &&
                getStrength() == rhs.getStrength() &&
                getDecomposition() == rhs.getDecomposition());
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_668874143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_668874143;
        
        
            
        
        
            
        
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_method = "4A24C365D6C63EAE3926032A3798E7DF", hash_generated_method = "3E9A27D176EE88C06944999305FF2B51")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            NativeCollation.closeCollator(address);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_field = "3E4B5647B5452F835C44422D885B6CAB", hash_generated_field = "728743DB6612B436D24CE07F9E0E578D")

    public static final int VALUE_DEFAULT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_field = "1290D3DE09381A02F23511FECCD60C0B", hash_generated_field = "9EF79B4A29645169497906E919B6FAF5")

    public static final int VALUE_PRIMARY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_field = "D4329CE4E67DFEFA7CF4FAB7F58C21E7", hash_generated_field = "583C62089B77C317428C9E462531A060")

    public static final int VALUE_SECONDARY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_field = "DD930DE45B9390CF47EC97008080F4C3", hash_generated_field = "5F260A36972F0E701131299E0A43E7B2")

    public static final int VALUE_TERTIARY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_field = "C94F06FE32E6009159897B6728820E10", hash_generated_field = "9A90704ECD935D223A8BB9CE1995F721")

    public static final int VALUE_DEFAULT_STRENGTH = VALUE_TERTIARY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_field = "4D29EF488E17B999B1085B63EAA28575", hash_generated_field = "7AFB3B26771CA61F5794ED5C9EDFC932")

    public static final int VALUE_QUATERNARY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_field = "313F386FA00D2D1173645697D9B66663", hash_generated_field = "FCD93EE6B3FC2830DA4047B9636EBC49")

    public static final int VALUE_IDENTICAL = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_field = "3225268A7B2B2E6C861A98889DA5C3E2", hash_generated_field = "29E1B5763DD6BF9165E050300F1FF599")

    public static final int VALUE_OFF = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.745 -0400", hash_original_field = "6745BA37434F463E28CDBB1C334DFED9", hash_generated_field = "51F7ABEDC426272800189683F01E1D9C")

    public static final int VALUE_ON = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "0C49D707A15D2EBDA5768CDDFACC6910", hash_generated_field = "F84E95097BC99A84F1329F912DE1C04E")

    public static final int VALUE_SHIFTED = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "00364B6051AA02AB0E1991B3800FFDED", hash_generated_field = "8BAB6D0B6D8A0F099F78E047CCEE3DF6")

    public static final int VALUE_NON_IGNORABLE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "985029AB5351893C348DC854F3D4B8CA", hash_generated_field = "C6B0BFB4AAAB2A6CD12ADF3D4EA8A6E1")

    public static final int VALUE_LOWER_FIRST = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "9DB0F50007339188BE801E1BF2F6D939", hash_generated_field = "6FA71123BF881152210F318027ED3BEB")

    public static final int VALUE_UPPER_FIRST = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "531EDAD139C2DA6ACF092A6533B70026", hash_generated_field = "5FA947735009434015E742CF03FC8D8E")

    public static final int VALUE_ON_WITHOUT_HANGUL = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "93188EC13BF0AF41E42CC5D62F3FBD97", hash_generated_field = "538E4AEF9C246123086D9CA39530A548")

    public static final int VALUE_ATTRIBUTE_VALUE_COUNT = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "E2E1829157605EE0EBE6A22F5DCE8816", hash_generated_field = "DEFFCE9E44F682D0761520353DF13E7B")

    public static final int FRENCH_COLLATION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "B91E0E8D92DA6180D2123B3684A0100F", hash_generated_field = "7DC87AE12792F09754FF718C279C3385")

    public static final int ALTERNATE_HANDLING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "7D2A79822BB2FDD426B008D5C38033FB", hash_generated_field = "28C07F44F7059A82501618278B58B8D5")

    public static final int CASE_FIRST = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "503543A58737D88F4C9ED7C8703BCB14", hash_generated_field = "A4A4EC9E8D42866A14FC8CA95EABB87D")

    public static final int CASE_LEVEL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "3E576470337E6F2FF85C3AA4973E9944", hash_generated_field = "28E667FFBB3A82AE536655DC24CF3548")

    public static final int DECOMPOSITION_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.746 -0400", hash_original_field = "597A60A7C658089CF973223B64F18354", hash_generated_field = "F38C7B0615A9D421DB10E7EF2BE0DCEC")

    public static final int STRENGTH = 5;
}

