package libcore.icu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.CharacterIterator;
import java.text.CollationKey;
import java.text.ParseException;
import java.util.Locale;

public final class RuleBasedCollatorICU implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.659 -0500", hash_original_field = "FC10F1D5DB77A59DC74DAA5810C2B00D", hash_generated_field = "728743DB6612B436D24CE07F9E0E578D")

    public static final int VALUE_DEFAULT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.661 -0500", hash_original_field = "50CED95662D20B6C74A29A50A1807F0C", hash_generated_field = "9EF79B4A29645169497906E919B6FAF5")

    public static final int VALUE_PRIMARY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.664 -0500", hash_original_field = "EABDE2553E98A84BBF9222D101BA3C16", hash_generated_field = "583C62089B77C317428C9E462531A060")

    public static final int VALUE_SECONDARY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.666 -0500", hash_original_field = "BCC77A39657331F75F940512FA071FA6", hash_generated_field = "5F260A36972F0E701131299E0A43E7B2")

    public static final int VALUE_TERTIARY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.669 -0500", hash_original_field = "D86FAF6C19F4989A1816213F9C2E0F7D", hash_generated_field = "9A90704ECD935D223A8BB9CE1995F721")

    public static final int VALUE_DEFAULT_STRENGTH = VALUE_TERTIARY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.671 -0500", hash_original_field = "A9E64599199F4A2A628D4307983F9FC5", hash_generated_field = "7AFB3B26771CA61F5794ED5C9EDFC932")

    public static final int VALUE_QUATERNARY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.673 -0500", hash_original_field = "813938C17F05398AC377F4512BA189D6", hash_generated_field = "FCD93EE6B3FC2830DA4047B9636EBC49")

    public static final int VALUE_IDENTICAL = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.677 -0500", hash_original_field = "41FCCA29F26A00A7455280B749447D74", hash_generated_field = "29E1B5763DD6BF9165E050300F1FF599")

    public static final int VALUE_OFF = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.679 -0500", hash_original_field = "EDEE17549438D654E7D4702036FBAF01", hash_generated_field = "51F7ABEDC426272800189683F01E1D9C")

    public static final int VALUE_ON = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.682 -0500", hash_original_field = "3DC47E36F2F9C9A48421B770F8129251", hash_generated_field = "F84E95097BC99A84F1329F912DE1C04E")

    public static final int VALUE_SHIFTED = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.684 -0500", hash_original_field = "86E0AE2FA860D91402A19B0DE4013070", hash_generated_field = "8BAB6D0B6D8A0F099F78E047CCEE3DF6")

    public static final int VALUE_NON_IGNORABLE = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.686 -0500", hash_original_field = "7804B692A112E5C36518BA49919A40AA", hash_generated_field = "C6B0BFB4AAAB2A6CD12ADF3D4EA8A6E1")

    public static final int VALUE_LOWER_FIRST = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.689 -0500", hash_original_field = "BE47EF02AC47D5BCCB577C002F944D12", hash_generated_field = "6FA71123BF881152210F318027ED3BEB")

    public static final int VALUE_UPPER_FIRST = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.691 -0500", hash_original_field = "C503870675A546FD8D337F2EC24464AA", hash_generated_field = "5FA947735009434015E742CF03FC8D8E")

    public static final int VALUE_ON_WITHOUT_HANGUL = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.693 -0500", hash_original_field = "82CC471B973840E726FC2DFD43C64338", hash_generated_field = "538E4AEF9C246123086D9CA39530A548")

    public static final int VALUE_ATTRIBUTE_VALUE_COUNT = 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.696 -0500", hash_original_field = "6C45789F9AFFFD1ADA84DA22A689FD58", hash_generated_field = "DEFFCE9E44F682D0761520353DF13E7B")

    public static final int FRENCH_COLLATION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.699 -0500", hash_original_field = "13EE310B6E2440AF52C0CA217D83CBD1", hash_generated_field = "7DC87AE12792F09754FF718C279C3385")

    public static final int ALTERNATE_HANDLING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.701 -0500", hash_original_field = "CDEAB795F436EEBF05B386D3195CB3BB", hash_generated_field = "28C07F44F7059A82501618278B58B8D5")

    public static final int CASE_FIRST = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.704 -0500", hash_original_field = "A9D14E7E72B36BBA1D8E8C79064FB0F3", hash_generated_field = "A4A4EC9E8D42866A14FC8CA95EABB87D")

    public static final int CASE_LEVEL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.706 -0500", hash_original_field = "D2C1FE6893D944076B35A5F3CE9C4373", hash_generated_field = "28E667FFBB3A82AE536655DC24CF3548")

    public static final int DECOMPOSITION_MODE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.709 -0500", hash_original_field = "5E35AF16174A879AD6D323E0718DA144", hash_generated_field = "F38C7B0615A9D421DB10E7EF2BE0DCEC")

    public static final int STRENGTH = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.711 -0500", hash_original_field = "0EFD4B56D5F68F850B84173C34758709", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.713 -0500", hash_original_method = "2EB56AAF7E8D69BAE596BFC26154D628", hash_generated_method = "92945CFB4FDFAEC3B1C0F7C8A0D0CE46")
    
public RuleBasedCollatorICU(String rules) throws ParseException {
        if (rules == null) {
            throw new NullPointerException();
        }
        address = NativeCollation.openCollatorFromRules(rules, VALUE_OFF, VALUE_DEFAULT_STRENGTH);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.716 -0500", hash_original_method = "A5C323A76C17F2A5DAD617321306AD0B", hash_generated_method = "99CF1C0871DAD2DD8B651AB66C8E45F1")
    
public RuleBasedCollatorICU(Locale locale) {
        address = NativeCollation.openCollator(locale.toString());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.719 -0500", hash_original_method = "A318B723665122F54B169082CADE3CC3", hash_generated_method = "67B0EF4F1D077AE3F338CDBE19294FDB")
    
private RuleBasedCollatorICU(int address) {
        this.address = address;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.722 -0500", hash_original_method = "2DC05452E0FCF4981A0124341AE4FC53", hash_generated_method = "D9DCDE634B9DD7E1EDC00D47B8BCB5C5")
    
public Object clone() {
        return new RuleBasedCollatorICU(NativeCollation.safeClone(address));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.724 -0500", hash_original_method = "49991F8A57E565642E1A41A931B1C001", hash_generated_method = "930D74DEB37A2A4B28BCE8B8BDABE1A2")
    
public int compare(String source, String target) {
        return NativeCollation.compare(address, source, target);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.726 -0500", hash_original_method = "239D987CE6D9B4CADAB8F872E8E9D57B", hash_generated_method = "FD6120F6D1F0485715C59D82F0F61F12")
    
public int getDecomposition() {
        return NativeCollation.getAttribute(address, DECOMPOSITION_MODE);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.728 -0500", hash_original_method = "44F9BFBEB06030096990BB2E8C89DED9", hash_generated_method = "E22C8178512FBFC4504685CCC2EF34FE")
    
public void setDecomposition(int mode) {
        NativeCollation.setAttribute(address, DECOMPOSITION_MODE, mode);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.730 -0500", hash_original_method = "AAB074F82BF97FFE28F8563C1D57A964", hash_generated_method = "682FCE185179B1C52F53794CDF3B7EDE")
    
public int getStrength() {
        return NativeCollation.getAttribute(address, STRENGTH);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.732 -0500", hash_original_method = "B780FC0CB29AFE09B6EA92E53FEFCCC0", hash_generated_method = "F52C3CEEC67196E29042FC398EA590D2")
    
public void setStrength(int strength) {
        NativeCollation.setAttribute(address, STRENGTH, strength);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.735 -0500", hash_original_method = "EE4A6867E88BF501B4AF7B7DE8C48A39", hash_generated_method = "D6B769959F9ECB8E45A318DE808C190C")
    
public void setAttribute(int type, int value) {
        NativeCollation.setAttribute(address, type, value);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.737 -0500", hash_original_method = "7E0368EE82E5C263E0341D3245A9B850", hash_generated_method = "136D6DDD8249625AC97968750C7B236F")
    
public int getAttribute(int type) {
        return NativeCollation.getAttribute(address, type);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.739 -0500", hash_original_method = "AD47FDA34CF9DDAC21CE9DA304C498D4", hash_generated_method = "D6E50BFC747F336A3CA33C966987ED84")
    
public CollationKey getCollationKey(String source) {
        if (source == null) {
            return null;
        }
        byte[] key = NativeCollation.getSortKey(address, source);
        if (key == null) {
            return null;
        }
        return new CollationKeyICU(source, key);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.742 -0500", hash_original_method = "FFB9880C0352BAA3924C6058A715E6CF", hash_generated_method = "5AACC7E39C63C584E4FB9DC215A15AA9")
    
public String getRules() {
        return NativeCollation.getRules(address);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.744 -0500", hash_original_method = "37423170550704AB69E3E5DFF5BA23DD", hash_generated_method = "CF926B0A19EC0DBECABE4CF41D879102")
    
public CollationElementIteratorICU getCollationElementIterator(String source) {
        return CollationElementIteratorICU.getInstance(address, source);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.746 -0500", hash_original_method = "C7D7D5ADEA090F255D72693DB837681B", hash_generated_method = "F26B96F6F94104BAEA13A0FB8B6E8075")
    
public CollationElementIteratorICU getCollationElementIterator(CharacterIterator it) {
        // We only implement the String-based API, so build a string from the iterator.
        return getCollationElementIterator(characterIteratorToString(it));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.748 -0500", hash_original_method = "7AE77B5FB071109A54141F0830318144", hash_generated_method = "5301BC205552665A10E5E04B8EEB45CB")
    
private String characterIteratorToString(CharacterIterator it) {
        StringBuilder result = new StringBuilder();
        for (char ch = it.current(); ch != CharacterIterator.DONE; ch = it.next()) {
            result.append(ch);
        }
        return result.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.751 -0500", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "4CAD1CB01D670A92D6EFB90260D990B3")
    
@Override public int hashCode() {
        return 42; // No-one uses RuleBasedCollatorICU as a hash key.
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.753 -0500", hash_original_method = "33726095AFF4CCE7845E5A8AF95C560E", hash_generated_method = "B2129DDB57F0B982A725D4AB1A49846D")
    
public boolean equals(String source, String target) {
        return (compare(source, target) == 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.756 -0500", hash_original_method = "7C2D1C08D1C2665AA117147559E8D29C", hash_generated_method = "865FC86F46E7AE571A0A0FA9A5D2D28A")
    
@Override public boolean equals(Object object) {
        if (object ==  this) {
            return true;
        }
        if (!(object instanceof RuleBasedCollatorICU)) {
            return false;
        }
        RuleBasedCollatorICU rhs = (RuleBasedCollatorICU) object;
        return getRules().equals(rhs.getRules()) &&
                getStrength() == rhs.getStrength() &&
                getDecomposition() == rhs.getDecomposition();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.758 -0500", hash_original_method = "4A24C365D6C63EAE3926032A3798E7DF", hash_generated_method = "1A5F84BC6C3B184C98C9FC9E49337644")
    
@Override protected void finalize() throws Throwable {
        try {
            NativeCollation.closeCollator(address);
        } finally {
            super.finalize();
        }
    }
}

