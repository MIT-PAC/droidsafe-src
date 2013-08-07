package libcore.icu;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.CharacterIterator;
import java.text.CollationKey;
import java.text.ParseException;
import java.util.Locale;






public final class RuleBasedCollatorICU implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.880 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.880 -0400", hash_original_method = "2EB56AAF7E8D69BAE596BFC26154D628", hash_generated_method = "3171FE2D30EE8D56C0242BB0A4D378B1")
    public  RuleBasedCollatorICU(String rules) throws ParseException {
        if(rules == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1398719271 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1398719271.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1398719271;
        } //End block
        address = NativeCollation.openCollatorFromRules(rules, VALUE_OFF, VALUE_DEFAULT_STRENGTH);
        // ---------- Original Method ----------
        //if (rules == null) {
            //throw new NullPointerException();
        //}
        //address = NativeCollation.openCollatorFromRules(rules, VALUE_OFF, VALUE_DEFAULT_STRENGTH);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.881 -0400", hash_original_method = "A5C323A76C17F2A5DAD617321306AD0B", hash_generated_method = "07D3C04B8B8E2257419AF3C327B3B479")
    public  RuleBasedCollatorICU(Locale locale) {
        address = NativeCollation.openCollator(locale.toString());
        // ---------- Original Method ----------
        //address = NativeCollation.openCollator(locale.toString());
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.881 -0400", hash_original_method = "A318B723665122F54B169082CADE3CC3", hash_generated_method = "372D2CB5171EA86DC45CCC1173FBD6F1")
    private  RuleBasedCollatorICU(int address) {
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.881 -0400", hash_original_method = "2DC05452E0FCF4981A0124341AE4FC53", hash_generated_method = "5ACD83758541073C3ADDAA6CACF8352D")
    public Object clone() {
Object var61AF93F4B07FC27B7B07C0F7916BCD9B_32093307 =         new RuleBasedCollatorICU(NativeCollation.safeClone(address));
        var61AF93F4B07FC27B7B07C0F7916BCD9B_32093307.addTaint(taint);
        return var61AF93F4B07FC27B7B07C0F7916BCD9B_32093307;
        // ---------- Original Method ----------
        //return new RuleBasedCollatorICU(NativeCollation.safeClone(address));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.882 -0400", hash_original_method = "49991F8A57E565642E1A41A931B1C001", hash_generated_method = "43171A4B7252D440317714AF8EA9588B")
    public int compare(String source, String target) {
        addTaint(target.getTaint());
        addTaint(source.getTaint());
        int varB423AA2E2351899A80FC6DF8454FA4D6_877064421 = (NativeCollation.compare(address, source, target));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695750978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695750978;
        // ---------- Original Method ----------
        //return NativeCollation.compare(address, source, target);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.882 -0400", hash_original_method = "239D987CE6D9B4CADAB8F872E8E9D57B", hash_generated_method = "A43FE4B7C1B2F1775F720ED84CF893B9")
    public int getDecomposition() {
        int var5D29D9E5D7CFCCF42EE5D15AF9DBED2C_1873204869 = (NativeCollation.getAttribute(address, DECOMPOSITION_MODE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1444326701 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1444326701;
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, DECOMPOSITION_MODE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.882 -0400", hash_original_method = "44F9BFBEB06030096990BB2E8C89DED9", hash_generated_method = "4105CF3CF889C8BF695639A6CBB245CA")
    public void setDecomposition(int mode) {
        addTaint(mode);
        NativeCollation.setAttribute(address, DECOMPOSITION_MODE, mode);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, DECOMPOSITION_MODE, mode);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.882 -0400", hash_original_method = "AAB074F82BF97FFE28F8563C1D57A964", hash_generated_method = "446DB48FB7D8AE23B22874DDDCBD8786")
    public int getStrength() {
        int varF365839574D47FB0A9065461012BAD07_1220165455 = (NativeCollation.getAttribute(address, STRENGTH));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971519470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971519470;
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, STRENGTH);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.883 -0400", hash_original_method = "B780FC0CB29AFE09B6EA92E53FEFCCC0", hash_generated_method = "A3713EB0777E611099C8350A77D8D7CA")
    public void setStrength(int strength) {
        addTaint(strength);
        NativeCollation.setAttribute(address, STRENGTH, strength);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, STRENGTH, strength);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.883 -0400", hash_original_method = "EE4A6867E88BF501B4AF7B7DE8C48A39", hash_generated_method = "3EF5F954ECA1917AFA4CB32B99BE6784")
    public void setAttribute(int type, int value) {
        addTaint(value);
        addTaint(type);
        NativeCollation.setAttribute(address, type, value);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, type, value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.883 -0400", hash_original_method = "7E0368EE82E5C263E0341D3245A9B850", hash_generated_method = "97A95F97B7570B27F5F7A36A8F837E33")
    public int getAttribute(int type) {
        addTaint(type);
        int var36AF4EC494F8B2CD52D534DAE820F45E_1179488246 = (NativeCollation.getAttribute(address, type));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494592095 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494592095;
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, type);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.883 -0400", hash_original_method = "AD47FDA34CF9DDAC21CE9DA304C498D4", hash_generated_method = "FE7993A94E74305E47C1BAEBBE548378")
    public CollationKey getCollationKey(String source) {
        addTaint(source.getTaint());
        if(source == null)        
        {
CollationKey var540C13E9E156B687226421B24F2DF178_537362863 =             null;
            var540C13E9E156B687226421B24F2DF178_537362863.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_537362863;
        } //End block
        byte[] key = NativeCollation.getSortKey(address, source);
        if(key == null)        
        {
CollationKey var540C13E9E156B687226421B24F2DF178_1391976776 =             null;
            var540C13E9E156B687226421B24F2DF178_1391976776.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1391976776;
        } //End block
CollationKey varC02C69FE9E56EAE95347BB4D3145D4AF_390563815 =         new CollationKeyICU(source, key);
        varC02C69FE9E56EAE95347BB4D3145D4AF_390563815.addTaint(taint);
        return varC02C69FE9E56EAE95347BB4D3145D4AF_390563815;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.884 -0400", hash_original_method = "FFB9880C0352BAA3924C6058A715E6CF", hash_generated_method = "7BBEBE00C76E09AF6233B7F89770AC6E")
    public String getRules() {
String var3726B2388D662DC588D1A47031972F2F_1441445058 =         NativeCollation.getRules(address);
        var3726B2388D662DC588D1A47031972F2F_1441445058.addTaint(taint);
        return var3726B2388D662DC588D1A47031972F2F_1441445058;
        // ---------- Original Method ----------
        //return NativeCollation.getRules(address);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.884 -0400", hash_original_method = "37423170550704AB69E3E5DFF5BA23DD", hash_generated_method = "D0734800B7830DB0A3C93A2AA9562B24")
    public CollationElementIteratorICU getCollationElementIterator(String source) {
        addTaint(source.getTaint());
CollationElementIteratorICU var7655C91E85873BB3154568D8684ED324_1286057675 =         CollationElementIteratorICU.getInstance(address, source);
        var7655C91E85873BB3154568D8684ED324_1286057675.addTaint(taint);
        return var7655C91E85873BB3154568D8684ED324_1286057675;
        // ---------- Original Method ----------
        //return CollationElementIteratorICU.getInstance(address, source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.884 -0400", hash_original_method = "C7D7D5ADEA090F255D72693DB837681B", hash_generated_method = "1425F0ED534972607C6C54546CE8417B")
    public CollationElementIteratorICU getCollationElementIterator(CharacterIterator it) {
        addTaint(it.getTaint());
CollationElementIteratorICU var9C852F1F0476779AB6D95093BE3D4B76_518638885 =         getCollationElementIterator(characterIteratorToString(it));
        var9C852F1F0476779AB6D95093BE3D4B76_518638885.addTaint(taint);
        return var9C852F1F0476779AB6D95093BE3D4B76_518638885;
        // ---------- Original Method ----------
        //return getCollationElementIterator(characterIteratorToString(it));
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.884 -0400", hash_original_method = "7AE77B5FB071109A54141F0830318144", hash_generated_method = "DEFA1D4C91AB48B5D34EE14EEE54E94E")
    private String characterIteratorToString(CharacterIterator it) {
        addTaint(it.getTaint());
        StringBuilder result = new StringBuilder();
for(char ch = it.current();ch != CharacterIterator.DONE;ch = it.next())
        {
            result.append(ch);
        } //End block
String varE65B3A02759122992CB82C0E651AD408_1816378633 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1816378633.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1816378633;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (char ch = it.current(); ch != CharacterIterator.DONE; ch = it.next()) {
            //result.append(ch);
        //}
        //return result.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.885 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "8396E01DF4BA34A0DB3DB8B151A6F123")
    @Override
    public int hashCode() {
        int varA1D0C6E83F027327D8461063F4AC58A6_540951340 = (42);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_134657053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_134657053;
        // ---------- Original Method ----------
        //return 42;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.885 -0400", hash_original_method = "33726095AFF4CCE7845E5A8AF95C560E", hash_generated_method = "374D606179288C2D40C1CCD329CCD4EC")
    public boolean equals(String source, String target) {
        addTaint(target.getTaint());
        addTaint(source.getTaint());
        boolean varCC4E783AFB2D2C096C220A69BFAF5B6E_621590084 = ((compare(source, target) == 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446969676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_446969676;
        // ---------- Original Method ----------
        //return (compare(source, target) == 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.885 -0400", hash_original_method = "7C2D1C08D1C2665AA117147559E8D29C", hash_generated_method = "BD4FBE4F29A7D8A7364A44ACDEE3A5ED")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(object ==  this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1302319857 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_822767496 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_822767496;
        } //End block
        if(!(object instanceof RuleBasedCollatorICU))        
        {
            boolean var68934A3E9455FA72420237EB05902327_536287353 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580322238 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_580322238;
        } //End block
        RuleBasedCollatorICU rhs = (RuleBasedCollatorICU) object;
        boolean var2565A28C2EBF0847B7B982CEC8F94EF1_1427502895 = (getRules().equals(rhs.getRules()) &&
                getStrength() == rhs.getStrength() &&
                getDecomposition() == rhs.getDecomposition());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1730760362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1730760362;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.885 -0400", hash_original_method = "4A24C365D6C63EAE3926032A3798E7DF", hash_generated_method = "3E9A27D176EE88C06944999305FF2B51")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.885 -0400", hash_original_field = "3E4B5647B5452F835C44422D885B6CAB", hash_generated_field = "728743DB6612B436D24CE07F9E0E578D")

    public static final int VALUE_DEFAULT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.885 -0400", hash_original_field = "1290D3DE09381A02F23511FECCD60C0B", hash_generated_field = "9EF79B4A29645169497906E919B6FAF5")

    public static final int VALUE_PRIMARY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.885 -0400", hash_original_field = "D4329CE4E67DFEFA7CF4FAB7F58C21E7", hash_generated_field = "583C62089B77C317428C9E462531A060")

    public static final int VALUE_SECONDARY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.885 -0400", hash_original_field = "DD930DE45B9390CF47EC97008080F4C3", hash_generated_field = "5F260A36972F0E701131299E0A43E7B2")

    public static final int VALUE_TERTIARY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.885 -0400", hash_original_field = "C94F06FE32E6009159897B6728820E10", hash_generated_field = "9A90704ECD935D223A8BB9CE1995F721")

    public static final int VALUE_DEFAULT_STRENGTH = VALUE_TERTIARY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "4D29EF488E17B999B1085B63EAA28575", hash_generated_field = "7AFB3B26771CA61F5794ED5C9EDFC932")

    public static final int VALUE_QUATERNARY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "313F386FA00D2D1173645697D9B66663", hash_generated_field = "FCD93EE6B3FC2830DA4047B9636EBC49")

    public static final int VALUE_IDENTICAL = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "3225268A7B2B2E6C861A98889DA5C3E2", hash_generated_field = "29E1B5763DD6BF9165E050300F1FF599")

    public static final int VALUE_OFF = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "6745BA37434F463E28CDBB1C334DFED9", hash_generated_field = "51F7ABEDC426272800189683F01E1D9C")

    public static final int VALUE_ON = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "0C49D707A15D2EBDA5768CDDFACC6910", hash_generated_field = "F84E95097BC99A84F1329F912DE1C04E")

    public static final int VALUE_SHIFTED = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "00364B6051AA02AB0E1991B3800FFDED", hash_generated_field = "8BAB6D0B6D8A0F099F78E047CCEE3DF6")

    public static final int VALUE_NON_IGNORABLE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "985029AB5351893C348DC854F3D4B8CA", hash_generated_field = "C6B0BFB4AAAB2A6CD12ADF3D4EA8A6E1")

    public static final int VALUE_LOWER_FIRST = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "9DB0F50007339188BE801E1BF2F6D939", hash_generated_field = "6FA71123BF881152210F318027ED3BEB")

    public static final int VALUE_UPPER_FIRST = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "531EDAD139C2DA6ACF092A6533B70026", hash_generated_field = "5FA947735009434015E742CF03FC8D8E")

    public static final int VALUE_ON_WITHOUT_HANGUL = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "93188EC13BF0AF41E42CC5D62F3FBD97", hash_generated_field = "538E4AEF9C246123086D9CA39530A548")

    public static final int VALUE_ATTRIBUTE_VALUE_COUNT = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "E2E1829157605EE0EBE6A22F5DCE8816", hash_generated_field = "DEFFCE9E44F682D0761520353DF13E7B")

    public static final int FRENCH_COLLATION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "B91E0E8D92DA6180D2123B3684A0100F", hash_generated_field = "7DC87AE12792F09754FF718C279C3385")

    public static final int ALTERNATE_HANDLING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "7D2A79822BB2FDD426B008D5C38033FB", hash_generated_field = "28C07F44F7059A82501618278B58B8D5")

    public static final int CASE_FIRST = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "503543A58737D88F4C9ED7C8703BCB14", hash_generated_field = "A4A4EC9E8D42866A14FC8CA95EABB87D")

    public static final int CASE_LEVEL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "3E576470337E6F2FF85C3AA4973E9944", hash_generated_field = "28E667FFBB3A82AE536655DC24CF3548")

    public static final int DECOMPOSITION_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.886 -0400", hash_original_field = "597A60A7C658089CF973223B64F18354", hash_generated_field = "F38C7B0615A9D421DB10E7EF2BE0DCEC")

    public static final int STRENGTH = 5;
}

