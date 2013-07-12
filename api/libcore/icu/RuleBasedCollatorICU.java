package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.CharacterIterator;
import java.text.CollationKey;
import java.text.ParseException;
import java.util.Locale;

public final class RuleBasedCollatorICU implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.462 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.463 -0400", hash_original_method = "2EB56AAF7E8D69BAE596BFC26154D628", hash_generated_method = "8350A3C8EE8B77A0779C1926F08F7B6C")
    public  RuleBasedCollatorICU(String rules) throws ParseException {
    if(rules == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1434173980 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1434173980.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1434173980;
        } //End block
        address = NativeCollation.openCollatorFromRules(rules, VALUE_OFF, VALUE_DEFAULT_STRENGTH);
        // ---------- Original Method ----------
        //if (rules == null) {
            //throw new NullPointerException();
        //}
        //address = NativeCollation.openCollatorFromRules(rules, VALUE_OFF, VALUE_DEFAULT_STRENGTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.464 -0400", hash_original_method = "A5C323A76C17F2A5DAD617321306AD0B", hash_generated_method = "07D3C04B8B8E2257419AF3C327B3B479")
    public  RuleBasedCollatorICU(Locale locale) {
        address = NativeCollation.openCollator(locale.toString());
        // ---------- Original Method ----------
        //address = NativeCollation.openCollator(locale.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.464 -0400", hash_original_method = "A318B723665122F54B169082CADE3CC3", hash_generated_method = "372D2CB5171EA86DC45CCC1173FBD6F1")
    private  RuleBasedCollatorICU(int address) {
        this.address = address;
        // ---------- Original Method ----------
        //this.address = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.464 -0400", hash_original_method = "2DC05452E0FCF4981A0124341AE4FC53", hash_generated_method = "1131545C0631359B79F7E87B78160ABF")
    public Object clone() {
Object var61AF93F4B07FC27B7B07C0F7916BCD9B_505714524 =         new RuleBasedCollatorICU(NativeCollation.safeClone(address));
        var61AF93F4B07FC27B7B07C0F7916BCD9B_505714524.addTaint(taint);
        return var61AF93F4B07FC27B7B07C0F7916BCD9B_505714524;
        // ---------- Original Method ----------
        //return new RuleBasedCollatorICU(NativeCollation.safeClone(address));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.465 -0400", hash_original_method = "49991F8A57E565642E1A41A931B1C001", hash_generated_method = "3334A989DCBBF70F47B944E00D7732DA")
    public int compare(String source, String target) {
        addTaint(target.getTaint());
        addTaint(source.getTaint());
        int varB423AA2E2351899A80FC6DF8454FA4D6_2076617905 = (NativeCollation.compare(address, source, target));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_474184345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_474184345;
        // ---------- Original Method ----------
        //return NativeCollation.compare(address, source, target);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.465 -0400", hash_original_method = "239D987CE6D9B4CADAB8F872E8E9D57B", hash_generated_method = "327661241700A92256E78B497AE34C4E")
    public int getDecomposition() {
        int var5D29D9E5D7CFCCF42EE5D15AF9DBED2C_1208997932 = (NativeCollation.getAttribute(address, DECOMPOSITION_MODE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616673725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616673725;
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, DECOMPOSITION_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.466 -0400", hash_original_method = "44F9BFBEB06030096990BB2E8C89DED9", hash_generated_method = "4105CF3CF889C8BF695639A6CBB245CA")
    public void setDecomposition(int mode) {
        addTaint(mode);
        NativeCollation.setAttribute(address, DECOMPOSITION_MODE, mode);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, DECOMPOSITION_MODE, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.466 -0400", hash_original_method = "AAB074F82BF97FFE28F8563C1D57A964", hash_generated_method = "9AC1DB328DFF3758BC5937EE142EF202")
    public int getStrength() {
        int varF365839574D47FB0A9065461012BAD07_1664579004 = (NativeCollation.getAttribute(address, STRENGTH));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_766905940 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_766905940;
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, STRENGTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.467 -0400", hash_original_method = "B780FC0CB29AFE09B6EA92E53FEFCCC0", hash_generated_method = "A3713EB0777E611099C8350A77D8D7CA")
    public void setStrength(int strength) {
        addTaint(strength);
        NativeCollation.setAttribute(address, STRENGTH, strength);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, STRENGTH, strength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.467 -0400", hash_original_method = "EE4A6867E88BF501B4AF7B7DE8C48A39", hash_generated_method = "3EF5F954ECA1917AFA4CB32B99BE6784")
    public void setAttribute(int type, int value) {
        addTaint(value);
        addTaint(type);
        NativeCollation.setAttribute(address, type, value);
        // ---------- Original Method ----------
        //NativeCollation.setAttribute(address, type, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.468 -0400", hash_original_method = "7E0368EE82E5C263E0341D3245A9B850", hash_generated_method = "90849ED2AD56123CDB70D86F59E1ED58")
    public int getAttribute(int type) {
        addTaint(type);
        int var36AF4EC494F8B2CD52D534DAE820F45E_1071898678 = (NativeCollation.getAttribute(address, type));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069693053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069693053;
        // ---------- Original Method ----------
        //return NativeCollation.getAttribute(address, type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.468 -0400", hash_original_method = "AD47FDA34CF9DDAC21CE9DA304C498D4", hash_generated_method = "8E2823E80F42C36674DF28A397895A22")
    public CollationKey getCollationKey(String source) {
        addTaint(source.getTaint());
    if(source == null)        
        {
CollationKey var540C13E9E156B687226421B24F2DF178_1084571138 =             null;
            var540C13E9E156B687226421B24F2DF178_1084571138.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1084571138;
        } //End block
        byte[] key = NativeCollation.getSortKey(address, source);
    if(key == null)        
        {
CollationKey var540C13E9E156B687226421B24F2DF178_1423981419 =             null;
            var540C13E9E156B687226421B24F2DF178_1423981419.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1423981419;
        } //End block
CollationKey varC02C69FE9E56EAE95347BB4D3145D4AF_1764621409 =         new CollationKeyICU(source, key);
        varC02C69FE9E56EAE95347BB4D3145D4AF_1764621409.addTaint(taint);
        return varC02C69FE9E56EAE95347BB4D3145D4AF_1764621409;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.469 -0400", hash_original_method = "FFB9880C0352BAA3924C6058A715E6CF", hash_generated_method = "963F3D2D2C1EF38E1821B547FA17C0F4")
    public String getRules() {
String var3726B2388D662DC588D1A47031972F2F_100012364 =         NativeCollation.getRules(address);
        var3726B2388D662DC588D1A47031972F2F_100012364.addTaint(taint);
        return var3726B2388D662DC588D1A47031972F2F_100012364;
        // ---------- Original Method ----------
        //return NativeCollation.getRules(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.469 -0400", hash_original_method = "37423170550704AB69E3E5DFF5BA23DD", hash_generated_method = "0E3AE8CAC4FBA60F1D5B98BAD8B5C7C6")
    public CollationElementIteratorICU getCollationElementIterator(String source) {
        addTaint(source.getTaint());
CollationElementIteratorICU var7655C91E85873BB3154568D8684ED324_29410113 =         CollationElementIteratorICU.getInstance(address, source);
        var7655C91E85873BB3154568D8684ED324_29410113.addTaint(taint);
        return var7655C91E85873BB3154568D8684ED324_29410113;
        // ---------- Original Method ----------
        //return CollationElementIteratorICU.getInstance(address, source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.469 -0400", hash_original_method = "C7D7D5ADEA090F255D72693DB837681B", hash_generated_method = "F59FB2015AFF515304D1C63F3651BDC7")
    public CollationElementIteratorICU getCollationElementIterator(CharacterIterator it) {
        addTaint(it.getTaint());
CollationElementIteratorICU var9C852F1F0476779AB6D95093BE3D4B76_177282794 =         getCollationElementIterator(characterIteratorToString(it));
        var9C852F1F0476779AB6D95093BE3D4B76_177282794.addTaint(taint);
        return var9C852F1F0476779AB6D95093BE3D4B76_177282794;
        // ---------- Original Method ----------
        //return getCollationElementIterator(characterIteratorToString(it));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.470 -0400", hash_original_method = "7AE77B5FB071109A54141F0830318144", hash_generated_method = "ECD8BD2BA1BB7E2794650B5E8108EA48")
    private String characterIteratorToString(CharacterIterator it) {
        addTaint(it.getTaint());
        StringBuilder result = new StringBuilder();
for(char ch = it.current();ch != CharacterIterator.DONE;ch = it.next())
        {
            result.append(ch);
        } //End block
String varE65B3A02759122992CB82C0E651AD408_32720754 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_32720754.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_32720754;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (char ch = it.current(); ch != CharacterIterator.DONE; ch = it.next()) {
            //result.append(ch);
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.470 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "94D9E1CA7DF06279E2A4130BD989AA46")
    @Override
    public int hashCode() {
        int varA1D0C6E83F027327D8461063F4AC58A6_1331493275 = (42);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269212457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269212457;
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.471 -0400", hash_original_method = "33726095AFF4CCE7845E5A8AF95C560E", hash_generated_method = "9D9E425C190BA4181560D0D21CADDB1F")
    public boolean equals(String source, String target) {
        addTaint(target.getTaint());
        addTaint(source.getTaint());
        boolean varCC4E783AFB2D2C096C220A69BFAF5B6E_1282407355 = ((compare(source, target) == 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1261100355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1261100355;
        // ---------- Original Method ----------
        //return (compare(source, target) == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.471 -0400", hash_original_method = "7C2D1C08D1C2665AA117147559E8D29C", hash_generated_method = "BDFA5D7832868D9493725BF1AD3B443A")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(object ==  this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_539877269 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_279258346 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_279258346;
        } //End block
    if(!(object instanceof RuleBasedCollatorICU))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1740014793 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736112620 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_736112620;
        } //End block
        RuleBasedCollatorICU rhs = (RuleBasedCollatorICU) object;
        boolean var2565A28C2EBF0847B7B982CEC8F94EF1_2121165157 = (getRules().equals(rhs.getRules()) &&
                getStrength() == rhs.getStrength() &&
                getDecomposition() == rhs.getDecomposition());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2129954902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2129954902;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.471 -0400", hash_original_method = "4A24C365D6C63EAE3926032A3798E7DF", hash_generated_method = "3E9A27D176EE88C06944999305FF2B51")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.471 -0400", hash_original_field = "3E4B5647B5452F835C44422D885B6CAB", hash_generated_field = "728743DB6612B436D24CE07F9E0E578D")

    public static final int VALUE_DEFAULT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.471 -0400", hash_original_field = "1290D3DE09381A02F23511FECCD60C0B", hash_generated_field = "9EF79B4A29645169497906E919B6FAF5")

    public static final int VALUE_PRIMARY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.471 -0400", hash_original_field = "D4329CE4E67DFEFA7CF4FAB7F58C21E7", hash_generated_field = "583C62089B77C317428C9E462531A060")

    public static final int VALUE_SECONDARY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "DD930DE45B9390CF47EC97008080F4C3", hash_generated_field = "5F260A36972F0E701131299E0A43E7B2")

    public static final int VALUE_TERTIARY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "C94F06FE32E6009159897B6728820E10", hash_generated_field = "9A90704ECD935D223A8BB9CE1995F721")

    public static final int VALUE_DEFAULT_STRENGTH = VALUE_TERTIARY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "4D29EF488E17B999B1085B63EAA28575", hash_generated_field = "7AFB3B26771CA61F5794ED5C9EDFC932")

    public static final int VALUE_QUATERNARY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "313F386FA00D2D1173645697D9B66663", hash_generated_field = "FCD93EE6B3FC2830DA4047B9636EBC49")

    public static final int VALUE_IDENTICAL = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "3225268A7B2B2E6C861A98889DA5C3E2", hash_generated_field = "29E1B5763DD6BF9165E050300F1FF599")

    public static final int VALUE_OFF = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "6745BA37434F463E28CDBB1C334DFED9", hash_generated_field = "51F7ABEDC426272800189683F01E1D9C")

    public static final int VALUE_ON = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "0C49D707A15D2EBDA5768CDDFACC6910", hash_generated_field = "F84E95097BC99A84F1329F912DE1C04E")

    public static final int VALUE_SHIFTED = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "00364B6051AA02AB0E1991B3800FFDED", hash_generated_field = "8BAB6D0B6D8A0F099F78E047CCEE3DF6")

    public static final int VALUE_NON_IGNORABLE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "985029AB5351893C348DC854F3D4B8CA", hash_generated_field = "C6B0BFB4AAAB2A6CD12ADF3D4EA8A6E1")

    public static final int VALUE_LOWER_FIRST = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "9DB0F50007339188BE801E1BF2F6D939", hash_generated_field = "6FA71123BF881152210F318027ED3BEB")

    public static final int VALUE_UPPER_FIRST = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "531EDAD139C2DA6ACF092A6533B70026", hash_generated_field = "5FA947735009434015E742CF03FC8D8E")

    public static final int VALUE_ON_WITHOUT_HANGUL = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "93188EC13BF0AF41E42CC5D62F3FBD97", hash_generated_field = "538E4AEF9C246123086D9CA39530A548")

    public static final int VALUE_ATTRIBUTE_VALUE_COUNT = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "E2E1829157605EE0EBE6A22F5DCE8816", hash_generated_field = "DEFFCE9E44F682D0761520353DF13E7B")

    public static final int FRENCH_COLLATION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "B91E0E8D92DA6180D2123B3684A0100F", hash_generated_field = "7DC87AE12792F09754FF718C279C3385")

    public static final int ALTERNATE_HANDLING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "7D2A79822BB2FDD426B008D5C38033FB", hash_generated_field = "28C07F44F7059A82501618278B58B8D5")

    public static final int CASE_FIRST = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "503543A58737D88F4C9ED7C8703BCB14", hash_generated_field = "A4A4EC9E8D42866A14FC8CA95EABB87D")

    public static final int CASE_LEVEL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "3E576470337E6F2FF85C3AA4973E9944", hash_generated_field = "28E667FFBB3A82AE536655DC24CF3548")

    public static final int DECOMPOSITION_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:25.472 -0400", hash_original_field = "597A60A7C658089CF973223B64F18354", hash_generated_field = "F38C7B0615A9D421DB10E7EF2BE0DCEC")

    public static final int STRENGTH = 5;
}

